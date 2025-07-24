package pomplatform.selectgrid.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSelectGridReceiveUnitValue extends GenericCondition{

	public ConditionSelectGridReceiveUnitValue(){
		setParameterCount(5);
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.Integer getOrigin() {
		return this.__origin;
	}

	public void setOrigin( java.lang.Integer value ) {
		this.__origin = value;
	}

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit == null ? null : (this.__receive_unit.indexOf("%") >= 0 ? this.__receive_unit : "%"+this.__receive_unit+"%");
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name == null ? null : (this.__bank_name.indexOf("%") >= 0 ? this.__bank_name : "%"+this.__bank_name+"%");
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getReceiveUnitAddress() {
		return this.__receive_unit_address == null ? null : (this.__receive_unit_address.indexOf("%") >= 0 ? this.__receive_unit_address : "%"+this.__receive_unit_address+"%");
	}

	public void setReceiveUnitAddress( java.lang.String value ) {
		this.__receive_unit_address = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(1, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getOrigin() != null) sb.append(__wrapNumber(1, "origin", getOrigin()));
		if(getReceiveUnit() != null) sb.append(__wrapString(1, "receiveUnit", getReceiveUnit()));
		if(getBankName() != null) sb.append(__wrapString(1, "bankName", getBankName()));
		if(getReceiveUnitAddress() != null) sb.append(__wrapString(1, "receiveUnitAddress", getReceiveUnitAddress()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("origin")) != null) setOrigin(__getInt(val)); 
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("receiveUnitAddress")) != null) setReceiveUnitAddress(__getString(val));
	}

	private java.lang.Integer __receive_unit_manage_id = null;
	private java.lang.Integer __origin = null;
	private java.lang.String __receive_unit = null;
	private java.lang.String __bank_name = null;
	private java.lang.String __receive_unit_address = null;
}

