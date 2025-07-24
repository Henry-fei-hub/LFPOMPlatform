package pomplatform.receivables.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcapitalhyhor extends GenericBase implements BaseFactory<BaseMcapitalhyhor>, Comparable<BaseMcapitalhyhor> 
{


	public static BaseMcapitalhyhor newInstance(){
		return new BaseMcapitalhyhor();
	}

	@Override
	public BaseMcapitalhyhor make(){
		BaseMcapitalhyhor b = new BaseMcapitalhyhor();
		return b;
	}

	public final static java.lang.String CS_YEAR_CONTRACT_MONEY = "year_contract_money" ;
	public final static java.lang.String CS_YEAR_RENT_MONEY = "year_rent_money" ;
	public final static java.lang.String CS_YEAR_SUBSIDY_MONEY = "year_subsidy_money" ;

	public final static java.lang.String ALL_CAPTIONS = ",,";

	public java.math.BigDecimal getYearContractMoney() {
		return this.__year_contract_money;
	}

	public void setYearContractMoney( java.math.BigDecimal value ) {
		this.__year_contract_money = value;
	}

	public java.math.BigDecimal getYearRentMoney() {
		return this.__year_rent_money;
	}

	public void setYearRentMoney( java.math.BigDecimal value ) {
		this.__year_rent_money = value;
	}

	public java.math.BigDecimal getYearSubsidyMoney() {
		return this.__year_subsidy_money;
	}

	public void setYearSubsidyMoney( java.math.BigDecimal value ) {
		this.__year_subsidy_money = value;
	}

	public void cloneCopy(BaseMcapitalhyhor __bean){
		__bean.setYearContractMoney(getYearContractMoney());
		__bean.setYearRentMoney(getYearRentMoney());
		__bean.setYearSubsidyMoney(getYearSubsidyMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getYearContractMoney() == null ? "" : getYearContractMoney());
		sb.append(",");
		sb.append(getYearRentMoney() == null ? "" : getYearRentMoney());
		sb.append(",");
		sb.append(getYearSubsidyMoney() == null ? "" : getYearSubsidyMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcapitalhyhor o) {
		return __year_contract_money == null ? -1 : __year_contract_money.compareTo(o.getYearContractMoney());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__year_contract_money);
		hash = 97 * hash + Objects.hashCode(this.__year_rent_money);
		hash = 97 * hash + Objects.hashCode(this.__year_subsidy_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcapitalhyhor o = (BaseMcapitalhyhor)obj;
		if(!Objects.equals(this.__year_contract_money, o.getYearContractMoney())) return false;
		if(!Objects.equals(this.__year_rent_money, o.getYearRentMoney())) return false;
		if(!Objects.equals(this.__year_subsidy_money, o.getYearSubsidyMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getYearContractMoney() != null) sb.append(__wrapDecimal(count++, "yearContractMoney", getYearContractMoney()));
		if(getYearRentMoney() != null) sb.append(__wrapDecimal(count++, "yearRentMoney", getYearRentMoney()));
		if(getYearSubsidyMoney() != null) sb.append(__wrapDecimal(count++, "yearSubsidyMoney", getYearSubsidyMoney()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getYearContractMoney() != null) res.put("yearContractMoney", getYearContractMoney());
		if(getYearRentMoney() != null) res.put("yearRentMoney", getYearRentMoney());
		if(getYearSubsidyMoney() != null) res.put("yearSubsidyMoney", getYearSubsidyMoney());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("yearContractMoney")) != null) setYearContractMoney(__getDecimal(val));  
		if((val = values.get("yearRentMoney")) != null) setYearRentMoney(__getDecimal(val));  
		if((val = values.get("yearSubsidyMoney")) != null) setYearSubsidyMoney(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __year_contract_money ;
	protected java.math.BigDecimal  __year_rent_money ;
	protected java.math.BigDecimal  __year_subsidy_money ;
}
