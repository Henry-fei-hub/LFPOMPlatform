package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BasePrepareBonusPaymentApplyInfo;
import pomplatform.bonusPayment.bean.ConditionPrepareBonusPaymentApplyInfo;

public class QueryPrepareBonusPaymentApplyInfo extends AbstractQuery<BasePrepareBonusPaymentApplyInfo, ConditionPrepareBonusPaymentApplyInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryPrepareBonusPaymentApplyInfo.class);

	public QueryPrepareBonusPaymentApplyInfo() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BasePrepareBonusPaymentApplyInfo> executeQuery( KeyValuePair[] replacements, ConditionPrepareBonusPaymentApplyInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(),
				condition.getPlateId(), 
				condition.getEndDate(),
				condition.getResignationDate()
			);
	}

	@Override
	public BasePrepareBonusPaymentApplyInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BasePrepareBonusPaymentApplyInfo __base = new BasePrepareBonusPaymentApplyInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "select e.plate_id,aa.employee_id,e.employee_no,e.employee_name,sum(aa.achieveIntegral) as achieve_integral,e.status from ( select a.employee_id,a.business_type_id ,case when d.parent_id = -1 then -(sum(a.integral)) else sum(a.integral) end as achieveIntegral,c.plate_id from employee_account_records a LEFT JOIN employee_day_plate_records C ON A.employee_id = C.employee_id AND A.record_date = C.record_date left join system_dictionary d on dic_type_id = 66 and a.business_type_id = d.dic_type_value_id LEFT JOIN plate_records pr on c.plate_id = pr.plate_id  where (pr.plate_id = ? or pr.plate_id = ?) and a.record_date <= ? GROUP BY c.plate_id,a.employee_id,a.business_type_id,d.parent_id ) as aa left join employees e on aa.employee_id = e.employee_id where (e.status = 0 or (e.status = 1 and e.resignation_date >= ?)) GROUP BY aa.employee_id,e.employee_no,e.employee_name,e.plate_id,e.status ORDER BY achieve_integral" ;
	private final static String RESULTSETFIELDLIST = "plate_id,employee_id,employee_no,employee_name,achieve_integral,status";
	private final static String[] fieldNames = { "plate_id", "plate_id", "end_date", "resignation_date"};
}
