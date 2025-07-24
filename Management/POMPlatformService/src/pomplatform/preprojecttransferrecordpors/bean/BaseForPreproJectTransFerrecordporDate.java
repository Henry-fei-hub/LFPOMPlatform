package pomplatform.preprojecttransferrecordpors.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseForPreproJectTransFerrecordporDate extends GenericBase implements BaseFactory<BaseForPreproJectTransFerrecordporDate>, Comparable<BaseForPreproJectTransFerrecordporDate> 
{


	public static BaseForPreproJectTransFerrecordporDate newInstance(){
		return new BaseForPreproJectTransFerrecordporDate();
	}

	@Override
	public BaseForPreproJectTransFerrecordporDate make(){
		BaseForPreproJectTransFerrecordporDate b = new BaseForPreproJectTransFerrecordporDate();
		return b;
	}

	public final static java.lang.String CS_PRE_PROJECT_TRANSFER_RECORD_ID = "pre_project_transfer_record_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_TRANSFER_EMPLOYEE_ID = "transfer_employee_id" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_PROJECT_ORIGINATION = "project_origination" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_TOTAL_BUILDING_AREAS = "total_building_areas" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,原报备人,转交人,项目id,开发商名称,项目名称,项目地址（省）,项目地址（市）,详细地址,项目类别,项目来源渠道,联系人,联系电话,项目面积";

	public java.lang.Integer getPreProjectTransferRecordId() {
		return this.__pre_project_transfer_record_id;
	}

	public void setPreProjectTransferRecordId( java.lang.Integer value ) {
		this.__pre_project_transfer_record_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getTransferEmployeeId() {
		return this.__transfer_employee_id;
	}

	public void setTransferEmployeeId( java.lang.Integer value ) {
		this.__transfer_employee_id = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.String value ) {
		this.__province = value;
	}

	public java.lang.String getCity() {
		return this.__city;
	}

	public void setCity( java.lang.String value ) {
		this.__city = value;
	}

	public java.lang.String getDetailAddress() {
		return this.__detail_address;
	}

	public void setDetailAddress( java.lang.String value ) {
		this.__detail_address = value;
	}

	public java.lang.String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.String value ) {
		this.__project_type = value;
	}

	public java.lang.String getProjectOrigination() {
		return this.__project_origination;
	}

	public void setProjectOrigination( java.lang.String value ) {
		this.__project_origination = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name;
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.math.BigDecimal getTotalBuildingAreas() {
		return this.__total_building_areas;
	}

	public void setTotalBuildingAreas( java.math.BigDecimal value ) {
		this.__total_building_areas = value;
	}

	
	public java.lang.String getBusinessType() {
		return __business_type;
	}

	public void setBusinessType(java.lang.String value) {
		this.__business_type = value;
	}

	public void cloneCopy(BaseForPreproJectTransFerrecordporDate __bean){
		__bean.setPreProjectTransferRecordId(getPreProjectTransferRecordId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setTransferEmployeeId(getTransferEmployeeId());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setCustomerName(getCustomerName());
		__bean.setProjectName(getProjectName());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setDetailAddress(getDetailAddress());
		__bean.setProjectType(getProjectType());
		__bean.setProjectOrigination(getProjectOrigination());
		__bean.setContactName(getContactName());
		__bean.setContactPhone(getContactPhone());
		__bean.setTotalBuildingAreas(getTotalBuildingAreas());
		__bean.setBusinessType(getBusinessType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPreProjectTransferRecordId() == null ? "" : getPreProjectTransferRecordId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getTransferEmployeeId() == null ? "" : getTransferEmployeeId());
		sb.append(",");
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getDetailAddress() == null ? "" : getDetailAddress());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getProjectOrigination() == null ? "" : getProjectOrigination());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getTotalBuildingAreas() == null ? "" : getTotalBuildingAreas());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseForPreproJectTransFerrecordporDate o) {
		return __pre_project_transfer_record_id == null ? -1 : __pre_project_transfer_record_id.compareTo(o.getPreProjectTransferRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pre_project_transfer_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__transfer_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__detail_address);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__project_origination);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__total_building_areas);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseForPreproJectTransFerrecordporDate o = (BaseForPreproJectTransFerrecordporDate)obj;
		if(!Objects.equals(this.__pre_project_transfer_record_id, o.getPreProjectTransferRecordId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__transfer_employee_id, o.getTransferEmployeeId())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__detail_address, o.getDetailAddress())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__project_origination, o.getProjectOrigination())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__total_building_areas, o.getTotalBuildingAreas())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPreProjectTransferRecordId() != null) sb.append(__wrapNumber(count++, "preProjectTransferRecordId", getPreProjectTransferRecordId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getTransferEmployeeId() != null) sb.append(__wrapNumber(count++, "transferEmployeeId", getTransferEmployeeId()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getDetailAddress() != null) sb.append(__wrapString(count++, "detailAddress", getDetailAddress()));
		if(getProjectType() != null) sb.append(__wrapString(count++, "projectType", getProjectType()));
		if(getProjectOrigination() != null) sb.append(__wrapString(count++, "projectOrigination", getProjectOrigination()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getTotalBuildingAreas() != null) sb.append(__wrapDecimal(count++, "totalBuildingAreas", getTotalBuildingAreas()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("preProjectTransferRecordId")) != null) setPreProjectTransferRecordId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("transferEmployeeId")) != null) setTransferEmployeeId(__getInt(val)); 
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
		if((val = values.get("projectOrigination")) != null) setProjectOrigination(__getString(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("totalBuildingAreas")) != null) setTotalBuildingAreas(__getDecimal(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
	}

	protected java.lang.Integer  __pre_project_transfer_record_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __transfer_employee_id ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.String  __detail_address ;
	protected java.lang.String  __project_type ;
	protected java.lang.String  __project_origination ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_phone ;
	protected java.math.BigDecimal  __total_building_areas ;
	protected java.lang.String  __business_type ;
}
