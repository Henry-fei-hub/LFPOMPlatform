package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeSalaryAdjustmentDetail extends GenericBase implements BaseFactory<BaseEmployeeSalaryAdjustmentDetail>, Comparable<BaseEmployeeSalaryAdjustmentDetail> 
{


	public static BaseEmployeeSalaryAdjustmentDetail newInstance(){
		return new BaseEmployeeSalaryAdjustmentDetail();
	}

	@Override
	public BaseEmployeeSalaryAdjustmentDetail make(){
		BaseEmployeeSalaryAdjustmentDetail b = new BaseEmployeeSalaryAdjustmentDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_TARGET_PROVINCE = "target_province" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_FEE = "fee" ;
	public final static java.lang.String CS_ORIGINAL_PAY = "original_pay" ;
	public final static java.lang.String CS_SEVERANCE = "severance" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_SUB_TYPE = "sub_type" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;

	public final static java.lang.String ALL_CAPTIONS = "姓名,工号,业务部门,归属部门,入职日期,调薪日期,个人效益指数,现薪资,调薪金额,调整后薪资总额,调薪比例,人事业务编码,流程类型,流程编码,流程实列编码";
	public final static java.lang.String EXPORT_CAPTIONS = "姓名,工号,业务部门,归属部门,入职日期,调薪日期,个人效益指数,现薪资,调薪金额,调整后薪资总额,调薪比例";
	
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

	public java.lang.Integer getTargetProvince() {
		return this.__target_province;
	}

	public void setTargetProvince( java.lang.Integer value ) {
		this.__target_province = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
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

	public java.math.BigDecimal getFee() {
		return this.__fee;
	}

	public void setFee( java.math.BigDecimal value ) {
		this.__fee = value;
	}

	public java.lang.String getOriginalPay() {
		return this.__original_pay;
	}

	public void setOriginalPay( java.lang.String value ) {
		this.__original_pay = value;
	}

	public java.math.BigDecimal getSeverance() {
		return this.__severance;
	}

	public void setSeverance( java.math.BigDecimal value ) {
		this.__severance = value;
	}

	public java.lang.String getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.lang.String value ) {
		this.__month_pay = value;
	}

	public java.lang.String getSubType() {
		return this.__sub_type;
	}

	public void setSubType( java.lang.String value ) {
		this.__sub_type = value;
	}

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

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return __business_id;
	}

	public void setBusinessId(java.lang.Integer __business_id) {
		this.__business_id = __business_id;
	}

	public java.lang.Integer getProcessInstanceActivityId() {
		return __process_instance_activity_id;
	}

	public void setProcessInstanceActivityId(java.lang.Integer __process_instance_activity_id) {
		this.__process_instance_activity_id = __process_instance_activity_id;
	}

	public java.lang.Integer getProcessActivityId() {
		return __process_activity_id;
	}

	public void setProcessActivityId(java.lang.Integer __process_activity_id) {
		this.__process_activity_id = __process_activity_id;
	}

	public java.lang.Integer getActivityType() {
		return __activity_type;
	}

	public void setActivityType(java.lang.Integer __activity_type) {
		this.__activity_type = __activity_type;
	}

	public java.lang.Integer getNodeType() {
		return __node_type;
	}

	public void setNodeType(java.lang.Integer __node_type) {
		this.__node_type = __node_type;
	}

	public java.lang.Integer getActivityId() {
		return __activity_id;
	}

	public void setActivityId(java.lang.Integer __activity_id) {
		this.__activity_id = __activity_id;
	}

	public java.lang.Integer getNextActivityId() {
		return __next_activity_id;
	}

	public void setNextActivityId(java.lang.Integer __next_activity_id) {
		this.__next_activity_id = __next_activity_id;
	}

	public java.lang.Integer getMainActivityId() {
		return __main_activity_id;
	}

	public void setMainActivityId(java.lang.Integer __main_activity_id) {
		this.__main_activity_id = __main_activity_id;
	}

	public java.lang.Integer getDeleteFlag() {
		return __delete_flag;
	}

	public void setDeleteFlag(java.lang.Integer __delete_flag) {
		this.__delete_flag = __delete_flag;
	}

	public java.lang.Integer getMessageStatus() {
		return __message_status;
	}

	public void setMessageStatus(java.lang.Integer __message_status) {
		this.__message_status = __message_status;
	}

	public java.lang.String getBusinessName() {
		return __business_name;
	}

	public void setBusinessName(java.lang.String __business_name) {
		this.__business_name = __business_name;
	}

	public java.lang.String getBackViewName() {
		return __back_view_name;
	}

	public void setBackViewName(java.lang.String __back_view_name) {
		this.__back_view_name = __back_view_name;
	}

	public java.util.Date getInstanceActivityCreateTime() {
		return __instance_activity_create_time;
	}

	public void setInstanceActivityCreateTime(java.util.Date __instance_activity_create_time) {
		this.__instance_activity_create_time = __instance_activity_create_time;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return __instance_activity_start_time;
	}

	public void setInstanceActivityStartTime(java.util.Date __instance_activity_start_time) {
		this.__instance_activity_start_time = __instance_activity_start_time;
	}

	public java.lang.Integer getStatus() {
		return __status;
	}

	public void setStatus(java.lang.Integer __status) {
		this.__status = __status;
	}

	public java.lang.String getRemark() {
		return __remark;
	}

	public void setRemark(java.lang.String __remark) {
		this.__remark = __remark;
	}

	public void cloneCopy(BaseEmployeeSalaryAdjustmentDetail __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setTargetProvince(getTargetProvince());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setFee(getFee());
		__bean.setOriginalPay(getOriginalPay());
		__bean.setSeverance(getSeverance());
		__bean.setMonthPay(getMonthPay());
		__bean.setSubType(getSubType());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setProcessActivityId(getProcessActivityId());
		__bean.setActivityType(getActivityType());
		__bean.setNodeType(getNodeType());
		__bean.setActivityId(getActivityId());
		__bean.setNextActivityId(getNextActivityId());
		__bean.setMainActivityId(getMainActivityId());
		__bean.setStatus(getStatus());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setMessageStatus(getMessageStatus());
		__bean.setBusinessName(getBusinessName());
		__bean.setBackViewName(getBackViewName());
		__bean.setInstanceActivityCreateTime(getInstanceActivityCreateTime());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strTargetProvince = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getTargetProvince()));
		sb.append(strTargetProvince == null ? "" : strTargetProvince);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getFee() == null ? "" : getFee());
		sb.append(",");
		sb.append(getOriginalPay() == null ? "" : getOriginalPay());
		sb.append(",");
		sb.append(getSeverance() == null ? "" : getSeverance());
		sb.append(",");
		sb.append(getMonthPay() == null ? "" : getMonthPay());
		sb.append(",");
		sb.append(getSubType() == null ? "" : getSubType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeSalaryAdjustmentDetail o) {
		return __personnel_business_id == null ? -1 : __personnel_business_id.compareTo(o.getPersonnelBusinessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__target_province);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__fee);
		hash = 97 * hash + Objects.hashCode(this.__original_pay);
		hash = 97 * hash + Objects.hashCode(this.__severance);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__sub_type);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__activity_type);
		hash = 97 * hash + Objects.hashCode(this.__node_type);
		hash = 97 * hash + Objects.hashCode(this.__activity_id);
		hash = 97 * hash + Objects.hashCode(this.__next_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__main_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__message_status);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_create_time);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeSalaryAdjustmentDetail o = (BaseEmployeeSalaryAdjustmentDetail)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__target_province, o.getTargetProvince())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__fee, o.getFee())) return false;
		if(!Objects.equals(this.__original_pay, o.getOriginalPay())) return false;
		if(!Objects.equals(this.__severance, o.getSeverance())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__sub_type, o.getSubType())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__process_activity_id, o.getProcessActivityId())) return false;
		if(!Objects.equals(this.__activity_type, o.getActivityType())) return false;
		if(!Objects.equals(this.__node_type, o.getNodeType())) return false;
		if(!Objects.equals(this.__activity_id, o.getActivityId())) return false;
		if(!Objects.equals(this.__next_activity_id, o.getNextActivityId())) return false;
		if(!Objects.equals(this.__main_activity_id, o.getMainActivityId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__message_status, o.getMessageStatus())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__instance_activity_create_time, o.getInstanceActivityCreateTime())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getTargetProvince() != null) sb.append(__wrapNumber(count++, "targetProvince", getTargetProvince()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getFee() != null) sb.append(__wrapDecimal(count++, "fee", getFee()));
		if(getOriginalPay() != null) sb.append(__wrapString(count++, "originalPay", getOriginalPay()));
		if(getSeverance() != null) sb.append(__wrapDecimal(count++, "severance", getSeverance()));
		if(getMonthPay() != null) sb.append(__wrapString(count++, "monthPay", getMonthPay()));
		if(getSubType() != null) sb.append(__wrapString(count++, "subType", getSubType()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getProcessActivityId() != null) sb.append(__wrapNumber(count++, "processActivityId", getProcessActivityId()));
		if(getActivityType() != null) sb.append(__wrapNumber(count++, "activityType", getActivityType()));
		if(getNodeType() != null) sb.append(__wrapNumber(count++, "nodeType", getNodeType()));
		if(getActivityId() != null) sb.append(__wrapNumber(count++, "activityId", getActivityId()));
		if(getNextActivityId() != null) sb.append(__wrapNumber(count++, "nextActivityId", getNextActivityId()));
		if(getMainActivityId() != null) sb.append(__wrapNumber(count++, "mainActivityId", getMainActivityId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getMessageStatus() != null) sb.append(__wrapNumber(count++, "messageStatus", getMessageStatus()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		if(getInstanceActivityCreateTime() != null) sb.append(__wrapDate(count++, "instanceActivityCreateTime", getInstanceActivityCreateTime()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, "instanceActivityStartTime", getInstanceActivityStartTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("targetProvince")) != null) setTargetProvince(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("fee")) != null) setFee(__getDecimal(val));  
		if((val = values.get("originalPay")) != null) setOriginalPay(__getString(val));
		if((val = values.get("severance")) != null) setSeverance(__getDecimal(val));  
		if((val = values.get("monthPay")) != null) setMonthPay(__getString(val));
		if((val = values.get("subType")) != null) setSubType(__getString(val));
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("processActivityId")) != null) setProcessActivityId(__getInt(val)); 
		if((val = values.get("activityType")) != null) setActivityType(__getInt(val)); 
		if((val = values.get("nodeType")) != null) setNodeType(__getInt(val)); 
		if((val = values.get("activityId")) != null) setActivityId(__getInt(val)); 
		if((val = values.get("nextActivityId")) != null) setNextActivityId(__getInt(val)); 
		if((val = values.get("mainActivityId")) != null) setMainActivityId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("messageStatus")) != null) setMessageStatus(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val)); 
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val)); 
		if((val = values.get("instanceActivityCreateTime")) != null) setInstanceActivityCreateTime(__getDate(val)); 
		if((val = values.get("instanceActivityStartTime")) != null) setInstanceActivityStartTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __target_province ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __fee ;
	protected java.lang.String  __original_pay ;
	protected java.math.BigDecimal  __severance ;
	protected java.lang.String  __month_pay ;
	protected java.lang.String  __sub_type ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __process_activity_id ;
	protected java.lang.Integer  __activity_type ;
	protected java.lang.Integer  __node_type ;
	protected java.lang.Integer  __activity_id ;
	protected java.lang.Integer  __next_activity_id ;
	protected java.lang.Integer  __main_activity_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __message_status ;
	protected java.lang.String  __business_name ;
	protected java.lang.String  __back_view_name ;
	protected java.util.Date  __instance_activity_create_time ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.lang.String  __remark ;
}
