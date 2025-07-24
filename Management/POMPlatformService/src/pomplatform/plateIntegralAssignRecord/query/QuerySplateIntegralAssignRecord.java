package pomplatform.plateIntegralAssignRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateIntegralAssignRecord.bean.BaseSplateIntegralAssignRecord;
import pomplatform.plateIntegralAssignRecord.bean.ConditionSplateIntegralAssignRecord;

public class QuerySplateIntegralAssignRecord extends AbstractQuery<BaseSplateIntegralAssignRecord, ConditionSplateIntegralAssignRecord>
{

	private static final Logger __logger = Logger.getLogger(QuerySplateIntegralAssignRecord.class);

	public QuerySplateIntegralAssignRecord() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("piar.plate_integral_assign_record_id");
	}

	@Override
	public BaseCollection<BaseSplateIntegralAssignRecord> executeQuery( KeyValuePair[] replacements, ConditionSplateIntegralAssignRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseSplateIntegralAssignRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSplateIntegralAssignRecord __base = new BaseSplateIntegralAssignRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateIntegralAssignRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAssignDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select piar.plate_integral_assign_record_id, piar.plate_id, piar.employee_id, piar.assign_integral, piar.assign_date, piar.plate_employee_id, piar.remark from plate_integral_assign_records piar where piar.employee_id = ? and piar.plate_id = ? order by piar.assign_date desc" ;
	private final static String RESULTSETFIELDLIST = "plate_integral_assign_record_id,plate_id,employee_id,assign_integral,assign_date,plate_employee_id,remark";
	private final static String[] fieldNames = { "employee_id", "plate_id"};
}
