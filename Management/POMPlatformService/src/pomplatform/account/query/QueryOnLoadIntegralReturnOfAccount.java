package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadIntegralReturnOfAccount;
import pomplatform.account.bean.ConditionOnLoadIntegralReturnOfAccount;

public class QueryOnLoadIntegralReturnOfAccount extends AbstractQuery<BaseOnLoadIntegralReturnOfAccount, ConditionOnLoadIntegralReturnOfAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadIntegralReturnOfAccount.class);

	public QueryOnLoadIntegralReturnOfAccount() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadIntegralReturnOfAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadIntegralReturnOfAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getRoleId()
			);
	}

	@Override
	public BaseOnLoadIntegralReturnOfAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadIntegralReturnOfAccount __base = new BaseOnLoadIntegralReturnOfAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAchieveintegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select aa.employee_id,sum(aa.achieveIntegral) as achieveIntegral,e.employee_no,e.employee_name,e.plate_id,e.status,e.grade_id from ( select a.employee_id,a.business_type_id ,case when d.parent_id = -1 then -(sum(a.integral)) else sum(a.integral) end as achieveIntegral,c.plate_id from employee_account_records a LEFT JOIN employee_day_plate_records c ON a.employee_id = c.employee_id AND a.record_date = c.record_date left join system_dictionary d on dic_type_id = 66 and a.business_type_id = d.dic_type_value_id where c.plate_id = ? GROUP BY c.plate_id,a.employee_id,a.business_type_id,d.parent_id ) as aa left join employees e on aa.employee_id = e.employee_id where aa.employee_id in(select er.employee_id from employee_roles er left join departments de on er.department_id = de.department_id where de.plate_id = aa.plate_id and er.role_id = ?) GROUP BY aa.employee_id,e.employee_no,e.employee_name,e.plate_id,e.status,e.grade_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,achieveintegral,employee_no,employee_name,plate_id,status,grade_id";
	private final static String[] fieldNames = { "plate_id", "role_id"};
}
