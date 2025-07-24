package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCustomSheetAccount extends GenericBase implements BaseFactory<BaseCustomSheetAccount>, Comparable<BaseCustomSheetAccount> 
{


	public static BaseCustomSheetAccount newInstance(){
		return new BaseCustomSheetAccount();
	}

	@Override
	public BaseCustomSheetAccount make(){
		BaseCustomSheetAccount b = new BaseCustomSheetAccount();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "project_name" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral";
	public final static java.lang.String CS_PROJECT_PERFORMANCE_AWARD = "project_performance_award";//项目绩效奖励
	public final static java.lang.String CS_PROJECT_PERFORMANCE_ACHIEVE = "project_performance_achieve";//项目绩效收入
	public final static java.lang.String CS_PROJECT_PERFORMANCE_DECUCT = "project_performance_deduct";//项目绩效扣除
	public final static java.lang.String CS_PROJECT_PERFORMANCE = "project_performance";//项目绩效

	public final static java.lang.String ALL_CAPTIONS = "合同ID,合同编号,合同名称,积分余额,项目绩效奖励,项目绩效收入,项目绩效扣除,项目绩效";

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}
	
	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral(java.math.BigDecimal value) {
		this.__left_integral = value;
	}
	
	public java.math.BigDecimal getProjectPerformanceAward() {
		return __project_performance_award;
	}
	
	public void setProjectPerformanceAward(java.math.BigDecimal value) {
		this.__project_performance_award = value;
	}
	
	public java.math.BigDecimal getProjectPerformanceAchieve() {
		return __project_performance_achieve;
	}
	
	public void setProjectPerformanceAchieve(java.math.BigDecimal value) {
		this.__project_performance_achieve = value;
	}
	
	public java.math.BigDecimal getProjectPerformanceDeduct() {
		return __project_performance_deduct;
	}
	
	public void setProjectPerformanceDeduct(java.math.BigDecimal value) {
		this.__project_performance_deduct = value;
	}
	
	public java.math.BigDecimal getProjectPerformance() {
		return __project_performance;
	}
	
	public void setProjectPerformance(java.math.BigDecimal value) {
		this.__project_performance = value;
	}

	public void cloneCopy(BaseCustomSheetAccount __bean){
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setProjectName(getProjectName());
		__bean.setLeftIntegral(getLeftIntegral());
		__bean.setProjectPerformanceAward(getProjectPerformanceAward());
		__bean.setProjectPerformanceAchieve(getProjectPerformanceAchieve());
		__bean.setProjectPerformanceDeduct(getProjectPerformanceDeduct());
		__bean.setProjectPerformance(getProjectPerformance());
	}

	public java.lang.String toCSVString() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		sb.append(",");
		sb.append(getProjectPerformanceAward() == null ? "" : getProjectPerformanceAward());
		sb.append(",");
		sb.append(getProjectPerformanceAchieve() == null ? "" : getProjectPerformanceAchieve());
		sb.append(",");
		sb.append(getProjectPerformanceDeduct() == null ? "" : getProjectPerformanceDeduct());
		sb.append(",");
		sb.append(getProjectPerformance() == null ? "" : getProjectPerformance());
		return sb.toString();
	}
	
	@Override
	public int compareTo(BaseCustomSheetAccount o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_performance_award);
		hash = 97 * hash + Objects.hashCode(this.__project_performance_achieve);
		hash = 97 * hash + Objects.hashCode(this.__project_performance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__project_performance);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCustomSheetAccount o = (BaseCustomSheetAccount)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if (!Objects.equals(this.__left_integral, o.getLeftIntegral()))
			return false;
		if (!Objects.equals(this.__project_performance_award, o.getProjectPerformanceAward()))
			return false;
		if (!Objects.equals(this.__project_performance_achieve, o.getProjectPerformanceAchieve()))
			return false;
		if (!Objects.equals(this.__project_performance_deduct, o.getProjectPerformanceDeduct()))
			return false;
		if (!Objects.equals(this.__project_performance, o.getProjectPerformance()))
			return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if (getLeftIntegral() != null)
			sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		if (getProjectPerformanceAward() != null)
			sb.append(__wrapDecimal(count++, "projectPerformanceAward", getProjectPerformanceAward()));
		if (getProjectPerformanceAchieve() != null)
			sb.append(__wrapDecimal(count++, "projectPerformanceAchieve", getProjectPerformanceAchieve()));
		if (getProjectPerformanceDeduct() != null)
			sb.append(__wrapDecimal(count++, "projectPerformanceDeduct", getProjectPerformanceDeduct()));
		if (getProjectPerformance() != null)
			sb.append(__wrapDecimal(count++, "projectPerformance", getProjectPerformance()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if ((val = values.get("leftIntegral")) != null)
			setLeftIntegral(__getDecimal(val));
		if ((val = values.get("projectPerformanceAward")) != null)
			setProjectPerformanceAward(__getDecimal(val));
		if ((val = values.get("projectPerformanceAchieve")) != null)
			setProjectPerformanceAchieve(__getDecimal(val));
		if ((val = values.get("projectPerformanceDeduct")) != null)
			setProjectPerformanceDeduct(__getDecimal(val));
		if ((val = values.get("projectPerformance")) != null)
			setProjectPerformance(__getDecimal(val));
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __project_name ;
	protected java.math.BigDecimal __left_integral;
	protected java.math.BigDecimal __project_performance_award;
	protected java.math.BigDecimal __project_performance_achieve;
	protected java.math.BigDecimal __project_performance_deduct;
	protected java.math.BigDecimal __project_performance;

}
