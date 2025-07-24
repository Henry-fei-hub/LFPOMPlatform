package pomplatform.myProject.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.myProject.bean.BaseMprojectemployeeppedsesor;
import pomplatform.myProject.bean.ConditionMprojectemployeeppedsesor;

public class QueryMprojectemployeeppedsesor extends AbstractQuery<BaseMprojectemployeeppedsesor, ConditionMprojectemployeeppedsesor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectemployeeppedsesor.class);

	public QueryMprojectemployeeppedsesor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pe.project_employee_id");
	}

	@Override
	public BaseCollection<BaseMprojectemployeeppedsesor> executeQuery( KeyValuePair[] replacements, ConditionMprojectemployeeppedsesor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getEmployeeId(), 
				condition.getDesignPhase(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseMprojectemployeeppedsesor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectemployeeppedsesor __base = new BaseMprojectemployeeppedsesor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanWorkHours(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRealWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkHours(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, (java.lang.Integer)args[5]);
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

	private final static String __SQLText = "select pe.project_employee_id, pe.project_id, pe.employee_id, pe.design_phase, pe.plan_work_hours, pe.real_work_hours, pe.plan_integral, pe.real_integral, pe.plan_start_date, pe.plan_end_date, pe.start_date, pe.end_date, pe.work_content, pe.alternate_field1, pe.alternate_field2, pe.alternate_field3, pe.status , p.contract_code, p.contract_name, p.customer_name, p.work_hours, p.department_id, p.project_type, p.project_code, p.project_name, p.project_progress, p.project_manage_id, p.project_manage_name, p.project_size, p.project_integral, p.project_description, p.budget, p.audit_reason, p.project_level, p.department_manager_id from project_employees pe, projects p where pe.project_id = p.project_id and pe.project_id = ? and pe.employee_id = ? and pe.design_phase = ? and pe.start_date = ? and pe.end_date = ? and pe.status = ?" ;
	private final static String RESULTSETFIELDLIST = "project_employee_id,project_id,employee_id,design_phase,plan_work_hours,real_work_hours,plan_integral,real_integral,plan_start_date,plan_end_date,start_date,end_date,work_content,alternate_field1,alternate_field2,alternate_field3,status,contract_code,contract_name,customer_name,work_hours,department_id,project_type,project_code,project_name,project_progress,project_manage_id,project_manage_name,project_size,project_integral,project_description,budget,audit_reason,project_level,department_manager_id";
	private final static String[] fieldNames = { "project_id", "employee_id", "design_phase", "start_date", "end_date", "status"};
}
