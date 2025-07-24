package pomplatform.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSspecialdeductionsepor extends GenericCondition{

	public ConditionSspecialdeductionsepor(){
		setParameterCount(7);
	}

	public java.lang.Integer getSpecialDeductionId() {
		return this.__special_deduction_id;
	}

	public void setSpecialDeductionId( java.lang.Integer value ) {
		this.__special_deduction_id = value;
	}

	public java.lang.Integer getEmployeId() {
		return this.__employe_id;
	}

	public void setEmployeId( java.lang.Integer value ) {
		this.__employe_id = value;
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

	public java.lang.Integer getDocumentType() {
		return this.__document_type;
	}

	public void setDocumentType( java.lang.Integer value ) {
		this.__document_type = value;
	}

	public java.lang.Integer getSpouseDocumentType() {
		return this.__spouse_document_type;
	}

	public void setSpouseDocumentType( java.lang.Integer value ) {
		this.__spouse_document_type = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSpecialDeductionId() != null) sb.append(__wrapNumber(1, "specialDeductionId", getSpecialDeductionId()));
		if(getEmployeId() != null) sb.append(__wrapNumber(1, "employeId", getEmployeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getDocumentType() != null) sb.append(__wrapNumber(1, "documentType", getDocumentType()));
		if(getSpouseDocumentType() != null) sb.append(__wrapNumber(1, "spouseDocumentType", getSpouseDocumentType()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(1, "isEnable", getIsEnable()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("specialDeductionId")) != null) setSpecialDeductionId(__getInt(val)); 
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("documentType")) != null) setDocumentType(__getInt(val)); 
		if((val = values.get("spouseDocumentType")) != null) setSpouseDocumentType(__getInt(val)); 
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
	}

	private java.lang.Integer __special_deduction_id = null;
	private java.lang.Integer __employe_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __document_type = null;
	private java.lang.Integer __spouse_document_type = null;
	private java.lang.Boolean __is_enable = null;
}

