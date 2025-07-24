package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseBonusPaymentDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class BonusPaymentDetail extends AbstractTable<BaseBonusPaymentDetail>
{

	public BonusPaymentDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 19;

		initTables();

		__tableName            = "bonus_payment_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseBonusPaymentDetail.CS_BONUS_PAYMENT_DETAIL_ID;
		__column_names[1] = BaseBonusPaymentDetail.CS_BONUS_PAYMENT_RECORD_ID;
		__column_names[2] = BaseBonusPaymentDetail.CS_PLATE_ID;
		__column_names[3] = BaseBonusPaymentDetail.CS_EMPLOYEE_ID;
		__column_names[4] = BaseBonusPaymentDetail.CS_EMPLOYEE_NO;
		__column_names[5] = BaseBonusPaymentDetail.CS_EMPLOYEE_NAME;
		__column_names[6] = BaseBonusPaymentDetail.CS_ACHIEVE_INTEGRAL;
		__column_names[7] = BaseBonusPaymentDetail.CS_PAY_PERCENT;
		__column_names[8] = BaseBonusPaymentDetail.CS_PAY_INTEGRAL;
		__column_names[9] = BaseBonusPaymentDetail.CS_LEFT_INTEGRAL;
		__column_names[10] = BaseBonusPaymentDetail.CS_PAY_DATE;
		__column_names[11] = BaseBonusPaymentDetail.CS_STATE;
		__column_names[12] = BaseBonusPaymentDetail.CS_IS_RETURN;
		__column_names[13] = BaseBonusPaymentDetail.CS_IS_LEVEL_TWO;
		__column_names[14] = BaseBonusPaymentDetail.CS_DEPARTMENT_ID;
		__column_names[15] = BaseBonusPaymentDetail.CS_FIRST_INTEGRAL;
		__column_names[16] = BaseBonusPaymentDetail.CS_SECOND_INTEGRAL;
		__column_names[17] = BaseBonusPaymentDetail.CS_THIRD_INTEGRAL;
		__column_names[18] = BaseBonusPaymentDetail.CS_SEND_NUMBER;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseBonusPaymentDetail b) {
		clear();
		setBonusPaymentDetailIdClear(b.getBonusPaymentDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getBonusPaymentDetailId() == null;
	}

	@Override
	public BaseBonusPaymentDetail generateBase(){
		BaseBonusPaymentDetail b = new BaseBonusPaymentDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseBonusPaymentDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setBonusPaymentDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setBonusPaymentRecordId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPlateId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeNo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmployeeName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayPercent(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLeftIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setState(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsReturn(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setIsLevelTwo(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setFirstIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSecondIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setThirdIntegral(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSendNumber(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseBonusPaymentDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getBonusPaymentDetailId();
		buff[count++] = b.getBonusPaymentRecordId();
		buff[count++] = b.getPlateId();
		buff[count++] = b.getEmployeeId();
		buff[count++] = b.getEmployeeNo();
		buff[count++] = b.getEmployeeName();
		buff[count++] = b.getAchieveIntegral();
		buff[count++] = b.getPayPercent();
		buff[count++] = b.getPayIntegral();
		buff[count++] = b.getLeftIntegral();
		buff[count++] = generateTimestampFromDate(b.getPayDate());
		buff[count++] = b.getState();
		buff[count++] = b.getIsReturn();
		buff[count++] = b.getIsLevelTwo();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getFirstIntegral();
		buff[count++] = b.getSecondIntegral();
		buff[count++] = b.getThirdIntegral();
		buff[count++] = b.getSendNumber();
	}

	@Override
	public void setDataFromBase(BaseBonusPaymentDetail b){
		if(b.getBonusPaymentDetailId() != null) setBonusPaymentDetailIdClear(b.getBonusPaymentDetailId());
		if(b.getBonusPaymentRecordId() != null) setBonusPaymentRecordId(b.getBonusPaymentRecordId());
		if(b.getPlateId() != null) setPlateId(b.getPlateId());
		if(b.getEmployeeId() != null) setEmployeeId(b.getEmployeeId());
		if(b.getEmployeeNo() != null) setEmployeeNo(b.getEmployeeNo());
		if(b.getEmployeeName() != null) setEmployeeName(b.getEmployeeName());
		if(b.getAchieveIntegral() != null) setAchieveIntegral(b.getAchieveIntegral());
		if(b.getPayPercent() != null) setPayPercent(b.getPayPercent());
		if(b.getPayIntegral() != null) setPayIntegral(b.getPayIntegral());
		if(b.getLeftIntegral() != null) setLeftIntegral(b.getLeftIntegral());
		if(b.getPayDate() != null) setPayDate(b.getPayDate());
		if(b.getState() != null) setState(b.getState());
		if(b.getIsReturn() != null) setIsReturn(b.getIsReturn());
		if(b.getIsLevelTwo() != null) setIsLevelTwo(b.getIsLevelTwo());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getFirstIntegral() != null) setFirstIntegral(b.getFirstIntegral());
		if(b.getSecondIntegral() != null) setSecondIntegral(b.getSecondIntegral());
		if(b.getThirdIntegral() != null) setThirdIntegral(b.getThirdIntegral());
		if(b.getSendNumber() != null) setSendNumber(b.getSendNumber());
	}

	@Override
	public BaseBonusPaymentDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseBonusPaymentDetail b = new BaseBonusPaymentDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseBonusPaymentDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBonusPaymentDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBonusPaymentRecordId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPlateId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayPercent(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPayDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setState(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsReturn(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsLevelTwo(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFirstIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSecondIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setThirdIntegral(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSendNumber(GenericBase.__getInt(val));
	}

	public void setBonusPaymentDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getBonusPaymentDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setBonusPaymentDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setBonusPaymentRecordId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getBonusPaymentRecordId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setPlateId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getPlateId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setEmployeeId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getEmployeeId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setEmployeeNo(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getEmployeeNo() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setEmployeeName(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getEmployeeName() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAchieveIntegral(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setPayPercent(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getPayPercent() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setPayIntegral(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getPayIntegral() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setLeftIntegral(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getLeftIntegral() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setPayDate(java.util.Date val) {
		setCurrentData(10, generateTimestampFromDate(val));
	}

	public java.util.Date getPayDate() {
		return GenericBase.__getDateFromSQL(__current_data[10]);
	}

	public void setState(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getState() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setIsReturn(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsReturn() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setIsLevelTwo(java.lang.Boolean val) {
		setCurrentData(13, val);
	}

	public java.lang.Boolean getIsLevelTwo() {
		return GenericBase.__getBoolean(__current_data[13]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setFirstIntegral(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getFirstIntegral() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setSecondIntegral(java.math.BigDecimal val) {
		setCurrentData(16, val);
	}

	public java.math.BigDecimal getSecondIntegral() {
		return GenericBase.__getDecimal(__current_data[16]);
	}

	public void setThirdIntegral(java.math.BigDecimal val) {
		setCurrentData(17, val);
	}

	public java.math.BigDecimal getThirdIntegral() {
		return GenericBase.__getDecimal(__current_data[17]);
	}

	public void setSendNumber(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getSendNumber() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setConditionBonusPaymentDetailId(String op, java.lang.Integer val) {
		setConditionBonusPaymentDetailId(op, val, CONDITION_AND);
	}

	public void setConditionBonusPaymentDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectBonusPaymentDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionBonusPaymentRecordId(String op, java.lang.Integer val) {
		setConditionBonusPaymentRecordId(op, val, CONDITION_AND);
	}

	public void setConditionBonusPaymentRecordId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectBonusPaymentRecordId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionPlateId(String op, java.lang.Integer val) {
		setConditionPlateId(op, val, CONDITION_AND);
	}

	public void setConditionPlateId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectPlateId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val) {
		setConditionEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectEmployeeId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionEmployeeNo(String op, java.lang.String val) {
		setConditionEmployeeNo(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeNo(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectEmployeeNo(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionEmployeeName(String op, java.lang.String val) {
		setConditionEmployeeName(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeName(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectEmployeeName(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val) {
		setConditionAchieveIntegral(op, val, CONDITION_AND);
	}

	public void setConditionAchieveIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAchieveIntegral(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPayPercent(String op, java.math.BigDecimal val) {
		setConditionPayPercent(op, val, CONDITION_AND);
	}

	public void setConditionPayPercent(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPayPercent(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionPayIntegral(String op, java.math.BigDecimal val) {
		setConditionPayIntegral(op, val, CONDITION_AND);
	}

	public void setConditionPayIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPayIntegral(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionLeftIntegral(String op, java.math.BigDecimal val) {
		setConditionLeftIntegral(op, val, CONDITION_AND);
	}

	public void setConditionLeftIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectLeftIntegral(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionPayDate(String op, java.util.Date val) {
		setConditionPayDate(op, val, CONDITION_AND);
	}

	public void setConditionPayDate(String op, java.util.Date val, String relation) {
		addCondition(10, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPayDate(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionState(String op, java.lang.Integer val) {
		setConditionState(op, val, CONDITION_AND);
	}

	public void setConditionState(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectState(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val) {
		setConditionIsReturn(op, val, CONDITION_AND);
	}

	public void setConditionIsReturn(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsReturn(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionIsLevelTwo(String op, java.lang.Boolean val) {
		setConditionIsLevelTwo(op, val, CONDITION_AND);
	}

	public void setConditionIsLevelTwo(String op, java.lang.Boolean val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectIsLevelTwo(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionFirstIntegral(String op, java.math.BigDecimal val) {
		setConditionFirstIntegral(op, val, CONDITION_AND);
	}

	public void setConditionFirstIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectFirstIntegral(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionSecondIntegral(String op, java.math.BigDecimal val) {
		setConditionSecondIntegral(op, val, CONDITION_AND);
	}

	public void setConditionSecondIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectSecondIntegral(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionThirdIntegral(String op, java.math.BigDecimal val) {
		setConditionThirdIntegral(op, val, CONDITION_AND);
	}

	public void setConditionThirdIntegral(String op, java.math.BigDecimal val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectThirdIntegral(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionSendNumber(String op, java.lang.Integer val) {
		setConditionSendNumber(op, val, CONDITION_AND);
	}

	public void setConditionSendNumber(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectSendNumber(boolean val) {
		__select_flags[18] = val;
	}


}

