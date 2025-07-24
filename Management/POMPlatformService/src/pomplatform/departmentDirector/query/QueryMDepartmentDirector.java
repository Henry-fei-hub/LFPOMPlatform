package pomplatform.departmentDirector.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.departmentDirector.bean.BaseMDepartmentDirector;
import pomplatform.departmentDirector.bean.ConditionMDepartmentDirector;

public class QueryMDepartmentDirector extends AbstractQuery<BaseMDepartmentDirector, ConditionMDepartmentDirector>
{

	private static final Logger __logger = Logger.getLogger(QueryMDepartmentDirector.class);

	public QueryMDepartmentDirector() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("P .common_area");
	}

	@Override
	public BaseCollection<BaseMDepartmentDirector> executeQuery( KeyValuePair[] replacements, ConditionMDepartmentDirector condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getProjectId(), 
				condition.getProjectType(), 
				condition.getProjectName(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseMDepartmentDirector generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMDepartmentDirector __base = new BaseMDepartmentDirector();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudget(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectGradeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLastPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProgressPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFinishPercentHavetime(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftPlateSureIntegral(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "SELECT P .common_area, P.logistics_area, P.percentage, P.total_integral, P.reserve_integral, P.budget, P.project_code, P.project_name, P.department_manager_id, P.project_manage_id, P.plate_id AS project_type, P.contract_code, C.sub_contract_name AS contract_name, '' AS customer_name, P.project_integral, P.work_hours, P.project_size, P.plan_start_date, P.plan_end_date, P.project_id, P.status, P.department_id, P.project_finish_percent, P.parent_id, P.total_finish_percent, P.plate_manager_id, P.project_grade_type, P.last_percent, P.complaint_integral, P.project_flag, b.sure_integral, COALESCE(p.project_integral,0)-COALESCE(d.project_amount,0) AS left_sure_integral, CASE WHEN P.project_integral > 0 THEN round((COALESCE (d.project_amount, 0 ) * 100 / P.project_integral ),2 ) ELSE 0 END AS progress_percentage, CASE WHEN P.project_integral > 0 THEN round((COALESCE (b.sure_integral, 0 ) * 100 / P.project_integral ),2 ) ELSE 0 END AS project_finish_percent_havetime, e.plate_sure_integral, COALESCE(p.reserve_integral,0)-COALESCE(f.account_integral,0) AS left_plate_sure_integral FROM projects P LEFT JOIN sub_contracts C ON P.sub_contract_id = C.sub_contract_id LEFT JOIN (SELECT project_id,sum(project_amount) AS sure_integral FROM project_settlements WHERE settlement_status = 2 AND settlement_date BETWEEN ? AND ? GROUP BY project_id) AS b ON p.project_id = b.project_id LEFT JOIN (SELECT project_id,sum(project_amount) AS project_amount FROM project_settlements WHERE settlement_status = 2 GROUP BY project_id) AS d ON p.project_id = d.project_id LEFT JOIN (SELECT project_id,sum(account_integral) AS plate_sure_integral FROM plate_project_account_records WHERE account_date BETWEEN ? AND ? GROUP BY project_id) AS e ON p.project_id = e.project_id LEFT JOIN (SELECT project_id,sum(account_integral) AS account_integral FROM plate_project_account_records GROUP BY project_id) AS f ON p.project_id = f.project_id WHERE P.project_id = ? AND P.plate_id = ? AND P.project_name LIKE ? AND P.status = ? ORDER BY P.project_id DESC" ;
	private final static String RESULTSETFIELDLIST = "common_area,logistics_area,percentage,total_integral,reserve_integral,budget,project_code,project_name,department_manager_id,project_manage_id,project_type,contract_code,contract_name,customer_name,project_integral,work_hours,project_size,plan_start_date,plan_end_date,project_id,status,department_id,project_finish_percent,parent_id,total_finish_percent,plate_manager_id,project_grade_type,last_percent,complaint_integral,project_flag,sure_integral,left_sure_integral,progress_percentage,project_finish_percent_havetime,plate_sure_integral,left_plate_sure_integral";
	private final static String[] fieldNames = { "start_date", "end_date", "start_date", "end_date", "project_id", "project_type", "project_name", "status"};
}
