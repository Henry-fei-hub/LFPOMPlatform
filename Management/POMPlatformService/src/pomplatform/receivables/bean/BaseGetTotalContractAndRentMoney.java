package pomplatform.receivables.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetTotalContractAndRentMoney extends GenericBase implements BaseFactory<BaseGetTotalContractAndRentMoney>, Comparable<BaseGetTotalContractAndRentMoney> 
{


	public static BaseGetTotalContractAndRentMoney newInstance(){
		return new BaseGetTotalContractAndRentMoney();
	}

	@Override
	public BaseGetTotalContractAndRentMoney make(){
		BaseGetTotalContractAndRentMoney b = new BaseGetTotalContractAndRentMoney();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_MONEY = "contract_money" ;
	public final static java.lang.String CS_RENT_MONEY = "rent_money" ;
	public final static java.lang.String CS_SUBSIDY_MONEY = "subsidy_money" ;

	public final static java.lang.String ALL_CAPTIONS = "设计费,房租";

	public java.math.BigDecimal getContractMoney() {
		return this.__contract_money;
	}

	public void setContractMoney( java.math.BigDecimal value ) {
		this.__contract_money = value;
	}

	public java.math.BigDecimal getRentMoney() {
		return this.__rent_money;
	}

	public void setRentMoney( java.math.BigDecimal value ) {
		this.__rent_money = value;
	}
	
	public java.math.BigDecimal getSubsidyMoney() {
		return this.__subsidy_money;
	}

	public void setSubsidyMoney( java.math.BigDecimal value ) {
		this.__subsidy_money = value;
	}

	public void cloneCopy(BaseGetTotalContractAndRentMoney __bean){
		__bean.setContractMoney(getContractMoney());
		__bean.setRentMoney(getRentMoney());
		__bean.setSubsidyMoney(getSubsidyMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractMoney() == null ? "" : getContractMoney());
		sb.append(",");
		sb.append(getRentMoney() == null ? "" : getRentMoney());
		sb.append(",");
		sb.append(getSubsidyMoney() == null ? "" : getSubsidyMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetTotalContractAndRentMoney o) {
		return __contract_money == null ? -1 : __contract_money.compareTo(o.getContractMoney());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_money);
		hash = 97 * hash + Objects.hashCode(this.__rent_money);
		hash = 97 * hash + Objects.hashCode(this.__subsidy_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetTotalContractAndRentMoney o = (BaseGetTotalContractAndRentMoney)obj;
		if(!Objects.equals(this.__contract_money, o.getContractMoney())) return false;
		if(!Objects.equals(this.__rent_money, o.getRentMoney())) return false;
		if(!Objects.equals(this.__subsidy_money, o.getSubsidyMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractMoney() != null) sb.append(__wrapDecimal(count++, "contractMoney", getContractMoney()));
		if(getRentMoney() != null) sb.append(__wrapDecimal(count++, "rentMoney", getRentMoney()));
		if(getSubsidyMoney() != null) sb.append(__wrapDecimal(count++, "subsidyMoney", getSubsidyMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractMoney")) != null) setContractMoney(__getDecimal(val));  
		if((val = values.get("rentMoney")) != null) setRentMoney(__getDecimal(val));  
		if((val = values.get("subsidyMoney")) != null) setSubsidyMoney(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __contract_money ;
	protected java.math.BigDecimal  __rent_money ;
	protected java.math.BigDecimal  __subsidy_money ;
}
