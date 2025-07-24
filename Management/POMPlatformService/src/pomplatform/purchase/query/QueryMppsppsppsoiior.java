package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseMppsppsppsoiior;
import pomplatform.purchase.bean.ConditionMppsppsppsoiior;

public class QueryMppsppsppsoiior extends AbstractQuery<BaseMppsppsppsoiior, ConditionMppsppsppsoiior>
{

	private static final Logger __logger = Logger.getLogger(QueryMppsppsppsoiior.class);

	public QueryMppsppsppsoiior() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ps.product_storage_id");
	}

	@Override
	public BaseCollection<BaseMppsppsppsoiior> executeQuery( KeyValuePair[] replacements, ConditionMppsppsppsoiior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProductStorageId(), 
				condition.getPersonnelBusinessId(), 
				condition.getSupplierId(), 
				condition.getPurchaseContractId(), 
				condition.getProductId(), 
				condition.getStorageId(), 
				condition.getOperateType(), 
				condition.getInOutType(), 
				condition.getIsComplete()
			);
	}

	@Override
	public BaseMppsppsppsoiior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMppsppsppsoiior __base = new BaseMppsppsppsoiior();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProductStorageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStorageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInOutType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxPoints(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsComplete(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductModel(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductSkinsSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCategoryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductSpecification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStorageCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStorageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStorageType(GenericBase.__getInt(val));
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
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[8]));
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

	private final static String __SQLText = "SELECT ps.product_storage_id, ps.personnel_business_id, ps.supplier_id, ps.purchase_contract_id, ps.product_id, ps.storage_id, ps.operate_type, ps.in_out_type, ps.product_number, ps.product_price, ps.total_price, ps.tax_points, ps.tax_price, ps.final_price, ps.create_employee_id, ps.create_time, ps.is_complete, ps.remark, pr.product_model, pr.product_name, pr.product_skins_size, pr.category_id, pr.product_type, pr.product_unit, pr.product_specification, st.storage_code, st.storage_name, st.storage_type FROM product_storages ps LEFT JOIN products pr ON pr.product_id = ps.product_id LEFT JOIN storages st ON st.storage_id = ps.storage_id WHERE ps.product_storage_id = ? AND ps.personnel_business_id = ? AND ps.supplier_id = ? AND ps.purchase_contract_id = ? AND ps.product_id = ? AND ps.storage_id = ? AND ps.operate_type = ? AND ps.in_out_type = ? AND ps.is_complete = ?" ;
	private final static String RESULTSETFIELDLIST = "product_storage_id,personnel_business_id,supplier_id,purchase_contract_id,product_id,storage_id,operate_type,in_out_type,product_number,product_price,total_price,tax_points,tax_price,final_price,create_employee_id,create_time,is_complete,remark,product_model,product_name,product_skins_size,category_id,product_type,product_unit,product_specification,storage_code,storage_name,storage_type";
	private final static String[] fieldNames = { "product_storage_id", "personnel_business_id", "supplier_id", "purchase_contract_id", "product_id", "storage_id", "operate_type", "in_out_type", "is_complete"};
}
