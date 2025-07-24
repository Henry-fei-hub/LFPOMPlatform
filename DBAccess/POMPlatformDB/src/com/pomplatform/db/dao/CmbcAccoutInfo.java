package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseCmbcAccoutInfo;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class CmbcAccoutInfo extends AbstractTable<BaseCmbcAccoutInfo>
{

	public CmbcAccoutInfo() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 22;

		initTables();

		__tableName            = "cmbc_accout_info";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseCmbcAccoutInfo.CS_CMBC_ACCOUT_INFO_ID;
		__column_names[1] = BaseCmbcAccoutInfo.CS_CCYNBR;
		__column_names[2] = BaseCmbcAccoutInfo.CS_C_CCYNBR;
		__column_names[3] = BaseCmbcAccoutInfo.CS_ACCITM;
		__column_names[4] = BaseCmbcAccoutInfo.CS_BBKNBR;
		__column_names[5] = BaseCmbcAccoutInfo.CS_ACCNBR;
		__column_names[6] = BaseCmbcAccoutInfo.CS_ACCNAM;
		__column_names[7] = BaseCmbcAccoutInfo.CS_ACCBLV;
		__column_names[8] = BaseCmbcAccoutInfo.CS_ONLBLV;
		__column_names[9] = BaseCmbcAccoutInfo.CS_HLDBLV;
		__column_names[10] = BaseCmbcAccoutInfo.CS_AVLBLV;
		__column_names[11] = BaseCmbcAccoutInfo.CS_LMTOVR;
		__column_names[12] = BaseCmbcAccoutInfo.CS_STSCOD;
		__column_names[13] = BaseCmbcAccoutInfo.CS_INTCOD;
		__column_names[14] = BaseCmbcAccoutInfo.CS_C_INTRAT;
		__column_names[15] = BaseCmbcAccoutInfo.CS_INTRAT;
		__column_names[16] = BaseCmbcAccoutInfo.CS_OPNDAT;
		__column_names[17] = BaseCmbcAccoutInfo.CS_MUTDAT;
		__column_names[18] = BaseCmbcAccoutInfo.CS_INTTYP;
		__column_names[19] = BaseCmbcAccoutInfo.CS_DPSTXT;
		__column_names[20] = BaseCmbcAccoutInfo.CS_CREATE_TIME;
		__column_names[21] = BaseCmbcAccoutInfo.CS_UPDATE_TIME;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseCmbcAccoutInfo b) {
		clear();
		setCmbcAccoutInfoIdClear(b.getCmbcAccoutInfoId());
	}

	public boolean isPrimaryKeyNull() {
		return getCmbcAccoutInfoId() == null;
	}

	@Override
	public BaseCmbcAccoutInfo generateBase(){
		BaseCmbcAccoutInfo b = new BaseCmbcAccoutInfo();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseCmbcAccoutInfo b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setCmbcAccoutInfoId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setCcynbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCCcynbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccitm(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBbknbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccnbr(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccnam(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setAccblv(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOnlblv(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setHldblv(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setAvlblv(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setLmtovr(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setStscod(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIntcod(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCIntrat(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIntrat(GenericBase.__getDecimal(val));
		if((val = __current_data[count++]) != null) b.setOpndat(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setMutdat(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setInttyp(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDpstxt(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	@Override
	public void setBaseToBuffer(BaseCmbcAccoutInfo b, Object[] buff){
		int count = 0;
		buff[count++] = b.getCmbcAccoutInfoId();
		buff[count++] = b.getCcynbr();
		buff[count++] = b.getCCcynbr();
		buff[count++] = b.getAccitm();
		buff[count++] = b.getBbknbr();
		buff[count++] = b.getAccnbr();
		buff[count++] = b.getAccnam();
		buff[count++] = b.getAccblv();
		buff[count++] = b.getOnlblv();
		buff[count++] = b.getHldblv();
		buff[count++] = b.getAvlblv();
		buff[count++] = b.getLmtovr();
		buff[count++] = b.getStscod();
		buff[count++] = b.getIntcod();
		buff[count++] = b.getCIntrat();
		buff[count++] = b.getIntrat();
		buff[count++] = generateTimestampFromDate(b.getOpndat());
		buff[count++] = generateTimestampFromDate(b.getMutdat());
		buff[count++] = b.getInttyp();
		buff[count++] = b.getDpstxt();
		buff[count++] = generateTimestampFromDate(b.getCreateTime());
		buff[count++] = generateTimestampFromDate(b.getUpdateTime());
	}

	@Override
	public void setDataFromBase(BaseCmbcAccoutInfo b){
		if(b.getCmbcAccoutInfoId() != null) setCmbcAccoutInfoIdClear(b.getCmbcAccoutInfoId());
		if(b.getCcynbr() != null) setCcynbr(b.getCcynbr());
		if(b.getCCcynbr() != null) setCCcynbr(b.getCCcynbr());
		if(b.getAccitm() != null) setAccitm(b.getAccitm());
		if(b.getBbknbr() != null) setBbknbr(b.getBbknbr());
		if(b.getAccnbr() != null) setAccnbr(b.getAccnbr());
		if(b.getAccnam() != null) setAccnam(b.getAccnam());
		if(b.getAccblv() != null) setAccblv(b.getAccblv());
		if(b.getOnlblv() != null) setOnlblv(b.getOnlblv());
		if(b.getHldblv() != null) setHldblv(b.getHldblv());
		if(b.getAvlblv() != null) setAvlblv(b.getAvlblv());
		if(b.getLmtovr() != null) setLmtovr(b.getLmtovr());
		if(b.getStscod() != null) setStscod(b.getStscod());
		if(b.getIntcod() != null) setIntcod(b.getIntcod());
		if(b.getCIntrat() != null) setCIntrat(b.getCIntrat());
		if(b.getIntrat() != null) setIntrat(b.getIntrat());
		if(b.getOpndat() != null) setOpndat(b.getOpndat());
		if(b.getMutdat() != null) setMutdat(b.getMutdat());
		if(b.getInttyp() != null) setInttyp(b.getInttyp());
		if(b.getDpstxt() != null) setDpstxt(b.getDpstxt());
		if(b.getCreateTime() != null) setCreateTime(b.getCreateTime());
		if(b.getUpdateTime() != null) setUpdateTime(b.getUpdateTime());
	}

	@Override
	public BaseCmbcAccoutInfo generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseCmbcAccoutInfo b = new BaseCmbcAccoutInfo();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseCmbcAccoutInfo __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCmbcAccoutInfoId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCcynbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCCcynbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccitm(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBbknbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccnbr(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccnam(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAccblv(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOnlblv(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setHldblv(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setAvlblv(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setLmtovr(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setStscod(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntcod(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCIntrat(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIntrat(GenericBase.__getDecimal(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOpndat(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMutdat(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setInttyp(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDpstxt(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
	}

	public void setCmbcAccoutInfoId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getCmbcAccoutInfoId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setCmbcAccoutInfoIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setCcynbr(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getCcynbr() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setCCcynbr(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getCCcynbr() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setAccitm(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getAccitm() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setBbknbr(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getBbknbr() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setAccnbr(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getAccnbr() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setAccnam(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getAccnam() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setAccblv(java.math.BigDecimal val) {
		setCurrentData(7, val);
	}

	public java.math.BigDecimal getAccblv() {
		return GenericBase.__getDecimal(__current_data[7]);
	}

	public void setOnlblv(java.math.BigDecimal val) {
		setCurrentData(8, val);
	}

	public java.math.BigDecimal getOnlblv() {
		return GenericBase.__getDecimal(__current_data[8]);
	}

	public void setHldblv(java.math.BigDecimal val) {
		setCurrentData(9, val);
	}

	public java.math.BigDecimal getHldblv() {
		return GenericBase.__getDecimal(__current_data[9]);
	}

	public void setAvlblv(java.math.BigDecimal val) {
		setCurrentData(10, val);
	}

	public java.math.BigDecimal getAvlblv() {
		return GenericBase.__getDecimal(__current_data[10]);
	}

	public void setLmtovr(java.math.BigDecimal val) {
		setCurrentData(11, val);
	}

	public java.math.BigDecimal getLmtovr() {
		return GenericBase.__getDecimal(__current_data[11]);
	}

	public void setStscod(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getStscod() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setIntcod(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getIntcod() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setCIntrat(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getCIntrat() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setIntrat(java.math.BigDecimal val) {
		setCurrentData(15, val);
	}

	public java.math.BigDecimal getIntrat() {
		return GenericBase.__getDecimal(__current_data[15]);
	}

	public void setOpndat(java.util.Date val) {
		setCurrentData(16, generateTimestampFromDate(val));
	}

	public java.util.Date getOpndat() {
		return GenericBase.__getDateFromSQL(__current_data[16]);
	}

	public void setMutdat(java.util.Date val) {
		setCurrentData(17, generateTimestampFromDate(val));
	}

	public java.util.Date getMutdat() {
		return GenericBase.__getDateFromSQL(__current_data[17]);
	}

	public void setInttyp(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getInttyp() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setDpstxt(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getDpstxt() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setCreateTime(java.util.Date val) {
		setCurrentData(20, generateTimestampFromDate(val));
	}

	public java.util.Date getCreateTime() {
		return GenericBase.__getDateFromSQL(__current_data[20]);
	}

	public void setUpdateTime(java.util.Date val) {
		setCurrentData(21, generateTimestampFromDate(val));
	}

	public java.util.Date getUpdateTime() {
		return GenericBase.__getDateFromSQL(__current_data[21]);
	}

	public void setConditionCmbcAccoutInfoId(String op, java.lang.Integer val) {
		setConditionCmbcAccoutInfoId(op, val, CONDITION_AND);
	}

	public void setConditionCmbcAccoutInfoId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectCmbcAccoutInfoId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionCcynbr(String op, java.lang.String val) {
		setConditionCcynbr(op, val, CONDITION_AND);
	}

	public void setConditionCcynbr(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectCcynbr(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionCCcynbr(String op, java.lang.String val) {
		setConditionCCcynbr(op, val, CONDITION_AND);
	}

	public void setConditionCCcynbr(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectCCcynbr(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionAccitm(String op, java.lang.String val) {
		setConditionAccitm(op, val, CONDITION_AND);
	}

	public void setConditionAccitm(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectAccitm(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionBbknbr(String op, java.lang.String val) {
		setConditionBbknbr(op, val, CONDITION_AND);
	}

	public void setConditionBbknbr(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectBbknbr(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionAccnbr(String op, java.lang.String val) {
		setConditionAccnbr(op, val, CONDITION_AND);
	}

	public void setConditionAccnbr(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectAccnbr(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionAccnam(String op, java.lang.String val) {
		setConditionAccnam(op, val, CONDITION_AND);
	}

	public void setConditionAccnam(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectAccnam(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionAccblv(String op, java.math.BigDecimal val) {
		setConditionAccblv(op, val, CONDITION_AND);
	}

	public void setConditionAccblv(String op, java.math.BigDecimal val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectAccblv(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionOnlblv(String op, java.math.BigDecimal val) {
		setConditionOnlblv(op, val, CONDITION_AND);
	}

	public void setConditionOnlblv(String op, java.math.BigDecimal val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectOnlblv(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionHldblv(String op, java.math.BigDecimal val) {
		setConditionHldblv(op, val, CONDITION_AND);
	}

	public void setConditionHldblv(String op, java.math.BigDecimal val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectHldblv(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionAvlblv(String op, java.math.BigDecimal val) {
		setConditionAvlblv(op, val, CONDITION_AND);
	}

	public void setConditionAvlblv(String op, java.math.BigDecimal val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectAvlblv(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionLmtovr(String op, java.math.BigDecimal val) {
		setConditionLmtovr(op, val, CONDITION_AND);
	}

	public void setConditionLmtovr(String op, java.math.BigDecimal val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectLmtovr(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionStscod(String op, java.lang.String val) {
		setConditionStscod(op, val, CONDITION_AND);
	}

	public void setConditionStscod(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectStscod(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionIntcod(String op, java.lang.String val) {
		setConditionIntcod(op, val, CONDITION_AND);
	}

	public void setConditionIntcod(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectIntcod(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionCIntrat(String op, java.lang.String val) {
		setConditionCIntrat(op, val, CONDITION_AND);
	}

	public void setConditionCIntrat(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectCIntrat(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionIntrat(String op, java.math.BigDecimal val) {
		setConditionIntrat(op, val, CONDITION_AND);
	}

	public void setConditionIntrat(String op, java.math.BigDecimal val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectIntrat(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionOpndat(String op, java.util.Date val) {
		setConditionOpndat(op, val, CONDITION_AND);
	}

	public void setConditionOpndat(String op, java.util.Date val, String relation) {
		addCondition(16, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOpndat(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionMutdat(String op, java.util.Date val) {
		setConditionMutdat(op, val, CONDITION_AND);
	}

	public void setConditionMutdat(String op, java.util.Date val, String relation) {
		addCondition(17, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectMutdat(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionInttyp(String op, java.lang.String val) {
		setConditionInttyp(op, val, CONDITION_AND);
	}

	public void setConditionInttyp(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectInttyp(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionDpstxt(String op, java.lang.String val) {
		setConditionDpstxt(op, val, CONDITION_AND);
	}

	public void setConditionDpstxt(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectDpstxt(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionCreateTime(String op, java.util.Date val) {
		setConditionCreateTime(op, val, CONDITION_AND);
	}

	public void setConditionCreateTime(String op, java.util.Date val, String relation) {
		addCondition(20, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectCreateTime(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionUpdateTime(String op, java.util.Date val) {
		setConditionUpdateTime(op, val, CONDITION_AND);
	}

	public void setConditionUpdateTime(String op, java.util.Date val, String relation) {
		addCondition(21, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectUpdateTime(boolean val) {
		__select_flags[21] = val;
	}


}

