package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePreProjectMyRecords extends GenericBase implements BaseFactory<BasePreProjectMyRecords>, Comparable<BasePreProjectMyRecords> 
{


	public static BasePreProjectMyRecords newInstance(){
		return new BasePreProjectMyRecords();
	}

	@Override
	public BasePreProjectMyRecords make(){
		BasePreProjectMyRecords b = new BasePreProjectMyRecords();
		return b;
	}

	public final static java.lang.String CS_APPLY_EMPLOYEE_ID = "apply_employee_id" ;
	public final static java.lang.String CS_REGISTER_DATE = "register_date" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_WIN_RATE = "win_rate" ;
	public final static java.lang.String CS_PROJECT_STATUS = "project_status" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PROJECT_BASE_ON = "project_base_on" ;
	public final static java.lang.String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static java.lang.String CS_ESTIMATE_THE_DESIGN_AREAS = "estimate_the_design_areas" ;
	public final static java.lang.String CS_ACTUAL_DESIGN_AREAS = "actual_design_areas" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_TRACK_DATE = "track_date" ;
	public final static java.lang.String CS_PROJECT_RECORD_REMARK = "project_record_remark" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static java.lang.String CS_PROJECT_SALES_TEAM = "project_sales_team" ;
	public final static java.lang.String CS_DESIGN_TEAM = "design_team" ;
	public final static java.lang.String CS_PROJECT_LEADER = "project_leader" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;

	public final static java.lang.String ALL_CAPTIONS = "报备人,登记时间,信息编号,项目名称,客户名称,项目地址（省）,项目地址（市）,业务类别,项目等级,赢率,项目状态,报备流程状态,立项/关闭的流程状态,立项依据,立项时间,设计预估面积,实际设计面积,预估合同金额,跟踪时间,项目跟踪记录,项目来源渠道,项目营销团队,主办设计团队,项目主管领导,项目经理";

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.util.Date getRegisterDate() {
		return this.__register_date;
	}

	public void setRegisterDate( java.util.Date value ) {
		this.__register_date = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.String value ) {
		this.__province = value;
	}

	public java.lang.String getCity() {
		return this.__city;
	}

	public void setCity( java.lang.String value ) {
		this.__city = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.String getWinRate() {
		return this.__win_rate;
	}

	public void setWinRate( java.lang.String value ) {
		this.__win_rate = value;
	}

	public java.lang.String getProjectStatus() {
		return this.__project_status;
	}

	public void setProjectStatus( java.lang.String value ) {
		this.__project_status = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( java.lang.Integer value ) {
		this.__project_base_on = value;
	}

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.math.BigDecimal getEstimateTheDesignAreas() {
		return this.__estimate_the_design_areas;
	}

	public void setEstimateTheDesignAreas( java.math.BigDecimal value ) {
		this.__estimate_the_design_areas = value;
	}

	public java.math.BigDecimal getActualDesignAreas() {
		return this.__actual_design_areas;
	}

	public void setActualDesignAreas( java.math.BigDecimal value ) {
		this.__actual_design_areas = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.util.Date getTrackDate() {
		return this.__track_date;
	}

	public void setTrackDate( java.util.Date value ) {
		this.__track_date = value;
	}

	public java.lang.String getProjectRecordRemark() {
		return this.__project_record_remark;
	}

	public void setProjectRecordRemark( java.lang.String value ) {
		this.__project_record_remark = value;
	}

	public java.lang.String getProjectOrigination() {
		return this.__project_origination;
	}

	public void setProjectOrigination( java.lang.String value ) {
		this.__project_origination = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.String getProjectLeader() {
		return this.__project_leader;
	}

	public void setProjectLeader( java.lang.String value ) {
		this.__project_leader = value;
	}

	public java.lang.String getProjectManager() {
		return this.__project_manager;
	}

	public void setProjectManager( java.lang.String value ) {
		this.__project_manager = value;
	}

	public void cloneCopy(BasePreProjectMyRecords __bean){
		__bean.setApplyEmployeeId(getApplyEmployeeId());
		__bean.setRegisterDate(getRegisterDate());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectName(getProjectName());
		__bean.setCustomerName(getCustomerName());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setWinRate(getWinRate());
		__bean.setProjectStatus(getProjectStatus());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setStatus(getStatus());
		__bean.setProjectBaseOn(getProjectBaseOn());
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setEstimateTheDesignAreas(getEstimateTheDesignAreas());
		__bean.setActualDesignAreas(getActualDesignAreas());
		__bean.setContractAmount(getContractAmount());
		__bean.setTrackDate(getTrackDate());
		__bean.setProjectRecordRemark(getProjectRecordRemark());
		__bean.setProjectOrigination(getProjectOrigination());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDesignTeam(getDesignTeam());
		__bean.setProjectLeader(getProjectLeader());
		__bean.setProjectManager(getProjectManager());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String applyEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getApplyEmployeeId()));
		sb.append(getApplyEmployeeId() == null ? "" : applyEmployeeId);
		sb.append(",");
		sb.append(getRegisterDate() == null ? "" : sdf.format(getRegisterDate()));
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType().replaceAll(",", "，"));
		sb.append(",");
		String projectLevel= delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
		sb.append(getProjectLevel() == null ? "" : projectLevel);
		sb.append(",");
		sb.append(getWinRate() == null ? "" : getWinRate());
		sb.append(",");
		sb.append(getProjectStatus() == null ? "" :getProjectStatus());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		String status= delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_161", String.valueOf(getStatus()));
		sb.append(getStatus() == null ? "" : status);
		sb.append(",");
		String projectBaseOn= delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_28", String.valueOf(getProjectBaseOn()));
		sb.append(getProjectBaseOn() == null ? "" : projectBaseOn);
		sb.append(",");
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		sb.append(getEstimateTheDesignAreas() == null ? "" : getEstimateTheDesignAreas());
		sb.append(",");
		sb.append(getActualDesignAreas() == null ? "" : getActualDesignAreas());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getTrackDate() == null ? "" : sdf.format(getTrackDate()));
		sb.append(",");
		sb.append(getProjectRecordRemark() == null ? "" : getProjectRecordRemark().replaceAll(",", "，").replaceAll("\r", " ").replaceAll("\n", " "));
		sb.append(",");
		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
		sb.append(",");
		String departments= delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(getDepartmentId() == null ? "" : departments);
		sb.append(",");
		String designTeam= delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getDesignTeam()));
		sb.append(getDesignTeam() == null ? "" : designTeam);
		sb.append(",");
		sb.append(getProjectLeader() == null ? "" : getProjectLeader());
		sb.append(",");
		sb.append(getProjectManager() == null ? "" : getProjectManager());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePreProjectMyRecords o) {
		return __apply_employee_id == null ? -1 : __apply_employee_id.compareTo(o.getApplyEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__apply_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__register_date);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__win_rate);
		hash = 97 * hash + Objects.hashCode(this.__project_status);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__project_base_on);
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__estimate_the_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__actual_design_areas);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__track_date);
		hash = 97 * hash + Objects.hashCode(this.__project_record_remark);
		hash = 97 * hash + Objects.hashCode(this.__project_origination);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__design_team);
		hash = 97 * hash + Objects.hashCode(this.__project_leader);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePreProjectMyRecords o = (BasePreProjectMyRecords)obj;
		if(!Objects.equals(this.__apply_employee_id, o.getApplyEmployeeId())) return false;
		if(!Objects.equals(this.__register_date, o.getRegisterDate())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__win_rate, o.getWinRate())) return false;
		if(!Objects.equals(this.__project_status, o.getProjectStatus())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__project_base_on, o.getProjectBaseOn())) return false;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__estimate_the_design_areas, o.getEstimateTheDesignAreas())) return false;
		if(!Objects.equals(this.__actual_design_areas, o.getActualDesignAreas())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__track_date, o.getTrackDate())) return false;
		if(!Objects.equals(this.__project_record_remark, o.getProjectRecordRemark())) return false;
		if(!Objects.equals(this.__project_origination, o.getProjectOrigination())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__design_team, o.getDesignTeam())) return false;
		if(!Objects.equals(this.__project_leader, o.getProjectLeader())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(count++, "applyEmployeeId", getApplyEmployeeId()));
		if(getRegisterDate() != null) sb.append(__wrapDate(count++, "registerDate", getRegisterDate()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getWinRate() != null) sb.append(__wrapString(count++, "winRate", getWinRate()));
		if(getProjectStatus() != null) sb.append(__wrapString(count++, "projectStatus", getProjectStatus()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(count++, "projectBaseOn", getProjectBaseOn()));
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getEstimateTheDesignAreas() != null) sb.append(__wrapDecimal(count++, "estimateTheDesignAreas", getEstimateTheDesignAreas()));
		if(getActualDesignAreas() != null) sb.append(__wrapDecimal(count++, "actualDesignAreas", getActualDesignAreas()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getTrackDate() != null) sb.append(__wrapDate(count++, "trackDate", getTrackDate()));
		if(getProjectRecordRemark() != null) sb.append(__wrapString(count++, "projectRecordRemark", getProjectRecordRemark()));
		if(getProjectOrigination() != null) sb.append(__wrapString(count++, "projectOrigination", getProjectOrigination()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(count++, "designTeam", getDesignTeam()));
		if(getProjectLeader() != null) sb.append(__wrapString(count++, "projectLeader", getProjectLeader()));
		if(getProjectManager() != null) sb.append(__wrapString(count++, "projectManager", getProjectManager()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("registerDate")) != null) setRegisterDate(__getDate(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("winRate")) != null) setWinRate(__getString(val));
		if((val = values.get("projectStatus")) != null) setProjectStatus(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val)); 
		if((val = values.get("estimateTheDesignAreas")) != null) setEstimateTheDesignAreas(__getDecimal(val));  
		if((val = values.get("actualDesignAreas")) != null) setActualDesignAreas(__getDecimal(val));  
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("trackDate")) != null) setTrackDate(__getDate(val)); 
		if((val = values.get("projectRecordRemark")) != null) setProjectRecordRemark(__getString(val));
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val)); 
		if((val = values.get("projectLeader")) != null) setProjectLeader(__getString(val));
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
	}

	protected java.lang.Integer  __apply_employee_id ;
	protected java.util.Date  __register_date ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.String  __business_type ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.String  __win_rate ;
	protected java.lang.String  __project_status ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __project_base_on ;
	protected java.util.Date  __project_approval_time ;
	protected java.math.BigDecimal  __estimate_the_design_areas ;
	protected java.math.BigDecimal  __actual_design_areas ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.util.Date  __track_date ;
	protected java.lang.String  __project_record_remark ;
	protected java.lang.String  __project_origination ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __design_team ;
	protected java.lang.String  __project_leader ;
	protected java.lang.String  __project_manager ;
}
