package pomplatform.plateIntegralTransferRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateIntegralTransferRecord.bean.BaseSplateIntegralTransferRecord;
import pomplatform.plateIntegralTransferRecord.bean.ConditionSplateIntegralTransferRecord;

public class QuerySplateIntegralTransferRecord extends AbstractQuery<BaseSplateIntegralTransferRecord, ConditionSplateIntegralTransferRecord>
{

	private static final Logger __logger = Logger.getLogger(QuerySplateIntegralTransferRecord.class);

	public QuerySplateIntegralTransferRecord() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pitr.plate_integral_transfer_record_id");
	}

	@Override
	public BaseCollection<BaseSplateIntegralTransferRecord> executeQuery( KeyValuePair[] replacements, ConditionSplateIntegralTransferRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseSplateIntegralTransferRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSplateIntegralTransferRecord __base = new BaseSplateIntegralTransferRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateIntegralTransferRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFromPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setToPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTransferIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTransferDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select pitr.plate_integral_transfer_record_id, pitr.from_plate_id, pitr.to_plate_id, pitr.transfer_integral, pitr.transfer_date, pitr.plate_employee_id, pitr.remark from plate_integral_transfer_records pitr where (pitr.from_plate_id = ? or pitr.to_plate_id = ? ) order by pitr.transfer_date desc" ;
	private final static String RESULTSETFIELDLIST = "plate_integral_transfer_record_id,from_plate_id,to_plate_id,transfer_integral,transfer_date,plate_employee_id,remark";
	private final static String[] fieldNames = { "plate_id", "plate_id"};
}
