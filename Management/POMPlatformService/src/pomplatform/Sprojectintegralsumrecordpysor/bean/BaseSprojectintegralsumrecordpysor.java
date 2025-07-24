package pomplatform.Sprojectintegralsumrecordpysor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectintegralsumrecordpysor extends GenericBase implements BaseFactory<BaseSprojectintegralsumrecordpysor>, Comparable<BaseSprojectintegralsumrecordpysor> 
{


	public static BaseSprojectintegralsumrecordpysor newInstance(){
		return new BaseSprojectintegralsumrecordpysor();
	}

	@Override
	public BaseSprojectintegralsumrecordpysor make(){
		BaseSprojectintegralsumrecordpysor b = new BaseSprojectintegralsumrecordpysor();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL_SUM = "project_integral_sum" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_DISTRIBUTED_PROJECT_INTEGRAL = "distributed_project_integral" ;
	public final static java.lang.String CS_UNDISTRIBUTED_PROJECT_INTEGRAL = "undistributed_project_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_UNSURE_INTEGRAL = "unsure_integral" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_SETTLED_PROJECT_COST = "settled_project_cost" ;
	public final static java.lang.String CS_UNSETTLED_PROJECT_COST = "unsettled_project_cost" ;
	public final static java.lang.String CS_SETTLEMENT_INTEGRAL = "settlement_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,项目名称,项目总积分,预留积分,项目积分,已分配项目积分,未分配项目积分,确认积分,未确认积分,项目成本,已结算项目成本,未结算项目成本,结算积分";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getProjectIntegralSum() {
		return this.__project_integral_sum;
	}

	public void setProjectIntegralSum( java.math.BigDecimal value ) {
		this.__project_integral_sum = value;
	}

	public java.math.BigDecimal getReserveIntegral() {
		return this.__reserve_integral;
	}

	public void setReserveIntegral( java.math.BigDecimal value ) {
		this.__reserve_integral = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getDistributedProjectIntegral() {
		return this.__distributed_project_integral;
	}

	public void setDistributedProjectIntegral( java.math.BigDecimal value ) {
		this.__distributed_project_integral = value;
	}

	public java.math.BigDecimal getUndistributedProjectIntegral() {
		return this.__undistributed_project_integral;
	}

	public void setUndistributedProjectIntegral( java.math.BigDecimal value ) {
		this.__undistributed_project_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getUnsureIntegral() {
		return this.__unsure_integral;
	}

	public void setUnsureIntegral( java.math.BigDecimal value ) {
		this.__unsure_integral = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.math.BigDecimal getSettledProjectCost() {
		return this.__settled_project_cost;
	}

	public void setSettledProjectCost( java.math.BigDecimal value ) {
		this.__settled_project_cost = value;
	}

	public java.math.BigDecimal getUnsettledProjectCost() {
		return this.__unsettled_project_cost;
	}

	public void setUnsettledProjectCost( java.math.BigDecimal value ) {
		this.__unsettled_project_cost = value;
	}

	public java.math.BigDecimal getSettlementIntegral() {
		return this.__settlement_integral;
	}

	public void setSettlementIntegral( java.math.BigDecimal value ) {
		this.__settlement_integral = value;
	}

	public void cloneCopy(BaseSprojectintegralsumrecordpysor __bean){
		__bean.setPlateId(getPlateId());
		__bean.setProjectId(getProjectId());
		__bean.setProjectIntegralSum(getProjectIntegralSum());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setDistributedProjectIntegral(getDistributedProjectIntegral());
		__bean.setUndistributedProjectIntegral(getUndistributedProjectIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setUnsureIntegral(getUnsureIntegral());
		__bean.setProjectCost(getProjectCost());
		__bean.setSettledProjectCost(getSettledProjectCost());
		__bean.setUnsettledProjectCost(getUnsettledProjectCost());
		__bean.setSettlementIntegral(getSettlementIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getProjectIntegralSum() == null ? "" : getProjectIntegralSum());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getDistributedProjectIntegral() == null ? "" : getDistributedProjectIntegral());
		sb.append(",");
		sb.append(getUndistributedProjectIntegral() == null ? "" : getUndistributedProjectIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getUnsureIntegral() == null ? "" : getUnsureIntegral());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getSettledProjectCost() == null ? "" : getSettledProjectCost());
		sb.append(",");
		sb.append(getUnsettledProjectCost() == null ? "" : getUnsettledProjectCost());
		sb.append(",");
		sb.append(getSettlementIntegral() == null ? "" : getSettlementIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectintegralsumrecordpysor o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_integral_sum);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__distributed_project_integral);
		hash = 97 * hash + Objects.hashCode(this.__undistributed_project_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__unsure_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__settled_project_cost);
		hash = 97 * hash + Objects.hashCode(this.__unsettled_project_cost);
		hash = 97 * hash + Objects.hashCode(this.__settlement_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectintegralsumrecordpysor o = (BaseSprojectintegralsumrecordpysor)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_integral_sum, o.getProjectIntegralSum())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__distributed_project_integral, o.getDistributedProjectIntegral())) return false;
		if(!Objects.equals(this.__undistributed_project_integral, o.getUndistributedProjectIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__unsure_integral, o.getUnsureIntegral())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__settled_project_cost, o.getSettledProjectCost())) return false;
		if(!Objects.equals(this.__unsettled_project_cost, o.getUnsettledProjectCost())) return false;
		if(!Objects.equals(this.__settlement_integral, o.getSettlementIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectIntegralSum() != null) sb.append(__wrapDecimal(count++, "projectIntegralSum", getProjectIntegralSum()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getDistributedProjectIntegral() != null) sb.append(__wrapDecimal(count++, "distributedProjectIntegral", getDistributedProjectIntegral()));
		if(getUndistributedProjectIntegral() != null) sb.append(__wrapDecimal(count++, "undistributedProjectIntegral", getUndistributedProjectIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getUnsureIntegral() != null) sb.append(__wrapDecimal(count++, "unsureIntegral", getUnsureIntegral()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getSettledProjectCost() != null) sb.append(__wrapDecimal(count++, "settledProjectCost", getSettledProjectCost()));
		if(getUnsettledProjectCost() != null) sb.append(__wrapDecimal(count++, "unsettledProjectCost", getUnsettledProjectCost()));
		if(getSettlementIntegral() != null) sb.append(__wrapDecimal(count++, "settlementIntegral", getSettlementIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectIntegralSum")) != null) setProjectIntegralSum(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("distributedProjectIntegral")) != null) setDistributedProjectIntegral(__getDecimal(val));  
		if((val = values.get("undistributedProjectIntegral")) != null) setUndistributedProjectIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("unsureIntegral")) != null) setUnsureIntegral(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("settledProjectCost")) != null) setSettledProjectCost(__getDecimal(val));  
		if((val = values.get("unsettledProjectCost")) != null) setUnsettledProjectCost(__getDecimal(val));  
		if((val = values.get("settlementIntegral")) != null) setSettlementIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __project_integral_sum ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __distributed_project_integral ;
	protected java.math.BigDecimal  __undistributed_project_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __unsure_integral ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.math.BigDecimal  __settled_project_cost ;
	protected java.math.BigDecimal  __unsettled_project_cost ;
	protected java.math.BigDecimal  __settlement_integral ;
}
