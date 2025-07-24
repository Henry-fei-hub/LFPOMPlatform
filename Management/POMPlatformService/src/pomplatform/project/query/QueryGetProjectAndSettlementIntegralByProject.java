package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseGetProjectAndSettlementIntegralByProject;
import pomplatform.project.bean.ConditionGetProjectAndSettlementIntegralByProject;

public class QueryGetProjectAndSettlementIntegralByProject extends AbstractQuery<BaseGetProjectAndSettlementIntegralByProject, ConditionGetProjectAndSettlementIntegralByProject>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectAndSettlementIntegralByProject.class);

	public QueryGetProjectAndSettlementIntegralByProject() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseGetProjectAndSettlementIntegralByProject> executeQuery( KeyValuePair[] replacements, ConditionGetProjectAndSettlementIntegralByProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseGetProjectAndSettlementIntegralByProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectAndSettlementIntegralByProject __base = new BaseGetProjectAndSettlementIntegralByProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT p.project_id, p.project_integral, sum(ps.total_amount) as settlement_integral from projects p LEFT JOIN project_settlements ps on p.project_id = ps.project_id where p.project_id = ? GROUP BY p.project_id, p.project_integral" ;
	private final static String RESULTSETFIELDLIST = "project_id,project_integral,settlement_integral";
	private final static String[] fieldNames = { "project_id"};
}
