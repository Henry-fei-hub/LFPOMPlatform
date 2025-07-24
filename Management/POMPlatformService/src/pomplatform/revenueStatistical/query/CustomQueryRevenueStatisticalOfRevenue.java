package pomplatform.revenueStatistical.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;

public class CustomQueryRevenueStatisticalOfRevenue extends AbstractQuery<BaseRevenueStatisticalOfRevenue, ConditionRevenueStatisticalOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(CustomQueryRevenueStatisticalOfRevenue.class);

	public CustomQueryRevenueStatisticalOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseRevenueStatisticalOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionRevenueStatisticalOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getPlateManagerId(), 
				condition.getDepartmentManagerId(), 
				condition.getProjectManageId(), 
				condition.getSheetName(), 
				condition.getSheetCode()
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
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSheetPercent(GenericBase.__getDecimal(val));
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
		if((val = __data[count++]) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setContractSave(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractSaveActive(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractSaveActiveUn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractSaveActivePause(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractSaveActiveNever(GenericBase.__getDecimal(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
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

	private final static String __SQLText = "select a.project_id,a.revenue_plate_id as plate_id,a.contract_code as sheet_code,a.project_name as sheet_name,NULL as contract_code,a.total_integral ,b.sheet_amount,0 as contract_amount,b.sheet_percent ,b.sheet_percent_str,b.modify_percent,b.modify_percent_str,b.total_percent,b.total_percent_str ,b.total_tax_revenue,b.total_revenue,b.current_revenue,0 as last_month_revenue,b.year,b.month,b.rate_percent,b.rate_percent_str,b.revenue_statistical_record_id ,a.plate_manager_id,a.department_manager_id,a.project_manage_id,case when a.plate_id is null then 2 else 1 end as flag,a.status,b.is_locked,b.contract_save,b.contract_save_active,b.contract_save_active_un,b.contract_save_active_pause,b.contract_save_active_never from projects a right join revenue_statistical_records b on a.project_id = b.project_id and b.year = ? and b.month = ? where a.project_flag in(1,4) and a.project_id = ? and a.revenue_plate_id = ? and a.plate_manager_id = ? and a.department_manager_id = ? and a.project_manage_id = ? and a.project_name like ? and a.contract_code like ? ORDER BY a.contract_code,a.sheet_amount desc" ;
	private final static String RESULTSETFIELDLIST = "project_id,plate_id,sheet_code,sheet_name,contract_code,total_integral,sheet_amount,contract_amount,sheet_percent,sheet_percent_str,modify_percent,modify_percent_str,total_percent,total_percent_str,total_tax_revenue,total_revenue,current_revenue,last_month_revenue,year,month,rate_percent,rate_percent_str,revenue_statistical_record_id,plate_manager_id,department_manager_id,project_manage_id,flag,status,is_locked,contract_save,contract_save_active,contract_save_active_un,contract_save_active_pause,contract_save_active_never";
	private final static String[] fieldNames = {"year", "month", "project_id", "plate_id", "plate_manager_id", "department_manager_id", "project_manage_id", "sheet_name", "sheet_code"};
}
