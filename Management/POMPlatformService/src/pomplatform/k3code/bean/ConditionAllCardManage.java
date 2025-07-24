package pomplatform.k3code.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAllCardManage extends GenericCondition{

	public ConditionAllCardManage(){
		setParameterCount(3);
	}

	public java.lang.Integer getObjectType() {
		return this.__object_type;
	}

	public void setObjectType( java.lang.Integer value ) {
		this.__object_type = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public java.lang.Integer getCardManageId() {
		return this.__card_manage_id;
	}

	public void setCardManageId( java.lang.Integer value ) {
		this.__card_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getObjectType() != null) sb.append(__wrapNumber(1, "objectType", getObjectType()));
		if(getEnabled() != null) sb.append(__wrapBoolean(1, "enabled", getEnabled()));
		if(getCardManageId() != null) sb.append(__wrapNumber(1, "cardManageId", getCardManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("objectType")) != null) setObjectType(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
		if((val = values.get("cardManageId")) != null) setCardManageId(__getInt(val)); 
	}

	private java.lang.Integer __object_type = null;
	private java.lang.Boolean __enabled = null;
	private java.lang.Integer __card_manage_id = null;
}

