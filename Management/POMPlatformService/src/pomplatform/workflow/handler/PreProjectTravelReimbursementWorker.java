package pomplatform.workflow.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pomplatform.db.bean.BaseInputTaxRecord;
import com.pomplatform.db.bean.BasePreProjectReimbursementNumber;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkMainProject;
import com.pomplatform.db.dao.*;

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
import delicacy.system.executor.SelectValueCache;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.CommonUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.exchangerate.utils.ExchangeRateUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;
import pomplatform.workflow.bean.BaseTravelReimbursementWithTt;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.business.ReimbursementInvoiceUtils;
import pomplatform.workflow.dao.TravelReimbursementWithTt;
import pomplatform.workflow.personnelbusiness.business.SendMSGCommon;

public class PreProjectTravelReimbursementWorker implements GenericWorkflowProcessor {

	protected BaseTravelReimbursementWithTt bean = new BaseTravelReimbursementWithTt();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		TravelReimbursementWithTt dao = new TravelReimbursementWithTt();
		dao.setDataFromBase(bean);
		// 获取最新的编码
		String code = OnWrokflowProcess.getNewCode(BaseHelpUtils.getIntValue(pd.getProcessTypeId()));
		dao.setCode(code);
		dataValidate(dao);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getTravelReimbursementId(), "");
		//插入账单流水
		params.put("businessId", dao.getTravelReimbursementId());
		params.put("processType", pd.getProcessTypeId());
		params.put("employeeId", employeeId);
		CustomSprocessbilllistppporProcess.deleteAndSaveDetailTables(params);
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getAttachmentId());

		// 费用分担关联发票处理
		List<Map<String, Integer>> mainListData = new ArrayList<>();
		TravelReimbursementLinkMainProject nrldDao = new TravelReimbursementLinkMainProject();
		nrldDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
		List<BaseTravelReimbursementLinkMainProject> detailList = nrldDao.conditionalLoad();
		for (BaseTravelReimbursementLinkMainProject baseNormalReimbursementLinkDepartment : detailList) {
			if((null != baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice()
					&&  baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice().equals(2))
					|| (null != baseNormalReimbursementLinkDepartment.getInputTax() && baseNormalReimbursementLinkDepartment.getInputTax().compareTo(BigDecimal.ZERO) > 0)) {
				Map<String, Integer> tmpMap = new HashMap<>();
				tmpMap.put("invoiceLinkKey", baseNormalReimbursementLinkDepartment.getInvoiceLinkKey());
				tmpMap.put("detailId", baseNormalReimbursementLinkDepartment.getTravelReimbursementLinkMainProjectId());
				mainListData.add(tmpMap);
			}
		}
		Map<String, Object> invoiceListMap = null;
		if(params.containsKey("invoiceListMap") && null != params.get("invoiceListMap")) {
			invoiceListMap = (Map<String, Object>) params.get("invoiceListMap");
		}
		ReimbursementInvoiceUtils.saveOrUpdateReimbusementInvoiceData(null, dao.getTravelReimbursementId(), pd.getProcessTypeId(), mainListData, invoiceListMap, 1);
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
					int applyEmpId = BaseHelpUtils.getIntValue(bean.getDrafter());
					if(applyEmpId > 0) {
						//获取报销类型
						int processType = BaseHelpUtils.getIntValue(currentActiveActivity.getProcessType());
						//获取报销类型名称
						String processTypeName = SelectValueCache.getSelectValue("system_process_types", processType+"");
						//获取报销编号
						String code = BaseHelpUtils.getString(bean==null?"":bean.getCode());
						ERPWeixinUtils.sendWXMsgToUser(applyEmpId,String.format(WeixinStatics.MSG_REIMBURSEMENT_MSG,code,processTypeName));
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
		TravelReimbursementWithTt dao = new TravelReimbursementWithTt();
		dao.setPrimaryKeyFromBase(bean);
		if (!dao.load())
			throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(null == dao.getDetailTravelReimbursementDetail()){
			TravelReimbursementDetail detailDao = new TravelReimbursementDetail();
			detailDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
			dao.setDetailTravelReimbursementDetail(detailDao.conditionalLoad());
		}
		if(null == dao.getDetailTravelReimbursementLinkMainProject()){
			TravelReimbursementLinkMainProject departmentDao = new TravelReimbursementLinkMainProject();
			departmentDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
			dao.setDetailTravelReimbursementLinkMainProject(departmentDao.conditionalLoad());
		}
		dataValidate(dao);
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BaseTravelReimbursement.CS_ATTACHMENT_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		BusinessAbstract ba = new BusinessAbstract(dao.getTravelReimbursementId(), "");
		//插入与修改账单流水
		params.put("businessId", dao.getTravelReimbursementId());
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
				Integer businessId = dao.getTravelReimbursementId();
				String remark = dao.getTitle();
				Integer processId = pi.getProcessInstance().getProcessId();
				Integer processInstanceId = pi.getProcessInstance().getProcessInstanceId();
				PlateCostRecord pcrDao = new PlateCostRecord();
				pcrDao.setConditionProcessInstanceId("=", processInstanceId);
				pcrDao.setConditionProcessType("=", processTypeId);
				if(pcrDao.countRows() <= 0){
					List<BaseTravelReimbursementLinkMainProject> list=dao.getDetailTravelReimbursementLinkMainProject();
					if(list.size()>0){
						Calendar c = Calendar.getInstance();
						BigDecimal rate = ExchangeRateUtils.getTodayExchangeRate(dao.getCurrency());
						if(null == rate) {
							throw new Exception("获取汇率失败");
						}
						dao.setExchangeRate(rate);
						for(BaseTravelReimbursementLinkMainProject baseNormal:list){
							//保存部门成本
							PlateCostRecord plateCostRecord=new PlateCostRecord();
							plateCostRecord.setPlateId(baseNormal.getPlateId());
							plateCostRecord.setCostIntegral(baseNormal.getFinalAmount().multiply(rate).setScale(2, BigDecimal.ROUND_DOWN));
							plateCostRecord.setSalaryIntegral(new BigDecimal("0"));
							plateCostRecord.setIsSettlement(false);
							//获取当前的年月
							plateCostRecord.setYear(c.get(Calendar.YEAR));
							plateCostRecord.setMonth(c.get(Calendar.MONTH)+1);
							plateCostRecord.setCostDate(c.getTime());
							plateCostRecord.setProcessType(processTypeId);
							plateCostRecord.setBusinessId(businessId);
							plateCostRecord.setProcessId(processId);
							plateCostRecord.setProcessInstanceId(processInstanceId);
							plateCostRecord.setRemark(remark);
							plateCostRecord.save();
							//同时更新数据到部门积分汇总表中
							PlateAccountRecord plateAccountRecordDao = new PlateAccountRecord();
							plateAccountRecordDao.setBusinessTypeId(AccountManageProcess.PLATE_BT_PLATE_COST);
							plateAccountRecordDao.setBusinessId(plateCostRecord.getPlateCostRecordId());
							plateAccountRecordDao.setPlateId(plateCostRecord.getPlateId());
							plateAccountRecordDao.setIntegral(plateCostRecord.getCostIntegral());
							plateAccountRecordDao.setRecordDate(plateCostRecord.getCostDate());
							plateAccountRecordDao.setOperateEmployeeId(employeeId);
							plateAccountRecordDao.setOperateTime(c.getTime());
							plateAccountRecordDao.setRemark(remark);
							plateAccountRecordDao.save();
						}
					}
				}

				int bunessId=BaseHelpUtils.getIntValue(bean.getTravelReimbursementId());
				InputTaxRecord rdao=new InputTaxRecord();
				rdao.setConditionBusinessId("=", bunessId);
				List<BaseInputTaxRecord> rlist=rdao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(rlist)&&rlist.size()>0) {
					rdao.setOverTime(new Date());
					rdao.conditionalUpdate();
				}

			}
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){//被驳回

				//流程被驳回则消息通知发起人
				String code = bean.getCode();
				ProcessInstance processInstance = pi.getProcessInstance();
				Integer processType = processInstance.getProcessType();
				int applyEmpId = BaseHelpUtils.getIntValue(bean.getDrafter());
				SendMSGCommon sendMSGCommon =new SendMSGCommon();
				Map map =new HashMap<String, Object>();
				map.put("code", code);
				map.put("processType", processType);
				map.put("applyEmpId", applyEmpId);
				sendMSGCommon.sendWXMsgToUser(map);
				}
		}
		// 查询出原有报销费用清单详情数据
		TravelReimbursementLinkMainProject nrldDao = new TravelReimbursementLinkMainProject();
		nrldDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
		List<BaseTravelReimbursementLinkMainProject> oriDetailList = nrldDao.conditionalLoad();
		Set<Integer> oriDetailSet = new HashSet<>();
		for (BaseTravelReimbursementLinkMainProject baseNormalReimbursementLinkDepartment : oriDetailList) {
			oriDetailSet.add(baseNormalReimbursementLinkDepartment.getTravelReimbursementLinkMainProjectId());
		}
		dao.update();

		// 需要报销费用清单相关联的发票数据
		nrldDao.clear();
		List<Map<String, Integer>> mainListData = new ArrayList<>();
		nrldDao.setConditionTravelReimbursementId("=", dao.getTravelReimbursementId());
		List<BaseTravelReimbursementLinkMainProject> detailList = nrldDao.conditionalLoad();
		for (BaseTravelReimbursementLinkMainProject baseNormalReimbursementLinkDepartment : detailList) {
			if((null != baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice()
					&&  baseNormalReimbursementLinkDepartment.getHaveElectronicInvoice().equals(2))
					|| (null != baseNormalReimbursementLinkDepartment.getInputTax() && baseNormalReimbursementLinkDepartment.getInputTax().compareTo(BigDecimal.ZERO) > 0)) {
				Map<String, Integer> tmpMap = new HashMap<>();
				tmpMap.put("invoiceLinkKey", baseNormalReimbursementLinkDepartment.getInvoiceLinkKey());
				tmpMap.put("detailId", baseNormalReimbursementLinkDepartment.getTravelReimbursementLinkMainProjectId());
				mainListData.add(tmpMap);
			}
		}
		Map<String, Object> invoiceListMap = null;
		if(params.containsKey("invoiceListMap") && null != params.get("invoiceListMap")) {
			invoiceListMap = (Map<String, Object>) params.get("invoiceListMap");
		}
		ReimbursementInvoiceUtils.saveOrUpdateReimbusementInvoiceData(oriDetailSet, dao.getTravelReimbursementId(),
				pi.getProcessDefinition().getProcessTypeId(), mainListData, invoiceListMap, 2);
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getApplicant());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,bean.getAmount(),null,null);
		e.setValue(OnWrokflowProcess.LINE_COMPANY_NAME, CommonUtils.getCompanyShortName(bean.getCompanyId()));
		e.setValue(OnWrokflowProcess.LINE_AMOUNT_NAME, bean.getAmount());
		CompanyRecord cr = new CompanyRecord();
		if(bean.getCompanyId()>0){
			cr.setCompanyRecordId(bean.getCompanyId());
			cr.load();
		}
		if(expression.contains(StaticUtils.BELONGING_COMPANY)){
			if(BaseHelpUtils.isNullOrEmpty(cr)){
				e.setValue(StaticUtils.BELONGING_COMPANY,"");
			}else{
				e.setValue(StaticUtils.BELONGING_COMPANY,cr.getCompanyName());
			}
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		TravelReimbursementWithTt dao = new TravelReimbursementWithTt();
		dao.setTravelReimbursementId(businessId);
		dao.load(true);
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getAttachmentId()));
		return dao.generateBaseExt().toJSON();
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if (BaseHelpUtils.getIntValue(roleId) == StaticUtils.ROLE_MAIN_PROJECT_MANAGER) {// 项目经理
			Set<Integer> ownerSet = new HashSet<>();
			List<BaseTravelReimbursementLinkMainProject> list = bean.getDetailTravelReimbursementLinkMainProject();
			if (list == null || list.isEmpty()) {
				throw new SQLException("请选择一个项目！");
			}

			for (BaseTravelReimbursementLinkMainProject b : list) {
				Integer projectId = b.getMainProjectId();
				if (projectId == null) {
					throw new SQLException("请选择一个项目！");
				}
				PreProjectReimbursementNumber dao = new PreProjectReimbursementNumber();
				dao.unsetSelectFlags();
				dao.setSelectCustomNumber(true);
				dao.setSelectProjectManager(true);
				dao.setConditionPreProjectReimbursementNumberId("=",projectId);
				BasePreProjectReimbursementNumber basePreProjectRe=dao.executeQueryOneRow();
				if (!BaseHelpUtils.isNullOrEmpty(basePreProjectRe)) {
						ownerSet.add(dao.getProjectManager());
				}
			}
			if (!ownerSet.isEmpty()) {
				Employee e = new Employee();
				e.unsetSelectFlags();
				e.setSelectEmployeeId(true);
				e.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
				e.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", ownerSet.toArray());
				List<BaseEmployee> employeeList = e.conditionalLoad();
				int length = employeeList.size();
				int[] activityOwners = new int[length];
				for (int i = 0; i < length; i++) {
					activityOwners[i] = BaseHelpUtils.getIntValue(employeeList.get(i).getEmployeeId());
				}
				return activityOwners;
			}
			return new int[0];
		}else {
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}
	}

	public void dataValidate(TravelReimbursementWithTt dao) throws Exception {
		if (BaseHelpUtils.isNullOrEmpty(dao.getTitle())) {
			throw new Exception("请填写主题");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getDrafter())) {
			throw new Exception("起草人有误");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getApplicant())) {
			throw new Exception("请选择报销人");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getEndDate()) || BaseHelpUtils.isNullOrEmpty(dao.getStartDate())) {
			throw new Exception("开始日期/结束日期 未选");
		} else {
			if (dao.getEndDate().getTime() - dao.getStartDate().getTime() < 0) {
				throw new Exception("出差结束日期必须大于等于开始日期");
			}
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
		if(BaseHelpUtils.getBoolean(dao.getRelatedToContract())) {
			if(BaseHelpUtils.isNullOrEmpty(dao.getContractAmount())) {
				throw new Exception("请填写合同金额");
			}
			if(BaseHelpUtils.isNullOrEmpty(dao.getReceiveUnitId())) {
				throw new Exception("请选择供应商");
			}
			if(BaseHelpUtils.isNullOrEmpty(dao.getPurchaserDepartment())) {
				throw new Exception("请选择采购人归属部门");
			}
			if(BaseHelpUtils.isNullOrEmpty(dao.getPurchaser())) {
				throw new Exception("请选择采购人");
			}
			if(BaseHelpUtils.isNullOrEmpty(dao.getPurchasingCategory())) {
				throw new Exception("请填写采购类别");
			}
		}else {
			dao.setContractAmount(null);
			dao.setReceiveUnitId(null);
			dao.setPurchaserDepartment(null);
			dao.setPurchaser(null);
			dao.setPurchasingCategory(null);
		}
		List<BaseTravelReimbursementDetail> travelReimbursementDetailList = dao.getDetailTravelReimbursementDetail();
		if (null == travelReimbursementDetailList || travelReimbursementDetailList.isEmpty()) {
			throw new Exception("请填写差旅报销明细");
		}
		List<BaseTravelReimbursementLinkMainProject> travelReimbursementLinkMainProjectList = dao
				.getDetailTravelReimbursementLinkMainProject();
		if (null == travelReimbursementLinkMainProjectList || travelReimbursementLinkMainProjectList.isEmpty()) {
			throw new Exception("请添加需要承担本次报销金额的项目");
		}
		BigDecimal sum = BigDecimal.ZERO;
		BigDecimal inputTaxAndFinalAmount = BigDecimal.ZERO;
		for (BaseTravelReimbursementLinkMainProject obj : travelReimbursementLinkMainProjectList) {
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
