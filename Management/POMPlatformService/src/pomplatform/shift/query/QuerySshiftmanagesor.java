package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseSshiftmanagesor;
import pomplatform.shift.bean.ConditionSshiftmanagesor;

public class QuerySshiftmanagesor extends AbstractQuery<BaseSshiftmanagesor, ConditionSshiftmanagesor>
{

	private static final Logger __logger = Logger.getLogger(QuerySshiftmanagesor.class);

	public QuerySshiftmanagesor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sm.shift_manage_id");
	}

	@Override
	public BaseCollection<BaseSshiftmanagesor> executeQuery( KeyValuePair[] replacements, ConditionSshiftmanagesor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getShiftName()
			);
	}

	@Override
	public BaseSshiftmanagesor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSshiftmanagesor __base = new BaseSshiftmanagesor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setShiftManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShiftName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "select sm.shift_manage_id, sm.shift_name, sm.start_date, sm.end_date, sm.is_enable, sm.operate_employee_id, sm.operate_time, sm.remark from shift_manages sm where sm.shift_name like ? and shift_manage_id > 2" ;
	private final static String RESULTSETFIELDLIST = "shift_manage_id,shift_name,start_date,end_date,is_enable,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "shift_name"};
}
