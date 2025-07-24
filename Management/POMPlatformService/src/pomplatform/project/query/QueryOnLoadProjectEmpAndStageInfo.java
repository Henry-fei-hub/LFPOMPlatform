package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadProjectEmpAndStageInfo;
import pomplatform.project.bean.ConditionOnLoadProjectEmpAndStageInfo;

public class QueryOnLoadProjectEmpAndStageInfo extends AbstractQuery<BaseOnLoadProjectEmpAndStageInfo, ConditionOnLoadProjectEmpAndStageInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectEmpAndStageInfo.class);

	public QueryOnLoadProjectEmpAndStageInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.project_employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectEmpAndStageInfo> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectEmpAndStageInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseOnLoadProjectEmpAndStageInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectEmpAndStageInfo __base = new BaseOnLoadProjectEmpAndStageInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT A.project_employee_id, A.project_id, A.employee_id, b.employee_no, b.employee_name, A.stage_id, A.plan_integral, ( SELECT SUM ( aa.real_amount ) AS sure_integral FROM project_settlement_details aa LEFT JOIN project_settlements bb ON aa.settlement_id = bb.settlement_id WHERE aa.project_id = A.project_id AND aa.employee_id = A.employee_id AND bb.stage_id = A.stage_id AND aa.settlement_status = 2 GROUP BY aa.project_id, aa.employee_id, bb.stage_id ), b.grade_id, A.alternate_field1, A.alternate_field2 FROM project_employees A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE A.project_id =? AND stage_id >= 0" ;
	private final static String RESULTSETFIELDLIST = "project_employee_id,project_id,employee_id,employee_no,employee_name,stage_id,plan_integral,sure_integral,grade_id,alternate_field1,alternate_field2";
	private final static String[] fieldNames = { "project_id"};
}
