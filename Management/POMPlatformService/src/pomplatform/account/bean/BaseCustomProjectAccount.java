package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCustomProjectAccount extends GenericBase implements BaseFactory<BaseCustomProjectAccount>, Comparable<BaseCustomProjectAccount> 
{


	public static BaseCustomProjectAccount newInstance(){
		return new BaseCustomProjectAccount();
	}

	@Override
	public BaseCustomProjectAccount make(){
		BaseCustomProjectAccount b = new BaseCustomProjectAccount();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral";
	public final static java.lang.String CS_PM_PERFORMANCE_DEDUCT = "pm_performance_deduct";//项目经理绩效扣除
	public final static java.lang.String CS_PM_PERFORMANCE_AWARD = "pm_performance_award";//项目经理绩效奖励
	public final static java.lang.String CS_PROJECT_PERFORMANCE = "project_performance_remain";//项目绩效结余

	public final static java.lang.String ALL_CAPTIONS = "合同ID,合同编号,合同名称,积分余额,项目经理绩效扣除,项目经理绩效奖励,项目绩效结余";

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}
	
	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral(java.math.BigDecimal value) {
		this.__left_integral = value;
	}
	
	public java.math.BigDecimal getPmPerformanceAward() {
		return __pm_performance_award;
	}
	
	public void setPmPerformanceAward(java.math.BigDecimal value) {
		this.__pm_performance_award = value;
	}
	
	public java.math.BigDecimal getPmPerformanceDeduct() {
		return __pm_performance_deduct;
	}
	
	public void setPmPerformanceDeduct(java.math.BigDecimal value) {
		this.__pm_performance_deduct = value;
	}
	
	public java.math.BigDecimal getProjectPerformanceRemain() {
		return __project_performance_remain;
	}
	
	public void setProjectPerformanceRemian(java.math.BigDecimal value) {
		this.__project_performance_remain = value;
	}

	public void cloneCopy(BaseCustomProjectAccount __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setLeftIntegral(getLeftIntegral());
		__bean.setPmPerformanceAward(getPmPerformanceAward());
		__bean.setPmPerformanceDeduct(getPmPerformanceDeduct());
		__bean.setProjectPerformanceRemian(getProjectPerformanceRemain());
	}

	public java.lang.String toCSVString() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		sb.append(",");
		sb.append(getPmPerformanceDeduct() == null ? "" : getPmPerformanceDeduct());
		sb.append(",");
		sb.append(getPmPerformanceAward() == null ? "" : getPmPerformanceAward());
		sb.append(",");
		sb.append(getProjectPerformanceRemain() == null ? "" : getProjectPerformanceRemain());
		return sb.toString();
	}
	
	@Override
	public int compareTo(BaseCustomProjectAccount o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		hash = 97 * hash + Objects.hashCode(this.__pm_performance_award);
		hash = 97 * hash + Objects.hashCode(this.__pm_performance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__project_performance_remain);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCustomProjectAccount o = (BaseCustomProjectAccount)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if (!Objects.equals(this.__left_integral, o.getLeftIntegral()))
			return false;
		if (!Objects.equals(this.__pm_performance_award, o.getPmPerformanceAward()))
			return false;
		if (!Objects.equals(this.__pm_performance_deduct, o.getPmPerformanceDeduct()))
			return false;
		if (!Objects.equals(this.__project_performance_remain, o.getProjectPerformanceRemain()))
			return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if (getLeftIntegral() != null)
			sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		if (getPmPerformanceAward() != null)
			sb.append(__wrapDecimal(count++, "pmPerformanceAward", getPmPerformanceAward()));
		if (getPmPerformanceDeduct() != null)
			sb.append(__wrapDecimal(count++, "pmPerformanceDeduct", getPmPerformanceDeduct()));
		if (getProjectPerformanceRemain() != null)
			sb.append(__wrapDecimal(count++, "projectPerformanceRemain", getProjectPerformanceRemain()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if ((val = values.get("leftIntegral")) != null)
			setLeftIntegral(__getDecimal(val));
		if ((val = values.get("pmPerformanceAward")) != null)
			setPmPerformanceAward(__getDecimal(val));
		if ((val = values.get("pmPerformanceDeduct")) != null)
			setPmPerformanceDeduct(__getDecimal(val));
		if ((val = values.get("projectPerformanceRemain")) != null)
			setProjectPerformanceRemian(__getDecimal(val));
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.math.BigDecimal __left_integral;
	protected java.math.BigDecimal __pm_performance_award;
	protected java.math.BigDecimal __pm_performance_deduct;
	protected java.math.BigDecimal __project_performance_remain;

}
