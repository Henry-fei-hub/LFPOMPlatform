package pomplatform.OnRevenue.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnBusinessStateOfRevenue extends GenericBase implements BaseFactory<BaseOnBusinessStateOfRevenue>, Comparable<BaseOnBusinessStateOfRevenue> 
{


	public static BaseOnBusinessStateOfRevenue newInstance(){
		return new BaseOnBusinessStateOfRevenue();
	}

	@Override
	public BaseOnBusinessStateOfRevenue make(){
		BaseOnBusinessStateOfRevenue b = new BaseOnBusinessStateOfRevenue();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_BUSINESS_CODE = "business_code" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_BUSINESS_INTEGRAL = "business_integral" ;
	public final static java.lang.String CS_SIGNING_COMPANY = "signing_company" ;
	public final static java.lang.String CS_FINISH_PERCENT = "finish_percent" ;
	public final static java.lang.String CS_FINISH_PERCENT_DETAIL = "finish_percent_detail" ;

	public final static java.lang.String ALL_CAPTIONS = "合同编号,业态编号,业态名称,总金额,签约公司,完工比,完工比明细";

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getBusinessCode() {
		return this.__business_code;
	}

	public void setBusinessCode( java.lang.String value ) {
		this.__business_code = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.math.BigDecimal getBusinessIntegral() {
		return this.__business_integral;
	}

	public void setBusinessIntegral( java.math.BigDecimal value ) {
		this.__business_integral = value;
	}

	public java.lang.Integer getSigningCompany() {
		return this.__signing_company;
	}

	public void setSigningCompany( java.lang.Integer value ) {
		this.__signing_company = value;
	}

	public java.math.BigDecimal getFinishPercent() {
		return this.__finish_percent;
	}

	public void setFinishPercent( java.math.BigDecimal value ) {
		this.__finish_percent = value;
	}

	public java.math.BigDecimal getFinishPercentDetail() {
		return this.__finish_percent_detail;
	}

	public void setFinishPercentDetail( java.math.BigDecimal value ) {
		this.__finish_percent_detail = value;
	}

	public void cloneCopy(BaseOnBusinessStateOfRevenue __bean){
		__bean.setContractCode(getContractCode());
		__bean.setBusinessCode(getBusinessCode());
		__bean.setBusinessName(getBusinessName());
		__bean.setBusinessIntegral(getBusinessIntegral());
		__bean.setSigningCompany(getSigningCompany());
		__bean.setFinishPercent(getFinishPercent());
		__bean.setFinishPercentDetail(getFinishPercentDetail());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strContractCode = delicacy.system.executor.SelectValueCache.getSelectValue("contracts", String.valueOf(getContractCode()));
		sb.append(strContractCode == null ? "" : strContractCode);
		sb.append(",");
		sb.append(getBusinessCode() == null ? "" : getBusinessCode());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getBusinessIntegral() == null ? "" : getBusinessIntegral());
		sb.append(",");
		String strSigningCompany = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSigningCompany()));
		sb.append(strSigningCompany == null ? "" : strSigningCompany);
		sb.append(",");
		sb.append(getFinishPercent() == null ? "" : getFinishPercent());
		sb.append(",");
		sb.append(getFinishPercentDetail() == null ? "" : getFinishPercentDetail());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnBusinessStateOfRevenue o) {
		return __contract_code == null ? -1 : __contract_code.compareTo(o.getContractCode());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__business_code);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__business_integral);
		hash = 97 * hash + Objects.hashCode(this.__signing_company);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent_detail);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnBusinessStateOfRevenue o = (BaseOnBusinessStateOfRevenue)obj;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__business_code, o.getBusinessCode())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__business_integral, o.getBusinessIntegral())) return false;
		if(!Objects.equals(this.__signing_company, o.getSigningCompany())) return false;
		if(!Objects.equals(this.__finish_percent, o.getFinishPercent())) return false;
		if(!Objects.equals(this.__finish_percent_detail, o.getFinishPercentDetail())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getBusinessCode() != null) sb.append(__wrapString(count++, "businessCode", getBusinessCode()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getBusinessIntegral() != null) sb.append(__wrapDecimal(count++, "businessIntegral", getBusinessIntegral()));
		if(getSigningCompany() != null) sb.append(__wrapNumber(count++, "signingCompany", getSigningCompany()));
		if(getFinishPercent() != null) sb.append(__wrapDecimal(count++, "finishPercent", getFinishPercent()));
		if(getFinishPercentDetail() != null) sb.append(__wrapDecimal(count++, "finishPercentDetail", getFinishPercentDetail()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("businessCode")) != null) setBusinessCode(__getString(val));
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("businessIntegral")) != null) setBusinessIntegral(__getDecimal(val));  
		if((val = values.get("signingCompany")) != null) setSigningCompany(__getInt(val)); 
		if((val = values.get("finishPercent")) != null) setFinishPercent(__getDecimal(val));  
		if((val = values.get("finishPercentDetail")) != null) setFinishPercentDetail(__getDecimal(val));  
	}

	protected java.lang.String  __contract_code ;
	protected java.lang.String  __business_code ;
	protected java.lang.String  __business_name ;
	protected java.math.BigDecimal  __business_integral ;
	protected java.lang.Integer  __signing_company ;
	protected java.math.BigDecimal  __finish_percent ;
	protected java.math.BigDecimal  __finish_percent_detail ;
}
