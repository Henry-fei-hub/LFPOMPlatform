package pomplatform.project.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnDevelopProject;
import pomplatform.project.bean.ConditionOnDevelopProject;

public class QueryOnDevelopProject extends AbstractQuery<BaseOnDevelopProject, ConditionOnDevelopProject>
{

	private static final Logger __logger = Logger.getLogger(QueryOnDevelopProject.class);

	public QueryOnDevelopProject() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("project_id");
	}

	@Override
	public BaseCollection<BaseOnDevelopProject> executeQuery( KeyValuePair[] replacements, ConditionOnDevelopProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getSheetCode(), 
				condition.getSheetName(),
				condition.getStartDate(),
				condition.getEndDate(),
				condition.getProjectFlag(),
				condition.getProjectSetupFlag()
			);
	}

	@Override
	public BaseOnDevelopProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnDevelopProject __base = new BaseOnDevelopProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSetupFlag(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "select project_id,contract_code,project_code,project_name,plate_id,project_level,business_type,project_type ,project_integral,create_time,department_id,plate_manager_id,department_manager_id,project_manage_id,remark,start_date,project_flag,project_setup_flag from projects where plate_id =? and contract_code like ? and project_name like ? and create_time between ? and ? and project_flag =? and project_setup_flag =? ORDER BY project_id,create_time desc" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,plate_id,project_level,business_type,project_type,project_integral,create_time,department_id,plate_manager_id,department_manager_id,project_manage_id,remark,start_date,project_flag,project_setup_flag";
	private final static String[] fieldNames = { "plate_id", "sheet_code", "sheet_name","startDate","endDate","project_flag","project_setup_flag"};
}
