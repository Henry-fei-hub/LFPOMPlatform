package pomplatform.ht.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ht.bean.BaseMainProject;
import pomplatform.ht.bean.ConditionMainProject;

public class QueryAfterMainProject extends AbstractQuery<BaseMainProject, ConditionMainProject>
{

	private static final Logger __logger = Logger.getLogger(QueryAfterMainProject.class);

	public QueryAfterMainProject() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("mp.main_project_id");
	}

	@Override
	public BaseCollection<BaseMainProject> executeQuery( KeyValuePair[] replacements, ConditionMainProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getHasContract(), 
				condition.getProjectBaseOn(), 
				condition.getInfoCode()
			);
	}

	@Override
	public BaseMainProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMainProject __base = new BaseMainProject();
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
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBidProject(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setConstructionUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRateOfBidWinning(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFollowUpDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEquityedgeRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOrderSignUpTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDesignServiceBook(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setServiceSuggestBook(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCoveredArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		
		if((val = __data[count++]) != null) __base.setHasFormalContracts(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasOutQuotations(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasSplitPrice(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select mp.main_project_id, mp.project_code, mp.project_name, mp.project_english_name, mp.project_status, mp.design_status, mp.sign_company, mp.project_origination, mp.project_origination_remark, mp.design_cooperation_name, mp.design_cooperation_english_name, mp.project_sales_team, mp.design_team, mp.is_high_rise_building, mp.info_register_time, mp.project_approval_time, mp.has_contract, mp.project_base_on, mp.info_code, mp.project_model, mp.design_qualification, mp.business_type, mp.fire_resistance_rating, mp.estimate_the_design_areas, mp.project_total_investment, mp.actual_design_areas, mp.total_building_areas, mp.building_height, mp.building_floors, mp.decorate_money_control, mp.project_level, mp.province, mp.city, mp.detail_address, mp.project_end_time, mp.project_type, mp.customer_name, mp.customer_address, mp.bid_project, mp.construction_unit, mp.architectural_design_units, mp.rate_of_bid_winning, mp.follow_up_date, mp.equityedge_remark, mp.order_sign_up_time, mp.design_service_book, mp.service_suggest_book, mp.total_money, mp.covered_area, mp.design_area,mp.has_formal_contracts,mp.has_out_quotations,mp.has_split_price,mp.parent_id from main_projects mp where mp.project_code <> '' and mp.project_code is not null and mp.project_code = ? and mp.project_name like ? and mp.has_contract = ? and mp.project_base_on = ? and mp.info_code like ? order by mp.info_code,mp.info_register_time DESC" ;
	private final static String RESULTSETFIELDLIST = "main_project_id,project_code,project_name,project_english_name,project_status,design_status,sign_company,project_origination,project_origination_remark,design_cooperation_name,design_cooperation_english_name,project_sales_team,design_team,is_high_rise_building,info_register_time,project_approval_time,has_contract,project_base_on,info_code,project_model,design_qualification,business_type,fire_resistance_rating,estimate_the_design_areas,project_total_investment,actual_design_areas,total_building_areas,building_height,building_floors,decorate_money_control,project_level,province,city,detail_address,project_end_time,project_type,customer_name,customer_address,bid_project,construction_unit,architectural_design_units,rate_of_bid_winning,follow_up_date,equityedge_remark,order_sign_up_time,design_service_book,service_suggest_book,total_money,covered_area,design_area,parent_id";
	private final static String[] fieldNames = { "project_code", "project_name", "has_contract", "project_base_on", "info_code"};
}
