package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseSealKeeper;


public class SealKeeper extends AbstractTable<BaseSealKeeper>
{

	public SealKeeper() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 10;

		initTables();

		__tableName            = "seal_keepers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSealKeeper.CS_SEAL_KEEPER_ID;
		__column_names[1] = BaseSealKeeper.CS_SEAL_NAME;
		__column_names[2] = BaseSealKeeper.CS_EMPLOYEE_ID;
		__column_names[3] = BaseSealKeeper.CS_CREAT_TIME;
		__column_names[4] = BaseSealKeeper.CS_OPERATOR_ID;
		__column_names[5] = BaseSealKeeper.CS_DELETE_FLAG;
		__column_names[6] = BaseSealKeeper.CS_COMPANY_ID;
		__column_names[7] = BaseSealKeeper.CS_NUMBER;
		__column_names[8] = BaseSealKeeper.CS_SEAL_TYPE;
		__column_names[9] = BaseSealKeeper.CS_REMARKS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSealKeeper b) {
		clear();
		setSealKeeperIdClear(b.getSealKeeperId());
	}

	public boolean isPrimaryKeyNull() {
		return getSealKeeperId() == null;
	}

	@Override
	public BaseSealKeeper generateBase(){
		BaseSealKeeper b = new BaseSealKeeper();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSealKeeper b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSealKeeperId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSealName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreatTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompanyId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSealType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemarks(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseSealKeeper b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSealKeeperId();
		buff[count++] = b.getSealName();
		buff[count++] = b.getEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreatTime());
		buff[count++] = b.getOperatorId();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getCompanyId();
		buff[count++] = b.getNumber();
		buff[count++] = b.getSealType();
		buff[count++] = b.getRemarks();
	}

	@Override
	public void setDataFromBase(BaseSealKeeper b){
		if(b.getSealKeeperId() != null) setSealKeeperIdClear(b.getSealKeeperId());
		if(b.getSealName() != null) setSealName(b.getSealName());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getCreatTime() != null) setCreatTime(b.getCreatTime());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getCompanyId() != null) setCompanyId(b.getCompanyId());
		if(b.getNumber() != null) setNumber(b.getNumber());
		if(b.getSealType() != null) setSealType(b.getSealType());
		if(b.getRemarks() != null) setRemarks(b.getRemarks());
	}

	@Override
	public BaseSealKeeper generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSealKeeper b = new BaseSealKeeper();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSealKeeper __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSealKeeperId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSealName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreatTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSealType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemarks(GenericBase.__getString(val));
	}

	public void setSealKeeperId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSealKeeperId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSealKeeperIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSealName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSealName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setCreatTime(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getCreatTime() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCompanyId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getCompanyId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setNumber(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getNumber() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setSealType(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getSealType() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setRemarks(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getRemarks() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setConditionSealKeeperId(String op, java.lang.Integer val) {
		setConditionSealKeeperId(op, val, CONDITION_AND);
	}

	public void setConditionSealKeeperId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSealKeeperId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSealName(String op, java.lang.String val) {
		setConditionSealName(op, val, CONDITION_AND);
	}

	public void setConditionSealName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSealName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionCreatTime(String op, java.util.Date val) {
		setConditionCreatTime(op, val, CONDITION_AND);
	}

	public void setConditionCreatTime(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreatTime(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCompanyId(String op, java.lang.Integer val) {
		setConditionCompanyId(op, val, CONDITION_AND);
	}

	public void setConditionCompanyId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectCompanyId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionNumber(String op, java.lang.Integer val) {
		setConditionNumber(op, val, CONDITION_AND);
	}

	public void setConditionNumber(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectNumber(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSealType(String op, java.lang.Integer val) {
		setConditionSealType(op, val, CONDITION_AND);
	}

	public void setConditionSealType(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSealType(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionRemarks(String op, java.lang.String val) {
		setConditionRemarks(op, val, CONDITION_AND);
	}

	public void setConditionRemarks(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectRemarks(boolean val) {
		__select_flags[9] = val;
	}


}

