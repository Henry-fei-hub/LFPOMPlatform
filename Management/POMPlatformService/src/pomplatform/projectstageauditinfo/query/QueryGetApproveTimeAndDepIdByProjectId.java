package pomplatform.projectstageauditinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectstageauditinfo.bean.BaseGetApproveTimeAndDepIdByProjectId;
import pomplatform.projectstageauditinfo.bean.ConditionGetApproveTimeAndDepIdByProjectId;

public class QueryGetApproveTimeAndDepIdByProjectId extends AbstractQuery<BaseGetApproveTimeAndDepIdByProjectId, ConditionGetApproveTimeAndDepIdByProjectId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetApproveTimeAndDepIdByProjectId.class);

	public QueryGetApproveTimeAndDepIdByProjectId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.project_approval_time");
	}

	@Override
	public BaseCollection<BaseGetApproveTimeAndDepIdByProjectId> executeQuery( KeyValuePair[] replacements, ConditionGetApproveTimeAndDepIdByProjectId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseGetApproveTimeAndDepIdByProjectId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetApproveTimeAndDepIdByProjectId __base = new BaseGetApproveTimeAndDepIdByProjectId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractSigningStatus(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select b.project_approval_time, c.department_id, a.contract_signing_status from contracts a LEFT JOIN main_projects b on a.info_code = b.info_code LEFT JOIN departments c on b.project_sales_team = c.department_name and c.delete_flag = 0 where contract_id = (select contract_id from projects where project_id = ?)" ;
	private final static String RESULTSETFIELDLIST = "project_approval_time,department_id,contract_signing_status";
	private final static String[] fieldNames = { "project_id"};
}
