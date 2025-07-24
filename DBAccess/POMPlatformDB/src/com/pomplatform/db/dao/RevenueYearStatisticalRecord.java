package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseRevenueYearStatisticalRecord;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class RevenueYearStatisticalRecord extends AbstractTable<BaseRevenueYearStatisticalRecord>
{

	public RevenueYearStatisticalRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 19;

		initTables();

		__tableName            = "revenue_year_statistical_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseRevenueYearStatisticalRecord.CS_REVENUE_YEAR_STATISTICAL_RECORD_ID;
		__column_names[1] = BaseRevenueYearStatisticalRecord.CS_PROJECT_ID;
		__column_names[2] = BaseRevenueYearStatisticalRecord.CS_YEAR;
		__column_names[3] = BaseRevenueYearStatisticalRecord.CS_JANUARY_REVENUE;
		__column_names[4] = BaseRevenueYearStatisticalRecord.CS_FEBRUARY_REVENUE;
		__column_names[5] = BaseRevenueYearStatisticalRecord.CS_MARCH_REVENUE;
		__column_names[6] = BaseRevenueYearStatisticalRecord.CS_APRIL_REVENUE;
		__column_names[7] = BaseRevenueYearStatisticalRecord.CS_MAY_REVENUE;
		__column_names[8] = BaseRevenueYearStatisticalRecord.CS_JUNE_REVENUE;
		__column_names[9] = BaseRevenueYearStatisticalRecord.CS_JULY_REVENUE;
		__column_names[10] = BaseRevenueYearStatisticalRecord.CS_AUGUST_REVENUE;
		__column_names[11] = BaseRevenueYearStatisticalRecord.CS_SEPTEMBER_REVENUE;
		__column_names[12] = BaseRevenueYearStatisticalRecord.CS_OCTOBER_REVENUE;
		__column_names[13] = BaseRevenueYearStatisticalRecord.CS_NOVEMBER_REVENUE;
		__column_names[14] = BaseRevenueYearStatisticalRecord.CS_DECEMBER_REVENUE;
		__column_names[15] = BaseRevenueYearStatisticalRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[16] = BaseRevenueYearStatisticalRecord.CS_OPERATE_TIME;
		__column_names[17] = BaseRevenueYearStatisticalRecord.CS_REMARK;
		__column_names[18] = BaseRevenueYearStatisticalRecord.CS_IS_LOCKED;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseRevenueYearStatisticalRecord b) {
		clear();
		setRevenueYearStatisticalRecordIdClear(b.getRevenueYearStatisticalRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getRevenueYearStatisticalRecordId() == null;
	}

	@Override
	public BaseRevenueYearStatisticalRecord generateBase(){
		BaseRevenueYearStatisticalRecord b = new BaseRevenueYearStatisticalRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseRevenueYearStatisticalRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setRevenueYearStatisticalRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setYear(GenericBase.__getInt(val));
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
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsLocked(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseRevenueYearStatisticalRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getRevenueYearStatisticalRecordId();
		buff[count++] = b.getProjectId();
		buff[count++] = b.getYear();
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
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getIsLocked();
	}

	@Override
	public void setDataFromBase(BaseRevenueYearStatisticalRecord b){
		if(b.getRevenueYearStatisticalRecordId() != null) setRevenueYearStatisticalRecordIdClear(b.getRevenueYearStatisticalRecordId());
		if(b.getProjectId() != null) setProjectId(b.getProjectId());
		if(b.getYear() != null) setYear(b.getYear());
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
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getIsLocked() != null) setIsLocked(b.getIsLocked());
	}

	@Override
	public BaseRevenueYearStatisticalRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseRevenueYearStatisticalRecord b = new BaseRevenueYearStatisticalRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseRevenueYearStatisticalRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRevenueYearStatisticalRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setYear(GenericBase.__getInt(val));
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
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLocked(GenericBase.__getBoolean(val));
	}

	public void setRevenueYearStatisticalRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getRevenueYearStatisticalRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setRevenueYearStatisticalRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setYear(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getYear() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setJanuaryRevenue(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getJanuaryRevenue() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setFebruaryRevenue(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getFebruaryRevenue() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setMarchRevenue(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getMarchRevenue() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setAprilRevenue(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getAprilRevenue() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setMayRevenue(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getMayRevenue() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setJuneRevenue(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getJuneRevenue() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setJulyRevenue(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getJulyRevenue() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setAugustRevenue(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getAugustRevenue() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setSeptemberRevenue(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getSeptemberRevenue() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setOctoberRevenue(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getOctoberRevenue() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setNovemberRevenue(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getNovemberRevenue() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setDecemberRevenue(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getDecemberRevenue() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setIsLocked(java.lang.Boolean val) {
		setCurrentData(18, val);
	}

	public java.lang.Boolean getIsLocked() {
		return GenericBase.__getBoolean(__current_data[18]);
	}

	public void setConditionRevenueYearStatisticalRecordId(String op, java.lang.Integer val) {
		setConditionRevenueYearStatisticalRecordId(op, val, CONDITION_AND);
	}

	public void setConditionRevenueYearStatisticalRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectRevenueYearStatisticalRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectId(String op, java.lang.Integer val) {
		setConditionProjectId(op, val, CONDITION_AND);
	}

	public void setConditionProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionYear(String op, java.lang.Integer val) {
		setConditionYear(op, val, CONDITION_AND);
	}

	public void setConditionYear(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectYear(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionJanuaryRevenue(String op, java.math.BigDecimal val) {
		setConditionJanuaryRevenue(op, val, CONDITION_AND);
	}

	public void setConditionJanuaryRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectJanuaryRevenue(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionFebruaryRevenue(String op, java.math.BigDecimal val) {
		setConditionFebruaryRevenue(op, val, CONDITION_AND);
	}

	public void setConditionFebruaryRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectFebruaryRevenue(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMarchRevenue(String op, java.math.BigDecimal val) {
		setConditionMarchRevenue(op, val, CONDITION_AND);
	}

	public void setConditionMarchRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMarchRevenue(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAprilRevenue(String op, java.math.BigDecimal val) {
		setConditionAprilRevenue(op, val, CONDITION_AND);
	}

	public void setConditionAprilRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAprilRevenue(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionMayRevenue(String op, java.math.BigDecimal val) {
		setConditionMayRevenue(op, val, CONDITION_AND);
	}

	public void setConditionMayRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectMayRevenue(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionJuneRevenue(String op, java.math.BigDecimal val) {
		setConditionJuneRevenue(op, val, CONDITION_AND);
	}

	public void setConditionJuneRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectJuneRevenue(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionJulyRevenue(String op, java.math.BigDecimal val) {
		setConditionJulyRevenue(op, val, CONDITION_AND);
	}

	public void setConditionJulyRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectJulyRevenue(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionAugustRevenue(String op, java.math.BigDecimal val) {
		setConditionAugustRevenue(op, val, CONDITION_AND);
	}

	public void setConditionAugustRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectAugustRevenue(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSeptemberRevenue(String op, java.math.BigDecimal val) {
		setConditionSeptemberRevenue(op, val, CONDITION_AND);
	}

	public void setConditionSeptemberRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSeptemberRevenue(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOctoberRevenue(String op, java.math.BigDecimal val) {
		setConditionOctoberRevenue(op, val, CONDITION_AND);
	}

	public void setConditionOctoberRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectOctoberRevenue(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionNovemberRevenue(String op, java.math.BigDecimal val) {
		setConditionNovemberRevenue(op, val, CONDITION_AND);
	}

	public void setConditionNovemberRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectNovemberRevenue(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionDecemberRevenue(String op, java.math.BigDecimal val) {
		setConditionDecemberRevenue(op, val, CONDITION_AND);
	}

	public void setConditionDecemberRevenue(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectDecemberRevenue(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
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

	public void setConditionIsLocked(String op, java.lang.Boolean val) {
		setConditionIsLocked(op, val, CONDITION_AND);
	}

	public void setConditionIsLocked(String op, java.lang.Boolean val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectIsLocked(boolean val) {
		__select_flags[18] = val;
	}


}

