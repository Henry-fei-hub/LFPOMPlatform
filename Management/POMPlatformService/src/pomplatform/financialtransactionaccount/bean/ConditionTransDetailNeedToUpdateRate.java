package pomplatform.financialtransactionaccount.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionTransDetailNeedToUpdateRate extends GenericCondition{

	public ConditionTransDetailNeedToUpdateRate(){
		setParameterCount(3);
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getIsCompleted() != null) sb.append(__wrapBoolean(1, "isCompleted", getIsCompleted()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	private java.lang.Boolean __is_completed = null;
	private java.lang.Integer __process_status = null;
	private java.lang.Integer __delete_flag = null;
}

