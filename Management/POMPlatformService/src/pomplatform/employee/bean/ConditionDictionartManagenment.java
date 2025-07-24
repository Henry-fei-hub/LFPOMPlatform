package pomplatform.employee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionDictionartManagenment extends GenericCondition{

	public ConditionDictionartManagenment(){
		setParameterCount(1);
	}

	public java.lang.String getDicTypeName() {
		return this.__dic_type_name == null ? null : (this.__dic_type_name.indexOf("%") >= 0 ? this.__dic_type_name : "%"+this.__dic_type_name+"%");
	}

	public void setDicTypeName( java.lang.String value ) {
		this.__dic_type_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDicTypeName() != null) sb.append(__wrapString(1, "dicTypeName", getDicTypeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("dicTypeName")) != null) setDicTypeName(__getString(val));
	}

	private java.lang.String __dic_type_name = null;
}

