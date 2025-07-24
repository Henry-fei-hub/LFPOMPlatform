package pomplatform.mainProjectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjectInfo.bean.BaseMcontractpmcior;
import pomplatform.mainProjectInfo.bean.ConditionMcontractpmcior;

public class QueryMcontractpmcior extends AbstractQuery<BaseMcontractpmcior, ConditionMcontractpmcior>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontractpmcior.class);

	public QueryMcontractpmcior() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.contract_id");
	}

	@Override
	public BaseCollection<BaseMcontractpmcior> executeQuery( KeyValuePair[] replacements, ConditionMcontractpmcior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getInfoCode()
			);
	}

	@Override
	public BaseMcontractpmcior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontractpmcior __base = new BaseMcontractpmcior();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT A.contract_id, A.info_code, b.project_id, b.project_code, b.project_name, d.design_team, A.customer_name, C.main_project_id FROM contracts A LEFT JOIN projects b ON A.contract_id = b.contract_id LEFT JOIN main_projects C ON b.project_code = C.project_code  left join pre_projects d on d.info_code =a.info_code  WHERE A.contract_id =? AND A.info_code =? AND b.project_type = 66" ;
	private final static String RESULTSETFIELDLIST = "contract_id,info_code,project_id,project_code,project_name,design_team,customer_name,main_project_id";
	private final static String[] fieldNames = { "contract_id", "info_code"};
}
