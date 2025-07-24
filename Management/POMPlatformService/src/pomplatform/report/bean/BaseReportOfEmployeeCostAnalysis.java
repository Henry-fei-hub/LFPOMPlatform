package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOfEmployeeCostAnalysis extends GenericBase implements BaseFactory<BaseReportOfEmployeeCostAnalysis>, Comparable<BaseReportOfEmployeeCostAnalysis> 
{


	public static BaseReportOfEmployeeCostAnalysis newInstance(){
		return new BaseReportOfEmployeeCostAnalysis();
	}

	@Override
	public BaseReportOfEmployeeCostAnalysis make(){
		BaseReportOfEmployeeCostAnalysis b = new BaseReportOfEmployeeCostAnalysis();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_COST_ANALYSIS_ID = "employee_cost_analysis_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_THIS_MONTH_PAY = "this_month_pay" ;
	public final static java.lang.String CS_LAST_MONTH_PAY = "last_month_pay" ;
	public final static java.lang.String CS_PAY_RAISE = "pay_raise" ;
	public final static java.lang.String CS_THIS_MONTH_INSURANCE = "this_month_insurance" ;
	public final static java.lang.String CS_LAST_MONTH_INSURANCE = "last_month_insurance" ;
	public final static java.lang.String CS_INSURANCE_RAISE = "insurance_raise" ;
	public final static java.lang.String CS_PAY_REMARK = "pay_remark" ;
	public final static java.lang.String CS_INSURANCE_REMARK = "insurance_remark" ;
	public final static java.lang.String CS_IS_LOCKED = "is_locked" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,年份,月份,本月应付工资,上月应付工资,工资涨幅,本月社保公积金,上月社保公积金,社保公积金涨幅,工资说明,社保公积金说明,是否加锁,操作人,操作时间,备注";
	public final static java.lang.String DOWNLOAD_CAPTIONS = "业务部门,年份,月份,本月应付工资,上月应付工资,工资涨幅,本月社保公积金,上月社保公积金,社保公积金涨幅,工资说明,社保公积金说明";
	
	public java.lang.Integer getEmployeeCostAnalysisId() {
		return this.__employee_cost_analysis_id;
	}

	public void setEmployeeCostAnalysisId( java.lang.Integer value ) {
		this.__employee_cost_analysis_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getThisMonthPay() {
		return this.__this_month_pay;
	}

	public void setThisMonthPay( java.math.BigDecimal value ) {
		this.__this_month_pay = value;
	}

	public java.math.BigDecimal getLastMonthPay() {
		return this.__last_month_pay;
	}

	public void setLastMonthPay( java.math.BigDecimal value ) {
		this.__last_month_pay = value;
	}

	public java.lang.String getPayRaise() {
		return this.__pay_raise;
	}

	public void setPayRaise( java.lang.String value ) {
		this.__pay_raise = value;
	}

	public java.math.BigDecimal getThisMonthInsurance() {
		return this.__this_month_insurance;
	}

	public void setThisMonthInsurance( java.math.BigDecimal value ) {
		this.__this_month_insurance = value;
	}

	public java.math.BigDecimal getLastMonthInsurance() {
		return this.__last_month_insurance;
	}

	public void setLastMonthInsurance( java.math.BigDecimal value ) {
		this.__last_month_insurance = value;
	}

	public java.lang.String getInsuranceRaise() {
		return this.__insurance_raise;
	}

	public void setInsuranceRaise( java.lang.String value ) {
		this.__insurance_raise = value;
	}

	public java.lang.String getPayRemark() {
		return this.__pay_remark;
	}

	public void setPayRemark( java.lang.String value ) {
		this.__pay_remark = value;
	}

	public java.lang.String getInsuranceRemark() {
		return this.__insurance_remark;
	}

	public void setInsuranceRemark( java.lang.String value ) {
		this.__insurance_remark = value;
	}

	public java.lang.Boolean getIsLocked() {
		return this.__is_locked;
	}

	public void setIsLocked( java.lang.Boolean value ) {
		this.__is_locked = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseReportOfEmployeeCostAnalysis __bean){
		__bean.setEmployeeCostAnalysisId(getEmployeeCostAnalysisId());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setThisMonthPay(getThisMonthPay());
		__bean.setLastMonthPay(getLastMonthPay());
		__bean.setPayRaise(getPayRaise());
		__bean.setThisMonthInsurance(getThisMonthInsurance());
		__bean.setLastMonthInsurance(getLastMonthInsurance());
		__bean.setInsuranceRaise(getInsuranceRaise());
		__bean.setPayRemark(getPayRemark());
		__bean.setInsuranceRemark(getInsuranceRemark());
		__bean.setIsLocked(getIsLocked());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getThisMonthPay() == null ? "" : getThisMonthPay());
		sb.append(",");
		sb.append(getLastMonthPay() == null ? "" : getLastMonthPay());
		sb.append(",");
		sb.append(getPayRaise() == null ? "" : getPayRaise());
		sb.append(",");
		sb.append(getThisMonthInsurance() == null ? "" : getThisMonthInsurance());
		sb.append(",");
		sb.append(getLastMonthInsurance() == null ? "" : getLastMonthInsurance());
		sb.append(",");
		sb.append(getInsuranceRaise() == null ? "" : getInsuranceRaise());
		sb.append(",");
		sb.append(getPayRemark() == null ? "" : getPayRemark());
		sb.append(",");
		sb.append(getInsuranceRemark() == null ? "" : getInsuranceRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOfEmployeeCostAnalysis o) {
		return __employee_cost_analysis_id == null ? -1 : __employee_cost_analysis_id.compareTo(o.getEmployeeCostAnalysisId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_cost_analysis_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__this_month_pay);
		hash = 97 * hash + Objects.hashCode(this.__last_month_pay);
		hash = 97 * hash + Objects.hashCode(this.__pay_raise);
		hash = 97 * hash + Objects.hashCode(this.__this_month_insurance);
		hash = 97 * hash + Objects.hashCode(this.__last_month_insurance);
		hash = 97 * hash + Objects.hashCode(this.__insurance_raise);
		hash = 97 * hash + Objects.hashCode(this.__pay_remark);
		hash = 97 * hash + Objects.hashCode(this.__insurance_remark);
		hash = 97 * hash + Objects.hashCode(this.__is_locked);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOfEmployeeCostAnalysis o = (BaseReportOfEmployeeCostAnalysis)obj;
		if(!Objects.equals(this.__employee_cost_analysis_id, o.getEmployeeCostAnalysisId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__this_month_pay, o.getThisMonthPay())) return false;
		if(!Objects.equals(this.__last_month_pay, o.getLastMonthPay())) return false;
		if(!Objects.equals(this.__pay_raise, o.getPayRaise())) return false;
		if(!Objects.equals(this.__this_month_insurance, o.getThisMonthInsurance())) return false;
		if(!Objects.equals(this.__last_month_insurance, o.getLastMonthInsurance())) return false;
		if(!Objects.equals(this.__insurance_raise, o.getInsuranceRaise())) return false;
		if(!Objects.equals(this.__pay_remark, o.getPayRemark())) return false;
		if(!Objects.equals(this.__insurance_remark, o.getInsuranceRemark())) return false;
		if(!Objects.equals(this.__is_locked, o.getIsLocked())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeCostAnalysisId() != null) sb.append(__wrapNumber(count++, "employeeCostAnalysisId", getEmployeeCostAnalysisId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getThisMonthPay() != null) sb.append(__wrapDecimal(count++, "thisMonthPay", getThisMonthPay()));
		if(getLastMonthPay() != null) sb.append(__wrapDecimal(count++, "lastMonthPay", getLastMonthPay()));
		if(getPayRaise() != null) sb.append(__wrapString(count++, "payRaise", getPayRaise()));
		if(getThisMonthInsurance() != null) sb.append(__wrapDecimal(count++, "thisMonthInsurance", getThisMonthInsurance()));
		if(getLastMonthInsurance() != null) sb.append(__wrapDecimal(count++, "lastMonthInsurance", getLastMonthInsurance()));
		if(getInsuranceRaise() != null) sb.append(__wrapString(count++, "insuranceRaise", getInsuranceRaise()));
		if(getPayRemark() != null) sb.append(__wrapString(count++, "payRemark", getPayRemark()));
		if(getInsuranceRemark() != null) sb.append(__wrapString(count++, "insuranceRemark", getInsuranceRemark()));
		if(getIsLocked() != null) sb.append(__wrapBoolean(count++, "isLocked", getIsLocked()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeCostAnalysisId")) != null) setEmployeeCostAnalysisId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("thisMonthPay")) != null) setThisMonthPay(__getDecimal(val));  
		if((val = values.get("lastMonthPay")) != null) setLastMonthPay(__getDecimal(val));  
		if((val = values.get("payRaise")) != null) setPayRaise(__getString(val));  
		if((val = values.get("thisMonthInsurance")) != null) setThisMonthInsurance(__getDecimal(val));  
		if((val = values.get("lastMonthInsurance")) != null) setLastMonthInsurance(__getDecimal(val));  
		if((val = values.get("insuranceRaise")) != null) setInsuranceRaise(__getString(val));  
		if((val = values.get("payRemark")) != null) setPayRemark(__getString(val));
		if((val = values.get("insuranceRemark")) != null) setInsuranceRemark(__getString(val));
		if((val = values.get("isLocked")) != null) setIsLocked(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __employee_cost_analysis_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __this_month_pay ;
	protected java.math.BigDecimal  __last_month_pay ;
	protected java.lang.String  __pay_raise ;
	protected java.math.BigDecimal  __this_month_insurance ;
	protected java.math.BigDecimal  __last_month_insurance ;
	protected java.lang.String  __insurance_raise ;
	protected java.lang.String  __pay_remark ;
	protected java.lang.String  __insurance_remark ;
	protected java.lang.Boolean  __is_locked ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
