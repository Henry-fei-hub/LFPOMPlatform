package pomplatform.financialStatements.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionFinancialBankAccountBalance extends GenericCondition{

	public ConditionFinancialBankAccountBalance(){
		setParameterCount(2);
	}

	public java.util.Date getMinHappenDate() {
		return this.__min_happen_date;
	}

	public void setMinHappenDate( java.util.Date value ) {
		this.__min_happen_date = value;
	}

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinHappenDate() != null) sb.append(__wrapDate(1, "minHappenDate", getMinHappenDate()));
		if(getSelfName() != null) sb.append(__wrapNumber(1, "selfName", getSelfName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minHappenDate")) != null) setMinHappenDate(__getDate(val)); 
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
	}

	private java.util.Date __min_happen_date = null;
	private java.lang.Integer __self_name = null;
}

