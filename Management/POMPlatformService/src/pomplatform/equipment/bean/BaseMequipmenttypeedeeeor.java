package pomplatform.equipment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import pomplatform.equipment.bean.BaseMequipmentrecordedeor;

public class BaseMequipmenttypeedeeeor extends GenericBase implements BaseFactory<BaseMequipmenttypeedeeeor>, Comparable<BaseMequipmenttypeedeeeor> 
{


	public static BaseMequipmenttypeedeeeor newInstance(){
		return new BaseMequipmenttypeedeeeor();
	}

	@Override
	public BaseMequipmenttypeedeeeor make(){
		BaseMequipmenttypeedeeeor b = new BaseMequipmenttypeedeeeor();
		return b;
	}

	public final static String CS_EQUIPMENT_TYPE_ID = "equipment_type_id" ;
	public final static String CS_NAME = "name" ;
	public final static String CS_TYPE = "type" ;
	public final static String CS_PRICE = "price" ;
	public final static String CS_COUNT = "count" ;
	public final static String CS_FLAG = "flag" ;
	public final static String CS_UPDATE_TIME = "update_time" ;
	public final static String CS_UPDATE_PERSON = "update_person" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_DEPARTMENT_NAME = "department_name" ;

	public final static String ALL_CAPTIONS = "名称,物品类型,单价,数量,物品状态,操作时间,操作人,所属部门";

	public Integer getEquipmentTypeId() {
		return this.__equipment_type_id;
	}

	public void setEquipmentTypeId( Integer value ) {
		this.__equipment_type_id = value;
	}

	public String getName() {
		return this.__name;
	}

	public void setName( String value ) {
		this.__name = value;
	}

	public Integer getType() {
		return this.__type;
	}

	public void setType( Integer value ) {
		this.__type = value;
	}

	public java.math.BigDecimal getPrice() {
		return this.__price;
	}

	public void setPrice( java.math.BigDecimal value ) {
		this.__price = value;
	}

	public Integer getCount() {
		return this.__count;
	}

	public void setCount( Integer value ) {
		this.__count = value;
	}

	public Boolean getFlag() {
		return this.__flag;
	}

	public void setFlag( Boolean value ) {
		this.__flag = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public Integer getUpdatePerson() {
		return this.__update_person;
	}

	public void setUpdatePerson( Integer value ) {
		this.__update_person = value;
	}

	public String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( String value ) {
		this.__department_name = value;
	}

	public java.util.List<BaseMequipmentrecordedeor> getDetailMequipmentrecordedeor() {
		return this.__detailMequipmentrecordedeor;
	}

	public void setDetailMequipmentrecordedeor( java.util.List<BaseMequipmentrecordedeor> value ) {
		this.__detailMequipmentrecordedeor = value;
	}

	public void cloneCopy(BaseMequipmenttypeedeeeor __bean){
		__bean.setEquipmentTypeId(getEquipmentTypeId());
		__bean.setName(getName());
		__bean.setType(getType());
		__bean.setPrice(getPrice());
		__bean.setCount(getCount());
		__bean.setFlag(getFlag());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setUpdatePerson(getUpdatePerson());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentName(getDepartmentName());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		String strType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_254", String.valueOf(getType()));
		sb.append(strType == null ? "" : strType);
		sb.append(",");
		sb.append(getPrice() == null ? "" : getPrice());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag()?"启用":"禁用");
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMequipmenttypeedeeeor o) {
		return __equipment_type_id == null ? -1 : __equipment_type_id.compareTo(o.getEquipmentTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__equipment_type_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__price);
		hash = 97 * hash + Objects.hashCode(this.__count);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__update_person);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMequipmenttypeedeeeor o = (BaseMequipmenttypeedeeeor)obj;
		if(!Objects.equals(this.__equipment_type_id, o.getEquipmentTypeId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__price, o.getPrice())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__update_person, o.getUpdatePerson())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEquipmentTypeId() != null) sb.append(__wrapNumber(count++, "equipmentTypeId", getEquipmentTypeId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getPrice() != null) sb.append(__wrapDecimal(count++, "price", getPrice()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		if(getFlag() != null) sb.append(__wrapBoolean(count++, "flag", getFlag()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getUpdatePerson() != null) sb.append(__wrapNumber(count++, "updatePerson", getUpdatePerson()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getDetailMequipmentrecordedeor() != null)  sb.append(__wrapList(count++, "detailMequipmentrecordedeor", getDetailMequipmentrecordedeor()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEquipmentTypeId() != null) res.put("equipmentTypeId", getEquipmentTypeId());
		if(getName() != null) res.put("name", getName());
		if(getType() != null) res.put("type", getType());
		if(getPrice() != null) res.put("price", getPrice());
		if(getCount() != null) res.put("count", getCount());
		if(getFlag() != null) res.put("flag", getFlag());
		if(getUpdateTime() != null) res.put("updateTime", getUpdateTime());
		if(getUpdatePerson() != null) res.put("updatePerson", getUpdatePerson());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentName() != null) res.put("departmentName", getDepartmentName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("equipmentTypeId")) != null) setEquipmentTypeId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("price")) != null) setPrice(__getDecimal(val));  
		if((val = values.get("count")) != null) setCount(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getBoolean(val));
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("updatePerson")) != null) setUpdatePerson(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("detailMequipmentrecordedeor")) != null) setDetailMequipmentrecordedeor(__getList(val, BaseMequipmentrecordedeor.newInstance()));
	}

	protected Integer  __equipment_type_id ;
	protected String  __name ;
	protected Integer  __type ;
	protected java.math.BigDecimal  __price ;
	protected Integer  __count ;
	protected Boolean  __flag ;
	protected java.util.Date  __update_time ;
	protected Integer  __update_person ;
	protected String  __employee_name ;
	protected String  __department_name ;
	protected java.util.List<BaseMequipmentrecordedeor> __detailMequipmentrecordedeor = null;
}
