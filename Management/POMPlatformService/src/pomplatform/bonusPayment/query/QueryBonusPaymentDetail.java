package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BaseBonusPaymentDetail;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentDetail;

public class QueryBonusPaymentDetail extends AbstractQuery<BaseBonusPaymentDetail, ConditionBonusPaymentDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusPaymentDetail.class);

	public QueryBonusPaymentDetail() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("bonus_payment_detail_id");
	}

	@Override
	public BaseCollection<BaseBonusPaymentDetail> executeQuery( KeyValuePair[] replacements, ConditionBonusPaymentDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBonusPaymentRecordId()
			);
	}

	@Override
	public BaseBonusPaymentDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusPaymentDetail __base = new BaseBonusPaymentDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBonusPaymentDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBonusPaymentRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setState(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFirstIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSecondIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThirdIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT bonus_payment_detail_id, bonus_payment_record_id,plate_id, employee_id, employee_no, employee_name, achieve_integral, pay_percent, pay_integral, left_integral, pay_date, state, send_number, first_integral, second_integral, third_integral  from bonus_payment_details WHERE bonus_payment_record_id = ?" ;
	private final static String RESULTSETFIELDLIST = "bonus_payment_detail_id,bonus_payment_record_id,plate_id,employee_id,employee_no,employee_name,achieve_integral,pay_percent,pay_integral,left_integral,pay_date,state,send_number,first_integral,second_integral,third_integral";
	private final static String[] fieldNames = { "bonus_payment_record_id"};
}
