package pomplatform.capatialandinvoice.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionInvoiceReportDetail extends GenericCondition{

	public ConditionInvoiceReportDetail(){
		setParameterCount(1);
	}

	public java.lang.Integer getProjectManagerId() {
		return this.__project_manager_id;
	}

	public void setProjectManagerId( java.lang.Integer value ) {
		this.__project_manager_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectManagerId() != null) sb.append(__wrapNumber(1, "projectManagerId", getProjectManagerId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectManagerId")) != null) setProjectManagerId(__getInt(val)); 
	}

	private java.lang.Integer __project_manager_id = null;
}

