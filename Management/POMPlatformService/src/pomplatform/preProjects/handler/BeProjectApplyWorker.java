package pomplatform.preProjects.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractsRecords;
import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.bean.BaseCwdFileVersion;
import com.pomplatform.db.bean.BaseCwdFilingManage;
import com.pomplatform.db.bean.BaseCwdFilingManageDetail;
import com.pomplatform.db.bean.BaseCwdFilingTemplate;
import com.pomplatform.db.bean.BaseCwdFilingTemplateDetail;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BaseMainProjectStage;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.BusinessCategory;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractLog;
import com.pomplatform.db.dao.ContractsRecords;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.CwdFile;
import com.pomplatform.db.dao.CwdFileVersion;
import com.pomplatform.db.dao.CwdFilingManage;
import com.pomplatform.db.dao.CwdFilingManageDetail;
import com.pomplatform.db.dao.CwdFilingTemplate;
import com.pomplatform.db.dao.CwdFilingTemplateDetail;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.MainProjectCompetitionUnit;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.MainProjectSpecialty;
import com.pomplatform.db.dao.MainProjectStage;
import com.pomplatform.db.dao.PmSpecial;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.PreProjectRecord;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericBase;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.date.util.DateUtil;
import delicacy.expression.Expression;
import delicacy.system.bean.BaseDepartment;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Department;
import delicacy.system.dao.EmployeeRole;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.common.business.OnCommonProcess;
import pomplatform.common.utils.AccountUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.preProjects.bean.BasePreProjectWithMmm;
import pomplatform.preProjects.business.PreProjectProcess;
import pomplatform.preProjects.dao.PreProjectWithMmm;
import pomplatform.workflow.business.OnWrokflowProcess;

public class BeProjectApplyWorker implements GenericWorkflowProcessor {

	protected BasePreProjectWithMmm bean = new BasePreProjectWithMmm();
	protected BaseMainProject pbean = new BaseMainProject();
	private PreProjectProcess p = new PreProjectProcess();

