package pomplatform.shift.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSshiftmanagesor extends GenericCondition{

	public ConditionSshiftmanagesor(){
		setParameterCount(1);
	}

	public java.lang.String getShiftName() {
		return this.__shift_name == null ? null : (this.__shift_name.indexOf("%") >= 0 ? this.__shift_name : "%"+this.__shift_name+"%");
	}

	public void setShiftName( java.lang.String value ) {
		this.__shift_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getShiftName() != null) sb.append(__wrapString(1, "shiftName", getShiftName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("shiftName")) != null) setShiftName(__getString(val));
	}

	private java.lang.String __shift_name = null;
}

