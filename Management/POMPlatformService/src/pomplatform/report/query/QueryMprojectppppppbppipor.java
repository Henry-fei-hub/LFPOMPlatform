package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseMprojectppppppbppipor;
import pomplatform.report.bean.ConditionMprojectppppppbppipor;

public class QueryMprojectppppppbppipor extends AbstractQuery<BaseMprojectppppppbppipor, ConditionMprojectppppppbppipor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectppppppbppipor.class);

	public QueryMprojectppppppbppipor() throws java.sql.SQLException 
	{
		setParameterNumber(16);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("P.project_id");
	}

	@Override
	public BaseCollection<BaseMprojectppppppbppipor> executeQuery( KeyValuePair[] replacements, ConditionMprojectppppppbppipor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getProjectId(), 
				condition.getProjectId(), 
				condition.getProjectId(), 
				condition.getProjectId(), 
				condition.getProjectId(), 
				condition.getProjectId(), 
				condition.getProjectType(), 
				condition.getBusinessLine(), 
				condition.getPricingType(), 
				condition.getPlateId(), 
				condition.getIsHasPrice(), 
				condition.getProjectFlag(), 
				condition.getContractCode(), 
				condition.getProjectCode(), 
				condition.getProjectName()
			);
	}

	@Override
	public BaseMprojectppppppbppipor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectppppppbppipor __base = new BaseMprojectppppppbppipor();
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
		if((val = __data[count++]) != null) __base.setRegularPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPriceSpread(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProgressPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoney1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMoney2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral2(GenericBase.__getDecimal(val));
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
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
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

	private final static String __SQLText = "SELECT P.project_id, P.contract_code, P.project_code, P.project_name, P.project_type, P.plate_id, P.design_type, P.department_id, P.design_phase, P.project_level, P.status, P.project_manage_id, P.work_hours, P.plan_start_date, P.plan_end_date, P.start_date, P.end_date, P.common_area, P.logistics_area, P.percentage, P.old_project_discount, P.budget, P.total_integral, P.reserve_integral, P.total_amount, P.project_integral, P.project_progress, P.project_size, P.project_description, P.audit_reason, P.department_manager_id, P.bim_area, P.cad_area, P.human_amount, P.append_total_integral, P.append_integral, P.remark, P.project_finish_percent, P.parent_id, P.total_finish_percent, P.project_grade_type, P.plate_manager_id, P.last_percent, P.complaint_percentage, P.complaint_integral, P.revenue_plate_id, P.sheet_amount, P.create_time, P.project_flag, P.business_type, P.contract_id, P.sub_contract_id, P.is_ecmc_project, P.money_sum, P.project_setup_flag, P.is_lock, P.is_auto, P.time_cycle, P.reserve_sheet_id, P.business_line, P.pricing_type, C.regular_price, (C.regular_price-p.total_integral) as price_spread, D.progress_percentage, CASE WHEN A.money isnull THEN 0 ELSE A.money END AS money_1, CASE WHEN B.money isnull THEN 0 ELSE A.money END AS money_2, CASE WHEN E.advance_integral_1 isnull THEN 0 ELSE E.advance_integral_1 END AS advance_integral_1, CASE WHEN F.advance_integral_2 isnull THEN 0 ELSE F.advance_integral_2 END AS advance_integral_2 FROM projects P LEFT JOIN ( SELECT ppcr.project_id, ppcr.subsidies_type, SUM(ppcr.money) as money FROM project_price_changed_records ppcr WHERE ppcr.project_id =? and ppcr.subsidies_type=1 GROUP BY ppcr.project_id, ppcr.subsidies_type ) as A on A.project_id =p.project_id LEFT JOIN ( SELECT ppcr.project_id, ppcr.subsidies_type, SUM(ppcr.money) as money FROM project_price_changed_records ppcr WHERE ppcr.project_id =? and ppcr.subsidies_type=2 GROUP BY ppcr.project_id, ppcr.subsidies_type ) as B on B.project_id =p.project_id LEFT JOIN ( SELECT p.project_id, (p.sheet_amount/1.06)*0.4 as regular_price FROM projects p WHERE p.project_id =? GROUP BY p.project_id ) as C on C.project_id =p.project_id LEFT JOIN ( select PP.project_id, CASE WHEN PP.project_integral > 0 THEN round(( COALESCE ( SUM ( ps.total_amount ), 0 ) * 100 / PP.project_integral ), 2 ) ELSE 0 END AS progress_percentage from projects PP LEFT JOIN project_settlements ps ON PP.project_id = ps.project_id AND ps.settlement_status = 2 where PP.project_id =? GROUP BY PP.project_id ) as D on D.project_id= p.project_id LEFT JOIN (select project_id, sum(advance_integral) as advance_integral_1 from project_advance_records where flag = 1 and project_id>0 AND project_id =? group by project_id ) as E on E.project_id = P.project_id LEFT JOIN (select project_id, sum(advance_integral) as advance_integral_2 from project_advance_records where flag = 2 and project_id>0 AND project_id =? group by project_id ) as F on F.project_id = P.project_id WHERE P.project_id =? AND P.project_type =? AND P.business_line =? AND P.pricing_type =? AND P.plate_id =? AND P.is_has_price =? AND P.project_flag =? AND p.contract_code like ? and p.project_code like ? and p.project_name like ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,project_code,project_name,project_type,plate_id,design_type,department_id,design_phase,project_level,status,project_manage_id,work_hours,plan_start_date,plan_end_date,start_date,end_date,common_area,logistics_area,percentage,old_project_discount,budget,total_integral,reserve_integral,total_amount,project_integral,project_progress,project_size,project_description,audit_reason,department_manager_id,bim_area,cad_area,human_amount,append_total_integral,append_integral,remark,project_finish_percent,parent_id,total_finish_percent,project_grade_type,plate_manager_id,last_percent,complaint_percentage,complaint_integral,revenue_plate_id,sheet_amount,create_time,project_flag,business_type,contract_id,sub_contract_id,is_ecmc_project,money_sum,project_setup_flag,is_lock,is_auto,time_cycle,reserve_sheet_id,business_line,pricing_type,regular_price,price_spread,progress_percentage,money_1,money_2,advance_integral_1,advance_integral_2";
	private final static String[] fieldNames = { "project_id", "project_id", "project_id", "project_id", "project_id", "project_id", "project_id", "project_type", "business_line", "pricing_type", "plate_id", "is_has_price", "project_flag", "contract_code", "project_code", "project_name"};
}
