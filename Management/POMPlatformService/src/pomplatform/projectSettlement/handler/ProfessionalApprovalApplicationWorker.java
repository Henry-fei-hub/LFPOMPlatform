package pomplatform.projectSettlement.handler;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;
import delicacy.common.*;
import delicacy.connection.ThreadConnection;
import delicacy.servlet.AbstractProcessores;
import delicacy.servlet.HttpCookie;
import delicacy.system.bean.*;
import delicacy.system.executor.SystemProcessConstants;
import message.common.ERPWeixinUtils;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import delicacy.system.executor.ProcessUtil;
import pomplatform.common.utils.StaticUtils;
import pomplatform.report.bean.BaseSystemProcessInstanceActivities;
import pomplatform.report.bean.ConditionSystemProcessInstanceActivities;
import pomplatform.report.query.QuerySystemProcessInstanceActivities;

public class ProfessionalApprovalApplicationWorker implements GenericWorkflowProcessor {

	private static final Logger __logger = Logger.getLogger(ProfessionalApprovalApplicationWorker.class);

	protected BaseProfessionalApproval bean = new BaseProfessionalApproval();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		/*if (true) {
			throw new SQLException("流程未编写完成");
		}*/

		int operator = BaseHelpUtils.getIntValue(params.get("operator"));
		String projectCode = BaseHelpUtils.getStringValue(params, "projectCode");
		int projectManageId = BaseHelpUtils.getIntValue(params, "projectManageId");

		Employee eDao =new Employee();
		eDao.setConditionEmployeeId("=", operator);
		eDao.setEmployeeId(operator);
		if(!eDao.load()) {
			throw new SQLException("错误！ 发起人信息获取失败");
		}

		BaseProject bp = new BaseProject();
		bp.setDataFromMap(params);
		Project daoPro = new Project();
		daoPro.setPrimaryKeyFromBase(bp);
		if (!daoPro.load()) {
			throw new SQLException("错误！ 项目信息获取失败!");
		}

		//更换项目经理
		ColumnChangedData ccd = daoPro.getColumnChangedData(BaseProject.CS_PROJECT_MANAGE_ID);

		if (ccd != null) {
			ProjectEmployee pe = new ProjectEmployee();
			if (ccd.getOriginal() != null) {
				//检索当原专业负责人在该项目上已经有了确认积分记录，则不做删除
				int org_employeeId = BaseHelpUtils.getIntValue(ccd.getOriginal());
				ProjectSettlementDetail settDao = new ProjectSettlementDetail();
				settDao.setConditionProjectId("=", daoPro.getProjectId());
				settDao.setConditionEmployeeId("=",org_employeeId);
				if(settDao.countRows() <= 0){
					pe.setConditionProjectId("=", daoPro.getProjectId());
					pe.setConditionEmployeeId("=", org_employeeId);
					pe.conditionalDelete();
				}
			}
			if (daoPro.getProjectManageId() != null&&daoPro.getProjectManageId() != 0) {
				pe.setProjectId(daoPro.getProjectId());
				pe.setEmployeeId(BaseHelpUtils.getIntValue(projectManageId));
				pe.setPlanStartDate(daoPro.getPlanStartDate());
				pe.setPlanEndDate(daoPro.getPlanEndDate());
				pe.setStatus(2);
				pe.setAlternateField2("2");//设置默认值为2，表示已完成。
				pe.save();
			}
		}

		ERPWeixinUtils.sendTextMsgToUser(eDao.getCompanyWeixin(), "更改订单编号("+projectCode+")的专业负责人记录待审批,请尽快处理");

		bean.setDataFromMap(params);
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setDataFromBase(bean);

		dao.setEmployeeId(eDao.getEmployeeId());
		dao.setEmployeeNo(eDao.getEmployeeNo());
		dao.setContractId(daoPro.getContractId());
		dao.setStatus(StaticUtils.PROJECT_TRANSITIONS_STAUTS_1);//流程记录

