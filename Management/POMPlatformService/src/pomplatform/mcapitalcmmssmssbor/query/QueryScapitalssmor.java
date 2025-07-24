package pomplatform.mcapitalcmmssmssbor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mcapitalcmmssmssbor.bean.BaseScapitalssmor;
import pomplatform.mcapitalcmmssmssbor.bean.ConditionScapitalssmor;

public class QueryScapitalssmor extends AbstractQuery<BaseScapitalssmor, ConditionScapitalssmor>
{

	private static final Logger __logger = Logger.getLogger(QueryScapitalssmor.class);

	public QueryScapitalssmor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.capital_id");
	}

	@Override
	public BaseCollection<BaseScapitalssmor> executeQuery( KeyValuePair[] replacements, ConditionScapitalssmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSelfName(), 
				condition.getSelfBankAccount(), 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate()
			);
	}

	@Override
	public BaseScapitalssmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScapitalssmor __base = new BaseScapitalssmor();
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
		if((val = __data[count++]) != null) __base.setBalance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalCurrency(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "select c.capital_id, c.info_code, c.project_code, c.contract_id, c.contract_code, c.money_attribute, c.self_name, c.self_bank_name, c.self_bank_account, c.other_name, c.other_bank_name, c.other_bank_account, c.borrow_money, c.loan_money, c.operator, c.happen_date, c.create_date, c.has_invoices, c.has_contract_receivable, c.has_distribution_collection, c.remark, c.capital_type, c.reimbursement_package_summary_id,null AS balance, c.original_currency from capitals c where c.self_name = ? and c.self_bank_account = ? and c.happen_date between ? and ? ORDER BY c.happen_date ASC" ;
	private final static String RESULTSETFIELDLIST = "capital_id,info_code,project_code,contract_id,contract_code,money_attribute,self_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,borrow_money,loan_money,operator,happen_date,create_date,has_invoices,has_contract_receivable,has_distribution_collection,remark,capital_type,reimbursement_package_summary_id,balance,original_currency";
	private final static String[] fieldNames = { "self_name", "self_bank_account", "min_happen_date", "max_happen_date"};
}
