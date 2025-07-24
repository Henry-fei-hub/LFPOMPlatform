package pomplatform.workflow.personnel.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionApplicationForFiling extends GenericCondition{

	public ConditionApplicationForFiling(){
		setParameterCount(1);
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private Integer __employee_id = null;
}

