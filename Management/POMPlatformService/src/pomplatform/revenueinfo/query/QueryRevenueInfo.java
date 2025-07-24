package pomplatform.revenueinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.revenueinfo.bean.BaseRevenueInfo;
import pomplatform.revenueinfo.bean.ConditionRevenueInfo;

public class QueryRevenueInfo extends AbstractQuery<BaseRevenueInfo, ConditionRevenueInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryRevenueInfo.class);

	public QueryRevenueInfo() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.YEAR");
	}

	@Override
	public BaseCollection<BaseRevenueInfo> executeQuery( KeyValuePair[] replacements, ConditionRevenueInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseRevenueInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRevenueInfo __base = new BaseRevenueInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT A.YEAR, A.MONTH, b.contract_id, SUM(A.current_revenue) AS current_revenue FROM revenue_statistical_records A LEFT JOIN projects b ON A.project_id = b.project_id WHERE b.contract_id =? AND A.YEAR =? AND b.contract_id > 0 GROUP BY A.YEAR, A.MONTH, b.contract_id" ;
	private final static String RESULTSETFIELDLIST = "year,month,contract_id,current_revenue";
	private final static String[] fieldNames = { "contract_id", "YEAR"};
}
