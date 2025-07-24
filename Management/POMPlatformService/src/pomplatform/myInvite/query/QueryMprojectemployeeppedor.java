package pomplatform.myInvite.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.myInvite.bean.BaseMprojectemployeeppedor;
import pomplatform.myInvite.bean.ConditionMprojectemployeeppedor;

public class QueryMprojectemployeeppedor extends AbstractQuery<BaseMprojectemployeeppedor, ConditionMprojectemployeeppedor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectemployeeppedor.class);

	public QueryMprojectemployeeppedor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("concat(s.image_path");
	}

	@Override
	public BaseCollection<BaseMprojectemployeeppedor> executeQuery( KeyValuePair[] replacements, ConditionMprojectemployeeppedor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getEmployeeId(), 
				condition.getDesignPhase()
			);
	}

	@Override
	public BaseMprojectemployeeppedor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectemployeeppedor __base = new BaseMprojectemployeeppedor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRealWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectProgress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudget(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select concat(s.image_path,case when e.photo is null then 'photo_view.png' else e.photo end) as photo ,pe.project_employee_id, pe.project_id, pe.employee_id, pe.design_phase, pe.plan_work_hours, pe.real_work_hours, pe.plan_integral, (case when pe.real_integral is null then pe.plan_integral else pe.real_integral end) as real_integral, pe.plan_start_date, pe.plan_end_date, (case when pe.start_date is null then pe.plan_start_date else pe.start_date end ) as start_date, (case when pe.end_date is null then pe.plan_end_date else pe.end_date end) as end_date, pe.work_content, pe.status , p.contract_code, p.work_hours, p.department_id, p.project_type, p.project_code, p.project_name, p.project_progress, p.project_manage_id, p.project_size, p.project_integral, p.project_description, p.budget, p.audit_reason, p.project_level, p.department_manager_id from project_employees pe left join projects p on pe.project_id = p.project_id left join employees e on pe.employee_id = e.employee_id left join system_config s on system_config_id = 1 where pe.project_id = ? and pe.employee_id = ? and pe.design_phase = ? and e.status = 0" ;
	private final static String RESULTSETFIELDLIST = "photo,project_employee_id,project_id,employee_id,design_phase,plan_work_hours,real_work_hours,plan_integral,real_integral,plan_start_date,plan_end_date,start_date,end_date,work_content,status,contract_code,work_hours,department_id,project_type,project_code,project_name,project_progress,project_manage_id,project_size,project_integral,project_description,budget,audit_reason,project_level,department_manager_id";
	private final static String[] fieldNames = { "project_id", "employee_id", "design_phase"};
}
