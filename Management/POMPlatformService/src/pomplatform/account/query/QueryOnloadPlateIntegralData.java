package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnloadPlateIntegralData;
import pomplatform.account.bean.ConditionOnloadPlateIntegralData;

public class QueryOnloadPlateIntegralData extends AbstractQuery<BaseOnloadPlateIntegralData, ConditionOnloadPlateIntegralData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnloadPlateIntegralData.class);

	public QueryOnloadPlateIntegralData() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.*");
	}

	@Override
	public BaseCollection<BaseOnloadPlateIntegralData> executeQuery( KeyValuePair[] replacements, ConditionOnloadPlateIntegralData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOnloadPlateIntegralData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnloadPlateIntegralData __base = new BaseOnloadPlateIntegralData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegralInt(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select abc.*,case when abc.integral < 0 then 1 else 2 end as flag ,case when abc.integral < 0 then -integral else integral end as integral_int from ( select plate_id,sum(integral) as integral,business_type_id,b.dic_type_value as name from plate_account_records left JOIN system_dictionary b on business_type_id = b.dic_type_value_id and b.dic_type_id = 65 where plate_id = ? and record_date BETWEEN ? AND ? GROUP BY plate_id,business_type_id,b.dic_type_value ) as abc ORDER BY abc.integral" ;
	private final static String RESULTSETFIELDLIST = "plate_id,integral,business_type_id,name,flag,integral_int";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
