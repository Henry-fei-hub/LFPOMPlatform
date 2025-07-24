package pomplatform.common.bean;

import java.util.Map;

import delicacy.common.GenericBase;

public class BaseKeyValue extends GenericBase{

	public java.lang.String getKey() {
		return this.key;
	}

	public void setKey( java.lang.String value ) {
		this.key = value;
	}

	public java.lang.String getValue() {
		return this.value;
	}

	public void setValue( java.lang.String value ) {
		this.value = value;
	}
	
	@Override
	public String toJSONString() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getKey() != null) sb.append(__wrapString(count++, "key", getKey()));
		if(getValue() != null) sb.append(__wrapString(count++, "value", getValue()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values) {
		Object val;
		if((val = values.get("key")) != null) setKey(__getString(val)); 
		if((val = values.get("value")) != null) setValue(__getString(val)); 
	}
	
	protected java.lang.String  key ;
	protected java.lang.String  value ;

}
