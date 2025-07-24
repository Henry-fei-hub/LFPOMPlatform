package pomplatform.role.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSroleror extends GenericCondition{

	public ConditionSroleror(){
		setParameterCount(1);
	}

	public java.lang.String getRoleName() {
		return this.__role_name == null ? null : (this.__role_name.indexOf("%") >= 0 ? this.__role_name : "%"+this.__role_name+"%");
	}

	public void setRoleName( java.lang.String value ) {
		this.__role_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getRoleName() != null) sb.append(__wrapString(1, "roleName", getRoleName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("roleName")) != null) setRoleName(__getString(val));
	}

	private java.lang.String __role_name = null;
}

