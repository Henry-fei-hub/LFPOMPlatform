package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadBenefitsData;
import pomplatform.account.bean.ConditionOnLoadBenefitsData;

public class QueryOnLoadBenefitsData extends AbstractQuery<BaseOnLoadBenefitsData, ConditionOnLoadBenefitsData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadBenefitsData.class);

	public QueryOnLoadBenefitsData() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("business_type_id");
	}

	@Override
	public BaseCollection<BaseOnLoadBenefitsData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadBenefitsData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseOnLoadBenefitsData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadBenefitsData __base = new BaseOnLoadBenefitsData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select business_type_id,sum(integral) as integral,EXTRACT(YEAR from record_date) as year,EXTRACT(MONTH from record_date) as month from employee_account_records where employee_id = ? and EXTRACT(YEAR from record_date) =? GROUP BY business_type_id,EXTRACT(YEAR from record_date),EXTRACT(MONTH from record_date)" ;
	private final static String RESULTSETFIELDLIST = "business_type_id,integral,year,month";
	private final static String[] fieldNames = { "employee_id", "year"};
}
