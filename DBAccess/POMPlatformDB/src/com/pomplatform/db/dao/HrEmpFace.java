package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseHrEmpFace;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class HrEmpFace extends AbstractTable<BaseHrEmpFace>
{

	public HrEmpFace() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 9;

		initTables();

		__tableName            = "hr_emp_faces";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseHrEmpFace.CS_HR_EMP_FACE_ID;
		__column_names[1] = BaseHrEmpFace.CS_EMPLOYEE_ID;
		__column_names[2] = BaseHrEmpFace.CS_SN;
		__column_names[3] = BaseHrEmpFace.CS_EMP_CODE;
		__column_names[4] = BaseHrEmpFace.CS_TMP;
		__column_names[5] = BaseHrEmpFace.CS_SIZE;
		__column_names[6] = BaseHrEmpFace.CS_VALID;
		__column_names[7] = BaseHrEmpFace.CS_ENABLED;
		__column_names[8] = BaseHrEmpFace.CS_FID;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseHrEmpFace b) {
		clear();
		setHrEmpFaceIdClear(b.getHrEmpFaceId());
	}

	public boolean isPrimaryKeyNull() {
		return getHrEmpFaceId() == null;
	}

	@Override
	public BaseHrEmpFace generateBase(){
		BaseHrEmpFace b = new BaseHrEmpFace();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseHrEmpFace b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setHrEmpFaceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmpCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTmp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSize(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setValid(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEnabled(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setFid(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseHrEmpFace b, Object[] buff){
		int count = 0;
		buff[count++] = b.getHrEmpFaceId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getSn();
		buff[count++] = b.getEmpCode();
		buff[count++] = b.getTmp();
		buff[count++] = b.getSize();
		buff[count++] = b.getValid();
		buff[count++] = b.getEnabled();
		buff[count++] = b.getFid();
	}

	@Override
	public void setDataFromBase(BaseHrEmpFace b){
		if(b.getHrEmpFaceId() != null) setHrEmpFaceIdClear(b.getHrEmpFaceId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getSn() != null) setSn(b.getSn());
		if(b.getEmpCode() != null) setEmpCode(b.getEmpCode());
		if(b.getTmp() != null) setTmp(b.getTmp());
		if(b.getSize() != null) setSize(b.getSize());
		if(b.getValid() != null) setValid(b.getValid());
		if(b.getEnabled() != null) setEnabled(b.getEnabled());
		if(b.getFid() != null) setFid(b.getFid());
	}

	@Override
	public BaseHrEmpFace generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseHrEmpFace b = new BaseHrEmpFace();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseHrEmpFace __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHrEmpFaceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmpCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTmp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSize(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setValid(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFid(GenericBase.__getInt(val));
	}

	public void setHrEmpFaceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getHrEmpFaceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setHrEmpFaceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSn(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getSn() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setEmpCode(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getEmpCode() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setTmp(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getTmp() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setSize(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getSize() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setValid(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getValid() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setEnabled(java.lang.Boolean val) {
		setCurrentData(7, val);
	}

	public java.lang.Boolean getEnabled() {
		return GenericBase.__getBoolean(__current_data[7]);
	}

	public void setFid(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getFid() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setConditionHrEmpFaceId(String op, java.lang.Integer val) {
		setConditionHrEmpFaceId(op, val, CONDITION_AND);
	}

	public void setConditionHrEmpFaceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectHrEmpFaceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSn(String op, java.lang.String val) {
		setConditionSn(op, val, CONDITION_AND);
	}

	public void setConditionSn(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSn(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmpCode(String op, java.lang.String val) {
		setConditionEmpCode(op, val, CONDITION_AND);
	}

	public void setConditionEmpCode(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmpCode(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTmp(String op, java.lang.String val) {
		setConditionTmp(op, val, CONDITION_AND);
	}

	public void setConditionTmp(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTmp(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSize(String op, java.lang.Integer val) {
		setConditionSize(op, val, CONDITION_AND);
	}

	public void setConditionSize(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSize(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionValid(String op, java.lang.Integer val) {
		setConditionValid(op, val, CONDITION_AND);
	}

	public void setConditionValid(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectValid(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionEnabled(String op, java.lang.Boolean val) {
		setConditionEnabled(op, val, CONDITION_AND);
	}

	public void setConditionEnabled(String op, java.lang.Boolean val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectEnabled(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionFid(String op, java.lang.Integer val) {
		setConditionFid(op, val, CONDITION_AND);
	}

	public void setConditionFid(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectFid(boolean val) {
		__select_flags[8] = val;
	}


}

