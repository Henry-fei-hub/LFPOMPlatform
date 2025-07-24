package pomplatform.workflow.personnelbusiness.handler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.SalaryAnnualBonus;
import com.pomplatform.db.dao.SalaryOfBonus;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.payment.business.OnPaymentManageProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.dao.PersonnelBusinesWithP;

public class PayrollApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	/**
	 * 工资发放
	 */
	private final static int TYPE_ONE = 1;

	/**
	 * 项目奖金
	 */
	private final static int TYPE_TWO = 2;

	/**
	 * 年终奖金 
	 */
	private final static int TYPE_THREE = 3;

	/**
	 * 待发放
	 */
	private final static int FLOW_STATUS_ZERO = 0; 

	/**
	 * 发放中
	 */
	private final static int FLOW_STATUS_ONE = 1;

	/**
	 * 发放完成
	 */
	private final static int FLOW_STATUS_TWO = 2;

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		int processType = pd.getProcessTypeId();
		bean.setProcessType(processType);
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		bean.setPersonnelBusinessId(dao.getPersonnelBusinessId());
		if(bean.getType() == TYPE_THREE){//年终奖发放时 需要将发放数据关联
			SalaryAnnualBonus sabDao = new SalaryAnnualBonus();
			sabDao.setConditionYear("=", bean.getCompanyProvince());
			sabDao.setConditionPersonnelBusinessId("=", 0);
			sabDao.setConditionFlowStatus("=", FLOW_STATUS_ZERO);
			sabDao.setPersonnelBusinessId(dao.getPersonnelBusinessId());
			sabDao.setFlowStatus(FLOW_STATUS_ONE);
			sabDao.setSendTime(new Date());
			sabDao.conditionalUpdate();
		}
		if (bean.getType() == TYPE_TWO) {//项目奖金发放时需要将发放数据关联
			SalaryOfBonus salaryOfBonus = new SalaryOfBonus();
			salaryOfBonus.setConditionYear("=", bean.getCompanyProvince());
			salaryOfBonus.setConditionMonth("=", bean.getTargetProvince());
			salaryOfBonus.setConditionPersonnelBusinessId("=", 0);
			salaryOfBonus.setConditionFlowStatus("=", FLOW_STATUS_ZERO);
			salaryOfBonus.setPersonnelBusinessId(dao.getPersonnelBusinessId());
			salaryOfBonus.setFlowStatus(FLOW_STATUS_ONE);
			salaryOfBonus.setSendTime(new Date());
			salaryOfBonus.conditionalUpdate();
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getAttachmentId());
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
		bean.setDataFromMap(params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}

			//获取当前审批节点
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			//获取当前节点类型
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			//只有处理节点才可以更改数据
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
				return null;
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		//修改附件的引用次数
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BasePersonnelBusines.CS_ATTACHMENT_ID);
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		//修改(武汉、大连)发放凭证的引用次数
		ColumnChangedData projectTypeData = dao.getColumnChangedData(BasePersonnelBusines.CS_PROJECT_TYPE);
		FileManageProcessor.upadteTimesByColumnChangedData(projectTypeData);
		//修改(上海)发放凭证的引用次数
		ColumnChangedData dutyIdData = dao.getColumnChangedData(BasePersonnelBusines.CS_DUTY_ID);
		FileManageProcessor.upadteTimesByColumnChangedData(dutyIdData);
		//修改(北京)发放凭证的引用次数
		ColumnChangedData startDateDetailData = dao.getColumnChangedData(BasePersonnelBusines.CS_START_DATE_DETAIL);
		FileManageProcessor.upadteTimesByColumnChangedData(startDateDetailData);
		//修改(深圳)发放凭证的引用次数
		ColumnChangedData endDateDetailData = dao.getColumnChangedData(BasePersonnelBusines.CS_END_DATE_DETAIL);
		FileManageProcessor.upadteTimesByColumnChangedData(endDateDetailData);
		if (completed) {
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				if(bean.getType() == TYPE_ONE){
					OnPaymentManageProcess pm = new OnPaymentManageProcess();
					pm.commonSalaryTotalPush(dao.getCompanyProvince(), dao.getTargetProvince(), 2);
					pm.commonSalaryTotalPush(dao.getCompanyProvince(), dao.getTargetProvince(), 3);
				}else if(bean.getType() == TYPE_THREE){
					SalaryAnnualBonus sabDao = new SalaryAnnualBonus();
					sabDao.setConditionYear("=", bean.getCompanyProvince());
					sabDao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
					sabDao.setConditionFlowStatus("=", FLOW_STATUS_ONE);
					sabDao.setFlowStatus(FLOW_STATUS_TWO);
					sabDao.setFinishTime(new Date());
					sabDao.conditionalUpdate();
				}else if (bean.getType() == TYPE_TWO) {//项目奖金发放
					SalaryOfBonus salaryOfBonusDao = new SalaryOfBonus();
					salaryOfBonusDao.setConditionYear("=", bean.getCompanyProvince());
					salaryOfBonusDao.setConditionMonth("=", bean.getTargetProvince());
					salaryOfBonusDao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
					salaryOfBonusDao.setConditionFlowStatus("=", FLOW_STATUS_ONE);
					salaryOfBonusDao.setFlowStatus(FLOW_STATUS_TWO);
					salaryOfBonusDao.setEndTime(new Date());
					salaryOfBonusDao.conditionalUpdate();
				}
				dao.setIsCompleted(true);
			}else if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){
				if(bean.getType() == TYPE_THREE){
					SalaryAnnualBonus sabDao = new SalaryAnnualBonus();
					sabDao.setConditionYear("=", bean.getCompanyProvince());
					sabDao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
					sabDao.setConditionFlowStatus("=", FLOW_STATUS_ZERO);
					sabDao.setPersonnelBusinessId(0);
					sabDao.setSendTime(null);
					sabDao.setFlowStatus(FLOW_STATUS_ZERO);
					sabDao.conditionalUpdate();
				}
				if (bean.getType() == TYPE_TWO) {//项目奖金的发放
					System.out.println("+++++++++++++++++++++++"+bean.getPersonnelBusinessId());
					SalaryOfBonus salaryOfBonusDao = new SalaryOfBonus();
					salaryOfBonusDao.setConditionYear("=", bean.getCompanyProvince());
					salaryOfBonusDao.setConditionMonth("=", bean.getTargetProvince());
					salaryOfBonusDao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
					salaryOfBonusDao.setConditionFlowStatus("=", FLOW_STATUS_ONE);
					salaryOfBonusDao.setPersonnelBusinessId(0);
					salaryOfBonusDao.setSendTime(null);
					salaryOfBonusDao.setFlowStatus(FLOW_STATUS_ZERO);
					salaryOfBonusDao.conditionalUpdate();
				}
			}
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e =OnWrokflowProcess.setExpression(expression, e, employeeId, bean.getFee(), null, null);
		e.setValue("天数", bean.getDays() == null ? 0.0 : bean.getDays().doubleValue());
		if(null != expression && expression.contains("发放类型")){
			if(null != bean.getType()){
				if(bean.getType() == TYPE_ONE){//薪资
					e.setValue("发放类型", "薪资");
				}else if(bean.getType() == TYPE_TWO){//项目奖金
					e.setValue("发放类型", "项目奖金");
				}else if(bean.getType() == TYPE_THREE){//年终奖金
					e.setValue("发放类型", "年终奖金");
				}
			}
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if(null != roleId && roleId > 0){
			if(roleId == StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER || roleId == StaticUtils.ROLE_HUMAN_RESOURCE_CASHIER){//部门分管领导 或 财务出纳(人资)
				String sql = "";
				int year = bean.getCompanyProvince();
				int month = bean.getTargetProvince();
				if(null != bean.getType()){
					if(roleId == StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER){
						if(bean.getType() == TYPE_ONE){
							sql = " department_id in (select department_id from salary_totals where year= "+ year
									+" and month = " + month + ") ";
						}else if(bean.getType() == TYPE_TWO){
							sql = " department_id in (select department_id from salary_of_bonus where flag in (2, 3) and year= "+ year
									+" and month = " + month + " and personnel_business_id = "+bean.getPersonnelBusinessId()+") ";
						}else if(bean.getType() == TYPE_THREE){
							sql = " department_id in (SELECT department_id FROM salary_annual_bonus WHERE personnel_business_id = " + bean.getPersonnelBusinessId() 
							+ " AND year = "+ year + ") ";
						}
					}else{//出纳先查询出该次奖金或年终奖所包含的归属公司出纳
						if(bean.getType() == TYPE_TWO){
							sql = " employee_id in ( SELECT employee_id FROM cashier_companys WHERE company_id in (select company_id from salary_of_bonus where flag in (2, 3) and year= "+ year
									+" and month = " + month + " and personnel_business_id= "+bean.getPersonnelBusinessId() +" ) )";
						}else if(bean.getType() == TYPE_THREE){
							sql = " employee_id in ( SELECT employee_id FROM cashier_companys WHERE company_id in (SELECT company_id FROM salary_annual_bonus WHERE personnel_business_id = " 
									+ bean.getPersonnelBusinessId()+ " AND year = " + year + ") )";
						}
					}
				}
				if(!BaseHelpUtils.isNullOrEmpty(sql)){
					sql = " employee_id in (SELECT employee_id FROM employee_roles where role_id = " + roleId + " and " + sql + ")"; 
				}else{
					sql = " employee_id in (SELECT employee_id FROM employee_roles where role_id = " + roleId + ")"; 
				}
				Employee dao = new Employee();
				dao.setConditionStatus("=", 0);
				List<BaseEmployee> eList = dao.conditionalLoad(sql);
				int [] eIdArr = new int[eList.size()];
				for (int i = 0; i < eList.size(); i++) {
					eIdArr[i] = eList.get(i).getEmployeeId();
				}
				return eIdArr;
			}
		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getAttachmentId()));
		dao.setReason(FileManageProcessor.getFileUrlById(dao.getProjectType()));
		dao.setAddress(FileManageProcessor.getFileUrlById(dao.getDutyId()));
		dao.setPlan(FileManageProcessor.getFileUrlById(dao.getStartDateDetail()));
		dao.setTransportation(FileManageProcessor.getFileUrlById(dao.getEndDateDetail()));
		return dao.generateBaseExt().toJSON();
	}
}
