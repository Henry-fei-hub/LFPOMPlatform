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
import pomplatform.ProjectStages.bean.BaseProjectStagesProcessApplication;
import pomplatform.ProjectStages.bean.ConditionProjectStagesProcessApplication;

public class QueryProjectStagesProcessApplication extends AbstractQuery<BaseProjectStagesProcessApplication, ConditionProjectStagesProcessApplication>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectStagesProcessApplication.class);

	public QueryProjectStagesProcessApplication() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("project_stage_process_record_id");
	}

	public static BaseProjectStagesProcessApplication selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseProjectStagesProcessApplication> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseProjectStagesProcessApplication selectOne(ConditionProjectStagesProcessApplication c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseProjectStagesProcessApplication> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseProjectStagesProcessApplication> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseProjectStagesProcessApplication> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseProjectStagesProcessApplication> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionProjectStagesProcessApplication c = new ConditionProjectStagesProcessApplication();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryProjectStagesProcessApplication dao = new QueryProjectStagesProcessApplication();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseProjectStagesProcessApplication> select(ConditionProjectStagesProcessApplication c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QueryProjectStagesProcessApplication dao = new QueryProjectStagesProcessApplication();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseProjectStagesProcessApplication> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseProjectStagesProcessApplication> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseProjectStagesProcessApplication> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionProjectStagesProcessApplication c = new ConditionProjectStagesProcessApplication();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryProjectStagesProcessApplication dao = new QueryProjectStagesProcessApplication();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseProjectStagesProcessApplication> executeQuery( KeyValuePair[] replacements, ConditionProjectStagesProcessApplication condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProjectStageProcessRecordId(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseProjectStagesProcessApplication> runQuery( KeyValuePair[] replacements, ConditionProjectStagesProcessApplication condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProjectStageProcessRecordId(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseProjectStagesProcessApplication> execute( KeyValuePair[] replacements, ConditionProjectStagesProcessApplication condition ) throws java.sql.SQLException {
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
	public BaseProjectStagesProcessApplication generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectStagesProcessApplication __base = new BaseProjectStagesProcessApplication();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectStageProcessRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectAmountSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApplyAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCurrentApplyRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApplyRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemainingRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemainingAmount(GenericBase.__getDecimal(val));
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

	public final static String __SQLText = "SELECT pspr.project_stage_process_record_id, pspr.contract_id, pspr.main_project_id, pspr.project_name, pspr.project_code, ps.project_amount_sum, pspr.apply_amount, pspr.file_id, pspr.file_url, pspr.remark, pspr.employee_id, pspr.employee_no, pspr.create_time, COALESCE ( pspr.current_apply_rate, 0 ) AS current_apply_rate, COALESCE ( aa.percent, 0 ) AS apply_rate, 100 - COALESCE ( aa.percent, 0 ) - COALESCE ( pspr.current_apply_rate, 0 ) AS remaining_rate, COALESCE ( ps.project_amount_sum, 0 ) - COALESCE ( aa.project_amount, 0 ) - COALESCE ( pspr.apply_amount, 0 ) AS remaining_amount FROM project_stage_process_records pspr LEFT JOIN ( SELECT contract_id, SUM ( project_amount ) AS project_amount_sum FROM project_stages GROUP BY contract_id ) AS ps ON pspr.contract_id = ps.contract_id LEFT JOIN ( SELECT contract_id, SUM ( percent ) AS percent, SUM ( project_amount ) AS project_amount FROM project_stages WHERE contract_id > 0 AND status = 2 GROUP BY contract_id ) AS aa ON aa.contract_id = ps.contract_id WHERE pspr.project_stage_process_record_id = ? and pspr.contract_id = ?" ;
	public final static String __originalSQL = "SELECT pspr.project_stage_process_record_id, pspr.contract_id, pspr.main_project_id, pspr.project_name, pspr.project_code, ps.project_amount_sum, pspr.apply_amount, pspr.file_id, pspr.file_url, pspr.remark, pspr.employee_id, pspr.employee_no, pspr.create_time, COALESCE ( pspr.current_apply_rate, 0 ) AS current_apply_rate, COALESCE ( aa.percent, 0 ) AS apply_rate, 100 - COALESCE ( aa.percent, 0 ) - COALESCE ( pspr.current_apply_rate, 0 ) AS remaining_rate, COALESCE ( ps.project_amount_sum, 0 ) - COALESCE ( aa.project_amount, 0 ) - COALESCE ( pspr.apply_amount, 0 ) AS remaining_amount FROM project_stage_process_records pspr LEFT JOIN ( SELECT contract_id, SUM ( project_amount ) AS project_amount_sum FROM project_stages GROUP BY contract_id ) AS ps ON pspr.contract_id = ps.contract_id LEFT JOIN ( SELECT contract_id, SUM ( percent ) AS percent, SUM ( project_amount ) AS project_amount FROM project_stages WHERE contract_id > 0 AND status = 2 GROUP BY contract_id ) AS aa ON aa.contract_id = ps.contract_id WHERE pspr.project_stage_process_record_id = :project_stage_process_record_id AND pspr.contract_id = :contract_id";
	private final static String RESULTSETFIELDLIST = "project_stage_process_record_id,contract_id,main_project_id,project_name,project_code,project_amount_sum,apply_amount,file_id,file_url,remark,employee_id,employee_no,create_time,current_apply_rate,apply_rate,remaining_rate,remaining_amount";
	private final static String[] fieldNames = { "project_stage_process_record_id", "contract_id"};
}
