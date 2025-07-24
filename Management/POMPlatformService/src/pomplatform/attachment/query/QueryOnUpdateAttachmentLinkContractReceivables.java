package pomplatform.attachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseOnUpdateAttachmentLinkContractReceivables;
import pomplatform.attachment.bean.ConditionOnUpdateAttachmentLinkContractReceivables;

public class QueryOnUpdateAttachmentLinkContractReceivables extends AbstractQuery<BaseOnUpdateAttachmentLinkContractReceivables, ConditionOnUpdateAttachmentLinkContractReceivables>
{

	private static final Logger __logger = Logger.getLogger(QueryOnUpdateAttachmentLinkContractReceivables.class);

	public QueryOnUpdateAttachmentLinkContractReceivables() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_receivable_id");
	}

	@Override
	public BaseCollection<BaseOnUpdateAttachmentLinkContractReceivables> executeQuery( KeyValuePair[] replacements, ConditionOnUpdateAttachmentLinkContractReceivables condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAttachmentManageId(), 
				condition.getContractId(), 
				condition.getParentId()
			);
	}

	@Override
	public BaseOnUpdateAttachmentLinkContractReceivables generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnUpdateAttachmentLinkContractReceivables __base = new BaseOnUpdateAttachmentLinkContractReceivables();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceivableName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceivablePercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceivableSumMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlagType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBindAmount(GenericBase.__getLong(val));
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

	private final static String __SQLText = "select a.contract_receivable_id,a.receivable_name,a.receivable_percentage,a.receivable_sum_money,a.parent_id ,case when (select count(*) as count from attachment_link_contract_receivables where contract_receivable_id = a.contract_receivable_id and attachment_manage_id = ?) > 0 then 2 else 1 end as flag_type,b.bind_amount from contract_receivables a LEFT JOIN (SELECT alcr.contract_receivable_id, COUNT (1) AS bind_amount FROM attachment_link_contract_receivables alcr LEFT JOIN system_process_instances spi ON spi.business_id = alcr.personnel_business_id AND spi.process_type = 27 WHERE spi.process_status IN (0, 1, 3) AND spi.delete_flag = 0 GROUP BY alcr.contract_receivable_id ) b ON b.contract_receivable_id = a.contract_receivable_id where a.contract_id = ? and a.parent_id = ? ORDER BY a.contract_receivable_id,a.parent_id" ;
	private final static String RESULTSETFIELDLIST = "contract_receivable_id,receivable_name,receivable_percentage,receivable_sum_money,parent_id,flag_type,bind_amount";
	private final static String[] fieldNames = { "attachment_manage_id", "contract_id", "parent_id"};
}
