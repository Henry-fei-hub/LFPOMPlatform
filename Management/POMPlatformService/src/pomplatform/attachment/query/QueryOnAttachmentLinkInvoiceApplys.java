package pomplatform.attachment.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseOnAttachmentLinkInvoiceApplys;
import pomplatform.attachment.bean.ConditionOnAttachmentLinkInvoiceApplys;

public class QueryOnAttachmentLinkInvoiceApplys extends AbstractQuery<BaseOnAttachmentLinkInvoiceApplys, ConditionOnAttachmentLinkInvoiceApplys>
{

	private static final Logger __logger = Logger.getLogger(QueryOnAttachmentLinkInvoiceApplys.class);

	public QueryOnAttachmentLinkInvoiceApplys() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.invoice_apply_id");
	}

	@Override
	public BaseCollection<BaseOnAttachmentLinkInvoiceApplys> executeQuery( KeyValuePair[] replacements, ConditionOnAttachmentLinkInvoiceApplys condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPersonnelBusinessId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseOnAttachmentLinkInvoiceApplys generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnAttachmentLinkInvoiceApplys __base = new BaseOnAttachmentLinkInvoiceApplys();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInvoiceApplyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplicantId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyParagraph(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperatorRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFlagType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBindAmount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegisteredAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLandline(GenericBase.__getString(val));
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

	private final static String __SQLText = "select a.invoice_apply_id,a.applicant_id,a.invoice_type,a.company_name,a.duty_paragraph,a.customer_name,a.customer_phone,a.apply_remark,a.operator_remark ,case when (select count(*) as count from attachment_link_invoice_applys where invoice_apply_id = a.invoice_apply_id and personnel_business_id = ?) > 0 then 2 else 1 end as flag_type,b.bind_amount,a.delete_flag,a.registered_address,a.bank_name,a.bank_account,a.landline from invoice_apply a LEFT JOIN (SELECT alia.invoice_apply_id, COUNT (1) AS bind_amount FROM attachment_link_invoice_applys alia LEFT JOIN system_process_instances spi ON spi.business_id = alia.personnel_business_id AND spi.process_type = 27 WHERE spi.process_status IN (0, 1, 3) AND spi.delete_flag = 0 GROUP BY alia.invoice_apply_id ) b ON b.invoice_apply_id = a.invoice_apply_id where a.contract_id = ? ORDER BY a.invoice_apply_id" ;
	private final static String RESULTSETFIELDLIST = "invoice_apply_id,applicant_id,invoice_type,company_name,duty_paragraph,customer_name,customer_phone,apply_remark,operator_remark,flag_type,bind_amount,delete_flag,registered_address,bank_name,bank_account,landline";
	private final static String[] fieldNames = { "personnel_business_id", "contract_id"};
}
