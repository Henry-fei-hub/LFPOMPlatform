package pomplatform.outQuotations.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadApplyListOfOutQuotations extends GenericBase implements BaseFactory<BaseOnLoadApplyListOfOutQuotations>, Comparable<BaseOnLoadApplyListOfOutQuotations> 
{


	public static BaseOnLoadApplyListOfOutQuotations newInstance(){
		return new BaseOnLoadApplyListOfOutQuotations();
	}

	@Override
	public BaseOnLoadApplyListOfOutQuotations make(){
		BaseOnLoadApplyListOfOutQuotations b = new BaseOnLoadApplyListOfOutQuotations();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_QUOTATION_NUMBER = "quotation_number" ;
	public final static java.lang.String CS_QUOTATION_NAME = "quotation_name" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_START_TIME = "start_time" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_QUOTATION_FILES = "quotation_files" ;
	public final static java.lang.String CS_QUOTATION_STATUS = "quotation_status" ;
	public final static java.lang.String CS_DISABLE_TYPE = "disable_type" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_NEW_CREATE_QUOTATION_NAME = "new_create_quotation_name" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,流程编码,活动实列编码,流程状态 0 发起中  1,创建时间,完成时间,流程类型,报价单编码,报价单编号(年月日-1),报价单名称,报价单总金额,,信息编号,项目编号,,业务类型,项目类型,报价单(原附件),报价单的状态 1成功 2不成功 3报价中...,可操作状态 0可操作,1禁止操作,创建人,contract_id,修改时间,新建的报价单名称";

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( java.lang.Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.String getQuotationNumber() {
		return this.__quotation_number;
	}

	public void setQuotationNumber( java.lang.String value ) {
		this.__quotation_number = value;
	}

	public java.lang.String getQuotationName() {
		return this.__quotation_name;
	}

	public void setQuotationName( java.lang.String value ) {
		this.__quotation_name = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
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

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.String getQuotationFiles() {
		return this.__quotation_files;
	}

	public void setQuotationFiles( java.lang.String value ) {
		this.__quotation_files = value;
	}

	public java.lang.Integer getQuotationStatus() {
		return this.__quotation_status;
	}

	public void setQuotationStatus( java.lang.Integer value ) {
		this.__quotation_status = value;
	}

	public java.lang.Integer getDisableType() {
		return this.__disable_type;
	}

	public void setDisableType( java.lang.Integer value ) {
		this.__disable_type = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.String getNewCreateQuotationName() {
		return this.__new_create_quotation_name;
	}

	public void setNewCreateQuotationName( java.lang.String value ) {
		this.__new_create_quotation_name = value;
	}

	public void cloneCopy(BaseOnLoadApplyListOfOutQuotations __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setProcessType(getProcessType());
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setQuotationNumber(getQuotationNumber());
		__bean.setQuotationName(getQuotationName());
		__bean.setMoneySum(getMoneySum());
		__bean.setStartTime(getStartTime());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectType(getProjectType());
		__bean.setQuotationFiles(getQuotationFiles());
		__bean.setQuotationStatus(getQuotationStatus());
		__bean.setDisableType(getDisableType());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setContractId(getContractId());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setNewCreateQuotationName(getNewCreateQuotationName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getQuotationNumber() == null ? "" : getQuotationNumber());
		sb.append(",");
		sb.append(getQuotationName() == null ? "" : getQuotationName());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getQuotationFiles() == null ? "" : getQuotationFiles());
		sb.append(",");
		sb.append(getQuotationStatus() == null ? "" : getQuotationStatus());
		sb.append(",");
		sb.append(getDisableType() == null ? "" : getDisableType());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getNewCreateQuotationName() == null ? "" : getNewCreateQuotationName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadApplyListOfOutQuotations o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__quotation_number);
		hash = 97 * hash + Objects.hashCode(this.__quotation_name);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__quotation_files);
		hash = 97 * hash + Objects.hashCode(this.__quotation_status);
		hash = 97 * hash + Objects.hashCode(this.__disable_type);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__new_create_quotation_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadApplyListOfOutQuotations o = (BaseOnLoadApplyListOfOutQuotations)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__quotation_number, o.getQuotationNumber())) return false;
		if(!Objects.equals(this.__quotation_name, o.getQuotationName())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__quotation_files, o.getQuotationFiles())) return false;
		if(!Objects.equals(this.__quotation_status, o.getQuotationStatus())) return false;
		if(!Objects.equals(this.__disable_type, o.getDisableType())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__new_create_quotation_name, o.getNewCreateQuotationName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getQuotationNumber() != null) sb.append(__wrapString(count++, "quotationNumber", getQuotationNumber()));
		if(getQuotationName() != null) sb.append(__wrapString(count++, "quotationName", getQuotationName()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getStartTime() != null) sb.append(__wrapDate(count++, "startTime", getStartTime()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getQuotationFiles() != null) sb.append(__wrapString(count++, "quotationFiles", getQuotationFiles()));
		if(getQuotationStatus() != null) sb.append(__wrapNumber(count++, "quotationStatus", getQuotationStatus()));
		if(getDisableType() != null) sb.append(__wrapNumber(count++, "disableType", getDisableType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getNewCreateQuotationName() != null) sb.append(__wrapString(count++, "newCreateQuotationName", getNewCreateQuotationName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceActivityId() != null) res.put("processInstanceActivityId", getProcessInstanceActivityId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getOutQuotationId() != null) res.put("outQuotationId", getOutQuotationId());
		if(getQuotationNumber() != null) res.put("quotationNumber", getQuotationNumber());
		if(getQuotationName() != null) res.put("quotationName", getQuotationName());
		if(getMoneySum() != null) res.put("moneySum", getMoneySum());
		if(getStartTime() != null) res.put("startTime", getStartTime());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getQuotationFiles() != null) res.put("quotationFiles", getQuotationFiles());
		if(getQuotationStatus() != null) res.put("quotationStatus", getQuotationStatus());
		if(getDisableType() != null) res.put("disableType", getDisableType());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getUpdateTime() != null) res.put("updateTime", getUpdateTime());
		if(getNewCreateQuotationName() != null) res.put("newCreateQuotationName", getNewCreateQuotationName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("quotationNumber")) != null) setQuotationNumber(__getString(val));
		if((val = values.get("quotationName")) != null) setQuotationName(__getString(val));
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("quotationFiles")) != null) setQuotationFiles(__getString(val));
		if((val = values.get("quotationStatus")) != null) setQuotationStatus(__getInt(val)); 
		if((val = values.get("disableType")) != null) setDisableType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("newCreateQuotationName")) != null) setNewCreateQuotationName(__getString(val));
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __out_quotation_id ;
	protected java.lang.String  __quotation_number ;
	protected java.lang.String  __quotation_name ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.util.Date  __start_time ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __project_type ;
	protected java.lang.String  __quotation_files ;
	protected java.lang.Integer  __quotation_status ;
	protected java.lang.Integer  __disable_type ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.util.Date  __update_time ;
	protected java.lang.String  __new_create_quotation_name ;
}
