package pomplatform.workflow.projectTravelReimbursement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionNewProjectTravelReimbursement extends GenericCondition{

	public ConditionNewProjectTravelReimbursement(){
		setParameterCount(1);
	}

	public java.lang.Integer getTravelReimbursementId() {
		return this.__travel_reimbursement_id;
	}

	public void setTravelReimbursementId( java.lang.Integer value ) {
		this.__travel_reimbursement_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTravelReimbursementId() != null) sb.append(__wrapNumber(1, "travelReimbursementId", getTravelReimbursementId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("travelReimbursementId")) != null) setTravelReimbursementId(__getInt(val)); 
	}

	private java.lang.Integer __travel_reimbursement_id = null;
}

