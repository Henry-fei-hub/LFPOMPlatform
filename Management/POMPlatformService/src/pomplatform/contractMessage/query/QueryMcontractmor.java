package pomplatform.contractMessage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractMessage.bean.BaseMcontractmor;
import pomplatform.contractMessage.bean.ConditionMcontractmor;

public class QueryMcontractmor extends AbstractQuery<BaseMcontractmor, ConditionMcontractmor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontractmor.class);

	public QueryMcontractmor() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT b.main_project_id");
	}

	@Override
	public BaseCollection<BaseMcontractmor> executeQuery( KeyValuePair[] replacements, ConditionMcontractmor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements
			);
	}

	public BaseCollection<BaseMcontractmor> runQuery( KeyValuePair[] replacements, ConditionMcontractmor condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements
			);
	}

	public BaseCollection<BaseMcontractmor> execute( KeyValuePair[] replacements, ConditionMcontractmor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements
			);
	}

	@Override
	public BaseMcontractmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontractmor __base = new BaseMcontractmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractMessageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
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
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT DISTINCT b.main_project_id, C.contract_message_id, A.contract_code, A.contract_name, A.contract_id FROM contract_messages C LEFT JOIN contracts AS A ON C.contract_id = A.contract_id AND C.msg_status = 1 LEFT JOIN main_projects b ON A.contract_code = b.project_code WHERE b.main_project_id > 0 AND A.contract_id >0" ;
	private final static String __originalSQL = "SELECT DISTINCT b.main_project_id, C.contract_message_id, A.contract_code, A.contract_name, A.contract_id FROM contract_messages C LEFT JOIN contracts AS A ON C.contract_id = A.contract_id AND C.msg_status = 1 LEFT JOIN main_projects b ON A.contract_code = b.project_code WHERE b.main_project_id > 0 AND A.contract_id >0";
	private final static String[] __queryConditions = new String[0];
	private final static String RESULTSETFIELDLIST = "main_project_id,contract_message_id,contract_code,contract_name,contract_id";
	private final static String[] fieldNames = { };
}
