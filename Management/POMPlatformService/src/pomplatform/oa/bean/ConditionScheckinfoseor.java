package pomplatform.oa.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScheckinfoseor extends GenericCondition{

	public ConditionScheckinfoseor(){
		setParameterCount(2);
	}

	public java.util.Date getMinLogindate() {
		return this.__min_logindate;
	}

	public void setMinLogindate( java.util.Date value ) {
		this.__min_logindate = value;
	}

	public java.util.Date getMaxLogindate() {
		return this.__max_logindate;
	}

	public void setMaxLogindate( java.util.Date value ) {
		this.__max_logindate = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinLogindate() != null) sb.append(__wrapDate(1, "minLogindate", getMinLogindate()));
		if(getMaxLogindate() != null) sb.append(__wrapDate(1, "maxLogindate", getMaxLogindate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minLogindate")) != null) setMinLogindate(__getDate(val)); 
		if((val = values.get("maxLogindate")) != null) setMaxLogindate(__getDate(val)); 
	}

	private java.util.Date __min_logindate = null;
	private java.util.Date __max_logindate = null;
}

