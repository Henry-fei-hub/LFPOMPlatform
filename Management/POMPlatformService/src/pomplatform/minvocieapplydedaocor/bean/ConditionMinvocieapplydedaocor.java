package pomplatform.minvocieapplydedaocor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMinvocieapplydedaocor extends GenericCondition{

	public ConditionMinvocieapplydedaocor(){
		setParameterCount(22);
	}

	public java.util.Date getMinOperatorTime() {
		return this.__min_operator_time;
	}

	public void setMinOperatorTime( java.util.Date value ) {
		this.__min_operator_time = value;
	}

	public java.util.Date getMaxOperatorTime() {
		return this.__max_operator_time;
	}

	public void setMaxOperatorTime( java.util.Date value ) {
		this.__max_operator_time = value;
	}

	public java.util.Date getMinApplyTime() {
		return this.__min_apply_time;
	}

	public void setMinApplyTime( java.util.Date value ) {
		this.__min_apply_time = value;
	}

	public java.util.Date getMaxApplyTime() {
		return this.__max_apply_time;
	}

	public void setMaxApplyTime( java.util.Date value ) {
		this.__max_apply_time = value;
	}

	public java.lang.Integer getInvoiceApplyId() {
		return this.__invoice_apply_id;
	}

	public void setInvoiceApplyId( java.lang.Integer value ) {
		this.__invoice_apply_id = value;
	}

	public java.lang.Integer getApplicantDeparmentId() {
		return this.__applicant_deparment_id;
	}

	public void setApplicantDeparmentId( java.lang.Integer value ) {
		this.__applicant_deparment_id = value;
	}

	public java.lang.String getApplicantName() {
		return this.__applicant_name == null ? null : (this.__applicant_name.indexOf("%") >= 0 ? this.__applicant_name : "%"+this.__applicant_name+"%");
	}

	public void setApplicantName( java.lang.String value ) {
		this.__applicant_name = value;
	}

	public java.lang.String getOperatorName() {
		return this.__operator_name == null ? null : (this.__operator_name.indexOf("%") >= 0 ? this.__operator_name : "%"+this.__operator_name+"%");
	}

	public void setOperatorName( java.lang.String value ) {
		this.__operator_name = value;
	}

	public java.lang.Integer getApplicantId() {
		return this.__applicant_id;
	}

	public void setApplicantId( java.lang.Integer value ) {
		this.__applicant_id = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.String getDepartmentName() {
		return this.__department_name == null ? null : (this.__department_name.indexOf("%") >= 0 ? this.__department_name : "%"+this.__department_name+"%");
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
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

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
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

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
	}

	public java.lang.Integer getInvoiceApplyStatus() {
		return this.__invoice_apply_status;
	}

	public void setInvoiceApplyStatus( java.lang.Integer value ) {
		this.__invoice_apply_status = value;
	}

	public java.lang.String getDutyParagraph() {
		return this.__duty_paragraph == null ? null : (this.__duty_paragraph.indexOf("%") >= 0 ? this.__duty_paragraph : "%"+this.__duty_paragraph+"%");
	}

	public void setDutyParagraph( java.lang.String value ) {
		this.__duty_paragraph = value;
	}

	public java.lang.String getApplyRemark() {
		return this.__apply_remark == null ? null : (this.__apply_remark.indexOf("%") >= 0 ? this.__apply_remark : "%"+this.__apply_remark+"%");
	}

	public void setApplyRemark( java.lang.String value ) {
		this.__apply_remark = value;
	}

	public java.lang.String getOperatorRemark() {
		return this.__operator_remark == null ? null : (this.__operator_remark.indexOf("%") >= 0 ? this.__operator_remark : "%"+this.__operator_remark+"%");
	}

	public void setOperatorRemark( java.lang.String value ) {
		this.__operator_remark = value;
	}

	public java.lang.String getCompanyName() {
		return this.__company_name == null ? null : (this.__company_name.indexOf("%") >= 0 ? this.__company_name : "%"+this.__company_name+"%");
	}

	public void setCompanyName( java.lang.String value ) {
		this.__company_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinOperatorTime() != null) sb.append(__wrapDate(1, "minOperatorTime", getMinOperatorTime()));
		if(getMaxOperatorTime() != null) sb.append(__wrapDate(1, "maxOperatorTime", getMaxOperatorTime()));
		if(getMinApplyTime() != null) sb.append(__wrapDate(1, "minApplyTime", getMinApplyTime()));
		if(getMaxApplyTime() != null) sb.append(__wrapDate(1, "maxApplyTime", getMaxApplyTime()));
		if(getInvoiceApplyId() != null) sb.append(__wrapNumber(1, "invoiceApplyId", getInvoiceApplyId()));
		if(getApplicantDeparmentId() != null) sb.append(__wrapNumber(1, "applicantDeparmentId", getApplicantDeparmentId()));
		if(getApplicantName() != null) sb.append(__wrapString(1, "applicantName", getApplicantName()));
		if(getOperatorName() != null) sb.append(__wrapString(1, "operatorName", getOperatorName()));
		if(getApplicantId() != null) sb.append(__wrapNumber(1, "applicantId", getApplicantId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(1, "operatorId", getOperatorId()));
		if(getDepartmentName() != null) sb.append(__wrapString(1, "departmentName", getDepartmentName()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getBankName() != null) sb.append(__wrapString(1, "bankName", getBankName()));
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(1, "invoiceType", getInvoiceType()));
		if(getInvoiceApplyStatus() != null) sb.append(__wrapNumber(1, "invoiceApplyStatus", getInvoiceApplyStatus()));
		if(getDutyParagraph() != null) sb.append(__wrapString(1, "dutyParagraph", getDutyParagraph()));
		if(getApplyRemark() != null) sb.append(__wrapString(1, "applyRemark", getApplyRemark()));
		if(getOperatorRemark() != null) sb.append(__wrapString(1, "operatorRemark", getOperatorRemark()));
		if(getCompanyName() != null) sb.append(__wrapString(1, "companyName", getCompanyName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minOperatorTime")) != null) setMinOperatorTime(__getDate(val)); 
		if((val = values.get("maxOperatorTime")) != null) setMaxOperatorTime(__getDate(val)); 
		if((val = values.get("minApplyTime")) != null) setMinApplyTime(__getDate(val)); 
		if((val = values.get("maxApplyTime")) != null) setMaxApplyTime(__getDate(val)); 
		if((val = values.get("invoiceApplyId")) != null) setInvoiceApplyId(__getInt(val)); 
		if((val = values.get("applicantDeparmentId")) != null) setApplicantDeparmentId(__getInt(val)); 
		if((val = values.get("applicantName")) != null) setApplicantName(__getString(val));
		if((val = values.get("operatorName")) != null) setOperatorName(__getString(val));
		if((val = values.get("applicantId")) != null) setApplicantId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("invoiceApplyStatus")) != null) setInvoiceApplyStatus(__getInt(val)); 
		if((val = values.get("dutyParagraph")) != null) setDutyParagraph(__getString(val));
		if((val = values.get("applyRemark")) != null) setApplyRemark(__getString(val));
		if((val = values.get("operatorRemark")) != null) setOperatorRemark(__getString(val));
		if((val = values.get("companyName")) != null) setCompanyName(__getString(val));
	}

	private java.util.Date __min_operator_time = null;
	private java.util.Date __max_operator_time = null;
	private java.util.Date __min_apply_time = null;
	private java.util.Date __max_apply_time = null;
	private java.lang.Integer __invoice_apply_id = null;
	private java.lang.Integer __applicant_deparment_id = null;
	private java.lang.String __applicant_name = null;
	private java.lang.String __operator_name = null;
	private java.lang.Integer __applicant_id = null;
	private java.lang.Integer __operator_id = null;
	private java.lang.String __department_name = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.String __bank_name = null;
	private java.lang.String __bank_account = null;
	private java.lang.Integer __invoice_type = null;
	private java.lang.Integer __invoice_apply_status = null;
	private java.lang.String __duty_paragraph = null;
	private java.lang.String __apply_remark = null;
	private java.lang.String __operator_remark = null;
	private java.lang.String __company_name = null;
}

