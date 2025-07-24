package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseJaidFunctionMaintenance extends GenericBase implements BaseFactory<BaseJaidFunctionMaintenance>, Comparable<BaseJaidFunctionMaintenance> 
{


	public static BaseJaidFunctionMaintenance newInstance(){
		return new BaseJaidFunctionMaintenance();
	}

	@Override
	public BaseJaidFunctionMaintenance make(){
		BaseJaidFunctionMaintenance b = new BaseJaidFunctionMaintenance();
		return b;
	}

	public final static java.lang.String CS_JAID_FUNCTION_MAINTENANCE_ID = "jaid_function_maintenance_id" ;
	public final static java.lang.String CS_NAME_ZH = "name_zh" ;
	public final static java.lang.String CS_NAME_EN = "name_en" ;
	public final static java.lang.String CS_PROJECT_ADDRESS_ZH = "project_address_zh" ;
	public final static java.lang.String CS_PROJECT_ADDRESS_EN = "project_address_en" ;
	public final static java.lang.String CS_DESIGN_TIME_ZH = "design_time_zh" ;
	public final static java.lang.String CS_DESIGN_TIME_EN = "design_time_en" ;
	public final static java.lang.String CS_FINISH_TIME_ZH = "finish_time_zh" ;
	public final static java.lang.String CS_FINISH_TIME_EN = "finish_time_en" ;
	public final static java.lang.String CS_PROJECT_AREA = "project_area" ;
	public final static java.lang.String CS_MAIN_THEME_ZH = "main_theme_zh" ;
	public final static java.lang.String CS_MAIN_THEME_EN = "main_theme_en" ;
	public final static java.lang.String CS_MAIN_PICTURE = "main_picture" ;
	public final static java.lang.String CS_TURN_PICTURE_ONE = "turn_picture_one" ;
	public final static java.lang.String CS_TURN_PICTURE_TWO = "turn_picture_two" ;
	public final static java.lang.String CS_TURN_PICTURE_THREE = "turn_picture_three" ;
	public final static java.lang.String CS_TURN_PICTURE_FOUR = "turn_picture_four" ;
	public final static java.lang.String CS_TURN_PICTURE_FIVE = "turn_picture_five" ;
	public final static java.lang.String CS_TURN_PICTURE_SIX = "turn_picture_six" ;
	public final static java.lang.String CS_DESCRIPTION_ZH = "description_zh" ;
	public final static java.lang.String CS_DESCRIPTION_EN = "description_en" ;
	public final static java.lang.String CS_BRIEF_ZH = "brief_zh" ;
	public final static java.lang.String CS_BRIEF_EN = "brief_en" ;
	public final static java.lang.String CS_IS_AUDITED = "is_audited" ;
	public final static java.lang.String CS_CLICK_NUM = "click_num" ;
	public final static java.lang.String CS_ORDER_ID = "order_id" ;
	public final static java.lang.String CS_PUBLISH_TIME = "publish_time" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_TYPE_DETAIL = "type_detail" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,名称(中文),名称(英文),项目地点(中文),项目地点(英文),设计时间(中文),设计时间(英文),竣工时间(中文),竣工时间(英文),项目面积(规模),主要题材(中文),主要题材(英文),主图片地址,轮播图片1地址,轮播图片2地址,轮播图片3地址,轮播图片4地址,轮播图片5地址,轮播图片6地址,详情(中文),详情(英文),简介(中文),简介(英文),是否审核,点击数,排序Id,发布时间,),2出版作品)),操作人,操作时间,备注";

	public java.lang.Integer getJaidFunctionMaintenanceId() {
		return this.__jaid_function_maintenance_id;
	}

	public void setJaidFunctionMaintenanceId( java.lang.Integer value ) {
		this.__jaid_function_maintenance_id = value;
	}

	public java.lang.String getNameZh() {
		return this.__name_zh;
	}

	public void setNameZh( java.lang.String value ) {
		this.__name_zh = value;
	}

	public java.lang.String getNameEn() {
		return this.__name_en;
	}

	public void setNameEn( java.lang.String value ) {
		this.__name_en = value;
	}

	public java.lang.String getProjectAddressZh() {
		return this.__project_address_zh;
	}

	public void setProjectAddressZh( java.lang.String value ) {
		this.__project_address_zh = value;
	}

	public java.lang.String getProjectAddressEn() {
		return this.__project_address_en;
	}

	public void setProjectAddressEn( java.lang.String value ) {
		this.__project_address_en = value;
	}

	public java.lang.String getDesignTimeZh() {
		return this.__design_time_zh;
	}

	public void setDesignTimeZh( java.lang.String value ) {
		this.__design_time_zh = value;
	}

	public java.lang.String getDesignTimeEn() {
		return this.__design_time_en;
	}

	public void setDesignTimeEn( java.lang.String value ) {
		this.__design_time_en = value;
	}

	public java.lang.String getFinishTimeZh() {
		return this.__finish_time_zh;
	}

	public void setFinishTimeZh( java.lang.String value ) {
		this.__finish_time_zh = value;
	}

	public java.lang.String getFinishTimeEn() {
		return this.__finish_time_en;
	}

	public void setFinishTimeEn( java.lang.String value ) {
		this.__finish_time_en = value;
	}

	public java.lang.String getProjectArea() {
		return this.__project_area;
	}

	public void setProjectArea( java.lang.String value ) {
		this.__project_area = value;
	}

	public java.lang.String getMainThemeZh() {
		return this.__main_theme_zh;
	}

	public void setMainThemeZh( java.lang.String value ) {
		this.__main_theme_zh = value;
	}

	public java.lang.String getMainThemeEn() {
		return this.__main_theme_en;
	}

	public void setMainThemeEn( java.lang.String value ) {
		this.__main_theme_en = value;
	}

	public java.lang.String getMainPicture() {
		return this.__main_picture;
	}

	public void setMainPicture( java.lang.String value ) {
		this.__main_picture = value;
	}

	public java.lang.String getTurnPictureOne() {
		return this.__turn_picture_one;
	}

	public void setTurnPictureOne( java.lang.String value ) {
		this.__turn_picture_one = value;
	}

	public java.lang.String getTurnPictureTwo() {
		return this.__turn_picture_two;
	}

	public void setTurnPictureTwo( java.lang.String value ) {
		this.__turn_picture_two = value;
	}

	public java.lang.String getTurnPictureThree() {
		return this.__turn_picture_three;
	}

	public void setTurnPictureThree( java.lang.String value ) {
		this.__turn_picture_three = value;
	}

	public java.lang.String getTurnPictureFour() {
		return this.__turn_picture_four;
	}

	public void setTurnPictureFour( java.lang.String value ) {
		this.__turn_picture_four = value;
	}

	public java.lang.String getTurnPictureFive() {
		return this.__turn_picture_five;
	}

	public void setTurnPictureFive( java.lang.String value ) {
		this.__turn_picture_five = value;
	}

	public java.lang.String getTurnPictureSix() {
		return this.__turn_picture_six;
	}

	public void setTurnPictureSix( java.lang.String value ) {
		this.__turn_picture_six = value;
	}

	public java.lang.String getDescriptionZh() {
		return this.__description_zh;
	}

	public void setDescriptionZh( java.lang.String value ) {
		this.__description_zh = value;
	}

	public java.lang.String getDescriptionEn() {
		return this.__description_en;
	}

	public void setDescriptionEn( java.lang.String value ) {
		this.__description_en = value;
	}

	public java.lang.String getBriefZh() {
		return this.__brief_zh;
	}

	public void setBriefZh( java.lang.String value ) {
		this.__brief_zh = value;
	}

	public java.lang.String getBriefEn() {
		return this.__brief_en;
	}

	public void setBriefEn( java.lang.String value ) {
		this.__brief_en = value;
	}

	public java.lang.Boolean getIsAudited() {
		return this.__is_audited;
	}

	public void setIsAudited( java.lang.Boolean value ) {
		this.__is_audited = value;
	}

	public java.lang.Integer getClickNum() {
		return this.__click_num;
	}

	public void setClickNum( java.lang.Integer value ) {
		this.__click_num = value;
	}

	public java.lang.Integer getOrderId() {
		return this.__order_id;
	}

	public void setOrderId( java.lang.Integer value ) {
		this.__order_id = value;
	}

	public java.util.Date getPublishTime() {
		return this.__publish_time;
	}

	public void setPublishTime( java.util.Date value ) {
		this.__publish_time = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getTypeDetail() {
		return this.__type_detail;
	}

	public void setTypeDetail( java.lang.Integer value ) {
		this.__type_detail = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseJaidFunctionMaintenance __bean){
		__bean.setJaidFunctionMaintenanceId(getJaidFunctionMaintenanceId());
		__bean.setNameZh(getNameZh());
		__bean.setNameEn(getNameEn());
		__bean.setProjectAddressZh(getProjectAddressZh());
		__bean.setProjectAddressEn(getProjectAddressEn());
		__bean.setDesignTimeZh(getDesignTimeZh());
		__bean.setDesignTimeEn(getDesignTimeEn());
		__bean.setFinishTimeZh(getFinishTimeZh());
		__bean.setFinishTimeEn(getFinishTimeEn());
		__bean.setProjectArea(getProjectArea());
		__bean.setMainThemeZh(getMainThemeZh());
		__bean.setMainThemeEn(getMainThemeEn());
		__bean.setMainPicture(getMainPicture());
		__bean.setTurnPictureOne(getTurnPictureOne());
		__bean.setTurnPictureTwo(getTurnPictureTwo());
		__bean.setTurnPictureThree(getTurnPictureThree());
		__bean.setTurnPictureFour(getTurnPictureFour());
		__bean.setTurnPictureFive(getTurnPictureFive());
		__bean.setTurnPictureSix(getTurnPictureSix());
		__bean.setDescriptionZh(getDescriptionZh());
		__bean.setDescriptionEn(getDescriptionEn());
		__bean.setBriefZh(getBriefZh());
		__bean.setBriefEn(getBriefEn());
		__bean.setIsAudited(getIsAudited());
		__bean.setClickNum(getClickNum());
		__bean.setOrderId(getOrderId());
		__bean.setPublishTime(getPublishTime());
		__bean.setType(getType());
		__bean.setTypeDetail(getTypeDetail());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getJaidFunctionMaintenanceId() == null ? "" : getJaidFunctionMaintenanceId());
		sb.append(",");
		sb.append(getNameZh() == null ? "" : getNameZh());
		sb.append(",");
		sb.append(getNameEn() == null ? "" : getNameEn());
		sb.append(",");
		sb.append(getProjectAddressZh() == null ? "" : getProjectAddressZh());
		sb.append(",");
		sb.append(getProjectAddressEn() == null ? "" : getProjectAddressEn());
		sb.append(",");
		sb.append(getDesignTimeZh() == null ? "" : getDesignTimeZh());
		sb.append(",");
		sb.append(getDesignTimeEn() == null ? "" : getDesignTimeEn());
		sb.append(",");
		sb.append(getFinishTimeZh() == null ? "" : getFinishTimeZh());
		sb.append(",");
		sb.append(getFinishTimeEn() == null ? "" : getFinishTimeEn());
		sb.append(",");
		sb.append(getProjectArea() == null ? "" : getProjectArea());
		sb.append(",");
		sb.append(getMainThemeZh() == null ? "" : getMainThemeZh());
		sb.append(",");
		sb.append(getMainThemeEn() == null ? "" : getMainThemeEn());
		sb.append(",");
		sb.append(getMainPicture() == null ? "" : getMainPicture());
		sb.append(",");
		sb.append(getTurnPictureOne() == null ? "" : getTurnPictureOne());
		sb.append(",");
		sb.append(getTurnPictureTwo() == null ? "" : getTurnPictureTwo());
		sb.append(",");
		sb.append(getTurnPictureThree() == null ? "" : getTurnPictureThree());
		sb.append(",");
		sb.append(getTurnPictureFour() == null ? "" : getTurnPictureFour());
		sb.append(",");
		sb.append(getTurnPictureFive() == null ? "" : getTurnPictureFive());
		sb.append(",");
		sb.append(getTurnPictureSix() == null ? "" : getTurnPictureSix());
		sb.append(",");
		sb.append(getDescriptionZh() == null ? "" : getDescriptionZh());
		sb.append(",");
		sb.append(getDescriptionEn() == null ? "" : getDescriptionEn());
		sb.append(",");
		sb.append(getBriefZh() == null ? "" : getBriefZh());
		sb.append(",");
		sb.append(getBriefEn() == null ? "" : getBriefEn());
		sb.append(",");
		sb.append(getIsAudited() == null ? "" : getIsAudited());
		sb.append(",");
		sb.append(getClickNum() == null ? "" : getClickNum());
		sb.append(",");
		sb.append(getOrderId() == null ? "" : getOrderId());
		sb.append(",");
		sb.append(getPublishTime() == null ? "" : sdf.format(getPublishTime()));
		sb.append(",");
		String strType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_124", String.valueOf(getType()));
		sb.append(strType == null ? "" : strType);
		sb.append(",");
		sb.append(getTypeDetail() == null ? "" : getTypeDetail());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseJaidFunctionMaintenance o) {
		return __jaid_function_maintenance_id == null ? -1 : __jaid_function_maintenance_id.compareTo(o.getJaidFunctionMaintenanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__jaid_function_maintenance_id);
		hash = 97 * hash + Objects.hashCode(this.__name_zh);
		hash = 97 * hash + Objects.hashCode(this.__name_en);
		hash = 97 * hash + Objects.hashCode(this.__project_address_zh);
		hash = 97 * hash + Objects.hashCode(this.__project_address_en);
		hash = 97 * hash + Objects.hashCode(this.__design_time_zh);
		hash = 97 * hash + Objects.hashCode(this.__design_time_en);
		hash = 97 * hash + Objects.hashCode(this.__finish_time_zh);
		hash = 97 * hash + Objects.hashCode(this.__finish_time_en);
		hash = 97 * hash + Objects.hashCode(this.__project_area);
		hash = 97 * hash + Objects.hashCode(this.__main_theme_zh);
		hash = 97 * hash + Objects.hashCode(this.__main_theme_en);
		hash = 97 * hash + Objects.hashCode(this.__main_picture);
		hash = 97 * hash + Objects.hashCode(this.__turn_picture_one);
		hash = 97 * hash + Objects.hashCode(this.__turn_picture_two);
		hash = 97 * hash + Objects.hashCode(this.__turn_picture_three);
		hash = 97 * hash + Objects.hashCode(this.__turn_picture_four);
		hash = 97 * hash + Objects.hashCode(this.__turn_picture_five);
		hash = 97 * hash + Objects.hashCode(this.__turn_picture_six);
		hash = 97 * hash + Objects.hashCode(this.__description_zh);
		hash = 97 * hash + Objects.hashCode(this.__description_en);
		hash = 97 * hash + Objects.hashCode(this.__brief_zh);
		hash = 97 * hash + Objects.hashCode(this.__brief_en);
		hash = 97 * hash + Objects.hashCode(this.__is_audited);
		hash = 97 * hash + Objects.hashCode(this.__click_num);
		hash = 97 * hash + Objects.hashCode(this.__order_id);
		hash = 97 * hash + Objects.hashCode(this.__publish_time);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__type_detail);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseJaidFunctionMaintenance o = (BaseJaidFunctionMaintenance)obj;
		if(!Objects.equals(this.__jaid_function_maintenance_id, o.getJaidFunctionMaintenanceId())) return false;
		if(!Objects.equals(this.__name_zh, o.getNameZh())) return false;
		if(!Objects.equals(this.__name_en, o.getNameEn())) return false;
		if(!Objects.equals(this.__project_address_zh, o.getProjectAddressZh())) return false;
		if(!Objects.equals(this.__project_address_en, o.getProjectAddressEn())) return false;
		if(!Objects.equals(this.__design_time_zh, o.getDesignTimeZh())) return false;
		if(!Objects.equals(this.__design_time_en, o.getDesignTimeEn())) return false;
		if(!Objects.equals(this.__finish_time_zh, o.getFinishTimeZh())) return false;
		if(!Objects.equals(this.__finish_time_en, o.getFinishTimeEn())) return false;
		if(!Objects.equals(this.__project_area, o.getProjectArea())) return false;
		if(!Objects.equals(this.__main_theme_zh, o.getMainThemeZh())) return false;
		if(!Objects.equals(this.__main_theme_en, o.getMainThemeEn())) return false;
		if(!Objects.equals(this.__main_picture, o.getMainPicture())) return false;
		if(!Objects.equals(this.__turn_picture_one, o.getTurnPictureOne())) return false;
		if(!Objects.equals(this.__turn_picture_two, o.getTurnPictureTwo())) return false;
		if(!Objects.equals(this.__turn_picture_three, o.getTurnPictureThree())) return false;
		if(!Objects.equals(this.__turn_picture_four, o.getTurnPictureFour())) return false;
		if(!Objects.equals(this.__turn_picture_five, o.getTurnPictureFive())) return false;
		if(!Objects.equals(this.__turn_picture_six, o.getTurnPictureSix())) return false;
		if(!Objects.equals(this.__description_zh, o.getDescriptionZh())) return false;
		if(!Objects.equals(this.__description_en, o.getDescriptionEn())) return false;
		if(!Objects.equals(this.__brief_zh, o.getBriefZh())) return false;
		if(!Objects.equals(this.__brief_en, o.getBriefEn())) return false;
		if(!Objects.equals(this.__is_audited, o.getIsAudited())) return false;
		if(!Objects.equals(this.__click_num, o.getClickNum())) return false;
		if(!Objects.equals(this.__order_id, o.getOrderId())) return false;
		if(!Objects.equals(this.__publish_time, o.getPublishTime())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__type_detail, o.getTypeDetail())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getJaidFunctionMaintenanceId() != null) sb.append(__wrapNumber(count++, "jaidFunctionMaintenanceId", getJaidFunctionMaintenanceId()));
		if(getNameZh() != null) sb.append(__wrapString(count++, "nameZh", getNameZh()));
		if(getNameEn() != null) sb.append(__wrapString(count++, "nameEn", getNameEn()));
		if(getProjectAddressZh() != null) sb.append(__wrapString(count++, "projectAddressZh", getProjectAddressZh()));
		if(getProjectAddressEn() != null) sb.append(__wrapString(count++, "projectAddressEn", getProjectAddressEn()));
		if(getDesignTimeZh() != null) sb.append(__wrapString(count++, "designTimeZh", getDesignTimeZh()));
		if(getDesignTimeEn() != null) sb.append(__wrapString(count++, "designTimeEn", getDesignTimeEn()));
		if(getFinishTimeZh() != null) sb.append(__wrapString(count++, "finishTimeZh", getFinishTimeZh()));
		if(getFinishTimeEn() != null) sb.append(__wrapString(count++, "finishTimeEn", getFinishTimeEn()));
		if(getProjectArea() != null) sb.append(__wrapString(count++, "projectArea", getProjectArea()));
		if(getMainThemeZh() != null) sb.append(__wrapString(count++, "mainThemeZh", getMainThemeZh()));
		if(getMainThemeEn() != null) sb.append(__wrapString(count++, "mainThemeEn", getMainThemeEn()));
		if(getMainPicture() != null) sb.append(__wrapString(count++, "mainPicture", getMainPicture()));
		if(getTurnPictureOne() != null) sb.append(__wrapString(count++, "turnPictureOne", getTurnPictureOne()));
		if(getTurnPictureTwo() != null) sb.append(__wrapString(count++, "turnPictureTwo", getTurnPictureTwo()));
		if(getTurnPictureThree() != null) sb.append(__wrapString(count++, "turnPictureThree", getTurnPictureThree()));
		if(getTurnPictureFour() != null) sb.append(__wrapString(count++, "turnPictureFour", getTurnPictureFour()));
		if(getTurnPictureFive() != null) sb.append(__wrapString(count++, "turnPictureFive", getTurnPictureFive()));
		if(getTurnPictureSix() != null) sb.append(__wrapString(count++, "turnPictureSix", getTurnPictureSix()));
		if(getDescriptionZh() != null) sb.append(__wrapString(count++, "descriptionZh", getDescriptionZh()));
		if(getDescriptionEn() != null) sb.append(__wrapString(count++, "descriptionEn", getDescriptionEn()));
		if(getBriefZh() != null) sb.append(__wrapString(count++, "briefZh", getBriefZh()));
		if(getBriefEn() != null) sb.append(__wrapString(count++, "briefEn", getBriefEn()));
		if(getIsAudited() != null) sb.append(__wrapBoolean(count++, "isAudited", getIsAudited()));
		if(getClickNum() != null) sb.append(__wrapNumber(count++, "clickNum", getClickNum()));
		if(getOrderId() != null) sb.append(__wrapNumber(count++, "orderId", getOrderId()));
		if(getPublishTime() != null) sb.append(__wrapDate(count++, "publishTime", getPublishTime()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getTypeDetail() != null) sb.append(__wrapNumber(count++, "typeDetail", getTypeDetail()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("jaidFunctionMaintenanceId")) != null) setJaidFunctionMaintenanceId(__getInt(val)); 
		if((val = values.get("nameZh")) != null) setNameZh(__getString(val));
		if((val = values.get("nameEn")) != null) setNameEn(__getString(val));
		if((val = values.get("projectAddressZh")) != null) setProjectAddressZh(__getString(val));
		if((val = values.get("projectAddressEn")) != null) setProjectAddressEn(__getString(val));
		if((val = values.get("designTimeZh")) != null) setDesignTimeZh(__getString(val));
		if((val = values.get("designTimeEn")) != null) setDesignTimeEn(__getString(val));
		if((val = values.get("finishTimeZh")) != null) setFinishTimeZh(__getString(val));
		if((val = values.get("finishTimeEn")) != null) setFinishTimeEn(__getString(val));
		if((val = values.get("projectArea")) != null) setProjectArea(__getString(val));
		if((val = values.get("mainThemeZh")) != null) setMainThemeZh(__getString(val));
		if((val = values.get("mainThemeEn")) != null) setMainThemeEn(__getString(val));
		if((val = values.get("mainPicture")) != null) setMainPicture(__getString(val));
		if((val = values.get("turnPictureOne")) != null) setTurnPictureOne(__getString(val));
		if((val = values.get("turnPictureTwo")) != null) setTurnPictureTwo(__getString(val));
		if((val = values.get("turnPictureThree")) != null) setTurnPictureThree(__getString(val));
		if((val = values.get("turnPictureFour")) != null) setTurnPictureFour(__getString(val));
		if((val = values.get("turnPictureFive")) != null) setTurnPictureFive(__getString(val));
		if((val = values.get("turnPictureSix")) != null) setTurnPictureSix(__getString(val));
		if((val = values.get("descriptionZh")) != null) setDescriptionZh(__getString(val));
		if((val = values.get("descriptionEn")) != null) setDescriptionEn(__getString(val));
		if((val = values.get("briefZh")) != null) setBriefZh(__getString(val));
		if((val = values.get("briefEn")) != null) setBriefEn(__getString(val));
		if((val = values.get("isAudited")) != null) setIsAudited(__getBoolean(val));
		if((val = values.get("clickNum")) != null) setClickNum(__getInt(val)); 
		if((val = values.get("orderId")) != null) setOrderId(__getInt(val)); 
		if((val = values.get("publishTime")) != null) setPublishTime(__getDate(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("typeDetail")) != null) setTypeDetail(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __jaid_function_maintenance_id ;
	protected java.lang.String  __name_zh ;
	protected java.lang.String  __name_en ;
	protected java.lang.String  __project_address_zh ;
	protected java.lang.String  __project_address_en ;
	protected java.lang.String  __design_time_zh ;
	protected java.lang.String  __design_time_en ;
	protected java.lang.String  __finish_time_zh ;
	protected java.lang.String  __finish_time_en ;
	protected java.lang.String  __project_area ;
	protected java.lang.String  __main_theme_zh ;
	protected java.lang.String  __main_theme_en ;
	protected java.lang.String  __main_picture ;
	protected java.lang.String  __turn_picture_one ;
	protected java.lang.String  __turn_picture_two ;
	protected java.lang.String  __turn_picture_three ;
	protected java.lang.String  __turn_picture_four ;
	protected java.lang.String  __turn_picture_five ;
	protected java.lang.String  __turn_picture_six ;
	protected java.lang.String  __description_zh ;
	protected java.lang.String  __description_en ;
	protected java.lang.String  __brief_zh ;
	protected java.lang.String  __brief_en ;
	protected java.lang.Boolean  __is_audited ;
	protected java.lang.Integer  __click_num ;
	protected java.lang.Integer  __order_id ;
	protected java.util.Date  __publish_time ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __type_detail ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
