package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCustomer;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Customer extends AbstractTable<BaseCustomer>
{

	public Customer() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 30;

		initTables();

		__tableName            = "customers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCustomer.CS_CUSTOMER_ID;
		__column_names[1] = BaseCustomer.CS_CUSTOMER_NAME;
		__column_names[2] = BaseCustomer.CS_COMPANY_ADDRESS;
		__column_names[3] = BaseCustomer.CS_WEB_SITE;
		__column_names[4] = BaseCustomer.CS_COMPANY_MOBILE;
		__column_names[5] = BaseCustomer.CS_COMPANY_FAX;
		__column_names[6] = BaseCustomer.CS_COMPANY_STOCK_CODE;
		__column_names[7] = BaseCustomer.CS_POST_CODE;
		__column_names[8] = BaseCustomer.CS_COMPANY_PROVINCE;
		__column_names[9] = BaseCustomer.CS_COMPANY_CITY;
		__column_names[10] = BaseCustomer.CS_CUSTOMER_TYPE;
		__column_names[11] = BaseCustomer.CS_CUSTOMER_LEVEL;
		__column_names[12] = BaseCustomer.CS_TYPE;
		__column_names[13] = BaseCustomer.CS_PARENT_ID;
		__column_names[14] = BaseCustomer.CS_IS_SURE;
		__column_names[15] = BaseCustomer.CS_IS_WAREHOUS;
		__column_names[16] = BaseCustomer.CS_IS_APPLY_QUOTE;
		__column_names[17] = BaseCustomer.CS_COMPANY_PARENT_NAME;
		__column_names[18] = BaseCustomer.CS_COMPANY_PARENT_ADDRESS;
		__column_names[19] = BaseCustomer.CS_COMPANY_CHILD_NAME;
		__column_names[20] = BaseCustomer.CS_COMPANY_EMPLOYEE_NUM;
		__column_names[21] = BaseCustomer.CS_COMPANY_SETUP;
		__column_names[22] = BaseCustomer.CS_COMPANY_NATURE;
		__column_names[23] = BaseCustomer.CS_COMPANY_QUALIFICATION;
		__column_names[24] = BaseCustomer.CS_COMPANY_ORGANIZATIONAL;
		__column_names[25] = BaseCustomer.CS_COMPANY_BRIEF;
		__column_names[26] = BaseCustomer.CS_OPERATE_EMPLOYEE_ID;
		__column_names[27] = BaseCustomer.CS_CREATE_TIME;
		__column_names[28] = BaseCustomer.CS_REMARK;
		__column_names[29] = BaseCustomer.CS_REPORT_EMPLOYEE_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCustomer b) {
		clear();
		setCustomerIdClear(b.getCustomerId());
	}

	public boolean isPrimaryKeyNull() {
		return getCustomerId() == null;
	}

	@Override
	public BaseCustomer generateBase(){
		BaseCustomer b = new BaseCustomer();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCustomer b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCustomerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setWebSite(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyMobile(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyFax(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyStockCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPostCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyProvince(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyCity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsSure(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setCompanyParentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyParentAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyChildName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyEmployeeNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanySetup(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCompanyNature(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyQualification(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyOrganizational(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCompanyBrief(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReportEmployeeId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCustomer b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCustomerId();
		buff[count++] = b.getCustomerName();
		buff[count++] = b.getCompanyAddress();
		buff[count++] = b.getWebSite();
		buff[count++] = b.getCompanyMobile();
		buff[count++] = b.getCompanyFax();
		buff[count++] = b.getCompanyStockCode();
		buff[count++] = b.getPostCode();
		buff[count++] = b.getCompanyProvince();
		buff[count++] = b.getCompanyCity();
		buff[count++] = b.getCustomerType();
		buff[count++] = b.getCustomerLevel();
		buff[count++] = b.getType();
		buff[count++] = b.getParentId();
		buff[count++] = b.getIsSure();
		buff[count++] = b.getIsWarehous();
		buff[count++] = b.getIsApplyQuote();
		buff[count++] = b.getCompanyParentName();
		buff[count++] = b.getCompanyParentAddress();
		buff[count++] = b.getCompanyChildName();
		buff[count++] = b.getCompanyEmployeeNum();
		buff[count++] = generateTimestampFromDate(b.getCompanySetup());
		buff[count++] = b.getCompanyNature();
		buff[count++] = b.getCompanyQualification();
		buff[count++] = b.getCompanyOrganizational();
		buff[count++] = b.getCompanyBrief();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getReportEmployeeId();
	}

	@Override
	public void setDataFromBase(BaseCustomer b){
		if(b.getCustomerId() != null) setCustomerIdClear(b.getCustomerId());
		if(b.getCustomerName() != null) setCustomerName(b.getCustomerName());
		if(b.getCompanyAddress() != null) setCompanyAddress(b.getCompanyAddress());
		if(b.getWebSite() != null) setWebSite(b.getWebSite());
		if(b.getCompanyMobile() != null) setCompanyMobile(b.getCompanyMobile());
		if(b.getCompanyFax() != null) setCompanyFax(b.getCompanyFax());
		if(b.getCompanyStockCode() != null) setCompanyStockCode(b.getCompanyStockCode());
		if(b.getPostCode() != null) setPostCode(b.getPostCode());
		if(b.getCompanyProvince() != null) setCompanyProvince(b.getCompanyProvince());
		if(b.getCompanyCity() != null) setCompanyCity(b.getCompanyCity());
		if(b.getCustomerType() != null) setCustomerType(b.getCustomerType());
		if(b.getCustomerLevel() != null) setCustomerLevel(b.getCustomerLevel());
		if(b.getType() != null) setType(b.getType());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getIsSure() != null) setIsSure(b.getIsSure());
		if(b.getIsWarehous() != null) setIsWarehous(b.getIsWarehous());
		if(b.getIsApplyQuote() != null) setIsApplyQuote(b.getIsApplyQuote());
		if(b.getCompanyParentName() != null) setCompanyParentName(b.getCompanyParentName());
		if(b.getCompanyParentAddress() != null) setCompanyParentAddress(b.getCompanyParentAddress());
		if(b.getCompanyChildName() != null) setCompanyChildName(b.getCompanyChildName());
		if(b.getCompanyEmployeeNum() != null) setCompanyEmployeeNum(b.getCompanyEmployeeNum());
		if(b.getCompanySetup() != null) setCompanySetup(b.getCompanySetup());
		if(b.getCompanyNature() != null) setCompanyNature(b.getCompanyNature());
		if(b.getCompanyQualification() != null) setCompanyQualification(b.getCompanyQualification());
		if(b.getCompanyOrganizational() != null) setCompanyOrganizational(b.getCompanyOrganizational());
		if(b.getCompanyBrief() != null) setCompanyBrief(b.getCompanyBrief());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getReportEmployeeId() != null) setReportEmployeeId(b.getReportEmployeeId());
	}

	@Override
	public BaseCustomer generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCustomer b = new BaseCustomer();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCustomer __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWebSite(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyMobile(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyFax(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyStockCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPostCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyProvince(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyCity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSure(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyParentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyParentAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyChildName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyEmployeeNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanySetup(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyNature(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyQualification(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyOrganizational(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyBrief(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReportEmployeeId(GenericBase.__getInt(val));
	}

	public void setCustomerId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCustomerId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCustomerIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCustomerName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCustomerName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCompanyAddress(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCompanyAddress() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setWebSite(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getWebSite() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCompanyMobile(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCompanyMobile() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setCompanyFax(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getCompanyFax() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setCompanyStockCode(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getCompanyStockCode() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setPostCode(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getPostCode() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setCompanyProvince(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getCompanyProvince() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setCompanyCity(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getCompanyCity() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setCustomerType(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getCustomerType() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setCustomerLevel(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getCustomerLevel() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setIsSure(java.lang.Boolean val) {
		setCurrentData(14, val);
	}

	public java.lang.Boolean getIsSure() {
		return GenericBase.__getBoolean(__current_data[14]);
	}

	public void setIsWarehous(java.lang.Boolean val) {
		setCurrentData(15, val);
	}

	public java.lang.Boolean getIsWarehous() {
		return GenericBase.__getBoolean(__current_data[15]);
	}

	public void setIsApplyQuote(java.lang.Boolean val) {
		setCurrentData(16, val);
	}

	public java.lang.Boolean getIsApplyQuote() {
		return GenericBase.__getBoolean(__current_data[16]);
	}

	public void setCompanyParentName(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getCompanyParentName() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setCompanyParentAddress(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getCompanyParentAddress() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setCompanyChildName(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getCompanyChildName() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setCompanyEmployeeNum(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getCompanyEmployeeNum() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setCompanySetup(java.util.Date val) {
		setCurrentData(21, generateTimestampFromDate(val));
	}

	public java.util.Date getCompanySetup() {
		return GenericBase.__getDateFromSQL(__current_data[21]);
	}

	public void setCompanyNature(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getCompanyNature() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setCompanyQualification(java.lang.String val) {
		setCurrentData(23, val);
	}

	public java.lang.String getCompanyQualification() {
		return GenericBase.__getString(__current_data[23]);
	}

	public void setCompanyOrganizational(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getCompanyOrganizational() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setCompanyBrief(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getCompanyBrief() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(27, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[27]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setReportEmployeeId(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getReportEmployeeId() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setConditionCustomerId(String op, java.lang.Integer val) {
		setConditionCustomerId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCustomerId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCustomerName(String op, java.lang.String val) {
		setConditionCustomerName(op, val, CONDITION_AND);
	}

	public void setConditionCustomerName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCustomerName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCompanyAddress(String op, java.lang.String val) {
		setConditionCompanyAddress(op, val, CONDITION_AND);
	}

	public void setConditionCompanyAddress(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompanyAddress(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionWebSite(String op, java.lang.String val) {
		setConditionWebSite(op, val, CONDITION_AND);
	}

	public void setConditionWebSite(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectWebSite(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCompanyMobile(String op, java.lang.String val) {
		setConditionCompanyMobile(op, val, CONDITION_AND);
	}

	public void setConditionCompanyMobile(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCompanyMobile(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCompanyFax(String op, java.lang.String val) {
		setConditionCompanyFax(op, val, CONDITION_AND);
	}

	public void setConditionCompanyFax(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCompanyFax(boolean val) {
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

	public void setConditionPostCode(String op, java.lang.String val) {
		setConditionPostCode(op, val, CONDITION_AND);
	}

	public void setConditionPostCode(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPostCode(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionCompanyProvince(String op, java.lang.String val) {
		setConditionCompanyProvince(op, val, CONDITION_AND);
	}

	public void setConditionCompanyProvince(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectCompanyProvince(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCompanyCity(String op, java.lang.String val) {
		setConditionCompanyCity(op, val, CONDITION_AND);
	}

	public void setConditionCompanyCity(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectCompanyCity(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionCustomerType(String op, java.lang.Integer val) {
		setConditionCustomerType(op, val, CONDITION_AND);
	}

	public void setConditionCustomerType(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectCustomerType(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCustomerLevel(String op, java.lang.Integer val) {
		setConditionCustomerLevel(op, val, CONDITION_AND);
	}

	public void setConditionCustomerLevel(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectCustomerLevel(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionIsSure(String op, java.lang.Boolean val) {
		setConditionIsSure(op, val, CONDITION_AND);
	}

	public void setConditionIsSure(String op, java.lang.Boolean val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectIsSure(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionIsWarehous(String op, java.lang.Boolean val) {
		setConditionIsWarehous(op, val, CONDITION_AND);
	}

	public void setConditionIsWarehous(String op, java.lang.Boolean val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectIsWarehous(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionIsApplyQuote(String op, java.lang.Boolean val) {
		setConditionIsApplyQuote(op, val, CONDITION_AND);
	}

	public void setConditionIsApplyQuote(String op, java.lang.Boolean val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectIsApplyQuote(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionCompanyParentName(String op, java.lang.String val) {
		setConditionCompanyParentName(op, val, CONDITION_AND);
	}

	public void setConditionCompanyParentName(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectCompanyParentName(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionCompanyParentAddress(String op, java.lang.String val) {
		setConditionCompanyParentAddress(op, val, CONDITION_AND);
	}

	public void setConditionCompanyParentAddress(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectCompanyParentAddress(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionCompanyChildName(String op, java.lang.String val) {
		setConditionCompanyChildName(op, val, CONDITION_AND);
	}

	public void setConditionCompanyChildName(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectCompanyChildName(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionCompanyEmployeeNum(String op, java.lang.Integer val) {
		setConditionCompanyEmployeeNum(op, val, CONDITION_AND);
	}

	public void setConditionCompanyEmployeeNum(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectCompanyEmployeeNum(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionCompanySetup(String op, java.util.Date val) {
		setConditionCompanySetup(op, val, CONDITION_AND);
	}

	public void setConditionCompanySetup(String op, java.util.Date val, String relation) {
		addCondition(21, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCompanySetup(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionCompanyNature(String op, java.lang.String val) {
		setConditionCompanyNature(op, val, CONDITION_AND);
	}

	public void setConditionCompanyNature(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectCompanyNature(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionCompanyQualification(String op, java.lang.String val) {
		setConditionCompanyQualification(op, val, CONDITION_AND);
	}

	public void setConditionCompanyQualification(String op, java.lang.String val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectCompanyQualification(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionCompanyOrganizational(String op, java.lang.String val) {
		setConditionCompanyOrganizational(op, val, CONDITION_AND);
	}

	public void setConditionCompanyOrganizational(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectCompanyOrganizational(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionCompanyBrief(String op, java.lang.String val) {
		setConditionCompanyBrief(op, val, CONDITION_AND);
	}

	public void setConditionCompanyBrief(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectCompanyBrief(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(27, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionReportEmployeeId(String op, java.lang.Integer val) {
		setConditionReportEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionReportEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectReportEmployeeId(boolean val) {
		__select_flags[29] = val;
	}


}

