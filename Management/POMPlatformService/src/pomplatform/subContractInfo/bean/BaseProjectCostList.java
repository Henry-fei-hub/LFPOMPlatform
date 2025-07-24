package pomplatform.subContractInfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectCostList extends GenericBase implements BaseFactory<BaseProjectCostList>, Comparable<BaseProjectCostList> 
{


	public static BaseProjectCostList newInstance(){
		return new BaseProjectCostList();
	}

	@Override
	public BaseProjectCostList make(){
		BaseProjectCostList b = new BaseProjectCostList();
		return b;
	}

	public final static java.lang.String CS_PROJECT_COST_ID = "project_cost_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_COST_TYPE = "cost_type" ;
	public final static java.lang.String CS_COST_DATE = "cost_date" ;
	public final static java.lang.String CS_SETTLEMENT_ID = "settlement_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "项目费用编码,项目名称,经办人,费用类型,日期,结算代码,状态,金额";

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

	public java.lang.Integer getSettlementId() {
		return this.__settlement_id;
	}

	public void setSettlementId( java.lang.Integer value ) {
		this.__settlement_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseProjectCostList __bean){
		__bean.setProjectCostId(getProjectCostId());
		__bean.setProjectId(getProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCostType(getCostType());
		__bean.setCostDate(getCostDate());
		__bean.setSettlementId(getSettlementId());
		__bean.setStatus(getStatus());
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCostId() == null ? "" : getProjectCostId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strCostType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_9", String.valueOf(getCostType()));
		sb.append(strCostType == null ? "" : strCostType);
		sb.append(",");
		sb.append(getCostDate() == null ? "" : sdf.format(getCostDate()));
		sb.append(",");
		sb.append(getSettlementId() == null ? "" : getSettlementId());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_16", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectCostList o) {
		return __project_cost_id == null ? -1 : __project_cost_id.compareTo(o.getProjectCostId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_cost_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__cost_type);
		hash = 97 * hash + Objects.hashCode(this.__cost_date);
		hash = 97 * hash + Objects.hashCode(this.__settlement_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectCostList o = (BaseProjectCostList)obj;
		if(!Objects.equals(this.__project_cost_id, o.getProjectCostId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__cost_type, o.getCostType())) return false;
		if(!Objects.equals(this.__cost_date, o.getCostDate())) return false;
		if(!Objects.equals(this.__settlement_id, o.getSettlementId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectCostId() != null) sb.append(__wrapNumber(count++, "projectCostId", getProjectCostId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCostType() != null) sb.append(__wrapNumber(count++, "costType", getCostType()));
		if(getCostDate() != null) sb.append(__wrapDate(count++, "costDate", getCostDate()));
		if(getSettlementId() != null) sb.append(__wrapNumber(count++, "settlementId", getSettlementId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectCostId")) != null) setProjectCostId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
		if((val = values.get("costDate")) != null) setCostDate(__getDate(val)); 
		if((val = values.get("settlementId")) != null) setSettlementId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_cost_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __cost_type ;
	protected java.util.Date  __cost_date ;
	protected java.lang.Integer  __settlement_id ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __amount ;
}
