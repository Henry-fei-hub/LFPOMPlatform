package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseAttachmentManage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class AttachmentManage extends AbstractTable<BaseAttachmentManage>
{

	public AttachmentManage() throws java.sql.SQLException
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 24;

		initTables();

		__tableName            = "attachment_manages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseAttachmentManage.CS_ATTACHMENT_MANAGE_ID;
		__column_names[1] = BaseAttachmentManage.CS_CONTRACT_ID;
		__column_names[2] = BaseAttachmentManage.CS_ATTACHMENT_CODE;
		__column_names[3] = BaseAttachmentManage.CS_ATTACHMENT_NAME;
		__column_names[4] = BaseAttachmentManage.CS_ATTACHMENT_ADDRESS;
		__column_names[5] = BaseAttachmentManage.CS_PERFESSION_REMARK;
		__column_names[6] = BaseAttachmentManage.CS_AMOUNT;
		__column_names[7] = BaseAttachmentManage.CS_RETURN_AMOUNT;
		__column_names[8] = BaseAttachmentManage.CS_PAYMENT_SURE;
		__column_names[9] = BaseAttachmentManage.CS_PAYMENT_GRADE_DESCRIPTION;
		__column_names[10] = BaseAttachmentManage.CS_SERIAL_NUMBER;
		__column_names[11] = BaseAttachmentManage.CS_RECORD_DATE;
		__column_names[12] = BaseAttachmentManage.CS_OPERATE_EMPLOYEE_ID;
		__column_names[13] = BaseAttachmentManage.CS_OPERATE_TIME;
		__column_names[14] = BaseAttachmentManage.CS_REMARK;
		__column_names[15] = BaseAttachmentManage.CS_DELETE_FLAG;
		__column_names[16] = BaseAttachmentManage.CS_PROJECT_MANAGE_ID;
		__column_names[17] = BaseAttachmentManage.CS_DEPARTMENT_ID;
		__column_names[18] = BaseAttachmentManage.CS_SUPER_PROJECT_MANAGE_ID;
		__column_names[19] = BaseAttachmentManage.CS_PERSONNEL_BUSINESS_ID;
		__column_names[20] = BaseAttachmentManage.CS_HAVE_VOUCHER;
		__column_names[21] = BaseAttachmentManage.CS_FINANCE_REMARK;
		__column_names[22] = BaseAttachmentManage.CS_CAN_RECEIVED_PAYMENT;
		__column_names[23] = BaseAttachmentManage.CS_CONFIRMATION_LETTER;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseAttachmentManage b) {
		clear();
		setAttachmentManageIdClear(b.getAttachmentManageId());
	}

	public boolean isPrimaryKeyNull() {
		return getAttachmentManageId() == null;
	}

	@Override
	public BaseAttachmentManage generateBase(){
		BaseAttachmentManage b = new BaseAttachmentManage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseAttachmentManage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachmentAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPerfessionRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setReturnAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPaymentSure(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setPaymentGradeDescription(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSerialNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSuperProjectManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setFinanceRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCanReceivedPayment(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setConfirmationLetter(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseAttachmentManage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getAttachmentManageId();
		buff[count++] = b.getContractId();
		buff[count++] = b.getAttachmentCode();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getAttachmentAddress();
		buff[count++] = b.getPerfessionRemark();
		buff[count++] = b.getAmount();
		buff[count++] = b.getReturnAmount();
		buff[count++] = b.getPaymentSure();
		buff[count++] = b.getPaymentGradeDescription();
		buff[count++] = b.getSerialNumber();
		buff[count++] = generateTimestampFromDate(b.getRecordDate());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getDeleteFlag();
		buff[count++] = b.getProjectManageId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getSuperProjectManageId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getHaveVoucher();
		buff[count++] = b.getFinanceRemark();
		buff[count++] = b.getCanReceivedPayment();
		buff[count++] = b.getConfirmationLetter();
	}

	@Override
	public void setDataFromBase(BaseAttachmentManage b){
		if(b.getAttachmentManageId() != null) setAttachmentManageIdClear(b.getAttachmentManageId());
		if(b.getContractId() != null) setContractId(b.getContractId());
		if(b.getAttachmentCode() != null) setAttachmentCode(b.getAttachmentCode());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getAttachmentAddress() != null) setAttachmentAddress(b.getAttachmentAddress());
		if(b.getPerfessionRemark() != null) setPerfessionRemark(b.getPerfessionRemark());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getReturnAmount() != null) setReturnAmount(b.getReturnAmount());
		if(b.getPaymentSure() != null) setPaymentSure(b.getPaymentSure());
		if(b.getPaymentGradeDescription() != null) setPaymentGradeDescription(b.getPaymentGradeDescription());
		if(b.getSerialNumber() != null) setSerialNumber(b.getSerialNumber());
		if(b.getRecordDate() != null) setRecordDate(b.getRecordDate());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getDeleteFlag() != null) setDeleteFlag(b.getDeleteFlag());
		if(b.getProjectManageId() != null) setProjectManageId(b.getProjectManageId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getSuperProjectManageId() != null) setSuperProjectManageId(b.getSuperProjectManageId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getHaveVoucher() != null) setHaveVoucher(b.getHaveVoucher());
		if(b.getFinanceRemark() != null) setFinanceRemark(b.getFinanceRemark());
		if(b.getCanReceivedPayment() != null) setCanReceivedPayment(b.getCanReceivedPayment());
		if(b.getConfirmationLetter() != null) setConfirmationLetter(b.getConfirmationLetter());
	}

	@Override
	public BaseAttachmentManage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseAttachmentManage b = new BaseAttachmentManage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseAttachmentManage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPerfessionRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReturnAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentSure(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPaymentGradeDescription(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSuperProjectManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinanceRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCanReceivedPayment(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setConfirmationLetter(GenericBase.__getBoolean(val));
	}

	public void setAttachmentManageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getAttachmentManageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setAttachmentManageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getContractId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setAttachmentCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getAttachmentCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setAttachmentAddress(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getAttachmentAddress() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setPerfessionRemark(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getPerfessionRemark() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(6, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[6]);
	}

	public void setReturnAmount(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getReturnAmount() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setPaymentSure(java.lang.Boolean val) {
		setCurrentData(8, val);
	}

	public java.lang.Boolean getPaymentSure() {
		return GenericBase.__getBoolean(__current_data[8]);
	}

	public void setPaymentGradeDescription(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getPaymentGradeDescription() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setSerialNumber(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getSerialNumber() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setRecordDate(java.util.Date val) {
		setCurrentData(11, generateTimestampFromDate(val));
	}

	public java.util.Date getRecordDate() {
		return GenericBase.__getDateFromSQL(__current_data[11]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(12, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[12]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(13, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[13]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setDeleteFlag(java.lang.Integer val) {
		setCurrentData(15, val);
	}

	public java.lang.Integer getDeleteFlag() {
		return GenericBase.__getInt(__current_data[15]);
	}

	public void setProjectManageId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getProjectManageId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setSuperProjectManageId(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getSuperProjectManageId() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(19, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[19]);
	}

	public void setHaveVoucher(java.lang.Boolean val) {
		setCurrentData(20, val);
	}

	public java.lang.Boolean getHaveVoucher() {
		return GenericBase.__getBoolean(__current_data[20]);
	}

	public void setFinanceRemark(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getFinanceRemark() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setCanReceivedPayment(java.lang.Boolean val) {
		setCurrentData(22, val);
	}

	public java.lang.Boolean getCanReceivedPayment() {
		return GenericBase.__getBoolean(__current_data[22]);
	}

	public void setConfirmationLetter(java.lang.Boolean val) {
		setCurrentData(23, val);
	}

	public java.lang.Boolean getConfirmationLetter() {
		return GenericBase.__getBoolean(__current_data[23]);
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val) {
		setConditionAttachmentManageId(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentManageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectAttachmentManageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractId(String op, java.lang.Integer val) {
		setConditionContractId(op, val, CONDITION_AND);
	}

	public void setConditionContractId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionAttachmentCode(String op, java.lang.String val) {
		setConditionAttachmentCode(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectAttachmentCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionAttachmentAddress(String op, java.lang.String val) {
		setConditionAttachmentAddress(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentAddress(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectAttachmentAddress(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionPerfessionRemark(String op, java.lang.String val) {
		setConditionPerfessionRemark(op, val, CONDITION_AND);
	}

	public void setConditionPerfessionRemark(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectPerfessionRemark(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionReturnAmount(String op, java.math.BigDecimal val) {
		setConditionReturnAmount(op, val, CONDITION_AND);
	}

	public void setConditionReturnAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectReturnAmount(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionPaymentSure(String op, java.lang.Boolean val) {
		setConditionPaymentSure(op, val, CONDITION_AND);
	}

	public void setConditionPaymentSure(String op, java.lang.Boolean val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectPaymentSure(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionPaymentGradeDescription(String op, java.lang.String val) {
		setConditionPaymentGradeDescription(op, val, CONDITION_AND);
	}

	public void setConditionPaymentGradeDescription(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectPaymentGradeDescription(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val) {
		setConditionSerialNumber(op, val, CONDITION_AND);
	}

	public void setConditionSerialNumber(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSerialNumber(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionRecordDate(String op, java.util.Date val) {
		setConditionRecordDate(op, val, CONDITION_AND);
	}

	public void setConditionRecordDate(String op, java.util.Date val, String relation) {
		addCondition(11, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectRecordDate(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(13, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val) {
		setConditionDeleteFlag(op, val, CONDITION_AND);
	}

	public void setConditionDeleteFlag(String op, java.lang.Integer val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectDeleteFlag(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val) {
		setConditionProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionProjectManageId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectProjectManageId(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionSuperProjectManageId(String op, java.lang.Integer val) {
		setConditionSuperProjectManageId(op, val, CONDITION_AND);
	}

	public void setConditionSuperProjectManageId(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectSuperProjectManageId(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionHaveVoucher(String op, java.lang.Boolean val) {
		setConditionHaveVoucher(op, val, CONDITION_AND);
	}

	public void setConditionHaveVoucher(String op, java.lang.Boolean val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectHaveVoucher(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionFinanceRemark(String op, java.lang.String val) {
		setConditionFinanceRemark(op, val, CONDITION_AND);
	}

	public void setConditionFinanceRemark(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectFinanceRemark(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionCanReceivedPayment(String op, java.lang.Boolean val) {
		setConditionCanReceivedPayment(op, val, CONDITION_AND);
	}

	public void setConditionCanReceivedPayment(String op, java.lang.Boolean val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectCanReceivedPayment(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionConfirmationLetter(String op, java.lang.Boolean val) {
		setConditionConfirmationLetter(op, val, CONDITION_AND);
	}

	public void setConditionConfirmationLetter(String op, java.lang.Boolean val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectConfirmationLetter(boolean val) {
		__select_flags[23] = val;
	}


}