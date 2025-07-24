package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseSprojectpbpor;
import pomplatform.project.bean.ConditionSprojectpbpor;

public class QuerySprojectpbpor extends AbstractQuery<BaseSprojectpbpor, ConditionSprojectpbpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectpbpor.class);

	public QuerySprojectpbpor() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseSprojectpbpor> executeQuery( KeyValuePair[] replacements, ConditionSprojectpbpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectType(), 
				condition.getBusinessLine(), 
				condition.getPricingType(), 
				condition.getContractCode(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getPlateId(),
				condition.getIsHasPrice(),
				condition.getProjectFlag());
	}

	@Override
	public BaseSprojectpbpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectpbpor __base = new BaseSprojectpbpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkHours(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlanEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOldProjectDiscount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudget(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectProgress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSize(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAuditReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBimArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCadArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHumanAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAppendTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAppendIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectGradeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLastPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setComplaintIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRevenuePlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsEcmcProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectSetupFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsAuto(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setTimeCycle(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReserveSheetId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessLine(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPricingType(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "select p.project_id, p.contract_code, p.project_code, p.project_name, p.project_type, p.plate_id, p.design_type, p.department_id, p.design_phase, p.project_level, p.status, p.project_manage_id, p.work_hours, p.plan_start_date, p.plan_end_date, p.start_date, p.end_date, p.common_area, p.logistics_area, p.percentage, p.old_project_discount, p.budget, p.total_integral, p.reserve_integral, p.total_amount, p.project_integral, p.project_progress, p.project_size, p.project_description, p.audit_reason, p.department_manager_id, p.bim_area, p.cad_area, p.human_amount, p.append_total_integral, p.append_integral, p.remark, p.project_finish_percent, p.parent_id, p.total_finish_percent, p.project_grade_type, p.plate_manager_id, p.last_percent, p.complaint_percentage, p.complaint_integral, p.revenue_plate_id, p.sheet_amount, p.create_time, p.project_flag, p.business_type, p.contract_id, p.sub_contract_id, p.is_ecmc_project, p.money_sum, p.project_setup_flag, p.is_lock, p.is_auto, p.time_cycle, p.reserve_sheet_id, p.business_line, p.pricing_type from projects p where p.project_type = ? and p.business_line = ? and p.pricing_type = ? and p.contract_code like ? and p.project_code like ? and p.project_name like ? and p.plate_id = ? and p.is_has_price = ?  and p.project_flag = ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,project_type,plate_id,design_type,department_id,design_phase,project_level,status,project_manage_id,work_hours,plan_start_date,plan_end_date,start_date,end_date,common_area,logistics_area,percentage,old_project_discount,budget,total_integral,reserve_integral,total_amount,project_integral,project_progress,project_size,project_description,audit_reason,department_manager_id,bim_area,cad_area,human_amount,append_total_integral,append_integral,remark,project_finish_percent,parent_id,total_finish_percent,project_grade_type,plate_manager_id,last_percent,complaint_percentage,complaint_integral,revenue_plate_id,sheet_amount,create_time,project_flag,business_type,contract_id,sub_contract_id,is_ecmc_project,money_sum,project_setup_flag,is_lock,is_auto,time_cycle,reserve_sheet_id,business_line,pricing_type";
	private final static String[] fieldNames = { "project_type", "business_line", "pricing_type", "contract_code", "project_code", "project_name", "plate_id", "is_has_price","project_flag"};
}
