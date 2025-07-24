package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportProjectWorkTimeDetail;
import pomplatform.report.bean.ConditionReportProjectWorkTimeDetail;

public class QueryReportProjectWorkTimeDetail extends AbstractQuery<BaseReportProjectWorkTimeDetail, ConditionReportProjectWorkTimeDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryReportProjectWorkTimeDetail.class);

	public QueryReportProjectWorkTimeDetail() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.project_id");
	}

	@Override
	public BaseCollection<BaseReportProjectWorkTimeDetail> executeQuery( KeyValuePair[] replacements, ConditionReportProjectWorkTimeDetail condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseReportProjectWorkTimeDetail> runQuery( KeyValuePair[] replacements, ConditionReportProjectWorkTimeDetail condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseReportProjectWorkTimeDetail> execute( KeyValuePair[] replacements, ConditionReportProjectWorkTimeDetail condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseReportProjectWorkTimeDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportProjectWorkTimeDetail __base = new BaseReportProjectWorkTimeDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWorkHour(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCoefficient(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatisticalWorkHour(GenericBase.__getDecimal(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT A.project_id, A.employee_id, A.employee_no, A.employee_name, A.plate_id, A.work_date, A.work_hour, A.coefficient, ( work_hour * coefficient ) AS statistical_work_hour FROM ( SELECT wh.project_id, wh.employee_id, wh.employee_no, wh.employee_name, wh.plate_id, wh.work_date, SUM ( work_hour ) AS work_hour, ( SELECT coefficient FROM rank_factor_maintenances WHERE rank_id = ( SELECT grade_id FROM employees WHERE employee_id = wh.employee_id )) AS coefficient FROM working_hours wh GROUP BY wh.project_id, wh.employee_id, wh.employee_no, wh.employee_name, wh.plate_id, wh.work_date ORDER BY wh.work_date DESC ) AS A WHERE A.project_id = ? GROUP BY A.project_id, A.employee_id, A.employee_no, A.employee_name, A.plate_id, A.work_date, A.work_hour, A.coefficient" ;
	private final static String __originalSQL = "SELECT A.project_id, A.employee_id, A.employee_no, A.employee_name, A.plate_id, A.work_date, A.work_hour, A.coefficient, ( work_hour * coefficient ) AS statistical_work_hour FROM ( SELECT wh.project_id, wh.employee_id, wh.employee_no, wh.employee_name, wh.plate_id, wh.work_date, SUM ( work_hour ) AS work_hour, ( SELECT coefficient FROM rank_factor_maintenances WHERE rank_id = ( SELECT grade_id FROM employees WHERE employee_id = wh.employee_id )) AS coefficient FROM working_hours wh GROUP BY wh.project_id, wh.employee_id, wh.employee_no, wh.employee_name, wh.plate_id, wh.work_date ORDER BY wh.work_date DESC ) AS A WHERE A.project_id =:project_id GROUP BY A.project_id, A.employee_id, A.employee_no, A.employee_name, A.plate_id, A.work_date, A.work_hour, A.coefficient";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.project_id =:project_id\",\"startIndex\": 627,\"stopIndex\":651,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.project_id =:project_id\",\"fullFieldName\":\"A.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 627,\"stopIndex\":651,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_id,employee_id,employee_no,employee_name,plate_id,work_date,work_hour,coefficient,statistical_work_hour";
	private final static String[] fieldNames = { "project_id"};
}
