package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportTotals;
import pomplatform.report.bean.ConditionReportTotals;

public class QueryReportTotals extends AbstractQuery<BaseReportTotals, ConditionReportTotals>
{

	private static final Logger __logger = Logger.getLogger(QueryReportTotals.class);

	public QueryReportTotals() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("report_total_id");
	}

	@Override
	public BaseCollection<BaseReportTotals> executeQuery( KeyValuePair[] replacements, ConditionReportTotals condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseReportTotals generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportTotals __base = new BaseReportTotals();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReportTotalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonthRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthCapitalPlate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCapitalPlate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthCapitalProject(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCapitalProject(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthSureIntegralPlate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalSureIntegralPlate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthSureIntegralProject(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalSureIntegralProject(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthCostPlate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCostPlate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthCostProject(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCostProject(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthCostProjectBefore(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCostProjectBefore(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthNewContract(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalNewContract(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAverageEmpNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMinEmpNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYearAverageEmpRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYearCapital(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBenefit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYearRevenue(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT report_total_id,plate_id,year,month_revenue,total_revenue,month_capital_plate,total_capital_plate,month_capital_project,total_capital_project, month_sure_integral_plate,total_sure_integral_plate,month_sure_integral_project,total_sure_integral_project,month_salary,total_salary,month_cost_plate, total_cost_plate,month_cost_project,total_cost_project,month_cost_project_before,total_cost_project_before,month_new_contract,total_new_contract,contract_total, average_emp_num,min_emp_num,year_average_emp_revenue,year_capital,benefit,year_revenue FROM report_totals WHERE plate_id = ? AND year = ? order by plate_id,year" ;
	private final static String RESULTSETFIELDLIST = "report_total_id,plate_id,year,month_revenue,total_revenue,month_capital_plate,total_capital_plate,month_capital_project,total_capital_project,month_sure_integral_plate,total_sure_integral_plate,month_sure_integral_project,total_sure_integral_project,month_salary,total_salary,month_cost_plate,total_cost_plate,month_cost_project,total_cost_project,month_cost_project_before,total_cost_project_before,month_new_contract,total_new_contract,contract_total,average_emp_num,min_emp_num,year_average_emp_revenue,year_capital,benefit,year_revenue";
	private final static String[] fieldNames = { "plate_id", "year"};
}
