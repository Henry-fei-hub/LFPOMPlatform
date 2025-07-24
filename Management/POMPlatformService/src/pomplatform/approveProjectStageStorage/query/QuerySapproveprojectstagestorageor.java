package pomplatform.approveProjectStageStorage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.approveProjectStageStorage.bean.BaseSapproveprojectstagestorageor;
import pomplatform.approveProjectStageStorage.bean.ConditionSapproveprojectstagestorageor;

public class QuerySapproveprojectstagestorageor extends AbstractQuery<BaseSapproveprojectstagestorageor, ConditionSapproveprojectstagestorageor>
{

	private static final Logger __logger = Logger.getLogger(QuerySapproveprojectstagestorageor.class);

	public QuerySapproveprojectstagestorageor() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("apss.project_id");
	}

	@Override
	public BaseCollection<BaseSapproveprojectstagestorageor> executeQuery( KeyValuePair[] replacements, ConditionSapproveprojectstagestorageor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getProjectManageId(), 
				condition.getPlateManagerId(), 
				condition.getDepartmentManagerId(), 
				condition.getContractCode(), 
				condition.getProjectName()
			);
	}

	@Override
	public BaseSapproveprojectstagestorageor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSapproveprojectstagestorageor __base = new BaseSapproveprojectstagestorageor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "select apss.project_id, apss.contract_code, apss.project_code, apss.project_name, apss.project_type, apss.plate_id, apss.project_manage_id, apss.plate_manager_id, apss.department_manager_id from approve_project_stage_storages apss where apss.project_id = ? and apss.plate_id = ? and apss.project_manage_id = ? and apss.plate_manager_id = ? and apss.department_manager_id = ? and apss.contract_code like ? and apss.project_name like ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,project_type,plate_id,project_manage_id,plate_manager_id,department_manager_id";
	private final static String[] fieldNames = { "project_id", "plate_id", "project_manage_id", "plate_manager_id", "department_manager_id", "contract_code", "project_name"};
}
