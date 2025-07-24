package pomplatform.salary.query;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.List;
import delicacy.common.CommonUtils;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salary.bean.BaseRepeatAnnualLeave;
import pomplatform.salary.bean.ConditionRepeatAnnualLeave;

public class QueryRepeatAnnualLeave extends AbstractQuery<BaseRepeatAnnualLeave, ConditionRepeatAnnualLeave>
{

	private static final Logger __logger = Logger.getLogger(QueryRepeatAnnualLeave.class);

	public QueryRepeatAnnualLeave() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	public static BaseRepeatAnnualLeave selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseRepeatAnnualLeave> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseRepeatAnnualLeave selectOne(ConditionRepeatAnnualLeave c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseRepeatAnnualLeave> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseRepeatAnnualLeave> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseRepeatAnnualLeave> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseRepeatAnnualLeave> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionRepeatAnnualLeave c = new ConditionRepeatAnnualLeave();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryRepeatAnnualLeave dao = new QueryRepeatAnnualLeave();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseRepeatAnnualLeave> select(ConditionRepeatAnnualLeave c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QueryRepeatAnnualLeave dao = new QueryRepeatAnnualLeave();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseRepeatAnnualLeave> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseRepeatAnnualLeave> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseRepeatAnnualLeave> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionRepeatAnnualLeave c = new ConditionRepeatAnnualLeave();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryRepeatAnnualLeave dao = new QueryRepeatAnnualLeave();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseRepeatAnnualLeave> executeQuery( KeyValuePair[] replacements, ConditionRepeatAnnualLeave condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements
			);
	}

	public BaseCollection<BaseRepeatAnnualLeave> runQuery( KeyValuePair[] replacements, ConditionRepeatAnnualLeave condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements
			);
	}

	public BaseCollection<BaseRepeatAnnualLeave> execute( KeyValuePair[] replacements, ConditionRepeatAnnualLeave condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements
			);
	}

	@Override
	public BaseRepeatAnnualLeave generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRepeatAnnualLeave __base = new BaseRepeatAnnualLeave();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setId(GenericBase.__getInt(val));
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
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	public final static String __SQLText = "SELECT employee_id,year,count(employee_id) as num,min(annual_leave_id) AS id FROM annual_leaves GROUP BY employee_id,year HAVING count(employee_id) > 1" ;
	public final static String __originalSQL = "SELECT employee_id,year,count(employee_id) as num,min(annual_leave_id) AS id FROM annual_leaves GROUP BY employee_id,year HAVING count(employee_id) > 1";
	private final static String RESULTSETFIELDLIST = "employee_id,year,num,id";
	private final static String[] fieldNames = { };
}
