package pomplatform.stagemodel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stagemodel.bean.BaseContractStageAuditManager;
import pomplatform.stagemodel.bean.ConditionContractStageAuditManager;

public class QueryContractStageAuditManager extends AbstractQuery<BaseContractStageAuditManager, ConditionContractStageAuditManager>
{

	private static final Logger __logger = Logger.getLogger(QueryContractStageAuditManager.class);

	public QueryContractStageAuditManager() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_stage_model_id");
	}

	@Override
	public BaseCollection<BaseContractStageAuditManager> executeQuery( KeyValuePair[] replacements, ConditionContractStageAuditManager condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getLocked()
			);
	}

	@Override
	public BaseContractStageAuditManager generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractStageAuditManager __base = new BaseContractStageAuditManager();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractStageModelId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStageModelName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setAuditStatus(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[4]));
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

	private final static String __SQLText = "SELECT a.contract_stage_model_id, a.contract_id, b.contract_code, b.contract_name, a.stage_model_name, a.locked, case when a.manager_audit_date is null then '1' else '2' end as audit_status from contract_stage_models a LEFT JOIN contracts b on a.contract_id = b.contract_id where a.need_manager_audit = true and a.manager_id = ? and a.contract_id = ? and b.contract_code like ? and b.contract_name like ? and a.locked = ? order by contract_stage_model_id desc" ;
	private final static String RESULTSETFIELDLIST = "contract_stage_model_id,contract_id,contract_code,contract_name,stage_model_name,locked,audit_status";
	private final static String[] fieldNames = { "employee_id", "contract_id", "contract_code", "contract_name", "locked"};
}
