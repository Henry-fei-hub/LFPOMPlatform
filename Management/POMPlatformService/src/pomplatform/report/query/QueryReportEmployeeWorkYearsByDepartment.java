package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportEmployeeWorkYearsByDepartment;
import pomplatform.report.bean.ConditionReportEmployeeWorkYearsByDepartment;

public class QueryReportEmployeeWorkYearsByDepartment extends AbstractQuery<BaseReportEmployeeWorkYearsByDepartment, ConditionReportEmployeeWorkYearsByDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryReportEmployeeWorkYearsByDepartment.class);

	public QueryReportEmployeeWorkYearsByDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.plate_id");
	}

	@Override
	public BaseCollection<BaseReportEmployeeWorkYearsByDepartment> executeQuery( KeyValuePair[] replacements, ConditionReportEmployeeWorkYearsByDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportEmployeeWorkYearsByDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportEmployeeWorkYearsByDepartment __base = new BaseReportEmployeeWorkYearsByDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOneInner(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOneInnerPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setThreeInner(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThreeInnerPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFiveInner(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFiveInnerPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTenInner(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTenInnerPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTenAdd(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTenAddPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotal(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT aa.plate_id, aa.department_id, aa.one_inner, round( aa.one_inner / aa.total * 100, 2 ) || '%' AS one_inner_percent, aa.three_inner, round( aa.three_inner / aa.total * 100, 2 ) || '%' AS three_inner_percent, aa.five_inner, round( aa.five_inner / aa.total * 100, 2 ) || '%' AS five_inner_percent, aa.ten_inner, round( aa.ten_inner / aa.total * 100, 2 ) || '%' AS ten_inner_percent, aa.ten_add, round( aa.ten_add / aa.total * 100, 2 ) || '%' AS ten_add_percent, aa.total FROM ( SELECT A .plate_id, A.department_id, SUM ( one_inner ) AS one_inner, SUM ( three_inner ) AS three_inner, SUM ( five_inner ) AS five_inner, SUM ( ten_inner ) AS ten_inner, SUM ( ten_add ) AS ten_add, SUM ( one_inner ) + SUM ( three_inner ) + SUM ( five_inner ) + SUM ( ten_inner ) + SUM ( ten_add ) AS total FROM ( SELECT pd.plate_id, pd.department_id, CASE WHEN EXTRACT ( YEAR FROM age( e.positive_date )) < 1 OR EXTRACT ( YEAR FROM age( e.positive_date )) IS NULL THEN COUNT ( e.employee_id ) ELSE 0 END AS one_inner, CASE WHEN EXTRACT ( YEAR FROM age( e.positive_date )) >= 1 AND EXTRACT ( YEAR FROM age( e.positive_date )) < 3 THEN COUNT ( e.employee_id ) ELSE 0 END AS three_inner, CASE WHEN EXTRACT ( YEAR FROM age( e.positive_date )) >= 3 AND EXTRACT ( YEAR FROM age( e.positive_date )) < 5 THEN COUNT ( e.employee_id ) ELSE 0 END AS five_inner, CASE WHEN EXTRACT ( YEAR FROM age( e.positive_date )) >= 5 AND EXTRACT ( YEAR FROM age( e.positive_date )) < 10 THEN COUNT ( e.employee_id ) ELSE 0 END AS ten_inner, CASE WHEN EXTRACT ( YEAR FROM age( e.positive_date )) >= 10 THEN COUNT ( e.employee_id ) ELSE 0 END AS ten_add FROM employees e LEFT JOIN plate_departments pd ON pd.department_id = e.department_id WHERE ( e.status = 0 AND e.onboard_date <=?) OR ( e.status != 0 AND e.resignation_date >=? AND e.resignation_date <=? ) GROUP BY pd.plate_id, pd.department_id, EXTRACT ( YEAR FROM age( e.positive_date ))) AS A GROUP BY A.plate_id, A.department_id ) AS aa WHERE aa.plate_id > 0 AND aa.department_id > 0 AND aa.plate_id =? ORDER BY aa.department_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,department_id,one_inner,one_inner_percent,three_inner,three_inner_percent,five_inner,five_inner_percent,ten_inner,ten_inner_percent,ten_add,ten_add_percent,total";
	private final static String[] fieldNames = { "end_date", "start_date", "end_date", "plate_id"};
}
