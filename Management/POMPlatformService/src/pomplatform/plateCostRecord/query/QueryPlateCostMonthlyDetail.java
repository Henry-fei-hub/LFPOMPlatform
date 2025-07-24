package pomplatform.plateCostRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateCostRecord.bean.BasePlateCostMonthlyDetail;
import pomplatform.plateCostRecord.bean.ConditionPlateCostMonthlyDetail;

public class QueryPlateCostMonthlyDetail extends AbstractQuery<BasePlateCostMonthlyDetail, ConditionPlateCostMonthlyDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateCostMonthlyDetail.class);

	public QueryPlateCostMonthlyDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BasePlateCostMonthlyDetail> executeQuery( KeyValuePair[] replacements, ConditionPlateCostMonthlyDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BasePlateCostMonthlyDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateCostMonthlyDetail __base = new BasePlateCostMonthlyDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.plate_id, a.record_date, a.integral, a.remark, b.process_id, b.process_instance_id, b.process_type, b.business_id from plate_account_records a LEFT JOIN plate_cost_records b on a.business_id = b.plate_cost_record_id where a.business_type_id = 7 and a.plate_id = ? and extract(year from a.record_date) = ? and extract(month from a.record_date) = ? ORDER BY a.record_date" ;
	private final static String RESULTSETFIELDLIST = "plate_id,record_date,integral,remark,process_id,process_instance_id,process_type,business_id";
	private final static String[] fieldNames = { "plate_id", "year", "month"};
}
