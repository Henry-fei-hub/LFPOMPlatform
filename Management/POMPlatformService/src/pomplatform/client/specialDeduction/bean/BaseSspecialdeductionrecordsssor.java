package pomplatform.client.specialDeduction.bean;

import java.util.Map;
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
	public final static java.lang.String CS_SPECIAL_DEDUCTION_RECORD_NAME = "special_deduction_record_name" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_NUM = "num" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE = "special_deduction_type" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TIME = "special_deduction_time" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_EDUCATION = "special_deduction_education" ;
	public final static java.lang.String CS_EDUCATION_AMOUNT = "education_amount" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_SUP_OLD = "special_deduction_sup_old" ;
	public final static java.lang.String CS_SUP_OLD_AMOUNT = "sup_old_amount" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_ID = "special_deduction_id" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_FILE_URL = "special_deduction_file_url" ;
	public final static java.lang.String CS_ALTERNATE_FIELD1 = "alternate_field1" ;
	public final static java.lang.String CS_ALTERNATE_FIELD2 = "alternate_field2" ;
	public final static java.lang.String CS_ALTERNATE_FIELD3 = "alternate_field3" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_EMPLOYE_ID = "employe_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARMENT_ID = "deparment_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,名字,基数,个数,类型,最长时间跨度,教育类型,教育类型金额,是否独生,赡养老人金额,file编码,fileurl,备用字段1,备用字段2,备用字段3,是否可用,有效开始日期,有效结束日期,创建日期,流程类型,申请人,工号,部门,归属公司,原因,备注";

	public java.lang.Integer getSpecialDeductionRecordId() {
		return this.__special_deduction_record_id;
	}

	public void setSpecialDeductionRecordId( java.lang.Integer value ) {
		this.__special_deduction_record_id = value;
	}

	public java.lang.String getSpecialDeductionRecordName() {
		return this.__special_deduction_record_name;
	}

	public void setSpecialDeductionRecordName( java.lang.String value ) {
		this.__special_deduction_record_name = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Integer value ) {
		this.__num = value;
	}

	public java.lang.Integer getSpecialDeductionType() {
		return this.__special_deduction_type;
	}

	public void setSpecialDeductionType( java.lang.Integer value ) {
		this.__special_deduction_type = value;
	}

	public java.lang.String getSpecialDeductionTime() {
		return this.__special_deduction_time;
	}

	public void setSpecialDeductionTime( java.lang.String value ) {
		this.__special_deduction_time = value;
	}

	public java.lang.Integer getSpecialDeductionEducation() {
		return this.__special_deduction_education;
	}

	public void setSpecialDeductionEducation( java.lang.Integer value ) {
		this.__special_deduction_education = value;
	}

	public java.math.BigDecimal getEducationAmount() {
		return this.__education_amount;
	}

	public void setEducationAmount( java.math.BigDecimal value ) {
		this.__education_amount = value;
	}

	public java.lang.Integer getSpecialDeductionSupOld() {
		return this.__special_deduction_sup_old;
	}

	public void setSpecialDeductionSupOld( java.lang.Integer value ) {
		this.__special_deduction_sup_old = value;
	}

	public java.math.BigDecimal getSupOldAmount() {
		return this.__sup_old_amount;
	}

	public void setSupOldAmount( java.math.BigDecimal value ) {
		this.__sup_old_amount = value;
	}

	public java.lang.Integer getSpecialDeductionId() {
		return this.__special_deduction_id;
	}

	public void setSpecialDeductionId( java.lang.Integer value ) {
		this.__special_deduction_id = value;
	}

	public java.lang.String getSpecialDeductionFileUrl() {
		return this.__special_deduction_file_url;
	}

	public void setSpecialDeductionFileUrl( java.lang.String value ) {
		this.__special_deduction_file_url = value;
	}

	public java.lang.String getAlternateField1() {
		return this.__alternate_field1;
	}

	public void setAlternateField1( java.lang.String value ) {
		this.__alternate_field1 = value;
	}

	public java.lang.String getAlternateField2() {
		return this.__alternate_field2;
	}

	public void setAlternateField2( java.lang.String value ) {
		this.__alternate_field2 = value;
	}

	public java.lang.String getAlternateField3() {
		return this.__alternate_field3;
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

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
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

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
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

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSspecialdeductionrecordsssor __bean){
		__bean.setSpecialDeductionRecordId(getSpecialDeductionRecordId());
		__bean.setSpecialDeductionRecordName(getSpecialDeductionRecordName());
		__bean.setAmount(getAmount());
		__bean.setNum(getNum());
		__bean.setSpecialDeductionType(getSpecialDeductionType());
		__bean.setSpecialDeductionTime(getSpecialDeductionTime());
		__bean.setSpecialDeductionEducation(getSpecialDeductionEducation());
		__bean.setEducationAmount(getEducationAmount());
		__bean.setSpecialDeductionSupOld(getSpecialDeductionSupOld());
		__bean.setSupOldAmount(getSupOldAmount());
		__bean.setSpecialDeductionId(getSpecialDeductionId());
		__bean.setSpecialDeductionFileUrl(getSpecialDeductionFileUrl());
		__bean.setAlternateField1(getAlternateField1());
		__bean.setAlternateField2(getAlternateField2());
		__bean.setAlternateField3(getAlternateField3());
		__bean.setIsEnable(getIsEnable());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setCreateDate(getCreateDate());
		__bean.setProcessType(getProcessType());
		__bean.setEmployeId(getEmployeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDeparmentId(getDeparmentId());
		__bean.setCompanyId(getCompanyId());
		__bean.setReason(getReason());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSpecialDeductionRecordId() == null ? "" : getSpecialDeductionRecordId());
		sb.append(",");
		sb.append(getSpecialDeductionRecordName() == null ? "" : getSpecialDeductionRecordName());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		sb.append(",");
		sb.append(getSpecialDeductionType() == null ? "" : getSpecialDeductionType());
		sb.append(",");
		sb.append(getSpecialDeductionTime() == null ? "" : getSpecialDeductionTime());
		sb.append(",");
		sb.append(getSpecialDeductionEducation() == null ? "" : getSpecialDeductionEducation());
		sb.append(",");
		sb.append(getEducationAmount() == null ? "" : getEducationAmount());
		sb.append(",");
		sb.append(getSpecialDeductionSupOld() == null ? "" : getSpecialDeductionSupOld());
		sb.append(",");
		sb.append(getSupOldAmount() == null ? "" : getSupOldAmount());
		sb.append(",");
		sb.append(getSpecialDeductionId() == null ? "" : getSpecialDeductionId());
		sb.append(",");
		sb.append(getSpecialDeductionFileUrl() == null ? "" : getSpecialDeductionFileUrl());
		sb.append(",");
		sb.append(getAlternateField1() == null ? "" : getAlternateField1());
		sb.append(",");
		sb.append(getAlternateField2() == null ? "" : getAlternateField2());
		sb.append(",");
		sb.append(getAlternateField3() == null ? "" : getAlternateField3());
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getEmployeId() == null ? "" : getEmployeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getDeparmentId() == null ? "" : getDeparmentId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
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
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_record_name);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__num);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_time);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_education);
		hash = 97 * hash + Objects.hashCode(this.__education_amount);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_sup_old);
		hash = 97 * hash + Objects.hashCode(this.__sup_old_amount);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_id);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_file_url);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field1);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field2);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field3);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__employe_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__deparment_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSspecialdeductionrecordsssor o = (BaseSspecialdeductionrecordsssor)obj;
		if(!Objects.equals(this.__special_deduction_record_id, o.getSpecialDeductionRecordId())) return false;
		if(!Objects.equals(this.__special_deduction_record_name, o.getSpecialDeductionRecordName())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		if(!Objects.equals(this.__special_deduction_type, o.getSpecialDeductionType())) return false;
		if(!Objects.equals(this.__special_deduction_time, o.getSpecialDeductionTime())) return false;
		if(!Objects.equals(this.__special_deduction_education, o.getSpecialDeductionEducation())) return false;
		if(!Objects.equals(this.__education_amount, o.getEducationAmount())) return false;
		if(!Objects.equals(this.__special_deduction_sup_old, o.getSpecialDeductionSupOld())) return false;
		if(!Objects.equals(this.__sup_old_amount, o.getSupOldAmount())) return false;
		if(!Objects.equals(this.__special_deduction_id, o.getSpecialDeductionId())) return false;
		if(!Objects.equals(this.__special_deduction_file_url, o.getSpecialDeductionFileUrl())) return false;
		if(!Objects.equals(this.__alternate_field1, o.getAlternateField1())) return false;
		if(!Objects.equals(this.__alternate_field2, o.getAlternateField2())) return false;
		if(!Objects.equals(this.__alternate_field3, o.getAlternateField3())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__employe_id, o.getEmployeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__deparment_id, o.getDeparmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSpecialDeductionRecordId() != null) sb.append(__wrapNumber(count++, "specialDeductionRecordId", getSpecialDeductionRecordId()));
		if(getSpecialDeductionRecordName() != null) sb.append(__wrapString(count++, "specialDeductionRecordName", getSpecialDeductionRecordName()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		if(getSpecialDeductionType() != null) sb.append(__wrapNumber(count++, "specialDeductionType", getSpecialDeductionType()));
		if(getSpecialDeductionTime() != null) sb.append(__wrapString(count++, "specialDeductionTime", getSpecialDeductionTime()));
		if(getSpecialDeductionEducation() != null) sb.append(__wrapNumber(count++, "specialDeductionEducation", getSpecialDeductionEducation()));
		if(getEducationAmount() != null) sb.append(__wrapDecimal(count++, "educationAmount", getEducationAmount()));
		if(getSpecialDeductionSupOld() != null) sb.append(__wrapNumber(count++, "specialDeductionSupOld", getSpecialDeductionSupOld()));
		if(getSupOldAmount() != null) sb.append(__wrapDecimal(count++, "supOldAmount", getSupOldAmount()));
		if(getSpecialDeductionId() != null) sb.append(__wrapNumber(count++, "specialDeductionId", getSpecialDeductionId()));
		if(getSpecialDeductionFileUrl() != null) sb.append(__wrapString(count++, "specialDeductionFileUrl", getSpecialDeductionFileUrl()));
		if(getAlternateField1() != null) sb.append(__wrapString(count++, "alternateField1", getAlternateField1()));
		if(getAlternateField2() != null) sb.append(__wrapString(count++, "alternateField2", getAlternateField2()));
		if(getAlternateField3() != null) sb.append(__wrapString(count++, "alternateField3", getAlternateField3()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getEmployeId() != null) sb.append(__wrapNumber(count++, "employeId", getEmployeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDeparmentId() != null) sb.append(__wrapNumber(count++, "deparmentId", getDeparmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("specialDeductionRecordId")) != null) setSpecialDeductionRecordId(__getInt(val)); 
		if((val = values.get("specialDeductionRecordName")) != null) setSpecialDeductionRecordName(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("num")) != null) setNum(__getInt(val)); 
		if((val = values.get("specialDeductionType")) != null) setSpecialDeductionType(__getInt(val)); 
		if((val = values.get("specialDeductionTime")) != null) setSpecialDeductionTime(__getString(val));
		if((val = values.get("specialDeductionEducation")) != null) setSpecialDeductionEducation(__getInt(val)); 
		if((val = values.get("educationAmount")) != null) setEducationAmount(__getDecimal(val));  
		if((val = values.get("specialDeductionSupOld")) != null) setSpecialDeductionSupOld(__getInt(val)); 
		if((val = values.get("supOldAmount")) != null) setSupOldAmount(__getDecimal(val));  
		if((val = values.get("specialDeductionId")) != null) setSpecialDeductionId(__getInt(val)); 
		if((val = values.get("specialDeductionFileUrl")) != null) setSpecialDeductionFileUrl(__getString(val));
		if((val = values.get("alternateField1")) != null) setAlternateField1(__getString(val));
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
		if((val = values.get("alternateField3")) != null) setAlternateField3(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("deparmentId")) != null) setDeparmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __special_deduction_record_id ;
	protected java.lang.String  __special_deduction_record_name ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __num ;
	protected java.lang.Integer  __special_deduction_type ;
	protected java.lang.String  __special_deduction_time ;
	protected java.lang.Integer  __special_deduction_education ;
	protected java.math.BigDecimal  __education_amount ;
	protected java.lang.Integer  __special_deduction_sup_old ;
	protected java.math.BigDecimal  __sup_old_amount ;
	protected java.lang.Integer  __special_deduction_id ;
	protected java.lang.String  __special_deduction_file_url ;
	protected java.lang.String  __alternate_field1 ;
	protected java.lang.String  __alternate_field2 ;
	protected java.lang.String  __alternate_field3 ;
	protected java.lang.Boolean  __is_enable ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.util.Date  __create_date ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __employe_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __deparment_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __reason ;
	protected java.lang.String  __remark ;
}
