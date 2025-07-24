package pomplatform.contractchange.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractchange.bean.BaseChangeContractInfo;
import pomplatform.contractchange.bean.ConditionChangeContractInfo;

public class QueryChangeContractInfo extends AbstractQuery<BaseChangeContractInfo, ConditionChangeContractInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryChangeContractInfo.class);

	public QueryChangeContractInfo() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cc.contract_change_id");
	}

	@Override
	public BaseCollection<BaseChangeContractInfo> executeQuery( KeyValuePair[] replacements, ConditionChangeContractInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getFlag()
			);
	}

	@Override
	public BaseChangeContractInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseChangeContractInfo __base = new BaseChangeContractInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractChangeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractChangeAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractChangeView(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select cc.contract_change_id, cc.contract_id, cc.contract_amount, cc.contract_change_amount, cc.contract_final_amount, cc.contract_change_view, cc.flag, cc.operate_employee_id, cc.operate_time, cc.remark from contract_changes cc where cc.contract_id = ? and cc.flag = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_change_id,contract_id,contract_amount,contract_change_amount,contract_final_amount,contract_change_view,flag,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "contract_id", "flag"};
}
