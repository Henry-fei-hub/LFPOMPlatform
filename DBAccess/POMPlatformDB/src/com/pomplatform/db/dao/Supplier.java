package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseSupplier;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class Supplier extends AbstractTable<BaseSupplier>
{

	public Supplier() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 36;

		initTables();

		__tableName            = "supplier";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseSupplier.CS_SUPPLIER_ID;
		__column_names[1] = BaseSupplier.CS_SUPPLIER_NAME;
		__column_names[2] = BaseSupplier.CS_SUPPLIER_CONTACT;
		__column_names[3] = BaseSupplier.CS_SUPPLIER_PHONE;
		__column_names[4] = BaseSupplier.CS_SUPPLIER_EMAIL;
		__column_names[5] = BaseSupplier.CS_SUPPLIER_TYPE;
		__column_names[6] = BaseSupplier.CS_SUPPLIER_MAIN_BUSINESS_TYPE;
		__column_names[7] = BaseSupplier.CS_SUPPLIER_SCOPE_SUPPLY;
		__column_names[8] = BaseSupplier.CS_SOCIAL_CREDIT_CODE;
		__column_names[9] = BaseSupplier.CS_SUPPLIER__PROVINCE;
		__column_names[10] = BaseSupplier.CS_SUPPLIER__CITY;
		__column_names[11] = BaseSupplier.CS_SUPPLIER_BANK_ADDRESS;
		__column_names[12] = BaseSupplier.CS_SUPPLIER_ADDRESS;
		__column_names[13] = BaseSupplier.CS_PRODUCTION_CYCLE;
		__column_names[14] = BaseSupplier.CS_LOGISTICS_CYCLE;
		__column_names[15] = BaseSupplier.CS_SUPPLIER_BOSS;
		__column_names[16] = BaseSupplier.CS_CONTRACT_SIGNING_TIME;
		__column_names[17] = BaseSupplier.CS_CONTRACT_SCOPE_TIME;
		__column_names[18] = BaseSupplier.CS_CONTRACT_SCOPE_TIME_START;
		__column_names[19] = BaseSupplier.CS_CONTRACT_SCOPE_TIME_END;
		__column_names[20] = BaseSupplier.CS_OPERATE_EMPLOYEE_ID;
		__column_names[21] = BaseSupplier.CS_OPERATE_TIME;
		__column_names[22] = BaseSupplier.CS_SUPPLIER_ORIGIN;
		__column_names[23] = BaseSupplier.CS_SUPPLIER_STATUS;
		__column_names[24] = BaseSupplier.CS_IS_USE;
		__column_names[25] = BaseSupplier.CS_RECEIVE_UNIT_MANAGE_ID;
		__column_names[26] = BaseSupplier.CS_AGREEMENT_TYPE;
		__column_names[27] = BaseSupplier.CS_AGREEMENT_SIGN_TIME;
		__column_names[28] = BaseSupplier.CS_AGREEMENT_SIGN_ADDRESS;
		__column_names[29] = BaseSupplier.CS_FILE_ID;
		__column_names[30] = BaseSupplier.CS_TEAM_SIZE;
		__column_names[31] = BaseSupplier.CS_AREAS_EXPERTISE;
		__column_names[32] = BaseSupplier.CS_ATTACHMENT_NAME;
		__column_names[33] = BaseSupplier.CS_ATTACHMENT;
		__column_names[34] = BaseSupplier.CS_CREATE_EMPLOYEE_ID;
		__column_names[35] = BaseSupplier.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseSupplier b) {
		clear();
		setSupplierIdClear(b.getSupplierId());
	}

	public boolean isPrimaryKeyNull() {
		return getSupplierId() == null;
	}

	@Override
	public BaseSupplier generateBase(){
		BaseSupplier b = new BaseSupplier();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseSupplier b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierContact(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierPhone(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierEmail(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierMainBusinessType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierScopeSupply(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSocialCreditCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplier_province(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplier_city(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierBankAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductionCycle(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setLogisticsCycle(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierBoss(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractSigningTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setContractScopeTime(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractScopeTimeStart(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setContractScopeTimeEnd(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setSupplierOrigin(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierStatus(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsUse(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAgreementType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAgreementSignTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setAgreementSignAddress(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFileId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTeamSize(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAreasExpertise(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAttachmentName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAttachment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseSupplier b, Object[] buff){
		int count = 0;
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getSupplierName();
		buff[count++] = b.getSupplierContact();
		buff[count++] = b.getSupplierPhone();
		buff[count++] = b.getSupplierEmail();
		buff[count++] = b.getSupplierType();
		buff[count++] = b.getSupplierMainBusinessType();
		buff[count++] = b.getSupplierScopeSupply();
		buff[count++] = b.getSocialCreditCode();
		buff[count++] = b.getSupplier_province();
		buff[count++] = b.getSupplier_city();
		buff[count++] = b.getSupplierBankAddress();
		buff[count++] = b.getSupplierAddress();
		buff[count++] = b.getProductionCycle();
		buff[count++] = b.getLogisticsCycle();
		buff[count++] = b.getSupplierBoss();
		buff[count++] = generateTimestampFromDate(b.getContractSigningTime());
		buff[count++] = b.getContractScopeTime();
		buff[count++] = generateTimestampFromDate(b.getContractScopeTimeStart());
		buff[count++] = generateTimestampFromDate(b.getContractScopeTimeEnd());
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getSupplierOrigin();
		buff[count++] = b.getSupplierStatus();
		buff[count++] = b.getIsUse();
		buff[count++] = b.getReceiveUnitManageId();
		buff[count++] = b.getAgreementType();
		buff[count++] = generateTimestampFromDate(b.getAgreementSignTime());
		buff[count++] = b.getAgreementSignAddress();
		buff[count++] = b.getFileId();
		buff[count++] = b.getTeamSize();
		buff[count++] = b.getAreasExpertise();
		buff[count++] = b.getAttachmentName();
		buff[count++] = b.getAttachment();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BaseSupplier b){
		if(b.getSupplierId() != null) setSupplierIdClear(b.getSupplierId());
		if(b.getSupplierName() != null) setSupplierName(b.getSupplierName());
		if(b.getSupplierContact() != null) setSupplierContact(b.getSupplierContact());
		if(b.getSupplierPhone() != null) setSupplierPhone(b.getSupplierPhone());
		if(b.getSupplierEmail() != null) setSupplierEmail(b.getSupplierEmail());
		if(b.getSupplierType() != null) setSupplierType(b.getSupplierType());
		if(b.getSupplierMainBusinessType() != null) setSupplierMainBusinessType(b.getSupplierMainBusinessType());
		if(b.getSupplierScopeSupply() != null) setSupplierScopeSupply(b.getSupplierScopeSupply());
		if(b.getSocialCreditCode() != null) setSocialCreditCode(b.getSocialCreditCode());
		if(b.getSupplier_province() != null) setSupplier_province(b.getSupplier_province());
		if(b.getSupplier_city() != null) setSupplier_city(b.getSupplier_city());
		if(b.getSupplierBankAddress() != null) setSupplierBankAddress(b.getSupplierBankAddress());
		if(b.getSupplierAddress() != null) setSupplierAddress(b.getSupplierAddress());
		if(b.getProductionCycle() != null) setProductionCycle(b.getProductionCycle());
		if(b.getLogisticsCycle() != null) setLogisticsCycle(b.getLogisticsCycle());
		if(b.getSupplierBoss() != null) setSupplierBoss(b.getSupplierBoss());
		if(b.getContractSigningTime() != null) setContractSigningTime(b.getContractSigningTime());
		if(b.getContractScopeTime() != null) setContractScopeTime(b.getContractScopeTime());
		if(b.getContractScopeTimeStart() != null) setContractScopeTimeStart(b.getContractScopeTimeStart());
		if(b.getContractScopeTimeEnd() != null) setContractScopeTimeEnd(b.getContractScopeTimeEnd());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getSupplierOrigin() != null) setSupplierOrigin(b.getSupplierOrigin());
		if(b.getSupplierStatus() != null) setSupplierStatus(b.getSupplierStatus());
		if(b.getIsUse() != null) setIsUse(b.getIsUse());
		if(b.getReceiveUnitManageId() != null) setReceiveUnitManageId(b.getReceiveUnitManageId());
		if(b.getAgreementType() != null) setAgreementType(b.getAgreementType());
		if(b.getAgreementSignTime() != null) setAgreementSignTime(b.getAgreementSignTime());
		if(b.getAgreementSignAddress() != null) setAgreementSignAddress(b.getAgreementSignAddress());
		if(b.getFileId() != null) setFileId(b.getFileId());
		if(b.getTeamSize() != null) setTeamSize(b.getTeamSize());
		if(b.getAreasExpertise() != null) setAreasExpertise(b.getAreasExpertise());
		if(b.getAttachmentName() != null) setAttachmentName(b.getAttachmentName());
		if(b.getAttachment() != null) setAttachment(b.getAttachment());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BaseSupplier generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseSupplier b = new BaseSupplier();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseSupplier __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierContact(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierPhone(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierEmail(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierMainBusinessType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierScopeSupply(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSocialCreditCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplier_province(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplier_city(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierBankAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductionCycle(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLogisticsCycle(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierBoss(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractSigningTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractScopeTime(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractScopeTimeStart(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractScopeTimeEnd(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierOrigin(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierStatus(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsUse(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAgreementType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAgreementSignTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAgreementSignAddress(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFileId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTeamSize(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAreasExpertise(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAttachment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setSupplierIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSupplierName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getSupplierName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setSupplierContact(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getSupplierContact() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setSupplierPhone(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getSupplierPhone() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setSupplierEmail(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getSupplierEmail() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setSupplierType(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getSupplierType() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setSupplierMainBusinessType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getSupplierMainBusinessType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSupplierScopeSupply(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getSupplierScopeSupply() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setSocialCreditCode(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getSocialCreditCode() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setSupplier_province(java.lang.Integer val) {
		setCurrentData(9, val);
	}

	public java.lang.Integer getSupplier_province() {
		return GenericBase.__getInt(__current_data[9]);
	}

	public void setSupplier_city(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getSupplier_city() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setSupplierBankAddress(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getSupplierBankAddress() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setSupplierAddress(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getSupplierAddress() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setProductionCycle(java.lang.Integer val) {
		setCurrentData(13, val);
	}

	public java.lang.Integer getProductionCycle() {
		return GenericBase.__getInt(__current_data[13]);
	}

	public void setLogisticsCycle(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getLogisticsCycle() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setSupplierBoss(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getSupplierBoss() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setContractSigningTime(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getContractSigningTime() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setContractScopeTime(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getContractScopeTime() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setContractScopeTimeStart(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getContractScopeTimeStart() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setContractScopeTimeEnd(java.util.Date val) {
		setCurrentData(19, generateTimestampFromDate(val));
	}

	public java.util.Date getContractScopeTimeEnd() {
		return GenericBase.__getDateFromSQL(__current_data[19]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(20, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[20]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(21, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[21]);
	}

	public void setSupplierOrigin(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getSupplierOrigin() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setSupplierStatus(java.lang.Integer val) {
		setCurrentData(23, val);
	}

	public java.lang.Integer getSupplierStatus() {
		return GenericBase.__getInt(__current_data[23]);
	}

	public void setIsUse(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getIsUse() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setReceiveUnitManageId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setAgreementType(java.lang.Integer val) {
		setCurrentData(26, val);
	}

	public java.lang.Integer getAgreementType() {
		return GenericBase.__getInt(__current_data[26]);
	}

	public void setAgreementSignTime(java.util.Date val) {
		setCurrentData(27, generateTimestampFromDate(val));
	}

	public java.util.Date getAgreementSignTime() {
		return GenericBase.__getDateFromSQL(__current_data[27]);
	}

	public void setAgreementSignAddress(java.lang.String val) {
		setCurrentData(28, val);
	}

	public java.lang.String getAgreementSignAddress() {
		return GenericBase.__getString(__current_data[28]);
	}

	public void setFileId(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getFileId() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setTeamSize(java.lang.Integer val) {
		setCurrentData(30, val);
	}

	public java.lang.Integer getTeamSize() {
		return GenericBase.__getInt(__current_data[30]);
	}

	public void setAreasExpertise(java.lang.Integer val) {
		setCurrentData(31, val);
	}

	public java.lang.Integer getAreasExpertise() {
		return GenericBase.__getInt(__current_data[31]);
	}

	public void setAttachmentName(java.lang.String val) {
		setCurrentData(32, val);
	}

	public java.lang.String getAttachmentName() {
		return GenericBase.__getString(__current_data[32]);
	}

	public void setAttachment(java.lang.String val) {
		setCurrentData(33, val);
	}

	public java.lang.String getAttachment() {
		return GenericBase.__getString(__current_data[33]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(34, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[34]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(35, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[35]);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSupplierName(String op, java.lang.String val) {
		setConditionSupplierName(op, val, CONDITION_AND);
	}

	public void setConditionSupplierName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSupplierName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSupplierContact(String op, java.lang.String val) {
		setConditionSupplierContact(op, val, CONDITION_AND);
	}

	public void setConditionSupplierContact(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSupplierContact(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSupplierPhone(String op, java.lang.String val) {
		setConditionSupplierPhone(op, val, CONDITION_AND);
	}

	public void setConditionSupplierPhone(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSupplierPhone(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionSupplierEmail(String op, java.lang.String val) {
		setConditionSupplierEmail(op, val, CONDITION_AND);
	}

	public void setConditionSupplierEmail(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectSupplierEmail(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionSupplierType(String op, java.lang.Integer val) {
		setConditionSupplierType(op, val, CONDITION_AND);
	}

	public void setConditionSupplierType(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectSupplierType(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionSupplierMainBusinessType(String op, java.lang.Integer val) {
		setConditionSupplierMainBusinessType(op, val, CONDITION_AND);
	}

	public void setConditionSupplierMainBusinessType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectSupplierMainBusinessType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSupplierScopeSupply(String op, java.lang.String val) {
		setConditionSupplierScopeSupply(op, val, CONDITION_AND);
	}

	public void setConditionSupplierScopeSupply(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSupplierScopeSupply(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionSocialCreditCode(String op, java.lang.String val) {
		setConditionSocialCreditCode(op, val, CONDITION_AND);
	}

	public void setConditionSocialCreditCode(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectSocialCreditCode(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionSupplier_province(String op, java.lang.Integer val) {
		setConditionSupplier_province(op, val, CONDITION_AND);
	}

	public void setConditionSupplier_province(String op, java.lang.Integer val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectSupplier_province(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionSupplier_city(String op, java.lang.Integer val) {
		setConditionSupplier_city(op, val, CONDITION_AND);
	}

	public void setConditionSupplier_city(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectSupplier_city(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSupplierBankAddress(String op, java.lang.String val) {
		setConditionSupplierBankAddress(op, val, CONDITION_AND);
	}

	public void setConditionSupplierBankAddress(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSupplierBankAddress(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionSupplierAddress(String op, java.lang.String val) {
		setConditionSupplierAddress(op, val, CONDITION_AND);
	}

	public void setConditionSupplierAddress(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectSupplierAddress(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionProductionCycle(String op, java.lang.Integer val) {
		setConditionProductionCycle(op, val, CONDITION_AND);
	}

	public void setConditionProductionCycle(String op, java.lang.Integer val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectProductionCycle(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionLogisticsCycle(String op, java.lang.Integer val) {
		setConditionLogisticsCycle(op, val, CONDITION_AND);
	}

	public void setConditionLogisticsCycle(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectLogisticsCycle(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionSupplierBoss(String op, java.lang.String val) {
		setConditionSupplierBoss(op, val, CONDITION_AND);
	}

	public void setConditionSupplierBoss(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectSupplierBoss(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionContractSigningTime(String op, java.util.Date val) {
		setConditionContractSigningTime(op, val, CONDITION_AND);
	}

	public void setConditionContractSigningTime(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectContractSigningTime(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionContractScopeTime(String op, java.lang.String val) {
		setConditionContractScopeTime(op, val, CONDITION_AND);
	}

	public void setConditionContractScopeTime(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectContractScopeTime(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionContractScopeTimeStart(String op, java.util.Date val) {
		setConditionContractScopeTimeStart(op, val, CONDITION_AND);
	}

	public void setConditionContractScopeTimeStart(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectContractScopeTimeStart(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionContractScopeTimeEnd(String op, java.util.Date val) {
		setConditionContractScopeTimeEnd(op, val, CONDITION_AND);
	}

	public void setConditionContractScopeTimeEnd(String op, java.util.Date val, String relation) {
		addCondition(19, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectContractScopeTimeEnd(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(21, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionSupplierOrigin(String op, java.lang.String val) {
		setConditionSupplierOrigin(op, val, CONDITION_AND);
	}

	public void setConditionSupplierOrigin(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectSupplierOrigin(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionSupplierStatus(String op, java.lang.Integer val) {
		setConditionSupplierStatus(op, val, CONDITION_AND);
	}

	public void setConditionSupplierStatus(String op, java.lang.Integer val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectSupplierStatus(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionIsUse(String op, java.lang.Integer val) {
		setConditionIsUse(op, val, CONDITION_AND);
	}

	public void setConditionIsUse(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectIsUse(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val) {
		setConditionReceiveUnitManageId(op, val, CONDITION_AND);
	}

	public void setConditionReceiveUnitManageId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectReceiveUnitManageId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionAgreementType(String op, java.lang.Integer val) {
		setConditionAgreementType(op, val, CONDITION_AND);
	}

	public void setConditionAgreementType(String op, java.lang.Integer val, String relation) {
		addCondition(26, op, relation, val);
	}

	public void setSelectAgreementType(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionAgreementSignTime(String op, java.util.Date val) {
		setConditionAgreementSignTime(op, val, CONDITION_AND);
	}

	public void setConditionAgreementSignTime(String op, java.util.Date val, String relation) {
		addCondition(27, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectAgreementSignTime(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionAgreementSignAddress(String op, java.lang.String val) {
		setConditionAgreementSignAddress(op, val, CONDITION_AND);
	}

	public void setConditionAgreementSignAddress(String op, java.lang.String val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectAgreementSignAddress(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionFileId(String op, java.lang.Integer val) {
		setConditionFileId(op, val, CONDITION_AND);
	}

	public void setConditionFileId(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectFileId(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionTeamSize(String op, java.lang.Integer val) {
		setConditionTeamSize(op, val, CONDITION_AND);
	}

	public void setConditionTeamSize(String op, java.lang.Integer val, String relation) {
		addCondition(30, op, relation, val);
	}

	public void setSelectTeamSize(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionAreasExpertise(String op, java.lang.Integer val) {
		setConditionAreasExpertise(op, val, CONDITION_AND);
	}

	public void setConditionAreasExpertise(String op, java.lang.Integer val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectAreasExpertise(boolean val) {
		__select_flags[31] = val;
	}

	public void setConditionAttachmentName(String op, java.lang.String val) {
		setConditionAttachmentName(op, val, CONDITION_AND);
	}

	public void setConditionAttachmentName(String op, java.lang.String val, String relation) {
		addCondition(32, op, relation, val);
	}

	public void setSelectAttachmentName(boolean val) {
		__select_flags[32] = val;
	}

	public void setConditionAttachment(String op, java.lang.String val) {
		setConditionAttachment(op, val, CONDITION_AND);
	}

	public void setConditionAttachment(String op, java.lang.String val, String relation) {
		addCondition(33, op, relation, val);
	}

	public void setSelectAttachment(boolean val) {
		__select_flags[33] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(34, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[34] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(35, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[35] = val;
	}


}

