package pomplatform.projectReportRecordDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectReportRecordDetail.bean.BaseProjectBuyCosts;
import pomplatform.projectReportRecordDetail.bean.ConditionProjectBuyCosts;

public class QueryProjectBuyCosts extends AbstractQuery<BaseProjectBuyCosts, ConditionProjectBuyCosts>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectBuyCosts.class);

	public QueryProjectBuyCosts() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseProjectBuyCosts> executeQuery( KeyValuePair[] replacements, ConditionProjectBuyCosts condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getProjectName(), 
				condition.getStatus(), 
				condition.getProjectId()
			);
	}

	@Override
	public BaseProjectBuyCosts generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectBuyCosts __base = new BaseProjectBuyCosts();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCostIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT a.project_id,a.contract_code,a.project_name,c.customer_name,a.plate_id, a.department_id,a.design_phase,a.project_code,c.contract_name, a.plan_start_date,a.plan_end_date,a.start_date,a.end_date,a.status,a.common_area,a.logistics_area,a.percentage,a.total_integral,a.reserve_integral, CASE WHEN sum(b.amount) is null THEN 0 ELSE sum(b.amount) END as cost_integral, a.total_integral-sum(b.amount) as left_integral,a.project_description,a.project_level,a.project_manage_id,a.department_manager_id,a.plate_manager_id FROM projects a LEFT JOIN project_cost b ON a.project_id = b.project_id LEFT JOIN contracts c ON a.contract_id = c.contract_id WHERE a.project_type = 30 AND a.contract_code like ? AND a.project_name like ? AND a.status = ? AND a.project_id = ? GROUP BY a.project_id,c.contract_name,c.customer_name" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_name,customer_name,plate_id,department_id,design_phase,project_code,contract_name,plan_start_date,plan_end_date,start_date,end_date,status,common_area,logistics_area,percentage,total_integral,reserve_integral,cost_integral,left_integral,project_description,project_level,project_manage_id,department_manager_id,plate_manager_id";
	private final static String[] fieldNames = { "contract_code", "project_name", "status", "project_id"};
}
