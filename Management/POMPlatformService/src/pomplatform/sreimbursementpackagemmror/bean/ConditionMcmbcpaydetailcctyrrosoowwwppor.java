package pomplatform.sreimbursementpackagemmror.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcmbcpaydetailcctyrrosoowwwppor extends GenericCondition{

	public ConditionMcmbcpaydetailcctyrrosoowwwppor(){
		setParameterCount(14);
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

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getObjectId() {
		return this.__object_id;
	}

	public void setObjectId( java.lang.Integer value ) {
		this.__object_id = value;
	}

	public java.lang.Integer getObjectType() {
		return this.__object_type;
	}

	public void setObjectType( java.lang.Integer value ) {
		this.__object_type = value;
	}

	public java.lang.Integer getWithdrawFlag() {
		return this.__withdraw_flag;
	}

	public void setWithdrawFlag( java.lang.Integer value ) {
		this.__withdraw_flag = value;
	}

	public java.lang.Integer getWithdrawOriginId() {
		return this.__withdraw_origin_id;
	}

	public void setWithdrawOriginId( java.lang.Integer value ) {
		this.__withdraw_origin_id = value;
	}

	public java.lang.Integer getWithdrawStatus() {
		return this.__withdraw_status;
	}

	public void setWithdrawStatus( java.lang.Integer value ) {
		this.__withdraw_status = value;
	}

	public java.lang.Integer getPayResult() {
		return this.__pay_result;
	}

	public void setPayResult( java.lang.Integer value ) {
		this.__pay_result = value;
	}

	public java.lang.Integer getPayStatus() {
		return this.__pay_status;
	}

	public void setPayStatus( java.lang.Integer value ) {
		this.__pay_status = value;
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
		if(getOperator() != null) sb.append(__wrapNumber(1, "operator", getOperator()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getObjectId() != null) sb.append(__wrapNumber(1, "objectId", getObjectId()));
		if(getObjectType() != null) sb.append(__wrapNumber(1, "objectType", getObjectType()));
		if(getWithdrawFlag() != null) sb.append(__wrapNumber(1, "withdrawFlag", getWithdrawFlag()));
		if(getWithdrawOriginId() != null) sb.append(__wrapNumber(1, "withdrawOriginId", getWithdrawOriginId()));
		if(getWithdrawStatus() != null) sb.append(__wrapNumber(1, "withdrawStatus", getWithdrawStatus()));
		if(getPayResult() != null) sb.append(__wrapNumber(1, "payResult", getPayResult()));
		if(getPayStatus() != null) sb.append(__wrapNumber(1, "payStatus", getPayStatus()));
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
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("objectId")) != null) setObjectId(__getInt(val)); 
		if((val = values.get("objectType")) != null) setObjectType(__getInt(val)); 
		if((val = values.get("withdrawFlag")) != null) setWithdrawFlag(__getInt(val)); 
		if((val = values.get("withdrawOriginId")) != null) setWithdrawOriginId(__getInt(val)); 
		if((val = values.get("withdrawStatus")) != null) setWithdrawStatus(__getInt(val)); 
		if((val = values.get("payResult")) != null) setPayResult(__getInt(val)); 
		if((val = values.get("payStatus")) != null) setPayStatus(__getInt(val)); 
	}

	private java.lang.Integer __cmbc_pay_detail_id = null;
	private java.lang.Integer __type = null;
	private java.lang.String __yurref = null;
	private java.lang.Integer __reimbursement_package_summary_id = null;
	private java.lang.Integer __reimbursement_package_id = null;
	private java.lang.Integer __operator = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __object_id = null;
	private java.lang.Integer __object_type = null;
	private java.lang.Integer __withdraw_flag = null;
	private java.lang.Integer __withdraw_origin_id = null;
	private java.lang.Integer __withdraw_status = null;
	private java.lang.Integer __pay_result = null;
	private java.lang.Integer __pay_status = null;
}

