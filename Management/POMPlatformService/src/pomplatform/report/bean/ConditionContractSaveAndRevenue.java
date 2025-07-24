package pomplatform.report.bean;

import delicacy.common.GenericCondition;

import java.util.Map;

public class ConditionContractSaveAndRevenue extends GenericCondition{

	public ConditionContractSaveAndRevenue(){
		setParameterCount(3);
	}

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	public Integer getYear() {
		return this.__year;
	}

	public void setYear( Integer value ) {
		this.__year = value;
	}

	public Integer getMonth() {
		return this.__month;
	}

	public void setMonth( Integer value ) {
		this.__month = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("year")) != null) setYear(__getInt(val));
		if((val = values.get("month")) != null) setMonth(__getInt(val));
	}

	private Integer __plate_id = null;
	private Integer __year = null;
	private Integer __month = null;
}

