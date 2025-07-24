package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompetitionUnit extends GenericBase implements BaseFactory<BaseCompetitionUnit>, Comparable<BaseCompetitionUnit> 
{


	public static BaseCompetitionUnit newInstance(){
		return new BaseCompetitionUnit();
	}

	@Override
	public BaseCompetitionUnit make(){
		BaseCompetitionUnit b = new BaseCompetitionUnit();
		return b;
	}

	public final static java.lang.String CS_COMPETITION_UNIT_ID = "competition_unit_id" ;
	public final static java.lang.String CS_PLATE_TYPE_NAME = "plate_type_name" ;
	public final static java.lang.String CS_AREA_NAME = "area_name" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_WEB_SITE = "web_site" ;
	public final static java.lang.String CS_COMPANY_STOCK_CODE = "company_stock_code" ;
	public final static java.lang.String CS_COMPANY_PROVINCE = "company_province" ;
	public final static java.lang.String CS_COMPANY_CITY = "company_city" ;
	public final static java.lang.String CS_BUSINESS_PLATE = "business_plate" ;
	public final static java.lang.String CS_PROFESSIONAL_PLATE = "professional_plate" ;
	public final static java.lang.String CS_COMPANY_PARENT_NAME = "company_parent_name" ;
	public final static java.lang.String CS_COMPANY_PARENT_ADDRESS = "company_parent_address" ;
	public final static java.lang.String CS_COMPANY_CHILD_NAME = "company_child_name" ;
	public final static java.lang.String CS_COMPANY_EMPLOYEE_NUM = "company_employee_num" ;
	public final static java.lang.String CS_COMPANY_SETUP = "company_setup" ;
	public final static java.lang.String CS_COMPANY_NATURE = "company_nature" ;
	public final static java.lang.String CS_COMPANY_QUALIFICATION = "company_qualification" ;
	public final static java.lang.String CS_COMPANY_ORGANIZATIONAL = "company_organizational" ;
	public final static java.lang.String CS_MAIN_WORK_CUSTOMER = "main_work_customer" ;
	public final static java.lang.String CS_MIAN_ACHIEVEMENT = "mian_achievement" ;
	public final static java.lang.String CS_COMPANY_BRIEF = "company_brief" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROJECT_VOLUME = "project_volume" ;
	public final static java.lang.String CS_DESIGN_DATE = "design_date" ;
	public final static java.lang.String CS_DESIGN_HIGHLIGHT = "design_highlight" ;
	public final static java.lang.String CS_DESIGN_FEE_STANDARD = "design_fee_standard" ;
	public final static java.lang.String CS_CORE_STRENGTH = "core_strength" ;
	public final static java.lang.String CS_WEAKNESSES = "weaknesses" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,板块名称,区域名称,名称,地址,网站,股票代码,省份,城市,业态板块,专业板块,客户集团公司名称,客户集团公司地址,分支机构,公司人数,公司成立日期,企业性质,企业资质,组织架构,主要合作客户,主要合作业绩,公司简介,项目名称,项目体量,设计日期,设计亮点,设计取费标准,核心优势,劣势,操作人,创建时间,备注";

	public java.lang.Integer getCompetitionUnitId() {
		return this.__competition_unit_id;
	}

	public void setCompetitionUnitId( java.lang.Integer value ) {
		this.__competition_unit_id = value;
	}

	public java.lang.String getPlateTypeName() {
		return this.__plate_type_name;
	}

	public void setPlateTypeName( java.lang.String value ) {
		this.__plate_type_name = value;
	}

	public java.lang.String getAreaName() {
		return this.__area_name;
	}

	public void setAreaName( java.lang.String value ) {
		this.__area_name = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.String getWebSite() {
		return this.__web_site;
	}

	public void setWebSite( java.lang.String value ) {
		this.__web_site = value;
	}

	public java.lang.String getCompanyStockCode() {
		return this.__company_stock_code;
	}

	public void setCompanyStockCode( java.lang.String value ) {
		this.__company_stock_code = value;
	}

	public java.lang.String getCompanyProvince() {
		return this.__company_province;
	}

	public void setCompanyProvince( java.lang.String value ) {
		this.__company_province = value;
	}

	public java.lang.String getCompanyCity() {
		return this.__company_city;
	}

	public void setCompanyCity( java.lang.String value ) {
		this.__company_city = value;
	}

	public java.lang.String getBusinessPlate() {
		return this.__business_plate;
	}

	public void setBusinessPlate( java.lang.String value ) {
		this.__business_plate = value;
	}

	public java.lang.String getProfessionalPlate() {
		return this.__professional_plate;
	}

	public void setProfessionalPlate( java.lang.String value ) {
		this.__professional_plate = value;
	}

	public java.lang.String getCompanyParentName() {
		return this.__company_parent_name;
	}

	public void setCompanyParentName( java.lang.String value ) {
		this.__company_parent_name = value;
	}

	public java.lang.String getCompanyParentAddress() {
		return this.__company_parent_address;
	}

	public void setCompanyParentAddress( java.lang.String value ) {
		this.__company_parent_address = value;
	}

	public java.lang.String getCompanyChildName() {
		return this.__company_child_name;
	}

	public void setCompanyChildName( java.lang.String value ) {
		this.__company_child_name = value;
	}

	public java.lang.Integer getCompanyEmployeeNum() {
		return this.__company_employee_num;
	}

	public void setCompanyEmployeeNum( java.lang.Integer value ) {
		this.__company_employee_num = value;
	}

	public java.util.Date getCompanySetup() {
		return this.__company_setup;
	}

	public void setCompanySetup( java.util.Date value ) {
		this.__company_setup = value;
	}

	public java.lang.String getCompanyNature() {
		return this.__company_nature;
	}

	public void setCompanyNature( java.lang.String value ) {
		this.__company_nature = value;
	}

	public java.lang.String getCompanyQualification() {
		return this.__company_qualification;
	}

	public void setCompanyQualification( java.lang.String value ) {
		this.__company_qualification = value;
	}

	public java.lang.String getCompanyOrganizational() {
		return this.__company_organizational;
	}

	public void setCompanyOrganizational( java.lang.String value ) {
		this.__company_organizational = value;
	}

	public java.lang.String getMainWorkCustomer() {
		return this.__main_work_customer;
	}

	public void setMainWorkCustomer( java.lang.String value ) {
		this.__main_work_customer = value;
	}

	public java.lang.String getMianAchievement() {
		return this.__mian_achievement;
	}

	public void setMianAchievement( java.lang.String value ) {
		this.__mian_achievement = value;
	}

	public java.lang.String getCompanyBrief() {
		return this.__company_brief;
	}

	public void setCompanyBrief( java.lang.String value ) {
		this.__company_brief = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectVolume() {
		return this.__project_volume;
	}

	public void setProjectVolume( java.lang.String value ) {
		this.__project_volume = value;
	}

	public java.util.Date getDesignDate() {
		return this.__design_date;
	}

	public void setDesignDate( java.util.Date value ) {
		this.__design_date = value;
	}

	public java.lang.String getDesignHighlight() {
		return this.__design_highlight;
	}

	public void setDesignHighlight( java.lang.String value ) {
		this.__design_highlight = value;
	}

	public java.lang.String getDesignFeeStandard() {
		return this.__design_fee_standard;
	}

	public void setDesignFeeStandard( java.lang.String value ) {
		this.__design_fee_standard = value;
	}

	public java.lang.String getCoreStrength() {
		return this.__core_strength;
	}

	public void setCoreStrength( java.lang.String value ) {
		this.__core_strength = value;
	}

	public java.lang.String getWeaknesses() {
		return this.__weaknesses;
	}

	public void setWeaknesses( java.lang.String value ) {
		this.__weaknesses = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseCompetitionUnit __bean){
		__bean.setCompetitionUnitId(getCompetitionUnitId());
		__bean.setPlateTypeName(getPlateTypeName());
		__bean.setAreaName(getAreaName());
		__bean.setName(getName());
		__bean.setAddress(getAddress());
		__bean.setWebSite(getWebSite());
		__bean.setCompanyStockCode(getCompanyStockCode());
		__bean.setCompanyProvince(getCompanyProvince());
		__bean.setCompanyCity(getCompanyCity());
		__bean.setBusinessPlate(getBusinessPlate());
		__bean.setProfessionalPlate(getProfessionalPlate());
		__bean.setCompanyParentName(getCompanyParentName());
		__bean.setCompanyParentAddress(getCompanyParentAddress());
		__bean.setCompanyChildName(getCompanyChildName());
		__bean.setCompanyEmployeeNum(getCompanyEmployeeNum());
		__bean.setCompanySetup(getCompanySetup());
		__bean.setCompanyNature(getCompanyNature());
		__bean.setCompanyQualification(getCompanyQualification());
		__bean.setCompanyOrganizational(getCompanyOrganizational());
		__bean.setMainWorkCustomer(getMainWorkCustomer());
		__bean.setMianAchievement(getMianAchievement());
		__bean.setCompanyBrief(getCompanyBrief());
		__bean.setProjectName(getProjectName());
		__bean.setProjectVolume(getProjectVolume());
		__bean.setDesignDate(getDesignDate());
		__bean.setDesignHighlight(getDesignHighlight());
		__bean.setDesignFeeStandard(getDesignFeeStandard());
		__bean.setCoreStrength(getCoreStrength());
		__bean.setWeaknesses(getWeaknesses());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompetitionUnitId() == null ? "" : getCompetitionUnitId());
		sb.append(",");
		sb.append(getPlateTypeName() == null ? "" : getPlateTypeName());
		sb.append(",");
		sb.append(getAreaName() == null ? "" : getAreaName());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getWebSite() == null ? "" : getWebSite());
		sb.append(",");
		sb.append(getCompanyStockCode() == null ? "" : getCompanyStockCode());
		sb.append(",");
		sb.append(getCompanyProvince() == null ? "" : getCompanyProvince());
		sb.append(",");
		sb.append(getCompanyCity() == null ? "" : getCompanyCity());
		sb.append(",");
		sb.append(getBusinessPlate() == null ? "" : getBusinessPlate());
		sb.append(",");
		sb.append(getProfessionalPlate() == null ? "" : getProfessionalPlate());
		sb.append(",");
		sb.append(getCompanyParentName() == null ? "" : getCompanyParentName());
		sb.append(",");
		sb.append(getCompanyParentAddress() == null ? "" : getCompanyParentAddress());
		sb.append(",");
		sb.append(getCompanyChildName() == null ? "" : getCompanyChildName());
		sb.append(",");
		sb.append(getCompanyEmployeeNum() == null ? "" : getCompanyEmployeeNum());
		sb.append(",");
		sb.append(getCompanySetup() == null ? "" : sdf.format(getCompanySetup()));
		sb.append(",");
		sb.append(getCompanyNature() == null ? "" : getCompanyNature());
		sb.append(",");
		sb.append(getCompanyQualification() == null ? "" : getCompanyQualification());
		sb.append(",");
		sb.append(getCompanyOrganizational() == null ? "" : getCompanyOrganizational());
		sb.append(",");
		sb.append(getMainWorkCustomer() == null ? "" : getMainWorkCustomer());
		sb.append(",");
		sb.append(getMianAchievement() == null ? "" : getMianAchievement());
		sb.append(",");
		sb.append(getCompanyBrief() == null ? "" : getCompanyBrief());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProjectVolume() == null ? "" : getProjectVolume());
		sb.append(",");
		sb.append(getDesignDate() == null ? "" : sdf.format(getDesignDate()));
		sb.append(",");
		sb.append(getDesignHighlight() == null ? "" : getDesignHighlight());
		sb.append(",");
		sb.append(getDesignFeeStandard() == null ? "" : getDesignFeeStandard());
		sb.append(",");
		sb.append(getCoreStrength() == null ? "" : getCoreStrength());
		sb.append(",");
		sb.append(getWeaknesses() == null ? "" : getWeaknesses());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompetitionUnit o) {
		return __competition_unit_id == null ? -1 : __competition_unit_id.compareTo(o.getCompetitionUnitId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__competition_unit_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_type_name);
		hash = 97 * hash + Objects.hashCode(this.__area_name);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__web_site);
		hash = 97 * hash + Objects.hashCode(this.__company_stock_code);
		hash = 97 * hash + Objects.hashCode(this.__company_province);
		hash = 97 * hash + Objects.hashCode(this.__company_city);
		hash = 97 * hash + Objects.hashCode(this.__business_plate);
		hash = 97 * hash + Objects.hashCode(this.__professional_plate);
		hash = 97 * hash + Objects.hashCode(this.__company_parent_name);
		hash = 97 * hash + Objects.hashCode(this.__company_parent_address);
		hash = 97 * hash + Objects.hashCode(this.__company_child_name);
		hash = 97 * hash + Objects.hashCode(this.__company_employee_num);
		hash = 97 * hash + Objects.hashCode(this.__company_setup);
		hash = 97 * hash + Objects.hashCode(this.__company_nature);
		hash = 97 * hash + Objects.hashCode(this.__company_qualification);
		hash = 97 * hash + Objects.hashCode(this.__company_organizational);
		hash = 97 * hash + Objects.hashCode(this.__main_work_customer);
		hash = 97 * hash + Objects.hashCode(this.__mian_achievement);
		hash = 97 * hash + Objects.hashCode(this.__company_brief);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__project_volume);
		hash = 97 * hash + Objects.hashCode(this.__design_date);
		hash = 97 * hash + Objects.hashCode(this.__design_highlight);
		hash = 97 * hash + Objects.hashCode(this.__design_fee_standard);
		hash = 97 * hash + Objects.hashCode(this.__core_strength);
		hash = 97 * hash + Objects.hashCode(this.__weaknesses);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompetitionUnit o = (BaseCompetitionUnit)obj;
		if(!Objects.equals(this.__competition_unit_id, o.getCompetitionUnitId())) return false;
		if(!Objects.equals(this.__plate_type_name, o.getPlateTypeName())) return false;
		if(!Objects.equals(this.__area_name, o.getAreaName())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__web_site, o.getWebSite())) return false;
		if(!Objects.equals(this.__company_stock_code, o.getCompanyStockCode())) return false;
		if(!Objects.equals(this.__company_province, o.getCompanyProvince())) return false;
		if(!Objects.equals(this.__company_city, o.getCompanyCity())) return false;
		if(!Objects.equals(this.__business_plate, o.getBusinessPlate())) return false;
		if(!Objects.equals(this.__professional_plate, o.getProfessionalPlate())) return false;
		if(!Objects.equals(this.__company_parent_name, o.getCompanyParentName())) return false;
		if(!Objects.equals(this.__company_parent_address, o.getCompanyParentAddress())) return false;
		if(!Objects.equals(this.__company_child_name, o.getCompanyChildName())) return false;
		if(!Objects.equals(this.__company_employee_num, o.getCompanyEmployeeNum())) return false;
		if(!Objects.equals(this.__company_setup, o.getCompanySetup())) return false;
		if(!Objects.equals(this.__company_nature, o.getCompanyNature())) return false;
		if(!Objects.equals(this.__company_qualification, o.getCompanyQualification())) return false;
		if(!Objects.equals(this.__company_organizational, o.getCompanyOrganizational())) return false;
		if(!Objects.equals(this.__main_work_customer, o.getMainWorkCustomer())) return false;
		if(!Objects.equals(this.__mian_achievement, o.getMianAchievement())) return false;
		if(!Objects.equals(this.__company_brief, o.getCompanyBrief())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__project_volume, o.getProjectVolume())) return false;
		if(!Objects.equals(this.__design_date, o.getDesignDate())) return false;
		if(!Objects.equals(this.__design_highlight, o.getDesignHighlight())) return false;
		if(!Objects.equals(this.__design_fee_standard, o.getDesignFeeStandard())) return false;
		if(!Objects.equals(this.__core_strength, o.getCoreStrength())) return false;
		if(!Objects.equals(this.__weaknesses, o.getWeaknesses())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompetitionUnitId() != null) sb.append(__wrapNumber(count++, "competitionUnitId", getCompetitionUnitId()));
		if(getPlateTypeName() != null) sb.append(__wrapString(count++, "plateTypeName", getPlateTypeName()));
		if(getAreaName() != null) sb.append(__wrapString(count++, "areaName", getAreaName()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getWebSite() != null) sb.append(__wrapString(count++, "webSite", getWebSite()));
		if(getCompanyStockCode() != null) sb.append(__wrapString(count++, "companyStockCode", getCompanyStockCode()));
		if(getCompanyProvince() != null) sb.append(__wrapString(count++, "companyProvince", getCompanyProvince()));
		if(getCompanyCity() != null) sb.append(__wrapString(count++, "companyCity", getCompanyCity()));
		if(getBusinessPlate() != null) sb.append(__wrapString(count++, "businessPlate", getBusinessPlate()));
		if(getProfessionalPlate() != null) sb.append(__wrapString(count++, "professionalPlate", getProfessionalPlate()));
		if(getCompanyParentName() != null) sb.append(__wrapString(count++, "companyParentName", getCompanyParentName()));
		if(getCompanyParentAddress() != null) sb.append(__wrapString(count++, "companyParentAddress", getCompanyParentAddress()));
		if(getCompanyChildName() != null) sb.append(__wrapString(count++, "companyChildName", getCompanyChildName()));
		if(getCompanyEmployeeNum() != null) sb.append(__wrapNumber(count++, "companyEmployeeNum", getCompanyEmployeeNum()));
		if(getCompanySetup() != null) sb.append(__wrapDate(count++, "companySetup", getCompanySetup()));
		if(getCompanyNature() != null) sb.append(__wrapString(count++, "companyNature", getCompanyNature()));
		if(getCompanyQualification() != null) sb.append(__wrapString(count++, "companyQualification", getCompanyQualification()));
		if(getCompanyOrganizational() != null) sb.append(__wrapString(count++, "companyOrganizational", getCompanyOrganizational()));
		if(getMainWorkCustomer() != null) sb.append(__wrapString(count++, "mainWorkCustomer", getMainWorkCustomer()));
		if(getMianAchievement() != null) sb.append(__wrapString(count++, "mianAchievement", getMianAchievement()));
		if(getCompanyBrief() != null) sb.append(__wrapString(count++, "companyBrief", getCompanyBrief()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProjectVolume() != null) sb.append(__wrapString(count++, "projectVolume", getProjectVolume()));
		if(getDesignDate() != null) sb.append(__wrapDate(count++, "designDate", getDesignDate()));
		if(getDesignHighlight() != null) sb.append(__wrapString(count++, "designHighlight", getDesignHighlight()));
		if(getDesignFeeStandard() != null) sb.append(__wrapString(count++, "designFeeStandard", getDesignFeeStandard()));
		if(getCoreStrength() != null) sb.append(__wrapString(count++, "coreStrength", getCoreStrength()));
		if(getWeaknesses() != null) sb.append(__wrapString(count++, "weaknesses", getWeaknesses()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("competitionUnitId")) != null) setCompetitionUnitId(__getInt(val)); 
		if((val = values.get("plateTypeName")) != null) setPlateTypeName(__getString(val));
		if((val = values.get("areaName")) != null) setAreaName(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("webSite")) != null) setWebSite(__getString(val));
		if((val = values.get("companyStockCode")) != null) setCompanyStockCode(__getString(val));
		if((val = values.get("companyProvince")) != null) setCompanyProvince(__getString(val));
		if((val = values.get("companyCity")) != null) setCompanyCity(__getString(val));
		if((val = values.get("businessPlate")) != null) setBusinessPlate(__getString(val));
		if((val = values.get("professionalPlate")) != null) setProfessionalPlate(__getString(val));
		if((val = values.get("companyParentName")) != null) setCompanyParentName(__getString(val));
		if((val = values.get("companyParentAddress")) != null) setCompanyParentAddress(__getString(val));
		if((val = values.get("companyChildName")) != null) setCompanyChildName(__getString(val));
		if((val = values.get("companyEmployeeNum")) != null) setCompanyEmployeeNum(__getInt(val)); 
		if((val = values.get("companySetup")) != null) setCompanySetup(__getDate(val)); 
		if((val = values.get("companyNature")) != null) setCompanyNature(__getString(val));
		if((val = values.get("companyQualification")) != null) setCompanyQualification(__getString(val));
		if((val = values.get("companyOrganizational")) != null) setCompanyOrganizational(__getString(val));
		if((val = values.get("mainWorkCustomer")) != null) setMainWorkCustomer(__getString(val));
		if((val = values.get("mianAchievement")) != null) setMianAchievement(__getString(val));
		if((val = values.get("companyBrief")) != null) setCompanyBrief(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectVolume")) != null) setProjectVolume(__getString(val));
		if((val = values.get("designDate")) != null) setDesignDate(__getDate(val)); 
		if((val = values.get("designHighlight")) != null) setDesignHighlight(__getString(val));
		if((val = values.get("designFeeStandard")) != null) setDesignFeeStandard(__getString(val));
		if((val = values.get("coreStrength")) != null) setCoreStrength(__getString(val));
		if((val = values.get("weaknesses")) != null) setWeaknesses(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __competition_unit_id ;
	protected java.lang.String  __plate_type_name ;
	protected java.lang.String  __area_name ;
	protected java.lang.String  __name ;
	protected java.lang.String  __address ;
	protected java.lang.String  __web_site ;
	protected java.lang.String  __company_stock_code ;
	protected java.lang.String  __company_province ;
	protected java.lang.String  __company_city ;
	protected java.lang.String  __business_plate ;
	protected java.lang.String  __professional_plate ;
	protected java.lang.String  __company_parent_name ;
	protected java.lang.String  __company_parent_address ;
	protected java.lang.String  __company_child_name ;
	protected java.lang.Integer  __company_employee_num ;
	protected java.util.Date  __company_setup ;
	protected java.lang.String  __company_nature ;
	protected java.lang.String  __company_qualification ;
	protected java.lang.String  __company_organizational ;
	protected java.lang.String  __main_work_customer ;
	protected java.lang.String  __mian_achievement ;
	protected java.lang.String  __company_brief ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __project_volume ;
	protected java.util.Date  __design_date ;
	protected java.lang.String  __design_highlight ;
	protected java.lang.String  __design_fee_standard ;
	protected java.lang.String  __core_strength ;
	protected java.lang.String  __weaknesses ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
