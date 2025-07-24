package pomplatform.capitaldistribution.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCapitalDistributionOfDepartment extends GenericBase implements BaseFactory<BaseCapitalDistributionOfDepartment>, Comparable<BaseCapitalDistributionOfDepartment> 
{


	public static BaseCapitalDistributionOfDepartment newInstance(){
		return new BaseCapitalDistributionOfDepartment();
	}

	@Override
	public BaseCapitalDistributionOfDepartment make(){
		BaseCapitalDistributionOfDepartment b = new BaseCapitalDistributionOfDepartment();
		return b;
	}

	public final static java.lang.String CS_CAPITAL_DISTRIBUTION_ID = "capital_distribution_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_DISTRIBUTION_AMOUNT = "distribution_amount" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_TOTAL_DISTRIBUTION_AMOUNT = "total_distribution_amount" ;
	public final static java.lang.String CS_LEFT_AMOUNT = "left_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "合同编号,合同名称,业务部门,回款金额,已分配金额,剩余金额,本部门回款分配金额,回款日期,备注";
	public final static java.lang.String DOWN_CAPTIONS = "合同编号,合同名称,订单编号,业务部门,专业负责人,回款金额,已分配金额,剩余金额,本部门回款分配金额,回款日期,备注";

	public java.lang.Integer getCapitalDistributionId() {
		return this.__capital_distribution_id;
	}

	public void setCapitalDistributionId( java.lang.Integer value ) {
		this.__capital_distribution_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.math.BigDecimal getDistributionAmount() {
		return this.__distribution_amount;
	}

	public void setDistributionAmount( java.math.BigDecimal value ) {
		this.__distribution_amount = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getProjectId() {
		return __project_id;
	}

	public void setProjectId(java.lang.Integer __project_id) {
		this.__project_id = __project_id;
	}

	public java.math.BigDecimal getTotalDistributionAmount() {
		return __total_distribution_amount;
	}

	public void setTotalDistributionAmount(java.math.BigDecimal __total_distribution_amount) {
		this.__total_distribution_amount = __total_distribution_amount;
	}

	public java.math.BigDecimal getLeftAmount() {
		return __left_amount;
	}

	public void setLeftAmount(java.math.BigDecimal __left_amount) {
		this.__left_amount = __left_amount;
	}
	
	public java.lang.Integer getProjectManageId() {
		return __project_manage_id;
	}

	public void setProjectManageId(java.lang.Integer __project_manage_id) {
		this.__project_manage_id = __project_manage_id;
	}

	public void cloneCopy(BaseCapitalDistributionOfDepartment __bean){
		__bean.setCapitalDistributionId(getCapitalDistributionId());
		__bean.setContractCode(getContractCode());
		__bean.setContractId(getContractId());
		__bean.setType(getType());
		__bean.setCapitalId(getCapitalId());
		__bean.setPlateId(getPlateId());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setDistributionAmount(getDistributionAmount());
		__bean.setHappenDate(getHappenDate());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
		__bean.setProjectId(getProjectId());
		__bean.setTotalDistributionAmount(getTotalDistributionAmount());
		__bean.setLeftAmount(getLeftAmount());
		__bean.setProjectManageId(getProjectManageId());
	}

	public java.lang.String toCSVString() {

		StringBuilder sb = new StringBuilder();
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		String strContractId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getContractId()));
		sb.append(strContractId == null ? "" : strContractId);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("project_code", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		String strId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId()));
		sb.append(strId == null ? "" : strId);
		sb.append(",");
		String strProjectManageId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManageId()));
		sb.append(strProjectManageId == null ? "" : strProjectManageId);
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getTotalDistributionAmount() == null ? "" : getTotalDistributionAmount());
		sb.append(",");
		sb.append(getLeftAmount() == null ? "" : getLeftAmount());
		sb.append(",");
		sb.append(getDistributionAmount() == null ? "" : getDistributionAmount());
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : DATE_SDF.format(getHappenDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark().replaceAll(",", "，"));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCapitalDistributionOfDepartment o) {
		return __capital_distribution_id == null ? -1 : __capital_distribution_id.compareTo(o.getCapitalDistributionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__capital_distribution_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__distribution_amount);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__total_distribution_amount);
		hash = 97 * hash + Objects.hashCode(this.__left_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCapitalDistributionOfDepartment o = (BaseCapitalDistributionOfDepartment)obj;
		if(!Objects.equals(this.__capital_distribution_id, o.getCapitalDistributionId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__total_distribution_amount, o.getTotalDistributionAmount())) return false;
		if(!Objects.equals(this.__left_amount, o.getLeftAmount())) return false;
		if(!Objects.equals(this.__distribution_amount, o.getDistributionAmount())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(count++, "capitalDistributionId", getCapitalDistributionId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getTotalDistributionAmount() != null) sb.append(__wrapDecimal(count++, "totalDistributionAmount", getTotalDistributionAmount()));
		if(getLeftAmount() != null) sb.append(__wrapDecimal(count++, "leftAmount", getLeftAmount()));
		if(getDistributionAmount() != null) sb.append(__wrapDecimal(count++, "distributionAmount", getDistributionAmount()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("capitalDistributionId")) != null) setCapitalDistributionId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("totalDistributionAmount")) != null) setTotalDistributionAmount(__getDecimal(val));  
		if((val = values.get("leftAmount")) != null) setLeftAmount(__getDecimal(val));  
		if((val = values.get("distributionAmount")) != null) setDistributionAmount(__getDecimal(val));  
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
	}

	protected java.lang.Integer  __capital_distribution_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __capital_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.math.BigDecimal  __distribution_amount ;
	protected java.util.Date  __happen_date ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
	protected java.math.BigDecimal  __total_distribution_amount ;
	protected java.math.BigDecimal  __left_amount ;
	protected java.lang.Integer  __project_manage_id ;
}
