package pomplatform.cmbcinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cmbcinfo.bean.BaseMcapitalbccoccmsssoooblpommmmlor;
import pomplatform.cmbcinfo.bean.ConditionMcapitalbccoccmsssoooblpommmmlor;

public class QueryMcapitalbccoccmsssoooblpommmmlor extends AbstractQuery<BaseMcapitalbccoccmsssoooblpommmmlor, ConditionMcapitalbccoccmsssoooblpommmmlor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitalbccoccmsssoooblpommmmlor.class);

	public QueryMcapitalbccoccmsssoooblpommmmlor() throws java.sql.SQLException 
	{
		setParameterNumber(22);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.capital_id");
	}

	@Override
	public BaseCollection<BaseMcapitalbccoccmsssoooblpommmmlor> executeQuery( KeyValuePair[] replacements, ConditionMcapitalbccoccmsssoooblpommmmlor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getLinkType(),
				condition.getCapitalId(), 
				condition.getContractId(), 
				condition.getOperator(), 
				condition.getCapitalType(), 
				condition.getContractCode(), 
				condition.getMoneyAttribute(), 
				condition.getSelfName(), 
				condition.getSelfBankName(), 
				condition.getSelfBankAccount(), 
				condition.getOtherName(), 
				condition.getOtherBankName(), 
				condition.getOtherBankAccount(), 
				condition.getBorrowMoney(), 
				condition.getLoanMoney(), 
				condition.getProcessStatus(), 
				condition.getOriginalCurrency(), 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate(), 
				condition.getMinCreateDate(), 
				condition.getMaxCreateDate(), 
				condition.getLinkNum()
			);
	}

	@Override
	public BaseMcapitalbccoccmsssoooblpommmmlor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitalbccoccmsssoooblpommmmlor __base = new BaseMcapitalbccoccmsssoooblpommmmlor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setHasDistributionCollection(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCapitalType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordReceiveCapital(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalCurrency(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLinkNum(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[13]));
		if(args[14] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[16]));
		if(args[17] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[17]));
		if(args[18] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[18]));
		if(args[19] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[19]));
		if(args[20] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
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

	private final static String __SQLText = "select c.capital_id, c.info_code, c.project_code, c.contract_id, c.contract_code, c.money_attribute, c.self_name, c.self_bank_name, c.self_bank_account, c.other_name, c.other_bank_name, c.other_bank_account, c.borrow_money, c.loan_money, c.operator, c.happen_date, c.create_date, c.has_invoices, c.has_contract_receivable, c.has_distribution_collection, c.remark, c.capital_type, c.reimbursement_package_summary_id, c.process_status, c.capital_distribution_id, c.have_voucher, c.process_type, c.business_id, c.record_receive_capital, c.exchange_rate, c.original_currency, bccl.link_num from capitals c LEFT JOIN (SELECT business_id, count(1) AS link_num FROM bank_capital_check_links WHERE link_type = ? AND business_type = 2 GROUP BY business_id) bccl ON c.capital_id = bccl.business_id where c.capital_id = ? and c.contract_id = ? and c.operator = ? and c.capital_type = ? AND c.contract_code like ? AND c.money_attribute = ? AND c.self_name = ? AND c.self_bank_name like ? AND c.self_bank_account LIKE ? AND c.other_name LIKE ? AND c.other_bank_name LIKE ? AND c.other_bank_account LIKE ? AND c.borrow_money = ? AND c.loan_money = ? AND c.process_status = ? AND c.original_currency = ? AND c.happen_date BETWEEN ? AND ? AND c.create_date BETWEEN ? AND ? AND bccl.link_num > ? order by c.happen_date desc" ;
	private final static String RESULTSETFIELDLIST = "capital_id,info_code,project_code,contract_id,contract_code,money_attribute,self_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,borrow_money,loan_money,operator,happen_date,create_date,has_invoices,has_contract_receivable,has_distribution_collection,remark,capital_type,reimbursement_package_summary_id,process_status,capital_distribution_id,have_voucher,process_type,business_id,record_receive_capital,exchange_rate,original_currency,link_num";
	private final static String[] fieldNames = { "link_type", "capital_id", "contract_id", "operator", "capital_type", "contract_code", "money_attribute", "self_name", "self_bank_name", "self_bank_account", "other_name", "other_bank_name", "other_bank_account", "borrow_money", "loan_money", "process_status", "original_currency", "min_happen_date", "max_happen_date", "min_create_date", "max_create_date", "link_num"};
}
