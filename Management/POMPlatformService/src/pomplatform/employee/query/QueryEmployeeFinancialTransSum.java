package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseEmployeeFinancialTransSum;
import pomplatform.employee.bean.ConditionEmployeeFinancialTransSum;

public class QueryEmployeeFinancialTransSum extends AbstractQuery<BaseEmployeeFinancialTransSum, ConditionEmployeeFinancialTransSum>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeFinancialTransSum.class);

	public QueryEmployeeFinancialTransSum() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.financial_transaction_account_id");
	}

	@Override
	public BaseCollection<BaseEmployeeFinancialTransSum> executeQuery( KeyValuePair[] replacements, ConditionEmployeeFinancialTransSum condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountType(), 
				condition.getEntityId(), 
				condition.getCompanyId(), 
				condition.getAccountType(), 
				condition.getEntityId(), 
				condition.getCompanyId(), 
				condition.getIsCompleted()
			);
	}

	public BaseCollection<BaseEmployeeFinancialTransSum> execute( KeyValuePair[] replacements, ConditionEmployeeFinancialTransSum condition ) throws java.sql.SQLException {
		return execute(condition, replacements, 
				condition.getAccountType(), 
				condition.getEntityId(), 
				condition.getCompanyId(), 
				condition.getAccountType(), 
				condition.getEntityId(), 
				condition.getCompanyId(), 
				condition.getIsCompleted()
			);
	}

	@Override
	public BaseEmployeeFinancialTransSum generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeFinancialTransSum __base = new BaseEmployeeFinancialTransSum();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStandardDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStandardCredit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowLimit(GenericBase.__getDecimal(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
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

	private final static String __SQLText = "select e.financial_transaction_account_id, COALESCE(sum(e.standard_debit), 0) as standard_debit, COALESCE(sum(e.standard_credit), 0) as standard_credit, 0 as borrow_limit from ( (select a.financial_transaction_account_id, b.standard_debit, b.standard_credit from financial_transaction_account_link_entities a LEFT JOIN financial_account_init_amount b on a.financial_transaction_account_id = b.financial_transaction_account_id and b.delete_flag = 0 WHERE a.account_type = ? and a.entity_id = ? and b.company_id = ? ) union all (select c.financial_transaction_account_id, sum(d.standard_debit) as standard_debit, sum(d.standard_credit) as standard_credit from financial_transaction_account_link_entities c LEFT JOIN financial_transaction_details d on c.financial_transaction_account_id = d.financial_transaction_account_id and d.delete_flag = 0 WHERE c.account_type = ? and c.entity_id = ? and d.company_id = ? and d.is_completed = ? group by c.financial_transaction_account_id) ) e GROUP BY e.financial_transaction_account_id" ;
	private final static String __originalSQL = "select e.financial_transaction_account_id, COALESCE(sum(e.standard_debit), 0) as standard_debit, COALESCE(sum(e.standard_credit), 0) as standard_credit, 0 as borrow_limit from ( (select a.financial_transaction_account_id, b.standard_debit, b.standard_credit from financial_transaction_account_link_entities a LEFT JOIN financial_account_init_amount b on a.financial_transaction_account_id = b.financial_transaction_account_id and b.delete_flag = 0 WHERE a.account_type = :account_type and a.entity_id = :entity_id and b.company_id = :company_id ) union all (select c.financial_transaction_account_id, sum(d.standard_debit) as standard_debit, sum(d.standard_credit) as standard_credit from financial_transaction_account_link_entities c LEFT JOIN financial_transaction_details d on c.financial_transaction_account_id = d.financial_transaction_account_id and d.delete_flag = 0 WHERE c.account_type = :account_type and c.entity_id = :entity_id and d.company_id = :company_id and d.is_completed = :is_completed group by c.financial_transaction_account_id) ) e GROUP BY e.financial_transaction_account_id ";
	private final static String[] __queryConditions = {
		"{\"fullCondition\": \"a.account_type = @account_type and a.entity_id = @entity_id and b.company_id = @company_id\",\"startIndex\": 454,\"stopIndex\":543,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"a.account_type = @account_type and a.entity_id = @entity_id\",\"startIndex\": 454,\"stopIndex\":512,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"a.account_type = @account_type\",\"fullFieldName\":\"a.account_type\",\"operationName\":\"=\",\"variableName\":\"accountType\",\"startIndex\": 454,\"stopIndex\":483,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.entity_id = @entity_id\",\"fullFieldName\":\"a.entity_id\",\"operationName\":\"=\",\"variableName\":\"entityId\",\"startIndex\": 489,\"stopIndex\":512,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"b.company_id = @company_id\",\"fullFieldName\":\"b.company_id\",\"operationName\":\"=\",\"variableName\":\"companyId\",\"startIndex\": 518,\"stopIndex\":543,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}"
		,
		"{\"fullCondition\": \"c.account_type = @account_type and c.entity_id = @entity_id and d.company_id = @company_id and d.is_completed = @is_completed\",\"startIndex\": 880,\"stopIndex\":1004,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"c.account_type = @account_type and c.entity_id = @entity_id and d.company_id = @company_id\",\"startIndex\": 880,\"stopIndex\":969,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"c.account_type = @account_type and c.entity_id = @entity_id\",\"startIndex\": 880,\"stopIndex\":938,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"c.account_type = @account_type\",\"fullFieldName\":\"c.account_type\",\"operationName\":\"=\",\"variableName\":\"accountType\",\"startIndex\": 880,\"stopIndex\":909,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"c.entity_id = @entity_id\",\"fullFieldName\":\"c.entity_id\",\"operationName\":\"=\",\"variableName\":\"entityId\",\"startIndex\": 915,\"stopIndex\":938,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"d.company_id = @company_id\",\"fullFieldName\":\"d.company_id\",\"operationName\":\"=\",\"variableName\":\"companyId\",\"startIndex\": 944,\"stopIndex\":969,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"d.is_completed = @is_completed\",\"fullFieldName\":\"d.is_completed\",\"operationName\":\"=\",\"variableName\":\"isCompleted\",\"startIndex\": 975,\"stopIndex\":1004,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}"
	};
	private final static String RESULTSETFIELDLIST = "financial_transaction_account_id,standard_debit,standard_credit,borrow_limit";
	private final static String[] fieldNames = { "account_type", "entity_id", "company_id", "account_type", "entity_id", "company_id", "is_completed"};
}
