package pomplatform.goodsreceive.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.goodsreceive.bean.BaseGoodsreceive;
import pomplatform.goodsreceive.bean.ConditionGoodsreceive;

public class QueryGoodsreceive extends AbstractQuery<BaseGoodsreceive, ConditionGoodsreceive>
{

	private static final Logger __logger = Logger.getLogger(QueryGoodsreceive.class);

	public QueryGoodsreceive() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("gr.goods_receive_id");
	}

	@Override
	public BaseCollection<BaseGoodsreceive> executeQuery( KeyValuePair[] replacements, ConditionGoodsreceive condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getGoodsReceiveId(), 
				condition.getSubject(), 
				condition.getCreateTime(), 
				condition.getReceiveDate(), 
				condition.getReceiveCount()
			);
	}

	@Override
	public BaseGoodsreceive generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGoodsreceive __base = new BaseGoodsreceive();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setGoodsReceiveId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubject(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReceiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreatePersonId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGoodsDetail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceivePersonNumber(GenericBase.__getLong(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT gr.goods_receive_id, gr.subject, gr.create_time, gr.receive_date, gr.count, gr.create_person_id, gr.file_manage_id, gr.goods_detail, receive_person_number, receive_count from goods_receives gr LEFT JOIN( SELECT goods_receive_id , COUNT(1) As receive_person_number, COUNT(receive_count) As receive_count from goods_receive_details grd GROUP BY goods_receive_id ) grd on grd.goods_receive_id = gr.goods_receive_id where gr.goods_receive_id = ? and gr.subject = ? and gr.create_time >? and gr.receive_date > ? and receive_count > ?" ;
	private final static String RESULTSETFIELDLIST = "goods_receive_id,subject,create_time,receive_date,count,create_person_id,file_manage_id,goods_detail,receive_person_number,receive_count";
	private final static String[] fieldNames = { "goods_receive_id", "subject", "create_time", "receive_date", "receive_count"};
}
