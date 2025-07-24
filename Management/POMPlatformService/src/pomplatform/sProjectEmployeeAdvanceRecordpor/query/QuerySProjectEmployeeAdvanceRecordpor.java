package pomplatform.sProjectEmployeeAdvanceRecordpor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sProjectEmployeeAdvanceRecordpor.bean.BaseSProjectEmployeeAdvanceRecordpor;
import pomplatform.sProjectEmployeeAdvanceRecordpor.bean.ConditionSProjectEmployeeAdvanceRecordpor;

public class QuerySProjectEmployeeAdvanceRecordpor extends AbstractQuery<BaseSProjectEmployeeAdvanceRecordpor, ConditionSProjectEmployeeAdvanceRecordpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySProjectEmployeeAdvanceRecordpor.class);

	public QuerySProjectEmployeeAdvanceRecordpor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseSProjectEmployeeAdvanceRecordpor> executeQuery( KeyValuePair[] replacements, ConditionSProjectEmployeeAdvanceRecordpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseSProjectEmployeeAdvanceRecordpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSProjectEmployeeAdvanceRecordpor __base = new BaseSProjectEmployeeAdvanceRecordpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.project_id, a.employee_id, sum(advanced_integral) as advance_integral from project_employee_advance_records a WHERE a.project_id = ? GROUP BY a.project_id, a.employee_id ORDER BY a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "project_id,employee_id,advance_integral";
	private final static String[] fieldNames = { "project_id"};
}
