package pomplatform.salaryemployeeevaluationrmmor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salaryemployeeevaluationrmmor.bean.BaseSsalaryemployeeevaluationrmmor;
import pomplatform.salaryemployeeevaluationrmmor.bean.ConditionSsalaryemployeeevaluationrmmor;

public class QuerySsalaryemployeeevaluationrmmor extends AbstractQuery<BaseSsalaryemployeeevaluationrmmor, ConditionSsalaryemployeeevaluationrmmor>
{

	private static final Logger __logger = Logger.getLogger(QuerySsalaryemployeeevaluationrmmor.class);

	public QuerySsalaryemployeeevaluationrmmor() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("see.salary_employee_evaluation_id");
	}

	@Override
	public BaseCollection<BaseSsalaryemployeeevaluationrmmor> executeQuery( KeyValuePair[] replacements, ConditionSsalaryemployeeevaluationrmmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRemark(), 
				condition.getMinOperateTime(), 
				condition.getMaxOperateTime(), 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate(), 
				condition.getSalaryEmployeeEvaluationId(), 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getGrade(), 
				condition.getOperateEmployeeId()
			);
	}

	@Override
	public BaseSsalaryemployeeevaluationrmmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSsalaryemployeeevaluationrmmor __base = new BaseSsalaryemployeeevaluationrmmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSalaryEmployeeEvaluationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGrade(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
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

	private final static String __SQLText = "select see.salary_employee_evaluation_id, see.employee_id, see.year, see.month, see.grade, see.happen_date, see.operate_employee_id, see.operate_time, see.remark from salary_employee_evaluation see where see.remark like ? and see.operate_time between ? and ? and see.happen_date between ? and ? and see.salary_employee_evaluation_id = ? and see.employee_id = ? and see.year = ? and see.month = ? and see.grade = ? and see.operate_employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "salary_employee_evaluation_id,employee_id,year,month,grade,happen_date,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "remark", "min_operate_time", "max_operate_time", "min_happen_date", "max_happen_date", "salary_employee_evaluation_id", "employee_id", "year", "month", "grade", "operate_employee_id"};
}
