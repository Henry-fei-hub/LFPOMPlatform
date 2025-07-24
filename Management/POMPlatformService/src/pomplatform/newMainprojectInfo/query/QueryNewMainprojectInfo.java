package pomplatform.newMainprojectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.newMainprojectInfo.bean.BaseNewMainprojectInfo;
import pomplatform.newMainprojectInfo.bean.ConditionNewMainprojectInfo;

public class QueryNewMainprojectInfo extends AbstractQuery<BaseNewMainprojectInfo, ConditionNewMainprojectInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryNewMainprojectInfo.class);

	public QueryNewMainprojectInfo() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mp.main_project_id");
	}

	@Override
	public BaseCollection<BaseNewMainprojectInfo> executeQuery( KeyValuePair[] replacements, ConditionNewMainprojectInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getProjectBaseOn(), 
				condition.getHasContract()
			);
	}

	@Override
	public BaseNewMainprojectInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNewMainprojectInfo __base = new BaseNewMainprojectInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectEnglishName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOriginationRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignCooperationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignCooperationEnglishName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setHasContract(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectModel(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignQualification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFireResistanceRating(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEstimateTheDesignAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectTotalInvestment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActualDesignAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBuildingHeight(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBuildingFloors(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDecorateMoneyControl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectSaleMan(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSaleTeamManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLeader(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[3]));
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

	private final static String __SQLText = "select mp.main_project_id, mp.project_code, mp.project_name, mp.project_english_name, mp.project_status, mp.design_status, mp.sign_company, mp.project_origination, mp.project_origination_remark, mp.design_cooperation_name, mp.design_cooperation_english_name, mp.project_sales_team, mp.design_team, mp.is_high_rise_building, mp.info_register_time, mp.project_approval_time, mp.has_contract, mp.project_base_on, mp.info_code, mp.project_model, mp.design_qualification, mp.business_type, mp.fire_resistance_rating, mp.estimate_the_design_areas, mp.project_total_investment, mp.actual_design_areas, mp.total_building_areas, mp.building_height, mp.building_floors, mp.decorate_money_control, mp.project_level, mp.province || mp.city || mp.detail_address as address, mp.project_end_time, (SELECT string_agg(employee_name,',') from main_project_employees mpe, employees e WHERE mpe.main_project_id = mp.main_project_id and mpe.employee_id = e.employee_id and mpe.relation = 1) as project_sale_man, (SELECT string_agg(employee_name,',') from main_project_employees mpe, employees e WHERE mpe.main_project_id = mp.main_project_id and mpe.employee_id = e.employee_id and mpe.relation = 2) as project_sale_team_manager, (SELECT string_agg(employee_name,',') from main_project_employees mpe, employees e WHERE mpe.main_project_id = mp.main_project_id and mpe.employee_id = e.employee_id and mpe.relation = 3) as project_manager, (SELECT string_agg(employee_name,',') from main_project_employees mpe, employees e WHERE mpe.main_project_id = mp.main_project_id and mpe.employee_id = e.employee_id and mpe.relation = 4) as project_leader from main_projects mp WHERE mp.project_code like ? and mp.project_name like ? and mp.project_base_on = ? and mp.has_contract = ?" ;
	private final static String RESULTSETFIELDLIST = "main_project_id,project_code,project_name,project_english_name,project_status,design_status,sign_company,project_origination,project_origination_remark,design_cooperation_name,design_cooperation_english_name,project_sales_team,design_team,is_high_rise_building,info_register_time,project_approval_time,has_contract,project_base_on,info_code,project_model,design_qualification,business_type,fire_resistance_rating,estimate_the_design_areas,project_total_investment,actual_design_areas,total_building_areas,building_height,building_floors,decorate_money_control,project_level,address,project_end_time,project_sale_man,project_sale_team_manager,project_manager,project_leader";
	private final static String[] fieldNames = { "project_code", "project_name", "project_base_on", "has_contract"};
}
