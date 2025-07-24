package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOnEmployeeNumTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeNumTotal;

public class QueryReportOnEmployeeNumTotal extends AbstractQuery<BaseReportOnEmployeeNumTotal, ConditionReportOnEmployeeNumTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOnEmployeeNumTotal.class);

	public QueryReportOnEmployeeNumTotal() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.plate_id");
	}

	@Override
	public BaseCollection<BaseReportOnEmployeeNumTotal> executeQuery( KeyValuePair[] replacements, ConditionReportOnEmployeeNumTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOnEmployeeNumTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOnEmployeeNumTotal __base = new BaseReportOnEmployeeNumTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOneBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOneAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwoBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwoAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThreeBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setThreeAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setThreeAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFourAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFourAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFiveBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFiveAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFiveAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSixBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSixAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSixAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSevenBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSevenAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSevenAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEightBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setEightAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setEightAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNineBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setNineAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setNineAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTenBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTenAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTenAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setElevenBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setElevenAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setElevenAverageNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwelfBeforNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwelfAfterNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTwelfAverageNum(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT aa.plate_id, aa.YEAR, aa.one_befor_num, bb.one_after_num, ( aa.one_befor_num + bb.one_after_num ) / 2.0 AS one_average_num, aa.two_befor_num, bb.two_after_num, ( aa.two_befor_num + bb.two_after_num ) / 2.0 AS two_average_num, aa.three_befor_num, bb.three_after_num, ( aa.three_befor_num + bb.three_after_num ) / 2.0 AS three_average_num, aa.four_befor_num, bb.four_after_num, ( aa.four_befor_num + bb.four_after_num ) / 2.0 AS four_average_num, aa.five_befor_num, bb.five_after_num, ( aa.five_befor_num + bb.five_after_num ) / 2.0 AS five_average_num, aa.six_befor_num, bb.six_after_num, ( aa.six_befor_num + bb.six_after_num ) / 2.0 AS six_average_num, aa.seven_befor_num, bb.seven_after_num, ( aa.seven_befor_num + bb.seven_after_num ) / 2.0 AS seven_average_num, aa.eight_befor_num, bb.eight_after_num, ( aa.eight_befor_num + bb.eight_after_num ) / 2.0 AS eight_average_num, aa.nine_befor_num, bb.nine_after_num, ( aa.nine_befor_num + bb.nine_after_num ) / 2.0 AS nine_average_num, aa.ten_befor_num, bb.ten_after_num, ( aa.ten_befor_num + bb.ten_after_num ) / 2.0 AS ten_average_num, aa.eleven_befor_num, bb.eleven_after_num, ( aa.eleven_befor_num + bb.eleven_after_num ) / 2.0 AS eleven_average_num, aa.twelf_befor_num, bb.twelf_after_num, ( aa.twelf_befor_num + bb.twelf_after_num ) / 2.0 AS twelf_average_num FROM ( SELECT YEAR, pd.plate_id, COUNT ( MONTH = 1 OR NULL ) AS one_befor_num, COUNT ( MONTH = 2 OR NULL ) AS two_befor_num, COUNT ( MONTH = 3 OR NULL ) AS three_befor_num, COUNT ( MONTH = 4 OR NULL ) AS four_befor_num, COUNT ( MONTH = 5 OR NULL ) AS five_befor_num, COUNT ( MONTH = 6 OR NULL ) AS six_befor_num, COUNT ( MONTH = 7 OR NULL ) AS seven_befor_num, COUNT ( MONTH = 8 OR NULL ) AS eight_befor_num, COUNT ( MONTH = 9 OR NULL ) AS nine_befor_num, COUNT ( MONTH = 10 OR NULL ) AS ten_befor_num, COUNT ( MONTH = 11 OR NULL ) AS eleven_befor_num, COUNT ( MONTH = 12 OR NULL ) AS twelf_befor_num FROM employee_day_plate_records A LEFT JOIN plate_departments pd on pd.department_id = A.department_id LEFT JOIN employees e ON A.employee_id = e.employee_id WHERE YEAR =? AND pd.plate_id>=0 AND EXTRACT ( DAY FROM record_date ) = 1 AND A.onboard_status IN ( 1, 2 ) AND A.record_date >= CASE WHEN e.onboard_date IS NULL THEN A.record_date ELSE e.onboard_date END GROUP BY YEAR, pd.plate_id ) AS aa FULL JOIN ( SELECT YEAR, pd.plate_id, COUNT ( MONTH = 1 OR NULL ) AS one_after_num, COUNT ( MONTH = 2 OR NULL ) AS two_after_num, COUNT ( MONTH = 3 OR NULL ) AS three_after_num, COUNT ( MONTH = 4 OR NULL ) AS four_after_num, COUNT ( MONTH = 5 OR NULL ) AS five_after_num, COUNT ( MONTH = 6 OR NULL ) AS six_after_num, COUNT ( MONTH = 7 OR NULL ) AS seven_after_num, COUNT ( MONTH = 8 OR NULL ) AS eight_after_num, COUNT ( MONTH = 9 OR NULL ) AS nine_after_num, COUNT ( MONTH = 10 OR NULL ) AS ten_after_num, COUNT ( MONTH = 11 OR NULL ) AS eleven_after_num, COUNT ( MONTH = 12 OR NULL ) AS twelf_after_num FROM employee_day_plate_records A LEFT JOIN plate_departments pd on pd.department_id = A.department_id LEFT JOIN employees e ON A.employee_id = e.employee_id WHERE YEAR =? AND pd.plate_id>=0 AND record_date = date_trunc( 'day', date_trunc( 'month', record_date + INTERVAL '1 month' ) + INTERVAL '-1 day' ) AND A.onboard_status IN ( 1, 2 ) AND A.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN now() ELSE e.resignation_date END ) GROUP BY YEAR, pd.plate_id ) AS bb ON aa.YEAR = bb.YEAR AND aa.plate_id = bb.plate_id WHERE aa.plate_id =? ORDER BY aa.YEAR, aa.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,one_befor_num,one_after_num,one_average_num,two_befor_num,two_after_num,two_average_num,three_befor_num,three_after_num,three_average_num,four_befor_num,four_after_num,four_average_num,five_befor_num,five_after_num,five_average_num,six_befor_num,six_after_num,six_average_num,seven_befor_num,seven_after_num,seven_average_num,eight_befor_num,eight_after_num,eight_average_num,nine_befor_num,nine_after_num,nine_average_num,ten_befor_num,ten_after_num,ten_average_num,eleven_befor_num,eleven_after_num,eleven_average_num,twelf_befor_num,twelf_after_num,twelf_average_num";
	private final static String[] fieldNames = { "year", "year", "plate_id"};
}
