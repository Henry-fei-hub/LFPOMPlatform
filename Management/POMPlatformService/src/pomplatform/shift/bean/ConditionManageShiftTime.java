package pomplatform.shift.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionManageShiftTime extends GenericCondition{

	public ConditionManageShiftTime(){
		setParameterCount(1);
	}

	public java.lang.String getShiftTimeName() {
		return this.__shift_time_name == null ? null : (this.__shift_time_name.indexOf("%") >= 0 ? this.__shift_time_name : "%"+this.__shift_time_name+"%");
	}

	public void setShiftTimeName( java.lang.String value ) {
		this.__shift_time_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getShiftTimeName() != null) sb.append(__wrapString(1, "shiftTimeName", getShiftTimeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("shiftTimeName")) != null) setShiftTimeName(__getString(val));
	}

	private java.lang.String __shift_time_name = null;
}

