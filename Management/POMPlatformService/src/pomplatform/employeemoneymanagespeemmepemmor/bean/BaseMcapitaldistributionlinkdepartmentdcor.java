package pomplatform.employeemoneymanagespeemmepemmor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcapitaldistributionlinkdepartmentdcor extends GenericBase implements BaseFactory<BaseMcapitaldistributionlinkdepartmentdcor>, Comparable<BaseMcapitaldistributionlinkdepartmentdcor> 
{


	public static BaseMcapitaldistributionlinkdepartmentdcor newInstance(){
		return new BaseMcapitaldistributionlinkdepartmentdcor();
	}

	@Override
	public BaseMcapitaldistributionlinkdepartmentdcor make(){
		BaseMcapitaldistributionlinkdepartmentdcor b = new BaseMcapitaldistributionlinkdepartmentdcor();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_LINK_DEPARTMENT_ID = "capital_distribution_link_department_id" ;
	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_ID = "capital_distribution_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_DEPARTMENT_NAME = "department_name" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,回款分配编码,部门编码,金额,部门名称,收款主键(手动分配回款使用),创建时间";

	public java.lang.Integer getCapitalDistributionLinkDepartmentId() {
		return this.__capital_distribution_link_department_id;
	}

	public void setCapitalDistributionLinkDepartmentId( java.lang.Integer value ) {
		this.__capital_distribution_link_department_id = value;
	}

	public java.lang.Integer getCapitalDistributionId() {
		return this.__capital_distribution_id;
	}

	public void setCapitalDistributionId( java.lang.Integer value ) {
		this.__capital_distribution_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.lang.String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BaseMcapitaldistributionlinkdepartmentdcor __bean){
		__bean.setCapitalDistributionLinkDepartmentId(getCapitalDistributionLinkDepartmentId());
		__bean.setCapitalDistributionId(getCapitalDistributionId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setMoney(getMoney());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setCapitalId(getCapitalId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCapitalDistributionLinkDepartmentId() == null ? "" : getCapitalDistributionLinkDepartmentId());
		sb.append(",");
		sb.append(getCapitalDistributionId() == null ? "" : getCapitalDistributionId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcapitaldistributionlinkdepartmentdcor o) {
		return __capital_distribution_link_department_id == null ? -1 : __capital_distribution_link_department_id.compareTo(o.getCapitalDistributionLinkDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_link_department_id);
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcapitaldistributionlinkdepartmentdcor o = (BaseMcapitaldistributionlinkdepartmentdcor)obj;
		if(!Objects.equals(this.__capital_distribution_link_department_id, o.getCapitalDistributionLinkDepartmentId())) return false;
		if(!Objects.equals(this.__capital_distribution_id, o.getCapitalDistributionId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalDistributionLinkDepartmentId() != null) sb.append(__wrapNumber(count++, "capitalDistributionLinkDepartmentId", getCapitalDistributionLinkDepartmentId()));
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(count++, "capitalDistributionId", getCapitalDistributionId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalDistributionLinkDepartmentId")) != null) setCapitalDistributionLinkDepartmentId(__getInt(val)); 
		if((val = values.get("capitalDistributionId")) != null) setCapitalDistributionId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __capital_distribution_link_department_id ;
	protected java.lang.Integer  __capital_distribution_id ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __money ;
	protected java.lang.String  __department_name ;
	protected java.lang.Integer  __capital_id ;
	protected java.util.Date  __create_time ;
}
