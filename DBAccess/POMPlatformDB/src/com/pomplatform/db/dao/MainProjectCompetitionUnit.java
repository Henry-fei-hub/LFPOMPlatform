package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseMainProjectCompetitionUnit;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class MainProjectCompetitionUnit extends AbstractTable<BaseMainProjectCompetitionUnit>
{

	public MainProjectCompetitionUnit() throws java.sql.SQLException
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 5;

		initTables();

		__tableName            = "main_project_competition_units";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseMainProjectCompetitionUnit.CS_MAIN_PROJECT_COMPETITION_UNIT_ID;
		__column_names[1] = BaseMainProjectCompetitionUnit.CS_MAIN_PROJECT_ID;
		__column_names[2] = BaseMainProjectCompetitionUnit.CS_COMPETITION_UNIT_ID;
		__column_names[3] = BaseMainProjectCompetitionUnit.CS_PRE_PROJECT_ID;
		__column_names[4] = BaseMainProjectCompetitionUnit.CS_BIDDING_INFORMATION;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseMainProjectCompetitionUnit b) {
		clear();
		setMainProjectCompetitionUnitIdClear(b.getMainProjectCompetitionUnitId());
	}

	public boolean isPrimaryKeyNull() {
		return getMainProjectCompetitionUnitId() == null;
	}

	@Override
	public BaseMainProjectCompetitionUnit generateBase(){
		BaseMainProjectCompetitionUnit b = new BaseMainProjectCompetitionUnit();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseMainProjectCompetitionUnit b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setMainProjectCompetitionUnitId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCompetitionUnitId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPreProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBiddingInformation(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseMainProjectCompetitionUnit b, Object[] buff){
		int count = 0;
		buff[count++] = b.getMainProjectCompetitionUnitId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getCompetitionUnitId();
		buff[count++] = b.getPreProjectId();
		buff[count++] = b.getBiddingInformation();
	}

	@Override
	public void setDataFromBase(BaseMainProjectCompetitionUnit b){
		if(b.getMainProjectCompetitionUnitId() != null) setMainProjectCompetitionUnitIdClear(b.getMainProjectCompetitionUnitId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getCompetitionUnitId() != null) setCompetitionUnitId(b.getCompetitionUnitId());
		if(b.getPreProjectId() != null) setPreProjectId(b.getPreProjectId());
		if(b.getBiddingInformation() != null) setBiddingInformation(b.getBiddingInformation());
	}

	@Override
	public BaseMainProjectCompetitionUnit generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseMainProjectCompetitionUnit b = new BaseMainProjectCompetitionUnit();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseMainProjectCompetitionUnit __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectCompetitionUnitId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCompetitionUnitId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBiddingInformation(GenericBase.__getString(val));
	}

	public void setMainProjectCompetitionUnitId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getMainProjectCompetitionUnitId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setMainProjectCompetitionUnitIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setCompetitionUnitId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getCompetitionUnitId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPreProjectId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPreProjectId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setBiddingInformation(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getBiddingInformation() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setConditionMainProjectCompetitionUnitId(String op, java.lang.Integer val) {
		setConditionMainProjectCompetitionUnitId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectCompetitionUnitId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectMainProjectCompetitionUnitId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCompetitionUnitId(String op, java.lang.Integer val) {
		setConditionCompetitionUnitId(op, val, CONDITION_AND);
	}

	public void setConditionCompetitionUnitId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCompetitionUnitId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val) {
		setConditionPreProjectId(op, val, CONDITION_AND);
	}

	public void setConditionPreProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPreProjectId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBiddingInformation(String op, java.lang.String val) {
		setConditionBiddingInformation(op, val, CONDITION_AND);
	}

	public void setConditionBiddingInformation(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBiddingInformation(boolean val) {
		__select_flags[4] = val;
	}


}
