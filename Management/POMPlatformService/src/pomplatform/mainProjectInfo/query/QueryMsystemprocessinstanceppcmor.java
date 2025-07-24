package pomplatform.mainProjectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjectInfo.bean.BaseMsystemprocessinstanceppcmor;
import pomplatform.mainProjectInfo.bean.ConditionMsystemprocessinstanceppcmor;

public class QueryMsystemprocessinstanceppcmor extends AbstractQuery<BaseMsystemprocessinstanceppcmor, ConditionMsystemprocessinstanceppcmor>
{

	private static final Logger __logger = Logger.getLogger(QueryMsystemprocessinstanceppcmor.class);

	public QueryMsystemprocessinstanceppcmor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.contract_id");
	}

	@Override
	public BaseCollection<BaseMsystemprocessinstanceppcmor> executeQuery( KeyValuePair[] replacements, ConditionMsystemprocessinstanceppcmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getContractId(), 
				condition.getMainProjectId(), 
				condition.getInfoCode()
			);
	}

	@Override
	public BaseMsystemprocessinstanceppcmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMsystemprocessinstanceppcmor __base = new BaseMsystemprocessinstanceppcmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "SELECT c.contract_id,spi.process_status FROM system_process_instances spi LEFT JOIN personnel_business pb ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type left join contracts c on c.contract_id = pb.link_id WHERE spi.process_type = 73 AND pb.project_id =? AND pb.link_id =? AND pb.duty_id =? and c.info_code =? AND pb.delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "contract_id,process_status";
	private final static String[] fieldNames = { "project_id", "contract_id", "main_project_id", "info_code"};
}
