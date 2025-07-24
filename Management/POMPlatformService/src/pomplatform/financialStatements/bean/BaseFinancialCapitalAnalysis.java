package pomplatform.financialStatements.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialCapitalAnalysis extends GenericBase implements BaseFactory<BaseFinancialCapitalAnalysis>, Comparable<BaseFinancialCapitalAnalysis> 
{


	public static BaseFinancialCapitalAnalysis newInstance(){
		return new BaseFinancialCapitalAnalysis();
	}

	@Override
	public BaseFinancialCapitalAnalysis make(){
		BaseFinancialCapitalAnalysis b = new BaseFinancialCapitalAnalysis();
		return b;
	}

	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_INITIAL_BALANCE = "initial_balance" ;
	public final static java.lang.String CS_CONTRACT_MONEY = "contract_money" ;
	public final static java.lang.String CS_RENT_RECEIVABLES = "rent_receivables" ;
	public final static java.lang.String CS_FINANCING_RECEIVABLES = "financing_receivables" ;
	public final static java.lang.String CS_EMPLOYEE_REPAYMENT = "employee_repayment" ;
	public final static java.lang.String CS_PRE_COLLECTION = "pre_collection" ;
	public final static java.lang.String CS_OTHER_RECEIVABLES = "other_receivables" ;
	public final static java.lang.String CS_INTERNAL_COLLECTION = "internal_collection" ;
	public final static java.lang.String CS_SALARY = "salary" ;
	public final static java.lang.String CS_PROJECT_REIMBURSEMENT = "project_reimbursement" ;
	public final static java.lang.String CS_RENT_PAYMENT = "rent_payment" ;
	public final static java.lang.String CS_ASSET_PURCHASE = "asset_purchase" ;
	public final static java.lang.String CS_FINANCING_PAYMENT = "financing_payment" ;
	public final static java.lang.String CS_EMPLOYEE_LOAN = "employee_loan" ;
	public final static java.lang.String CS_PRE_PAYMENT = "pre_payment" ;
	public final static java.lang.String CS_OTHER_PAYMENT = "other_payment" ;
	public final static java.lang.String CS_INTERNAL_PAYMENT = "internal_payment" ;
	public final static java.lang.String CS_CLOSING_BALANCE = "closing_balance" ;

	public final static java.lang.String ALL_CAPTIONS = ",,期初余额,合同款,房租框,融资收款,员工还款,预收款,,内部收款,薪酬,项目报销,房租物业付款,资产采购,融资付款,员工借款,,,,期末余额";

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.math.BigDecimal getInitialBalance() {
		return this.__initial_balance;
	}

	public void setInitialBalance( java.math.BigDecimal value ) {
		this.__initial_balance = value;
	}

	public java.math.BigDecimal getContractMoney() {
		return this.__contract_money;
	}

	public void setContractMoney( java.math.BigDecimal value ) {
		this.__contract_money = value;
	}

	public java.math.BigDecimal getRentReceivables() {
		return this.__rent_receivables;
	}

	public void setRentReceivables( java.math.BigDecimal value ) {
		this.__rent_receivables = value;
	}

	public java.math.BigDecimal getFinancingReceivables() {
		return this.__financing_receivables;
	}

	public void setFinancingReceivables( java.math.BigDecimal value ) {
		this.__financing_receivables = value;
	}

	public java.math.BigDecimal getEmployeeRepayment() {
		return this.__employee_repayment;
	}

	public void setEmployeeRepayment( java.math.BigDecimal value ) {
		this.__employee_repayment = value;
	}

	public java.math.BigDecimal getPreCollection() {
		return this.__pre_collection;
	}

	public void setPreCollection( java.math.BigDecimal value ) {
		this.__pre_collection = value;
	}

	public java.math.BigDecimal getOtherReceivables() {
		return this.__other_receivables;
	}

	public void setOtherReceivables( java.math.BigDecimal value ) {
		this.__other_receivables = value;
	}

	public java.math.BigDecimal getInternalCollection() {
		return this.__internal_collection;
	}

	public void setInternalCollection( java.math.BigDecimal value ) {
		this.__internal_collection = value;
	}

	public java.math.BigDecimal getSalary() {
		return this.__salary;
	}

	public void setSalary( java.math.BigDecimal value ) {
		this.__salary = value;
	}

	public java.math.BigDecimal getProjectReimbursement() {
		return this.__project_reimbursement;
	}

	public void setProjectReimbursement( java.math.BigDecimal value ) {
		this.__project_reimbursement = value;
	}

	public java.math.BigDecimal getRentPayment() {
		return this.__rent_payment;
	}

	public void setRentPayment( java.math.BigDecimal value ) {
		this.__rent_payment = value;
	}

	public java.math.BigDecimal getAssetPurchase() {
		return this.__asset_purchase;
	}

	public void setAssetPurchase( java.math.BigDecimal value ) {
		this.__asset_purchase = value;
	}

	public java.math.BigDecimal getFinancingPayment() {
		return this.__financing_payment;
	}

	public void setFinancingPayment( java.math.BigDecimal value ) {
		this.__financing_payment = value;
	}

	public java.math.BigDecimal getEmployeeLoan() {
		return this.__employee_loan;
	}

	public void setEmployeeLoan( java.math.BigDecimal value ) {
		this.__employee_loan = value;
	}

	public java.math.BigDecimal getPrePayment() {
		return this.__pre_payment;
	}

	public void setPrePayment( java.math.BigDecimal value ) {
		this.__pre_payment = value;
	}

	public java.math.BigDecimal getOtherPayment() {
		return this.__other_payment;
	}

	public void setOtherPayment( java.math.BigDecimal value ) {
		this.__other_payment = value;
	}

	public java.math.BigDecimal getInternalPayment() {
		return this.__internal_payment;
	}

	public void setInternalPayment( java.math.BigDecimal value ) {
		this.__internal_payment = value;
	}

	public java.math.BigDecimal getClosingBalance() {
		return this.__closing_balance;
	}

	public void setClosingBalance( java.math.BigDecimal value ) {
		this.__closing_balance = value;
	}

	public void cloneCopy(BaseFinancialCapitalAnalysis __bean){
		__bean.setCompanyId(getCompanyId());
		__bean.setBankAccount(getBankAccount());
		__bean.setInitialBalance(getInitialBalance());
		__bean.setContractMoney(getContractMoney());
		__bean.setRentReceivables(getRentReceivables());
		__bean.setFinancingReceivables(getFinancingReceivables());
		__bean.setEmployeeRepayment(getEmployeeRepayment());
		__bean.setPreCollection(getPreCollection());
		__bean.setOtherReceivables(getOtherReceivables());
		__bean.setInternalCollection(getInternalCollection());
		__bean.setSalary(getSalary());
		__bean.setProjectReimbursement(getProjectReimbursement());
		__bean.setRentPayment(getRentPayment());
		__bean.setAssetPurchase(getAssetPurchase());
		__bean.setFinancingPayment(getFinancingPayment());
		__bean.setEmployeeLoan(getEmployeeLoan());
		__bean.setPrePayment(getPrePayment());
		__bean.setOtherPayment(getOtherPayment());
		__bean.setInternalPayment(getInternalPayment());
		__bean.setClosingBalance(getClosingBalance());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getInitialBalance() == null ? "" : getInitialBalance());
		sb.append(",");
		sb.append(getContractMoney() == null ? "" : getContractMoney());
		sb.append(",");
		sb.append(getRentReceivables() == null ? "" : getRentReceivables());
		sb.append(",");
		sb.append(getFinancingReceivables() == null ? "" : getFinancingReceivables());
		sb.append(",");
		sb.append(getEmployeeRepayment() == null ? "" : getEmployeeRepayment());
		sb.append(",");
		sb.append(getPreCollection() == null ? "" : getPreCollection());
		sb.append(",");
		sb.append(getOtherReceivables() == null ? "" : getOtherReceivables());
		sb.append(",");
		sb.append(getInternalCollection() == null ? "" : getInternalCollection());
		sb.append(",");
		sb.append(getSalary() == null ? "" : getSalary());
		sb.append(",");
		sb.append(getProjectReimbursement() == null ? "" : getProjectReimbursement());
		sb.append(",");
		sb.append(getRentPayment() == null ? "" : getRentPayment());
		sb.append(",");
		sb.append(getAssetPurchase() == null ? "" : getAssetPurchase());
		sb.append(",");
		sb.append(getFinancingPayment() == null ? "" : getFinancingPayment());
		sb.append(",");
		sb.append(getEmployeeLoan() == null ? "" : getEmployeeLoan());
		sb.append(",");
		sb.append(getPrePayment() == null ? "" : getPrePayment());
		sb.append(",");
		sb.append(getOtherPayment() == null ? "" : getOtherPayment());
		sb.append(",");
		sb.append(getInternalPayment() == null ? "" : getInternalPayment());
		sb.append(",");
		sb.append(getClosingBalance() == null ? "" : getClosingBalance());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialCapitalAnalysis o) {
		return __company_id == null ? -1 : __company_id.compareTo(o.getCompanyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__initial_balance);
		hash = 97 * hash + Objects.hashCode(this.__contract_money);
		hash = 97 * hash + Objects.hashCode(this.__rent_receivables);
		hash = 97 * hash + Objects.hashCode(this.__financing_receivables);
		hash = 97 * hash + Objects.hashCode(this.__employee_repayment);
		hash = 97 * hash + Objects.hashCode(this.__pre_collection);
		hash = 97 * hash + Objects.hashCode(this.__other_receivables);
		hash = 97 * hash + Objects.hashCode(this.__internal_collection);
		hash = 97 * hash + Objects.hashCode(this.__salary);
		hash = 97 * hash + Objects.hashCode(this.__project_reimbursement);
		hash = 97 * hash + Objects.hashCode(this.__rent_payment);
		hash = 97 * hash + Objects.hashCode(this.__asset_purchase);
		hash = 97 * hash + Objects.hashCode(this.__financing_payment);
		hash = 97 * hash + Objects.hashCode(this.__employee_loan);
		hash = 97 * hash + Objects.hashCode(this.__pre_payment);
		hash = 97 * hash + Objects.hashCode(this.__other_payment);
		hash = 97 * hash + Objects.hashCode(this.__internal_payment);
		hash = 97 * hash + Objects.hashCode(this.__closing_balance);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialCapitalAnalysis o = (BaseFinancialCapitalAnalysis)obj;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__initial_balance, o.getInitialBalance())) return false;
		if(!Objects.equals(this.__contract_money, o.getContractMoney())) return false;
		if(!Objects.equals(this.__rent_receivables, o.getRentReceivables())) return false;
		if(!Objects.equals(this.__financing_receivables, o.getFinancingReceivables())) return false;
		if(!Objects.equals(this.__employee_repayment, o.getEmployeeRepayment())) return false;
		if(!Objects.equals(this.__pre_collection, o.getPreCollection())) return false;
		if(!Objects.equals(this.__other_receivables, o.getOtherReceivables())) return false;
		if(!Objects.equals(this.__internal_collection, o.getInternalCollection())) return false;
		if(!Objects.equals(this.__salary, o.getSalary())) return false;
		if(!Objects.equals(this.__project_reimbursement, o.getProjectReimbursement())) return false;
		if(!Objects.equals(this.__rent_payment, o.getRentPayment())) return false;
		if(!Objects.equals(this.__asset_purchase, o.getAssetPurchase())) return false;
		if(!Objects.equals(this.__financing_payment, o.getFinancingPayment())) return false;
		if(!Objects.equals(this.__employee_loan, o.getEmployeeLoan())) return false;
		if(!Objects.equals(this.__pre_payment, o.getPrePayment())) return false;
		if(!Objects.equals(this.__other_payment, o.getOtherPayment())) return false;
		if(!Objects.equals(this.__internal_payment, o.getInternalPayment())) return false;
		if(!Objects.equals(this.__closing_balance, o.getClosingBalance())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getInitialBalance() != null) sb.append(__wrapDecimal(count++, "initialBalance", getInitialBalance()));
		if(getContractMoney() != null) sb.append(__wrapDecimal(count++, "contractMoney", getContractMoney()));
		if(getRentReceivables() != null) sb.append(__wrapDecimal(count++, "rentReceivables", getRentReceivables()));
		if(getFinancingReceivables() != null) sb.append(__wrapDecimal(count++, "financingReceivables", getFinancingReceivables()));
		if(getEmployeeRepayment() != null) sb.append(__wrapDecimal(count++, "employeeRepayment", getEmployeeRepayment()));
		if(getPreCollection() != null) sb.append(__wrapDecimal(count++, "preCollection", getPreCollection()));
		if(getOtherReceivables() != null) sb.append(__wrapDecimal(count++, "otherReceivables", getOtherReceivables()));
		if(getInternalCollection() != null) sb.append(__wrapDecimal(count++, "internalCollection", getInternalCollection()));
		if(getSalary() != null) sb.append(__wrapDecimal(count++, "salary", getSalary()));
		if(getProjectReimbursement() != null) sb.append(__wrapDecimal(count++, "projectReimbursement", getProjectReimbursement()));
		if(getRentPayment() != null) sb.append(__wrapDecimal(count++, "rentPayment", getRentPayment()));
		if(getAssetPurchase() != null) sb.append(__wrapDecimal(count++, "assetPurchase", getAssetPurchase()));
		if(getFinancingPayment() != null) sb.append(__wrapDecimal(count++, "financingPayment", getFinancingPayment()));
		if(getEmployeeLoan() != null) sb.append(__wrapDecimal(count++, "employeeLoan", getEmployeeLoan()));
		if(getPrePayment() != null) sb.append(__wrapDecimal(count++, "prePayment", getPrePayment()));
		if(getOtherPayment() != null) sb.append(__wrapDecimal(count++, "otherPayment", getOtherPayment()));
		if(getInternalPayment() != null) sb.append(__wrapDecimal(count++, "internalPayment", getInternalPayment()));
		if(getClosingBalance() != null) sb.append(__wrapDecimal(count++, "closingBalance", getClosingBalance()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("initialBalance")) != null) setInitialBalance(__getDecimal(val));  
		if((val = values.get("contractMoney")) != null) setContractMoney(__getDecimal(val));  
		if((val = values.get("rentReceivables")) != null) setRentReceivables(__getDecimal(val));  
		if((val = values.get("financingReceivables")) != null) setFinancingReceivables(__getDecimal(val));  
		if((val = values.get("employeeRepayment")) != null) setEmployeeRepayment(__getDecimal(val));  
		if((val = values.get("preCollection")) != null) setPreCollection(__getDecimal(val));  
		if((val = values.get("otherReceivables")) != null) setOtherReceivables(__getDecimal(val));  
		if((val = values.get("internalCollection")) != null) setInternalCollection(__getDecimal(val));  
		if((val = values.get("salary")) != null) setSalary(__getDecimal(val));  
		if((val = values.get("projectReimbursement")) != null) setProjectReimbursement(__getDecimal(val));  
		if((val = values.get("rentPayment")) != null) setRentPayment(__getDecimal(val));  
		if((val = values.get("assetPurchase")) != null) setAssetPurchase(__getDecimal(val));  
		if((val = values.get("financingPayment")) != null) setFinancingPayment(__getDecimal(val));  
		if((val = values.get("employeeLoan")) != null) setEmployeeLoan(__getDecimal(val));  
		if((val = values.get("prePayment")) != null) setPrePayment(__getDecimal(val));  
		if((val = values.get("otherPayment")) != null) setOtherPayment(__getDecimal(val));  
		if((val = values.get("internalPayment")) != null) setInternalPayment(__getDecimal(val));  
		if((val = values.get("closingBalance")) != null) setClosingBalance(__getDecimal(val));  
	}

	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __bank_account ;
	protected java.math.BigDecimal  __initial_balance ;
	protected java.math.BigDecimal  __contract_money ;
	protected java.math.BigDecimal  __rent_receivables ;
	protected java.math.BigDecimal  __financing_receivables ;
	protected java.math.BigDecimal  __employee_repayment ;
	protected java.math.BigDecimal  __pre_collection ;
	protected java.math.BigDecimal  __other_receivables ;
	protected java.math.BigDecimal  __internal_collection ;
	protected java.math.BigDecimal  __salary ;
	protected java.math.BigDecimal  __project_reimbursement ;
	protected java.math.BigDecimal  __rent_payment ;
	protected java.math.BigDecimal  __asset_purchase ;
	protected java.math.BigDecimal  __financing_payment ;
	protected java.math.BigDecimal  __employee_loan ;
	protected java.math.BigDecimal  __pre_payment ;
	protected java.math.BigDecimal  __other_payment ;
	protected java.math.BigDecimal  __internal_payment ;
	protected java.math.BigDecimal  __closing_balance ;
}
