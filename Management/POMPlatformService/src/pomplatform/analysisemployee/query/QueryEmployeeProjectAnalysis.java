package pomplatform.analysisemployee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.analysisemployee.bean.BaseEmployeeProjectAnalysis;
import pomplatform.analysisemployee.bean.ConditionEmployeeProjectAnalysis;

public class QueryEmployeeProjectAnalysis extends AbstractQuery<BaseEmployeeProjectAnalysis, ConditionEmployeeProjectAnalysis>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeProjectAnalysis.class);

	public QueryEmployeeProjectAnalysis() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeProjectAnalysis> executeQuery( KeyValuePair[] replacements, ConditionEmployeeProjectAnalysis condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeName(), 
				condition.getIsbusy(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseEmployeeProjectAnalysis generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeProjectAnalysis __base = new BaseEmployeeProjectAnalysis();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setIsbusy(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT aa.employee_id,e.employee_no,e.employee_name,e.plate_id,e.department_id, sum(aa.left_integral) as left_integral,count(aa.project_id) as num,e.isbusy FROM (SELECT a.project_id,a.employee_id, CASE WHEN a.plan_integral is null THEN 0 ELSE a.plan_integral END - CASE WHEN b.real_amount is null THEN 0 ELSE b.real_amount END as left_integral FROM (SELECT project_id,employee_id,sum(plan_integral) as plan_integral FROM project_employees GROUP BY project_id,employee_id ORDER BY project_id ,employee_id) a LEFT JOIN( SELECT project_id,employee_id,sum(real_amount) as real_amount FROM project_settlement_details GROUP BY project_id,employee_id ORDER BY project_id ,employee_id) b ON a.project_id = b.project_id AND a.employee_id = b.employee_id ) aa LEFT JOIN employees e ON aa.employee_id = e.employee_id left join projects p on aa.project_id = p.project_id WHERE aa.left_integral > 0 AND e.status = 0 AND e.plate_id = ? AND e.department_id in (select child_id from department_ids where department_id = ?) AND e.employee_name like ? AND e.isbusy = ? AND aa.employee_id = ? and p.project_type <> 30 GROUP BY aa.employee_id,e.employee_no,e.employee_name,e.plate_id,e.department_id,e.isbusy ORDER BY left_integral DESC" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,plate_id,department_id,left_integral,num,isbusy";
	private final static String[] fieldNames = { "plate_id", "department_id", "employee_name", "isbusy","employee_id"};
}
