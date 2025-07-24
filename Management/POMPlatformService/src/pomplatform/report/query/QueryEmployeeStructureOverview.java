package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseEmployeeStructureOverview;
import pomplatform.report.bean.ConditionEmployeeStructureOverview;

public class QueryEmployeeStructureOverview extends AbstractQuery<BaseEmployeeStructureOverview, ConditionEmployeeStructureOverview>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeStructureOverview.class);

	public QueryEmployeeStructureOverview() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("0 as a");
	}

	@Override
	public BaseCollection<BaseEmployeeStructureOverview> executeQuery( KeyValuePair[] replacements, ConditionEmployeeStructureOverview condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements
			);
	}

	public BaseCollection<BaseEmployeeStructureOverview> runQuery( KeyValuePair[] replacements, ConditionEmployeeStructureOverview condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements
			);
	}

	public BaseCollection<BaseEmployeeStructureOverview> execute( KeyValuePair[] replacements, ConditionEmployeeStructureOverview condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements
			);
	}

	@Override
	public BaseEmployeeStructureOverview generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeStructureOverview __base = new BaseEmployeeStructureOverview();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setA(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select 0 as a,count(0) as a_1,1 as round from employees where status = 0 and employee_id>0 union select * from gender_view union select * from political_view union select * from birth_view union select * from start_work_view union select * from onboard_view union select * from education_view order by a" ;
	private final static String __originalSQL = "select 0 as a,count(0) as a_1,1 as round from employees where status = 0 and employee_id>0 union select * from gender_view union select * from political_view union select * from birth_view union select * from start_work_view union select * from onboard_view union select * from education_view order by a";
	private final static String[] __queryConditions = new String[0];
	private final static String RESULTSETFIELDLIST = "a,a_1,round";
	private final static String[] fieldNames = { };
}
