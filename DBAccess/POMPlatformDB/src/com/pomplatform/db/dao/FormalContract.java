package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseFormalContract;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class FormalContract extends AbstractTable<BaseFormalContract>
{

	public FormalContract() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 42;

		initTables();

		__tableName            = "formal_contracts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseFormalContract.CS_FORMAL_CONTRACT_ID;
		__column_names[1] = BaseFormalContract.CS_CLIENT_CONTRACT_ID;
		__column_names[2] = BaseFormalContract.CS_CONTRACT_CODE;
		__column_names[3] = BaseFormalContract.CS_CONTRACT_NAME;
		__column_names[4] = BaseFormalContract.CS_CUSTOMER_NAME;
		__column_names[5] = BaseFormalContract.CS_START_DATE;
		__column_names[6] = BaseFormalContract.CS_END_DATE;
		__column_names[7] = BaseFormalContract.CS_STATUS;
		__column_names[8] = BaseFormalContract.CS_PROJECT_CODE;
		__column_names[9] = BaseFormalContract.CS_CONTRACT_TYPE;
		__column_names[10] = BaseFormalContract.CS_PROJECT_LEVEL;
		__column_names[11] = BaseFormalContract.CS_TOTAL_PROJECT_TIME;
		__column_names[12] = BaseFormalContract.CS_SIGNING_MONEY_SUM;
		__column_names[13] = BaseFormalContract.CS_DESIGN_AREAS;
		__column_names[14] = BaseFormalContract.CS_CONTRACT_PRICE;
		__column_names[15] = BaseFormalContract.CS_PROJECT_ADDRESS;
		__column_names[16] = BaseFormalContract.CS_CONTRACT_FOLLOWER;
		__column_names[17] = BaseFormalContract.CS_REMARK;
		__column_names[18] = BaseFormalContract.CS_CONTRACT_DATE;
		__column_names[19] = BaseFormalContract.CS_SIGNING_COMPANY_NAME;
		__column_names[20] = BaseFormalContract.CS_CREATE_TIME;
		__column_names[21] = BaseFormalContract.CS_UPDATE_TIME;
		__column_names[22] = BaseFormalContract.CS_BUSINESS_TYPE;
		__column_names[23] = BaseFormalContract.CS_FLOW_STATUS;
		__column_names[24] = BaseFormalContract.CS_SERIAL_NUMBER;
		__column_names[25] = BaseFormalContract.CS_PROJECT_TYPE;
		__column_names[26] = BaseFormalContract.CS_COVERED_AREA;
		__column_names[27] = BaseFormalContract.CS_PROFESSIONAL_COOPERATION;
		__column_names[28] = BaseFormalContract.CS_PROVINCE;
		__column_names[29] = BaseFormalContract.CS_CITY;
		__column_names[30] = BaseFormalContract.CS_DETAIL_ADDRESS;
		__column_names[31] = BaseFormalContract.CS_CUSTOMER_ADDRESS;
		__column_names[32] = BaseFormalContract.CS_SERVICE_SUGGEST_BOOK;
		__column_names[33] = BaseFormalContract.CS_PROJECT_APPROVAL_TIME;
		__column_names[34] = BaseFormalContract.CS_ORDER_NO;
		__column_names[35] = BaseFormalContract.CS_CONTRACT_STATUS;
		__column_names[36] = BaseFormalContract.CS_JOB_MIX;
		__column_names[37] = BaseFormalContract.CS_SERVICE_AREA;
		__column_names[38] = BaseFormalContract.CS_WITH_THE_AMOUNT;
		__column_names[39] = BaseFormalContract.CS_ON_SITE_TIME;
		__column_names[40] = BaseFormalContract.CS_ON_SITE_TOTAL_MONEY;
		__column_names[41] = BaseFormalContract.CS_INFO_CODE;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseFormalContract b) {
		clear();
		setFormalContractIdClear(b.getFormalContractId());
	}

	public boolean isPrimaryKeyNull() {
		return getFormalContractId() == null;
	}

	@Override
	public BaseFormalContract generateBase(){
		BaseFormalContract b = new BaseFormalContract();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseFormalContract b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setFormalContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setClientContractId(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTotalProjectTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDesignAreas(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProjectAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractFollower(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSigningCompanyName(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setBusinessType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFlowStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSerialNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCoveredArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setProfessionalCooperation(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProvince(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCity(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDetailAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCustomerAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setServiceSuggestBook(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrderNo(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setJobMix(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setServiceArea(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setWithTheAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOnSiteTime(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOnSiteTotalMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInfoCode(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseFormalContract b, Object[] buff){
		int count = 0;
		buff[count++] = b.getFormalContractId();
		buff[count++] = b.getClientContractId();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getContractName();
		buff[count++] = b.getCustomerName();
		buff[count++] = generateTimestampFromDate(b.getStartDate());
		buff[count++] = generateTimestampFromDate(b.getEndDate());
		buff[count++] = b.getStatus();
		buff[count++] = b.getProjectCode();
		buff[count++] = b.getContractType();
		buff[count++] = b.getProjectLevel();
		buff[count++] = b.getTotalProjectTime();
		buff[count++] = b.getSigningMoneySum();
		buff[count++] = b.getDesignAreas();
		buff[count++] = b.getContractPrice();
		buff[count++] = b.getProjectAddress();
		buff[count++] = b.getContractFollower();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getContractDate());
		buff[count++] = b.getSigningCompanyName();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
		buff[count++] = b.getBusinessType();
		buff[count++] = b.getFlowStatus();
		buff[count++] = b.getSerialNumber();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getCoveredArea();
		buff[count++] = b.getProfessionalCooperation();
		buff[count++] = b.getProvince();
		buff[count++] = b.getCity();
		buff[count++] = b.getDetailAddress();
		buff[count++] = b.getCustomerAddress();
		buff[count++] = b.getServiceSuggestBook();
		buff[count++] = generateTimestampFromDate(b.getProjectApprovalTime());
		buff[count++] = b.getOrderNo();
		buff[count++] = b.getContractStatus();
		buff[count++] = b.getJobMix();
		buff[count++] = b.getServiceArea();
		buff[count++] = b.getWithTheAmount();
		buff[count++] = b.getOnSiteTime();
		buff[count++] = b.getOnSiteTotalMoney();
		buff[count++] = b.getInfoCode();
	}

	@Override
	public void setDataFromBase(BaseFormalContract b){
		if(b.getFormalContractId() != null) setFormalContractIdClear(b.getFormalContractId());
		if(b.getClientContractId() != null) setClientContractId(b.getClientContractId());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getContractName() != null) setContractName(b.getContractName());
		if(b.getCustomerName() != null) setCustomerName(b.getCustomerName());
		if(b.getStartDate() != null) setStartDate(b.getStartDate());
		if(b.getEndDate() != null) setEndDate(b.getEndDate());
		if(b.getStatus() != null) setStatus(b.getStatus());
		if(b.getProjectCode() != null) setProjectCode(b.getProjectCode());
		if(b.getContractType() != null) setContractType(b.getContractType());
		if(b.getProjectLevel() != null) setProjectLevel(b.getProjectLevel());
		if(b.getTotalProjectTime() != null) setTotalProjectTime(b.getTotalProjectTime());
		if(b.getSigningMoneySum() != null) setSigningMoneySum(b.getSigningMoneySum());
		if(b.getDesignAreas() != null) setDesignAreas(b.getDesignAreas());
		if(b.getContractPrice() != null) setContractPrice(b.getContractPrice());
		if(b.getProjectAddress() != null) setProjectAddress(b.getProjectAddress());
		if(b.getContractFollower() != null) setContractFollower(b.getContractFollower());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getContractDate() != null) setContractDate(b.getContractDate());
		if(b.getSigningCompanyName() != null) setSigningCompanyName(b.getSigningCompanyName());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
		if(b.getBusinessType() != null) setBusinessType(b.getBusinessType());
		if(b.getFlowStatus() != null) setFlowStatus(b.getFlowStatus());
		if(b.getSerialNumber() != null) setSerialNumber(b.getSerialNumber());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getCoveredArea() != null) setCoveredArea(b.getCoveredArea());
		if(b.getProfessionalCooperation() != null) setProfessionalCooperation(b.getProfessionalCooperation());
		if(b.getProvince() != null) setProvince(b.getProvince());
		if(b.getCity() != null) setCity(b.getCity());
		if(b.getDetailAddress() != null) setDetailAddress(b.getDetailAddress());
		if(b.getCustomerAddress() != null) setCustomerAddress(b.getCustomerAddress());
		if(b.getServiceSuggestBook() != null) setServiceSuggestBook(b.getServiceSuggestBook());
		if(b.getProjectApprovalTime() != null) setProjectApprovalTime(b.getProjectApprovalTime());
		if(b.getOrderNo() != null) setOrderNo(b.getOrderNo());
		if(b.getContractStatus() != null) setContractStatus(b.getContractStatus());
		if(b.getJobMix() != null) setJobMix(b.getJobMix());
		if(b.getServiceArea() != null) setServiceArea(b.getServiceArea());
		if(b.getWithTheAmount() != null) setWithTheAmount(b.getWithTheAmount());
		if(b.getOnSiteTime() != null) setOnSiteTime(b.getOnSiteTime());
		if(b.getOnSiteTotalMoney() != null) setOnSiteTotalMoney(b.getOnSiteTotalMoney());
		if(b.getInfoCode() != null) setInfoCode(b.getInfoCode());
	}

	@Override
	public BaseFormalContract generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseFormalContract b = new BaseFormalContract();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseFormalContract __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFormalContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClientContractId(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalProjectTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignAreas(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractFollower(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlowStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCoveredArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProfessionalCooperation(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProvince(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCity(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setServiceSuggestBook(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectApprovalTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setJobMix(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setServiceArea(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWithTheAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnSiteTime(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnSiteTotalMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInfoCode(GenericBase.__getString(val));
	}

	public void setFormalContractId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getFormalContractId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setFormalContractIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setClientContractId(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getClientContractId() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setContractName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getContractName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCustomerName(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getCustomerName() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setStartDate(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getStartDate() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setEndDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getEndDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setStatus(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getStatus() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setProjectCode(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getProjectCode() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setContractType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getContractType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setProjectLevel(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getProjectLevel() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setTotalProjectTime(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getTotalProjectTime() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setSigningMoneySum(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setDesignAreas(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getDesignAreas() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setContractPrice(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getContractPrice() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setProjectAddress(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getProjectAddress() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setContractFollower(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getContractFollower() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setContractDate(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getContractDate() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setSigningCompanyName(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getSigningCompanyName() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(20, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[20]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(21, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[21]);
	}

	public void setBusinessType(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getBusinessType() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setFlowStatus(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getFlowStatus() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setSerialNumber(java.lang.String val) {
		setCurrentData(24, val);
	}

	public java.lang.String getSerialNumber() {
		return GenericBase.__getString(__current_data[24]);
	}

	public void setProjectType(java.lang.String val) {
		setCurrentData(25, val);
	}

	public java.lang.String getProjectType() {
		return GenericBase.__getString(__current_data[25]);
	}

	public void setCoveredArea(java.math.BigDecimal val) {
		setCurrentData(26, val);
	}

	public java.math.BigDecimal getCoveredArea() {
		return GenericBase.__getDecimal(__current_data[26]);
	}

	public void setProfessionalCooperation(java.lang.String val) {
		setCurrentData(27, val);
	}

	public java.lang.String getProfessionalCooperation() {
		return GenericBase.__getString(__current_data[27]);
	}

	public void setProvince(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getProvince() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setCity(java.lang.String val) {
		setCurrentData(29, val);
	}

	public java.lang.String getCity() {
		return GenericBase.__getString(__current_data[29]);
	}

	public void setDetailAddress(java.lang.String val) {
		setCurrentData(30, val);
	}

	public java.lang.String getDetailAddress() {
		return GenericBase.__getString(__current_data[30]);
	}

	public void setCustomerAddress(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getCustomerAddress() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setServiceSuggestBook(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getServiceSuggestBook() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setProjectApprovalTime(java.util.Date val) {
		setCurrentData(33, generateTimestampFromDate(val));
	}

	public java.util.Date getProjectApprovalTime() {
		return GenericBase.__getDateFromSQL(__current_data[33]);
	}

	public void setOrderNo(java.lang.Integer val) {
		setCurrentData(34, val);
	}

	public java.lang.Integer getOrderNo() {
		return GenericBase.__getInt(__current_data[34]);
	}

	public void setContractStatus(java.lang.Integer val) {
		setCurrentData(35, val);
	}

	public java.lang.Integer getContractStatus() {
		return GenericBase.__getInt(__current_data[35]);
	}

	public void setJobMix(java.lang.Integer val) {
		setCurrentData(36, val);
	}

	public java.lang.Integer getJobMix() {
		return GenericBase.__getInt(__current_data[36]);
	}

	public void setServiceArea(java.math.BigDecimal val) {
		setCurrentData(37, val);
	}

	public java.math.BigDecimal getServiceArea() {
		return GenericBase.__getDecimal(__current_data[37]);
	}

	public void setWithTheAmount(java.math.BigDecimal val) {
		setCurrentData(38, val);
	}

	public java.math.BigDecimal getWithTheAmount() {
		return GenericBase.__getDecimal(__current_data[38]);
	}

	public void setOnSiteTime(java.lang.Integer val) {
		setCurrentData(39, val);
	}

	public java.lang.Integer getOnSiteTime() {
		return GenericBase.__getInt(__current_data[39]);
	}

	public void setOnSiteTotalMoney(java.math.BigDecimal val) {
		setCurrentData(40, val);
	}

	public java.math.BigDecimal getOnSiteTotalMoney() {
		return GenericBase.__getDecimal(__current_data[40]);
	}

	public void setInfoCode(java.lang.String val) {
		setCurrentData(41, val);
	}

	public java.lang.String getInfoCode() {
		return GenericBase.__getString(__current_data[41]);
	}

	public void setConditionFormalContractId(String op, java.lang.Integer val) {
		setConditionFormalContractId(op, val, CONDITION_AND);
	}

	public void setConditionFormalContractId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectFormalContractId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionClientContractId(String op, java.lang.String val) {
		setConditionClientContractId(op, val, CONDITION_AND);
	}

	public void setConditionClientContractId(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectClientContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionContractName(String op, java.lang.String val) {
		setConditionContractName(op, val, CONDITION_AND);
	}

	public void setConditionContractName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectContractName(boolean val) {
		__select_flags[3] = val;
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

	public void setConditionStartDate(String op, java.util.Date val) {
		setConditionStartDate(op, val, CONDITION_AND);
	}

	public void setConditionStartDate(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectStartDate(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEndDate(String op, java.util.Date val) {
		setConditionEndDate(op, val, CONDITION_AND);
	}

	public void setConditionEndDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectEndDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionStatus(String op, java.lang.Integer val) {
		setConditionStatus(op, val, CONDITION_AND);
	}

	public void setConditionStatus(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectStatus(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionProjectCode(String op, java.lang.String val) {
		setConditionProjectCode(op, val, CONDITION_AND);
	}

	public void setConditionProjectCode(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProjectCode(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionContractType(String op, java.lang.Integer val) {
		setConditionContractType(op, val, CONDITION_AND);
	}

	public void setConditionContractType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectContractType(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val) {
		setConditionProjectLevel(op, val, CONDITION_AND);
	}

	public void setConditionProjectLevel(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectProjectLevel(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTotalProjectTime(String op, java.lang.Integer val) {
		setConditionTotalProjectTime(op, val, CONDITION_AND);
	}

	public void setConditionTotalProjectTime(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTotalProjectTime(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val) {
		setConditionSigningMoneySum(op, val, CONDITION_AND);
	}

	public void setConditionSigningMoneySum(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSigningMoneySum(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionDesignAreas(String op, java.math.BigDecimal val) {
		setConditionDesignAreas(op, val, CONDITION_AND);
	}

	public void setConditionDesignAreas(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectDesignAreas(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionContractPrice(String op, java.math.BigDecimal val) {
		setConditionContractPrice(op, val, CONDITION_AND);
	}

	public void setConditionContractPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectContractPrice(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionProjectAddress(String op, java.lang.String val) {
		setConditionProjectAddress(op, val, CONDITION_AND);
	}

	public void setConditionProjectAddress(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectProjectAddress(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionContractFollower(String op, java.lang.Integer val) {
		setConditionContractFollower(op, val, CONDITION_AND);
	}

	public void setConditionContractFollower(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectContractFollower(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionContractDate(String op, java.util.Date val) {
		setConditionContractDate(op, val, CONDITION_AND);
	}

	public void setConditionContractDate(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectContractDate(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionSigningCompanyName(String op, java.lang.Integer val) {
		setConditionSigningCompanyName(op, val, CONDITION_AND);
	}

	public void setConditionSigningCompanyName(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectSigningCompanyName(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(20, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(21, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionBusinessType(String op, java.lang.String val) {
		setConditionBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionBusinessType(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectBusinessType(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionFlowStatus(String op, java.lang.Integer val) {
		setConditionFlowStatus(op, val, CONDITION_AND);
	}

	public void setConditionFlowStatus(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectFlowStatus(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionSerialNumber(String op, java.lang.String val) {
		setConditionSerialNumber(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumber(String op, java.lang.String val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectSerialNumber(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionProjectType(String op, java.lang.String val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.String val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionCoveredArea(String op, java.math.BigDecimal val) {
		setConditionCoveredArea(op, val, CONDITION_AND);
	}

	public void setConditionCoveredArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectCoveredArea(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionProfessionalCooperation(String op, java.lang.String val) {
		setConditionProfessionalCooperation(op, val, CONDITION_AND);
	}

	public void setConditionProfessionalCooperation(String op, java.lang.String val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectProfessionalCooperation(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionProvince(String op, java.lang.String val) {
		setConditionProvince(op, val, CONDITION_AND);
	}

	public void setConditionProvince(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectProvince(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionCity(String op, java.lang.String val) {
		setConditionCity(op, val, CONDITION_AND);
	}

	public void setConditionCity(String op, java.lang.String val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectCity(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionDetailAddress(String op, java.lang.String val) {
		setConditionDetailAddress(op, val, CONDITION_AND);
	}

	public void setConditionDetailAddress(String op, java.lang.String val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectDetailAddress(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionCustomerAddress(String op, java.lang.String val) {
		setConditionCustomerAddress(op, val, CONDITION_AND);
	}

	public void setConditionCustomerAddress(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectCustomerAddress(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionServiceSuggestBook(String op, java.lang.String val) {
		setConditionServiceSuggestBook(op, val, CONDITION_AND);
	}

	public void setConditionServiceSuggestBook(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectServiceSuggestBook(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionProjectApprovalTime(String op, java.util.Date val) {
		setConditionProjectApprovalTime(op, val, CONDITION_AND);
	}

	public void setConditionProjectApprovalTime(String op, java.util.Date val, String relation) {
		addCondition(33, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectProjectApprovalTime(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionOrderNo(String op, java.lang.Integer val) {
		setConditionOrderNo(op, val, CONDITION_AND);
	}

	public void setConditionOrderNo(String op, java.lang.Integer val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectOrderNo(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionContractStatus(String op, java.lang.Integer val) {
		setConditionContractStatus(op, val, CONDITION_AND);
	}

	public void setConditionContractStatus(String op, java.lang.Integer val, String relation) {
		addCondition(35, op, relation, val);
	}

	public void setSelectContractStatus(boolean val) {
		__select_flags[35] = val;
	}

	public void setConditionJobMix(String op, java.lang.Integer val) {
		setConditionJobMix(op, val, CONDITION_AND);
	}

	public void setConditionJobMix(String op, java.lang.Integer val, String relation) {
		addCondition(36, op, relation, val);
	}

	public void setSelectJobMix(boolean val) {
		__select_flags[36] = val;
	}

	public void setConditionServiceArea(String op, java.math.BigDecimal val) {
		setConditionServiceArea(op, val, CONDITION_AND);
	}

	public void setConditionServiceArea(String op, java.math.BigDecimal val, String relation) {
		addCondition(37, op, relation, val);
	}

	public void setSelectServiceArea(boolean val) {
		__select_flags[37] = val;
	}

	public void setConditionWithTheAmount(String op, java.math.BigDecimal val) {
		setConditionWithTheAmount(op, val, CONDITION_AND);
	}

	public void setConditionWithTheAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(38, op, relation, val);
	}

	public void setSelectWithTheAmount(boolean val) {
		__select_flags[38] = val;
	}

	public void setConditionOnSiteTime(String op, java.lang.Integer val) {
		setConditionOnSiteTime(op, val, CONDITION_AND);
	}

	public void setConditionOnSiteTime(String op, java.lang.Integer val, String relation) {
		addCondition(39, op, relation, val);
	}

	public void setSelectOnSiteTime(boolean val) {
		__select_flags[39] = val;
	}

	public void setConditionOnSiteTotalMoney(String op, java.math.BigDecimal val) {
		setConditionOnSiteTotalMoney(op, val, CONDITION_AND);
	}

	public void setConditionOnSiteTotalMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(40, op, relation, val);
	}

	public void setSelectOnSiteTotalMoney(boolean val) {
		__select_flags[40] = val;
	}

	public void setConditionInfoCode(String op, java.lang.String val) {
		setConditionInfoCode(op, val, CONDITION_AND);
	}

	public void setConditionInfoCode(String op, java.lang.String val, String relation) {
		addCondition(41, op, relation, val);
	}

	public void setSelectInfoCode(boolean val) {
		__select_flags[41] = val;
	}


}

