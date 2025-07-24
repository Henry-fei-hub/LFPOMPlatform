package pomplatform.totaltrainingmanagement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.totaltrainingmanagement.bean.BaseTotalTrainingManagement;
import pomplatform.totaltrainingmanagement.bean.ConditionTotalTrainingManagement;

public class QueryTotalTrainingManagement extends AbstractQuery<BaseTotalTrainingManagement, ConditionTotalTrainingManagement>
{

	private static final Logger __logger = Logger.getLogger(QueryTotalTrainingManagement.class);

	public QueryTotalTrainingManagement() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.YEAR");
	}

	@Override
	public BaseCollection<BaseTotalTrainingManagement> executeQuery( KeyValuePair[] replacements, ConditionTotalTrainingManagement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseTotalTrainingManagement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTotalTrainingManagement __base = new BaseTotalTrainingManagement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT A.YEAR, A.department_id, A.NUMBER FROM ( SELECT date_part( 'year', start_time ) AS YEAR, COUNT ( department_id ) AS NUMBER, department_id FROM training_managements GROUP BY department_id, date_part( 'year', start_time ) ) A WHERE A.department_id =? and A.YEAR=? ORDER BY A.YEAR DESC" ;
	private final static String RESULTSETFIELDLIST = "year,department_id,number";
	private final static String[] fieldNames = { "department_id", "YEAR"};
}
