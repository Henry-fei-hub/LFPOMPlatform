package pomplatform.salaryexceptions.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salaryexceptions.bean.BaseOnSalaryExceptions;
import pomplatform.salaryexceptions.bean.ConditionOnSalaryExceptions;

public class QueryOnSalaryExceptions extends AbstractQuery<BaseOnSalaryExceptions, ConditionOnSalaryExceptions>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryExceptions.class);

	public QueryOnSalaryExceptions() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.personnel_business_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryExceptions> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryExceptions condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPersonnelBusinessId()
			);
	}

	@Override
	public BaseOnSalaryExceptions generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryExceptions __base = new BaseOnSalaryExceptions();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select pb.personnel_business_id,pb.employee_id, pb.employee_no, pb.department_id, pb.company_id, pb.reason, pb.remark ,pb.create_time,pb.process_type from personnel_business pb where pb.personnel_business_id = ?" ;
	private final static String RESULTSETFIELDLIST = "personnel_business_id,employee_id,employee_no,department_id,company_id,reason,remark,create_time,process_type";
	private final static String[] fieldNames = { "personnel_business_id"};
}
