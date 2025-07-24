package pomplatform.workflow.purchase.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import com.pomplatform.db.bean.BaseProductInquiryDetail;

public class BaseSproductinquirytotalpor extends GenericBase implements BaseFactory<BaseSproductinquirytotalpor>, Comparable<BaseSproductinquirytotalpor> 
{


	public static BaseSproductinquirytotalpor newInstance(){
		return new BaseSproductinquirytotalpor();
	}

	@Override
	public BaseSproductinquirytotalpor make(){
		BaseSproductinquirytotalpor b = new BaseSproductinquirytotalpor();
		return b;
	}

	public final static java.lang.String CS_PRODUCT_INQUIRY_TOTAL_ID = "product_inquiry_total_id" ;
	public final static java.lang.String CS_MAJOR_TITLE = "major_title" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,主题,流程类型,事由,申请人工号,申请人部门,创建人,创建时间,删除状态 0未删除 1已删除,备注";

	public java.lang.Integer getProductInquiryTotalId() {
		return this.__product_inquiry_total_id;
	}

	public void setProductInquiryTotalId( java.lang.Integer value ) {
		this.__product_inquiry_total_id = value;
	}

	public java.lang.String getMajorTitle() {
		return this.__major_title;
	}

	public void setMajorTitle( java.lang.String value ) {
		this.__major_title = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.List<BaseProductInquiryDetail> getDetailProductInquiryDetail() {
		return this.__detailProductInquiryDetail;
	}

	public void setDetailProductInquiryDetail( java.util.List<BaseProductInquiryDetail> value ) {
		this.__detailProductInquiryDetail = value;
	}

	public void cloneCopy(BaseSproductinquirytotalpor __bean){
		__bean.setProductInquiryTotalId(getProductInquiryTotalId());
		__bean.setMajorTitle(getMajorTitle());
		__bean.setProcessType(getProcessType());
		__bean.setReason(getReason());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductInquiryTotalId() == null ? "" : getProductInquiryTotalId());
		sb.append(",");
		sb.append(getMajorTitle() == null ? "" : getMajorTitle());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSproductinquirytotalpor o) {
		return __product_inquiry_total_id == null ? -1 : __product_inquiry_total_id.compareTo(o.getProductInquiryTotalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__product_inquiry_total_id);
		hash = 97 * hash + Objects.hashCode(this.__major_title);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSproductinquirytotalpor o = (BaseSproductinquirytotalpor)obj;
		if(!Objects.equals(this.__product_inquiry_total_id, o.getProductInquiryTotalId())) return false;
		if(!Objects.equals(this.__major_title, o.getMajorTitle())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductInquiryTotalId() != null) sb.append(__wrapNumber(count++, "productInquiryTotalId", getProductInquiryTotalId()));
		if(getMajorTitle() != null) sb.append(__wrapString(count++, "majorTitle", getMajorTitle()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getDetailProductInquiryDetail() != null)  sb.append(__wrapList(count++, "detailProductInquiryDetail", getDetailProductInquiryDetail()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productInquiryTotalId")) != null) setProductInquiryTotalId(__getInt(val)); 
		if((val = values.get("majorTitle")) != null) setMajorTitle(__getString(val));
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("detailProductInquiryDetail")) != null) setDetailProductInquiryDetail(__getList(val, BaseProductInquiryDetail.newInstance()));
	}

	protected java.lang.Integer  __product_inquiry_total_id ;
	protected java.lang.String  __major_title ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.String  __reason ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.String  __remark ;
	protected java.util.List<BaseProductInquiryDetail> __detailProductInquiryDetail = null;
}
