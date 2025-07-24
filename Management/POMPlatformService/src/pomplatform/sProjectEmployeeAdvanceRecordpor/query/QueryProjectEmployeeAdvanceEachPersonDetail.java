package pomplatform.sProjectEmployeeAdvanceRecordpor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sProjectEmployeeAdvanceRecordpor.bean.BaseProjectEmployeeAdvanceEachPersonDetail;
import pomplatform.sProjectEmployeeAdvanceRecordpor.bean.ConditionProjectEmployeeAdvanceEachPersonDetail;

public class QueryProjectEmployeeAdvanceEachPersonDetail extends AbstractQuery<BaseProjectEmployeeAdvanceEachPersonDetail, ConditionProjectEmployeeAdvanceEachPersonDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectEmployeeAdvanceEachPersonDetail.class);

	public QueryProjectEmployeeAdvanceEachPersonDetail() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseProjectEmployeeAdvanceEachPersonDetail> executeQuery( KeyValuePair[] replacements, ConditionProjectEmployeeAdvanceEachPersonDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseProjectEmployeeAdvanceEachPersonDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectEmployeeAdvanceEachPersonDetail __base = new BaseProjectEmployeeAdvanceEachPersonDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.project_id, a.employee_id, a.advanced_integral as advance_integral, a.advance_date, a.operate_employee_id, a.remark from project_employee_advance_records a WHERE a.project_id = ? AND a.employee_id = ? ORDER BY a.advance_date" ;
	private final static String RESULTSETFIELDLIST = "project_id,employee_id,advance_integral,advance_date,operate_employee_id,remark";
	private final static String[] fieldNames = { "project_id", "employee_id"};
}
