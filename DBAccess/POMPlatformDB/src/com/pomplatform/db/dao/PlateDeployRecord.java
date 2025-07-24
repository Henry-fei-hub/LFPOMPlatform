package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BasePlateDeployRecord;


public class PlateDeployRecord extends AbstractTable<BasePlateDeployRecord>
{

	public PlateDeployRecord() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 7;

		initTables();

		__tableName            = "plate_deploy_records";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateDeployRecord.CS_PLATE_DEPLOY_RECORD_ID;
		__column_names[1] = BasePlateDeployRecord.CS_PLATE_ID;
		__column_names[2] = BasePlateDeployRecord.CS_ADVANCE_INTEGRAL;
		__column_names[3] = BasePlateDeployRecord.CS_ADVANCE_DATE;
		__column_names[4] = BasePlateDeployRecord.CS_OPERATE_TIME;
		__column_names[5] = BasePlateDeployRecord.CS_OPERATE_EMPLOYEE_ID;
		__column_names[6] = BasePlateDeployRecord.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateDeployRecord b) {
		clear();
		setPlateDeployRecordIdClear(b.getPlateDeployRecordId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateDeployRecordId() == null;
	}

	@Override
	public BasePlateDeployRecord generateBase(){
		BasePlateDeployRecord b = new BasePlateDeployRecord();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateDeployRecord b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateDeployRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	public void setDataFromCSV(String csvLine){
		setDataFromCSV(csvLine, null);
	}

	public void setDataFromCSV(String csvLine, String names){
		int count = 0; String val;
		Integer num = null;
		setInputNames(names);
		String[] values = JsonParser.csvLine(csvLine, ',');
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlateDeployRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlateId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAdvanceIntegral(GenericBase.__getDecimal(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setAdvanceDate(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperateTime(GenericBase.__getDate(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setOperateEmployeeId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setRemark(GenericBase.__getString(val));
		}
	}

	@Override
	public void setBaseToBuffer(BasePlateDeployRecord b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateDeployRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getAdvanceIntegral();
		buff[count++] = generateTimestampFromDate(b.getAdvanceDate());
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePlateDeployRecord b){
		if(b.getPlateDeployRecordId() != null) setPlateDeployRecordIdClear(b.getPlateDeployRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getAdvanceIntegral() != null) setAdvanceIntegral(b.getAdvanceIntegral());
		if(b.getAdvanceDate() != null) setAdvanceDate(b.getAdvanceDate());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePlateDeployRecord generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateDeployRecord b = new BasePlateDeployRecord();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateDeployRecord __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateDeployRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPlateDeployRecordId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateDeployRecordId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateDeployRecordIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAdvanceIntegral(java.math.BigDecimal val) {
		setCurrentData(2, val);
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return GenericBase.__getDecimal(__current_data[2]);
	}

	public void setAdvanceDate(java.util.Date val) {
		setCurrentData(3, generateTimestampFromDate(val));
	}

	public java.util.Date getAdvanceDate() {
		return GenericBase.__getDateFromSQL(__current_data[3]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setConditionPlateDeployRecordId(String op, java.lang.Integer val) {
		setConditionPlateDeployRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateDeployRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateDeployRecordId(boolean val) {
		__select_flags[0] = val;
	}

	public void setPlateDeployRecordIdExpression(String val) {
		__dataExpressions[0] = val;
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

	public void setPlateIdExpression(String val) {
		__dataExpressions[1] = val;
	}

	public void setConditionAdvanceIntegral(String op, java.math.BigDecimal val) {
		setConditionAdvanceIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAdvanceIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAdvanceIntegral(boolean val) {
		__select_flags[2] = val;
	}

	public void setAdvanceIntegralExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionAdvanceDate(String op, java.util.Date val) {
		setConditionAdvanceDate(op, val, CONDITION_AND);
	}

	public void setConditionAdvanceDate(String op, java.util.Date val, String relation) {
		addCondition(3, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAdvanceDate(boolean val) {
		__select_flags[3] = val;
	}

	public void setAdvanceDateExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[4] = val;
	}

	public void setOperateTimeExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[5] = val;
	}

	public void setOperateEmployeeIdExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[6] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[6] = val;
	}


}

