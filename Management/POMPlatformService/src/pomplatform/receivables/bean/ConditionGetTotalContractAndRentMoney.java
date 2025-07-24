package pomplatform.receivables.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetTotalContractAndRentMoney extends GenericCondition{

	public ConditionGetTotalContractAndRentMoney(){
		setParameterCount(2);
	}

	public java.util.Date getFirstDate() {
		return this.__first_date;
	}

	public void setFirstDate( java.util.Date value ) {
		this.__first_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getFirstDate() != null) sb.append(__wrapDate(1, "firstDate", getFirstDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("firstDate")) != null) setFirstDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	private java.util.Date __first_date = null;
	private java.util.Date __end_date = null;
}

