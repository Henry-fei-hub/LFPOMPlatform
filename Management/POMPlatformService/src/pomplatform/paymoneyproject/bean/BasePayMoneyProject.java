package pomplatform.paymoneyproject.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePayMoneyProject extends GenericBase implements BaseFactory<BasePayMoneyProject>, Comparable<BasePayMoneyProject> 
{


	public static BasePayMoneyProject newInstance(){
		return new BasePayMoneyProject();
	}

	@Override
	public BasePayMoneyProject make(){
		BasePayMoneyProject b = new BasePayMoneyProject();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_DESIGN_PHASE = "design_phase" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_PLAN_START_DATE = "plan_start_date" ;
	public final static java.lang.String CS_PLAN_END_DATE = "plan_end_date" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_COMMON_AREA = "common_area" ;
	public final static java.lang.String CS_LOGISTICS_AREA = "logistics_area" ;
	public final static java.lang.String CS_PERCENTAGE = "percentage" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_COST_INTEGRAL = "cost_integral" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;
	public final static java.lang.String CS_PROJECT_DESCRIPTION = "project_description" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_DEPARTMENT_MANAGER_ID = "department_manager_id" ;
	public final static java.lang.String CS_PLATE_MANAGER_ID = "plate_manager_id" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,合同编号,项目名称,客户名称,板块,归属部门,设计阶段,项目编号,主订单名称,项目计划开始日期,项目计划结束日期,项目开始日期,项目结束日期,项目状态,公区面积,后勤面积,核算比例,项目总积分,项目积分,预留积分,订单成本,订单剩余积分,项目描述,项目等级,专业负责人,部门经理,事业部负责人";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.util.Date getPlanStartDate() {
		return this.__plan_start_date;
	}

	public void setPlanStartDate( java.util.Date value ) {
		this.__plan_start_date = value;
	}

	public java.util.Date getPlanEndDate() {
		return this.__plan_end_date;
	}

	public void setPlanEndDate( java.util.Date value ) {
		this.__plan_end_date = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getCommonArea() {
		return this.__common_area;
	}

	public void setCommonArea( java.math.BigDecimal value ) {
		this.__common_area = value;
	}

	public java.math.BigDecimal getLogisticsArea() {
		return this.__logistics_area;
	}

	public void setLogisticsArea( java.math.BigDecimal value ) {
		this.__logistics_area = value;
	}

	public java.math.BigDecimal getPercentage() {
		return this.__percentage;
	}

	public void setPercentage( java.math.BigDecimal value ) {
		this.__percentage = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.math.BigDecimal value ) {
		this.__reserve_integral = value;
	}

	public java.math.BigDecimal getCostIntegral() {
		return this.__cost_integral;
	}

	public void setCostIntegral( java.math.BigDecimal value ) {
		this.__cost_integral = value;
	}

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public java.lang.String getProjectDescription() {
		return this.__project_description;
	}

	public void setProjectDescription( java.lang.String value ) {
		this.__project_description = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.lang.Integer getPlateManagerId() {
		return this.__plate_manager_id;
	}

	public void setPlateManagerId( java.lang.Integer value ) {
		this.__plate_manager_id = value;
	}

	public void cloneCopy(BasePayMoneyProject __bean){
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setCustomerName(getCustomerName());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDesignPhase(getDesignPhase());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractName(getContractName());
		__bean.setPlanStartDate(getPlanStartDate());
		__bean.setPlanEndDate(getPlanEndDate());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setStatus(getStatus());
		__bean.setCommonArea(getCommonArea());
		__bean.setLogisticsArea(getLogisticsArea());
		__bean.setPercentage(getPercentage());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setCostIntegral(getCostIntegral());
		__bean.setLeftIntegral(getLeftIntegral());
		__bean.setProjectDescription(getProjectDescription());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setDepartmentManagerId(getDepartmentManagerId());
		__bean.setPlateManagerId(getPlateManagerId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getDesignPhase() == null ? "" : getDesignPhase());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getPlanStartDate() == null ? "" : sdf.format(getPlanStartDate()));
		sb.append(",");
		sb.append(getPlanEndDate() == null ? "" : sdf.format(getPlanEndDate()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getCommonArea() == null ? "" : getCommonArea());
		sb.append(",");
		sb.append(getLogisticsArea() == null ? "" : getLogisticsArea());
		sb.append(",");
		sb.append(getPercentage() == null ? "" : getPercentage());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getCostIntegral() == null ? "" : getCostIntegral());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		sb.append(",");
		sb.append(getProjectDescription() == null ? "" : getProjectDescription());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getDepartmentManagerId() == null ? "" : getDepartmentManagerId());
		sb.append(",");
		sb.append(getPlateManagerId() == null ? "" : getPlateManagerId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePayMoneyProject o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__design_phase);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__plan_start_date);
		hash = 97 * hash + Objects.hashCode(this.__plan_end_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__common_area);
		hash = 97 * hash + Objects.hashCode(this.__logistics_area);
		hash = 97 * hash + Objects.hashCode(this.__percentage);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_description);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__department_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePayMoneyProject o = (BasePayMoneyProject)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__design_phase, o.getDesignPhase())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__plan_start_date, o.getPlanStartDate())) return false;
		if(!Objects.equals(this.__plan_end_date, o.getPlanEndDate())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__common_area, o.getCommonArea())) return false;
		if(!Objects.equals(this.__logistics_area, o.getLogisticsArea())) return false;
		if(!Objects.equals(this.__percentage, o.getPercentage())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__cost_integral, o.getCostIntegral())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		if(!Objects.equals(this.__project_description, o.getProjectDescription())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__department_manager_id, o.getDepartmentManagerId())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(count++, "designPhase", getDesignPhase()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getPlanStartDate() != null) sb.append(__wrapDate(count++, "planStartDate", getPlanStartDate()));
		if(getPlanEndDate() != null) sb.append(__wrapDate(count++, "planEndDate", getPlanEndDate()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getCommonArea() != null) sb.append(__wrapDecimal(count++, "commonArea", getCommonArea()));
		if(getLogisticsArea() != null) sb.append(__wrapDecimal(count++, "logisticsArea", getLogisticsArea()));
		if(getPercentage() != null) sb.append(__wrapDecimal(count++, "percentage", getPercentage()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getCostIntegral() != null) sb.append(__wrapDecimal(count++, "costIntegral", getCostIntegral()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		if(getProjectDescription() != null) sb.append(__wrapString(count++, "projectDescription", getProjectDescription()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(count++, "departmentManagerId", getDepartmentManagerId()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, "plateManagerId", getPlateManagerId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("planStartDate")) != null) setPlanStartDate(__getDate(val)); 
		if((val = values.get("planEndDate")) != null) setPlanEndDate(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("commonArea")) != null) setCommonArea(__getDecimal(val));  
		if((val = values.get("logisticsArea")) != null) setLogisticsArea(__getDecimal(val));  
		if((val = values.get("percentage")) != null) setPercentage(__getDecimal(val));  
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("costIntegral")) != null) setCostIntegral(__getDecimal(val));  
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
		if((val = values.get("projectDescription")) != null) setProjectDescription(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __customer_name ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __design_phase ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __contract_name ;
	protected java.util.Date  __plan_start_date ;
	protected java.util.Date  __plan_end_date ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __common_area ;
	protected java.math.BigDecimal  __logistics_area ;
	protected java.math.BigDecimal  __percentage ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __cost_integral ;
	protected java.math.BigDecimal  __left_integral ;
	protected java.lang.String  __project_description ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.Integer  __department_manager_id ;
	protected java.lang.Integer  __plate_manager_id ;
}
