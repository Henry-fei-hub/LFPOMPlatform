package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseGoodsReceiveDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class GoodsReceiveDetail extends AbstractTable<BaseGoodsReceiveDetail>
{

	public GoodsReceiveDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "goods_receive_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseGoodsReceiveDetail.CS_GOODS_RECEIVE_DETAIL_ID;
		__column_names[1] = BaseGoodsReceiveDetail.CS_GOODS_RECEIVE_ID;
		__column_names[2] = BaseGoodsReceiveDetail.CS_EMPLOYEE_ID;
		__column_names[3] = BaseGoodsReceiveDetail.CS_EMPLOYEE_NUMBER;
		__column_names[4] = BaseGoodsReceiveDetail.CS_DEPARTMENT_ID;
		__column_names[5] = BaseGoodsReceiveDetail.CS_RECEIVE_TIME;
		__column_names[6] = BaseGoodsReceiveDetail.CS_EMPLOYEE_NAME;
		__column_names[7] = BaseGoodsReceiveDetail.CS_IS_RECEIVE;
		__column_names[8] = BaseGoodsReceiveDetail.CS_RECEIVE_COUNT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseGoodsReceiveDetail b) {
		clear();
		setGoodsReceiveDetailIdClear(b.getGoodsReceiveDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getGoodsReceiveDetailId() == null;
	}

	@Override
	public BaseGoodsReceiveDetail generateBase(){
		BaseGoodsReceiveDetail b = new BaseGoodsReceiveDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseGoodsReceiveDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setGoodsReceiveDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setGoodsReceiveId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNumber(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiveTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsReceive(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiveCount(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseGoodsReceiveDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getGoodsReceiveDetailId();
		buff[count++] = b.getGoodsReceiveId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNumber();
		buff[count++] = b.getDepartmentId();
		buff[count++] = generateTimestampFromDate(b.getReceiveTime());
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getIsReceive();
		buff[count++] = b.getReceiveCount();
	}

	@Override
	public void setDataFromBase(BaseGoodsReceiveDetail b){
		if(b.getGoodsReceiveDetailId() != null) setGoodsReceiveDetailIdClear(b.getGoodsReceiveDetailId());
		if(b.getGoodsReceiveId() != null) setGoodsReceiveId(b.getGoodsReceiveId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNumber() != null) setEmployeeNumber(b.getEmployeeNumber());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getReceiveTime() != null) setReceiveTime(b.getReceiveTime());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getIsReceive() != null) setIsReceive(b.getIsReceive());
		if(b.getReceiveCount() != null) setReceiveCount(b.getReceiveCount());
	}

	@Override
	public BaseGoodsReceiveDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseGoodsReceiveDetail b = new BaseGoodsReceiveDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseGoodsReceiveDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGoodsReceiveDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGoodsReceiveId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNumber(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReceive(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveCount(GenericBase.__getInt(val));
	}

	public void setGoodsReceiveDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getGoodsReceiveDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setGoodsReceiveDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setGoodsReceiveId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getGoodsReceiveId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeNumber(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmployeeNumber() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setReceiveTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getReceiveTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setIsReceive(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getIsReceive() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setReceiveCount(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getReceiveCount() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionGoodsReceiveDetailId(String op, java.lang.Integer val) {
		setConditionGoodsReceiveDetailId(op, val, CONDITION_AND);
	}

	public void setConditionGoodsReceiveDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectGoodsReceiveDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionGoodsReceiveId(String op, java.lang.Integer val) {
		setConditionGoodsReceiveId(op, val, CONDITION_AND);
	}

	public void setConditionGoodsReceiveId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectGoodsReceiveId(boolean val) {
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

	public void setConditionEmployeeNumber(String op, java.lang.String val) {
		setConditionEmployeeNumber(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNumber(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeNumber(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionReceiveTime(String op, java.util.Date val) {
		setConditionReceiveTime(op, val, CONDITION_AND);
	}

	public void setConditionReceiveTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectReceiveTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionIsReceive(String op, java.lang.Integer val) {
		setConditionIsReceive(op, val, CONDITION_AND);
	}

	public void setConditionIsReceive(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectIsReceive(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionReceiveCount(String op, java.lang.Integer val) {
		setConditionReceiveCount(op, val, CONDITION_AND);
	}

	public void setConditionReceiveCount(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectReceiveCount(boolean val) {
		__select_flags[8] = val;
	}


}

