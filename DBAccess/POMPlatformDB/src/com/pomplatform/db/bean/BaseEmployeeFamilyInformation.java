package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeFamilyInformation extends GenericBase implements BaseFactory<BaseEmployeeFamilyInformation>, Comparable<BaseEmployeeFamilyInformation> 
{


	public static BaseEmployeeFamilyInformation newInstance(){
		return new BaseEmployeeFamilyInformation();
	}

	@Override
	public BaseEmployeeFamilyInformation make(){
		BaseEmployeeFamilyInformation b = new BaseEmployeeFamilyInformation();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_FAMILY_INFORMATION_ID = "employee_family_information_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_FAMILY_MEMBER_NAME = "family_member_name" ;
	public final static java.lang.String CS_RELATION = "relation" ;
	public final static java.lang.String CS_FAMILY_WORK_PLACE = "family_work_place" ;
	public final static java.lang.String CS_TELEPHONE = "telephone" ;
	public final static java.lang.String CS_FAMILY_MEMBER_CARD = "family_member_card" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,姓名,与本人关系,工作单位,联系电话,家庭成员身份证号";

	public java.lang.Integer getEmployeeFamilyInformationId() {
		return this.__employee_family_information_id;
	}

	public void setEmployeeFamilyInformationId( java.lang.Integer value ) {
		this.__employee_family_information_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getFamilyMemberName() {
		return this.__family_member_name;
	}

	public void setFamilyMemberName( java.lang.String value ) {
		this.__family_member_name = value;
	}

	public java.lang.String getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.String value ) {
		this.__relation = value;
	}

	public java.lang.String getFamilyWorkPlace() {
		return this.__family_work_place;
	}

	public void setFamilyWorkPlace( java.lang.String value ) {
		this.__family_work_place = value;
	}

	public java.lang.String getTelephone() {
		return this.__telephone;
	}

	public void setTelephone( java.lang.String value ) {
		this.__telephone = value;
	}

	public java.lang.String getFamilyMemberCard() {
		return this.__family_member_card;
	}

	public void setFamilyMemberCard( java.lang.String value ) {
		this.__family_member_card = value;
	}

	public void cloneCopy(BaseEmployeeFamilyInformation __bean){
		__bean.setEmployeeFamilyInformationId(getEmployeeFamilyInformationId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setFamilyMemberName(getFamilyMemberName());
		__bean.setRelation(getRelation());
		__bean.setFamilyWorkPlace(getFamilyWorkPlace());
		__bean.setTelephone(getTelephone());
		__bean.setFamilyMemberCard(getFamilyMemberCard());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeFamilyInformationId() == null ? "" : getEmployeeFamilyInformationId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getFamilyMemberName() == null ? "" : getFamilyMemberName());
		sb.append(",");
		sb.append(getRelation() == null ? "" : getRelation());
		sb.append(",");
		sb.append(getFamilyWorkPlace() == null ? "" : getFamilyWorkPlace());
		sb.append(",");
		sb.append(getTelephone() == null ? "" : getTelephone());
		sb.append(",");
		sb.append(getFamilyMemberCard() == null ? "" : getFamilyMemberCard());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeFamilyInformation o) {
		return __employee_family_information_id == null ? -1 : __employee_family_information_id.compareTo(o.getEmployeeFamilyInformationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_family_information_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__family_member_name);
		hash = 97 * hash + Objects.hashCode(this.__relation);
		hash = 97 * hash + Objects.hashCode(this.__family_work_place);
		hash = 97 * hash + Objects.hashCode(this.__telephone);
		hash = 97 * hash + Objects.hashCode(this.__family_member_card);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeFamilyInformation o = (BaseEmployeeFamilyInformation)obj;
		if(!Objects.equals(this.__employee_family_information_id, o.getEmployeeFamilyInformationId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__family_member_name, o.getFamilyMemberName())) return false;
		if(!Objects.equals(this.__relation, o.getRelation())) return false;
		if(!Objects.equals(this.__family_work_place, o.getFamilyWorkPlace())) return false;
		if(!Objects.equals(this.__telephone, o.getTelephone())) return false;
		if(!Objects.equals(this.__family_member_card, o.getFamilyMemberCard())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeFamilyInformationId() != null) sb.append(__wrapNumber(count++, "employeeFamilyInformationId", getEmployeeFamilyInformationId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getFamilyMemberName() != null) sb.append(__wrapString(count++, "familyMemberName", getFamilyMemberName()));
		if(getRelation() != null) sb.append(__wrapString(count++, "relation", getRelation()));
		if(getFamilyWorkPlace() != null) sb.append(__wrapString(count++, "familyWorkPlace", getFamilyWorkPlace()));
		if(getTelephone() != null) sb.append(__wrapString(count++, "telephone", getTelephone()));
		if(getFamilyMemberCard() != null) sb.append(__wrapString(count++, "familyMemberCard", getFamilyMemberCard()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeFamilyInformationId")) != null) setEmployeeFamilyInformationId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("familyMemberName")) != null) setFamilyMemberName(__getString(val));
		if((val = values.get("relation")) != null) setRelation(__getString(val));
		if((val = values.get("familyWorkPlace")) != null) setFamilyWorkPlace(__getString(val));
		if((val = values.get("telephone")) != null) setTelephone(__getString(val));
		if((val = values.get("familyMemberCard")) != null) setFamilyMemberCard(__getString(val));
	}

	protected java.lang.Integer  __employee_family_information_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __family_member_name ;
	protected java.lang.String  __relation ;
	protected java.lang.String  __family_work_place ;
	protected java.lang.String  __telephone ;
	protected java.lang.String  __family_member_card ;
}
