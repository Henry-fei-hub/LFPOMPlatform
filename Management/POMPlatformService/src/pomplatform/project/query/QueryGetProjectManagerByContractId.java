package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseGetProjectManagerByContractId;
import pomplatform.project.bean.ConditionGetProjectManagerByContractId;

public class QueryGetProjectManagerByContractId extends AbstractQuery<BaseGetProjectManagerByContractId, ConditionGetProjectManagerByContractId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectManagerByContractId.class);

	public QueryGetProjectManagerByContractId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("distinct a.project_manage_id");
	}

	@Override
	public BaseCollection<BaseGetProjectManagerByContractId> executeQuery( KeyValuePair[] replacements, ConditionGetProjectManagerByContractId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseGetProjectManagerByContractId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectManagerByContractId __base = new BaseGetProjectManagerByContractId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManagerWeixin(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select b.employee_id as project_manage_id, b.company_weixin as project_manager_weixin, a.plate_id from projects a LEFT JOIN employees b on a.project_manage_id = b.employee_id and b.status = 0 where a.contract_id = ? " ;
	private final static String RESULTSETFIELDLIST = "project_manage_id,project_manager_weixin,plate_id";
	private final static String[] fieldNames = { "contract_id"};
}
