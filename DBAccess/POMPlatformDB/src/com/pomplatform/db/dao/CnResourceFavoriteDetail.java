package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BaseCnResourceFavoriteDetail;


public class CnResourceFavoriteDetail extends AbstractTable<BaseCnResourceFavoriteDetail>
{

	public CnResourceFavoriteDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 6;

		initTables();

		__tableName            = "cn_resource_favorite_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCnResourceFavoriteDetail.CS_RESOURCE_FAVORITE_DETAIL_ID;
		__column_names[1] = BaseCnResourceFavoriteDetail.CS_RESOURCE_FAVORITE_ID;
		__column_names[2] = BaseCnResourceFavoriteDetail.CS_RESOURCE_ID;
		__column_names[3] = BaseCnResourceFavoriteDetail.CS_DESCRIPTION;
		__column_names[4] = BaseCnResourceFavoriteDetail.CS_CREATE_TIME;
		__column_names[5] = BaseCnResourceFavoriteDetail.CS_ORGANIZATION_ID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCnResourceFavoriteDetail b) {
		clear();
		setResourceFavoriteDetailIdClear(b.getResourceFavoriteDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getResourceFavoriteDetailId() == null;
	}

	@Override
	public BaseCnResourceFavoriteDetail generateBase(){
		BaseCnResourceFavoriteDetail b = new BaseCnResourceFavoriteDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCnResourceFavoriteDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setResourceFavoriteDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResourceFavoriteId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setResourceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOrganizationId(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseCnResourceFavoriteDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getResourceFavoriteDetailId();
		buff[count++] = b.getResourceFavoriteId();
		buff[count++] = b.getResourceId();
		buff[count++] = b.getDescription();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOrganizationId();
	}

	@Override
	public void setDataFromBase(BaseCnResourceFavoriteDetail b){
		if(b.getResourceFavoriteDetailId() != null) setResourceFavoriteDetailIdClear(b.getResourceFavoriteDetailId());
		if(b.getResourceFavoriteId() != null) setResourceFavoriteId(b.getResourceFavoriteId());
		if(b.getResourceId() != null) setResourceId(b.getResourceId());
		if(b.getDescription() != null) setDescription(b.getDescription());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOrganizationId() != null) setOrganizationId(b.getOrganizationId());
	}

	@Override
	public BaseCnResourceFavoriteDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCnResourceFavoriteDetail b = new BaseCnResourceFavoriteDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCnResourceFavoriteDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceFavoriteDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceFavoriteId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setResourceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrganizationId(GenericBase.__getInt(val));
	}

	public void setResourceFavoriteDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getResourceFavoriteDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setResourceFavoriteDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setResourceFavoriteId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getResourceFavoriteId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setResourceId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getResourceId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setDescription(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getDescription() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setOrganizationId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOrganizationId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setConditionResourceFavoriteDetailId(String op, java.lang.Integer val) {
		setConditionResourceFavoriteDetailId(op, val, CONDITION_AND);
	}

	public void setConditionResourceFavoriteDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectResourceFavoriteDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionResourceFavoriteId(String op, java.lang.Integer val) {
		setConditionResourceFavoriteId(op, val, CONDITION_AND);
	}

	public void setConditionResourceFavoriteId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectResourceFavoriteId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionResourceId(String op, java.lang.Integer val) {
		setConditionResourceId(op, val, CONDITION_AND);
	}

	public void setConditionResourceId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectResourceId(boolean val) {
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

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val) {
		setConditionOrganizationId(op, val, CONDITION_AND);
	}

	public void setConditionOrganizationId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOrganizationId(boolean val) {
		__select_flags[5] = val;
	}


}

