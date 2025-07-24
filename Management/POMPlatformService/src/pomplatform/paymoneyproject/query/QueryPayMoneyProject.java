package pomplatform.paymoneyproject.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.paymoneyproject.bean.BasePayMoneyProject;
import pomplatform.paymoneyproject.bean.ConditionPayMoneyProject;

public class QueryPayMoneyProject extends AbstractQuery<BasePayMoneyProject, ConditionPayMoneyProject>
{

	private static final Logger __logger = Logger.getLogger(QueryPayMoneyProject.class);

	public QueryPayMoneyProject() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .project_id");
	}

	@Override
	public BaseCollection<BasePayMoneyProject> executeQuery( KeyValuePair[] replacements, ConditionPayMoneyProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectType(), 
				condition.getContractCode(), 
				condition.getProjectName(), 
				condition.getStatus(), 
				condition.getProjectId()
			);
	}

	@Override
	public BasePayMoneyProject generateBase(Object[] __data) throws java.sql.SQLException {
		BasePayMoneyProject __base = new BasePayMoneyProject();
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
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT A.project_id, A.contract_code, A.project_name, C.customer_name, A.plate_id, A.department_id, A.design_phase, A.project_code, C.contract_name, A.plan_start_date, A.plan_end_date, A.start_date, A.end_date, A.status, A.common_area, A.logistics_area, A.percentage, A.total_integral, A.project_integral, A.reserve_integral, CASE WHEN SUM (b.amount) IS NULL THEN 0 ELSE SUM (b.amount) END AS cost_integral, A.total_integral - SUM (b.amount) AS left_integral, A.project_description, A.project_level, A.project_manage_id, A.department_manager_id, A.plate_manager_id FROM projects A LEFT JOIN project_cost b ON A.project_id = b.project_id LEFT JOIN contracts C ON A.contract_id = C.contract_id WHERE A.project_type =? AND A.contract_code LIKE ? AND A.project_name LIKE ? AND A.status =? AND A.project_id =? GROUP BY A.project_id, C.contract_name, C.customer_name" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_name,customer_name,plate_id,department_id,design_phase,project_code,contract_name,plan_start_date,plan_end_date,start_date,end_date,status,common_area,logistics_area,percentage,total_integral,project_integral,reserve_integral,cost_integral,left_integral,project_description,project_level,project_manage_id,department_manager_id,plate_manager_id";
	private final static String[] fieldNames = { "project_type", "contract_code", "project_name", "status", "project_id"};
}
