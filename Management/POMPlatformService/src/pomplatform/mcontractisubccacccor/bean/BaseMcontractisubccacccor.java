package pomplatform.mcontractisubccacccor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcontractisubccacccor extends GenericBase implements BaseFactory<BaseMcontractisubccacccor>, Comparable<BaseMcontractisubccacccor> 
{


	public static BaseMcontractisubccacccor newInstance(){
		return new BaseMcontractisubccacccor();
	}

	@Override
	public BaseMcontractisubccacccor make(){
		BaseMcontractisubccacccor b = new BaseMcontractisubccacccor();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_UN_RECIVE_MONEY = "un_recive_money" ;
	public final static java.lang.String CS_UN_RECIVE_CONTRACT_MONEY = "un_recive_contract_money" ;

	public final static java.lang.String ALL_CAPTIONS = "合同编码,合同编号,合同名称,签约总金额,客户名称,已开发票金额,已收款金额,已开发票未收款金额,合同未收款金额";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.math.BigDecimal getUnReciveMoney() {
		return this.__un_recive_money;
	}

	public void setUnReciveMoney( java.math.BigDecimal value ) {
		this.__un_recive_money = value;
	}

	public java.math.BigDecimal getUnReciveContractMoney() {
		return this.__un_recive_contract_money;
	}

	public void setUnReciveContractMoney( java.math.BigDecimal value ) {
		this.__un_recive_contract_money = value;
	}

	public void cloneCopy(BaseMcontractisubccacccor __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setCustomerName(getCustomerName());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setUnReciveMoney(getUnReciveMoney());
		__bean.setUnReciveContractMoney(getUnReciveContractMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getUnReciveMoney() == null ? "" : getUnReciveMoney());
		sb.append(",");
		sb.append(getUnReciveContractMoney() == null ? "" : getUnReciveContractMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcontractisubccacccor o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__un_recive_money);
		hash = 97 * hash + Objects.hashCode(this.__un_recive_contract_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcontractisubccacccor o = (BaseMcontractisubccacccor)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__un_recive_money, o.getUnReciveMoney())) return false;
		if(!Objects.equals(this.__un_recive_contract_money, o.getUnReciveContractMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getUnReciveMoney() != null) sb.append(__wrapDecimal(count++, "unReciveMoney", getUnReciveMoney()));
		if(getUnReciveContractMoney() != null) sb.append(__wrapDecimal(count++, "unReciveContractMoney", getUnReciveContractMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("unReciveMoney")) != null) setUnReciveMoney(__getDecimal(val));  
		if((val = values.get("unReciveContractMoney")) != null) setUnReciveContractMoney(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.String  __customer_name ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.math.BigDecimal  __un_recive_money ;
	protected java.math.BigDecimal  __un_recive_contract_money ;
}
