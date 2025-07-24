package pomplatform.receivables.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;

public class BaseMinvoicecseccor extends GenericBase implements BaseFactory<BaseMinvoicecseccor>, Comparable<BaseMinvoicecseccor> 
{


	public static BaseMinvoicecseccor newInstance(){
		return new BaseMinvoicecseccor();
	}

	@Override
	public BaseMinvoicecseccor make(){
		BaseMinvoicecseccor b = new BaseMinvoicecseccor();
		return b;
	}

	public final static java.lang.String CS_INVOICE_ID = "invoice_id" ;
	public final static java.lang.String CS_TICKETING_COMPANY = "ticketing_company" ;
	public final static java.lang.String CS_INVOICE_TYPE = "invoice_type" ;
	public final static java.lang.String CS_INVOICE_CODE = "invoice_code" ;
	public final static java.lang.String CS_INVOICE_NUMBER = "invoice_number" ;
	public final static java.lang.String CS_IN_STOCK_DATE = "in_stock_date" ;
	public final static java.lang.String CS_INVALID_REMARK = "invalid_remark" ;
	public final static java.lang.String CS_IS_INVALID_OPERATOR = "is_invalid_operator" ;
	public final static java.lang.String CS_STORAGE_OPERATOR = "storage_operator" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_BILLING_OPERATION = "billing_operation" ;
	public final static java.lang.String CS_INVOICE_DATE = "invoice_date" ;
	public final static java.lang.String CS_REGISTRATION_DATE = "registration_date" ;
	public final static java.lang.String CS_SIGN = "sign" ;
	public final static java.lang.String CS_CONTRACT_RECEIVABLE_ID = "contract_receivable_id" ;
	public final static java.lang.String CS_ACKNOWLEDGE_LETTER_ID = "acknowledge_letter_id" ;
	public final static java.lang.String CS_HAVE_VOUCHER = "have_voucher" ;
	public final static java.lang.String CS_IS_CAPITAL = "is_capital" ;
	public final static java.lang.String CS_CAPITAL_AMOUNT = "capital_amount" ;
	public final static java.lang.String CS_PROJECT_MANAGER_ID = "project_manager_id" ;

	public final static java.lang.String ALL_CAPTIONS = "开发票 编码,购票公司,发票类型 1专票，2普票 ，3代开,发票代码(10位 每次批量录入是一样),发票号码(8位 规则+1),发票入库日期,发票空白作废备注,发票空白作废操作人,发票入库操作人,信息编号,项目编号,合同id,合同编号,主订单名称,签约总金额,客户名称,开票金额(如 100),开票操作人,开票日期,开发票的登记日期,3填开作废。当月发票，当月作废。4.负数作废。做了红字，然后又作废。5.空白作废。尚未开具，就直接作废（往往是不慎污染弄脏了，没法使用）,收款阶段id,确认函id,是否有凭证,是否对应回款,回款金额,项目经理编码";
	public final static java.lang.String DW_CAPTIONS = "发票号码,开票时间,合同编号,合同名称,合同金额,客户名称,开票金额,已回款金额,未回款金额,是否逾期,项目经理";

	public java.lang.Integer getInvoiceId() {
		return this.__invoice_id;
	}

	public void setInvoiceId( java.lang.Integer value ) {
		this.__invoice_id = value;
	}

	public java.lang.Integer getTicketingCompany() {
		return this.__ticketing_company;
	}

