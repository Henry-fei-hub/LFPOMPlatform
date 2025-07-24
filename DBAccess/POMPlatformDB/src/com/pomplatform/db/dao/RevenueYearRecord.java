package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseRevenueYearRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class RevenueYearRecord extends AbstractTable<BaseRevenueYearRecord>
{

	public RevenueYearRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 25;

		initTables();

		__tableName            = "revenue_year_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseRevenueYearRecord.CS_REVENUE_YEAR_RECORD_ID;
		__column_names[1] = BaseRevenueYearRecord.CS_CONTRACT_ID;
		__column_names[2] = BaseRevenueYearRecord.CS_CODE;
		__column_names[3] = BaseRevenueYearRecord.CS_NAME;
		__column_names[4] = BaseRevenueYearRecord.CS_MONEY;
		__column_names[5] = BaseRevenueYearRecord.CS_JANUARY_REVENUE;
		__column_names[6] = BaseRevenueYearRecord.CS_FEBRUARY_REVENUE;
		__column_names[7] = BaseRevenueYearRecord.CS_MARCH_REVENUE;
		__column_names[8] = BaseRevenueYearRecord.CS_APRIL_REVENUE;
		__column_names[9] = BaseRevenueYearRecord.CS_MAY_REVENUE;
		__column_names[10] = BaseRevenueYearRecord.CS_JUNE_REVENUE;
		__column_names[11] = BaseRevenueYearRecord.CS_JULY_REVENUE;
		__column_names[12] = BaseRevenueYearRecord.CS_AUGUST_REVENUE;
		__column_names[13] = BaseRevenueYearRecord.CS_SEPTEMBER_REVENUE;
		__column_names[14] = BaseRevenueYearRecord.CS_OCTOBER_REVENUE;
		__column_names[15] = BaseRevenueYearRecord.CS_NOVEMBER_REVENUE;
		__column_names[16] = BaseRevenueYearRecord.CS_DECEMBER_REVENUE;
		__column_names[17] = BaseRevenueYearRecord.CS_TOTAL_REVENUE;
		__column_names[18] = BaseRevenueYearRecord.CS_PARENT_ID;
		__column_names[19] = BaseRevenueYearRecord.CS_YEAR_REVENUE;
		__column_names[20] = BaseRevenueYearRecord.CS_FLAG;
		__column_names[21] = BaseRevenueYearRecord.CS_SIGNING_COMPANY;
		__column_names[22] = BaseRevenueYearRecord.CS_IS_FINISH;
		__column_names[23] = BaseRevenueYearRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[24] = BaseRevenueYearRecord.CS_OPERATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseRevenueYearRecord b) {
		clear();
		setRevenueYearRecordIdClear(b.getRevenueYearRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getRevenueYearRecordId() == null;
	}

	@Override
	public BaseRevenueYearRecord generateBase(){
		BaseRevenueYearRecord b = new BaseRevenueYearRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseRevenueYearRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setRevenueYearRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMoney(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setJanuaryRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFebruaryRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMarchRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAprilRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMayRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setJuneRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setJulyRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAugustRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSeptemberRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOctoberRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setNovemberRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setDecemberRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalRevenue(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setParentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYearRevenue(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSigningCompany(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsFinish(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseRevenueYearRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getRevenueYearRecordId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getCode();
		buff[count++] = b.getName();
		buff[count++] = b.getMoney();
		buff[count++] = b.getJanuaryRevenue();
		buff[count++] = b.getFebruaryRevenue();
		buff[count++] = b.getMarchRevenue();
		buff[count++] = b.getAprilRevenue();
		buff[count++] = b.getMayRevenue();
		buff[count++] = b.getJuneRevenue();
		buff[count++] = b.getJulyRevenue();
		buff[count++] = b.getAugustRevenue();
		buff[count++] = b.getSeptemberRevenue();
		buff[count++] = b.getOctoberRevenue();
		buff[count++] = b.getNovemberRevenue();
		buff[count++] = b.getDecemberRevenue();
		buff[count++] = b.getTotalRevenue();
		buff[count++] = b.getParentId();
		buff[count++] = b.getYearRevenue();
		buff[count++] = b.getFlag();
		buff[count++] = b.getSigningCompany();
		buff[count++] = b.getIsFinish();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
	}

	@Override
	public void setDataFromBase(BaseRevenueYearRecord b){
		if(b.getRevenueYearRecordId() != null) setRevenueYearRecordIdClear(b.getRevenueYearRecordId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getCode() != null) setCode(b.getCode());
		if(b.getName() != null) setName(b.getName());
		if(b.getMoney() != null) setMoney(b.getMoney());
		if(b.getJanuaryRevenue() != null) setJanuaryRevenue(b.getJanuaryRevenue());
		if(b.getFebruaryRevenue() != null) setFebruaryRevenue(b.getFebruaryRevenue());
		if(b.getMarchRevenue() != null) setMarchRevenue(b.getMarchRevenue());
		if(b.getAprilRevenue() != null) setAprilRevenue(b.getAprilRevenue());
		if(b.getMayRevenue() != null) setMayRevenue(b.getMayRevenue());
		if(b.getJuneRevenue() != null) setJuneRevenue(b.getJuneRevenue());
		if(b.getJulyRevenue() != null) setJulyRevenue(b.getJulyRevenue());
		if(b.getAugustRevenue() != null) setAugustRevenue(b.getAugustRevenue());
		if(b.getSeptemberRevenue() != null) setSeptemberRevenue(b.getSeptemberRevenue());
		if(b.getOctoberRevenue() != null) setOctoberRevenue(b.getOctoberRevenue());
		if(b.getNovemberRevenue() != null) setNovemberRevenue(b.getNovemberRevenue());
		if(b.getDecemberRevenue() != null) setDecemberRevenue(b.getDecemberRevenue());
		if(b.getTotalRevenue() != null) setTotalRevenue(b.getTotalRevenue());
		if(b.getParentId() != null) setParentId(b.getParentId());
		if(b.getYearRevenue() != null) setYearRevenue(b.getYearRevenue());
		if(b.getFlag() != null) setFlag(b.getFlag());
		if(b.getSigningCompany() != null) setSigningCompany(b.getSigningCompany());
		if(b.getIsFinish() != null) setIsFinish(b.getIsFinish());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
	}

	@Override
	public BaseRevenueYearRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseRevenueYearRecord b = new BaseRevenueYearRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseRevenueYearRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenueYearRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setJanuaryRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFebruaryRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMarchRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAprilRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMayRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setJuneRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setJulyRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAugustRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSeptemberRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOctoberRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNovemberRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDecemberRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalRevenue(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setParentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYearRevenue(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSigningCompany(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsFinish(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setRevenueYearRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getRevenueYearRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setRevenueYearRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setMoney(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getMoney() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setJanuaryRevenue(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getJanuaryRevenue() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setFebruaryRevenue(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getFebruaryRevenue() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setMarchRevenue(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getMarchRevenue() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setAprilRevenue(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getAprilRevenue() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setMayRevenue(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getMayRevenue() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setJuneRevenue(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getJuneRevenue() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setJulyRevenue(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getJulyRevenue() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setAugustRevenue(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getAugustRevenue() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setSeptemberRevenue(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getSeptemberRevenue() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setOctoberRevenue(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getOctoberRevenue() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setNovemberRevenue(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getNovemberRevenue() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setDecemberRevenue(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getDecemberRevenue() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setTotalRevenue(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getTotalRevenue() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setParentId(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getParentId() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setYearRevenue(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getYearRevenue() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setFlag(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getFlag() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setSigningCompany(java.lang.Integer val) {
		setCurrentData(21, val);
	}

	public java.lang.Integer getSigningCompany() {
		return GenericBase.__getInt(__current_data[21]);
	}

	public void setIsFinish(java.lang.Boolean val) {
		setCurrentData(22, val);
	}

	public java.lang.Boolean getIsFinish() {
		return GenericBase.__getBoolean(__current_data[22]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(24, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[24]);
	}

	public void setConditionRevenueYearRecordId(String op, java.lang.Integer val) {
		setConditionRevenueYearRecordId(op, val, CONDITION_AND);
	}

	public void setConditionRevenueYearRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectRevenueYearRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCode(String op, java.lang.String val) {
		setConditionCode(op, val, CONDITION_AND);
	}

	public void setConditionCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCode(boolean val) {
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

	public void setConditionMoney(String op, java.math.BigDecimal val) {
		setConditionMoney(op, val, CONDITION_AND);
	}

	public void setConditionMoney(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMoney(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionJanuaryRevenue(String op, java.math.BigDecimal val) {
		setConditionJanuaryRevenue(op, val, CONDITION_AND);
	}

	public void setConditionJanuaryRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectJanuaryRevenue(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFebruaryRevenue(String op, java.math.BigDecimal val) {
		setConditionFebruaryRevenue(op, val, CONDITION_AND);
	}

	public void setConditionFebruaryRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFebruaryRevenue(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMarchRevenue(String op, java.math.BigDecimal val) {
		setConditionMarchRevenue(op, val, CONDITION_AND);
	}

	public void setConditionMarchRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMarchRevenue(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionAprilRevenue(String op, java.math.BigDecimal val) {
		setConditionAprilRevenue(op, val, CONDITION_AND);
	}

	public void setConditionAprilRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectAprilRevenue(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionMayRevenue(String op, java.math.BigDecimal val) {
		setConditionMayRevenue(op, val, CONDITION_AND);
	}

	public void setConditionMayRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectMayRevenue(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionJuneRevenue(String op, java.math.BigDecimal val) {
		setConditionJuneRevenue(op, val, CONDITION_AND);
	}

	public void setConditionJuneRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectJuneRevenue(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionJulyRevenue(String op, java.math.BigDecimal val) {
		setConditionJulyRevenue(op, val, CONDITION_AND);
	}

	public void setConditionJulyRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectJulyRevenue(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionAugustRevenue(String op, java.math.BigDecimal val) {
		setConditionAugustRevenue(op, val, CONDITION_AND);
	}

	public void setConditionAugustRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectAugustRevenue(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionSeptemberRevenue(String op, java.math.BigDecimal val) {
		setConditionSeptemberRevenue(op, val, CONDITION_AND);
	}

	public void setConditionSeptemberRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectSeptemberRevenue(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionOctoberRevenue(String op, java.math.BigDecimal val) {
		setConditionOctoberRevenue(op, val, CONDITION_AND);
	}

	public void setConditionOctoberRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectOctoberRevenue(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionNovemberRevenue(String op, java.math.BigDecimal val) {
		setConditionNovemberRevenue(op, val, CONDITION_AND);
	}

	public void setConditionNovemberRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectNovemberRevenue(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionDecemberRevenue(String op, java.math.BigDecimal val) {
		setConditionDecemberRevenue(op, val, CONDITION_AND);
	}

	public void setConditionDecemberRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectDecemberRevenue(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionTotalRevenue(String op, java.math.BigDecimal val) {
		setConditionTotalRevenue(op, val, CONDITION_AND);
	}

	public void setConditionTotalRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectTotalRevenue(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionParentId(String op, java.lang.Integer val) {
		setConditionParentId(op, val, CONDITION_AND);
	}

	public void setConditionParentId(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectParentId(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionYearRevenue(String op, java.lang.Integer val) {
		setConditionYearRevenue(op, val, CONDITION_AND);
	}

	public void setConditionYearRevenue(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectYearRevenue(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionFlag(String op, java.lang.Integer val) {
		setConditionFlag(op, val, CONDITION_AND);
	}

	public void setConditionFlag(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectFlag(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionSigningCompany(String op, java.lang.Integer val) {
		setConditionSigningCompany(op, val, CONDITION_AND);
	}

	public void setConditionSigningCompany(String op, java.lang.Integer val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectSigningCompany(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionIsFinish(String op, java.lang.Boolean val) {
		setConditionIsFinish(op, val, CONDITION_AND);
	}

	public void setConditionIsFinish(String op, java.lang.Boolean val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectIsFinish(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(24, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[24] = val;
	}


}

