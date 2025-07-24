package pomplatform.buggetdetailinfo.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBuggetDetailInfo extends GenericBase implements BaseFactory<BaseBuggetDetailInfo>, Comparable<BaseBuggetDetailInfo> 
{


	public static BaseBuggetDetailInfo newInstance(){
		return new BaseBuggetDetailInfo();
	}

	@Override
	public BaseBuggetDetailInfo make(){
		BaseBuggetDetailInfo b = new BaseBuggetDetailInfo();
		return b;
	}

	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_BDD_TYPE = "bdd_type" ;
	public final static java.lang.String CS_BDD_AMOUNT = "bdd_amount" ;
	public final static java.lang.String CS_BDD_AMOUNT_PERCENT = "bdd_amount_percent" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT_USE = "budget_contract_amount_use" ;
	public final static java.lang.String CS_USE_PERCENT = "use_percent" ;

	public final static java.lang.String ALL_CAPTIONS = "预算管理id,预算类别,预算金额,预算类别占比,实际已用金额,实际类别占比";

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.String getBddType() {
		return this.__bdd_type;
	}

	public void setBddType( java.lang.String value ) {
		this.__bdd_type = value;
	}

	public java.math.BigDecimal getBddAmount() {
		return this.__bdd_amount;
	}

	public void setBddAmount( java.math.BigDecimal value ) {
		this.__bdd_amount = value;
	}

	public java.lang.String getBddAmountPercent() {
		return this.__bdd_amount_percent;
	}

	public void setBddAmountPercent( java.lang.String value ) {
		this.__bdd_amount_percent = value;
	}

	public java.math.BigDecimal getBudgetContractAmountUse() {
		return this.__budget_contract_amount_use;
	}

	public void setBudgetContractAmountUse( java.math.BigDecimal value ) {
		this.__budget_contract_amount_use = value;
	}

	public java.lang.String getUsePercent() {
		return this.__use_percent;
	}

	public void setUsePercent( java.lang.String value ) {
		this.__use_percent = value;
	}

	public void cloneCopy(BaseBuggetDetailInfo __bean){
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setBddType(getBddType());
		__bean.setBddAmount(getBddAmount());
		__bean.setBddAmountPercent(getBddAmountPercent());
		__bean.setBudgetContractAmountUse(getBudgetContractAmountUse());
		__bean.setUsePercent(getUsePercent());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBudgetManagementId() == null ? "" : getBudgetManagementId());
		sb.append(",");
		sb.append(getBddType() == null ? "" : getBddType());
		sb.append(",");
		sb.append(getBddAmount() == null ? "" : getBddAmount());
		sb.append(",");
		sb.append(getBddAmountPercent() == null ? "" : getBddAmountPercent());
		sb.append(",");
		sb.append(getBudgetContractAmountUse() == null ? "" : getBudgetContractAmountUse());
		sb.append(",");
		sb.append(getUsePercent() == null ? "" : getUsePercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBuggetDetailInfo o) {
		return __budget_management_id == null ? -1 : __budget_management_id.compareTo(o.getBudgetManagementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__bdd_type);
		hash = 97 * hash + Objects.hashCode(this.__bdd_amount);
		hash = 97 * hash + Objects.hashCode(this.__bdd_amount_percent);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount_use);
		hash = 97 * hash + Objects.hashCode(this.__use_percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBuggetDetailInfo o = (BaseBuggetDetailInfo)obj;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__bdd_type, o.getBddType())) return false;
		if(!Objects.equals(this.__bdd_amount, o.getBddAmount())) return false;
		if(!Objects.equals(this.__bdd_amount_percent, o.getBddAmountPercent())) return false;
		if(!Objects.equals(this.__budget_contract_amount_use, o.getBudgetContractAmountUse())) return false;
		if(!Objects.equals(this.__use_percent, o.getUsePercent())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getBddType() != null) sb.append(__wrapString(count++, "bddType", getBddType()));
		if(getBddAmount() != null) sb.append(__wrapDecimal(count++, "bddAmount", getBddAmount()));
		if(getBddAmountPercent() != null) sb.append(__wrapString(count++, "bddAmountPercent", getBddAmountPercent()));
		if(getBudgetContractAmountUse() != null) sb.append(__wrapDecimal(count++, "budgetContractAmountUse", getBudgetContractAmountUse()));
		if(getUsePercent() != null) sb.append(__wrapString(count++, "usePercent", getUsePercent()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("bddType")) != null) setBddType(__getString(val));
		if((val = values.get("bddAmount")) != null) setBddAmount(__getDecimal(val));  
		if((val = values.get("bddAmountPercent")) != null) setBddAmountPercent(__getString(val));
		if((val = values.get("budgetContractAmountUse")) != null) setBudgetContractAmountUse(__getDecimal(val));  
		if((val = values.get("usePercent")) != null) setUsePercent(__getString(val));
	}

	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.String  __bdd_type ;
	protected java.math.BigDecimal  __bdd_amount ;
	protected java.lang.String  __bdd_amount_percent ;
	protected java.math.BigDecimal  __budget_contract_amount_use ;
	protected java.lang.String  __use_percent ;
}
