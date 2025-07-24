package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class NormalReimbursementLinkDepartment extends AbstractTable<BaseNormalReimbursementLinkDepartment>
{

	public NormalReimbursementLinkDepartment() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 12;

		initTables();

		__tableName            = "normal_reimbursement_link_departments";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseNormalReimbursementLinkDepartment.CS_NORMAL_REIMBURSEMENT_LINK_DEPARTMENT_ID;
		__column_names[1] = BaseNormalReimbursementLinkDepartment.CS_PROJECT_NORMAL_REIMBURSEMENT_ID;
		__column_names[2] = BaseNormalReimbursementLinkDepartment.CS_DEPARTMENT_ID;
		__column_names[3] = BaseNormalReimbursementLinkDepartment.CS_AMOUNT;
		__column_names[4] = BaseNormalReimbursementLinkDepartment.CS_INPUT_TAX;
		__column_names[5] = BaseNormalReimbursementLinkDepartment.CS_FINAL_AMOUNT;
		__column_names[6] = BaseNormalReimbursementLinkDepartment.CS_MAIN_ITEM_ID;
		__column_names[7] = BaseNormalReimbursementLinkDepartment.CS_SUB_ITEM_ID;
		__column_names[8] = BaseNormalReimbursementLinkDepartment.CS_REMARK;
		__column_names[9] = BaseNormalReimbursementLinkDepartment.CS_INPUT_TAX_REBATE;
		__column_names[10] = BaseNormalReimbursementLinkDepartment.CS_HAVE_ELECTRONIC_INVOICE;
		__column_names[11] = BaseNormalReimbursementLinkDepartment.CS_INVOICE_LINK_KEY;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseNormalReimbursementLinkDepartment b) {
		clear();
		setNormalReimbursementLinkDepartmentIdClear(b.getNormalReimbursementLinkDepartmentId());
	}

	public boolean isPrimaryKeyNull() {
		return getNormalReimbursementLinkDepartmentId() == null;
	}

	@Override
	public BaseNormalReimbursementLinkDepartment generateBase(){
		BaseNormalReimbursementLinkDepartment b = new BaseNormalReimbursementLinkDepartment();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseNormalReimbursementLinkDepartment b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setNormalReimbursementLinkDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setDepartmentId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setInputTax(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setMainItemId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setSubItemId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setInputTaxRebate(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHaveElectronicInvoice(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setInvoiceLinkKey(GenericBase.__getInt(val));
	}

	@Override
	public void setBaseToBuffer(BaseNormalReimbursementLinkDepartment b, Object[] buff){
		int count = 0;
		buff[count++] = b.getNormalReimbursementLinkDepartmentId();
		buff[count++] = b.getProjectNormalReimbursementId();
		buff[count++] = b.getDepartmentId();
		buff[count++] = b.getAmount();
		buff[count++] = b.getInputTax();
		buff[count++] = b.getFinalAmount();
		buff[count++] = b.getMainItemId();
		buff[count++] = b.getSubItemId();
		buff[count++] = b.getRemark();
		buff[count++] = b.getInputTaxRebate();
		buff[count++] = b.getHaveElectronicInvoice();
		buff[count++] = b.getInvoiceLinkKey();
	}

	@Override
	public void setDataFromBase(BaseNormalReimbursementLinkDepartment b){
		if(b.getNormalReimbursementLinkDepartmentId() != null) setNormalReimbursementLinkDepartmentIdClear(b.getNormalReimbursementLinkDepartmentId());
		if(b.getProjectNormalReimbursementId() != null) setProjectNormalReimbursementId(b.getProjectNormalReimbursementId());
		if(b.getDepartmentId() != null) setDepartmentId(b.getDepartmentId());
		if(b.getAmount() != null) setAmount(b.getAmount());
		if(b.getInputTax() != null) setInputTax(b.getInputTax());
		if(b.getFinalAmount() != null) setFinalAmount(b.getFinalAmount());
		if(b.getMainItemId() != null) setMainItemId(b.getMainItemId());
		if(b.getSubItemId() != null) setSubItemId(b.getSubItemId());
		if(b.getRemark() != null) setRemark(b.getRemark());
		if(b.getInputTaxRebate() != null) setInputTaxRebate(b.getInputTaxRebate());
		if(b.getHaveElectronicInvoice() != null) setHaveElectronicInvoice(b.getHaveElectronicInvoice());
		if(b.getInvoiceLinkKey() != null) setInvoiceLinkKey(b.getInvoiceLinkKey());
	}

	@Override
	public BaseNormalReimbursementLinkDepartment generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseNormalReimbursementLinkDepartment b = new BaseNormalReimbursementLinkDepartment();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseNormalReimbursementLinkDepartment __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNormalReimbursementLinkDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectNormalReimbursementId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainItemId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setSubItemId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInputTaxRebate(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHaveElectronicInvoice(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInvoiceLinkKey(GenericBase.__getInt(val));
	}

	public void setNormalReimbursementLinkDepartmentId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getNormalReimbursementLinkDepartmentId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setNormalReimbursementLinkDepartmentIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setProjectNormalReimbursementId(java.lang.Integer val) {
		setCurrentData(1, val);
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return GenericBase.__getInt(__current_data[1]);
	}

	public void setDepartmentId(java.lang.Integer val) {
		setCurrentData(2, val);
	}

	public java.lang.Integer getDepartmentId() {
		return GenericBase.__getInt(__current_data[2]);
	}

	public void setAmount(java.math.BigDecimal val) {
		setCurrentData(3, val);
	}

	public java.math.BigDecimal getAmount() {
		return GenericBase.__getDecimal(__current_data[3]);
	}

	public void setInputTax(java.math.BigDecimal val) {
		setCurrentData(4, val);
	}

	public java.math.BigDecimal getInputTax() {
		return GenericBase.__getDecimal(__current_data[4]);
	}

	public void setFinalAmount(java.math.BigDecimal val) {
		setCurrentData(5, val);
	}

	public java.math.BigDecimal getFinalAmount() {
		return GenericBase.__getDecimal(__current_data[5]);
	}

	public void setMainItemId(java.lang.Integer val) {
		setCurrentData(6, val);
	}

	public java.lang.Integer getMainItemId() {
		return GenericBase.__getInt(__current_data[6]);
	}

	public void setSubItemId(java.lang.Integer val) {
		setCurrentData(7, val);
	}

	public java.lang.Integer getSubItemId() {
		return GenericBase.__getInt(__current_data[7]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setInputTaxRebate(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setHaveElectronicInvoice(java.lang.Integer val) {
		setCurrentData(10, val);
	}

	public java.lang.Integer getHaveElectronicInvoice() {
		return GenericBase.__getInt(__current_data[10]);
	}

	public void setInvoiceLinkKey(java.lang.Integer val) {
		setCurrentData(11, val);
	}

	public java.lang.Integer getInvoiceLinkKey() {
		return GenericBase.__getInt(__current_data[11]);
	}

	public void setConditionNormalReimbursementLinkDepartmentId(String op, java.lang.Integer val) {
		setConditionNormalReimbursementLinkDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionNormalReimbursementLinkDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectNormalReimbursementLinkDepartmentId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionProjectNormalReimbursementId(String op, java.lang.Integer val) {
		setConditionProjectNormalReimbursementId(op, val, CONDITION_AND);
	}

	public void setConditionProjectNormalReimbursementId(String op, java.lang.Integer val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectProjectNormalReimbursementId(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val) {
		setConditionDepartmentId(op, val, CONDITION_AND);
	}

	public void setConditionDepartmentId(String op, java.lang.Integer val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectDepartmentId(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAmount(String op, java.math.BigDecimal val) {
		setConditionAmount(op, val, CONDITION_AND);
	}

	public void setConditionAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAmount(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val) {
		setConditionInputTax(op, val, CONDITION_AND);
	}

	public void setConditionInputTax(String op, java.math.BigDecimal val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectInputTax(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val) {
		setConditionFinalAmount(op, val, CONDITION_AND);
	}

	public void setConditionFinalAmount(String op, java.math.BigDecimal val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectFinalAmount(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionMainItemId(String op, java.lang.Integer val) {
		setConditionMainItemId(op, val, CONDITION_AND);
	}

	public void setConditionMainItemId(String op, java.lang.Integer val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectMainItemId(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionSubItemId(String op, java.lang.Integer val) {
		setConditionSubItemId(op, val, CONDITION_AND);
	}

	public void setConditionSubItemId(String op, java.lang.Integer val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectSubItemId(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val) {
		setConditionInputTaxRebate(op, val, CONDITION_AND);
	}

	public void setConditionInputTaxRebate(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectInputTaxRebate(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionHaveElectronicInvoice(String op, java.lang.Integer val) {
		setConditionHaveElectronicInvoice(op, val, CONDITION_AND);
	}

	public void setConditionHaveElectronicInvoice(String op, java.lang.Integer val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectHaveElectronicInvoice(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionInvoiceLinkKey(String op, java.lang.Integer val) {
		setConditionInvoiceLinkKey(op, val, CONDITION_AND);
	}

	public void setConditionInvoiceLinkKey(String op, java.lang.Integer val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectInvoiceLinkKey(boolean val) {
		__select_flags[11] = val;
	}


}

