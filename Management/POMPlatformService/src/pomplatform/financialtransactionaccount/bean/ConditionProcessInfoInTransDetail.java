package pomplatform.financialtransactionaccount.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionProcessInfoInTransDetail extends GenericCondition{

	public ConditionProcessInfoInTransDetail(){
		setParameterCount(2);
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(1, "isCompleted", getIsCompleted()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
	}

	private java.lang.Integer __delete_flag = null;
	private java.lang.Boolean __is_completed = null;
}

