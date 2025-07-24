package pomplatform.report.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseContractSaveAndRevenue;
import pomplatform.report.bean.ConditionContractSaveAndRevenue;

public class QueryContractSaveAndRevenue extends AbstractQuery<BaseContractSaveAndRevenue, ConditionContractSaveAndRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryContractSaveAndRevenue.class);

	public QueryContractSaveAndRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rs.year");
	}

	@Override
	public BaseCollection<BaseContractSaveAndRevenue> executeQuery( KeyValuePair[] replacements, ConditionContractSaveAndRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseContractSaveAndRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractSaveAndRevenue __base = new BaseContractSaveAndRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActive(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select rs.year,rs.month,p.revenue_plate_id AS plate_id,sum(current_revenue) AS current_revenue,sum(rs.contract_save_active) as active from revenue_statistical_records rs LEFT JOIN projects p on p.project_id = rs.project_id where plate_id =? and year =? and month =? GROUP BY rs.year,rs.month,p.revenue_plate_id" ;
	private final static String RESULTSETFIELDLIST = "year,month,plate_id,current_revenue,active";
	private final static String[] fieldNames = { "plate_id", "year", "month"};
}
