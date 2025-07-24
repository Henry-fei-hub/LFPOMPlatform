package pomplatform.workflow.projectNormalReimbursement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionNormalReimbursementWithProject extends GenericCondition{

	public ConditionNormalReimbursementWithProject(){
		setParameterCount(1);
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return this.__project_normal_reimbursement_id;
	}

	public void setProjectNormalReimbursementId( java.lang.Integer value ) {
		this.__project_normal_reimbursement_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectNormalReimbursementId() != null) sb.append(__wrapNumber(1, "projectNormalReimbursementId", getProjectNormalReimbursementId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectNormalReimbursementId")) != null) setProjectNormalReimbursementId(__getInt(val)); 
	}

	private java.lang.Integer __project_normal_reimbursement_id = null;
}

