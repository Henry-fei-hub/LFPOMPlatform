package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseSpurchasepaymentor;
import pomplatform.purchase.bean.ConditionSpurchasepaymentor;

public class QuerySpurchasepaymentor extends AbstractQuery<BaseSpurchasepaymentor, ConditionSpurchasepaymentor>
{

	private static final Logger __logger = Logger.getLogger(QuerySpurchasepaymentor.class);

	public QuerySpurchasepaymentor() throws java.sql.SQLException 
	{
		setParameterNumber(23);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pp.purchase_payment_id");
	}

	@Override
	public BaseCollection<BaseSpurchasepaymentor> executeQuery( KeyValuePair[] replacements, ConditionSpurchasepaymentor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinRealPaymentDate(), 
				condition.getMaxRealPaymentDate(), 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getPurchaseContractId(), 
				condition.getPurchasePaymentStatus(), 
				condition.getPersonInCharge(), 
				condition.getOperatorId(), 
				condition.getPaymentCondition(), 
				condition.getRemark(), 
				condition.getPaymentName(), 
				condition.getMinPaymentDate(), 
				condition.getMaxPaymentDate(), 
				condition.getPurchasePaymentId(), 
				condition.getPersonnelBusinessId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getProjectName(), 
				condition.getProjectCode(), 
				condition.getMainProjectId(), 
				condition.getSupplierName(), 
				condition.getSupplierId(), 
				condition.getMajorContactPerson()
			);
	}

	@Override
	public BaseSpurchasepaymentor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSpurchasepaymentor __base = new BaseSpurchasepaymentor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPurchasePaymentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPaymentDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPaymentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPaymentCondition(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPurchasePaymentStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonInCharge(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRealPaymentDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRealPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProcessBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDealStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPurchasePerson(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAfterSaleRequirements(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQualityAssurance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTermOfPayment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAbbreviatedName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMajorContactPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setString(count++, GenericBase.__getString(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setString(count++, GenericBase.__getString(args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setString(count++, GenericBase.__getString(args[22]));
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

	private final static String __SQLText = "SELECT pp.purchase_payment_id, pp.personnel_business_id, pp.payment_date, pp.payment_name, pp.payment_condition, pp.payment_ratio, pp.payment_amount, pp.remark, pp.create_time, pp.purchase_contract_id, pp.purchase_payment_status, pp.person_in_charge, pp.operator_id, pp.real_payment_date, pp.real_payment_amount, pp.process_business_id, pp.deal_status, pc.contract_name, pc.contract_code, pc.contract_amount, pc.contract_date, pc.purchase_person, pc.after_sale_requirements, pc.quality_assurance, pc.term_of_payment, mp.main_project_id, mp.project_name, mp.project_code, sp.supplier_id, sp.supplier_name, sp.abbreviated_name, sp.major_contact_person, sp.contact_phone FROM purchase_payments pp LEFT JOIN purchase_contracts pc ON pc.purchase_contract_id = pp.purchase_contract_id LEFT JOIN main_projects mp ON mp.main_project_id = pc.main_project_id LEFT JOIN suppliers sp ON sp.supplier_id = pc.supplier_id WHERE pp.real_payment_date between ? and ? and pp.create_time BETWEEN ? AND ? AND pp.purchase_contract_id = ? AND pp.purchase_payment_status = ? AND pp.person_in_charge = ? AND pp.operator_id = ? AND pp.payment_condition LIKE ? AND pp.remark LIKE ? AND pp.payment_name LIKE ? AND pp.payment_date BETWEEN ? AND ? AND pp.purchase_payment_id = ? AND pp.personnel_business_id = ? AND pc.contract_code LIKE ? AND pc.contract_name LIKE ? AND mp.project_name LIKE ? AND mp.project_code LIKE ? AND mp.main_project_id = ? AND sp.supplier_name LIKE ? AND sp.supplier_id = ? AND sp.major_contact_person LIKE ? ORDER BY pp.payment_date ASC" ;
	private final static String RESULTSETFIELDLIST = "purchase_payment_id,personnel_business_id,payment_date,payment_name,payment_condition,payment_ratio,payment_amount,remark,create_time,purchase_contract_id,purchase_payment_status,person_in_charge,operator_id,real_payment_date,real_payment_amount,process_business_id,deal_status,contract_name,contract_code,contract_amount,contract_date,purchase_person,after_sale_requirements,quality_assurance,term_of_payment,main_project_id,project_name,project_code,supplier_id,supplier_name,abbreviated_name,major_contact_person,contact_phone";
	private final static String[] fieldNames = { "min_real_payment_date", "max_real_payment_date", "min_create_time", "max_create_time", "purchase_contract_id", "purchase_payment_status", "person_in_charge", "operator_id", "payment_condition", "remark", "payment_name", "min_payment_date", "max_payment_date", "purchase_payment_id", "personnel_business_id", "contract_code", "contract_name", "project_name", "project_code", "main_project_id", "supplier_name", "supplier_id", "major_contact_person"};
}
