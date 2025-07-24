package pomplatform.selectgrid.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.selectgrid.bean.BaseSelectGridPreProjectValue;
import pomplatform.selectgrid.bean.ConditionSelectGridPreProjectValue;

public class QuerySelectGridPreProjectValue extends AbstractQuery<BaseSelectGridPreProjectValue, ConditionSelectGridPreProjectValue>
{

	private static final Logger __logger = Logger.getLogger(QuerySelectGridPreProjectValue.class);

	public QuerySelectGridPreProjectValue() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pprn.pre_project_reimbursement_number_id");
	}

	@Override
	public BaseCollection<BaseSelectGridPreProjectValue> executeQuery( KeyValuePair[] replacements, ConditionSelectGridPreProjectValue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectName(), 
				condition.getCustomNumber(), 
				condition.getRemark(), 
				condition.getPlateId(), 
				condition.getPreProjectReimbursementNumberId()
			);
	}

	@Override
	public BaseSelectGridPreProjectValue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSelectGridPreProjectValue __base = new BaseSelectGridPreProjectValue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPreProjectReimbursementNumberId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPreProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT pprn.pre_project_reimbursement_number_id, pprn.custom_number, pprn.project_manager, pprn.create_time, pprn.remark, pprn.pre_project_type, pprn.plate_id, pprn.pre_business_type, mp.project_name, mp.project_code, mp.info_code FROM pre_project_reimbursement_numbers pprn LEFT JOIN pre_projects mp ON pprn.main_project_id = mp.pre_project_id WHERE mp.project_name LIKE ? AND pprn.custom_number LIKE ? AND pprn.remark LIKE ? AND pprn.plate_id = ? AND pre_project_reimbursement_number_id = ?" ;
	private final static String RESULTSETFIELDLIST = "pre_project_reimbursement_number_id,custom_number,project_manager,create_time,remark,pre_project_type,plate_id,pre_business_type,project_name,project_code,info_code";
	private final static String[] fieldNames = { "project_name", "custom_number", "remark", "plate_id", "pre_project_reimbursement_number_id"};
}
