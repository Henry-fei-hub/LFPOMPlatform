package pomplatform.projectSettlement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionProfessionalApprovalApplication extends GenericCondition{

	public ConditionProfessionalApprovalApplication(){
		setParameterCount(1);
	}

	public Integer getProfessionalApproval_id() {
		return this.__professional_approval__id;
	}

	public void setProfessionalApproval_id( Integer value ) {
		this.__professional_approval__id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProfessionalApproval_id() != null) sb.append(__wrapNumber(1, "professionalApproval_id", getProfessionalApproval_id()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("professionalApproval_id")) != null) setProfessionalApproval_id(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getProfessionalApproval_id() != null) res.add("professionalApproval_id");
		return res;
	}

	private Integer __professional_approval__id = null;
}

