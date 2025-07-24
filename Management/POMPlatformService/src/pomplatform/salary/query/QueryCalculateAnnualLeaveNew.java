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
import pomplatform.salary.bean.BaseCalculateAnnualLeaveNew;
import pomplatform.salary.bean.ConditionCalculateAnnualLeaveNew;

public class QueryCalculateAnnualLeaveNew extends AbstractQuery<BaseCalculateAnnualLeaveNew, ConditionCalculateAnnualLeaveNew>
{

	private static final Logger __logger = Logger.getLogger(QueryCalculateAnnualLeaveNew.class);

	public QueryCalculateAnnualLeaveNew() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_name");
	}

	public static BaseCalculateAnnualLeaveNew selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseCalculateAnnualLeaveNew> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCalculateAnnualLeaveNew selectOne(ConditionCalculateAnnualLeaveNew c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseCalculateAnnualLeaveNew> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseCalculateAnnualLeaveNew> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseCalculateAnnualLeaveNew> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseCalculateAnnualLeaveNew> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionCalculateAnnualLeaveNew c = new ConditionCalculateAnnualLeaveNew();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryCalculateAnnualLeaveNew dao = new QueryCalculateAnnualLeaveNew();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseCalculateAnnualLeaveNew> select(ConditionCalculateAnnualLeaveNew c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QueryCalculateAnnualLeaveNew dao = new QueryCalculateAnnualLeaveNew();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseCalculateAnnualLeaveNew> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseCalculateAnnualLeaveNew> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseCalculateAnnualLeaveNew> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionCalculateAnnualLeaveNew c = new ConditionCalculateAnnualLeaveNew();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryCalculateAnnualLeaveNew dao = new QueryCalculateAnnualLeaveNew();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseCalculateAnnualLeaveNew> executeQuery( KeyValuePair[] replacements, ConditionCalculateAnnualLeaveNew condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getEmployeeNo()
			);
	}

	public BaseCollection<BaseCalculateAnnualLeaveNew> runQuery( KeyValuePair[] replacements, ConditionCalculateAnnualLeaveNew condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getYear(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getEmployeeNo()
			);
	}

	public BaseCollection<BaseCalculateAnnualLeaveNew> execute( KeyValuePair[] replacements, ConditionCalculateAnnualLeaveNew condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getYear(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getEmployeeNo()
			);
	}

	@Override
	public BaseCalculateAnnualLeaveNew generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCalculateAnnualLeaveNew __base = new BaseCalculateAnnualLeaveNew();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCurrentYearTotalAnnualLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentYearUsageAmountAnnual(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRemainingAmountAnnual(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentYearTotalWealfareLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentYearUsageAmountWealfare(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRemainingAmountWealfare(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastYearTotalAnnualLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastYearUsageAmountAnnual(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastRemainingAmountAnnual(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastYearTotalWealfareLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastYearUsageAmountWealfare(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastRemainingAmountWealfare(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastRemainingLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentYearLeave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentYearUsedtime(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemainingOvertime(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUsed(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOvertimeHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUsedY(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOvertimeHoursY(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	public final static String __SQLText = "SELECT e.employee_name,e.employee_no,d.department_name ,COALESCE(a.total_annual_leave,0.0) AS current_year_total_annual_leave ,COALESCE(a.usage_amount_annual,0.0) AS current_year_usage_amount_annual ,COALESCE(a.total_annual_leave,0.0)-COALESCE(a.usage_amount_annual,0.0) AS current_remaining_amount_annual ,COALESCE(a.total_wealfare_leave,0.0) AS current_year_total_wealfare_leave ,COALESCE(a.usage_amount_wealfare,0.0) AS current_year_usage_amount_wealfare ,COALESCE(a.total_wealfare_leave,0.0)-COALESCE(a.usage_amount_wealfare,0.0) AS current_remaining_amount_wealfare ,COALESCE(aa.total_annual_leave,0.0) AS last_year_total_annual_leave ,COALESCE(aa.usage_amount_annual,0.0) AS last_year_usage_amount_annual ,COALESCE(aa.total_annual_leave,0.0)-COALESCE(aa.usage_amount_annual,0.0) AS last_remaining_amount_annual ,COALESCE(aa.total_wealfare_leave,0.0) AS last_year_total_wealfare_leave ,COALESCE(aa.usage_amount_wealfare,0.0) AS last_year_usage_amount_wealfare ,COALESCE(aa.total_wealfare_leave,0.0)-COALESCE(aa.usage_amount_wealfare,0.0) AS last_remaining_amount_wealfare ,0.0 AS last_remaining_leave,0.0 AS current_year_leave,0.0 AS current_year_usedtime,0.0 AS remaining_overtime ,o.used,o.overtime_hours,o_y.used_y,o_y.overtime_hours_y ,e.employee_id,e.department_id,e.plate_id,a.year FROM employees e LEFT JOIN departments d ON e.department_id = d.department_id LEFT JOIN annual_leaves a ON a.employee_id = e.employee_id and a.year = ? LEFT JOIN annual_leaves aa ON aa.employee_id = e.employee_id AND aa.year = a.year-1 LEFT JOIN ( SELECT employee_id,sum(adjust) AS used,sum(COALESCE(nornal_overtime_hours,0.0)+COALESCE(weekend_overtime_hours,0.0)+COALESCE(holiday_overtime_hours,0.0)) AS overtime_hours FROM employee_month_checks GROUP BY employee_id ) o ON e.employee_id = o.employee_id LEFT JOIN ( SELECT employee_id,year,sum(adjust) AS used_y,sum(COALESCE(nornal_overtime_hours,0.0)+COALESCE(weekend_overtime_hours,0.0)+COALESCE(holiday_overtime_hours,0.0)) AS overtime_hours_y FROM employee_month_checks GROUP BY employee_id,year ) o_y ON e.employee_id = o_y.employee_id AND a.year = o_y.year WHERE e.employee_id = ? and e.employee_name LIKE ? and d.department_id = ? and e.employee_no LIKE ? and e.status = 0" ;
	public final static String __originalSQL = "SELECT e.employee_name,e.employee_no,d.department_name ,COALESCE(a.total_annual_leave,0.0) AS current_year_total_annual_leave ,COALESCE(a.usage_amount_annual,0.0) AS current_year_usage_amount_annual ,COALESCE(a.total_annual_leave,0.0)-COALESCE(a.usage_amount_annual,0.0) AS current_remaining_amount_annual ,COALESCE(a.total_wealfare_leave,0.0) AS current_year_total_wealfare_leave ,COALESCE(a.usage_amount_wealfare,0.0) AS current_year_usage_amount_wealfare ,COALESCE(a.total_wealfare_leave,0.0)-COALESCE(a.usage_amount_wealfare,0.0) AS current_remaining_amount_wealfare ,COALESCE(aa.total_annual_leave,0.0) AS last_year_total_annual_leave ,COALESCE(aa.usage_amount_annual,0.0) AS last_year_usage_amount_annual ,COALESCE(aa.total_annual_leave,0.0)-COALESCE(aa.usage_amount_annual,0.0) AS last_remaining_amount_annual ,COALESCE(aa.total_wealfare_leave,0.0) AS last_year_total_wealfare_leave ,COALESCE(aa.usage_amount_wealfare,0.0) AS last_year_usage_amount_wealfare ,COALESCE(aa.total_wealfare_leave,0.0)-COALESCE(aa.usage_amount_wealfare,0.0) AS last_remaining_amount_wealfare ,0.0 AS last_remaining_leave,0.0 AS current_year_leave,0.0 AS current_year_usedtime,0.0 AS remaining_overtime ,o.used,o.overtime_hours,o_y.used_y,o_y.overtime_hours_y ,e.employee_id,e.department_id,e.plate_id,a.year FROM employees e LEFT JOIN departments d ON e.department_id = d.department_id LEFT JOIN annual_leaves a ON a.employee_id = e.employee_id AND a.year = :year LEFT JOIN annual_leaves aa ON aa.employee_id = e.employee_id AND aa.year = a.year-1 LEFT JOIN ( SELECT employee_id,sum(adjust) AS used,sum(COALESCE(nornal_overtime_hours,0.0)+COALESCE(weekend_overtime_hours,0.0)+COALESCE(holiday_overtime_hours,0.0)) AS overtime_hours FROM employee_month_checks GROUP BY employee_id ) o ON e.employee_id = o.employee_id LEFT JOIN ( SELECT employee_id,year,sum(adjust) AS used_y,sum(COALESCE(nornal_overtime_hours,0.0)+COALESCE(weekend_overtime_hours,0.0)+COALESCE(holiday_overtime_hours,0.0)) AS overtime_hours_y FROM employee_month_checks GROUP BY employee_id,year ) o_y ON e.employee_id = o_y.employee_id AND a.year = o_y.year WHERE e.employee_id = :employee_id AND e.employee_name like :employee_name AND d.department_id =:department_id AND e.employee_no like :employee_no AND e.status = 0";
	private final static String RESULTSETFIELDLIST = "employee_name,employee_no,department_name,current_year_total_annual_leave,current_year_usage_amount_annual,current_remaining_amount_annual,current_year_total_wealfare_leave,current_year_usage_amount_wealfare,current_remaining_amount_wealfare,last_year_total_annual_leave,last_year_usage_amount_annual,last_remaining_amount_annual,last_year_total_wealfare_leave,last_year_usage_amount_wealfare,last_remaining_amount_wealfare,last_remaining_leave,current_year_leave,current_year_usedtime,remaining_overtime,used,overtime_hours,used_y,overtime_hours_y,employee_id,department_id,plate_id,year";
	private final static String[] fieldNames = { "year", "employee_id", "employee_name", "department_id", "employee_no"};
}
