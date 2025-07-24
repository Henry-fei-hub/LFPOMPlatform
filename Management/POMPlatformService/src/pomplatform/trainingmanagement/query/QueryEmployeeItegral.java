package pomplatform.trainingmanagement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.trainingmanagement.bean.BaseEmployeeItegral;
import pomplatform.trainingmanagement.bean.ConditionEmployeeItegral;

public class QueryEmployeeItegral extends AbstractQuery<BaseEmployeeItegral, ConditionEmployeeItegral>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeItegral.class);

	public QueryEmployeeItegral() throws java.sql.SQLException 
	{
		setParameterNumber(14);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT o.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeItegral> executeQuery( KeyValuePair[] replacements, ConditionEmployeeItegral condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getSelectYear(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeeItegral generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeItegral __base = new BaseEmployeeItegral();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOne(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwo(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setThree(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFour(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFive(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSix(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSeven(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setEight(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setNine(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTen(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setEleven(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwelve(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTotal(GenericBase.__getLong(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
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

	private final static String __SQLText = "SELECT DISTINCT o.employee_id, o.department_id, aa.one, bb.two, cc.three, dd.four, ee.five, ff.six, gg.seven, hh.eight, ii.nine, jj.ten, kk.eleven, ll.twelve, (CASE WHEN aa.one is null THEN 0 ELSE aa.one END +CASE WHEN bb.two is null THEN 0 ELSE bb.two END+CASE WHEN cc.three is null THEN 0 ELSE cc.three END+CASE WHEN dd.four is null THEN 0 ELSE dd.four END +CASE WHEN ee.five is null THEN 0 ELSE ee.five END+CASE WHEN ff.six is null THEN 0 ELSE ff.six END+CASE WHEN gg.seven is null THEN 0 ELSE gg.seven END+CASE WHEN hh.eight is null THEN 0 ELSE hh.eight END +CASE WHEN ii.nine is null THEN 0 ELSE ii.nine END+CASE WHEN jj.ten is null THEN 0 ELSE jj.ten END+CASE WHEN kk.eleven is null THEN 0 ELSE kk.eleven END+CASE WHEN ll.twelve is null THEN 0 ELSE ll.twelve END) as total FROM training_management_details o LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS one FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 1 GROUP BY A .employee_id ORDER BY A .employee_id ) AS aa ON o.employee_id = aa.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS two FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 2 GROUP BY A .employee_id ORDER BY A .employee_id ) AS bb ON o.employee_id = bb.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS three FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 3 GROUP BY A .employee_id ORDER BY A .employee_id ) AS cc ON o.employee_id = cc.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS four FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 4 GROUP BY A .employee_id ORDER BY A .employee_id ) AS dd ON o.employee_id = dd.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS five FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 5 GROUP BY A .employee_id ORDER BY A .employee_id ) AS ee ON o.employee_id = ee.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS six FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 6 GROUP BY A .employee_id ORDER BY A .employee_id ) AS ff ON o.employee_id = ff.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS seven FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 7 GROUP BY A .employee_id ORDER BY A .employee_id ) AS gg ON o.employee_id = gg.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS eight FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 8 GROUP BY A .employee_id ORDER BY A .employee_id ) AS hh ON o.employee_id = hh.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS nine FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 9 GROUP BY A .employee_id ORDER BY A .employee_id ) AS ii ON o.employee_id = ii.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS ten FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 10 GROUP BY A .employee_id ORDER BY A .employee_id ) AS jj ON o.employee_id = jj.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS eleven FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 11 GROUP BY A .employee_id ORDER BY A .employee_id ) AS kk ON o.employee_id = kk.employee_id LEFT JOIN ( SELECT A .employee_id, SUM (b.course_score) AS twelve FROM training_management_details A LEFT JOIN training_managements b ON A .training_management_id = b.training_management_id WHERE EXTRACT (YEAR FROM A .sign_out_time) = ? AND EXTRACT (MONTH FROM A .sign_out_time) = 12 GROUP BY A .employee_id ORDER BY A .employee_id ) AS ll ON o.employee_id = ll.employee_id where o.employee_id = ? AND o.department_id = ? AND (CASE WHEN aa.one IS NULL THEN 0 ELSE aa.one END + CASE WHEN bb.two IS NULL THEN 0 ELSE bb.two END + CASE WHEN cc.three IS NULL THEN 0 ELSE cc.three END + CASE WHEN dd.four IS NULL THEN 0 ELSE dd.four END + CASE WHEN ee.five IS NULL THEN 0 ELSE ee.five END + CASE WHEN ff.six IS NULL THEN 0 ELSE ff.six END + CASE WHEN gg.seven IS NULL THEN 0 ELSE gg.seven END + CASE WHEN hh.eight IS NULL THEN 0 ELSE hh.eight END + CASE WHEN ii.nine IS NULL THEN 0 ELSE ii.nine END + CASE WHEN jj.ten IS NULL THEN 0 ELSE jj.ten END + CASE WHEN kk.eleven IS NULL THEN 0 ELSE kk.eleven END + CASE WHEN ll.twelve IS NULL THEN 0 ELSE ll.twelve END ) <> 0" ;
	private final static String RESULTSETFIELDLIST = "employee_id,department_id,one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,total";
	private final static String[] fieldNames = { "select_year", "select_year", "select_year", "select_year", "select_year", "select_year", "select_year", "select_year", "select_year", "select_year", "select_year", "select_year", "employee_id", "department_id"};
}
