package pomplatform.sProjectAdvanceRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sProjectAdvanceRecord.bean.BaseSProjectAdvanceRecord;
import pomplatform.sProjectAdvanceRecord.bean.ConditionSProjectAdvanceRecord;

public class QuerySProjectAdvanceRecord extends AbstractQuery<BaseSProjectAdvanceRecord, ConditionSProjectAdvanceRecord>
{

	private static final Logger __logger = Logger.getLogger(QuerySProjectAdvanceRecord.class);

	public QuerySProjectAdvanceRecord() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseSProjectAdvanceRecord> executeQuery( KeyValuePair[] replacements, ConditionSProjectAdvanceRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getAdvanceYear(), 
				condition.getAdvanceMonth()
			);
	}

	@Override
	public BaseSProjectAdvanceRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSProjectAdvanceRecord __base = new BaseSProjectAdvanceRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.plate_id, a.project_id, a.advance_integral, a.left_integral, a.advance_date, a.operate_employee_id, a.remark FROM project_advance_records a WHERE a.plate_id = ? AND extract(year from a.advance_date) = ? AND extract(month from a.advance_date) = ? ORDER BY a.advance_date" ;
	private final static String RESULTSETFIELDLIST = "plate_id,project_id,advance_integral,left_integral,advance_date,operate_employee_id,remark";
	private final static String[] fieldNames = { "plate_id", "advance_year", "advance_month"};
}
