package pomplatform.reimbursementpackage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMCmbcPaymentDetailpor extends GenericCondition{

	public ConditionMCmbcPaymentDetailpor(){
		setParameterCount(10);
	}

	public java.lang.String getDbtacc() {
		return this.__dbtacc == null ? null : (this.__dbtacc.indexOf("%") >= 0 ? this.__dbtacc : "%"+this.__dbtacc+"%");
	}

	public void setDbtacc( java.lang.String value ) {
		this.__dbtacc = value;
	}

	public java.lang.String getDbtbbk() {
		return this.__dbtbbk == null ? null : (this.__dbtbbk.indexOf("%") >= 0 ? this.__dbtbbk : "%"+this.__dbtbbk+"%");
	}

	public void setDbtbbk( java.lang.String value ) {
		this.__dbtbbk = value;
	}

	public java.lang.String getCrtacc() {
		return this.__crtacc == null ? null : (this.__crtacc.indexOf("%") >= 0 ? this.__crtacc : "%"+this.__crtacc+"%");
	}

	public void setCrtacc( java.lang.String value ) {
		this.__crtacc = value;
	}

	public java.lang.String getCrtnam() {
		return this.__crtnam == null ? null : (this.__crtnam.indexOf("%") >= 0 ? this.__crtnam : "%"+this.__crtnam+"%");
	}

	public void setCrtnam( java.lang.String value ) {
		this.__crtnam = value;
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

	public java.lang.Integer getCmbcPaymentId() {
		return this.__cmbc_payment_id;
	}

	public void setCmbcPaymentId( java.lang.Integer value ) {
		this.__cmbc_payment_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDbtacc() != null) sb.append(__wrapString(1, "dbtacc", getDbtacc()));
		if(getDbtbbk() != null) sb.append(__wrapString(1, "dbtbbk", getDbtbbk()));
		if(getCrtacc() != null) sb.append(__wrapString(1, "crtacc", getCrtacc()));
		if(getCrtnam() != null) sb.append(__wrapString(1, "crtnam", getCrtnam()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getYurref() != null) sb.append(__wrapString(1, "yurref", getYurref()));
		if(getReimbursementPackageSummaryId() != null) sb.append(__wrapNumber(1, "reimbursementPackageSummaryId", getReimbursementPackageSummaryId()));
		if(getReimbursementPackageId() != null) sb.append(__wrapNumber(1, "reimbursementPackageId", getReimbursementPackageId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getCmbcPaymentId() != null) sb.append(__wrapNumber(1, "cmbcPaymentId", getCmbcPaymentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("dbtacc")) != null) setDbtacc(__getString(val));
		if((val = values.get("dbtbbk")) != null) setDbtbbk(__getString(val));
		if((val = values.get("crtacc")) != null) setCrtacc(__getString(val));
		if((val = values.get("crtnam")) != null) setCrtnam(__getString(val));
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("yurref")) != null) setYurref(__getString(val));
		if((val = values.get("reimbursementPackageSummaryId")) != null) setReimbursementPackageSummaryId(__getInt(val)); 
		if((val = values.get("reimbursementPackageId")) != null) setReimbursementPackageId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("cmbcPaymentId")) != null) setCmbcPaymentId(__getInt(val)); 
	}

	private java.lang.String __dbtacc = null;
	private java.lang.String __dbtbbk = null;
	private java.lang.String __crtacc = null;
	private java.lang.String __crtnam = null;
	private java.lang.Integer __type = null;
	private java.lang.String __yurref = null;
	private java.lang.Integer __reimbursement_package_summary_id = null;
	private java.lang.Integer __reimbursement_package_id = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __cmbc_payment_id = null;
}

