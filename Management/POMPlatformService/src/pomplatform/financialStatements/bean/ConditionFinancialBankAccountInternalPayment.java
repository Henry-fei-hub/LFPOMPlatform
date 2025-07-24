package pomplatform.financialStatements.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionFinancialBankAccountInternalPayment extends GenericCondition{

	public ConditionFinancialBankAccountInternalPayment(){
		setParameterCount(3);
	}

	public java.lang.Integer getObjectId() {
		return this.__object_id;
	}

	public void setObjectId( java.lang.Integer value ) {
		this.__object_id = value;
	}

	public java.util.Date getMinHappenDate() {
		return this.__min_happen_date;
	}

	public void setMinHappenDate( java.util.Date value ) {
		this.__min_happen_date = value;
	}

	public java.util.Date getMaxHappenDate() {
		return this.__max_happen_date;
	}

	public void setMaxHappenDate( java.util.Date value ) {
		this.__max_happen_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getObjectId() != null) sb.append(__wrapNumber(1, "objectId", getObjectId()));
		if(getMinHappenDate() != null) sb.append(__wrapDate(1, "minHappenDate", getMinHappenDate()));
		if(getMaxHappenDate() != null) sb.append(__wrapDate(1, "maxHappenDate", getMaxHappenDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("objectId")) != null) setObjectId(__getInt(val)); 
		if((val = values.get("minHappenDate")) != null) setMinHappenDate(__getDate(val)); 
		if((val = values.get("maxHappenDate")) != null) setMaxHappenDate(__getDate(val)); 
	}

	private java.lang.Integer __object_id = null;
	private java.util.Date __min_happen_date = null;
	private java.util.Date __max_happen_date = null;
}