	/*
	 * 运营流程逻辑重点(项目报备--项目立项--报价单--订单下达)
	 *
	 * a.项目报备
	 * 1.区分开项目报备的数据和项目立项的数据
	 * 2.p.savaDataForBeProject(params); 用作于保存或更新pre_projects的数据，
	 * 	 salePersonReocrd，saleLeaderReocrd，projectManageReocrd，projectLeaderReocrd，projectResponsibleRecord，businessTypeReocrd，specialtyReocrd，competitionUnitRecord，detailProjectStage的数据以preProjectId为关联id更新
	 * 3.p.savaDataForMainProject(params); 用作于保存main_projects的数据
	 * 	 salePersonReocrd，saleLeaderReocrd，projectManageReocrd，projectLeaderReocrd，projectResponsibleRecord，businessTypeReocrd，specialtyReocrd，competitionUnitRecord，detailProjectStage的数据再重新保存一次，并且以mainProjectId为关联id
	 *   main_projects的process_status字段用于区分流程状态 0无意义  1进行中  2已完成  3已驳回
	 * ps:上述子表数据均保存两次，分别以preProjectId和mainProjectId,主要目的是为了一个报备（pre_projects），能有多个项目立项（main_projects）,用以区分数据不混，项目立项后用main_pojects作为主表做后续的数据关联
	 * 4.报备人默认设置为项目秘书（main_project_employee relation=1）
	 *
	 *
	 * b.项目立项
	 * 4.info_code在项目报备时生成,若存在 pre_projects,main_projects,contracts,out_quotations,out_design_considerations则均为一致
	 * 5.project_code则在项目立项时根据 mainProjectStageId 和isModifyProject生成,pre_project中不存在, main_projects,contracts,out_quotations,out_design_considerations则均为一致，在后续的代码逻辑中，主要用project_code来关联项目立项的数据和合同数据
	 * 6.报价单提交以及报价单功能：利用 project_code 和 Out_Quotation_Id 来关联数据。
	 *   因为会有多条main_projects的数据以及报价单的历史数据，因此在报价单相关的功能同样是使用project_code来区分，  并且报价单的合同报价单(out_design_considerations)和产值单(main_project_business_types = businessTypeReocrd )则使用Out_Quotation_Id,project_code来区分数据 ，默认情况下
	 *   main_project_business_types的Out_Quotation_Id等于0 来表示该数据是项目立项的数据， 报价单后续的操作（CRUD）main_project_business_types 都要带上out_quotation_id ，并且流程结束后应该同步反向更新立项数据
	 *	 报价单流程过程中：main_project_business_types 的status字段转为1
	 *	 报价单流程完成后：main_project_business_types 的status字段转为2
	 *	 报价单流程驳回后：main_project_business_types 的status字段转为0
	 *
	 *	报价单流程完成后，要把project_stages的contract_id 和 project_amount（= 产值 * 占比） 更新
	 *
	 * 7.订单下达
	 * 	  项目信息(原拆分价列表) 汇总main_project_business_types 的status为2的成一条数据 ，并且创建子订单提交子订单需要把数据全部下完，占比100% ; main_project_business_types 的status为3 表示全部已经拆分完毕
	 *
	 * 8.项目经理管理项目 -- 可分配阶段确认
	 * 		project_stages 增加了status字段   ( 0 无意义  , 1 未分配阶段确认  ,2 已完成进行可分配阶段确认 , 3 流程进行中  )
	 *   	新建流程页面：以contracts为主表关联project_stages查询出可以进行可分配阶段确认的合同
	 *   	流程完成把勾选的阶段的status更新为2
	 *   	流程驳回把勾选的阶段的status更新为1
	 *
	 * 9.部门经理设置专业负责人和部门预留
	 *   修改项目: 生成一条 project_transition 的记录表数据，根据 is_or_not 字段来判断是否需要审批然后设置status（状态   0 操作记录 ，1 待审批   2 已驳回   3 已完成 ）
	 *   审批页面：查询project_transition的status为1的数据让方案主创去审批，同意则吧status更新成3  驳回更新成2
	 *   ps:专业负责人暂时不会更新到project_employees表中，只更新projects的project_manage_id的值
	 *
	 * 10.专业负责人--团队组建流程
	 *   新建:以project_id 和 business_id 保存project_employees 的数据
	 *   更新:同意:把本次流程的project_employees的数据的status更新成2 ，其余的同一个project_id下的project_employees的数据的status更新成0
	 *   	   驳回:把本次流程的project_employees的数据的status更新成1,其余的同一个project_id下的project_employees的数据的status不更新
	 *
	 * 11.专业负责人--经费结算
	 *    获取 project_stages中状态值为2的阶段获取出来以及相对应的占比
	 *
	 *
	 *
	 *
	 *
	 * */

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		// 如果在项目信息这边修改客户
		pbean.setDataFromMap(params);
		if (BaseHelpUtils.getIntValue(params.get("clientId"))>0) {
			Customer customer = new Customer();
			customer.setConditionCustomerId("=",BaseHelpUtils.getIntValue(params.get("clientId")));
			customer.setCustomerId(BaseHelpUtils.getIntValue(params.get("clientId")));
			if(customer.load()) {
				pbean.setCustomerName(customer.getCustomerName());
				pbean.setClientId(BaseHelpUtils.getIntValue(params.get("clientId")));
			}else {
				throw new SQLException("该客户不存在,请先到客户管理新增。");
			}
		}else {
			throw new SQLException("请选择正确的客户");
		}

		// 保持main_projects表
		Date currentDate = new Date();
		MainProject pdao = new MainProject();
//		pbean.setDataFromMap(params);
		// 信息编号
		String infoCode = BaseHelpUtils.getString(pbean.getInfoCode());
		// 立项项目阶段
		int mainStageId = BaseHelpUtils.getIntValue(pbean.getMainProjectStageId());
		// 是否修改项目
		Boolean isModifyProject = pbean.getIsModifyProject();
		List<BaseProjectStage> detailProjectStageList = GenericBase.__getList(params.get("detailProjectStage"),BaseProjectStage.newInstance());
		if (mainStageId <= 0) {
			throw new SQLException("项目阶段不能为空");
		}
		if (BaseHelpUtils.isNullOrEmpty(isModifyProject)) {
			throw new SQLException("是否修改项目不能为空");
		}
		if (BaseHelpUtils.isNullOrEmpty(detailProjectStageList) || detailProjectStageList.size() <= 0) {
//			throw new SQLException("非修改项目时,阶段策划不能为空");
			throw new SQLException("阶段策划不能为空");
		}

