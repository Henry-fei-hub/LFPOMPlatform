package pomplatform.designer.invitation.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectemployeepor extends GenericBase implements BaseFactory<BaseMprojectemployeepor>, Comparable<BaseMprojectemployeepor> 
{


	public static BaseMprojectemployeepor newInstance(){
		return new BaseMprojectemployeepor();
	}

	@Override
	public BaseMprojectemployeepor make(){
		BaseMprojectemployeepor b = new BaseMprojectemployeepor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_EMPLOYEE_ID = "project_employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_WORK_CONTENT = "work_content" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_REAL_INTEGRAL = "real_integral" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_SETTLEMENT = "settlement" ;

	public final static java.lang.String ALL_CAPTIONS = "项目负责人编码,项目名称,项目编码,项目组建编码,员工编码,工作内容,实际开始日期,实际结束日期,,,,";

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getProjectEmployeeId() {
		return this.__project_employee_id;
	}

	public void setProjectEmployeeId( java.lang.Integer value ) {
		this.__project_employee_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getWorkContent() {
		return this.__work_content;
	}

	public void setWorkContent( java.lang.String value ) {
		this.__work_content = value;
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

	public java.math.BigDecimal getPlanIntegral() {
		return this.__plan_integral;
	}

	public void setPlanIntegral( java.math.BigDecimal value ) {
		this.__plan_integral = value;
	}

	public java.math.BigDecimal getRealIntegral() {
		return this.__real_integral;
	}

	public void setRealIntegral( java.math.BigDecimal value ) {
		this.__real_integral = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public java.math.BigDecimal getSettlement() {
		return this.__settlement;
	}

	public void setSettlement( java.math.BigDecimal value ) {
		this.__settlement = value;
	}

	public void cloneCopy(BaseMprojectemployeepor __bean){
		__bean.setProjectManageId(getProjectManageId());
		__bean.setProjectName(getProjectName());
		__bean.setProjectId(getProjectId());
		__bean.setProjectEmployeeId(getProjectEmployeeId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setWorkContent(getWorkContent());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setRealIntegral(getRealIntegral());
		__bean.setCost(getCost());
		__bean.setSettlement(getSettlement());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getProjectEmployeeId() == null ? "" : getProjectEmployeeId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getWorkContent() == null ? "" : getWorkContent());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getPlanIntegral() == null ? "" : getPlanIntegral());
		sb.append(",");
		sb.append(getRealIntegral() == null ? "" : getRealIntegral());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		sb.append(",");
		sb.append(getSettlement() == null ? "" : getSettlement());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectemployeepor o) {
		return __project_employee_id == null ? -1 : __project_employee_id.compareTo(o.getProjectEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__work_content);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__real_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__settlement);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectemployeepor o = (BaseMprojectemployeepor)obj;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_employee_id, o.getProjectEmployeeId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__work_content, o.getWorkContent())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__real_integral, o.getRealIntegral())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__settlement, o.getSettlement())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectEmployeeId() != null) sb.append(__wrapNumber(count++, "projectEmployeeId", getProjectEmployeeId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getWorkContent() != null) sb.append(__wrapString(count++, "workContent", getWorkContent()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getRealIntegral() != null) sb.append(__wrapDecimal(count++, "realIntegral", getRealIntegral()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getSettlement() != null) sb.append(__wrapDecimal(count++, "settlement", getSettlement()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectEmployeeId")) != null) setProjectEmployeeId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("workContent")) != null) setWorkContent(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("realIntegral")) != null) setRealIntegral(__getDecimal(val));  
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("settlement")) != null) setSettlement(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __project_employee_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __work_content ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __real_integral ;
	protected java.math.BigDecimal  __cost ;
	protected java.math.BigDecimal  __settlement ;
}
