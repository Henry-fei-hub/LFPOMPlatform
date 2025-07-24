package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseCurrentMonthSalaryType;
import pomplatform.payment.bean.ConditionCurrentMonthSalaryType;

public class QueryCurrentMonthSalaryType extends AbstractQuery<BaseCurrentMonthSalaryType, ConditionCurrentMonthSalaryType>
{

	private static final Logger __logger = Logger.getLogger(QueryCurrentMonthSalaryType.class);

	public QueryCurrentMonthSalaryType() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT fundraising_project_type");
	}

	@Override
	public BaseCollection<BaseCurrentMonthSalaryType> executeQuery( KeyValuePair[] replacements, ConditionCurrentMonthSalaryType condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseCurrentMonthSalaryType generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCurrentMonthSalaryType __base = new BaseCurrentMonthSalaryType();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFundraisingProjectType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select DISTINCT fundraising_project_type from employee_salary_types where year =? and month =? and company_id =?" ;
	private final static String RESULTSETFIELDLIST = "fundraising_project_type";
	private final static String[] fieldNames = { "year", "month", "company_id"};
}
