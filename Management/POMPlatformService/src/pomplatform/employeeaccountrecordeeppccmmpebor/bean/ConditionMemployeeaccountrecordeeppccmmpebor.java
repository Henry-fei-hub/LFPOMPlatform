package pomplatform.employeeaccountrecordeeppccmmpebor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMemployeeaccountrecordeeppccmmpebor extends GenericCondition{

	public ConditionMemployeeaccountrecordeeppccmmpebor(){
		setParameterCount(5);
	}

	public java.util.Date getMinRecordDate() {
		return this.__min_record_date;
	}

	public void setMinRecordDate( java.util.Date value ) {
		this.__min_record_date = value;
	}

	public java.util.Date getMaxRecordDate() {
		return this.__max_record_date;
	}

	public void setMaxRecordDate( java.util.Date value ) {
		this.__max_record_date = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( java.lang.Integer value ) {
		this.__business_type_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinRecordDate() != null) sb.append(__wrapDate(1, "minRecordDate", getMinRecordDate()));
		if(getMaxRecordDate() != null) sb.append(__wrapDate(1, "maxRecordDate", getMaxRecordDate()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(1, "businessTypeId", getBusinessTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minRecordDate")) != null) setMinRecordDate(__getDate(val)); 
		if((val = values.get("maxRecordDate")) != null) setMaxRecordDate(__getDate(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
	}

	private java.util.Date __min_record_date = null;
	private java.util.Date __max_record_date = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __business_type_id = null;
}

