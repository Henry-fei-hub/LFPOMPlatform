package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseprojectPreInfomations;
import pomplatform.preProjects.bean.ConditionprojectPreInfomations;

public class QueryprojectPreInfomations extends AbstractQuery<BaseprojectPreInfomations, ConditionprojectPreInfomations>
{

	private static final Logger __logger = Logger.getLogger(QueryprojectPreInfomations.class);

	public QueryprojectPreInfomations() throws java.sql.SQLException 
	{
		setParameterNumber(36);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("CASE WHEN C .status = 5 OR C.status = 2 OR C.contract_status = 3 OR C.project_status = '暂停' OR C.project_status = '已完成' THEN 'project_warn_grey.png' WHEN C.days > 15 THEN 'project_warn_black.png' WHEN C.days > 10 THEN 'project_warn_red.png' WHEN C.days > 5 THEN 'project_warn_yellow.png' ELSE'project_warn_green.png' END AS warn_img");
	}

	@Override
	public BaseCollection<BaseprojectPreInfomations> executeQuery( KeyValuePair[] replacements, ConditionprojectPreInfomations condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(),
				condition.getEmployeeId(),
				condition.getDepartmentId(), 
				condition.getProjectCode(), 
				condition.getInfoCode(), 
				condition.getProjectName(), 
				condition.getCustomerName(), 
				condition.getBusinessType(), 
				condition.getDetailAddress(), 
				condition.getProjectLevel(), 
				condition.getContractAmount(), 
				condition.getProjectStatus(), 
				condition.getProjectSalesTeam(), 
				condition.getProcessStatus(), 
				condition.getStatus(), 
				condition.getProjectBaseOn(), 
				condition.getProjectOrigination(), 
				condition.getContactName(), 
				condition.getProjectMissioner(), 
				condition.getEstimateTheDesignAreas(), 
				condition.getActualDesignAreas(), 
				condition.getProjectTotalInvestment(), 
				condition.getDecorateMoneyControl(), 
				condition.getDesignTeam(), 
				condition.getContractStatus(), 
				condition.getDesignStatus(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getDesignCooperationName(), 
				condition.getArchitecturalDesignUnits(), 
				condition.getEmployeeName(), 
				condition.getProjectLeader(), 
				condition.getProjectManager(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd(), 
				condition.getWinRate()
			);
	}

	@Override
	public BaseprojectPreInfomations generateBase(Object[] __data) throws java.sql.SQLException {
		BaseprojectPreInfomations __base = new BaseprojectPreInfomations();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setWarnImg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWinRate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setComparisonForm(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectMissioner(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEstimateTheDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActualDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectTotalInvestment(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecorateMoneyControl(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLeader(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOriginationRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignQualification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDesignCooperationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFireResistanceRating(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBuildingHeight(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBuildingFloors(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegion(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCloseReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCloseRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGrade(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDays(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsPubliclyBidding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHaveAgents(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOwnerTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEstimatePrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompetitionName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsOperationDepartment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectOutputValue(GenericBase.__getDecimal(val));
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
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setString(count++, GenericBase.__getString(args[18]));
		if(args[19] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[19]));
		if(args[20] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[20]));
		if(args[21] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[21]));
		if(args[22] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[22]));
		if(args[23] != null) __statement.setInt(count++, GenericBase.__getInt(args[23]));
		if(args[24] != null) __statement.setInt(count++, GenericBase.__getInt(args[24]));
		if(args[25] != null) __statement.setString(count++, GenericBase.__getString(args[25]));
		if(args[26] != null) __statement.setString(count++, GenericBase.__getString(args[26]));
		if(args[27] != null) __statement.setString(count++, GenericBase.__getString(args[27]));
		if(args[28] != null) __statement.setString(count++, GenericBase.__getString(args[28]));
		if(args[29] != null) __statement.setString(count++, GenericBase.__getString(args[29]));
		if(args[30] != null) __statement.setString(count++, GenericBase.__getString(args[30]));
		if(args[31] != null) __statement.setString(count++, GenericBase.__getString(args[31]));
		if(args[32] != null) __statement.setString(count++, GenericBase.__getString(args[32]));
		if(args[33] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[33]));
		if(args[34] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[34]));
		if(args[35] != null) __statement.setString(count++, GenericBase.__getString(args[35]));
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

	
	private final static String __SQLText = "SELECT CASE WHEN C .status = 5 OR C.status = 2 OR C.contract_status = 3 OR C.project_status = '暂停' OR C.project_status = '已完成' THEN 'project_warn_grey.png' WHEN C.days > 15 THEN 'project_warn_black.png' WHEN C.days > 10 THEN 'project_warn_red.png' WHEN C.days > 5 THEN 'project_warn_yellow.png' ELSE'project_warn_green.png' END AS warn_img, C.project_code, C.info_code, C.project_name, C.customer_name, C.business_type, C.detail_address, C.project_level, C.contract_amount, C.win_rate, C.project_status, C.apply_employee_id, C.project_sales_team, C.process_status, C.status, C.project_base_on, C.create_time, C.register_date, C.project_origination, C.comparison_form, C.contact_name, C.contact_phone, C.project_missioner, C.estimate_the_design_areas, C.actual_design_areas, C.project_total_investment, C.decorate_money_control, C.design_team, C.project_leader, C.project_manager, C.contract_status, C.design_status, C.project_origination_remark, C.province, C.city, C.info_register_time, C.customer_address, C.sign_company, C.design_qualification, C.project_approval_time, C.design_cooperation_name, C.is_high_rise_building, C.total_building_areas, C.fire_resistance_rating, C.building_height, C.building_floors, C.architectural_design_units, C.contact_email, C.plate_id, C.employee_name, C.project_type, C.client_id, C.region, C.remark, C.close_reason, C.close_remark, C.grade, C.is_original, C.is_sub_project, C.days, CASE WHEN C.status = 5 OR C.status = 2 OR C.contract_status = 3 OR C.project_status = '暂停' OR C.project_status = '已完成' THEN 5 WHEN C.days > 15 THEN 4 WHEN C.days > 10 THEN 1 WHEN C.days > 5 THEN 2 ELSE 3 END AS FLAG, C.is_publicly_bidding, C.have_agents, C.department_id, C.owner_type_id, C.estimate_price, C.pre_project_id, C.specialty, C.competition_name, C.is_operation_department, C.project_output_value FROM ( SELECT aa.pre_project_id, aa.project_output_value, aa.project_code, aa.info_code, aa.project_name, aa.customer_name, aa.business_type, aa.detail_address, aa.project_level, ppr.contract_amount, aa.win_rate, aa.project_status, aa.apply_employee_id, aa.project_sales_team, A.process_status, aa.status, aa.project_base_on, aa.create_time, ppr.register_date, aa.project_origination, aa.comparison_form, aa.contact_name, aa.contact_phone, aa.estimate_the_design_areas, aa.actual_design_areas, aa.project_total_investment, aa.decorate_money_control, aa.design_team, aa.contract_status, aa.design_status, aa.project_origination_remark, aa.province, aa.city, aa.info_register_time, aa.customer_address, aa.sign_company, aa.design_qualification, aa.project_approval_time, aa.design_cooperation_name, aa.is_high_rise_building, aa.total_building_areas, aa.fire_resistance_rating, aa.building_height, aa.building_floors, aa.architectural_design_units, aa.contact_email, aa.project_type, aa.client_id, aa.region, aa.remark, aa.close_reason, aa.close_remark, aa.grade, aa.is_original, aa.is_sub_project, aa.is_publicly_bidding, aa.have_agents, e.department_id, e.plate_id, e.employee_name, aa.owner_type_id, aa.estimate_price, aa.specialty, CASE WHEN aa.info_register_time IS NULL THEN date_part( 'day', now() - aa.create_time ) ELSE CASE WHEN ppr.register_date IS NULL THEN date_part( 'day', now() - aa.info_register_time ) ELSE date_part( 'day', now() - ppr.register_date ) END END AS days, ab.project_missioner, ab.project_head, ab.project_manager, ab.project_leader, dd.competition_name, aa.is_operation_department FROM  pre_projects aa LEFT JOIN ( SELECT mpe.pre_project_id, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpe.relation = 1 THEN e.employee_name END )) ), '，' ) AS project_missioner, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpe.relation = 2 THEN e.employee_name END )) ), '，' ) AS project_head, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpe.relation = 3 THEN e.employee_name END )) ), '，' ) AS project_manager, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpe.relation = 4 THEN e.employee_name END )) ), '，' ) AS project_leader FROM pre_projects P LEFT JOIN main_project_employees mpe ON P.pre_project_id = mpe.pre_project_id LEFT JOIN employees e ON mpe.employee_id = e.employee_id WHERE mpe.pre_project_id IS NOT NULL AND (mpe.employee_id =?  or p.apply_employee_id=? or e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =?)) GROUP BY mpe.pre_project_id ) AS ab  ON ab.pre_project_id = aa.pre_project_id LEFT JOIN employees e ON e.employee_id = aa.apply_employee_id LEFT JOIN ( SELECT pre_project_id, MAX ( contract_amount ) AS contract_amount, MAX ( register_date ) AS register_date, MAX ( track_date ) AS track_date FROM pre_project_records GROUP BY pre_project_id ORDER BY pre_project_id desc) AS ppr ON aa.pre_project_id = ppr.pre_project_id LEFT JOIN system_process_instances A ON aa.pre_project_id = A.business_id AND A.process_type = 42  LEFT JOIN ( SELECT mcu.pre_project_id, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT cu.NAME )) ), '，' ) AS competition_name FROM main_project_competition_units mcu LEFT JOIN competition_units cu ON mcu.competition_unit_id = cu.competition_unit_id GROUP BY mcu.pre_project_id ) dd ON aa.pre_project_id = dd.pre_project_id  ) C WHERE C.project_code LIKE ? AND C.info_code like ? AND C.project_name LIKE ? AND C.customer_name LIKE ? AND C.business_type =? AND C.detail_address LIKE ? AND C.project_level =? AND C.contract_amount =? AND C.project_status =? AND C.project_sales_team =? AND C.process_status =? AND C.status =? AND C.project_base_on =? AND C.project_origination =? AND C.contact_name like ? AND C.project_missioner like ? AND C.estimate_the_design_areas =? AND C.actual_design_areas =? AND C.project_total_investment =? AND C.decorate_money_control =? AND C.design_team =? AND C.contract_status =? AND C.design_status =? AND C.province like ? AND C.city like ? AND C.design_cooperation_name =? AND C.architectural_design_units =? AND C.employee_name LIKE ? AND C.project_leader LIKE ? AND C.project_manager LIKE ? AND C.create_time BETWEEN ? AND ? AND C.win_rate >? ORDER BY CASE WHEN C.status = 5 OR C.status = 2 OR C.contract_status = 3 OR C.project_status = '暂停' OR C.project_status = '已完成' THEN 5 WHEN C.days > 15 THEN 4 WHEN C.days > 10 THEN 1 WHEN C.days > 5 THEN 2 ELSE 3 END " ;
//	private final static String __SQLText = "SELECT CASE WHEN C .status = 5 OR C.status = 2 OR C.contract_status = 3 OR C.project_status = '暂停' OR C.project_status = '已完成' THEN 'project_warn_grey.png' WHEN C.days > 15 THEN 'project_warn_black.png' WHEN C.days > 10 THEN 'project_warn_red.png' WHEN C.days > 5 THEN 'project_warn_yellow.png' ELSE'project_warn_green.png' END AS warn_img, C.project_code, C.info_code, C.project_name, C.customer_name, C.business_type, C.detail_address, C.project_level, C.contract_amount, C.win_rate, C.project_status, C.apply_employee_id, C.project_sales_team, C.process_status, C.status, C.project_base_on, C.create_time, C.register_date, C.project_origination, C.comparison_form, C.contact_name, C.contact_phone, C.project_missioner, C.estimate_the_design_areas, C.actual_design_areas, C.project_total_investment, C.decorate_money_control, C.design_team, C.project_leader, C.project_manager, C.contract_status, C.design_status, C.project_origination_remark, C.province, C.city, C.info_register_time, C.customer_address, C.sign_company, C.design_qualification, C.project_approval_time, C.design_cooperation_name, C.is_high_rise_building, C.total_building_areas, C.fire_resistance_rating, C.building_height, C.building_floors, C.architectural_design_units, C.contact_email, C.plate_id, C.employee_name, C.project_type, C.client_id, C.region, C.remark, C.close_reason, C.close_remark, C.grade, C.is_original, C.is_sub_project, C.days, CASE WHEN C.status = 5 OR C.status = 2 OR C.contract_status = 3 OR C.project_status = '暂停' OR C.project_status = '已完成' THEN 5 WHEN C.days > 15 THEN 4 WHEN C.days > 10 THEN 1 WHEN C.days > 5 THEN 2 ELSE 3 END AS FLAG, C.is_publicly_bidding, C.have_agents, C.department_id, C.owner_type_id, C.estimate_price, C.pre_project_id, C.specialty, C.competition_name, C.is_operation_department, C.project_output_value FROM ( SELECT aa.pre_project_id, aa.project_output_value, aa.project_code, aa.info_code, aa.project_name, aa.customer_name, aa.business_type, aa.detail_address, aa.project_level, ppr.contract_amount, aa.win_rate, aa.project_status, aa.apply_employee_id, aa.project_sales_team, A.process_status, aa.status, aa.project_base_on, aa.create_time, ppr.register_date, aa.project_origination, aa.comparison_form, aa.contact_name, aa.contact_phone, aa.estimate_the_design_areas, aa.actual_design_areas, aa.project_total_investment, aa.decorate_money_control, aa.design_team, aa.contract_status, aa.design_status, aa.project_origination_remark, aa.province, aa.city, aa.info_register_time, aa.customer_address, aa.sign_company, aa.design_qualification, aa.project_approval_time, aa.design_cooperation_name, aa.is_high_rise_building, aa.total_building_areas, aa.fire_resistance_rating, aa.building_height, aa.building_floors, aa.architectural_design_units, aa.contact_email, aa.project_type, aa.client_id, aa.region, aa.remark, aa.close_reason, aa.close_remark, aa.grade, aa.is_original, aa.is_sub_project, aa.is_publicly_bidding, aa.have_agents, e.department_id, e.plate_id, e.employee_name, aa.owner_type_id, aa.estimate_price, aa.specialty, CASE WHEN aa.info_register_time IS NULL THEN date_part( 'day', now() - aa.create_time ) ELSE CASE WHEN ppr.register_date IS NULL THEN date_part( 'day', now() - aa.info_register_time ) ELSE date_part( 'day', now() - ppr.register_date ) END END AS days, ab.project_missioner, ab.project_head, ab.project_manager, ab.project_leader, dd.competition_name, aa.is_operation_department FROM ( SELECT mpe.pre_project_id, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpe.relation = 1 THEN e.employee_name END )) ), '，' ) AS project_missioner, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpe.relation = 2 THEN e.employee_name END )) ), '，' ) AS project_head, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpe.relation = 3 THEN e.employee_name END )) ), '，' ) AS project_manager, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT CASE WHEN mpe.relation = 4 THEN e.employee_name END )) ), '，' ) AS project_leader FROM pre_projects P LEFT JOIN main_project_employees mpe ON P.pre_project_id = mpe.pre_project_id LEFT JOIN employees e ON mpe.employee_id = e.employee_id WHERE mpe.pre_project_id IS NOT NULL AND (mpe.employee_id =?  or p.apply_employee_id=? or e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =?)) GROUP BY mpe.pre_project_id ) AS ab LEFT JOIN pre_projects aa ON ab.pre_project_id = aa.pre_project_id LEFT JOIN employees e ON e.employee_id = aa.apply_employee_id LEFT JOIN ( SELECT pre_project_id, MAX ( contract_amount ) AS contract_amount, MAX ( register_date ) AS register_date, MAX ( track_date ) AS track_date FROM pre_project_records GROUP BY pre_project_id ORDER BY pre_project_id desc) AS ppr ON aa.pre_project_id = ppr.pre_project_id LEFT JOIN system_process_instances A ON aa.pre_project_id = A.business_id AND A.process_type = 42 LEFT JOIN contracts cot ON aa.info_code = cot.info_code LEFT JOIN ( SELECT mcu.pre_project_id, array_to_string( ARRAY ( SELECT UNNEST ( ARRAY_AGG ( DISTINCT cu.NAME )) ), '，' ) AS competition_name FROM main_project_competition_units mcu LEFT JOIN competition_units cu ON mcu.competition_unit_id = cu.competition_unit_id GROUP BY mcu.pre_project_id ) dd ON aa.pre_project_id = dd.pre_project_id  ) C WHERE C.project_code LIKE ? AND C.info_code like ? AND C.project_name LIKE ? AND C.customer_name LIKE ? AND C.business_type =? AND C.detail_address LIKE ? AND C.project_level =? AND C.contract_amount =? AND C.project_status =? AND C.project_sales_team =? AND C.process_status =? AND C.status =? AND C.project_base_on =? AND C.project_origination =? AND C.contact_name like ? AND C.project_missioner like ? AND C.estimate_the_design_areas =? AND C.actual_design_areas =? AND C.project_total_investment =? AND C.decorate_money_control =? AND C.design_team =? AND C.contract_status =? AND C.design_status =? AND C.province like ? AND C.city like ? AND C.design_cooperation_name =? AND C.architectural_design_units =? AND C.employee_name LIKE ? AND C.project_leader LIKE ? AND C.project_manager LIKE ? AND C.create_time BETWEEN ? AND ? AND C.win_rate >? ORDER BY CASE WHEN C.status = 5 OR C.status = 2 OR C.contract_status = 3 OR C.project_status = '暂停' OR C.project_status = '已完成' THEN 5 WHEN C.days > 15 THEN 4 WHEN C.days > 10 THEN 1 WHEN C.days > 5 THEN 2 ELSE 3 END " ;
	private final static String RESULTSETFIELDLIST = "warn_img,project_code,info_code,project_name,customer_name,business_type,detail_address,project_level,contract_amount,win_rate,project_status,apply_employee_id,project_sales_team,process_status,status,project_base_on,create_time,register_date,project_origination,comparison_form,contact_name,contact_phone,project_missioner,estimate_the_design_areas,actual_design_areas,project_total_investment,decorate_money_control,design_team,project_leader,project_manager,contract_status,design_status,project_origination_remark,province,city,info_register_time,customer_address,sign_company,design_qualification,project_approval_time,design_cooperation_name,is_high_rise_building,total_building_areas,fire_resistance_rating,building_height,building_floors,architectural_design_units,contact_email,plate_id,employee_name,project_type,client_id,region,remark,close_reason,close_remark,grade,is_original,is_sub_project,days,flag,is_publicly_bidding,have_agents,department_id,owner_type_id,estimate_price,pre_project_id,specialty,competition_name,is_operation_department,project_output_value";
	private final static String[] fieldNames = { "employee_id","employee_id", "department_id", "project_code", "info_code", "project_name", "customer_name", "business_type", "detail_address", "project_level", "contract_amount", "project_status", "project_sales_team", "process_status", "status", "project_base_on", "project_origination", "contact_name", "project_missioner", "estimate_the_design_areas", "actual_design_areas", "project_total_investment", "decorate_money_control", "design_team", "contract_status", "design_status", "province", "city", "design_cooperation_name", "architectural_design_units", "employee_name", "project_leader", "project_manager", "create_time_start", "create_time_end", "win_rate"};
}
