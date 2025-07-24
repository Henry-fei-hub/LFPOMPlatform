package pomplatform.managementTeamProject.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.managementTeamProject.bean.BaseMManagementTeamProject;
import pomplatform.managementTeamProject.bean.ConditionMManagementTeamProject;

public class QueryMManagementTeamProject extends AbstractQuery<BaseMManagementTeamProject, ConditionMManagementTeamProject>
{

	private static final Logger __logger = Logger.getLogger(QueryMManagementTeamProject.class);

	public QueryMManagementTeamProject() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.common_area");
	}

	@Override
	public BaseCollection<BaseMManagementTeamProject> executeQuery( KeyValuePair[] replacements, ConditionMManagementTeamProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getDepartmentId(), 
				condition.getProjectType(), 
				condition.getStatus(),
                                condition.getProjectName(),
                                condition.getContractCode()
			);
	}

	@Override
	public BaseMManagementTeamProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMManagementTeamProject __base = new BaseMManagementTeamProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudget(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkHours(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
		if(args[2] != null) __statement.setInt(count++, (java.lang.Integer)args[2]);
		if(args[3] != null) __statement.setInt(count++, (java.lang.Integer)args[3]);
                if(args[4] != null) __statement.setString(count++, (java.lang.String)args[4]);
                if(args[5] != null) __statement.setString(count++, (java.lang.String)args[5]);
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

//	private final static String __SQLText = "select p.common_area,p.logistics_area,p.percentage,p.total_integral,p.reserve_integral,p.project_code,p.project_name,p.department_manager_id, p.budget,p.project_manage_id,p.project_type ,p.contract_code,c.sub_contract_name as contract_name,'' as customer_name, p.project_integral, p.work_hours, p.project_size, p.plan_start_date, p.plan_end_date, p.project_id, p.status,p.department_id,p.project_finish_percent,p.parent_id,p.total_finish_percent,p.plate_manager_id,p.project_grade_type,p.last_percent from projects p, sub_contracts c where p.contract_code = c.sub_contract_code and p.project_id = ? and p.department_id in (select child_id from department_ids where department_id = ? ) and p.project_type = ? and p.status = ? and p.project_name like ? order by p.project_id desc" ;
        private final static String __SQLText = "select p.common_area,p.logistics_area,p.percentage,p.total_integral,p.reserve_integral,p.project_code,p.project_name,p.department_manager_id, p.budget,p.project_manage_id,p.plate_id as project_type ,p.contract_code,sc.sub_contract_name as contract_name,'' as customer_name, p.project_integral, p.work_hours, p.project_size, p.plan_start_date, p.plan_end_date, p.project_id, p.status,p.department_id,p.project_finish_percent,p.parent_id,p.total_finish_percent,p.plate_manager_id,p.project_grade_type,p.last_percent from projects p LEFT JOIN sub_contracts sc on p.contract_code = sc.sub_contract_code LEFT JOIN contracts c on sc.parent_id = c.contract_id where p.project_id = ? and p.department_id in (select child_id from department_ids where department_id = ? ) and p.project_type = ? and p.status = ? and p.project_name like ? and c.contract_code = ? order by p.project_id desc" ;
	private final static String RESULTSETFIELDLIST = "common_area,logistics_area,percentage,total_integral,reserve_integral,project_code,project_name,department_manager_id,budget,project_manage_id,project_type,contract_code,contract_name,customer_name,project_integral,work_hours,project_size,plan_start_date,plan_end_date,project_id,status,department_id,project_finish_percent,parent_id,total_finish_percent,plate_manager_id,project_grade_type,last_percent";
	private final static String[] fieldNames = { "project_id", "department_id", "project_type", "status","project_name","contract_code"};
}
