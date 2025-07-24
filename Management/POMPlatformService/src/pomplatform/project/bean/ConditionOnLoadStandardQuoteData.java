package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadStandardQuoteData extends GenericCondition{

	public ConditionOnLoadStandardQuoteData(){
		setParameterCount(4);
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.String getClientName() {
		return this.__client_name == null ? null : (this.__client_name.indexOf("%") >= 0 ? this.__client_name : "%"+this.__client_name+"%");
	}

	public void setClientName( java.lang.String value ) {
		this.__client_name = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type == null ? null : (this.__business_type.indexOf("%") >= 0 ? this.__business_type : "%"+this.__business_type+"%");
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getClientName() != null) sb.append(__wrapString(1, "clientName", getClientName()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("clientName")) != null) setClientName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
	}

	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.String __client_name = null;
	private java.lang.String __business_type = null;
}

