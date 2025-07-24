package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadProjectEmployeePerformance;
import pomplatform.project.bean.ConditionOnLoadProjectEmployeePerformance;

public class QueryOnLoadProjectEmployeePerformance extends AbstractQuery<BaseOnLoadProjectEmployeePerformance, ConditionOnLoadProjectEmployeePerformance>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectEmployeePerformance.class);

	public QueryOnLoadProjectEmployeePerformance() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectEmployeePerformance> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectEmployeePerformance condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPerformanceFlag(), 
				condition.getProjectId()
			);
	}

	@Override
	public BaseOnLoadProjectEmployeePerformance generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectEmployeePerformance __base = new BaseOnLoadProjectEmployeePerformance();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPerformanceIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalSettlementIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEnabled(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "select a.project_id,a.employee_id,b.employee_no,b.employee_name,a.plan_integral,0 as integral ,COALESCE((select sum(pps.integral) from project_performance_settlement_details pps where pps.project_id = a.project_id and pps.employee_id = a.employee_id and pps.performance_flag = ? GROUP BY pps.project_id,pps.employee_id),0) as total_performance_integral ,COALESCE(sum(c.real_amount),0) as total_sure_integral,COALESCE(sum(c.project_cost),0) as total_cost,COALESCE(sum(c.final_amount),0) as total_settlement_integral ,b.status,case when b.status = 0 then true else false end enabled from project_employees a left join employees b on a.employee_id = b.employee_id left join project_settlement_details c on a.project_id = c.project_id and a.employee_id = c.employee_id and c.settlement_status = 2 where a.project_id = ? GROUP BY a.project_id,a.employee_id,b.employee_no,b.employee_name,b.status,a.plan_integral" ;
	private final static String RESULTSETFIELDLIST = "project_id,employee_id,employee_no,employee_name,plan_integral,integral,total_performance_integral,total_sure_integral,total_cost,total_settlement_integral,status,enabled";
	private final static String[] fieldNames = { "performance_flag", "project_id"};
}
