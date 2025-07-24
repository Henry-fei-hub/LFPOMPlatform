package pomplatform.approveProjectStageStorage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.approveProjectStageStorage.bean.Baseapproveprojectstagestoragecor;
import pomplatform.approveProjectStageStorage.bean.Conditionapproveprojectstagestoragecor;

public class Queryapproveprojectstagestoragecor extends AbstractQuery<Baseapproveprojectstagestoragecor, Conditionapproveprojectstagestoragecor>
{

	private static final Logger __logger = Logger.getLogger(Queryapproveprojectstagestoragecor.class);

	public Queryapproveprojectstagestoragecor() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("apss.project_id");
	}

	@Override
	public BaseCollection<Baseapproveprojectstagestoragecor> executeQuery( KeyValuePair[] replacements, Conditionapproveprojectstagestoragecor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getProjectManageId(), 
				condition.getPlateManagerId(), 
				condition.getDepartmentManagerId()
			);
	}

	@Override
	public Baseapproveprojectstagestoragecor generateBase(Object[] __data) throws java.sql.SQLException {
		Baseapproveprojectstagestoragecor __base = new Baseapproveprojectstagestoragecor();
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
		if((val = __data[count++]) != null) __base.setApproveProjectStageStorageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "select apss.project_id, apss.contract_code, apss.project_code, apss.project_name, apss.project_type, apss.plate_id, apss.project_manage_id, apss.plate_manager_id, apss.department_manager_id, apss.approve_project_stage_storage_id, apss.process_type, apss.delete_flag, apss.create_time from approve_project_stage_storages apss where apss.contract_code like ? and apss.project_code like ? and apss.project_name like ? and apss.project_id = ? and apss.plate_id = ? and apss.project_manage_id = ? and apss.plate_manager_id = ? and apss.department_manager_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,project_type,plate_id,project_manage_id,plate_manager_id,department_manager_id,approve_project_stage_storage_id,process_type,delete_flag,create_time";
	private final static String[] fieldNames = { "contract_code", "project_code", "project_name", "project_id", "plate_id", "project_manage_id", "plate_manager_id", "department_manager_id"};
}
