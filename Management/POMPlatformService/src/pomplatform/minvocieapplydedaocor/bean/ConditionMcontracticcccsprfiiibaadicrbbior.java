package pomplatform.minvocieapplydedaocor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcontracticcccsprfiiibaadicrbbior extends GenericCondition{

	public ConditionMcontracticcccsprfiiibaadicrbbior(){
		setParameterCount(21);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getFlowStatus() {
		return this.__flow_status;
	}

	public void setFlowStatus( java.lang.Integer value ) {
		this.__flow_status = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Boolean getIsSystemAdd() {
		return this.__is_system_add;
	}

	public void setIsSystemAdd( java.lang.Boolean value ) {
		this.__is_system_add = value;
	}

	public java.lang.Boolean getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Boolean value ) {
		this.__is_finish = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getApplyRemark() {
		return this.__apply_remark == null ? null : (this.__apply_remark.indexOf("%") >= 0 ? this.__apply_remark : "%"+this.__apply_remark+"%");
	}

	public void setApplyRemark( java.lang.String value ) {
		this.__apply_remark = value;
	}

	public java.lang.Integer getApplicantId() {
		return this.__applicant_id;
	}

	public void setApplicantId( java.lang.Integer value ) {
		this.__applicant_id = value;
	}

	public java.lang.String getDutyParagraph() {
		return this.__duty_paragraph == null ? null : (this.__duty_paragraph.indexOf("%") >= 0 ? this.__duty_paragraph : "%"+this.__duty_paragraph+"%");
	}

	public void setDutyParagraph( java.lang.String value ) {
		this.__duty_paragraph = value;
	}

	public java.lang.String getIaCustomerName() {
		return this.__ia_customer_name == null ? null : (this.__ia_customer_name.indexOf("%") >= 0 ? this.__ia_customer_name : "%"+this.__ia_customer_name+"%");
	}

	public void setIaCustomerName( java.lang.String value ) {
		this.__ia_customer_name = value;
	}

	public java.lang.String getCustomerPhone() {
		return this.__customer_phone == null ? null : (this.__customer_phone.indexOf("%") >= 0 ? this.__customer_phone : "%"+this.__customer_phone+"%");
	}

	public void setCustomerPhone( java.lang.String value ) {
		this.__customer_phone = value;
	}

	public java.lang.String getRegisteredAddress() {
		return this.__registered_address == null ? null : (this.__registered_address.indexOf("%") >= 0 ? this.__registered_address : "%"+this.__registered_address+"%");
	}

	public void setRegisteredAddress( java.lang.String value ) {
		this.__registered_address = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name == null ? null : (this.__bank_name.indexOf("%") >= 0 ? this.__bank_name : "%"+this.__bank_name+"%");
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account == null ? null : (this.__bank_account.indexOf("%") >= 0 ? this.__bank_account : "%"+this.__bank_account+"%");
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.Integer getInvoiceApplyStatus() {
		return this.__invoice_apply_status;
	}

	public void setInvoiceApplyStatus( java.lang.Integer value ) {
		this.__invoice_apply_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getFlowStatus() != null) sb.append(__wrapNumber(1, "flowStatus", getFlowStatus()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getIsSystemAdd() != null) sb.append(__wrapBoolean(1, "isSystemAdd", getIsSystemAdd()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(1, "isFinish", getIsFinish()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		if(getApplyRemark() != null) sb.append(__wrapString(1, "applyRemark", getApplyRemark()));
		if(getApplicantId() != null) sb.append(__wrapNumber(1, "applicantId", getApplicantId()));
		if(getDutyParagraph() != null) sb.append(__wrapString(1, "dutyParagraph", getDutyParagraph()));
		if(getIaCustomerName() != null) sb.append(__wrapString(1, "iaCustomerName", getIaCustomerName()));
		if(getCustomerPhone() != null) sb.append(__wrapString(1, "customerPhone", getCustomerPhone()));
		if(getRegisteredAddress() != null) sb.append(__wrapString(1, "registeredAddress", getRegisteredAddress()));
		if(getBankName() != null) sb.append(__wrapString(1, "bankName", getBankName()));
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		if(getInvoiceApplyStatus() != null) sb.append(__wrapNumber(1, "invoiceApplyStatus", getInvoiceApplyStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("flowStatus")) != null) setFlowStatus(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("isSystemAdd")) != null) setIsSystemAdd(__getBoolean(val));
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("applyRemark")) != null) setApplyRemark(__getString(val));
		if((val = values.get("applicantId")) != null) setApplicantId(__getInt(val)); 
		if((val = values.get("dutyParagraph")) != null) setDutyParagraph(__getString(val));
		if((val = values.get("iaCustomerName")) != null) setIaCustomerName(__getString(val));
		if((val = values.get("customerPhone")) != null) setCustomerPhone(__getString(val));
		if((val = values.get("registeredAddress")) != null) setRegisteredAddress(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("invoiceApplyStatus")) != null) setInvoiceApplyStatus(__getInt(val)); 
	}

	private java.lang.Integer __contract_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.String __customer_name = null;
	private java.lang.Integer __status = null;
	private java.lang.String __project_code = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __flow_status = null;
	private java.lang.String __info_code = null;
	private java.lang.Boolean __is_system_add = null;
	private java.lang.Boolean __is_finish = null;
	private java.lang.String __business_type = null;
	private java.lang.String __apply_remark = null;
	private java.lang.Integer __applicant_id = null;
	private java.lang.String __duty_paragraph = null;
	private java.lang.String __ia_customer_name = null;
	private java.lang.String __customer_phone = null;
	private java.lang.String __registered_address = null;
	private java.lang.String __bank_name = null;
	private java.lang.String __bank_account = null;
	private java.lang.Integer __invoice_apply_status = null;
}

