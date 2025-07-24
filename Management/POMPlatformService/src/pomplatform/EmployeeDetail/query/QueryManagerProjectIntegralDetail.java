package pomplatform.EmployeeDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.EmployeeDetail.bean.BaseManagerProjectIntegralDetail;
import pomplatform.EmployeeDetail.bean.ConditionManagerProjectIntegralDetail;

public class QueryManagerProjectIntegralDetail extends AbstractQuery<BaseManagerProjectIntegralDetail, ConditionManagerProjectIntegralDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryManagerProjectIntegralDetail.class);

	public QueryManagerProjectIntegralDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseManagerProjectIntegralDetail> executeQuery( KeyValuePair[] replacements, ConditionManagerProjectIntegralDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseManagerProjectIntegralDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseManagerProjectIntegralDetail __base = new BaseManagerProjectIntegralDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAssignedIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setManageProjectId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "select a.employee_id,b.employee_no,a.assigned_integral,a.manage_project_id from manage_project_employee_records a left join employees b on a.employee_id = b.employee_id where extract(year from a.assign_date) = ? and extract(month from a.assign_date) = ? and a.employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,assigned_integral,manage_project_id";
	private final static String[] fieldNames = { "year", "month", "employee_id"};
}
