package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseContractLogList;
import pomplatform.contract.bean.ConditionContractLogList;

public class QueryContractLogList extends AbstractQuery<BaseContractLogList, ConditionContractLogList>
{

	private static final Logger __logger = Logger.getLogger(QueryContractLogList.class);

	public QueryContractLogList() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseContractLogList> executeQuery( KeyValuePair[] replacements, ConditionContractLogList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getOriginalStatus(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getNewStatus()
			);
	}

	@Override
	public BaseContractLogList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractLogList __base = new BaseContractLogList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOriginalStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNewStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT a.contract_id, b.contract_code, b.contract_name, b.customer_name, b.signing_money_sum, b.signing_company_name, a.original_status, a.new_status, a.operator, a.operate_time from contract_logs a LEFT JOIN contracts b on a.contract_id = b.contract_id where (a.process_status = 3 or a.process_status is null) and a.operate_time >= ? and a.operate_time < ? and a.delete_flag = 0 and a.original_status = ? and b.contract_code like ? and b.contract_name like ? and a.new_status = ? order by a.operate_time, b.contract_code" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,signing_money_sum,signing_company_name,original_status,new_status,operator,operate_time";
	private final static String[] fieldNames = { "start_date", "end_date", "original_status", "contract_code", "contract_name", "new_status"};
}
