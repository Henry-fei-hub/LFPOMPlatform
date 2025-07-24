package pomplatform.awaitingapproval.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAwaitingapproval extends GenericBase implements BaseFactory<BaseAwaitingapproval>, Comparable<BaseAwaitingapproval> 
{


	public static BaseAwaitingapproval newInstance(){
		return new BaseAwaitingapproval();
	}

	@Override
	public BaseAwaitingapproval make(){
		BaseAwaitingapproval b = new BaseAwaitingapproval();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ID = "id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_TYPE_NAME = "process_type_name" ;
	public final static java.lang.String CS_TIME_OUT_ACTION = "time_out_action" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static java.lang.String CS_ID_TYPE = "id_type" ;
	public final static java.lang.String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static java.lang.String CS_COMPANY_WEIXIN = "company_weixin" ;
	public final static java.lang.String CS_COMPANY_EMAIL = "company_email" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id";
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id";
	public final static java.lang.String CS_ACTIVITY_TYPE = "activity_type";

	public final static java.lang.String ALL_CAPTIONS = "处理人,,流程类型,业务名称,流程类型名称,活动时限,流程实例节点开始处于活动时间,,返回数据集,企业微信账号,企业邮箱";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getId() {
		return this.__id;
	}

	public void setId( java.lang.Integer value ) {
		this.__id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( java.lang.String value ) {
		this.__process_type_name = value;
	}

	public java.lang.Integer getTimeOutAction() {
		return this.__time_out_action;
	}

	public void setTimeOutAction( java.lang.Integer value ) {
		this.__time_out_action = value;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return this.__instance_activity_start_time;
	}

	public void setInstanceActivityStartTime( java.util.Date value ) {
		this.__instance_activity_start_time = value;
	}

	public java.lang.Integer getIdType() {
		return this.__id_type;
	}

	public void setIdType( java.lang.Integer value ) {
		this.__id_type = value;
	}

	public java.lang.String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.lang.String getCompanyWeixin() {
		return this.__company_weixin;
	}

	public void setCompanyWeixin( java.lang.String value ) {
		this.__company_weixin = value;
	}

	public java.lang.String getCompanyEmail() {
		return this.__company_email;
	}

	public void setCompanyEmail( java.lang.String value ) {
		this.__company_email = value;
	}

	public java.lang.Integer getBusinessId() {
		return __business_id;
	}

	public void setBusinessId(java.lang.Integer value) {
		this.__business_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return __process_instance_id;
	}

	public void setProcessInstanceId(java.lang.Integer value) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getActivityType() {
		return __activity_type;
	}

	public void setActivityType(java.lang.Integer value) {
		this.__activity_type = value;
	}

	public void cloneCopy(BaseAwaitingapproval __bean){
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

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAwaitingapproval o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
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
		final BaseAwaitingapproval o = (BaseAwaitingapproval)obj;
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
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
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

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
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

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.String  __business_name ;
	protected java.lang.String  __process_type_name ;
	protected java.lang.Integer  __time_out_action ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.lang.Integer  __id_type ;
	protected java.lang.String  __back_view_name ;
	protected java.lang.String  __company_weixin ;
	protected java.lang.String  __company_email ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_instance_id;
	protected java.lang.Integer  __activity_type;
}
