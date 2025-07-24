package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseTrackTalentsMinimumArrangement;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class TrackTalentsMinimumArrangement extends AbstractTable<BaseTrackTalentsMinimumArrangement>
{

	public TrackTalentsMinimumArrangement() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 11;

		initTables();

		__tableName            = "track_talents_minimum_arrangements";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseTrackTalentsMinimumArrangement.CS_TRACK_TALENTS_MINIMUM_ARRANGEMENT_ID;
		__column_names[1] = BaseTrackTalentsMinimumArrangement.CS_PLATE_ID;
		__column_names[2] = BaseTrackTalentsMinimumArrangement.CS_PROJECT_TYPE;
		__column_names[3] = BaseTrackTalentsMinimumArrangement.CS_MAX_AMOUNT;
		__column_names[4] = BaseTrackTalentsMinimumArrangement.CS_MIN_AMOUNT;
		__column_names[5] = BaseTrackTalentsMinimumArrangement.CS_HIGH_DESIGNER;
		__column_names[6] = BaseTrackTalentsMinimumArrangement.CS_MIDDLE_DESIGNER;
		__column_names[7] = BaseTrackTalentsMinimumArrangement.CS_INITIAL_DESIGNER;
		__column_names[8] = BaseTrackTalentsMinimumArrangement.CS_OPERATE_EMPLOYEE_ID;
		__column_names[9] = BaseTrackTalentsMinimumArrangement.CS_OPERATE_TIME;
		__column_names[10] = BaseTrackTalentsMinimumArrangement.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseTrackTalentsMinimumArrangement b) {
		clear();
		setTrackTalentsMinimumArrangementIdClear(b.getTrackTalentsMinimumArrangementId());
	}

	public boolean isPrimaryKeyNull() {
		return getTrackTalentsMinimumArrangementId() == null;
	}

	@Override
	public BaseTrackTalentsMinimumArrangement generateBase(){
		BaseTrackTalentsMinimumArrangement b = new BaseTrackTalentsMinimumArrangement();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseTrackTalentsMinimumArrangement b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setTrackTalentsMinimumArrangementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMaxAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMinAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHighDesigner(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMiddleDesigner(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInitialDesigner(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseTrackTalentsMinimumArrangement b, Object[] buff){
		int count = 0;
		buff[count++] = b.getTrackTalentsMinimumArrangementId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getProjectType();
		buff[count++] = b.getMaxAmount();
		buff[count++] = b.getMinAmount();
		buff[count++] = b.getHighDesigner();
		buff[count++] = b.getMiddleDesigner();
		buff[count++] = b.getInitialDesigner();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseTrackTalentsMinimumArrangement b){
		if(b.getTrackTalentsMinimumArrangementId() != null) setTrackTalentsMinimumArrangementIdClear(b.getTrackTalentsMinimumArrangementId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getProjectType() != null) setProjectType(b.getProjectType());
		if(b.getMaxAmount() != null) setMaxAmount(b.getMaxAmount());
		if(b.getMinAmount() != null) setMinAmount(b.getMinAmount());
		if(b.getHighDesigner() != null) setHighDesigner(b.getHighDesigner());
		if(b.getMiddleDesigner() != null) setMiddleDesigner(b.getMiddleDesigner());
		if(b.getInitialDesigner() != null) setInitialDesigner(b.getInitialDesigner());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseTrackTalentsMinimumArrangement generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseTrackTalentsMinimumArrangement b = new BaseTrackTalentsMinimumArrangement();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseTrackTalentsMinimumArrangement __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTrackTalentsMinimumArrangementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMaxAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMinAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHighDesigner(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMiddleDesigner(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInitialDesigner(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setTrackTalentsMinimumArrangementId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getTrackTalentsMinimumArrangementId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setTrackTalentsMinimumArrangementIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProjectType(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProjectType() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setMaxAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getMaxAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setMinAmount(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getMinAmount() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setHighDesigner(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getHighDesigner() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setMiddleDesigner(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMiddleDesigner() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setInitialDesigner(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getInitialDesigner() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setConditionTrackTalentsMinimumArrangementId(String op, java.lang.Integer val) {
		setConditionTrackTalentsMinimumArrangementId(op, val, CONDITION_AND);
	}

	public void setConditionTrackTalentsMinimumArrangementId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectTrackTalentsMinimumArrangementId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProjectType(String op, java.lang.Integer val) {
		setConditionProjectType(op, val, CONDITION_AND);
	}

	public void setConditionProjectType(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProjectType(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionMaxAmount(String op, java.math.BigDecimal val) {
		setConditionMaxAmount(op, val, CONDITION_AND);
	}

	public void setConditionMaxAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectMaxAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionMinAmount(String op, java.math.BigDecimal val) {
		setConditionMinAmount(op, val, CONDITION_AND);
	}

	public void setConditionMinAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectMinAmount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionHighDesigner(String op, java.lang.Integer val) {
		setConditionHighDesigner(op, val, CONDITION_AND);
	}

	public void setConditionHighDesigner(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectHighDesigner(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMiddleDesigner(String op, java.lang.Integer val) {
		setConditionMiddleDesigner(op, val, CONDITION_AND);
	}

	public void setConditionMiddleDesigner(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMiddleDesigner(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionInitialDesigner(String op, java.lang.Integer val) {
		setConditionInitialDesigner(op, val, CONDITION_AND);
	}

	public void setConditionInitialDesigner(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectInitialDesigner(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[10] = val;
	}


}

