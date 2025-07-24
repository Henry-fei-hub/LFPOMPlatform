package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnProjectManageStatus extends GenericCondition{

	public ConditionOnProjectManageStatus(){
		setParameterCount(4);
	}

	public String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( String value ) {
		this.__info_code = value;
	}

	public Boolean getHasOutQuotations() {
		return this.__has_out_quotations;
	}

	public void setHasOutQuotations( Boolean value ) {
		this.__has_out_quotations = value;
	}

	public Boolean getHasSplitPrice() {
		return this.__has_split_price;
	}

	public void setHasSplitPrice( Boolean value ) {
		this.__has_split_price = value;
	}

	public Boolean getHasSendSheet() {
		return this.__has_send_sheet;
	}

	public void setHasSendSheet( Boolean value ) {
		this.__has_send_sheet = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getHasOutQuotations() != null) sb.append(__wrapBoolean(1, "hasOutQuotations", getHasOutQuotations()));
		if(getHasSplitPrice() != null) sb.append(__wrapBoolean(1, "hasSplitPrice", getHasSplitPrice()));
		if(getHasSendSheet() != null) sb.append(__wrapBoolean(1, "hasSendSheet", getHasSendSheet()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("hasOutQuotations")) != null) setHasOutQuotations(__getBoolean(val));
		if((val = values.get("hasSplitPrice")) != null) setHasSplitPrice(__getBoolean(val));
		if((val = values.get("hasSendSheet")) != null) setHasSendSheet(__getBoolean(val));
	}

	private String __info_code = null;
	private Boolean __has_out_quotations = null;
	private Boolean __has_split_price = null;
	private Boolean __has_send_sheet = null;
}

