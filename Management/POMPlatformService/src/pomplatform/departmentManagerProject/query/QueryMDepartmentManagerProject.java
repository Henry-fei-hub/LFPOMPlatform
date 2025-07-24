package pomplatform.departmentManagerProject.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.departmentManagerProject.bean.BaseMDepartmentManagerProject;
import pomplatform.departmentManagerProject.bean.ConditionMDepartmentManagerProject;

public class QueryMDepartmentManagerProject extends AbstractQuery<BaseMDepartmentManagerProject, ConditionMDepartmentManagerProject>
{

	private static final Logger __logger = Logger.getLogger(QueryMDepartmentManagerProject.class);

	public QueryMDepartmentManagerProject() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseMDepartmentManagerProject> executeQuery( KeyValuePair[] replacements, ConditionMDepartmentManagerProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProjectType()
			);
	}

	@Override
	public BaseMDepartmentManagerProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMDepartmentManagerProject __base = new BaseMDepartmentManagerProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkHours(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectProgress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudget(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAuditReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOldProjectDiscount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setElectromechanicalType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOfficeType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select p.project_id, p.contract_code, p.contract_name, p.customer_name, p.work_hours, p.department_id, p.design_phase, p.project_type, p.project_code, p.project_name, p.plan_start_date, p.plan_end_date, p.start_date, p.end_date, p.status, p.project_progress, p.project_manage_id, p.project_manage_name, p.project_size, p.project_integral, p.project_description, p.budget, p.audit_reason, p.project_level, p.department_manager_id, p.plate_id, p.common_area, p.logistics_area, p.percentage, p.total_integral, p.old_project_discount, p.reserve_integral, p.electromechanical_type, p.total_amount, p.office_type from projects p left join contracts c on p.contract_code = c.contract_code left join employees e on p.plate_id = e.plate_id where e.role_id = 3 and e.employee_id = ? and p.project_type = ? and e.status = 0 order by p.project_id desc" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,contract_name,customer_name,work_hours,department_id,design_phase,project_type,project_code,project_name,plan_start_date,plan_end_date,start_date,end_date,status,project_progress,project_manage_id,project_manage_name,project_size,project_integral,project_description,budget,audit_reason,project_level,department_manager_id,plate_id,common_area,logistics_area,percentage,total_integral,old_project_discount,reserve_integral,electromechanical_type,total_amount,office_type";
	private final static String[] fieldNames = { "employee_id", "project_type"};
}
