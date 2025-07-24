package pomplatform.sinvoiceitior.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMinvoicettorunusecount extends GenericCondition{

	public ConditionMinvoicettorunusecount(){
		setParameterCount(1);
	}

	public java.lang.Integer getTicketingCompany() {
		return this.__ticketing_company;
	}

	public void setTicketingCompany( java.lang.Integer value ) {
		this.__ticketing_company = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTicketingCompany() != null) sb.append(__wrapNumber(1, "ticketingCompany", getTicketingCompany()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("ticketingCompany")) != null) setTicketingCompany(__getInt(val)); 
	}

	private java.lang.Integer __ticketing_company = null;
}

