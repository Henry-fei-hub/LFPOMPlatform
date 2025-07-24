package pomplatform.company.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.company.bean.BaseCompanyAccountGetSheetTotal;
import pomplatform.company.bean.ConditionCompanyAccountGetSheetTotal;

public class QueryCompanyAccountGetSheetTotal extends AbstractQuery<BaseCompanyAccountGetSheetTotal, ConditionCompanyAccountGetSheetTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryCompanyAccountGetSheetTotal.class);

	public QueryCompanyAccountGetSheetTotal() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.contract_id");
	}

	@Override
	public BaseCollection<BaseCompanyAccountGetSheetTotal> executeQuery( KeyValuePair[] replacements, ConditionCompanyAccountGetSheetTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseCompanyAccountGetSheetTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCompanyAccountGetSheetTotal __base = new BaseCompanyAccountGetSheetTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "SELECT c.contract_id,c.contract_code,c.contract_name,c.signing_money_sum,CASE WHEN sum(p.total_integral) is null THEN 0 ELSE sum(p.total_integral) end as sheet_total_integral FROM contracts c LEFT JOIN projects p ON c.contract_id = p.contract_id WHERE c.contract_date BETWEEN ? AND ? GROUP BY c.contract_id ORDER BY c.contract_id" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,signing_money_sum,sheet_total_integral";
	private final static String[] fieldNames = { "start_date", "end_date"};
}
