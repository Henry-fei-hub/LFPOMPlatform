package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePlatePerformanceBonusDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PlatePerformanceBonusDetail extends AbstractTable<BasePlatePerformanceBonusDetail>
{

	public PlatePerformanceBonusDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "plate_performance_bonus_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlatePerformanceBonusDetail.CS_PLATE_PERFORMANCE_BONUS_DETAIL_ID;
		__column_names[1] = BasePlatePerformanceBonusDetail.CS_PLATE_PERFORMANCE_BONUS_ID;
		__column_names[2] = BasePlatePerformanceBonusDetail.CS_PLATE_ID;
		__column_names[3] = BasePlatePerformanceBonusDetail.CS_EMPLOYEE_ID;
		__column_names[4] = BasePlatePerformanceBonusDetail.CS_SEND_INTEGRAL;
		__column_names[5] = BasePlatePerformanceBonusDetail.CS_SENDED_INTEGRAL;
		__column_names[6] = BasePlatePerformanceBonusDetail.CS_SEND_DATE;
		__column_names[7] = BasePlatePerformanceBonusDetail.CS_OPERATE_EMPLOYEE_ID;
		__column_names[8] = BasePlatePerformanceBonusDetail.CS_OPERATE_TIME;
		__column_names[9] = BasePlatePerformanceBonusDetail.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlatePerformanceBonusDetail b) {
		clear();
		setPlatePerformanceBonusDetailIdClear(b.getPlatePerformanceBonusDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlatePerformanceBonusDetailId() == null;
	}

	@Override
	public BasePlatePerformanceBonusDetail generateBase(){
		BasePlatePerformanceBonusDetail b = new BasePlatePerformanceBonusDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlatePerformanceBonusDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlatePerformanceBonusDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlatePerformanceBonusId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSendIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSendedIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSendDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BasePlatePerformanceBonusDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlatePerformanceBonusDetailId();
		buff[count++] = b.getPlatePerformanceBonusId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getSendIntegral();
		buff[count++] = b.getSendedIntegral();
		buff[count++] = generateTimestampFromDate(b.getSendDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePlatePerformanceBonusDetail b){
		if(b.getPlatePerformanceBonusDetailId() != null) setPlatePerformanceBonusDetailIdClear(b.getPlatePerformanceBonusDetailId());
		if(b.getPlatePerformanceBonusId() != null) setPlatePerformanceBonusId(b.getPlatePerformanceBonusId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getSendIntegral() != null) setSendIntegral(b.getSendIntegral());
		if(b.getSendedIntegral() != null) setSendedIntegral(b.getSendedIntegral());
		if(b.getSendDate() != null) setSendDate(b.getSendDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePlatePerformanceBonusDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlatePerformanceBonusDetail b = new BasePlatePerformanceBonusDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlatePerformanceBonusDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlatePerformanceBonusDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlatePerformanceBonusId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendedIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPlatePerformanceBonusDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlatePerformanceBonusDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlatePerformanceBonusDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlatePerformanceBonusId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlatePerformanceBonusId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setSendIntegral(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getSendIntegral() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setSendedIntegral(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getSendedIntegral() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setSendDate(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getSendDate() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionPlatePerformanceBonusDetailId(String op, java.lang.Integer val) {
		setConditionPlatePerformanceBonusDetailId(op, val, CONDITION_AND);
	}

	public void setConditionPlatePerformanceBonusDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlatePerformanceBonusDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlatePerformanceBonusId(String op, java.lang.Integer val) {
		setConditionPlatePerformanceBonusId(op, val, CONDITION_AND);
	}

	public void setConditionPlatePerformanceBonusId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlatePerformanceBonusId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSendIntegral(String op, java.math.BigDecimal val) {
		setConditionSendIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSendIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSendIntegral(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSendedIntegral(String op, java.math.BigDecimal val) {
		setConditionSendedIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSendedIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSendedIntegral(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSendDate(String op, java.util.Date val) {
		setConditionSendDate(op, val, CONDITION_AND);
	}

	public void setConditionSendDate(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectSendDate(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[9] = val;
	}


}

