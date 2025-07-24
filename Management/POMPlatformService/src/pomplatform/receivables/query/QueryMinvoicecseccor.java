package pomplatform.receivables.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.receivables.bean.BaseMinvoicecseccor;
import pomplatform.receivables.bean.ConditionMinvoicecseccor;

public class QueryMinvoicecseccor extends AbstractQuery<BaseMinvoicecseccor, ConditionMinvoicecseccor>
{

	private static final Logger __logger = Logger.getLogger(QueryMinvoicecseccor.class);

	public QueryMinvoicecseccor() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("i.invoice_id");
	}

	@Override
	public BaseCollection<BaseMinvoicecseccor> executeQuery( KeyValuePair[] replacements, ConditionMinvoicecseccor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProjectManagerId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getContractCode(), 
				condition.getContractName()
			);
	}

	public BaseCollection<BaseMinvoicecseccor> runQuery( KeyValuePair[] replacements, ConditionMinvoicecseccor condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProjectManagerId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getContractCode(), 
				condition.getContractName()
			);
	}

	public BaseCollection<BaseMinvoicecseccor> execute( KeyValuePair[] replacements, ConditionMinvoicecseccor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProjectManagerId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getContractCode(), 
				condition.getContractName()
			);
	}

	@Override
	public BaseMinvoicecseccor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMinvoicecseccor __base = new BaseMinvoicecseccor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTicketingCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInStockDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInvalidRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsInvalidOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStorageOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBillingOperation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRegistrationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSign(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAcknowledgeLetterId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsCapital(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectManagerId(GenericBase.__getInt(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT i.invoice_id, i.ticketing_company, i.invoice_type, i.invoice_code, i.invoice_number, i.in_stock_date, i.invalid_remark, i.is_invalid_operator, i.storage_operator, i.info_code, i.project_code, C.contract_id, C.contract_code, C.contract_name, C.signing_money_sum, i.customer_id, i.invoice_amount, i.billing_operation, i.invoice_date, i.registration_date, i.sign, i.contract_receivable_id, i.acknowledge_letter_id, i.have_voucher, i.is_capital, capital_amount, i.project_manager_id FROM invoices i LEFT JOIN contracts C ON C.contract_id = i.contract_id WHERE i.project_manager_id = ? and i.invoice_date >= ? and i.invoice_date <= ? and C.contract_code like ? and C.contract_name like ? and sign IN ( 1, 2 ) ORDER BY i.invoice_date DESC" ;
	private final static String __originalSQL = "SELECT i.invoice_id, i.ticketing_company, i.invoice_type, i.invoice_code, i.invoice_number, i.in_stock_date, i.invalid_remark, i.is_invalid_operator, i.storage_operator, i.info_code, i.project_code, C.contract_id, C.contract_code, C.contract_name, C.signing_money_sum, i.customer_id, i.invoice_amount, i.billing_operation, i.invoice_date, i.registration_date, i.sign, i.contract_receivable_id, i.acknowledge_letter_id, i.have_voucher, i.is_capital, capital_amount, i.project_manager_id FROM invoices i LEFT JOIN contracts C ON C.contract_id = i.contract_id WHERE i.project_manager_id =:project_manager_id AND i.invoice_date >=:start_date AND i.invoice_date <=:end_date AND C.contract_code LIKE :contract_code AND C.contract_name LIKE :contract_name AND sign IN ( 1, 2 ) ORDER BY i.invoice_date DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"i.project_manager_id =:project_manager_id AND i.invoice_date >=:start_date AND i.invoice_date <=:end_date AND C.contract_code LIKE :contract_code AND C.contract_name LIKE :contract_name AND sign IN ( 1, 2 )\",\"startIndex\": 563,\"stopIndex\":768,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"i.project_manager_id =:project_manager_id\",\"fullFieldName\":\"i.project_manager_id\",\"operationName\":\"=\",\"variableName\":\"projectManagerId\",\"nextToken\":\"and\",\"startIndex\": 563,\"stopIndex\":603,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"i.invoice_date >=:start_date\",\"fullFieldName\":\"i.invoice_date\",\"operationName\":\">=\",\"variableName\":\"startDate\",\"nextToken\":\"and\",\"startIndex\": 609,\"stopIndex\":636,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"i.invoice_date <=:end_date\",\"fullFieldName\":\"i.invoice_date\",\"operationName\":\"<=\",\"variableName\":\"endDate\",\"nextToken\":\"and\",\"startIndex\": 642,\"stopIndex\":667,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_code LIKE :contract_code\",\"fullFieldName\":\"C.contract_code\",\"operationName\":\"like\",\"variableName\":\"contractCode\",\"nextToken\":\"and\",\"startIndex\": 673,\"stopIndex\":707,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.contract_name LIKE :contract_name\",\"fullFieldName\":\"C.contract_name\",\"operationName\":\"like\",\"variableName\":\"contractName\",\"nextToken\":\"and\",\"startIndex\": 713,\"stopIndex\":747,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sign IN ( 1, 2 )\",\"startIndex\": 753,\"stopIndex\":768,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "invoice_id,ticketing_company,invoice_type,invoice_code,invoice_number,in_stock_date,invalid_remark,is_invalid_operator,storage_operator,info_code,project_code,contract_id,contract_code,contract_name,signing_money_sum,customer_id,invoice_amount,billing_operation,invoice_date,registration_date,sign,contract_receivable_id,acknowledge_letter_id,have_voucher,is_capital,capital_amount,project_manager_id";
	private final static String[] fieldNames = { "project_manager_id", "start_date", "end_date", "contract_code", "contract_name"};
}
