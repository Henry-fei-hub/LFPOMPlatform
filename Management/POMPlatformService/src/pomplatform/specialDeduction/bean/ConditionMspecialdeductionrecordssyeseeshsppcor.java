package pomplatform.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMspecialdeductionrecordssyeseeshsppcor extends GenericCondition{

	public ConditionMspecialdeductionrecordssyeseeshsppcor(){
		setParameterCount(11);
	}

	public java.lang.String getYear() {
		return this.__year;
	}

	public void setYear( java.lang.String value ) {
		this.__year = value;
	}

	public java.lang.Integer getEmployeId() {
		return this.__employe_id;
	}

	public void setEmployeId( java.lang.Integer value ) {
		this.__employe_id = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	public java.lang.Integer getEducationType() {
		return this.__education_type;
	}

	public void setEducationType( java.lang.Integer value ) {
		this.__education_type = value;
	}

	public java.lang.Integer getEducationStage() {
		return this.__education_stage;
	}

	public void setEducationStage( java.lang.Integer value ) {
		this.__education_stage = value;
	}

	public java.lang.Integer getSingleChild() {
		return this.__single_child;
	}

	public void setSingleChild( java.lang.Integer value ) {
		this.__single_child = value;
	}

	public java.lang.Integer getHouseFirst() {
		return this.__house_first;
	}

	public void setHouseFirst( java.lang.Integer value ) {
		this.__house_first = value;
	}

	public java.lang.Integer getSchooling() {
		return this.__schooling;
	}

	public void setSchooling( java.lang.Integer value ) {
		this.__schooling = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapString(1, "year", getYear()));
		if(getEmployeId() != null) sb.append(__wrapNumber(1, "employeId", getEmployeId()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(1, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getEducationType() != null) sb.append(__wrapNumber(1, "educationType", getEducationType()));
		if(getEducationStage() != null) sb.append(__wrapNumber(1, "educationStage", getEducationStage()));
		if(getSingleChild() != null) sb.append(__wrapNumber(1, "singleChild", getSingleChild()));
		if(getHouseFirst() != null) sb.append(__wrapNumber(1, "houseFirst", getHouseFirst()));
		if(getSchooling() != null) sb.append(__wrapNumber(1, "schooling", getSchooling()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getString(val));
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("educationType")) != null) setEducationType(__getInt(val)); 
		if((val = values.get("educationStage")) != null) setEducationStage(__getInt(val)); 
		if((val = values.get("singleChild")) != null) setSingleChild(__getInt(val)); 
		if((val = values.get("houseFirst")) != null) setHouseFirst(__getInt(val)); 
		if((val = values.get("schooling")) != null) setSchooling(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	private java.lang.String __year = null;
	private java.lang.Integer __employe_id = null;
	private java.lang.Integer __special_deduction_type_id = null;
	private java.lang.Integer __education_type = null;
	private java.lang.Integer __education_stage = null;
	private java.lang.Integer __single_child = null;
	private java.lang.Integer __house_first = null;
	private java.lang.Integer __schooling = null;
	private java.lang.Integer __process_status = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __company_id = null;
}

