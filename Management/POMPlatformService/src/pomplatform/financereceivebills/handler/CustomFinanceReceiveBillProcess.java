package pomplatform.financereceivebills.handler;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseFinanceReceiveBill;
import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.FinanceReceiveBill;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.TravelReimbursement;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;

/**
 * 
 * @author CL
 *
 */
public class CustomFinanceReceiveBillProcess implements GenericProcessor {

	private final static String CHANGE_BILL_STATUS = "changeBillStatus";// 改变收单状态
	
	private final static String GET_INFO_BY_BARCODE_TOADD = "getInfoByBarcodeToadd";//根据条形码获取报销单信息并且记录收单
	
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	
	/**
	 * 已收
	 */
	private final static Integer STATUS_1 = 1; 
	/**
	 * 退回
	 */
	private final static Integer STATUS_2 = 2; 
	/**
	 * 转交
	 */
	private final static Integer STATUS_3 = 3;
	/**
	 * 待补正资料
	 */
	private final static Integer STATUS_4 = 4; 

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case CHANGE_BILL_STATUS:
				return changeBillStatus(result);
			case GET_INFO_BY_BARCODE_TOADD:
				return getInfoByBarcodeToadd(result);
			}
		}
		return null;
	}
	
	public static String getInfoByBarcodeToadd(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMsg = null;
		String barCode = BaseHelpUtils.getStringValue(params, "barCode");
		String departmentName = BaseHelpUtils.getStringValue(params, "departmentName");
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
		Employee eDao = new Employee();
		eDao.setEmployeeId(employeeId);
		BaseCollection<BaseFinanceReceiveBill> bc = new BaseCollection<>();
		if(barCode.length() == 13 && eDao.load()){
			
			String employeeName = eDao.getEmployeeName();
			boolean flag = true;
			List<BaseFinanceReceiveBill> list = new ArrayList<>();
			BaseFinanceReceiveBill bean = new BaseFinanceReceiveBill();
			//获取报销编号
			String code = barCode.substring(0, 6) + "-" + barCode.substring(7, 12);
			Date currentDate = new Date();
			//检测该单是否已经录入
			FinanceReceiveBill frbDao = new FinanceReceiveBill();
			frbDao.setConditionCode("=", code);
			
			String detailRemark = "(" + sdf.format(currentDate) + ")" + employeeName + "已收;";
			if(null != frbDao.executeQueryOneRow()){
				if(frbDao.getReceiveStatus() == STATUS_1){
					if(!Objects.equals(employeeId, frbDao.getHandlePerson())){
						frbDao.setHandlePerson(employeeId);
						frbDao.setUpdateTime(currentDate);
						frbDao.setDetailRemark(frbDao.getDetailRemark() + detailRemark);
						frbDao.update();
					}
				}else{
					frbDao.setReceiveStatus(STATUS_1);
					frbDao.setUpdateTime(currentDate);
					frbDao.setDetailRemark(frbDao.getDetailRemark() + detailRemark);
					frbDao.update();
				}
			}else{
				Integer applicant = null;
				//寻找报销单
				if(flag){//日常中寻找
					ProjectNormalReimbursement pnrDao = new ProjectNormalReimbursement();
					pnrDao.setConditionCode("=", code);
					if(null != pnrDao.executeQueryOneRow()){
						flag = false;
						applicant = pnrDao.getApplyEmployeeId();
						bean.setAmount(pnrDao.getAmount());
						bean.setApplicant(applicant);
						bean.setBusinessId(pnrDao.getProjectNormalReimbursementId());
						bean.setDepartmentId(pnrDao.getDepartmentId());
						bean.setCompanyId(pnrDao.getCompanyId());
						SystemProcessInstance spiDao = new SystemProcessInstance();
						spiDao.setConditionBusinessId("=", pnrDao.getProjectNormalReimbursementId());
						spiDao.addCondition(BaseSystemProcessInstance.CS_PROCESS_TYPE, "in", StaticUtils.PROCESS_TYPE_2, 
								StaticUtils.PROCESS_TYPE_3, StaticUtils.PROCESS_TYPE_8);
						if(null != spiDao.executeQueryOneRow()){
							bean.setProcessType(spiDao.getProcessType());
						}
					}
				}
				if(flag){//差旅
					TravelReimbursement trDao = new TravelReimbursement();
					trDao.setConditionCode("=", code);
					if(null != trDao.executeQueryOneRow()){
						flag = false;
						applicant = trDao.getApplicant();
						bean.setAmount(trDao.getAmount());
						bean.setApplicant(applicant);
						bean.setBusinessId(trDao.getTravelReimbursementId());
						bean.setCompanyId(trDao.getCompanyId());
						bean.setDepartmentId(trDao.getDepartmentId());
						SystemProcessInstance spiDao = new SystemProcessInstance();
						spiDao.setConditionBusinessId("=", trDao.getTravelReimbursementId());
						spiDao.addCondition(BaseSystemProcessInstance.CS_PROCESS_TYPE, "in", StaticUtils.PROCESS_TYPE_4, 
								StaticUtils.PROCESS_TYPE_5, StaticUtils.PROCESS_TYPE_9);
						if(null != spiDao.executeQueryOneRow()){
							bean.setProcessType(spiDao.getProcessType());
						}
					}
				}
				if(flag){//预付
					PayMoneyManage pmmDao = new PayMoneyManage();
					pmmDao.setConditionCode("=", code);
					if(null != pmmDao.executeQueryOneRow()){
						flag = false;
						applicant = pmmDao.getEmployeeId();
						bean.setApplicant(applicant);
						bean.setAmount(pmmDao.getPayAmount());
						bean.setProcessType(StaticUtils.PROCESS_TYPE_7);
						bean.setBusinessId(pmmDao.getPayMoneyManageId());
						bean.setDepartmentId(pmmDao.getCompanyId());
						bean.setCompanyId(pmmDao.getCompanyId());
					}
				}
				if(flag){//借款
					EmployeeMoneyManage emmDao = new EmployeeMoneyManage();
					emmDao.setConditionCode("=", code);
					if(null != emmDao.executeQueryOneRow()){
						flag = false;
						applicant = emmDao.getEmployeeId();
						bean.setApplicant(applicant);
						bean.setAmount(emmDao.getBorrowMoney());
						bean.setProcessType(StaticUtils.PROCESS_TYPE_6);
						bean.setBusinessId(emmDao.getEmployeeMoneyManageId());
						bean.setDepartmentId(emmDao.getCompanyId());
						bean.setCompanyId(emmDao.getCompanyId());
					}
				}
				if(null != bean.getProcessType() && null != bean.getBusinessId()){
					// 检测是否该单到财务会计
					SystemProcessInstanceActivity spiaDao = new SystemProcessInstanceActivity();
					spiaDao.setConditionProcessType("=", bean.getProcessType());
					spiaDao.setConditionBusinessId("=", bean.getBusinessId());
					spiaDao.setConditionStatus("=", 1);
					if(null != spiaDao.executeQueryOneRow()) {
						if(null != spiaDao.getBackViewName()) {
							if(spiaDao.getBackViewName().contains("财务会计")) {
								bean.setCode(code);
								bean.setDetailRemark(detailRemark);
								bean.setSendee(employeeId);
								bean.setHandlePerson(employeeId);
								bean.setCreateTime(currentDate);
								bean.setUpdateTime(currentDate);
								bean.setReceiveStatus(STATUS_1);
								frbDao.setDataFromBase(bean);
								frbDao.save();
							} else {
								status = -1;
								errorMsg = String.format("单号(%1$s)现在处于(%2$s)审批,未处于[财务会计]审批,无法收单", code, spiaDao.getBackViewName());
							}
						}else {
							status = -1;
							errorMsg = "该单未处于财务会计审批,无法收单";
						}
					}
				}else{
					status = -1;
					errorMsg = String.format("根据单号(%1$s)没有找到报销单", code);
				}
				if(status >= 0 && null != applicant){
					StringBuilder sb = new StringBuilder();
					sb.append("您申请的报销单：").append(code).append(" ").append(departmentName).append("（").append(employeeName)
					.append("）已于").append(sdf.format(currentDate)).append("接收纸质单据。谢谢！");
					ERPWeixinUtils.sendWXMsgToUser(applicant, sb.toString());
				}
			}
			list.add(bean);
			bc.setCollections(list);
		}else{
			status = -1;
			errorMsg = String.format("条形码数据错误 barCode = %1$s", barCode);
		}
		return bc.toJSON(status, errorMsg);
	}

	private String changeBillStatus(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMsg = null;
		int billStatus = BaseHelpUtils.getIntValue(params, "billStatus");
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
		int toEmployeeId = BaseHelpUtils.getIntValue(params, "toEmployeeId");
//		int financeReceiveBillId = BaseHelpUtils.getIntValue(params, "financeReceiveBillId");
		String financeReceiveBillIds = BaseHelpUtils.getStringValue(params, "financeReceiveBillIds");
		String departmentName = BaseHelpUtils.getStringValue(params, "departmentName");
		FinanceReceiveBill frDao = new FinanceReceiveBill();
		List<BaseFinanceReceiveBill> list = frDao.conditionalLoad(BaseFinanceReceiveBill.CS_FINANCE_RECEIVE_BILL_ID 
				+ " in (" + financeReceiveBillIds +" )");
//		frDao.setFinanceReceiveBillId(financeReceiveBillId);
		Employee eDao = new Employee();
		Date currentDate = new Date();
		eDao.setEmployeeId(employeeId);
		if(list.size() > 0 && billStatus > 0 && eDao.load()){
			StringBuilder sb = new StringBuilder();
			for (BaseFinanceReceiveBill baseFinanceReceiveBill : list) {
				frDao.clear();
				frDao.setFinanceReceiveBillId(baseFinanceReceiveBill.getFinanceReceiveBillId());
				frDao.load();
				String detailRemark = "";
				sb.append("您申请的报销单：").append(frDao.getCode()).append(" ");
				String employeeName = eDao.getEmployeeName();
				if(billStatus == STATUS_1){
					sb.append(departmentName).append("（").append(employeeName).append("）已于").append(sdf.format(currentDate)).append("接收纸质单据。谢谢！");
					detailRemark = "(" + sdf.format(currentDate) + ")" + employeeName + "已收;";
				}else if(billStatus == STATUS_2){
					if(toEmployeeId > 0){
						eDao.clear();
						eDao.setEmployeeId(toEmployeeId);
						eDao.load();
						String toEmployeeName = eDao.getEmployeeName();
						sb.append(departmentName).append("（").append(employeeName).append("）已于").append(sdf.format(currentDate)).append("退回给").append("（").append(toEmployeeName).append("）。谢谢！");
						detailRemark = "(" + sdf.format(currentDate) + ")退回给" + toEmployeeName + ";";
					}else{
						status = -1;
						errorMsg = String.format("退回人employeeId = %1$s 不存在", toEmployeeId) + ";";
					}
				}else if(billStatus == STATUS_3){
					if(toEmployeeId > 0){
						eDao.clear();
						eDao.setEmployeeId(toEmployeeId);
						eDao.load();
						String toEmployeeName = eDao.getEmployeeName();
						sb.append(departmentName).append("（").append(employeeName).append("）已于").append(sdf.format(currentDate)).append("转交给（").append(toEmployeeName).append("）处理。谢谢！");
						detailRemark = "(" + sdf.format(currentDate) + ")转交给" + toEmployeeName + ";";
					}else{
						status = -1;
						errorMsg = String.format("转交人employeeId = %1$s 不存在", toEmployeeId) + ";";
					}
				}else if(billStatus == STATUS_4){
					detailRemark = "(" + sdf.format(currentDate) + ")待补正资料;";
				}
				frDao.setReceiveStatus(billStatus);
				frDao.setDetailRemark(frDao.getDetailRemark() + detailRemark);
				frDao.update();
				if(status >= 0 && billStatus != STATUS_4.intValue()){
					ERPWeixinUtils.sendWXMsgToUser(frDao.getApplicant(), sb.toString());
				}
			}
			
		}else{
			status = -1;
			errorMsg = "数据错误";
		}
		
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}
	
}
