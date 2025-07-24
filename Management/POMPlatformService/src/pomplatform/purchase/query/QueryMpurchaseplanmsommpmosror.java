package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseMpurchaseplanmsommpmosror;
import pomplatform.purchase.bean.ConditionMpurchaseplanmsommpmosror;

public class QueryMpurchaseplanmsommpmosror extends AbstractQuery<BaseMpurchaseplanmsommpmosror, ConditionMpurchaseplanmsommpmosror>
{

	private static final Logger __logger = Logger.getLogger(QueryMpurchaseplanmsommpmosror.class);

	public QueryMpurchaseplanmsommpmosror() throws java.sql.SQLException 
	{
		setParameterNumber(17);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pp.purchase_plan_id");
	}

	@Override
	public BaseCollection<BaseMpurchaseplanmsommpmosror> executeQuery( KeyValuePair[] replacements, ConditionMpurchaseplanmsommpmosror condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getToPersonnelBusinessId(), 
				condition.getDealStatus(), 
				condition.getPurchaseContractId(), 
				condition.getIsComplete(), 
				condition.getOperatorId(), 
				condition.getMinPurchaseDate(), 
				condition.getMaxPurchaseDate(), 
				condition.getPersonInCharge(), 
				condition.getMainProjectId(), 
				condition.getOriPersonnelBusinessId(), 
				condition.getSupplierId(), 
				condition.getRemark(), 
				condition.getProjectName(), 
				condition.getProjectCode(), 
				condition.getSupplierName(), 
				condition.getContractCode(), 
				condition.getContractName()
			);
	}

	@Override
	public BaseMpurchaseplanmsommpmosror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMpurchaseplanmsommpmosror __base = new BaseMpurchaseplanmsommpmosror();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPurchasePlanId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonInCharge(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOriPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPurchaseDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPurchaseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAbbreviatedName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMajorContactPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsComplete(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDealStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setToPersonnelBusinessId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
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

	private final static String __SQLText = "SELECT pp.purchase_plan_id, pp.person_in_charge, pp.main_project_id, mp.project_code, mp.project_name, pp.ori_personnel_business_id, pp.purchase_date, pp.purchase_amount, pp.supplier_id, sp.supplier_name, sp.supplier_code, sp.abbreviated_name, sp.major_contact_person, sp.contact_phone, pp.tax_amount, pp.remark, pp.create_time, pp.is_complete, pp.operator_id, pp.deal_status, pp.purchase_contract_id, pc.contract_name, pc.contract_code,pp.to_personnel_business_id FROM purchase_plans pp LEFT JOIN main_projects mp ON mp.main_project_id = pp.main_project_id LEFT JOIN supplier sp ON pp.supplier_id = sp.supplier_id LEFT JOIN purchase_contracts pc ON pc.purchase_contract_id = pp.purchase_contract_id WHERE pp.to_personnel_business_id = ? and pp.deal_status = ? AND pp.purchase_contract_id = ? AND pp.is_complete = ? AND pp.operator_id = ? AND pp.purchase_date BETWEEN ? AND ? AND pp.person_in_charge = ? AND pp.main_project_id = ? AND pp.ori_personnel_business_id = ? AND pp.supplier_id = ? AND pp.remark LIKE ? AND mp.project_name LIKE ? AND mp.project_code LIKE ? AND sp.supplier_name LIKE ? AND pc.contract_code LIKE ? AND pc.contract_name LIKE ? ORDER BY pp.purchase_date, pp.create_time" ;
	private final static String RESULTSETFIELDLIST = "purchase_plan_id,person_in_charge,main_project_id,project_code,project_name,ori_personnel_business_id,purchase_date,purchase_amount,supplier_id,supplier_name,supplier_code,abbreviated_name,major_contact_person,contact_phone,tax_amount,remark,create_time,is_complete,operator_id,deal_status,purchase_contract_id,contract_name,contract_code,to_personnel_business_id";
	private final static String[] fieldNames = { "to_personnel_business_id", "deal_status", "purchase_contract_id", "is_complete", "operator_id", "min_purchase_date", "max_purchase_date", "person_in_charge", "main_project_id", "ori_personnel_business_id", "supplier_id", "remark", "project_name", "project_code", "supplier_name", "contract_code", "contract_name"};
}
