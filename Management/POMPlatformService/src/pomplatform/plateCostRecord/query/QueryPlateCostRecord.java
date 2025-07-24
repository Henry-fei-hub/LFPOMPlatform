package pomplatform.plateCostRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateCostRecord.bean.BasePlateCostRecord;
import pomplatform.plateCostRecord.bean.ConditionPlateCostRecord;

public class QueryPlateCostRecord extends AbstractQuery<BasePlateCostRecord, ConditionPlateCostRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateCostRecord.class);

	public QueryPlateCostRecord() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pcr.plate_cost_record_id");
	}

	@Override
	public BaseCollection<BasePlateCostRecord> executeQuery( KeyValuePair[] replacements, ConditionPlateCostRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BasePlateCostRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateCostRecord __base = new BasePlateCostRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateCostRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsSettlement(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT pcr.plate_cost_record_id,pcr.plate_id,pcr.cost_integral,pcr.salary_integral,pcr.remark,pcr.is_settlement,pcr.cost_date,pcr.process_type,pcr.business_id,pcr.process_id,pcr.process_instance_id from plate_cost_records pcr WHERE pcr.plate_id = ? AND pcr.cost_date >= ? AND pcr.cost_date <= ? ORDER BY pcr.cost_date DESC, pcr.plate_cost_record_id DESC" ;
	private final static String RESULTSETFIELDLIST = "plate_cost_record_id,plate_id,cost_integral,salary_integral,remark,is_settlement,cost_date,process_type,business_id,process_id,process_instance_id";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
