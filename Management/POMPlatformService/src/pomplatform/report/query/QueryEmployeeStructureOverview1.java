package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseEmployeeStructureOverview1;
import pomplatform.report.bean.ConditionEmployeeStructureOverview1;

public class QueryEmployeeStructureOverview1 extends AbstractQuery<BaseEmployeeStructureOverview1, ConditionEmployeeStructureOverview1>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeStructureOverview1.class);

	public QueryEmployeeStructureOverview1() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.a");
	}

	@Override
	public BaseCollection<BaseEmployeeStructureOverview1> executeQuery( KeyValuePair[] replacements, ConditionEmployeeStructureOverview1 condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements
			);
	}

	public BaseCollection<BaseEmployeeStructureOverview1> runQuery( KeyValuePair[] replacements, ConditionEmployeeStructureOverview1 condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements
			);
	}

	public BaseCollection<BaseEmployeeStructureOverview1> execute( KeyValuePair[] replacements, ConditionEmployeeStructureOverview1 condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements
			);
	}

	@Override
	public BaseEmployeeStructureOverview1 generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeStructureOverview1 __base = new BaseEmployeeStructureOverview1();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setA(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setB(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setA1(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRound(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT aa.a, aa.b, count(aa.a) AS a_1, round(((count(aa.a))::numeric / (( SELECT count(0) AS a_1 FROM employees WHERE ((employees.status = 0) AND (employees.employee_id > 0))))::numeric), 2) AS round FROM ( SELECT sd.dic_type_value_id AS a, sd.dic_type_value AS b FROM (employees e LEFT JOIN system_dictionary sd ON (((sd.dic_type_value_id = e.grade_id) AND (sd.dic_type_id = 3)))) WHERE ((e.status = 0) AND (e.employee_id > 0))) aa GROUP BY aa.a, aa.b ORDER BY aa.a" ;
	private final static String __originalSQL = "SELECT aa.a, aa.b, count(aa.a) AS a_1, round(((count(aa.a))::numeric / (( SELECT count(0) AS a_1 FROM employees WHERE ((employees.status = 0) AND (employees.employee_id > 0))))::numeric), 2) AS round FROM ( SELECT sd.dic_type_value_id AS a, sd.dic_type_value AS b FROM (employees e LEFT JOIN system_dictionary sd ON (((sd.dic_type_value_id = e.grade_id) AND (sd.dic_type_id = 3)))) WHERE ((e.status = 0) AND (e.employee_id > 0))) aa GROUP BY aa.a, aa.b ORDER BY aa.a";
	private final static String[] __queryConditions = new String[0];
	private final static String RESULTSETFIELDLIST = "a,b,a_1,round";
	private final static String[] fieldNames = { };
}
