package pomplatform.workflow.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseonLoadPurchaseProductBySupplier;
import pomplatform.workflow.bean.ConditiononLoadPurchaseProductBySupplier;

public class QueryonLoadPurchaseProductBySupplier extends AbstractQuery<BaseonLoadPurchaseProductBySupplier, ConditiononLoadPurchaseProductBySupplier>
{

	private static final Logger __logger = Logger.getLogger(QueryonLoadPurchaseProductBySupplier.class);

	public QueryonLoadPurchaseProductBySupplier() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.personnel_business_id");
	}

	@Override
	public BaseCollection<BaseonLoadPurchaseProductBySupplier> executeQuery( KeyValuePair[] replacements, ConditiononLoadPurchaseProductBySupplier condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPersonnelBusinessId(), 
				condition.getMainProjectId()
			);
	}

	@Override
	public BaseonLoadPurchaseProductBySupplier generateBase(Object[] __data) throws java.sql.SQLException {
		BaseonLoadPurchaseProductBySupplier __base = new BaseonLoadPurchaseProductBySupplier();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPurchaseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonInCharge(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPurchaseDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT a.personnel_business_id,a.main_project_id,m.project_code,m.project_name,a.supplier_id,SUM(a.total_price) AS purchase_amount,SUM(a.final_price) AS tax_amount,p.person_in_charge,p.purchase_date,p.remark FROM purchase_product_details a LEFT JOIN main_projects m ON a.main_project_id = m.main_project_id LEFT JOIN purchase_plans p ON a.personnel_business_id = p.ori_personnel_business_id AND p.main_project_id = a.main_project_id WHERE a.personnel_business_id = ? AND a.main_project_id = ? GROUP BY a.personnel_business_id,a.main_project_id,m.project_code,m.project_name,a.supplier_id,p.person_in_charge,p.purchase_date,p.remark" ;
	private final static String RESULTSETFIELDLIST = "personnel_business_id,main_project_id,project_code,project_name,supplier_id,purchase_amount,tax_amount,person_in_charge,purchase_date,remark";
	private final static String[] fieldNames = { "personnel_business_id", "main_project_id"};
}
