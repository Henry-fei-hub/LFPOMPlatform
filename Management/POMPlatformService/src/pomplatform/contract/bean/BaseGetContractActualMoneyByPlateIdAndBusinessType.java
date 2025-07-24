package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetContractActualMoneyByPlateIdAndBusinessType extends GenericBase implements BaseFactory<BaseGetContractActualMoneyByPlateIdAndBusinessType>, Comparable<BaseGetContractActualMoneyByPlateIdAndBusinessType> 
{


	public static BaseGetContractActualMoneyByPlateIdAndBusinessType newInstance(){
		return new BaseGetContractActualMoneyByPlateIdAndBusinessType();
	}

	@Override
	public BaseGetContractActualMoneyByPlateIdAndBusinessType make(){
		BaseGetContractActualMoneyByPlateIdAndBusinessType b = new BaseGetContractActualMoneyByPlateIdAndBusinessType();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_ACTUAL_MONEY = "actual_money" ;

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,签约总金额,实际参与分配的金额";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.math.BigDecimal getActualMoney() {
		return this.__actual_money;
	}

	public void setActualMoney( java.math.BigDecimal value ) {
		this.__actual_money = value;
	}

	public void cloneCopy(BaseGetContractActualMoneyByPlateIdAndBusinessType __bean){
		__bean.setContractId(getContractId());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setActualMoney(getActualMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getActualMoney() == null ? "" : getActualMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetContractActualMoneyByPlateIdAndBusinessType o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__actual_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetContractActualMoneyByPlateIdAndBusinessType o = (BaseGetContractActualMoneyByPlateIdAndBusinessType)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__actual_money, o.getActualMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getActualMoney() != null) sb.append(__wrapDecimal(count++, "actualMoney", getActualMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("actualMoney")) != null) setActualMoney(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.math.BigDecimal  __actual_money ;
}
