package pomplatform.newcontractppcor.bean;

import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;
import delicacy.date.util.DateUtil;

public class BaseScontractppcor extends GenericBase implements BaseFactory<BaseScontractppcor>, Comparable<BaseScontractppcor> 
{


	public static BaseScontractppcor newInstance(){
		return new BaseScontractppcor();
	}

	@Override
	public BaseScontractppcor make(){
		BaseScontractppcor b = new BaseScontractppcor();
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
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_CONTRACT_SIGNING_STATUS = "contract_signing_status" ;
	public final static java.lang.String CS_SENDING_DATE = "sending_date" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_RELEVANT_EMPLOYEES = "relevant_employees" ;
	public final static java.lang.String CS_RELEVANT_EMPLOYEES_NAME = "relevant_employees_name" ;
	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_BORROW_MONEY_SUM = "borrow_money_sum" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_NO_BORROW_MONEY_SUM = "no_borrow_money_sum" ;
	public final static java.lang.String CS_NO_PERCENT = "no_percent" ;
	public final static java.lang.String CS_PERCENT_SUM = "percent_sum" ;
	public final static java.lang.String CS_GROUP_NAME = "group_name" ;
	public final static java.lang.String CS_SIGN_COMPANY = "sign_company" ;
	public final static java.lang.String CS_PRE_PROJECT_TYPE = "pre_project_type" ;
	public final static java.lang.String CS_MAIN_PROJECT_TYPE = "main_project_type" ;
	public final static java.lang.String CS_HAVE_INVOICE_AMOUNT = "have_invoice_amount" ;
	public final static java.lang.String CS_UN_INVOICE_AMOUNT = "un_invoice_amount" ;
	public final static java.lang.String CS_DESIGN_TEAM = "design_team" ;
	public final static java.lang.String CS_PROJECT_SECRETARY = "project_secretary" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;
	public final static java.lang.String CS_PROJECT_LEADER = "project_leader" ;
	public final static java.lang.String CS_MAIN_PROJECT_APPROVAL_TIME = "main_project_approval_time" ;
	public final static java.lang.String CS_PAYABLE_BUT_NOT_PAID = "payable_but_not_paid" ;

	//public final static java.lang.String ALL_CAPTIONS = "主订单编码,主订单编号,主订单名称,客户名称,项目开始日期,项目结束日期,项目状态,项目编号,合同类别,项目等级,项目总工期,签约总金额,总设计面积,合同单价,项目地点,合同跟进人,备注,合同签订日期,我方签约公司名称,创建时间,修改时间,业务类别,流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成,流水号,项目类别,建筑面积,配合专业,省份,城市,详细地址,客户地址,服务建议书,立单时间 提交了立单时间会将保存下来，只是点击保存不会将当前时间保存下来，单每次都会显示当前的时间，提交了下次显示的就是提交时的立单时间,标记补充协议字段；除0之外，其他都表示第n个补充协议,是否为630项目，0是   1不是       默认值为0,信息编号,合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除,客户合同编号,操作人,,合同签订状态  1已寄出  2已签订,合同寄出日期,归属部门,合同跟进相关人员,合同跟进人员名称,客户编码,,占比(%),,,,,拟签约公司,,,已开票金额,,主办设计团队,,,,,";
	public final static java.lang.String ALL_CAPTIONS = "合同编号,合同名称,合同附件,集团名称,客户名称,项目编号,合同类别,项目等级,项目总工期,项目类型,立项类型,签约总金额,回款金额,回款率,设计阶段比例%,应支付但未支付金额,已开票金额,主办设计团队,项目秘书,项目负责人,项目主管领导,立项时间,未收款,未收款比例%,总设计面积,项目地点,合同跟进人,备注,我方签约公司名称,业务类别,客户地址,合同签订状态,合同签订日期,合同寄出日期,创建时间,修改时间,操作人,合同状态";

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

	public java.lang.Integer getContractFollower() {
		return this.__contract_follower;
	}

	public void setContractFollower( java.lang.Integer value ) {
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

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.lang.Integer getContractSigningStatus() {
		return this.__contract_signing_status;
	}

	public void setContractSigningStatus( java.lang.Integer value ) {
		this.__contract_signing_status = value;
	}

	public java.util.Date getSendingDate() {
		return this.__sending_date;
	}

	public void setSendingDate( java.util.Date value ) {
		this.__sending_date = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getRelevantEmployees() {
		return this.__relevant_employees;
	}

	public void setRelevantEmployees( java.lang.String value ) {
		this.__relevant_employees = value;
	}

	public java.lang.String getRelevantEmployeesName() {
		return this.__relevant_employees_name;
	}

	public void setRelevantEmployeesName( java.lang.String value ) {
		this.__relevant_employees_name = value;
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.math.BigDecimal getBorrowMoneySum() {
		return this.__borrow_money_sum;
	}

	public void setBorrowMoneySum( java.math.BigDecimal value ) {
		this.__borrow_money_sum = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.math.BigDecimal getNoBorrowMoneySum() {
		return this.__no_borrow_money_sum;
	}

	public void setNoBorrowMoneySum( java.math.BigDecimal value ) {
		this.__no_borrow_money_sum = value;
	}

	public java.math.BigDecimal getNoPercent() {
		return this.__no_percent;
	}

	public void setNoPercent( java.math.BigDecimal value ) {
		this.__no_percent = value;
	}

	public java.math.BigDecimal getPercentSum() {
		return this.__percent_sum;
	}

	public void setPercentSum( java.math.BigDecimal value ) {
		this.__percent_sum = value;
	}

	public java.lang.Integer getGroupName() {
		return this.__group_name;
	}

	public void setGroupName( java.lang.Integer value ) {
		this.__group_name = value;
	}

	public java.lang.Integer getSignCompany() {
		return this.__sign_company;
	}

	public void setSignCompany( java.lang.Integer value ) {
		this.__sign_company = value;
	}

	public java.lang.Integer getPreProjectType() {
		return this.__pre_project_type;
	}

	public void setPreProjectType( java.lang.Integer value ) {
		this.__pre_project_type = value;
	}

	public java.lang.Integer getMainProjectType() {
		return this.__main_project_type;
	}

	public void setMainProjectType( java.lang.Integer value ) {
		this.__main_project_type = value;
	}

	public java.math.BigDecimal getHaveInvoiceAmount() {
		return this.__have_invoice_amount;
	}

	public void setHaveInvoiceAmount( java.math.BigDecimal value ) {
		this.__have_invoice_amount = value;
	}

	public java.math.BigDecimal getUnInvoiceAmount() {
		return this.__un_invoice_amount;
	}

	public void setUnInvoiceAmount( java.math.BigDecimal value ) {
		this.__un_invoice_amount = value;
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.String getProjectSecretary() {
		return this.__project_secretary;
	}

	public void setProjectSecretary( java.lang.String value ) {
		this.__project_secretary = value;
	}

	public java.lang.String getProjectManager() {
		return this.__project_manager;
	}

	public void setProjectManager( java.lang.String value ) {
		this.__project_manager = value;
	}

	public java.lang.String getProjectLeader() {
		return this.__project_leader;
	}

	public void setProjectLeader( java.lang.String value ) {
		this.__project_leader = value;
	}

	public java.util.Date getMainProjectApprovalTime() {
		return this.__main_project_approval_time;
	}

	public void setMainProjectApprovalTime( java.util.Date value ) {
		this.__main_project_approval_time = value;
	}

	public java.math.BigDecimal getPayableButNotPaid() {
		return this.__payable_but_not_paid;
	}

	public void setPayableButNotPaid( java.math.BigDecimal value ) {
		this.__payable_but_not_paid = value;
	}

	public void cloneCopy(BaseScontractppcor __bean){
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
		__bean.setOperator(getOperator());
		__bean.setFlag(getFlag());
		__bean.setContractSigningStatus(getContractSigningStatus());
		__bean.setSendingDate(getSendingDate());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setRelevantEmployees(getRelevantEmployees());
		__bean.setRelevantEmployeesName(getRelevantEmployeesName());
		__bean.setCustomerId(getCustomerId());
		__bean.setBorrowMoneySum(getBorrowMoneySum());
		__bean.setPercent(getPercent());
		__bean.setNoBorrowMoneySum(getNoBorrowMoneySum());
		__bean.setNoPercent(getNoPercent());
		__bean.setPercentSum(getPercentSum());
		__bean.setGroupName(getGroupName());
		__bean.setSignCompany(getSignCompany());
		__bean.setPreProjectType(getPreProjectType());
		__bean.setMainProjectType(getMainProjectType());
		__bean.setHaveInvoiceAmount(getHaveInvoiceAmount());
		__bean.setUnInvoiceAmount(getUnInvoiceAmount());
		__bean.setDesignTeam(getDesignTeam());
		__bean.setProjectSecretary(getProjectSecretary());
		__bean.setProjectManager(getProjectManager());
		__bean.setProjectLeader(getProjectLeader());
		__bean.setMainProjectApprovalTime(getMainProjectApprovalTime());
		__bean.setPayableButNotPaid(getPayableButNotPaid());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
//		sb.append(getContractId() == null ? "" : getContractId());
//		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getServiceSuggestBook() == null ? "" : "http://erp.jaid.cn" + getServiceSuggestBook());
		sb.append(",");
		String strGroupName = delicacy.system.executor.SelectValueCache.getSelectValue("parent_customers_name", String.valueOf(getGroupName()));
		sb.append(strGroupName == null ? "" : strGroupName);
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
//		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
//		sb.append(",");
//		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
//		sb.append(",");
//		sb.append(getStatus() == null ? "" : getStatus());
//		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		String strContractType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_27", String.valueOf(getContractType()));
		sb.append(strContractType == null ? "" : strContractType);
		sb.append(",");
		String strProjectLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_2", String.valueOf(getProjectLevel()));
		sb.append(strProjectLevel == null ? "" : strProjectLevel);
		sb.append(",");
		sb.append(getTotalProjectTime() == null ? "" : getTotalProjectTime());
		sb.append(",");
		String strPreProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_244", String.valueOf(getPreProjectType()));
		sb.append(strPreProjectType == null ? "" : strPreProjectType);
		sb.append(",");
		String strMainProjectType = delicacy.system.executor.SelectValueCache.getSelectValue("main_project_stages", String.valueOf(getMainProjectType()));
		sb.append(strMainProjectType == null ? "" : strMainProjectType);
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getBorrowMoneySum() == null ? "" : getBorrowMoneySum());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_DOWN)+"%");
		sb.append(",");
		sb.append(getPercentSum() == null ? "" : getPercentSum().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getPayableButNotPaid() == null ? "" : getPayableButNotPaid());
		sb.append(",");
		sb.append(getHaveInvoiceAmount() == null ? "" : getHaveInvoiceAmount());
		sb.append(",");
//		sb.append(getUnInvoiceAmount() == null ? "" : getUnInvoiceAmount());
//		sb.append(",");
		String strDesignTeam = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getDesignTeam()));
		sb.append(strDesignTeam == null ? "" : strDesignTeam);
		sb.append(",");
		sb.append(getProjectSecretary() == null ? "" : getProjectSecretary());
		sb.append(",");
		sb.append(getProjectManager() == null ? "" : getProjectManager());
		sb.append(",");
		sb.append(getProjectLeader() == null ? "" : getProjectLeader());
		sb.append(",");
		sb.append(getMainProjectApprovalTime() == null ? "" : sdf.format(getMainProjectApprovalTime()));
		sb.append(",");
		sb.append(getNoBorrowMoneySum() == null ? "" : getNoBorrowMoneySum());
		sb.append(",");
		sb.append(getNoPercent() == null ? "" : getNoPercent().multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_DOWN)+"%");
		sb.append(",");
		sb.append(getDesignAreas() == null ? "" : getDesignAreas());
		sb.append(",");
		sb.append(getProjectAddress() == null ? "" : getProjectAddress());
		sb.append(",");
		sb.append(getContractFollower() == null ? "" : getContractFollower());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
//		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
//		sb.append(",");
		String strSigningCompanyName = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getSigningCompanyName()));
		sb.append(strSigningCompanyName == null ? "" : strSigningCompanyName);
		sb.append(",");
