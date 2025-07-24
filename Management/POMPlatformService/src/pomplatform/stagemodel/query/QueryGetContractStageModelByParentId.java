package pomplatform.stagemodel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stagemodel.bean.BaseGetContractStageModelByParentId;
import pomplatform.stagemodel.bean.ConditionGetContractStageModelByParentId;

public class QueryGetContractStageModelByParentId extends AbstractQuery<BaseGetContractStageModelByParentId, ConditionGetContractStageModelByParentId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetContractStageModelByParentId.class);

	public QueryGetContractStageModelByParentId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
//		setOrderByFields("csm.contract_stage_model_id");
	}

	@Override
	public BaseCollection<BaseGetContractStageModelByParentId> executeQuery( KeyValuePair[] replacements, ConditionGetContractStageModelByParentId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractStageModelId()
			);
	}

	@Override
	public BaseGetContractStageModelByParentId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetContractStageModelByParentId __base = new BaseGetContractStageModelByParentId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractStageModelId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageModelId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageModelName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeafNode(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNeedManagerAudit(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setNeedDesignDirectorAudit(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setActualPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setManagerComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setManagerAuditDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDesignDirectorComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignDirectorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignDirectorAuditDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setConfirmDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasEvidence(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setEvidence(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPath(val);
		if((val = __data[count++]) != null) __base.setDepth(GenericBase.__getInt(val));
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

	private final static String __SQLText = "WITH RECURSIVE T (contract_stage_model_id, contract_id, stage_model_id, stage_model_name, percent, parent_id, leaf_node, order_no, need_manager_audit, need_design_director_audit, actual_percent, remark, manager_comment, manager_id, manager_audit_date, design_director_comment, design_director_id, design_director_audit_date, locked, process_status, confirm_date, has_evidence, evidence, year, path, depth)  AS (     SELECT contract_stage_model_id, contract_id, stage_model_id, stage_model_name, percent, parent_id, leaf_node, order_no, need_manager_audit, need_design_director_audit, actual_percent, remark, manager_comment, manager_id, manager_audit_date, design_director_comment, design_director_id, design_director_audit_date, locked, process_status, confirm_date, has_evidence, evidence, year, ARRAY[contract_stage_model_id] AS path, 1 AS depth     FROM contract_stage_models     WHERE contract_stage_model_id = ?       UNION ALL      SELECT a.contract_stage_model_id, a.contract_id, a.stage_model_id, a.stage_model_name, a.percent, a.parent_id, a.leaf_node, a.order_no, a.need_manager_audit, a.need_design_director_audit, a.actual_percent, a.remark, a.manager_comment, a.manager_id, a.manager_audit_date, a.design_director_comment, a.design_director_id, a.design_director_audit_date, a.locked, a.process_status, a.confirm_date, a.has_evidence, a.evidence, a.year, T.path || a.contract_stage_model_id, T.depth + 1 AS depth     FROM contract_stage_models a     JOIN T ON a.parent_id = T.contract_stage_model_id     )     SELECT contract_stage_model_id, contract_id, stage_model_id, stage_model_name, percent, parent_id, leaf_node, order_no, need_manager_audit, need_design_director_audit, actual_percent, remark, manager_comment, manager_id, manager_audit_date, design_director_comment, design_director_id, design_director_audit_date, locked, process_status, confirm_date, has_evidence, evidence, year, path, depth FROM T ORDER BY path" ;
	private final static String RESULTSETFIELDLIST = "contract_stage_model_id,contract_id,stage_model_id,stage_model_name,percent,parent_id,leaf_node,order_no,need_manager_audit,need_design_director_audit,actual_percent,remark,manager_comment,manager_id,manager_audit_date,design_director_comment,design_director_id,design_director_audit_date,locked,process_status,confirm_date,has_evidence,evidence,year,path,depth";
	private final static String[] fieldNames = { "contract_stage_model_id"};
}
