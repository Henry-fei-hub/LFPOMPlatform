package pomplatform.operating.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operating.bean.BaseOperatingOnOtherPlateIntegral;
import pomplatform.operating.bean.ConditionOperatingOnOtherPlateIntegral;

public class QueryOperatingOnOtherPlateIntegral extends AbstractQuery<BaseOperatingOnOtherPlateIntegral, ConditionOperatingOnOtherPlateIntegral>
{

	private static final Logger __logger = Logger.getLogger(QueryOperatingOnOtherPlateIntegral.class);

	public QueryOperatingOnOtherPlateIntegral() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.plate_id as own_plate_id");
	}

	@Override
	public BaseCollection<BaseOperatingOnOtherPlateIntegral> executeQuery( KeyValuePair[] replacements, ConditionOperatingOnOtherPlateIntegral condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOperatingOnOtherPlateIntegral generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOperatingOnOtherPlateIntegral __base = new BaseOperatingOnOtherPlateIntegral();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOwnPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "select c.plate_id as own_plate_id,a.project_id,a.employee_id,a.final_amount,a.settlement_date ,b.year,b.month,b.plate_id from project_settlement_details a left join employee_change_plate_records b on a.employee_id = b.employee_id and extract(year from a.settlement_date) = year and extract(month from a.settlement_date) = month left join projects c on a.project_id = c.project_id where c.plate_id = ? and b.plate_id <> ? and a.settlement_date >= ? and a.settlement_date < ? and c.project_setup_flag <> 1 order by a.settlement_date " ;
	private final static String RESULTSETFIELDLIST = "own_plate_id,project_id,employee_id,final_amount,settlement_date,year,month,plate_id";
	private final static String[] fieldNames = { "plate_id", "plate_id", "start_date", "end_date"};
}
