package pomplatform.specialDeduction.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadSpecialExpireData extends GenericBase implements BaseFactory<BaseOnLoadSpecialExpireData>, Comparable<BaseOnLoadSpecialExpireData> 
{


	public static BaseOnLoadSpecialExpireData newInstance(){
		return new BaseOnLoadSpecialExpireData();
	}

	@Override
	public BaseOnLoadSpecialExpireData make(){
		BaseOnLoadSpecialExpireData b = new BaseOnLoadSpecialExpireData();
		return b;
	}

	public final static java.lang.String CS_SPECIAL_DEDUCTION_RECORD_ID = "special_deduction_record_id" ;
	public final static java.lang.String CS_EMPLOYE_ID = "employe_id" ;
	public final static java.lang.String CS_DEPARMENT_ID = "deparment_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_ID = "special_deduction_type_id" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_NAME = "special_deduction_type_name" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;

	public final static java.lang.String ALL_CAPTIONS = "id,纳税人id,部门,业务部门,归属公司,扣除年度,专项类型,专项扣款类型名称,创建时间,有效开始时间,有效结束时间,流程状态 0 发起中  1";

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

	public java.lang.String getYear() {
		return this.__year;
	}

	public void setYear( java.lang.String value ) {
		this.__year = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	public java.lang.String getSpecialDeductionTypeName() {
		return this.__special_deduction_type_name;
	}

	public void setSpecialDeductionTypeName( java.lang.String value ) {
		this.__special_deduction_type_name = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
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

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public void cloneCopy(BaseOnLoadSpecialExpireData __bean){
		__bean.setSpecialDeductionRecordId(getSpecialDeductionRecordId());
		__bean.setEmployeId(getEmployeId());
		__bean.setDeparmentId(getDeparmentId());
		__bean.setPlateId(getPlateId());
		__bean.setCompanyId(getCompanyId());
		__bean.setYear(getYear());
		__bean.setSpecialDeductionTypeId(getSpecialDeductionTypeId());
		__bean.setSpecialDeductionTypeName(getSpecialDeductionTypeName());
		__bean.setCreateDate(getCreateDate());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setProcessStatus(getProcessStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSpecialDeductionRecordId() == null ? "" : getSpecialDeductionRecordId());
		sb.append(",");
		sb.append(getEmployeId() == null ? "" : getEmployeId());
		sb.append(",");
		sb.append(getDeparmentId() == null ? "" : getDeparmentId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getSpecialDeductionTypeId() == null ? "" : getSpecialDeductionTypeId());
		sb.append(",");
		sb.append(getSpecialDeductionTypeName() == null ? "" : getSpecialDeductionTypeName());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadSpecialExpireData o) {
		return __special_deduction_record_id == null ? -1 : __special_deduction_record_id.compareTo(o.getSpecialDeductionRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employe_id);
		hash = 97 * hash + Objects.hashCode(this.__deparment_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_id);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_name);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadSpecialExpireData o = (BaseOnLoadSpecialExpireData)obj;
		if(!Objects.equals(this.__special_deduction_record_id, o.getSpecialDeductionRecordId())) return false;
		if(!Objects.equals(this.__employe_id, o.getEmployeId())) return false;
		if(!Objects.equals(this.__deparment_id, o.getDeparmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__special_deduction_type_id, o.getSpecialDeductionTypeId())) return false;
		if(!Objects.equals(this.__special_deduction_type_name, o.getSpecialDeductionTypeName())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSpecialDeductionRecordId() != null) sb.append(__wrapNumber(count++, "specialDeductionRecordId", getSpecialDeductionRecordId()));
		if(getEmployeId() != null) sb.append(__wrapNumber(count++, "employeId", getEmployeId()));
		if(getDeparmentId() != null) sb.append(__wrapNumber(count++, "deparmentId", getDeparmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getYear() != null) sb.append(__wrapString(count++, "year", getYear()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(count++, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getSpecialDeductionTypeName() != null) sb.append(__wrapString(count++, "specialDeductionTypeName", getSpecialDeductionTypeName()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSpecialDeductionRecordId() != null) res.put("specialDeductionRecordId", getSpecialDeductionRecordId());
		if(getEmployeId() != null) res.put("employeId", getEmployeId());
		if(getDeparmentId() != null) res.put("deparmentId", getDeparmentId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getYear() != null) res.put("year", getYear());
		if(getSpecialDeductionTypeId() != null) res.put("specialDeductionTypeId", getSpecialDeductionTypeId());
		if(getSpecialDeductionTypeName() != null) res.put("specialDeductionTypeName", getSpecialDeductionTypeName());
		if(getCreateDate() != null) res.put("createDate", getCreateDate());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("specialDeductionRecordId")) != null) setSpecialDeductionRecordId(__getInt(val)); 
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("deparmentId")) != null) setDeparmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getString(val));
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("specialDeductionTypeName")) != null) setSpecialDeductionTypeName(__getString(val));
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __special_deduction_record_id ;
	protected java.lang.Integer  __employe_id ;
	protected java.lang.Integer  __deparment_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __year ;
	protected java.lang.Integer  __special_deduction_type_id ;
	protected java.lang.String  __special_deduction_type_name ;
	protected java.util.Date  __create_date ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __process_status ;
}
