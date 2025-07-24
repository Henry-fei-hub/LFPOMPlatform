package pomplatform.operation.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectemployeeepor extends GenericBase implements BaseFactory<BaseMprojectemployeeepor>, Comparable<BaseMprojectemployeeepor> 
{


	public static BaseMprojectemployeeepor newInstance(){
		return new BaseMprojectemployeeepor();
	}

	@Override
	public BaseMprojectemployeeepor make(){
		BaseMprojectemployeeepor b = new BaseMprojectemployeeepor();
		return b;
	}

	public final static java.lang.String CS_PHOTO = "photo" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_WORK_CONTENT = "work_content" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_REAL_INTEGRAL = "real_integral" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_SETTLEMENT = "settlement" ;

	public final static java.lang.String ALL_CAPTIONS = "头像,员工编码,工作内容,实际开始日期,实际结束日期,,状态,,,";

	public java.lang.String getPhoto() {
		return this.__photo;
	}

	public void setPhoto( java.lang.String value ) {
		this.__photo = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getWorkContent() {
		return this.__work_content;
	}

	public void setWorkContent( java.lang.String value ) {
		this.__work_content = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getRealIntegral() {
		return this.__real_integral;
	}

	public void setRealIntegral( java.math.BigDecimal value ) {
		this.__real_integral = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public java.math.BigDecimal getSettlement() {
		return this.__settlement;
	}

	public void setSettlement( java.math.BigDecimal value ) {
		this.__settlement = value;
	}

	public void cloneCopy(BaseMprojectemployeeepor __bean){
		__bean.setPhoto(getPhoto());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setWorkContent(getWorkContent());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setIntegral(getIntegral());
		__bean.setStatus(getStatus());
		__bean.setRealIntegral(getRealIntegral());
		__bean.setCost(getCost());
		__bean.setSettlement(getSettlement());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPhoto() == null ? "" : getPhoto());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getWorkContent() == null ? "" : getWorkContent());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getRealIntegral() == null ? "" : getRealIntegral());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		sb.append(",");
		sb.append(getSettlement() == null ? "" : getSettlement());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectemployeeepor o) {
		return __photo == null ? -1 : __photo.compareTo(o.getPhoto());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__photo);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__work_content);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__real_integral);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__settlement);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectemployeeepor o = (BaseMprojectemployeeepor)obj;
		if(!Objects.equals(this.__photo, o.getPhoto())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__work_content, o.getWorkContent())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__real_integral, o.getRealIntegral())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__settlement, o.getSettlement())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPhoto() != null) sb.append(__wrapString(count++, "photo", getPhoto()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getWorkContent() != null) sb.append(__wrapString(count++, "workContent", getWorkContent()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getRealIntegral() != null) sb.append(__wrapDecimal(count++, "realIntegral", getRealIntegral()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getSettlement() != null) sb.append(__wrapDecimal(count++, "settlement", getSettlement()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("photo")) != null) setPhoto(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("workContent")) != null) setWorkContent(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("realIntegral")) != null) setRealIntegral(__getDecimal(val));  
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("settlement")) != null) setSettlement(__getDecimal(val));  
	}

	protected java.lang.String  __photo ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __work_content ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __integral ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __real_integral ;
	protected java.math.BigDecimal  __cost ;
	protected java.math.BigDecimal  __settlement ;
}
