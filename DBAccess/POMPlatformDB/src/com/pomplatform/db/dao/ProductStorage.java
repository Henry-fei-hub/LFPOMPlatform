package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProductStorage;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProductStorage extends AbstractTable<BaseProductStorage>
{

	public ProductStorage() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 18;

		initTables();

		__tableName            = "product_storages";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProductStorage.CS_PRODUCT_STORAGE_ID;
		__column_names[1] = BaseProductStorage.CS_PERSONNEL_BUSINESS_ID;
		__column_names[2] = BaseProductStorage.CS_SUPPLIER_ID;
		__column_names[3] = BaseProductStorage.CS_PURCHASE_CONTRACT_ID;
		__column_names[4] = BaseProductStorage.CS_PRODUCT_ID;
		__column_names[5] = BaseProductStorage.CS_STORAGE_ID;
		__column_names[6] = BaseProductStorage.CS_IN_OUT_TYPE;
		__column_names[7] = BaseProductStorage.CS_OPERATE_TYPE;
		__column_names[8] = BaseProductStorage.CS_PRODUCT_NUMBER;
		__column_names[9] = BaseProductStorage.CS_PRODUCT_PRICE;
		__column_names[10] = BaseProductStorage.CS_TOTAL_PRICE;
		__column_names[11] = BaseProductStorage.CS_TAX_POINTS;
		__column_names[12] = BaseProductStorage.CS_TAX_PRICE;
		__column_names[13] = BaseProductStorage.CS_FINAL_PRICE;
		__column_names[14] = BaseProductStorage.CS_CREATE_EMPLOYEE_ID;
		__column_names[15] = BaseProductStorage.CS_CREATE_TIME;
		__column_names[16] = BaseProductStorage.CS_IS_COMPLETE;
		__column_names[17] = BaseProductStorage.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProductStorage b) {
		clear();
		setProductStorageIdClear(b.getProductStorageId());
	}

	public boolean isPrimaryKeyNull() {
		return getProductStorageId() == null;
	}

	@Override
	public BaseProductStorage generateBase(){
		BaseProductStorage b = new BaseProductStorage();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProductStorage b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProductStorageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPurchaseContractId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setStorageId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInOutType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxPoints(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setIsComplete(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseProductStorage b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProductStorageId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getPurchaseContractId();
		buff[count++] = b.getProductId();
		buff[count++] = b.getStorageId();
		buff[count++] = b.getInOutType();
		buff[count++] = b.getOperateType();
		buff[count++] = b.getProductNumber();
		buff[count++] = b.getProductPrice();
		buff[count++] = b.getTotalPrice();
		buff[count++] = b.getTaxPoints();
		buff[count++] = b.getTaxPrice();
		buff[count++] = b.getFinalPrice();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getIsComplete();
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseProductStorage b){
		if(b.getProductStorageId() != null) setProductStorageIdClear(b.getProductStorageId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getPurchaseContractId() != null) setPurchaseContractId(b.getPurchaseContractId());
		if(b.getProductId() != null) setProductId(b.getProductId());
		if(b.getStorageId() != null) setStorageId(b.getStorageId());
		if(b.getInOutType() != null) setInOutType(b.getInOutType());
		if(b.getOperateType() != null) setOperateType(b.getOperateType());
		if(b.getProductNumber() != null) setProductNumber(b.getProductNumber());
		if(b.getProductPrice() != null) setProductPrice(b.getProductPrice());
		if(b.getTotalPrice() != null) setTotalPrice(b.getTotalPrice());
		if(b.getTaxPoints() != null) setTaxPoints(b.getTaxPoints());
		if(b.getTaxPrice() != null) setTaxPrice(b.getTaxPrice());
		if(b.getFinalPrice() != null) setFinalPrice(b.getFinalPrice());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getIsComplete() != null) setIsComplete(b.getIsComplete());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseProductStorage generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProductStorage b = new BaseProductStorage();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProductStorage __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductStorageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPurchaseContractId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStorageId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInOutType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxPoints(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsComplete(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setProductStorageId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProductStorageId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProductStorageIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setPurchaseContractId(java.lang.Integer val) {
		setCurrentData(3, val);
	}

	public java.lang.Integer getPurchaseContractId() {
		return GenericBase.__getInt(__current_data[3]);
	}

	public void setProductId(java.lang.Integer val) {
		setCurrentData(4, val);
	}

	public java.lang.Integer getProductId() {
		return GenericBase.__getInt(__current_data[4]);
	}

	public void setStorageId(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getStorageId() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setInOutType(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getInOutType() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setOperateType(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getOperateType() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setProductNumber(java.lang.Integer val) {
		setCurrentData(8, val);
	}

	public java.lang.Integer getProductNumber() {
		return GenericBase.__getInt(__current_data[8]);
	}

	public void setProductPrice(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getProductPrice() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setTotalPrice(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getTotalPrice() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setTaxPoints(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getTaxPoints() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setTaxPrice(java.math.BigDecimal val) {
		setCurrentData(12, val);
	}

	public java.math.BigDecimal getTaxPrice() {
		return GenericBase.__getDecimal(__current_data[12]);
	}

	public void setFinalPrice(java.math.BigDecimal val) {
		setCurrentData(13, val);
	}

	public java.math.BigDecimal getFinalPrice() {
		return GenericBase.__getDecimal(__current_data[13]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(14, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[14]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(15, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[15]);
	}

	public void setIsComplete(java.lang.Boolean val) {
		setCurrentData(16, val);
	}

	public java.lang.Boolean getIsComplete() {
		return GenericBase.__getBoolean(__current_data[16]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setConditionProductStorageId(String op, java.lang.Integer val) {
		setConditionProductStorageId(op, val, CONDITION_AND);
	}

	public void setConditionProductStorageId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProductStorageId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val) {
		setConditionPersonnelBusinessId(op, val, CONDITION_AND);
	}

	public void setConditionPersonnelBusinessId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectPersonnelBusinessId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionPurchaseContractId(String op, java.lang.Integer val) {
		setConditionPurchaseContractId(op, val, CONDITION_AND);
	}

	public void setConditionPurchaseContractId(String op, java.lang.Integer val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectPurchaseContractId(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProductId(String op, java.lang.Integer val) {
		setConditionProductId(op, val, CONDITION_AND);
	}

	public void setConditionProductId(String op, java.lang.Integer val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProductId(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionStorageId(String op, java.lang.Integer val) {
		setConditionStorageId(op, val, CONDITION_AND);
	}

	public void setConditionStorageId(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectStorageId(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionInOutType(String op, java.lang.Integer val) {
		setConditionInOutType(op, val, CONDITION_AND);
	}

	public void setConditionInOutType(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectInOutType(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionOperateType(String op, java.lang.Integer val) {
		setConditionOperateType(op, val, CONDITION_AND);
	}

	public void setConditionOperateType(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectOperateType(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionProductNumber(String op, java.lang.Integer val) {
		setConditionProductNumber(op, val, CONDITION_AND);
	}

	public void setConditionProductNumber(String op, java.lang.Integer val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProductNumber(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionProductPrice(String op, java.math.BigDecimal val) {
		setConditionProductPrice(op, val, CONDITION_AND);
	}

	public void setConditionProductPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProductPrice(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val) {
		setConditionTotalPrice(op, val, CONDITION_AND);
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectTotalPrice(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionTaxPoints(String op, java.math.BigDecimal val) {
		setConditionTaxPoints(op, val, CONDITION_AND);
	}

	public void setConditionTaxPoints(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectTaxPoints(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionTaxPrice(String op, java.math.BigDecimal val) {
		setConditionTaxPrice(op, val, CONDITION_AND);
	}

	public void setConditionTaxPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectTaxPrice(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionFinalPrice(String op, java.math.BigDecimal val) {
		setConditionFinalPrice(op, val, CONDITION_AND);
	}

	public void setConditionFinalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectFinalPrice(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(15, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionIsComplete(String op, java.lang.Boolean val) {
		setConditionIsComplete(op, val, CONDITION_AND);
	}

	public void setConditionIsComplete(String op, java.lang.Boolean val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectIsComplete(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[17] = val;
	}


}

