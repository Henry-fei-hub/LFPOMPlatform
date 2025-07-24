package pomplatform.poolmanage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.poolmanage.bean.BaseOnloadPoolEmployeeData;
import pomplatform.poolmanage.bean.ConditionOnloadPoolEmployeeData;

public class QueryOnloadPoolEmployeeData extends AbstractQuery<BaseOnloadPoolEmployeeData, ConditionOnloadPoolEmployeeData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnloadPoolEmployeeData.class);

	public QueryOnloadPoolEmployeeData() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .pool_manage_id");
	}

	@Override
	public BaseCollection<BaseOnloadPoolEmployeeData> executeQuery( KeyValuePair[] replacements, ConditionOnloadPoolEmployeeData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPoolManageId()
			);
	}

	@Override
	public BaseOnloadPoolEmployeeData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnloadPoolEmployeeData __base = new BaseOnloadPoolEmployeeData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPoolManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPoolManageEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessIds(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessNames(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProfessionalIds(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProfessionalNames(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT A .pool_manage_id, A.pool_manage_employee_id, A.employee_id, b.employee_no, b.employee_name, b.gender, b.department_id, A.business_ids, A.business_names, A.professional_ids, A.professional_names FROM pool_manage_employees A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE A.pool_manage_id =? ORDER BY A.pool_manage_employee_id" ;
	private final static String RESULTSETFIELDLIST = "pool_manage_id,pool_manage_employee_id,employee_id,employee_no,employee_name,gender,department_id,business_ids,business_names,professional_ids,professional_names";
	private final static String[] fieldNames = { "pool_manage_id"};
}
