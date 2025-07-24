package pomplatform.selectgrid.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.selectgrid.bean.BaseSelectGridReceiveUnitValue;
import pomplatform.selectgrid.bean.ConditionSelectGridReceiveUnitValue;

public class QuerySelectGridReceiveUnitValue extends AbstractQuery<BaseSelectGridReceiveUnitValue, ConditionSelectGridReceiveUnitValue>
{

	private static final Logger __logger = Logger.getLogger(QuerySelectGridReceiveUnitValue.class);

	public QuerySelectGridReceiveUnitValue() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rum.receive_unit_manage_id");
	}

	@Override
	public BaseCollection<BaseSelectGridReceiveUnitValue> executeQuery( KeyValuePair[] replacements, ConditionSelectGridReceiveUnitValue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReceiveUnitManageId(), 
				condition.getOrigin(), 
				condition.getReceiveUnit(), 
				condition.getBankName(), 
				condition.getReceiveUnitAddress()
			);
	}

	@Override
	public BaseSelectGridReceiveUnitValue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSelectGridReceiveUnitValue __base = new BaseSelectGridReceiveUnitValue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOrigin(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select rum.receive_unit_manage_id, rum.receive_unit, rum.bank_account, rum.bank_name, rum.receive_unit_address, rum.operate_employee_id, rum.operate_time, rum.origin from receive_unit_manages rum where rum.receive_unit_manage_id = ? and rum.origin = ? and rum.receive_unit like ? and rum.bank_name like ? and rum.receive_unit_address like ?_address" ;
	private final static String RESULTSETFIELDLIST = "receive_unit_manage_id,receive_unit,bank_account,bank_name,receive_unit_address,operate_employee_id,operate_time,origin";
	private final static String[] fieldNames = { "receive_unit_manage_id", "origin", "receive_unit", "bank_name", "receive_unit_address"};
}
