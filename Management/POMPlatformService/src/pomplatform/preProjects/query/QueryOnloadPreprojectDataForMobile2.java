package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseOnloadPreprojectDataForMobile2;
import pomplatform.preProjects.bean.ConditionOnloadPreprojectDataForMobile2;

public class QueryOnloadPreprojectDataForMobile2 extends AbstractQuery<BaseOnloadPreprojectDataForMobile2, ConditionOnloadPreprojectDataForMobile2>
{

	private static final Logger __logger = Logger.getLogger(QueryOnloadPreprojectDataForMobile2.class);

	public QueryOnloadPreprojectDataForMobile2() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pre_project_id");
	}

	@Override
	public BaseCollection<BaseOnloadPreprojectDataForMobile2> executeQuery( KeyValuePair[] replacements, ConditionOnloadPreprojectDataForMobile2 condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPreProjectId()
			);
	}

	@Override
	public BaseOnloadPreprojectDataForMobile2 generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnloadPreprojectDataForMobile2 __base = new BaseOnloadPreprojectDataForMobile2();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOriginationRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignQualification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDesignCooperationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectTotalInvestment(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFireResistanceRating(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEstimateTheDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActualDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBuildingHeight(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBuildingFloors(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecorateMoneyControl(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHasContract(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCloseReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setComparisonForm(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegion(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWinRate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCloseRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGrade(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsPubliclyBidding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHaveAgents(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsWinningBid(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setBidCompanyNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBidRankingType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBidRanking(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSalePerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSaleLeader(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManage(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLeader(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOwnerTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEstimatePrice(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT pre_project_id, project_code, info_code, client_id, customer_name, customer_address, project_name, province, city, detail_address, project_type, total_building_areas, project_origination, project_origination_remark, customer_contact_id, contact_name, contact_phone, design_status, project_sales_team, design_team, project_level, sign_company, design_qualification, project_base_on, project_approval_time, is_high_rise_building, design_cooperation_name, architectural_design_units, project_total_investment, fire_resistance_rating, estimate_the_design_areas, actual_design_areas, building_height, building_floors, decorate_money_control, specialty, business_type, has_contract, apply_employee_id, create_time, info_register_time, project_status, close_reason, status, comparison_form, region, win_rate, remark, close_remark, grade, is_original, is_sub_project, contract_status, is_publicly_bidding, have_agents, is_winning_bid, bid_company_num, bid_ranking_type, bid_ranking, '' AS sale_person, '' AS sale_leader, '' AS project_manage, '' AS project_leader, owner_type_id, estimate_price FROM pre_projects WHERE pre_project_id =?" ;
	private final static String RESULTSETFIELDLIST = "pre_project_id,project_code,info_code,client_id,customer_name,customer_address,project_name,province,city,detail_address,project_type,total_building_areas,project_origination,project_origination_remark,customer_contact_id,contact_name,contact_phone,design_status,project_sales_team,design_team,project_level,sign_company,design_qualification,project_base_on,project_approval_time,is_high_rise_building,design_cooperation_name,architectural_design_units,project_total_investment,fire_resistance_rating,estimate_the_design_areas,actual_design_areas,building_height,building_floors,decorate_money_control,specialty,business_type,has_contract,apply_employee_id,create_time,info_register_time,project_status,close_reason,status,comparison_form,region,win_rate,remark,close_remark,grade,is_original,is_sub_project,contract_status,is_publicly_bidding,have_agents,is_winning_bid,bid_company_num,bid_ranking_type,bid_ranking,sale_person,sale_leader,project_manage,project_leader,owner_type_id,estimate_price";
	private final static String[] fieldNames = { "pre_project_id"};
}
