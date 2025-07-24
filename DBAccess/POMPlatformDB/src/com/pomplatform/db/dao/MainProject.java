package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseMainProject;


public class MainProject extends AbstractTable<BaseMainProject>
{

	public MainProject() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 100;

		initTables();

		__tableName            = "main_projects";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMainProject.CS_MAIN_PROJECT_ID;
		__column_names[1] = BaseMainProject.CS_PROJECT_CODE;
		__column_names[2] = BaseMainProject.CS_PROJECT_NAME;
		__column_names[3] = BaseMainProject.CS_PROJECT_ENGLISH_NAME;
		__column_names[4] = BaseMainProject.CS_PROJECT_STATUS;
		__column_names[5] = BaseMainProject.CS_DESIGN_STATUS;
		__column_names[6] = BaseMainProject.CS_SIGN_COMPANY;
		__column_names[7] = BaseMainProject.CS_PROJECT_ORIGINATION;
		__column_names[8] = BaseMainProject.CS_PROJECT_ORIGINATION_REMARK;
		__column_names[9] = BaseMainProject.CS_DESIGN_COOPERATION_NAME;
		__column_names[10] = BaseMainProject.CS_DESIGN_COOPERATION_ENGLISH_NAME;
		__column_names[11] = BaseMainProject.CS_DESIGN_TEAM;
		__column_names[12] = BaseMainProject.CS_IS_HIGH_RISE_BUILDING;
		__column_names[13] = BaseMainProject.CS_INFO_REGISTER_TIME;
		__column_names[14] = BaseMainProject.CS_PROJECT_APPROVAL_TIME;
		__column_names[15] = BaseMainProject.CS_HAS_CONTRACT;
		__column_names[16] = BaseMainProject.CS_PROJECT_BASE_ON;
		__column_names[17] = BaseMainProject.CS_INFO_CODE;
		__column_names[18] = BaseMainProject.CS_PROJECT_MODEL;
		__column_names[19] = BaseMainProject.CS_DESIGN_QUALIFICATION;
		__column_names[20] = BaseMainProject.CS_BUSINESS_TYPE;
		__column_names[21] = BaseMainProject.CS_FIRE_RESISTANCE_RATING;
		__column_names[22] = BaseMainProject.CS_ESTIMATE_THE_DESIGN_AREAS;
		__column_names[23] = BaseMainProject.CS_PROJECT_TOTAL_INVESTMENT;
		__column_names[24] = BaseMainProject.CS_ACTUAL_DESIGN_AREAS;
		__column_names[25] = BaseMainProject.CS_TOTAL_BUILDING_AREAS;
		__column_names[26] = BaseMainProject.CS_BUILDING_HEIGHT;
		__column_names[27] = BaseMainProject.CS_BUILDING_FLOORS;
		__column_names[28] = BaseMainProject.CS_DECORATE_MONEY_CONTROL;
		__column_names[29] = BaseMainProject.CS_PROJECT_LEVEL;
		__column_names[30] = BaseMainProject.CS_PROVINCE;
		__column_names[31] = BaseMainProject.CS_CITY;
		__column_names[32] = BaseMainProject.CS_DETAIL_ADDRESS;
		__column_names[33] = BaseMainProject.CS_PROJECT_END_TIME;
		__column_names[34] = BaseMainProject.CS_PROJECT_TYPE;
		__column_names[35] = BaseMainProject.CS_CUSTOMER_NAME;
		__column_names[36] = BaseMainProject.CS_CUSTOMER_ADDRESS;
		__column_names[37] = BaseMainProject.CS_BID_PROJECT;
		__column_names[38] = BaseMainProject.CS_CONSTRUCTION_UNIT;
		__column_names[39] = BaseMainProject.CS_ARCHITECTURAL_DESIGN_UNITS;
		__column_names[40] = BaseMainProject.CS_RATE_OF_BID_WINNING;
		__column_names[41] = BaseMainProject.CS_FOLLOW_UP_DATE;
		__column_names[42] = BaseMainProject.CS_EQUITYEDGE_REMARK;
		__column_names[43] = BaseMainProject.CS_ORDER_SIGN_UP_TIME;
		__column_names[44] = BaseMainProject.CS_DESIGN_SERVICE_BOOK;
		__column_names[45] = BaseMainProject.CS_SERVICE_SUGGEST_BOOK;
		__column_names[46] = BaseMainProject.CS_TOTAL_MONEY;
		__column_names[47] = BaseMainProject.CS_COVERED_AREA;
		__column_names[48] = BaseMainProject.CS_DESIGN_AREA;
		__column_names[49] = BaseMainProject.CS_HAS_FORMAL_CONTRACTS;
		__column_names[50] = BaseMainProject.CS_HAS_OUT_QUOTATIONS;
		__column_names[51] = BaseMainProject.CS_SPECIALTY;
		__column_names[52] = BaseMainProject.CS_PROJECT_SALES_TEAM;
		__column_names[53] = BaseMainProject.CS_HAS_SPLIT_PRICE;
		__column_names[54] = BaseMainProject.CS_HAS_ORDER_RELEASE;
		__column_names[55] = BaseMainProject.CS_HAS_DEPOSIT;
		__column_names[56] = BaseMainProject.CS_HAS_RATE_OF_PAYMENT;
		__column_names[57] = BaseMainProject.CS_PARENT_ID;
		__column_names[58] = BaseMainProject.CS_SERIAL_NUMBER;
		__column_names[59] = BaseMainProject.CS_HAS_FORMAL_CONTRACT_TIME;
		__column_names[60] = BaseMainProject.CS_HAS_OUT_QUOTATION_TIME;
		__column_names[61] = BaseMainProject.CS_HAS_ORDER_RELEASE_TIME;
		__column_names[62] = BaseMainProject.CS_HAS_SPLIT_PRICE_TIME;
		__column_names[63] = BaseMainProject.CS_BID_TYPE;
		__column_names[64] = BaseMainProject.CS_BID_DATE;
		__column_names[65] = BaseMainProject.CS_BID_CLASS_TYPE;
		__column_names[66] = BaseMainProject.CS_BID_UNIT_NUM;
		__column_names[67] = BaseMainProject.CS_OUR_ORDER;
		__column_names[68] = BaseMainProject.CS_BIG_PAY_AMOUNT;
		__column_names[69] = BaseMainProject.CS_BIG_IS_ACHIEVE_AMOUNT;
		__column_names[70] = BaseMainProject.CS_BIG_ADVANCE_AMOUNT;
		__column_names[71] = BaseMainProject.CS_CLIENT_ID;
		__column_names[72] = BaseMainProject.CS_CONTACT_NAME;
		__column_names[73] = BaseMainProject.CS_CONTACT_PHONE;
		__column_names[74] = BaseMainProject.CS_APPLY_EMPLOYEE_ID;
		__column_names[75] = BaseMainProject.CS_CUSTOMER_CONTACT_ID;
		__column_names[76] = BaseMainProject.CS_ARCHITECTURAL_DESIGN_UNIT_ID;
		__column_names[77] = BaseMainProject.CS_ARCHITECTURAL_DESIGN_UNIT_CONTACT_ID;
		__column_names[78] = BaseMainProject.CS_REGION;
		__column_names[79] = BaseMainProject.CS_COMPARISON_FORM;
		__column_names[80] = BaseMainProject.CS_IS_ORIGINAL;
		__column_names[81] = BaseMainProject.CS_IS_SUB_PROJECT;
		__column_names[82] = BaseMainProject.CS_CONTRACT_STATUS;
		__column_names[83] = BaseMainProject.CS_IS_PUBLICLY_BIDDING;
		__column_names[84] = BaseMainProject.CS_HAVE_AGENTS;
		__column_names[85] = BaseMainProject.CS_COMPANY_ID;
		__column_names[86] = BaseMainProject.CS_COMPANY_NO;
		__column_names[87] = BaseMainProject.CS_PERCENT;
		__column_names[88] = BaseMainProject.CS_OWNER_TYPE_ID;
		__column_names[89] = BaseMainProject.CS_ESTIMATE_PRICE;
		__column_names[90] = BaseMainProject.CS_PROJECT_PHASE;
		__column_names[91] = BaseMainProject.CS_PROJECT_ATTRIBUTE;
		__column_names[92] = BaseMainProject.CS_PROJECT_NAME_ONE;
		__column_names[93] = BaseMainProject.CS_WINNING_TIME;
		__column_names[94] = BaseMainProject.CS_PROJECT_OUTPUT_VALUE;
		__column_names[95] = BaseMainProject.CS_MAIN_PROJECT_STAGE_ID;
		__column_names[96] = BaseMainProject.CS_IS_MODIFY_PROJECT;
		__column_names[97] = BaseMainProject.CS_GRADE;
		__column_names[98] = BaseMainProject.CS_REMARK;
		__column_names[99] = BaseMainProject.CS_PROCESS_STATUS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMainProject b) {
		clear();
		setMainProjectIdClear(b.getMainProjectId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectId() == null;
	}

	@Override
	public BaseMainProject generateBase(){
		BaseMainProject b = new BaseMainProject();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProject b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectEnglishName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectStatus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignStatus(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSignCompany(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectOrigination(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectOriginationRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignCooperationName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignCooperationEnglishName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignTeam(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setHasContract(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setProjectBaseOn(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectModel(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignQualification(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFireResistanceRating(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEstimateTheDesignAreas(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectTotalInvestment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setActualDesignAreas(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBuildingHeight(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBuildingFloors(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDecorateMoneyControl(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProvince(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDetailAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBidProject(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setConstructionUnit(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRateOfBidWinning(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFollowUpDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEquityedgeRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOrderSignUpTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDesignServiceBook(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setServiceSuggestBook(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTotalMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCoveredArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDesignArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHasFormalContracts(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setHasOutQuotations(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setSpecialty(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setHasSplitPrice(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setHasOrderRelease(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setHasDeposit(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setHasRateOfPayment(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSerialNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHasFormalContractTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setHasOutQuotationTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setHasOrderReleaseTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setHasSplitPriceTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setBidType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBidDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setBidClassType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBidUnitNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOurOrder(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBigPayAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setBigIsAchieveAmount(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setBigAdvanceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setClientId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContactName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContactPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setArchitecturalDesignUnitId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setArchitecturalDesignUnitContactId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRegion(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setComparisonForm(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsSubProject(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setContractStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsPubliclyBidding(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setHaveAgents(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOwnerTypeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEstimatePrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectPhase(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectAttribute(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectNameOne(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWinningTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setProjectOutputValue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMainProjectStageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsModifyProject(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setGrade(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProcessStatus(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setMainProjectId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectEnglishName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectStatus(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignStatus(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSignCompany(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setDesignCooperationName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignCooperationEnglishName(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignTeam(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setInfoRegisterTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectApprovalTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasContract(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectBaseOn(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setInfoCode(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectModel(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignQualification(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBusinessType(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFireResistanceRating(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEstimateTheDesignAreas(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectTotalInvestment(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setActualDesignAreas(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalBuildingAreas(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBuildingHeight(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBuildingFloors(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDecorateMoneyControl(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectLevel(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setProjectEndTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectType(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setBidProject(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setConstructionUnit(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setArchitecturalDesignUnits(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRateOfBidWinning(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setFollowUpDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEquityedgeRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOrderSignUpTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignServiceBook(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setServiceSuggestBook(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setTotalMoney(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCoveredArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setDesignArea(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasFormalContracts(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasOutQuotations(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSpecialty(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectSalesTeam(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasSplitPrice(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasOrderRelease(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasDeposit(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasRateOfPayment(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setParentId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setSerialNumber(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasFormalContractTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasOutQuotationTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasOrderReleaseTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setHasSplitPriceTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBidType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBidDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBidClassType(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBidUnitNum(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOurOrder(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBigPayAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBigIsAchieveAmount(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setBigAdvanceAmount(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setClientId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setApplyEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCustomerContactId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setArchitecturalDesignUnitId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setArchitecturalDesignUnitContactId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRegion(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setComparisonForm(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setCompanyId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setCompanyNo(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPercent(GenericBase.__getDecimal(val));
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
			if(val != null && !val.isEmpty()) setProjectPhase(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectAttribute(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectNameOne(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setWinningTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProjectOutputValue(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setMainProjectStageId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setIsModifyProject(GenericBase.__getBoolean(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setGrade(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setProcessStatus(GenericBase.__getInt(val));
		}
	}

	@Override
	public void setBaseToBuffer(BaseMainProject b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProjectEnglishName();
		buff[count++] = b.getProjectStatus();
		buff[count++] = b.getDesignStatus();
		buff[count++] = b.getSignCompany();
		buff[count++] = b.getProjectOrigination();
		buff[count++] = b.getProjectOriginationRemark();
		buff[count++] = b.getDesignCooperationName();
		buff[count++] = b.getDesignCooperationEnglishName();
		buff[count++] = b.getDesignTeam();
		buff[count++] = b.getIsHighRiseBuilding();
		buff[count++] = generateTimestampFromDate(b.getInfoRegisterTime());
		buff[count++] = generateTimestampFromDate(b.getProjectApprovalTime());
		buff[count++] = b.getHasContract();
		buff[count++] = b.getProjectBaseOn();
		buff[count++] = b.getInfoCode();
		buff[count++] = b.getProjectModel();
		buff[count++] = b.getDesignQualification();
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getFireResistanceRating();
		buff[count++] = b.getEstimateTheDesignAreas();
		buff[count++] = b.getProjectTotalInvestment();
		buff[count++] = b.getActualDesignAreas();
		buff[count++] = b.getTotalBuildingAreas();
		buff[count++] = b.getBuildingHeight();
		buff[count++] = b.getBuildingFloors();
		buff[count++] = b.getDecorateMoneyControl();
		buff[count++] = b.getProjectLevel();
		buff[count++] = b.getProvince();
		buff[count++] = b.getCity();
		buff[count++] = b.getDetailAddress();
		buff[count++] = generateTimestampFromDate(b.getProjectEndTime());
		buff[count++] = b.getProjectType();
		buff[count++] = b.getCustomerName();
		buff[count++] = b.getCustomerAddress();
		buff[count++] = b.getBidProject();
		buff[count++] = b.getConstructionUnit();
		buff[count++] = b.getArchitecturalDesignUnits();
		buff[count++] = b.getRateOfBidWinning();
		buff[count++] = generateTimestampFromDate(b.getFollowUpDate());
		buff[count++] = b.getEquityedgeRemark();
		buff[count++] = generateTimestampFromDate(b.getOrderSignUpTime());
		buff[count++] = b.getDesignServiceBook();
		buff[count++] = b.getServiceSuggestBook();
		buff[count++] = b.getTotalMoney();
		buff[count++] = b.getCoveredArea();
		buff[count++] = b.getDesignArea();
		buff[count++] = b.getHasFormalContracts();
		buff[count++] = b.getHasOutQuotations();
		buff[count++] = b.getSpecialty();
		buff[count++] = b.getProjectSalesTeam();
		buff[count++] = b.getHasSplitPrice();
		buff[count++] = b.getHasOrderRelease();
		buff[count++] = b.getHasDeposit();
		buff[count++] = b.getHasRateOfPayment();
		buff[count++] = b.getParentId();
		buff[count++] = b.getSerialNumber();
		buff[count++] = generateTimestampFromDate(b.getHasFormalContractTime());
		buff[count++] = generateTimestampFromDate(b.getHasOutQuotationTime());
		buff[count++] = generateTimestampFromDate(b.getHasOrderReleaseTime());
		buff[count++] = generateTimestampFromDate(b.getHasSplitPriceTime());
		buff[count++] = b.getBidType();
		buff[count++] = generateTimestampFromDate(b.getBidDate());
		buff[count++] = b.getBidClassType();
		buff[count++] = b.getBidUnitNum();
		buff[count++] = b.getOurOrder();
		buff[count++] = b.getBigPayAmount();
		buff[count++] = b.getBigIsAchieveAmount();
		buff[count++] = b.getBigAdvanceAmount();
		buff[count++] = b.getClientId();
		buff[count++] = b.getContactName();
		buff[count++] = b.getContactPhone();
		buff[count++] = b.getApplyEmployeeId();
		buff[count++] = b.getCustomerContactId();
		buff[count++] = b.getArchitecturalDesignUnitId();
		buff[count++] = b.getArchitecturalDesignUnitContactId();
		buff[count++] = b.getRegion();
		buff[count++] = b.getComparisonForm();
		buff[count++] = b.getIsOriginal();
		buff[count++] = b.getIsSubProject();
		buff[count++] = b.getContractStatus();
		buff[count++] = b.getIsPubliclyBidding();
		buff[count++] = b.getHaveAgents();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getCompanyNo();
		buff[count++] = b.getPercent();
		buff[count++] = b.getOwnerTypeId();
		buff[count++] = b.getEstimatePrice();
		buff[count++] = b.getProjectPhase();
		buff[count++] = b.getProjectAttribute();
		buff[count++] = b.getProjectNameOne();
		buff[count++] = generateTimestampFromDate(b.getWinningTime());
		buff[count++] = b.getProjectOutputValue();
		buff[count++] = b.getMainProjectStageId();
		buff[count++] = b.getIsModifyProject();
		buff[count++] = b.getGrade();
		buff[count++] = b.getRemark();
		buff[count++] = b.getProcessStatus();
	}

	@Override
	public void setDataFromBase(BaseMainProject b){
		if(b.getMainProjectId() != null) setMainProjectIdClear(b.getMainProjectId());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProjectEnglishName() != null) setProjectEnglishName(b.getProjectEnglishName());
		if(b.getProjectStatus() != null) setProjectStatus(b.getProjectStatus());
		if(b.getDesignStatus() != null) setDesignStatus(b.getDesignStatus());
		if(b.getSignCompany() != null) setSignCompany(b.getSignCompany());
		if(b.getProjectOrigination() != null) setProjectOrigination(b.getProjectOrigination());
		if(b.getProjectOriginationRemark() != null) setProjectOriginationRemark(b.getProjectOriginationRemark());
		if(b.getDesignCooperationName() != null) setDesignCooperationName(b.getDesignCooperationName());
		if(b.getDesignCooperationEnglishName() != null) setDesignCooperationEnglishName(b.getDesignCooperationEnglishName());
		if(b.getDesignTeam() != null) setDesignTeam(b.getDesignTeam());
		if(b.getIsHighRiseBuilding() != null) setIsHighRiseBuilding(b.getIsHighRiseBuilding());
		if(b.getInfoRegisterTime() != null) setInfoRegisterTime(b.getInfoRegisterTime());
		if(b.getProjectApprovalTime() != null) setProjectApprovalTime(b.getProjectApprovalTime());
		if(b.getHasContract() != null) setHasContract(b.getHasContract());
		if(b.getProjectBaseOn() != null) setProjectBaseOn(b.getProjectBaseOn());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
		if(b.getProjectModel() != null) setProjectModel(b.getProjectModel());
		if(b.getDesignQualification() != null) setDesignQualification(b.getDesignQualification());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getFireResistanceRating() != null) setFireResistanceRating(b.getFireResistanceRating());
		if(b.getEstimateTheDesignAreas() != null) setEstimateTheDesignAreas(b.getEstimateTheDesignAreas());
		if(b.getProjectTotalInvestment() != null) setProjectTotalInvestment(b.getProjectTotalInvestment());
		if(b.getActualDesignAreas() != null) setActualDesignAreas(b.getActualDesignAreas());
		if(b.getTotalBuildingAreas() != null) setTotalBuildingAreas(b.getTotalBuildingAreas());
		if(b.getBuildingHeight() != null) setBuildingHeight(b.getBuildingHeight());
		if(b.getBuildingFloors() != null) setBuildingFloors(b.getBuildingFloors());
		if(b.getDecorateMoneyControl() != null) setDecorateMoneyControl(b.getDecorateMoneyControl());
		if(b.getProjectLevel() != null) setProjectLevel(b.getProjectLevel());
		if(b.getProvince() != null) setProvince(b.getProvince());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getDetailAddress() != null) setDetailAddress(b.getDetailAddress());
		if(b.getProjectEndTime() != null) setProjectEndTime(b.getProjectEndTime());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getCustomerName() != null) setCustomerName(b.getCustomerName());
		if(b.getCustomerAddress() != null) setCustomerAddress(b.getCustomerAddress());
		if(b.getBidProject() != null) setBidProject(b.getBidProject());
		if(b.getConstructionUnit() != null) setConstructionUnit(b.getConstructionUnit());
		if(b.getArchitecturalDesignUnits() != null) setArchitecturalDesignUnits(b.getArchitecturalDesignUnits());
		if(b.getRateOfBidWinning() != null) setRateOfBidWinning(b.getRateOfBidWinning());
		if(b.getFollowUpDate() != null) setFollowUpDate(b.getFollowUpDate());
		if(b.getEquityedgeRemark() != null) setEquityedgeRemark(b.getEquityedgeRemark());
		if(b.getOrderSignUpTime() != null) setOrderSignUpTime(b.getOrderSignUpTime());
		if(b.getDesignServiceBook() != null) setDesignServiceBook(b.getDesignServiceBook());
		if(b.getServiceSuggestBook() != null) setServiceSuggestBook(b.getServiceSuggestBook());
		if(b.getTotalMoney() != null) setTotalMoney(b.getTotalMoney());
		if(b.getCoveredArea() != null) setCoveredArea(b.getCoveredArea());
		if(b.getDesignArea() != null) setDesignArea(b.getDesignArea());
		if(b.getHasFormalContracts() != null) setHasFormalContracts(b.getHasFormalContracts());
		if(b.getHasOutQuotations() != null) setHasOutQuotations(b.getHasOutQuotations());
		if(b.getSpecialty() != null) setSpecialty(b.getSpecialty());
		if(b.getProjectSalesTeam() != null) setProjectSalesTeam(b.getProjectSalesTeam());
		if(b.getHasSplitPrice() != null) setHasSplitPrice(b.getHasSplitPrice());
		if(b.getHasOrderRelease() != null) setHasOrderRelease(b.getHasOrderRelease());
		if(b.getHasDeposit() != null) setHasDeposit(b.getHasDeposit());
		if(b.getHasRateOfPayment() != null) setHasRateOfPayment(b.getHasRateOfPayment());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getSerialNumber() != null) setSerialNumber(b.getSerialNumber());
		if(b.getHasFormalContractTime() != null) setHasFormalContractTime(b.getHasFormalContractTime());
		if(b.getHasOutQuotationTime() != null) setHasOutQuotationTime(b.getHasOutQuotationTime());
		if(b.getHasOrderReleaseTime() != null) setHasOrderReleaseTime(b.getHasOrderReleaseTime());
		if(b.getHasSplitPriceTime() != null) setHasSplitPriceTime(b.getHasSplitPriceTime());
		if(b.getBidType() != null) setBidType(b.getBidType());
		if(b.getBidDate() != null) setBidDate(b.getBidDate());
		if(b.getBidClassType() != null) setBidClassType(b.getBidClassType());
		if(b.getBidUnitNum() != null) setBidUnitNum(b.getBidUnitNum());
		if(b.getOurOrder() != null) setOurOrder(b.getOurOrder());
		if(b.getBigPayAmount() != null) setBigPayAmount(b.getBigPayAmount());
		if(b.getBigIsAchieveAmount() != null) setBigIsAchieveAmount(b.getBigIsAchieveAmount());
		if(b.getBigAdvanceAmount() != null) setBigAdvanceAmount(b.getBigAdvanceAmount());
		if(b.getClientId() != null) setClientId(b.getClientId());
		if(b.getContactName() != null) setContactName(b.getContactName());
		if(b.getContactPhone() != null) setContactPhone(b.getContactPhone());
		if(b.getApplyEmployeeId() != null) setApplyEmployeeId(b.getApplyEmployeeId());
		if(b.getCustomerContactId() != null) setCustomerContactId(b.getCustomerContactId());
		if(b.getArchitecturalDesignUnitId() != null) setArchitecturalDesignUnitId(b.getArchitecturalDesignUnitId());
		if(b.getArchitecturalDesignUnitContactId() != null) setArchitecturalDesignUnitContactId(b.getArchitecturalDesignUnitContactId());
		if(b.getRegion() != null) setRegion(b.getRegion());
		if(b.getComparisonForm() != null) setComparisonForm(b.getComparisonForm());
		if(b.getIsOriginal() != null) setIsOriginal(b.getIsOriginal());
		if(b.getIsSubProject() != null) setIsSubProject(b.getIsSubProject());
		if(b.getContractStatus() != null) setContractStatus(b.getContractStatus());
		if(b.getIsPubliclyBidding() != null) setIsPubliclyBidding(b.getIsPubliclyBidding());
		if(b.getHaveAgents() != null) setHaveAgents(b.getHaveAgents());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getCompanyNo() != null) setCompanyNo(b.getCompanyNo());
		if(b.getPercent() != null) setPercent(b.getPercent());
		if(b.getOwnerTypeId() != null) setOwnerTypeId(b.getOwnerTypeId());
		if(b.getEstimatePrice() != null) setEstimatePrice(b.getEstimatePrice());
		if(b.getProjectPhase() != null) setProjectPhase(b.getProjectPhase());
		if(b.getProjectAttribute() != null) setProjectAttribute(b.getProjectAttribute());
		if(b.getProjectNameOne() != null) setProjectNameOne(b.getProjectNameOne());
		if(b.getWinningTime() != null) setWinningTime(b.getWinningTime());
		if(b.getProjectOutputValue() != null) setProjectOutputValue(b.getProjectOutputValue());
		if(b.getMainProjectStageId() != null) setMainProjectStageId(b.getMainProjectStageId());
		if(b.getIsModifyProject() != null) setIsModifyProject(b.getIsModifyProject());
		if(b.getGrade() != null) setGrade(b.getGrade());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getProcessStatus() != null) setProcessStatus(b.getProcessStatus());
	}

	@Override
	public BaseMainProject generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProject b = new BaseMainProject();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProject __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectEnglishName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectStatus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignStatus(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSignCompany(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectOriginationRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignCooperationName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignCooperationEnglishName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsHighRiseBuilding(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoRegisterTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasContract(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectBaseOn(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectModel(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignQualification(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFireResistanceRating(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEstimateTheDesignAreas(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectTotalInvestment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setActualDesignAreas(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBuildingHeight(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBuildingFloors(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDecorateMoneyControl(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvince(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectEndTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBidProject(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setConstructionUnit(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setArchitecturalDesignUnits(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRateOfBidWinning(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFollowUpDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEquityedgeRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderSignUpTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignServiceBook(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setServiceSuggestBook(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCoveredArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasFormalContracts(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasOutQuotations(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSpecialty(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasSplitPrice(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasOrderRelease(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasDeposit(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasRateOfPayment(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasFormalContractTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasOutQuotationTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasOrderReleaseTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHasSplitPriceTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBidType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBidDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBidClassType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBidUnitNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOurOrder(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBigPayAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBigIsAchieveAmount(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBigAdvanceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContactPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setArchitecturalDesignUnitId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setArchitecturalDesignUnitContactId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRegion(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComparisonForm(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsPubliclyBidding(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveAgents(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOwnerTypeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEstimatePrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectPhase(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAttribute(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWinningTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectOutputValue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsModifyProject(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGrade(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProcessStatus(GenericBase.__getInt(val));
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectEnglishName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectEnglishName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectStatus(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProjectStatus() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDesignStatus(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getDesignStatus() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setSignCompany(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getSignCompany() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setProjectOrigination(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getProjectOrigination() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setProjectOriginationRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getProjectOriginationRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setDesignCooperationName(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getDesignCooperationName() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setDesignCooperationEnglishName(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getDesignCooperationEnglishName() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setDesignTeam(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getDesignTeam() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setIsHighRiseBuilding(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsHighRiseBuilding() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setInfoRegisterTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getInfoRegisterTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setProjectApprovalTime(java.util.Date val) {
		setCurrentData(14, generateTimestampFromDate(val));
	}

	public java.util.Date getProjectApprovalTime() {
		return GenericBase.__getDateFromSQL(__current_data[14]);
	}

	public void setHasContract(java.lang.Boolean val) {
		setCurrentData(15, val);
	}

	public java.lang.Boolean getHasContract() {
		return GenericBase.__getBoolean(__current_data[15]);
	}

	public void setProjectBaseOn(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getProjectBaseOn() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setProjectModel(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getProjectModel() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setDesignQualification(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getDesignQualification() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setBusinessType(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getBusinessType() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setFireResistanceRating(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getFireResistanceRating() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setEstimateTheDesignAreas(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getEstimateTheDesignAreas() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setProjectTotalInvestment(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getProjectTotalInvestment() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setActualDesignAreas(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getActualDesignAreas() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setTotalBuildingAreas(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getTotalBuildingAreas() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setBuildingHeight(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getBuildingHeight() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setBuildingFloors(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getBuildingFloors() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setDecorateMoneyControl(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getDecorateMoneyControl() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setProjectLevel(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getProjectLevel() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setProvince(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getProvince() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setCity(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getCity() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setDetailAddress(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getDetailAddress() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setProjectEndTime(java.util.Date val) {
		setCurrentData(33, generateTimestampFromDate(val));
	}

	public java.util.Date getProjectEndTime() {
		return GenericBase.__getDateFromSQL(__current_data[33]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(34, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[34]);
	}

	public void setCustomerName(java.lang.String val) {
		setCurrentData(35, val);
	}

	public java.lang.String getCustomerName() {
		return GenericBase.__getString(__current_data[35]);
	}

	public void setCustomerAddress(java.lang.String val) {
		setCurrentData(36, val);
	}

	public java.lang.String getCustomerAddress() {
		return GenericBase.__getString(__current_data[36]);
	}

	public void setBidProject(java.lang.String val) {
		setCurrentData(37, val);
	}

	public java.lang.String getBidProject() {
		return GenericBase.__getString(__current_data[37]);
	}

	public void setConstructionUnit(java.lang.String val) {
		setCurrentData(38, val);
	}

	public java.lang.String getConstructionUnit() {
		return GenericBase.__getString(__current_data[38]);
	}

	public void setArchitecturalDesignUnits(java.lang.String val) {
		setCurrentData(39, val);
	}

	public java.lang.String getArchitecturalDesignUnits() {
		return GenericBase.__getString(__current_data[39]);
	}

	public void setRateOfBidWinning(java.lang.String val) {
		setCurrentData(40, val);
	}

	public java.lang.String getRateOfBidWinning() {
		return GenericBase.__getString(__current_data[40]);
	}

	public void setFollowUpDate(java.util.Date val) {
		setCurrentData(41, generateTimestampFromDate(val));
	}

	public java.util.Date getFollowUpDate() {
		return GenericBase.__getDateFromSQL(__current_data[41]);
	}

	public void setEquityedgeRemark(java.lang.String val) {
		setCurrentData(42, val);
	}

	public java.lang.String getEquityedgeRemark() {
		return GenericBase.__getString(__current_data[42]);
	}

	public void setOrderSignUpTime(java.util.Date val) {
		setCurrentData(43, generateTimestampFromDate(val));
	}

	public java.util.Date getOrderSignUpTime() {
		return GenericBase.__getDateFromSQL(__current_data[43]);
	}

	public void setDesignServiceBook(java.lang.String val) {
		setCurrentData(44, val);
	}

	public java.lang.String getDesignServiceBook() {
		return GenericBase.__getString(__current_data[44]);
	}

	public void setServiceSuggestBook(java.lang.String val) {
		setCurrentData(45, val);
	}

	public java.lang.String getServiceSuggestBook() {
		return GenericBase.__getString(__current_data[45]);
	}

	public void setTotalMoney(java.math.BigDecimal val) {
		setCurrentData(46, val);
	}

	public java.math.BigDecimal getTotalMoney() {
		return GenericBase.__getDecimal(__current_data[46]);
	}

	public void setCoveredArea(java.math.BigDecimal val) {
		setCurrentData(47, val);
	}

	public java.math.BigDecimal getCoveredArea() {
		return GenericBase.__getDecimal(__current_data[47]);
	}

	public void setDesignArea(java.math.BigDecimal val) {
		setCurrentData(48, val);
	}

	public java.math.BigDecimal getDesignArea() {
		return GenericBase.__getDecimal(__current_data[48]);
	}

	public void setHasFormalContracts(java.lang.Boolean val) {
		setCurrentData(49, val);
	}

	public java.lang.Boolean getHasFormalContracts() {
		return GenericBase.__getBoolean(__current_data[49]);
	}

	public void setHasOutQuotations(java.lang.Boolean val) {
		setCurrentData(50, val);
	}

	public java.lang.Boolean getHasOutQuotations() {
		return GenericBase.__getBoolean(__current_data[50]);
	}

	public void setSpecialty(java.lang.String val) {
		setCurrentData(51, val);
	}

	public java.lang.String getSpecialty() {
		return GenericBase.__getString(__current_data[51]);
	}

	public void setProjectSalesTeam(java.lang.String val) {
		setCurrentData(52, val);
	}

	public java.lang.String getProjectSalesTeam() {
		return GenericBase.__getString(__current_data[52]);
	}

	public void setHasSplitPrice(java.lang.Boolean val) {
		setCurrentData(53, val);
	}

	public java.lang.Boolean getHasSplitPrice() {
		return GenericBase.__getBoolean(__current_data[53]);
	}

	public void setHasOrderRelease(java.lang.Boolean val) {
		setCurrentData(54, val);
	}

	public java.lang.Boolean getHasOrderRelease() {
		return GenericBase.__getBoolean(__current_data[54]);
	}

	public void setHasDeposit(java.lang.Boolean val) {
		setCurrentData(55, val);
	}

	public java.lang.Boolean getHasDeposit() {
		return GenericBase.__getBoolean(__current_data[55]);
	}

	public void setHasRateOfPayment(java.math.BigDecimal val) {
		setCurrentData(56, val);
	}

	public java.math.BigDecimal getHasRateOfPayment() {
		return GenericBase.__getDecimal(__current_data[56]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(57, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[57]);
	}

	public void setSerialNumber(java.lang.Integer val) {
		setCurrentData(58, val);
	}

	public java.lang.Integer getSerialNumber() {
		return GenericBase.__getInt(__current_data[58]);
	}

	public void setHasFormalContractTime(java.util.Date val) {
		setCurrentData(59, generateTimestampFromDate(val));
	}

	public java.util.Date getHasFormalContractTime() {
		return GenericBase.__getDateFromSQL(__current_data[59]);
	}

	public void setHasOutQuotationTime(java.util.Date val) {
		setCurrentData(60, generateTimestampFromDate(val));
	}

	public java.util.Date getHasOutQuotationTime() {
		return GenericBase.__getDateFromSQL(__current_data[60]);
	}

	public void setHasOrderReleaseTime(java.util.Date val) {
		setCurrentData(61, generateTimestampFromDate(val));
	}

	public java.util.Date getHasOrderReleaseTime() {
		return GenericBase.__getDateFromSQL(__current_data[61]);
	}

	public void setHasSplitPriceTime(java.util.Date val) {
		setCurrentData(62, generateTimestampFromDate(val));
	}

	public java.util.Date getHasSplitPriceTime() {
		return GenericBase.__getDateFromSQL(__current_data[62]);
	}

	public void setBidType(java.lang.Integer val) {
		setCurrentData(63, val);
	}

	public java.lang.Integer getBidType() {
		return GenericBase.__getInt(__current_data[63]);
	}

	public void setBidDate(java.util.Date val) {
		setCurrentData(64, generateTimestampFromDate(val));
	}

	public java.util.Date getBidDate() {
		return GenericBase.__getDateFromSQL(__current_data[64]);
	}

	public void setBidClassType(java.lang.Integer val) {
		setCurrentData(65, val);
	}

	public java.lang.Integer getBidClassType() {
		return GenericBase.__getInt(__current_data[65]);
	}

	public void setBidUnitNum(java.lang.Integer val) {
		setCurrentData(66, val);
	}

	public java.lang.Integer getBidUnitNum() {
		return GenericBase.__getInt(__current_data[66]);
	}

	public void setOurOrder(java.lang.String val) {
		setCurrentData(67, val);
	}

	public java.lang.String getOurOrder() {
		return GenericBase.__getString(__current_data[67]);
	}

	public void setBigPayAmount(java.math.BigDecimal val) {
		setCurrentData(68, val);
	}

	public java.math.BigDecimal getBigPayAmount() {
		return GenericBase.__getDecimal(__current_data[68]);
	}

	public void setBigIsAchieveAmount(java.lang.Boolean val) {
		setCurrentData(69, val);
	}

	public java.lang.Boolean getBigIsAchieveAmount() {
		return GenericBase.__getBoolean(__current_data[69]);
	}

	public void setBigAdvanceAmount(java.math.BigDecimal val) {
		setCurrentData(70, val);
	}

	public java.math.BigDecimal getBigAdvanceAmount() {
		return GenericBase.__getDecimal(__current_data[70]);
	}

	public void setClientId(java.lang.Integer val) {
		setCurrentData(71, val);
	}

	public java.lang.Integer getClientId() {
		return GenericBase.__getInt(__current_data[71]);
	}

	public void setContactName(java.lang.String val) {
		setCurrentData(72, val);
	}

	public java.lang.String getContactName() {
		return GenericBase.__getString(__current_data[72]);
	}

	public void setContactPhone(java.lang.String val) {
		setCurrentData(73, val);
	}

	public java.lang.String getContactPhone() {
		return GenericBase.__getString(__current_data[73]);
	}

	public void setApplyEmployeeId(java.lang.Integer val) {
		setCurrentData(74, val);
	}

	public java.lang.Integer getApplyEmployeeId() {
		return GenericBase.__getInt(__current_data[74]);
	}

	public void setCustomerContactId(java.lang.Integer val) {
		setCurrentData(75, val);
	}

	public java.lang.Integer getCustomerContactId() {
		return GenericBase.__getInt(__current_data[75]);
	}

	public void setArchitecturalDesignUnitId(java.lang.Integer val) {
		setCurrentData(76, val);
	}

	public java.lang.Integer getArchitecturalDesignUnitId() {
		return GenericBase.__getInt(__current_data[76]);
	}

	public void setArchitecturalDesignUnitContactId(java.lang.Integer val) {
		setCurrentData(77, val);
	}

	public java.lang.Integer getArchitecturalDesignUnitContactId() {
		return GenericBase.__getInt(__current_data[77]);
	}

	public void setRegion(java.lang.Integer val) {
		setCurrentData(78, val);
	}

	public java.lang.Integer getRegion() {
		return GenericBase.__getInt(__current_data[78]);
	}

	public void setComparisonForm(java.lang.Integer val) {
		setCurrentData(79, val);
	}

	public java.lang.Integer getComparisonForm() {
		return GenericBase.__getInt(__current_data[79]);
	}

	public void setIsOriginal(java.lang.Boolean val) {
		setCurrentData(80, val);
	}

	public java.lang.Boolean getIsOriginal() {
		return GenericBase.__getBoolean(__current_data[80]);
	}

	public void setIsSubProject(java.lang.Boolean val) {
		setCurrentData(81, val);
	}

	public java.lang.Boolean getIsSubProject() {
		return GenericBase.__getBoolean(__current_data[81]);
	}

	public void setContractStatus(java.lang.Integer val) {
		setCurrentData(82, val);
	}

	public java.lang.Integer getContractStatus() {
		return GenericBase.__getInt(__current_data[82]);
	}

	public void setIsPubliclyBidding(java.lang.Boolean val) {
		setCurrentData(83, val);
	}

	public java.lang.Boolean getIsPubliclyBidding() {
		return GenericBase.__getBoolean(__current_data[83]);
	}

	public void setHaveAgents(java.lang.Boolean val) {
		setCurrentData(84, val);
	}

	public java.lang.Boolean getHaveAgents() {
		return GenericBase.__getBoolean(__current_data[84]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(85, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[85]);
	}

	public void setCompanyNo(java.lang.String val) {
		setCurrentData(86, val);
	}

	public java.lang.String getCompanyNo() {
		return GenericBase.__getString(__current_data[86]);
	}

	public void setPercent(java.math.BigDecimal val) {
		setCurrentData(87, val);
	}

	public java.math.BigDecimal getPercent() {
		return GenericBase.__getDecimal(__current_data[87]);
	}

	public void setOwnerTypeId(java.lang.Integer val) {
		setCurrentData(88, val);
	}

	public java.lang.Integer getOwnerTypeId() {
		return GenericBase.__getInt(__current_data[88]);
	}

	public void setEstimatePrice(java.math.BigDecimal val) {
		setCurrentData(89, val);
	}

	public java.math.BigDecimal getEstimatePrice() {
		return GenericBase.__getDecimal(__current_data[89]);
	}

	public void setProjectPhase(java.lang.Integer val) {
		setCurrentData(90, val);
	}

	public java.lang.Integer getProjectPhase() {
		return GenericBase.__getInt(__current_data[90]);
	}

	public void setProjectAttribute(java.lang.Integer val) {
		setCurrentData(91, val);
	}

	public java.lang.Integer getProjectAttribute() {
		return GenericBase.__getInt(__current_data[91]);
	}

	public void setProjectNameOne(java.lang.String val) {
		setCurrentData(92, val);
	}

	public java.lang.String getProjectNameOne() {
		return GenericBase.__getString(__current_data[92]);
	}

	public void setWinningTime(java.util.Date val) {
		setCurrentData(93, generateTimestampFromDate(val));
	}

	public java.util.Date getWinningTime() {
		return GenericBase.__getDateFromSQL(__current_data[93]);
	}

	public void setProjectOutputValue(java.math.BigDecimal val) {
		setCurrentData(94, val);
	}

	public java.math.BigDecimal getProjectOutputValue() {
		return GenericBase.__getDecimal(__current_data[94]);
	}

	public void setMainProjectStageId(java.lang.Integer val) {
		setCurrentData(95, val);
	}

	public java.lang.Integer getMainProjectStageId() {
		return GenericBase.__getInt(__current_data[95]);
	}

	public void setIsModifyProject(java.lang.Boolean val) {
		setCurrentData(96, val);
	}

	public java.lang.Boolean getIsModifyProject() {
		return GenericBase.__getBoolean(__current_data[96]);
	}

	public void setGrade(java.lang.String val) {
		setCurrentData(97, val);
	}

	public java.lang.String getGrade() {
		return GenericBase.__getString(__current_data[97]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(98, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[98]);
	}

	public void setProcessStatus(java.lang.Integer val) {
		setCurrentData(99, val);
	}

	public java.lang.Integer getProcessStatus() {
		return GenericBase.__getInt(__current_data[99]);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[0] = val;
	}

	public void setMainProjectIdExpression(String val) {
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

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[2] = val;
	}

	public void setProjectNameExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionProjectEnglishName(String op, java.lang.String val) {
		setConditionProjectEnglishName(op, val, CONDITION_AND);
	}

	public void setConditionProjectEnglishName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectEnglishName(boolean val) {
		__select_flags[3] = val;
	}

	public void setProjectEnglishNameExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionProjectStatus(String op, java.lang.String val) {
		setConditionProjectStatus(op, val, CONDITION_AND);
	}

	public void setConditionProjectStatus(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectStatus(boolean val) {
		__select_flags[4] = val;
	}

	public void setProjectStatusExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionDesignStatus(String op, java.lang.String val) {
		setConditionDesignStatus(op, val, CONDITION_AND);
	}

	public void setConditionDesignStatus(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDesignStatus(boolean val) {
		__select_flags[5] = val;
	}

	public void setDesignStatusExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionSignCompany(String op, java.lang.Integer val) {
		setConditionSignCompany(op, val, CONDITION_AND);
	}

	public void setConditionSignCompany(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSignCompany(boolean val) {
		__select_flags[6] = val;
	}

	public void setSignCompanyExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionProjectOrigination(String op, java.lang.String val) {
		setConditionProjectOrigination(op, val, CONDITION_AND);
	}

	public void setConditionProjectOrigination(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProjectOrigination(boolean val) {
		__select_flags[7] = val;
	}

	public void setProjectOriginationExpression(String val) {
		__dataExpressions[7] = val;
	}

	public void setConditionProjectOriginationRemark(String op, java.lang.String val) {
		setConditionProjectOriginationRemark(op, val, CONDITION_AND);
	}

	public void setConditionProjectOriginationRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProjectOriginationRemark(boolean val) {
		__select_flags[8] = val;
	}

	public void setProjectOriginationRemarkExpression(String val) {
		__dataExpressions[8] = val;
	}

	public void setConditionDesignCooperationName(String op, java.lang.String val) {
		setConditionDesignCooperationName(op, val, CONDITION_AND);
	}

	public void setConditionDesignCooperationName(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectDesignCooperationName(boolean val) {
		__select_flags[9] = val;
	}

	public void setDesignCooperationNameExpression(String val) {
		__dataExpressions[9] = val;
	}

	public void setConditionDesignCooperationEnglishName(String op, java.lang.String val) {
		setConditionDesignCooperationEnglishName(op, val, CONDITION_AND);
	}

	public void setConditionDesignCooperationEnglishName(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectDesignCooperationEnglishName(boolean val) {
		__select_flags[10] = val;
	}

	public void setDesignCooperationEnglishNameExpression(String val) {
		__dataExpressions[10] = val;
	}

	public void setConditionDesignTeam(String op, java.lang.Integer val) {
		setConditionDesignTeam(op, val, CONDITION_AND);
	}

	public void setConditionDesignTeam(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectDesignTeam(boolean val) {
		__select_flags[11] = val;
	}

	public void setDesignTeamExpression(String val) {
		__dataExpressions[11] = val;
	}

	public void setConditionIsHighRiseBuilding(String op, java.lang.Boolean val) {
		setConditionIsHighRiseBuilding(op, val, CONDITION_AND);
	}

	public void setConditionIsHighRiseBuilding(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsHighRiseBuilding(boolean val) {
		__select_flags[12] = val;
	}

	public void setIsHighRiseBuildingExpression(String val) {
		__dataExpressions[12] = val;
	}

	public void setConditionInfoRegisterTime(String op, java.util.Date val) {
		setConditionInfoRegisterTime(op, val, CONDITION_AND);
	}

	public void setConditionInfoRegisterTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectInfoRegisterTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setInfoRegisterTimeExpression(String val) {
		__dataExpressions[13] = val;
	}

	public void setConditionProjectApprovalTime(String op, java.util.Date val) {
		setConditionProjectApprovalTime(op, val, CONDITION_AND);
	}

	public void setConditionProjectApprovalTime(String op, java.util.Date val, String relation) {
		addCondition(14, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectProjectApprovalTime(boolean val) {
		__select_flags[14] = val;
	}

	public void setProjectApprovalTimeExpression(String val) {
		__dataExpressions[14] = val;
	}

	public void setConditionHasContract(String op, java.lang.Boolean val) {
		setConditionHasContract(op, val, CONDITION_AND);
	}

	public void setConditionHasContract(String op, java.lang.Boolean val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectHasContract(boolean val) {
		__select_flags[15] = val;
	}

	public void setHasContractExpression(String val) {
		__dataExpressions[15] = val;
	}

	public void setConditionProjectBaseOn(String op, java.lang.Integer val) {
		setConditionProjectBaseOn(op, val, CONDITION_AND);
	}

	public void setConditionProjectBaseOn(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectProjectBaseOn(boolean val) {
		__select_flags[16] = val;
	}

	public void setProjectBaseOnExpression(String val) {
		__dataExpressions[16] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[17] = val;
	}

	public void setInfoCodeExpression(String val) {
		__dataExpressions[17] = val;
	}

	public void setConditionProjectModel(String op, java.lang.String val) {
		setConditionProjectModel(op, val, CONDITION_AND);
	}

	public void setConditionProjectModel(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectProjectModel(boolean val) {
		__select_flags[18] = val;
	}

	public void setProjectModelExpression(String val) {
		__dataExpressions[18] = val;
	}

	public void setConditionDesignQualification(String op, java.lang.String val) {
		setConditionDesignQualification(op, val, CONDITION_AND);
	}

	public void setConditionDesignQualification(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectDesignQualification(boolean val) {
		__select_flags[19] = val;
	}

	public void setDesignQualificationExpression(String val) {
		__dataExpressions[19] = val;
	}

	public void setConditionBusinessType(String op, java.lang.String val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[20] = val;
	}

	public void setBusinessTypeExpression(String val) {
		__dataExpressions[20] = val;
	}

	public void setConditionFireResistanceRating(String op, java.lang.String val) {
		setConditionFireResistanceRating(op, val, CONDITION_AND);
	}

	public void setConditionFireResistanceRating(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectFireResistanceRating(boolean val) {
		__select_flags[21] = val;
	}

	public void setFireResistanceRatingExpression(String val) {
		__dataExpressions[21] = val;
	}

	public void setConditionEstimateTheDesignAreas(String op, java.lang.String val) {
		setConditionEstimateTheDesignAreas(op, val, CONDITION_AND);
	}

	public void setConditionEstimateTheDesignAreas(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectEstimateTheDesignAreas(boolean val) {
		__select_flags[22] = val;
	}

	public void setEstimateTheDesignAreasExpression(String val) {
		__dataExpressions[22] = val;
	}

	public void setConditionProjectTotalInvestment(String op, java.lang.String val) {
		setConditionProjectTotalInvestment(op, val, CONDITION_AND);
	}

	public void setConditionProjectTotalInvestment(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectProjectTotalInvestment(boolean val) {
		__select_flags[23] = val;
	}

	public void setProjectTotalInvestmentExpression(String val) {
		__dataExpressions[23] = val;
	}

	public void setConditionActualDesignAreas(String op, java.lang.String val) {
		setConditionActualDesignAreas(op, val, CONDITION_AND);
	}

	public void setConditionActualDesignAreas(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectActualDesignAreas(boolean val) {
		__select_flags[24] = val;
	}

	public void setActualDesignAreasExpression(String val) {
		__dataExpressions[24] = val;
	}

	public void setConditionTotalBuildingAreas(String op, java.lang.String val) {
		setConditionTotalBuildingAreas(op, val, CONDITION_AND);
	}

	public void setConditionTotalBuildingAreas(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectTotalBuildingAreas(boolean val) {
		__select_flags[25] = val;
	}

	public void setTotalBuildingAreasExpression(String val) {
		__dataExpressions[25] = val;
	}

	public void setConditionBuildingHeight(String op, java.lang.String val) {
		setConditionBuildingHeight(op, val, CONDITION_AND);
	}

	public void setConditionBuildingHeight(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectBuildingHeight(boolean val) {
		__select_flags[26] = val;
	}

	public void setBuildingHeightExpression(String val) {
		__dataExpressions[26] = val;
	}

	public void setConditionBuildingFloors(String op, java.lang.String val) {
		setConditionBuildingFloors(op, val, CONDITION_AND);
	}

	public void setConditionBuildingFloors(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectBuildingFloors(boolean val) {
		__select_flags[27] = val;
	}

	public void setBuildingFloorsExpression(String val) {
		__dataExpressions[27] = val;
	}

	public void setConditionDecorateMoneyControl(String op, java.lang.String val) {
		setConditionDecorateMoneyControl(op, val, CONDITION_AND);
	}

	public void setConditionDecorateMoneyControl(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectDecorateMoneyControl(boolean val) {
		__select_flags[28] = val;
	}

	public void setDecorateMoneyControlExpression(String val) {
		__dataExpressions[28] = val;
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val) {
		setConditionProjectLevel(op, val, CONDITION_AND);
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectProjectLevel(boolean val) {
		__select_flags[29] = val;
	}

	public void setProjectLevelExpression(String val) {
		__dataExpressions[29] = val;
	}

	public void setConditionProvince(String op, java.lang.String val) {
		setConditionProvince(op, val, CONDITION_AND);
	}

	public void setConditionProvince(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectProvince(boolean val) {
		__select_flags[30] = val;
	}

	public void setProvinceExpression(String val) {
		__dataExpressions[30] = val;
	}

	public void setConditionCity(String op, java.lang.String val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[31] = val;
	}

	public void setCityExpression(String val) {
		__dataExpressions[31] = val;
	}

	public void setConditionDetailAddress(String op, java.lang.String val) {
		setConditionDetailAddress(op, val, CONDITION_AND);
	}

	public void setConditionDetailAddress(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectDetailAddress(boolean val) {
		__select_flags[32] = val;
	}

	public void setDetailAddressExpression(String val) {
		__dataExpressions[32] = val;
	}

	public void setConditionProjectEndTime(String op, java.util.Date val) {
		setConditionProjectEndTime(op, val, CONDITION_AND);
	}

	public void setConditionProjectEndTime(String op, java.util.Date val, String relation) {
		addCondition(33, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectProjectEndTime(boolean val) {
		__select_flags[33] = val;
	}

	public void setProjectEndTimeExpression(String val) {
		__dataExpressions[33] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[34] = val;
	}

	public void setProjectTypeExpression(String val) {
		__dataExpressions[34] = val;
	}

	public void setConditionCustomerName(String op, java.lang.String val) {
		setConditionCustomerName(op, val, CONDITION_AND);
	}

	public void setConditionCustomerName(String op, java.lang.String val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectCustomerName(boolean val) {
		__select_flags[35] = val;
	}

	public void setCustomerNameExpression(String val) {
		__dataExpressions[35] = val;
	}

	public void setConditionCustomerAddress(String op, java.lang.String val) {
		setConditionCustomerAddress(op, val, CONDITION_AND);
	}

	public void setConditionCustomerAddress(String op, java.lang.String val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectCustomerAddress(boolean val) {
		__select_flags[36] = val;
	}

	public void setCustomerAddressExpression(String val) {
		__dataExpressions[36] = val;
	}

	public void setConditionBidProject(String op, java.lang.String val) {
		setConditionBidProject(op, val, CONDITION_AND);
	}

	public void setConditionBidProject(String op, java.lang.String val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectBidProject(boolean val) {
		__select_flags[37] = val;
	}

	public void setBidProjectExpression(String val) {
		__dataExpressions[37] = val;
	}

	public void setConditionConstructionUnit(String op, java.lang.String val) {
		setConditionConstructionUnit(op, val, CONDITION_AND);
	}

	public void setConditionConstructionUnit(String op, java.lang.String val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectConstructionUnit(boolean val) {
		__select_flags[38] = val;
	}

	public void setConstructionUnitExpression(String val) {
		__dataExpressions[38] = val;
	}

	public void setConditionArchitecturalDesignUnits(String op, java.lang.String val) {
		setConditionArchitecturalDesignUnits(op, val, CONDITION_AND);
	}

	public void setConditionArchitecturalDesignUnits(String op, java.lang.String val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectArchitecturalDesignUnits(boolean val) {
		__select_flags[39] = val;
	}

	public void setArchitecturalDesignUnitsExpression(String val) {
		__dataExpressions[39] = val;
	}

	public void setConditionRateOfBidWinning(String op, java.lang.String val) {
		setConditionRateOfBidWinning(op, val, CONDITION_AND);
	}

	public void setConditionRateOfBidWinning(String op, java.lang.String val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectRateOfBidWinning(boolean val) {
		__select_flags[40] = val;
	}

	public void setRateOfBidWinningExpression(String val) {
		__dataExpressions[40] = val;
	}

	public void setConditionFollowUpDate(String op, java.util.Date val) {
		setConditionFollowUpDate(op, val, CONDITION_AND);
	}

	public void setConditionFollowUpDate(String op, java.util.Date val, String relation) {
		addCondition(41, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectFollowUpDate(boolean val) {
		__select_flags[41] = val;
	}

	public void setFollowUpDateExpression(String val) {
		__dataExpressions[41] = val;
	}

	public void setConditionEquityedgeRemark(String op, java.lang.String val) {
		setConditionEquityedgeRemark(op, val, CONDITION_AND);
	}

	public void setConditionEquityedgeRemark(String op, java.lang.String val, String relation) {
		addCondition(42, op, relation, val);
	}

	public void setSelectEquityedgeRemark(boolean val) {
		__select_flags[42] = val;
	}

	public void setEquityedgeRemarkExpression(String val) {
		__dataExpressions[42] = val;
	}

	public void setConditionOrderSignUpTime(String op, java.util.Date val) {
		setConditionOrderSignUpTime(op, val, CONDITION_AND);
	}

	public void setConditionOrderSignUpTime(String op, java.util.Date val, String relation) {
		addCondition(43, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOrderSignUpTime(boolean val) {
		__select_flags[43] = val;
	}

	public void setOrderSignUpTimeExpression(String val) {
		__dataExpressions[43] = val;
	}

	public void setConditionDesignServiceBook(String op, java.lang.String val) {
		setConditionDesignServiceBook(op, val, CONDITION_AND);
	}

	public void setConditionDesignServiceBook(String op, java.lang.String val, String relation) {
		addCondition(44, op, relation, val);
	}

	public void setSelectDesignServiceBook(boolean val) {
		__select_flags[44] = val;
	}

	public void setDesignServiceBookExpression(String val) {
		__dataExpressions[44] = val;
	}

	public void setConditionServiceSuggestBook(String op, java.lang.String val) {
		setConditionServiceSuggestBook(op, val, CONDITION_AND);
	}

	public void setConditionServiceSuggestBook(String op, java.lang.String val, String relation) {
		addCondition(45, op, relation, val);
	}

	public void setSelectServiceSuggestBook(boolean val) {
		__select_flags[45] = val;
	}

	public void setServiceSuggestBookExpression(String val) {
		__dataExpressions[45] = val;
	}

	public void setConditionTotalMoney(String op, java.math.BigDecimal val) {
		setConditionTotalMoney(op, val, CONDITION_AND);
	}

	public void setConditionTotalMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(46, op, relation, val);
	}

	public void setSelectTotalMoney(boolean val) {
		__select_flags[46] = val;
	}

	public void setTotalMoneyExpression(String val) {
		__dataExpressions[46] = val;
	}

	public void setConditionCoveredArea(String op, java.math.BigDecimal val) {
		setConditionCoveredArea(op, val, CONDITION_AND);
	}

	public void setConditionCoveredArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(47, op, relation, val);
	}

	public void setSelectCoveredArea(boolean val) {
		__select_flags[47] = val;
	}

	public void setCoveredAreaExpression(String val) {
		__dataExpressions[47] = val;
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val) {
		setConditionDesignArea(op, val, CONDITION_AND);
	}

	public void setConditionDesignArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(48, op, relation, val);
	}

	public void setSelectDesignArea(boolean val) {
		__select_flags[48] = val;
	}

	public void setDesignAreaExpression(String val) {
		__dataExpressions[48] = val;
	}

	public void setConditionHasFormalContracts(String op, java.lang.Boolean val) {
		setConditionHasFormalContracts(op, val, CONDITION_AND);
	}

	public void setConditionHasFormalContracts(String op, java.lang.Boolean val, String relation) {
		addCondition(49, op, relation, val);
	}

	public void setSelectHasFormalContracts(boolean val) {
		__select_flags[49] = val;
	}

	public void setHasFormalContractsExpression(String val) {
		__dataExpressions[49] = val;
	}

	public void setConditionHasOutQuotations(String op, java.lang.Boolean val) {
		setConditionHasOutQuotations(op, val, CONDITION_AND);
	}

	public void setConditionHasOutQuotations(String op, java.lang.Boolean val, String relation) {
		addCondition(50, op, relation, val);
	}

	public void setSelectHasOutQuotations(boolean val) {
		__select_flags[50] = val;
	}

	public void setHasOutQuotationsExpression(String val) {
		__dataExpressions[50] = val;
	}

	public void setConditionSpecialty(String op, java.lang.String val) {
		setConditionSpecialty(op, val, CONDITION_AND);
	}

	public void setConditionSpecialty(String op, java.lang.String val, String relation) {
		addCondition(51, op, relation, val);
	}

	public void setSelectSpecialty(boolean val) {
		__select_flags[51] = val;
	}

	public void setSpecialtyExpression(String val) {
		__dataExpressions[51] = val;
	}

	public void setConditionProjectSalesTeam(String op, java.lang.String val) {
		setConditionProjectSalesTeam(op, val, CONDITION_AND);
	}

	public void setConditionProjectSalesTeam(String op, java.lang.String val, String relation) {
		addCondition(52, op, relation, val);
	}

	public void setSelectProjectSalesTeam(boolean val) {
		__select_flags[52] = val;
	}

	public void setProjectSalesTeamExpression(String val) {
		__dataExpressions[52] = val;
	}

	public void setConditionHasSplitPrice(String op, java.lang.Boolean val) {
		setConditionHasSplitPrice(op, val, CONDITION_AND);
	}

	public void setConditionHasSplitPrice(String op, java.lang.Boolean val, String relation) {
		addCondition(53, op, relation, val);
	}

	public void setSelectHasSplitPrice(boolean val) {
		__select_flags[53] = val;
	}

	public void setHasSplitPriceExpression(String val) {
		__dataExpressions[53] = val;
	}

	public void setConditionHasOrderRelease(String op, java.lang.Boolean val) {
		setConditionHasOrderRelease(op, val, CONDITION_AND);
	}

	public void setConditionHasOrderRelease(String op, java.lang.Boolean val, String relation) {
		addCondition(54, op, relation, val);
	}

	public void setSelectHasOrderRelease(boolean val) {
		__select_flags[54] = val;
	}

	public void setHasOrderReleaseExpression(String val) {
		__dataExpressions[54] = val;
	}

	public void setConditionHasDeposit(String op, java.lang.Boolean val) {
		setConditionHasDeposit(op, val, CONDITION_AND);
	}

	public void setConditionHasDeposit(String op, java.lang.Boolean val, String relation) {
		addCondition(55, op, relation, val);
	}

	public void setSelectHasDeposit(boolean val) {
		__select_flags[55] = val;
	}

	public void setHasDepositExpression(String val) {
		__dataExpressions[55] = val;
	}

	public void setConditionHasRateOfPayment(String op, java.math.BigDecimal val) {
		setConditionHasRateOfPayment(op, val, CONDITION_AND);
	}

	public void setConditionHasRateOfPayment(String op, java.math.BigDecimal val, String relation) {
		addCondition(56, op, relation, val);
	}

	public void setSelectHasRateOfPayment(boolean val) {
		__select_flags[56] = val;
	}

	public void setHasRateOfPaymentExpression(String val) {
		__dataExpressions[56] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(57, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[57] = val;
	}

	public void setParentIdExpression(String val) {
		__dataExpressions[57] = val;
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val) {
		setConditionSerialNumber(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val, String relation) {
		addCondition(58, op, relation, val);
	}

	public void setSelectSerialNumber(boolean val) {
		__select_flags[58] = val;
	}

	public void setSerialNumberExpression(String val) {
		__dataExpressions[58] = val;
	}

	public void setConditionHasFormalContractTime(String op, java.util.Date val) {
		setConditionHasFormalContractTime(op, val, CONDITION_AND);
	}

	public void setConditionHasFormalContractTime(String op, java.util.Date val, String relation) {
		addCondition(59, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHasFormalContractTime(boolean val) {
		__select_flags[59] = val;
	}

	public void setHasFormalContractTimeExpression(String val) {
		__dataExpressions[59] = val;
	}

	public void setConditionHasOutQuotationTime(String op, java.util.Date val) {
		setConditionHasOutQuotationTime(op, val, CONDITION_AND);
	}

	public void setConditionHasOutQuotationTime(String op, java.util.Date val, String relation) {
		addCondition(60, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHasOutQuotationTime(boolean val) {
		__select_flags[60] = val;
	}

	public void setHasOutQuotationTimeExpression(String val) {
		__dataExpressions[60] = val;
	}

	public void setConditionHasOrderReleaseTime(String op, java.util.Date val) {
		setConditionHasOrderReleaseTime(op, val, CONDITION_AND);
	}

	public void setConditionHasOrderReleaseTime(String op, java.util.Date val, String relation) {
		addCondition(61, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHasOrderReleaseTime(boolean val) {
		__select_flags[61] = val;
	}

	public void setHasOrderReleaseTimeExpression(String val) {
		__dataExpressions[61] = val;
	}

	public void setConditionHasSplitPriceTime(String op, java.util.Date val) {
		setConditionHasSplitPriceTime(op, val, CONDITION_AND);
	}

	public void setConditionHasSplitPriceTime(String op, java.util.Date val, String relation) {
		addCondition(62, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectHasSplitPriceTime(boolean val) {
		__select_flags[62] = val;
	}

	public void setHasSplitPriceTimeExpression(String val) {
		__dataExpressions[62] = val;
	}

	public void setConditionBidType(String op, java.lang.Integer val) {
		setConditionBidType(op, val, CONDITION_AND);
	}

	public void setConditionBidType(String op, java.lang.Integer val, String relation) {
		addCondition(63, op, relation, val);
	}

	public void setSelectBidType(boolean val) {
		__select_flags[63] = val;
	}

	public void setBidTypeExpression(String val) {
		__dataExpressions[63] = val;
	}

	public void setConditionBidDate(String op, java.util.Date val) {
		setConditionBidDate(op, val, CONDITION_AND);
	}

	public void setConditionBidDate(String op, java.util.Date val, String relation) {
		addCondition(64, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBidDate(boolean val) {
		__select_flags[64] = val;
	}

	public void setBidDateExpression(String val) {
		__dataExpressions[64] = val;
	}

	public void setConditionBidClassType(String op, java.lang.Integer val) {
		setConditionBidClassType(op, val, CONDITION_AND);
	}

	public void setConditionBidClassType(String op, java.lang.Integer val, String relation) {
		addCondition(65, op, relation, val);
	}

	public void setSelectBidClassType(boolean val) {
		__select_flags[65] = val;
	}

	public void setBidClassTypeExpression(String val) {
		__dataExpressions[65] = val;
	}

	public void setConditionBidUnitNum(String op, java.lang.Integer val) {
		setConditionBidUnitNum(op, val, CONDITION_AND);
	}

	public void setConditionBidUnitNum(String op, java.lang.Integer val, String relation) {
		addCondition(66, op, relation, val);
	}

	public void setSelectBidUnitNum(boolean val) {
		__select_flags[66] = val;
	}

	public void setBidUnitNumExpression(String val) {
		__dataExpressions[66] = val;
	}

	public void setConditionOurOrder(String op, java.lang.String val) {
		setConditionOurOrder(op, val, CONDITION_AND);
	}

	public void setConditionOurOrder(String op, java.lang.String val, String relation) {
		addCondition(67, op, relation, val);
	}

	public void setSelectOurOrder(boolean val) {
		__select_flags[67] = val;
	}

	public void setOurOrderExpression(String val) {
		__dataExpressions[67] = val;
	}

	public void setConditionBigPayAmount(String op, java.math.BigDecimal val) {
		setConditionBigPayAmount(op, val, CONDITION_AND);
	}

	public void setConditionBigPayAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(68, op, relation, val);
	}

	public void setSelectBigPayAmount(boolean val) {
		__select_flags[68] = val;
	}

	public void setBigPayAmountExpression(String val) {
		__dataExpressions[68] = val;
	}

	public void setConditionBigIsAchieveAmount(String op, java.lang.Boolean val) {
		setConditionBigIsAchieveAmount(op, val, CONDITION_AND);
	}

	public void setConditionBigIsAchieveAmount(String op, java.lang.Boolean val, String relation) {
		addCondition(69, op, relation, val);
	}

	public void setSelectBigIsAchieveAmount(boolean val) {
		__select_flags[69] = val;
	}

	public void setBigIsAchieveAmountExpression(String val) {
		__dataExpressions[69] = val;
	}

	public void setConditionBigAdvanceAmount(String op, java.math.BigDecimal val) {
		setConditionBigAdvanceAmount(op, val, CONDITION_AND);
	}

	public void setConditionBigAdvanceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(70, op, relation, val);
	}

	public void setSelectBigAdvanceAmount(boolean val) {
		__select_flags[70] = val;
	}

	public void setBigAdvanceAmountExpression(String val) {
		__dataExpressions[70] = val;
	}

	public void setConditionClientId(String op, java.lang.Integer val) {
		setConditionClientId(op, val, CONDITION_AND);
	}

	public void setConditionClientId(String op, java.lang.Integer val, String relation) {
		addCondition(71, op, relation, val);
	}

	public void setSelectClientId(boolean val) {
		__select_flags[71] = val;
	}

	public void setClientIdExpression(String val) {
		__dataExpressions[71] = val;
	}

	public void setConditionContactName(String op, java.lang.String val) {
		setConditionContactName(op, val, CONDITION_AND);
	}

	public void setConditionContactName(String op, java.lang.String val, String relation) {
		addCondition(72, op, relation, val);
	}

	public void setSelectContactName(boolean val) {
		__select_flags[72] = val;
	}

	public void setContactNameExpression(String val) {
		__dataExpressions[72] = val;
	}

	public void setConditionContactPhone(String op, java.lang.String val) {
		setConditionContactPhone(op, val, CONDITION_AND);
	}

	public void setConditionContactPhone(String op, java.lang.String val, String relation) {
		addCondition(73, op, relation, val);
	}

	public void setSelectContactPhone(boolean val) {
		__select_flags[73] = val;
	}

	public void setContactPhoneExpression(String val) {
		__dataExpressions[73] = val;
	}

	public void setConditionApplyEmployeeId(String op, java.lang.Integer val) {
		setConditionApplyEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionApplyEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(74, op, relation, val);
	}

	public void setSelectApplyEmployeeId(boolean val) {
		__select_flags[74] = val;
	}

	public void setApplyEmployeeIdExpression(String val) {
		__dataExpressions[74] = val;
	}

	public void setConditionCustomerContactId(String op, java.lang.Integer val) {
		setConditionCustomerContactId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerContactId(String op, java.lang.Integer val, String relation) {
		addCondition(75, op, relation, val);
	}

	public void setSelectCustomerContactId(boolean val) {
		__select_flags[75] = val;
	}

	public void setCustomerContactIdExpression(String val) {
		__dataExpressions[75] = val;
	}

	public void setConditionArchitecturalDesignUnitId(String op, java.lang.Integer val) {
		setConditionArchitecturalDesignUnitId(op, val, CONDITION_AND);
	}

	public void setConditionArchitecturalDesignUnitId(String op, java.lang.Integer val, String relation) {
		addCondition(76, op, relation, val);
	}

	public void setSelectArchitecturalDesignUnitId(boolean val) {
		__select_flags[76] = val;
	}

	public void setArchitecturalDesignUnitIdExpression(String val) {
		__dataExpressions[76] = val;
	}

	public void setConditionArchitecturalDesignUnitContactId(String op, java.lang.Integer val) {
		setConditionArchitecturalDesignUnitContactId(op, val, CONDITION_AND);
	}

	public void setConditionArchitecturalDesignUnitContactId(String op, java.lang.Integer val, String relation) {
		addCondition(77, op, relation, val);
	}

	public void setSelectArchitecturalDesignUnitContactId(boolean val) {
		__select_flags[77] = val;
	}

	public void setArchitecturalDesignUnitContactIdExpression(String val) {
		__dataExpressions[77] = val;
	}

	public void setConditionRegion(String op, java.lang.Integer val) {
		setConditionRegion(op, val, CONDITION_AND);
	}

	public void setConditionRegion(String op, java.lang.Integer val, String relation) {
		addCondition(78, op, relation, val);
	}

	public void setSelectRegion(boolean val) {
		__select_flags[78] = val;
	}

	public void setRegionExpression(String val) {
		__dataExpressions[78] = val;
	}

	public void setConditionComparisonForm(String op, java.lang.Integer val) {
		setConditionComparisonForm(op, val, CONDITION_AND);
	}

	public void setConditionComparisonForm(String op, java.lang.Integer val, String relation) {
		addCondition(79, op, relation, val);
	}

	public void setSelectComparisonForm(boolean val) {
		__select_flags[79] = val;
	}

	public void setComparisonFormExpression(String val) {
		__dataExpressions[79] = val;
	}

	public void setConditionIsOriginal(String op, java.lang.Boolean val) {
		setConditionIsOriginal(op, val, CONDITION_AND);
	}

	public void setConditionIsOriginal(String op, java.lang.Boolean val, String relation) {
		addCondition(80, op, relation, val);
	}

	public void setSelectIsOriginal(boolean val) {
		__select_flags[80] = val;
	}

	public void setIsOriginalExpression(String val) {
		__dataExpressions[80] = val;
	}

	public void setConditionIsSubProject(String op, java.lang.Boolean val) {
		setConditionIsSubProject(op, val, CONDITION_AND);
	}

	public void setConditionIsSubProject(String op, java.lang.Boolean val, String relation) {
		addCondition(81, op, relation, val);
	}

	public void setSelectIsSubProject(boolean val) {
		__select_flags[81] = val;
	}

	public void setIsSubProjectExpression(String val) {
		__dataExpressions[81] = val;
	}

	public void setConditionContractStatus(String op, java.lang.Integer val) {
		setConditionContractStatus(op, val, CONDITION_AND);
	}

	public void setConditionContractStatus(String op, java.lang.Integer val, String relation) {
		addCondition(82, op, relation, val);
	}

	public void setSelectContractStatus(boolean val) {
		__select_flags[82] = val;
	}

	public void setContractStatusExpression(String val) {
		__dataExpressions[82] = val;
	}

	public void setConditionIsPubliclyBidding(String op, java.lang.Boolean val) {
		setConditionIsPubliclyBidding(op, val, CONDITION_AND);
	}

	public void setConditionIsPubliclyBidding(String op, java.lang.Boolean val, String relation) {
		addCondition(83, op, relation, val);
	}

	public void setSelectIsPubliclyBidding(boolean val) {
		__select_flags[83] = val;
	}

	public void setIsPubliclyBiddingExpression(String val) {
		__dataExpressions[83] = val;
	}

	public void setConditionHaveAgents(String op, java.lang.Boolean val) {
		setConditionHaveAgents(op, val, CONDITION_AND);
	}

	public void setConditionHaveAgents(String op, java.lang.Boolean val, String relation) {
		addCondition(84, op, relation, val);
	}

	public void setSelectHaveAgents(boolean val) {
		__select_flags[84] = val;
	}

	public void setHaveAgentsExpression(String val) {
		__dataExpressions[84] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(85, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[85] = val;
	}

	public void setCompanyIdExpression(String val) {
		__dataExpressions[85] = val;
	}

	public void setConditionCompanyNo(String op, java.lang.String val) {
		setConditionCompanyNo(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNo(String op, java.lang.String val, String relation) {
		addCondition(86, op, relation, val);
	}

	public void setSelectCompanyNo(boolean val) {
		__select_flags[86] = val;
	}

	public void setCompanyNoExpression(String val) {
		__dataExpressions[86] = val;
	}

	public void setConditionPercent(String op, java.math.BigDecimal val) {
		setConditionPercent(op, val, CONDITION_AND);
	}

	public void setConditionPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(87, op, relation, val);
	}

	public void setSelectPercent(boolean val) {
		__select_flags[87] = val;
	}

	public void setPercentExpression(String val) {
		__dataExpressions[87] = val;
	}

	public void setConditionOwnerTypeId(String op, java.lang.Integer val) {
		setConditionOwnerTypeId(op, val, CONDITION_AND);
	}

	public void setConditionOwnerTypeId(String op, java.lang.Integer val, String relation) {
		addCondition(88, op, relation, val);
	}

	public void setSelectOwnerTypeId(boolean val) {
		__select_flags[88] = val;
	}

	public void setOwnerTypeIdExpression(String val) {
		__dataExpressions[88] = val;
	}

	public void setConditionEstimatePrice(String op, java.math.BigDecimal val) {
		setConditionEstimatePrice(op, val, CONDITION_AND);
	}

	public void setConditionEstimatePrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(89, op, relation, val);
	}

	public void setSelectEstimatePrice(boolean val) {
		__select_flags[89] = val;
	}

	public void setEstimatePriceExpression(String val) {
		__dataExpressions[89] = val;
	}

	public void setConditionProjectPhase(String op, java.lang.Integer val) {
		setConditionProjectPhase(op, val, CONDITION_AND);
	}

	public void setConditionProjectPhase(String op, java.lang.Integer val, String relation) {
		addCondition(90, op, relation, val);
	}

	public void setSelectProjectPhase(boolean val) {
		__select_flags[90] = val;
	}

	public void setProjectPhaseExpression(String val) {
		__dataExpressions[90] = val;
	}

	public void setConditionProjectAttribute(String op, java.lang.Integer val) {
		setConditionProjectAttribute(op, val, CONDITION_AND);
	}

	public void setConditionProjectAttribute(String op, java.lang.Integer val, String relation) {
		addCondition(91, op, relation, val);
	}

	public void setSelectProjectAttribute(boolean val) {
		__select_flags[91] = val;
	}

	public void setProjectAttributeExpression(String val) {
		__dataExpressions[91] = val;
	}

	public void setConditionProjectNameOne(String op, java.lang.String val) {
		setConditionProjectNameOne(op, val, CONDITION_AND);
	}

	public void setConditionProjectNameOne(String op, java.lang.String val, String relation) {
		addCondition(92, op, relation, val);
	}

	public void setSelectProjectNameOne(boolean val) {
		__select_flags[92] = val;
	}

	public void setProjectNameOneExpression(String val) {
		__dataExpressions[92] = val;
	}

	public void setConditionWinningTime(String op, java.util.Date val) {
		setConditionWinningTime(op, val, CONDITION_AND);
	}

	public void setConditionWinningTime(String op, java.util.Date val, String relation) {
		addCondition(93, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectWinningTime(boolean val) {
		__select_flags[93] = val;
	}

	public void setWinningTimeExpression(String val) {
		__dataExpressions[93] = val;
	}

	public void setConditionProjectOutputValue(String op, java.math.BigDecimal val) {
		setConditionProjectOutputValue(op, val, CONDITION_AND);
	}

	public void setConditionProjectOutputValue(String op, java.math.BigDecimal val, String relation) {
		addCondition(94, op, relation, val);
	}

	public void setSelectProjectOutputValue(boolean val) {
		__select_flags[94] = val;
	}

	public void setProjectOutputValueExpression(String val) {
		__dataExpressions[94] = val;
	}

	public void setConditionMainProjectStageId(String op, java.lang.Integer val) {
		setConditionMainProjectStageId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectStageId(String op, java.lang.Integer val, String relation) {
		addCondition(95, op, relation, val);
	}

	public void setSelectMainProjectStageId(boolean val) {
		__select_flags[95] = val;
	}

	public void setMainProjectStageIdExpression(String val) {
		__dataExpressions[95] = val;
	}

	public void setConditionIsModifyProject(String op, java.lang.Boolean val) {
		setConditionIsModifyProject(op, val, CONDITION_AND);
	}

	public void setConditionIsModifyProject(String op, java.lang.Boolean val, String relation) {
		addCondition(96, op, relation, val);
	}

	public void setSelectIsModifyProject(boolean val) {
		__select_flags[96] = val;
	}

	public void setIsModifyProjectExpression(String val) {
		__dataExpressions[96] = val;
	}

	public void setConditionGrade(String op, java.lang.String val) {
		setConditionGrade(op, val, CONDITION_AND);
	}

	public void setConditionGrade(String op, java.lang.String val, String relation) {
		addCondition(97, op, relation, val);
	}

	public void setSelectGrade(boolean val) {
		__select_flags[97] = val;
	}

	public void setGradeExpression(String val) {
		__dataExpressions[97] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(98, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[98] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[98] = val;
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val) {
		setConditionProcessStatus(op, val, CONDITION_AND);
	}

	public void setConditionProcessStatus(String op, java.lang.Integer val, String relation) {
		addCondition(99, op, relation, val);
	}

	public void setSelectProcessStatus(boolean val) {
		__select_flags[99] = val;
	}

	public void setProcessStatusExpression(String val) {
		__dataExpressions[99] = val;
	}


}

