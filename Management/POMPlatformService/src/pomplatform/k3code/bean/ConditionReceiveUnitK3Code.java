package pomplatform.k3code.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionReceiveUnitK3Code extends GenericCondition{

	public ConditionReceiveUnitK3Code(){
		setParameterCount(8);
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account == null ? null : (this.__bank_account.indexOf("%") >= 0 ? this.__bank_account : "%"+this.__bank_account+"%");
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getK3Code() {
		return this.__k3_code == null ? null : (this.__k3_code.indexOf("%") >= 0 ? this.__k3_code : "%"+this.__k3_code+"%");
	}

	public void setK3Code( java.lang.String value ) {
		this.__k3_code = value;
	}
	
	public java.lang.String getReceiveUnit() {
		return this.__receive_unit == null ? null : (this.__receive_unit.indexOf("%") >= 0 ? this.__receive_unit : "%"+this.__receive_unit+"%");
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}
	
	public java.util.Date getOperateStartTime() {
		return __operate_start_time;
	}

	public void setOperateStartTime(java.util.Date value) {
		this.__operate_start_time = value;
	}
	
	public java.util.Date getOperateEndTime() {
		return __operate_end_time;
	}
	
	public void setOperateEndTime(java.util.Date value) {
		this.__operate_end_time = value;
	}

	public java.util.Date getUpdateStartTime() {
		return __update_start_time;
	}

	public void setUpdateStartTime(java.util.Date value) {
		this.__update_start_time = value;
	}
	
	public java.util.Date getUpdateEndTime() {
		return __update_end_time;
	}
	
	public void setUpdateEndTime(java.util.Date value) {
		this.__update_end_time = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBusinessId() != null) sb.append(__wrapNumber(1, "businessId", getBusinessId()));
		if(getBankAccount() != null) sb.append(__wrapString(1, "bankAccount", getBankAccount()));
		if(getK3Code() != null) sb.append(__wrapString(1, "k3Code", getK3Code()));
		if(getReceiveUnit() != null) sb.append(__wrapString(1, "receiveUnit", getReceiveUnit()));
		if(getOperateStartTime() != null) sb.append(__wrapDate(1, "operateStartTime", getOperateStartTime()));
		if(getOperateEndTime() != null) sb.append(__wrapDate(1, "operateEndTime", getOperateEndTime()));
		if(getUpdateStartTime() != null) sb.append(__wrapDate(1, "updateStartTime", getUpdateStartTime()));
		if(getUpdateEndTime() != null) sb.append(__wrapDate(1, "updateEndTime", getUpdateEndTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("k3Code")) != null) setK3Code(__getString(val));
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("operateStartTime")) != null) setOperateStartTime(__getDate(val));
		if((val = values.get("operateEndTime")) != null) setOperateEndTime(__getDate(val));
		if((val = values.get("updateStartTime")) != null) setUpdateStartTime(__getDate(val));
		if((val = values.get("updateEndTime")) != null) setUpdateEndTime(__getDate(val));
	}

	private java.lang.Integer __business_id = null;
	private java.lang.String __bank_account = null;
	private java.lang.String __k3_code = null;
	private java.lang.String __receive_unit = null;
	private java.util.Date __operate_start_time = null;
	private java.util.Date __operate_end_time = null;
	private java.util.Date __update_start_time = null;
	private java.util.Date __update_end_time = null;
}

