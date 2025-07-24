package pomplatform.projectCost.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetUnsettledProjectCost extends GenericBase implements BaseFactory<BaseGetUnsettledProjectCost>, Comparable<BaseGetUnsettledProjectCost> 
{


	public static BaseGetUnsettledProjectCost newInstance(){
		return new BaseGetUnsettledProjectCost();
	}

	@Override
	public BaseGetUnsettledProjectCost make(){
		BaseGetUnsettledProjectCost b = new BaseGetUnsettledProjectCost();
		return b;
	}

	public final static java.lang.String CS_PROJECT_COST_ID = "project_cost_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "项目费用编码,金额";

	public java.lang.Integer getProjectCostId() {
		return this.__project_cost_id;
	}

	public void setProjectCostId( java.lang.Integer value ) {
		this.__project_cost_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseGetUnsettledProjectCost __bean){
		__bean.setProjectCostId(getProjectCostId());
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectCostId() == null ? "" : getProjectCostId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetUnsettledProjectCost o) {
		return __project_cost_id == null ? -1 : __project_cost_id.compareTo(o.getProjectCostId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_cost_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetUnsettledProjectCost o = (BaseGetUnsettledProjectCost)obj;
		if(!Objects.equals(this.__project_cost_id, o.getProjectCostId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectCostId() != null) sb.append(__wrapNumber(count++, "projectCostId", getProjectCostId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectCostId")) != null) setProjectCostId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_cost_id ;
	protected java.math.BigDecimal  __amount ;
}
