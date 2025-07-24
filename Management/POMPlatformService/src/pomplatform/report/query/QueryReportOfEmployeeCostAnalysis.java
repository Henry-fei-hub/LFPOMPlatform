package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfEmployeeCostAnalysis;
import pomplatform.report.bean.ConditionReportOfEmployeeCostAnalysis;

public class QueryReportOfEmployeeCostAnalysis extends AbstractQuery<BaseReportOfEmployeeCostAnalysis, ConditionReportOfEmployeeCostAnalysis>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfEmployeeCostAnalysis.class);

	public QueryReportOfEmployeeCostAnalysis() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_cost_analysis_id");
	}

	@Override
	public BaseCollection<BaseReportOfEmployeeCostAnalysis> executeQuery( KeyValuePair[] replacements, ConditionReportOfEmployeeCostAnalysis condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseReportOfEmployeeCostAnalysis generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfEmployeeCostAnalysis __base = new BaseReportOfEmployeeCostAnalysis();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeCostAnalysisId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThisMonthPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastMonthPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayRaise(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setThisMonthInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastMonthInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsuranceRaise(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsuranceRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "SELECT employee_cost_analysis_id,plate_id,year,month,this_month_pay,last_month_pay,pay_raise,this_month_insurance,last_month_insurance,insurance_raise,pay_remark,insurance_remark,is_locked, operate_employee_id,operate_time,remark FROM employee_cost_analysis WHERE year = ? AND month = ? ORDER BY plate_id" ;
	private final static String RESULTSETFIELDLIST = "employee_cost_analysis_id,plate_id,year,month,this_month_pay,last_month_pay,pay_raise,this_month_insurance,last_month_insurance,insurance_raise,pay_remark,insurance_remark,is_locked,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "year", "month"};
}
