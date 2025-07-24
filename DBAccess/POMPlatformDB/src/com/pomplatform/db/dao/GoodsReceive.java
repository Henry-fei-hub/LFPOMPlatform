package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseGoodsReceive;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class GoodsReceive extends AbstractTable<BaseGoodsReceive>
{

	public GoodsReceive() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "goods_receives";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseGoodsReceive.CS_GOODS_RECEIVE_ID;
		__column_names[1] = BaseGoodsReceive.CS_SUBJECT;
		__column_names[2] = BaseGoodsReceive.CS_RECEIVE_DATE;
		__column_names[3] = BaseGoodsReceive.CS_DEPARTMENT_ID;
		__column_names[4] = BaseGoodsReceive.CS_COUNT;
		__column_names[5] = BaseGoodsReceive.CS_CREATE_PERSON_ID;
		__column_names[6] = BaseGoodsReceive.CS_CREATE_TIME;
		__column_names[7] = BaseGoodsReceive.CS_FILE_MANAGE_ID;
		__column_names[8] = BaseGoodsReceive.CS_GOODS_DETAIL;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseGoodsReceive b) {
		clear();
		setGoodsReceiveIdClear(b.getGoodsReceiveId());
	}

	public boolean isPrimaryKeyNull() {
		return getGoodsReceiveId() == null;
	}

	@Override
	public BaseGoodsReceive generateBase(){
		BaseGoodsReceive b = new BaseGoodsReceive();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseGoodsReceive b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setGoodsReceiveId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubject(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setReceiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCount(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreatePersonId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setFileManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setGoodsDetail(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseGoodsReceive b, Object[] buff){
		int count = 0;
		buff[count++] = b.getGoodsReceiveId();
		buff[count++] = b.getSubject();
		buff[count++] = generateTimestampFromDate(b.getReceiveDate());
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getCount();
		buff[count++] = b.getCreatePersonId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getFileManageId();
		buff[count++] = b.getGoodsDetail();
	}

	@Override
	public void setDataFromBase(BaseGoodsReceive b){
		if(b.getGoodsReceiveId() != null) setGoodsReceiveIdClear(b.getGoodsReceiveId());
		if(b.getSubject() != null) setSubject(b.getSubject());
		if(b.getReceiveDate() != null) setReceiveDate(b.getReceiveDate());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getCount() != null) setCount(b.getCount());
		if(b.getCreatePersonId() != null) setCreatePersonId(b.getCreatePersonId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getFileManageId() != null) setFileManageId(b.getFileManageId());
		if(b.getGoodsDetail() != null) setGoodsDetail(b.getGoodsDetail());
	}

	@Override
	public BaseGoodsReceive generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseGoodsReceive b = new BaseGoodsReceive();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseGoodsReceive __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGoodsReceiveId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubject(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCount(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreatePersonId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGoodsDetail(GenericBase.__getString(val));
	}

	public void setGoodsReceiveId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getGoodsReceiveId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setGoodsReceiveIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSubject(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSubject() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setReceiveDate(java.util.Date val) {
		setCurrentData(2, generateTimestampFromDate(val));
	}

	public java.util.Date getReceiveDate() {
		return GenericBase.__getDateFromSQL(__current_data[2]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setCount(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getCount() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setCreatePersonId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getCreatePersonId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(6, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[6]);
	}

	public void setFileManageId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getFileManageId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setGoodsDetail(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getGoodsDetail() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setConditionGoodsReceiveId(String op, java.lang.Integer val) {
		setConditionGoodsReceiveId(op, val, CONDITION_AND);
	}

	public void setConditionGoodsReceiveId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectGoodsReceiveId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSubject(String op, java.lang.String val) {
		setConditionSubject(op, val, CONDITION_AND);
	}

	public void setConditionSubject(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSubject(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionReceiveDate(String op, java.util.Date val) {
		setConditionReceiveDate(op, val, CONDITION_AND);
	}

	public void setConditionReceiveDate(String op, java.util.Date val, String relation) {
		addCondition(2, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectReceiveDate(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionCount(String op, java.lang.Integer val) {
		setConditionCount(op, val, CONDITION_AND);
	}

	public void setConditionCount(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectCount(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionCreatePersonId(String op, java.lang.Integer val) {
		setConditionCreatePersonId(op, val, CONDITION_AND);
	}

	public void setConditionCreatePersonId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectCreatePersonId(boolean val) {
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

	public void setConditionFileManageId(String op, java.lang.Integer val) {
		setConditionFileManageId(op, val, CONDITION_AND);
	}

	public void setConditionFileManageId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFileManageId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionGoodsDetail(String op, java.lang.String val) {
		setConditionGoodsDetail(op, val, CONDITION_AND);
	}

	public void setConditionGoodsDetail(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectGoodsDetail(boolean val) {
		__select_flags[8] = val;
	}


}

