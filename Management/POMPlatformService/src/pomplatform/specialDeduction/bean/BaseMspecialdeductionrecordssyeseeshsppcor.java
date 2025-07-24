package pomplatform.specialDeduction.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMspecialdeductionrecordssyeseeshsppcor extends GenericBase implements BaseFactory<BaseMspecialdeductionrecordssyeseeshsppcor>, Comparable<BaseMspecialdeductionrecordssyeseeshsppcor> 
{


	public static BaseMspecialdeductionrecordssyeseeshsppcor newInstance(){
		return new BaseMspecialdeductionrecordssyeseeshsppcor();
	}

	@Override
	public BaseMspecialdeductionrecordssyeseeshsppcor make(){
		BaseMspecialdeductionrecordssyeseeshsppcor b = new BaseMspecialdeductionrecordssyeseeshsppcor();
		return b;
	}

	public final static java.lang.String CS_SPECIAL_DEDUCTION_RECORD_ID = "special_deduction_record_id" ;
	public final static java.lang.String CS_EMPLOYE_ID = "employe_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_DETAIL_ID = "special_deduction_detail_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_SCHOOLING = "schooling" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_DEDUCTION_PERCENTAGE = "deduction_percentage" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_NUM = "num" ;
	public final static java.lang.String CS_EDUCATION_TYPE = "education_type" ;
	public final static java.lang.String CS_EDUCATION_STAGE = "education_stage" ;
	public final static java.lang.String CS_HOUSE_FIRST = "house_first" ;
	public final static java.lang.String CS_SINGLE_CHILD = "single_child" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_ID = "special_deduction_type_id" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;

	public final static java.lang.String ALL_CAPTIONS = "id,纳税人id,扣除年度,业务部门,归属公司,创建时间,是否可用,备注,id,父id,当前受教育阶段,有效开始时间,有效结束时间,本人扣除比例,金额(基数),个数,继续教育类型,教育阶段,是否婚前各自首套贷款且婚后分别扣除50%,是否独生,专项类型,租房城市,流程状态 0 发起中  1";

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

	public java.lang.Integer getSpecialDeductionDetailId() {
		return this.__special_deduction_detail_id;
	}

	public void setSpecialDeductionDetailId( java.lang.Integer value ) {
		this.__special_deduction_detail_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getSchooling() {
		return this.__schooling;
	}

	public void setSchooling( java.lang.Integer value ) {
		this.__schooling = value;
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

	public java.math.BigDecimal getDeductionPercentage() {
		return this.__deduction_percentage;
	}

	public void setDeductionPercentage( java.math.BigDecimal value ) {
		this.__deduction_percentage = value;
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

	public java.lang.Integer getHouseFirst() {
		return this.__house_first;
	}

	public void setHouseFirst( java.lang.Integer value ) {
		this.__house_first = value;
	}

	public java.lang.Integer getSingleChild() {
		return this.__single_child;
	}

	public void setSingleChild( java.lang.Integer value ) {
		this.__single_child = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	public java.lang.String getCity() {
		return this.__city;
	}

	public void setCity( java.lang.String value ) {
		this.__city = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public void cloneCopy(BaseMspecialdeductionrecordssyeseeshsppcor __bean){
		__bean.setSpecialDeductionRecordId(getSpecialDeductionRecordId());
		__bean.setEmployeId(getEmployeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setPlateId(getPlateId());
		__bean.setCompanyId(getCompanyId());
		__bean.setCreateDate(getCreateDate());
		__bean.setIsEnable(getIsEnable());
		__bean.setRemark(getRemark());
		__bean.setSpecialDeductionDetailId(getSpecialDeductionDetailId());
		__bean.setParentId(getParentId());
		__bean.setSchooling(getSchooling());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setDeductionPercentage(getDeductionPercentage());
		__bean.setAmount(getAmount());
		__bean.setNum(getNum());
		__bean.setEducationType(getEducationType());
		__bean.setEducationStage(getEducationStage());
		__bean.setHouseFirst(getHouseFirst());
		__bean.setSingleChild(getSingleChild());
		__bean.setSpecialDeductionTypeId(getSpecialDeductionTypeId());
		__bean.setCity(getCity());
		__bean.setProcessStatus(getProcessStatus());
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
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSpecialDeductionDetailId() == null ? "" : getSpecialDeductionDetailId());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getSchooling() == null ? "" : getSchooling());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getDeductionPercentage() == null ? "" : getDeductionPercentage());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		sb.append(",");
		sb.append(getEducationType() == null ? "" : getEducationType());
		sb.append(",");
		sb.append(getEducationStage() == null ? "" : getEducationStage());
		sb.append(",");
		sb.append(getHouseFirst() == null ? "" : getHouseFirst());
		sb.append(",");
		sb.append(getSingleChild() == null ? "" : getSingleChild());
		sb.append(",");
		sb.append(getSpecialDeductionTypeId() == null ? "" : getSpecialDeductionTypeId());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMspecialdeductionrecordssyeseeshsppcor o) {
		return __special_deduction_record_id == null ? -1 : __special_deduction_record_id.compareTo(o.getSpecialDeductionRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employe_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__schooling);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__deduction_percentage);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__num);
		hash = 97 * hash + Objects.hashCode(this.__education_type);
		hash = 97 * hash + Objects.hashCode(this.__education_stage);
		hash = 97 * hash + Objects.hashCode(this.__house_first);
		hash = 97 * hash + Objects.hashCode(this.__single_child);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_id);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMspecialdeductionrecordssyeseeshsppcor o = (BaseMspecialdeductionrecordssyeseeshsppcor)obj;
		if(!Objects.equals(this.__special_deduction_record_id, o.getSpecialDeductionRecordId())) return false;
		if(!Objects.equals(this.__employe_id, o.getEmployeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__special_deduction_detail_id, o.getSpecialDeductionDetailId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__schooling, o.getSchooling())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__deduction_percentage, o.getDeductionPercentage())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		if(!Objects.equals(this.__education_type, o.getEducationType())) return false;
		if(!Objects.equals(this.__education_stage, o.getEducationStage())) return false;
		if(!Objects.equals(this.__house_first, o.getHouseFirst())) return false;
		if(!Objects.equals(this.__single_child, o.getSingleChild())) return false;
		if(!Objects.equals(this.__special_deduction_type_id, o.getSpecialDeductionTypeId())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSpecialDeductionRecordId() != null) sb.append(__wrapNumber(count++, "specialDeductionRecordId", getSpecialDeductionRecordId()));
		if(getEmployeId() != null) sb.append(__wrapNumber(count++, "employeId", getEmployeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSpecialDeductionDetailId() != null) sb.append(__wrapNumber(count++, "specialDeductionDetailId", getSpecialDeductionDetailId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getSchooling() != null) sb.append(__wrapNumber(count++, "schooling", getSchooling()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getDeductionPercentage() != null) sb.append(__wrapDecimal(count++, "deductionPercentage", getDeductionPercentage()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		if(getEducationType() != null) sb.append(__wrapNumber(count++, "educationType", getEducationType()));
		if(getEducationStage() != null) sb.append(__wrapNumber(count++, "educationStage", getEducationStage()));
		if(getHouseFirst() != null) sb.append(__wrapNumber(count++, "houseFirst", getHouseFirst()));
		if(getSingleChild() != null) sb.append(__wrapNumber(count++, "singleChild", getSingleChild()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(count++, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSpecialDeductionRecordId() != null) res.put("specialDeductionRecordId", getSpecialDeductionRecordId());
		if(getEmployeId() != null) res.put("employeId", getEmployeId());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getCreateDate() != null) res.put("createDate", getCreateDate());
		if(getIsEnable() != null) res.put("isEnable", getIsEnable());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getSpecialDeductionDetailId() != null) res.put("specialDeductionDetailId", getSpecialDeductionDetailId());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getSchooling() != null) res.put("schooling", getSchooling());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getDeductionPercentage() != null) res.put("deductionPercentage", getDeductionPercentage());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getNum() != null) res.put("num", getNum());
		if(getEducationType() != null) res.put("educationType", getEducationType());
		if(getEducationStage() != null) res.put("educationStage", getEducationStage());
		if(getHouseFirst() != null) res.put("houseFirst", getHouseFirst());
		if(getSingleChild() != null) res.put("singleChild", getSingleChild());
		if(getSpecialDeductionTypeId() != null) res.put("specialDeductionTypeId", getSpecialDeductionTypeId());
		if(getCity() != null) res.put("city", getCity());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("specialDeductionRecordId")) != null) setSpecialDeductionRecordId(__getInt(val)); 
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("specialDeductionDetailId")) != null) setSpecialDeductionDetailId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("schooling")) != null) setSchooling(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("deductionPercentage")) != null) setDeductionPercentage(__getDecimal(val));  
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("num")) != null) setNum(__getInt(val)); 
		if((val = values.get("educationType")) != null) setEducationType(__getInt(val)); 
		if((val = values.get("educationStage")) != null) setEducationStage(__getInt(val)); 
		if((val = values.get("houseFirst")) != null) setHouseFirst(__getInt(val)); 
		if((val = values.get("singleChild")) != null) setSingleChild(__getInt(val)); 
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __special_deduction_record_id ;
	protected java.lang.Integer  __employe_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __company_id ;
	protected java.util.Date  __create_date ;
	protected java.lang.Boolean  __is_enable ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __special_deduction_detail_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __schooling ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __deduction_percentage ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __num ;
	protected java.lang.Integer  __education_type ;
	protected java.lang.Integer  __education_stage ;
	protected java.lang.Integer  __house_first ;
	protected java.lang.Integer  __single_child ;
	protected java.lang.Integer  __special_deduction_type_id ;
	protected java.lang.String  __city ;
	protected java.lang.Integer  __process_status ;
}
