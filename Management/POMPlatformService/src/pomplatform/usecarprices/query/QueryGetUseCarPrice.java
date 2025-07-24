package pomplatform.usecarprices.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.usecarprices.bean.BaseGetUseCarPrice;
import pomplatform.usecarprices.bean.ConditionGetUseCarPrice;

public class QueryGetUseCarPrice extends AbstractQuery<BaseGetUseCarPrice, ConditionGetUseCarPrice>
{

	private static final Logger __logger = Logger.getLogger(QueryGetUseCarPrice.class);

	public QueryGetUseCarPrice() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ucp.use_car_price_id");
	}

	@Override
	public BaseCollection<BaseGetUseCarPrice> executeQuery( KeyValuePair[] replacements, ConditionGetUseCarPrice condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getUseCarPriceId(), 
				condition.getPrice(), 
				condition.getParentId(), 
				condition.getToArea(), 
				condition.getFromArea()
			);
	}

	@Override
	public BaseGetUseCarPrice generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetUseCarPrice __base = new BaseGetUseCarPrice();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setUseCarPriceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFromArea(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setToArea(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select ucp.use_car_price_id, ucp.from_area, ucp.to_area, ucp.price, ucp.parent_id from use_car_prices ucp where ucp.use_car_price_id = ? and ucp.price = ? and ucp.parent_id = ? and ucp.to_area like ? and ucp.from_area like ?" ;
	private final static String RESULTSETFIELDLIST = "use_car_price_id,from_area,to_area,price,parent_id";
	private final static String[] fieldNames = { "use_car_price_id", "price", "parent_id", "to_area", "from_area"};
}
