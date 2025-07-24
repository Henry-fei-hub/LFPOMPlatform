package pomplatform.projectEmployee.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.projectEmployee.bean.BaseSprojectemployeepdsor;
import pomplatform.projectEmployee.bean.ConditionSprojectemployeepdsor;

public class QuerySprojectemployeepdsor extends AbstractQuery<BaseSprojectemployeepdsor, ConditionSprojectemployeepdsor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectemployeepdsor.class);

	public QuerySprojectemployeepdsor() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pe.project_employee_id");
	}

	@Override
	public BaseCollection<BaseSprojectemployeepdsor> executeQuery( KeyValuePair[] replacements, ConditionSprojectemployeepdsor condition ) throws java.sql.SQLException {
		return executeQuery(replacements,
				condition.getProjectId(),
				condition.getStageId(),
				condition.getProjectId(),
				condition.getStageId(),
				condition.getProjectId(), 
				condition.getDesignPhase(), 
				condition.getStatus(), 
				condition.getStageId()
			);
	}

	@Override
	public BaseSprojectemployeepdsor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectemployeepdsor __base = new BaseSprojectemployeepdsor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlement(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setInt(count++, (java.lang.Integer)args[4]);
		if(args[5] != null) __statement.setInt(count++, (java.lang.Integer)args[5]);
		if(args[6] != null) __statement.setInt(count++, (java.lang.Integer)args[6]);
		if(args[7] != null) __statement.setInt(count++, (java.lang.Integer)args[7]);
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

	private final static String __SQLText = "select pe.project_employee_id, pe.project_id, pe.employee_id, pe.work_content, COALESCE(pe.plan_integral,0) as plan_integral, pe.real_integral, (SELECT sum(COALESCE(psd.project_cost, 0)) as cost FROM project_settlements ps LEFT JOIN project_settlement_details psd ON ps.settlement_id = psd.settlement_id WHERE ps.project_id = ? AND ps.stage_id = ? AND psd.employee_id = pe.employee_id GROUP BY ps.stage_id),(SELECT sum(COALESCE(psd.final_amount, 0)) as settlement FROM project_settlements ps LEFT JOIN project_settlement_details psd ON ps.settlement_id = psd.settlement_id WHERE ps.project_id = ? AND ps.stage_id = ? AND psd.employee_id = pe.employee_id GROUP BY ps.stage_id), pe.plan_start_date, pe.plan_end_date, pe.start_date, pe.end_date, pe.status,e.grade_id from project_employees pe left join project_settlement_details psd on pe.project_id = psd.project_id and pe.employee_id = psd.employee_id left join employees e on pe.employee_id = e.employee_id where pe.project_id = ? and pe.design_phase = ? and pe.status = ? and pe.stage_id = ? group by pe.project_employee_id, pe.project_id, pe.employee_id,pe.start_date, pe.plan_start_date ,pe.end_date, pe.plan_end_date , pe.work_content, pe.plan_integral, pe.real_integral,pe.status,e.grade_id ORDER BY e.grade_id" ;
	private final static String RESULTSETFIELDLIST = "project_employee_id,project_id,employee_id,work_content,plan_integral,real_integral,cost,settlement,plan_start_date,plan_end_date,start_date,end_date,status,grade_id";
	private final static String[] fieldNames = { "project_id","stage_id","project_id","stage_id","project_id", "design_phase", "status","stage_id"};
}
