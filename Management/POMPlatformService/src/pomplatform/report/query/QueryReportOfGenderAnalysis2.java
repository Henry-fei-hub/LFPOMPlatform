package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfGenderAnalysis;
import pomplatform.report.bean.ConditionReportOfGenderAnalysis;

public class QueryReportOfGenderAnalysis2 extends AbstractQuery<BaseReportOfGenderAnalysis, ConditionReportOfGenderAnalysis>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfGenderAnalysis2.class);

	public QueryReportOfGenderAnalysis2() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.plate_id");
	}

	@Override
	public BaseCollection<BaseReportOfGenderAnalysis> executeQuery( KeyValuePair[] replacements, ConditionReportOfGenderAnalysis condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportOfGenderAnalysis generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfGenderAnalysis __base = new BaseReportOfGenderAnalysis();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setGenderProportionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
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

	private final static String __SQLText = "SELECT c.gender_proportion_id,b.plate_id,c.male_proportion_str,c.female_proportion_str, sum(b.male_one) as male_january,CASE WHEN sum(b.male_one)+sum(b.female_one) = 0 THEN 0 ELSE sum(b.male_one)/(sum(b.male_one)+sum(b.female_one))*100 END as male_january_per, sum(b.female_one) as female_january,CASE WHEN sum(b.male_one)+sum(b.female_one) = 0 THEN 0 ELSE sum(b.female_one)/(sum(b.male_one)+sum(b.female_one))*100 END as female_january_per, sum(b.male_one)+sum(b.female_one) as january_total, sum(b.male_two) as male_february,CASE WHEN sum(b.male_two)+sum(b.female_two) = 0 THEN 0 ELSE sum(b.male_two)/(sum(b.male_two)+sum(b.female_two))*100 END as male_february_per, sum(b.female_two) as female_february,CASE WHEN sum(b.male_two)+sum(b.female_two) = 0 THEN 0 ELSE sum(b.female_two)/(sum(b.male_two)+sum(b.female_two))*100 END as female_february_per, sum(b.male_two)+sum(b.female_two) as february_total, sum(b.male_three) as male_march,CASE WHEN sum(b.male_three)+sum(b.female_three) = 0 THEN 0 ELSE sum(b.male_three)/(sum(b.male_three)+sum(b.female_three))*100 END as male_march_per, sum(b.female_three) as female_march,CASE WHEN sum(b.male_three)+sum(b.female_three) = 0 THEN 0 ELSE sum(b.female_three)/(sum(b.male_three)+sum(b.female_three))*100 END as female_march_per, sum(b.male_three)+sum(b.female_three) as march_total, sum(b.male_four) as male_april,CASE WHEN sum(b.male_four)+sum(b.female_four) = 0 THEN 0 ELSE sum(b.male_four)/(sum(b.male_four)+sum(b.female_four))*100 END as male_april_per, sum(b.female_four) as female_april,CASE WHEN sum(b.male_four)+sum(b.female_four) = 0 THEN 0 ELSE sum(b.female_four)/(sum(b.male_four)+sum(b.female_four))*100 END as female_april_per, sum(b.male_four)+sum(b.female_four) as april_total, sum(b.male_five) as male_may,CASE WHEN sum(b.male_five)+sum(b.female_five) = 0 THEN 0 ELSE sum(b.male_five)/(sum(b.male_five)+sum(b.female_five))*100 END as male_may_per, sum(b.female_five) as female_may,CASE WHEN sum(b.male_five)+sum(b.female_five) = 0 THEN 0 ELSE sum(b.female_five)/(sum(b.male_five)+sum(b.female_five))*100 END as female_may_per, sum(b.male_five)+sum(b.female_five) as may_total, sum(b.male_six) as male_june,CASE WHEN sum(b.male_six)+sum(b.female_six) = 0 THEN 0 ELSE sum(b.male_six)/(sum(b.male_six)+sum(b.female_six))*100 END as male_june_per, sum(b.female_six) as female_june,CASE WHEN sum(b.male_six)+sum(b.female_six) = 0 THEN 0 ELSE sum(b.female_six)/(sum(b.male_six)+sum(b.female_six))*100 END as female_june_per, sum(b.male_six)+sum(b.female_six) as june_total, sum(b.male_seven) as male_july,CASE WHEN sum(b.male_seven)+sum(b.female_seven) = 0 THEN 0 ELSE sum(b.male_seven)/(sum(b.male_seven)+sum(b.female_seven))*100 END as male_july_per, sum(b.female_seven) as female_july,CASE WHEN sum(b.male_seven)+sum(b.female_seven) = 0 THEN 0 ELSE sum(b.female_seven)/(sum(b.male_seven)+sum(b.female_seven))*100 END as female_july_per, sum(b.male_seven)+sum(b.female_seven) as july_total, sum(b.male_eight) as male_august,CASE WHEN sum(b.male_eight)+sum(b.female_eight) = 0 THEN 0 ELSE sum(b.male_eight)/(sum(b.male_eight)+sum(b.female_eight))*100 END as male_august_per, sum(b.female_eight) as female_august,CASE WHEN sum(b.male_eight)+sum(b.female_eight) = 0 THEN 0 ELSE sum(b.female_eight)/(sum(b.male_eight)+sum(b.female_eight))*100 END as female_august_per, sum(b.male_eight)+sum(b.female_eight) as august_total, sum(b.male_nine) as male_september,CASE WHEN sum(b.male_nine)+sum(b.female_nine) = 0 THEN 0 ELSE sum(b.male_nine)/(sum(b.male_nine)+sum(b.female_nine))*100 END as male_september_per, sum(b.female_nine) as female_september,CASE WHEN sum(b.male_nine)+sum(b.female_nine) = 0 THEN 0 ELSE sum(b.female_nine)/(sum(b.male_nine)+sum(b.female_nine))*100 END as female_september_per, sum(b.male_nine)+sum(b.female_nine) as september_total, sum(b.male_ten) as male_october,CASE WHEN sum(b.male_ten)+sum(b.female_ten) = 0 THEN 0 ELSE sum(b.male_ten)/(sum(b.male_ten)+sum(b.female_ten))*100 END as male_october_per, sum(b.female_ten) as female_october,CASE WHEN sum(b.male_ten)+sum(b.female_ten) = 0 THEN 0 ELSE sum(b.female_ten)/(sum(b.male_ten)+sum(b.female_ten))*100 END as female_october_per, sum(b.male_ten)+sum(b.female_ten) as october_total, sum(b.male_eleven) as male_november,CASE WHEN sum(b.male_eleven)+sum(b.female_eleven) = 0 THEN 0 ELSE sum(b.male_eleven)/(sum(b.male_eleven)+sum(b.female_eleven))*100 END as male_november_per, sum(b.female_eleven) as female_november,CASE WHEN sum(b.male_eleven)+sum(b.female_eleven) = 0 THEN 0 ELSE sum(b.female_eleven)/(sum(b.male_eleven)+sum(b.female_eleven))*100 END as female_november_per, sum(b.male_eleven)+sum(b.female_eleven) as november_total, sum(b.male_twelve) as male_december,CASE WHEN sum(b.male_twelve)+sum(b.female_twelve) = 0 THEN 0 ELSE sum(b.male_twelve)/(sum(b.male_twelve)+sum(b.female_twelve))*100 END as male_december_per, sum(b.female_twelve) as female_december,CASE WHEN sum(b.male_twelve)+sum(b.female_twelve) = 0 THEN 0 ELSE sum(b.female_twelve)/(sum(b.male_twelve)+sum(b.female_twelve))*100 END as female_december_per, sum(b.male_twelve)+sum(b.female_twelve) as december_total FROM (SELECT a.plate_id, case WHEN a.month = 1 THEN sum(a.male_num) else 0 END as male_one, case WHEN a.month = 1 THEN sum(a.female_num) else 0 END as female_one, case WHEN a.month = 2 THEN sum(a.male_num) else 0 END as male_two, case WHEN a.month = 2 THEN sum(a.female_num) else 0 END as female_two, case WHEN a.month = 3 THEN sum(a.male_num) else 0 END as male_three, case WHEN a.month = 3 THEN sum(a.female_num) else 0 END as female_three, case WHEN a.month = 4 THEN sum(a.male_num) else 0 END as male_four, case WHEN a.month = 4 THEN sum(a.female_num) else 0 END as female_four, case WHEN a.month = 5 THEN sum(a.male_num) else 0 END as male_five, case WHEN a.month = 5 THEN sum(a.female_num) else 0 END as female_five, case WHEN a.month = 6 THEN sum(a.male_num) else 0 END as male_six, case WHEN a.month = 6 THEN sum(a.female_num) else 0 END as female_six, case WHEN a.month = 7 THEN sum(a.male_num) else 0 END as male_seven, case WHEN a.month = 7 THEN sum(a.female_num) else 0 END as female_seven, case WHEN a.month = 8 THEN sum(a.male_num) else 0 END as male_eight, case WHEN a.month = 8 THEN sum(a.female_num) else 0 END as female_eight, case WHEN a.month = 9 THEN sum(a.male_num) else 0 END as male_nine, case WHEN a.month = 9 THEN sum(a.female_num) else 0 END as female_nine, case WHEN a.month = 10 THEN sum(a.male_num) else 0 END as male_ten, case WHEN a.month = 10 THEN sum(a.female_num) else 0 END as female_ten, case WHEN a.month = 11 THEN sum(a.male_num) else 0 END as male_eleven, case WHEN a.month = 11 THEN sum(a.female_num) else 0 END as female_eleven, case WHEN a.month = 12 THEN sum(a.male_num) else 0 END as male_twelve, case WHEN a.month = 12 THEN sum(a.female_num) else 0 END as female_twelve FROM (SELECT edpr.plate_id,gender,1 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-1-31') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,2 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-2-28') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,3 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-3-31') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,4 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-4-30') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,5 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-5-31') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,6 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-6-30') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,7 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-7-31') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,8 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-8-31') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,9 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-9-30') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,10 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-10-31') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,11 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-11-30') GROUP BY edpr.plate_id,gender UNION SELECT edpr.plate_id,gender,12 as month,case WHEN gender = 1 THEN count(gender) ELSE 0 END as male_num,case WHEN gender = 2 THEN count(gender) ELSE 0 END as female_num FROM employees e LEFT JOIN employee_day_plate_records edpr ON e.employee_id = edpr.employee_id WHERE edpr.record_date = DATE(? || '-12-31') GROUP BY edpr.plate_id,gender ORDER BY plate_id,gender,month) as a GROUP BY a.plate_id,a.month ORDER BY a.plate_id,a.month) as b LEFT JOIN gender_proportion c ON b.plate_id = c.plate_id WHERE b.plate_id = ? GROUP BY b.plate_id,c.male_proportion_str,c.female_proportion_str,c.gender_proportion_id" ;
	private final static String RESULTSETFIELDLIST = "gender_proportion_id,plate_id,male_proportion_str,female_proportion_str,male_january,male_january_per,female_january,female_january_per,january_total,male_february,male_february_per,female_february,female_february_per,february_total,male_march,male_march_per,female_march,female_march_per,march_total,male_april,male_april_per,female_april,female_april_per,april_total,male_may,male_may_per,female_may,female_may_per,may_total,male_june,male_june_per,female_june,female_june_per,june_total,male_july,male_july_per,female_july,female_july_per,july_total,male_august,male_august_per,female_august,female_august_per,august_total,male_september,male_september_per,female_september,female_september_per,september_total,male_october,male_october_per,female_october,female_october_per,october_total,male_november,male_november_per,female_november,female_november_per,november_total,male_december,male_december_per,female_december,female_december_per,december_total";
	private final static String[] fieldNames = { "year", "year", "year", "year", "year", "year", "year", "year", "year", "year", "year", "year","plate_id"};
}
