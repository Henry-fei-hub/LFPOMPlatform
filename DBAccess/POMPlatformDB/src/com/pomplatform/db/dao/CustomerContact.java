package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCustomerContact;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CustomerContact extends AbstractTable<BaseCustomerContact>
{

	public CustomerContact() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 19;

		initTables();

		__tableName            = "customer_contacts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCustomerContact.CS_CUSTOMER_CONTACT_ID;
		__column_names[1] = BaseCustomerContact.CS_CUSTOMER_ID;
		__column_names[2] = BaseCustomerContact.CS_NAME;
		__column_names[3] = BaseCustomerContact.CS_GRADE;
		__column_names[4] = BaseCustomerContact.CS_TELEPHONE;
		__column_names[5] = BaseCustomerContact.CS_MOBILE;
		__column_names[6] = BaseCustomerContact.CS_EMAIL;
		__column_names[7] = BaseCustomerContact.CS_BIRTH_DATE;
		__column_names[8] = BaseCustomerContact.CS_GENDER;
		__column_names[9] = BaseCustomerContact.CS_EMPLOYEE_TYPE;
		__column_names[10] = BaseCustomerContact.CS_PERSONAL_INFLUENCE;
		__column_names[11] = BaseCustomerContact.CS_COOPERATION_RELATION;
		__column_names[12] = BaseCustomerContact.CS_COOPERATION_ATTITUDE;
		__column_names[13] = BaseCustomerContact.CS_WORK_ADDRESS;
		__column_names[14] = BaseCustomerContact.CS_GIFT_RECORD;
		__column_names[15] = BaseCustomerContact.CS_COMPLAINT_ADVICE;
		__column_names[16] = BaseCustomerContact.CS_OPERATE_EMPLOYEE_ID;
		__column_names[17] = BaseCustomerContact.CS_OPERATE_TIME;
		__column_names[18] = BaseCustomerContact.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCustomerContact b) {
		clear();
		setCustomerContactIdClear(b.getCustomerContactId());
	}

	public boolean isPrimaryKeyNull() {
		return getCustomerContactId() == null;
	}

	@Override
	public BaseCustomerContact generateBase(){
		BaseCustomerContact b = new BaseCustomerContact();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCustomerContact b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCustomerId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setGrade(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTelephone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMobile(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setEmail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBirthDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setGender(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setEmployeeType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonalInfluence(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCooperationRelation(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCooperationAttitude(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setWorkAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setGiftRecord(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setComplaintAdvice(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseCustomerContact b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCustomerContactId();
		buff[count++] = b.getCustomerId();
		buff[count++] = b.getName();
		buff[count++] = b.getGrade();
		buff[count++] = b.getTelephone();
		buff[count++] = b.getMobile();
		buff[count++] = b.getEmail();
		buff[count++] = generateTimestampFromDate(b.getBirthDate());
		buff[count++] = b.getGender();
		buff[count++] = b.getEmployeeType();
		buff[count++] = b.getPersonalInfluence();
		buff[count++] = b.getCooperationRelation();
		buff[count++] = b.getCooperationAttitude();
		buff[count++] = b.getWorkAddress();
		buff[count++] = b.getGiftRecord();
		buff[count++] = b.getComplaintAdvice();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseCustomerContact b){
		if(b.getCustomerContactId() != null) setCustomerContactIdClear(b.getCustomerContactId());
		if(b.getCustomerId() != null) setCustomerId(b.getCustomerId());
		if(b.getName() != null) setName(b.getName());
		if(b.getGrade() != null) setGrade(b.getGrade());
		if(b.getTelephone() != null) setTelephone(b.getTelephone());
		if(b.getMobile() != null) setMobile(b.getMobile());
		if(b.getEmail() != null) setEmail(b.getEmail());
		if(b.getBirthDate() != null) setBirthDate(b.getBirthDate());
		if(b.getGender() != null) setGender(b.getGender());
		if(b.getEmployeeType() != null) setEmployeeType(b.getEmployeeType());
		if(b.getPersonalInfluence() != null) setPersonalInfluence(b.getPersonalInfluence());
		if(b.getCooperationRelation() != null) setCooperationRelation(b.getCooperationRelation());
		if(b.getCooperationAttitude() != null) setCooperationAttitude(b.getCooperationAttitude());
		if(b.getWorkAddress() != null) setWorkAddress(b.getWorkAddress());
		if(b.getGiftRecord() != null) setGiftRecord(b.getGiftRecord());
		if(b.getComplaintAdvice() != null) setComplaintAdvice(b.getComplaintAdvice());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseCustomerContact generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCustomerContact b = new BaseCustomerContact();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCustomerContact __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGrade(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTelephone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMobile(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBirthDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGender(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setEmployeeType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonalInfluence(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCooperationRelation(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCooperationAttitude(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setWorkAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setGiftRecord(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setComplaintAdvice(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setCustomerContactId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCustomerContactId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCustomerContactIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCustomerId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getCustomerId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setName(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getName() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setGrade(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getGrade() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setTelephone(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getTelephone() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setMobile(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getMobile() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setEmail(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getEmail() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setBirthDate(java.util.Date val) {
		setCurrentData(7, generateTimestampFromDate(val));
	}

	public java.util.Date getBirthDate() {
		return GenericBase.__getDateFromSQL(__current_data[7]);
	}

	public void setGender(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getGender() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setEmployeeType(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getEmployeeType() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setPersonalInfluence(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getPersonalInfluence() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setCooperationRelation(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getCooperationRelation() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setCooperationAttitude(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getCooperationAttitude() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setWorkAddress(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getWorkAddress() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setGiftRecord(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getGiftRecord() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setComplaintAdvice(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getComplaintAdvice() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setConditionCustomerContactId(String op, java.lang.Integer val) {
		setConditionCustomerContactId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerContactId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCustomerContactId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCustomerId(String op, java.lang.Integer val) {
		setConditionCustomerId(op, val, CONDITION_AND);
	}

	public void setConditionCustomerId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCustomerId(boolean val) {
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

	public void setConditionGrade(String op, java.lang.String val) {
		setConditionGrade(op, val, CONDITION_AND);
	}

	public void setConditionGrade(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectGrade(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTelephone(String op, java.lang.String val) {
		setConditionTelephone(op, val, CONDITION_AND);
	}

	public void setConditionTelephone(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTelephone(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionMobile(String op, java.lang.String val) {
		setConditionMobile(op, val, CONDITION_AND);
	}

	public void setConditionMobile(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectMobile(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionEmail(String op, java.lang.String val) {
		setConditionEmail(op, val, CONDITION_AND);
	}

	public void setConditionEmail(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectEmail(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionBirthDate(String op, java.util.Date val) {
		setConditionBirthDate(op, val, CONDITION_AND);
	}

	public void setConditionBirthDate(String op, java.util.Date val, String relation) {
		addCondition(7, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectBirthDate(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionGender(String op, java.lang.Integer val) {
		setConditionGender(op, val, CONDITION_AND);
	}

	public void setConditionGender(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectGender(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionEmployeeType(String op, java.lang.Integer val) {
		setConditionEmployeeType(op, val, CONDITION_AND);
	}

	public void setConditionEmployeeType(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectEmployeeType(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionPersonalInfluence(String op, java.lang.Integer val) {
		setConditionPersonalInfluence(op, val, CONDITION_AND);
	}

	public void setConditionPersonalInfluence(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectPersonalInfluence(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCooperationRelation(String op, java.lang.Integer val) {
		setConditionCooperationRelation(op, val, CONDITION_AND);
	}

	public void setConditionCooperationRelation(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectCooperationRelation(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCooperationAttitude(String op, java.lang.Integer val) {
		setConditionCooperationAttitude(op, val, CONDITION_AND);
	}

	public void setConditionCooperationAttitude(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectCooperationAttitude(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionWorkAddress(String op, java.lang.String val) {
		setConditionWorkAddress(op, val, CONDITION_AND);
	}

	public void setConditionWorkAddress(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectWorkAddress(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionGiftRecord(String op, java.lang.String val) {
		setConditionGiftRecord(op, val, CONDITION_AND);
	}

	public void setConditionGiftRecord(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectGiftRecord(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionComplaintAdvice(String op, java.lang.String val) {
		setConditionComplaintAdvice(op, val, CONDITION_AND);
	}

	public void setConditionComplaintAdvice(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectComplaintAdvice(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[18] = val;
	}


}

