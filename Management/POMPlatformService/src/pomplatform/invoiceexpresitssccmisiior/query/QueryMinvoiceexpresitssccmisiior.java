package pomplatform.invoiceexpresitssccmisiior.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.invoiceexpresitssccmisiior.bean.BaseMinvoiceexpresitssccmisiior;
import pomplatform.invoiceexpresitssccmisiior.bean.ConditionMinvoiceexpresitssccmisiior;

public class QueryMinvoiceexpresitssccmisiior extends AbstractQuery<BaseMinvoiceexpresitssccmisiior, ConditionMinvoiceexpresitssccmisiior>
{

	private static final Logger __logger = Logger.getLogger(QueryMinvoiceexpresitssccmisiior.class);

	public QueryMinvoiceexpresitssccmisiior() throws java.sql.SQLException 
	{
		setParameterNumber(19);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT 	ct.contract_id");
	}

	@Override
	public BaseCollection<BaseMinvoiceexpresitssccmisiior> executeQuery( KeyValuePair[] replacements, ConditionMinvoiceexpresitssccmisiior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getContractId(), 
				condition.getClientName(), 
				condition.getCourierType(), 
				condition.getMinCourierDate(), 
				condition.getMaxCourierDate(), 
				condition.getMinSignDate(), 
				condition.getMaxSignDate(), 
				condition.getTel(), 
				condition.getSignStatus(), 
				condition.getSignName(), 
				condition.getCourierNumber(), 
				condition.getMailingAddress(), 
				condition.getInvoiceType(), 
				condition.getSign(), 
				condition.getInvoiceCode(), 
				condition.getInvoiceNumber(), 
				condition.getContactId()
			);
	}

	@Override
	public BaseMinvoiceexpresitssccmisiior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMinvoiceexpresitssccmisiior __base = new BaseMinvoiceexpresitssccmisiior();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceExpressId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCourierType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setClientName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTel(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCourierNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMailingAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCourierDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSignStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSignName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignReceipt(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
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

	private final static String __SQLText = "SELECT DISTINCT ct.contract_id, ct.contract_code, ct.contract_name, ie.invoice_express_id, ie.info_code, ie.project_code, ie.courier_type, ie.contact_id, cl.customer_name as client_name, ie.tel, ie.courier_number, ie.mailing_address, ie.courier_date, ie.sign_status, ie.sign_date, ie.sign_name, ie.sign_receipt, ie.remark, ie.operator FROM invoice_express ie LEFT JOIN contracts ct ON ct.contract_id = ie.contract_id LEFT JOIN invoice_apply cl ON cl.invoice_apply_id = ie.contact_id LEFT JOIN invoices i on i.invoice_express_id = ie.invoice_express_id WHERE ct.contract_code LIKE ? AND ct.contract_name LIKE ? AND ct.contract_id =? AND ie.courier_type = ? AND cl.customer_name LIKE ? AND ie.courier_date BETWEEN ? AND ? AND ie.sign_date BETWEEN ? AND ? AND ie.tel LIKE ? AND ie.sign_status = ? AND ie.sign_name LIKE ? AND ie.courier_number LIKE ? AND ie.mailing_address LIKE ? AND i.invoice_type = ? AND i.sign = ? AND i.invoice_code LIKE ? AND i.invoice_number LIKE ? AND ie.contact_id = ? order by ie.courier_date desc" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,invoice_express_id,info_code,project_code,courier_type,contact_id,client_name,tel,courier_number,mailing_address,courier_date,sign_status,sign_date,sign_name,sign_receipt,remark,operator";
	private final static String[] fieldNames = { "contract_code", "contract_name", "contract_id", "client_name", "courier_type", "min_courier_date", "max_courier_date", "min_sign_date", "max_sign_date", "tel", "sign_status", "sign_name", "courier_number", "mailing_address", "invoice_type", "sign", "invoice_code", "invoice_number", "contact_id"};
}
