package pomplatform.ProjectStages.query;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.List;
import delicacy.common.CommonUtils;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ProjectStages.bean.BaseLoadCurrentProjectStageProcessDetail;
import pomplatform.ProjectStages.bean.ConditionLoadCurrentProjectStageProcessDetail;

public class QueryLoadCurrentProjectStageProcessDetail extends AbstractQuery<BaseLoadCurrentProjectStageProcessDetail, ConditionLoadCurrentProjectStageProcessDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryLoadCurrentProjectStageProcessDetail.class);

	public QueryLoadCurrentProjectStageProcessDetail() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("project_stage_id");
	}

	public static BaseLoadCurrentProjectStageProcessDetail selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseLoadCurrentProjectStageProcessDetail> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseLoadCurrentProjectStageProcessDetail selectOne(ConditionLoadCurrentProjectStageProcessDetail c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseLoadCurrentProjectStageProcessDetail> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseLoadCurrentProjectStageProcessDetail> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseLoadCurrentProjectStageProcessDetail> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseLoadCurrentProjectStageProcessDetail> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionLoadCurrentProjectStageProcessDetail c = new ConditionLoadCurrentProjectStageProcessDetail();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryLoadCurrentProjectStageProcessDetail dao = new QueryLoadCurrentProjectStageProcessDetail();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseLoadCurrentProjectStageProcessDetail> select(ConditionLoadCurrentProjectStageProcessDetail c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QueryLoadCurrentProjectStageProcessDetail dao = new QueryLoadCurrentProjectStageProcessDetail();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseLoadCurrentProjectStageProcessDetail> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseLoadCurrentProjectStageProcessDetail> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseLoadCurrentProjectStageProcessDetail> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionLoadCurrentProjectStageProcessDetail c = new ConditionLoadCurrentProjectStageProcessDetail();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryLoadCurrentProjectStageProcessDetail dao = new QueryLoadCurrentProjectStageProcessDetail();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseLoadCurrentProjectStageProcessDetail> executeQuery( KeyValuePair[] replacements, ConditionLoadCurrentProjectStageProcessDetail condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProjectStageProcessRecordId(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseLoadCurrentProjectStageProcessDetail> runQuery( KeyValuePair[] replacements, ConditionLoadCurrentProjectStageProcessDetail condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProjectStageProcessRecordId(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseLoadCurrentProjectStageProcessDetail> execute( KeyValuePair[] replacements, ConditionLoadCurrentProjectStageProcessDetail condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProjectStageProcessRecordId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseLoadCurrentProjectStageProcessDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLoadCurrentProjectStageProcessDetail __base = new BaseLoadCurrentProjectStageProcessDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAmountEd(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsSure(GenericBase.__getInt(val));
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
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	public final static String __SQLText = "SELECT ps.project_stage_id, ps.stage_id, ps.percent, ps.stage_name, ps.remark, ps.main_project_id, ps.contract_id, ps.status, CASE WHEN ps.status = 1 THEN ps.project_amount ELSE 0 END AS project_amount, CASE WHEN ps.status = 2 THEN ps.project_amount ELSE 0 END AS project_amount_ed , case when a.project_stage_process_detail_id is not null then 1 else 0 END AS is_sure FROM project_stages ps LEFT JOIN project_stage_process_details a on a.stage_id = ps.stage_id and a.project_stage_process_record_id = ? WHERE ps.contract_id > 0 and ps.contract_id = ? and ps.status IN ( 1, 2, 3 )" ;
	public final static String __originalSQL = "SELECT ps.project_stage_id, ps.stage_id, ps.percent, ps.stage_name, ps.remark, ps.main_project_id, ps.contract_id, ps.status, CASE WHEN ps.status = 1 THEN ps.project_amount ELSE 0 END AS project_amount, CASE WHEN ps.status = 2 THEN ps.project_amount ELSE 0 END AS project_amount_ed , case when a.project_stage_process_detail_id is not null then 1 else 0 END AS is_sure FROM project_stages ps LEFT JOIN project_stage_process_details a on a.stage_id = ps.stage_id and a.project_stage_process_record_id =:project_stage_process_record_id WHERE ps.contract_id > 0 AND ps.contract_id =:contract_id AND ps.status IN ( 1, 2, 3 )";
	private final static String RESULTSETFIELDLIST = "project_stage_id,stage_id,percent,stage_name,remark,main_project_id,contract_id,status,project_amount,project_amount_ed,is_sure";
	private final static String[] fieldNames = { "project_stage_process_record_id", "contract_id"};
}
