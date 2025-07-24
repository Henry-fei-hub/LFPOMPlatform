package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseProjectOfProjectManager;
import pomplatform.project.bean.ConditionProjectOfProjectManager;

public class QueryProjectOfProjectManager extends AbstractQuery<BaseProjectOfProjectManager, ConditionProjectOfProjectManager>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectOfProjectManager.class);

	public QueryProjectOfProjectManager() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("* from ( SELECT a.project_id");
	}

	@Override
	public BaseCollection<BaseProjectOfProjectManager> executeQuery( KeyValuePair[] replacements, ConditionProjectOfProjectManager condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectManageId()
			);
	}

	@Override
	public BaseProjectOfProjectManager generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectOfProjectManager __base = new BaseProjectOfProjectManager();
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

	private final static String __SQLText = "SELECT * from ( SELECT a.project_id, a.project_integral, sum(b.total_amount) as settlement_integral from projects a LEFT JOIN project_settlements b on a.project_id = b.project_id WHERE a.project_manage_id = ? and a.plate_id >= 0 and a.status != 11 group by a.project_id, a.project_integral) a where a.project_integral != a.settlement_integral" ;
	private final static String RESULTSETFIELDLIST = "project_id,project_integral,settlement_integral";
	private final static String[] fieldNames = { "project_manage_id"};
}
