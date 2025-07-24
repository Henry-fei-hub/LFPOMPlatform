package pomplatform.contractreceivablecipor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractreceivablecipor.bean.BaseScontractreceivablecipor;
import pomplatform.contractreceivablecipor.bean.ConditionScontractreceivablecipor;

public class QueryScontractreceivablecipor extends AbstractQuery<BaseScontractreceivablecipor, ConditionScontractreceivablecipor>
{

	private static final Logger __logger = Logger.getLogger(QueryScontractreceivablecipor.class);

	public QueryScontractreceivablecipor() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("contract_receivable_id");
	}

	@Override
	public BaseCollection<BaseScontractreceivablecipor> executeQuery( KeyValuePair[] replacements, ConditionScontractreceivablecipor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractReceivableId(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getReceivableName(), 
				condition.getIsConfirmationLetter(), 
				condition.getRemark(), 
				condition.getParentId()
			);
	}

	@Override
	public BaseScontractreceivablecipor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScontractreceivablecipor __base = new BaseScontractreceivablecipor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceivableName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceivablePercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceivableSumMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsConfirmationLetter(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "SELECT contract_receivable_id, info_code, project_code, contract_id, contract_code, receivable_name, receivable_percentage, receivable_sum_money, is_confirmation_letter, remark, parent_id FROM contract_receivables WHERE contract_receivable_id = ? AND info_code LIKE ? AND project_code LIKE ? AND contract_id = ? AND contract_code LIKE ? AND receivable_name LIKE ? AND is_confirmation_letter = ? AND remark LIKE ? AND parent_id = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_receivable_id,info_code,project_code,contract_id,contract_code,receivable_name,receivable_percentage,receivable_sum_money,is_confirmation_letter,remark,parent_id";
	private final static String[] fieldNames = { "contract_receivable_id", "info_code", "project_code", "contract_id", "contract_code", "receivable_name", "is_confirmation_letter", "remark", "parent_id"};
}
