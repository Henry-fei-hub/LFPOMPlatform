package pomplatform.projectAttachmentManage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectAttachmentManage.bean.BaseNonconformityAttachmentDetail;
import pomplatform.projectAttachmentManage.bean.ConditionNonconformityAttachmentDetail;

public class QueryNonconformityAttachmentDetail extends AbstractQuery<BaseNonconformityAttachmentDetail, ConditionNonconformityAttachmentDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryNonconformityAttachmentDetail.class);

	public QueryNonconformityAttachmentDetail() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.* from projects A left join ( select contract_id from projects where project_id =:project_id ) as B ON B.contract_id= A.contract_id  where B.contract_id= A.contract_id and project_type in (16");
	}

	@Override
	public BaseCollection<BaseNonconformityAttachmentDetail> executeQuery( KeyValuePair[] replacements, ConditionNonconformityAttachmentDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseNonconformityAttachmentDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNonconformityAttachmentDetail __base = new BaseNonconformityAttachmentDetail();
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

	private final static String __SQLText = "select A.* from projects A left join ( select contract_id from projects where project_id =? ) as B ON B.contract_id= A.contract_id where B.contract_id= A.contract_id and project_type in (16,33)" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,project_type,plate_id,design_type,department_id,design_phase,project_level,status,project_manage_id,work_hours,plan_start_date,plan_end_date,start_date,end_date,common_area,logistics_area,percentage,old_project_discount,budget,total_integral,reserve_integral,total_amount,project_integral,project_progress,project_size,project_description,audit_reason,department_manager_id,bim_area,cad_area,human_amount,append_total_integral,append_integral,remark,project_finish_percent,parent_id,total_finish_percent,project_grade_type,plate_manager_id,last_percent,complaint_percentage,complaint_integral,revenue_plate_id,sheet_amount,create_time,project_flag,business_type,contract_id,sub_contract_id,is_ecmc_project,money_sum,project_setup_flag,is_lock,is_auto,time_cycle,reserve_sheet_id,business_line";
	private final static String[] fieldNames = { "project_id"};
}
