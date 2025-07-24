package pomplatform.goodsreceive.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGoodsreceivedetail extends GenericBase implements BaseFactory<BaseGoodsreceivedetail>, Comparable<BaseGoodsreceivedetail> 
{


	public static BaseGoodsreceivedetail newInstance(){
		return new BaseGoodsreceivedetail();
	}

	@Override
	public BaseGoodsreceivedetail make(){
		BaseGoodsreceivedetail b = new BaseGoodsreceivedetail();
		return b;
	}

	public final static java.lang.String CS_GOODS_RECEIVE_DETAIL_ID = "goods_receive_detail_id" ;
	public final static java.lang.String CS_GOODS_RECEIVE_ID = "goods_receive_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NUMBER = "employee_number" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RECEIVE_TIME = "receive_time" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_IS_RECEIVE = "is_receive" ;
	public final static java.lang.String CS_RECEIVE_COUNT = "receive_count" ;

	public final static java.lang.String ALL_CAPTIONS = "主键ID,物品领用ID,领用人ID,领用人的工号,部门,领用的时间,领用人姓名,是否已经领用,领取数量";

	public java.lang.Integer getGoodsReceiveDetailId() {
		return this.__goods_receive_detail_id;
	}

	public void setGoodsReceiveDetailId( java.lang.Integer value ) {
		this.__goods_receive_detail_id = value;
	}

	public java.lang.Integer getGoodsReceiveId() {
		return this.__goods_receive_id;
	}

	public void setGoodsReceiveId( java.lang.Integer value ) {
		this.__goods_receive_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNumber() {
		return this.__employee_number;
	}

	public void setEmployeeNumber( java.lang.String value ) {
		this.__employee_number = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getReceiveTime() {
		return this.__receive_time;
	}

	public void setReceiveTime( java.util.Date value ) {
		this.__receive_time = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getIsReceive() {
		return this.__is_receive;
	}

	public void setIsReceive( java.lang.Integer value ) {
		this.__is_receive = value;
	}

	public java.lang.Long getReceiveCount() {
		return this.__receive_count;
	}

	public void setReceiveCount( java.lang.Long value ) {
		this.__receive_count = value;
	}

	public void cloneCopy(BaseGoodsreceivedetail __bean){
		__bean.setGoodsReceiveDetailId(getGoodsReceiveDetailId());
		__bean.setGoodsReceiveId(getGoodsReceiveId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNumber(getEmployeeNumber());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setReceiveTime(getReceiveTime());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setIsReceive(getIsReceive());
		__bean.setReceiveCount(getReceiveCount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getGoodsReceiveDetailId() == null ? "" : getGoodsReceiveDetailId());
		sb.append(",");
		sb.append(getGoodsReceiveId() == null ? "" : getGoodsReceiveId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNumber() == null ? "" : getEmployeeNumber());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getReceiveTime() == null ? "" : sdf.format(getReceiveTime()));
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getIsReceive() == null ? "" : getIsReceive());
		sb.append(",");
		sb.append(getReceiveCount() == null ? "" : getReceiveCount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGoodsreceivedetail o) {
		return __goods_receive_detail_id == null ? -1 : __goods_receive_detail_id.compareTo(o.getGoodsReceiveDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__goods_receive_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__goods_receive_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_number);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__receive_time);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__is_receive);
		hash = 97 * hash + Objects.hashCode(this.__receive_count);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGoodsreceivedetail o = (BaseGoodsreceivedetail)obj;
		if(!Objects.equals(this.__goods_receive_detail_id, o.getGoodsReceiveDetailId())) return false;
		if(!Objects.equals(this.__goods_receive_id, o.getGoodsReceiveId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_number, o.getEmployeeNumber())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__receive_time, o.getReceiveTime())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__is_receive, o.getIsReceive())) return false;
		if(!Objects.equals(this.__receive_count, o.getReceiveCount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getGoodsReceiveDetailId() != null) sb.append(__wrapNumber(count++, "goodsReceiveDetailId", getGoodsReceiveDetailId()));
		if(getGoodsReceiveId() != null) sb.append(__wrapNumber(count++, "goodsReceiveId", getGoodsReceiveId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNumber() != null) sb.append(__wrapString(count++, "employeeNumber", getEmployeeNumber()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getReceiveTime() != null) sb.append(__wrapDate(count++, "receiveTime", getReceiveTime()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getIsReceive() != null) sb.append(__wrapNumber(count++, "isReceive", getIsReceive()));
		if(getReceiveCount() != null) sb.append(__wrapNumber(count++, "receiveCount", getReceiveCount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("goodsReceiveDetailId")) != null) setGoodsReceiveDetailId(__getInt(val)); 
		if((val = values.get("goodsReceiveId")) != null) setGoodsReceiveId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNumber")) != null) setEmployeeNumber(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("receiveTime")) != null) setReceiveTime(__getDate(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("isReceive")) != null) setIsReceive(__getInt(val)); 
		if((val = values.get("receiveCount")) != null) setReceiveCount(__getLong(val)); 
	}

	protected java.lang.Integer  __goods_receive_detail_id ;
	protected java.lang.Integer  __goods_receive_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_number ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __receive_time ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __is_receive ;
	protected java.lang.Long  __receive_count ;
}
