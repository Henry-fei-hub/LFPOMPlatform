package pomplatform.reimbursementpackage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScmbcpaydetailctyor extends GenericCondition{

	public ConditionScmbcpaydetailctyor(){
		setParameterCount(6);
	}

	public java.lang.Integer getCmbcPayDetailId() {
		return this.__cmbc_pay_detail_id;
	}

	public void setCmbcPayDetailId( java.lang.Integer value ) {
		this.__cmbc_pay_detail_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getYurref() {
		return this.__yurref;
	}

	public void setYurref( java.lang.String value ) {
		this.__yurref = value;
	}

	public java.lang.Integer getReimbursementPackageSummaryId() {
		return this.__reimbursement_package_summary_id;
	}

	public void setReimbursementPackageSummaryId( java.lang.Integer value ) {
		this.__reimbursement_package_summary_id = value;
	}

	public java.lang.Integer getReimbursementPackageId() {
		return this.__reimbursement_package_id;
	}

	public void setReimbursementPackageId( java.lang.Integer value ) {
		this.__reimbursement_package_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCmbcPayDetailId() != null) sb.append(__wrapNumber(1, "cmbcPayDetailId", getCmbcPayDetailId()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getYurref() != null) sb.append(__wrapString(1, "yurref", getYurref()));
		if(getReimbursementPackageSummaryId() != null) sb.append(__wrapNumber(1, "reimbursementPackageSummaryId", getReimbursementPackageSummaryId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(1, "reimbursementPackageId", getReimbursementPackageId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("cmbcPayDetailId")) != null) setCmbcPayDetailId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("yurref")) != null) setYurref(__getString(val));
		if((val = values.get("reimbursementPackageSummaryId")) != null) setReimbursementPackageSummaryId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
	}

	private java.lang.Integer __cmbc_pay_detail_id = null;
	private java.lang.Integer __type = null;
	private java.lang.String __yurref = null;
	private java.lang.Integer __reimbursement_package_summary_id = null;
	private java.lang.Integer __reimbursement_package_id = null;
	private java.lang.Integer __status = null;
}

