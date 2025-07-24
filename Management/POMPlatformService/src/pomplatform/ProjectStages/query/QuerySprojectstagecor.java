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
import pomplatform.ProjectStages.bean.BaseSprojectstagecor;
import pomplatform.ProjectStages.bean.ConditionSprojectstagecor;

public class QuerySprojectstagecor extends AbstractQuery<BaseSprojectstagecor, ConditionSprojectstagecor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectstagecor.class);

	public QuerySprojectstagecor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("project_stage_id");
	}

	public static BaseCollection<BaseSprojectstagecor> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseSprojectstagecor> select(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionSprojectstagecor c = new ConditionSprojectstagecor();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QuerySprojectstagecor dao = new QuerySprojectstagecor();
		return dao.runQuery(replacements, c);
	}


	public static List<BaseSprojectstagecor> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseSprojectstagecor> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionSprojectstagecor c = new ConditionSprojectstagecor();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QuerySprojectstagecor dao = new QuerySprojectstagecor();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseSprojectstagecor> executeQuery( KeyValuePair[] replacements, ConditionSprojectstagecor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseSprojectstagecor> runQuery( KeyValuePair[] replacements, ConditionSprojectstagecor condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseSprojectstagecor> execute( KeyValuePair[] replacements, ConditionSprojectstagecor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseSprojectstagecor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectstagecor __base = new BaseSprojectstagecor();
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
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT ps.project_stage_id, ps.stage_id, ps.percent, ps.stage_name, ps.remark, ps.main_project_id, ps.contract_id, ps.status, CASE WHEN ps.status = 1 THEN ps.project_amount ELSE 0 END AS project_amount, CASE WHEN ps.status = 2 THEN ps.project_amount ELSE 0 END AS project_amount_ed FROM project_stages ps WHERE ps.contract_id > 0 and ps.contract_id = ? and ps.status IN ( 1, 2, 3)" ;
	private final static String __originalSQL = "SELECT ps.project_stage_id, ps.stage_id, ps.percent, ps.stage_name, ps.remark, ps.main_project_id, ps.contract_id, ps.status, CASE WHEN ps.status = 1 THEN ps.project_amount ELSE 0 END AS project_amount, CASE WHEN ps.status = 2 THEN ps.project_amount ELSE 0 END AS project_amount_ed FROM project_stages ps WHERE ps.contract_id > 0 AND ps.contract_id =:contract_id AND ps.status IN ( 1, 2, 3)";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"ps.contract_id > 0 AND ps.contract_id =:contract_id AND ps.status IN ( 1, 2, 3)\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":305,\"endIndex\":309},\"startIndex\": 311,\"stopIndex\":389,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": contractId,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"ps.contract_id > 0\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"WHERE\",\"startIndex\":305,\"endIndex\":309},\"startIndex\": 311,\"stopIndex\":328,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"ps.contract_id =:contract_id\",\"fullFieldName\":\"ps.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"nextToken\":\"AND\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":330,\"endIndex\":332},\"startIndex\": 334,\"stopIndex\":361,\"variableNum\": 0,\"includeStaticCondition\": False,\"conditionNames\": contractId,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"ps.status IN ( 1, 2, 3)\",\"previousToken\":{\"tokenName\":\"AND\",\"startIndex\":363,\"endIndex\":365},\"startIndex\": 367,\"stopIndex\":389,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_stage_id,stage_id,percent,stage_name,remark,main_project_id,contract_id,status,project_amount,project_amount_ed";
	private final static String[] fieldNames = { "contract_id"};
}
