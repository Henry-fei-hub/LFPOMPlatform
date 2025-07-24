package pomplatform.operation.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectemployeeForQuery extends GenericBase implements BaseFactory<BaseMprojectemployeeForQuery>, Comparable<BaseMprojectemployeeForQuery> 
{


	public static BaseMprojectemployeeForQuery newInstance(){
		return new BaseMprojectemployeeForQuery();
	}

	@Override
	public BaseMprojectemployeeForQuery make(){
		BaseMprojectemployeeForQuery b = new BaseMprojectemployeeForQuery();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PLAN_INTEGRAL = "plan_integral" ;
	public final static java.lang.String CS_REAL_INTEGRAL = "real_integral" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_SETTLEMENT = "settlement" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,员工编码,预分配积分,实际获得积分,费用,结算积分";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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
	
	public java.math.BigDecimal getAdvancedIntegral() {
		return this.__advanced_integral;
	}

	public void setAdvancedIntegral( java.math.BigDecimal value ) {
		this.__advanced_integral = value;
	}

	public void cloneCopy(BaseMprojectemployeeForQuery __bean){
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlanIntegral(getPlanIntegral());
		__bean.setRealIntegral(getRealIntegral());
		__bean.setCost(getCost());
		__bean.setSettlement(getSettlement());
		__bean.setAdvancedIntegral(getAdvancedIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
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
	public int compareTo(BaseMprojectemployeeForQuery o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__real_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__settlement);
		hash = 97 * hash + Objects.hashCode(this.__advanced_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectemployeeForQuery o = (BaseMprojectemployeeForQuery)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plan_integral, o.getPlanIntegral())) return false;
		if(!Objects.equals(this.__real_integral, o.getRealIntegral())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__settlement, o.getSettlement())) return false;
		if(!Objects.equals(this.__advanced_integral, o.getAdvancedIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlanIntegral() != null) sb.append(__wrapDecimal(count++, "planIntegral", getPlanIntegral()));
		if(getRealIntegral() != null) sb.append(__wrapDecimal(count++, "realIntegral", getRealIntegral()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getSettlement() != null) sb.append(__wrapDecimal(count++, "settlement", getSettlement()));
		if(getAdvancedIntegral() != null) sb.append(__wrapDecimal(count++, "advancedIntegral", getAdvancedIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("planIntegral")) != null) setPlanIntegral(__getDecimal(val));  
		if((val = values.get("realIntegral")) != null) setRealIntegral(__getDecimal(val));  
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("settlement")) != null) setSettlement(__getDecimal(val)); 
		if((val = values.get("advancedIntegral")) != null) setAdvancedIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __plan_integral ;
	protected java.math.BigDecimal  __real_integral ;
	protected java.math.BigDecimal  __cost ;
	protected java.math.BigDecimal  __settlement ;
	protected java.math.BigDecimal  __advanced_integral ;
}
