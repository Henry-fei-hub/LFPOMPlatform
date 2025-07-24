package com.pomplatform.db.dao;

import delicacy.common.AbstractTable;
import delicacy.common.JsonParser;
import delicacy.common.GenericBase;
import com.pomplatform.db.bean.BasePlateDeployDetail;


public class PlateDeployDetail extends AbstractTable<BasePlateDeployDetail>
{

	public PlateDeployDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 8;

		initTables();

		__tableName            = "plate_deploy_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePlateDeployDetail.CS_PLATE_DEPLOY_DETAIL_ID;
		__column_names[1] = BasePlateDeployDetail.CS_PLATE_DEPLOY_RECORD_ID;
		__column_names[2] = BasePlateDeployDetail.CS_EMPLOYEE_ID;
		__column_names[3] = BasePlateDeployDetail.CS_ADVANCE_INTEGRAL;
		__column_names[4] = BasePlateDeployDetail.CS_ADVANCE_DATE;
		__column_names[5] = BasePlateDeployDetail.CS_OPERATE_TIME;
		__column_names[6] = BasePlateDeployDetail.CS_OPERATE_EMPLOYEE_ID;
		__column_names[7] = BasePlateDeployDetail.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePlateDeployDetail b) {
		clear();
		setPlateDeployDetailIdClear(b.getPlateDeployDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getPlateDeployDetailId() == null;
	}

	@Override
	public BasePlateDeployDetail generateBase(){
		BasePlateDeployDetail b = new BasePlateDeployDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePlateDeployDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPlateDeployDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateDeployRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
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
			if(val != null && !val.isEmpty()) setPlateDeployDetailId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setPlateDeployRecordId(GenericBase.__getInt(val));
		}
		if((num = __inputNames[count++]) != null) {
			val = values[num];
			if(val != null && !val.isEmpty()) setEmployeeId(GenericBase.__getInt(val));
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
	public void setBaseToBuffer(BasePlateDeployDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPlateDeployDetailId();
		buff[count++] = b.getPlateDeployRecordId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getAdvanceIntegral();
		buff[count++] = generateTimestampFromDate(b.getAdvanceDate());
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BasePlateDeployDetail b){
		if(b.getPlateDeployDetailId() != null) setPlateDeployDetailIdClear(b.getPlateDeployDetailId());
		if(b.getPlateDeployRecordId() != null) setPlateDeployRecordId(b.getPlateDeployRecordId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getAdvanceIntegral() != null) setAdvanceIntegral(b.getAdvanceIntegral());
		if(b.getAdvanceDate() != null) setAdvanceDate(b.getAdvanceDate());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BasePlateDeployDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePlateDeployDetail b = new BasePlateDeployDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePlateDeployDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateDeployDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateDeployRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAdvanceDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setPlateDeployDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPlateDeployDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPlateDeployDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPlateDeployRecordId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPlateDeployRecordId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAdvanceIntegral(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setAdvanceDate(java.util.Date val) {
		setCurrentData(4, generateTimestampFromDate(val));
	}

	public java.util.Date getAdvanceDate() {
		return GenericBase.__getDateFromSQL(__current_data[4]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(5, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[5]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setConditionPlateDeployDetailId(String op, java.lang.Integer val) {
		setConditionPlateDeployDetailId(op, val, CONDITION_AND);
	}

	public void setConditionPlateDeployDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPlateDeployDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setPlateDeployDetailIdExpression(String val) {
		__dataExpressions[0] = val;
	}

	public void setConditionPlateDeployRecordId(String op, java.lang.Integer val) {
		setConditionPlateDeployRecordId(op, val, CONDITION_AND);
	}

	public void setConditionPlateDeployRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPlateDeployRecordId(boolean val) {
		__select_flags[1] = val;
	}

	public void setPlateDeployRecordIdExpression(String val) {
		__dataExpressions[1] = val;
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

	public void setEmployeeIdExpression(String val) {
		__dataExpressions[2] = val;
	}

	public void setConditionAdvanceIntegral(String op, java.math.BigDecimal val) {
		setConditionAdvanceIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAdvanceIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAdvanceIntegral(boolean val) {
		__select_flags[3] = val;
	}

	public void setAdvanceIntegralExpression(String val) {
		__dataExpressions[3] = val;
	}

	public void setConditionAdvanceDate(String op, java.util.Date val) {
		setConditionAdvanceDate(op, val, CONDITION_AND);
	}

	public void setConditionAdvanceDate(String op, java.util.Date val, String relation) {
		addCondition(4, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAdvanceDate(boolean val) {
		__select_flags[4] = val;
	}

	public void setAdvanceDateExpression(String val) {
		__dataExpressions[4] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(5, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[5] = val;
	}

	public void setOperateTimeExpression(String val) {
		__dataExpressions[5] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[6] = val;
	}

	public void setOperateEmployeeIdExpression(String val) {
		__dataExpressions[6] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[7] = val;
	}

	public void setRemarkExpression(String val) {
		__dataExpressions[7] = val;
	}


}

