package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseK3Code;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class K3Code extends AbstractTable<BaseK3Code>
{

	public K3Code() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "k3_codes";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseK3Code.CS_K3_CODE_ID;
		__column_names[1] = BaseK3Code.CS_TYPE;
		__column_names[2] = BaseK3Code.CS_BUSINESS_ID;
		__column_names[3] = BaseK3Code.CS_K3_CODE;
		__column_names[4] = BaseK3Code.CS_K3_NAME;
		__column_names[5] = BaseK3Code.CS_DEPARTMENT_TYPE;
		__column_names[6] = BaseK3Code.CS_ADDITIONAL_BUSINESS_ID;
		__column_names[7] = BaseK3Code.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseK3Code b) {
		clear();
		setK3CodeIdClear(b.getK3CodeId());
	}

	public boolean isPrimaryKeyNull() {
		return getK3CodeId() == null;
	}

	@Override
	public BaseK3Code generateBase(){
		BaseK3Code b = new BaseK3Code();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseK3Code b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setK3CodeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setK3Code(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setK3Name(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDepartmentType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAdditionalBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseK3Code b, Object[] buff){
		int count = 0;
		buff[count++] = b.getK3CodeId();
		buff[count++] = b.getType();
		buff[count++] = b.getBusinessId();
		buff[count++] = b.getK3Code();
		buff[count++] = b.getK3Name();
		buff[count++] = b.getDepartmentType();
		buff[count++] = b.getAdditionalBusinessId();
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseK3Code b){
		if(b.getK3CodeId() != null) setK3CodeIdClear(b.getK3CodeId());
		if(b.getType() != null) setType(b.getType());
		if(b.getBusinessId() != null) setBusinessId(b.getBusinessId());
		if(b.getK3Code() != null) setK3Code(b.getK3Code());
		if(b.getK3Name() != null) setK3Name(b.getK3Name());
		if(b.getDepartmentType() != null) setDepartmentType(b.getDepartmentType());
		if(b.getAdditionalBusinessId() != null) setAdditionalBusinessId(b.getAdditionalBusinessId());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseK3Code generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseK3Code b = new BaseK3Code();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseK3Code __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setK3CodeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setK3Code(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setK3Name(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdditionalBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setK3CodeId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getK3CodeId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setK3CodeIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setBusinessId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getBusinessId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setK3Code(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getK3Code() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setK3Name(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getK3Name() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDepartmentType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getDepartmentType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setAdditionalBusinessId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getAdditionalBusinessId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setConditionK3CodeId(String op, java.lang.Integer val) {
		setConditionK3CodeId(op, val, CONDITION_AND);
	}

	public void setConditionK3CodeId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectK3CodeId(boolean val) {
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

	public void setConditionBusinessId(String op, java.lang.Integer val) {
		setConditionBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectBusinessId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionK3Code(String op, java.lang.String val) {
		setConditionK3Code(op, val, CONDITION_AND);
	}

	public void setConditionK3Code(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectK3Code(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionK3Name(String op, java.lang.String val) {
		setConditionK3Name(op, val, CONDITION_AND);
	}

	public void setConditionK3Name(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectK3Name(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDepartmentType(String op, java.lang.Integer val) {
		setConditionDepartmentType(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDepartmentType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAdditionalBusinessId(String op, java.lang.Integer val) {
		setConditionAdditionalBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionAdditionalBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAdditionalBusinessId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[7] = val;
	}


}

