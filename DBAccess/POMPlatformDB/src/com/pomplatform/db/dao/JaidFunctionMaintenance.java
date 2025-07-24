package com.pomplatform.db.dao;

import com.pomplatform.db.bean.BaseJaidFunctionMaintenance;

import delicacy.common.AbstractTable;
import delicacy.common.GenericBase;


public class JaidFunctionMaintenance extends AbstractTable<BaseJaidFunctionMaintenance>
{

	public JaidFunctionMaintenance() throws java.sql.SQLException 
	{

		initColumnNames();
	}

	protected final void initColumnNames()  throws java.sql.SQLException {

		__columnCount          = 32;

		initTables();

		__tableName            = "jaid_function_maintenances";

		__key_columns          = new int[1];
		__key_columns[0] = 0;

		__column_names[0] = BaseJaidFunctionMaintenance.CS_JAID_FUNCTION_MAINTENANCE_ID;
		__column_names[1] = BaseJaidFunctionMaintenance.CS_NAME_ZH;
		__column_names[2] = BaseJaidFunctionMaintenance.CS_NAME_EN;
		__column_names[3] = BaseJaidFunctionMaintenance.CS_PROJECT_ADDRESS_ZH;
		__column_names[4] = BaseJaidFunctionMaintenance.CS_PROJECT_ADDRESS_EN;
		__column_names[5] = BaseJaidFunctionMaintenance.CS_DESIGN_TIME_ZH;
		__column_names[6] = BaseJaidFunctionMaintenance.CS_DESIGN_TIME_EN;
		__column_names[7] = BaseJaidFunctionMaintenance.CS_FINISH_TIME_ZH;
		__column_names[8] = BaseJaidFunctionMaintenance.CS_FINISH_TIME_EN;
		__column_names[9] = BaseJaidFunctionMaintenance.CS_PROJECT_AREA;
		__column_names[10] = BaseJaidFunctionMaintenance.CS_MAIN_THEME_ZH;
		__column_names[11] = BaseJaidFunctionMaintenance.CS_MAIN_THEME_EN;
		__column_names[12] = BaseJaidFunctionMaintenance.CS_MAIN_PICTURE;
		__column_names[13] = BaseJaidFunctionMaintenance.CS_TURN_PICTURE_ONE;
		__column_names[14] = BaseJaidFunctionMaintenance.CS_TURN_PICTURE_TWO;
		__column_names[15] = BaseJaidFunctionMaintenance.CS_TURN_PICTURE_THREE;
		__column_names[16] = BaseJaidFunctionMaintenance.CS_TURN_PICTURE_FOUR;
		__column_names[17] = BaseJaidFunctionMaintenance.CS_TURN_PICTURE_FIVE;
		__column_names[18] = BaseJaidFunctionMaintenance.CS_TURN_PICTURE_SIX;
		__column_names[19] = BaseJaidFunctionMaintenance.CS_DESCRIPTION_ZH;
		__column_names[20] = BaseJaidFunctionMaintenance.CS_DESCRIPTION_EN;
		__column_names[21] = BaseJaidFunctionMaintenance.CS_BRIEF_ZH;
		__column_names[22] = BaseJaidFunctionMaintenance.CS_BRIEF_EN;
		__column_names[23] = BaseJaidFunctionMaintenance.CS_IS_AUDITED;
		__column_names[24] = BaseJaidFunctionMaintenance.CS_CLICK_NUM;
		__column_names[25] = BaseJaidFunctionMaintenance.CS_ORDER_ID;
		__column_names[26] = BaseJaidFunctionMaintenance.CS_PUBLISH_TIME;
		__column_names[27] = BaseJaidFunctionMaintenance.CS_TYPE;
		__column_names[28] = BaseJaidFunctionMaintenance.CS_TYPE_DETAIL;
		__column_names[29] = BaseJaidFunctionMaintenance.CS_OPERATE_EMPLOYEE_ID;
		__column_names[30] = BaseJaidFunctionMaintenance.CS_OPERATE_TIME;
		__column_names[31] = BaseJaidFunctionMaintenance.CS_REMARK;

		resetSelectFlags() ;
		resetInsertFlags() ;
	}

	public void resetInsertFlags(){
		for(int i = 0; i < __columnCount; i ++ ) __insert_flags[i] = true;
		__insert_flags[0] = false;
		__serial_column = 0;
	}

