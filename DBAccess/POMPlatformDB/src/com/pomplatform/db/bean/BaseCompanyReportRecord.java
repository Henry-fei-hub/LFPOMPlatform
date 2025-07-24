package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompanyReportRecord extends GenericBase implements BaseFactory<BaseCompanyReportRecord>, Comparable<BaseCompanyReportRecord> 
{


	public static BaseCompanyReportRecord newInstance(){
		return new BaseCompanyReportRecord();
	}

	@Override
	public BaseCompanyReportRecord make(){
		BaseCompanyReportRecord b = new BaseCompanyReportRecord();
		return b;
	}

	public final static java.lang.String CS_COMPANY_REPORT_RECORD_ID = "company_report_record_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_SHEET_TOTAL_INTEGRAL = "sheet_total_integral" ;
	public final static java.lang.String CS_COMPANY_SUBSIDY = "company_subsidy" ;
	public final static java.lang.String CS_WIN_INTEGRAL = "win_integral" ;
	public final static java.lang.String CS_COMPLAINT_INTEGRAL = "complaint_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL_EXTRACT = "project_integral_extract" ;
	public final static java.lang.String CS_AWARD_SEND = "award_send" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,比率,账户余额,合同总额,订单总积分,公司补贴,中标奖金,投诉保证金,项目积分提取,奖金发放";

	public java.lang.Integer getCompanyReportRecordId() {
		return this.__company_report_record_id;
	}

	public void setCompanyReportRecordId( java.lang.Integer value ) {
		this.__company_report_record_id = value;
	}

	public java.lang.String getPercent() {
		return this.__percent;
	}

	public void setPercent( java.lang.String value ) {
		this.__percent = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.math.BigDecimal getSheetTotalIntegral() {
		return this.__sheet_total_integral;
	}

	public void setSheetTotalIntegral( java.math.BigDecimal value ) {
		this.__sheet_total_integral = value;
	}

	public java.math.BigDecimal getCompanySubsidy() {
		return this.__company_subsidy;
	}

	public void setCompanySubsidy( java.math.BigDecimal value ) {
		this.__company_subsidy = value;
	}

	public java.math.BigDecimal getWinIntegral() {
		return this.__win_integral;
	}

	public void setWinIntegral( java.math.BigDecimal value ) {
		this.__win_integral = value;
	}

	public java.math.BigDecimal getComplaintIntegral() {
		return this.__complaint_integral;
	}

	public void setComplaintIntegral( java.math.BigDecimal value ) {
		this.__complaint_integral = value;
	}

	public java.math.BigDecimal getProjectIntegralExtract() {
		return this.__project_integral_extract;
	}

	public void setProjectIntegralExtract( java.math.BigDecimal value ) {
		this.__project_integral_extract = value;
	}

	public java.math.BigDecimal getAwardSend() {
		return this.__award_send;
	}

	public void setAwardSend( java.math.BigDecimal value ) {
		this.__award_send = value;
	}

	public void cloneCopy(BaseCompanyReportRecord __bean){
		__bean.setCompanyReportRecordId(getCompanyReportRecordId());
		__bean.setPercent(getPercent());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setSheetTotalIntegral(getSheetTotalIntegral());
		__bean.setCompanySubsidy(getCompanySubsidy());
		__bean.setWinIntegral(getWinIntegral());
		__bean.setComplaintIntegral(getComplaintIntegral());
		__bean.setProjectIntegralExtract(getProjectIntegralExtract());
		__bean.setAwardSend(getAwardSend());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyReportRecordId() == null ? "" : getCompanyReportRecordId());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getSheetTotalIntegral() == null ? "" : getSheetTotalIntegral());
		sb.append(",");
		sb.append(getCompanySubsidy() == null ? "" : getCompanySubsidy());
		sb.append(",");
		sb.append(getWinIntegral() == null ? "" : getWinIntegral());
		sb.append(",");
		sb.append(getComplaintIntegral() == null ? "" : getComplaintIntegral());
		sb.append(",");
		sb.append(getProjectIntegralExtract() == null ? "" : getProjectIntegralExtract());
		sb.append(",");
		sb.append(getAwardSend() == null ? "" : getAwardSend());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyReportRecord o) {
		return __company_report_record_id == null ? -1 : __company_report_record_id.compareTo(o.getCompanyReportRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_report_record_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__sheet_total_integral);
		hash = 97 * hash + Objects.hashCode(this.__company_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__win_integral);
		hash = 97 * hash + Objects.hashCode(this.__complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral_extract);
		hash = 97 * hash + Objects.hashCode(this.__award_send);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyReportRecord o = (BaseCompanyReportRecord)obj;
		if(!Objects.equals(this.__company_report_record_id, o.getCompanyReportRecordId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__sheet_total_integral, o.getSheetTotalIntegral())) return false;
		if(!Objects.equals(this.__company_subsidy, o.getCompanySubsidy())) return false;
		if(!Objects.equals(this.__win_integral, o.getWinIntegral())) return false;
		if(!Objects.equals(this.__complaint_integral, o.getComplaintIntegral())) return false;
		if(!Objects.equals(this.__project_integral_extract, o.getProjectIntegralExtract())) return false;
		if(!Objects.equals(this.__award_send, o.getAwardSend())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyReportRecordId() != null) sb.append(__wrapNumber(count++, "companyReportRecordId", getCompanyReportRecordId()));
		if(getPercent() != null) sb.append(__wrapString(count++, "percent", getPercent()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getSheetTotalIntegral() != null) sb.append(__wrapDecimal(count++, "sheetTotalIntegral", getSheetTotalIntegral()));
		if(getCompanySubsidy() != null) sb.append(__wrapDecimal(count++, "companySubsidy", getCompanySubsidy()));
		if(getWinIntegral() != null) sb.append(__wrapDecimal(count++, "winIntegral", getWinIntegral()));
		if(getComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "complaintIntegral", getComplaintIntegral()));
		if(getProjectIntegralExtract() != null) sb.append(__wrapDecimal(count++, "projectIntegralExtract", getProjectIntegralExtract()));
		if(getAwardSend() != null) sb.append(__wrapDecimal(count++, "awardSend", getAwardSend()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyReportRecordId")) != null) setCompanyReportRecordId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getString(val));
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("sheetTotalIntegral")) != null) setSheetTotalIntegral(__getDecimal(val));  
		if((val = values.get("companySubsidy")) != null) setCompanySubsidy(__getDecimal(val));  
		if((val = values.get("winIntegral")) != null) setWinIntegral(__getDecimal(val));  
		if((val = values.get("complaintIntegral")) != null) setComplaintIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegralExtract")) != null) setProjectIntegralExtract(__getDecimal(val));  
		if((val = values.get("awardSend")) != null) setAwardSend(__getDecimal(val));  
	}

	protected java.lang.Integer  __company_report_record_id ;
	protected java.lang.String  __percent ;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.math.BigDecimal  __sheet_total_integral ;
	protected java.math.BigDecimal  __company_subsidy ;
	protected java.math.BigDecimal  __win_integral ;
	protected java.math.BigDecimal  __complaint_integral ;
	protected java.math.BigDecimal  __project_integral_extract ;
	protected java.math.BigDecimal  __award_send ;
}
