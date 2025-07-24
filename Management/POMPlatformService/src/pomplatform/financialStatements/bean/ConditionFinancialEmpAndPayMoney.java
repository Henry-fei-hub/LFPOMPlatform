package pomplatform.financialStatements.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionFinancialEmpAndPayMoney extends GenericCondition{

	public ConditionFinancialEmpAndPayMoney(){
		setParameterCount(3);
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.util.Date getMinUpdateTime() {
		return this.__min_update_time;
	}

	public void setMinUpdateTime( java.util.Date value ) {
		this.__min_update_time = value;
	}

	public java.util.Date getMaxUpdateTime() {
		return this.__max_update_time;
	}

	public void setMaxUpdateTime( java.util.Date value ) {
		this.__max_update_time = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getMinUpdateTime() != null) sb.append(__wrapDate(1, "minUpdateTime", getMinUpdateTime()));
		if(getMaxUpdateTime() != null) sb.append(__wrapDate(1, "maxUpdateTime", getMaxUpdateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("minUpdateTime")) != null) setMinUpdateTime(__getDate(val)); 
		if((val = values.get("maxUpdateTime")) != null) setMaxUpdateTime(__getDate(val)); 
	}

	private java.lang.Integer __company_id = null;
	private java.util.Date __min_update_time = null;
	private java.util.Date __max_update_time = null;
}

