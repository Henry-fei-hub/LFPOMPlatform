package pomplatform.orderplacement.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadApproveContractRunDry extends GenericBase implements BaseFactory<BaseOnLoadApproveContractRunDry>, Comparable<BaseOnLoadApproveContractRunDry> 
{


	public static BaseOnLoadApproveContractRunDry newInstance(){
		return new BaseOnLoadApproveContractRunDry();
	}

	@Override
	public BaseOnLoadApproveContractRunDry make(){
		BaseOnLoadApproveContractRunDry b = new BaseOnLoadApproveContractRunDry();
		return b;
	}

	public final static String CS_PROCESS_POOLED_TASK_ID = "process_pooled_task_id" ;
	public final static String CS_TYPE_FLAG = "type_flag" ;
	public final static String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static String CS_BUSINESS_ID = "business_id" ;
	public final static String CS_BUSINESS_NAME = "business_name" ;
	public final static String CS_PROCESS_ACTIVITY_ID = "process_activity_id" ;
	public final static String CS_PROCESS_ID = "process_id" ;
	public final static String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static String CS_NODE_TYPE = "node_type" ;
	public final static String CS_ACTIVITY_ID = "activity_id" ;
	public final static String CS_NEXT_ACTIVITY_ID = "next_activity_id" ;
	public final static String CS_MAIN_ACTIVITY_ID = "main_activity_id" ;
	public final static String CS_INSTANCE_ACTIVITY_CREATE_TIME = "instance_activity_create_time" ;
	public final static String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static String CS_OPERATE_TIME = "operate_time" ;
	public final static String CS_PROCESS_COMMENT = "process_comment" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_ACTIVITY_TYPE = "activity_type" ;
	public final static String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static String CS_PROCESS_TYPE = "process_type" ;
	public final static String CS_CONTRACT_ID = "contract_id" ;
	public final static String CS_CONTRACT_CODE = "contract_code" ;
	public final static String CS_INFO_CODE = "info_code" ;
	public final static String CS_ORDER_INFO_ID = "order_info_id" ;
	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_CONTRACT_NAME = "contract_name" ;
	public final static String CS_FILE_ID = "file_id" ;
	public final static String CS_FILE_URL = "file_url" ;
	public final static String CS_FILE_NAME = "file_name" ;

	public final static String ALL_CAPTIONS = "主键编码,,主键编码,业务编码,业务名称,活动编码,流程编码,流程实列编码,附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人,当前流程实例节点的内部编码,下一个流程节点的编码,如果是知会节点，所依附的主节点,流程实例节点创建时间,流程实例节点开始处于活动时间,操作时间,提交意见,状态,节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会,返回数据集,流程类型,主订单编码,主订单编号,信息编号,订单信息编码,项目编号,主订单名称,附件id,附件url,附件名";

	public Integer getProcessPooledTaskId() {
		return this.__process_pooled_task_id;
	}

	public void setProcessPooledTaskId( Integer value ) {
		this.__process_pooled_task_id = value;
	}

	public Integer getTypeFlag() {
		return this.__type_flag;
	}

	public void setTypeFlag( Integer value ) {
		this.__type_flag = value;
	}

	public Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( Integer value ) {
		this.__business_id = value;
	}

	public String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( String value ) {
		this.__business_name = value;
	}

	public Integer getProcessActivityId() {
		return this.__process_activity_id;
	}

	public void setProcessActivityId( Integer value ) {
		this.__process_activity_id = value;
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

	public Integer getNodeType() {
		return this.__node_type;
	}

	public void setNodeType( Integer value ) {
		this.__node_type = value;
	}

	public Integer getActivityId() {
		return this.__activity_id;
	}

	public void setActivityId( Integer value ) {
		this.__activity_id = value;
	}

	public Integer getNextActivityId() {
		return this.__next_activity_id;
	}

	public void setNextActivityId( Integer value ) {
		this.__next_activity_id = value;
	}

	public Integer getMainActivityId() {
		return this.__main_activity_id;
	}

	public void setMainActivityId( Integer value ) {
		this.__main_activity_id = value;
	}

	public java.util.Date getInstanceActivityCreateTime() {
		return this.__instance_activity_create_time;
	}

	public void setInstanceActivityCreateTime( java.util.Date value ) {
		this.__instance_activity_create_time = value;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return this.__instance_activity_start_time;
	}

	public void setInstanceActivityStartTime( java.util.Date value ) {
		this.__instance_activity_start_time = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public String getProcessComment() {
		return this.__process_comment;
	}

	public void setProcessComment( String value ) {
		this.__process_comment = value;
	}

	public Integer getStatus() {
		return this.__status;
	}

	public void setStatus( Integer value ) {
		this.__status = value;
	}

	public Integer getActivityType() {
		return this.__activity_type;
	}

	public void setActivityType( Integer value ) {
		this.__activity_type = value;
	}

	public String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( String value ) {
		this.__back_view_name = value;
	}

	public Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( Integer value ) {
		this.__process_type = value;
	}

	public Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( Integer value ) {
		this.__contract_id = value;
	}

	public String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( String value ) {
		this.__contract_code = value;
	}

	public String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( String value ) {
		this.__info_code = value;
	}

	public Integer getOrderInfoId() {
		return this.__order_info_id;
	}

	public void setOrderInfoId( Integer value ) {
		this.__order_info_id = value;
	}

	public String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( String value ) {
		this.__contract_name = value;
	}

	public Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( Integer value ) {
		this.__file_id = value;
	}

	public String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( String value ) {
		this.__file_url = value;
	}

	public String getFileName() {
		return this.__file_name;
	}

	public void setFileName( String value ) {
		this.__file_name = value;
	}

	public void cloneCopy(BaseOnLoadApproveContractRunDry __bean){
		__bean.setProcessPooledTaskId(getProcessPooledTaskId());
		__bean.setTypeFlag(getTypeFlag());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessActivityId(getProcessActivityId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setNodeType(getNodeType());
		__bean.setActivityId(getActivityId());
		__bean.setNextActivityId(getNextActivityId());
		__bean.setMainActivityId(getMainActivityId());
		__bean.setInstanceActivityCreateTime(getInstanceActivityCreateTime());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setOperateTime(getOperateTime());
		__bean.setProcessComment(getProcessComment());
		__bean.setStatus(getStatus());
		__bean.setActivityType(getActivityType());
		__bean.setBackViewName(getBackViewName());
		__bean.setProcessType(getProcessType());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setInfoCode(getInfoCode());
		__bean.setOrderInfoId(getOrderInfoId());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractName(getContractName());
		__bean.setFileId(getFileId());
		__bean.setFileUrl(getFileUrl());
		__bean.setFileName(getFileName());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessPooledTaskId() == null ? "" : getProcessPooledTaskId());
		sb.append(",");
		sb.append(getTypeFlag() == null ? "" : getTypeFlag());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessActivityId() == null ? "" : getProcessActivityId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getNodeType() == null ? "" : getNodeType());
		sb.append(",");
		sb.append(getActivityId() == null ? "" : getActivityId());
		sb.append(",");
		sb.append(getNextActivityId() == null ? "" : getNextActivityId());
		sb.append(",");
		sb.append(getMainActivityId() == null ? "" : getMainActivityId());
		sb.append(",");
		sb.append(getInstanceActivityCreateTime() == null ? "" : sdf.format(getInstanceActivityCreateTime()));
		sb.append(",");
		sb.append(getInstanceActivityStartTime() == null ? "" : sdf.format(getInstanceActivityStartTime()));
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getProcessComment() == null ? "" : getProcessComment());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getActivityType() == null ? "" : getActivityType());
		sb.append(",");
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getOrderInfoId() == null ? "" : getOrderInfoId());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadApproveContractRunDry o) {
		return __process_pooled_task_id == null ? -1 : __process_pooled_task_id.compareTo(o.getProcessPooledTaskId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_pooled_task_id);
		hash = 97 * hash + Objects.hashCode(this.__type_flag);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__node_type);
		hash = 97 * hash + Objects.hashCode(this.__activity_id);
		hash = 97 * hash + Objects.hashCode(this.__next_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__main_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_create_time);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__process_comment);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__activity_type);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__order_info_id);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadApproveContractRunDry o = (BaseOnLoadApproveContractRunDry)obj;
		if(!Objects.equals(this.__process_pooled_task_id, o.getProcessPooledTaskId())) return false;
		if(!Objects.equals(this.__type_flag, o.getTypeFlag())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_activity_id, o.getProcessActivityId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__node_type, o.getNodeType())) return false;
		if(!Objects.equals(this.__activity_id, o.getActivityId())) return false;
		if(!Objects.equals(this.__next_activity_id, o.getNextActivityId())) return false;
		if(!Objects.equals(this.__main_activity_id, o.getMainActivityId())) return false;
		if(!Objects.equals(this.__instance_activity_create_time, o.getInstanceActivityCreateTime())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__process_comment, o.getProcessComment())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__activity_type, o.getActivityType())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__order_info_id, o.getOrderInfoId())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessPooledTaskId() != null) sb.append(__wrapNumber(count++, "processPooledTaskId", getProcessPooledTaskId()));
		if(getTypeFlag() != null) sb.append(__wrapNumber(count++, "typeFlag", getTypeFlag()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessActivityId() != null) sb.append(__wrapNumber(count++, "processActivityId", getProcessActivityId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getNodeType() != null) sb.append(__wrapNumber(count++, "nodeType", getNodeType()));
		if(getActivityId() != null) sb.append(__wrapNumber(count++, "activityId", getActivityId()));
		if(getNextActivityId() != null) sb.append(__wrapNumber(count++, "nextActivityId", getNextActivityId()));
		if(getMainActivityId() != null) sb.append(__wrapNumber(count++, "mainActivityId", getMainActivityId()));
		if(getInstanceActivityCreateTime() != null) sb.append(__wrapDate(count++, "instanceActivityCreateTime", getInstanceActivityCreateTime()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, "instanceActivityStartTime", getInstanceActivityStartTime()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, "processComment", getProcessComment()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getActivityType() != null) sb.append(__wrapNumber(count++, "activityType", getActivityType()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getOrderInfoId() != null) sb.append(__wrapNumber(count++, "orderInfoId", getOrderInfoId()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getFileName() != null) sb.append(__wrapString(count++, "fileName", getFileName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessPooledTaskId() != null) res.put("processPooledTaskId", getProcessPooledTaskId());
		if(getTypeFlag() != null) res.put("typeFlag", getTypeFlag());
		if(getProcessInstanceActivityId() != null) res.put("processInstanceActivityId", getProcessInstanceActivityId());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessActivityId() != null) res.put("processActivityId", getProcessActivityId());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getNodeType() != null) res.put("nodeType", getNodeType());
		if(getActivityId() != null) res.put("activityId", getActivityId());
		if(getNextActivityId() != null) res.put("nextActivityId", getNextActivityId());
		if(getMainActivityId() != null) res.put("mainActivityId", getMainActivityId());
		if(getInstanceActivityCreateTime() != null) res.put("instanceActivityCreateTime", getInstanceActivityCreateTime());
		if(getInstanceActivityStartTime() != null) res.put("instanceActivityStartTime", getInstanceActivityStartTime());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getProcessComment() != null) res.put("processComment", getProcessComment());
		if(getStatus() != null) res.put("status", getStatus());
		if(getActivityType() != null) res.put("activityType", getActivityType());
		if(getBackViewName() != null) res.put("backViewName", getBackViewName());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getOrderInfoId() != null) res.put("orderInfoId", getOrderInfoId());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		if(getFileName() != null) res.put("fileName", getFileName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processPooledTaskId")) != null) setProcessPooledTaskId(__getInt(val)); 
		if((val = values.get("typeFlag")) != null) setTypeFlag(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processActivityId")) != null) setProcessActivityId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("nodeType")) != null) setNodeType(__getInt(val)); 
		if((val = values.get("activityId")) != null) setActivityId(__getInt(val)); 
		if((val = values.get("nextActivityId")) != null) setNextActivityId(__getInt(val)); 
		if((val = values.get("mainActivityId")) != null) setMainActivityId(__getInt(val)); 
		if((val = values.get("instanceActivityCreateTime")) != null) setInstanceActivityCreateTime(__getDate(val)); 
		if((val = values.get("instanceActivityStartTime")) != null) setInstanceActivityStartTime(__getDate(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("processComment")) != null) setProcessComment(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("activityType")) != null) setActivityType(__getInt(val)); 
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val));
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("orderInfoId")) != null) setOrderInfoId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
	}

	protected Integer  __process_pooled_task_id ;
	protected Integer  __type_flag ;
	protected Integer  __process_instance_activity_id ;
	protected Integer  __business_id ;
	protected String  __business_name ;
	protected Integer  __process_activity_id ;
	protected Integer  __process_id ;
	protected Integer  __process_instance_id ;
	protected Integer  __node_type ;
	protected Integer  __activity_id ;
	protected Integer  __next_activity_id ;
	protected Integer  __main_activity_id ;
	protected java.util.Date  __instance_activity_create_time ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.util.Date  __operate_time ;
	protected String  __process_comment ;
	protected Integer  __status ;
	protected Integer  __activity_type ;
	protected String  __back_view_name ;
	protected Integer  __process_type ;
	protected Integer  __contract_id ;
	protected String  __contract_code ;
	protected String  __info_code ;
	protected Integer  __order_info_id ;
	protected String  __project_code ;
	protected String  __contract_name ;
	protected Integer  __file_id ;
	protected String  __file_url ;
	protected String  __file_name ;
}
