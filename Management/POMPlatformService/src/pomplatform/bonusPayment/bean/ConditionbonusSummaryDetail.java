package pomplatform.bonusPayment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionbonusSummaryDetail extends GenericCondition{

	public ConditionbonusSummaryDetail(){
		setParameterCount(9);
	}

	public java.util.Date getFirststart() {
		return this.__firststart;
	}

	public void setFirststart( java.util.Date value ) {
		this.__firststart = value;
	}

	public java.util.Date getFirstend() {
		return this.__firstend;
	}

	public void setFirstend( java.util.Date value ) {
		this.__firstend = value;
	}

	public java.util.Date getSecondstart() {
		return this.__secondstart;
	}

	public void setSecondstart( java.util.Date value ) {
		this.__secondstart = value;
	}

	public java.util.Date getSecondend() {
		return this.__secondend;
	}

	public void setSecondend( java.util.Date value ) {
		this.__secondend = value;
	}

	public java.util.Date getThirdstart() {
		return this.__thirdstart;
	}

	public void setThirdstart( java.util.Date value ) {
		this.__thirdstart = value;
	}

	public java.util.Date getThirdend() {
		return this.__thirdend;
	}

	public void setThirdend( java.util.Date value ) {
		this.__thirdend = value;
	}

	public java.util.Date getFourthstart() {
		return this.__fourthstart;
	}

	public void setFourthstart( java.util.Date value ) {
		this.__fourthstart = value;
	}

	public java.util.Date getFourthend() {
		return this.__fourthend;
	}

	public void setFourthend( java.util.Date value ) {
		this.__fourthend = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getFirststart() != null) sb.append(__wrapDate(1, "firststart", getFirststart()));
		if(getFirstend() != null) sb.append(__wrapDate(1, "firstend", getFirstend()));
		if(getSecondstart() != null) sb.append(__wrapDate(1, "secondstart", getSecondstart()));
		if(getSecondend() != null) sb.append(__wrapDate(1, "secondend", getSecondend()));
		if(getThirdstart() != null) sb.append(__wrapDate(1, "thirdstart", getThirdstart()));
		if(getThirdend() != null) sb.append(__wrapDate(1, "thirdend", getThirdend()));
		if(getFourthstart() != null) sb.append(__wrapDate(1, "fourthstart", getFourthstart()));
		if(getFourthend() != null) sb.append(__wrapDate(1, "fourthend", getFourthend()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("firststart")) != null) setFirststart(__getDate(val)); 
		if((val = values.get("firstend")) != null) setFirstend(__getDate(val)); 
		if((val = values.get("secondstart")) != null) setSecondstart(__getDate(val)); 
		if((val = values.get("secondend")) != null) setSecondend(__getDate(val)); 
		if((val = values.get("thirdstart")) != null) setThirdstart(__getDate(val)); 
		if((val = values.get("thirdend")) != null) setThirdend(__getDate(val)); 
		if((val = values.get("fourthstart")) != null) setFourthstart(__getDate(val)); 
		if((val = values.get("fourthend")) != null) setFourthend(__getDate(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	private java.util.Date __firststart = null;
	private java.util.Date __firstend = null;
	private java.util.Date __secondstart = null;
	private java.util.Date __secondend = null;
	private java.util.Date __thirdstart = null;
	private java.util.Date __thirdend = null;
	private java.util.Date __fourthstart = null;
	private java.util.Date __fourthend = null;
	private java.lang.Integer __plate_id = null;
}

