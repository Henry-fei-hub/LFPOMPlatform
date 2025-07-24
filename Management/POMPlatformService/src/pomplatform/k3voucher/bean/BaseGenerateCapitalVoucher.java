package pomplatform.k3voucher.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGenerateCapitalVoucher extends GenericBase implements BaseFactory<BaseGenerateCapitalVoucher>, Comparable<BaseGenerateCapitalVoucher> 
{


	public static BaseGenerateCapitalVoucher newInstance(){
		return new BaseGenerateCapitalVoucher();
	}

	@Override
	public BaseGenerateCapitalVoucher make(){
		BaseGenerateCapitalVoucher b = new BaseGenerateCapitalVoucher();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_MONEY_ATTRIBUTE = "money_attribute" ;
	public final static java.lang.String CS_HAVE_VOUCHER = "have_voucher" ;
	public final static java.lang.String CS_SELF_BANK_NAME = "self_bank_name" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_OTHER_NAME = "other_name" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_LOAN_MONEY = "loan_money" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_ORIGINAL_CURRENCY = "original_currency" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "资金表id,款项属性,是否有凭证,银行名称(收款方),银行账号(收款方),对方名称(付款方),借（增加）,贷（减少）,汇率,原币金额,合同编号,发生日期,登记日期,登记人,备注";

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.lang.Boolean getHaveVoucher() {
		return this.__have_voucher;
	}

	public void setHaveVoucher( java.lang.Boolean value ) {
		this.__have_voucher = value;
	}

	public java.lang.String getSelfBankName() {
		return this.__self_bank_name;
	}

	public void setSelfBankName( java.lang.String value ) {
		this.__self_bank_name = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account;
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.lang.String getOtherName() {
		return this.__other_name;
	}

	public void setOtherName( java.lang.String value ) {
		this.__other_name = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.math.BigDecimal getLoanMoney() {
		return this.__loan_money;
	}

	public void setLoanMoney( java.math.BigDecimal value ) {
		this.__loan_money = value;
	}

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
	}

	public java.math.BigDecimal getOriginalCurrency() {
		return this.__original_currency;
	}

	public void setOriginalCurrency( java.math.BigDecimal value ) {
		this.__original_currency = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseGenerateCapitalVoucher __bean){
		__bean.setCapitalId(getCapitalId());
		__bean.setMoneyAttribute(getMoneyAttribute());
		__bean.setHaveVoucher(getHaveVoucher());
		__bean.setSelfBankName(getSelfBankName());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setOtherName(getOtherName());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setLoanMoney(getLoanMoney());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setOriginalCurrency(getOriginalCurrency());
		__bean.setContractCode(getContractCode());
		__bean.setHappenDate(getHappenDate());
		__bean.setCreateDate(getCreateDate());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getMoneyAttribute() == null ? "" : getMoneyAttribute());
		sb.append(",");
		sb.append(getHaveVoucher() == null ? "" : getHaveVoucher());
		sb.append(",");
		sb.append(getSelfBankName() == null ? "" : getSelfBankName());
		sb.append(",");
		sb.append(getSelfBankAccount() == null ? "" : getSelfBankAccount());
		sb.append(",");
		sb.append(getOtherName() == null ? "" : getOtherName());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getLoanMoney() == null ? "" : getLoanMoney());
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		sb.append(getOriginalCurrency() == null ? "" : getOriginalCurrency());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGenerateCapitalVoucher o) {
		return __capital_id == null ? -1 : __capital_id.compareTo(o.getCapitalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__money_attribute);
		hash = 97 * hash + Objects.hashCode(this.__have_voucher);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_name);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__other_name);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__loan_money);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__original_currency);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGenerateCapitalVoucher o = (BaseGenerateCapitalVoucher)obj;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__money_attribute, o.getMoneyAttribute())) return false;
		if(!Objects.equals(this.__have_voucher, o.getHaveVoucher())) return false;
		if(!Objects.equals(this.__self_bank_name, o.getSelfBankName())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__other_name, o.getOtherName())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__loan_money, o.getLoanMoney())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__original_currency, o.getOriginalCurrency())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(count++, "moneyAttribute", getMoneyAttribute()));
		if(getHaveVoucher() != null) sb.append(__wrapBoolean(count++, "haveVoucher", getHaveVoucher()));
		if(getSelfBankName() != null) sb.append(__wrapString(count++, "selfBankName", getSelfBankName()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getOtherName() != null) sb.append(__wrapString(count++, "otherName", getOtherName()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getLoanMoney() != null) sb.append(__wrapDecimal(count++, "loanMoney", getLoanMoney()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getOriginalCurrency() != null) sb.append(__wrapDecimal(count++, "originalCurrency", getOriginalCurrency()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("haveVoucher")) != null) setHaveVoucher(__getBoolean(val));
		if((val = values.get("selfBankName")) != null) setSelfBankName(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("otherName")) != null) setOtherName(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("loanMoney")) != null) setLoanMoney(__getDecimal(val));  
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("originalCurrency")) != null) setOriginalCurrency(__getDecimal(val));  
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __money_attribute ;
	protected java.lang.Boolean  __have_voucher ;
	protected java.lang.String  __self_bank_name ;
	protected java.lang.String  __self_bank_account ;
	protected java.lang.String  __other_name ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.math.BigDecimal  __loan_money ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.math.BigDecimal  __original_currency ;
	protected java.lang.String  __contract_code ;
	protected java.util.Date  __happen_date ;
	protected java.util.Date  __create_date ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __remark ;
}
