package pomplatform.company.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionJobManager extends GenericCondition{

	public ConditionJobManager(){
		setParameterCount(1);
	}

	public java.lang.String getDutyName() {
		return this.__duty_name == null ? null : (this.__duty_name.indexOf("%") >= 0 ? this.__duty_name : "%"+this.__duty_name+"%");
	}

	public void setDutyName( java.lang.String value ) {
		this.__duty_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDutyName() != null) sb.append(__wrapString(1, "dutyName", getDutyName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("dutyName")) != null) setDutyName(__getString(val));
	}

	private java.lang.String __duty_name = null;
}

