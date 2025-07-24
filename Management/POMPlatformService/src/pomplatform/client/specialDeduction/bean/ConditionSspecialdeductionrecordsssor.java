package pomplatform.client.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSspecialdeductionrecordsssor extends GenericCondition{

	public ConditionSspecialdeductionrecordsssor(){
		setParameterCount(19);
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getReason() {
		return this.__reason == null ? null : (this.__reason.indexOf("%") >= 0 ? this.__reason : "%"+this.__reason+"%");
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getEmployeId() {
		return this.__employe_id;
	}

	public void setEmployeId( java.lang.Integer value ) {
		this.__employe_id = value;
	}

	public java.lang.Integer getDeparmentId() {
		return this.__deparment_id;
	}

	public void setDeparmentId( java.lang.Integer value ) {
		this.__deparment_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getSpecialDeductionRecordId() {
		return this.__special_deduction_record_id;
	}

	public void setSpecialDeductionRecordId( java.lang.Integer value ) {
		this.__special_deduction_record_id = value;
	}

	public java.lang.String getSpecialDeductionRecordName() {
		return this.__special_deduction_record_name == null ? null : (this.__special_deduction_record_name.indexOf("%") >= 0 ? this.__special_deduction_record_name : "%"+this.__special_deduction_record_name+"%");
	}

	public void setSpecialDeductionRecordName( java.lang.String value ) {
		this.__special_deduction_record_name = value;
	}

	public java.lang.Integer getSpecialDeductionType() {
		return this.__special_deduction_type;
	}

	public void setSpecialDeductionType( java.lang.Integer value ) {
		this.__special_deduction_type = value;
	}

	public java.lang.Integer getSpecialDeductionEducation() {
		return this.__special_deduction_education;
	}

	public void setSpecialDeductionEducation( java.lang.Integer value ) {
		this.__special_deduction_education = value;
	}

	public java.lang.Integer getSpecialDeductionSupOld() {
		return this.__special_deduction_sup_old;
	}

	public void setSpecialDeductionSupOld( java.lang.Integer value ) {
		this.__special_deduction_sup_old = value;
	}

	public java.lang.Integer getSpecialDeductionId() {
		return this.__special_deduction_id;
	}

	public void setSpecialDeductionId( java.lang.Integer value ) {
		this.__special_deduction_id = value;
	}

	public java.lang.String getAlternateField1() {
		return this.__alternate_field1 == null ? null : (this.__alternate_field1.indexOf("%") >= 0 ? this.__alternate_field1 : "%"+this.__alternate_field1+"%");
	}

	public void setAlternateField1( java.lang.String value ) {
		this.__alternate_field1 = value;
	}

	public java.lang.String getAlternateField2() {
		return this.__alternate_field2 == null ? null : (this.__alternate_field2.indexOf("%") >= 0 ? this.__alternate_field2 : "%"+this.__alternate_field2+"%");
	}

	public void setAlternateField2( java.lang.String value ) {
		this.__alternate_field2 = value;
	}

	public java.lang.String getAlternateField3() {
		return this.__alternate_field3 == null ? null : (this.__alternate_field3.indexOf("%") >= 0 ? this.__alternate_field3 : "%"+this.__alternate_field3+"%");
	}

	public void setAlternateField3( java.lang.String value ) {
		this.__alternate_field3 = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public java.lang.String getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.lang.String value ) {
		this.__start_date = value;
	}

	public java.lang.String getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.lang.String value ) {
		this.__end_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getReason() != null) sb.append(__wrapString(1, "reason", getReason()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getEmployeId() != null) sb.append(__wrapNumber(1, "employeId", getEmployeId()));
		if(getDeparmentId() != null) sb.append(__wrapNumber(1, "deparmentId", getDeparmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getSpecialDeductionRecordId() != null) sb.append(__wrapNumber(1, "specialDeductionRecordId", getSpecialDeductionRecordId()));
		if(getSpecialDeductionRecordName() != null) sb.append(__wrapString(1, "specialDeductionRecordName", getSpecialDeductionRecordName()));
		if(getSpecialDeductionType() != null) sb.append(__wrapNumber(1, "specialDeductionType", getSpecialDeductionType()));
		if(getSpecialDeductionEducation() != null) sb.append(__wrapNumber(1, "specialDeductionEducation", getSpecialDeductionEducation()));
		if(getSpecialDeductionSupOld() != null) sb.append(__wrapNumber(1, "specialDeductionSupOld", getSpecialDeductionSupOld()));
		if(getSpecialDeductionId() != null) sb.append(__wrapNumber(1, "specialDeductionId", getSpecialDeductionId()));
		if(getAlternateField1() != null) sb.append(__wrapString(1, "alternateField1", getAlternateField1()));
		if(getAlternateField2() != null) sb.append(__wrapString(1, "alternateField2", getAlternateField2()));
		if(getAlternateField3() != null) sb.append(__wrapString(1, "alternateField3", getAlternateField3()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(1, "isEnable", getIsEnable()));
		if(getStartDate() != null) sb.append(__wrapString(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapString(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("deparmentId")) != null) setDeparmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("specialDeductionRecordId")) != null) setSpecialDeductionRecordId(__getInt(val)); 
		if((val = values.get("specialDeductionRecordName")) != null) setSpecialDeductionRecordName(__getString(val));
		if((val = values.get("specialDeductionType")) != null) setSpecialDeductionType(__getInt(val)); 
		if((val = values.get("specialDeductionEducation")) != null) setSpecialDeductionEducation(__getInt(val)); 
		if((val = values.get("specialDeductionSupOld")) != null) setSpecialDeductionSupOld(__getInt(val)); 
		if((val = values.get("specialDeductionId")) != null) setSpecialDeductionId(__getInt(val)); 
		if((val = values.get("alternateField1")) != null) setAlternateField1(__getString(val));
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
		if((val = values.get("alternateField3")) != null) setAlternateField3(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("startDate")) != null) setStartDate(__getString(val));
		if((val = values.get("endDate")) != null) setEndDate(__getString(val));
	}

	private java.lang.String __employee_no = null;
	private java.lang.String __reason = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __employe_id = null;
	private java.lang.Integer __deparment_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __special_deduction_record_id = null;
	private java.lang.String __special_deduction_record_name = null;
	private java.lang.Integer __special_deduction_type = null;
	private java.lang.Integer __special_deduction_education = null;
	private java.lang.Integer __special_deduction_sup_old = null;
	private java.lang.Integer __special_deduction_id = null;
	private java.lang.String __alternate_field1 = null;
	private java.lang.String __alternate_field2 = null;
	private java.lang.String __alternate_field3 = null;
	private java.lang.Boolean __is_enable = null;
	private java.lang.String __start_date = null;
	private java.lang.String __end_date = null;
}

