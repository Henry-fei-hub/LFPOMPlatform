package pomplatform.mcontractreceivableiicor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mcontractreceivableiicor.bean.BaseMcontractreceivableiicor;
import pomplatform.mcontractreceivableiicor.bean.ConditionMcontractreceivableiicor;

public class QueryMcontractreceivableiicor extends AbstractQuery<BaseMcontractreceivableiicor, ConditionMcontractreceivableiicor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcontractreceivableiicor.class);

	public QueryMcontractreceivableiicor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cr.contract_id");
	}

	@Override
	public BaseCollection<BaseMcontractreceivableiicor> executeQuery( KeyValuePair[] replacements, ConditionMcontractreceivableiicor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInvoiceApplyId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseMcontractreceivableiicor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcontractreceivableiicor __base = new BaseMcontractreceivableiicor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceivableName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceivablePercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceivableSumMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsConfirmationLetter(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceivableApplyMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT cr.contract_id, cr.contract_receivable_id, cr.receivable_name, cr.receivable_percentage, cr.receivable_sum_money, cr.is_confirmation_letter, cr.remark, cr.parent_id, iar.receivable_apply_money, iar.create_time FROM contract_receivables cr LEFT JOIN invoice_apply_receivables iar ON iar.contract_id = cr.contract_id AND iar.contract_receivable_id = cr.contract_receivable_id AND iar.invoice_apply_id = ? WHERE cr.contract_id = ?;" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_receivable_id,receivable_name,receivable_percentage,receivable_sum_money,is_confirmation_letter,remark,parent_id,receivable_apply_money,create_time";
	private final static String[] fieldNames = { "invoice_apply_id", "contract_id"};
}
