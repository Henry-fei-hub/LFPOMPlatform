package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLaborPaymentData;
import pomplatform.payment.bean.ConditionOnLaborPaymentData;

public class QueryOnLaborPaymentData extends AbstractQuery<BaseOnLaborPaymentData, ConditionOnLaborPaymentData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLaborPaymentData.class);

	public QueryOnLaborPaymentData() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.labor_payment_employee_id");
	}

	@Override
	public BaseCollection<BaseOnLaborPaymentData> executeQuery( KeyValuePair[] replacements, ConditionOnLaborPaymentData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getDepartmentId(), 
				condition.getPlateId(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseOnLaborPaymentData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLaborPaymentData __base = new BaseOnLaborPaymentData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setLaborPaymentEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT a.labor_payment_employee_id,a.employee_id,e.employee_no,e.employee_name,e.department_id,e.plate_id,e.company_id,a.year,a.month FROM labor_payment_employees a LEFT JOIN employees e ON a.employee_id = e.employee_id WHERE e.employee_no like ? AND e.employee_name like ? AND a.year = ? AND a.month = ? AND e.department_id in(SELECT child_id FROM department_ids WHERE department_id = ?) AND e.plate_id = ? AND e.company_id = ? ORDER BY e.plate_id,a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "labor_payment_employee_id,employee_id,employee_no,employee_name,department_id,plate_id,company_id,year,month";
	private final static String[] fieldNames = { "employee_no", "employee_name", "year", "month", "department_id", "plate_id", "company_id"};
}
