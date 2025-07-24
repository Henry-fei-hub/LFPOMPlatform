package pomplatform.mainProjectInfo.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadBidPaySheetProjectSummary extends GenericBase implements BaseFactory<BaseOnLoadBidPaySheetProjectSummary>, Comparable<BaseOnLoadBidPaySheetProjectSummary> 
{


	public static BaseOnLoadBidPaySheetProjectSummary newInstance(){
		return new BaseOnLoadBidPaySheetProjectSummary();
	}

	@Override
	public BaseOnLoadBidPaySheetProjectSummary make(){
		BaseOnLoadBidPaySheetProjectSummary b = new BaseOnLoadBidPaySheetProjectSummary();
		return b;
	}

	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_TRANSPORTATION = "transportation" ;
	public final static java.lang.String CS_PROJECT_SALES_TEAM = "project_sales_team" ;
	public final static java.lang.String CS_LIVING_EXPENSES = "living_expenses" ;
	public final static java.lang.String CS_START_DATE_DETAIL = "start_date_detail" ;
	public final static java.lang.String CS_END_DATE_DETAIL = "end_date_detail" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SEVERANCE = "severance" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_DUTY_ID = "duty_id" ;
	public final static java.lang.String CS_LINK_ID = "link_id" ;
	public final static java.lang.String CS_ATTACHMENT_ID = "attachment_id" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;

	public final static java.lang.String ALL_CAPTIONS = "项目名称,项目编号,信息编号,交通工具,项目营销团队,生活费用(元/月),0上午   1下午,0上午   1下午,地址,申请缘由,备注,离职补偿金,主订单编号,主订单名称,,,板块,项目总金额,创建时间,完成时间,主键编码,流程状态 0 发起中  1,人事业务编码,员工编码,开始日期,职务,关联表编码,附件编码,附件名称";
	public final static java.lang.String DOWN_CAPTIONS = "项目名称,项目编号,信息编号,客户名称,项目营销团队,投标金额,投标类型,投标单位总数,我方排名,落标原因,备注,甲方补偿金额,订单编号,订单名称,业务部门,落标补偿金";
	
	
	
	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getTransportation() {
		return this.__transportation;
	}

	public void setTransportation( java.lang.String value ) {
		this.__transportation = value;
	}

	public java.lang.String getProjectSalesTeam() {
		return this.__project_sales_team;
	}

	public void setProjectSalesTeam( java.lang.String value ) {
		this.__project_sales_team = value;
	}

	public java.math.BigDecimal getLivingExpenses() {
		return this.__living_expenses;
	}

	public void setLivingExpenses( java.math.BigDecimal value ) {
		this.__living_expenses = value;
	}

	public java.lang.Integer getStartDateDetail() {
		return this.__start_date_detail;
	}

	public void setStartDateDetail( java.lang.Integer value ) {
		this.__start_date_detail = value;
	}

	public java.lang.Integer getEndDateDetail() {
		return this.__end_date_detail;
	}

	public void setEndDateDetail( java.lang.Integer value ) {
		this.__end_date_detail = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
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

	public java.math.BigDecimal getSeverance() {
		return this.__severance;
	}

	public void setSeverance( java.math.BigDecimal value ) {
		this.__severance = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
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

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.lang.Integer getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( java.lang.Integer value ) {
		this.__duty_id = value;
	}

	public java.lang.Integer getLinkId() {
		return this.__link_id;
	}

	public void setLinkId( java.lang.Integer value ) {
		this.__link_id = value;
	}

	public java.lang.Integer getAttachmentId() {
		return this.__attachment_id;
	}

	public void setAttachmentId( java.lang.Integer value ) {
		this.__attachment_id = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public void cloneCopy(BaseOnLoadBidPaySheetProjectSummary __bean){
		__bean.setProjectName(getProjectName());
		__bean.setProjectCode(getProjectCode());
		__bean.setInfoCode(getInfoCode());
		__bean.setTransportation(getTransportation());
		__bean.setProjectSalesTeam(getProjectSalesTeam());
		__bean.setLivingExpenses(getLivingExpenses());
		__bean.setStartDateDetail(getStartDateDetail());
		__bean.setEndDateDetail(getEndDateDetail());
		__bean.setAddress(getAddress());
		__bean.setReason(getReason());
		__bean.setRemark(getRemark());
		__bean.setSeverance(getSeverance());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setPlateId(getPlateId());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setStartDate(getStartDate());
		__bean.setDutyId(getDutyId());
		__bean.setLinkId(getLinkId());
		__bean.setAttachmentId(getAttachmentId());
		__bean.setAttachmentName(getAttachmentName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getTransportation() == null ? "" : getTransportation());
		sb.append(",");
		sb.append(getProjectSalesTeam() == null ? "" : getProjectSalesTeam());
		sb.append(",");
		sb.append(getLivingExpenses() == null ? "" : getLivingExpenses());
		sb.append(",");
		String startDateDetail = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_129", String.valueOf(getStartDateDetail()));
		sb.append(startDateDetail == null ? "" : startDateDetail);
		sb.append(",");
		sb.append(getEndDateDetail() == null ? "" : getEndDateDetail());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getSeverance() == null ? "" : getSeverance());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		String plateName = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId()));
		sb.append(plateName == null ? "" : plateName);
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadBidPaySheetProjectSummary o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__transportation);
		hash = 97 * hash + Objects.hashCode(this.__project_sales_team);
		hash = 97 * hash + Objects.hashCode(this.__living_expenses);
		hash = 97 * hash + Objects.hashCode(this.__start_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__end_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__severance);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		hash = 97 * hash + Objects.hashCode(this.__link_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadBidPaySheetProjectSummary o = (BaseOnLoadBidPaySheetProjectSummary)obj;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__transportation, o.getTransportation())) return false;
		if(!Objects.equals(this.__project_sales_team, o.getProjectSalesTeam())) return false;
		if(!Objects.equals(this.__living_expenses, o.getLivingExpenses())) return false;
		if(!Objects.equals(this.__start_date_detail, o.getStartDateDetail())) return false;
		if(!Objects.equals(this.__end_date_detail, o.getEndDateDetail())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__severance, o.getSeverance())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		if(!Objects.equals(this.__link_id, o.getLinkId())) return false;
		if(!Objects.equals(this.__attachment_id, o.getAttachmentId())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getTransportation() != null) sb.append(__wrapString(count++, "transportation", getTransportation()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(count++, "projectSalesTeam", getProjectSalesTeam()));
		if(getLivingExpenses() != null) sb.append(__wrapDecimal(count++, "livingExpenses", getLivingExpenses()));
		if(getStartDateDetail() != null) sb.append(__wrapNumber(count++, "startDateDetail", getStartDateDetail()));
		if(getEndDateDetail() != null) sb.append(__wrapNumber(count++, "endDateDetail", getEndDateDetail()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getSeverance() != null) sb.append(__wrapDecimal(count++, "severance", getSeverance()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getDutyId() != null) sb.append(__wrapNumber(count++, "dutyId", getDutyId()));
		if(getLinkId() != null) sb.append(__wrapNumber(count++, "linkId", getLinkId()));
		if(getAttachmentId() != null) sb.append(__wrapNumber(count++, "attachmentId", getAttachmentId()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getTransportation() != null) res.put("transportation", getTransportation());
		if(getProjectSalesTeam() != null) res.put("projectSalesTeam", getProjectSalesTeam());
		if(getLivingExpenses() != null) res.put("livingExpenses", getLivingExpenses());
		if(getStartDateDetail() != null) res.put("startDateDetail", getStartDateDetail());
		if(getEndDateDetail() != null) res.put("endDateDetail", getEndDateDetail());
		if(getAddress() != null) res.put("address", getAddress());
		if(getReason() != null) res.put("reason", getReason());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getSeverance() != null) res.put("severance", getSeverance());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getCode() != null) res.put("code", getCode());
		if(getName() != null) res.put("name", getName());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getTotalAmount() != null) res.put("totalAmount", getTotalAmount());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getDutyId() != null) res.put("dutyId", getDutyId());
		if(getLinkId() != null) res.put("linkId", getLinkId());
		if(getAttachmentId() != null) res.put("attachmentId", getAttachmentId());
		if(getAttachmentName() != null) res.put("attachmentName", getAttachmentName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("transportation")) != null) setTransportation(__getString(val));
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val));
		if((val = values.get("livingExpenses")) != null) setLivingExpenses(__getDecimal(val));  
		if((val = values.get("startDateDetail")) != null) setStartDateDetail(__getInt(val)); 
		if((val = values.get("endDateDetail")) != null) setEndDateDetail(__getInt(val)); 
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("severance")) != null) setSeverance(__getDecimal(val));  
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("dutyId")) != null) setDutyId(__getInt(val)); 
		if((val = values.get("linkId")) != null) setLinkId(__getInt(val)); 
		if((val = values.get("attachmentId")) != null) setAttachmentId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
	}

	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __transportation ;
	protected java.lang.String  __project_sales_team ;
	protected java.math.BigDecimal  __living_expenses ;
	protected java.lang.Integer  __start_date_detail ;
	protected java.lang.Integer  __end_date_detail ;
	protected java.lang.String  __address ;
	protected java.lang.String  __reason ;
	protected java.lang.String  __remark ;
	protected java.math.BigDecimal  __severance ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __start_date ;
	protected java.lang.Integer  __duty_id ;
	protected java.lang.Integer  __link_id ;
	protected java.lang.Integer  __attachment_id ;
	protected java.lang.String  __attachment_name ;
}
