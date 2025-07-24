package pomplatform.goodsreceive.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.goodsreceive.bean.BaseGoodsreceivedetail;
import pomplatform.goodsreceive.bean.ConditionGoodsreceivedetail;

public class QueryGoodsreceivedetail extends AbstractQuery<BaseGoodsreceivedetail, ConditionGoodsreceivedetail>
{

	private static final Logger __logger = Logger.getLogger(QueryGoodsreceivedetail.class);

	public QueryGoodsreceivedetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BaseGoodsreceivedetail> executeQuery( KeyValuePair[] replacements, ConditionGoodsreceivedetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getGoodsReceiveDetailId(), 
				condition.getGoodsReceiveId(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getReceiveTime()
			);
	}

	@Override
	public BaseGoodsreceivedetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGoodsreceivedetail __base = new BaseGoodsreceivedetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setGoodsReceiveDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGoodsReceiveId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsReceive(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveCount(GenericBase.__getLong(val));
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
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "select * from goods_receive_details where goods_receive_detail_id = ? and goods_receive_id = ? and employee_id = ? and department_id = ? and receive_time > ?" ;
	private final static String RESULTSETFIELDLIST = "goods_receive_detail_id,goods_receive_id,employee_id,employee_number,department_id,receive_time,employee_name,is_receive,receive_count";
	private final static String[] fieldNames = { "goods_receive_detail_id", "goods_receive_id", "employee_id", "department_id", "receive_time"};
}
