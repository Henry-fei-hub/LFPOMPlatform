package pomplatform.designer.invitation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.designer.invitation.bean.BaseMprojectemployeepor;
import pomplatform.designer.invitation.bean.ConditionMprojectemployeepor;

public class QueryMprojectemployeepor extends AbstractQuery<BaseMprojectemployeepor, ConditionMprojectemployeepor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectemployeepor.class);

	public QueryMprojectemployeepor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_manage_id");
	}

	@Override
	public BaseCollection<BaseMprojectemployeepor> executeQuery( KeyValuePair[] replacements, ConditionMprojectemployeepor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMprojectemployeepor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectemployeepor __base = new BaseMprojectemployeepor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlement(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select p.project_manage_id, p.project_name, p.project_id, pe.project_employee_id, pe.employee_id, pe.work_content, COALESCE(pe.start_date, pe.plan_start_date) as start_date, COALESCE(pe.end_date, pe.plan_end_date) as end_date, pe.plan_integral, sum(COALESCE(ec.real_amount,0.0)) as real_integral, sum(COALESCE(ec.project_cost,0.0)) as cost, sum(COALESCE(ec.final_amount,0.0)) as settlement from project_employees pe left join projects p on pe.project_id = p.project_id left join project_settlement_details ec on pe.project_id = ec.project_id and pe.employee_id = ec.employee_id where pe.employee_id = ? and pe.status = ? and pe.project_id = ? and pe.project_id is not null and p.status < 8 group by p.project_manage_id, p.project_name, p.project_id, pe.project_employee_id, pe.employee_id, pe.work_content, COALESCE(pe.start_date, pe.plan_start_date), COALESCE(pe.end_date, pe.plan_end_date),pe.plan_integral" ;
	private final static String RESULTSETFIELDLIST = "project_manage_id,project_name,project_id,project_employee_id,employee_id,work_content,start_date,end_date,plan_integral,real_integral,cost,settlement";
	private final static String[] fieldNames = { "employee_id", "status", "project_id"};
}
