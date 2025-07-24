package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseProductInquiryDetail;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class ProductInquiryDetail extends AbstractTable<BaseProductInquiryDetail>
{

	public ProductInquiryDetail() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 21;

		initTables();

		__tableName            = "product_inquiry_details";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseProductInquiryDetail.CS_PRODUCT_INQUIRY_DETAIL_ID;
		__column_names[1] = BaseProductInquiryDetail.CS_PRODUCT_INQUIRY_TOTAL_ID;
		__column_names[2] = BaseProductInquiryDetail.CS_PRODUCT_ID;
		__column_names[3] = BaseProductInquiryDetail.CS_PRODUCT_NAME;
		__column_names[4] = BaseProductInquiryDetail.CS_PRODUCT_MODEL;
		__column_names[5] = BaseProductInquiryDetail.CS_PRODUCT_NUMBER;
		__column_names[6] = BaseProductInquiryDetail.CS_PRODUCT_UNIT;
		__column_names[7] = BaseProductInquiryDetail.CS_PRE_TECHNICAL_INDICATOR;
		__column_names[8] = BaseProductInquiryDetail.CS_PRODUCT_SPECIFICATION;
		__column_names[9] = BaseProductInquiryDetail.CS_INQUIRY_TECHNICAL_INDICATOR;
		__column_names[10] = BaseProductInquiryDetail.CS_PERSON_IN_CHARGE;
		__column_names[11] = BaseProductInquiryDetail.CS_CREATE_EMPLOYEE_ID;
		__column_names[12] = BaseProductInquiryDetail.CS_CREATE_TIME;
		__column_names[13] = BaseProductInquiryDetail.CS_REMARK;
		__column_names[14] = BaseProductInquiryDetail.CS_PRODUCT_PRICE;
		__column_names[15] = BaseProductInquiryDetail.CS_TOTAL_PRICE;
		__column_names[16] = BaseProductInquiryDetail.CS_SUPPLIER_ID;
		__column_names[17] = BaseProductInquiryDetail.CS_PERSONNEL_BUSINESS_ID;
		__column_names[18] = BaseProductInquiryDetail.CS_MAIN_PROJECT_ID;
		__column_names[19] = BaseProductInquiryDetail.CS_IS_PASS;
		__column_names[20] = BaseProductInquiryDetail.CS_TAX_POINTS;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseProductInquiryDetail b) {
		clear();
		setProductInquiryDetailIdClear(b.getProductInquiryDetailId());
	}

	public boolean isPrimaryKeyNull() {
		return getProductInquiryDetailId() == null;
	}

	@Override
	public BaseProductInquiryDetail generateBase(){
		BaseProductInquiryDetail b = new BaseProductInquiryDetail();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseProductInquiryDetail b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setProductInquiryDetailId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductInquiryTotalId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductName(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductModel(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductNumber(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProductUnit(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPreTechnicalIndicator(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductSpecification(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInquiryTechnicalIndicator(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setPersonInCharge(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProductPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setSupplierId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setMainProjectId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setIsPass(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setTaxPoints(GenericBase.__getDecimal(val));
	}

	@Override
	public void setBaseToBuffer(BaseProductInquiryDetail b, Object[] buff){
		int count = 0;
		buff[count++] = b.getProductInquiryDetailId();
		buff[count++] = b.getProductInquiryTotalId();
		buff[count++] = b.getProductId();
		buff[count++] = b.getProductName();
		buff[count++] = b.getProductModel();
		buff[count++] = b.getProductNumber();
		buff[count++] = b.getProductUnit();
		buff[count++] = b.getPreTechnicalIndicator();
		buff[count++] = b.getProductSpecification();
		buff[count++] = b.getInquiryTechnicalIndicator();
		buff[count++] = b.getPersonInCharge();
		buff[count++] = b.getCreateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = b.getRemark();
		buff[count++] = b.getProductPrice();
		buff[count++] = b.getTotalPrice();
		buff[count++] = b.getSupplierId();
		buff[count++] = b.getPersonnelBusinessId();
		buff[count++] = b.getMainProjectId();
		buff[count++] = b.getIsPass();
		buff[count++] = b.getTaxPoints();
	}

	@Override
	public void setDataFromBase(BaseProductInquiryDetail b){
		if(b.getProductInquiryDetailId() != null) setProductInquiryDetailIdClear(b.getProductInquiryDetailId());
		if(b.getProductInquiryTotalId() != null) setProductInquiryTotalId(b.getProductInquiryTotalId());
		if(b.getProductId() != null) setProductId(b.getProductId());
		if(b.getProductName() != null) setProductName(b.getProductName());
		if(b.getProductModel() != null) setProductModel(b.getProductModel());
		if(b.getProductNumber() != null) setProductNumber(b.getProductNumber());
		if(b.getProductUnit() != null) setProductUnit(b.getProductUnit());
		if(b.getPreTechnicalIndicator() != null) setPreTechnicalIndicator(b.getPreTechnicalIndicator());
		if(b.getProductSpecification() != null) setProductSpecification(b.getProductSpecification());
		if(b.getInquiryTechnicalIndicator() != null) setInquiryTechnicalIndicator(b.getInquiryTechnicalIndicator());
		if(b.getPersonInCharge() != null) setPersonInCharge(b.getPersonInCharge());
		if(b.getCreateEmployeeId() != null) setCreateEmployeeId(b.getCreateEmployeeId());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getProductPrice() != null) setProductPrice(b.getProductPrice());
		if(b.getTotalPrice() != null) setTotalPrice(b.getTotalPrice());
		if(b.getSupplierId() != null) setSupplierId(b.getSupplierId());
		if(b.getPersonnelBusinessId() != null) setPersonnelBusinessId(b.getPersonnelBusinessId());
		if(b.getMainProjectId() != null) setMainProjectId(b.getMainProjectId());
		if(b.getIsPass() != null) setIsPass(b.getIsPass());
		if(b.getTaxPoints() != null) setTaxPoints(b.getTaxPoints());
	}

	@Override
	public BaseProductInquiryDetail generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseProductInquiryDetail b = new BaseProductInquiryDetail();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseProductInquiryDetail __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductInquiryDetailId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductInquiryTotalId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductName(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductModel(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductNumber(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductUnit(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPreTechnicalIndicator(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductSpecification(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInquiryTechnicalIndicator(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonInCharge(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProductPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsPass(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTaxPoints(GenericBase.__getDecimal(val));
	}

	public void setProductInquiryDetailId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getProductInquiryDetailId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setProductInquiryDetailIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProductInquiryTotalId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProductInquiryTotalId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setProductId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getProductId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setProductName(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProductName() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProductModel(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProductModel() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setProductNumber(java.lang.Integer val) {
		setCurrentData(5, val);
	}

	public java.lang.Integer getProductNumber() {
		return GenericBase.__getInt(__current_data[5]);
	}

	public void setProductUnit(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getProductUnit() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setPreTechnicalIndicator(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getPreTechnicalIndicator() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setProductSpecification(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getProductSpecification() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setInquiryTechnicalIndicator(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getInquiryTechnicalIndicator() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setPersonInCharge(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getPersonInCharge() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setCreateEmployeeId(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getCreateEmployeeId() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(12, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[12]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setProductPrice(java.math.BigDecimal val) {
		setCurrentData(14, val);
	}

	public java.math.BigDecimal getProductPrice() {
		return GenericBase.__getDecimal(__current_data[14]);
	}

	public void setTotalPrice(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getTotalPrice() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setSupplierId(java.lang.Integer val) {
		setCurrentData(16, val);
	}

	public java.lang.Integer getSupplierId() {
		return GenericBase.__getInt(__current_data[16]);
	}

	public void setPersonnelBusinessId(java.lang.Integer val) {
		setCurrentData(17, val);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return GenericBase.__getInt(__current_data[17]);
	}

	public void setMainProjectId(java.lang.Integer val) {
		setCurrentData(18, val);
	}

	public java.lang.Integer getMainProjectId() {
		return GenericBase.__getInt(__current_data[18]);
	}

	public void setIsPass(java.lang.Boolean val) {
		setCurrentData(19, val);
	}

	public java.lang.Boolean getIsPass() {
		return GenericBase.__getBoolean(__current_data[19]);
	}

	public void setTaxPoints(java.math.BigDecimal val) {
		setCurrentData(20, val);
	}

	public java.math.BigDecimal getTaxPoints() {
		return GenericBase.__getDecimal(__current_data[20]);
	}

	public void setConditionProductInquiryDetailId(String op, java.lang.Integer val) {
		setConditionProductInquiryDetailId(op, val, CONDITION_AND);
	}

	public void setConditionProductInquiryDetailId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectProductInquiryDetailId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProductInquiryTotalId(String op, java.lang.Integer val) {
		setConditionProductInquiryTotalId(op, val, CONDITION_AND);
	}

	public void setConditionProductInquiryTotalId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProductInquiryTotalId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionProductId(String op, java.lang.Integer val) {
		setConditionProductId(op, val, CONDITION_AND);
	}

	public void setConditionProductId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectProductId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProductName(String op, java.lang.String val) {
		setConditionProductName(op, val, CONDITION_AND);
	}

	public void setConditionProductName(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProductName(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProductModel(String op, java.lang.String val) {
		setConditionProductModel(op, val, CONDITION_AND);
	}

	public void setConditionProductModel(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProductModel(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionProductNumber(String op, java.lang.Integer val) {
		setConditionProductNumber(op, val, CONDITION_AND);
	}

	public void setConditionProductNumber(String op, java.lang.Integer val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectProductNumber(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionProductUnit(String op, java.lang.String val) {
		setConditionProductUnit(op, val, CONDITION_AND);
	}

	public void setConditionProductUnit(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectProductUnit(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionPreTechnicalIndicator(String op, java.lang.String val) {
		setConditionPreTechnicalIndicator(op, val, CONDITION_AND);
	}

	public void setConditionPreTechnicalIndicator(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectPreTechnicalIndicator(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionProductSpecification(String op, java.lang.String val) {
		setConditionProductSpecification(op, val, CONDITION_AND);
	}

	public void setConditionProductSpecification(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectProductSpecification(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionInquiryTechnicalIndicator(String op, java.lang.String val) {
		setConditionInquiryTechnicalIndicator(op, val, CONDITION_AND);
	}

	public void setConditionInquiryTechnicalIndicator(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectInquiryTechnicalIndicator(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionPersonInCharge(String op, java.lang.Integer val) {
		setConditionPersonInCharge(op, val, CONDITION_AND);
	}

	public void setConditionPersonInCharge(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectPersonInCharge(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val) {
		setConditionCreateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionCreateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectCreateEmployeeId(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(12, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionProductPrice(String op, java.math.BigDecimal val) {
		setConditionProductPrice(op, val, CONDITION_AND);
	}

	public void setConditionProductPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectProductPrice(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val) {
		setConditionTotalPrice(op, val, CONDITION_AND);
	}

	public void setConditionTotalPrice(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectTotalPrice(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionSupplierId(String op, java.lang.Integer val) {
		setConditionSupplierId(op, val, CONDITION_AND);
	}

	public void setConditionSupplierId(String op, java.lang.Integer val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectSupplierId(boolean val) {
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

	public void setConditionMainProjectId(String op, java.lang.Integer val) {
		setConditionMainProjectId(op, val, CONDITION_AND);
	}

	public void setConditionMainProjectId(String op, java.lang.Integer val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectMainProjectId(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionIsPass(String op, java.lang.Boolean val) {
		setConditionIsPass(op, val, CONDITION_AND);
	}

	public void setConditionIsPass(String op, java.lang.Boolean val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectIsPass(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionTaxPoints(String op, java.math.BigDecimal val) {
		setConditionTaxPoints(op, val, CONDITION_AND);
	}

	public void setConditionTaxPoints(String op, java.math.BigDecimal val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectTaxPoints(boolean val) {
		__select_flags[20] = val;
	}


}

