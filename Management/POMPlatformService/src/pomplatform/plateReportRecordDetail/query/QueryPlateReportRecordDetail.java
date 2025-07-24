package pomplatform.plateReportRecordDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateReportRecordDetail.bean.BasePlateReportRecordDetail;
import pomplatform.plateReportRecordDetail.bean.ConditionPlateReportRecordDetail;

public class QueryPlateReportRecordDetail extends AbstractQuery<BasePlateReportRecordDetail, ConditionPlateReportRecordDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateReportRecordDetail.class);

	public QueryPlateReportRecordDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("prr.plate_id");
	}

	@Override
	public BaseCollection<BasePlateReportRecordDetail> executeQuery( KeyValuePair[] replacements, ConditionPlateReportRecordDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BasePlateReportRecordDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateReportRecordDetail __base = new BasePlateReportRecordDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectSettlement(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanySubsidy(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmployeeAchieveIntegralReturn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryReturn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryAdvance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setManagerProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAdvance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setQualityFee(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyFee(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setViolationCharges(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
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

	private final static String __SQLText = "SELECT prr.plate_id, SUM(CASE WHEN prr.achieve_integral IS NULL THEN 0 ELSE prr.achieve_integral END) AS achieve_integral, SUM(CASE WHEN prr.project_settlement IS NULL THEN 0 ELSE prr.project_settlement END) AS project_settlement, SUM(CASE WHEN prr.company_subsidy IS NULL THEN 0 ELSE prr.company_subsidy END) AS company_subsidy, SUM(CASE WHEN prr.employee_achieve_integral_return IS NULL THEN 0 ELSE prr.employee_achieve_integral_return END) AS employee_achieve_integral_return, SUM(CASE WHEN prr.salary_return IS NULL THEN 0 ELSE prr.salary_return END) AS salary_return, SUM(CASE WHEN prr.salary_advance IS NULL THEN 0 ELSE prr.salary_advance END) AS salary_advance, SUM(CASE WHEN prr.manager_project_integral IS NULL THEN 0 ELSE prr.manager_project_integral END) AS manager_project_integral, SUM(CASE WHEN prr.achieve_integral IS NULL THEN 0 ELSE prr.plate_cost END) AS plate_cost, SUM(CASE WHEN prr.project_advance IS NULL THEN 0 ELSE prr.project_advance END) AS project_advance, SUM(CASE WHEN prr.quality_fee IS NULL THEN 0 ELSE prr.quality_fee END) AS quality_fee, SUM(CASE WHEN prr.company_fee IS NULL THEN 0 ELSE prr.company_fee END) AS company_fee, SUM(CASE WHEN prr.violation_charges IS NULL THEN 0 ELSE prr.violation_charges END) AS violation_charges FROM plate_report_records prr WHERE prr.plate_id = ? AND prr.record_date >= ? AND prr.record_date <= ? GROUP BY prr.plate_id ORDER BY prr.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,achieve_integral,project_settlement,company_subsidy,employee_achieve_integral_return,salary_return,salary_advance,manager_project_integral,plate_cost,project_advance,quality_fee,company_fee,violation_charges";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
