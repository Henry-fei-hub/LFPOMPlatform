package pomplatform.employee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionEmployeeFinancialTransSum extends GenericCondition{

	public ConditionEmployeeFinancialTransSum(){
		setParameterCount(4);
	}

	public java.lang.Integer getAccountType() {
		return this.__account_type;
	}

	public void setAccountType( java.lang.Integer value ) {
		this.__account_type = value;
	}

	public java.lang.Integer getEntityId() {
		return this.__entity_id;
	}

	public void setEntityId( java.lang.Integer value ) {
		this.__entity_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAccountType() != null) sb.append(__wrapNumber(1, "accountType", getAccountType()));
		if(getEntityId() != null) sb.append(__wrapNumber(1, "entityId", getEntityId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(1, "isCompleted", getIsCompleted()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountType")) != null) setAccountType(__getInt(val)); 
		if((val = values.get("entityId")) != null) setEntityId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getAccountType() != null) res.add("accountType");
		if(getEntityId() != null) res.add("entityId");
		if(getCompanyId() != null) res.add("companyId");
		if(getIsCompleted() != null) res.add("isCompleted");
		return res;
	}

	private java.lang.Integer __account_type = null;
	private java.lang.Integer __entity_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Boolean __is_completed = null;
}

