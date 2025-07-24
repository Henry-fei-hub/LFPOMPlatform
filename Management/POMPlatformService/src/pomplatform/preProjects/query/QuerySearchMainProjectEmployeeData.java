package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseSearchMainProjectEmployeeData;
import pomplatform.preProjects.bean.ConditionSearchMainProjectEmployeeData;

public class QuerySearchMainProjectEmployeeData extends AbstractQuery<BaseSearchMainProjectEmployeeData, ConditionSearchMainProjectEmployeeData>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchMainProjectEmployeeData.class);

	public QuerySearchMainProjectEmployeeData() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .main_project_employee_id");
	}

	@Override
	public BaseCollection<BaseSearchMainProjectEmployeeData> executeQuery( KeyValuePair[] replacements, ConditionSearchMainProjectEmployeeData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPreProjectId(), 
				condition.getRelation(), 
				condition.getMainProjectId()
			);
	}

	@Override
	public BaseSearchMainProjectEmployeeData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchMainProjectEmployeeData __base = new BaseSearchMainProjectEmployeeData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRelation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainAndAssistance(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsPlateManager(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "SELECT A .main_project_employee_id, A.main_project_id, A.employee_id, A.relation, e.employee_no, e.employee_name, e.plate_id, A.main_and_assistance , a.is_plate_manager FROM main_project_employees A LEFT JOIN employees e ON A.employee_id = e.employee_id WHERE A.pre_project_id =? AND A.relation =? AND A.main_project_id =?" ;
	private final static String RESULTSETFIELDLIST = "main_project_employee_id,main_project_id,employee_id,relation,employee_no,employee_name,plate_id,main_and_assistance,is_plate_manager";
	private final static String[] fieldNames = { "pre_project_id", "relation", "main_project_id"};
}
