package pomplatform.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMspecialdeductionrecordsor extends GenericCondition{

	public ConditionMspecialdeductionrecordsor(){
		setParameterCount(17);
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

	public java.lang.Integer getDocumentType() {
		return this.__document_type;
	}

	public void setDocumentType( java.lang.Integer value ) {
		this.__document_type = value;
	}

	public java.lang.Integer getSpouseSituation() {
		return this.__spouse_situation;
	}

	public void setSpouseSituation( java.lang.Integer value ) {
		this.__spouse_situation = value;
	}

	public java.lang.String getName() {
		return this.__name == null ? null : (this.__name.indexOf("%") >= 0 ? this.__name : "%"+this.__name+"%");
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
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

	public java.lang.Integer getHouseBorrower() {
		return this.__house_borrower;
	}

	public void setHouseBorrower( java.lang.Integer value ) {
		this.__house_borrower = value;
	}

	public java.lang.Integer getHouseType() {
		return this.__house_type;
	}

	public void setHouseType( java.lang.Integer value ) {
		this.__house_type = value;
	}

	public java.lang.Integer getHouseFirst() {
		return this.__house_first;
	}

	public void setHouseFirst( java.lang.Integer value ) {
		this.__house_first = value;
	}

	public java.lang.Integer getLoanType() {
		return this.__loan_type;
	}

	public void setLoanType( java.lang.Integer value ) {
		this.__loan_type = value;
	}

	public java.lang.Integer getSingleChild() {
		return this.__single_child;
	}

	public void setSingleChild( java.lang.Integer value ) {
		this.__single_child = value;
	}

	public java.lang.Integer getChangeType() {
		return this.__change_type;
	}

	public void setChangeType( java.lang.Integer value ) {
		this.__change_type = value;
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
		if(getDocumentType() != null) sb.append(__wrapNumber(1, "documentType", getDocumentType()));
		if(getSpouseSituation() != null) sb.append(__wrapNumber(1, "spouseSituation", getSpouseSituation()));
		if(getName() != null) sb.append(__wrapString(1, "name", getName()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(1, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getEducationType() != null) sb.append(__wrapNumber(1, "educationType", getEducationType()));
		if(getEducationStage() != null) sb.append(__wrapNumber(1, "educationStage", getEducationStage()));
		if(getHouseBorrower() != null) sb.append(__wrapNumber(1, "houseBorrower", getHouseBorrower()));
		if(getHouseType() != null) sb.append(__wrapNumber(1, "houseType", getHouseType()));
		if(getHouseFirst() != null) sb.append(__wrapNumber(1, "houseFirst", getHouseFirst()));
		if(getLoanType() != null) sb.append(__wrapNumber(1, "loanType", getLoanType()));
		if(getSingleChild() != null) sb.append(__wrapNumber(1, "singleChild", getSingleChild()));
		if(getChangeType() != null) sb.append(__wrapNumber(1, "changeType", getChangeType()));
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
		if((val = values.get("documentType")) != null) setDocumentType(__getInt(val)); 
		if((val = values.get("spouseSituation")) != null) setSpouseSituation(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("educationType")) != null) setEducationType(__getInt(val)); 
		if((val = values.get("educationStage")) != null) setEducationStage(__getInt(val)); 
		if((val = values.get("houseBorrower")) != null) setHouseBorrower(__getInt(val)); 
		if((val = values.get("houseType")) != null) setHouseType(__getInt(val)); 
		if((val = values.get("houseFirst")) != null) setHouseFirst(__getInt(val)); 
		if((val = values.get("loanType")) != null) setLoanType(__getInt(val)); 
		if((val = values.get("singleChild")) != null) setSingleChild(__getInt(val)); 
		if((val = values.get("changeType")) != null) setChangeType(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	private java.lang.String __year = null;
	private java.lang.Integer __employe_id = null;
	private java.lang.Integer __document_type = null;
	private java.lang.Integer __spouse_situation = null;
	private java.lang.String __name = null;
	private java.lang.Integer __special_deduction_type_id = null;
	private java.lang.Integer __education_type = null;
	private java.lang.Integer __education_stage = null;
	private java.lang.Integer __house_borrower = null;
	private java.lang.Integer __house_type = null;
	private java.lang.Integer __house_first = null;
	private java.lang.Integer __loan_type = null;
	private java.lang.Integer __single_child = null;
	private java.lang.Integer __change_type = null;
	private java.lang.Integer __process_status = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __company_id = null;
}

