package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCompetitionUnit;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CompetitionUnit extends AbstractTable<BaseCompetitionUnit>
{

	public CompetitionUnit() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 32;

		initTables();

		__tableName            = "competition_units";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCompetitionUnit.CS_COMPETITION_UNIT_ID;
		__column_names[1] = BaseCompetitionUnit.CS_PLATE_TYPE_NAME;
		__column_names[2] = BaseCompetitionUnit.CS_AREA_NAME;
		__column_names[3] = BaseCompetitionUnit.CS_NAME;
		__column_names[4] = BaseCompetitionUnit.CS_ADDRESS;
		__column_names[5] = BaseCompetitionUnit.CS_WEB_SITE;
		__column_names[6] = BaseCompetitionUnit.CS_COMPANY_STOCK_CODE;
		__column_names[7] = BaseCompetitionUnit.CS_COMPANY_PROVINCE;
		__column_names[8] = BaseCompetitionUnit.CS_COMPANY_CITY;
		__column_names[9] = BaseCompetitionUnit.CS_BUSINESS_PLATE;
		__column_names[10] = BaseCompetitionUnit.CS_PROFESSIONAL_PLATE;
		__column_names[11] = BaseCompetitionUnit.CS_COMPANY_PARENT_NAME;
		__column_names[12] = BaseCompetitionUnit.CS_COMPANY_PARENT_ADDRESS;
		__column_names[13] = BaseCompetitionUnit.CS_COMPANY_CHILD_NAME;
		__column_names[14] = BaseCompetitionUnit.CS_COMPANY_EMPLOYEE_NUM;
		__column_names[15] = BaseCompetitionUnit.CS_COMPANY_SETUP;
		__column_names[16] = BaseCompetitionUnit.CS_COMPANY_NATURE;
		__column_names[17] = BaseCompetitionUnit.CS_COMPANY_QUALIFICATION;
		__column_names[18] = BaseCompetitionUnit.CS_COMPANY_ORGANIZATIONAL;
		__column_names[19] = BaseCompetitionUnit.CS_MAIN_WORK_CUSTOMER;
		__column_names[20] = BaseCompetitionUnit.CS_MIAN_ACHIEVEMENT;
		__column_names[21] = BaseCompetitionUnit.CS_COMPANY_BRIEF;
		__column_names[22] = BaseCompetitionUnit.CS_PROJECT_NAME;
		__column_names[23] = BaseCompetitionUnit.CS_PROJECT_VOLUME;
		__column_names[24] = BaseCompetitionUnit.CS_DESIGN_DATE;
		__column_names[25] = BaseCompetitionUnit.CS_DESIGN_HIGHLIGHT;
		__column_names[26] = BaseCompetitionUnit.CS_DESIGN_FEE_STANDARD;
		__column_names[27] = BaseCompetitionUnit.CS_CORE_STRENGTH;
		__column_names[28] = BaseCompetitionUnit.CS_WEAKNESSES;
		__column_names[29] = BaseCompetitionUnit.CS_OPERATE_EMPLOYEE_ID;
		__column_names[30] = BaseCompetitionUnit.CS_CREATE_TIME;
		__column_names[31] = BaseCompetitionUnit.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCompetitionUnit b) {
		clear();
		setCompetitionUnitIdClear(b.getCompetitionUnitId());
	}

	public boolean isPrimaryKeyNull() {
		return getCompetitionUnitId() == null;
	}

	@Override
	public BaseCompetitionUnit generateBase(){
		BaseCompetitionUnit b = new BaseCompetitionUnit();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCompetitionUnit b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCompetitionUnitId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateTypeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAreaName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWebSite(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyStockCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyProvince(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyCity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBusinessPlate(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProfessionalPlate(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyParentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyParentAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyChildName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyEmployeeNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanySetup(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompanyNature(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyQualification(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyOrganizational(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainWorkCustomer(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMianAchievement(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyBrief(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectVolume(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDesignHighlight(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignFeeStandard(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCoreStrength(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWeaknesses(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCompetitionUnit b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCompetitionUnitId();
		buff[count++] = b.getPlateTypeName();
		buff[count++] = b.getAreaName();
		buff[count++] = b.getName();
		buff[count++] = b.getAddress();
		buff[count++] = b.getWebSite();
		buff[count++] = b.getCompanyStockCode();
		buff[count++] = b.getCompanyProvince();
		buff[count++] = b.getCompanyCity();
		buff[count++] = b.getBusinessPlate();
		buff[count++] = b.getProfessionalPlate();
		buff[count++] = b.getCompanyParentName();
		buff[count++] = b.getCompanyParentAddress();
		buff[count++] = b.getCompanyChildName();
		buff[count++] = b.getCompanyEmployeeNum();
		buff[count++] = generateTimestampFromDate(b.getCompanySetup());
		buff[count++] = b.getCompanyNature();
		buff[count++] = b.getCompanyQualification();
		buff[count++] = b.getCompanyOrganizational();
		buff[count++] = b.getMainWorkCustomer();
		buff[count++] = b.getMianAchievement();
		buff[count++] = b.getCompanyBrief();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getProjectVolume();
		buff[count++] = generateTimestampFromDate(b.getDesignDate());
		buff[count++] = b.getDesignHighlight();
		buff[count++] = b.getDesignFeeStandard();
		buff[count++] = b.getCoreStrength();
		buff[count++] = b.getWeaknesses();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseCompetitionUnit b){
		if(b.getCompetitionUnitId() != null) setCompetitionUnitIdClear(b.getCompetitionUnitId());
		if(b.getPlateTypeName() != null) setPlateTypeName(b.getPlateTypeName());
		if(b.getAreaName() != null) setAreaName(b.getAreaName());
		if(b.getName() != null) setName(b.getName());
		if(b.getAddress() != null) setAddress(b.getAddress());
		if(b.getWebSite() != null) setWebSite(b.getWebSite());
		if(b.getCompanyStockCode() != null) setCompanyStockCode(b.getCompanyStockCode());
		if(b.getCompanyProvince() != null) setCompanyProvince(b.getCompanyProvince());
		if(b.getCompanyCity() != null) setCompanyCity(b.getCompanyCity());
		if(b.getBusinessPlate() != null) setBusinessPlate(b.getBusinessPlate());
		if(b.getProfessionalPlate() != null) setProfessionalPlate(b.getProfessionalPlate());
		if(b.getCompanyParentName() != null) setCompanyParentName(b.getCompanyParentName());
		if(b.getCompanyParentAddress() != null) setCompanyParentAddress(b.getCompanyParentAddress());
		if(b.getCompanyChildName() != null) setCompanyChildName(b.getCompanyChildName());
		if(b.getCompanyEmployeeNum() != null) setCompanyEmployeeNum(b.getCompanyEmployeeNum());
		if(b.getCompanySetup() != null) setCompanySetup(b.getCompanySetup());
		if(b.getCompanyNature() != null) setCompanyNature(b.getCompanyNature());
		if(b.getCompanyQualification() != null) setCompanyQualification(b.getCompanyQualification());
		if(b.getCompanyOrganizational() != null) setCompanyOrganizational(b.getCompanyOrganizational());
		if(b.getMainWorkCustomer() != null) setMainWorkCustomer(b.getMainWorkCustomer());
		if(b.getMianAchievement() != null) setMianAchievement(b.getMianAchievement());
		if(b.getCompanyBrief() != null) setCompanyBrief(b.getCompanyBrief());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getProjectVolume() != null) setProjectVolume(b.getProjectVolume());
		if(b.getDesignDate() != null) setDesignDate(b.getDesignDate());
		if(b.getDesignHighlight() != null) setDesignHighlight(b.getDesignHighlight());
		if(b.getDesignFeeStandard() != null) setDesignFeeStandard(b.getDesignFeeStandard());
		if(b.getCoreStrength() != null) setCoreStrength(b.getCoreStrength());
		if(b.getWeaknesses() != null) setWeaknesses(b.getWeaknesses());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseCompetitionUnit generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCompetitionUnit b = new BaseCompetitionUnit();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCompetitionUnit __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompetitionUnitId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateTypeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreaName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWebSite(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyStockCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyProvince(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyCity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessPlate(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalPlate(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyParentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyParentAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyChildName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyEmployeeNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanySetup(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNature(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyQualification(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyOrganizational(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainWorkCustomer(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMianAchievement(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyBrief(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectVolume(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignHighlight(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignFeeStandard(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCoreStrength(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWeaknesses(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setCompetitionUnitId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCompetitionUnitId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCompetitionUnitIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateTypeName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getPlateTypeName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setAreaName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getAreaName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setAddress(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getAddress() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setWebSite(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getWebSite() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setCompanyStockCode(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getCompanyStockCode() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setCompanyProvince(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getCompanyProvince() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setCompanyCity(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getCompanyCity() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setBusinessPlate(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getBusinessPlate() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setProfessionalPlate(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getProfessionalPlate() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setCompanyParentName(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getCompanyParentName() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setCompanyParentAddress(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getCompanyParentAddress() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setCompanyChildName(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getCompanyChildName() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setCompanyEmployeeNum(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getCompanyEmployeeNum() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setCompanySetup(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getCompanySetup() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setCompanyNature(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getCompanyNature() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setCompanyQualification(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getCompanyQualification() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setCompanyOrganizational(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getCompanyOrganizational() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setMainWorkCustomer(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getMainWorkCustomer() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setMianAchievement(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getMianAchievement() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setCompanyBrief(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getCompanyBrief() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setProjectVolume(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getProjectVolume() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setDesignDate(java.util.Date val) {
		setCurrentData(24, generateTimestampFromDate(val));
	}

	public java.util.Date getDesignDate() {
		return GenericBase.__getDateFromSQL(__current_data[24]);
	}

	public void setDesignHighlight(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getDesignHighlight() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setDesignFeeStandard(java.lang.String val) {
		setCurrentData(26, val);
	}

	public java.lang.String getDesignFeeStandard() {
		return GenericBase.__getString(__current_data[26]);
	}

	public void setCoreStrength(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getCoreStrength() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setWeaknesses(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getWeaknesses() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(30, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[30]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setConditionCompetitionUnitId(String op, java.lang.Integer val) {
		setConditionCompetitionUnitId(op, val, CONDITION_AND);
	}

	public void setConditionCompetitionUnitId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCompetitionUnitId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateTypeName(String op, java.lang.String val) {
		setConditionPlateTypeName(op, val, CONDITION_AND);
	}

	public void setConditionPlateTypeName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateTypeName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAreaName(String op, java.lang.String val) {
		setConditionAreaName(op, val, CONDITION_AND);
	}

	public void setConditionAreaName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAreaName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAddress(String op, java.lang.String val) {
		setConditionAddress(op, val, CONDITION_AND);
	}

	public void setConditionAddress(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAddress(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionWebSite(String op, java.lang.String val) {
		setConditionWebSite(op, val, CONDITION_AND);
	}

	public void setConditionWebSite(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectWebSite(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCompanyStockCode(String op, java.lang.String val) {
		setConditionCompanyStockCode(op, val, CONDITION_AND);
	}

	public void setConditionCompanyStockCode(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCompanyStockCode(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionCompanyProvince(String op, java.lang.String val) {
		setConditionCompanyProvince(op, val, CONDITION_AND);
	}

	public void setConditionCompanyProvince(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectCompanyProvince(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCompanyCity(String op, java.lang.String val) {
		setConditionCompanyCity(op, val, CONDITION_AND);
	}

	public void setConditionCompanyCity(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCompanyCity(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionBusinessPlate(String op, java.lang.String val) {
		setConditionBusinessPlate(op, val, CONDITION_AND);
	}

	public void setConditionBusinessPlate(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectBusinessPlate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProfessionalPlate(String op, java.lang.String val) {
		setConditionProfessionalPlate(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalPlate(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProfessionalPlate(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCompanyParentName(String op, java.lang.String val) {
		setConditionCompanyParentName(op, val, CONDITION_AND);
	}

	public void setConditionCompanyParentName(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectCompanyParentName(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCompanyParentAddress(String op, java.lang.String val) {
		setConditionCompanyParentAddress(op, val, CONDITION_AND);
	}

	public void setConditionCompanyParentAddress(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCompanyParentAddress(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionCompanyChildName(String op, java.lang.String val) {
		setConditionCompanyChildName(op, val, CONDITION_AND);
	}

	public void setConditionCompanyChildName(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectCompanyChildName(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCompanyEmployeeNum(String op, java.lang.Integer val) {
		setConditionCompanyEmployeeNum(op, val, CONDITION_AND);
	}

	public void setConditionCompanyEmployeeNum(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectCompanyEmployeeNum(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionCompanySetup(String op, java.util.Date val) {
		setConditionCompanySetup(op, val, CONDITION_AND);
	}

	public void setConditionCompanySetup(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCompanySetup(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionCompanyNature(String op, java.lang.String val) {
		setConditionCompanyNature(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNature(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectCompanyNature(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCompanyQualification(String op, java.lang.String val) {
		setConditionCompanyQualification(op, val, CONDITION_AND);
	}

	public void setConditionCompanyQualification(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCompanyQualification(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionCompanyOrganizational(String op, java.lang.String val) {
		setConditionCompanyOrganizational(op, val, CONDITION_AND);
	}

	public void setConditionCompanyOrganizational(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectCompanyOrganizational(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionMainWorkCustomer(String op, java.lang.String val) {
		setConditionMainWorkCustomer(op, val, CONDITION_AND);
	}

	public void setConditionMainWorkCustomer(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectMainWorkCustomer(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionMianAchievement(String op, java.lang.String val) {
		setConditionMianAchievement(op, val, CONDITION_AND);
	}

	public void setConditionMianAchievement(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectMianAchievement(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionCompanyBrief(String op, java.lang.String val) {
		setConditionCompanyBrief(op, val, CONDITION_AND);
	}

	public void setConditionCompanyBrief(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectCompanyBrief(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionProjectVolume(String op, java.lang.String val) {
		setConditionProjectVolume(op, val, CONDITION_AND);
	}

	public void setConditionProjectVolume(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectProjectVolume(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionDesignDate(String op, java.util.Date val) {
		setConditionDesignDate(op, val, CONDITION_AND);
	}

	public void setConditionDesignDate(String op, java.util.Date val, String relation) {
		addCondition(24, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectDesignDate(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionDesignHighlight(String op, java.lang.String val) {
		setConditionDesignHighlight(op, val, CONDITION_AND);
	}

	public void setConditionDesignHighlight(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectDesignHighlight(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionDesignFeeStandard(String op, java.lang.String val) {
		setConditionDesignFeeStandard(op, val, CONDITION_AND);
	}

	public void setConditionDesignFeeStandard(String op, java.lang.String val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectDesignFeeStandard(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionCoreStrength(String op, java.lang.String val) {
		setConditionCoreStrength(op, val, CONDITION_AND);
	}

	public void setConditionCoreStrength(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectCoreStrength(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionWeaknesses(String op, java.lang.String val) {
		setConditionWeaknesses(op, val, CONDITION_AND);
	}

	public void setConditionWeaknesses(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectWeaknesses(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(30, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[31] = val;
	}


}

