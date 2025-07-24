package pomplatform.report.bean;

import delicacy.common.GenericCondition;

import java.util.Map;

public class ConditionDepartmentIncomeReport extends GenericCondition{

	public ConditionDepartmentIncomeReport(){
		setParameterCount(2);
	}

	public Integer getYear() {
		return this.__year;
	}

	public void setYear( Integer value ) {
		this.__year = value;
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
	}

	private Integer __year = null;
	private Integer __plate_id = null;
}

