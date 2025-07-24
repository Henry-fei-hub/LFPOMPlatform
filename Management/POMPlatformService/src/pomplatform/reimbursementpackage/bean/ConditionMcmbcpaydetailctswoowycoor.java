package pomplatform.reimbursementpackage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcmbcpaydetailctswoowycoor extends GenericCondition{

	public ConditionMcmbcpaydetailctswoowycoor(){
		setParameterCount(10);
	}

	public java.lang.Integer getCmbcPaymentId() {
		return this.__cmbc_payment_id;
	}

	public void setCmbcPaymentId( java.lang.Integer value ) {
		this.__cmbc_payment_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getWithdrawFlag() {
		return this.__withdraw_flag;
	}

	public void setWithdrawFlag( java.lang.Integer value ) {
		this.__withdraw_flag = value;
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

	public java.lang.Integer getWithdrawStatus() {
		return this.__withdraw_status;
	}

	public void setWithdrawStatus( java.lang.Integer value ) {
		this.__withdraw_status = value;
	}

	public java.lang.String getYurref() {
		return this.__yurref;
	}

	public void setYurref( java.lang.String value ) {
		this.__yurref = value;
	}

	public java.lang.Integer getCmbcPayDetailId() {
		return this.__cmbc_pay_detail_id;
	}

	public void setCmbcPayDetailId( java.lang.Integer value ) {
		this.__cmbc_pay_detail_id = value;
	}

	public java.lang.String getOriYurref() {
		return this.__ori_yurref;
	}

	public void setOriYurref( java.lang.String value ) {
		this.__ori_yurref = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCmbcPaymentId() != null) sb.append(__wrapNumber(1, "cmbcPaymentId", getCmbcPaymentId()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getWithdrawFlag() != null) sb.append(__wrapNumber(1, "withdrawFlag", getWithdrawFlag()));
		if(getObjectId() != null) sb.append(__wrapNumber(1, "objectId", getObjectId()));
		if(getObjectType() != null) sb.append(__wrapNumber(1, "objectType", getObjectType()));
		if(getWithdrawStatus() != null) sb.append(__wrapNumber(1, "withdrawStatus", getWithdrawStatus()));
		if(getYurref() != null) sb.append(__wrapString(1, "yurref", getYurref()));
		if(getCmbcPayDetailId() != null) sb.append(__wrapNumber(1, "cmbcPayDetailId", getCmbcPayDetailId()));
		if(getOriYurref() != null) sb.append(__wrapString(1, "oriYurref", getOriYurref()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("cmbcPaymentId")) != null) setCmbcPaymentId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("withdrawFlag")) != null) setWithdrawFlag(__getInt(val)); 
		if((val = values.get("objectId")) != null) setObjectId(__getInt(val)); 
		if((val = values.get("objectType")) != null) setObjectType(__getInt(val)); 
		if((val = values.get("withdrawStatus")) != null) setWithdrawStatus(__getInt(val)); 
		if((val = values.get("yurref")) != null) setYurref(__getString(val));
		if((val = values.get("cmbcPayDetailId")) != null) setCmbcPayDetailId(__getInt(val)); 
		if((val = values.get("oriYurref")) != null) setOriYurref(__getString(val));
	}

	private java.lang.Integer __cmbc_payment_id = null;
	private java.lang.Integer __type = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __withdraw_flag = null;
	private java.lang.Integer __object_id = null;
	private java.lang.Integer __object_type = null;
	private java.lang.Integer __withdraw_status = null;
	private java.lang.String __yurref = null;
	private java.lang.Integer __cmbc_pay_detail_id = null;
	private java.lang.String __ori_yurref = null;
}

