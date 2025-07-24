package pomplatform.stagemodel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stagemodel.bean.BaseGetStageModelByParentId;
import pomplatform.stagemodel.bean.ConditionGetStageModelByParentId;

public class QueryGetStageModelByParentId extends AbstractQuery<BaseGetStageModelByParentId, ConditionGetStageModelByParentId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetStageModelByParentId.class);

	public QueryGetStageModelByParentId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("s.stage_model_id");
	}

	@Override
	public BaseCollection<BaseGetStageModelByParentId> executeQuery( KeyValuePair[] replacements, ConditionGetStageModelByParentId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStageModelId()
			);
	}

	@Override
	public BaseGetStageModelByParentId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetStageModelByParentId __base = new BaseGetStageModelByParentId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setStageModelId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageModelName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeafNode(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNeedManagerAudit(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setNeedDesignDirectorAudit(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "WITH RECURSIVE T (stage_model_id, stage_model_name, percent, parent_id, leaf_node, order_no, need_manager_audit, need_design_director_audit, remark, path, depth)  AS (     SELECT stage_model_id, stage_model_name, percent, parent_id, leaf_node, order_no, need_manager_audit, need_design_director_audit, remark, ARRAY[stage_model_id] AS path, 1 AS depth     FROM stage_models     WHERE parent_id = 0 and stage_model_id = ?       UNION ALL      SELECT sm.stage_model_id, sm.stage_model_name, sm.percent, sm.parent_id, sm.leaf_node, sm.order_no, sm.need_manager_audit, sm.need_design_director_audit, sm.remark, T.path || sm.stage_model_id, T.depth + 1 AS depth     FROM stage_models sm     JOIN T ON sm.parent_id = T.stage_model_id     )     SELECT stage_model_id, stage_model_name, percent, parent_id, leaf_node, order_no, need_manager_audit, need_design_director_audit, remark, path, depth FROM T ORDER BY path" ;
	private final static String RESULTSETFIELDLIST = "stage_model_id,stage_model_name,percent,parent_id,leaf_node,order_no,need_manager_audit,need_design_director_audit,remark,path,depth";
	private final static String[] fieldNames = { "stage_model_id"};
}
