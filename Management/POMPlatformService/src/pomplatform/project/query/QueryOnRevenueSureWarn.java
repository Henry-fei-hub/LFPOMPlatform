package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnRevenueSureWarn;
import pomplatform.project.bean.ConditionOnRevenueSureWarn;

public class QueryOnRevenueSureWarn extends AbstractQuery<BaseOnRevenueSureWarn, ConditionOnRevenueSureWarn>
{

	private static final Logger __logger = Logger.getLogger(QueryOnRevenueSureWarn.class);

	public QueryOnRevenueSureWarn() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aaa.employee_id");
	}

	@Override
	public BaseCollection<BaseOnRevenueSureWarn> executeQuery( KeyValuePair[] replacements, ConditionOnRevenueSureWarn condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnRevenueSureWarn generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnRevenueSureWarn __base = new BaseOnRevenueSureWarn();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectNoNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWeekDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWarnFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWarnImg(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT aaa.employee_id,e.employee_no, e.employee_name, e.plate_id,aaa.project_num,aaa.project_no_num , aaa.sure_integral, aaa.sure_date, aaa.week_date ,CASE WHEN aaa.project_num = 0 AND aaa.project_no_num > 0 THEN 3 WHEN aaa.sure_date >= aaa.week_date THEN 1 ELSE 2 END warn_flag ,CASE WHEN aaa.project_num = 0 AND aaa.project_no_num > 0 THEN 'project_warn_yellow.png' WHEN aaa.sure_date >= aaa.week_date THEN 'project_warn_green.png' ELSE 'project_warn_red.png' END warn_img FROM (SELECT aa.employee_id,SUM(aa.project_num) AS project_num,SUM(aa.project_no_num) AS project_no_num,MAX(aa.sure_date) AS sure_date,MAX(aa.sure_integral) AS sure_integral,aa.week_date FROM ( SELECT A .project_manage_id AS employee_id, COUNT(A.status = 2 or A.status = 17 OR NULL ) AS project_num,COUNT(A.STATUS = 5 OR NULL) AS project_no_num, MAX (b.sure_date) AS sure_date , SUM (b.sure_integral) AS sure_integral , CURRENT_DATE + CAST ( - 1 * ( CASE WHEN TO_NUMBER( to_char(CURRENT_DATE, 'D'), '99' ) = 1 THEN 6 ELSE TO_NUMBER( to_char(CURRENT_DATE, 'D'), '99' ) - 2 END ) || ' days' AS INTERVAL ) AS week_date , A .status FROM projects A LEFT JOIN ( SELECT project_id, MAX (settlement_date) AS sure_date, SUM (total_amount) AS sure_integral FROM project_settlements WHERE settlement_status = 2 AND settlement_date >= CURRENT_DATE + CAST ( - 1 * ( CASE WHEN TO_NUMBER( to_char(CURRENT_DATE, 'D'), '99' ) = 1 THEN 6 ELSE TO_NUMBER( to_char(CURRENT_DATE, 'D'), '99' ) - 2 END ) || ' days' AS INTERVAL ) GROUP BY project_id ) AS b ON A .project_id = b.project_id LEFT JOIN plate_records P ON A .plate_id = P .plate_id LEFT JOIN ( SELECT project_id, SUM (total_amount) AS total_sure_integral FROM project_settlements WHERE settlement_status = 2 AND settlement_date < CURRENT_DATE + CAST ( - 1 * ( CASE WHEN TO_NUMBER( to_char(CURRENT_DATE, 'D'), '99' ) = 1 THEN 6 ELSE TO_NUMBER( to_char(CURRENT_DATE, 'D'), '99' ) - 2 END ) || ' days' AS INTERVAL ) GROUP BY project_id ) AS ps ON A .project_id = ps.project_id WHERE A .project_manage_id > 0 AND A .project_flag = 1 AND A .project_type <> 16 AND A .status in(2,5,17) AND A .project_integral > 0 AND A .project_integral > CASE WHEN ps.total_sure_integral IS NULL THEN 0.0 ELSE ps.total_sure_integral END AND P .plate_type = 1 AND A .plate_id <> 11 GROUP BY A .project_manage_id, A .status ) AS aa GROUP BY aa.employee_id,aa.week_date ) AS aaa LEFT JOIN employees e ON aaa.employee_id = e.employee_id LEFT JOIN plate_records pr ON e.plate_id = pr.plate_id WHERE e.employee_id > 0 AND pr.plate_type= 1 AND e.employee_no LIKE ? AND e.employee_name LIKE ? AND e.plate_id =? ORDER BY aaa.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,plate_id,project_num,project_no_num,sure_integral,sure_date,week_date,warn_flag,warn_img";
	private final static String[] fieldNames = { "employee_no", "employee_name", "plate_id"};
}
