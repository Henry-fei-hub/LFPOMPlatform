package pomplatform.specialDeduction.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSspecialdeductionrecordsssor extends GenericBase implements BaseFactory<BaseSspecialdeductionrecordsssor>, Comparable<BaseSspecialdeductionrecordsssor> 
{


	public static BaseSspecialdeductionrecordsssor newInstance(){
		return new BaseSspecialdeductionrecordsssor();
	}

	@Override
	public BaseSspecialdeductionrecordsssor make(){
		BaseSspecialdeductionrecordsssor b = new BaseSspecialdeductionrecordsssor();
		return b;
	}

	public final static java.lang.String CS_SPECIAL_DEDUCTION_RECORD_ID = "special_deduction_record_id" ;
	public final static java.lang.String CS_EMPLOYE_ID = "employe_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_DEPARMENT_ID = "deparment_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_DOCUMENT_TYPE = "document_type" ;
	public final static java.lang.String CS_IDENTIFICATION_NUMBER = "identification_number" ;
	public final static java.lang.String CS_PHONE = "phone" ;
	public final static java.lang.String CS_TAXPAYER_REGISTRATION_NUMBER = "taxpayer_registration_number" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_WITHHOLD_ID = "withhold_id" ;
	public final static java.lang.String CS_WITHHOLD_NAME = "withhold_name" ;
	public final static java.lang.String CS_WITHHOLD_REGISTRATION_NUMBER = "withhold_registration_number" ;
	public final static java.lang.String CS_SPOUSE_SITUATION = "spouse_situation" ;
	public final static java.lang.String CS_SPOUSE_NAME = "spouse_name" ;
	public final static java.lang.String CS_SPOUSE_DOCUMENT_TYPE = "spouse_document_type" ;
	public final static java.lang.String CS_SPOUSE_IDENTIFICATION_NUMBER = "spouse_identification_number" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "id,纳税人id,纳税人名字,有效开始时间,有效结束时间,流程类型,部门,业务部门,归属公司,身份证件类型,纳税人身份证件号码,手机号码,纳税人识别号,联系地址,邮箱,扣缴义务人id,扣缴义务人名称,扣缴义务人纳税人识别号,配偶情况 （0 无  1有）,配偶名称,配偶身份证件类型,配偶身份证件号码,创建时间,是否可用,备注";

	public java.lang.Integer getSpecialDeductionRecordId() {
		return this.__special_deduction_record_id;
	}

	public void setSpecialDeductionRecordId( java.lang.Integer value ) {
		this.__special_deduction_record_id = value;
	}

	public java.lang.Integer getEmployeId() {
		return this.__employe_id;
	}

	public void setEmployeId( java.lang.Integer value ) {
		this.__employe_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getDeparmentId() {
		return this.__deparment_id;
	}

	public void setDeparmentId( java.lang.Integer value ) {
		this.__deparment_id = value;
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

	public java.lang.String getIdentificationNumber() {
		return this.__identification_number;
	}

	public void setIdentificationNumber( java.lang.String value ) {
		this.__identification_number = value;
	}

	public java.lang.String getPhone() {
		return this.__phone;
	}

	public void setPhone( java.lang.String value ) {
		this.__phone = value;
	}

	public java.lang.String getTaxpayerRegistrationNumber() {
		return this.__taxpayer_registration_number;
	}

	public void setTaxpayerRegistrationNumber( java.lang.String value ) {
		this.__taxpayer_registration_number = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.String getEmail() {
		return this.__email;
	}

	public void setEmail( java.lang.String value ) {
		this.__email = value;
	}

	public java.lang.Integer getWithholdId() {
		return this.__withhold_id;
	}

	public void setWithholdId( java.lang.Integer value ) {
		this.__withhold_id = value;
	}

	public java.lang.String getWithholdName() {
		return this.__withhold_name;
	}

	public void setWithholdName( java.lang.String value ) {
		this.__withhold_name = value;
	}

	public java.lang.String getWithholdRegistrationNumber() {
		return this.__withhold_registration_number;
	}

	public void setWithholdRegistrationNumber( java.lang.String value ) {
		this.__withhold_registration_number = value;
	}

	public java.lang.Integer getSpouseSituation() {
		return this.__spouse_situation;
	}

	public void setSpouseSituation( java.lang.Integer value ) {
		this.__spouse_situation = value;
	}

	public java.lang.String getSpouseName() {
		return this.__spouse_name;
	}

	public void setSpouseName( java.lang.String value ) {
		this.__spouse_name = value;
	}

	public java.lang.Integer getSpouseDocumentType() {
		return this.__spouse_document_type;
	}

	public void setSpouseDocumentType( java.lang.Integer value ) {
		this.__spouse_document_type = value;
	}

	public java.lang.String getSpouseIdentificationNumber() {
		return this.__spouse_identification_number;
	}

	public void setSpouseIdentificationNumber( java.lang.String value ) {
		this.__spouse_identification_number = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSspecialdeductionrecordsssor __bean){
		__bean.setSpecialDeductionRecordId(getSpecialDeductionRecordId());
		__bean.setEmployeId(getEmployeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setProcessType(getProcessType());
		__bean.setDeparmentId(getDeparmentId());
		__bean.setPlateId(getPlateId());
		__bean.setCompanyId(getCompanyId());
		__bean.setDocumentType(getDocumentType());
		__bean.setIdentificationNumber(getIdentificationNumber());
		__bean.setPhone(getPhone());
		__bean.setTaxpayerRegistrationNumber(getTaxpayerRegistrationNumber());
		__bean.setAddress(getAddress());
		__bean.setEmail(getEmail());
		__bean.setWithholdId(getWithholdId());
		__bean.setWithholdName(getWithholdName());
		__bean.setWithholdRegistrationNumber(getWithholdRegistrationNumber());
		__bean.setSpouseSituation(getSpouseSituation());
		__bean.setSpouseName(getSpouseName());
		__bean.setSpouseDocumentType(getSpouseDocumentType());
		__bean.setSpouseIdentificationNumber(getSpouseIdentificationNumber());
		__bean.setCreateDate(getCreateDate());
		__bean.setIsEnable(getIsEnable());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSpecialDeductionRecordId() == null ? "" : getSpecialDeductionRecordId());
		sb.append(",");
		sb.append(getEmployeId() == null ? "" : getEmployeId());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getDeparmentId() == null ? "" : getDeparmentId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getDocumentType() == null ? "" : getDocumentType());
		sb.append(",");
		sb.append(getIdentificationNumber() == null ? "" : getIdentificationNumber());
		sb.append(",");
		sb.append(getPhone() == null ? "" : getPhone());
		sb.append(",");
		sb.append(getTaxpayerRegistrationNumber() == null ? "" : getTaxpayerRegistrationNumber());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getWithholdId() == null ? "" : getWithholdId());
		sb.append(",");
		sb.append(getWithholdName() == null ? "" : getWithholdName());
		sb.append(",");
		sb.append(getWithholdRegistrationNumber() == null ? "" : getWithholdRegistrationNumber());
		sb.append(",");
		sb.append(getSpouseSituation() == null ? "" : getSpouseSituation());
		sb.append(",");
		sb.append(getSpouseName() == null ? "" : getSpouseName());
		sb.append(",");
		sb.append(getSpouseDocumentType() == null ? "" : getSpouseDocumentType());
		sb.append(",");
		sb.append(getSpouseIdentificationNumber() == null ? "" : getSpouseIdentificationNumber());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSspecialdeductionrecordsssor o) {
		return __special_deduction_record_id == null ? -1 : __special_deduction_record_id.compareTo(o.getSpecialDeductionRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employe_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__deparment_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__document_type);
		hash = 97 * hash + Objects.hashCode(this.__identification_number);
		hash = 97 * hash + Objects.hashCode(this.__phone);
		hash = 97 * hash + Objects.hashCode(this.__taxpayer_registration_number);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__withhold_id);
		hash = 97 * hash + Objects.hashCode(this.__withhold_name);
		hash = 97 * hash + Objects.hashCode(this.__withhold_registration_number);
		hash = 97 * hash + Objects.hashCode(this.__spouse_situation);
		hash = 97 * hash + Objects.hashCode(this.__spouse_name);
		hash = 97 * hash + Objects.hashCode(this.__spouse_document_type);
		hash = 97 * hash + Objects.hashCode(this.__spouse_identification_number);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSspecialdeductionrecordsssor o = (BaseSspecialdeductionrecordsssor)obj;
		if(!Objects.equals(this.__special_deduction_record_id, o.getSpecialDeductionRecordId())) return false;
		if(!Objects.equals(this.__employe_id, o.getEmployeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__deparment_id, o.getDeparmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__document_type, o.getDocumentType())) return false;
		if(!Objects.equals(this.__identification_number, o.getIdentificationNumber())) return false;
		if(!Objects.equals(this.__phone, o.getPhone())) return false;
		if(!Objects.equals(this.__taxpayer_registration_number, o.getTaxpayerRegistrationNumber())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__withhold_id, o.getWithholdId())) return false;
		if(!Objects.equals(this.__withhold_name, o.getWithholdName())) return false;
		if(!Objects.equals(this.__withhold_registration_number, o.getWithholdRegistrationNumber())) return false;
		if(!Objects.equals(this.__spouse_situation, o.getSpouseSituation())) return false;
		if(!Objects.equals(this.__spouse_name, o.getSpouseName())) return false;
		if(!Objects.equals(this.__spouse_document_type, o.getSpouseDocumentType())) return false;
		if(!Objects.equals(this.__spouse_identification_number, o.getSpouseIdentificationNumber())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSpecialDeductionRecordId() != null) sb.append(__wrapNumber(count++, "specialDeductionRecordId", getSpecialDeductionRecordId()));
		if(getEmployeId() != null) sb.append(__wrapNumber(count++, "employeId", getEmployeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getDeparmentId() != null) sb.append(__wrapNumber(count++, "deparmentId", getDeparmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDocumentType() != null) sb.append(__wrapNumber(count++, "documentType", getDocumentType()));
		if(getIdentificationNumber() != null) sb.append(__wrapString(count++, "identificationNumber", getIdentificationNumber()));
		if(getPhone() != null) sb.append(__wrapString(count++, "phone", getPhone()));
		if(getTaxpayerRegistrationNumber() != null) sb.append(__wrapString(count++, "taxpayerRegistrationNumber", getTaxpayerRegistrationNumber()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getWithholdId() != null) sb.append(__wrapNumber(count++, "withholdId", getWithholdId()));
		if(getWithholdName() != null) sb.append(__wrapString(count++, "withholdName", getWithholdName()));
		if(getWithholdRegistrationNumber() != null) sb.append(__wrapString(count++, "withholdRegistrationNumber", getWithholdRegistrationNumber()));
		if(getSpouseSituation() != null) sb.append(__wrapNumber(count++, "spouseSituation", getSpouseSituation()));
		if(getSpouseName() != null) sb.append(__wrapString(count++, "spouseName", getSpouseName()));
		if(getSpouseDocumentType() != null) sb.append(__wrapNumber(count++, "spouseDocumentType", getSpouseDocumentType()));
		if(getSpouseIdentificationNumber() != null) sb.append(__wrapString(count++, "spouseIdentificationNumber", getSpouseIdentificationNumber()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSpecialDeductionRecordId() != null) res.put("specialDeductionRecordId", getSpecialDeductionRecordId());
		if(getEmployeId() != null) res.put("employeId", getEmployeId());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getDeparmentId() != null) res.put("deparmentId", getDeparmentId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getDocumentType() != null) res.put("documentType", getDocumentType());
		if(getIdentificationNumber() != null) res.put("identificationNumber", getIdentificationNumber());
		if(getPhone() != null) res.put("phone", getPhone());
		if(getTaxpayerRegistrationNumber() != null) res.put("taxpayerRegistrationNumber", getTaxpayerRegistrationNumber());
		if(getAddress() != null) res.put("address", getAddress());
		if(getEmail() != null) res.put("email", getEmail());
		if(getWithholdId() != null) res.put("withholdId", getWithholdId());
		if(getWithholdName() != null) res.put("withholdName", getWithholdName());
		if(getWithholdRegistrationNumber() != null) res.put("withholdRegistrationNumber", getWithholdRegistrationNumber());
		if(getSpouseSituation() != null) res.put("spouseSituation", getSpouseSituation());
		if(getSpouseName() != null) res.put("spouseName", getSpouseName());
		if(getSpouseDocumentType() != null) res.put("spouseDocumentType", getSpouseDocumentType());
		if(getSpouseIdentificationNumber() != null) res.put("spouseIdentificationNumber", getSpouseIdentificationNumber());
		if(getCreateDate() != null) res.put("createDate", getCreateDate());
		if(getIsEnable() != null) res.put("isEnable", getIsEnable());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("specialDeductionRecordId")) != null) setSpecialDeductionRecordId(__getInt(val)); 
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("deparmentId")) != null) setDeparmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("documentType")) != null) setDocumentType(__getInt(val)); 
		if((val = values.get("identificationNumber")) != null) setIdentificationNumber(__getString(val));
		if((val = values.get("phone")) != null) setPhone(__getString(val)); 
		if((val = values.get("taxpayerRegistrationNumber")) != null) setTaxpayerRegistrationNumber(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("withholdId")) != null) setWithholdId(__getInt(val)); 
		if((val = values.get("withholdName")) != null) setWithholdName(__getString(val));
		if((val = values.get("withholdRegistrationNumber")) != null) setWithholdRegistrationNumber(__getString(val));
		if((val = values.get("spouseSituation")) != null) setSpouseSituation(__getInt(val)); 
		if((val = values.get("spouseName")) != null) setSpouseName(__getString(val));
		if((val = values.get("spouseDocumentType")) != null) setSpouseDocumentType(__getInt(val)); 
		if((val = values.get("spouseIdentificationNumber")) != null) setSpouseIdentificationNumber(__getString(val));
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __special_deduction_record_id ;
	protected java.lang.Integer  __employe_id ;
	protected java.lang.String  __employee_name ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __deparment_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __document_type ;
	protected java.lang.String  __identification_number ;
	protected java.lang.String  __phone ;
	protected java.lang.String  __taxpayer_registration_number ;
	protected java.lang.String  __address ;
	protected java.lang.String  __email ;
	protected java.lang.Integer  __withhold_id ;
	protected java.lang.String  __withhold_name ;
	protected java.lang.String  __withhold_registration_number ;
	protected java.lang.Integer  __spouse_situation ;
	protected java.lang.String  __spouse_name ;
	protected java.lang.Integer  __spouse_document_type ;
	protected java.lang.String  __spouse_identification_number ;
	protected java.util.Date  __create_date ;
	protected java.lang.Boolean  __is_enable ;
	protected java.lang.String  __remark ;
}
