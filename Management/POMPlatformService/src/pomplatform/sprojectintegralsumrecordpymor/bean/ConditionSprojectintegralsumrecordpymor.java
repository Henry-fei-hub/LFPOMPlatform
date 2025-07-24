package pomplatform.sprojectintegralsumrecordpymor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectintegralsumrecordpymor extends GenericCondition{

	public ConditionSprojectintegralsumrecordpymor(){
		setParameterCount(4);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getStartMonth() {
		return this.__start_month;
	}

	public void setStartMonth( java.lang.Integer value ) {
		this.__start_month = value;
	}
        
        public java.lang.Integer getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( java.lang.Integer value ) {
		this.__end_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
                if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val)); 
                if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __start_month = null;
        private java.lang.Integer __end_month = null;
}

