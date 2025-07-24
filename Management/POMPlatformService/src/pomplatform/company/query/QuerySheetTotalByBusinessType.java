package pomplatform.company.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.company.bean.BaseSheetTotalByBusinessType;
import pomplatform.company.bean.ConditionSheetTotalByBusinessType;

public class QuerySheetTotalByBusinessType extends AbstractQuery<BaseSheetTotalByBusinessType, ConditionSheetTotalByBusinessType>
{

	private static final Logger __logger = Logger.getLogger(QuerySheetTotalByBusinessType.class);

	public QuerySheetTotalByBusinessType() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("business_type");
	}

	@Override
	public BaseCollection<BaseSheetTotalByBusinessType> executeQuery( KeyValuePair[] replacements, ConditionSheetTotalByBusinessType condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseSheetTotalByBusinessType generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSheetTotalByBusinessType __base = new BaseSheetTotalByBusinessType();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select business_type,sum(sheet_total_integral) as sheet_total_integral,sum(complaint_integral) as complaint_integral,sum(sheet_integral) as sheet_integral from sub_contracts where agree_date >= ? and agree_date <? group by business_type order by sheet_total_integral desc" ;
	private final static String RESULTSETFIELDLIST = "business_type,sheet_total_integral,complaint_integral,sheet_integral";
	private final static String[] fieldNames = { "start_date", "end_date"};
}
