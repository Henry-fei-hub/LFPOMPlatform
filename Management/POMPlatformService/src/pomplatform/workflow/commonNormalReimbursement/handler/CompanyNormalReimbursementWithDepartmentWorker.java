package pomplatform.workflow.commonNormalReimbursement.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.NormalReimbursementLinkDepartment;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Department;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.CommonUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.commonNormalReimbursement.bean.BaseProjectNormalReimbursementWithPn;
import pomplatform.workflow.commonNormalReimbursement.dao.ProjectNormalReimbursementWithPn;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;

public class CompanyNormalReimbursementWithDepartmentWorker implements GenericWorkflowProcessor {

	protected BaseProjectNormalReimbursementWithPn bean = new BaseProjectNormalReimbursementWithPn();

	private static final Logger __logger = Logger.getLogger(CompanyNormalReimbursementWithDepartmentWorker.class);


	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setApplyEmployeeId(employeeId);
		bean.setIsProject(false);
		bean.setCode(OnWrokflowProcess.getNewCode(BaseHelpUtils.getIntValue(pd.getProcessTypeId())));
		ProjectNormalReimbursementWithPn dao = new ProjectNormalReimbursementWithPn();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getProjectNormalReimbursementId(), dao.getReimbursementName());
		//插入账单流水
		params.put("businessId", dao.getProjectNormalReimbursementId());
		params.put("processType", pd.getProcessTypeId());
		params.put("employeeId", employeeId);
		CustomSprocessbilllistppporProcess.deleteAndSaveDetailTables(params);
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getAttachmentId());
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed)
			throws Exception {
		bean.setDataFromMap(params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}
			//获取当前活动节点
			ProcessInstanceActivity currentActiveActivity = pIns.getActiveActivity();
			if(!BaseHelpUtils.isNullOrEmpty(currentActiveActivity)) {
				//获取当前活动节点名称
				String nodeName = BaseHelpUtils.getString(currentActiveActivity.getBackViewName());
				if(nodeName.equals(StaticUtils.NODE_NAME_ONE)) {//如果是财务会计节点，则推送提醒消息给到发起人，提醒打印报销单和贴发票
					//获取发起人，而不是报销人
					int applyEmpId = BaseHelpUtils.getIntValue(bean.getApplyEmployeeId());
					if(applyEmpId > 0) {
						//获取报销类型
						int processType = BaseHelpUtils.getIntValue(currentActiveActivity.getProcessType());
						//获取报销类型名称
						String processTypeName = SelectValueCache.getSelectValue("system_process_types", processType+"");
						//获取报销编号
						String code = BaseHelpUtils.getString(bean==null?"":bean.getCode());
						ERPWeixinUtils.sendWXMsgToUser(applyEmpId, String.format(WeixinStatics.MSG_REIMBURSEMENT_MSG,code,processTypeName));
					}
				}
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
		ProjectNormalReimbursementWithPn dao = new ProjectNormalReimbursementWithPn();
		dao.setPrimaryKeyFromBase(bean);
		if (!dao.load())
			throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(null == dao.getDetailProjectNormalReimbursementDetail()){
			ProjectNormalReimbursementDetail detailDao = new ProjectNormalReimbursementDetail();
			detailDao.setConditionProjectNormalReimbursementId("=", dao.getProjectNormalReimbursementId());
			dao.setDetailProjectNormalReimbursementDetail(detailDao.conditionalLoad());
		}
		if(null == dao.getDetailNormalReimbursementLinkDepartment()){
			NormalReimbursementLinkDepartment linkDao = new NormalReimbursementLinkDepartment();
			linkDao.setConditionProjectNormalReimbursementId("=", dao.getProjectNormalReimbursementId());
			dao.setDetailNormalReimbursementLinkDepartment(linkDao.conditionalLoad());
		}
		dataValidate(dao);
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BaseProjectNormalReimbursement.CS_ATTACHMENT_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		BusinessAbstract ba = new BusinessAbstract(dao.getProjectNormalReimbursementId(), dao.getReimbursementName());
		//插入与修改账单流水
		params.put("businessId", dao.getProjectNormalReimbursementId());
		params.put("processType", pi.getProcessInstance().getProcessType());
		params.put("employeeId", employeeId);
		//由于财务出纳一般处于最后一个节点  所以还是需要修改数据   所以主数据的修改在最后一个节点还是进行修改的  (财务出纳会改成处理节点)
		CustomSprocessbilllistppporProcess.deleteAndSaveDetailTables(params);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				CustomSprocessbilllistppporProcess.passProcessBillList(params);
				dao.setIsCompleted(true);
				//部门成本记录下来
				Integer processTypeId = pi.getProcessInstance().getProcessType();
				Integer businessId = dao.getProjectNormalReimbursementId();
				PlateCostRecord pcrDao = new PlateCostRecord();
				pcrDao.setConditionBusinessId("=", businessId);
				pcrDao.setConditionProcessType("=", processTypeId);
				if(pcrDao.countRows() <= 0){
					List<BaseNormalReimbursementLinkDepartment> list=dao.getDetailNormalReimbursementLinkDepartment();
					if(list.size()>0){
						//获取当前的年月
						Date date=new Date();
						Calendar c = Calendar.getInstance();
						c.setTime(date);
						String remark = dao.getReimbursementName();
						Integer processId = pi.getProcessInstance().getProcessId();
						Integer processInstanceId = pi.getProcessInstance().getProcessInstanceId();
						for(BaseNormalReimbursementLinkDepartment baseNormal:list){
							//插入数据到部门成本表中
							PlateCostRecord plateCostRecord=new PlateCostRecord();
							Department department=new Department();
							department.setDepartmentId(baseNormal.getDepartmentId());
							if(department.load()){
								plateCostRecord.setPlateId(department.getPlateId());
							}
							plateCostRecord.setCostIntegral(baseNormal.getFinalAmount());
							plateCostRecord.setSalaryIntegral(new BigDecimal("0"));
							plateCostRecord.setIsSettlement(false);
							plateCostRecord.setYear(c.get(Calendar.YEAR));
							plateCostRecord.setMonth(c.get(Calendar.MONTH)+1);
							plateCostRecord.setCostDate(date);
							plateCostRecord.setProcessType(processTypeId);
							plateCostRecord.setBusinessId(businessId);
							plateCostRecord.setProcessId(processId);
							plateCostRecord.setProcessInstanceId(processInstanceId);
							plateCostRecord.setRemark(remark);
							plateCostRecord.save();
							//插入数据到部门积分汇总表中
							PlateAccountRecord plateAccountRecordDao = new PlateAccountRecord();
							plateAccountRecordDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
							plateAccountRecordDao.setBusinessId(plateCostRecord.getPlateCostRecordId());
							plateAccountRecordDao.setPlateId(plateCostRecord.getPlateId());
							plateAccountRecordDao.setIntegral(plateCostRecord.getCostIntegral());
							plateAccountRecordDao.setRecordDate(plateCostRecord.getCostDate());
							plateAccountRecordDao.setOperateEmployeeId(employeeId);
							plateAccountRecordDao.setOperateTime(date);
							plateAccountRecordDao.setRemark(remark);
							plateAccountRecordDao.save();
						}
					}
				}
			}
			
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){//被驳回
				//流程被驳回则消息通知发起人
				String code = bean.getCode();
				ProcessInstance processInstance = pi.getProcessInstance();
				Integer processType = processInstance.getProcessType(); 
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getApplyEmployeeId());
				SendMSGCommon sendMSGCommon =new SendMSGCommon();
				Map map =new HashMap<String, Object>();
				map.put("code", code);
				map.put("processType", processType);
				map.put("applyEmpId", applyEmpId);
				sendMSGCommon.sendWXMsgToUser(map);
			}
			
		}
		dao.update();
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,bean.getAmount(),null,null);
		e.setValue(OnWrokflowProcess.LINE_COMPANY_NAME, CommonUtils.getCompanyShortName(bean.getCompanyId()));
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if (poolType == null || poolType == 0) {
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		} else {
			List<BaseNormalReimbursementLinkDepartment> list = bean.getDetailNormalReimbursementLinkDepartment();
			if (list == null || list.isEmpty()) {
				throw new SQLException("请选择一个部门！");
			}
			Set<Integer> ownerSet = new HashSet<>();
			for (BaseNormalReimbursementLinkDepartment b : list) {
				Integer id = b.getDepartmentId();
				if(id == null || id == 0){
					throw new Exception("请选择一个部门！");
				}
				do{
					int[] tempArr = NormalReimbursementWithDepartmentWorker.findNextOwner(id, roleId);
					if (null != tempArr && tempArr.length > 0) {
						for (int userId : tempArr) {
							ownerSet.add(userId);
						}
						break;
					}else{
						Department departmentDao = new Department();
						departmentDao.unsetSelectFlags();
						departmentDao.setSelectParentId(true);
						departmentDao.setConditionDepartmentId("=", id);
						id = departmentDao.executeQueryOneRow().getParentId();
					}
				}while(null != id && !id.equals(1));
			}
			if (!ownerSet.isEmpty()) {
				int length = ownerSet.size();
				int[] activityOwners = new int[length];
				int i = 0;
				for (Integer obj : ownerSet) {
					activityOwners[i] = BaseHelpUtils.getIntValue(obj);
					i++;
				}
				return activityOwners;
			} else {
				return new int[0];
			}
		}
		//		List<BaseNormalReimbursementLinkDepartment> list = bean.getDetailNormalReimbursementLinkDepartment();
		//		if (null != list && !list.isEmpty()) {
		//			int size = list.size();
		//			Map<Integer, Object> ownerMap = new HashMap<>();
		//			if (null != roleId && poolType != null && poolType != 0) {
		//				for (int i = 0; i < size; i++) {
		//					Integer id = list.get(i).getDepartmentId();
		//					if (null != id) {
		//						int[] tempArr = ProcessUtil.findNextOwner(processCreator, employeeId, id, roleId);
		//						if (null != tempArr) {
		//							for (int userId : tempArr) {
		//								ownerMap.put(userId, null);
		//							}
		//						}
		//					} else {
		//						throw new Exception("请选择一个部门！");
		//					}
		//				}
		//				if (!ownerMap.isEmpty()) {
		//					int length = ownerMap.size();
		//					int[] activityOwners = new int[length];
		//					int i = 0;
		//					for (Integer obj : ownerMap.keySet()) {
		//						activityOwners[i] = BaseHelpUtils.getIntValue(obj);
		//						i++;
		//					}
		//					return activityOwners;
		//				} else {
		//					return new int[0];
		//				}
		//			} else {
		//				return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		//			}
		//		} else {
		//			throw new SQLException("请选择一个部门！");
		//		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ProjectNormalReimbursementWithPn dao = new ProjectNormalReimbursementWithPn();
		dao.setProjectNormalReimbursementId(businessId);
		dao.load();
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getAttachmentId()));
		return dao.generateBaseExt().toJSON();
	}

	public void dataValidate(ProjectNormalReimbursementWithPn dao) throws Exception {
		if (BaseHelpUtils.isNullOrEmpty(dao.getReimbursementName())) {
			throw new Exception("请填写主题");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getApplyEmployeeId())) {
			throw new Exception("起草人有误");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getEmployeeId())) {
			throw new Exception("请选择报销人");
		}
		if (null == dao.getAmount() || dao.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("报销金额必须大于0");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getCompanyId())) {
			throw new Exception("请选择归属公司");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getRemark())) {
			throw new Exception("请填写备注");
		}
		List<BaseProjectNormalReimbursementDetail> commonNormalReimbursementDetailList = dao
				.getDetailProjectNormalReimbursementDetail();
		if (null == commonNormalReimbursementDetailList || commonNormalReimbursementDetailList.isEmpty()) {
			throw new Exception("请填写日常报销明细");
		}
		List<BaseNormalReimbursementLinkDepartment> commonReimbursementLinkDepartmentList = dao
				.getDetailNormalReimbursementLinkDepartment();
		if (null == commonReimbursementLinkDepartmentList || commonReimbursementLinkDepartmentList.isEmpty()) {
			throw new Exception("请添加需要承担本次报销金额的部门");
		}
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal inputTaxAndFinalAmount = BigDecimal.ZERO;
		for (BaseNormalReimbursementLinkDepartment obj : commonReimbursementLinkDepartmentList) {
			if (null != obj.getAmount()) {
				sum = sum.add(obj.getAmount());
			}
			if(null != obj.getInputTax()) {
				inputTaxAndFinalAmount = inputTaxAndFinalAmount.add(obj.getInputTax());
			}
			if(null != obj.getFinalAmount()) {
				inputTaxAndFinalAmount = inputTaxAndFinalAmount.add(obj.getFinalAmount());
			}
			if(null != obj.getInputTaxRebate()) {
				inputTaxAndFinalAmount = inputTaxAndFinalAmount.subtract(obj.getInputTaxRebate());
			}
		}
		if (dao.getAmount().compareTo(sum) != 0) {
			throw new Exception("报销金额分拆前后的总数不一致");
		}
		if(sum.compareTo(inputTaxAndFinalAmount) != 0) {
			throw new Exception("进项税 + 成本 - 进项税转出 != 报销金额");
		}
	}
}
