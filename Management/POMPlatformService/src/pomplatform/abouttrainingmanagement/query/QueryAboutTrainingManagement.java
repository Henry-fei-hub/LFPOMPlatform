package pomplatform.abouttrainingmanagement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.abouttrainingmanagement.bean.BaseAboutTrainingManagement;
import pomplatform.abouttrainingmanagement.bean.ConditionAboutTrainingManagement;

public class QueryAboutTrainingManagement extends AbstractQuery<BaseAboutTrainingManagement, ConditionAboutTrainingManagement>
{

	private static final Logger __logger = Logger.getLogger(QueryAboutTrainingManagement.class);

	public QueryAboutTrainingManagement() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.YEAR");
	}

	@Override
	public BaseCollection<BaseAboutTrainingManagement> executeQuery( KeyValuePair[] replacements, ConditionAboutTrainingManagement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseAboutTrainingManagement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAboutTrainingManagement __base = new BaseAboutTrainingManagement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNumber(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT A.YEAR, A.MONTH, A.department_id, A.NUMBER FROM ( SELECT date_part( 'year', start_time ) AS YEAR, date_part( 'month', start_time ) AS MONTH, COUNT ( department_id ) AS NUMBER, department_id FROM training_managements GROUP BY department_id, date_part( 'year', start_time ), date_part( 'month', start_time ) ) A WHERE A.department_id =? AND A.YEAR =? AND A.MONTH =? ORDER BY A.YEAR DESC, A.MONTH DESC" ;
	private final static String RESULTSETFIELDLIST = "year,month,department_id,number";
	private final static String[] fieldNames = { "department_id", "year", "month"};
}
