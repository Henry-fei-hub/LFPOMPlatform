package pomplatform.company.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSheetTotalByProjectType extends GenericBase implements BaseFactory<BaseSheetTotalByProjectType>, Comparable<BaseSheetTotalByProjectType> 
{


	public static BaseSheetTotalByProjectType newInstance(){
		return new BaseSheetTotalByProjectType();
	}

	@Override
	public BaseSheetTotalByProjectType make(){
		BaseSheetTotalByProjectType b = new BaseSheetTotalByProjectType();
		return b;
	}

	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_SHEET_TOTAL_INTEGRAL = "sheet_total_integral" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_SHEET_INTEGRAL = "sheet_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "项目类型,订单总积分,投诉保证金,订单积分";

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.math.BigDecimal getSheetTotalIntegral() {
		return this.__sheet_total_integral;
	}

	public void setSheetTotalIntegral( java.math.BigDecimal value ) {
		this.__sheet_total_integral = value;
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return this.__complaint_integral;
	}

	public void setComplaintIntegral( java.math.BigDecimal value ) {
		this.__complaint_integral = value;
	}

	public java.math.BigDecimal getSheetIntegral() {
		return this.__sheet_integral;
	}

	public void setSheetIntegral( java.math.BigDecimal value ) {
		this.__sheet_integral = value;
	}

	public void cloneCopy(BaseSheetTotalByProjectType __bean){
		__bean.setProjectType(getProjectType());
		__bean.setSheetTotalIntegral(getSheetTotalIntegral());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setSheetIntegral(getSheetIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getProjectType()));
		sb.append(strProjectType == null ? "" : strProjectType);
		sb.append(",");
		sb.append(getSheetTotalIntegral() == null ? "" : getSheetTotalIntegral());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getSheetIntegral() == null ? "" : getSheetIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSheetTotalByProjectType o) {
		return __project_type == null ? -1 : __project_type.compareTo(o.getProjectType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__sheet_total_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__sheet_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSheetTotalByProjectType o = (BaseSheetTotalByProjectType)obj;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__sheet_total_integral, o.getSheetTotalIntegral())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__sheet_integral, o.getSheetIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectType() != null) sb.append(__wrapNumber(count++, "projectType", getProjectType()));
		if(getSheetTotalIntegral() != null) sb.append(__wrapDecimal(count++, "sheetTotalIntegral", getSheetTotalIntegral()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getSheetIntegral() != null) sb.append(__wrapDecimal(count++, "sheetIntegral", getSheetIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("sheetTotalIntegral")) != null) setSheetTotalIntegral(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("sheetIntegral")) != null) setSheetIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_type ;
	protected java.math.BigDecimal  __sheet_total_integral ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.math.BigDecimal  __sheet_integral ;
}
