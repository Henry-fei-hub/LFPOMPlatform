package pomplatform.subjectType.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSubjectTypeLinkDepartment extends GenericCondition{

	public ConditionSubjectTypeLinkDepartment(){
		setParameterCount(1);
	}

	public java.lang.Integer getSubjectTypeId() {
		return this.__subject_type_id;
	}

	public void setSubjectTypeId( java.lang.Integer value ) {
		this.__subject_type_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSubjectTypeId() != null) sb.append(__wrapNumber(1, "subjectTypeId", getSubjectTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("subjectTypeId")) != null) setSubjectTypeId(__getInt(val)); 
	}

	private java.lang.Integer __subject_type_id = null;
}

