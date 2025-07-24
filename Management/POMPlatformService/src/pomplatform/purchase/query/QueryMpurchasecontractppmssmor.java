package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseMpurchasecontractppmssmor;
import pomplatform.purchase.bean.ConditionMpurchasecontractppmssmor;

public class QueryMpurchasecontractppmssmor extends AbstractQuery<BaseMpurchasecontractppmssmor, ConditionMpurchasecontractppmssmor>
{

	private static final Logger __logger = Logger.getLogger(QueryMpurchasecontractppmssmor.class);

	public QueryMpurchasecontractppmssmor() throws java.sql.SQLException 
	{
		setParameterNumber(19);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pc.purchase_contract_id");
	}

	@Override
	public BaseCollection<BaseMpurchasecontractppmssmor> executeQuery( KeyValuePair[] replacements, ConditionMpurchasecontractppmssmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinContractDate(), 
				condition.getMaxContractDate(), 
				condition.getPurchaseContractId(), 
				condition.getSupplierId(), 
				condition.getPurchasePerson(), 
				condition.getMainProjectId(), 
				condition.getAfterSaleRequirements(), 
				condition.getPersonnelBusinessId(), 
				condition.getContractName(), 
				condition.getContractCode(), 
				condition.getQualityAssurance(), 
				condition.getTermOfPayment(), 
				condition.getAfterSaleRequirements(), 
				condition.getProjectName(), 
				condition.getProjectCode(), 
				condition.getMainProjectId(), 
				condition.getSupplierName(), 
				condition.getSupplierId(), 
				condition.getMajorContactPerson()
			);
	}

	@Override
	public BaseMpurchasecontractppmssmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMpurchasecontractppmssmor __base = new BaseMpurchasecontractppmssmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPurchasePerson(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQualityAssurance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTermOfPayment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAfterSaleRequirements(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmountPaid(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAmountUnpaid(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHaveInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLackInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractAttachment(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAbbreviatedName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMajorContactPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileName(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setString(count++, GenericBase.__getString(args[18]));
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

	private final static String __SQLText = "SELECT pc.purchase_contract_id, pc.contract_name, pc.contract_code, pc.supplier_id, pc.purchase_person, pc.contract_amount, pc.main_project_id, pc.quality_assurance, pc.contract_date, pc.term_of_payment, pc.after_sale_requirements, pc.amount_paid, pc.amount_unpaid, pc.have_invoice_amount, pc.lack_invoice_amount, pc.contract_attachment, pc.personnel_business_id, pc.create_time, mp.project_name, mp.project_code, sp.supplier_name, sp.abbreviated_name, sp.major_contact_person, sp.contact_phone, fm.file_url, fm.file_name FROM purchase_contracts pc LEFT JOIN main_projects mp ON mp.main_project_id = pc.main_project_id LEFT JOIN suppliers sp ON sp.supplier_id = pc.supplier_id LEFT JOIN file_manages fm ON fm.file_id = pc.contract_attachment WHERE pc.contract_date BETWEEN ? AND ? AND pc.purchase_contract_id = ? AND pc.supplier_id = ? AND pc.purchase_person = ? AND pc.main_project_id = ? AND pc.after_sale_requirements = ? AND pc.personnel_business_id = ? AND pc.contract_name LIKE ? AND pc.contract_code LIKE ? AND pc.quality_assurance LIKE ? AND pc.term_of_payment LIKE ? AND pc.after_sale_requirements LIKE ? AND mp.project_name LIKE ? AND mp.project_code LIKE ? AND mp.main_project_id = ? AND sp.supplier_name LIKE ? AND sp.supplier_id = ? AND sp.major_contact_person LIKE ? ORDER BY pc.contract_date ASC" ;
	private final static String RESULTSETFIELDLIST = "purchase_contract_id,contract_name,contract_code,supplier_id,purchase_person,contract_amount,main_project_id,quality_assurance,contract_date,term_of_payment,after_sale_requirements,amount_paid,amount_unpaid,have_invoice_amount,lack_invoice_amount,contract_attachment,personnel_business_id,create_time,project_name,project_code,supplier_name,abbreviated_name,major_contact_person,contact_phone,file_url,file_name";
	private final static String[] fieldNames = { "min_contract_date", "max_contract_date", "purchase_contract_id", "supplier_id", "purchase_person", "main_project_id", "after_sale_requirements", "personnel_business_id", "contract_name", "contract_code", "quality_assurance", "term_of_payment", "after_sale_requirements", "project_name", "project_code", "main_project_id", "supplier_name", "supplier_id", "major_contact_person"};
}
