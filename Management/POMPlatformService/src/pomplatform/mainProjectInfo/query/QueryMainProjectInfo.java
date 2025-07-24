package pomplatform.mainProjectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjectInfo.bean.BaseMainProjectInfo;
import pomplatform.mainProjectInfo.bean.ConditionMainProjectInfo;

public class QueryMainProjectInfo extends AbstractQuery<BaseMainProjectInfo, ConditionMainProjectInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryMainProjectInfo.class);

	public QueryMainProjectInfo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mp.main_project_id");
	}

	@Override
	public BaseCollection<BaseMainProjectInfo> executeQuery( KeyValuePair[] replacements, ConditionMainProjectInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectBaseOn(), 
				condition.getHasContract()
			);
	}

	@Override
	public BaseMainProjectInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMainProjectInfo __base = new BaseMainProjectInfo();
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
		if((val = __data[count++]) != null) __base.setProjectSalesman(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeamManager(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectManager(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLeader(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectEndTime(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[2]));
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

	private final static String __SQLText = "select mp.main_project_id, mp.project_code, mp.project_name, mp.project_english_name, mp.project_status, mp.design_status, mp.sign_company, mp.project_origination, mp.project_origination_remark, mp.design_cooperation_name, mp.design_cooperation_english_name, mp.project_sales_team, mp.project_salesman, mp.project_sales_team_manager, mp.design_team, mp.is_high_rise_building, mp.info_register_time, mp.project_approval_time, mp.project_manager, mp.project_leader, mp.has_contract, mp.project_base_on, mp.info_code, mp.project_model, mp.design_qualification, mp.business_type, mp.fire_resistance_rating, mp.estimate_the_design_areas, mp.project_total_investment, mp.actual_design_areas, mp.total_building_areas, mp.building_height, mp.building_floors, mp.decorate_money_control, mp.project_level, mp.province, mp.city, mp.detail_address, mp.project_end_time from main_projects mp where mp.project_code = ? and mp.project_base_on = ? and mp.has_contract = ? order by mp.project_approval_time" ;
	private final static String RESULTSETFIELDLIST = "main_project_id,project_code,project_name,project_english_name,project_status,design_status,sign_company,project_origination,project_origination_remark,design_cooperation_name,design_cooperation_english_name,project_sales_team,project_salesman,project_sales_team_manager,design_team,is_high_rise_building,info_register_time,project_approval_time,project_manager,project_leader,has_contract,project_base_on,info_code,project_model,design_qualification,business_type,fire_resistance_rating,estimate_the_design_areas,project_total_investment,actual_design_areas,total_building_areas,building_height,building_floors,decorate_money_control,project_level,province,city,detail_address,project_end_time";
	private final static String[] fieldNames = { "project_code", "project_base_on", "has_contract"};
}
