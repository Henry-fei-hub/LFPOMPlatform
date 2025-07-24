package pomplatform.report.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseProjectAccountIncome;
import pomplatform.report.bean.ConditionProjectAccountIncome;

public class QueryProjectAccountIncome extends AbstractQuery<BaseProjectAccountIncome, ConditionProjectAccountIncome>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectAccountIncome.class);

	public QueryProjectAccountIncome() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("EXTRACT ( YEAR FROM pc.cost_date ) as year");
	}

	@Override
	public BaseCollection<BaseProjectAccountIncome> executeQuery(KeyValuePair[] replacements, ConditionProjectAccountIncome condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseProjectAccountIncome generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectAccountIncome __base = new BaseProjectAccountIncome();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSum(GenericBase.__getDecimal(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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

	private final static String __SQLText = "SELECT EXTRACT ( YEAR FROM pc.cost_date ) as year, EXTRACT ( MONTH FROM pc.cost_date ) as month, P.plate_id, SUM ( amount ) FROM projects P LEFT JOIN project_cost pc ON pc.project_id = P.project_id WHERE EXTRACT ( YEAR FROM pc.cost_date ) =? AND EXTRACT ( MONTH FROM pc.cost_date ) =? AND P.plate_id =? AND p.project_type != 30 GROUP BY EXTRACT ( YEAR FROM pc.cost_date ), EXTRACT ( MONTH FROM pc.cost_date ), P.plate_id" ;
	private final static String RESULTSETFIELDLIST = "year,month,plate_id,sum";
	private final static String[] fieldNames = { "year", "month", "plate_id"};
}
