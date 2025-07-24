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
import pomplatform.salary.bean.BaseCalculateAnnualLeave;
import pomplatform.salary.bean.ConditionCalculateAnnualLeave;

public class QueryCalculateAnnualLeave extends AbstractQuery<BaseCalculateAnnualLeave, ConditionCalculateAnnualLeave>
{

	private static final Logger __logger = Logger.getLogger(QueryCalculateAnnualLeave.class);

	public QueryCalculateAnnualLeave() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_no");
	}

	public static BaseCalculateAnnualLeave selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseCalculateAnnualLeave> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCalculateAnnualLeave selectOne(ConditionCalculateAnnualLeave c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseCalculateAnnualLeave> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseCalculateAnnualLeave> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseCalculateAnnualLeave> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseCalculateAnnualLeave> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionCalculateAnnualLeave c = new ConditionCalculateAnnualLeave();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryCalculateAnnualLeave dao = new QueryCalculateAnnualLeave();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseCalculateAnnualLeave> select(ConditionCalculateAnnualLeave c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QueryCalculateAnnualLeave dao = new QueryCalculateAnnualLeave();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseCalculateAnnualLeave> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseCalculateAnnualLeave> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseCalculateAnnualLeave> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionCalculateAnnualLeave c = new ConditionCalculateAnnualLeave();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryCalculateAnnualLeave dao = new QueryCalculateAnnualLeave();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseCalculateAnnualLeave> executeQuery( KeyValuePair[] replacements, ConditionCalculateAnnualLeave condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getCurrentRemainingAmountAnnual(), 
				condition.getCurrentRemainingAmountWealfare(), 
				condition.getLastRemainingAmountAnnual(), 
				condition.getLastRemainingAmountWealfare()
			);
	}

	public BaseCollection<BaseCalculateAnnualLeave> runQuery( KeyValuePair[] replacements, ConditionCalculateAnnualLeave condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getCurrentRemainingAmountAnnual(), 
				condition.getCurrentRemainingAmountWealfare(), 
				condition.getLastRemainingAmountAnnual(), 
				condition.getLastRemainingAmountWealfare()
			);
	}

	public BaseCollection<BaseCalculateAnnualLeave> execute( KeyValuePair[] replacements, ConditionCalculateAnnualLeave condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getCurrentRemainingAmountAnnual(), 
				condition.getCurrentRemainingAmountWealfare(), 
				condition.getLastRemainingAmountAnnual(), 
				condition.getLastRemainingAmountWealfare()
			);
	}

	@Override
	public BaseCalculateAnnualLeave generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCalculateAnnualLeave __base = new BaseCalculateAnnualLeave();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	public final static String __SQLText = "SELECT e.employee_no, e.employee_name, d.department_name, e.employee_id, e.department_id, cc.current_year_total_annual_leave, cc.current_year_usage_amount_annual, cc.current_remaining_amount_annual, cc.current_year_total_wealfare_leave, cc.current_year_usage_amount_wealfare, current_remaining_amount_wealfare, cc.last_year_total_annual_leave, cc.last_year_usage_amount_annual, last_remaining_amount_annual, cc.last_year_total_wealfare_leave, cc.last_year_usage_amount_wealfare, last_remaining_amount_wealfare, ( CASE WHEN swc.last_remaining_leave IS NULL THEN 0 ELSE swc.last_remaining_leave END ), ( CASE WHEN swc.current_year_leave IS NULL THEN 0 ELSE swc.current_year_leave END ), ( CASE WHEN swc.current_year_usedtime IS NULL THEN 0 ELSE swc.current_year_usedtime END ), ( CASE WHEN ttt.aa IS NULL THEN 0 ELSE ttt.aa END ) AS remaining_overtime FROM ( SELECT A .employee_id AS employee_id, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.total_annual_leave ELSE 0 END ) AS current_year_total_annual_leave, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.usage_amount_annual ELSE 0 END ) AS current_year_usage_amount_annual, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.total_annual_leave ELSE 0 END ) - SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.usage_amount_annual ELSE 0 END ) AS current_remaining_amount_annual, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.total_wealfare_leave ELSE 0 END ) AS current_year_total_wealfare_leave, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.usage_amount_wealfare ELSE 0 END ) AS current_year_usage_amount_wealfare, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.total_wealfare_leave ELSE 0 END ) - SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.usage_amount_wealfare ELSE 0 END ) AS current_remaining_amount_wealfare, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.total_annual_leave ELSE 0 END ) AS last_year_total_annual_leave, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.usage_amount_annual ELSE 0 END ) AS last_year_usage_amount_annual, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.total_annual_leave ELSE 0 END ) - SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.usage_amount_annual ELSE 0 END ) AS last_remaining_amount_annual, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.total_wealfare_leave ELSE 0 END ) AS last_year_total_wealfare_leave, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.usage_amount_wealfare ELSE 0 END ) AS last_year_usage_amount_wealfare, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.total_wealfare_leave ELSE 0 END ) - SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.usage_amount_wealfare ELSE 0 END ) AS last_remaining_amount_wealfare FROM annual_leaves A GROUP BY A.employee_id ORDER BY A.employee_id ) AS cc RIGHT JOIN employees e ON cc.employee_id = e.employee_id LEFT JOIN departments d ON e.department_id = d.department_id LEFT JOIN ( SELECT overtime.employee_id, overtime.overtimeHours - ( CASE WHEN usedtime IS NULL THEN 0 ELSE usedtime END ) AS aa FROM ( SELECT employee_id, SUM ( nornal_overtime_hours ) + SUM ( weekend_overtime_hours ) + SUM ( holiday_overtime_hours ) AS overtimeHours FROM employee_month_checks GROUP BY employee_id ) AS overtime INNER JOIN employees ON plate_id IN ( 56, 57, 58 ) AND employees.employee_id = overtime.employee_id LEFT JOIN ( SELECT A .employee_id, SUM ( A.used ) AS usedtime FROM ( SELECT personnel_business_id, employee_id, SUM ( days * 7 ) + SUM ( hours ) AS used FROM personnel_business WHERE process_type = 13 AND TYPE = 21 AND delete_flag = 0 GROUP BY employee_id, personnel_business_id ) AS A LEFT JOIN system_process_instances spi ON spi.business_id = A.personnel_business_id AND spi.process_type = 13 WHERE spi.process_status IN ( 0, 1, 3, 4 ) GROUP BY A.employee_id ) AS use ON overtime.employee_id = use.employee_id UNION SELECT overtime.employee_id, overtime.overtimeHours - ( CASE WHEN usedtime IS NULL THEN 0 ELSE usedtime END ) AS aa FROM ( SELECT employee_id, SUM ( nornal_overtime_hours ) + SUM ( weekend_overtime_hours ) + SUM ( holiday_overtime_hours ) AS overtimeHours FROM employee_month_checks emc WHERE ( emc.MONTH = EXTRACT ( MONTH FROM CURRENT_DATE ) AND emc.YEAR = EXTRACT ( YEAR FROM CURRENT_DATE ) ) OR ( emc.MONTH = ( CASE WHEN EXTRACT ( MONTH FROM CURRENT_DATE ) = 1 THEN 12 ELSE EXTRACT ( MONTH FROM CURRENT_DATE ) - 1 END ) AND emc.YEAR = ( CASE WHEN EXTRACT ( MONTH FROM CURRENT_DATE ) = 1 THEN EXTRACT ( YEAR FROM CURRENT_DATE ) - 1 ELSE EXTRACT ( YEAR FROM CURRENT_DATE ) END ) ) GROUP BY employee_id ) AS overtime INNER JOIN employees ON plate_id NOT IN ( 56, 57, 58 ) AND employees.employee_id = overtime.employee_id LEFT JOIN ( SELECT employee_id, CASE WHEN SUM ( total_compensatory_leave ) IS NULL THEN 0 ELSE SUM ( total_compensatory_leave ) END AS usedtime FROM compensatory_leaves cl WHERE ( cl.MONTH = EXTRACT ( MONTH FROM CURRENT_DATE ) AND cl.YEAR = EXTRACT ( YEAR FROM CURRENT_DATE ) ) OR ( cl.MONTH = ( CASE WHEN EXTRACT ( MONTH FROM CURRENT_DATE ) = 1 THEN 12 ELSE EXTRACT ( MONTH FROM CURRENT_DATE ) - 1 END ) AND cl.YEAR = ( CASE WHEN EXTRACT ( MONTH FROM CURRENT_DATE ) = 1 THEN EXTRACT ( YEAR FROM CURRENT_DATE ) - 1 ELSE EXTRACT ( YEAR FROM CURRENT_DATE ) END ) ) AND status = 1 GROUP BY employee_id ) AS use ON overtime.employee_id = use.employee_id ) AS ttt ON ttt.employee_id = e.employee_id LEFT JOIN ( SELECT overtime.employee_id, SUM ( CASE WHEN overtime.YEAR != CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN overtime.overtimeHours ELSE 0 END ) - ( CASE WHEN lastuse.usedtime IS NULL THEN 0 ELSE lastuse.usedtime END ) AS last_remaining_leave, SUM ( CASE WHEN overtime.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN overtime.overtimeHours ELSE 0 END ) AS current_year_leave, use.usedtime AS current_year_usedtime FROM ( SELECT employee_id, SUM ( nornal_overtime_hours ) + SUM ( weekend_overtime_hours ) + SUM ( holiday_overtime_hours ) AS overtimeHours, YEAR FROM employee_month_checks GROUP BY employee_id, YEAR ) AS overtime INNER JOIN employees ON plate_id IN ( 56, 57, 58 ) AND employees.employee_id = overtime.employee_id LEFT JOIN ( SELECT A .employee_id, SUM ( A.used ) AS usedtime, A.yy FROM ( SELECT personnel_business_id, employee_id, SUM ( days * 7 ) + SUM ( hours ) AS used, EXTRACT ( YEAR FROM start_date ) AS yy FROM personnel_business WHERE process_type = 13 AND TYPE = 21 AND delete_flag = 0 AND EXTRACT ( YEAR FROM start_date ) = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) GROUP BY employee_id, yy, personnel_business_id ) AS A LEFT JOIN system_process_instances spi ON spi.business_id = A.personnel_business_id AND spi.process_type = 13 WHERE spi.process_status IN ( 0, 1, 3, 4 ) GROUP BY A.employee_id, A.yy ) AS use ON overtime.employee_id = use.employee_id LEFT JOIN ( SELECT A .employee_id, SUM ( A.used ) AS usedtime, A.yy FROM ( SELECT personnel_business_id, employee_id, SUM ( days * 7 ) + SUM ( hours ) AS used, EXTRACT ( YEAR FROM start_date ) AS yy FROM personnel_business WHERE process_type = 13 AND TYPE = 21 AND delete_flag = 0 AND EXTRACT ( YEAR FROM start_date ) != CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) GROUP BY employee_id, yy, personnel_business_id ) AS A LEFT JOIN system_process_instances spi ON spi.business_id = A.personnel_business_id AND spi.process_type = 13 WHERE spi.process_status IN ( 0, 1, 3, 4 ) GROUP BY A.employee_id, A.yy ) AS lastuse ON overtime.employee_id = lastuse.employee_id GROUP BY overtime.employee_id, use.usedtime, lastuse.usedtime UNION SELECT overtime.employee_id, 0 AS last_remaining_leave, SUM ( CASE WHEN overtime.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN overtime.overtimeHours ELSE 0 END ) AS current_year_leave, CASE WHEN use.usedtime IS NULL THEN 0 ELSE use.usedtime END AS current_year_usedtime FROM ( SELECT employee_id, SUM ( nornal_overtime_hours ) + SUM ( weekend_overtime_hours ) + SUM ( holiday_overtime_hours ) AS overtimeHours, YEAR FROM employee_month_checks emc WHERE emc.YEAR = CAST ( to_char( CURRENT_DATE, 'yyyy' ) AS INTEGER ) GROUP BY employee_id, YEAR ) AS overtime INNER JOIN employees ON plate_id NOT IN ( 56, 57, 58 ) AND employees.employee_id = overtime.employee_id LEFT JOIN ( SELECT employee_id, SUM ( total_compensatory_leave ) AS usedtime FROM compensatory_leaves cl WHERE cl.YEAR = CAST ( to_char( CURRENT_DATE, 'yyyy' ) AS INTEGER ) AND status = 1 GROUP BY employee_id ) AS use ON overtime.employee_id = use.employee_id GROUP BY overtime.employee_id, use.usedtime ) AS swc ON swc.employee_id = e.employee_id WHERE e.employee_name LIKE ? and d.department_id = ? and current_remaining_amount_annual = ? and current_remaining_amount_wealfare = ? and last_remaining_amount_annual = ? and last_remaining_amount_wealfare = ? and e.status = 0" ;
	public final static String __originalSQL = "SELECT e.employee_no, e.employee_name, d.department_name, e.employee_id, e.department_id, cc.current_year_total_annual_leave, cc.current_year_usage_amount_annual, cc.current_remaining_amount_annual, cc.current_year_total_wealfare_leave, cc.current_year_usage_amount_wealfare, current_remaining_amount_wealfare, cc.last_year_total_annual_leave, cc.last_year_usage_amount_annual, last_remaining_amount_annual, cc.last_year_total_wealfare_leave, cc.last_year_usage_amount_wealfare, last_remaining_amount_wealfare, ( CASE WHEN swc.last_remaining_leave IS NULL THEN 0 ELSE swc.last_remaining_leave END ), ( CASE WHEN swc.current_year_leave IS NULL THEN 0 ELSE swc.current_year_leave END ), ( CASE WHEN swc.current_year_usedtime IS NULL THEN 0 ELSE swc.current_year_usedtime END ), ( CASE WHEN ttt.aa IS NULL THEN 0 ELSE ttt.aa END ) AS remaining_overtime FROM ( SELECT A .employee_id AS employee_id, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.total_annual_leave ELSE 0 END ) AS current_year_total_annual_leave, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.usage_amount_annual ELSE 0 END ) AS current_year_usage_amount_annual, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.total_annual_leave ELSE 0 END ) - SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.usage_amount_annual ELSE 0 END ) AS current_remaining_amount_annual, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.total_wealfare_leave ELSE 0 END ) AS current_year_total_wealfare_leave, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.usage_amount_wealfare ELSE 0 END ) AS current_year_usage_amount_wealfare, SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.total_wealfare_leave ELSE 0 END ) - SUM ( CASE WHEN A.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN A.usage_amount_wealfare ELSE 0 END ) AS current_remaining_amount_wealfare, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.total_annual_leave ELSE 0 END ) AS last_year_total_annual_leave, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.usage_amount_annual ELSE 0 END ) AS last_year_usage_amount_annual, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.total_annual_leave ELSE 0 END ) - SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.usage_amount_annual ELSE 0 END ) AS last_remaining_amount_annual, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.total_wealfare_leave ELSE 0 END ) AS last_year_total_wealfare_leave, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.usage_amount_wealfare ELSE 0 END ) AS last_year_usage_amount_wealfare, SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.total_wealfare_leave ELSE 0 END ) - SUM ( CASE WHEN A.YEAR = CAST ( to_char( ( SELECT now( ) :: TIMESTAMP + '-1 year' ), 'yyyy' ) AS INTEGER ) THEN A.usage_amount_wealfare ELSE 0 END ) AS last_remaining_amount_wealfare FROM annual_leaves A GROUP BY A.employee_id ORDER BY A.employee_id ) AS cc RIGHT JOIN employees e ON cc.employee_id = e.employee_id LEFT JOIN departments d ON e.department_id = d.department_id LEFT JOIN ( SELECT overtime.employee_id, overtime.overtimeHours - ( CASE WHEN usedtime IS NULL THEN 0 ELSE usedtime END ) AS aa FROM ( SELECT employee_id, SUM ( nornal_overtime_hours ) + SUM ( weekend_overtime_hours ) + SUM ( holiday_overtime_hours ) AS overtimeHours FROM employee_month_checks GROUP BY employee_id ) AS overtime INNER JOIN employees ON plate_id IN ( 56, 57, 58 ) AND employees.employee_id = overtime.employee_id LEFT JOIN ( SELECT A .employee_id, SUM ( A.used ) AS usedtime FROM ( SELECT personnel_business_id, employee_id, SUM ( days * 7 ) + SUM ( hours ) AS used FROM personnel_business WHERE process_type = 13 AND TYPE = 21 AND delete_flag = 0 GROUP BY employee_id, personnel_business_id ) AS A LEFT JOIN system_process_instances spi ON spi.business_id = A.personnel_business_id AND spi.process_type = 13 WHERE spi.process_status IN ( 0, 1, 3, 4 ) GROUP BY A.employee_id ) AS use ON overtime.employee_id = use.employee_id UNION SELECT overtime.employee_id, overtime.overtimeHours - ( CASE WHEN usedtime IS NULL THEN 0 ELSE usedtime END ) AS aa FROM ( SELECT employee_id, SUM ( nornal_overtime_hours ) + SUM ( weekend_overtime_hours ) + SUM ( holiday_overtime_hours ) AS overtimeHours FROM employee_month_checks emc WHERE ( emc.MONTH = EXTRACT ( MONTH FROM CURRENT_DATE ) AND emc.YEAR = EXTRACT ( YEAR FROM CURRENT_DATE ) ) OR ( emc.MONTH = ( CASE WHEN EXTRACT ( MONTH FROM CURRENT_DATE ) = 1 THEN 12 ELSE EXTRACT ( MONTH FROM CURRENT_DATE ) - 1 END ) AND emc.YEAR = ( CASE WHEN EXTRACT ( MONTH FROM CURRENT_DATE ) = 1 THEN EXTRACT ( YEAR FROM CURRENT_DATE ) - 1 ELSE EXTRACT ( YEAR FROM CURRENT_DATE ) END ) ) GROUP BY employee_id ) AS overtime INNER JOIN employees ON plate_id NOT IN ( 56, 57, 58 ) AND employees.employee_id = overtime.employee_id LEFT JOIN ( SELECT employee_id, CASE WHEN SUM ( total_compensatory_leave ) IS NULL THEN 0 ELSE SUM ( total_compensatory_leave ) END AS usedtime FROM compensatory_leaves cl WHERE ( cl.MONTH = EXTRACT ( MONTH FROM CURRENT_DATE ) AND cl.YEAR = EXTRACT ( YEAR FROM CURRENT_DATE ) ) OR ( cl.MONTH = ( CASE WHEN EXTRACT ( MONTH FROM CURRENT_DATE ) = 1 THEN 12 ELSE EXTRACT ( MONTH FROM CURRENT_DATE ) - 1 END ) AND cl.YEAR = ( CASE WHEN EXTRACT ( MONTH FROM CURRENT_DATE ) = 1 THEN EXTRACT ( YEAR FROM CURRENT_DATE ) - 1 ELSE EXTRACT ( YEAR FROM CURRENT_DATE ) END ) ) AND status = 1 GROUP BY employee_id ) AS use ON overtime.employee_id = use.employee_id ) AS ttt ON ttt.employee_id = e.employee_id LEFT JOIN ( SELECT overtime.employee_id, SUM ( CASE WHEN overtime.YEAR != CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN overtime.overtimeHours ELSE 0 END ) - ( CASE WHEN lastuse.usedtime IS NULL THEN 0 ELSE lastuse.usedtime END ) AS last_remaining_leave, SUM ( CASE WHEN overtime.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN overtime.overtimeHours ELSE 0 END ) AS current_year_leave, use.usedtime AS current_year_usedtime FROM ( SELECT employee_id, SUM ( nornal_overtime_hours ) + SUM ( weekend_overtime_hours ) + SUM ( holiday_overtime_hours ) AS overtimeHours, YEAR FROM employee_month_checks GROUP BY employee_id, YEAR ) AS overtime INNER JOIN employees ON plate_id IN ( 56, 57, 58 ) AND employees.employee_id = overtime.employee_id LEFT JOIN ( SELECT A .employee_id, SUM ( A.used ) AS usedtime, A.yy FROM ( SELECT personnel_business_id, employee_id, SUM ( days * 7 ) + SUM ( hours ) AS used, EXTRACT ( YEAR FROM start_date ) AS yy FROM personnel_business WHERE process_type = 13 AND TYPE = 21 AND delete_flag = 0 AND EXTRACT ( YEAR FROM start_date ) = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) GROUP BY employee_id, yy, personnel_business_id ) AS A LEFT JOIN system_process_instances spi ON spi.business_id = A.personnel_business_id AND spi.process_type = 13 WHERE spi.process_status IN ( 0, 1, 3, 4 ) GROUP BY A.employee_id, A.yy ) AS use ON overtime.employee_id = use.employee_id LEFT JOIN ( SELECT A .employee_id, SUM ( A.used ) AS usedtime, A.yy FROM ( SELECT personnel_business_id, employee_id, SUM ( days * 7 ) + SUM ( hours ) AS used, EXTRACT ( YEAR FROM start_date ) AS yy FROM personnel_business WHERE process_type = 13 AND TYPE = 21 AND delete_flag = 0 AND EXTRACT ( YEAR FROM start_date ) != CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) GROUP BY employee_id, yy, personnel_business_id ) AS A LEFT JOIN system_process_instances spi ON spi.business_id = A.personnel_business_id AND spi.process_type = 13 WHERE spi.process_status IN ( 0, 1, 3, 4 ) GROUP BY A.employee_id, A.yy ) AS lastuse ON overtime.employee_id = lastuse.employee_id GROUP BY overtime.employee_id, use.usedtime, lastuse.usedtime UNION SELECT overtime.employee_id, 0 AS last_remaining_leave, SUM ( CASE WHEN overtime.YEAR = CAST ( to_char( CURRENT_DATE, 'YYYY' ) AS INTEGER ) THEN overtime.overtimeHours ELSE 0 END ) AS current_year_leave, CASE WHEN use.usedtime IS NULL THEN 0 ELSE use.usedtime END AS current_year_usedtime FROM ( SELECT employee_id, SUM ( nornal_overtime_hours ) + SUM ( weekend_overtime_hours ) + SUM ( holiday_overtime_hours ) AS overtimeHours, YEAR FROM employee_month_checks emc WHERE emc.YEAR = CAST ( to_char( CURRENT_DATE, 'yyyy' ) AS INTEGER ) GROUP BY employee_id, YEAR ) AS overtime INNER JOIN employees ON plate_id NOT IN ( 56, 57, 58 ) AND employees.employee_id = overtime.employee_id LEFT JOIN ( SELECT employee_id, SUM ( total_compensatory_leave ) AS usedtime FROM compensatory_leaves cl WHERE cl.YEAR = CAST ( to_char( CURRENT_DATE, 'yyyy' ) AS INTEGER ) AND status = 1 GROUP BY employee_id ) AS use ON overtime.employee_id = use.employee_id GROUP BY overtime.employee_id, use.usedtime ) AS swc ON swc.employee_id = e.employee_id WHERE e.employee_name LIKE :employee_name AND d.department_id =:department_id AND current_remaining_amount_annual =:current_remaining_amount_annual AND current_remaining_amount_wealfare =:current_remaining_amount_wealfare AND last_remaining_amount_annual =:last_remaining_amount_annual AND last_remaining_amount_wealfare =:last_remaining_amount_wealfare AND e.status = 0";
	private final static String RESULTSETFIELDLIST = "employee_no,employee_name,department_name,employee_id,department_id,current_year_total_annual_leave,current_year_usage_amount_annual,current_remaining_amount_annual,current_year_total_wealfare_leave,current_year_usage_amount_wealfare,current_remaining_amount_wealfare,last_year_total_annual_leave,last_year_usage_amount_annual,last_remaining_amount_annual,last_year_total_wealfare_leave,last_year_usage_amount_wealfare,last_remaining_amount_wealfare,last_remaining_leave,current_year_leave,current_year_usedtime,remaining_overtime";
	private final static String[] fieldNames = { "employee_name", "department_id", "current_remaining_amount_annual", "current_remaining_amount_wealfare", "last_remaining_amount_annual", "last_remaining_amount_wealfare"};
}
