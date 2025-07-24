package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProductInquirySupplierDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProductInquirySupplierDetail extends AbstractTable<BaseProductInquirySupplierDetail>
{

	public ProductInquirySupplierDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 13;

		initTables();

		__tableName            = "product_inquiry_supplier_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProductInquirySupplierDetail.CS_PRODUCT_INQUIRY_SUPPLIER_DETAIL_ID;
		__column_names[1] = BaseProductInquirySupplierDetail.CS_SUPPLIER_ID;
		__column_names[2] = BaseProductInquirySupplierDetail.CS_PRODUCT_INQUIRY_DETAIL_ID;
		__column_names[3] = BaseProductInquirySupplierDetail.CS_PRODUCT_PRICE;
		__column_names[4] = BaseProductInquirySupplierDetail.CS_TOTAL_PRICE;
		__column_names[5] = BaseProductInquirySupplierDetail.CS_TAX_POINTS;
		__column_names[6] = BaseProductInquirySupplierDetail.CS_PRIORITY_LEVEL;
		__column_names[7] = BaseProductInquirySupplierDetail.CS_REMARK;
		__column_names[8] = BaseProductInquirySupplierDetail.CS_INQUIRY_DATE;
		__column_names[9] = BaseProductInquirySupplierDetail.CS_CREATE_TIME;
		__column_names[10] = BaseProductInquirySupplierDetail.CS_OPERATOR_ID;
		__column_names[11] = BaseProductInquirySupplierDetail.CS_SUPPLIER_CONTACT_ID;
		__column_names[12] = BaseProductInquirySupplierDetail.CS_IS_SELECT;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProductInquirySupplierDetail b) {
		clear();
		setProductInquirySupplierDetailIdClear(b.getProductInquirySupplierDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getProductInquirySupplierDetailId() == null;
	}

	@Override
	public BaseProductInquirySupplierDetail generateBase(){
		BaseProductInquirySupplierDetail b = new BaseProductInquirySupplierDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProductInquirySupplierDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProductInquirySupplierDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductInquiryDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTaxPoints(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setPriorityLevel(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInquiryDate(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setOperatorId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSupplierContactId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsSelect(GenericBase.__getBoolean(val));
	}

	@Override
	public void setBaseToBuffer(BaseProductInquirySupplierDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProductInquirySupplierDetailId();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getProductInquiryDetailId();
		buff[count++] = b.getProductPrice();
		buff[count++] = b.getTotalPrice();
		buff[count++] = b.getTaxPoints();
		buff[count++] = b.getPriorityLevel();
		buff[count++] = b.getRemark();
		buff[count++] = generateTimestampFromDate(b.getInquiryDate());
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getOperatorId();
		buff[count++] = b.getSupplierContactId();
		buff[count++] = b.getIsSelect();
	}

	@Override
	public void setDataFromBase(BaseProductInquirySupplierDetail b){
		if(b.getProductInquirySupplierDetailId() != null) setProductInquirySupplierDetailIdClear(b.getProductInquirySupplierDetailId());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getProductInquiryDetailId() != null) setProductInquiryDetailId(b.getProductInquiryDetailId());
		if(b.getProductPrice() != null) setProductPrice(b.getProductPrice());
		if(b.getTotalPrice() != null) setTotalPrice(b.getTotalPrice());
		if(b.getTaxPoints() != null) setTaxPoints(b.getTaxPoints());
		if(b.getPriorityLevel() != null) setPriorityLevel(b.getPriorityLevel());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getInquiryDate() != null) setInquiryDate(b.getInquiryDate());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getOperatorId() != null) setOperatorId(b.getOperatorId());
		if(b.getSupplierContactId() != null) setSupplierContactId(b.getSupplierContactId());
		if(b.getIsSelect() != null) setIsSelect(b.getIsSelect());
	}

	@Override
	public BaseProductInquirySupplierDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProductInquirySupplierDetail b = new BaseProductInquirySupplierDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProductInquirySupplierDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductInquirySupplierDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductInquiryDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxPoints(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPriorityLevel(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInquiryDate(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierContactId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsSelect(GenericBase.__getBoolean(val));
	}

	public void setProductInquirySupplierDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProductInquirySupplierDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProductInquirySupplierDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProductInquiryDetailId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProductInquiryDetailId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setProductPrice(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getProductPrice() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setTotalPrice(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getTotalPrice() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setTaxPoints(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getTaxPoints() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setPriorityLevel(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getPriorityLevel() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setInquiryDate(java.util.Date val) {
		setCurrentData(8, generateTimestampFromDate(val));
	}

	public java.util.Date getInquiryDate() {
		return GenericBase.__getDateFromSQL(__current_data[8]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(9, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[9]);
	}

	public void setOperatorId(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getOperatorId() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setSupplierContactId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getSupplierContactId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setIsSelect(java.lang.Boolean val) {
		setCurrentData(12, val);
	}

	public java.lang.Boolean getIsSelect() {
		return GenericBase.__getBoolean(__current_data[12]);
	}

	public void setConditionProductInquirySupplierDetailId(String op, java.lang.Integer val) {
		setConditionProductInquirySupplierDetailId(op, val, CONDITION_AND);
	}

	public void setConditionProductInquirySupplierDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProductInquirySupplierDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProductInquiryDetailId(String op, java.lang.Integer val) {
		setConditionProductInquiryDetailId(op, val, CONDITION_AND);
	}

	public void setConditionProductInquiryDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProductInquiryDetailId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProductPrice(String op, java.math.BigDecimal val) {
		setConditionProductPrice(op, val, CONDITION_AND);
	}

	public void setConditionProductPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProductPrice(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val) {
		setConditionTotalPrice(op, val, CONDITION_AND);
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectTotalPrice(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionTaxPoints(String op, java.math.BigDecimal val) {
		setConditionTaxPoints(op, val, CONDITION_AND);
	}

	public void setConditionTaxPoints(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectTaxPoints(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionPriorityLevel(String op, java.lang.Integer val) {
		setConditionPriorityLevel(op, val, CONDITION_AND);
	}

	public void setConditionPriorityLevel(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectPriorityLevel(boolean val) {
		__select_flags[6] = val;
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

	public void setConditionInquiryDate(String op, java.util.Date val) {
		setConditionInquiryDate(op, val, CONDITION_AND);
	}

	public void setConditionInquiryDate(String op, java.util.Date val, String relation) {
		addCondition(8, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectInquiryDate(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(9, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionOperatorId(String op, java.lang.Integer val) {
		setConditionOperatorId(op, val, CONDITION_AND);
	}

	public void setConditionOperatorId(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectOperatorId(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionSupplierContactId(String op, java.lang.Integer val) {
		setConditionSupplierContactId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierContactId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectSupplierContactId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionIsSelect(String op, java.lang.Boolean val) {
		setConditionIsSelect(op, val, CONDITION_AND);
	}

	public void setConditionIsSelect(String op, java.lang.Boolean val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectIsSelect(boolean val) {
		__select_flags[12] = val;
	}


}