		Employee pmDao =new Employee();
		pmDao.setEmployeeId(projectManageId);
		if(pmDao.load()) {
			dao.setProjectManageDepartmentId(pmDao.getDepartmentId());
			dao.setProjectManageName(pmDao.getEmployeeName());
		}else{
			throw new SQLException("错误！ 专业负责人信息获取失败");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getProjectManageId())){
			dao.setProjectManageName(null);
		}
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getProfessionalApproval_id(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		System.out.println("================================================= employeeId: " + employeeId);
		Project proDao =new Project();
		proDao.setProjectId( bean.getProjectId());
		BigDecimal newPercentage = BaseHelpUtils.getBigDecimalValue(params.get("percentage"));
		int newProjectManageId = BaseHelpUtils.getIntValue(params.get("projectManageId"));

		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){//同意,并且吧其他的数据删除掉
				//bean.setDeleteFlag(1);

				if (proDao.load()) {
					BigDecimal totalIntegral = proDao.getTotalIntegral();
					BigDecimal percentage =newPercentage.multiply(new BigDecimal(0.01)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
					//预留积分
					BigDecimal reserveIntegral = totalIntegral.multiply(percentage).setScale(2, BigDecimal.ROUND_HALF_DOWN);
					//项目积分
					BigDecimal projectIntegral = totalIntegral.subtract(reserveIntegral);

					proDao.setReserveIntegral(reserveIntegral);
					proDao.setProjectIntegral(projectIntegral);
					proDao.setProjectManageId(newProjectManageId);
					proDao.setPercentage(newPercentage);
					int oldProjectManageId = BaseHelpUtils.getIntValue(proDao.getProjectManageId());
					if ( oldProjectManageId!=newProjectManageId) {
						ProjectEmployee pe = new ProjectEmployee();
						//检索当原专业负责人在该项目上已经有了确认积分记录，则不做删除
						if (oldProjectManageId>0) {
							ProjectSettlementDetail settDao = new ProjectSettlementDetail();
							settDao.setConditionProjectId("=", proDao.getProjectId());
							settDao.setConditionEmployeeId("=",oldProjectManageId);
							if(settDao.countRows() <= 0){
								pe.setConditionProjectId("=", proDao.getProjectId());
								pe.setConditionEmployeeId("=", oldProjectManageId);
								pe.conditionalDelete();
							}
						}
						if (newProjectManageId>0) {
							pe.clear();
							pe.setConditionProjectId("=", proDao.getProjectId());
							pe.setConditionEmployeeId("=",newProjectManageId);
							List<BaseProjectEmployee> conditionalLoad = pe.conditionalLoad();
							if(conditionalLoad.size()>0) {
								BaseProjectEmployee baseProjectEmployee = conditionalLoad.get(0);
							} else {
								pe.setProjectId(proDao.getProjectId());
								pe.setEmployeeId(newProjectManageId);
								pe.setPlanStartDate(proDao.getPlanStartDate());
								pe.setPlanEndDate(proDao.getPlanEndDate());
								pe.setStatus(2);
								pe.setAlternateField2("2");// 设置默认值为2，表示已完成。
								pe.save();
							}
						}
					}
				}else{
					throw new SQLException("项目记录获取失败");
				}

				//更换项目经理
				proDao.update();
			}else if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){
				//bean.setDeleteFlag(1);
			}
		}

		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {
				return null;
			}

            // 获取客户化业务流程处理的程序-根据每个流程执行程序的名字,从系统的任务分发表
            // 从数据库中装载流程定义信息
            SystemProcessDefinition processDefinition = ProcessUtil.loadProcess(pi.getProcessDefinition().getProcessId());
            String executeClassName = AbstractProcessores.getWorkflowProcessorClass(processDefinition.getProcessType().getProcessExecuteName());
            if (executeClassName == null) {
                throw new SQLException("process execute class not found");
            }
            // 实例化客户流程处理程序
            GenericWorkflowProcessor gwp = (GenericWorkflowProcessor) Class.forName(executeClassName).newInstance();
            // 查找下一个流程节点,先找到流程的第一个节点
            BaseSystemProcessActivity firstActivity = ProcessUtil.firstActivity(processDefinition);
            // 查找下一个流程节点
            BaseSystemProcessActivity nextActivity = ProcessUtil.findNextActivity(processDefinition, gwp, firstActivity);
            // 看看是否下一个流程节点是结束节点,如果是结束节点,即将流程结束
            if (nextActivity.getActivitySerialNo() != SystemProcessConstants.PROCESS_LAST_ACTIVITY) {
				BaseCollection<BaseSystemProcessInstanceActivities> bc = new BaseCollection<>();
				ConditionSystemProcessInstanceActivities cpa = new ConditionSystemProcessInstanceActivities();
				cpa.setProcessType(pi.getProcessInstance().getProcessType());
				cpa.setBusinessId(pi.getProcessInstance().getBusinessId());
				cpa.setProcessInstanceId(pi.getProcessInstance().getProcessInstanceId());
				QuerySystemProcessInstanceActivities query = new QuerySystemProcessInstanceActivities();
				bc = query.executeQuery(null, cpa);
				List<BaseSystemProcessInstanceActivities> bcCollections = bc.getCollections();
				if (bcCollections != null && bcCollections.size() != 0) {
					BaseSystemProcessInstanceActivities bpia =new BaseSystemProcessInstanceActivities();
                    Map sendMessage = new HashMap();
                    for(int i = 0; i < bcCollections.size(); i++) {
						if(!sendMessage.containsKey(bcCollections.get(i).getEmployeeId())&&!BaseHelpUtils.isNullOrEmpty(bcCollections.get(i).getCompanyWeixin())){
							ERPWeixinUtils.sendTextMsgToUser(bcCollections.get(i).getCompanyWeixin(), "更改订单编号("+bean.getProjectCode()+")的专业负责人记录待审批,请尽快处理");
							__logger.info("向员工ID为:"+bcCollections.get(i).getEmployeeId()+"的企业微信号:"+bcCollections.get(i).getCompanyWeixin()+"推送专业负责人记录待审批信息，推送内容为【"+bcCollections.get(i).getCompanyWeixin()+"更改订单编号("+bean.getProjectCode()+")的专业负责人记录待审批,请尽快处理"+"】");
						}
						sendMessage.put(bcCollections.get(i).getEmployeeId(),bcCollections.get(i).getEmployeeId());
                    }
                }
            }
		}
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getProfessionalApproval_id(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		Employee pmDao =new Employee();
		Map sendMessage = new HashMap();
		if(null != roleId){
			if(roleId.equals(StaticUtils.ROLE_MAIN_PROJECT_PERSON_IN_CHARGE)) {
				MainProject mDao =new MainProject();
				mDao.setConditionProjectCode("=", bean.getProjectCode());
				BaseMainProject baseMainProject = mDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(baseMainProject)) {
					MainProjectEmployee mpeDao =new MainProjectEmployee();
					mpeDao.setConditionMainProjectId("=", baseMainProject.getMainProjectId());
					mpeDao.setConditionRelation("=", 5);
					List<BaseMainProjectEmployee> conditionalLoad = mpeDao.conditionalLoad();
					if(conditionalLoad.size()<=0) {
						throw new SQLException("错误！未设定项目负责人");
					}else {
						int size = conditionalLoad.size();
						int[] arr = new int[size];
						for(int i = 0; i < size; i++) {
							arr[i] = conditionalLoad.get(i).getEmployeeId();
							pmDao.clear();
							pmDao.setEmployeeId(arr[i]);
							if(pmDao.load()) {
								if(!sendMessage.containsKey(pmDao.getEmployeeId())&&!BaseHelpUtils.isNullOrEmpty(pmDao.getCompanyWeixin())){
									ERPWeixinUtils.sendTextMsgToUser(pmDao.getCompanyWeixin(), "更改订单编号("+bean.getProjectCode()+")的专业负责人记录待审批,请尽快处理");
									__logger.info("向员工(项目负责人)ID为:"+pmDao.getEmployeeId()+"的企业微信号:"+pmDao.getCompanyWeixin()+"推送专业负责人记录待审批信息，推送内容为【"+pmDao.getCompanyWeixin()+"更改订单编号("+bean.getProjectCode()+")的专业负责人记录待审批,请尽快处理"+"】");
								}
								sendMessage.put(pmDao.getEmployeeId(),pmDao.getEmployeeId());
							}else{
								throw new SQLException("错误！ 下个节点审批信息获取失败");
							}
						}
						return arr;
					}
				}else {
					throw new SQLException("错误！ 立项信息获取失败");
				}
			}
		}
        //__logger.info("processCreator："+processCreator+"-employeeId:"+employeeId+"-departmentId"+departmentId+"-roleId"+roleId);
		int[] nextOwner = ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		/*for(int i = 0; nextOwner!=null&&i < nextOwner.length; i++) {
			pmDao.clear();
			pmDao.setEmployeeId(nextOwner[i]);
			if(pmDao.load()) {
				if(!sendMessage.containsKey(pmDao.getEmployeeId())&&!BaseHelpUtils.isNullOrEmpty(pmDao.getCompanyWeixin())){
					ERPWeixinUtils.sendTextMsgToUser(pmDao.getCompanyWeixin(), "更改订单编号("+bean.getProjectCode()+")的专业负责人记录待审批,请尽快处理");
					__logger.info("向员工ID为:"+pmDao.getEmployeeId()+"的企业微信号:"+pmDao.getCompanyWeixin()+"推送专业负责人记录待审批信息，推送内容为【"+pmDao.getCompanyWeixin()+"更改订单编号("+bean.getProjectCode()+")的专业负责人记录待审批,请尽快处理"+"】");
				}
				sendMessage.put(pmDao.getEmployeeId(),pmDao.getEmployeeId());
			}else{
				throw new SQLException("错误！ 下个节点审批人信息获取失败");
			}
		}*/
		return nextOwner;
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setProfessionalApproval_id(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

}
