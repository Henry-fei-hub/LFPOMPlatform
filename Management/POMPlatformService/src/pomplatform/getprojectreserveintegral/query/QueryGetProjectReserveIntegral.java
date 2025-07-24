package pomplatform.getprojectreserveintegral.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.getprojectreserveintegral.bean.BaseGetProjectReserveIntegral;
import pomplatform.getprojectreserveintegral.bean.ConditionGetProjectReserveIntegral;

public class QueryGetProjectReserveIntegral extends AbstractQuery<BaseGetProjectReserveIntegral, ConditionGetProjectReserveIntegral>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectReserveIntegral.class);

	public QueryGetProjectReserveIntegral() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("(SELECT sum(total_amount)");
	}

	@Override
	public BaseCollection<BaseGetProjectReserveIntegral> executeQuery( KeyValuePair[] replacements, ConditionGetProjectReserveIntegral condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseGetProjectReserveIntegral generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectReserveIntegral __base = new BaseGetProjectReserveIntegral();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT (SELECT (CASE WHEN SUM(total_amount) is NULL THEN 0 ELSE SUM(total_amount) END) from project_settlements ps WHERE ps.project_id = p.project_id)/(case when p.project_integral =0 OR p.project_integral is NULL then 1 ELSE p.project_integral END)*(CASE WHEN p.project_integral =0 OR p.project_integral is NULL then 0 ELSE ((SELECT (CASE WHEN SUM(assign_integral) is NULL THEN 0 ELSE SUM(assign_integral) END) from project_integral_assign_records WHERE project_id = p.project_id)+p.reserve_integral+(SELECT (CASE WHEN SUM(transfer_integral) is NULL THEN 0 ELSE SUM(transfer_integral) END) from project_integral_transfer_records WHERE from_project_id = p.project_id)) END)-(SELECT (CASE WHEN SUM(assign_integral) is NULL THEN 0 ELSE SUM(assign_integral) END) from project_integral_assign_records WHERE project_id = p.project_id)-(SELECT (CASE WHEN SUM(transfer_integral) is NULL THEN 0 ELSE SUM(transfer_integral) END) from project_integral_transfer_records WHERE from_project_id = p.project_id) as integral from projects p WHERE p.project_id = ?" ;
	private final static String RESULTSETFIELDLIST = "integral";
	private final static String[] fieldNames = { "project_id"};
}
