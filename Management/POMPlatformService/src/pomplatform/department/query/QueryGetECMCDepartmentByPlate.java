package pomplatform.department.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.department.bean.BaseGetECMCDepartmentByPlate;
import pomplatform.department.bean.ConditionGetECMCDepartmentByPlate;

public class QueryGetECMCDepartmentByPlate extends AbstractQuery<BaseGetECMCDepartmentByPlate, ConditionGetECMCDepartmentByPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryGetECMCDepartmentByPlate.class);

	public QueryGetECMCDepartmentByPlate() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("department_name");
	}

	@Override
	public BaseCollection<BaseGetECMCDepartmentByPlate> executeQuery( KeyValuePair[] replacements, ConditionGetECMCDepartmentByPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getDepartmentName()
			);
	}

	@Override
	public BaseGetECMCDepartmentByPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetECMCDepartmentByPlate __base = new BaseGetECMCDepartmentByPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEcmcDepartmentId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT department_name, ecmc_department_id from departments where department_name = (SELECT plate_name from plate_records where plate_id = ?) or department_name = ?" ;
	private final static String RESULTSETFIELDLIST = "department_name,ecmc_department_id";
	private final static String[] fieldNames = { "plate_id", "department_name"};
}
