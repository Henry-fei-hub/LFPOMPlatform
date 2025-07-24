package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadProjectChangeList;
import pomplatform.project.bean.ConditionOnLoadProjectChangeList;

public class QueryOnLoadProjectChangeList extends AbstractQuery<BaseOnLoadProjectChangeList, ConditionOnLoadProjectChangeList>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectChangeList.class);

	public QueryOnLoadProjectChangeList() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id as idd");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectChangeList> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectChangeList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectManageId()
			);
	}

	@Override
	public BaseOnLoadProjectChangeList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectChangeList __base = new BaseOnLoadProjectChangeList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setIdd(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVal(GenericBase.__getString(val));
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

	private final static String __SQLText = "select a.project_id as idd,b.contract_code||'--'||b.project_name as val from project_contract_changes a left join projects b on a.project_id = b.project_id where a.is_completed = false and b.project_manage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "idd,val";
	private final static String[] fieldNames = { "project_manage_id"};
}
