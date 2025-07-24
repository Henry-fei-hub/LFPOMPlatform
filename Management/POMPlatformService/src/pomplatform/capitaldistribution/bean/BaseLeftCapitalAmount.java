package pomplatform.capitaldistribution.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseLeftCapitalAmount extends GenericBase implements BaseFactory<BaseLeftCapitalAmount>, Comparable<BaseLeftCapitalAmount> 
{


	public static BaseLeftCapitalAmount newInstance(){
		return new BaseLeftCapitalAmount();
	}

	@Override
	public BaseLeftCapitalAmount make(){
		BaseLeftCapitalAmount b = new BaseLeftCapitalAmount();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;

	public final static java.lang.String ALL_CAPTIONS = "资金表id,合同id,回款金额";

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.util.Date getHappenDate() {
		return __happen_date;
	}

	public void setHappenDate(java.util.Date __happen_date) {
		this.__happen_date = __happen_date;
	}

	public java.lang.String getRemark() {
		return __remark;
	}

	public void setRemark(java.lang.String __remark) {
		this.__remark = __remark;
	}

	public java.math.BigDecimal getLeftAmount() {
		return __left_amount;
	}

	public void setLeftAmount(java.math.BigDecimal __left_amount) {
		this.__left_amount = __left_amount;
	}

	public void cloneCopy(BaseLeftCapitalAmount __bean){
		__bean.setCapitalId(getCapitalId());
		__bean.setContractId(getContractId());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setHappenDate(getHappenDate());
		__bean.setRemark(getRemark());
		__bean.setLeftAmount(getLeftAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseLeftCapitalAmount o) {
		return __capital_id == null ? -1 : __capital_id.compareTo(o.getCapitalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__left_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseLeftCapitalAmount o = (BaseLeftCapitalAmount)obj;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__left_amount, o.getLeftAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getLeftAmount() != null) sb.append(__wrapDecimal(count++, "leftAmount", getLeftAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));  
		if((val = values.get("leftAmount")) != null) setLeftAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.util.Date __happen_date;
	protected java.lang.String __remark;
	protected java.math.BigDecimal  __left_amount ;
}
