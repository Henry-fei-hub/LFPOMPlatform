package pomplatform.getProjectByContract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.getProjectByContract.bean.BaseGetProjectByContract;
import pomplatform.getProjectByContract.bean.ConditionGetProjectByContract;

public class QueryGetProjectByContract extends AbstractQuery<BaseGetProjectByContract, ConditionGetProjectByContract>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectByContract.class);

	public QueryGetProjectByContract() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseGetProjectByContract> executeQuery( KeyValuePair[] replacements, ConditionGetProjectByContract condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode()
			);
	}

	@Override
	public BaseGetProjectByContract generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectByContract __base = new BaseGetProjectByContract();
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
		if(args[0] != null) __statement.setString(count++, (java.lang.String)args[0]);
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

	private final static String __SQLText = "select p.project_id, p.contract_code, p.project_code, p.project_name, p.project_type, p.plate_id, p.design_type, p.department_id, p.design_phase, p.project_level, p.status, p.project_manage_id, p.work_hours, p.plan_start_date, p.plan_end_date, p.start_date, p.end_date, p.common_area, p.logistics_area, p.percentage, p.old_project_discount, p.budget, p.total_integral, p.reserve_integral, p.total_amount, p.project_integral, p.project_progress, p.project_size, p.project_description, p.audit_reason, p.department_manager_id, p.bim_area, p.cad_area, p.human_amount, p.append_total_integral, p.append_integral, p.remark, p.project_finish_percent, p.parent_id, p.total_finish_percent, p.project_grade_type, p.plate_manager_id, p.last_percent from projects p left join sub_contracts sc on p.contract_code = sc.sub_contract_code left join contracts c on sc.parent_id = c.contract_id where c.contract_code = ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,project_type,plate_id,design_type,department_id,design_phase,project_level,status,project_manage_id,work_hours,plan_start_date,plan_end_date,start_date,end_date,common_area,logistics_area,percentage,old_project_discount,budget,total_integral,reserve_integral,total_amount,project_integral,project_progress,project_size,project_description,audit_reason,department_manager_id,bim_area,cad_area,human_amount,append_total_integral,append_integral,remark,project_finish_percent,parent_id,total_finish_percent,project_grade_type,plate_manager_id,last_percent";
	private final static String[] fieldNames = { "contract_code"};
}
