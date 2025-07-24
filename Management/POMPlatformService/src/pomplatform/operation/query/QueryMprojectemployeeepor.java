package pomplatform.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseMprojectemployeeepor;
import pomplatform.operation.bean.ConditionMprojectemployeeepor;

public class QueryMprojectemployeeepor extends AbstractQuery<BaseMprojectemployeeepor, ConditionMprojectemployeeepor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectemployeeepor.class);

	public QueryMprojectemployeeepor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("COALESCE(e.photo");
	}

	@Override
	public BaseCollection<BaseMprojectemployeeepor> executeQuery( KeyValuePair[] replacements, ConditionMprojectemployeeepor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMprojectemployeeepor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectemployeeepor __base = new BaseMprojectemployeeepor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select COALESCE(e.photo, '/images/photos/photo_view.png') as photo, pe.employee_id, pe.work_content, COALESCE(pe.start_date, pe.plan_start_date) as start_date, COALESCE(pe.end_date, pe.plan_end_date) as end_date, COALESCE(pe.plan_integral,0.0) as integral, pe.status, sum(COALESCE(ec.real_amount,0.0)) as real_integral, sum(COALESCE(ec.project_cost,0.0)) as cost, sum(COALESCE(ec.final_amount,0.0)) as settlement from project_employees pe left join employees e on pe.employee_id = e.employee_id left join project_settlement_details ec on pe.project_id = ec.project_id and pe.employee_id = ec.employee_id where pe.project_id = ? group by COALESCE(e.photo, '/images/photos/photo_view.png'), pe.employee_id, pe.work_content, COALESCE(pe.start_date, pe.plan_start_date) , COALESCE(pe.end_date, pe.plan_end_date) , COALESCE(pe.plan_integral,0.0), pe.status" ;
	private final static String RESULTSETFIELDLIST = "photo,employee_id,work_content,start_date,end_date,integral,status,real_integral,cost,settlement";
	private final static String[] fieldNames = { "project_id"};
}
