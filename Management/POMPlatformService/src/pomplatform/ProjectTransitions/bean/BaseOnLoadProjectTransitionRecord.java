package pomplatform.ProjectTransitions.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectTransitionRecord extends GenericBase implements BaseFactory<BaseOnLoadProjectTransitionRecord>, Comparable<BaseOnLoadProjectTransitionRecord> 
{


	public static BaseOnLoadProjectTransitionRecord newInstance(){
		return new BaseOnLoadProjectTransitionRecord();
	}

	@Override
	public BaseOnLoadProjectTransitionRecord make(){
		BaseOnLoadProjectTransitionRecord b = new BaseOnLoadProjectTransitionRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_TRANSITION_ID = "project_transition_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_NEW_PROJECT_MANAGE_ID = "new_project_manage_id" ;
	public final static java.lang.String CS_OLD_NEW_PROJECT_MANAGE_ID = "old_new_project_manage_id" ;
	public final static java.lang.String CS_NEW_PERCENTAGE = "new_percentage" ;
	public final static java.lang.String CS_OLD_PERCENTAGE = "old_percentage" ;
	public final static java.lang.String CS_INITIATE_DESIGN = "initiate_design" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_MSG_COUNT = "msg_count" ;
	public final static java.lang.String CS_MSG_STATUS = "msg_status" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;

	public final static java.lang.String ALL_CAPTIONS = "id,项目主键,项目编号,项目名称,,,,,方案主创,状态,操作人id,创建时间,消息推送次数,消息状态   0 无意义 ，1 需要进行消息推送   2 已完成，不需要进行消息推送   3 已失效,合同编号";

	public java.lang.Integer getProjectTransitionId() {
		return this.__project_transition_id;
	}

	public void setProjectTransitionId( java.lang.Integer value ) {
		this.__project_transition_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getNewProjectManageId() {
		return this.__new_project_manage_id;
	}

	public void setNewProjectManageId( java.lang.Integer value ) {
		this.__new_project_manage_id = value;
	}

	public java.lang.Integer getOldNewProjectManageId() {
		return this.__old_new_project_manage_id;
	}

	public void setOldNewProjectManageId( java.lang.Integer value ) {
		this.__old_new_project_manage_id = value;
	}

	public java.math.BigDecimal getNewPercentage() {
		return this.__new_percentage;
	}

	public void setNewPercentage( java.math.BigDecimal value ) {
		this.__new_percentage = value;
	}

	public java.math.BigDecimal getOldPercentage() {
		return this.__old_percentage;
	}

	public void setOldPercentage( java.math.BigDecimal value ) {
		this.__old_percentage = value;
	}

	public java.lang.Integer getInitiateDesign() {
		return this.__initiate_design;
	}

	public void setInitiateDesign( java.lang.Integer value ) {
		this.__initiate_design = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getMsgCount() {
		return this.__msg_count;
	}

	public void setMsgCount( java.lang.Integer value ) {
		this.__msg_count = value;
	}

	public java.lang.Integer getMsgStatus() {
		return this.__msg_status;
	}

	public void setMsgStatus( java.lang.Integer value ) {
		this.__msg_status = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public void cloneCopy(BaseOnLoadProjectTransitionRecord __bean){
		__bean.setProjectTransitionId(getProjectTransitionId());
		__bean.setProjectId(getProjectId());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setNewProjectManageId(getNewProjectManageId());
		__bean.setOldNewProjectManageId(getOldNewProjectManageId());
		__bean.setNewPercentage(getNewPercentage());
		__bean.setOldPercentage(getOldPercentage());
		__bean.setInitiateDesign(getInitiateDesign());
		__bean.setStatus(getStatus());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setMsgCount(getMsgCount());
		__bean.setMsgStatus(getMsgStatus());
		__bean.setContractCode(getContractCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectTransitionId() == null ? "" : getProjectTransitionId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getNewProjectManageId() == null ? "" : getNewProjectManageId());
		sb.append(",");
		sb.append(getOldNewProjectManageId() == null ? "" : getOldNewProjectManageId());
		sb.append(",");
		sb.append(getNewPercentage() == null ? "" : getNewPercentage());
		sb.append(",");
		sb.append(getOldPercentage() == null ? "" : getOldPercentage());
		sb.append(",");
		sb.append(getInitiateDesign() == null ? "" : getInitiateDesign());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getMsgCount() == null ? "" : getMsgCount());
		sb.append(",");
		sb.append(getMsgStatus() == null ? "" : getMsgStatus());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadProjectTransitionRecord o) {
		return __project_transition_id == null ? -1 : __project_transition_id.compareTo(o.getProjectTransitionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_transition_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__new_project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__old_new_project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__new_percentage);
		hash = 97 * hash + Objects.hashCode(this.__old_percentage);
		hash = 97 * hash + Objects.hashCode(this.__initiate_design);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__msg_count);
		hash = 97 * hash + Objects.hashCode(this.__msg_status);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadProjectTransitionRecord o = (BaseOnLoadProjectTransitionRecord)obj;
		if(!Objects.equals(this.__project_transition_id, o.getProjectTransitionId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__new_project_manage_id, o.getNewProjectManageId())) return false;
		if(!Objects.equals(this.__old_new_project_manage_id, o.getOldNewProjectManageId())) return false;
		if(!Objects.equals(this.__new_percentage, o.getNewPercentage())) return false;
		if(!Objects.equals(this.__old_percentage, o.getOldPercentage())) return false;
		if(!Objects.equals(this.__initiate_design, o.getInitiateDesign())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__msg_count, o.getMsgCount())) return false;
		if(!Objects.equals(this.__msg_status, o.getMsgStatus())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectTransitionId() != null) sb.append(__wrapNumber(count++, "projectTransitionId", getProjectTransitionId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getNewProjectManageId() != null) sb.append(__wrapNumber(count++, "newProjectManageId", getNewProjectManageId()));
		if(getOldNewProjectManageId() != null) sb.append(__wrapNumber(count++, "oldNewProjectManageId", getOldNewProjectManageId()));
		if(getNewPercentage() != null) sb.append(__wrapDecimal(count++, "newPercentage", getNewPercentage()));
		if(getOldPercentage() != null) sb.append(__wrapDecimal(count++, "oldPercentage", getOldPercentage()));
		if(getInitiateDesign() != null) sb.append(__wrapNumber(count++, "initiateDesign", getInitiateDesign()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getMsgCount() != null) sb.append(__wrapNumber(count++, "msgCount", getMsgCount()));
		if(getMsgStatus() != null) sb.append(__wrapNumber(count++, "msgStatus", getMsgStatus()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectTransitionId() != null) res.put("projectTransitionId", getProjectTransitionId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getNewProjectManageId() != null) res.put("newProjectManageId", getNewProjectManageId());
		if(getOldNewProjectManageId() != null) res.put("oldNewProjectManageId", getOldNewProjectManageId());
		if(getNewPercentage() != null) res.put("newPercentage", getNewPercentage());
		if(getOldPercentage() != null) res.put("oldPercentage", getOldPercentage());
		if(getInitiateDesign() != null) res.put("initiateDesign", getInitiateDesign());
		if(getStatus() != null) res.put("status", getStatus());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getMsgCount() != null) res.put("msgCount", getMsgCount());
		if(getMsgStatus() != null) res.put("msgStatus", getMsgStatus());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectTransitionId")) != null) setProjectTransitionId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("newProjectManageId")) != null) setNewProjectManageId(__getInt(val)); 
		if((val = values.get("oldNewProjectManageId")) != null) setOldNewProjectManageId(__getInt(val)); 
		if((val = values.get("newPercentage")) != null) setNewPercentage(__getDecimal(val));  
		if((val = values.get("oldPercentage")) != null) setOldPercentage(__getDecimal(val));  
		if((val = values.get("initiateDesign")) != null) setInitiateDesign(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("msgCount")) != null) setMsgCount(__getInt(val)); 
		if((val = values.get("msgStatus")) != null) setMsgStatus(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
	}

	protected java.lang.Integer  __project_transition_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __new_project_manage_id ;
	protected java.lang.Integer  __old_new_project_manage_id ;
	protected java.math.BigDecimal  __new_percentage ;
	protected java.math.BigDecimal  __old_percentage ;
	protected java.lang.Integer  __initiate_design ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __msg_count ;
	protected java.lang.Integer  __msg_status ;
	protected java.lang.String  __contract_code ;
}
