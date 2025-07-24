package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfGenderPlateMonth;
import pomplatform.report.bean.ConditionReportOfGenderPlateMonth;

public class QueryReportOfGenderPlateMonth extends AbstractQuery<BaseReportOfGenderPlateMonth, ConditionReportOfGenderPlateMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfGenderPlateMonth.class);

	public QueryReportOfGenderPlateMonth() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseReportOfGenderPlateMonth> executeQuery( KeyValuePair[] replacements, ConditionReportOfGenderPlateMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTheDate(), 
				condition.getTheDate(), 
				condition.getTheDate(), 
				condition.getPlateType()
			);
	}

	@Override
	public BaseReportOfGenderPlateMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfGenderPlateMonth __base = new BaseReportOfGenderPlateMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMaleProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFemaleProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMaleProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemaleProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMale(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMalePer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemale(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFemalePer(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotal(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.plate_id,b.male_proportion_str,b.female_proportion_str,b.male_proportion,b.female_proportion, sum(a.male) as male, CASE WHEN sum(a.male)+sum(a.female) = 0 THEN 0 ELSE sum(a.male) / (sum(a.male)+sum(a.female))*100 END as male_per, sum(a.female) as female,CASE WHEN sum(a.male)+sum(a.female) = 0 THEN 0 ELSE sum(a.female) / (sum(a.male)+sum(a.female))*100 END as female_per, sum(a.male)+sum(a.female) as total FROM (SELECT plate_id, case WHEN gender = 1 THEN count(gender) ELSE 0 END as male, case WHEN gender = 2 THEN count(gender) ELSE 0 END as female FROM employees WHERE (onboard_date <= ? AND status = 0) OR (onboard_date <= ? AND resignation_date >= ? AND status != 0) GROUP BY plate_id,gender order BY plate_id,gender) as a LEFT JOIN gender_proportion b ON a.plate_id = b.plate_id LEFT JOIN plate_records pr ON a.plate_id = pr.plate_id WHERE pr.plate_type = ? GROUP BY a.plate_id,b.male_proportion_str,b.female_proportion_str,b.male_proportion,b.female_proportion ORDER BY a.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,male_proportion_str,female_proportion_str,male_proportion,female_proportion,male,male_per,female,female_per,total";
	private final static String[] fieldNames = { "the_date", "the_date", "the_date", "plate_type"};
}
