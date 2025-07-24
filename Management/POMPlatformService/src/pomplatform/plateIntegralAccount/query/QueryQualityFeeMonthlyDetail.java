package pomplatform.plateIntegralAccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateIntegralAccount.bean.BaseQualityFeeMonthlyDetail;
import pomplatform.plateIntegralAccount.bean.ConditionQualityFeeMonthlyDetail;

public class QueryQualityFeeMonthlyDetail extends AbstractQuery<BaseQualityFeeMonthlyDetail, ConditionQualityFeeMonthlyDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryQualityFeeMonthlyDetail.class);

	public QueryQualityFeeMonthlyDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pia.plate_integral_achieve_id");
	}

	@Override
	public BaseCollection<BaseQualityFeeMonthlyDetail> executeQuery( KeyValuePair[] replacements, ConditionQualityFeeMonthlyDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFromPlateId(), 
				condition.getSendYear(), 
				condition.getSendMonth()
			);
	}

	@Override
	public BaseQualityFeeMonthlyDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseQualityFeeMonthlyDetail __base = new BaseQualityFeeMonthlyDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateIntegralAchieveId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFromPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setToPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSendDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "select pia.plate_integral_achieve_id, pia.from_plate_id, pia.to_plate_id, pia.send_integral, pia.send_date, pia.operate_employee_id, pia.operate_time, pia.remark from plate_integral_achieves pia where pia.from_plate_id = ? and extract(year from pia.send_date) = ? and extract(month from pia.send_date) = ? and pia.to_plate_id > 0 order by pia.send_date" ;
	private final static String RESULTSETFIELDLIST = "plate_integral_achieve_id,from_plate_id,to_plate_id,send_integral,send_date,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "from_plate_id", "send_year", "send_month"};
}