		int signCompany = pbean.getSignCompany();
		CompanyRecord comDao = new CompanyRecord();
		comDao.setCompanyRecordId(signCompany);
		// 生成项目编号
		if (comDao.load()) {
			// 获取公司编号
			String companyCode = BaseHelpUtils.getString(comDao.getCompanyCode());
			// 获取阶段编号
			MainProjectStage mpsDao = new MainProjectStage();
			mpsDao.setConditionMainStageId("=", mainStageId);
			BaseMainProjectStage baseMainProjectStage = mpsDao.executeQueryOneRow();
			if (BaseHelpUtils.isNullOrEmpty(baseMainProjectStage)) {
				throw new SQLException("不存在该项目阶段");
			}
			String mainStageCode = baseMainProjectStage.getMainStageCode();
			// 判断是否修改项目
			String X = "";
			if (isModifyProject) {
				pdao.clear();
				pdao.setConditionInfoCode("=", infoCode);
				pdao.setConditionMainProjectStageId("=", mainStageId);
				pdao.setConditionIsModifyProject("=", isModifyProject);
				int size = pdao.conditionalLoad().size()+1;
				if(size<10) {
					X = "X-0"+size;
				}else {
					X = "X-"+size;
				}
			}else {
				pdao.clear();
				pdao.setConditionInfoCode("=", infoCode);
				pdao.setConditionMainProjectStageId("=", mainStageId);
				pdao.setConditionIsModifyProject("=", isModifyProject);
				int size = pdao.conditionalLoad().size()+1;
				if(size<10) {
					X = "0"+size;
				}else {
					X = ""+size;
				}
			}
			// 项目编号：公司编号.信息编号-阶段编号，如：KB.2019-001E。如果项目有修改，则要在项目后面+X（根据第二步增加的阶段和是否修改项目判断）
			String projectCode = companyCode + "." + infoCode + mainStageCode + X;
			pdao.clear();
			pdao.setConditionProjectCode("=", projectCode.trim());
//			pdao.setConditionProcessStatus("=", 2);
			pdao.addCondition(BaseMainProject.CS_PROCESS_STATUS, "in", 1,2);//查询进行中和已完成是否有重名
			List<BaseMainProject> baseMainProject = pdao.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseMainProject)||baseMainProject.size()>0) {
				throw new SQLException("项目编号(" + projectCode + ")已重复,请修改项目阶段或是否修改项目字段");
			} else {
				pbean.setProjectCode(projectCode);
			}
		} else {
			throw new SQLException("拟签约公司查询失败！");
		}
		
		pdao.clear();
		pdao.setDataFromBase(pbean);
		pdao.setProjectApprovalTime(currentDate);
		pdao.setProcessStatus(1);//进行中
		pdao.save();
		Integer mainProjectId = pdao.getMainProjectId();
		params.put("mainProjectId", mainProjectId);
		p.savaDataForMainProject(params);

		// 保存前期项目信息
		params.put("activityId", employeeId);
//		params.put("clientId", customerId);
		params.remove("projectName");
		params.remove("clientId");
		params.remove("customerName");
		String resultStr = p.savaDataForBeProject(params);
		// 更改项目的立项状态
		bean.setDataFromMap(params);
		if (null == bean.getPreProjectId()) {
			BaseCollection<BasePreProject> bc = new BaseCollection<>();
			bc.setDataFromJSON(BasePreProject.newInstance(), resultStr);
			bean.setPreProjectId(bc.getStatus());
		}
		PreProjectWithMmm dao = new PreProjectWithMmm();
		dao.setPrimaryKeyFromBase(bean);
		dao.setDataFromBase(bean);
		dao.setStatus(1);// 立项进行中
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(mainProjectId, "");
		return ba;
	}


	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
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
		params.put("activityId", employeeId);
		String infoCode = BaseHelpUtils.getString(params.get("infoCode"));
		String projectCode = BaseHelpUtils.getString(params.get("projectCode"));


		// 如果在项目信息这边修改客户，查询该客户是否存在，不存在则添加
