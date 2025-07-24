package pomplatform.preProjects.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionprojectPreInfomations extends GenericCondition{

	public ConditionprojectPreInfomations(){
		setParameterCount(35);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getInfoCode() {
//		return this.__info_code;
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.String getDetailAddress() {
		return this.__detail_address == null ? null : (this.__detail_address.indexOf("%") >= 0 ? this.__detail_address : "%"+this.__detail_address+"%");
	}

	public void setDetailAddress( java.lang.String value ) {
		this.__detail_address = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.String getProjectStatus() {
		return this.__project_status;
	}

	public void setProjectStatus( java.lang.String value ) {
		this.__project_status = value;
	}

	public java.lang.String getProjectSalesTeam() {
		return this.__project_sales_team;
	}

	public void setProjectSalesTeam( java.lang.String value ) {
		this.__project_sales_team = value;
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

	public java.lang.String getProjectOrigination() {
		return this.__project_origination;
	}

	public void setProjectOrigination( java.lang.String value ) {
		this.__project_origination = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name == null ? null : (this.__contact_name.indexOf("%") >= 0 ? this.__contact_name : "%"+this.__contact_name+"%");
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getProjectMissioner() {
		return this.__project_missioner == null ? null : (this.__project_missioner.indexOf("%") >= 0 ? this.__project_missioner : "%"+this.__project_missioner+"%");
	}

	public void setProjectMissioner( java.lang.String value ) {
		this.__project_missioner = value;
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

	public java.math.BigDecimal getProjectTotalInvestment() {
		return this.__project_total_investment;
	}

	public void setProjectTotalInvestment( java.math.BigDecimal value ) {
		this.__project_total_investment = value;
	}

	public java.math.BigDecimal getDecorateMoneyControl() {
		return this.__decorate_money_control;
	}

	public void setDecorateMoneyControl( java.math.BigDecimal value ) {
		this.__decorate_money_control = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.lang.String getDesignStatus() {
		return this.__design_status;
	}

	public void setDesignStatus( java.lang.String value ) {
		this.__design_status = value;
	}

	public java.lang.String getProvince() {

		return this.__province == null ? null : (this.__province.indexOf("%") >= 0 ? this.__province : "%"+this.__province+"%");
	}

	public void setProvince( java.lang.String value ) {
		this.__province = value;
	}

	public java.lang.String getCity() {
		return this.__city == null ? null : (this.__city.indexOf("%") >= 0 ? this.__city : "%"+this.__city+"%");
	}

	public void setCity( java.lang.String value ) {
		this.__city = value;
	}

	public java.lang.String getDesignCooperationName() {
		return this.__design_cooperation_name;
	}

	public void setDesignCooperationName( java.lang.String value ) {
		this.__design_cooperation_name = value;
	}

	public java.lang.String getArchitecturalDesignUnits() {
		return this.__architectural_design_units;
	}

	public void setArchitecturalDesignUnits( java.lang.String value ) {
		this.__architectural_design_units = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getProjectLeader() {
		return this.__project_leader == null ? null : (this.__project_leader.indexOf("%") >= 0 ? this.__project_leader : "%"+this.__project_leader+"%");
	}

	public void setProjectLeader( java.lang.String value ) {
		this.__project_leader = value;
	}

	public java.lang.String getProjectManager() {
		return this.__project_manager == null ? null : (this.__project_manager.indexOf("%") >= 0 ? this.__project_manager : "%"+this.__project_manager+"%");
	}

	public void setProjectManager( java.lang.String value ) {
		this.__project_manager = value;
	}

	public java.util.Date getCreateTimeStart() {
		return this.__create_time_start;
	}

	public void setCreateTimeStart( java.util.Date value ) {
		this.__create_time_start = value;
	}

	public java.util.Date getCreateTimeEnd() {
		return this.__create_time_end;
	}

	public void setCreateTimeEnd( java.util.Date value ) {
		this.__create_time_end = value;
	}

	public java.lang.String getWinRate() {
		return this.__win_rate;
	}

	public void setWinRate( java.lang.String value ) {
		this.__win_rate = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getBusinessType() != null) sb.append(__wrapString(1, "businessType", getBusinessType()));
		if(getDetailAddress() != null) sb.append(__wrapString(1, "detailAddress", getDetailAddress()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(1, "projectLevel", getProjectLevel()));
		if(getContractAmount() != null) sb.append(__wrapNumber(1, "contractAmount", getContractAmount()));
		if(getProjectStatus() != null) sb.append(__wrapString(1, "projectStatus", getProjectStatus()));
		if(getProjectSalesTeam() != null) sb.append(__wrapString(1, "projectSalesTeam", getProjectSalesTeam()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(1, "projectBaseOn", getProjectBaseOn()));
		if(getProjectOrigination() != null) sb.append(__wrapString(1, "projectOrigination", getProjectOrigination()));
		if(getContactName() != null) sb.append(__wrapString(1, "contactName", getContactName()));
		if(getProjectMissioner() != null) sb.append(__wrapString(1, "projectMissioner", getProjectMissioner()));
		if(getEstimateTheDesignAreas() != null) sb.append(__wrapNumber(1, "estimateTheDesignAreas", getEstimateTheDesignAreas()));
		if(getActualDesignAreas() != null) sb.append(__wrapNumber(1, "actualDesignAreas", getActualDesignAreas()));
		if(getProjectTotalInvestment() != null) sb.append(__wrapNumber(1, "projectTotalInvestment", getProjectTotalInvestment()));
		if(getDecorateMoneyControl() != null) sb.append(__wrapNumber(1, "decorateMoneyControl", getDecorateMoneyControl()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(1, "designTeam", getDesignTeam()));
		if(getContractStatus() != null) sb.append(__wrapNumber(1, "contractStatus", getContractStatus()));
		if(getDesignStatus() != null) sb.append(__wrapString(1, "designStatus", getDesignStatus()));
		if(getProvince() != null) sb.append(__wrapString(1, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(1, "city", getCity()));
		if(getDesignCooperationName() != null) sb.append(__wrapString(1, "designCooperationName", getDesignCooperationName()));
		if(getArchitecturalDesignUnits() != null) sb.append(__wrapString(1, "architecturalDesignUnits", getArchitecturalDesignUnits()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getProjectLeader() != null) sb.append(__wrapString(1, "projectLeader", getProjectLeader()));
		if(getProjectManager() != null) sb.append(__wrapString(1, "projectManager", getProjectManager()));
		if(getCreateTimeStart() != null) sb.append(__wrapDate(1, "createTimeStart", getCreateTimeStart()));
		if(getCreateTimeEnd() != null) sb.append(__wrapDate(1, "createTimeEnd", getCreateTimeEnd()));
		if(getWinRate() != null) sb.append(__wrapString(1, "winRate", getWinRate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("projectStatus")) != null) setProjectStatus(__getString(val));
		if((val = values.get("projectSalesTeam")) != null) setProjectSalesTeam(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("projectMissioner")) != null) setProjectMissioner(__getString(val));
		if((val = values.get("estimateTheDesignAreas")) != null) setEstimateTheDesignAreas(__getDecimal(val));  
		if((val = values.get("actualDesignAreas")) != null) setActualDesignAreas(__getDecimal(val));  
		if((val = values.get("projectTotalInvestment")) != null) setProjectTotalInvestment(__getDecimal(val));  
		if((val = values.get("decorateMoneyControl")) != null) setDecorateMoneyControl(__getDecimal(val));  
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val)); 
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("designStatus")) != null) setDesignStatus(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("designCooperationName")) != null) setDesignCooperationName(__getString(val));
		if((val = values.get("architecturalDesignUnits")) != null) setArchitecturalDesignUnits(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("projectLeader")) != null) setProjectLeader(__getString(val));
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
		if((val = values.get("createTimeStart")) != null) setCreateTimeStart(__getDate(val)); 
		if((val = values.get("createTimeEnd")) != null) setCreateTimeEnd(__getDate(val)); 
		if((val = values.get("winRate")) != null) setWinRate(__getString(val));
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __project_code = null;
	private java.lang.String __info_code = null;
	private java.lang.String __project_name = null;
	private java.lang.String __customer_name = null;
	private java.lang.String __business_type = null;
	private java.lang.String __detail_address = null;
	private java.lang.Integer __project_level = null;
	private java.math.BigDecimal __contract_amount = null;
	private java.lang.String __project_status = null;
	private java.lang.String __project_sales_team = null;
	private java.lang.Integer __process_status = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __project_base_on = null;
	private java.lang.String __project_origination = null;
	private java.lang.String __contact_name = null;
	private java.lang.String __project_missioner = null;
	private java.math.BigDecimal __estimate_the_design_areas = null;
	private java.math.BigDecimal __actual_design_areas = null;
	private java.math.BigDecimal __project_total_investment = null;
	private java.math.BigDecimal __decorate_money_control = null;
	private java.lang.Integer __design_team = null;
	private java.lang.Integer __contract_status = null;
	private java.lang.String __design_status = null;
	private java.lang.String __province = null;
	private java.lang.String __city = null;
	private java.lang.String __design_cooperation_name = null;
	private java.lang.String __architectural_design_units = null;
	private java.lang.String __employee_name = null;
	private java.lang.String __project_leader = null;
	private java.lang.String __project_manager = null;
	private java.util.Date __create_time_start = null;
	private java.util.Date __create_time_end = null;
	private java.lang.String __win_rate = null;
}

