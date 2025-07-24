package pomplatform.revenueStatistical.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;

public class QueryRevenueStatisticalOfRevenue extends AbstractQuery<BaseRevenueStatisticalOfRevenue, ConditionRevenueStatisticalOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryRevenueStatisticalOfRevenue.class);

	public QueryRevenueStatisticalOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseRevenueStatisticalOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionRevenueStatisticalOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEndDate(), 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getPlateManagerId(), 
				condition.getDepartmentManagerId(), 
				condition.getProjectManageId(), 
				condition.getSheetName(), 
				condition.getSheetCode(),
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseRevenueStatisticalOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRevenueStatisticalOfRevenue __base = new BaseRevenueStatisticalOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOldSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOldProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetPercentStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setModifyPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setModifyPercentStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPercentStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalTaxRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrentRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastMonthRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRatePercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRatePercentStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRevenueStatisticalRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalSureRevenue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalSurePercentStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractSaveActive(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDayStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractSaveActiveUn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractSaveActivePause(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractSaveActiveNever(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractSaveOther(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "SELECT AA.project_id, AA.plate_id, AA.sheet_code, AA.sheet_name, AA.total_integral, AA.contract_code, AA.sheet_amount, AA.old_sheet_amount, AA.contract_amount, AA.project_integral, AA.old_project_integral, AA.sheet_percent, AA.sure_integral, AA.sheet_percent_str, AA.modify_percent,AA.modify_percent_str,AA.total_percent, AA.total_percent_str, AA.total_tax_revenue, AA.total_revenue, AA.current_revenue, AA.last_month_revenue, AA.year, AA.month, AA.rate_percent, AA.rate_percent_str, AA.revenue_statistical_record_id, AA.plate_manager_id, AA.department_manager_id, AA.project_manage_id, AA.flag, AA.status, AA.total_sure_revenue, AA.total_sure_percent_str, AA.contract_save, 0.0 as contract_save_active,CASE WHEN ( AA.status = 4 ) THEN 3 WHEN ( AA.status = 10 ) THEN 4 WHEN ( CURRENT_DATE - BB.settlement_date ) <= 90 THEN 1 WHEN ( CURRENT_DATE - BB.settlement_date ) > 90 THEN 2 ELSE 0 END AS day_status,0.0 AS contract_save_active_un, 0.0 AS contract_save_active_pause, 0.0 AS contract_save_active_never, 0.0 AS contract_save_other, AA.contract_status from ( SELECT A .project_id, A.revenue_plate_id AS plate_id, A.contract_code AS sheet_code, A.project_name AS sheet_name, A.total_integral, NULL AS contract_code, CASE WHEN b.sheet_amount > 0 THEN b.sheet_amount ELSE A.sheet_amount END AS sheet_amount, A.sheet_amount AS old_sheet_amount, 0.0 AS contract_amount, CASE WHEN b.project_integral > 0 THEN b.project_integral ELSE A.project_integral END AS project_integral, A.project_integral AS old_project_integral, 0.0 AS sheet_percent, A.sure_integral, NULL AS sheet_percent_str, b.modify_percent, NULL AS modify_percent_str, b.total_percent, NULL AS total_percent_str, b.total_tax_revenue, b.total_revenue, b.current_revenue, 0.0 AS last_month_revenue, 0 AS YEAR, 0 AS MONTH, C.rate_percent, NULL AS rate_percent_str, b.revenue_statistical_record_id, A.plate_manager_id, A.department_manager_id, A.project_manage_id, CASE WHEN b.project_id IS NULL THEN 2 ELSE 1 END AS FLAG, A.status, 0.0 AS total_sure_revenue, NULL AS total_sure_percent_str, 0.0 AS contract_save, A.contract_status FROM ( SELECT P .project_id, P.revenue_plate_id, P.contract_code, P.project_name, P.total_integral, P.sheet_amount, P.project_integral, P.plate_manager_id, P.department_manager_id, P.project_manage_id, P.status, COALESCE ( SUM ( ps.total_amount ), 0 ) AS sure_integral, c.contract_status FROM projects P LEFT JOIN contracts c on P.contract_id > 0 and P.contract_id = c.contract_id LEFT JOIN project_settlements ps ON P.project_id = ps.project_id AND ps.settlement_status = 2 AND ps.settlement_date <= ? WHERE P.project_flag in (1,4)    AND P.project_id = ? AND P.revenue_plate_id = ? AND P.plate_manager_id = ? AND P.department_manager_id = ? AND P.project_manage_id = ? AND P.project_name LIKE ? AND P.contract_code LIKE ? GROUP BY P.project_id, P.revenue_plate_id, P.contract_code, P.project_name, P.total_integral, P.sheet_amount, P.project_integral, P.plate_manager_id, P.department_manager_id, P.project_manage_id, P.status, c.contract_status ) A LEFT JOIN revenue_statistical_records b ON A.project_id = b.project_id AND b.YEAR = ? AND b.MONTH = ? LEFT JOIN plate_rate_records C ON A.revenue_plate_id = C.plate_id ORDER BY A.contract_code, A.sheet_amount DESC ) AA LEFT JOIN ( SELECT p.project_id,MAx(settlement_date) AS settlement_date from project_settlements p GROUP BY p.project_id )BB ON AA.project_id=BB.project_id" ;
	private final static String RESULTSETFIELDLIST = "project_id,plate_id,sheet_code,sheet_name,total_integral,contract_code,sheet_amount,old_sheet_amount,contract_amount,project_integral,old_project_integral,sheet_percent,sure_integral,sheet_percent_str,modify_percent,modify_percent_str,total_percent,total_percent_str,total_tax_revenue,total_revenue,current_revenue,last_month_revenue,year,month,rate_percent,rate_percent_str,revenue_statistical_record_id,plate_manager_id,department_manager_id,project_manage_id,flag,status,total_sure_revenue,total_sure_percent_str,contract_save,contract_save_active,day_status,contract_save_active_un,contract_save_active_pause, contract_save_active_never, contract_save_other, contract_status";
	private final static String[] fieldNames = { "end_date", "project_id", "plate_id", "plate_manager_id", "department_manager_id", "project_manage_id", "sheet_name", "sheet_code", "year", "month"};
}
