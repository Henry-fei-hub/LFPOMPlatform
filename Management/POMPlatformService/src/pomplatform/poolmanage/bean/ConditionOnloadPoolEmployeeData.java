package pomplatform.poolmanage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnloadPoolEmployeeData extends GenericCondition{

	public ConditionOnloadPoolEmployeeData(){
		setParameterCount(1);
	}

	public java.lang.Integer getPoolManageId() {
		return this.__pool_manage_id;
	}

	public void setPoolManageId( java.lang.Integer value ) {
		this.__pool_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPoolManageId() != null) sb.append(__wrapNumber(1, "poolManageId", getPoolManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("poolManageId")) != null) setPoolManageId(__getInt(val)); 
	}

	private java.lang.Integer __pool_manage_id = null;
}

