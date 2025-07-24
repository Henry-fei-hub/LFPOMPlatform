package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOrderInfo extends GenericBase implements BaseFactory<BaseOrderInfo>, Comparable<BaseOrderInfo> 
{


	public static BaseOrderInfo newInstance(){
		return new BaseOrderInfo();
	}

	@Override
	public BaseOrderInfo make(){
		BaseOrderInfo b = new BaseOrderInfo();
		return b;
	}

	public final static String CS_ORDER_INFO_ID = "order_info_id" ;
	public final static String CS_CONTRACT_ID = "contract_id" ;
	public final static String CS_CONTRACT_CODE = "contract_code" ;
	public final static String CS_CONTRACT_NAME = "contract_name" ;
	public final static String CS_CUSTOMER_NAME = "customer_name" ;
	public final static String CS_START_DATE = "start_date" ;
	public final static String CS_END_DATE = "end_date" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_PROJECT_CODE = "project_code" ;
	public final static String CS_CONTRACT_TYPE = "contract_type" ;
	public final static String CS_PROJECT_LEVEL = "project_level" ;
	public final static String CS_CONTRACT_PRICE = "contract_price" ;
	public final static String CS_PROJECT_ADDRESS = "project_address" ;
	public final static String CS_CONTRACT_FOLLOWER = "contract_follower" ;
	public final static String CS_REMARK = "remark" ;
	public final static String CS_CONTRACT_DATE = "contract_date" ;
	public final static String CS_SIGNING_COMPANY_NAME = "signing_company_name" ;
	public final static String CS_CREATE_TIME = "create_time" ;
	public final static String CS_UPDATE_TIME = "update_time" ;
	public final static String CS_BUSINESS_TYPE = "business_type" ;
	public final static String CS_FLOW_STATUS = "flow_status" ;
	public final static String CS_SERIAL_NUMBER = "serial_number" ;
	public final static String CS_PROJECT_TYPE = "project_type" ;
	public final static String CS_COVERED_AREA = "covered_area" ;
	public final static String CS_PROFESSIONAL_COOPERATION = "professional_cooperation" ;
	public final static String CS_PROVINCE = "province" ;
	public final static String CS_CITY = "city" ;
	public final static String CS_DETAIL_ADDRESS = "detail_address" ;
	public final static String CS_CUSTOMER_ADDRESS = "customer_address" ;
	public final static String CS_SERVICE_SUGGEST_BOOK = "service_suggest_book" ;
	public final static String CS_PROJECT_APPROVAL_TIME = "project_approval_time" ;
	public final static String CS_ORDER_NO = "order_no" ;
	public final static String CS_INFO_CODE = "info_code" ;
	public final static String CS_CONTRACT_STATUS = "contract_status" ;
	public final static String CS_CLIENT_CONTRACT_ID = "client_contract_id" ;
	public final static String CS_IS_FINISH = "is_finish" ;
	public final static String CS_IS_SYSTEM_ADD = "is_system_add" ;
	public final static String CS_HAS_OUT_QUOTATIONS = "has_out_quotations" ;
	public final static String CS_FILE_ID = "file_id" ;
	public final static String CS_FILE_URL = "file_url" ;
	public final static String CS_TOTAL_PROJECT_TIME = "total_project_time" ;
	public final static String CS_DESIGN_AREAS = "design_areas" ;
	public final static String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;
	public final static String CS_HAS_SPLIT_PRICE = "has_split_price" ;
	public final static String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static String CS_OUT_OUTTATION_ID = "out_outtation_id" ;
	public final static String CS_FILE_NAME = "file_name" ;

	public final static String ALL_CAPTIONS = "订单信息编码,主订单编码,主订单编号,主订单名称,客户名称,开始日期,结束日期,结算状态,项目编号,合同类别,项目等级,合同单价,项目地点,合同跟进人,备注,合同签订日期,我方签约公司名称,创建时间,修改时间,业务类别,流转状态，默认为0表示可以提交到运营管理修改承接部门1表示可以提交到运营管理运营价格2表示可以提交到运营管理运营价格审核3表示审核完成,流水号,项目类别,建筑面积,配合专业,省份,城市,详细地址,客户地址,服务建议书,立单时间 提交了立单时间会将保存下来，只是点击保存不会将当前时间保存下来，单每次都会显示当前的时间，提交了下次显示的就是提交时的立单时间,标记补充协议字段；除0之外，其他都表示第n个补充协议,信息编号,合同状态  0未启动、1待签署、2已签署、3未签搁置、4解除,客户合同编号,合同是否完成,是否为erp系统添加  true 为系统添加  false 为数据导入,是否有报价单,附件id,附件url,项目总工期,总设计面积,签约总金额,是否有拆分价 true 有，反之,主键编码,报价单编码,附件名";

	public Integer getOrderInfoId() {
		return this.__order_info_id;
	}

	public void setOrderInfoId( Integer value ) {
		this.__order_info_id = value;
	}

	public Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( Integer value ) {
		this.__contract_id = value;
	}

	public String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( String value ) {
		this.__contract_code = value;
	}

	public String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( String value ) {
		this.__contract_name = value;
	}

	public String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( String value ) {
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

	public String getStatus() {
		return this.__status;
	}

	public void setStatus( String value ) {
		this.__status = value;
	}

	public String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( String value ) {
		this.__project_code = value;
	}

	public String getContractType() {
		return this.__contract_type;
	}

	public void setContractType( String value ) {
		this.__contract_type = value;
	}

	public String getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( String value ) {
		this.__project_level = value;
	}

	public java.math.BigDecimal getContractPrice() {
		return this.__contract_price;
	}

	public void setContractPrice( java.math.BigDecimal value ) {
		this.__contract_price = value;
	}

	public String getProjectAddress() {
		return this.__project_address;
	}

	public void setProjectAddress( String value ) {
		this.__project_address = value;
	}

	public Integer getContractFollower() {
		return this.__contract_follower;
	}

	public void setContractFollower( Integer value ) {
		this.__contract_follower = value;
	}

	public String getRemark() {
		return this.__remark;
	}

	public void setRemark( String value ) {
		this.__remark = value;
	}

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
	}

	public Integer getSigningCompanyName() {
		return this.__signing_company_name;
	}

	public void setSigningCompanyName( Integer value ) {
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

	public String getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( String value ) {
		this.__business_type = value;
	}

	public Integer getFlowStatus() {
		return this.__flow_status;
	}

	public void setFlowStatus( Integer value ) {
		this.__flow_status = value;
	}

	public String getSerialNumber() {
		return this.__serial_number;
	}

	public void setSerialNumber( String value ) {
		this.__serial_number = value;
	}

	public String getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( String value ) {
		this.__project_type = value;
	}

	public java.math.BigDecimal getCoveredArea() {
		return this.__covered_area;
	}

	public void setCoveredArea( java.math.BigDecimal value ) {
		this.__covered_area = value;
	}

	public String getProfessionalCooperation() {
		return this.__professional_cooperation;
	}

	public void setProfessionalCooperation( String value ) {
		this.__professional_cooperation = value;
	}

	public String getProvince() {
		return this.__province;
	}

	public void setProvince( String value ) {
		this.__province = value;
	}

	public String getCity() {
		return this.__city;
	}

	public void setCity( String value ) {
		this.__city = value;
	}

	public String getDetailAddress() {
		return this.__detail_address;
	}

	public void setDetailAddress( String value ) {
		this.__detail_address = value;
	}

	public String getCustomerAddress() {
		return this.__customer_address;
	}

	public void setCustomerAddress( String value ) {
		this.__customer_address = value;
	}

	public String getServiceSuggestBook() {
		return this.__service_suggest_book;
	}

	public void setServiceSuggestBook( String value ) {
		this.__service_suggest_book = value;
	}

	public java.util.Date getProjectApprovalTime() {
		return this.__project_approval_time;
	}

	public void setProjectApprovalTime( java.util.Date value ) {
		this.__project_approval_time = value;
	}

	public Integer getOrderNo() {
		return this.__order_no;
	}

	public void setOrderNo( Integer value ) {
		this.__order_no = value;
	}

	public String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( String value ) {
		this.__info_code = value;
	}

	public Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( Integer value ) {
		this.__contract_status = value;
	}

	public String getClientContractId() {
		return this.__client_contract_id;
	}

	public void setClientContractId( String value ) {
		this.__client_contract_id = value;
	}

	public Boolean getIsFinish() {
		return this.__is_finish;
	}

	public void setIsFinish( Boolean value ) {
		this.__is_finish = value;
	}

	public Boolean getIsSystemAdd() {
		return this.__is_system_add;
	}

	public void setIsSystemAdd( Boolean value ) {
		this.__is_system_add = value;
	}

	public Boolean getHasOutQuotations() {
		return this.__has_out_quotations;
	}

	public void setHasOutQuotations( Boolean value ) {
		this.__has_out_quotations = value;
	}

	public Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( Integer value ) {
		this.__file_id = value;
	}

	public String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( String value ) {
		this.__file_url = value;
	}

	public Integer getTotalProjectTime() {
		return this.__total_project_time;
	}

	public void setTotalProjectTime( Integer value ) {
		this.__total_project_time = value;
	}

	public java.math.BigDecimal getDesignAreas() {
		return this.__design_areas;
	}

	public void setDesignAreas( java.math.BigDecimal value ) {
		this.__design_areas = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public Boolean getHasSplitPrice() {
		return this.__has_split_price;
	}

	public void setHasSplitPrice( Boolean value ) {
		this.__has_split_price = value;
	}

	public Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( Integer value ) {
		this.__main_project_id = value;
	}

	public Integer getOutOuttationId() {
		return this.__out_outtation_id;
	}

	public void setOutOuttationId( Integer value ) {
		this.__out_outtation_id = value;
	}

	public String getFileName() {
		return this.__file_name;
	}

	public void setFileName( String value ) {
		this.__file_name = value;
	}

	public void cloneCopy(BaseOrderInfo __bean){
		__bean.setOrderInfoId(getOrderInfoId());
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
		__bean.setInfoCode(getInfoCode());
		__bean.setContractStatus(getContractStatus());
		__bean.setClientContractId(getClientContractId());
		__bean.setIsFinish(getIsFinish());
		__bean.setIsSystemAdd(getIsSystemAdd());
		__bean.setHasOutQuotations(getHasOutQuotations());
		__bean.setFileId(getFileId());
		__bean.setFileUrl(getFileUrl());
		__bean.setTotalProjectTime(getTotalProjectTime());
		__bean.setDesignAreas(getDesignAreas());
		__bean.setSigningMoneySum(getSigningMoneySum());
		__bean.setHasSplitPrice(getHasSplitPrice());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setOutOuttationId(getOutOuttationId());
		__bean.setFileName(getFileName());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOrderInfoId() == null ? "" : getOrderInfoId());
		sb.append(",");
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
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		sb.append(getContractType() == null ? "" : getContractType());
		sb.append(",");
		sb.append(getProjectLevel() == null ? "" : getProjectLevel());
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
		sb.append(getHasOutQuotations() == null ? "" : getHasOutQuotations());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getTotalProjectTime() == null ? "" : getTotalProjectTime());
		sb.append(",");
		sb.append(getDesignAreas() == null ? "" : getDesignAreas());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		sb.append(",");
		sb.append(getHasSplitPrice() == null ? "" : getHasSplitPrice());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getOutOuttationId() == null ? "" : getOutOuttationId());
		sb.append(",");
		sb.append(getFileName() == null ? "" : getFileName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOrderInfo o) {
		return __order_info_id == null ? -1 : __order_info_id.compareTo(o.getOrderInfoId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__order_info_id);
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
		hash = 97 * hash + Objects.hashCode(this.__info_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_status);
		hash = 97 * hash + Objects.hashCode(this.__client_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__is_finish);
		hash = 97 * hash + Objects.hashCode(this.__is_system_add);
		hash = 97 * hash + Objects.hashCode(this.__has_out_quotations);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__total_project_time);
		hash = 97 * hash + Objects.hashCode(this.__design_areas);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__has_split_price);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__out_outtation_id);
		hash = 97 * hash + Objects.hashCode(this.__file_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOrderInfo o = (BaseOrderInfo)obj;
		if(!Objects.equals(this.__order_info_id, o.getOrderInfoId())) return false;
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
		if(!Objects.equals(this.__info_code, o.getInfoCode())) return false;
		if(!Objects.equals(this.__contract_status, o.getContractStatus())) return false;
		if(!Objects.equals(this.__client_contract_id, o.getClientContractId())) return false;
		if(!Objects.equals(this.__is_finish, o.getIsFinish())) return false;
		if(!Objects.equals(this.__is_system_add, o.getIsSystemAdd())) return false;
		if(!Objects.equals(this.__has_out_quotations, o.getHasOutQuotations())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__total_project_time, o.getTotalProjectTime())) return false;
		if(!Objects.equals(this.__design_areas, o.getDesignAreas())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		if(!Objects.equals(this.__has_split_price, o.getHasSplitPrice())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__out_outtation_id, o.getOutOuttationId())) return false;
		if(!Objects.equals(this.__file_name, o.getFileName())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOrderInfoId() != null) sb.append(__wrapNumber(count++, "orderInfoId", getOrderInfoId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getStatus() != null) sb.append(__wrapString(count++, "status", getStatus()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getContractType() != null) sb.append(__wrapString(count++, "contractType", getContractType()));
		if(getProjectLevel() != null) sb.append(__wrapString(count++, "projectLevel", getProjectLevel()));
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
		if(getInfoCode() != null) sb.append(__wrapString(count++, "infoCode", getInfoCode()));
		if(getContractStatus() != null) sb.append(__wrapNumber(count++, "contractStatus", getContractStatus()));
		if(getClientContractId() != null) sb.append(__wrapString(count++, "clientContractId", getClientContractId()));
		if(getIsFinish() != null) sb.append(__wrapBoolean(count++, "isFinish", getIsFinish()));
		if(getIsSystemAdd() != null) sb.append(__wrapBoolean(count++, "isSystemAdd", getIsSystemAdd()));
		if(getHasOutQuotations() != null) sb.append(__wrapBoolean(count++, "hasOutQuotations", getHasOutQuotations()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getTotalProjectTime() != null) sb.append(__wrapNumber(count++, "totalProjectTime", getTotalProjectTime()));
		if(getDesignAreas() != null) sb.append(__wrapDecimal(count++, "designAreas", getDesignAreas()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		if(getHasSplitPrice() != null) sb.append(__wrapBoolean(count++, "hasSplitPrice", getHasSplitPrice()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getOutOuttationId() != null) sb.append(__wrapNumber(count++, "outOuttationId", getOutOuttationId()));
		if(getFileName() != null) sb.append(__wrapString(count++, "flieName", getFileName()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getOrderInfoId() != null) res.put("orderInfoId", getOrderInfoId());
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
		if(getInfoCode() != null) res.put("infoCode", getInfoCode());
		if(getContractStatus() != null) res.put("contractStatus", getContractStatus());
		if(getClientContractId() != null) res.put("clientContractId", getClientContractId());
		if(getIsFinish() != null) res.put("isFinish", getIsFinish());
		if(getIsSystemAdd() != null) res.put("isSystemAdd", getIsSystemAdd());
		if(getHasOutQuotations() != null) res.put("hasOutQuotations", getHasOutQuotations());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		if(getTotalProjectTime() != null) res.put("totalProjectTime", getTotalProjectTime());
		if(getDesignAreas() != null) res.put("designAreas", getDesignAreas());
		if(getSigningMoneySum() != null) res.put("signingMoneySum", getSigningMoneySum());
		if(getHasSplitPrice() != null) res.put("hasSplitPrice", getHasSplitPrice());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getOutOuttationId() != null) res.put("outOuttationId", getOutOuttationId());
		if(getFileName() != null) res.put("flieName", getFileName());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("orderInfoId")) != null) setOrderInfoId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("contractType")) != null) setContractType(__getString(val));
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getString(val));
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
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("clientContractId")) != null) setClientContractId(__getString(val));
		if((val = values.get("isFinish")) != null) setIsFinish(__getBoolean(val));
		if((val = values.get("isSystemAdd")) != null) setIsSystemAdd(__getBoolean(val));
		if((val = values.get("hasOutQuotations")) != null) setHasOutQuotations(__getBoolean(val));
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("totalProjectTime")) != null) setTotalProjectTime(__getInt(val)); 
		if((val = values.get("designAreas")) != null) setDesignAreas(__getDecimal(val));  
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
		if((val = values.get("hasSplitPrice")) != null) setHasSplitPrice(__getBoolean(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("outOuttationId")) != null) setOutOuttationId(__getInt(val)); 
		if((val = values.get("fileName")) != null) setFileName(__getString(val));
	}

	protected Integer  __order_info_id ;
	protected Integer  __contract_id ;
	protected String  __contract_code ;
	protected String  __contract_name ;
	protected String  __customer_name ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected String  __status ;
	protected String  __project_code ;
	protected String  __contract_type ;
	protected String  __project_level ;
	protected java.math.BigDecimal  __contract_price ;
	protected String  __project_address ;
	protected Integer  __contract_follower ;
	protected String  __remark ;
	protected java.util.Date  __contract_date ;
	protected Integer  __signing_company_name ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected String  __business_type ;
	protected Integer  __flow_status ;
	protected String  __serial_number ;
	protected String  __project_type ;
	protected java.math.BigDecimal  __covered_area ;
	protected String  __professional_cooperation ;
	protected String  __province ;
	protected String  __city ;
	protected String  __detail_address ;
	protected String  __customer_address ;
	protected String  __service_suggest_book ;
	protected java.util.Date  __project_approval_time ;
	protected Integer  __order_no ;
	protected String  __info_code ;
	protected Integer  __contract_status ;
	protected String  __client_contract_id ;
	protected Boolean  __is_finish ;
	protected Boolean  __is_system_add ;
	protected Boolean  __has_out_quotations ;
	protected Integer  __file_id ;
	protected String  __file_url ;
	protected Integer  __total_project_time ;
	protected java.math.BigDecimal  __design_areas ;
	protected java.math.BigDecimal  __signing_money_sum ;
	protected Boolean  __has_split_price ;
	protected Integer  __main_project_id ;
	protected Integer  __out_outtation_id ;
	protected String  __file_name ;
}
