package pomplatform.attachment.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeeaaccadpppccor extends GenericBase implements BaseFactory<BaseMemployeeaaccadpppccor>, Comparable<BaseMemployeeaaccadpppccor> 
{


	public static BaseMemployeeaaccadpppccor newInstance(){
		return new BaseMemployeeaaccadpppccor();
	}

	@Override
	public BaseMemployeeaaccadpppccor make(){
		BaseMemployeeaaccadpppccor b = new BaseMemployeeaaccadpppccor();
		return b;
	}

	public final static java.lang.String CS_ATTACHMENT_MANAGE_ID = "attachment_manage_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_ATTACHMENT_CODE = "attachment_code" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_ATTACHMENT_ADDRESS = "attachment_address" ;
	public final static java.lang.String CS_PERFESSION_REMARK = "perfession_remark" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_RETURN_AMOUNT = "return_amount" ;
	public final static java.lang.String CS_PAYMENT_SURE = "payment_sure" ;
	public final static java.lang.String CS_PAYMENT_GRADE_DESCRIPTION = "payment_grade_description" ;
	public final static java.lang.String CS_SERIAL_NUMBER = "serial_number" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_SUPER_PROJECT_MANAGE_ID = "super_project_manage_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_HAVE_VOUCHER = "have_voucher" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_EMPLOYEE_NAME_STR = "employee_name_str" ;
	public final static java.lang.String CS_FINANCE_REMARK = "finance_remark";
	public final static java.lang.String CS_CAN_RECEIVED_PAYMENT = "can_received_payment";
	public final static java.lang.String CS_RESIDUAL_RECEIPTS = "residual_receipts";

	public final static java.lang.String ALL_CAPTIONS = "合同名称,合同编号,金额,回款金额,会议备注,本月能否收款,本月回款金额(预测),确认函名称,项目负责人,大项目负责人,负责总监,记录日期";

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getAttachmentCode() {
		return this.__attachment_code;
	}

	public void setAttachmentCode( java.lang.String value ) {
		this.__attachment_code = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.String getAttachmentAddress() {
		return this.__attachment_address;
	}

	public void setAttachmentAddress( java.lang.String value ) {
		this.__attachment_address = value;
	}

	public java.lang.String getPerfessionRemark() {
		return this.__perfession_remark;
	}

	public void setPerfessionRemark( java.lang.String value ) {
		this.__perfession_remark = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getReturnAmount() {
		return this.__return_amount;
	}

	public void setReturnAmount( java.math.BigDecimal value ) {
		this.__return_amount = value;
	}

	public java.lang.Boolean getPaymentSure() {
		return this.__payment_sure;
	}

	public void setPaymentSure( java.lang.Boolean value ) {
		this.__payment_sure = value;
	}

	public java.lang.String getPaymentGradeDescription() {
		return this.__payment_grade_description;
	}

	public void setPaymentGradeDescription( java.lang.String value ) {
		this.__payment_grade_description = value;
	}

	public java.lang.Integer getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( java.lang.Integer value ) {
		this.__serial_number = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getSuperProjectManageId() {
		return this.__super_project_manage_id;
	}

	public void setSuperProjectManageId( java.lang.Integer value ) {
		this.__super_project_manage_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Boolean getHaveVoucher() {
		return this.__have_voucher;
	}

	public void setHaveVoucher( java.lang.Boolean value ) {
		this.__have_voucher = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getEmployeeNameStr() {
		return this.__employee_name_str;
	}

	public void setEmployeeNameStr( java.lang.String value ) {
		this.__employee_name_str = value;
	}

	public java.lang.String getFinanceRemark() {
		return __finance_remark;
	}

	public void setFinanceRemark(java.lang.String value) {
		this.__finance_remark = value;
	}

	public java.lang.Boolean getCanReceivedPayment() {
		return __can_received_payment;
	}

	public void setCanReceivedPayment(java.lang.Boolean value) {
		this.__can_received_payment = value;
	}

	public java.math.BigDecimal getResidualReceipts() {
		return __residual_receipts;
	}

	public void setResidualReceipts(java.math.BigDecimal value) {
		this.__residual_receipts = value;
	}

	public void cloneCopy(BaseMemployeeaaccadpppccor __bean){
		__bean.setAttachmentManageId(getAttachmentManageId());
		__bean.setContractId(getContractId());
		__bean.setAttachmentCode(getAttachmentCode());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setAttachmentAddress(getAttachmentAddress());
		__bean.setPerfessionRemark(getPerfessionRemark());
		__bean.setAmount(getAmount());
		__bean.setReturnAmount(getReturnAmount());
		__bean.setPaymentSure(getPaymentSure());
		__bean.setPaymentGradeDescription(getPaymentGradeDescription());
		__bean.setSerialNumber(getSerialNumber());
		__bean.setRecordDate(getRecordDate());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setSuperProjectManageId(getSuperProjectManageId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setHaveVoucher(getHaveVoucher());
		__bean.setContractName(getContractName());
		__bean.setContractCode(getContractCode());
		__bean.setEmployeeNameStr(getEmployeeNameStr());
		__bean.setFinanceRemark(getFinanceRemark());
		__bean.setCanReceivedPayment(getCanReceivedPayment());
		__bean.setResidualReceipts(getResidualReceipts());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getReturnAmount() == null ? "" : getReturnAmount());
		sb.append(",");
		sb.append(getFinanceRemark() == null ? "" : getFinanceRemark().replace("，", ","));
		sb.append(",");
		sb.append(getCanReceivedPayment() == null ? "" : getCanReceivedPayment() ? "能" : "不能");
		sb.append(",");
		sb.append(getResidualReceipts() == null ? "" : getResidualReceipts());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		String strProjectManageId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManageId()));
		String strSuperProjectManageId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getSuperProjectManageId()));
		sb.append(strProjectManageId == null ? "" : strProjectManageId);
		sb.append(",");
		sb.append(strSuperProjectManageId == null ? "" : strSuperProjectManageId);
		sb.append(",");
		sb.append(getEmployeeNameStr() == null ? "" : getEmployeeNameStr());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeeaaccadpppccor o) {
		return __attachment_manage_id == null ? -1 : __attachment_manage_id.compareTo(o.getAttachmentManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__attachment_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_code);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__attachment_address);
		hash = 97 * hash + Objects.hashCode(this.__perfession_remark);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__return_amount);
		hash = 97 * hash + Objects.hashCode(this.__payment_sure);
		hash = 97 * hash + Objects.hashCode(this.__payment_grade_description);
		hash = 97 * hash + Objects.hashCode(this.__serial_number);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__super_project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__have_voucher);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_str);
		hash = 97 * hash + Objects.hashCode(this.__finance_remark);
		hash = 97 * hash + Objects.hashCode(this.__can_received_payment);
		hash = 97 * hash + Objects.hashCode(this.__residual_receipts);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeeaaccadpppccor o = (BaseMemployeeaaccadpppccor)obj;
		if(!Objects.equals(this.__attachment_manage_id, o.getAttachmentManageId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__attachment_code, o.getAttachmentCode())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__attachment_address, o.getAttachmentAddress())) return false;
		if(!Objects.equals(this.__perfession_remark, o.getPerfessionRemark())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__return_amount, o.getReturnAmount())) return false;
		if(!Objects.equals(this.__payment_sure, o.getPaymentSure())) return false;
		if(!Objects.equals(this.__payment_grade_description, o.getPaymentGradeDescription())) return false;
		if(!Objects.equals(this.__serial_number, o.getSerialNumber())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__super_project_manage_id, o.getSuperProjectManageId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__have_voucher, o.getHaveVoucher())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__employee_name_str, o.getEmployeeNameStr())) return false;
		if(!Objects.equals(this.__finance_remark, o.getFinanceRemark())) return false;
		if(!Objects.equals(this.__can_received_payment, o.getCanReceivedPayment())) return false;
		if(!Objects.equals(this.__residual_receipts, o.getResidualReceipts())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(count++, "attachmentManageId", getAttachmentManageId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getAttachmentCode() != null) sb.append(__wrapString(count++, "attachmentCode", getAttachmentCode()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getAttachmentAddress() != null) sb.append(__wrapString(count++, "attachmentAddress", getAttachmentAddress()));
		if(getPerfessionRemark() != null) sb.append(__wrapString(count++, "perfessionRemark", getPerfessionRemark()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getReturnAmount() != null) sb.append(__wrapDecimal(count++, "returnAmount", getReturnAmount()));
		if(getPaymentSure() != null) sb.append(__wrapBoolean(count++, "paymentSure", getPaymentSure()));
		if(getPaymentGradeDescription() != null) sb.append(__wrapString(count++, "paymentGradeDescription", getPaymentGradeDescription()));
		if(getSerialNumber() != null) sb.append(__wrapNumber(count++, "serialNumber", getSerialNumber()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getSuperProjectManageId() != null) sb.append(__wrapNumber(count++, "superProjectManageId", getSuperProjectManageId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getHaveVoucher() != null) sb.append(__wrapBoolean(count++, "haveVoucher", getHaveVoucher()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getEmployeeNameStr() != null) sb.append(__wrapString(count++, "employeeNameStr", getEmployeeNameStr()));
		if(getFinanceRemark() != null) sb.append(__wrapString(count++, "financeRemark", getFinanceRemark()));
		if(getCanReceivedPayment() != null) sb.append(__wrapBoolean(count++, "canReceivedPayment", getCanReceivedPayment()));
		if(getResidualReceipts() != null) sb.append(__wrapDecimal(count++, "residualReceipts", getResidualReceipts()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("attachmentCode")) != null) setAttachmentCode(__getString(val));
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("attachmentAddress")) != null) setAttachmentAddress(__getString(val));
		if((val = values.get("perfessionRemark")) != null) setPerfessionRemark(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("returnAmount")) != null) setReturnAmount(__getDecimal(val));  
		if((val = values.get("paymentSure")) != null) setPaymentSure(__getBoolean(val));
		if((val = values.get("paymentGradeDescription")) != null) setPaymentGradeDescription(__getString(val));
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("superProjectManageId")) != null) setSuperProjectManageId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("haveVoucher")) != null) setHaveVoucher(__getBoolean(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("employeeNameStr")) != null) setEmployeeNameStr(__getString(val));
		if((val = values.get("financeRemark")) != null) setFinanceRemark(__getString(val));
		if((val = values.get("canReceivedPayment")) != null) setCanReceivedPayment(__getBoolean(val));
		if((val = values.get("residualReceipts")) != null) setResidualReceipts(__getDecimal(val));  
	}

	protected java.lang.Integer  __attachment_manage_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __attachment_code ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.String  __attachment_address ;
	protected java.lang.String  __perfession_remark ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __return_amount ;
	protected java.lang.Boolean  __payment_sure ;
	protected java.lang.String  __payment_grade_description ;
	protected java.lang.Integer  __serial_number ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __super_project_manage_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Boolean  __have_voucher ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __employee_name_str ;
	protected java.lang.String  __finance_remark;
	protected java.lang.Boolean  __can_received_payment;
	protected java.math.BigDecimal  __residual_receipts;
}