//		Customer cusDao = new Customer();
//		String customerName = BaseHelpUtils.getString(bean.getCustomerName());
//		cusDao.setConditionCustomerName("=", customerName);
//		BaseCustomer cusBean = cusDao.executeQueryOneRow();
//		System.out.println("审批时==="+params.toString());
//		int customerId = 0;
//		// 如果客户不存在则添加
//		if (BaseHelpUtils.isNullOrEmpty(cusBean)) {
//			cusDao.setCustomerName(customerName);
//			cusDao.setCompanyAddress(bean.getCustomerAddress());
//			cusDao.setIsSure(false);
//			cusDao.setType(1);// 开发商
//			cusDao.setReportEmployeeId(BaseHelpUtils.getIntValue(params.get("applyEmployeeId")));
//			cusDao.setCustomerType(3);
//			cusDao.setCreateTime(new Date());
//			cusDao.save();
//			System.out.println("审批新增了客户==="+cusDao.toString());
//			bean.setClientId(cusDao.getCustomerId());
//			customerId = cusDao.getCustomerId();
//		} else {
//			customerId = cusBean.getCustomerId();
//		}
		// 如果在项目信息这边修改客户
		pbean.setDataFromMap(params);
		if (BaseHelpUtils.getIntValue(params.get("clientId"))>0) {
			Customer customer = new Customer();
			customer.setConditionCustomerId("=",BaseHelpUtils.getIntValue(params.get("clientId")));
			customer.setCustomerId(BaseHelpUtils.getIntValue(params.get("clientId")));
			if(customer.load()) {
				pbean.setCustomerName(customer.getCustomerName());
				pbean.setClientId(BaseHelpUtils.getIntValue(params.get("clientId")));
			}else {
				throw new SQLException("该客户不存在,请先到客户管理新增。");
			}
		}else {
			throw new SQLException("请选择正确的客户");
		}
		Date currentDate = new Date();
		//更新main_projects表
		MainProject pdao = new MainProject();
//		pbean.setDataFromMap(params);
		pdao.setDataFromBase(pbean);
		pdao.setProjectApprovalTime(currentDate);
		Integer mainProjectId = BaseHelpUtils.getIntValue(pbean.getMainProjectId());
