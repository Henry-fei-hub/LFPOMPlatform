package pomplatform.companyarea.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCompanyarea extends GenericCondition{

	public ConditionCompanyarea(){
		setParameterCount(2);
	}

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
	}

	public java.lang.Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( java.lang.Integer value ) {
		this.__company_record_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAreaId() != null) sb.append(__wrapNumber(1, "areaId", getAreaId()));
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(1, "companyRecordId", getCompanyRecordId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val)); 
	}

	private java.lang.Integer __area_id = null;
	private java.lang.Integer __company_record_id = null;
}

