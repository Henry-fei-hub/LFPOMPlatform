package pomplatform.projectCost.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectcostpcor extends GenericBase implements BaseFactory<BaseSprojectcostpcor>, Comparable<BaseSprojectcostpcor> 
{


	public static BaseSprojectcostpcor newInstance(){
		return new BaseSprojectcostpcor();
	}

	@Override
	public BaseSprojectcostpcor make(){
		BaseSprojectcostpcor b = new BaseSprojectcostpcor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_COST_ID = "project_cost_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_COST_MONEY = "cost_money" ;
	public final static java.lang.String CS_COST_TYPE = "cost_type" ;
	public final static java.lang.String CS_COST_DATE = "cost_date" ;

	public final static java.lang.String ALL_CAPTIONS = "项目费用编码,项目编码,经办人,金额,费用类型,日期";

	public java.lang.Integer getProjectCostId() {
		return this.__project_cost_id;
	}

	public void setProjectCostId( java.lang.Integer value ) {
		this.__project_cost_id = value;
	}

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

	public java.lang.String getCostMoney() {
		return this.__cost_money;
	}

	public void setCostMoney( java.lang.String value ) {
		this.__cost_money = value;
	}

	public java.lang.Integer getCostType() {
		return this.__cost_type;
	}

	public void setCostType( java.lang.Integer value ) {
		this.__cost_type = value;
	}

	public java.util.Date getCostDate() {
		return this.__cost_date;
	}

	public void setCostDate( java.util.Date value ) {
		this.__cost_date = value;
	}

	public void cloneCopy(BaseSprojectcostpcor __bean){
		__bean.setProjectCostId(getProjectCostId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCostMoney(getCostMoney());
		__bean.setCostType(getCostType());
		__bean.setCostDate(getCostDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCostId() == null ? "" : getProjectCostId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCostMoney() == null ? "" : getCostMoney());
		sb.append(",");
		sb.append(getCostType() == null ? "" : getCostType());
		sb.append(",");
		sb.append(getCostDate() == null ? "" : sdf.format(getCostDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectcostpcor o) {
		return __project_cost_id == null ? -1 : __project_cost_id.compareTo(o.getProjectCostId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_cost_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__cost_money);
		hash = 97 * hash + Objects.hashCode(this.__cost_type);
		hash = 97 * hash + Objects.hashCode(this.__cost_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectcostpcor o = (BaseSprojectcostpcor)obj;
		if(!Objects.equals(this.__project_cost_id, o.getProjectCostId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__cost_money, o.getCostMoney())) return false;
		if(!Objects.equals(this.__cost_type, o.getCostType())) return false;
		if(!Objects.equals(this.__cost_date, o.getCostDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectCostId() != null) sb.append(__wrapNumber(count++, "projectCostId", getProjectCostId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCostMoney() != null) sb.append(__wrapString(count++, "costMoney", getCostMoney()));
		if(getCostType() != null) sb.append(__wrapNumber(count++, "costType", getCostType()));
		if(getCostDate() != null) sb.append(__wrapDate(count++, "costDate", getCostDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectCostId")) != null) setProjectCostId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("costMoney")) != null) setCostMoney(__getString(val));
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
		if((val = values.get("costDate")) != null) setCostDate(__getDate(val)); 
	}

	protected java.lang.Integer  __project_cost_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __cost_money ;
	protected java.lang.Integer  __cost_type ;
	protected java.util.Date  __cost_date ;
}