	public void setPrimaryKeyFromBase(BaseJaidFunctionMaintenance b) {
		clear();
		setJaidFunctionMaintenanceIdClear(b.getJaidFunctionMaintenanceId());
	}

	public boolean isPrimaryKeyNull() {
		return getJaidFunctionMaintenanceId() == null;
	}

	@Override
	public BaseJaidFunctionMaintenance generateBase(){
		BaseJaidFunctionMaintenance b = new BaseJaidFunctionMaintenance();
		setDataToBase(b);
		return b;
	}

	@Override
	public void setDataToBase(BaseJaidFunctionMaintenance b){
		int count = 0; Object val;
		if((val = __current_data[count++]) != null) b.setJaidFunctionMaintenanceId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setNameZh(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setNameEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectAddressZh(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectAddressEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignTimeZh(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDesignTimeEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFinishTimeZh(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setFinishTimeEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setProjectArea(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainThemeZh(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainThemeEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setMainPicture(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTurnPictureOne(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTurnPictureTwo(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTurnPictureThree(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTurnPictureFour(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTurnPictureFive(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setTurnPictureSix(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDescriptionZh(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setDescriptionEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBriefZh(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setBriefEn(GenericBase.__getString(val));
		if((val = __current_data[count++]) != null) b.setIsAudited(GenericBase.__getBoolean(val));
		if((val = __current_data[count++]) != null) b.setClickNum(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOrderId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setPublishTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setType(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setTypeDetail(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __current_data[count++]) != null) b.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __current_data[count++]) != null) b.setRemark(GenericBase.__getString(val));
	}

	@Override
	public void setBaseToBuffer(BaseJaidFunctionMaintenance b, Object[] buff){
		int count = 0;
		buff[count++] = b.getJaidFunctionMaintenanceId();
		buff[count++] = b.getNameZh();
		buff[count++] = b.getNameEn();
		buff[count++] = b.getProjectAddressZh();
		buff[count++] = b.getProjectAddressEn();
		buff[count++] = b.getDesignTimeZh();
		buff[count++] = b.getDesignTimeEn();
		buff[count++] = b.getFinishTimeZh();
		buff[count++] = b.getFinishTimeEn();
		buff[count++] = b.getProjectArea();
		buff[count++] = b.getMainThemeZh();
		buff[count++] = b.getMainThemeEn();
		buff[count++] = b.getMainPicture();
		buff[count++] = b.getTurnPictureOne();
		buff[count++] = b.getTurnPictureTwo();
		buff[count++] = b.getTurnPictureThree();
		buff[count++] = b.getTurnPictureFour();
		buff[count++] = b.getTurnPictureFive();
		buff[count++] = b.getTurnPictureSix();
		buff[count++] = b.getDescriptionZh();
		buff[count++] = b.getDescriptionEn();
		buff[count++] = b.getBriefZh();
		buff[count++] = b.getBriefEn();
		buff[count++] = b.getIsAudited();
		buff[count++] = b.getClickNum();
		buff[count++] = b.getOrderId();
		buff[count++] = generateTimestampFromDate(b.getPublishTime());
		buff[count++] = b.getType();
		buff[count++] = b.getTypeDetail();
		buff[count++] = b.getOperateEmployeeId();
		buff[count++] = generateTimestampFromDate(b.getOperateTime());
		buff[count++] = b.getRemark();
	}

	@Override
	public void setDataFromBase(BaseJaidFunctionMaintenance b){
		if(b.getJaidFunctionMaintenanceId() != null) setJaidFunctionMaintenanceIdClear(b.getJaidFunctionMaintenanceId());
		if(b.getNameZh() != null) setNameZh(b.getNameZh());
		if(b.getNameEn() != null) setNameEn(b.getNameEn());
		if(b.getProjectAddressZh() != null) setProjectAddressZh(b.getProjectAddressZh());
		if(b.getProjectAddressEn() != null) setProjectAddressEn(b.getProjectAddressEn());
		if(b.getDesignTimeZh() != null) setDesignTimeZh(b.getDesignTimeZh());
		if(b.getDesignTimeEn() != null) setDesignTimeEn(b.getDesignTimeEn());
		if(b.getFinishTimeZh() != null) setFinishTimeZh(b.getFinishTimeZh());
		if(b.getFinishTimeEn() != null) setFinishTimeEn(b.getFinishTimeEn());
		if(b.getProjectArea() != null) setProjectArea(b.getProjectArea());
		if(b.getMainThemeZh() != null) setMainThemeZh(b.getMainThemeZh());
		if(b.getMainThemeEn() != null) setMainThemeEn(b.getMainThemeEn());
		if(b.getMainPicture() != null) setMainPicture(b.getMainPicture());
		if(b.getTurnPictureOne() != null) setTurnPictureOne(b.getTurnPictureOne());
		if(b.getTurnPictureTwo() != null) setTurnPictureTwo(b.getTurnPictureTwo());
		if(b.getTurnPictureThree() != null) setTurnPictureThree(b.getTurnPictureThree());
		if(b.getTurnPictureFour() != null) setTurnPictureFour(b.getTurnPictureFour());
		if(b.getTurnPictureFive() != null) setTurnPictureFive(b.getTurnPictureFive());
		if(b.getTurnPictureSix() != null) setTurnPictureSix(b.getTurnPictureSix());
		if(b.getDescriptionZh() != null) setDescriptionZh(b.getDescriptionZh());
		if(b.getDescriptionEn() != null) setDescriptionEn(b.getDescriptionEn());
		if(b.getBriefZh() != null) setBriefZh(b.getBriefZh());
		if(b.getBriefEn() != null) setBriefEn(b.getBriefEn());
		if(b.getIsAudited() != null) setIsAudited(b.getIsAudited());
		if(b.getClickNum() != null) setClickNum(b.getClickNum());
		if(b.getOrderId() != null) setOrderId(b.getOrderId());
		if(b.getPublishTime() != null) setPublishTime(b.getPublishTime());
		if(b.getType() != null) setType(b.getType());
		if(b.getTypeDetail() != null) setTypeDetail(b.getTypeDetail());
		if(b.getOperateEmployeeId() != null) setOperateEmployeeId(b.getOperateEmployeeId());
		if(b.getOperateTime() != null) setOperateTime(b.getOperateTime());
		if(b.getRemark() != null) setRemark(b.getRemark());
	}

	@Override
	public BaseJaidFunctionMaintenance generateBaseFromResultSet(java.sql.ResultSet sdr)  throws java.sql.SQLException {

		BaseJaidFunctionMaintenance b = new BaseJaidFunctionMaintenance();
		setQueryResultToBase(b, sdr);
		return b;
	}

	@Override
	public void setQueryResultToBase(BaseJaidFunctionMaintenance __base, java.sql.ResultSet sdr ) throws java.sql.SQLException {
		int count = 1, index = 0;
		java.sql.ResultSetMetaData rsmd = sdr.getMetaData();
		int columnCount = rsmd.getColumnCount();
		Object val;
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setJaidFunctionMaintenanceId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNameZh(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setNameEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAddressZh(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectAddressEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignTimeZh(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDesignTimeEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishTimeZh(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setFinishTimeEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setProjectArea(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainThemeZh(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainThemeEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setMainPicture(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTurnPictureOne(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTurnPictureTwo(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTurnPictureThree(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTurnPictureFour(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTurnPictureFive(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTurnPictureSix(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDescriptionZh(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setDescriptionEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBriefZh(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setBriefEn(GenericBase.__getString(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setIsAudited(GenericBase.__getBoolean(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setClickNum(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOrderId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setPublishTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setType(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setTypeDetail(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if(__select_flags[index++] && count <= columnCount && (val = sdr.getObject(count++)) != null) __base.setRemark(GenericBase.__getString(val));
	}

	public void setJaidFunctionMaintenanceId(java.lang.Integer val) {
		setCurrentData(0, val);
	}

	public java.lang.Integer getJaidFunctionMaintenanceId() {
		return GenericBase.__getInt(__current_data[0]);
	}

	public void setJaidFunctionMaintenanceIdClear(java.lang.Integer val) {
		__backup_data[0] = __current_data[0] =  val;
		__modified_flags[0] = false;
	}

	public void setNameZh(java.lang.String val) {
		setCurrentData(1, val);
	}

	public java.lang.String getNameZh() {
		return GenericBase.__getString(__current_data[1]);
	}

	public void setNameEn(java.lang.String val) {
		setCurrentData(2, val);
	}

	public java.lang.String getNameEn() {
		return GenericBase.__getString(__current_data[2]);
	}

	public void setProjectAddressZh(java.lang.String val) {
		setCurrentData(3, val);
	}

	public java.lang.String getProjectAddressZh() {
		return GenericBase.__getString(__current_data[3]);
	}

	public void setProjectAddressEn(java.lang.String val) {
		setCurrentData(4, val);
	}

	public java.lang.String getProjectAddressEn() {
		return GenericBase.__getString(__current_data[4]);
	}

	public void setDesignTimeZh(java.lang.String val) {
		setCurrentData(5, val);
	}

	public java.lang.String getDesignTimeZh() {
		return GenericBase.__getString(__current_data[5]);
	}

	public void setDesignTimeEn(java.lang.String val) {
		setCurrentData(6, val);
	}

	public java.lang.String getDesignTimeEn() {
		return GenericBase.__getString(__current_data[6]);
	}

	public void setFinishTimeZh(java.lang.String val) {
		setCurrentData(7, val);
	}

	public java.lang.String getFinishTimeZh() {
		return GenericBase.__getString(__current_data[7]);
	}

	public void setFinishTimeEn(java.lang.String val) {
		setCurrentData(8, val);
	}

	public java.lang.String getFinishTimeEn() {
		return GenericBase.__getString(__current_data[8]);
	}

	public void setProjectArea(java.lang.String val) {
		setCurrentData(9, val);
	}

	public java.lang.String getProjectArea() {
		return GenericBase.__getString(__current_data[9]);
	}

	public void setMainThemeZh(java.lang.String val) {
		setCurrentData(10, val);
	}

	public java.lang.String getMainThemeZh() {
		return GenericBase.__getString(__current_data[10]);
	}

	public void setMainThemeEn(java.lang.String val) {
		setCurrentData(11, val);
	}

	public java.lang.String getMainThemeEn() {
		return GenericBase.__getString(__current_data[11]);
	}

	public void setMainPicture(java.lang.String val) {
		setCurrentData(12, val);
	}

	public java.lang.String getMainPicture() {
		return GenericBase.__getString(__current_data[12]);
	}

	public void setTurnPictureOne(java.lang.String val) {
		setCurrentData(13, val);
	}

	public java.lang.String getTurnPictureOne() {
		return GenericBase.__getString(__current_data[13]);
	}

	public void setTurnPictureTwo(java.lang.String val) {
		setCurrentData(14, val);
	}

	public java.lang.String getTurnPictureTwo() {
		return GenericBase.__getString(__current_data[14]);
	}

	public void setTurnPictureThree(java.lang.String val) {
		setCurrentData(15, val);
	}

	public java.lang.String getTurnPictureThree() {
		return GenericBase.__getString(__current_data[15]);
	}

	public void setTurnPictureFour(java.lang.String val) {
		setCurrentData(16, val);
	}

	public java.lang.String getTurnPictureFour() {
		return GenericBase.__getString(__current_data[16]);
	}

	public void setTurnPictureFive(java.lang.String val) {
		setCurrentData(17, val);
	}

	public java.lang.String getTurnPictureFive() {
		return GenericBase.__getString(__current_data[17]);
	}

	public void setTurnPictureSix(java.lang.String val) {
		setCurrentData(18, val);
	}

	public java.lang.String getTurnPictureSix() {
		return GenericBase.__getString(__current_data[18]);
	}

	public void setDescriptionZh(java.lang.String val) {
		setCurrentData(19, val);
	}

	public java.lang.String getDescriptionZh() {
		return GenericBase.__getString(__current_data[19]);
	}

	public void setDescriptionEn(java.lang.String val) {
		setCurrentData(20, val);
	}

	public java.lang.String getDescriptionEn() {
		return GenericBase.__getString(__current_data[20]);
	}

	public void setBriefZh(java.lang.String val) {
		setCurrentData(21, val);
	}

	public java.lang.String getBriefZh() {
		return GenericBase.__getString(__current_data[21]);
	}

	public void setBriefEn(java.lang.String val) {
		setCurrentData(22, val);
	}

	public java.lang.String getBriefEn() {
		return GenericBase.__getString(__current_data[22]);
	}

	public void setIsAudited(java.lang.Boolean val) {
		setCurrentData(23, val);
	}

	public java.lang.Boolean getIsAudited() {
		return GenericBase.__getBoolean(__current_data[23]);
	}

	public void setClickNum(java.lang.Integer val) {
		setCurrentData(24, val);
	}

	public java.lang.Integer getClickNum() {
		return GenericBase.__getInt(__current_data[24]);
	}

	public void setOrderId(java.lang.Integer val) {
		setCurrentData(25, val);
	}

	public java.lang.Integer getOrderId() {
		return GenericBase.__getInt(__current_data[25]);
	}

	public void setPublishTime(java.util.Date val) {
		setCurrentData(26, generateTimestampFromDate(val));
	}

	public java.util.Date getPublishTime() {
		return GenericBase.__getDateFromSQL(__current_data[26]);
	}

	public void setType(java.lang.Integer val) {
		setCurrentData(27, val);
	}

	public java.lang.Integer getType() {
		return GenericBase.__getInt(__current_data[27]);
	}

	public void setTypeDetail(java.lang.Integer val) {
		setCurrentData(28, val);
	}

	public java.lang.Integer getTypeDetail() {
		return GenericBase.__getInt(__current_data[28]);
	}

	public void setOperateEmployeeId(java.lang.Integer val) {
		setCurrentData(29, val);
	}

	public java.lang.Integer getOperateEmployeeId() {
		return GenericBase.__getInt(__current_data[29]);
	}

	public void setOperateTime(java.util.Date val) {
		setCurrentData(30, generateTimestampFromDate(val));
	}

	public java.util.Date getOperateTime() {
		return GenericBase.__getDateFromSQL(__current_data[30]);
	}

	public void setRemark(java.lang.String val) {
		setCurrentData(31, val);
	}

	public java.lang.String getRemark() {
		return GenericBase.__getString(__current_data[31]);
	}

	public void setConditionJaidFunctionMaintenanceId(String op, java.lang.Integer val) {
		setConditionJaidFunctionMaintenanceId(op, val, CONDITION_AND);
	}

	public void setConditionJaidFunctionMaintenanceId(String op, java.lang.Integer val, String relation) {
		addCondition(0, op, relation, val);
	}

	public void setSelectJaidFunctionMaintenanceId(boolean val) {
		__select_flags[0] = val;
	}

	public void setConditionNameZh(String op, java.lang.String val) {
		setConditionNameZh(op, val, CONDITION_AND);
	}

	public void setConditionNameZh(String op, java.lang.String val, String relation) {
		addCondition(1, op, relation, val);
	}

	public void setSelectNameZh(boolean val) {
		__select_flags[1] = val;
	}

	public void setConditionNameEn(String op, java.lang.String val) {
		setConditionNameEn(op, val, CONDITION_AND);
	}

	public void setConditionNameEn(String op, java.lang.String val, String relation) {
		addCondition(2, op, relation, val);
	}

	public void setSelectNameEn(boolean val) {
		__select_flags[2] = val;
	}

	public void setConditionProjectAddressZh(String op, java.lang.String val) {
		setConditionProjectAddressZh(op, val, CONDITION_AND);
	}

	public void setConditionProjectAddressZh(String op, java.lang.String val, String relation) {
		addCondition(3, op, relation, val);
	}

	public void setSelectProjectAddressZh(boolean val) {
		__select_flags[3] = val;
	}

	public void setConditionProjectAddressEn(String op, java.lang.String val) {
		setConditionProjectAddressEn(op, val, CONDITION_AND);
	}

	public void setConditionProjectAddressEn(String op, java.lang.String val, String relation) {
		addCondition(4, op, relation, val);
	}

	public void setSelectProjectAddressEn(boolean val) {
		__select_flags[4] = val;
	}

	public void setConditionDesignTimeZh(String op, java.lang.String val) {
		setConditionDesignTimeZh(op, val, CONDITION_AND);
	}

	public void setConditionDesignTimeZh(String op, java.lang.String val, String relation) {
		addCondition(5, op, relation, val);
	}

	public void setSelectDesignTimeZh(boolean val) {
		__select_flags[5] = val;
	}

	public void setConditionDesignTimeEn(String op, java.lang.String val) {
		setConditionDesignTimeEn(op, val, CONDITION_AND);
	}

	public void setConditionDesignTimeEn(String op, java.lang.String val, String relation) {
		addCondition(6, op, relation, val);
	}

	public void setSelectDesignTimeEn(boolean val) {
		__select_flags[6] = val;
	}

	public void setConditionFinishTimeZh(String op, java.lang.String val) {
		setConditionFinishTimeZh(op, val, CONDITION_AND);
	}

	public void setConditionFinishTimeZh(String op, java.lang.String val, String relation) {
		addCondition(7, op, relation, val);
	}

	public void setSelectFinishTimeZh(boolean val) {
		__select_flags[7] = val;
	}

	public void setConditionFinishTimeEn(String op, java.lang.String val) {
		setConditionFinishTimeEn(op, val, CONDITION_AND);
	}

	public void setConditionFinishTimeEn(String op, java.lang.String val, String relation) {
		addCondition(8, op, relation, val);
	}

	public void setSelectFinishTimeEn(boolean val) {
		__select_flags[8] = val;
	}

	public void setConditionProjectArea(String op, java.lang.String val) {
		setConditionProjectArea(op, val, CONDITION_AND);
	}

	public void setConditionProjectArea(String op, java.lang.String val, String relation) {
		addCondition(9, op, relation, val);
	}

	public void setSelectProjectArea(boolean val) {
		__select_flags[9] = val;
	}

	public void setConditionMainThemeZh(String op, java.lang.String val) {
		setConditionMainThemeZh(op, val, CONDITION_AND);
	}

	public void setConditionMainThemeZh(String op, java.lang.String val, String relation) {
		addCondition(10, op, relation, val);
	}

	public void setSelectMainThemeZh(boolean val) {
		__select_flags[10] = val;
	}

	public void setConditionMainThemeEn(String op, java.lang.String val) {
		setConditionMainThemeEn(op, val, CONDITION_AND);
	}

	public void setConditionMainThemeEn(String op, java.lang.String val, String relation) {
		addCondition(11, op, relation, val);
	}

	public void setSelectMainThemeEn(boolean val) {
		__select_flags[11] = val;
	}

	public void setConditionMainPicture(String op, java.lang.String val) {
		setConditionMainPicture(op, val, CONDITION_AND);
	}

	public void setConditionMainPicture(String op, java.lang.String val, String relation) {
		addCondition(12, op, relation, val);
	}

	public void setSelectMainPicture(boolean val) {
		__select_flags[12] = val;
	}

	public void setConditionTurnPictureOne(String op, java.lang.String val) {
		setConditionTurnPictureOne(op, val, CONDITION_AND);
	}

	public void setConditionTurnPictureOne(String op, java.lang.String val, String relation) {
		addCondition(13, op, relation, val);
	}

	public void setSelectTurnPictureOne(boolean val) {
		__select_flags[13] = val;
	}

	public void setConditionTurnPictureTwo(String op, java.lang.String val) {
		setConditionTurnPictureTwo(op, val, CONDITION_AND);
	}

	public void setConditionTurnPictureTwo(String op, java.lang.String val, String relation) {
		addCondition(14, op, relation, val);
	}

	public void setSelectTurnPictureTwo(boolean val) {
		__select_flags[14] = val;
	}

	public void setConditionTurnPictureThree(String op, java.lang.String val) {
		setConditionTurnPictureThree(op, val, CONDITION_AND);
	}

	public void setConditionTurnPictureThree(String op, java.lang.String val, String relation) {
		addCondition(15, op, relation, val);
	}

	public void setSelectTurnPictureThree(boolean val) {
		__select_flags[15] = val;
	}

	public void setConditionTurnPictureFour(String op, java.lang.String val) {
		setConditionTurnPictureFour(op, val, CONDITION_AND);
	}

	public void setConditionTurnPictureFour(String op, java.lang.String val, String relation) {
		addCondition(16, op, relation, val);
	}

	public void setSelectTurnPictureFour(boolean val) {
		__select_flags[16] = val;
	}

	public void setConditionTurnPictureFive(String op, java.lang.String val) {
		setConditionTurnPictureFive(op, val, CONDITION_AND);
	}

	public void setConditionTurnPictureFive(String op, java.lang.String val, String relation) {
		addCondition(17, op, relation, val);
	}

	public void setSelectTurnPictureFive(boolean val) {
		__select_flags[17] = val;
	}

	public void setConditionTurnPictureSix(String op, java.lang.String val) {
		setConditionTurnPictureSix(op, val, CONDITION_AND);
	}

	public void setConditionTurnPictureSix(String op, java.lang.String val, String relation) {
		addCondition(18, op, relation, val);
	}

	public void setSelectTurnPictureSix(boolean val) {
		__select_flags[18] = val;
	}

	public void setConditionDescriptionZh(String op, java.lang.String val) {
		setConditionDescriptionZh(op, val, CONDITION_AND);
	}

	public void setConditionDescriptionZh(String op, java.lang.String val, String relation) {
		addCondition(19, op, relation, val);
	}

	public void setSelectDescriptionZh(boolean val) {
		__select_flags[19] = val;
	}

	public void setConditionDescriptionEn(String op, java.lang.String val) {
		setConditionDescriptionEn(op, val, CONDITION_AND);
	}

	public void setConditionDescriptionEn(String op, java.lang.String val, String relation) {
		addCondition(20, op, relation, val);
	}

	public void setSelectDescriptionEn(boolean val) {
		__select_flags[20] = val;
	}

	public void setConditionBriefZh(String op, java.lang.String val) {
		setConditionBriefZh(op, val, CONDITION_AND);
	}

	public void setConditionBriefZh(String op, java.lang.String val, String relation) {
		addCondition(21, op, relation, val);
	}

	public void setSelectBriefZh(boolean val) {
		__select_flags[21] = val;
	}

	public void setConditionBriefEn(String op, java.lang.String val) {
		setConditionBriefEn(op, val, CONDITION_AND);
	}

	public void setConditionBriefEn(String op, java.lang.String val, String relation) {
		addCondition(22, op, relation, val);
	}

	public void setSelectBriefEn(boolean val) {
		__select_flags[22] = val;
	}

	public void setConditionIsAudited(String op, java.lang.Boolean val) {
		setConditionIsAudited(op, val, CONDITION_AND);
	}

	public void setConditionIsAudited(String op, java.lang.Boolean val, String relation) {
		addCondition(23, op, relation, val);
	}

	public void setSelectIsAudited(boolean val) {
		__select_flags[23] = val;
	}

	public void setConditionClickNum(String op, java.lang.Integer val) {
		setConditionClickNum(op, val, CONDITION_AND);
	}

	public void setConditionClickNum(String op, java.lang.Integer val, String relation) {
		addCondition(24, op, relation, val);
	}

	public void setSelectClickNum(boolean val) {
		__select_flags[24] = val;
	}

	public void setConditionOrderId(String op, java.lang.Integer val) {
		setConditionOrderId(op, val, CONDITION_AND);
	}

	public void setConditionOrderId(String op, java.lang.Integer val, String relation) {
		addCondition(25, op, relation, val);
	}

	public void setSelectOrderId(boolean val) {
		__select_flags[25] = val;
	}

	public void setConditionPublishTime(String op, java.util.Date val) {
		setConditionPublishTime(op, val, CONDITION_AND);
	}

	public void setConditionPublishTime(String op, java.util.Date val, String relation) {
		addCondition(26, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectPublishTime(boolean val) {
		__select_flags[26] = val;
	}

	public void setConditionType(String op, java.lang.Integer val) {
		setConditionType(op, val, CONDITION_AND);
	}

	public void setConditionType(String op, java.lang.Integer val, String relation) {
		addCondition(27, op, relation, val);
	}

	public void setSelectType(boolean val) {
		__select_flags[27] = val;
	}

	public void setConditionTypeDetail(String op, java.lang.Integer val) {
		setConditionTypeDetail(op, val, CONDITION_AND);
	}

	public void setConditionTypeDetail(String op, java.lang.Integer val, String relation) {
		addCondition(28, op, relation, val);
	}

	public void setSelectTypeDetail(boolean val) {
		__select_flags[28] = val;
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val) {
		setConditionOperateEmployeeId(op, val, CONDITION_AND);
	}

	public void setConditionOperateEmployeeId(String op, java.lang.Integer val, String relation) {
		addCondition(29, op, relation, val);
	}

	public void setSelectOperateEmployeeId(boolean val) {
		__select_flags[29] = val;
	}

	public void setConditionOperateTime(String op, java.util.Date val) {
		setConditionOperateTime(op, val, CONDITION_AND);
	}

	public void setConditionOperateTime(String op, java.util.Date val, String relation) {
		addCondition(30, op, relation, generateTimestampFromDate(val));
	}

	public void setSelectOperateTime(boolean val) {
		__select_flags[30] = val;
	}

	public void setConditionRemark(String op, java.lang.String val) {
		setConditionRemark(op, val, CONDITION_AND);
	}

	public void setConditionRemark(String op, java.lang.String val, String relation) {
		addCondition(31, op, relation, val);
	}

	public void setSelectRemark(boolean val) {
		__select_flags[31] = val;
	}


}

