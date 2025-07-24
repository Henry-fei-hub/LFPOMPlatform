package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BasePreProject;


public class PreProject extends AbstractTable<BasePreProject>
{

	public PreProject() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 68;

		initTables();

		__tableName            = "pre_projects";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePreProject.CS_PRE_PROJECT_ID;
		__column_names[1] = BasePreProject.CS_PROJECT_CODE;
		__column_names[2] = BasePreProject.CS_INFO_CODE;
		__column_names[3] = BasePreProject.CS_CLIENT_ID;
		__column_names[4] = BasePreProject.CS_CUSTOMER_NAME;
		__column_names[5] = BasePreProject.CS_CUSTOMER_ADDRESS;
		__column_names[6] = BasePreProject.CS_PROJECT_NAME;
		__column_names[7] = BasePreProject.CS_PROVINCE;
		__column_names[8] = BasePreProject.CS_CITY;
		__column_names[9] = BasePreProject.CS_DETAIL_ADDRESS;
		__column_names[10] = BasePreProject.CS_PROJECT_TYPE;
		__column_names[11] = BasePreProject.CS_TOTAL_BUILDING_AREAS;
		__column_names[12] = BasePreProject.CS_PROJECT_ORIGINATION;
		__column_names[13] = BasePreProject.CS_PROJECT_ORIGINATION_REMARK;
		__column_names[14] = BasePreProject.CS_CUSTOMER_CONTACT_ID;
		__column_names[15] = BasePreProject.CS_CONTACT_NAME;
		__column_names[16] = BasePreProject.CS_CONTACT_PHONE;
		__column_names[17] = BasePreProject.CS_DESIGN_STATUS;
		__column_names[18] = BasePreProject.CS_PROJECT_SALES_TEAM;
		__column_names[19] = BasePreProject.CS_DESIGN_TEAM;
		__column_names[20] = BasePreProject.CS_PROJECT_LEVEL;
		__column_names[21] = BasePreProject.CS_SIGN_COMPANY;
		__column_names[22] = BasePreProject.CS_DESIGN_QUALIFICATION;
		__column_names[23] = BasePreProject.CS_PROJECT_BASE_ON;
		__column_names[24] = BasePreProject.CS_PROJECT_APPROVAL_TIME;
		__column_names[25] = BasePreProject.CS_IS_HIGH_RISE_BUILDING;
		__column_names[26] = BasePreProject.CS_DESIGN_COOPERATION_NAME;
		__column_names[27] = BasePreProject.CS_ARCHITECTURAL_DESIGN_UNITS;
		__column_names[28] = BasePreProject.CS_PROJECT_TOTAL_INVESTMENT;
		__column_names[29] = BasePreProject.CS_FIRE_RESISTANCE_RATING;
		__column_names[30] = BasePreProject.CS_ESTIMATE_THE_DESIGN_AREAS;
		__column_names[31] = BasePreProject.CS_ACTUAL_DESIGN_AREAS;
		__column_names[32] = BasePreProject.CS_BUILDING_HEIGHT;
		__column_names[33] = BasePreProject.CS_BUILDING_FLOORS;
		__column_names[34] = BasePreProject.CS_DECORATE_MONEY_CONTROL;
		__column_names[35] = BasePreProject.CS_SPECIALTY;
		__column_names[36] = BasePreProject.CS_BUSINESS_TYPE;
		__column_names[37] = BasePreProject.CS_HAS_CONTRACT;
		__column_names[38] = BasePreProject.CS_APPLY_EMPLOYEE_ID;
		__column_names[39] = BasePreProject.CS_CREATE_TIME;
		__column_names[40] = BasePreProject.CS_INFO_REGISTER_TIME;
		__column_names[41] = BasePreProject.CS_PROJECT_STATUS;
		__column_names[42] = BasePreProject.CS_CLOSE_REASON;
		__column_names[43] = BasePreProject.CS_STATUS;
		__column_names[44] = BasePreProject.CS_COMPARISON_FORM;
		__column_names[45] = BasePreProject.CS_REGION;
		__column_names[46] = BasePreProject.CS_WIN_RATE;
		__column_names[47] = BasePreProject.CS_REMARK;
		__column_names[48] = BasePreProject.CS_CLOSE_REMARK;
		__column_names[49] = BasePreProject.CS_GRADE;
		__column_names[50] = BasePreProject.CS_IS_ORIGINAL;
		__column_names[51] = BasePreProject.CS_IS_SUB_PROJECT;
		__column_names[52] = BasePreProject.CS_CONTRACT_STATUS;
		__column_names[53] = BasePreProject.CS_IS_PUBLICLY_BIDDING;
		__column_names[54] = BasePreProject.CS_HAVE_AGENTS;
		__column_names[55] = BasePreProject.CS_IS_WINNING_BID;
		__column_names[56] = BasePreProject.CS_BID_COMPANY_NUM;
		__column_names[57] = BasePreProject.CS_BID_RANKING_TYPE;
		__column_names[58] = BasePreProject.CS_BID_RANKING;
		__column_names[59] = BasePreProject.CS_OWNER_TYPE_ID;
		__column_names[60] = BasePreProject.CS_ESTIMATE_PRICE;
		__column_names[61] = BasePreProject.CS_CONTACT_EMAIL;
		__column_names[62] = BasePreProject.CS_IS_OPERATION_DEPARTMENT;
		__column_names[63] = BasePreProject.CS_PROJECT_NAME_ONE;
		__column_names[64] = BasePreProject.CS_BUSINESS_TYPES;
		__column_names[65] = BasePreProject.CS_BUSINESS_TYPES_NAME;
		__column_names[66] = BasePreProject.CS_PROJECT_OUTPUT_VALUE;
		__column_names[67] = BasePreProject.CS_PARENT_CUSTOMER_NAME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePreProject b) {
		clear();
		setPreProjectIdClear(b.getPreProjectId());
	}

	public boolean isPrimaryKeyNull() {
		return getPreProjectId() == null;
	}

	@Override
	public BasePreProject generateBase(){
		BasePreProject b = new BasePreProject();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePreProject b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPreProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setClientId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProvince(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDetailAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectOrigination(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectOriginationRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContactName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignStatus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignTeam(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSignCompany(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDesignQualification(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setDesignCooperationName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectTotalInvestment(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFireResistanceRating(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEstimateTheDesignAreas(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setActualDesignAreas(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBuildingHeight(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBuildingFloors(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDecorateMoneyControl(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSpecialty(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHasContract(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProjectStatus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCloseReason(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setComparisonForm(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRegion(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWinRate(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCloseRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setGrade(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsSubProject(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setContractStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsPubliclyBidding(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setHaveAgents(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsWinningBid(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBidCompanyNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBidRankingType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBidRanking(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOwnerTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEstimatePrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContactEmail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsOperationDepartment(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProjectNameOne(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessTypes(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessTypesName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectOutputValue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setParentCustomerName(GenericBase.__getString(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPreProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setInfoCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setClientId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCustomerName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCustomerAddress(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProvince(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCity(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDetailAddress(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalBuildingAreas(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectOrigination(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectOriginationRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCustomerContactId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContactName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContactPhone(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignStatus(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectSalesTeam(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignTeam(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectLevel(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSignCompany(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignQualification(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectBaseOn(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectApprovalTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignCooperationName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setArchitecturalDesignUnits(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectTotalInvestment(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFireResistanceRating(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEstimateTheDesignAreas(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setActualDesignAreas(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBuildingHeight(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBuildingFloors(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDecorateMoneyControl(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSpecialty(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessType(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasContract(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setApplyEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCreateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setInfoRegisterTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectStatus(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCloseReason(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setComparisonForm(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRegion(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWinRate(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCloseRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setGrade(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsOriginal(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsSubProject(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContractStatus(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsPubliclyBidding(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHaveAgents(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsWinningBid(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBidCompanyNum(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBidRankingType(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBidRanking(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOwnerTypeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEstimatePrice(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setContactEmail(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsOperationDepartment(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectNameOne(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessTypes(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessTypesName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectOutputValue(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setParentCustomerName(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BasePreProject b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPreProjectId();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getClientId();
		buff[count++] = b.getCustomerName();
		buff[count++] = b.getCustomerAddress();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProvince();
		buff[count++] = b.getCity();
		buff[count++] = b.getDetailAddress();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getTotalBuildingAreas();
		buff[count++] = b.getProjectOrigination();
		buff[count++] = b.getProjectOriginationRemark();
		buff[count++] = b.getCustomerContactId();
		buff[count++] = b.getContactName();
		buff[count++] = b.getContactPhone();
		buff[count++] = b.getDesignStatus();
		buff[count++] = b.getProjectSalesTeam();
		buff[count++] = b.getDesignTeam();
		buff[count++] = b.getProjectLevel();
		buff[count++] = b.getSignCompany();
		buff[count++] = b.getDesignQualification();
		buff[count++] = b.getProjectBaseOn();
		buff[count++] = generateTimestampFromDate(b.getProjectApprovalTime());
		buff[count++] = b.getIsHighRiseBuilding();
		buff[count++] = b.getDesignCooperationName();
		buff[count++] = b.getArchitecturalDesignUnits();
		buff[count++] = b.getProjectTotalInvestment();
		buff[count++] = b.getFireResistanceRating();
		buff[count++] = b.getEstimateTheDesignAreas();
		buff[count++] = b.getActualDesignAreas();
		buff[count++] = b.getBuildingHeight();
		buff[count++] = b.getBuildingFloors();
		buff[count++] = b.getDecorateMoneyControl();
		buff[count++] = b.getSpecialty();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getHasContract();
		buff[count++] = b.getApplyEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getInfoRegisterTime());
		buff[count++] = b.getProjectStatus();
		buff[count++] = b.getCloseReason();
		buff[count++] = b.getStatus();
		buff[count++] = b.getComparisonForm();
		buff[count++] = b.getRegion();
		buff[count++] = b.getWinRate();
		buff[count++] = b.getRemark();
		buff[count++] = b.getCloseRemark();
		buff[count++] = b.getGrade();
		buff[count++] = b.getIsOriginal();
		buff[count++] = b.getIsSubProject();
		buff[count++] = b.getContractStatus();
		buff[count++] = b.getIsPubliclyBidding();
		buff[count++] = b.getHaveAgents();
		buff[count++] = b.getIsWinningBid();
		buff[count++] = b.getBidCompanyNum();
		buff[count++] = b.getBidRankingType();
		buff[count++] = b.getBidRanking();
		buff[count++] = b.getOwnerTypeId();
		buff[count++] = b.getEstimatePrice();
		buff[count++] = b.getContactEmail();
		buff[count++] = b.getIsOperationDepartment();
		buff[count++] = b.getProjectNameOne();
		buff[count++] = b.getBusinessTypes();
		buff[count++] = b.getBusinessTypesName();
		buff[count++] = b.getProjectOutputValue();
		buff[count++] = b.getParentCustomerName();
	}

	@Override
	public void setDataFromBase(BasePreProject b){
		if(b.getPreProjectId() != null) setPreProjectIdClear(b.getPreProjectId());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getClientId() != null) setClientId(b.getClientId());
		if(b.getCustomerName() != null) setCustomerName(b.getCustomerName());
		if(b.getCustomerAddress() != null) setCustomerAddress(b.getCustomerAddress());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProvince() != null) setProvince(b.getProvince());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getDetailAddress() != null) setDetailAddress(b.getDetailAddress());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getTotalBuildingAreas() != null) setTotalBuildingAreas(b.getTotalBuildingAreas());
		if(b.getProjectOrigination() != null) setProjectOrigination(b.getProjectOrigination());
		if(b.getProjectOriginationRemark() != null) setProjectOriginationRemark(b.getProjectOriginationRemark());
		if(b.getCustomerContactId() != null) setCustomerContactId(b.getCustomerContactId());
		if(b.getContactName() != null) setContactName(b.getContactName());
		if(b.getContactPhone() != null) setContactPhone(b.getContactPhone());
		if(b.getDesignStatus() != null) setDesignStatus(b.getDesignStatus());
		if(b.getProjectSalesTeam() != null) setProjectSalesTeam(b.getProjectSalesTeam());
		if(b.getDesignTeam() != null) setDesignTeam(b.getDesignTeam());
		if(b.getProjectLevel() != null) setProjectLevel(b.getProjectLevel());
		if(b.getSignCompany() != null) setSignCompany(b.getSignCompany());
		if(b.getDesignQualification() != null) setDesignQualification(b.getDesignQualification());
		if(b.getProjectBaseOn() != null) setProjectBaseOn(b.getProjectBaseOn());
		if(b.getProjectApprovalTime() != null) setProjectApprovalTime(b.getProjectApprovalTime());
		if(b.getIsHighRiseBuilding() != null) setIsHighRiseBuilding(b.getIsHighRiseBuilding());
		if(b.getDesignCooperationName() != null) setDesignCooperationName(b.getDesignCooperationName());
		if(b.getArchitecturalDesignUnits() != null) setArchitecturalDesignUnits(b.getArchitecturalDesignUnits());
		if(b.getProjectTotalInvestment() != null) setProjectTotalInvestment(b.getProjectTotalInvestment());
		if(b.getFireResistanceRating() != null) setFireResistanceRating(b.getFireResistanceRating());
		if(b.getEstimateTheDesignAreas() != null) setEstimateTheDesignAreas(b.getEstimateTheDesignAreas());
		if(b.getActualDesignAreas() != null) setActualDesignAreas(b.getActualDesignAreas());
		if(b.getBuildingHeight() != null) setBuildingHeight(b.getBuildingHeight());
		if(b.getBuildingFloors() != null) setBuildingFloors(b.getBuildingFloors());
		if(b.getDecorateMoneyControl() != null) setDecorateMoneyControl(b.getDecorateMoneyControl());
		if(b.getSpecialty() != null) setSpecialty(b.getSpecialty());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getHasContract() != null) setHasContract(b.getHasContract());
		if(b.getApplyEmployeeId() != null) setApplyEmployeeId(b.getApplyEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getInfoRegisterTime() != null) setInfoRegisterTime(b.getInfoRegisterTime());
		if(b.getProjectStatus() != null) setProjectStatus(b.getProjectStatus());
		if(b.getCloseReason() != null) setCloseReason(b.getCloseReason());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getComparisonForm() != null) setComparisonForm(b.getComparisonForm());
		if(b.getRegion() != null) setRegion(b.getRegion());
		if(b.getWinRate() != null) setWinRate(b.getWinRate());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getCloseRemark() != null) setCloseRemark(b.getCloseRemark());
		if(b.getGrade() != null) setGrade(b.getGrade());
		if(b.getIsOriginal() != null) setIsOriginal(b.getIsOriginal());
		if(b.getIsSubProject() != null) setIsSubProject(b.getIsSubProject());
		if(b.getContractStatus() != null) setContractStatus(b.getContractStatus());
		if(b.getIsPubliclyBidding() != null) setIsPubliclyBidding(b.getIsPubliclyBidding());
		if(b.getHaveAgents() != null) setHaveAgents(b.getHaveAgents());
		if(b.getIsWinningBid() != null) setIsWinningBid(b.getIsWinningBid());
		if(b.getBidCompanyNum() != null) setBidCompanyNum(b.getBidCompanyNum());
		if(b.getBidRankingType() != null) setBidRankingType(b.getBidRankingType());
		if(b.getBidRanking() != null) setBidRanking(b.getBidRanking());
		if(b.getOwnerTypeId() != null) setOwnerTypeId(b.getOwnerTypeId());
		if(b.getEstimatePrice() != null) setEstimatePrice(b.getEstimatePrice());
		if(b.getContactEmail() != null) setContactEmail(b.getContactEmail());
		if(b.getIsOperationDepartment() != null) setIsOperationDepartment(b.getIsOperationDepartment());
		if(b.getProjectNameOne() != null) setProjectNameOne(b.getProjectNameOne());
		if(b.getBusinessTypes() != null) setBusinessTypes(b.getBusinessTypes());
		if(b.getBusinessTypesName() != null) setBusinessTypesName(b.getBusinessTypesName());
		if(b.getProjectOutputValue() != null) setProjectOutputValue(b.getProjectOutputValue());
		if(b.getParentCustomerName() != null) setParentCustomerName(b.getParentCustomerName());
	}

	@Override
	public BasePreProject generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePreProject b = new BasePreProject();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePreProject __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvince(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectOriginationRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignStatus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignQualification(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignCooperationName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTotalInvestment(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFireResistanceRating(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEstimateTheDesignAreas(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualDesignAreas(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBuildingHeight(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBuildingFloors(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDecorateMoneyControl(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialty(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasContract(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCloseReason(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComparisonForm(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegion(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWinRate(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCloseRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGrade(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsPubliclyBidding(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveAgents(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsWinningBid(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBidCompanyNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBidRankingType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBidRanking(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOwnerTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEstimatePrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactEmail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsOperationDepartment(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessTypes(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessTypesName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectOutputValue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentCustomerName(GenericBase.__getString(val));
	}

	public void setPreProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPreProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPreProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setClientId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getClientId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCustomerName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCustomerName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setCustomerAddress(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getCustomerAddress() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setProvince(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getProvince() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setCity(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getCity() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setDetailAddress(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getDetailAddress() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setTotalBuildingAreas(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getTotalBuildingAreas() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setProjectOrigination(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getProjectOrigination() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setProjectOriginationRemark(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getProjectOriginationRemark() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setCustomerContactId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getCustomerContactId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setContactName(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getContactName() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setContactPhone(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getContactPhone() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setDesignStatus(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getDesignStatus() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setProjectSalesTeam(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getProjectSalesTeam() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setDesignTeam(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getDesignTeam() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setProjectLevel(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getProjectLevel() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setSignCompany(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getSignCompany() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setDesignQualification(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getDesignQualification() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setProjectBaseOn(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getProjectBaseOn() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setProjectApprovalTime(java.util.Date val) {
		setCurrentData(24, generateTimestampFromDate(val));
	}

	public java.util.Date getProjectApprovalTime() {
		return GenericBase.__getDateFromSQL(__current_data[24]);
	}

	public void setIsHighRiseBuilding(java.lang.Boolean val) {
		setCurrentData(25, val);
	}

	public java.lang.Boolean getIsHighRiseBuilding() {
		return GenericBase.__getBoolean(__current_data[25]);
	}

	public void setDesignCooperationName(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getDesignCooperationName() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setArchitecturalDesignUnits(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getArchitecturalDesignUnits() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setProjectTotalInvestment(java.math.BigDecimal val) {
		setCurrentData(28, val);
	}

	public java.math.BigDecimal getProjectTotalInvestment() {
		return GenericBase.__getDecimal(__current_data[28]);
	}

	public void setFireResistanceRating(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getFireResistanceRating() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setEstimateTheDesignAreas(java.math.BigDecimal val) {
		setCurrentData(30, val);
	}

	public java.math.BigDecimal getEstimateTheDesignAreas() {
		return GenericBase.__getDecimal(__current_data[30]);
	}

	public void setActualDesignAreas(java.math.BigDecimal val) {
		setCurrentData(31, val);
	}

	public java.math.BigDecimal getActualDesignAreas() {
		return GenericBase.__getDecimal(__current_data[31]);
	}

	public void setBuildingHeight(java.math.BigDecimal val) {
		setCurrentData(32, val);
	}

	public java.math.BigDecimal getBuildingHeight() {
		return GenericBase.__getDecimal(__current_data[32]);
	}

	public void setBuildingFloors(java.math.BigDecimal val) {
		setCurrentData(33, val);
	}

	public java.math.BigDecimal getBuildingFloors() {
		return GenericBase.__getDecimal(__current_data[33]);
	}

	public void setDecorateMoneyControl(java.math.BigDecimal val) {
		setCurrentData(34, val);
	}

	public java.math.BigDecimal getDecorateMoneyControl() {
		return GenericBase.__getDecimal(__current_data[34]);
	}

	public void setSpecialty(java.lang.String val) {
		setCurrentData(35, val);
	}

	public java.lang.String getSpecialty() {
		return GenericBase.__getString(__current_data[35]);
	}

	public void setBusinessType(java.lang.String val) {
		setCurrentData(36, val);
	}

	public java.lang.String getBusinessType() {
		return GenericBase.__getString(__current_data[36]);
	}

	public void setHasContract(java.lang.Boolean val) {
		setCurrentData(37, val);
	}

	public java.lang.Boolean getHasContract() {
		return GenericBase.__getBoolean(__current_data[37]);
	}

	public void setApplyEmployeeId(java.lang.Integer val) {
		setCurrentData(38, val);
	}

	public java.lang.Integer getApplyEmployeeId() {
		return GenericBase.__getInt(__current_data[38]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(39, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[39]);
	}

	public void setInfoRegisterTime(java.util.Date val) {
		setCurrentData(40, generateTimestampFromDate(val));
	}

	public java.util.Date getInfoRegisterTime() {
		return GenericBase.__getDateFromSQL(__current_data[40]);
	}

	public void setProjectStatus(java.lang.String val) {
		setCurrentData(41, val);
	}

	public java.lang.String getProjectStatus() {
		return GenericBase.__getString(__current_data[41]);
	}

	public void setCloseReason(java.lang.String val) {
		setCurrentData(42, val);
	}

	public java.lang.String getCloseReason() {
		return GenericBase.__getString(__current_data[42]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(43, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[43]);
	}

	public void setComparisonForm(java.lang.Integer val) {
		setCurrentData(44, val);
	}

	public java.lang.Integer getComparisonForm() {
		return GenericBase.__getInt(__current_data[44]);
	}

	public void setRegion(java.lang.Integer val) {
		setCurrentData(45, val);
	}

	public java.lang.Integer getRegion() {
		return GenericBase.__getInt(__current_data[45]);
	}

	public void setWinRate(java.lang.String val) {
		setCurrentData(46, val);
	}

	public java.lang.String getWinRate() {
		return GenericBase.__getString(__current_data[46]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(47, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[47]);
	}

	public void setCloseRemark(java.lang.String val) {
		setCurrentData(48, val);
	}

	public java.lang.String getCloseRemark() {
		return GenericBase.__getString(__current_data[48]);
	}

	public void setGrade(java.lang.String val) {
		setCurrentData(49, val);
	}

	public java.lang.String getGrade() {
		return GenericBase.__getString(__current_data[49]);
	}

	public void setIsOriginal(java.lang.Boolean val) {
		setCurrentData(50, val);
	}

	public java.lang.Boolean getIsOriginal() {
		return GenericBase.__getBoolean(__current_data[50]);
	}

	public void setIsSubProject(java.lang.Boolean val) {
		setCurrentData(51, val);
	}

	public java.lang.Boolean getIsSubProject() {
		return GenericBase.__getBoolean(__current_data[51]);
	}

	public void setContractStatus(java.lang.Integer val) {
		setCurrentData(52, val);
	}

	public java.lang.Integer getContractStatus() {
		return GenericBase.__getInt(__current_data[52]);
	}

	public void setIsPubliclyBidding(java.lang.Boolean val) {
		setCurrentData(53, val);
	}

	public java.lang.Boolean getIsPubliclyBidding() {
		return GenericBase.__getBoolean(__current_data[53]);
	}

	public void setHaveAgents(java.lang.Boolean val) {
		setCurrentData(54, val);
	}

	public java.lang.Boolean getHaveAgents() {
		return GenericBase.__getBoolean(__current_data[54]);
	}

	public void setIsWinningBid(java.lang.Boolean val) {
		setCurrentData(55, val);
	}

	public java.lang.Boolean getIsWinningBid() {
		return GenericBase.__getBoolean(__current_data[55]);
	}

	public void setBidCompanyNum(java.lang.Integer val) {
		setCurrentData(56, val);
	}

	public java.lang.Integer getBidCompanyNum() {
		return GenericBase.__getInt(__current_data[56]);
	}

	public void setBidRankingType(java.lang.String val) {
		setCurrentData(57, val);
	}

	public java.lang.String getBidRankingType() {
		return GenericBase.__getString(__current_data[57]);
	}

	public void setBidRanking(java.lang.Integer val) {
		setCurrentData(58, val);
	}

	public java.lang.Integer getBidRanking() {
		return GenericBase.__getInt(__current_data[58]);
	}

	public void setOwnerTypeId(java.lang.Integer val) {
		setCurrentData(59, val);
	}

	public java.lang.Integer getOwnerTypeId() {
		return GenericBase.__getInt(__current_data[59]);
	}

	public void setEstimatePrice(java.math.BigDecimal val) {
		setCurrentData(60, val);
	}

	public java.math.BigDecimal getEstimatePrice() {
		return GenericBase.__getDecimal(__current_data[60]);
	}

	public void setContactEmail(java.lang.String val) {
		setCurrentData(61, val);
	}

	public java.lang.String getContactEmail() {
		return GenericBase.__getString(__current_data[61]);
	}

	public void setIsOperationDepartment(java.lang.Boolean val) {
		setCurrentData(62, val);
	}

	public java.lang.Boolean getIsOperationDepartment() {
		return GenericBase.__getBoolean(__current_data[62]);
	}

	public void setProjectNameOne(java.lang.String val) {
		setCurrentData(63, val);
	}

	public java.lang.String getProjectNameOne() {
		return GenericBase.__getString(__current_data[63]);
	}

	public void setBusinessTypes(java.lang.String val) {
		setCurrentData(64, val);
	}

	public java.lang.String getBusinessTypes() {
		return GenericBase.__getString(__current_data[64]);
	}

	public void setBusinessTypesName(java.lang.String val) {
		setCurrentData(65, val);
	}

	public java.lang.String getBusinessTypesName() {
		return GenericBase.__getString(__current_data[65]);
	}

	public void setProjectOutputValue(java.math.BigDecimal val) {
		setCurrentData(66, val);
	}

	public java.math.BigDecimal getProjectOutputValue() {
		return GenericBase.__getDecimal(__current_data[66]);
	}

	public void setParentCustomerName(java.lang.String val) {
		setCurrentData(67, val);
	}

	public java.lang.String getParentCustomerName() {
		return GenericBase.__getString(__current_data[67]);
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val) {
		setConditionPreProjectId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPreProjectId(boolean val) {
		__select_flags[0] = val;
	}

	public void setPreProjectIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[1] = val;
	}

	public void setProjectCodeExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setInfoCodeExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionClientId(String op, java.lang.Integer val) {
		setConditionClientId(op, val, CONDITION_AND);
	}

	public void setConditionClientId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectClientId(boolean val) {
		__select_flags[3] = val;
	}

	public void setClientIdExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionCustomerName(String op, java.lang.String val) {
		setConditionCustomerName(op, val, CONDITION_AND);
	}

	public void setConditionCustomerName(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCustomerName(boolean val) {
		__select_flags[4] = val;
	}

	public void setCustomerNameExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionCustomerAddress(String op, java.lang.String val) {
		setConditionCustomerAddress(op, val, CONDITION_AND);
	}

	public void setConditionCustomerAddress(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCustomerAddress(boolean val) {
		__select_flags[5] = val;
	}

	public void setCustomerAddressExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[6] = val;
	}

	public void setProjectNameExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionProvince(String op, java.lang.String val) {
		setConditionProvince(op, val, CONDITION_AND);
	}

	public void setConditionProvince(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProvince(boolean val) {
		__select_flags[7] = val;
	}

	public void setProvinceExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionCity(String op, java.lang.String val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[8] = val;
	}

	public void setCityExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionDetailAddress(String op, java.lang.String val) {
		setConditionDetailAddress(op, val, CONDITION_AND);
	}

	public void setConditionDetailAddress(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectDetailAddress(boolean val) {
		__select_flags[9] = val;
	}

	public void setDetailAddressExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[10] = val;
	}

	public void setProjectTypeExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionTotalBuildingAreas(String op, java.math.BigDecimal val) {
		setConditionTotalBuildingAreas(op, val, CONDITION_AND);
	}

	public void setConditionTotalBuildingAreas(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTotalBuildingAreas(boolean val) {
		__select_flags[11] = val;
	}

	public void setTotalBuildingAreasExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionProjectOrigination(String op, java.lang.String val) {
		setConditionProjectOrigination(op, val, CONDITION_AND);
	}

	public void setConditionProjectOrigination(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectProjectOrigination(boolean val) {
		__select_flags[12] = val;
	}

	public void setProjectOriginationExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionProjectOriginationRemark(String op, java.lang.String val) {
		setConditionProjectOriginationRemark(op, val, CONDITION_AND);
	}

	public void setConditionProjectOriginationRemark(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectProjectOriginationRemark(boolean val) {
		__select_flags[13] = val;
	}

	public void setProjectOriginationRemarkExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionCustomerContactId(String op, java.lang.Integer val) {
		setConditionCustomerContactId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerContactId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectCustomerContactId(boolean val) {
		__select_flags[14] = val;
	}

	public void setCustomerContactIdExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionContactName(String op, java.lang.String val) {
		setConditionContactName(op, val, CONDITION_AND);
	}

	public void setConditionContactName(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectContactName(boolean val) {
		__select_flags[15] = val;
	}

	public void setContactNameExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionContactPhone(String op, java.lang.String val) {
		setConditionContactPhone(op, val, CONDITION_AND);
	}

	public void setConditionContactPhone(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectContactPhone(boolean val) {
		__select_flags[16] = val;
	}

	public void setContactPhoneExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionDesignStatus(String op, java.lang.String val) {
		setConditionDesignStatus(op, val, CONDITION_AND);
	}

	public void setConditionDesignStatus(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectDesignStatus(boolean val) {
		__select_flags[17] = val;
	}

	public void setDesignStatusExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionProjectSalesTeam(String op, java.lang.String val) {
		setConditionProjectSalesTeam(op, val, CONDITION_AND);
	}

	public void setConditionProjectSalesTeam(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectProjectSalesTeam(boolean val) {
		__select_flags[18] = val;
	}

	public void setProjectSalesTeamExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionDesignTeam(String op, java.lang.Integer val) {
		setConditionDesignTeam(op, val, CONDITION_AND);
	}

	public void setConditionDesignTeam(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectDesignTeam(boolean val) {
		__select_flags[19] = val;
	}

	public void setDesignTeamExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val) {
		setConditionProjectLevel(op, val, CONDITION_AND);
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectProjectLevel(boolean val) {
		__select_flags[20] = val;
	}

	public void setProjectLevelExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionSignCompany(String op, java.lang.Integer val) {
		setConditionSignCompany(op, val, CONDITION_AND);
	}

	public void setConditionSignCompany(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectSignCompany(boolean val) {
		__select_flags[21] = val;
	}

	public void setSignCompanyExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionDesignQualification(String op, java.lang.String val) {
		setConditionDesignQualification(op, val, CONDITION_AND);
	}

	public void setConditionDesignQualification(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectDesignQualification(boolean val) {
		__select_flags[22] = val;
	}

	public void setDesignQualificationExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionProjectBaseOn(String op, java.lang.Integer val) {
		setConditionProjectBaseOn(op, val, CONDITION_AND);
	}

	public void setConditionProjectBaseOn(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectProjectBaseOn(boolean val) {
		__select_flags[23] = val;
	}

	public void setProjectBaseOnExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionProjectApprovalTime(String op, java.util.Date val) {
		setConditionProjectApprovalTime(op, val, CONDITION_AND);
	}

	public void setConditionProjectApprovalTime(String op, java.util.Date val, String relation) {
		addCondition(24, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectProjectApprovalTime(boolean val) {
		__select_flags[24] = val;
	}

	public void setProjectApprovalTimeExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionIsHighRiseBuilding(String op, java.lang.Boolean val) {
		setConditionIsHighRiseBuilding(op, val, CONDITION_AND);
	}

	public void setConditionIsHighRiseBuilding(String op, java.lang.Boolean val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectIsHighRiseBuilding(boolean val) {
		__select_flags[25] = val;
	}

	public void setIsHighRiseBuildingExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionDesignCooperationName(String op, java.lang.String val) {
		setConditionDesignCooperationName(op, val, CONDITION_AND);
	}

	public void setConditionDesignCooperationName(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectDesignCooperationName(boolean val) {
		__select_flags[26] = val;
	}

	public void setDesignCooperationNameExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionArchitecturalDesignUnits(String op, java.lang.String val) {
		setConditionArchitecturalDesignUnits(op, val, CONDITION_AND);
	}

	public void setConditionArchitecturalDesignUnits(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectArchitecturalDesignUnits(boolean val) {
		__select_flags[27] = val;
	}

	public void setArchitecturalDesignUnitsExpression(String val) {
		__dataExpressions[27] = val;
	}

	public void setConditionProjectTotalInvestment(String op, java.math.BigDecimal val) {
		setConditionProjectTotalInvestment(op, val, CONDITION_AND);
	}

	public void setConditionProjectTotalInvestment(String op, java.math.BigDecimal val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectProjectTotalInvestment(boolean val) {
		__select_flags[28] = val;
	}

	public void setProjectTotalInvestmentExpression(String val) {
		__dataExpressions[28] = val;
	}

	public void setConditionFireResistanceRating(String op, java.lang.String val) {
		setConditionFireResistanceRating(op, val, CONDITION_AND);
	}

	public void setConditionFireResistanceRating(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectFireResistanceRating(boolean val) {
		__select_flags[29] = val;
	}

	public void setFireResistanceRatingExpression(String val) {
		__dataExpressions[29] = val;
	}

	public void setConditionEstimateTheDesignAreas(String op, java.math.BigDecimal val) {
		setConditionEstimateTheDesignAreas(op, val, CONDITION_AND);
	}

	public void setConditionEstimateTheDesignAreas(String op, java.math.BigDecimal val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectEstimateTheDesignAreas(boolean val) {
		__select_flags[30] = val;
	}

	public void setEstimateTheDesignAreasExpression(String val) {
		__dataExpressions[30] = val;
	}

	public void setConditionActualDesignAreas(String op, java.math.BigDecimal val) {
		setConditionActualDesignAreas(op, val, CONDITION_AND);
	}

	public void setConditionActualDesignAreas(String op, java.math.BigDecimal val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectActualDesignAreas(boolean val) {
		__select_flags[31] = val;
	}

	public void setActualDesignAreasExpression(String val) {
		__dataExpressions[31] = val;
	}

	public void setConditionBuildingHeight(String op, java.math.BigDecimal val) {
		setConditionBuildingHeight(op, val, CONDITION_AND);
	}

	public void setConditionBuildingHeight(String op, java.math.BigDecimal val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectBuildingHeight(boolean val) {
		__select_flags[32] = val;
	}

	public void setBuildingHeightExpression(String val) {
		__dataExpressions[32] = val;
	}

	public void setConditionBuildingFloors(String op, java.math.BigDecimal val) {
		setConditionBuildingFloors(op, val, CONDITION_AND);
	}

	public void setConditionBuildingFloors(String op, java.math.BigDecimal val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectBuildingFloors(boolean val) {
		__select_flags[33] = val;
	}

	public void setBuildingFloorsExpression(String val) {
		__dataExpressions[33] = val;
	}

	public void setConditionDecorateMoneyControl(String op, java.math.BigDecimal val) {
		setConditionDecorateMoneyControl(op, val, CONDITION_AND);
	}

	public void setConditionDecorateMoneyControl(String op, java.math.BigDecimal val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectDecorateMoneyControl(boolean val) {
		__select_flags[34] = val;
	}

	public void setDecorateMoneyControlExpression(String val) {
		__dataExpressions[34] = val;
	}

	public void setConditionSpecialty(String op, java.lang.String val) {
		setConditionSpecialty(op, val, CONDITION_AND);
	}

	public void setConditionSpecialty(String op, java.lang.String val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectSpecialty(boolean val) {
		__select_flags[35] = val;
	}

	public void setSpecialtyExpression(String val) {
		__dataExpressions[35] = val;
	}

	public void setConditionBusinessType(String op, java.lang.String val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.String val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[36] = val;
	}

	public void setBusinessTypeExpression(String val) {
		__dataExpressions[36] = val;
	}

	public void setConditionHasContract(String op, java.lang.Boolean val) {
		setConditionHasContract(op, val, CONDITION_AND);
	}

	public void setConditionHasContract(String op, java.lang.Boolean val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectHasContract(boolean val) {
		__select_flags[37] = val;
	}

	public void setHasContractExpression(String val) {
		__dataExpressions[37] = val;
	}

	public void setConditionApplyEmployeeId(String op, java.lang.Integer val) {
		setConditionApplyEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionApplyEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectApplyEmployeeId(boolean val) {
		__select_flags[38] = val;
	}

	public void setApplyEmployeeIdExpression(String val) {
		__dataExpressions[38] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(39, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[39] = val;
	}

	public void setCreateTimeExpression(String val) {
		__dataExpressions[39] = val;
	}

	public void setConditionInfoRegisterTime(String op, java.util.Date val) {
		setConditionInfoRegisterTime(op, val, CONDITION_AND);
	}

	public void setConditionInfoRegisterTime(String op, java.util.Date val, String relation) {
		addCondition(40, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectInfoRegisterTime(boolean val) {
		__select_flags[40] = val;
	}

	public void setInfoRegisterTimeExpression(String val) {
		__dataExpressions[40] = val;
	}

	public void setConditionProjectStatus(String op, java.lang.String val) {
		setConditionProjectStatus(op, val, CONDITION_AND);
	}

	public void setConditionProjectStatus(String op, java.lang.String val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectProjectStatus(boolean val) {
		__select_flags[41] = val;
	}

	public void setProjectStatusExpression(String val) {
		__dataExpressions[41] = val;
	}

	public void setConditionCloseReason(String op, java.lang.String val) {
		setConditionCloseReason(op, val, CONDITION_AND);
	}

	public void setConditionCloseReason(String op, java.lang.String val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectCloseReason(boolean val) {
		__select_flags[42] = val;
	}

	public void setCloseReasonExpression(String val) {
		__dataExpressions[42] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(43, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[43] = val;
	}

	public void setStatusExpression(String val) {
		__dataExpressions[43] = val;
	}

	public void setConditionComparisonForm(String op, java.lang.Integer val) {
		setConditionComparisonForm(op, val, CONDITION_AND);
	}

	public void setConditionComparisonForm(String op, java.lang.Integer val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectComparisonForm(boolean val) {
		__select_flags[44] = val;
	}

	public void setComparisonFormExpression(String val) {
		__dataExpressions[44] = val;
	}

	public void setConditionRegion(String op, java.lang.Integer val) {
		setConditionRegion(op, val, CONDITION_AND);
	}

	public void setConditionRegion(String op, java.lang.Integer val, String relation) {
		addCondition(45, op, relation, val);
	}

	public void setSelectRegion(boolean val) {
		__select_flags[45] = val;
	}

	public void setRegionExpression(String val) {
		__dataExpressions[45] = val;
	}

	public void setConditionWinRate(String op, java.lang.String val) {
		setConditionWinRate(op, val, CONDITION_AND);
	}

	public void setConditionWinRate(String op, java.lang.String val, String relation) {
		addCondition(46, op, relation, val);
	}

	public void setSelectWinRate(boolean val) {
		__select_flags[46] = val;
	}

	public void setWinRateExpression(String val) {
		__dataExpressions[46] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(47, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[47] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[47] = val;
	}

	public void setConditionCloseRemark(String op, java.lang.String val) {
		setConditionCloseRemark(op, val, CONDITION_AND);
	}

	public void setConditionCloseRemark(String op, java.lang.String val, String relation) {
		addCondition(48, op, relation, val);
	}

	public void setSelectCloseRemark(boolean val) {
		__select_flags[48] = val;
	}

	public void setCloseRemarkExpression(String val) {
		__dataExpressions[48] = val;
	}

	public void setConditionGrade(String op, java.lang.String val) {
		setConditionGrade(op, val, CONDITION_AND);
	}

	public void setConditionGrade(String op, java.lang.String val, String relation) {
		addCondition(49, op, relation, val);
	}

	public void setSelectGrade(boolean val) {
		__select_flags[49] = val;
	}

	public void setGradeExpression(String val) {
		__dataExpressions[49] = val;
	}

	public void setConditionIsOriginal(String op, java.lang.Boolean val) {
		setConditionIsOriginal(op, val, CONDITION_AND);
	}

	public void setConditionIsOriginal(String op, java.lang.Boolean val, String relation) {
		addCondition(50, op, relation, val);
	}

	public void setSelectIsOriginal(boolean val) {
		__select_flags[50] = val;
	}

	public void setIsOriginalExpression(String val) {
		__dataExpressions[50] = val;
	}

	public void setConditionIsSubProject(String op, java.lang.Boolean val) {
		setConditionIsSubProject(op, val, CONDITION_AND);
	}

	public void setConditionIsSubProject(String op, java.lang.Boolean val, String relation) {
		addCondition(51, op, relation, val);
	}

	public void setSelectIsSubProject(boolean val) {
		__select_flags[51] = val;
	}

	public void setIsSubProjectExpression(String val) {
		__dataExpressions[51] = val;
	}

	public void setConditionContractStatus(String op, java.lang.Integer val) {
		setConditionContractStatus(op, val, CONDITION_AND);
	}

	public void setConditionContractStatus(String op, java.lang.Integer val, String relation) {
		addCondition(52, op, relation, val);
	}

	public void setSelectContractStatus(boolean val) {
		__select_flags[52] = val;
	}

	public void setContractStatusExpression(String val) {
		__dataExpressions[52] = val;
	}

	public void setConditionIsPubliclyBidding(String op, java.lang.Boolean val) {
		setConditionIsPubliclyBidding(op, val, CONDITION_AND);
	}

	public void setConditionIsPubliclyBidding(String op, java.lang.Boolean val, String relation) {
		addCondition(53, op, relation, val);
	}

	public void setSelectIsPubliclyBidding(boolean val) {
		__select_flags[53] = val;
	}

	public void setIsPubliclyBiddingExpression(String val) {
		__dataExpressions[53] = val;
	}

	public void setConditionHaveAgents(String op, java.lang.Boolean val) {
		setConditionHaveAgents(op, val, CONDITION_AND);
	}

	public void setConditionHaveAgents(String op, java.lang.Boolean val, String relation) {
		addCondition(54, op, relation, val);
	}

	public void setSelectHaveAgents(boolean val) {
		__select_flags[54] = val;
	}

	public void setHaveAgentsExpression(String val) {
		__dataExpressions[54] = val;
	}

	public void setConditionIsWinningBid(String op, java.lang.Boolean val) {
		setConditionIsWinningBid(op, val, CONDITION_AND);
	}

	public void setConditionIsWinningBid(String op, java.lang.Boolean val, String relation) {
		addCondition(55, op, relation, val);
	}

	public void setSelectIsWinningBid(boolean val) {
		__select_flags[55] = val;
	}

	public void setIsWinningBidExpression(String val) {
		__dataExpressions[55] = val;
	}

	public void setConditionBidCompanyNum(String op, java.lang.Integer val) {
		setConditionBidCompanyNum(op, val, CONDITION_AND);
	}

	public void setConditionBidCompanyNum(String op, java.lang.Integer val, String relation) {
		addCondition(56, op, relation, val);
	}

	public void setSelectBidCompanyNum(boolean val) {
		__select_flags[56] = val;
	}

	public void setBidCompanyNumExpression(String val) {
		__dataExpressions[56] = val;
	}

	public void setConditionBidRankingType(String op, java.lang.String val) {
		setConditionBidRankingType(op, val, CONDITION_AND);
	}

	public void setConditionBidRankingType(String op, java.lang.String val, String relation) {
		addCondition(57, op, relation, val);
	}

	public void setSelectBidRankingType(boolean val) {
		__select_flags[57] = val;
	}

	public void setBidRankingTypeExpression(String val) {
		__dataExpressions[57] = val;
	}

	public void setConditionBidRanking(String op, java.lang.Integer val) {
		setConditionBidRanking(op, val, CONDITION_AND);
	}

	public void setConditionBidRanking(String op, java.lang.Integer val, String relation) {
		addCondition(58, op, relation, val);
	}

	public void setSelectBidRanking(boolean val) {
		__select_flags[58] = val;
	}

	public void setBidRankingExpression(String val) {
		__dataExpressions[58] = val;
	}

	public void setConditionOwnerTypeId(String op, java.lang.Integer val) {
		setConditionOwnerTypeId(op, val, CONDITION_AND);
	}

	public void setConditionOwnerTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(59, op, relation, val);
	}

	public void setSelectOwnerTypeId(boolean val) {
		__select_flags[59] = val;
	}

	public void setOwnerTypeIdExpression(String val) {
		__dataExpressions[59] = val;
	}

	public void setConditionEstimatePrice(String op, java.math.BigDecimal val) {
		setConditionEstimatePrice(op, val, CONDITION_AND);
	}

	public void setConditionEstimatePrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(60, op, relation, val);
	}

	public void setSelectEstimatePrice(boolean val) {
		__select_flags[60] = val;
	}

	public void setEstimatePriceExpression(String val) {
		__dataExpressions[60] = val;
	}

	public void setConditionContactEmail(String op, java.lang.String val) {
		setConditionContactEmail(op, val, CONDITION_AND);
	}

	public void setConditionContactEmail(String op, java.lang.String val, String relation) {
		addCondition(61, op, relation, val);
	}

	public void setSelectContactEmail(boolean val) {
		__select_flags[61] = val;
	}

	public void setContactEmailExpression(String val) {
		__dataExpressions[61] = val;
	}

	public void setConditionIsOperationDepartment(String op, java.lang.Boolean val) {
		setConditionIsOperationDepartment(op, val, CONDITION_AND);
	}

	public void setConditionIsOperationDepartment(String op, java.lang.Boolean val, String relation) {
		addCondition(62, op, relation, val);
	}

	public void setSelectIsOperationDepartment(boolean val) {
		__select_flags[62] = val;
	}

	public void setIsOperationDepartmentExpression(String val) {
		__dataExpressions[62] = val;
	}

	public void setConditionProjectNameOne(String op, java.lang.String val) {
		setConditionProjectNameOne(op, val, CONDITION_AND);
	}

	public void setConditionProjectNameOne(String op, java.lang.String val, String relation) {
		addCondition(63, op, relation, val);
	}

	public void setSelectProjectNameOne(boolean val) {
		__select_flags[63] = val;
	}

	public void setProjectNameOneExpression(String val) {
		__dataExpressions[63] = val;
	}

	public void setConditionBusinessTypes(String op, java.lang.String val) {
		setConditionBusinessTypes(op, val, CONDITION_AND);
	}

	public void setConditionBusinessTypes(String op, java.lang.String val, String relation) {
		addCondition(64, op, relation, val);
	}

	public void setSelectBusinessTypes(boolean val) {
		__select_flags[64] = val;
	}

	public void setBusinessTypesExpression(String val) {
		__dataExpressions[64] = val;
	}

	public void setConditionBusinessTypesName(String op, java.lang.String val) {
		setConditionBusinessTypesName(op, val, CONDITION_AND);
	}

	public void setConditionBusinessTypesName(String op, java.lang.String val, String relation) {
		addCondition(65, op, relation, val);
	}

	public void setSelectBusinessTypesName(boolean val) {
		__select_flags[65] = val;
	}

	public void setBusinessTypesNameExpression(String val) {
		__dataExpressions[65] = val;
	}

	public void setConditionProjectOutputValue(String op, java.math.BigDecimal val) {
		setConditionProjectOutputValue(op, val, CONDITION_AND);
	}

	public void setConditionProjectOutputValue(String op, java.math.BigDecimal val, String relation) {
		addCondition(66, op, relation, val);
	}

	public void setSelectProjectOutputValue(boolean val) {
		__select_flags[66] = val;
	}

	public void setProjectOutputValueExpression(String val) {
		__dataExpressions[66] = val;
	}

	public void setConditionParentCustomerName(String op, java.lang.String val) {
		setConditionParentCustomerName(op, val, CONDITION_AND);
	}

	public void setConditionParentCustomerName(String op, java.lang.String val, String relation) {
		addCondition(67, op, relation, val);
	}

	public void setSelectParentCustomerName(boolean val) {
		__select_flags[67] = val;
	}

	public void setParentCustomerNameExpression(String val) {
		__dataExpressions[67] = val;
	}


}

