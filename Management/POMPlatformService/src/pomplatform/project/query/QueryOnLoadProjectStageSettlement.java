package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadProjectStageSettlement;
import pomplatform.project.bean.ConditionOnLoadProjectStageSettlement;

public class QueryOnLoadProjectStageSettlement extends AbstractQuery<BaseOnLoadProjectStageSettlement, ConditionOnLoadProjectStageSettlement>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectStageSettlement.class);

	public QueryOnLoadProjectStageSettlement() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .project_stage_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectStageSettlement> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectStageSettlement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getStageId()
			);
	}

	@Override
	public BaseOnLoadProjectStageSettlement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectStageSettlement __base = new BaseOnLoadProjectStageSettlement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAttachmentNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStagePlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectTemplateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT A .project_stage_id, A.project_id, A.stage_id, A.percent, A.project_amount, A.stage_name, ( SELECT SUM ( total_amount ) AS settlement_integral FROM project_settlements WHERE project_id = A.project_id AND stage_id = A.stage_id AND settlement_status = 2 GROUP BY project_id, stage_id ), ( SELECT COUNT ( project_attachment_id ) AS attachment_num FROM project_attachments WHERE project_id = A.project_id AND stage_id = A.stage_id ), ( SELECT COUNT ( settlement_id ) AS settlement_num FROM project_settlements WHERE project_id = A.project_id ), ( SELECT SUM ( plan_integral ) AS stage_plan_integral FROM project_employees WHERE project_id = A.project_id AND stage_id = A.stage_id GROUP BY project_id, stage_id ), A.remark, A.project_template_id FROM project_stages A WHERE A.project_id =? AND A.stage_id =? ORDER BY project_stage_id,stage_id ASC" ;
	private final static String RESULTSETFIELDLIST = "project_stage_id,project_id,stage_id,percent,project_amount,stage_name,settlement_integral,attachment_num,settlement_num,stage_plan_integral,remark,project_template_id";
	private final static String[] fieldNames = { "project_id", "stage_id"};
}
