package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseEmployeeStructureOverview2;
import pomplatform.report.bean.ConditionEmployeeStructureOverview2;

public class QueryEmployeeStructureOverview2 extends AbstractQuery<BaseEmployeeStructureOverview2, ConditionEmployeeStructureOverview2>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeStructureOverview2.class);

	public QueryEmployeeStructureOverview2() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .YEAR");
	}

	@Override
	public BaseCollection<BaseEmployeeStructureOverview2> executeQuery( KeyValuePair[] replacements, ConditionEmployeeStructureOverview2 condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getStartYear(), 
				condition.getEndYear()
			);
	}

	public BaseCollection<BaseEmployeeStructureOverview2> runQuery( KeyValuePair[] replacements, ConditionEmployeeStructureOverview2 condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getStartYear(), 
				condition.getEndYear()
			);
	}

	public BaseCollection<BaseEmployeeStructureOverview2> execute( KeyValuePair[] replacements, ConditionEmployeeStructureOverview2 condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getStartYear(), 
				condition.getEndYear()
			);
	}

	@Override
	public BaseEmployeeStructureOverview2 generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeStructureOverview2 __base = new BaseEmployeeStructureOverview2();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setEmpNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotalNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "SELECT A .YEAR, A.emp_num, b.total_num, CASE WHEN COALESCE ( b.total_num, 0 ) > 0 THEN round( COALESCE ( A.emp_num, 0.0 ) / b.total_num * 100, 2 ) ELSE 0.0 END AS percent FROM ( SELECT EXTRACT ( YEAR FROM e.onboard_date ) AS YEAR, COUNT ( e.employee_id ) AS emp_num FROM employees e WHERE EXTRACT ( YEAR FROM e.onboard_date ) = EXTRACT ( YEAR FROM e.start_work_date ) GROUP BY EXTRACT ( YEAR FROM e.onboard_date ) ) A LEFT JOIN ( SELECT COUNT ( employee_id ) AS total_num FROM employees WHERE status = 0 and employee_id > 0) b ON 1 = 1 WHERE A.YEAR between ? and ? ORDER BY A.YEAR" ;
	private final static String __originalSQL = "SELECT A .YEAR, A.emp_num, b.total_num, CASE WHEN COALESCE ( b.total_num, 0 ) > 0 THEN round( COALESCE ( A.emp_num, 0.0 ) / b.total_num * 100, 2 ) ELSE 0.0 END AS percent FROM ( SELECT EXTRACT ( YEAR FROM e.onboard_date ) AS YEAR, COUNT ( e.employee_id ) AS emp_num FROM employees e WHERE EXTRACT ( YEAR FROM e.onboard_date ) = EXTRACT ( YEAR FROM e.start_work_date ) GROUP BY EXTRACT ( YEAR FROM e.onboard_date ) ) A LEFT JOIN ( SELECT COUNT ( employee_id ) AS total_num FROM employees WHERE status = 0 and employee_id > 0) b ON 1 = 1 WHERE A.YEAR BETWEEN :start_year AND :end_year ORDER BY A.YEAR";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.YEAR BETWEEN :start_year AND :end_year\",\"startIndex\": 542,\"stopIndex\":581,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.YEAR BETWEEN :start_year AND :end_year\",\"fullFieldName\":\"A.YEAR\",\"operationName\":\"between\",\"variableName\":\"startYear\",\"secondName\":\"endYear\",\"startIndex\": 542,\"stopIndex\":581,\"variableNum\": 0,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "year,emp_num,total_num,percent";
	private final static String[] fieldNames = { "start_year", "end_year"};
}
