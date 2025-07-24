package pomplatform.OnRevenue.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRevenueYearRecordSubOfRevenue extends GenericBase implements BaseFactory<BaseRevenueYearRecordSubOfRevenue>, Comparable<BaseRevenueYearRecordSubOfRevenue> 
{


	public static BaseRevenueYearRecordSubOfRevenue newInstance(){
		return new BaseRevenueYearRecordSubOfRevenue();
	}

	@Override
	public BaseRevenueYearRecordSubOfRevenue make(){
		BaseRevenueYearRecordSubOfRevenue b = new BaseRevenueYearRecordSubOfRevenue();
		return b;
	}

	public final static java.lang.String CS_REVENUE_YEAR_RECORD_ID = "revenue_year_record_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_MONEY = "money" ;
	public final static java.lang.String CS_JANUARY_REVENUE = "january_revenue" ;
	public final static java.lang.String CS_FEBRUARY_REVENUE = "february_revenue" ;
	public final static java.lang.String CS_MARCH_REVENUE = "march_revenue" ;
	public final static java.lang.String CS_APRIL_REVENUE = "april_revenue" ;
	public final static java.lang.String CS_MAY_REVENUE = "may_revenue" ;
	public final static java.lang.String CS_JUNE_REVENUE = "june_revenue" ;
	public final static java.lang.String CS_JULY_REVENUE = "july_revenue" ;
	public final static java.lang.String CS_AUGUST_REVENUE = "august_revenue" ;
	public final static java.lang.String CS_SEPTEMBER_REVENUE = "september_revenue" ;
	public final static java.lang.String CS_OCTOBER_REVENUE = "october_revenue" ;
	public final static java.lang.String CS_NOVEMBER_REVENUE = "november_revenue" ;
	public final static java.lang.String CS_DECEMBER_REVENUE = "december_revenue" ;
	public final static java.lang.String CS_TOTAL_REVENUE = "total_revenue" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_YEAR_REVENUE = "year_revenue" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_SIGNING_COMPANY = "signing_company" ;
	public final static java.lang.String CS_IS_FINISH = "is_finish" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同编码,编号,名称,金额,1月,2月,3月,4月,5月,6月,7月,8月,9月,10月,11月,12月,合计,父级编码,年度,2营收,签约公司,合同是否完成,操作人,操作时间";

	public java.lang.Integer getRevenueYearRecordId() {
		return this.__revenue_year_record_id;
	}

	public void setRevenueYearRecordId( java.lang.Integer value ) {
		this.__revenue_year_record_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getMoney() {
		return this.__money;
	}

	public void setMoney( java.math.BigDecimal value ) {
		this.__money = value;
	}

	public java.math.BigDecimal getJanuaryRevenue() {
		return this.__january_revenue;
	}

	public void setJanuaryRevenue( java.math.BigDecimal value ) {
		this.__january_revenue = value;
	}

	public java.math.BigDecimal getFebruaryRevenue() {
		return this.__february_revenue;
	}

	public void setFebruaryRevenue( java.math.BigDecimal value ) {
		this.__february_revenue = value;
	}

	public java.math.BigDecimal getMarchRevenue() {
		return this.__march_revenue;
	}

	public void setMarchRevenue( java.math.BigDecimal value ) {
		this.__march_revenue = value;
	}

	public java.math.BigDecimal getAprilRevenue() {
		return this.__april_revenue;
	}

	public void setAprilRevenue( java.math.BigDecimal value ) {
		this.__april_revenue = value;
	}

	public java.math.BigDecimal getMayRevenue() {
		return this.__may_revenue;
	}

	public void setMayRevenue( java.math.BigDecimal value ) {
		this.__may_revenue = value;
	}

	public java.math.BigDecimal getJuneRevenue() {
		return this.__june_revenue;
	}

	public void setJuneRevenue( java.math.BigDecimal value ) {
		this.__june_revenue = value;
	}

	public java.math.BigDecimal getJulyRevenue() {
		return this.__july_revenue;
	}

	public void setJulyRevenue( java.math.BigDecimal value ) {
		this.__july_revenue = value;
	}

	public java.math.BigDecimal getAugustRevenue() {
		return this.__august_revenue;
	}

	public void setAugustRevenue( java.math.BigDecimal value ) {
		this.__august_revenue = value;
	}

	public java.math.BigDecimal getSeptemberRevenue() {
		return this.__september_revenue;
	}

	public void setSeptemberRevenue( java.math.BigDecimal value ) {
		this.__september_revenue = value;
	}

	public java.math.BigDecimal getOctoberRevenue() {
		return this.__october_revenue;
	}

	public void setOctoberRevenue( java.math.BigDecimal value ) {
		this.__october_revenue = value;
	}

	public java.math.BigDecimal getNovemberRevenue() {
		return this.__november_revenue;
	}

	public void setNovemberRevenue( java.math.BigDecimal value ) {
		this.__november_revenue = value;
	}

	public java.math.BigDecimal getDecemberRevenue() {
		return this.__december_revenue;
	}

	public void setDecemberRevenue( java.math.BigDecimal value ) {
		this.__december_revenue = value;
	}

	public java.math.BigDecimal getTotalRevenue() {
		return this.__total_revenue;
	}

	public void setTotalRevenue( java.math.BigDecimal value ) {
		this.__total_revenue = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getYearRevenue() {
		return this.__year_revenue;
	}

	public void setYearRevenue( java.lang.Integer value ) {
		this.__year_revenue = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getSigningCompany() {
		return this.__signing_company;
	}

	public void setSigningCompany( java.lang.Integer value ) {
		this.__signing_company = value;
	}

	public java.lang.Boolean getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Boolean value ) {
		this.__is_finish = value;
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

	public void cloneCopy(BaseRevenueYearRecordSubOfRevenue __bean){
		__bean.setRevenueYearRecordId(getRevenueYearRecordId());
		__bean.setContractId(getContractId());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setMoney(getMoney());
		__bean.setJanuaryRevenue(getJanuaryRevenue());
		__bean.setFebruaryRevenue(getFebruaryRevenue());
		__bean.setMarchRevenue(getMarchRevenue());
		__bean.setAprilRevenue(getAprilRevenue());
		__bean.setMayRevenue(getMayRevenue());
		__bean.setJuneRevenue(getJuneRevenue());
		__bean.setJulyRevenue(getJulyRevenue());
		__bean.setAugustRevenue(getAugustRevenue());
		__bean.setSeptemberRevenue(getSeptemberRevenue());
		__bean.setOctoberRevenue(getOctoberRevenue());
		__bean.setNovemberRevenue(getNovemberRevenue());
		__bean.setDecemberRevenue(getDecemberRevenue());
		__bean.setTotalRevenue(getTotalRevenue());
		__bean.setParentId(getParentId());
		__bean.setYearRevenue(getYearRevenue());
		__bean.setFlag(getFlag());
		__bean.setSigningCompany(getSigningCompany());
		__bean.setIsFinish(getIsFinish());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRevenueYearRecordId() == null ? "" : getRevenueYearRecordId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getMoney() == null ? "" : getMoney());
		sb.append(",");
		sb.append(getJanuaryRevenue() == null ? "" : getJanuaryRevenue());
		sb.append(",");
		sb.append(getFebruaryRevenue() == null ? "" : getFebruaryRevenue());
		sb.append(",");
		sb.append(getMarchRevenue() == null ? "" : getMarchRevenue());
		sb.append(",");
		sb.append(getAprilRevenue() == null ? "" : getAprilRevenue());
		sb.append(",");
		sb.append(getMayRevenue() == null ? "" : getMayRevenue());
		sb.append(",");
		sb.append(getJuneRevenue() == null ? "" : getJuneRevenue());
		sb.append(",");
		sb.append(getJulyRevenue() == null ? "" : getJulyRevenue());
		sb.append(",");
		sb.append(getAugustRevenue() == null ? "" : getAugustRevenue());
		sb.append(",");
		sb.append(getSeptemberRevenue() == null ? "" : getSeptemberRevenue());
		sb.append(",");
		sb.append(getOctoberRevenue() == null ? "" : getOctoberRevenue());
		sb.append(",");
		sb.append(getNovemberRevenue() == null ? "" : getNovemberRevenue());
		sb.append(",");
		sb.append(getDecemberRevenue() == null ? "" : getDecemberRevenue());
		sb.append(",");
		sb.append(getTotalRevenue() == null ? "" : getTotalRevenue());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getYearRevenue() == null ? "" : getYearRevenue());
		sb.append(",");
		String strFlag = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_34", String.valueOf(getFlag()));
		sb.append(strFlag == null ? "" : strFlag);
		sb.append(",");
		String strSigningCompany = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSigningCompany()));
		sb.append(strSigningCompany == null ? "" : strSigningCompany);
		sb.append(",");
		sb.append(getIsFinish() == null ? "" : getIsFinish());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRevenueYearRecordSubOfRevenue o) {
		return __revenue_year_record_id == null ? -1 : __revenue_year_record_id.compareTo(o.getRevenueYearRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__revenue_year_record_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__money);
		hash = 97 * hash + Objects.hashCode(this.__january_revenue);
		hash = 97 * hash + Objects.hashCode(this.__february_revenue);
		hash = 97 * hash + Objects.hashCode(this.__march_revenue);
		hash = 97 * hash + Objects.hashCode(this.__april_revenue);
		hash = 97 * hash + Objects.hashCode(this.__may_revenue);
		hash = 97 * hash + Objects.hashCode(this.__june_revenue);
		hash = 97 * hash + Objects.hashCode(this.__july_revenue);
		hash = 97 * hash + Objects.hashCode(this.__august_revenue);
		hash = 97 * hash + Objects.hashCode(this.__september_revenue);
		hash = 97 * hash + Objects.hashCode(this.__october_revenue);
		hash = 97 * hash + Objects.hashCode(this.__november_revenue);
		hash = 97 * hash + Objects.hashCode(this.__december_revenue);
		hash = 97 * hash + Objects.hashCode(this.__total_revenue);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__year_revenue);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__signing_company);
		hash = 97 * hash + Objects.hashCode(this.__is_finish);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRevenueYearRecordSubOfRevenue o = (BaseRevenueYearRecordSubOfRevenue)obj;
		if(!Objects.equals(this.__revenue_year_record_id, o.getRevenueYearRecordId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__money, o.getMoney())) return false;
		if(!Objects.equals(this.__january_revenue, o.getJanuaryRevenue())) return false;
		if(!Objects.equals(this.__february_revenue, o.getFebruaryRevenue())) return false;
		if(!Objects.equals(this.__march_revenue, o.getMarchRevenue())) return false;
		if(!Objects.equals(this.__april_revenue, o.getAprilRevenue())) return false;
		if(!Objects.equals(this.__may_revenue, o.getMayRevenue())) return false;
		if(!Objects.equals(this.__june_revenue, o.getJuneRevenue())) return false;
		if(!Objects.equals(this.__july_revenue, o.getJulyRevenue())) return false;
		if(!Objects.equals(this.__august_revenue, o.getAugustRevenue())) return false;
		if(!Objects.equals(this.__september_revenue, o.getSeptemberRevenue())) return false;
		if(!Objects.equals(this.__october_revenue, o.getOctoberRevenue())) return false;
		if(!Objects.equals(this.__november_revenue, o.getNovemberRevenue())) return false;
		if(!Objects.equals(this.__december_revenue, o.getDecemberRevenue())) return false;
		if(!Objects.equals(this.__total_revenue, o.getTotalRevenue())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__year_revenue, o.getYearRevenue())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__signing_company, o.getSigningCompany())) return false;
		if(!Objects.equals(this.__is_finish, o.getIsFinish())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRevenueYearRecordId() != null) sb.append(__wrapNumber(count++, "revenueYearRecordId", getRevenueYearRecordId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getMoney() != null) sb.append(__wrapDecimal(count++, "money", getMoney()));
		if(getJanuaryRevenue() != null) sb.append(__wrapDecimal(count++, "januaryRevenue", getJanuaryRevenue()));
		if(getFebruaryRevenue() != null) sb.append(__wrapDecimal(count++, "februaryRevenue", getFebruaryRevenue()));
		if(getMarchRevenue() != null) sb.append(__wrapDecimal(count++, "marchRevenue", getMarchRevenue()));
		if(getAprilRevenue() != null) sb.append(__wrapDecimal(count++, "aprilRevenue", getAprilRevenue()));
		if(getMayRevenue() != null) sb.append(__wrapDecimal(count++, "mayRevenue", getMayRevenue()));
		if(getJuneRevenue() != null) sb.append(__wrapDecimal(count++, "juneRevenue", getJuneRevenue()));
		if(getJulyRevenue() != null) sb.append(__wrapDecimal(count++, "julyRevenue", getJulyRevenue()));
		if(getAugustRevenue() != null) sb.append(__wrapDecimal(count++, "augustRevenue", getAugustRevenue()));
		if(getSeptemberRevenue() != null) sb.append(__wrapDecimal(count++, "septemberRevenue", getSeptemberRevenue()));
		if(getOctoberRevenue() != null) sb.append(__wrapDecimal(count++, "octoberRevenue", getOctoberRevenue()));
		if(getNovemberRevenue() != null) sb.append(__wrapDecimal(count++, "novemberRevenue", getNovemberRevenue()));
		if(getDecemberRevenue() != null) sb.append(__wrapDecimal(count++, "decemberRevenue", getDecemberRevenue()));
		if(getTotalRevenue() != null) sb.append(__wrapDecimal(count++, "totalRevenue", getTotalRevenue()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getYearRevenue() != null) sb.append(__wrapNumber(count++, "yearRevenue", getYearRevenue()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getSigningCompany() != null) sb.append(__wrapNumber(count++, "signingCompany", getSigningCompany()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(count++, "isFinish", getIsFinish()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("revenueYearRecordId")) != null) setRevenueYearRecordId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("money")) != null) setMoney(__getDecimal(val));  
		if((val = values.get("januaryRevenue")) != null) setJanuaryRevenue(__getDecimal(val));  
		if((val = values.get("februaryRevenue")) != null) setFebruaryRevenue(__getDecimal(val));  
		if((val = values.get("marchRevenue")) != null) setMarchRevenue(__getDecimal(val));  
		if((val = values.get("aprilRevenue")) != null) setAprilRevenue(__getDecimal(val));  
		if((val = values.get("mayRevenue")) != null) setMayRevenue(__getDecimal(val));  
		if((val = values.get("juneRevenue")) != null) setJuneRevenue(__getDecimal(val));  
		if((val = values.get("julyRevenue")) != null) setJulyRevenue(__getDecimal(val));  
		if((val = values.get("augustRevenue")) != null) setAugustRevenue(__getDecimal(val));  
		if((val = values.get("septemberRevenue")) != null) setSeptemberRevenue(__getDecimal(val));  
		if((val = values.get("octoberRevenue")) != null) setOctoberRevenue(__getDecimal(val));  
		if((val = values.get("novemberRevenue")) != null) setNovemberRevenue(__getDecimal(val));  
		if((val = values.get("decemberRevenue")) != null) setDecemberRevenue(__getDecimal(val));  
		if((val = values.get("totalRevenue")) != null) setTotalRevenue(__getDecimal(val));  
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("yearRevenue")) != null) setYearRevenue(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("signingCompany")) != null) setSigningCompany(__getInt(val)); 
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __revenue_year_record_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __money ;
	protected java.math.BigDecimal  __january_revenue ;
	protected java.math.BigDecimal  __february_revenue ;
	protected java.math.BigDecimal  __march_revenue ;
	protected java.math.BigDecimal  __april_revenue ;
	protected java.math.BigDecimal  __may_revenue ;
	protected java.math.BigDecimal  __june_revenue ;
	protected java.math.BigDecimal  __july_revenue ;
	protected java.math.BigDecimal  __august_revenue ;
	protected java.math.BigDecimal  __september_revenue ;
	protected java.math.BigDecimal  __october_revenue ;
	protected java.math.BigDecimal  __november_revenue ;
	protected java.math.BigDecimal  __december_revenue ;
	protected java.math.BigDecimal  __total_revenue ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __year_revenue ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Integer  __signing_company ;
	protected java.lang.Boolean  __is_finish ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
}
