package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BasePurchaseContract;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class PurchaseContract extends AbstractTable<BasePurchaseContract>
{

	public PurchaseContract() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 19;

		initTables();

		__tableName            = "purchase_contracts";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BasePurchaseContract.CS_PURCHASE_CONTRACT_ID;
		__column_names[1] = BasePurchaseContract.CS_CONTRACT_NAME;
		__column_names[2] = BasePurchaseContract.CS_CONTRACT_CODE;
		__column_names[3] = BasePurchaseContract.CS_SUPPLIER_ID;
		__column_names[4] = BasePurchaseContract.CS_PURCHASE_PERSON;
		__column_names[5] = BasePurchaseContract.CS_CONTRACT_AMOUNT;
		__column_names[6] = BasePurchaseContract.CS_MAIN_PROJECT_ID;
		__column_names[7] = BasePurchaseContract.CS_PROJECT_NAME;
		__column_names[8] = BasePurchaseContract.CS_QUALITY_ASSURANCE;
		__column_names[9] = BasePurchaseContract.CS_CONTRACT_DATE;
		__column_names[10] = BasePurchaseContract.CS_TERM_OF_PAYMENT;
		__column_names[11] = BasePurchaseContract.CS_AFTER_SALE_REQUIREMENTS;
		__column_names[12] = BasePurchaseContract.CS_AMOUNT_PAID;
		__column_names[13] = BasePurchaseContract.CS_AMOUNT_UNPAID;
		__column_names[14] = BasePurchaseContract.CS_HAVE_INVOICE_AMOUNT;
		__column_names[15] = BasePurchaseContract.CS_LACK_INVOICE_AMOUNT;
		__column_names[16] = BasePurchaseContract.CS_CONTRACT_ATTACHMENT;
		__column_names[17] = BasePurchaseContract.CS_PERSONNEL_BUSINESS_ID;
		__column_names[18] = BasePurchaseContract.CS_CREATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BasePurchaseContract b) {
		clear();
		setPurchaseContractIdClear(b.getPurchaseContractId());
	}

	public boolean isPrimaryKeyNull() {
		return getPurchaseContractId() == null;
	}

	@Override
	public BasePurchaseContract generateBase(){
		BasePurchaseContract b = new BasePurchaseContract();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BasePurchaseContract b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractCode(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchasePerson(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setQualityAssurance(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setTermOfPayment(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAfterSaleRequirements(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAmountPaid(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAmountUnpaid(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHaveInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLackInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setContractAttachment(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BasePurchaseContract b, Object[] buff){
		int count = 0;
		buff[count++] = b.getPurchaseContractId();
		buff[count++] = b.getContractName();
		buff[count++] = b.getContractCode();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getPurchasePerson();
		buff[count++] = b.getContractAmount();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getProjectName();
		buff[count++] = b.getQualityAssurance();
		buff[count++] = generateTimestampFromDate(b.getContractDate());
		buff[count++] = b.getTermOfPayment();
		buff[count++] = b.getAfterSaleRequirements();
		buff[count++] = b.getAmountPaid();
		buff[count++] = b.getAmountUnpaid();
		buff[count++] = b.getHaveInvoiceAmount();
		buff[count++] = b.getLackInvoiceAmount();
		buff[count++] = b.getContractAttachment();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
	}

	@Override
	public void setDataFromBase(BasePurchaseContract b){
		if(b.getPurchaseContractId() != null) setPurchaseContractIdClear(b.getPurchaseContractId());
		if(b.getContractName() != null) setContractName(b.getContractName());
		if(b.getContractCode() != null) setContractCode(b.getContractCode());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getPurchasePerson() != null) setPurchasePerson(b.getPurchasePerson());
		if(b.getContractAmount() != null) setContractAmount(b.getContractAmount());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getProjectName() != null) setProjectName(b.getProjectName());
		if(b.getQualityAssurance() != null) setQualityAssurance(b.getQualityAssurance());
		if(b.getContractDate() != null) setContractDate(b.getContractDate());
		if(b.getTermOfPayment() != null) setTermOfPayment(b.getTermOfPayment());
		if(b.getAfterSaleRequirements() != null) setAfterSaleRequirements(b.getAfterSaleRequirements());
		if(b.getAmountPaid() != null) setAmountPaid(b.getAmountPaid());
		if(b.getAmountUnpaid() != null) setAmountUnpaid(b.getAmountUnpaid());
		if(b.getHaveInvoiceAmount() != null) setHaveInvoiceAmount(b.getHaveInvoiceAmount());
		if(b.getLackInvoiceAmount() != null) setLackInvoiceAmount(b.getLackInvoiceAmount());
		if(b.getContractAttachment() != null) setContractAttachment(b.getContractAttachment());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
	}

	@Override
	public BasePurchaseContract generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BasePurchaseContract b = new BasePurchaseContract();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BasePurchaseContract __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractCode(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchasePerson(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setQualityAssurance(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTermOfPayment(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAfterSaleRequirements(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmountPaid(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmountUnpaid(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveInvoiceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLackInvoiceAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setContractAttachment(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setPurchaseContractId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getPurchaseContractId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setPurchaseContractIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setContractName(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getContractName() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setContractCode(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getContractCode() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setPurchasePerson(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getPurchasePerson() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setContractAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getContractAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setProjectName(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getProjectName() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setQualityAssurance(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getQualityAssurance() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setContractDate(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getContractDate() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setTermOfPayment(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getTermOfPayment() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setAfterSaleRequirements(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getAfterSaleRequirements() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setAmountPaid(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getAmountPaid() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setAmountUnpaid(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getAmountUnpaid() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setHaveInvoiceAmount(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getHaveInvoiceAmount() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setLackInvoiceAmount(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getLackInvoiceAmount() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setContractAttachment(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getContractAttachment() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(18, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[18]);
	}

	public void setConditionPurchaseContractId(String op, java.lang.Integer val) {
		setConditionPurchaseContractId(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseContractId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectPurchaseContractId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionContractName(String op, java.lang.String val) {
		setConditionContractName(op, val, CONDITION_AND);
	}

	public void setConditionContractName(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectContractName(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionContractCode(String op, java.lang.String val) {
		setConditionContractCode(op, val, CONDITION_AND);
	}

	public void setConditionContractCode(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectContractCode(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionPurchasePerson(String op, java.lang.Integer val) {
		setConditionPurchasePerson(op, val, CONDITION_AND);
	}

	public void setConditionPurchasePerson(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectPurchasePerson(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val) {
		setConditionContractAmount(op, val, CONDITION_AND);
	}

	public void setConditionContractAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectContractAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionProjectName(String op, java.lang.String val) {
		setConditionProjectName(op, val, CONDITION_AND);
	}

	public void setConditionProjectName(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectProjectName(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionQualityAssurance(String op, java.lang.String val) {
		setConditionQualityAssurance(op, val, CONDITION_AND);
	}

	public void setConditionQualityAssurance(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectQualityAssurance(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionContractDate(String op, java.util.Date val) {
		setConditionContractDate(op, val, CONDITION_AND);
	}

	public void setConditionContractDate(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectContractDate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionTermOfPayment(String op, java.lang.String val) {
		setConditionTermOfPayment(op, val, CONDITION_AND);
	}

	public void setConditionTermOfPayment(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTermOfPayment(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionAfterSaleRequirements(String op, java.lang.String val) {
		setConditionAfterSaleRequirements(op, val, CONDITION_AND);
	}

	public void setConditionAfterSaleRequirements(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectAfterSaleRequirements(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionAmountPaid(String op, java.math.BigDecimal val) {
		setConditionAmountPaid(op, val, CONDITION_AND);
	}

	public void setConditionAmountPaid(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectAmountPaid(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionAmountUnpaid(String op, java.math.BigDecimal val) {
		setConditionAmountUnpaid(op, val, CONDITION_AND);
	}

	public void setConditionAmountUnpaid(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectAmountUnpaid(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionHaveInvoiceAmount(String op, java.math.BigDecimal val) {
		setConditionHaveInvoiceAmount(op, val, CONDITION_AND);
	}

	public void setConditionHaveInvoiceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectHaveInvoiceAmount(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionLackInvoiceAmount(String op, java.math.BigDecimal val) {
		setConditionLackInvoiceAmount(op, val, CONDITION_AND);
	}

	public void setConditionLackInvoiceAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectLackInvoiceAmount(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionContractAttachment(String op, java.lang.Integer val) {
		setConditionContractAttachment(op, val, CONDITION_AND);
	}

	public void setConditionContractAttachment(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectContractAttachment(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(18, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[18] = val;
	}


}

