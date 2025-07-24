package pomplatform.stagemodel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stagemodel.bean.BaseContractStageProcessStatusList;
import pomplatform.stagemodel.bean.ConditionContractStageProcessStatusList;

public class QueryContractStageProcessStatusList extends AbstractQuery<BaseContractStageProcessStatusList, ConditionContractStageProcessStatusList>
{

	private static final Logger __logger = Logger.getLogger(QueryContractStageProcessStatusList.class);

	public QueryContractStageProcessStatusList() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_stage_model_id");
	}

	@Override
	public BaseCollection<BaseContractStageProcessStatusList> executeQuery( KeyValuePair[] replacements, ConditionContractStageProcessStatusList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessStatus(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getManagerId(), 
				condition.getDesignDirectorId()
			);
	}

	@Override
	public BaseContractStageProcessStatusList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractStageProcessStatusList __base = new BaseContractStageProcessStatusList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractStageModelId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStageModelName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setManagerId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setManageAuditStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignDirectorId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignDirectorAuditStatus(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT a.contract_stage_model_id, a.contract_id, b.contract_code, b.contract_name, concat(c.stage_model_name,'-',a.stage_model_name) as stage_model_name, case when a.need_manager_audit = false then null else cast(a.manager_id as varchar) end as manager_id, case when a.need_manager_audit = true and a.manager_audit_date is not null then '已审批' when a.need_manager_audit = true and a.manager_audit_date is null then '未审批' else null end as manage_audit_status, case when a.need_design_director_audit = true then cast (a.design_director_id as varchar) else null end as design_director_id, case when a.need_design_director_audit = true and a.design_director_audit_date is not null then '已审批' when a.need_design_director_audit = true and a.design_director_audit_date is null then '未审批' else null end as design_director_audit_status, a.process_status from contract_stage_models a LEFT JOIN contracts b on a.contract_id = b.contract_id LEFT JOIN contract_stage_models c on a.parent_id = c.contract_stage_model_id where a.process_status in (1,3) and a.process_status = ? and a.contract_id = ? and b.contract_code like ? and b.contract_name like ? and a.manager_id = ? and a.design_director_id = ? order by a.process_status" ;
	private final static String RESULTSETFIELDLIST = "contract_stage_model_id,contract_id,contract_code,contract_name,stage_model_name,manager_id,manage_audit_status,design_director_id,design_director_audit_status,process_status";
	private final static String[] fieldNames = { "process_status", "contract_id", "contract_code", "contract_name", "manager_id", "design_director_id"};
}
