package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BasePlateDeployDetails;
import pomplatform.account.bean.ConditionPlateDeployDetails;

public class QueryPlateDeployDetails extends AbstractQuery<BasePlateDeployDetails, ConditionPlateDeployDetails>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateDeployDetails.class);

	public QueryPlateDeployDetails() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pdd.plate_deploy_detail_id");
	}

	@Override
	public BaseCollection<BasePlateDeployDetails> executeQuery( KeyValuePair[] replacements, ConditionPlateDeployDetails condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getPlateDeployRecordId()
			);
	}

	public BaseCollection<BasePlateDeployDetails> runQuery( KeyValuePair[] replacements, ConditionPlateDeployDetails condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getPlateDeployRecordId()
			);
	}

	public BaseCollection<BasePlateDeployDetails> execute( KeyValuePair[] replacements, ConditionPlateDeployDetails condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getPlateDeployRecordId()
			);
	}

	@Override
	public BasePlateDeployDetails generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateDeployDetails __base = new BasePlateDeployDetails();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateDeployDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateDeployRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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

	private final static String __SQLText = "SELECT pdd.plate_deploy_detail_id, pdd.plate_deploy_record_id, pdd.employee_id, d.plate_name, pdd.advance_integral, pdd.advance_date, pdd.operate_time, pdd.operate_employee_id, pdd.remark FROM plate_deploy_details pdd left join employees e on e.employee_id = pdd.employee_id left join plate_records d on e.plate_id = d.plate_id WHERE plate_deploy_record_id = ?" ;
	private final static String __originalSQL = "SELECT pdd.plate_deploy_detail_id, pdd.plate_deploy_record_id, pdd.employee_id, d.plate_name, pdd.advance_integral, pdd.advance_date, pdd.operate_time, pdd.operate_employee_id, pdd.remark FROM plate_deploy_details pdd left join employees e on e.employee_id = pdd.employee_id left join plate_records d on e.plate_id = d.plate_id WHERE plate_deploy_record_id =:plate_deploy_record_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"plate_deploy_record_id =:plate_deploy_record_id\",\"startIndex\": 334,\"stopIndex\":380,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"plate_deploy_record_id =:plate_deploy_record_id\",\"fullFieldName\":\"plate_deploy_record_id\",\"operationName\":\"=\",\"variableName\":\"plateDeployRecordId\",\"startIndex\": 334,\"stopIndex\":380,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "plate_deploy_detail_id,plate_deploy_record_id,employee_id,plate_name,advance_integral,advance_date,operate_time,operate_employee_id,remark";
	private final static String[] fieldNames = { "plate_deploy_record_id"};
}
