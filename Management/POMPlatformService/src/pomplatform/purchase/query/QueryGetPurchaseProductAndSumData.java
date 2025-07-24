package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseGetPurchaseProductAndSumData;
import pomplatform.purchase.bean.ConditionGetPurchaseProductAndSumData;

public class QueryGetPurchaseProductAndSumData extends AbstractQuery<BaseGetPurchaseProductAndSumData, ConditionGetPurchaseProductAndSumData>
{

	private static final Logger __logger = Logger.getLogger(QueryGetPurchaseProductAndSumData.class);

	public QueryGetPurchaseProductAndSumData() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ppd.purchase_product_detail_id");
	}

	@Override
	public BaseCollection<BaseGetPurchaseProductAndSumData> executeQuery( KeyValuePair[] replacements, ConditionGetPurchaseProductAndSumData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPurchaseProductDetailId(), 
				condition.getPersonnelBusinessId(), 
				condition.getMainProjectId(), 
				condition.getSupplierId(), 
				condition.getProductId(), 
				condition.getPurchaseContractId()
			);
	}

	@Override
	public BaseGetPurchaseProductAndSumData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetPurchaseProductAndSumData __base = new BaseGetPurchaseProductAndSumData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPurchaseProductDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxPoints(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlanArrivalDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductModel(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCategoryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductSkinsSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductSpecification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHaveSum(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT ppd.purchase_product_detail_id, ppd.personnel_business_id, ppd.main_project_id, ppd.supplier_id, ppd.product_id, ppd.product_number, ppd.product_unit, ppd.product_price, ppd.total_price, ppd.tax_points, ppd.tax_price, ppd.final_price, ppd.plan_arrival_date, ppd.create_employee_id, ppd.create_time, ppd.remark, ppd.purchase_contract_id, pr.product_name, pr.product_model, pr.category_id, pr.product_type, pr.product_skins_size, pr.product_specification, COALESCE (ap.have_sum, 0) as have_sum FROM purchase_product_details ppd LEFT JOIN products pr ON pr.product_id = ppd.product_id LEFT JOIN ( SELECT purchase_contract_id, product_id, COALESCE (SUM(product_number), 0) AS have_sum FROM product_storages WHERE is_complete = TRUE AND in_out_type = 1 GROUP BY purchase_contract_id, product_id ) ap ON ap.purchase_contract_id = ppd.purchase_contract_id AND ap.product_id = ppd.product_id WHERE ppd.purchase_product_detail_id = ? AND ppd.personnel_business_id = ? AND ppd.main_project_id = ? AND ppd.supplier_id = ? AND ppd.product_id = ? AND ppd.purchase_contract_id = ?" ;
	private final static String RESULTSETFIELDLIST = "purchase_product_detail_id,personnel_business_id,main_project_id,supplier_id,product_id,product_number,product_unit,product_price,total_price,tax_points,tax_price,final_price,plan_arrival_date,create_employee_id,create_time,remark,purchase_contract_id,product_name,product_model,category_id,product_type,product_skins_size,product_specification,have_sum";
	private final static String[] fieldNames = { "purchase_product_detail_id", "personnel_business_id", "main_project_id", "supplier_id", "product_id", "purchase_contract_id"};
}
