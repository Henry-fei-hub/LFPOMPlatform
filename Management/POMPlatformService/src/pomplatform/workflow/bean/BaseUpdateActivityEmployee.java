package pomplatform.workflow.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseUpdateActivityEmployee extends GenericBase implements BaseFactory<BaseUpdateActivityEmployee>, Comparable<BaseUpdateActivityEmployee> 
{


	public static BaseUpdateActivityEmployee newInstance(){
		return new BaseUpdateActivityEmployee();
	}

	@Override
	public BaseUpdateActivityEmployee make(){
		BaseUpdateActivityEmployee b = new BaseUpdateActivityEmployee();
		return b;
	}

	public final static String CS_PROCESS_TYPE = "process_type" ;
	public final static String CS_PROCESS_ID = "process_id" ;
	public final static String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static String CS_BUSINESS_ID = "business_id" ;
	public final static String CS_DRAFTER = "drafter" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_BUSINESS_NAME = "business_name" ;
	public final static String CS_CREATE_TIME = "create_time" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_NODE_ID = "node_id" ;
	public final static String CS_NODE_TYPE = "node_type" ;

	public final static String ALL_CAPTIONS = "流程类型,流程编码,流程实列编码,业务编码,发起人,节点审批人,摘要,创建时间,节点状态,节点ID,节点类型";

	public Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( Integer value ) {
		this.__process_type = value;
	}

	public Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( Integer value ) {
		this.__process_id = value;
	}

	public Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( Integer value ) {
		this.__process_instance_id = value;
	}

	public Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( Integer value ) {
		this.__business_id = value;
	}

	public Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( Integer value ) {
		this.__drafter = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( String value ) {
		this.__business_name = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public Integer getStatus() {
		return this.__status;
	}

	public void setStatus( Integer value ) {
		this.__status = value;
	}

	public Integer getNodeId() {
		return this.__node_id;
	}

	public void setNodeId( Integer value ) {
		this.__node_id = value;
	}

	public Integer getNodeType() {
		return this.__node_type;
	}

	public void setNodeType( Integer value ) {
		this.__node_type = value;
	}

	public void cloneCopy(BaseUpdateActivityEmployee __bean){
		__bean.setProcessType(getProcessType());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessId(getBusinessId());
		__bean.setDrafter(getDrafter());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setBusinessName(getBusinessName());
		__bean.setCreateTime(getCreateTime());
		__bean.setStatus(getStatus());
		__bean.setNodeId(getNodeId());
		__bean.setNodeType(getNodeType());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_38", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getNodeId() == null ? "" : getNodeId());
		sb.append(",");
		String strNodeType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getNodeType()));
		sb.append(strNodeType == null ? "" : strNodeType);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseUpdateActivityEmployee o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__node_id);
		hash = 97 * hash + Objects.hashCode(this.__node_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseUpdateActivityEmployee o = (BaseUpdateActivityEmployee)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__node_id, o.getNodeId())) return false;
		if(!Objects.equals(this.__node_type, o.getNodeType())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getNodeId() != null) sb.append(__wrapNumber(count++, "nodeId", getNodeId()));
		if(getNodeType() != null) sb.append(__wrapNumber(count++, "nodeType", getNodeType()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getDrafter() != null) res.put("drafter", getDrafter());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getStatus() != null) res.put("status", getStatus());
		if(getNodeId() != null) res.put("nodeId", getNodeId());
		if(getNodeType() != null) res.put("nodeType", getNodeType());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("nodeId")) != null) setNodeId(__getInt(val)); 
		if((val = values.get("nodeType")) != null) setNodeType(__getInt(val)); 
	}

	protected Integer  __process_type ;
	protected Integer  __process_id ;
	protected Integer  __process_instance_id ;
	protected Integer  __business_id ;
	protected Integer  __drafter ;
	protected Integer  __employee_id ;
	protected String  __business_name ;
	protected java.util.Date  __create_time ;
	protected Integer  __status ;
	protected Integer  __node_id ;
	protected Integer  __node_type ;
}
