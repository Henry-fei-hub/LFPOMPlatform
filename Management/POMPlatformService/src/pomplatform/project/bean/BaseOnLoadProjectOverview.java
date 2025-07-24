package pomplatform.project.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectOverview extends GenericBase implements BaseFactory<BaseOnLoadProjectOverview>, Comparable<BaseOnLoadProjectOverview> 
{


	public static BaseOnLoadProjectOverview newInstance(){
		return new BaseOnLoadProjectOverview();
	}

	@Override
	public BaseOnLoadProjectOverview make(){
		BaseOnLoadProjectOverview b = new BaseOnLoadProjectOverview();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_TOTAL_INTEGRAL = "total_integral" ;
	public final static java.lang.String CS_RESERVE_INTEGRAL = "reserve_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_TOTAL_COUNT = "total_count" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_TOTAL_COST = "total_cost" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_LEFT_AMOUNT = "left_amount" ;
	public final static java.lang.String CS_RESERVE_AMOUNT = "reserve_amount" ;
	public final static java.lang.String CS_SURE_AMOUNT = "sure_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "合同id,项目编码,项目总积分,预留积分,项目积分,,,本次结算积分,未结算项目成本,已结算项目成本,,,,";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getTotalIntegral() {
		return this.__total_integral;
	}

	public void setTotalIntegral( java.math.BigDecimal value ) {
		this.__total_integral = value;
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

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.Integer getTotalCount() {
		return this.__total_count;
	}

	public void setTotalCount( java.lang.Integer value ) {
		this.__total_count = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.math.BigDecimal getTotalCost() {
		return this.__total_cost;
	}

	public void setTotalCost( java.math.BigDecimal value ) {
		this.__total_cost = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return this.__project_amount;
	}

	public void setProjectAmount( java.math.BigDecimal value ) {
		this.__project_amount = value;
	}

	public java.math.BigDecimal getLeftAmount() {
		return this.__left_amount;
	}

	public void setLeftAmount( java.math.BigDecimal value ) {
		this.__left_amount = value;
	}

	public java.math.BigDecimal getReserveAmount() {
		return this.__reserve_amount;
	}

	public void setReserveAmount( java.math.BigDecimal value ) {
		this.__reserve_amount = value;
	}

	public java.math.BigDecimal getSureAmount() {
		return this.__sure_amount;
	}

	public void setSureAmount( java.math.BigDecimal value ) {
		this.__sure_amount = value;
	}

	public void cloneCopy(BaseOnLoadProjectOverview __bean){
		__bean.setContractId(getContractId());
		__bean.setProjectId(getProjectId());
		__bean.setTotalIntegral(getTotalIntegral());
		__bean.setReserveIntegral(getReserveIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setPercent(getPercent());
		__bean.setTotalCount(getTotalCount());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setTotalCost(getTotalCost());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setLeftAmount(getLeftAmount());
		__bean.setReserveAmount(getReserveAmount());
		__bean.setSureAmount(getSureAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getTotalIntegral() == null ? "" : getTotalIntegral());
		sb.append(",");
		sb.append(getReserveIntegral() == null ? "" : getReserveIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getTotalCount() == null ? "" : getTotalCount());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getTotalCost() == null ? "" : getTotalCost());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getLeftAmount() == null ? "" : getLeftAmount());
		sb.append(",");
		sb.append(getReserveAmount() == null ? "" : getReserveAmount());
		sb.append(",");
		sb.append(getSureAmount() == null ? "" : getSureAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadProjectOverview o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__total_integral);
		hash = 97 * hash + Objects.hashCode(this.__reserve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__total_count);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_cost);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__left_amount);
		hash = 97 * hash + Objects.hashCode(this.__reserve_amount);
		hash = 97 * hash + Objects.hashCode(this.__sure_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadProjectOverview o = (BaseOnLoadProjectOverview)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__total_integral, o.getTotalIntegral())) return false;
		if(!Objects.equals(this.__reserve_integral, o.getReserveIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__total_count, o.getTotalCount())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__total_cost, o.getTotalCost())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__left_amount, o.getLeftAmount())) return false;
		if(!Objects.equals(this.__reserve_amount, o.getReserveAmount())) return false;
		if(!Objects.equals(this.__sure_amount, o.getSureAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getTotalIntegral() != null) sb.append(__wrapDecimal(count++, "totalIntegral", getTotalIntegral()));
		if(getReserveIntegral() != null) sb.append(__wrapDecimal(count++, "reserveIntegral", getReserveIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getTotalCount() != null) sb.append(__wrapNumber(count++, "totalCount", getTotalCount()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getTotalCost() != null) sb.append(__wrapDecimal(count++, "totalCost", getTotalCost()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getLeftAmount() != null) sb.append(__wrapDecimal(count++, "leftAmount", getLeftAmount()));
		if(getReserveAmount() != null) sb.append(__wrapDecimal(count++, "reserveAmount", getReserveAmount()));
		if(getSureAmount() != null) sb.append(__wrapDecimal(count++, "sureAmount", getSureAmount()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getTotalIntegral() != null) res.put("totalIntegral", getTotalIntegral());
		if(getReserveIntegral() != null) res.put("reserveIntegral", getReserveIntegral());
		if(getProjectIntegral() != null) res.put("projectIntegral", getProjectIntegral());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getTotalCount() != null) res.put("totalCount", getTotalCount());
		if(getTotalAmount() != null) res.put("totalAmount", getTotalAmount());
		if(getFinalAmount() != null) res.put("finalAmount", getFinalAmount());
		if(getTotalCost() != null) res.put("totalCost", getTotalCost());
		if(getProjectAmount() != null) res.put("projectAmount", getProjectAmount());
		if(getLeftAmount() != null) res.put("leftAmount", getLeftAmount());
		if(getReserveAmount() != null) res.put("reserveAmount", getReserveAmount());
		if(getSureAmount() != null) res.put("sureAmount", getSureAmount());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("totalIntegral")) != null) setTotalIntegral(__getDecimal(val));  
		if((val = values.get("reserveIntegral")) != null) setReserveIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("totalCount")) != null) setTotalCount(__getInt(val)); 
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("totalCost")) != null) setTotalCost(__getDecimal(val));  
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("leftAmount")) != null) setLeftAmount(__getDecimal(val));  
		if((val = values.get("reserveAmount")) != null) setReserveAmount(__getDecimal(val));  
		if((val = values.get("sureAmount")) != null) setSureAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __total_integral ;
	protected java.math.BigDecimal  __reserve_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.Integer  __total_count ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.math.BigDecimal  __total_cost ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.math.BigDecimal  __left_amount ;
	protected java.math.BigDecimal  __reserve_amount ;
	protected java.math.BigDecimal  __sure_amount ;
}
