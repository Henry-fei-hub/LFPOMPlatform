package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseHrEmpFinger;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class HrEmpFinger extends AbstractTable<BaseHrEmpFinger>
{

	public HrEmpFinger() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "hr_emp_fingers";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseHrEmpFinger.CS_HR_EMP_FINGER_ID;
		__column_names[1] = BaseHrEmpFinger.CS_EMPLOYEE_ID;
		__column_names[2] = BaseHrEmpFinger.CS_SN;
		__column_names[3] = BaseHrEmpFinger.CS_EMP_CODE;
		__column_names[4] = BaseHrEmpFinger.CS_TEMPLATE;
		__column_names[5] = BaseHrEmpFinger.CS_FPVERSION;
		__column_names[6] = BaseHrEmpFinger.CS_FINGER_TYPE;
		__column_names[7] = BaseHrEmpFinger.CS_SIZE;
		__column_names[8] = BaseHrEmpFinger.CS_VALID;
		__column_names[9] = BaseHrEmpFinger.CS_IS_ACTIVE;
		__column_names[10] = BaseHrEmpFinger.CS_FID;
		__column_names[11] = BaseHrEmpFinger.CS_UTIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseHrEmpFinger b) {
		clear();
		setHrEmpFingerIdClear(b.getHrEmpFingerId());
	}

	public boolean isPrimaryKeyNull() {
		return getHrEmpFingerId() == null;
	}

	@Override
	public BaseHrEmpFinger generateBase(){
		BaseHrEmpFinger b = new BaseHrEmpFinger();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseHrEmpFinger b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setHrEmpFingerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmpCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTemplate(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFpversion(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFingerType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSize(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setValid(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsActive(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFid(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setUtime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseHrEmpFinger b, Object[] buff){
		int count = 0;
		buff[count++] = b.getHrEmpFingerId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getSn();
		buff[count++] = b.getEmpCode();
		buff[count++] = b.getTemplate();
		buff[count++] = b.getFpversion();
		buff[count++] = b.getFingerType();
		buff[count++] = b.getSize();
		buff[count++] = b.getValid();
		buff[count++] = b.getIsActive();
		buff[count++] = b.getFid();
		buff[count++] = generateTimestampFromDate(b.getUtime());
	}

	@Override
	public void setDataFromBase(BaseHrEmpFinger b){
		if(b.getHrEmpFingerId() != null) setHrEmpFingerIdClear(b.getHrEmpFingerId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getSn() != null) setSn(b.getSn());
		if(b.getEmpCode() != null) setEmpCode(b.getEmpCode());
		if(b.getTemplate() != null) setTemplate(b.getTemplate());
		if(b.getFpversion() != null) setFpversion(b.getFpversion());
		if(b.getFingerType() != null) setFingerType(b.getFingerType());
		if(b.getSize() != null) setSize(b.getSize());
		if(b.getValid() != null) setValid(b.getValid());
		if(b.getIsActive() != null) setIsActive(b.getIsActive());
		if(b.getFid() != null) setFid(b.getFid());
		if(b.getUtime() != null) setUtime(b.getUtime());
	}

	@Override
	public BaseHrEmpFinger generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseHrEmpFinger b = new BaseHrEmpFinger();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseHrEmpFinger __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHrEmpFingerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmpCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTemplate(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFpversion(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFingerType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSize(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setValid(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsActive(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFid(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUtime(GenericBase.__getDateFromSQL(val));
	}

	public void setHrEmpFingerId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getHrEmpFingerId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setHrEmpFingerIdClear(java.lang.Integer val) {
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

	public void setTemplate(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getTemplate() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setFpversion(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getFpversion() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setFingerType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getFingerType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSize(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSize() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setValid(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getValid() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setIsActive(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getIsActive() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setFid(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getFid() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setUtime(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getUtime() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setConditionHrEmpFingerId(String op, java.lang.Integer val) {
		setConditionHrEmpFingerId(op, val, CONDITION_AND);
	}

	public void setConditionHrEmpFingerId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectHrEmpFingerId(boolean val) {
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

	public void setConditionTemplate(String op, java.lang.String val) {
		setConditionTemplate(op, val, CONDITION_AND);
	}

	public void setConditionTemplate(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTemplate(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionFpversion(String op, java.lang.Integer val) {
		setConditionFpversion(op, val, CONDITION_AND);
	}

	public void setConditionFpversion(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFpversion(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionFingerType(String op, java.lang.Integer val) {
		setConditionFingerType(op, val, CONDITION_AND);
	}

	public void setConditionFingerType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectFingerType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSize(String op, java.lang.Integer val) {
		setConditionSize(op, val, CONDITION_AND);
	}

	public void setConditionSize(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSize(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionValid(String op, java.lang.Integer val) {
		setConditionValid(op, val, CONDITION_AND);
	}

	public void setConditionValid(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectValid(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionIsActive(String op, java.lang.Integer val) {
		setConditionIsActive(op, val, CONDITION_AND);
	}

	public void setConditionIsActive(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectIsActive(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionFid(String op, java.lang.Integer val) {
		setConditionFid(op, val, CONDITION_AND);
	}

	public void setConditionFid(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectFid(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionUtime(String op, java.util.Date val) {
		setConditionUtime(op, val, CONDITION_AND);
	}

	public void setConditionUtime(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUtime(boolean val) {
		__select_flags[11] = val;
	}


}

