package pomplatform.outPriceListItem.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOutPriceListItem extends GenericCondition{

	public ConditionOutPriceListItem(){
		setParameterCount(2);
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(1, "outQuotationId", getOutQuotationId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
	}

	private java.lang.String __info_code = null;
	private java.lang.Integer __out_quotation_id = null;
}

