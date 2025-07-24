package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseContractDistributionNew;
import pomplatform.employee.bean.ConditionContractDistributionNew;

public class QueryContractDistributionNew extends AbstractQuery<BaseContractDistributionNew, ConditionContractDistributionNew>
{

	private static final Logger __logger = Logger.getLogger(QueryContractDistributionNew.class);

	public QueryContractDistributionNew() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.contract_id");
	}

	@Override
	public BaseCollection<BaseContractDistributionNew> executeQuery( KeyValuePair[] replacements, ConditionContractDistributionNew condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getContractName(), 
				condition.getPlateId(), 
				condition.getBusinessType(),
				condition.getContractId(),
				condition.getOrderStatus()
			);
	}

	@Override
	public BaseContractDistributionNew generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractDistributionNew __base = new BaseContractDistributionNew();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRealRelatively(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRelativelyProgress(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSum(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "SELECT c.contract_id, c.contract_code, c.contract_date, c.contract_name, c.signing_money_sum, c.business_type, p.plate_name, BB.percent*100 as real_relatively, case when c.signing_money_sum = 0 then 0 else round(sum(mc.income * 1.06)/c.signing_money_sum*100 , 2) end as relatively_progress, sum(mc.day_revenue) FROM contract_distributions cd LEFT JOIN marketing_commissions mc ON mc.contract_id = cd.contract_id LEFT JOIN plate_records p on p.plate_id = cd.plate_id LEFT JOIN contracts c on c.contract_id = cd.contract_id LEFT JOIN ( SELECT aa.contract_id, SUM ( aa.sheet_amount ), SUM ( aa.revenue_integral) as revenue_integral, CASE WHEN SUM ( aa.sheet_amount ) > 0 THEN round( SUM ( aa.revenue_integral ) / SUM ( aa.sheet_amount ), 4 ) ELSE 0 END AS percent FROM ( SELECT A .project_id, A.sheet_amount, A.contract_id, CASE WHEN A.project_integral > 0 THEN COALESCE ( b.sure_integral, 0 ) / A.project_integral * A.sheet_amount ELSE 0 END AS revenue_integral FROM projects A LEFT JOIN ( SELECT project_id, SUM ( total_amount ) AS sure_integral FROM project_settlements GROUP BY project_id ) AS b ON A.project_id = b.project_id ) aa GROUP BY aa.contract_id ) BB on c.contract_id = BB.contract_id LEFT JOIN contract_distributions cds ON C.contract_id = cds.contract_id where c.contract_code = ? and mc.commissions >=? and mc.commissions <=? and c.contract_name like ? and cd.plate_id = ? and mc.business_type =? and c.contract_id =? AND cds.order_status =? GROUP BY c.contract_id, c.contract_code, c.contract_date, c.contract_name, c.signing_money_sum, p.plate_name, BB.percent" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_date,contract_name,signing_money_sum,business_type,plate_name,real_relatively,relatively_progress,sum";
	private final static String[] fieldNames = { "contract_code", "start_date", "end_date", "contract_name", "plate_id", "business_type" , "contract_id" , "order_status"};
}