	public void setTicketingCompany( java.lang.Integer value ) {
		this.__ticketing_company = value;
	}

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
	}

	public java.lang.String getInvoiceCode() {
		return this.__invoice_code;
	}

	public void setInvoiceCode( java.lang.String value ) {
		this.__invoice_code = value;
	}

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number;
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.util.Date getInStockDate() {
		return this.__in_stock_date;
	}

	public void setInStockDate( java.util.Date value ) {
		this.__in_stock_date = value;
	}

	public java.lang.String getInvalidRemark() {
		return this.__invalid_remark;
	}

	public void setInvalidRemark( java.lang.String value ) {
		this.__invalid_remark = value;
	}

	public java.lang.Integer getIsInvalidOperator() {
		return this.__is_invalid_operator;
	}

	public void setIsInvalidOperator( java.lang.Integer value ) {
		this.__is_invalid_operator = value;
	}

	public java.lang.Integer getStorageOperator() {
		return this.__storage_operator;
	}

	public void setStorageOperator( java.lang.Integer value ) {
		this.__storage_operator = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

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

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.lang.Integer getBillingOperation() {
		return this.__billing_operation;
	}

	public void setBillingOperation( java.lang.Integer value ) {
		this.__billing_operation = value;
	}

	public java.util.Date getInvoiceDate() {
		return this.__invoice_date;
	}

	public void setInvoiceDate( java.util.Date value ) {
		this.__invoice_date = value;
	}

	public java.util.Date getRegistrationDate() {
		return this.__registration_date;
	}

	public void setRegistrationDate( java.util.Date value ) {
		this.__registration_date = value;
	}

	public java.lang.Integer getSign() {
		return this.__sign;
	}

	public void setSign( java.lang.Integer value ) {
		this.__sign = value;
	}

	public java.lang.Integer getContractReceivableId() {
		return this.__contract_receivable_id;
	}

	public void setContractReceivableId( java.lang.Integer value ) {
		this.__contract_receivable_id = value;
	}

	public java.lang.Integer getAcknowledgeLetterId() {
		return this.__acknowledge_letter_id;
	}

	public void setAcknowledgeLetterId( java.lang.Integer value ) {
		this.__acknowledge_letter_id = value;
	}

	public java.lang.Boolean getHaveVoucher() {
		return this.__have_voucher;
	}

	public void setHaveVoucher( java.lang.Boolean value ) {
		this.__have_voucher = value;
	}

	public java.lang.Integer getIsCapital() {
		return this.__is_capital;
	}

	public void setIsCapital( java.lang.Integer value ) {
		this.__is_capital = value;
	}

	public java.math.BigDecimal getCapitalAmount() {
		return this.__capital_amount;
	}

	public void setCapitalAmount( java.math.BigDecimal value ) {
		this.__capital_amount = value;
	}

	public java.lang.Integer getProjectManagerId() {
		return this.__project_manager_id;
	}

	public void setProjectManagerId( java.lang.Integer value ) {
		this.__project_manager_id = value;
	}
	

	public java.math.BigDecimal getArrears() {
		return __arrears;
	}

	public void setArrears(java.math.BigDecimal __arrears) {
		this.__arrears = __arrears;
	}

	public java.lang.Integer getOverduePayment() {
		return __overdue_payment;
	}

	public void setOverduePayment(java.lang.Integer __overdue_payment) {
		this.__overdue_payment = __overdue_payment;
	}

	public void cloneCopy(BaseMinvoicecseccor __bean){
		__bean.setInvoiceId(getInvoiceId());
		__bean.setTicketingCompany(getTicketingCompany());
		__bean.setInvoiceType(getInvoiceType());
		__bean.setInvoiceCode(getInvoiceCode());
		__bean.setInvoiceNumber(getInvoiceNumber());
		__bean.setInStockDate(getInStockDate());
		__bean.setInvalidRemark(getInvalidRemark());
		__bean.setIsInvalidOperator(getIsInvalidOperator());
		__bean.setStorageOperator(getStorageOperator());
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setCustomerId(getCustomerId());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setBillingOperation(getBillingOperation());
		__bean.setInvoiceDate(getInvoiceDate());
		__bean.setRegistrationDate(getRegistrationDate());
		__bean.setSign(getSign());
		__bean.setContractReceivableId(getContractReceivableId());
		__bean.setAcknowledgeLetterId(getAcknowledgeLetterId());
		__bean.setHaveVoucher(getHaveVoucher());
		__bean.setIsCapital(getIsCapital());
		__bean.setCapitalAmount(getCapitalAmount());
		__bean.setProjectManagerId(getProjectManagerId());
		__bean.setOverduePayment(getOverduePayment());
		__bean.setArrears(getArrears());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInvoiceNumber() == null ? "" : getInvoiceNumber());
		sb.append(",");
		sb.append(getInvoiceDate() == null ? "" : sdf.format(getInvoiceDate()));
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		String customer = SelectValueCache.getSelectValue("customers", BaseHelpUtils.getString(getCustomerId()));
		sb.append(customer == null ? "" : customer);
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getCapitalAmount() == null ? "" : getCapitalAmount());
		sb.append(",");
		sb.append(getArrears() == null ? "" : getArrears());
		sb.append(",");
		if(getOverduePayment() != null) {
			if(getOverduePayment()==0) {
				sb.append("否");
			}else if(getOverduePayment()==1) {
				sb.append("是");
			}
		}
		sb.append(",");
		sb.append(getProjectManagerId() == null ? "" : delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManagerId())));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMinvoicecseccor o) {
		return __invoice_id == null ? -1 : __invoice_id.compareTo(o.getInvoiceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__invoice_id);
		hash = 97 * hash + Objects.hashCode(this.__ticketing_company);
		hash = 97 * hash + Objects.hashCode(this.__invoice_type);
		hash = 97 * hash + Objects.hashCode(this.__invoice_code);
		hash = 97 * hash + Objects.hashCode(this.__invoice_number);
		hash = 97 * hash + Objects.hashCode(this.__in_stock_date);
		hash = 97 * hash + Objects.hashCode(this.__invalid_remark);
		hash = 97 * hash + Objects.hashCode(this.__is_invalid_operator);
		hash = 97 * hash + Objects.hashCode(this.__storage_operator);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__billing_operation);
		hash = 97 * hash + Objects.hashCode(this.__invoice_date);
		hash = 97 * hash + Objects.hashCode(this.__registration_date);
		hash = 97 * hash + Objects.hashCode(this.__sign);
		hash = 97 * hash + Objects.hashCode(this.__contract_receivable_id);
		hash = 97 * hash + Objects.hashCode(this.__acknowledge_letter_id);
		hash = 97 * hash + Objects.hashCode(this.__have_voucher);
		hash = 97 * hash + Objects.hashCode(this.__is_capital);
		hash = 97 * hash + Objects.hashCode(this.__capital_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__overdue_payment);
		hash = 97 * hash + Objects.hashCode(this.__arrears);
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMinvoicecseccor o = (BaseMinvoicecseccor)obj;
		if(!Objects.equals(this.__invoice_id, o.getInvoiceId())) return false;
		if(!Objects.equals(this.__ticketing_company, o.getTicketingCompany())) return false;
		if(!Objects.equals(this.__invoice_type, o.getInvoiceType())) return false;
		if(!Objects.equals(this.__invoice_code, o.getInvoiceCode())) return false;
		if(!Objects.equals(this.__invoice_number, o.getInvoiceNumber())) return false;
		if(!Objects.equals(this.__in_stock_date, o.getInStockDate())) return false;
		if(!Objects.equals(this.__invalid_remark, o.getInvalidRemark())) return false;
		if(!Objects.equals(this.__is_invalid_operator, o.getIsInvalidOperator())) return false;
		if(!Objects.equals(this.__storage_operator, o.getStorageOperator())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__billing_operation, o.getBillingOperation())) return false;
		if(!Objects.equals(this.__invoice_date, o.getInvoiceDate())) return false;
		if(!Objects.equals(this.__registration_date, o.getRegistrationDate())) return false;
		if(!Objects.equals(this.__sign, o.getSign())) return false;
		if(!Objects.equals(this.__contract_receivable_id, o.getContractReceivableId())) return false;
		if(!Objects.equals(this.__acknowledge_letter_id, o.getAcknowledgeLetterId())) return false;
		if(!Objects.equals(this.__have_voucher, o.getHaveVoucher())) return false;
		if(!Objects.equals(this.__is_capital, o.getIsCapital())) return false;
		if(!Objects.equals(this.__capital_amount, o.getCapitalAmount())) return false;
		if(!Objects.equals(this.__project_manager_id, o.getProjectManagerId())) return false;
		if(!Objects.equals(this.__arrears, o.getArrears())) return false;
		if(!Objects.equals(this.__overdue_payment, o.getOverduePayment())) return false;
		return true;
	}
	

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInvoiceId() != null) sb.append(__wrapNumber(count++, "invoiceId", getInvoiceId()));
		if(getTicketingCompany() != null) sb.append(__wrapNumber(count++, "ticketingCompany", getTicketingCompany()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(count++, "invoiceType", getInvoiceType()));
		if(getInvoiceCode() != null) sb.append(__wrapString(count++, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(count++, "invoiceNumber", getInvoiceNumber()));
		if(getInStockDate() != null) sb.append(__wrapDate(count++, "inStockDate", getInStockDate()));
		if(getInvalidRemark() != null) sb.append(__wrapString(count++, "invalidRemark", getInvalidRemark()));
		if(getIsInvalidOperator() != null) sb.append(__wrapNumber(count++, "isInvalidOperator", getIsInvalidOperator()));
		if(getStorageOperator() != null) sb.append(__wrapNumber(count++, "storageOperator", getStorageOperator()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getBillingOperation() != null) sb.append(__wrapNumber(count++, "billingOperation", getBillingOperation()));
		if(getInvoiceDate() != null) sb.append(__wrapDate(count++, "invoiceDate", getInvoiceDate()));
		if(getRegistrationDate() != null) sb.append(__wrapDate(count++, "registrationDate", getRegistrationDate()));
		if(getSign() != null) sb.append(__wrapNumber(count++, "sign", getSign()));
		if(getContractReceivableId() != null) sb.append(__wrapNumber(count++, "contractReceivableId", getContractReceivableId()));
		if(getAcknowledgeLetterId() != null) sb.append(__wrapNumber(count++, "acknowledgeLetterId", getAcknowledgeLetterId()));
		if(getHaveVoucher() != null) sb.append(__wrapBoolean(count++, "haveVoucher", getHaveVoucher()));
		if(getIsCapital() != null) sb.append(__wrapNumber(count++, "isCapital", getIsCapital()));
		if(getCapitalAmount() != null) sb.append(__wrapDecimal(count++, "capitalAmount", getCapitalAmount()));
		if(getProjectManagerId() != null) sb.append(__wrapNumber(count++, "projectManagerId", getProjectManagerId()));
		if(getArrears() != null) sb.append(__wrapDecimal(count++, "arrears", getArrears()));
		if(getOverduePayment() != null) sb.append(__wrapNumber(count++, "overduePayment", getOverduePayment()));
		return sb.toString();
	}
	
	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("invoiceId")) != null) setInvoiceId(__getInt(val)); 
		if((val = values.get("ticketingCompany")) != null) setTicketingCompany(__getInt(val)); 
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("inStockDate")) != null) setInStockDate(__getDate(val)); 
		if((val = values.get("invalidRemark")) != null) setInvalidRemark(__getString(val));
		if((val = values.get("isInvalidOperator")) != null) setIsInvalidOperator(__getInt(val)); 
		if((val = values.get("storageOperator")) != null) setStorageOperator(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val));
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("billingOperation")) != null) setBillingOperation(__getInt(val)); 
		if((val = values.get("invoiceDate")) != null) setInvoiceDate(__getDate(val)); 
		if((val = values.get("registrationDate")) != null) setRegistrationDate(__getDate(val)); 
		if((val = values.get("sign")) != null) setSign(__getInt(val)); 
		if((val = values.get("contractReceivableId")) != null) setContractReceivableId(__getInt(val)); 
		if((val = values.get("acknowledgeLetterId")) != null) setAcknowledgeLetterId(__getInt(val)); 
		if((val = values.get("haveVoucher")) != null) setHaveVoucher(__getBoolean(val));
		if((val = values.get("isCapital")) != null) setIsCapital(__getInt(val)); 
		if((val = values.get("capitalAmount")) != null) setCapitalAmount(__getDecimal(val));  
		if((val = values.get("projectManagerId")) != null) setProjectManagerId(__getInt(val)); 
		if((val = values.get("arrears")) != null) setArrears(__getDecimal(val));  
		if((val = values.get("overduePayment")) != null) setOverduePayment(__getInt(val)); 
	}
	
	protected java.lang.Integer  __invoice_id ;
	protected java.lang.Integer  __ticketing_company ;
	protected java.lang.Integer  __invoice_type ;
	protected java.lang.String  __invoice_code ;
	protected java.lang.String  __invoice_number ;
	protected java.util.Date  __in_stock_date ;
	protected java.lang.String  __invalid_remark ;
	protected java.lang.Integer  __is_invalid_operator ;
	protected java.lang.Integer  __storage_operator ;
	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.lang.Integer  __customer_id ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.lang.Integer  __billing_operation ;
	protected java.util.Date  __invoice_date ;
	protected java.util.Date  __registration_date ;
	protected java.lang.Integer  __sign ;
	protected java.lang.Integer  __contract_receivable_id ;
	protected java.lang.Integer  __acknowledge_letter_id ;
	protected java.lang.Boolean  __have_voucher ;
	protected java.lang.Integer  __is_capital ;
	protected java.math.BigDecimal  __capital_amount ;
	protected java.lang.Integer  __project_manager_id ;
	protected java.math.BigDecimal  __arrears ;
	protected java.lang.Integer  __overdue_payment ;
}
