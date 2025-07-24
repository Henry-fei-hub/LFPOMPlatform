package pomplatform.financialStatements.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialStatements.bean.BaseFinancialContractMoney;
import pomplatform.financialStatements.bean.ConditionFinancialContractMoney;

public class QueryFinancialContractMoney extends AbstractQuery<BaseFinancialContractMoney, ConditionFinancialContractMoney>
{

	private static final Logger __logger = Logger.getLogger(QueryFinancialContractMoney.class);

	public QueryFinancialContractMoney() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("foo.company_id");
	}

	@Override
	public BaseCollection<BaseFinancialContractMoney> executeQuery( KeyValuePair[] replacements, ConditionFinancialContractMoney condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime()
			);
	}

	@Override
	public BaseFinancialContractMoney generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFinancialContractMoney __base = new BaseFinancialContractMoney();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
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

	private final static String __SQLText = "SELECT foo.company_id, SUM(foo.payment_amount) AS amount FROM ( SELECT rpd.business_id, rpd.payment_amount, pnr.company_id, rp.update_time FROM (SELECT DISTINCT business_id, reimbursement_package_id, process_type_id, SUM(payment_amount) AS payment_amount FROM reimbursement_package_details WHERE process_type_id IN (2, 8) GROUP BY business_id, reimbursement_package_id, process_type_id) rpd LEFT JOIN reimbursement_packages rp ON rp.reimbursement_package_id = rpd.reimbursement_package_id LEFT JOIN project_normal_reimbursements pnr ON rpd.business_id = pnr.project_normal_reimbursement_id WHERE rp.is_completed = TRUE UNION ALL SELECT rpd.business_id, rpd.payment_amount, tr.company_id, rp.update_time FROM (SELECT DISTINCT business_id, reimbursement_package_id, process_type_id, SUM(payment_amount) AS payment_amount FROM reimbursement_package_details WHERE process_type_id IN (4, 9) GROUP BY business_id, reimbursement_package_id, process_type_id) rpd LEFT JOIN reimbursement_packages rp ON rp.reimbursement_package_id = rpd.reimbursement_package_id LEFT JOIN travel_reimbursements tr ON rpd.business_id = tr.travel_reimbursement_id WHERE rp.is_completed = TRUE ) AS foo WHERE foo.company_id = ? AND foo.company_id in (replace) AND foo.update_time BETWEEN ? AND ? GROUP BY foo.company_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,amount";
	private final static String[] fieldNames = { "company_id", "min_update_time", "max_update_time"};
}
