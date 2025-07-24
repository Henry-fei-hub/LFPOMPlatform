package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseContractManage;
import pomplatform.contract.bean.ConditionContractManage;

public class QueryContractManage extends AbstractQuery<BaseContractManage, ConditionContractManage>
{

	private static final Logger __logger = Logger.getLogger(QueryContractManage.class);

	public QueryContractManage() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.contract_id");
	}

	@Override
	public BaseCollection<BaseContractManage> executeQuery( KeyValuePair[] replacements, ConditionContractManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSigningCompanyName(), 
				condition.getContractName(), 
				condition.getContractCode(),
				condition.getCustomerId()
			);
	}

	@Override
	public BaseContractManage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractManage __base = new BaseContractManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinancialContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select c.contract_id, c.contract_code, c.contract_name, c.signing_money_sum, c.signing_company_name,c.update_time,c.info_code, c.operator,c.financial_contract_code, c.customer_id, c.customer_name from contracts c where c.signing_company_name = ? and c.contract_name like ? and c.contract_code like ? and c.customer_id = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,signing_money_sum,signing_company_name,update_time,info_code,operator,financial_contract_code,customer_id,customer_name";
	private final static String[] fieldNames = { "signing_company_name", "contract_name", "contract_code", "customer_id"};
}
