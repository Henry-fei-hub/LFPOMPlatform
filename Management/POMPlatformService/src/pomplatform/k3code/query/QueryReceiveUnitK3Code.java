package pomplatform.k3code.query;

import java.sql.Date;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3code.bean.BaseReceiveUnitK3Code;
import pomplatform.k3code.bean.ConditionReceiveUnitK3Code;

public class QueryReceiveUnitK3Code extends AbstractQuery<BaseReceiveUnitK3Code, ConditionReceiveUnitK3Code>
{

	private static final Logger __logger = Logger.getLogger(QueryReceiveUnitK3Code.class);

	public QueryReceiveUnitK3Code() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("kc.k3_code_id");
	}

	@Override
	public BaseCollection<BaseReceiveUnitK3Code> executeQuery( KeyValuePair[] replacements, ConditionReceiveUnitK3Code condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessId(), 
				condition.getBankAccount(), 
				condition.getK3Code(),
				condition.getReceiveUnit(),
				condition.getOperateStartTime(),
				condition.getOperateEndTime(),
				condition.getUpdateStartTime(),
				condition.getUpdateEndTime()
			);
	}

	@Override
	public BaseReceiveUnitK3Code generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReceiveUnitK3Code __base = new BaseReceiveUnitK3Code();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setK3CodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setK3Code(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setK3Name(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
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

	private final static String __SQLText = "SELECT kc.k3_code_id, kc.type, kc.business_id, kc.k3_code, kc.k3_name, rum.bank_account, rum.receive_unit, rum.operate_time from k3_codes kc LEFT JOIN receive_unit_manages rum ON kc.business_id = rum.receive_unit_manage_id WHERE kc.business_id = ? AND rum.bank_account like ? AND kc.k3_code like ? AND rum.receive_unit like ? AND kc.type = 8 and rum.operate_time >= ? and rum.operate_time < ? and kc.update_time >= ? and kc.update_time < ?" ;
	private final static String RESULTSETFIELDLIST = "k3_code_id,type,business_id,k3_code,k3_name,bank_account,receive_unit,operate_time";
	private final static String[] fieldNames = { "business_id", "bank_account", "k3_code", "receive_unit", "operate_start_time", "operate_end_time", "update_start_time", "update_end_time"};
}