//		params.put("mainProjectId", mainProjectId);
//		params.put("clientId", customerId);
		p.savaDataForMainProject(params);

		PreProject dao =new PreProject();
		dao.setConditionInfoCode("=", infoCode);
		BasePreProject bean = dao.executeQueryOneRow();

		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setStatus(2);//立项成功
				dao.setProjectStatus("设计中");//只有项目状态为设计中，ECMC的项目才会由前期项目转为正式项目


				pdao.setProcessStatus(2);//已完成
				//立项后自动创建一条合同记录
				Contract cDao = new Contract();
				cDao.setConditionInfoCode("=", infoCode);
				cDao.setConditionProjectCode("=", projectCode);
				BaseContract cBean = cDao.executeQueryOneRow();
				boolean createContract = false;
				cDao.clear();
				if(null == cBean) {
					createContract = true;
				}else {
					cDao.setDataFromBase(cBean);
					cDao.clearModifiedFlags();
				}
				if(!BaseHelpUtils.isNullOrEmpty(pdao.getProjectCode())) {
					cDao.setContractCode(pdao.getProjectCode());
				}
				if(!BaseHelpUtils.isNullOrEmpty(infoCode)) {
					//2019-001
					int num  = BaseHelpUtils.getIntValue(infoCode.substring(5));
					if(num<=0) {
						throw new SQLException("信息编号("+infoCode+")格式有误!");
					}
					cDao.setSerialNumber(num+"");
				}
				cDao.setContractName(pdao.getProjectName());
				cDao.setProjectCode(pdao.getProjectCode());
				cDao.setProjectLevel(pdao.getProjectLevel());
				cDao.setSigningCompanyName(pdao.getSignCompany());
				cDao.setCreateTime(currentDate);
				cDao.setFlowStatus(99);
				cDao.setProjectApprovalTime(currentDate);
				cDao.setCustomerName(pdao.getCustomerName());
				//cDao.setCustomerId(pdao.getClientId());
				cDao.setCustomerId(BaseHelpUtils.getIntValue(params.get("clientId")));
				cDao.setInfoCode(pdao.getInfoCode());
				Integer contractStatus = null;
				if(Objects.equals(dao.getProjectBaseOn(), StaticUtils.PROJECT_BASE_ON_1) || Objects.equals(dao.getProjectBaseOn(), StaticUtils.PROJECT_BASE_ON_4)) {
					//投标/邀标立项的时候，合同设置为未出结果状态
					contractStatus = StaticUtils.CONTRACT_STATUS_1;
				}else {
					//合同/委托函立项的时候，合同设置为项目缓慢状态
					contractStatus = StaticUtils.CONTRACT_STATUS_4;
				}
				cDao.setContractStatus(contractStatus);
				if(null != dao.getRegion()) {
					SystemDictionary dicDao = new SystemDictionary();
					dicDao.setConditionDicTypeId("=", 170);
					dicDao.setConditionDicTypeValueId("=", dao.getRegion());
					BaseSystemDictionary dicBean = dicDao.executeQueryOneRow();
					if(null != dicBean && null != dicBean.getDicTypeValue()) {
						dicDao.clear();
						dicDao.setConditionDicTypeId("=", 116);
						dicDao.setConditionDicTypeValue("=", dicBean.getDicTypeValue());
						dicBean = dicDao.executeQueryOneRow();
						if(null != dicBean && null != dicBean.getDicTypeValueId()) {
							cDao.setContractArea(dicBean.getDicTypeValueId());
						}
					}
				}
				if(createContract) {
					cDao.save();
					//创建合同的账号
					AccountUtils.createAccount(AccountUtils.ACCOUNT_TYPE_CONTRACT, cDao.getContractId(), AccountUtils.ACCOUNT_LEVEL_1, cDao.getContractName(), null, true);
				}else {
					cDao.update();
				}

				Integer contractId = cDao.getContractId();
				//更新ProjectStage的contractId
				ProjectStage psDao = new ProjectStage();
				psDao.setConditionMainProjectId("=", mainProjectId);
				psDao.setContractId(contractId);
				psDao.setProjectAmount(BigDecimal.ZERO);
				psDao.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_1);
				psDao.conditionalUpdate();

				ContractLog clDao = new ContractLog();
				clDao.setContractId(contractId);
				clDao.setNewStatus(contractStatus);
				clDao.setContent("项目立项完成，创建合同");
				clDao.save();


				//更新合同跟踪记录表
				ContractsRecords crDao=new ContractsRecords();
				crDao.setConditionContractCode("=", pdao.getProjectCode());
				List<BaseContractsRecords> crlist=crDao.conditionalLoad();
				if(crlist.size()>0) {
					crDao.setContractId(contractId);
					crDao.setContractCode(cDao.getContractCode());
					crDao.setContractName(cDao.getContractName());
					crDao.setContractAmount(cDao.getSigningMoneySum());//签约合同金额
					crDao.conditionalUpdate();
				}

				//获取流程发起者ID,在流程结束时给发起者企业微信发送消息通知
				int employeeIds=pi.getProcessInstance().getEmployeeId();
				String content = "您好，您申请的（"+bean.getProjectName()+"）前期项目立项审批完成，请您登录ERP系统查看，谢谢！";
				ERPWeixinUtils.sendWXMsgToUser(employeeIds, content);

				//企业微信消息推送给 项目立项报备人 通知项目立项已完成
				//报备人id
				Integer applyEmployeeId = pdao.getApplyEmployeeId();
				if(!BaseHelpUtils.isNullOrEmpty(applyEmployeeId)&&applyEmployeeId>0) {
					ERPWeixinUtils.sendWXMsgToUser(applyEmployeeId,String.format(WeixinStatics.MSG_PRE_PROJECT_COMPLETED_MSG,bean.getProjectName()));
				}

				if(null != pbean && null != pbean.getMainProjectId()){
					CwdFile cwdFileDao = new CwdFile();
					cwdFileDao.setConditionProjectId("=", pbean.getMainProjectId());
					if(cwdFileDao.countRows() == 0){
						generateProjectFolder(pbean);
					}
				}
			}else if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){
				dao.setStatus(3);//立项失败
				pdao.setProcessStatus(3);//已驳回
				//获取流程发起者ID,在流程结束时给发起者企业微信发送消息通知
				int employeeIds=pi.getProcessInstance().getEmployeeId();
				String content = "抱歉，您申请的（"+bean.getProjectName()+"）前期项目立项被驳回，请您登录ERP系统查看，谢谢！";
				ERPWeixinUtils.sendWXMsgToUser(employeeIds, content);
			}
		}

		dao.update();
		pdao.update();
