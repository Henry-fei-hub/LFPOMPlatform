package pomplatform.report.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseDepartmentAccountIncome;
import pomplatform.report.bean.ConditionDepartmentAccountIncome;

public class QueryDepartmentAccountIncome extends AbstractQuery<BaseDepartmentAccountIncome, ConditionDepartmentAccountIncome>
{

	private static final Logger __logger = Logger.getLogger(QueryDepartmentAccountIncome.class);

	public QueryDepartmentAccountIncome() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("EXTRACT(year from record_date)");
	}

	@Override
	public BaseCollection<BaseDepartmentAccountIncome> executeQuery(KeyValuePair[] replacements, ConditionDepartmentAccountIncome condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getBusinessTypeId()
			);
	}

	@Override
	public BaseDepartmentAccountIncome generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDepartmentAccountIncome __base = new BaseDepartmentAccountIncome();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDatePart(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setDatePart(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT EXTRACT(year from record_date),EXTRACT(month from record_date),plate_id , business_type_id , sum(integral) AS integral from plate_account_records where business_type_id in (1,7) and EXTRACT(year from record_date) =? and EXTRACT(month from record_date) =? and plate_id =? and business_type_id =? GROUP BY EXTRACT(year from record_date),EXTRACT(month from record_date),plate_id ,business_type_id" ;
	private final static String RESULTSETFIELDLIST = "date_part,date_part,plate_id,business_type_id,integral";
	private final static String[] fieldNames = { "year", "month", "plate_id", "business_type_id"};
}
