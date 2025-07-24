package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseGetContractCodeNum;
import pomplatform.preProjects.bean.ConditionGetContractCodeNum;

public class QueryGetContractCodeNum extends AbstractQuery<BaseGetContractCodeNum, ConditionGetContractCodeNum>
{

	private static final Logger __logger = Logger.getLogger(QueryGetContractCodeNum.class);

	public QueryGetContractCodeNum() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("MAX(CAST(substring(project_code");
	}

	@Override
	public BaseCollection<BaseGetContractCodeNum> executeQuery( KeyValuePair[] replacements, ConditionGetContractCodeNum condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectCode()
			);
	}

	@Override
	public BaseGetContractCodeNum generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetContractCodeNum __base = new BaseGetContractCodeNum();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "SELECT MAX(CAST(substring(project_code,7,3) AS INTEGER))+1 as num FROM contracts WHERE project_code like ? AND LENGTH(project_code) = 9" ;
	private final static String RESULTSETFIELDLIST = "num";
	private final static String[] fieldNames = { "project_code"};
}
