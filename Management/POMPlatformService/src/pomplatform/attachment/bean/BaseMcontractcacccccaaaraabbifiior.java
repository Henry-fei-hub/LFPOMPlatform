package pomplatform.attachment.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.date.util.DateUtil;

public class BaseMcontractcacccccaaaraabbifiior extends GenericBase implements BaseFactory<BaseMcontractcacccccaaaraabbifiior>, Comparable<BaseMcontractcacccccaaaraabbifiior> 
{


	public static BaseMcontractcacccccaaaraabbifiior newInstance(){
		return new BaseMcontractcacccccaaaraabbifiior();
	}

	@Override
	public BaseMcontractcacccccaaaraabbifiior make(){
		BaseMcontractcacccccaaaraabbifiior b = new BaseMcontractcacccccaaaraabbifiior();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_CONTRACT_TYPE = "contract_type" ;
	public final static java.lang.String CS_PROJECT_LEVEL = "project_level" ;
	public final static java.lang.String CS_TOTAL_PROJECT_TIME = "total_project_time" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static java.lang.String CS_DESIGN_AREAS = "design_areas" ;
	public final static java.lang.String CS_CONTRACT_PRICE = "contract_price" ;
	public final static java.lang.String CS_PROJECT_ADDRESS = "project_address" ;
	public final static java.lang.String CS_CONTRACT_FOLLOWER = "contract_follower" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CONTRACT_DATE = "contract_date" ;
	public final static java.lang.String CS_SIGNING_COMPANY_NAME = "signing_company_name" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_FLOW_STATUS = "flow_status" ;
	public final static java.lang.String CS_SERIAL_NUMBER = "serial_number" ;
	public final static java.lang.String CS_PROJECT_TYPE = "project_type" ;
	public final static java.lang.String CS_COVERED_AREA = "covered_area" ;
	public final static java.lang.String CS_PROFESSIONAL_COOPERATION = "professional_cooperation" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static java.lang.String CS_CUSTOMER_ADDRESS = "customer_address" ;
	public final static java.lang.String CS_SERVICE_SUGGEST_BOOK = "service_suggest_book" ;
	public final static java.lang.String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static java.lang.String CS_ORDER_NO = "order_no" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_INFO_CODE = "info_code" ;
	public final static java.lang.String CS_CONTRACT_STATUS = "contract_status" ;
	public final static java.lang.String CS_CLIENT_CONTRACT_ID = "client_contract_id" ;
	public final static java.lang.String CS_IS_FINISH = "is_finish" ;
	public final static java.lang.String CS_IS_SYSTEM_ADD = "is_system_add" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_ATTACHMENT_REMARK = "attachment_remark" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_COUNT = "count" ;
	public final static java.lang.String CS_CURRENT_BORROW_MONEY = "current_borrow_money";
	public final static java.lang.String CS_CURRENT_AMOUNT = "current_amount";

	public final static java.lang.String ALL_CAPTIONS = "主订单编码,主订单编号,主订单名称,客户名称,开始日期,结束日期,结算状态,项目编号,合同类别,项目等级,项目总工期,签约总金额,总设计面积,合同单价,项目地点,合同跟进人,备注,合同签订日期,我方签约公司名称,创建时间,修改时间,业务类别,流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成,流水号,项目类别,建筑面积,配合专业,省份,城市,详细地址,客户地址,服务建议书,立单时间 提交了立单时间会将保存下来，只是点击保存不会将当前时间保存下来，单每次都会显示当前的时间，提交了下次显示的就是提交时的立单时间,标记补充协议字段；除0之外，其他都表示第n个补充协议,tree结构表示,信息编号,合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除,客户合同编号,合同是否完成,是否为erp系统添加  true 为系统添加  false 为数据导入,操作人,确认函申请备注,借（增加）,";

	public final static java.lang.String EXPORT_CAPTIONS = "合同状态,合同编号,合同名称,客户名称,签约总金额,累积含税营收,开票金额,总回款金额,总设计面积,当期回款金额,当期开票金额,确认函张数,确认函累计回款,最近一次发票开具日期";
	
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

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getContractType() {
		return this.__contract_type;
	}

	public void setContractType( java.lang.Integer value ) {
		this.__contract_type = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getTotalProjectTime() {
		return this.__total_project_time;
	}

	public void setTotalProjectTime( java.lang.Integer value ) {
		this.__total_project_time = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public java.math.BigDecimal getDesignAreas() {
		return this.__design_areas;
	}

	public void setDesignAreas( java.math.BigDecimal value ) {
		this.__design_areas = value;
	}

	public java.math.BigDecimal getContractPrice() {
		return this.__contract_price;
	}

	public void setContractPrice( java.math.BigDecimal value ) {
		this.__contract_price = value;
	}

	public java.lang.String getProjectAddress() {
		return this.__project_address;
	}

	public void setProjectAddress( java.lang.String value ) {
		this.__project_address = value;
	}

	public java.lang.String getContractFollower() {
		return this.__contract_follower;
	}

	public void setContractFollower( java.lang.String value ) {
		this.__contract_follower = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
	}

	public java.lang.Integer getSigningCompanyName() {
		return this.__signing_company_name;
	}

	public void setSigningCompanyName( java.lang.Integer value ) {
		this.__signing_company_name = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.lang.String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.String value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getFlowStatus() {
		return this.__flow_status;
	}

	public void setFlowStatus( java.lang.Integer value ) {
		this.__flow_status = value;
	}

	public java.lang.String getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( java.lang.String value ) {
		this.__serial_number = value;
	}

	public java.lang.String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.String value ) {
		this.__project_type = value;
	}

	public java.math.BigDecimal getCoveredArea() {
		return this.__covered_area;
	}

	public void setCoveredArea( java.math.BigDecimal value ) {
		this.__covered_area = value;
	}

	public java.lang.String getProfessionalCooperation() {
		return this.__professional_cooperation;
	}

	public void setProfessionalCooperation( java.lang.String value ) {
		this.__professional_cooperation = value;
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

	public java.lang.String getDetailAddress() {
		return this.__detail_address;
	}

	public void setDetailAddress( java.lang.String value ) {
		this.__detail_address = value;
	}

	public java.lang.String getCustomerAddress() {
		return this.__customer_address;
	}

	public void setCustomerAddress( java.lang.String value ) {
		this.__customer_address = value;
	}

	public java.lang.String getServiceSuggestBook() {
		return this.__service_suggest_book;
	}

	public void setServiceSuggestBook( java.lang.String value ) {
		this.__service_suggest_book = value;
	}

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public java.lang.Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( java.lang.Integer value ) {
		this.__order_no = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	public java.lang.String getClientContractId() {
		return this.__client_contract_id;
	}

	public void setClientContractId( java.lang.String value ) {
		this.__client_contract_id = value;
	}

	public java.lang.Boolean getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( java.lang.Boolean value ) {
		this.__is_finish = value;
	}

	public java.lang.Boolean getIsSystemAdd() {
		return this.__is_system_add;
	}

	public void setIsSystemAdd( java.lang.Boolean value ) {
		this.__is_system_add = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.String getAttachmentRemark() {
		return this.__attachment_remark;
	}

	public void setAttachmentRemark( java.lang.String value ) {
		this.__attachment_remark = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.lang.Long getCount() {
		return this.__count;
	}

	public void setCount( java.lang.Long value ) {
		this.__count = value;
	}
	
	public java.math.BigDecimal getInvoiceAmount() {
		return __invoice_amount;
	}

	public void setInvoiceAmount(java.math.BigDecimal value) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return __project_amount;
	}

	public void setProjectAmount(java.math.BigDecimal value) {
		this.__project_amount = value;
	}

	public java.math.BigDecimal getCheckAmount() {
		return __check_amount;
	}

	public void setCheckAmount(java.math.BigDecimal value) {
		this.__check_amount = value;
	}

	public java.lang.Boolean getContractInfoAudited() {
		return __contract_info_audited;
	}

	public void setContractInfoAudited(java.lang.Boolean value) {
		this.__contract_info_audited = value;
	}

	public java.math.BigDecimal getCurrentBorrowMoney() {
		return __current_borrow_money;
	}

	public void setCurrentBorrowMoney(java.math.BigDecimal value) {
		this.__current_borrow_money = value;
	}

	public java.math.BigDecimal getCurrentAmount() {
		return __current_amount;
	}

	public void setCurrentAmount(java.math.BigDecimal value) {
		this.__current_amount = value;
	}

	public java.util.Date getCapitalDate() {
		return __capital_date;
	}

	public void setCapitalDate(java.util.Date value) {
		this.__capital_date = value;
	}

	public java.util.Date getSettlementDate() {
		return __settlement_date;
	}

	public void setSettlementDate(java.util.Date value) {
		this.__settlement_date = value;
	}

	public java.util.Date getInvoiceDate() {
		return __invoice_date;
	}

	public void setInvoiceDate(java.util.Date value) {
		this.__invoice_date = value;
	}

	public void cloneCopy(BaseMcontractcacccccaaaraabbifiior __bean){
		__bean.setContractId(getContractId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCustomerName(getCustomerName());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setStatus(getStatus());
		__bean.setProjectCode(getProjectCode());
		__bean.setContractType(getContractType());
		__bean.setProjectLevel(getProjectLevel());
		__bean.setTotalProjectTime(getTotalProjectTime());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setDesignAreas(getDesignAreas());
		__bean.setContractPrice(getContractPrice());
		__bean.setProjectAddress(getProjectAddress());
		__bean.setContractFollower(getContractFollower());
		__bean.setRemark(getRemark());
		__bean.setContractDate(getContractDate());
		__bean.setSigningCompanyName(getSigningCompanyName());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setBusinessType(getBusinessType());
		__bean.setFlowStatus(getFlowStatus());
		__bean.setSerialNumber(getSerialNumber());
		__bean.setProjectType(getProjectType());
		__bean.setCoveredArea(getCoveredArea());
		__bean.setProfessionalCooperation(getProfessionalCooperation());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setDetailAddress(getDetailAddress());
		__bean.setCustomerAddress(getCustomerAddress());
		__bean.setServiceSuggestBook(getServiceSuggestBook());
		__bean.setProjectApprovalTime(getProjectApprovalTime());
		__bean.setOrderNo(getOrderNo());
		__bean.setParentId(getParentId());
		__bean.setInfoCode(getInfoCode());
		__bean.setContractStatus(getContractStatus());
		__bean.setClientContractId(getClientContractId());
		__bean.setIsFinish(getIsFinish());
		__bean.setIsSystemAdd(getIsSystemAdd());
		__bean.setOperator(getOperator());
		__bean.setAttachmentRemark(getAttachmentRemark());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setCount(getCount());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setCheckAmount(getCheckAmount());
		__bean.setContractInfoAudited(getContractInfoAudited());
		__bean.setCurrentBorrowMoney(getCurrentBorrowMoney());
		__bean.setCurrentAmount(getCurrentAmount());
		__bean.setCapitalDate(getCapitalDate());
		__bean.setSettlementDate(getSettlementDate());
		__bean.setInvoiceDate(getInvoiceDate());
	}
	
	public java.lang.String setReplaceAll(String val){
		if(!BaseHelpUtils.isNullOrEmpty(val)){
			return val.replaceAll("\r", "").replaceAll("\n", "").replaceAll(",", "，");
		}
		return "";
	}
	
	public java.lang.String toCSVString1() {
		StringBuilder sb = new StringBuilder();
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_35", String.valueOf(getContractStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(setReplaceAll(getContractCode()));
		sb.append(",");
		sb.append(setReplaceAll(getContractName()));
		sb.append(",");
		sb.append(setReplaceAll(getCustomerName()));
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getDesignAreas() == null ? "" : getDesignAreas());
		sb.append(",");
		sb.append(getCurrentBorrowMoney() == null ? "" : getCurrentBorrowMoney());
		sb.append(",");
		sb.append(getCurrentAmount() == null ? "" : getCurrentAmount());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		sb.append(",");
		sb.append(getCheckAmount() == null ? "" : getCheckAmount());
		sb.append(",");
		sb.append(null == getInvoiceDate() ? "" : DateUtil.formatDateTimeString(getInvoiceDate()));
		return sb.toString();
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
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_39", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractType() == null ? "" : getContractType());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
		sb.append(",");
		sb.append(getTotalProjectTime() == null ? "" : getTotalProjectTime());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getDesignAreas() == null ? "" : getDesignAreas());
		sb.append(",");
		sb.append(getContractPrice() == null ? "" : getContractPrice());
		sb.append(",");
		sb.append(getProjectAddress() == null ? "" : getProjectAddress());
		sb.append(",");
		sb.append(getContractFollower() == null ? "" : getContractFollower());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getSigningCompanyName() == null ? "" : getSigningCompanyName());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getFlowStatus() == null ? "" : getFlowStatus());
		sb.append(",");
		sb.append(getSerialNumber() == null ? "" : getSerialNumber());
		sb.append(",");
		sb.append(getProjectType() == null ? "" : getProjectType());
		sb.append(",");
		sb.append(getCoveredArea() == null ? "" : getCoveredArea());
		sb.append(",");
		sb.append(getProfessionalCooperation() == null ? "" : getProfessionalCooperation());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getDetailAddress() == null ? "" : getDetailAddress());
		sb.append(",");
		sb.append(getCustomerAddress() == null ? "" : getCustomerAddress());
		sb.append(",");
		sb.append(getServiceSuggestBook() == null ? "" : getServiceSuggestBook());
		sb.append(",");
		sb.append(getProjectApprovalTime() == null ? "" : sdf.format(getProjectApprovalTime()));
		sb.append(",");
		sb.append(getOrderNo() == null ? "" : getOrderNo());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getInfoCode() == null ? "" : getInfoCode());
		sb.append(",");
		sb.append(getContractStatus() == null ? "" : getContractStatus());
		sb.append(",");
		sb.append(getClientContractId() == null ? "" : getClientContractId());
		sb.append(",");
		sb.append(getIsFinish() == null ? "" : getIsFinish());
		sb.append(",");
		sb.append(getIsSystemAdd() == null ? "" : getIsSystemAdd());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getAttachmentRemark() == null ? "" : getAttachmentRemark());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getCount() == null ? "" : getCount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcontractcacccccaaaraabbifiior o) {
		return __contract_id == null ? -1 : __contract_id.compareTo(o.getContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_type);
		hash = 97 * hash + Objects.hashCode(this.__project_level);
		hash = 97 * hash + Objects.hashCode(this.__total_project_time);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__design_areas);
		hash = 97 * hash + Objects.hashCode(this.__contract_price);
		hash = 97 * hash + Objects.hashCode(this.__project_address);
		hash = 97 * hash + Objects.hashCode(this.__contract_follower);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__contract_date);
		hash = 97 * hash + Objects.hashCode(this.__signing_company_name);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__flow_status);
		hash = 97 * hash + Objects.hashCode(this.__serial_number);
		hash = 97 * hash + Objects.hashCode(this.__project_type);
		hash = 97 * hash + Objects.hashCode(this.__covered_area);
		hash = 97 * hash + Objects.hashCode(this.__professional_cooperation);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__detail_address);
		hash = 97 * hash + Objects.hashCode(this.__customer_address);
		hash = 97 * hash + Objects.hashCode(this.__service_suggest_book);
		hash = 97 * hash + Objects.hashCode(this.__project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__order_no);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		hash = 97 * hash + Objects.hashCode(this.__client_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__is_finish);
		hash = 97 * hash + Objects.hashCode(this.__is_system_add);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__attachment_remark);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__count);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__check_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_info_audited);
		hash = 97 * hash + Objects.hashCode(this.__current_borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__current_amount);
		hash = 97 * hash + Objects.hashCode(this.__capital_date);
		hash = 97 * hash + Objects.hashCode(this.__settlement_date);
		hash = 97 * hash + Objects.hashCode(this.__invoice_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcontractcacccccaaaraabbifiior o = (BaseMcontractcacccccaaaraabbifiior)obj;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__contract_type, o.getContractType())) return false;
		if(!Objects.equals(this.__project_level, o.getProjectLevel())) return false;
		if(!Objects.equals(this.__total_project_time, o.getTotalProjectTime())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__design_areas, o.getDesignAreas())) return false;
		if(!Objects.equals(this.__contract_price, o.getContractPrice())) return false;
		if(!Objects.equals(this.__project_address, o.getProjectAddress())) return false;
		if(!Objects.equals(this.__contract_follower, o.getContractFollower())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__contract_date, o.getContractDate())) return false;
		if(!Objects.equals(this.__signing_company_name, o.getSigningCompanyName())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__flow_status, o.getFlowStatus())) return false;
		if(!Objects.equals(this.__serial_number, o.getSerialNumber())) return false;
		if(!Objects.equals(this.__project_type, o.getProjectType())) return false;
		if(!Objects.equals(this.__covered_area, o.getCoveredArea())) return false;
		if(!Objects.equals(this.__professional_cooperation, o.getProfessionalCooperation())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__detail_address, o.getDetailAddress())) return false;
		if(!Objects.equals(this.__customer_address, o.getCustomerAddress())) return false;
		if(!Objects.equals(this.__service_suggest_book, o.getServiceSuggestBook())) return false;
		if(!Objects.equals(this.__project_approval_time, o.getProjectApprovalTime())) return false;
		if(!Objects.equals(this.__order_no, o.getOrderNo())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		if(!Objects.equals(this.__client_contract_id, o.getClientContractId())) return false;
		if(!Objects.equals(this.__is_finish, o.getIsFinish())) return false;
		if(!Objects.equals(this.__is_system_add, o.getIsSystemAdd())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__attachment_remark, o.getAttachmentRemark())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__count, o.getCount())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__check_amount, o.getCheckAmount())) return false;
		if(!Objects.equals(this.__contract_info_audited, o.getContractInfoAudited())) return false;
		if(!Objects.equals(this.__current_borrow_money, o.getCurrentBorrowMoney())) return false;
		if(!Objects.equals(this.__current_amount, o.getCurrentAmount())) return false;
		if(!Objects.equals(this.__capital_date, o.getCapitalDate())) return false;
		if(!Objects.equals(this.__settlement_date, o.getSettlementDate())) return false;
		if(!Objects.equals(this.__invoice_date, o.getInvoiceDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractType() != null) sb.append(__wrapNumber(count++, "contractType", getContractType()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(count++, "projectLevel", getProjectLevel()));
		if(getTotalProjectTime() != null) sb.append(__wrapNumber(count++, "totalProjectTime", getTotalProjectTime()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getDesignAreas() != null) sb.append(__wrapDecimal(count++, "designAreas", getDesignAreas()));
		if(getContractPrice() != null) sb.append(__wrapDecimal(count++, "contractPrice", getContractPrice()));
		if(getProjectAddress() != null) sb.append(__wrapString(count++, "projectAddress", getProjectAddress()));
		if(getContractFollower() != null) sb.append(__wrapString(count++, "contractFollower", getContractFollower()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getContractDate() != null) sb.append(__wrapDate(count++, "contractDate", getContractDate()));
		if(getSigningCompanyName() != null) sb.append(__wrapNumber(count++, "signingCompanyName", getSigningCompanyName()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getBusinessType() != null) sb.append(__wrapString(count++, "businessType", getBusinessType()));
		if(getFlowStatus() != null) sb.append(__wrapNumber(count++, "flowStatus", getFlowStatus()));
		if(getSerialNumber() != null) sb.append(__wrapString(count++, "serialNumber", getSerialNumber()));
		if(getProjectType() != null) sb.append(__wrapString(count++, "projectType", getProjectType()));
		if(getCoveredArea() != null) sb.append(__wrapDecimal(count++, "coveredArea", getCoveredArea()));
		if(getProfessionalCooperation() != null) sb.append(__wrapString(count++, "professionalCooperation", getProfessionalCooperation()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getDetailAddress() != null) sb.append(__wrapString(count++, "detailAddress", getDetailAddress()));
		if(getCustomerAddress() != null) sb.append(__wrapString(count++, "customerAddress", getCustomerAddress()));
		if(getServiceSuggestBook() != null) sb.append(__wrapString(count++, "serviceSuggestBook", getServiceSuggestBook()));
		if(getProjectApprovalTime() != null) sb.append(__wrapDate(count++, "projectApprovalTime", getProjectApprovalTime()));
		if(getOrderNo() != null) sb.append(__wrapNumber(count++, "orderNo", getOrderNo()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getContractStatus() != null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		if(getClientContractId() != null) sb.append(__wrapString(count++, "clientContractId", getClientContractId()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(count++, "isFinish", getIsFinish()));
		if(getIsSystemAdd() != null) sb.append(__wrapBoolean(count++, "isSystemAdd", getIsSystemAdd()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getAttachmentRemark() != null) sb.append(__wrapString(count++, "attachmentRemark", getAttachmentRemark()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getCount() != null) sb.append(__wrapNumber(count++, "count", getCount()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getCheckAmount() != null) sb.append(__wrapDecimal(count++, "checkAmount", getCheckAmount()));
		if(getContractInfoAudited() != null) sb.append(__wrapBoolean(count++, "contractInfoAudited", getContractInfoAudited()));
		if(getCurrentBorrowMoney() != null) sb.append(__wrapDecimal(count++, "currentBorrowMoney", getCurrentBorrowMoney()));
		if(getCurrentAmount() != null) sb.append(__wrapDecimal(count++, "currentAmount", getCurrentAmount()));
		if(getCapitalDate() != null) sb.append(__wrapDate(count++, "capitalDate", getCapitalDate()));
		if(getSettlementDate() != null) sb.append(__wrapDate(count++, "settlementDate", getSettlementDate()));
		if(getInvoiceDate() != null) sb.append(__wrapDate(count++, "invoiceDate", getInvoiceDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractType")) != null) setContractType(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("totalProjectTime")) != null) setTotalProjectTime(__getInt(val)); 
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("designAreas")) != null) setDesignAreas(__getDecimal(val));  
		if((val = values.get("contractPrice")) != null) setContractPrice(__getDecimal(val));  
		if((val = values.get("projectAddress")) != null) setProjectAddress(__getString(val));
		if((val = values.get("contractFollower")) != null) setContractFollower(__getString(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("contractDate")) != null) setContractDate(__getDate(val)); 
		if((val = values.get("signingCompanyName")) != null) setSigningCompanyName(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getString(val));
		if((val = values.get("flowStatus")) != null) setFlowStatus(__getInt(val)); 
		if((val = values.get("serialNumber")) != null) setSerialNumber(__getString(val));
		if((val = values.get("projectType")) != null) setProjectType(__getString(val));
		if((val = values.get("coveredArea")) != null) setCoveredArea(__getDecimal(val));  
		if((val = values.get("professionalCooperation")) != null) setProfessionalCooperation(__getString(val));
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("detailAddress")) != null) setDetailAddress(__getString(val));
		if((val = values.get("customerAddress")) != null) setCustomerAddress(__getString(val));
		if((val = values.get("serviceSuggestBook")) != null) setServiceSuggestBook(__getString(val));
		if((val = values.get("projectApprovalTime")) != null) setProjectApprovalTime(__getDate(val)); 
		if((val = values.get("orderNo")) != null) setOrderNo(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("clientContractId")) != null) setClientContractId(__getString(val));
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
		if((val = values.get("isSystemAdd")) != null) setIsSystemAdd(__getBoolean(val));
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("attachmentRemark")) != null) setAttachmentRemark(__getString(val));
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("count")) != null) setCount(__getLong(val)); 
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("checkAmount")) != null) setCheckAmount(__getDecimal(val)); 
		if((val = values.get("contractInfoAudited")) != null) setContractInfoAudited(__getBoolean(val));
		if((val = values.get("currentBorrowMoney")) != null) setCurrentBorrowMoney(__getDecimal(val)); 
		if((val = values.get("currentAmount")) != null) setCurrentAmount(__getDecimal(val)); 
		if((val = values.get("capitalDate")) != null) setCapitalDate(__getDate(val)); 
		if((val = values.get("settlementDate")) != null) setSettlementDate(__getDate(val)); 
		if((val = values.get("invoiceDate")) != null) setInvoiceDate(__getDate(val));
	}

	protected java.lang.Integer  __contract_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __customer_name ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __contract_type ;
	protected java.lang.Integer  __project_level ;
	protected java.lang.Integer  __total_project_time ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected java.math.BigDecimal  __design_areas ;
	protected java.math.BigDecimal  __contract_price ;
	protected java.lang.String  __project_address ;
	protected java.lang.String  __contract_follower ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __contract_date ;
	protected java.lang.Integer  __signing_company_name ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.lang.String  __business_type ;
	protected java.lang.Integer  __flow_status ;
	protected java.lang.String  __serial_number ;
	protected java.lang.String  __project_type ;
	protected java.math.BigDecimal  __covered_area ;
	protected java.lang.String  __professional_cooperation ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.String  __detail_address ;
	protected java.lang.String  __customer_address ;
	protected java.lang.String  __service_suggest_book ;
	protected java.util.Date  __project_approval_time ;
	protected java.lang.Integer  __order_no ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __info_code ;
	protected java.lang.Integer  __contract_status ;
	protected java.lang.String  __client_contract_id ;
	protected java.lang.Boolean  __is_finish ;
	protected java.lang.Boolean  __is_system_add ;
	protected java.lang.Integer  __operator ;
	protected java.lang.String  __attachment_remark ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.lang.Long  __count ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.math.BigDecimal  __check_amount ;
	protected java.lang.Boolean  __contract_info_audited ;
	protected java.math.BigDecimal  __current_borrow_money ;
	protected java.math.BigDecimal  __current_amount ;
	protected java.util.Date  __capital_date ;
	protected java.util.Date  __settlement_date;
	protected java.util.Date  __invoice_date;
}
