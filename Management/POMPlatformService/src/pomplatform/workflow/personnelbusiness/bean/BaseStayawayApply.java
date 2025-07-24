package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseStayawayApply extends GenericBase implements BaseFactory<BaseStayawayApply>, Comparable<BaseStayawayApply> 
{


	public static BaseStayawayApply newInstance(){
		return new BaseStayawayApply();
	}

	@Override
	public BaseStayawayApply make(){
		BaseStayawayApply b = new BaseStayawayApply();
		return b;
	}

	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_START_DATE_DETAIL = "start_date_detail" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_END_DATE_DETAIL = "end_date_detail" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_PLAN = "plan" ;
	public final static java.lang.String CS_TRANSPORTATION = "transportation" ;
	public final static java.lang.String CS_FEE = "fee" ;
	public final static java.lang.String CS_UNIT = "unit" ;
	public final static java.lang.String CS_CONTACT_PERSON = "contact_person" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "人事业务编码,流程类型,申请人,工号,部门,归属公司,假期类型,开始日期,0上午   1下午,截止日期,0上午   1下午,天数,申请缘由,备注,地址,计划安排,交通工具,预计费用,外访单位,联系人,起草时间,删除状态  0未删除    1已删除";

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Integer getStartDateDetail() {
		return this.__start_date_detail;
	}

	public void setStartDateDetail( java.lang.Integer value ) {
		this.__start_date_detail = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getEndDateDetail() {
		return this.__end_date_detail;
	}

	public void setEndDateDetail( java.lang.Integer value ) {
		this.__end_date_detail = value;
	}

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
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

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.String getPlan() {
		return this.__plan;
	}

	public void setPlan( java.lang.String value ) {
		this.__plan = value;
	}

	public java.lang.String getTransportation() {
		return this.__transportation;
	}

	public void setTransportation( java.lang.String value ) {
		this.__transportation = value;
	}

	public java.math.BigDecimal getFee() {
		return this.__fee;
	}

	public void setFee( java.math.BigDecimal value ) {
		this.__fee = value;
	}

	public java.lang.String getUnit() {
		return this.__unit;
	}

	public void setUnit( java.lang.String value ) {
		this.__unit = value;
	}

	public java.lang.String getContactPerson() {
		return this.__contact_person;
	}

	public void setContactPerson( java.lang.String value ) {
		this.__contact_person = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public void cloneCopy(BaseStayawayApply __bean){
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCompanyId(getCompanyId());
		__bean.setType(getType());
		__bean.setStartDate(getStartDate());
		__bean.setStartDateDetail(getStartDateDetail());
		__bean.setEndDate(getEndDate());
		__bean.setEndDateDetail(getEndDateDetail());
		__bean.setDays(getDays());
		__bean.setReason(getReason());
		__bean.setRemark(getRemark());
		__bean.setAddress(getAddress());
		__bean.setPlan(getPlan());
		__bean.setTransportation(getTransportation());
		__bean.setFee(getFee());
		__bean.setUnit(getUnit());
		__bean.setContactPerson(getContactPerson());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getStartDateDetail() == null ? "" : getStartDateDetail());
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getEndDateDetail() == null ? "" : getEndDateDetail());
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getPlan() == null ? "" : getPlan());
		sb.append(",");
		sb.append(getTransportation() == null ? "" : getTransportation());
		sb.append(",");
		sb.append(getFee() == null ? "" : getFee());
		sb.append(",");
		sb.append(getUnit() == null ? "" : getUnit());
		sb.append(",");
		sb.append(getContactPerson() == null ? "" : getContactPerson());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStayawayApply o) {
		return __personnel_business_id == null ? -1 : __personnel_business_id.compareTo(o.getPersonnelBusinessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__plan);
		hash = 97 * hash + Objects.hashCode(this.__transportation);
		hash = 97 * hash + Objects.hashCode(this.__fee);
		hash = 97 * hash + Objects.hashCode(this.__unit);
		hash = 97 * hash + Objects.hashCode(this.__contact_person);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStayawayApply o = (BaseStayawayApply)obj;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__start_date_detail, o.getStartDateDetail())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__end_date_detail, o.getEndDateDetail())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__plan, o.getPlan())) return false;
		if(!Objects.equals(this.__transportation, o.getTransportation())) return false;
		if(!Objects.equals(this.__fee, o.getFee())) return false;
		if(!Objects.equals(this.__unit, o.getUnit())) return false;
		if(!Objects.equals(this.__contact_person, o.getContactPerson())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getStartDateDetail() != null) sb.append(__wrapNumber(count++, "startDateDetail", getStartDateDetail()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getEndDateDetail() != null) sb.append(__wrapNumber(count++, "endDateDetail", getEndDateDetail()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getPlan() != null) sb.append(__wrapString(count++, "plan", getPlan()));
		if(getTransportation() != null) sb.append(__wrapString(count++, "transportation", getTransportation()));
		if(getFee() != null) sb.append(__wrapDecimal(count++, "fee", getFee()));
		if(getUnit() != null) sb.append(__wrapString(count++, "unit", getUnit()));
		if(getContactPerson() != null) sb.append(__wrapString(count++, "contactPerson", getContactPerson()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("startDateDetail")) != null) setStartDateDetail(__getInt(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("endDateDetail")) != null) setEndDateDetail(__getInt(val)); 
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("plan")) != null) setPlan(__getString(val));
		if((val = values.get("transportation")) != null) setTransportation(__getString(val));
		if((val = values.get("fee")) != null) setFee(__getDecimal(val));  
		if((val = values.get("unit")) != null) setUnit(__getString(val));
		if((val = values.get("contactPerson")) != null) setContactPerson(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __type ;
	protected java.util.Date  __start_date ;
	protected java.lang.Integer  __start_date_detail ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __end_date_detail ;
	protected java.math.BigDecimal  __days ;
	protected java.lang.String  __reason ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __address ;
	protected java.lang.String  __plan ;
	protected java.lang.String  __transportation ;
	protected java.math.BigDecimal  __fee ;
	protected java.lang.String  __unit ;
	protected java.lang.String  __contact_person ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
}
