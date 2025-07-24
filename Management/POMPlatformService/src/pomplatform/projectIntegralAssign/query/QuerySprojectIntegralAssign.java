package pomplatform.projectIntegralAssign.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectIntegralAssign.bean.BaseSprojectIntegralAssign;
import pomplatform.projectIntegralAssign.bean.ConditionSprojectIntegralAssign;

public class QuerySprojectIntegralAssign extends AbstractQuery<BaseSprojectIntegralAssign, ConditionSprojectIntegralAssign>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectIntegralAssign.class);

	public QuerySprojectIntegralAssign() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("piar.project_integral_assign_record_id");
	}

	@Override
	public BaseCollection<BaseSprojectIntegralAssign> executeQuery( KeyValuePair[] replacements, ConditionSprojectIntegralAssign condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getEmployeeId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseSprojectIntegralAssign generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectIntegralAssign __base = new BaseSprojectIntegralAssign();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectIntegralAssignRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBeforeReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAfterReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAssignDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "select piar.project_integral_assign_record_id, piar.project_id, piar.employee_id, piar.before_reserve_integral, piar.after_reserve_integral, piar.assign_integral, piar.assign_date, piar.plate_id, piar.plate_employee_id, piar.remark from project_integral_assign_records piar where piar.project_id = ? and piar.employee_id = ? and piar.plate_id = ? order by piar.project_integral_assign_record_id desc" ;
	private final static String RESULTSETFIELDLIST = "project_integral_assign_record_id,project_id,employee_id,before_reserve_integral,after_reserve_integral,assign_integral,assign_date,plate_id,plate_employee_id,remark";
	private final static String[] fieldNames = { "project_id", "employee_id", "plate_id"};
}
