package pomplatform.sProjectEmployeeAdvanceRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sProjectEmployeeAdvanceRecord.bean.BaseSProjectEmployeeAdvanceRecordDetail;
import pomplatform.sProjectEmployeeAdvanceRecord.bean.ConditionSProjectEmployeeAdvanceRecordDetail;

public class QuerySProjectEmployeeAdvanceRecordDetail extends AbstractQuery<BaseSProjectEmployeeAdvanceRecordDetail, ConditionSProjectEmployeeAdvanceRecordDetail>
{

	private static final Logger __logger = Logger.getLogger(QuerySProjectEmployeeAdvanceRecordDetail.class);

	public QuerySProjectEmployeeAdvanceRecordDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseSProjectEmployeeAdvanceRecordDetail> executeQuery( KeyValuePair[] replacements, ConditionSProjectEmployeeAdvanceRecordDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getAdvanceYear(), 
				condition.getAdvanceMonth()
			);
	}

	@Override
	public BaseSProjectEmployeeAdvanceRecordDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSProjectEmployeeAdvanceRecordDetail __base = new BaseSProjectEmployeeAdvanceRecordDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdvancedIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.employee_id, a.project_id, a.advanced_integral, a.advance_date, a.operate_employee_id, a.remark FROM project_employee_advance_records a WHERE a.employee_id = ? AND extract(year from a.advance_date) = ? AND extract(month from a.advance_date) = ? ORDER BY a.advance_date" ;
	private final static String RESULTSETFIELDLIST = "employee_id,project_id,advanced_integral,advance_date,operate_employee_id,remark";
	private final static String[] fieldNames = { "employee_id", "advance_year", "advance_month"};
}
