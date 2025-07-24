package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOnLoadStandardQuoteData extends GenericBase implements BaseFactory<BaseOnLoadStandardQuoteData>, Comparable<BaseOnLoadStandardQuoteData> 
{


	public static BaseOnLoadStandardQuoteData newInstance(){
		return new BaseOnLoadStandardQuoteData();
	}

	@Override
	public BaseOnLoadStandardQuoteData make(){
		BaseOnLoadStandardQuoteData b = new BaseOnLoadStandardQuoteData();
		return b;
	}

	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static java.lang.String CS_PROJECT_BASE_ON = "project_base_on" ;
	public final static java.lang.String CS_BID_TYPE = "bid_type" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_AREA = "area" ;
	public final static java.lang.String CS_CLIENT_NAME = "client_name" ;
	public final static java.lang.String CS_SAME_PERCENT = "same_percent" ;
	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_AREA_LEVEL = "area_level" ;

	public final static java.lang.String ALL_CAPTIONS = "信息编号,项目编号,项目名称,业务类别,立项时间,立项依据,投标结果,省份,城市,项目等级,金额,面积,联系人姓名,相似度,报价单表编码,等级(1一线，2二线，3三线)";

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.lang.Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( java.lang.Integer value ) {
		this.__project_base_on = value;
	}

	public java.lang.Integer getBidType() {
		return this.__bid_type;
	}

	public void setBidType( java.lang.Integer value ) {
		this.__bid_type = value;
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

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.math.BigDecimal getArea() {
		return this.__area;
	}

	public void setArea( java.math.BigDecimal value ) {
		this.__area = value;
	}

	public java.lang.String getClientName() {
		return this.__client_name;
	}

	public void setClientName( java.lang.String value ) {
		this.__client_name = value;
	}

	public java.math.BigDecimal getSamePercent() {
		return this.__same_percent;
	}

	public void setSamePercent( java.math.BigDecimal value ) {
		this.__same_percent = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.Integer getAreaLevel() {
		return this.__area_level;
	}

	public void setAreaLevel( java.lang.Integer value ) {
		this.__area_level = value;
	}

	public void cloneCopy(BaseOnLoadStandardQuoteData __bean){
		__bean.setInfoCode(getInfoCode());
		__bean.setProjectCode(getProjectCode());
		__bean.setProjectName(getProjectName());
		__bean.setBusinessType(getBusinessType());
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setProjectBaseOn(getProjectBaseOn());
		__bean.setBidType(getBidType());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setMoneySum(getMoneySum());
		__bean.setArea(getArea());
		__bean.setClientName(getClientName());
		__bean.setSamePercent(getSamePercent());
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setAreaLevel(getAreaLevel());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		sb.append(getProjectBaseOn() == null ? "" : getProjectBaseOn());
		sb.append(",");
		sb.append(getBidType() == null ? "" : getBidType());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getArea() == null ? "" : getArea());
		sb.append(",");
		sb.append(getClientName() == null ? "" : getClientName());
		sb.append(",");
		sb.append(getSamePercent() == null ? "" : getSamePercent());
		sb.append(",");
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getAreaLevel() == null ? "" : getAreaLevel());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadStandardQuoteData o) {
		int i = o.getSamePercent().compareTo(__same_percent);//先按照相似度排序 
		if(i == 0){  
			return o.getProjectApprovalTime().compareTo(__project_approval_time);//如果相似度相等，则按立项时间排序
		}  
		return i;  
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__project_base_on);
		hash = 97 * hash + Objects.hashCode(this.__bid_type);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__area);
		hash = 97 * hash + Objects.hashCode(this.__client_name);
		hash = 97 * hash + Objects.hashCode(this.__same_percent);
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__area_level);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadStandardQuoteData o = (BaseOnLoadStandardQuoteData)obj;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__project_base_on, o.getProjectBaseOn())) return false;
		if(!Objects.equals(this.__bid_type, o.getBidType())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__area, o.getArea())) return false;
		if(!Objects.equals(this.__client_name, o.getClientName())) return false;
		if(!Objects.equals(this.__same_percent, o.getSamePercent())) return false;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__area_level, o.getAreaLevel())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(count++, "projectBaseOn", getProjectBaseOn()));
		if(getBidType() != null) sb.append(__wrapNumber(count++, "bidType", getBidType()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getArea() != null) sb.append(__wrapDecimal(count++, "area", getArea()));
		if(getClientName() != null) sb.append(__wrapString(count++, "clientName", getClientName()));
		if(getSamePercent() != null) sb.append(__wrapDecimal(count++, "samePercent", getSamePercent()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getAreaLevel() != null) sb.append(__wrapNumber(count++, "areaLevel", getAreaLevel()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val)); 
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("bidType")) != null) setBidType(__getInt(val)); 
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("area")) != null) setArea(__getDecimal(val));  
		if((val = values.get("clientName")) != null) setClientName(__getString(val));
		if((val = values.get("samePercent")) != null) setSamePercent(__getDecimal(val));  
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("areaLevel")) != null) setAreaLevel(__getInt(val)); 
	}

	protected java.lang.String  __info_code ;
	protected java.lang.String  __project_code ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __business_type ;
	protected java.util.Date  __project_approval_time ;
	protected java.lang.Integer  __project_base_on ;
	protected java.lang.Integer  __bid_type ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.Integer  __project_level ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.math.BigDecimal  __area ;
	protected java.lang.String  __client_name ;
	protected java.math.BigDecimal  __same_percent ;
	protected java.lang.Integer  __out_quotation_id ;
	protected java.lang.Integer  __area_level ;
}
