package pomplatform.contractincome.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionContractIncomeBasicInfo extends GenericCondition{

	public ConditionContractIncomeBasicInfo(){
		setParameterCount(4);
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Boolean getCopyIncomeLedger() {
		return this.__copy_income_ledger;
	}

	public void setCopyIncomeLedger( java.lang.Boolean value ) {
		this.__copy_income_ledger = value;
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
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getCopyIncomeLedger() != null) sb.append(__wrapBoolean(1, "copyIncomeLedger", getCopyIncomeLedger()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("copyIncomeLedger")) != null) setCopyIncomeLedger(__getBoolean(val));
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	private java.lang.Integer __project_type = null;
	private java.util.Date __start_date = null;
	private java.lang.Boolean __copy_income_ledger = null;
	private java.util.Date __end_date = null;
}

