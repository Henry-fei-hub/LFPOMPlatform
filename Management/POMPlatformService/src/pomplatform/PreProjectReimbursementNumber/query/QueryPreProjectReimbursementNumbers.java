package pomplatform.PreProjectReimbursementNumber.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.PreProjectReimbursementNumber.bean.BasePreProjectReimbursementNumbers;
import pomplatform.PreProjectReimbursementNumber.bean.ConditionPreProjectReimbursementNumbers;

public class QueryPreProjectReimbursementNumbers extends AbstractQuery<BasePreProjectReimbursementNumbers, ConditionPreProjectReimbursementNumbers>
{

	private static final Logger __logger = Logger.getLogger(QueryPreProjectReimbursementNumbers.class);

	public QueryPreProjectReimbursementNumbers() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pprn.pre_project_reimbursement_number_id");
	}

	@Override
	public BaseCollection<BasePreProjectReimbursementNumbers> executeQuery( KeyValuePair[] replacements, ConditionPreProjectReimbursementNumbers condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectName(), 
				condition.getOperator(), 
				condition.getCustomNumber(), 
				condition.getRemark()
			);
	}

	@Override
	public BasePreProjectReimbursementNumbers generateBase(Object[] __data) throws java.sql.SQLException {
		BasePreProjectReimbursementNumbers __base = new BasePreProjectReimbursementNumbers();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPreProjectReimbursementNumberId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreBusinessType(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "select pprn.pre_project_reimbursement_number_id, pprn.custom_number, pprn.main_project_id, pprn.project_manager, pprn.operator, pprn.create_time, pprn.remark , mp.project_code, mp.project_name,mp.business_type,mp.project_type,pprn.plate_id, pprn.pre_project_type, pprn.pre_business_type from pre_project_reimbursement_numbers pprn left join pre_projects mp on pprn.main_project_id=mp.pre_project_id where mp.project_name like ? and pprn.operator = ? and pprn.custom_number like ? and pprn.remark like ?" ;
	private final static String RESULTSETFIELDLIST = "pre_project_reimbursement_number_id,custom_number,main_project_id,project_manager,operator,create_time,remark,project_code,project_name,business_type,project_type,plate_id,pre_project_type,pre_business_type";
	private final static String[] fieldNames = { "project_name", "operator", "custom_number", "remark"};
}
