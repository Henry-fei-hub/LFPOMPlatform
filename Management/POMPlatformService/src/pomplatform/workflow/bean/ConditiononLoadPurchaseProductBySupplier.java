package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditiononLoadPurchaseProductBySupplier extends GenericCondition{

	public ConditiononLoadPurchaseProductBySupplier(){
		setParameterCount(2);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(1, "personnelBusinessId", getPersonnelBusinessId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
	}

	private java.lang.Integer __personnel_business_id = null;
	private java.lang.Integer __main_project_id = null;
}

