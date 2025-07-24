package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSystemProcessInstanceActivities extends GenericBase implements BaseFactory<BaseSystemProcessInstanceActivities>, Comparable<BaseSystemProcessInstanceActivities> 
{


	public static BaseSystemProcessInstanceActivities newInstance(){
		return new BaseSystemProcessInstanceActivities();
	}

	@Override
	public BaseSystemProcessInstanceActivities make(){
		BaseSystemProcessInstanceActivities b = new BaseSystemProcessInstanceActivities();
		return b;
	}

	public final static String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_ID = "id" ;
	public final static String CS_PROCESS_TYPE = "process_type" ;
	public final static String CS_BUSINESS_NAME = "business_name" ;
	public final static String CS_PROCESS_TYPE_NAME = "process_type_name" ;
	public final static String CS_TIME_OUT_ACTION = "time_out_action" ;
	public final static String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static String CS_ID_TYPE = "id_type" ;
	public final static String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static String CS_COMPANY_WEIXIN = "company_weixin" ;
	public final static String CS_COMPANY_EMAIL = "company_email" ;
	public final static String CS_BUSINESS_ID = "business_id" ;
	public final static String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static String CS_ACTIVITY_TYPE = "activity_type" ;

	public final static String ALL_CAPTIONS = "主键编码,处理人,,流程类型,业务名称,流程类型名称,活动时限,流程实例节点开始处于活动时间,,返回数据集,企业微信账号,企业邮箱,业务编码,流程实列编码,节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会";

	public Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public Integer getId() {
		return this.__id;
	}

	public void setId( Integer value ) {
		this.__id = value;
	}

	public Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( Integer value ) {
		this.__process_type = value;
	}

	public String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( String value ) {
		this.__business_name = value;
	}

	public String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( String value ) {
		this.__process_type_name = value;
	}

	public Integer getTimeOutAction() {
		return this.__time_out_action;
	}

	public void setTimeOutAction( Integer value ) {
		this.__time_out_action = value;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return this.__instance_activity_start_time;
	}

	public void setInstanceActivityStartTime( java.util.Date value ) {
		this.__instance_activity_start_time = value;
	}

	public Integer getIdType() {
		return this.__id_type;
	}

	public void setIdType( Integer value ) {
		this.__id_type = value;
	}

	public String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( String value ) {
		this.__back_view_name = value;
	}

	public String getCompanyWeixin() {
		return this.__company_weixin;
	}

	public void setCompanyWeixin( String value ) {
		this.__company_weixin = value;
	}

	public String getCompanyEmail() {
		return this.__company_email;
	}

	public void setCompanyEmail( String value ) {
		this.__company_email = value;
	}

	public Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( Integer value ) {
		this.__business_id = value;
	}

	public Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( Integer value ) {
		this.__process_instance_id = value;
	}

	public Integer getActivityType() {
		return this.__activity_type;
	}

	public void setActivityType( Integer value ) {
		this.__activity_type = value;
	}

	public void cloneCopy(BaseSystemProcessInstanceActivities __bean){
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setId(getId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessTypeName(getProcessTypeName());
		__bean.setTimeOutAction(getTimeOutAction());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setIdType(getIdType());
		__bean.setBackViewName(getBackViewName());
		__bean.setCompanyWeixin(getCompanyWeixin());
		__bean.setCompanyEmail(getCompanyEmail());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setActivityType(getActivityType());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getId() == null ? "" : getId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessTypeName() == null ? "" : getProcessTypeName());
		sb.append(",");
		sb.append(getTimeOutAction() == null ? "" : getTimeOutAction());
		sb.append(",");
		sb.append(getInstanceActivityStartTime() == null ? "" : sdf.format(getInstanceActivityStartTime()));
		sb.append(",");
		sb.append(getIdType() == null ? "" : getIdType());
		sb.append(",");
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getCompanyWeixin() == null ? "" : getCompanyWeixin());
		sb.append(",");
		sb.append(getCompanyEmail() == null ? "" : getCompanyEmail());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getActivityType() == null ? "" : getActivityType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSystemProcessInstanceActivities o) {
		return __process_instance_activity_id == null ? -1 : __process_instance_activity_id.compareTo(o.getProcessInstanceActivityId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_type_name);
		hash = 97 * hash + Objects.hashCode(this.__time_out_action);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__id_type);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__company_weixin);
		hash = 97 * hash + Objects.hashCode(this.__company_email);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__activity_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSystemProcessInstanceActivities o = (BaseSystemProcessInstanceActivities)obj;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__id, o.getId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_type_name, o.getProcessTypeName())) return false;
		if(!Objects.equals(this.__time_out_action, o.getTimeOutAction())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__id_type, o.getIdType())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__company_weixin, o.getCompanyWeixin())) return false;
		if(!Objects.equals(this.__company_email, o.getCompanyEmail())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__activity_type, o.getActivityType())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getId() != null) sb.append(__wrapNumber(count++, "id", getId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessTypeName() != null) sb.append(__wrapString(count++, "processTypeName", getProcessTypeName()));
		if(getTimeOutAction() != null) sb.append(__wrapNumber(count++, "timeOutAction", getTimeOutAction()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, "instanceActivityStartTime", getInstanceActivityStartTime()));
		if(getIdType() != null) sb.append(__wrapNumber(count++, "idType", getIdType()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		if(getCompanyWeixin() != null) sb.append(__wrapString(count++, "companyWeixin", getCompanyWeixin()));
		if(getCompanyEmail() != null) sb.append(__wrapString(count++, "companyEmail", getCompanyEmail()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getActivityType() != null) sb.append(__wrapNumber(count++, "activityType", getActivityType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessInstanceActivityId() != null) res.put("processInstanceActivityId", getProcessInstanceActivityId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getId() != null) res.put("id", getId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessTypeName() != null) res.put("processTypeName", getProcessTypeName());
		if(getTimeOutAction() != null) res.put("timeOutAction", getTimeOutAction());
		if(getInstanceActivityStartTime() != null) res.put("instanceActivityStartTime", getInstanceActivityStartTime());
		if(getIdType() != null) res.put("idType", getIdType());
		if(getBackViewName() != null) res.put("backViewName", getBackViewName());
		if(getCompanyWeixin() != null) res.put("companyWeixin", getCompanyWeixin());
		if(getCompanyEmail() != null) res.put("companyEmail", getCompanyEmail());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getActivityType() != null) res.put("activityType", getActivityType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("id")) != null) setId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processTypeName")) != null) setProcessTypeName(__getString(val));
		if((val = values.get("timeOutAction")) != null) setTimeOutAction(__getInt(val)); 
		if((val = values.get("instanceActivityStartTime")) != null) setInstanceActivityStartTime(__getDate(val)); 
		if((val = values.get("idType")) != null) setIdType(__getInt(val)); 
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val));
		if((val = values.get("companyWeixin")) != null) setCompanyWeixin(__getString(val));
		if((val = values.get("companyEmail")) != null) setCompanyEmail(__getString(val));
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("activityType")) != null) setActivityType(__getInt(val)); 
	}

	protected Integer  __process_instance_activity_id ;
	protected Integer  __employee_id ;
	protected Integer  __id ;
	protected Integer  __process_type ;
	protected String  __business_name ;
	protected String  __process_type_name ;
	protected Integer  __time_out_action ;
	protected java.util.Date  __instance_activity_start_time ;
	protected Integer  __id_type ;
	protected String  __back_view_name ;
	protected String  __company_weixin ;
	protected String  __company_email ;
	protected Integer  __business_id ;
	protected Integer  __process_instance_id ;
	protected Integer  __activity_type ;
}
