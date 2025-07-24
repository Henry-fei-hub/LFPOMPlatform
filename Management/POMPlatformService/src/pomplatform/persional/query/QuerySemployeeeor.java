package pomplatform.persional.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.persional.bean.BaseSemployeeeor;
import pomplatform.persional.bean.ConditionSemployeeeor;

public class QuerySemployeeeor extends AbstractQuery<BaseSemployeeeor, ConditionSemployeeeor>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeeeor.class);

	public QuerySemployeeeor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseSemployeeeor> executeQuery( KeyValuePair[] replacements, ConditionSemployeeeor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseSemployeeeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeeeor __base = new BaseSemployeeeor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQq(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select e.employee_id, e.employee_no, e.employee_name, e.department_id, e.role_id, e.grade_id, e.mobile, e.phone, e.qq, e.email, e.photo, e.address, e.plate_id from employees e where e.employee_id = ? and e.status = 0" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,grade_id,mobile,phone,qq,email,photo,address,plate_id";
	private final static String[] fieldNames = { "employee_id"};
}
