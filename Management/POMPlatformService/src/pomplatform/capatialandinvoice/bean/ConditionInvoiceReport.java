package pomplatform.capatialandinvoice.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionInvoiceReport extends GenericCondition{

	public ConditionInvoiceReport(){
		setParameterCount(2);
	}

	public java.lang.Integer getProjectManagerId() {
		return this.__project_manager_id;
	}

	public void setProjectManagerId( java.lang.Integer value ) {
		this.__project_manager_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectManagerId() != null) sb.append(__wrapNumber(1, "projectManagerId", getProjectManagerId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectManagerId")) != null) setProjectManagerId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	private java.lang.Integer __project_manager_id = null;
	private java.lang.Integer __plate_id = null;
}

