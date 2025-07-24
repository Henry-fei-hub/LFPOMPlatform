package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseGetProjects;
import pomplatform.project.bean.ConditionGetProjects;

public class QueryGetProjects extends AbstractQuery<BaseGetProjects, ConditionGetProjects>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjects.class);

	public QueryGetProjects() throws java.sql.SQLException 
	{
		setParameterNumber(17);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseGetProjects> executeQuery( KeyValuePair[] replacements, ConditionGetProjects condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentManagerId(), 
				condition.getPlateManagerId(), 
				condition.getContractCode(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getDesignType(), 
				condition.getDepartmentId(), 
				condition.getProjectLevel(), 
				condition.getStatus(), 
				condition.getProjectManageId(), 
				condition.getBusinessType(), 
				condition.getContractId(), 
				condition.getSubContractId(), 
				condition.getProjectSetupFlag(), 
				condition.getIsLock()
			);
	}

	@Override
	public BaseGetProjects generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjects __base = new BaseGetProjects();
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[16]));
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

	private final static String __SQLText = "select p.project_id, p.contract_code, p.project_code, p.project_name, p.project_type, p.plate_id, p.design_type, p.department_id, p.design_phase, p.project_level, p.status, p.project_manage_id, p.work_hours, p.plan_start_date, p.plan_end_date, p.start_date, p.end_date, p.common_area, p.logistics_area, p.percentage, p.old_project_discount, p.budget, p.total_integral, p.reserve_integral, p.total_amount, p.project_integral, p.project_progress, p.project_size, p.project_description, p.audit_reason, p.department_manager_id, p.bim_area, p.cad_area, p.human_amount, p.append_total_integral, p.append_integral, p.remark, p.project_finish_percent, p.parent_id, p.total_finish_percent, p.project_grade_type, p.plate_manager_id, p.last_percent, p.complaint_percentage, p.complaint_integral, p.revenue_plate_id, p.sheet_amount, p.create_time, p.project_flag, p.business_type, p.contract_id, p.sub_contract_id, p.is_ecmc_project, p.money_sum, p.project_setup_flag, p.is_lock from projects p where p.department_manager_id = ? and p.plate_manager_id = ? and p.contract_code like ? and p.project_code like ? and p.project_name like ? and p.project_id = ? and p.plate_id = ? and p.design_type = ? and p.department_id = ? and p.project_level = ? and p.status = ? and p.project_manage_id = ? and p.business_type = ? and p.contract_id = ? and p.sub_contract_id = ? and p.project_setup_flag = ? and p.is_lock = ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,project_type,plate_id,design_type,department_id,design_phase,project_level,status,project_manage_id,work_hours,plan_start_date,plan_end_date,start_date,end_date,common_area,logistics_area,percentage,old_project_discount,budget,total_integral,reserve_integral,total_amount,project_integral,project_progress,project_size,project_description,audit_reason,department_manager_id,bim_area,cad_area,human_amount,append_total_integral,append_integral,remark,project_finish_percent,parent_id,total_finish_percent,project_grade_type,plate_manager_id,last_percent,complaint_percentage,complaint_integral,revenue_plate_id,sheet_amount,create_time,project_flag,business_type,contract_id,sub_contract_id,is_ecmc_project,money_sum,project_setup_flag,is_lock";
	private final static String[] fieldNames = { "department_manager_id", "plate_manager_id", "contract_code", "project_code", "project_name", "project_id", "plate_id", "design_type", "department_id", "project_level", "status", "project_manage_id", "business_type", "contract_id", "sub_contract_id", "project_setup_flag", "is_lock"};
}
