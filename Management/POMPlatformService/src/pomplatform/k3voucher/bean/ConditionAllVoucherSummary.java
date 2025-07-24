package pomplatform.k3voucher.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAllVoucherSummary extends GenericCondition{

	public ConditionAllVoucherSummary(){
		setParameterCount(6);
	}

	public java.lang.Integer getVoucherType() {
		return this.__voucher_type;
	}

	public void setVoucherType( java.lang.Integer value ) {
		this.__voucher_type = value;
	}

	public java.lang.Integer getVoucherYear() {
		return this.__voucher_year;
	}

	public void setVoucherYear( java.lang.Integer value ) {
		this.__voucher_year = value;
	}

	public java.lang.Integer getVoucherMonth() {
		return this.__voucher_month;
	}

	public void setVoucherMonth( java.lang.Integer value ) {
		this.__voucher_month = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getSequenceNumber() {
		return __sequence_number;
	}

	public void setSequenceNumber(java.lang.Integer value) {
		this.__sequence_number = value;
	}

	public java.lang.String getReimbursementPackageCode() {
		return this.__reimbursement_package_code == null ? null : (this.__reimbursement_package_code.indexOf("%") >= 0 ? this.__reimbursement_package_code : "%"+this.__reimbursement_package_code+"%");
	}

	public void setReimbursementPackageCode(java.lang.String value) {
		this.__reimbursement_package_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getVoucherType() != null) sb.append(__wrapNumber(1, "voucherType", getVoucherType()));
		if(getVoucherYear() != null) sb.append(__wrapNumber(1, "voucherYear", getVoucherYear()));
		if(getVoucherMonth() != null) sb.append(__wrapNumber(1, "voucherMonth", getVoucherMonth()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getSequenceNumber() != null) sb.append(__wrapNumber(1, "sequenceNumber", getSequenceNumber()));
		if(getReimbursementPackageCode() != null) sb.append(__wrapString(1, "reimbursementPackageCode", getReimbursementPackageCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("voucherType")) != null) setVoucherType(__getInt(val)); 
		if((val = values.get("voucherYear")) != null) setVoucherYear(__getInt(val)); 
		if((val = values.get("voucherMonth")) != null) setVoucherMonth(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("sequenceNumber")) != null) setSequenceNumber(__getInt(val)); 
		if((val = values.get("reimbursementPackageCode")) != null) setReimbursementPackageCode(__getString(val)); 
	}

	private java.lang.Integer __voucher_type = null;
	private java.lang.Integer __voucher_year = null;
	private java.lang.Integer __voucher_month = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __sequence_number = null;
	private java.lang.String __reimbursement_package_code = null;
}

