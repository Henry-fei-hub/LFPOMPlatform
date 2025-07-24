package pomplatform.finance.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.finance.bean.BaseInvoiceAndPayment;
import pomplatform.finance.bean.ConditionInvoiceAndPayment;

public class QueryInvoiceAndPayment extends AbstractQuery<BaseInvoiceAndPayment, ConditionInvoiceAndPayment>
{

	private static final Logger __logger = Logger.getLogger(QueryInvoiceAndPayment.class);

	public QueryInvoiceAndPayment() throws java.sql.SQLException 
	{
		setParameterNumber(14);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("C.capital_id");
	}
	@Override
	public BaseCollection<BaseInvoiceAndPayment> executeQuery( KeyValuePair[] replacements, ConditionInvoiceAndPayment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getOtherName(), 
				condition.getOtherBankAccount(), 
				condition.getSelfName(), 
				condition.getHasInvoices(),
				condition.getHasContractReceivable(), 
				condition.getHasDistributionCollection(), 
				condition.getProcessStatus(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getBorrowMoney(), 
				condition.getHaveVoucher(),
				condition.getHappenYear(),
				condition.getHappenMonth()
			);
	}

	@Override
	public BaseInvoiceAndPayment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseInvoiceAndPayment __base = new BaseInvoiceAndPayment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSelfName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLoanMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasInvoices(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasContractReceivable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHasDistributionCollection(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCapitalType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRecordReceiveCapital(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalCurrency(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsHavingInvoice(GenericBase.__getDecimal(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[4]));
		if(args[5] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[10]));
		if(args[11] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT C.capital_id, C.info_code, C.project_code, C.contract_id, st.contract_name, st.contract_code, C.money_attribute, C.self_name, C.self_bank_name, C.self_bank_account, C.other_name, C.other_bank_name, C.other_bank_account, C.borrow_money, C.loan_money, C.OPERATOR, C.happen_date, C.create_date, C.has_invoices, C.has_contract_receivable, e.employee_name, C.remark, C.has_distribution_collection, C.capital_type, C.reimbursement_package_summary_id, C.process_status, C.capital_distribution_id, C.have_voucher, C.record_receive_capital, C.exchange_rate, C.original_currency,C.is_having_invoice FROM capitals C LEFT JOIN employees e ON C.OPERATOR = e.employee_id LEFT JOIN contracts st ON st.contract_id = C.contract_id WHERE C.contract_id =? AND C.other_name LIKE ? AND C.other_bank_account LIKE ? AND C.self_name =? AND C.money_attribute =1 AND C.has_invoices =? AND C.has_contract_receivable =? AND C.has_distribution_collection =? AND C.capital_type = 1 AND process_status =? AND st.contract_code LIKE ? AND st.contract_name LIKE ? AND borrow_money =? AND C.have_voucher =? AND EXTRACT( YEAR FROM happen_date ) =? AND EXTRACT( MONTH FROM happen_date ) =? ORDER BY C.capital_id" ;
	private final static String RESULTSETFIELDLIST = "capital_id,info_code,project_code,contract_id,contract_name,contract_code,money_attribute,self_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,borrow_money,loan_money,operator,happen_date,create_date,has_invoices,has_contract_receivable,employee_name,remark,has_distribution_collection,capital_type,reimbursement_package_summary_id,process_status,capital_distribution_id,have_voucher,record_receive_capital,exchange_rate,original_currency,is_having_invoice";
	private final static String[] fieldNames = { "contract_id", "other_name", "other_bank_account", "self_name", "has_invoices", "has_contract_receivable", "has_distribution_collection", "process_status", "contract_code", "contract_name", "borrow_money", "have_voucher","happen_year","happen_month"};
}
