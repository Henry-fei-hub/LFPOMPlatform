package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseProductWithP;
import pomplatform.purchase.bean.ConditionProductWithP;

public class QueryProductWithP extends AbstractQuery<BaseProductWithP, ConditionProductWithP>
{

	private static final Logger __logger = Logger.getLogger(QueryProductWithP.class);

	public QueryProductWithP() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.product_id");
	}

	@Override
	public BaseCollection<BaseProductWithP> executeQuery( KeyValuePair[] replacements, ConditionProductWithP condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getProductModel(), 
				condition.getProductSpecification(), 
				condition.getRemark(), 
				condition.getProductId(), 
				condition.getCategoryId(), 
				condition.getProductType(), 
				condition.getIsEnabled(), 
				condition.getCreateEmployeeId(), 
				condition.getDeleteFlag()
			);
	}

	@Override
	public BaseProductWithP generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProductWithP __base = new BaseProductWithP();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProductId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCategoryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductModel(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductSpecification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductSkinsSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
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

	private final static String __SQLText = "select p.product_id, p.category_id, p.product_name, p.product_type, p.product_unit, p.product_model, p.product_specification, p.product_skins_size, p.is_enabled, p.create_employee_id, p.create_time, p.delete_flag, p.remark from products p where p.create_time between ? and ? and p.product_model like ? and p.product_specification like ? and p.remark like ? and p.product_id = ? and p.category_id = ? and p.product_type = ? and p.is_enabled = ? and p.create_employee_id = ? and p.delete_flag = ?" ;
	private final static String RESULTSETFIELDLIST = "product_id,category_id,product_name,product_type,product_unit,product_model,product_specification,product_skins_size,is_enabled,create_employee_id,create_time,delete_flag,remark";
	private final static String[] fieldNames = { "min_create_time", "max_create_time", "product_model", "product_specification", "remark", "product_id", "category_id", "product_type", "is_enabled", "create_employee_id", "delete_flag"};
}