//		if(BaseHelpUtils.getIntValue(dao.getStatus())!=3){
//			pdao.update();
//		}

		BusinessAbstract ba = new BusinessAbstract(dao.getPreProjectId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getApplyEmployeeId());
		e =OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
		e.setValue("立项依据", SelectValueCache.getSelectValue("system_dictionary_28", String.valueOf(bean.getProjectBaseOn())));
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}


	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		//如果角色不为空并且角色为项目主管领导的时候
		if(null != roleId && roleId.equals(StaticUtils.ROLE_PROJECT_LEADER)){
			MainProjectEmployee emDao = new MainProjectEmployee();
			emDao.setConditionPreProjectId("=",getPreProjectId());
			emDao.setConditionRelation("=", 4);//项目主管领导
			emDao.setConditionIsPlateManager("=", Boolean.TRUE);
			List<BaseMainProjectEmployee> embean = emDao.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(embean)){
				int size = embean.size();
				int[] arr = new int[size];
				for(int i = 0; i < size; i++){
					arr[i] = embean.get(i).getEmployeeId();
				}
				return arr;
			}
		}
		if(null != roleId && roleId.equals(StaticUtils.ROLE_PROJECT_RELATE_LEADER)){
			MainProjectEmployee emDao = new MainProjectEmployee();
			emDao.setConditionPreProjectId("=",getPreProjectId());
			emDao.setConditionRelation("=", 4);//项目主管领导
			emDao.setConditionIsPlateManager("=", Boolean.FALSE);
			List<BaseMainProjectEmployee> embean = emDao.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(embean)){
				int size = embean.size();
				int[] arr = new int[size];
				for(int i = 0; i < size; i++){
					arr[i] = embean.get(i).getEmployeeId();
				}
				return arr;
			}
		}
		if(null != roleId && roleId.equals(StaticUtils.ROLE_OPERATIONS_MANAGER)){
			int designTeam=BaseHelpUtils.getIntValue(bean.getDesignTeam());//主办设计团队
			if(designTeam>0) {
				Set<Integer> set=getDepartmentManageId(designTeam,StaticUtils.ROLE_OPERATIONS_MANAGER);
				int size=set.size();
				int[] arr = new int[size];
				int i=0;
				for (int value : set) {
					if(i==size)break;
					arr[i]=value;
					i++;
				}
				return arr;
			}
		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
//		PreProjectWithMmm dao = new PreProjectWithMmm();
		MainProject dao = new MainProject();
		dao.setMainProjectId(businessId);
		dao.load();
		String json = dao.generateBase().toJSON();
		System.out.println("json===================="+json);
		
		return json;
	}

	private int preProjectId;

	public int getPreProjectId() {
		return preProjectId;
	}

	public void setPreProjectId(int preProjectId) {
		this.preProjectId = preProjectId;
	}

	private void generateProjectFolder(BaseMainProject bean) throws Exception{
		if(null == bean){
			return;
		}
		//创建项目文件夹
		CompanyRecord crDao = new CompanyRecord();
		crDao.setConditionCompanyRecordId("=", bean.getCompanyId());
		crDao.unsetSelectFlags();
		crDao.setSelectCompanyNo(true);
		BaseCompanyRecord crBean = crDao.executeQueryOneRow();
		if(null == crBean)
			return;
		CwdFile fileDao = new CwdFile();
		fileDao.setFileName(String.format("%1$s-%2$s-%3$s", bean.getProjectCode(), bean.getProjectName(), bean.getMainProjectId()));
		fileDao.setParentId(0);
		fileDao.setProjectId(bean.getMainProjectId());
		fileDao.setFilePath(fileDao.getFileName() + "/");
		fileDao.setOssKey(fileDao.getFilePath());
		fileDao.setIsFolder(true);
		fileDao.setFileType(StaticUtils.FILE_TYPE_FOLDER);
		fileDao.setCompanyId(bean.getCompanyId());
		fileDao.setCompanyNo(crBean.getCompanyNo());
		fileDao.setUploadLock(false);
		fileDao.setCreateTime(new Date());
		fileDao.setModificationTime(fileDao.getCreateTime());
		fileDao.setDeleteFlag(StaticUtils.NO_DELETE);
		fileDao.save();
		BaseCwdFileVersion versionBean = new BaseCwdFileVersion();
		versionBean.setDataFromJSON(fileDao.generateBase().toJSON());
		versionBean.setUploadStartTime(fileDao.getCreateTime());
		versionBean.setUploadCompletedTime(fileDao.getCreateTime());
		versionBean.setUploadStatus(StaticUtils.FILE_VERSION_UPLOAD_STATUS_3);
        CwdFileVersion versionDao = new CwdFileVersion();
        versionDao.setDataFromBase(versionBean);
        versionDao.save();
        fileDao.setFileVersionId(versionDao.getCwdFileVersionId());
        fileDao.update();
        Integer parentId = fileDao.getCwdFileId();
        String filePath = fileDao.getFilePath();
        //创建文件夹：基础资料
        generateCommonFolder(StaticUtils.FOLDER_NAME_BASIC, StaticUtils.FILE_ATTRIBUTION_BASIC, filePath, parentId, fileDao, versionDao);
        //创建文件夹：设计区
        generateCommonFolder(StaticUtils.FOLDER_NAME_DESIGN, StaticUtils.FILE_ATTRIBUTION_DESIGN, filePath, parentId, fileDao, versionDao);
        //创建文件夹：审核区
        generateCommonFolder(StaticUtils.FOLDER_NAME_AUDIT, StaticUtils.FILE_ATTRIBUTION_AUDIT, filePath, parentId, fileDao, versionDao);
        //创建文件夹：提资区
//        generateCommonFolder(StaticUtils.FOLDER_NAME_RAISE, StaticUtils.FILE_ATTRIBUTION_RAISE, filePath, parentId, fileDao, versionDao);
        //创建文件夹：交付区
        generateCommonFolder(StaticUtils.FOLDER_NAME_DELIVERY, StaticUtils.FILE_ATTRIBUTION_DELIVERY, filePath, parentId, fileDao, versionDao);
        //创建文件夹：出版区
//        generateCommonFolder(StaticUtils.FOLDER_NAME_PUBLISH, StaticUtils.FILE_ATTRIBUTION_PUBLISH, filePath, parentId, fileDao, versionDao);
        //创建文件夹：协同区
        generateCommonFolder(StaticUtils.FOLDER_NAME_COORDINATION, StaticUtils.FILE_ATTRIBUTION_COORDINATION, filePath, parentId, fileDao, versionDao);

	}

	private void generateCommonFolder(String folderName, Integer fileAttribution, String parentFilePath, Integer parentId, CwdFile fileDao, CwdFileVersion versionDao) throws Exception{
		fileDao.setCwdFileId(null);;
        fileDao.setFileName(folderName);
        fileDao.setFilePath(parentFilePath + fileDao.getFileName() + "/");
        fileDao.setOssKey(fileDao.getFilePath());
        fileDao.setParentId(parentId);
        fileDao.setFileAttribution(fileAttribution);
        fileDao.save();
        versionDao.setCwdFileVersionId(null);
        versionDao.setFileName(fileDao.getFileName());
        versionDao.setFilePath(fileDao.getFilePath());
        versionDao.setOssKey(fileDao.getOssKey());
        versionDao.setCwdFileId(fileDao.getCwdFileId());
        versionDao.save();
        fileDao.setFileVersionId(versionDao.getCwdFileVersionId());
        fileDao.update();
	}



	/**
	 *
	 * @param mainProjectId
	 * @param employeeId
	 * @throws SQLException
	 */
	public static void createProjectFiling(int mainProjectId, int employeeId) throws SQLException {
		CwdFilingTemplate cftDao = new CwdFilingTemplate();
		List<BaseCwdFilingTemplate> cftList = cftDao.conditionalLoad();
		if(cftList.size() > 0) {
			Date currentDate = new Date();
			List<BaseCwdFilingManage> cfmList = new ArrayList<>();
			for (BaseCwdFilingTemplate baseCwdFilingTemplate : cftList) {
				BaseCwdFilingManage tmpBean = new BaseCwdFilingManage();
				tmpBean.setFilingType(baseCwdFilingTemplate.getFilingType());
				tmpBean.setCwdFilingTemplateId(baseCwdFilingTemplate.getCwdFilingTemplateId());
				tmpBean.setMainProjectId(mainProjectId);
				tmpBean.setTemplateName(baseCwdFilingTemplate.getTemplateName());
				tmpBean.setCreateTime(currentDate);
				tmpBean.setOperatorId(employeeId);
				cfmList.add(tmpBean);
			}
			// 插入主数据
			CwdFilingManage cfmDao = new CwdFilingManage();
			cfmDao.save(cfmList);
			cfmDao.clear();
			cfmList.clear();
			cfmList = cfmDao.conditionalLoad();
			// 处理详情数据
			if(cfmList.size() > 0) {
				// 模板详情
				CwdFilingTemplateDetail cftdDao = new CwdFilingTemplateDetail();
				// 业务表详情
				CwdFilingManageDetail cfmdDao = new CwdFilingManageDetail();
				// 存放原有主键与模板详情主键 key为原有主键  value
				Map<Integer, Integer> idMap = new HashMap<>();
				for (BaseCwdFilingManage baseCwdFilingManage : cfmList) {
					int cwdFilingTemplateId = baseCwdFilingManage.getCwdFilingTemplateId();
					cftdDao.clear();
					cftdDao.setConditionCwdFilingTemplateId("=", cwdFilingTemplateId);
					List<BaseCwdFilingTemplateDetail> cftdList = cftdDao.conditionalLoad();
					if(cftdList.size() > 0) {
						for (BaseCwdFilingTemplateDetail baseCwdFilingTemplateDetail : cftdList) {
							BaseCwdFilingManageDetail tmpBean = new BaseCwdFilingManageDetail();
							tmpBean.setCwdFilingManageId(baseCwdFilingManage.getCwdFilingManageId());
							tmpBean.setFileName(baseCwdFilingTemplateDetail.getFileName());
							tmpBean.setOperatorId(employeeId);
							tmpBean.setParentId(baseCwdFilingTemplateDetail.getParentId());
							tmpBean.setCreateTime(currentDate);
							tmpBean.setMainProjectId(mainProjectId);
							cfmdDao.clear();
							cfmdDao.setDataFromBase(tmpBean);
							cfmdDao.save();
							idMap.put(baseCwdFilingTemplateDetail.getCwdFilingTemplateDetailId(), cfmdDao.getCwdFilingManageDetailId());
						}
					}
				}
				// 更新父级id
				cfmdDao.clear();
				cfmdDao.setConditionMainProjectId("=", mainProjectId);
				List<BaseCwdFilingManageDetail> cfmdList = cfmdDao.conditionalLoad();
			    for (BaseCwdFilingManageDetail baseCwdFilingManageDetail : cfmdList) {
			    	cfmdDao.clear();
			    	if(baseCwdFilingManageDetail.getParentId() > 0) {
			    		int parentId = idMap.get(baseCwdFilingManageDetail.getParentId());
				    	if(!Objects.equals(parentId, baseCwdFilingManageDetail.getParentId())) {
				    		cfmdDao.setDataFromBase(baseCwdFilingManageDetail);
					    	cfmdDao.clearModifiedFlags();
					    	cfmdDao.setParentId(parentId);
					    	cfmdDao.update();
				    	}
			    	}
				}
			}
		}
	}


	/**
	 * 找业务部门下所有部门经理
	 * @param plateId
	 * @param roleId
	 * @return
	 * @throws SQLException
	 */
	public static Set<Integer>  getDepartmentManageId(int plateId,int roleId) throws SQLException{
		Set<Integer>  set=new HashSet<>();
		Department dao = new Department();
		dao.setConditionPlateId("=",plateId);
		dao.setConditionDeleteFlag("=", 0);
		List<BaseDepartment> list = dao.conditionalLoad("order by department_id asc");
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			EmployeeRole employeeRoleDao = new EmployeeRole();
			for(BaseDepartment bean : list){
				//获取部门Id
				int departmentId = BaseHelpUtils.getIntValue(bean.getDepartmentId());
				employeeRoleDao.clear();
				employeeRoleDao.setConditionDepartmentId("=",departmentId);
				employeeRoleDao.setConditionRoleId("=",roleId);
				List<BaseEmployeeRole> rlist = employeeRoleDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(rlist)&&rlist.size()>0){
					for (BaseEmployeeRole rbean : rlist) {
						int empId = BaseHelpUtils.getIntValue(rbean.getEmployeeId());
						if(empId > 0){
							set.add(empId);
						}
					}
				}
				break;
			}
		}
		return set;
	}

	/**
	 * 去除字符串中的空格、回车、换行符、制表符，分号
	 *
	 * @param str
	 * @return
	 */
	public static String replaceSpecialStr(String str) {
		String repl = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			repl = m.replaceAll("");
		}
		return repl;
	}

//	public static void main(String[] args) throws SQLException {
//		MainProject pdao =new MainProject();
//
//		Integer[] a =new Integer[2];
//		a[0] = 1;
//		a[1] = 2;
//		pdao.addCondition(BaseMainProject.CS_PROCESS_STATUS, "in", 1,2);
//		List<BaseMainProject> conditionalLoad = pdao.conditionalLoad();
//
//	}


}
