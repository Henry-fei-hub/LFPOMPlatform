package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnResourceFavorite;


public class CnResourceFavorite extends AbstractTable<BaseCnResourceFavorite>
{

	public CnResourceFavorite() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "cn_resource_favorites";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnResourceFavorite.CS_RESOURCE_FAVORITE_ID;
		__column_names[1] = BaseCnResourceFavorite.CS_TYPE;
		__column_names[2] = BaseCnResourceFavorite.CS_NAME;
		__column_names[3] = BaseCnResourceFavorite.CS_DESCRIPTION;
		__column_names[4] = BaseCnResourceFavorite.CS_PRIVATE_STATUS;
		__column_names[5] = BaseCnResourceFavorite.CS_CREATOR;
		__column_names[6] = BaseCnResourceFavorite.CS_CREATE_TIME;
		__column_names[7] = BaseCnResourceFavorite.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnResourceFavorite b) {
		clear();
		setResourceFavoriteIdClear(b.getResourceFavoriteId());
	}

	public boolean isPrimaryKeyNull() {
		return getResourceFavoriteId() == null;
	}

	@Override
	public BaseCnResourceFavorite generateBase(){
		BaseCnResourceFavorite b = new BaseCnResourceFavorite();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnResourceFavorite b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResourceFavoriteId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPrivateStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreator(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnResourceFavorite b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResourceFavoriteId();
		buff[count++] = b.getType();
		buff[count++] = b.getName();
		buff[count++] = b.getDescription();
		buff[count++] = b.getPrivateStatus();
		buff[count++] = b.getCreator();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnResourceFavorite b){
		if(b.getResourceFavoriteId() != null) setResourceFavoriteIdClear(b.getResourceFavoriteId());
		if(b.getType() != null) setType(b.getType());
		if(b.getName() != null) setName(b.getName());
		if(b.getDescription() != null) setDescription(b.getDescription());
		if(b.getPrivateStatus() != null) setPrivateStatus(b.getPrivateStatus());
		if(b.getCreator() != null) setCreator(b.getCreator());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnResourceFavorite generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnResourceFavorite b = new BaseCnResourceFavorite();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnResourceFavorite __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceFavoriteId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPrivateStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreator(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setResourceFavoriteId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResourceFavoriteId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setResourceFavoriteIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setDescription(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getDescription() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setPrivateStatus(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPrivateStatus() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreator(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCreator() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setConditionResourceFavoriteId(String op, java.lang.Integer val) {
		setConditionResourceFavoriteId(op, val, CONDITION_AND);
	}

	public void setConditionResourceFavoriteId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResourceFavoriteId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionName(String op, java.lang.String val) {
		setConditionName(op, val, CONDITION_AND);
	}

	public void setConditionName(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectName(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDescription(String op, java.lang.String val) {
		setConditionDescription(op, val, CONDITION_AND);
	}

	public void setConditionDescription(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDescription(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPrivateStatus(String op, java.lang.Integer val) {
		setConditionPrivateStatus(op, val, CONDITION_AND);
	}

	public void setConditionPrivateStatus(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPrivateStatus(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreator(String op, java.lang.Integer val) {
		setConditionCreator(op, val, CONDITION_AND);
	}

	public void setConditionCreator(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCreator(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(6, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[7] = val;
	}


}