//		sb.append(getContractPrice() == null ? "" : getContractPrice());
//		sb.append(",");
		String strBusinessType = delicacy.system.executor.SelectValueCache.getSelectValue("production_value_coefficient_type", String.valueOf(getBusinessType()));
		sb.append(strBusinessType == null ? "" : strBusinessType);
		sb.append(",");
		sb.append(getCustomerAddress() == null ? "" : getCustomerAddress());
		sb.append(",");
		String contractSigningStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_139", String.valueOf(getContractSigningStatus()));
		sb.append(contractSigningStatus == null ? "" : contractSigningStatus);
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getSendingDate() == null ? "" : DateUtil.formatDateString(getSendingDate()));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");

		String strOperator = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperator()));
		sb.append(strOperator == null ? "" : strOperator);
		sb.append(",");
		String strContractStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_35", String.valueOf(getContractStatus()));
		sb.append(strContractStatus == null ? "" : strContractStatus);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseScontractppcor o) {
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
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__contract_signing_status);
		hash = 97 * hash + Objects.hashCode(this.__sending_date);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__relevant_employees);
		hash = 97 * hash + Objects.hashCode(this.__relevant_employees_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__no_borrow_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__no_percent);
		hash = 97 * hash + Objects.hashCode(this.__percent_sum);
		hash = 97 * hash + Objects.hashCode(this.__group_name);
		hash = 97 * hash + Objects.hashCode(this.__sign_company);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_type);
		hash = 97 * hash + Objects.hashCode(this.__main_project_type);
		hash = 97 * hash + Objects.hashCode(this.__have_invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__un_invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__design_team);
		hash = 97 * hash + Objects.hashCode(this.__project_secretary);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		hash = 97 * hash + Objects.hashCode(this.__project_leader);
		hash = 97 * hash + Objects.hashCode(this.__main_project_approval_time);
		hash = 97 * hash + Objects.hashCode(this.__payable_but_not_paid);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseScontractppcor o = (BaseScontractppcor)obj;
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
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__contract_signing_status, o.getContractSigningStatus())) return false;
		if(!Objects.equals(this.__sending_date, o.getSendingDate())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__relevant_employees, o.getRelevantEmployees())) return false;
		if(!Objects.equals(this.__relevant_employees_name, o.getRelevantEmployeesName())) return false;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__borrow_money_sum, o.getBorrowMoneySum())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__no_borrow_money_sum, o.getNoBorrowMoneySum())) return false;
		if(!Objects.equals(this.__no_percent, o.getNoPercent())) return false;
		if(!Objects.equals(this.__percent_sum, o.getPercentSum())) return false;
		if(!Objects.equals(this.__group_name, o.getGroupName())) return false;
		if(!Objects.equals(this.__sign_company, o.getSignCompany())) return false;
		if(!Objects.equals(this.__pre_project_type, o.getPreProjectType())) return false;
		if(!Objects.equals(this.__main_project_type, o.getMainProjectType())) return false;
		if(!Objects.equals(this.__have_invoice_amount, o.getHaveInvoiceAmount())) return false;
		if(!Objects.equals(this.__un_invoice_amount, o.getUnInvoiceAmount())) return false;
		if(!Objects.equals(this.__design_team, o.getDesignTeam())) return false;
		if(!Objects.equals(this.__project_secretary, o.getProjectSecretary())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		if(!Objects.equals(this.__project_leader, o.getProjectLeader())) return false;
		if(!Objects.equals(this.__main_project_approval_time, o.getMainProjectApprovalTime())) return false;
		if(!Objects.equals(this.__payable_but_not_paid, o.getPayableButNotPaid())) return false;
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
		if(getContractFollower() != null) sb.append(__wrapNumber(count++, "contractFollower", getContractFollower()));
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
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getContractSigningStatus() != null) sb.append(__wrapNumber(count++, "contractSigningStatus", getContractSigningStatus()));
		if(getSendingDate() != null) sb.append(__wrapDate(count++, "sendingDate", getSendingDate()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getRelevantEmployees() != null) sb.append(__wrapString(count++, "relevantEmployees", getRelevantEmployees()));
		if(getRelevantEmployeesName() != null) sb.append(__wrapString(count++, "relevantEmployeesName", getRelevantEmployeesName()));
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getBorrowMoneySum() != null) sb.append(__wrapDecimal(count++, "borrowMoneySum", getBorrowMoneySum()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getNoBorrowMoneySum() != null) sb.append(__wrapDecimal(count++, "noBorrowMoneySum", getNoBorrowMoneySum()));
		if(getNoPercent() != null) sb.append(__wrapDecimal(count++, "noPercent", getNoPercent()));
		if(getPercentSum() != null) sb.append(__wrapDecimal(count++, "percentSum", getPercentSum()));
		if(getGroupName() != null) sb.append(__wrapNumber(count++, "groupName", getGroupName()));
		if(getSignCompany() != null) sb.append(__wrapNumber(count++, "signCompany", getSignCompany()));
		if(getPreProjectType() != null) sb.append(__wrapNumber(count++, "preProjectType", getPreProjectType()));
		if(getMainProjectType() != null) sb.append(__wrapNumber(count++, "mainProjectType", getMainProjectType()));
		if(getHaveInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "haveInvoiceAmount", getHaveInvoiceAmount()));
		if(getUnInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "unInvoiceAmount", getUnInvoiceAmount()));
		if(getDesignTeam() != null) sb.append(__wrapNumber(count++, "designTeam", getDesignTeam()));
		if(getProjectSecretary() != null) sb.append(__wrapString(count++, "projectSecretary", getProjectSecretary()));
		if(getProjectManager() != null) sb.append(__wrapString(count++, "projectManager", getProjectManager()));
		if(getProjectLeader() != null) sb.append(__wrapString(count++, "projectLeader", getProjectLeader()));
		if(getMainProjectApprovalTime() != null) sb.append(__wrapDate(count++, "mainProjectApprovalTime", getMainProjectApprovalTime()));
		if(getPayableButNotPaid() != null) sb.append(__wrapDecimal(count++, "payableButNotPaid", getPayableButNotPaid()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getContractId() != null) res.put("contractId", getContractId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getCustomerName() != null) res.put("customerName", getCustomerName());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getStatus() != null) res.put("status", getStatus());
		if(getProjectCode() != null) res.put("projectCode", getProjectCode());
		if(getContractType() != null) res.put("contractType", getContractType());
		if(getProjectLevel() != null) res.put("projectLevel", getProjectLevel());
		if(getTotalProjectTime() != null) res.put("totalProjectTime", getTotalProjectTime());
		if(getSigningMoneySum() != null) res.put("signingMoneySum", getSigningMoneySum());
		if(getDesignAreas() != null) res.put("designAreas", getDesignAreas());
		if(getContractPrice() != null) res.put("contractPrice", getContractPrice());
		if(getProjectAddress() != null) res.put("projectAddress", getProjectAddress());
		if(getContractFollower() != null) res.put("contractFollower", getContractFollower());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getContractDate() != null) res.put("contractDate", getContractDate());
		if(getSigningCompanyName() != null) res.put("signingCompanyName", getSigningCompanyName());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getUpdateTime() != null) res.put("updateTime", getUpdateTime());
		if(getBusinessType() != null) res.put("businessType", getBusinessType());
		if(getFlowStatus() != null) res.put("flowStatus", getFlowStatus());
		if(getSerialNumber() != null) res.put("serialNumber", getSerialNumber());
		if(getProjectType() != null) res.put("projectType", getProjectType());
		if(getCoveredArea() != null) res.put("coveredArea", getCoveredArea());
		if(getProfessionalCooperation() != null) res.put("professionalCooperation", getProfessionalCooperation());
		if(getProvince() != null) res.put("province", getProvince());
		if(getCity() != null) res.put("city", getCity());
		if(getDetailAddress() != null) res.put("detailAddress", getDetailAddress());
		if(getCustomerAddress() != null) res.put("customerAddress", getCustomerAddress());
		if(getServiceSuggestBook() != null) res.put("serviceSuggestBook", getServiceSuggestBook());
		if(getProjectApprovalTime() != null) res.put("projectApprovalTime", getProjectApprovalTime());
		if(getOrderNo() != null) res.put("orderNo", getOrderNo());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getContractStatus() != null) res.put("contractStatus", getContractStatus());
		if(getClientContractId() != null) res.put("clientContractId", getClientContractId());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getFlag() != null) res.put("flag", getFlag());
		if(getContractSigningStatus() != null) res.put("contractSigningStatus", getContractSigningStatus());
		if(getSendingDate() != null) res.put("sendingDate", getSendingDate());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getRelevantEmployees() != null) res.put("relevantEmployees", getRelevantEmployees());
		if(getRelevantEmployeesName() != null) res.put("relevantEmployeesName", getRelevantEmployeesName());
		if(getCustomerId() != null) res.put("customerId", getCustomerId());
		if(getBorrowMoneySum() != null) res.put("borrowMoneySum", getBorrowMoneySum());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getNoBorrowMoneySum() != null) res.put("noBorrowMoneySum", getNoBorrowMoneySum());
		if(getNoPercent() != null) res.put("noPercent", getNoPercent());
		if(getPercentSum() != null) res.put("percentSum", getPercentSum());
		if(getGroupName() != null) res.put("groupName", getGroupName());
		if(getSignCompany() != null) res.put("signCompany", getSignCompany());
		if(getPreProjectType() != null) res.put("preProjectType", getPreProjectType());
		if(getMainProjectType() != null) res.put("mainProjectType", getMainProjectType());
		if(getHaveInvoiceAmount() != null) res.put("haveInvoiceAmount", getHaveInvoiceAmount());
		if(getUnInvoiceAmount() != null) res.put("unInvoiceAmount", getUnInvoiceAmount());
		if(getDesignTeam() != null) res.put("designTeam", getDesignTeam());
		if(getProjectSecretary() != null) res.put("projectSecretary", getProjectSecretary());
		if(getProjectManager() != null) res.put("projectManager", getProjectManager());
		if(getProjectLeader() != null) res.put("projectLeader", getProjectLeader());
		if(getMainProjectApprovalTime() != null) res.put("mainProjectApprovalTime", getMainProjectApprovalTime());
		if(getPayableButNotPaid() != null) res.put("payableButNotPaid", getPayableButNotPaid());
		return res;
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
		if((val = values.get("contractFollower")) != null) setContractFollower(__getInt(val));
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
		if((val = values.get("operator")) != null) setOperator(__getInt(val));
		if((val = values.get("flag")) != null) setFlag(__getInt(val));
		if((val = values.get("contractSigningStatus")) != null) setContractSigningStatus(__getInt(val));
		if((val = values.get("sendingDate")) != null) setSendingDate(__getDate(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val));
		if((val = values.get("relevantEmployees")) != null) setRelevantEmployees(__getString(val));
		if((val = values.get("relevantEmployeesName")) != null) setRelevantEmployeesName(__getString(val));
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val));
		if((val = values.get("borrowMoneySum")) != null) setBorrowMoneySum(__getDecimal(val));
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));
		if((val = values.get("noBorrowMoneySum")) != null) setNoBorrowMoneySum(__getDecimal(val));
		if((val = values.get("noPercent")) != null) setNoPercent(__getDecimal(val));
		if((val = values.get("percentSum")) != null) setPercentSum(__getDecimal(val));
		if((val = values.get("groupName")) != null) setGroupName(__getInt(val));
		if((val = values.get("signCompany")) != null) setSignCompany(__getInt(val));
		if((val = values.get("preProjectType")) != null) setPreProjectType(__getInt(val));
		if((val = values.get("mainProjectType")) != null) setMainProjectType(__getInt(val));
		if((val = values.get("haveInvoiceAmount")) != null) setHaveInvoiceAmount(__getDecimal(val));
		if((val = values.get("unInvoiceAmount")) != null) setUnInvoiceAmount(__getDecimal(val));
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val));
		if((val = values.get("projectSecretary")) != null) setProjectSecretary(__getString(val));
		if((val = values.get("projectManager")) != null) setProjectManager(__getString(val));
		if((val = values.get("projectLeader")) != null) setProjectLeader(__getString(val));
		if((val = values.get("mainProjectApprovalTime")) != null) setMainProjectApprovalTime(__getDate(val));
		if((val = values.get("payableButNotPaid")) != null) setPayableButNotPaid(__getDecimal(val));
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
	protected java.lang.Integer  __contract_follower ;
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
	protected java.lang.Integer  __operator ;
	protected java.lang.Integer  __flag ;
	protected java.lang.Integer  __contract_signing_status ;
	protected java.util.Date  __sending_date ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __relevant_employees ;
	protected java.lang.String  __relevant_employees_name ;
	protected java.lang.Integer  __customer_id ;
	protected java.math.BigDecimal  __borrow_money_sum ;
	protected java.math.BigDecimal  __percent ;
	protected java.math.BigDecimal  __no_borrow_money_sum ;
	protected java.math.BigDecimal  __no_percent ;
	protected java.math.BigDecimal  __percent_sum ;
	protected java.lang.Integer  __group_name ;
	protected java.lang.Integer  __sign_company ;
	protected java.lang.Integer  __pre_project_type ;
	protected java.lang.Integer  __main_project_type ;
	protected java.math.BigDecimal  __have_invoice_amount ;
	protected java.math.BigDecimal  __un_invoice_amount ;
	protected java.lang.Integer  __design_team ;
	protected java.lang.String  __project_secretary ;
	protected java.lang.String  __project_manager ;
	protected java.lang.String  __project_leader ;
	protected java.util.Date  __main_project_approval_time ;
	protected java.math.BigDecimal  __payable_but_not_paid ;
}
