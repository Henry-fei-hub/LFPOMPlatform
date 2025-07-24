package pomplatform.capitalsinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitalsinfo.bean.BaseCapitalsInfo;
import pomplatform.capitalsinfo.bean.ConditionCapitalsInfo;

public class QueryCapitalsInfo extends AbstractQuery<BaseCapitalsInfo, ConditionCapitalsInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalsInfo.class);

	public QueryCapitalsInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("contract_id");
	}

	@Override
	public BaseCollection<BaseCapitalsInfo> executeQuery( KeyValuePair[] replacements, ConditionCapitalsInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear()
			);
	}

	@Override
	public BaseCapitalsInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalsInfo __base = new BaseCapitalsInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT contract_id, happen_date, year, month, original_currency FROM ( SELECT contract_id, happen_date, EXTRACT(YEAR FROM happen_date) as year, EXTRACT(MONTH FROM happen_date) as month, original_currency from capitals A WHERE capital_type =1 AND money_attribute = 1  OR money_attribute = 11  AND  contract_id is not null AND contract_id >0 ) B WHERE B.year=?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,happen_date,year,month,original_currency";
	private final static String[] fieldNames = { "year"};
}
