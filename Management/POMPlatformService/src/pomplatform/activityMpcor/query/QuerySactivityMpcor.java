package pomplatform.activityMpcor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.activityMpcor.bean.BaseSactivityMpcor;
import pomplatform.activityMpcor.bean.ConditionSactivityMpcor;

public class QuerySactivityMpcor extends AbstractQuery<BaseSactivityMpcor, ConditionSactivityMpcor>
{

	private static final Logger __logger = Logger.getLogger(QuerySactivityMpcor.class);

	public QuerySactivityMpcor() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.activitie_id");
	}

	@Override
	public BaseCollection<BaseSactivityMpcor> executeQuery( KeyValuePair[] replacements, ConditionSactivityMpcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getOperateEmployeeId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getProjectName(), 
				condition.getContactName(), 
				condition.getCustomerName(), 
				condition.getMeetType(), 
				condition.getMeetTitle(), 
				condition.getDepartmentId(),
				condition.getProvince(),
				condition.getCity()
			);
	}

	@Override
	public BaseSactivityMpcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSactivityMpcor __base = new BaseSactivityMpcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setActivitieId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMeetType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMeetTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMeetAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMeetTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMeetTarget(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTheirRequire(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTheirEmployees(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOurEmployees(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOurDesignerEmployees(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOutTimeStart(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOutTimeEnd(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
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

	private final static String __SQLText = "SELECT a.activitie_id, a.main_project_id, a.customer_id, a.customer_name, a.project_name, a.meet_type, a.meet_time, a.meet_address, a.meet_title, a.meet_target, a.contact_name, a.their_require, a.their_employees, a.our_employees, a.operate_employee_id, a.operate_time, a.remark ,e.department_id ,a.our_designer_employees,a.province,a.city,a.out_time_start, a.out_time_end FROM activities a LEFT JOIN pre_projects b ON a.main_project_id = b.pre_project_id LEFT JOIN employees e ON a.operate_employee_id = e.employee_id LEFT JOIN departments d ON e.department_id=d.department_id WHERE a.operate_employee_id = ? and a.meet_time BETWEEN ? AND ? and a.project_name like ? and a.contact_name like ? and a.customer_name like ? and a.meet_type = ? and a.meet_title like ? AND e.department_id = ? AND A.province= ? AND A.city= ? ORDER BY a.meet_time DESC" ;
	private final static String RESULTSETFIELDLIST = "activitie_id,main_project_id,customer_id,customer_name,project_name,meet_type,meet_time,meet_address,meet_title,meet_target,contact_name,their_require,their_employees,our_employees,operate_employee_id,operate_time,remark,department_id,our_designer_employees,province,city,out_time_start,out_time_end";
	private final static String[] fieldNames = { "operate_employee_id", "start_date", "end_date", "project_name", "contact_name", "customer_name", "meet_type", "meet_title", "department_id","province","city"};
}
