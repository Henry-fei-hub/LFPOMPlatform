package pomplatform.plateIntegralSends.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateIntegralSends.bean.BasePlateIntegralSends;
import pomplatform.plateIntegralSends.bean.ConditionPlateIntegralSends;

public class QueryPlateIntegralSends extends AbstractQuery<BasePlateIntegralSends, ConditionPlateIntegralSends>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateIntegralSends.class);

	public QueryPlateIntegralSends() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pis.plate_integral_send_id");
	}

	@Override
	public BaseCollection<BasePlateIntegralSends> executeQuery( KeyValuePair[] replacements, ConditionPlateIntegralSends condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateIntegralSendId(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BasePlateIntegralSends generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateIntegralSends __base = new BasePlateIntegralSends();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateIntegralSendId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "select pis.plate_integral_send_id, pis.plate_id, pis.send_integral, pis.employee_id, pis.send_date, pis.remark from plate_integral_sends pis where pis.plate_integral_send_id = ? and pis.plate_id = ? and pis.employee_id = ? and pis.send_date >= ? and pis.send_date <= ? order by pis.send_date desc" ;
	private final static String RESULTSETFIELDLIST = "plate_integral_send_id,plate_id,send_integral,employee_id,send_date,remark";
	private final static String[] fieldNames = { "plate_integral_send_id", "plate_id", "employee_id", "start_date", "end_date"};
}
