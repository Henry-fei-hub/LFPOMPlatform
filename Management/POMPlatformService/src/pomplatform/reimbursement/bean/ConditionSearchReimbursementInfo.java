package pomplatform.reimbursement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class ConditionSearchReimbursementInfo extends GenericCondition{

	public final static String NAME_START_CREATE_TIME = "startCreateTime" ;
	public final static String NAME_END_CREATE_TIME = "endCreateTime" ;
	public final static String NAME_START_COMPLETE_TIME = "startCompleteTime" ;
	public final static String NAME_END_COMPLETE_TIME = "endCompleteTime" ;
	public final static String NAME_COMPANY_ID = "companyId" ;
	public final static String NAME_SUB_TYPE = "subType" ;
	public final static String NAME_PROCESS_TYPE = "processType" ;
	public final static String NAME_BEAR_FEE_CODE = "bearFeeCode" ;
	public final static String NAME_BEAR_FEE_NAME = "bearFeeName" ;
	public final static String NAME_CODE = "code" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_PLATE_ID = "plateId" ;
	public final static String NAME_PROCESS_STATUS = "processStatus" ;
	public final static String NAME_PACKAGE_CODE = "packageCode" ;
	public final static String NAME_CURRENCY = "currency" ;
	public final static String NAME_CONTRACT_CODE = "contractCode" ;
	public final static String NAME_REMARK = "remark" ;
	public final static String NAME_BACK_VIEW_NAME = "backViewName" ;
	public final static String NAME_BD_CODE = "bdCode" ;

	public ConditionSearchReimbursementInfo(){
		setParameterCount(19);
	}

	public java.util.Date getStartCreateTime() {
		return this.__start_create_time;
	}

	public void setStartCreateTime( java.util.Date value ) {
		this.__start_create_time = value;
	}

	public java.util.Date getEndCreateTime() {
		return this.__end_create_time;
	}

	public void setEndCreateTime( java.util.Date value ) {
		this.__end_create_time = value;
	}

	public java.util.Date getStartCompleteTime() {
		return this.__start_complete_time;
	}

	public void setStartCompleteTime( java.util.Date value ) {
		this.__start_complete_time = value;
	}

	public java.util.Date getEndCompleteTime() {
		return this.__end_complete_time;
	}

	public void setEndCompleteTime( java.util.Date value ) {
		this.__end_complete_time = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getSubType() {
		return this.__sub_type;
	}

	public void setSubType( java.lang.Integer value ) {
		this.__sub_type = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getBearFeeCode() {
		return this.__bear_fee_code == null ? null : (this.__bear_fee_code.indexOf("%") >= 0 ? this.__bear_fee_code : "%"+this.__bear_fee_code+"%");
	}

	public void setBearFeeCode( java.lang.String value ) {
		this.__bear_fee_code = value;
	}

	public java.lang.String getBearFeeName() {
		return this.__bear_fee_name == null ? null : (this.__bear_fee_name.indexOf("%") >= 0 ? this.__bear_fee_name : "%"+this.__bear_fee_name+"%");
	}

	public void setBearFeeName( java.lang.String value ) {
		this.__bear_fee_name = value;
	}

	public java.lang.String getCode() {
		return this.__code == null ? null : (this.__code.indexOf("%") >= 0 ? this.__code : "%"+this.__code+"%");
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.String getPackageCode() {
		return this.__package_code == null ? null : (this.__package_code.indexOf("%") >= 0 ? this.__package_code : "%"+this.__package_code+"%");
	}

	public void setPackageCode( java.lang.String value ) {
		this.__package_code = value;
	}

	public java.lang.Integer getCurrency() {
		return this.__currency;
	}

	public void setCurrency( java.lang.Integer value ) {
		this.__currency = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getBackViewName() {
		return this.__back_view_name == null ? null : (this.__back_view_name.indexOf("%") >= 0 ? this.__back_view_name : "%"+this.__back_view_name+"%");
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.lang.String getBdCode() {
		return this.__bd_code == null ? null : (this.__bd_code.indexOf("%") >= 0 ? this.__bd_code : "%"+this.__bd_code+"%");
	}

	public void setBdCode( java.lang.String value ) {
		this.__bd_code = value;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getStartCreateTime() != null) res.put(NAME_START_CREATE_TIME, getStartCreateTime());
		if(getEndCreateTime() != null) res.put(NAME_END_CREATE_TIME, getEndCreateTime());
		if(getStartCompleteTime() != null) res.put(NAME_START_COMPLETE_TIME, getStartCompleteTime());
		if(getEndCompleteTime() != null) res.put(NAME_END_COMPLETE_TIME, getEndCompleteTime());
		if(getCompanyId() != null) res.put(NAME_COMPANY_ID, getCompanyId());
		if(getSubType() != null) res.put(NAME_SUB_TYPE, getSubType());
		if(getProcessType() != null) res.put(NAME_PROCESS_TYPE, getProcessType());
		if(getBearFeeCode() != null) res.put(NAME_BEAR_FEE_CODE, getBearFeeCode());
		if(getBearFeeName() != null) res.put(NAME_BEAR_FEE_NAME, getBearFeeName());
		if(getCode() != null) res.put(NAME_CODE, getCode());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getPlateId() != null) res.put(NAME_PLATE_ID, getPlateId());
		if(getProcessStatus() != null) res.put(NAME_PROCESS_STATUS, getProcessStatus());
		if(getPackageCode() != null) res.put(NAME_PACKAGE_CODE, getPackageCode());
		if(getCurrency() != null) res.put(NAME_CURRENCY, getCurrency());
		if(getContractCode() != null) res.put(NAME_CONTRACT_CODE, getContractCode());
		if(getRemark() != null) res.put(NAME_REMARK, getRemark());
		if(getBackViewName() != null) res.put(NAME_BACK_VIEW_NAME, getBackViewName());
		if(getBdCode() != null) res.put(NAME_BD_CODE, getBdCode());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartCreateTime() != null) sb.append(__wrapDate(1, NAME_START_CREATE_TIME, getStartCreateTime()));
		if(getEndCreateTime() != null) sb.append(__wrapDate(1, NAME_END_CREATE_TIME, getEndCreateTime()));
		if(getStartCompleteTime() != null) sb.append(__wrapDate(1, NAME_START_COMPLETE_TIME, getStartCompleteTime()));
		if(getEndCompleteTime() != null) sb.append(__wrapDate(1, NAME_END_COMPLETE_TIME, getEndCompleteTime()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, NAME_COMPANY_ID, getCompanyId()));
		if(getSubType() != null) sb.append(__wrapNumber(1, NAME_SUB_TYPE, getSubType()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, NAME_PROCESS_TYPE, getProcessType()));
		if(getBearFeeCode() != null) sb.append(__wrapString(1, NAME_BEAR_FEE_CODE, getBearFeeCode()));
		if(getBearFeeName() != null) sb.append(__wrapString(1, NAME_BEAR_FEE_NAME, getBearFeeName()));
		if(getCode() != null) sb.append(__wrapString(1, NAME_CODE, getCode()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, NAME_PLATE_ID, getPlateId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, NAME_PROCESS_STATUS, getProcessStatus()));
		if(getPackageCode() != null) sb.append(__wrapString(1, NAME_PACKAGE_CODE, getPackageCode()));
		if(getCurrency() != null) sb.append(__wrapNumber(1, NAME_CURRENCY, getCurrency()));
		if(getContractCode() != null) sb.append(__wrapString(1, NAME_CONTRACT_CODE, getContractCode()));
		if(getRemark() != null) sb.append(__wrapString(1, NAME_REMARK, getRemark()));
		if(getBackViewName() != null) sb.append(__wrapString(1, NAME_BACK_VIEW_NAME, getBackViewName()));
		if(getBdCode() != null) sb.append(__wrapString(1, NAME_BD_CODE, getBdCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		super.setDataFromMap(values);
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_START_CREATE_TIME) && (val = values.get(NAME_START_CREATE_TIME)) != null) setStartCreateTime(__getDate(val)); 
		if(values.containsKey(NAME_END_CREATE_TIME) && (val = values.get(NAME_END_CREATE_TIME)) != null) setEndCreateTime(__getDate(val)); 
		if(values.containsKey(NAME_START_COMPLETE_TIME) && (val = values.get(NAME_START_COMPLETE_TIME)) != null) setStartCompleteTime(__getDate(val)); 
		if(values.containsKey(NAME_END_COMPLETE_TIME) && (val = values.get(NAME_END_COMPLETE_TIME)) != null) setEndCompleteTime(__getDate(val)); 
		if(values.containsKey(NAME_COMPANY_ID) && (val = values.get(NAME_COMPANY_ID)) != null) setCompanyId(__getInt(val)); 
		if(values.containsKey(NAME_SUB_TYPE) && (val = values.get(NAME_SUB_TYPE)) != null) setSubType(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_TYPE) && (val = values.get(NAME_PROCESS_TYPE)) != null) setProcessType(__getInt(val)); 
		if(values.containsKey(NAME_BEAR_FEE_CODE) && (val = values.get(NAME_BEAR_FEE_CODE)) != null) setBearFeeCode(__getString(val));
		if(values.containsKey(NAME_BEAR_FEE_NAME) && (val = values.get(NAME_BEAR_FEE_NAME)) != null) setBearFeeName(__getString(val));
		if(values.containsKey(NAME_CODE) && (val = values.get(NAME_CODE)) != null) setCode(__getString(val));
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_PLATE_ID) && (val = values.get(NAME_PLATE_ID)) != null) setPlateId(__getInt(val)); 
		if(values.containsKey(NAME_PROCESS_STATUS) && (val = values.get(NAME_PROCESS_STATUS)) != null) setProcessStatus(__getInt(val)); 
		if(values.containsKey(NAME_PACKAGE_CODE) && (val = values.get(NAME_PACKAGE_CODE)) != null) setPackageCode(__getString(val));
		if(values.containsKey(NAME_CURRENCY) && (val = values.get(NAME_CURRENCY)) != null) setCurrency(__getInt(val)); 
		if(values.containsKey(NAME_CONTRACT_CODE) && (val = values.get(NAME_CONTRACT_CODE)) != null) setContractCode(__getString(val));
		if(values.containsKey(NAME_REMARK) && (val = values.get(NAME_REMARK)) != null) setRemark(__getString(val));
		if(values.containsKey(NAME_BACK_VIEW_NAME) && (val = values.get(NAME_BACK_VIEW_NAME)) != null) setBackViewName(__getString(val));
		if(values.containsKey(NAME_BD_CODE) && (val = values.get(NAME_BD_CODE)) != null) setBdCode(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getStartCreateTime() != null) res.add(NAME_START_CREATE_TIME);
		if(getEndCreateTime() != null) res.add(NAME_END_CREATE_TIME);
		if(getStartCompleteTime() != null) res.add(NAME_START_COMPLETE_TIME);
		if(getEndCompleteTime() != null) res.add(NAME_END_COMPLETE_TIME);
		if(getCompanyId() != null) res.add(NAME_COMPANY_ID);
		if(getSubType() != null) res.add(NAME_SUB_TYPE);
		if(getProcessType() != null) res.add(NAME_PROCESS_TYPE);
		if(getBearFeeCode() != null) res.add(NAME_BEAR_FEE_CODE);
		if(getBearFeeName() != null) res.add(NAME_BEAR_FEE_NAME);
		if(getCode() != null) res.add(NAME_CODE);
		if(getEmployeeId() != null) res.add(NAME_EMPLOYEE_ID);
		if(getPlateId() != null) res.add(NAME_PLATE_ID);
		if(getProcessStatus() != null) res.add(NAME_PROCESS_STATUS);
		if(getPackageCode() != null) res.add(NAME_PACKAGE_CODE);
		if(getCurrency() != null) res.add(NAME_CURRENCY);
		if(getContractCode() != null) res.add(NAME_CONTRACT_CODE);
		if(getRemark() != null) res.add(NAME_REMARK);
		if(getBackViewName() != null) res.add(NAME_BACK_VIEW_NAME);
		if(getBdCode() != null) res.add(NAME_BD_CODE);
		return res;
	}

	private java.util.Date __start_create_time = null;
	private java.util.Date __end_create_time = null;
	private java.util.Date __start_complete_time = null;
	private java.util.Date __end_complete_time = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __sub_type = null;
	private java.lang.Integer __process_type = null;
	private java.lang.String __bear_fee_code = null;
	private java.lang.String __bear_fee_name = null;
	private java.lang.String __code = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __process_status = null;
	private java.lang.String __package_code = null;
	private java.lang.Integer __currency = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __remark = null;
	private java.lang.String __back_view_name = null;
	private java.lang.String __bd_code = null;
}

