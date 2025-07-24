package pomplatform.workflow.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMakeEmployeeNo extends GenericCondition{

	public ConditionMakeEmployeeNo(){
		setParameterCount(2);
	}

	public java.lang.Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( java.lang.Integer value ) {
		this.__company_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(1, "companyRecordId", getCompanyRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
	}

	private java.lang.Integer __company_record_id = null;
	private java.lang.Integer __plate_id = null;
}

