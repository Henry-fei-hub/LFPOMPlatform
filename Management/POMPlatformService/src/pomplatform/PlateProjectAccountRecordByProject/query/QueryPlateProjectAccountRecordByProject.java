package pomplatform.PlateProjectAccountRecordByProject.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.PlateProjectAccountRecordByProject.bean.BasePlateProjectAccountRecordByProject;
import pomplatform.PlateProjectAccountRecordByProject.bean.ConditionPlateProjectAccountRecordByProject;

public class QueryPlateProjectAccountRecordByProject extends AbstractQuery<BasePlateProjectAccountRecordByProject, ConditionPlateProjectAccountRecordByProject>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateProjectAccountRecordByProject.class);

	public QueryPlateProjectAccountRecordByProject() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BasePlateProjectAccountRecordByProject> executeQuery( KeyValuePair[] replacements, ConditionPlateProjectAccountRecordByProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getRecordYear(), 
				condition.getRecordMonth(), 
				condition.getContractCode(), 
				condition.getProjectCode(), 
				condition.getProjectName()
			);
	}

	@Override
	public BasePlateProjectAccountRecordByProject generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateProjectAccountRecordByProject __base = new BasePlateProjectAccountRecordByProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccountIntegral(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
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

	private final static String __SQLText = "select a.plate_id,a.project_id,b.contract_code,b.project_code,b.project_name,sum(a.account_integral) as account_integral from plate_project_account_records a left join projects b on a.project_id = b.project_id where a.plate_id = ? AND extract(year from a.account_date) = ? and extract(month from a.account_date) = ? AND b.contract_code like ? AND b.project_code like ? and b.project_name like ? group by a.plate_id,a.project_id,b.contract_code,b.project_code,b.project_name ORDER BY a.project_id desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,project_id,contract_code,project_code,project_name,account_integral";
	private final static String[] fieldNames = { "plate_id", "record_year", "record_month", "contract_code", "project_code", "project_name"};
}
