package pomplatform.plateIntegralSendRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateIntegralSendRecord.bean.BasePlateIntegralSendRecord;
import pomplatform.plateIntegralSendRecord.bean.ConditionPlateIntegralSendRecord;

public class QueryPlateIntegralSendRecord extends AbstractQuery<BasePlateIntegralSendRecord, ConditionPlateIntegralSendRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateIntegralSendRecord.class);

	public QueryPlateIntegralSendRecord() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pis.plate_integral_send_id");
	}

	@Override
	public BaseCollection<BasePlateIntegralSendRecord> executeQuery( KeyValuePair[] replacements, ConditionPlateIntegralSendRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartdate(), 
				condition.getEnddate(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo()
			);
	}

	@Override
	public BasePlateIntegralSendRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateIntegralSendRecord __base = new BasePlateIntegralSendRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateIntegralSendId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSendIntegral(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "SELECT pis.plate_integral_send_id,pis.plate_id,pis.employee_id,e.employee_no,pis.send_integral,pis.send_date,pis.remark from plate_integral_sends pis LEFT JOIN employees e ON pis.employee_id = e.employee_id WHERE pis.plate_id = ? AND pis.send_date >= ? AND pis.send_date <= ? AND pis.employee_id = ? AND e.employee_no like ? ORDER BY pis.send_date DESC, pis.plate_integral_send_id DESC, e.employee_id" ;
	private final static String RESULTSETFIELDLIST = "plate_integral_send_id,plate_id,employee_id,employee_no,send_integral,send_date,remark";
	private final static String[] fieldNames = { "plate_id", "startDate", "endDate", "employee_id", "employee_no"};
}
