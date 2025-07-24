package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfGenderAnalysisByDepartment;
import pomplatform.report.bean.ConditionReportOfGenderAnalysisByDepartment;

public class QueryReportOfGenderAnalysisByDepartment extends AbstractQuery<BaseReportOfGenderAnalysisByDepartment, ConditionReportOfGenderAnalysisByDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfGenderAnalysisByDepartment.class);

	public QueryReportOfGenderAnalysisByDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("C .gender_proportion_id");
	}

	@Override
	public BaseCollection<BaseReportOfGenderAnalysisByDepartment> executeQuery( KeyValuePair[] replacements, ConditionReportOfGenderAnalysisByDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOfGenderAnalysisByDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfGenderAnalysisByDepartment __base = new BaseReportOfGenderAnalysisByDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setGenderProportionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMaleProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFemaleProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMaleJanuary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleJanuaryPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleJanuary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleJanuaryPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJanuaryTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleFebruary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleFebruaryPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleFebruary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleFebruaryPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruaryTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleMarch(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleMarchPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleMarch(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleMarchPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarchTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleApril(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleAprilPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleApril(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleAprilPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAprilTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleMay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleMayPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleMay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleMayPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMayTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleJune(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleJunePer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleJune(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleJunePer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuneTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleJuly(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleJulyPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleJuly(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleJulyPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJulyTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleAugust(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleAugustPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleAugust(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleAugustPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugustTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleSeptember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleSeptemberPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleSeptember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleSeptemberPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptemberTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleOctober(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleOctoberPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleOctober(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleOctoberPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctoberTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleNovember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleNovemberPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleNovember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleNovemberPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovemberTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleDecember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMaleDecemberPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleDecember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleDecemberPer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecemberTotal(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT C .gender_proportion_id, b.plate_id, b.department_id, C.male_proportion_str, C.female_proportion_str, SUM ( b.male_one ) AS male_january, CASE WHEN SUM ( b.male_one ) + SUM ( b.female_one ) = 0 THEN 0 ELSE SUM ( b.male_one ) / ( SUM ( b.male_one ) + SUM ( b.female_one )) * 100 END AS male_january_per, SUM ( b.female_one ) AS female_january, CASE WHEN SUM ( b.male_one ) + SUM ( b.female_one ) = 0 THEN 0 ELSE SUM ( b.female_one ) / ( SUM ( b.male_one ) + SUM ( b.female_one )) * 100 END AS female_january_per, SUM ( b.male_one ) + SUM ( b.female_one ) AS january_total, SUM ( b.male_two ) AS male_february, CASE WHEN SUM ( b.male_two ) + SUM ( b.female_two ) = 0 THEN 0 ELSE SUM ( b.male_two ) / ( SUM ( b.male_two ) + SUM ( b.female_two )) * 100 END AS male_february_per, SUM ( b.female_two ) AS female_february, CASE WHEN SUM ( b.male_two ) + SUM ( b.female_two ) = 0 THEN 0 ELSE SUM ( b.female_two ) / ( SUM ( b.male_two ) + SUM ( b.female_two )) * 100 END AS female_february_per, SUM ( b.male_two ) + SUM ( b.female_two ) AS february_total, SUM ( b.male_three ) AS male_march, CASE WHEN SUM ( b.male_three ) + SUM ( b.female_three ) = 0 THEN 0 ELSE SUM ( b.male_three ) / ( SUM ( b.male_three ) + SUM ( b.female_three )) * 100 END AS male_march_per, SUM ( b.female_three ) AS female_march, CASE WHEN SUM ( b.male_three ) + SUM ( b.female_three ) = 0 THEN 0 ELSE SUM ( b.female_three ) / ( SUM ( b.male_three ) + SUM ( b.female_three )) * 100 END AS female_march_per, SUM ( b.male_three ) + SUM ( b.female_three ) AS march_total, SUM ( b.male_four ) AS male_april, CASE WHEN SUM ( b.male_four ) + SUM ( b.female_four ) = 0 THEN 0 ELSE SUM ( b.male_four ) / ( SUM ( b.male_four ) + SUM ( b.female_four )) * 100 END AS male_april_per, SUM ( b.female_four ) AS female_april, CASE WHEN SUM ( b.male_four ) + SUM ( b.female_four ) = 0 THEN 0 ELSE SUM ( b.female_four ) / ( SUM ( b.male_four ) + SUM ( b.female_four )) * 100 END AS female_april_per, SUM ( b.male_four ) + SUM ( b.female_four ) AS april_total, SUM ( b.male_five ) AS male_may, CASE WHEN SUM ( b.male_five ) + SUM ( b.female_five ) = 0 THEN 0 ELSE SUM ( b.male_five ) / ( SUM ( b.male_five ) + SUM ( b.female_five )) * 100 END AS male_may_per, SUM ( b.female_five ) AS female_may, CASE WHEN SUM ( b.male_five ) + SUM ( b.female_five ) = 0 THEN 0 ELSE SUM ( b.female_five ) / ( SUM ( b.male_five ) + SUM ( b.female_five )) * 100 END AS female_may_per, SUM ( b.male_five ) + SUM ( b.female_five ) AS may_total, SUM ( b.male_six ) AS male_june, CASE WHEN SUM ( b.male_six ) + SUM ( b.female_six ) = 0 THEN 0 ELSE SUM ( b.male_six ) / ( SUM ( b.male_six ) + SUM ( b.female_six )) * 100 END AS male_june_per, SUM ( b.female_six ) AS female_june, CASE WHEN SUM ( b.male_six ) + SUM ( b.female_six ) = 0 THEN 0 ELSE SUM ( b.female_six ) / ( SUM ( b.male_six ) + SUM ( b.female_six )) * 100 END AS female_june_per, SUM ( b.male_six ) + SUM ( b.female_six ) AS june_total, SUM ( b.male_seven ) AS male_july, CASE WHEN SUM ( b.male_seven ) + SUM ( b.female_seven ) = 0 THEN 0 ELSE SUM ( b.male_seven ) / ( SUM ( b.male_seven ) + SUM ( b.female_seven )) * 100 END AS male_july_per, SUM ( b.female_seven ) AS female_july, CASE WHEN SUM ( b.male_seven ) + SUM ( b.female_seven ) = 0 THEN 0 ELSE SUM ( b.female_seven ) / ( SUM ( b.male_seven ) + SUM ( b.female_seven )) * 100 END AS female_july_per, SUM ( b.male_seven ) + SUM ( b.female_seven ) AS july_total, SUM ( b.male_eight ) AS male_august, CASE WHEN SUM ( b.male_eight ) + SUM ( b.female_eight ) = 0 THEN 0 ELSE SUM ( b.male_eight ) / ( SUM ( b.male_eight ) + SUM ( b.female_eight )) * 100 END AS male_august_per, SUM ( b.female_eight ) AS female_august, CASE WHEN SUM ( b.male_eight ) + SUM ( b.female_eight ) = 0 THEN 0 ELSE SUM ( b.female_eight ) / ( SUM ( b.male_eight ) + SUM ( b.female_eight )) * 100 END AS female_august_per, SUM ( b.male_eight ) + SUM ( b.female_eight ) AS august_total, SUM ( b.male_nine ) AS male_september, CASE WHEN SUM ( b.male_nine ) + SUM ( b.female_nine ) = 0 THEN 0 ELSE SUM ( b.male_nine ) / ( SUM ( b.male_nine ) + SUM ( b.female_nine )) * 100 END AS male_september_per, SUM ( b.female_nine ) AS female_september, CASE WHEN SUM ( b.male_nine ) + SUM ( b.female_nine ) = 0 THEN 0 ELSE SUM ( b.female_nine ) / ( SUM ( b.male_nine ) + SUM ( b.female_nine )) * 100 END AS female_september_per, SUM ( b.male_nine ) + SUM ( b.female_nine ) AS september_total, SUM ( b.male_ten ) AS male_october, CASE WHEN SUM ( b.male_ten ) + SUM ( b.female_ten ) = 0 THEN 0 ELSE SUM ( b.male_ten ) / ( SUM ( b.male_ten ) + SUM ( b.female_ten )) * 100 END AS male_october_per, SUM ( b.female_ten ) AS female_october, CASE WHEN SUM ( b.male_ten ) + SUM ( b.female_ten ) = 0 THEN 0 ELSE SUM ( b.female_ten ) / ( SUM ( b.male_ten ) + SUM ( b.female_ten )) * 100 END AS female_october_per, SUM ( b.male_ten ) + SUM ( b.female_ten ) AS october_total, SUM ( b.male_eleven ) AS male_november, CASE WHEN SUM ( b.male_eleven ) + SUM ( b.female_eleven ) = 0 THEN 0 ELSE SUM ( b.male_eleven ) / ( SUM ( b.male_eleven ) + SUM ( b.female_eleven )) * 100 END AS male_november_per, SUM ( b.female_eleven ) AS female_november, CASE WHEN SUM ( b.male_eleven ) + SUM ( b.female_eleven ) = 0 THEN 0 ELSE SUM ( b.female_eleven ) / ( SUM ( b.male_eleven ) + SUM ( b.female_eleven )) * 100 END AS female_november_per, SUM ( b.male_eleven ) + SUM ( b.female_eleven ) AS november_total, SUM ( b.male_twelve ) AS male_december, CASE WHEN SUM ( b.male_twelve ) + SUM ( b.female_twelve ) = 0 THEN 0 ELSE SUM ( b.male_twelve ) / ( SUM ( b.male_twelve ) + SUM ( b.female_twelve )) * 100 END AS male_december_per, SUM ( b.female_twelve ) AS female_december, CASE WHEN SUM ( b.male_twelve ) + SUM ( b.female_twelve ) = 0 THEN 0 ELSE SUM ( b.female_twelve ) / ( SUM ( b.male_twelve ) + SUM ( b.female_twelve )) * 100 END AS female_december_per, SUM ( b.male_twelve ) + SUM ( b.female_twelve ) AS december_total FROM ( SELECT A .plate_id, A.department_id, CASE WHEN A.MONTH = 1 THEN SUM ( A.male_num ) ELSE 0 END AS male_one, CASE WHEN A.MONTH = 1 THEN SUM ( A.female_num ) ELSE 0 END AS female_one, CASE WHEN A.MONTH = 2 THEN SUM ( A.male_num ) ELSE 0 END AS male_two, CASE WHEN A.MONTH = 2 THEN SUM ( A.female_num ) ELSE 0 END AS female_two, CASE WHEN A.MONTH = 3 THEN SUM ( A.male_num ) ELSE 0 END AS male_three, CASE WHEN A.MONTH = 3 THEN SUM ( A.female_num ) ELSE 0 END AS female_three, CASE WHEN A.MONTH = 4 THEN SUM ( A.male_num ) ELSE 0 END AS male_four, CASE WHEN A.MONTH = 4 THEN SUM ( A.female_num ) ELSE 0 END AS female_four, CASE WHEN A.MONTH = 5 THEN SUM ( A.male_num ) ELSE 0 END AS male_five, CASE WHEN A.MONTH = 5 THEN SUM ( A.female_num ) ELSE 0 END AS female_five, CASE WHEN A.MONTH = 6 THEN SUM ( A.male_num ) ELSE 0 END AS male_six, CASE WHEN A.MONTH = 6 THEN SUM ( A.female_num ) ELSE 0 END AS female_six, CASE WHEN A.MONTH = 7 THEN SUM ( A.male_num ) ELSE 0 END AS male_seven, CASE WHEN A.MONTH = 7 THEN SUM ( A.female_num ) ELSE 0 END AS female_seven, CASE WHEN A.MONTH = 8 THEN SUM ( A.male_num ) ELSE 0 END AS male_eight, CASE WHEN A.MONTH = 8 THEN SUM ( A.female_num ) ELSE 0 END AS female_eight, CASE WHEN A.MONTH = 9 THEN SUM ( A.male_num ) ELSE 0 END AS male_nine, CASE WHEN A.MONTH = 9 THEN SUM ( A.female_num ) ELSE 0 END AS female_nine, CASE WHEN A.MONTH = 10 THEN SUM ( A.male_num ) ELSE 0 END AS male_ten, CASE WHEN A.MONTH = 10 THEN SUM ( A.female_num ) ELSE 0 END AS female_ten, CASE WHEN A.MONTH = 11 THEN SUM ( A.male_num ) ELSE 0 END AS male_eleven, CASE WHEN A.MONTH = 11 THEN SUM ( A.female_num ) ELSE 0 END AS female_eleven, CASE WHEN A.MONTH = 12 THEN SUM ( A.male_num ) ELSE 0 END AS male_twelve, CASE WHEN A.MONTH = 12 THEN SUM ( A.female_num ) ELSE 0 END AS female_twelve FROM ( SELECT pd.plate_id, pd.department_id, gender, 1 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-1-31' ) AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-1-30' ) ELSE e.resignation_date END ) AND pd.plate_id >=0 GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 2 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-2-28' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-2-28' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 3 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-3-31' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-3-31' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 4 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-4-30' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-4-30' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 5 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-5-31' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-5-31' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 6 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-6-30' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-6-30' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 7 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-7-31' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-7-31' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 8 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-8-31' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-8-31' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 9 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-9-30' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-9-30' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 10 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-10-31' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-10-31' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 11 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-11-30' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-11-30' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender UNION SELECT pd.plate_id, pd.department_id, gender, 12 AS MONTH, CASE WHEN gender = 1 THEN COUNT ( gender ) ELSE 0 END AS male_num, CASE WHEN gender = 2 THEN COUNT ( gender ) ELSE 0 END AS female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id LEFT JOIN plate_departments pd ON pd.department_id = pd.department_id WHERE edpr.record_date = DATE ( 9999 || '-12-31' ) AND pd.plate_id >=0 AND edpr.record_date <= ( CASE WHEN e.resignation_date IS NULL THEN DATE ( 9999 || '-12-31' ) ELSE e.resignation_date END ) GROUP BY pd.plate_id, pd.department_id, gender ORDER BY plate_id, gender, MONTH ) AS A GROUP BY A.plate_id, A.department_id, A.MONTH ORDER BY A.department_id, A.MONTH ) AS b LEFT JOIN gender_proportion C ON b.plate_id = C.plate_id WHERE b.plate_id =? GROUP BY b.plate_id, b.department_id, C.male_proportion_str, C.female_proportion_str, C.gender_proportion_id" ;
	private final static String RESULTSETFIELDLIST = "gender_proportion_id,plate_id,department_id,male_proportion_str,female_proportion_str,male_january,male_january_per,female_january,female_january_per,january_total,male_february,male_february_per,female_february,female_february_per,february_total,male_march,male_march_per,female_march,female_march_per,march_total,male_april,male_april_per,female_april,female_april_per,april_total,male_may,male_may_per,female_may,female_may_per,may_total,male_june,male_june_per,female_june,female_june_per,june_total,male_july,male_july_per,female_july,female_july_per,july_total,male_august,male_august_per,female_august,female_august_per,august_total,male_september,male_september_per,female_september,female_september_per,september_total,male_october,male_october_per,female_october,female_october_per,october_total,male_november,male_november_per,female_november,female_november_per,november_total,male_december,male_december_per,female_december,female_december_per,december_total";
	private final static String[] fieldNames = { "plate_id"};
}
