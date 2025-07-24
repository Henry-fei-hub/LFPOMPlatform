package pomplatform.specialDeduction.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMspecialdeductionrecordsor extends GenericBase implements BaseFactory<BaseMspecialdeductionrecordsor>, Comparable<BaseMspecialdeductionrecordsor> 
{


	public static BaseMspecialdeductionrecordsor newInstance(){
		return new BaseMspecialdeductionrecordsor();
	}

	@Override
	public BaseMspecialdeductionrecordsor make(){
		BaseMspecialdeductionrecordsor b = new BaseMspecialdeductionrecordsor();
		return b;
	}

	public final static java.lang.String CS_SPECIAL_DEDUCTION_RECORD_ID = "special_deduction_record_id" ;
	public final static java.lang.String CS_EMPLOYE_ID = "employe_id" ;
	public final static java.lang.String CS_DEPARMENT_ID = "deparment_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_DOCUMENT_TYPE = "document_type" ;
	public final static java.lang.String CS_IDENTIFICATION_NUMBER = "identification_number" ;
	public final static java.lang.String CS_PHONE = "phone" ;
	public final static java.lang.String CS_TAXPAYER_REGISTRATION_NUMBER = "taxpayer_registration_number" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_WITHHOLD_NAME = "withhold_name" ;
	public final static java.lang.String CS_WITHHOLD_REGISTRATION_NUMBER = "withhold_registration_number" ;
	public final static java.lang.String CS_SPOUSE_SITUATION = "spouse_situation" ;
	public final static java.lang.String CS_SPOUSE_NAME = "spouse_name" ;
	public final static java.lang.String CS_SPOUSE_DOCUMENT_TYPE = "spouse_document_type" ;
	public final static java.lang.String CS_SPOUSE_IDENTIFICATION_NUMBER = "spouse_identification_number" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_FID = "fid" ;
	public final static java.lang.String CS_FURL = "furl" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_DETAIL_ID = "special_deduction_detail_id" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_OTHER_DOCUMENT_TYPE = "other_document_type" ;
	public final static java.lang.String CS_OTHER_IDENTIFICATION_NUMBER = "other_identification_number" ;
	public final static java.lang.String CS_BRITHDATE = "brithdate" ;
	public final static java.lang.String CS_NATIONALITY_REGION = "nationality_region" ;
	public final static java.lang.String CS_SCHOOLING = "schooling" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_SCHOOLING_TERMINATION_DATE = "schooling_termination_date" ;
	public final static java.lang.String CS_SCHOOLING_REGION = "schooling_region" ;
	public final static java.lang.String CS_SCHOOL = "school" ;
	public final static java.lang.String CS_DEDUCTION_PERCENTAGE = "deduction_percentage" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_NUM = "num" ;
	public final static java.lang.String CS_EDUCATION_TYPE = "education_type" ;
	public final static java.lang.String CS_EDUCATION_STAGE = "education_stage" ;
	public final static java.lang.String CS_ISSUE_DATE = "issue_date" ;
	public final static java.lang.String CS_CREDENTIAL = "credential" ;
	public final static java.lang.String CS_CREDENTIAL_NUMBER = "credential_number" ;
	public final static java.lang.String CS_ISSUING_AUTHORITY = "issuing_authority" ;
	public final static java.lang.String CS_HOUSE_ADDRESS = "house_address" ;
	public final static java.lang.String CS_HOUSE_BORROWER = "house_borrower" ;
	public final static java.lang.String CS_HOUSE_TYPE = "house_type" ;
	public final static java.lang.String CS_HOUSE_NUMBER = "house_number" ;
	public final static java.lang.String CS_HOUSE_FIRST = "house_first" ;
	public final static java.lang.String CS_LOAN_TYPE = "loan_type" ;
	public final static java.lang.String CS_CREDITOR_BANK = "creditor_bank" ;
	public final static java.lang.String CS_CREDITOR_CONTRACT_NUMBER = "creditor_contract_number" ;
	public final static java.lang.String CS_REPAYMENT_FIRST_DATE = "repayment_first_date" ;
	public final static java.lang.String CS_REPAYMENT = "repayment" ;
	public final static java.lang.String CS_HOUSE_AMOUNT = "house_amount" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_LEASE_TYPE = "lease_type" ;
	public final static java.lang.String CS_LEASE_ADDRESS = "lease_address" ;
	public final static java.lang.String CS_LEASE_CONTRACT_NUMBER = "lease_contract_number" ;
	public final static java.lang.String CS_SINGLE_CHILD = "single_child" ;
	public final static java.lang.String CS_ALLOCATION_WAY = "allocation_way" ;
	public final static java.lang.String CS_ALLOCATION_AMOUNT = "allocation_amount" ;
	public final static java.lang.String CS_CHANGE_TYPE = "change_type" ;
	public final static java.lang.String CS_HOSPITALIZATION_TOTAL_COST = "hospitalization_total_cost" ;
	public final static java.lang.String CS_HOSPITALIZATION_PERSONAL_COST = "hospitalization_personal_cost" ;
	public final static java.lang.String CS_RELATIONSHIP = "relationship" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_ID = "special_deduction_type_id" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_ALTERNATE_FIELD1 = "alternate_field1" ;
	public final static java.lang.String CS_ALTERNATE_FIELD2 = "alternate_field2" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;

	public final static java.lang.String ALL_CAPTIONS = "id,纳税人id,部门,业务部门,归属公司,身份证件类型,纳税人身份证件号码,手机号码,纳税人识别号,联系地址,邮箱,扣缴义务人名称,扣缴义务人纳税人识别号,配偶情况 （0 无  1有）,配偶名称,配偶身份证件类型,配偶身份证件号码,是否可用,备注,,,id,父id,姓名,身份证件类型,身份证件号码,出生日期,国籍,当前受教育阶段,有效开始时间,有效结束时间,教育终止时间,当前就读国家地区,当前就读学校,本人扣除比例,金额(基数),个数,继续教育类型,教育阶段,发证日期,证书名称,证书编号,发证机关,房屋坐落地址,是否房屋贷款借款人,房屋证书类型,房屋证书编号,是否婚前各自首套贷款且婚后分别扣除50%,贷款类型 0公积金打开  1商业贷款,贷款银行,贷款合同编号,首次还款日期,贷款期数（月数）,贷款抵扣金额,省份,城市,租赁类型 0个人 1组织,住房坐落地址,住房租赁合同编号,是否独生,分摊方式,本年度月扣除金额,较上次报送信息是否发生变化  0 首次报送 1 无变化 2有变化,医药费用总金额,个人负担金额,与本人关系 0 父亲 1母亲 2子女 3 其他,fileId,fileUrl,扣除年度,专项类型,创建时间,备用字段1,备用字段2,流程状态 0 发起中  1";

	public java.lang.Integer getSpecialDeductionRecordId() {
		return this.__special_deduction_record_id;
	}

	public void setSpecialDeductionRecordId( java.lang.Integer value ) {
		this.__special_deduction_record_id = value;
	}

	public java.lang.Integer getEmployeId() {
		return this.__employe_id;
	}

	public void setEmployeId( java.lang.Integer value ) {
		this.__employe_id = value;
	}

	public java.lang.Integer getDeparmentId() {
		return this.__deparment_id;
	}

	public void setDeparmentId( java.lang.Integer value ) {
		this.__deparment_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getDocumentType() {
		return this.__document_type;
	}

	public void setDocumentType( java.lang.Integer value ) {
		this.__document_type = value;
	}

	public java.lang.String getIdentificationNumber() {
		return this.__identification_number;
	}

	public void setIdentificationNumber( java.lang.String value ) {
		this.__identification_number = value;
	}

	public java.lang.String getPhone() {
		return this.__phone;
	}

	public void setPhone( java.lang.String value ) {
		this.__phone = value;
	}

	public java.lang.String getTaxpayerRegistrationNumber() {
		return this.__taxpayer_registration_number;
	}

	public void setTaxpayerRegistrationNumber( java.lang.String value ) {
		this.__taxpayer_registration_number = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.String getEmail() {
		return this.__email;
	}

	public void setEmail( java.lang.String value ) {
		this.__email = value;
	}

	public java.lang.String getWithholdName() {
		return this.__withhold_name;
	}

	public void setWithholdName( java.lang.String value ) {
		this.__withhold_name = value;
	}

	public java.lang.String getWithholdRegistrationNumber() {
		return this.__withhold_registration_number;
	}

	public void setWithholdRegistrationNumber( java.lang.String value ) {
		this.__withhold_registration_number = value;
	}

	public java.lang.Integer getSpouseSituation() {
		return this.__spouse_situation;
	}

	public void setSpouseSituation( java.lang.Integer value ) {
		this.__spouse_situation = value;
	}

	public java.lang.String getSpouseName() {
		return this.__spouse_name;
	}

	public void setSpouseName( java.lang.String value ) {
		this.__spouse_name = value;
	}

	public java.lang.Integer getSpouseDocumentType() {
		return this.__spouse_document_type;
	}

	public void setSpouseDocumentType( java.lang.Integer value ) {
		this.__spouse_document_type = value;
	}

	public java.lang.String getSpouseIdentificationNumber() {
		return this.__spouse_identification_number;
	}

	public void setSpouseIdentificationNumber( java.lang.String value ) {
		this.__spouse_identification_number = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getFid() {
		return this.__fid;
	}

	public void setFid( java.lang.String value ) {
		this.__fid = value;
	}

	public java.lang.String getFurl() {
		return this.__furl;
	}

	public void setFurl( java.lang.String value ) {
		this.__furl = value;
	}

	public java.lang.Integer getSpecialDeductionDetailId() {
		return this.__special_deduction_detail_id;
	}

	public void setSpecialDeductionDetailId( java.lang.Integer value ) {
		this.__special_deduction_detail_id = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.Integer getOtherDocumentType() {
		return this.__other_document_type;
	}

	public void setOtherDocumentType( java.lang.Integer value ) {
		this.__other_document_type = value;
	}

	public java.lang.String getOtherIdentificationNumber() {
		return this.__other_identification_number;
	}

	public void setOtherIdentificationNumber( java.lang.String value ) {
		this.__other_identification_number = value;
	}

	public java.util.Date getBrithdate() {
		return this.__brithdate;
	}

	public void setBrithdate( java.util.Date value ) {
		this.__brithdate = value;
	}

	public java.lang.String getNationalityRegion() {
		return this.__nationality_region;
	}

	public void setNationalityRegion( java.lang.String value ) {
		this.__nationality_region = value;
	}

	public java.lang.Integer getSchooling() {
		return this.__schooling;
	}

	public void setSchooling( java.lang.Integer value ) {
		this.__schooling = value;
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

	public java.util.Date getSchoolingTerminationDate() {
		return this.__schooling_termination_date;
	}

	public void setSchoolingTerminationDate( java.util.Date value ) {
		this.__schooling_termination_date = value;
	}

	public java.lang.String getSchoolingRegion() {
		return this.__schooling_region;
	}

	public void setSchoolingRegion( java.lang.String value ) {
		this.__schooling_region = value;
	}

	public java.lang.String getSchool() {
		return this.__school;
	}

	public void setSchool( java.lang.String value ) {
		this.__school = value;
	}

	public java.math.BigDecimal getDeductionPercentage() {
		return this.__deduction_percentage;
	}

	public void setDeductionPercentage( java.math.BigDecimal value ) {
		this.__deduction_percentage = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Integer value ) {
		this.__num = value;
	}

	public java.lang.Integer getEducationType() {
		return this.__education_type;
	}

	public void setEducationType( java.lang.Integer value ) {
		this.__education_type = value;
	}

	public java.lang.Integer getEducationStage() {
		return this.__education_stage;
	}

	public void setEducationStage( java.lang.Integer value ) {
		this.__education_stage = value;
	}

	public java.util.Date getIssueDate() {
		return this.__issue_date;
	}

	public void setIssueDate( java.util.Date value ) {
		this.__issue_date = value;
	}

	public java.lang.String getCredential() {
		return this.__credential;
	}

	public void setCredential( java.lang.String value ) {
		this.__credential = value;
	}

	public java.lang.String getCredentialNumber() {
		return this.__credential_number;
	}

	public void setCredentialNumber( java.lang.String value ) {
		this.__credential_number = value;
	}

	public java.lang.String getIssuingAuthority() {
		return this.__issuing_authority;
	}

	public void setIssuingAuthority( java.lang.String value ) {
		this.__issuing_authority = value;
	}

	public java.lang.String getHouseAddress() {
		return this.__house_address;
	}

	public void setHouseAddress( java.lang.String value ) {
		this.__house_address = value;
	}

	public java.lang.Integer getHouseBorrower() {
		return this.__house_borrower;
	}

	public void setHouseBorrower( java.lang.Integer value ) {
		this.__house_borrower = value;
	}

	public java.lang.Integer getHouseType() {
		return this.__house_type;
	}

	public void setHouseType( java.lang.Integer value ) {
		this.__house_type = value;
	}

	public java.lang.String getHouseNumber() {
		return this.__house_number;
	}

	public void setHouseNumber( java.lang.String value ) {
		this.__house_number = value;
	}

	public java.lang.Integer getHouseFirst() {
		return this.__house_first;
	}

	public void setHouseFirst( java.lang.Integer value ) {
		this.__house_first = value;
	}

	public java.lang.Integer getLoanType() {
		return this.__loan_type;
	}

	public void setLoanType( java.lang.Integer value ) {
		this.__loan_type = value;
	}

	public java.lang.String getCreditorBank() {
		return this.__creditor_bank;
	}

	public void setCreditorBank( java.lang.String value ) {
		this.__creditor_bank = value;
	}

	public java.lang.String getCreditorContractNumber() {
		return this.__creditor_contract_number;
	}

	public void setCreditorContractNumber( java.lang.String value ) {
		this.__creditor_contract_number = value;
	}

	public java.util.Date getRepaymentFirstDate() {
		return this.__repayment_first_date;
	}

	public void setRepaymentFirstDate( java.util.Date value ) {
		this.__repayment_first_date = value;
	}

	public java.lang.Integer getRepayment() {
		return this.__repayment;
	}

	public void setRepayment( java.lang.Integer value ) {
		this.__repayment = value;
	}

	public java.math.BigDecimal getHouseAmount() {
		return this.__house_amount;
	}

	public void setHouseAmount( java.math.BigDecimal value ) {
		this.__house_amount = value;
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

	public java.lang.Integer getLeaseType() {
		return this.__lease_type;
	}

	public void setLeaseType( java.lang.Integer value ) {
		this.__lease_type = value;
	}

	public java.lang.String getLeaseAddress() {
		return this.__lease_address;
	}

	public void setLeaseAddress( java.lang.String value ) {
		this.__lease_address = value;
	}

	public java.lang.String getLeaseContractNumber() {
		return this.__lease_contract_number;
	}

	public void setLeaseContractNumber( java.lang.String value ) {
		this.__lease_contract_number = value;
	}

	public java.lang.Integer getSingleChild() {
		return this.__single_child;
	}

	public void setSingleChild( java.lang.Integer value ) {
		this.__single_child = value;
	}

	public java.lang.String getAllocationWay() {
		return this.__allocation_way;
	}

	public void setAllocationWay( java.lang.String value ) {
		this.__allocation_way = value;
	}

	public java.math.BigDecimal getAllocationAmount() {
		return this.__allocation_amount;
	}

	public void setAllocationAmount( java.math.BigDecimal value ) {
		this.__allocation_amount = value;
	}

	public java.lang.Integer getChangeType() {
		return this.__change_type;
	}

	public void setChangeType( java.lang.Integer value ) {
		this.__change_type = value;
	}

	public java.math.BigDecimal getHospitalizationTotalCost() {
		return this.__hospitalization_total_cost;
	}

	public void setHospitalizationTotalCost( java.math.BigDecimal value ) {
		this.__hospitalization_total_cost = value;
	}

	public java.math.BigDecimal getHospitalizationPersonalCost() {
		return this.__hospitalization_personal_cost;
	}

	public void setHospitalizationPersonalCost( java.math.BigDecimal value ) {
		this.__hospitalization_personal_cost = value;
	}

	public java.lang.Integer getRelationship() {
		return this.__relationship;
	}

	public void setRelationship( java.lang.Integer value ) {
		this.__relationship = value;
	}

	public java.lang.String getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.String value ) {
		this.__file_id = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.lang.String getAlternateField1() {
		return this.__alternate_field1;
	}

	public void setAlternateField1( java.lang.String value ) {
		this.__alternate_field1 = value;
	}

	public java.lang.String getAlternateField2() {
		return this.__alternate_field2;
	}

	public void setAlternateField2( java.lang.String value ) {
		this.__alternate_field2 = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}
	
	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public void cloneCopy(BaseMspecialdeductionrecordsor __bean){
		__bean.setSpecialDeductionRecordId(getSpecialDeductionRecordId());
		__bean.setEmployeId(getEmployeId());
		__bean.setDeparmentId(getDeparmentId());
		__bean.setPlateId(getPlateId());
		__bean.setCompanyId(getCompanyId());
		__bean.setDocumentType(getDocumentType());
		__bean.setIdentificationNumber(getIdentificationNumber());
		__bean.setPhone(getPhone());
		__bean.setTaxpayerRegistrationNumber(getTaxpayerRegistrationNumber());
		__bean.setAddress(getAddress());
		__bean.setEmail(getEmail());
		__bean.setWithholdName(getWithholdName());
		__bean.setWithholdRegistrationNumber(getWithholdRegistrationNumber());
		__bean.setSpouseSituation(getSpouseSituation());
		__bean.setSpouseName(getSpouseName());
		__bean.setSpouseDocumentType(getSpouseDocumentType());
		__bean.setSpouseIdentificationNumber(getSpouseIdentificationNumber());
		__bean.setIsEnable(getIsEnable());
		__bean.setRemark(getRemark());
		__bean.setFid(getFid());
		__bean.setFurl(getFurl());
		__bean.setSpecialDeductionDetailId(getSpecialDeductionDetailId());
		__bean.setParentId(getParentId());
		__bean.setName(getName());
		__bean.setOtherDocumentType(getOtherDocumentType());
		__bean.setOtherIdentificationNumber(getOtherIdentificationNumber());
		__bean.setBrithdate(getBrithdate());
		__bean.setNationalityRegion(getNationalityRegion());
		__bean.setSchooling(getSchooling());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setSchoolingTerminationDate(getSchoolingTerminationDate());
		__bean.setSchoolingRegion(getSchoolingRegion());
		__bean.setSchool(getSchool());
		__bean.setDeductionPercentage(getDeductionPercentage());
		__bean.setAmount(getAmount());
		__bean.setNum(getNum());
		__bean.setEducationType(getEducationType());
		__bean.setEducationStage(getEducationStage());
		__bean.setIssueDate(getIssueDate());
		__bean.setCredential(getCredential());
		__bean.setCredentialNumber(getCredentialNumber());
		__bean.setIssuingAuthority(getIssuingAuthority());
		__bean.setHouseAddress(getHouseAddress());
		__bean.setHouseBorrower(getHouseBorrower());
		__bean.setHouseType(getHouseType());
		__bean.setHouseNumber(getHouseNumber());
		__bean.setHouseFirst(getHouseFirst());
		__bean.setLoanType(getLoanType());
		__bean.setCreditorBank(getCreditorBank());
		__bean.setCreditorContractNumber(getCreditorContractNumber());
		__bean.setRepaymentFirstDate(getRepaymentFirstDate());
		__bean.setRepayment(getRepayment());
		__bean.setHouseAmount(getHouseAmount());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setLeaseType(getLeaseType());
		__bean.setLeaseAddress(getLeaseAddress());
		__bean.setLeaseContractNumber(getLeaseContractNumber());
		__bean.setSingleChild(getSingleChild());
		__bean.setAllocationWay(getAllocationWay());
		__bean.setAllocationAmount(getAllocationAmount());
		__bean.setChangeType(getChangeType());
		__bean.setHospitalizationTotalCost(getHospitalizationTotalCost());
		__bean.setHospitalizationPersonalCost(getHospitalizationPersonalCost());
		__bean.setRelationship(getRelationship());
		__bean.setFileId(getFileId());
		__bean.setFileUrl(getFileUrl());
		__bean.setYear(getYear());
		__bean.setSpecialDeductionTypeId(getSpecialDeductionTypeId());
		__bean.setCreateDate(getCreateDate());
		__bean.setAlternateField1(getAlternateField1());
		__bean.setAlternateField2(getAlternateField2());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setProcessInstanceId(getProcessInstanceId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSpecialDeductionRecordId() == null ? "" : getSpecialDeductionRecordId());
		sb.append(",");
		sb.append(getEmployeId() == null ? "" : getEmployeId());
		sb.append(",");
		sb.append(getDeparmentId() == null ? "" : getDeparmentId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getDocumentType() == null ? "" : getDocumentType());
		sb.append(",");
		sb.append(getIdentificationNumber() == null ? "" : getIdentificationNumber());
		sb.append(",");
		sb.append(getPhone() == null ? "" : getPhone());
		sb.append(",");
		sb.append(getTaxpayerRegistrationNumber() == null ? "" : getTaxpayerRegistrationNumber());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getWithholdName() == null ? "" : getWithholdName());
		sb.append(",");
		sb.append(getWithholdRegistrationNumber() == null ? "" : getWithholdRegistrationNumber());
		sb.append(",");
		sb.append(getSpouseSituation() == null ? "" : getSpouseSituation());
		sb.append(",");
		sb.append(getSpouseName() == null ? "" : getSpouseName());
		sb.append(",");
		sb.append(getSpouseDocumentType() == null ? "" : getSpouseDocumentType());
		sb.append(",");
		sb.append(getSpouseIdentificationNumber() == null ? "" : getSpouseIdentificationNumber());
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getFid() == null ? "" : getFid());
		sb.append(",");
		sb.append(getFurl() == null ? "" : getFurl());
		sb.append(",");
		sb.append(getSpecialDeductionDetailId() == null ? "" : getSpecialDeductionDetailId());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getOtherDocumentType() == null ? "" : getOtherDocumentType());
		sb.append(",");
		sb.append(getOtherIdentificationNumber() == null ? "" : getOtherIdentificationNumber());
		sb.append(",");
		sb.append(getBrithdate() == null ? "" : sdf.format(getBrithdate()));
		sb.append(",");
		sb.append(getNationalityRegion() == null ? "" : getNationalityRegion());
		sb.append(",");
		sb.append(getSchooling() == null ? "" : getSchooling());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getSchoolingTerminationDate() == null ? "" : sdf.format(getSchoolingTerminationDate()));
		sb.append(",");
		sb.append(getSchoolingRegion() == null ? "" : getSchoolingRegion());
		sb.append(",");
		sb.append(getSchool() == null ? "" : getSchool());
		sb.append(",");
		sb.append(getDeductionPercentage() == null ? "" : getDeductionPercentage());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		sb.append(",");
		sb.append(getEducationType() == null ? "" : getEducationType());
		sb.append(",");
		sb.append(getEducationStage() == null ? "" : getEducationStage());
		sb.append(",");
		sb.append(getIssueDate() == null ? "" : sdf.format(getIssueDate()));
		sb.append(",");
		sb.append(getCredential() == null ? "" : getCredential());
		sb.append(",");
		sb.append(getCredentialNumber() == null ? "" : getCredentialNumber());
		sb.append(",");
		sb.append(getIssuingAuthority() == null ? "" : getIssuingAuthority());
		sb.append(",");
		sb.append(getHouseAddress() == null ? "" : getHouseAddress());
		sb.append(",");
		sb.append(getHouseBorrower() == null ? "" : getHouseBorrower());
		sb.append(",");
		sb.append(getHouseType() == null ? "" : getHouseType());
		sb.append(",");
		sb.append(getHouseNumber() == null ? "" : getHouseNumber());
		sb.append(",");
		sb.append(getHouseFirst() == null ? "" : getHouseFirst());
		sb.append(",");
		sb.append(getLoanType() == null ? "" : getLoanType());
		sb.append(",");
		sb.append(getCreditorBank() == null ? "" : getCreditorBank());
		sb.append(",");
		sb.append(getCreditorContractNumber() == null ? "" : getCreditorContractNumber());
		sb.append(",");
		sb.append(getRepaymentFirstDate() == null ? "" : sdf.format(getRepaymentFirstDate()));
		sb.append(",");
		sb.append(getRepayment() == null ? "" : getRepayment());
		sb.append(",");
		sb.append(getHouseAmount() == null ? "" : getHouseAmount());
		sb.append(",");
		sb.append(getProvince() == null ? "" : getProvince());
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getLeaseType() == null ? "" : getLeaseType());
		sb.append(",");
		sb.append(getLeaseAddress() == null ? "" : getLeaseAddress());
		sb.append(",");
		sb.append(getLeaseContractNumber() == null ? "" : getLeaseContractNumber());
		sb.append(",");
		sb.append(getSingleChild() == null ? "" : getSingleChild());
		sb.append(",");
		sb.append(getAllocationWay() == null ? "" : getAllocationWay());
		sb.append(",");
		sb.append(getAllocationAmount() == null ? "" : getAllocationAmount());
		sb.append(",");
		sb.append(getChangeType() == null ? "" : getChangeType());
		sb.append(",");
		sb.append(getHospitalizationTotalCost() == null ? "" : getHospitalizationTotalCost());
		sb.append(",");
		sb.append(getHospitalizationPersonalCost() == null ? "" : getHospitalizationPersonalCost());
		sb.append(",");
		sb.append(getRelationship() == null ? "" : getRelationship());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getSpecialDeductionTypeId() == null ? "" : getSpecialDeductionTypeId());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getAlternateField1() == null ? "" : getAlternateField1());
		sb.append(",");
		sb.append(getAlternateField2() == null ? "" : getAlternateField2());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMspecialdeductionrecordsor o) {
		return __special_deduction_record_id == null ? -1 : __special_deduction_record_id.compareTo(o.getSpecialDeductionRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employe_id);
		hash = 97 * hash + Objects.hashCode(this.__deparment_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__document_type);
		hash = 97 * hash + Objects.hashCode(this.__identification_number);
		hash = 97 * hash + Objects.hashCode(this.__phone);
		hash = 97 * hash + Objects.hashCode(this.__taxpayer_registration_number);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__withhold_name);
		hash = 97 * hash + Objects.hashCode(this.__withhold_registration_number);
		hash = 97 * hash + Objects.hashCode(this.__spouse_situation);
		hash = 97 * hash + Objects.hashCode(this.__spouse_name);
		hash = 97 * hash + Objects.hashCode(this.__spouse_document_type);
		hash = 97 * hash + Objects.hashCode(this.__spouse_identification_number);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__fid);
		hash = 97 * hash + Objects.hashCode(this.__furl);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__other_document_type);
		hash = 97 * hash + Objects.hashCode(this.__other_identification_number);
		hash = 97 * hash + Objects.hashCode(this.__brithdate);
		hash = 97 * hash + Objects.hashCode(this.__nationality_region);
		hash = 97 * hash + Objects.hashCode(this.__schooling);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__schooling_termination_date);
		hash = 97 * hash + Objects.hashCode(this.__schooling_region);
		hash = 97 * hash + Objects.hashCode(this.__school);
		hash = 97 * hash + Objects.hashCode(this.__deduction_percentage);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__num);
		hash = 97 * hash + Objects.hashCode(this.__education_type);
		hash = 97 * hash + Objects.hashCode(this.__education_stage);
		hash = 97 * hash + Objects.hashCode(this.__issue_date);
		hash = 97 * hash + Objects.hashCode(this.__credential);
		hash = 97 * hash + Objects.hashCode(this.__credential_number);
		hash = 97 * hash + Objects.hashCode(this.__issuing_authority);
		hash = 97 * hash + Objects.hashCode(this.__house_address);
		hash = 97 * hash + Objects.hashCode(this.__house_borrower);
		hash = 97 * hash + Objects.hashCode(this.__house_type);
		hash = 97 * hash + Objects.hashCode(this.__house_number);
		hash = 97 * hash + Objects.hashCode(this.__house_first);
		hash = 97 * hash + Objects.hashCode(this.__loan_type);
		hash = 97 * hash + Objects.hashCode(this.__creditor_bank);
		hash = 97 * hash + Objects.hashCode(this.__creditor_contract_number);
		hash = 97 * hash + Objects.hashCode(this.__repayment_first_date);
		hash = 97 * hash + Objects.hashCode(this.__repayment);
		hash = 97 * hash + Objects.hashCode(this.__house_amount);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__lease_type);
		hash = 97 * hash + Objects.hashCode(this.__lease_address);
		hash = 97 * hash + Objects.hashCode(this.__lease_contract_number);
		hash = 97 * hash + Objects.hashCode(this.__single_child);
		hash = 97 * hash + Objects.hashCode(this.__allocation_way);
		hash = 97 * hash + Objects.hashCode(this.__allocation_amount);
		hash = 97 * hash + Objects.hashCode(this.__change_type);
		hash = 97 * hash + Objects.hashCode(this.__hospitalization_total_cost);
		hash = 97 * hash + Objects.hashCode(this.__hospitalization_personal_cost);
		hash = 97 * hash + Objects.hashCode(this.__relationship);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_id);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field1);
		hash = 97 * hash + Objects.hashCode(this.__alternate_field2);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMspecialdeductionrecordsor o = (BaseMspecialdeductionrecordsor)obj;
		if(!Objects.equals(this.__special_deduction_record_id, o.getSpecialDeductionRecordId())) return false;
		if(!Objects.equals(this.__employe_id, o.getEmployeId())) return false;
		if(!Objects.equals(this.__deparment_id, o.getDeparmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__document_type, o.getDocumentType())) return false;
		if(!Objects.equals(this.__identification_number, o.getIdentificationNumber())) return false;
		if(!Objects.equals(this.__phone, o.getPhone())) return false;
		if(!Objects.equals(this.__taxpayer_registration_number, o.getTaxpayerRegistrationNumber())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__withhold_name, o.getWithholdName())) return false;
		if(!Objects.equals(this.__withhold_registration_number, o.getWithholdRegistrationNumber())) return false;
		if(!Objects.equals(this.__spouse_situation, o.getSpouseSituation())) return false;
		if(!Objects.equals(this.__spouse_name, o.getSpouseName())) return false;
		if(!Objects.equals(this.__spouse_document_type, o.getSpouseDocumentType())) return false;
		if(!Objects.equals(this.__spouse_identification_number, o.getSpouseIdentificationNumber())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__fid, o.getFid())) return false;
		if(!Objects.equals(this.__furl, o.getFurl())) return false;
		if(!Objects.equals(this.__special_deduction_detail_id, o.getSpecialDeductionDetailId())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__other_document_type, o.getOtherDocumentType())) return false;
		if(!Objects.equals(this.__other_identification_number, o.getOtherIdentificationNumber())) return false;
		if(!Objects.equals(this.__brithdate, o.getBrithdate())) return false;
		if(!Objects.equals(this.__nationality_region, o.getNationalityRegion())) return false;
		if(!Objects.equals(this.__schooling, o.getSchooling())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__schooling_termination_date, o.getSchoolingTerminationDate())) return false;
		if(!Objects.equals(this.__schooling_region, o.getSchoolingRegion())) return false;
		if(!Objects.equals(this.__school, o.getSchool())) return false;
		if(!Objects.equals(this.__deduction_percentage, o.getDeductionPercentage())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		if(!Objects.equals(this.__education_type, o.getEducationType())) return false;
		if(!Objects.equals(this.__education_stage, o.getEducationStage())) return false;
		if(!Objects.equals(this.__issue_date, o.getIssueDate())) return false;
		if(!Objects.equals(this.__credential, o.getCredential())) return false;
		if(!Objects.equals(this.__credential_number, o.getCredentialNumber())) return false;
		if(!Objects.equals(this.__issuing_authority, o.getIssuingAuthority())) return false;
		if(!Objects.equals(this.__house_address, o.getHouseAddress())) return false;
		if(!Objects.equals(this.__house_borrower, o.getHouseBorrower())) return false;
		if(!Objects.equals(this.__house_type, o.getHouseType())) return false;
		if(!Objects.equals(this.__house_number, o.getHouseNumber())) return false;
		if(!Objects.equals(this.__house_first, o.getHouseFirst())) return false;
		if(!Objects.equals(this.__loan_type, o.getLoanType())) return false;
		if(!Objects.equals(this.__creditor_bank, o.getCreditorBank())) return false;
		if(!Objects.equals(this.__creditor_contract_number, o.getCreditorContractNumber())) return false;
		if(!Objects.equals(this.__repayment_first_date, o.getRepaymentFirstDate())) return false;
		if(!Objects.equals(this.__repayment, o.getRepayment())) return false;
		if(!Objects.equals(this.__house_amount, o.getHouseAmount())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__lease_type, o.getLeaseType())) return false;
		if(!Objects.equals(this.__lease_address, o.getLeaseAddress())) return false;
		if(!Objects.equals(this.__lease_contract_number, o.getLeaseContractNumber())) return false;
		if(!Objects.equals(this.__single_child, o.getSingleChild())) return false;
		if(!Objects.equals(this.__allocation_way, o.getAllocationWay())) return false;
		if(!Objects.equals(this.__allocation_amount, o.getAllocationAmount())) return false;
		if(!Objects.equals(this.__change_type, o.getChangeType())) return false;
		if(!Objects.equals(this.__hospitalization_total_cost, o.getHospitalizationTotalCost())) return false;
		if(!Objects.equals(this.__hospitalization_personal_cost, o.getHospitalizationPersonalCost())) return false;
		if(!Objects.equals(this.__relationship, o.getRelationship())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__special_deduction_type_id, o.getSpecialDeductionTypeId())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__alternate_field1, o.getAlternateField1())) return false;
		if(!Objects.equals(this.__alternate_field2, o.getAlternateField2())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSpecialDeductionRecordId() != null) sb.append(__wrapNumber(count++, "specialDeductionRecordId", getSpecialDeductionRecordId()));
		if(getEmployeId() != null) sb.append(__wrapNumber(count++, "employeId", getEmployeId()));
		if(getDeparmentId() != null) sb.append(__wrapNumber(count++, "deparmentId", getDeparmentId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getDocumentType() != null) sb.append(__wrapNumber(count++, "documentType", getDocumentType()));
		if(getIdentificationNumber() != null) sb.append(__wrapString(count++, "identificationNumber", getIdentificationNumber()));
		if(getPhone() != null) sb.append(__wrapString(count++, "phone", getPhone()));
		if(getTaxpayerRegistrationNumber() != null) sb.append(__wrapString(count++, "taxpayerRegistrationNumber", getTaxpayerRegistrationNumber()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getWithholdName() != null) sb.append(__wrapString(count++, "withholdName", getWithholdName()));
		if(getWithholdRegistrationNumber() != null) sb.append(__wrapString(count++, "withholdRegistrationNumber", getWithholdRegistrationNumber()));
		if(getSpouseSituation() != null) sb.append(__wrapNumber(count++, "spouseSituation", getSpouseSituation()));
		if(getSpouseName() != null) sb.append(__wrapString(count++, "spouseName", getSpouseName()));
		if(getSpouseDocumentType() != null) sb.append(__wrapNumber(count++, "spouseDocumentType", getSpouseDocumentType()));
		if(getSpouseIdentificationNumber() != null) sb.append(__wrapString(count++, "spouseIdentificationNumber", getSpouseIdentificationNumber()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getFid() != null) sb.append(__wrapString(count++, "fid", getFid()));
		if(getFurl() != null) sb.append(__wrapString(count++, "furl", getFurl()));
		if(getSpecialDeductionDetailId() != null) sb.append(__wrapNumber(count++, "specialDeductionDetailId", getSpecialDeductionDetailId()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getOtherDocumentType() != null) sb.append(__wrapNumber(count++, "otherDocumentType", getOtherDocumentType()));
		if(getOtherIdentificationNumber() != null) sb.append(__wrapString(count++, "otherIdentificationNumber", getOtherIdentificationNumber()));
		if(getBrithdate() != null) sb.append(__wrapDate(count++, "brithdate", getBrithdate()));
		if(getNationalityRegion() != null) sb.append(__wrapString(count++, "nationalityRegion", getNationalityRegion()));
		if(getSchooling() != null) sb.append(__wrapNumber(count++, "schooling", getSchooling()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getSchoolingTerminationDate() != null) sb.append(__wrapDate(count++, "schoolingTerminationDate", getSchoolingTerminationDate()));
		if(getSchoolingRegion() != null) sb.append(__wrapString(count++, "schoolingRegion", getSchoolingRegion()));
		if(getSchool() != null) sb.append(__wrapString(count++, "school", getSchool()));
		if(getDeductionPercentage() != null) sb.append(__wrapDecimal(count++, "deductionPercentage", getDeductionPercentage()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		if(getEducationType() != null) sb.append(__wrapNumber(count++, "educationType", getEducationType()));
		if(getEducationStage() != null) sb.append(__wrapNumber(count++, "educationStage", getEducationStage()));
		if(getIssueDate() != null) sb.append(__wrapDate(count++, "issueDate", getIssueDate()));
		if(getCredential() != null) sb.append(__wrapString(count++, "credential", getCredential()));
		if(getCredentialNumber() != null) sb.append(__wrapString(count++, "credentialNumber", getCredentialNumber()));
		if(getIssuingAuthority() != null) sb.append(__wrapString(count++, "issuingAuthority", getIssuingAuthority()));
		if(getHouseAddress() != null) sb.append(__wrapString(count++, "houseAddress", getHouseAddress()));
		if(getHouseBorrower() != null) sb.append(__wrapNumber(count++, "houseBorrower", getHouseBorrower()));
		if(getHouseType() != null) sb.append(__wrapNumber(count++, "houseType", getHouseType()));
		if(getHouseNumber() != null) sb.append(__wrapString(count++, "houseNumber", getHouseNumber()));
		if(getHouseFirst() != null) sb.append(__wrapNumber(count++, "houseFirst", getHouseFirst()));
		if(getLoanType() != null) sb.append(__wrapNumber(count++, "loanType", getLoanType()));
		if(getCreditorBank() != null) sb.append(__wrapString(count++, "creditorBank", getCreditorBank()));
		if(getCreditorContractNumber() != null) sb.append(__wrapString(count++, "creditorContractNumber", getCreditorContractNumber()));
		if(getRepaymentFirstDate() != null) sb.append(__wrapDate(count++, "repaymentFirstDate", getRepaymentFirstDate()));
		if(getRepayment() != null) sb.append(__wrapNumber(count++, "repayment", getRepayment()));
		if(getHouseAmount() != null) sb.append(__wrapDecimal(count++, "houseAmount", getHouseAmount()));
		if(getProvince() != null) sb.append(__wrapString(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapString(count++, "city", getCity()));
		if(getLeaseType() != null) sb.append(__wrapNumber(count++, "leaseType", getLeaseType()));
		if(getLeaseAddress() != null) sb.append(__wrapString(count++, "leaseAddress", getLeaseAddress()));
		if(getLeaseContractNumber() != null) sb.append(__wrapString(count++, "leaseContractNumber", getLeaseContractNumber()));
		if(getSingleChild() != null) sb.append(__wrapNumber(count++, "singleChild", getSingleChild()));
		if(getAllocationWay() != null) sb.append(__wrapString(count++, "allocationWay", getAllocationWay()));
		if(getAllocationAmount() != null) sb.append(__wrapDecimal(count++, "allocationAmount", getAllocationAmount()));
		if(getChangeType() != null) sb.append(__wrapNumber(count++, "changeType", getChangeType()));
		if(getHospitalizationTotalCost() != null) sb.append(__wrapDecimal(count++, "hospitalizationTotalCost", getHospitalizationTotalCost()));
		if(getHospitalizationPersonalCost() != null) sb.append(__wrapDecimal(count++, "hospitalizationPersonalCost", getHospitalizationPersonalCost()));
		if(getRelationship() != null) sb.append(__wrapNumber(count++, "relationship", getRelationship()));
		if(getFileId() != null) sb.append(__wrapString(count++, "fileId", getFileId()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(count++, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getAlternateField1() != null) sb.append(__wrapString(count++, "alternateField1", getAlternateField1()));
		if(getAlternateField2() != null) sb.append(__wrapString(count++, "alternateField2", getAlternateField2()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSpecialDeductionRecordId() != null) res.put("specialDeductionRecordId", getSpecialDeductionRecordId());
		if(getEmployeId() != null) res.put("employeId", getEmployeId());
		if(getDeparmentId() != null) res.put("deparmentId", getDeparmentId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getDocumentType() != null) res.put("documentType", getDocumentType());
		if(getIdentificationNumber() != null) res.put("identificationNumber", getIdentificationNumber());
		if(getPhone() != null) res.put("phone", getPhone());
		if(getTaxpayerRegistrationNumber() != null) res.put("taxpayerRegistrationNumber", getTaxpayerRegistrationNumber());
		if(getAddress() != null) res.put("address", getAddress());
		if(getEmail() != null) res.put("email", getEmail());
		if(getWithholdName() != null) res.put("withholdName", getWithholdName());
		if(getWithholdRegistrationNumber() != null) res.put("withholdRegistrationNumber", getWithholdRegistrationNumber());
		if(getSpouseSituation() != null) res.put("spouseSituation", getSpouseSituation());
		if(getSpouseName() != null) res.put("spouseName", getSpouseName());
		if(getSpouseDocumentType() != null) res.put("spouseDocumentType", getSpouseDocumentType());
		if(getSpouseIdentificationNumber() != null) res.put("spouseIdentificationNumber", getSpouseIdentificationNumber());
		if(getIsEnable() != null) res.put("isEnable", getIsEnable());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getFid() != null) res.put("fid", getFid());
		if(getFurl() != null) res.put("furl", getFurl());
		if(getSpecialDeductionDetailId() != null) res.put("specialDeductionDetailId", getSpecialDeductionDetailId());
		if(getParentId() != null) res.put("parentId", getParentId());
		if(getName() != null) res.put("name", getName());
		if(getOtherDocumentType() != null) res.put("otherDocumentType", getOtherDocumentType());
		if(getOtherIdentificationNumber() != null) res.put("otherIdentificationNumber", getOtherIdentificationNumber());
		if(getBrithdate() != null) res.put("brithdate", getBrithdate());
		if(getNationalityRegion() != null) res.put("nationalityRegion", getNationalityRegion());
		if(getSchooling() != null) res.put("schooling", getSchooling());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getSchoolingTerminationDate() != null) res.put("schoolingTerminationDate", getSchoolingTerminationDate());
		if(getSchoolingRegion() != null) res.put("schoolingRegion", getSchoolingRegion());
		if(getSchool() != null) res.put("school", getSchool());
		if(getDeductionPercentage() != null) res.put("deductionPercentage", getDeductionPercentage());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getNum() != null) res.put("num", getNum());
		if(getEducationType() != null) res.put("educationType", getEducationType());
		if(getEducationStage() != null) res.put("educationStage", getEducationStage());
		if(getIssueDate() != null) res.put("issueDate", getIssueDate());
		if(getCredential() != null) res.put("credential", getCredential());
		if(getCredentialNumber() != null) res.put("credentialNumber", getCredentialNumber());
		if(getIssuingAuthority() != null) res.put("issuingAuthority", getIssuingAuthority());
		if(getHouseAddress() != null) res.put("houseAddress", getHouseAddress());
		if(getHouseBorrower() != null) res.put("houseBorrower", getHouseBorrower());
		if(getHouseType() != null) res.put("houseType", getHouseType());
		if(getHouseNumber() != null) res.put("houseNumber", getHouseNumber());
		if(getHouseFirst() != null) res.put("houseFirst", getHouseFirst());
		if(getLoanType() != null) res.put("loanType", getLoanType());
		if(getCreditorBank() != null) res.put("creditorBank", getCreditorBank());
		if(getCreditorContractNumber() != null) res.put("creditorContractNumber", getCreditorContractNumber());
		if(getRepaymentFirstDate() != null) res.put("repaymentFirstDate", getRepaymentFirstDate());
		if(getRepayment() != null) res.put("repayment", getRepayment());
		if(getHouseAmount() != null) res.put("houseAmount", getHouseAmount());
		if(getProvince() != null) res.put("province", getProvince());
		if(getCity() != null) res.put("city", getCity());
		if(getLeaseType() != null) res.put("leaseType", getLeaseType());
		if(getLeaseAddress() != null) res.put("leaseAddress", getLeaseAddress());
		if(getLeaseContractNumber() != null) res.put("leaseContractNumber", getLeaseContractNumber());
		if(getSingleChild() != null) res.put("singleChild", getSingleChild());
		if(getAllocationWay() != null) res.put("allocationWay", getAllocationWay());
		if(getAllocationAmount() != null) res.put("allocationAmount", getAllocationAmount());
		if(getChangeType() != null) res.put("changeType", getChangeType());
		if(getHospitalizationTotalCost() != null) res.put("hospitalizationTotalCost", getHospitalizationTotalCost());
		if(getHospitalizationPersonalCost() != null) res.put("hospitalizationPersonalCost", getHospitalizationPersonalCost());
		if(getRelationship() != null) res.put("relationship", getRelationship());
		if(getFileId() != null) res.put("fileId", getFileId());
		if(getFileUrl() != null) res.put("fileUrl", getFileUrl());
		if(getYear() != null) res.put("year", getYear());
		if(getSpecialDeductionTypeId() != null) res.put("specialDeductionTypeId", getSpecialDeductionTypeId());
		if(getCreateDate() != null) res.put("createDate", getCreateDate());
		if(getAlternateField1() != null) res.put("alternateField1", getAlternateField1());
		if(getAlternateField2() != null) res.put("alternateField2", getAlternateField2());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("specialDeductionRecordId")) != null) setSpecialDeductionRecordId(__getInt(val)); 
		if((val = values.get("employeId")) != null) setEmployeId(__getInt(val)); 
		if((val = values.get("deparmentId")) != null) setDeparmentId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("documentType")) != null) setDocumentType(__getInt(val)); 
		if((val = values.get("identificationNumber")) != null) setIdentificationNumber(__getString(val));
		if((val = values.get("phone")) != null) setPhone(__getString(val));
		if((val = values.get("taxpayerRegistrationNumber")) != null) setTaxpayerRegistrationNumber(__getString(val));
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("withholdName")) != null) setWithholdName(__getString(val));
		if((val = values.get("withholdRegistrationNumber")) != null) setWithholdRegistrationNumber(__getString(val));
		if((val = values.get("spouseSituation")) != null) setSpouseSituation(__getInt(val)); 
		if((val = values.get("spouseName")) != null) setSpouseName(__getString(val));
		if((val = values.get("spouseDocumentType")) != null) setSpouseDocumentType(__getInt(val)); 
		if((val = values.get("spouseIdentificationNumber")) != null) setSpouseIdentificationNumber(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("fid")) != null) setFid(__getString(val));
		if((val = values.get("furl")) != null) setFurl(__getString(val));
		if((val = values.get("specialDeductionDetailId")) != null) setSpecialDeductionDetailId(__getInt(val)); 
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("otherDocumentType")) != null) setOtherDocumentType(__getInt(val)); 
		if((val = values.get("otherIdentificationNumber")) != null) setOtherIdentificationNumber(__getString(val));
		if((val = values.get("brithdate")) != null) setBrithdate(__getDate(val)); 
		if((val = values.get("nationalityRegion")) != null) setNationalityRegion(__getString(val));
		if((val = values.get("schooling")) != null) setSchooling(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("schoolingTerminationDate")) != null) setSchoolingTerminationDate(__getDate(val)); 
		if((val = values.get("schoolingRegion")) != null) setSchoolingRegion(__getString(val));
		if((val = values.get("school")) != null) setSchool(__getString(val));
		if((val = values.get("deductionPercentage")) != null) setDeductionPercentage(__getDecimal(val));  
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("num")) != null) setNum(__getInt(val)); 
		if((val = values.get("educationType")) != null) setEducationType(__getInt(val)); 
		if((val = values.get("educationStage")) != null) setEducationStage(__getInt(val)); 
		if((val = values.get("issueDate")) != null) setIssueDate(__getDate(val)); 
		if((val = values.get("credential")) != null) setCredential(__getString(val));
		if((val = values.get("credentialNumber")) != null) setCredentialNumber(__getString(val));
		if((val = values.get("issuingAuthority")) != null) setIssuingAuthority(__getString(val));
		if((val = values.get("houseAddress")) != null) setHouseAddress(__getString(val));
		if((val = values.get("houseBorrower")) != null) setHouseBorrower(__getInt(val)); 
		if((val = values.get("houseType")) != null) setHouseType(__getInt(val)); 
		if((val = values.get("houseNumber")) != null) setHouseNumber(__getString(val));
		if((val = values.get("houseFirst")) != null) setHouseFirst(__getInt(val)); 
		if((val = values.get("loanType")) != null) setLoanType(__getInt(val)); 
		if((val = values.get("creditorBank")) != null) setCreditorBank(__getString(val));
		if((val = values.get("creditorContractNumber")) != null) setCreditorContractNumber(__getString(val));
		if((val = values.get("repaymentFirstDate")) != null) setRepaymentFirstDate(__getDate(val)); 
		if((val = values.get("repayment")) != null) setRepayment(__getInt(val)); 
		if((val = values.get("houseAmount")) != null) setHouseAmount(__getDecimal(val));  
		if((val = values.get("province")) != null) setProvince(__getString(val));
		if((val = values.get("city")) != null) setCity(__getString(val));
		if((val = values.get("leaseType")) != null) setLeaseType(__getInt(val)); 
		if((val = values.get("leaseAddress")) != null) setLeaseAddress(__getString(val));
		if((val = values.get("leaseContractNumber")) != null) setLeaseContractNumber(__getString(val));
		if((val = values.get("singleChild")) != null) setSingleChild(__getInt(val)); 
		if((val = values.get("allocationWay")) != null) setAllocationWay(__getString(val));
		if((val = values.get("allocationAmount")) != null) setAllocationAmount(__getDecimal(val));  
		if((val = values.get("changeType")) != null) setChangeType(__getInt(val)); 
		if((val = values.get("hospitalizationTotalCost")) != null) setHospitalizationTotalCost(__getDecimal(val));  
		if((val = values.get("hospitalizationPersonalCost")) != null) setHospitalizationPersonalCost(__getDecimal(val));  
		if((val = values.get("relationship")) != null) setRelationship(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getString(val));
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("alternateField1")) != null) setAlternateField1(__getString(val));
		if((val = values.get("alternateField2")) != null) setAlternateField2(__getString(val));
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
	}

	protected java.lang.Integer  __special_deduction_record_id ;
	protected java.lang.Integer  __employe_id ;
	protected java.lang.Integer  __deparment_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __document_type ;
	protected java.lang.String  __identification_number ;
	protected java.lang.String  __phone ;
	protected java.lang.String  __taxpayer_registration_number ;
	protected java.lang.String  __address ;
	protected java.lang.String  __email ;
	protected java.lang.String  __withhold_name ;
	protected java.lang.String  __withhold_registration_number ;
	protected java.lang.Integer  __spouse_situation ;
	protected java.lang.String  __spouse_name ;
	protected java.lang.Integer  __spouse_document_type ;
	protected java.lang.String  __spouse_identification_number ;
	protected java.lang.Boolean  __is_enable ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __fid ;
	protected java.lang.String  __furl ;
	protected java.lang.Integer  __special_deduction_detail_id ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __name ;
	protected java.lang.Integer  __other_document_type ;
	protected java.lang.String  __other_identification_number ;
	protected java.util.Date  __brithdate ;
	protected java.lang.String  __nationality_region ;
	protected java.lang.Integer  __schooling ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.util.Date  __schooling_termination_date ;
	protected java.lang.String  __schooling_region ;
	protected java.lang.String  __school ;
	protected java.math.BigDecimal  __deduction_percentage ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __num ;
	protected java.lang.Integer  __education_type ;
	protected java.lang.Integer  __education_stage ;
	protected java.util.Date  __issue_date ;
	protected java.lang.String  __credential ;
	protected java.lang.String  __credential_number ;
	protected java.lang.String  __issuing_authority ;
	protected java.lang.String  __house_address ;
	protected java.lang.Integer  __house_borrower ;
	protected java.lang.Integer  __house_type ;
	protected java.lang.String  __house_number ;
	protected java.lang.Integer  __house_first ;
	protected java.lang.Integer  __loan_type ;
	protected java.lang.String  __creditor_bank ;
	protected java.lang.String  __creditor_contract_number ;
	protected java.util.Date  __repayment_first_date ;
	protected java.lang.Integer  __repayment ;
	protected java.math.BigDecimal  __house_amount ;
	protected java.lang.String  __province ;
	protected java.lang.String  __city ;
	protected java.lang.Integer  __lease_type ;
	protected java.lang.String  __lease_address ;
	protected java.lang.String  __lease_contract_number ;
	protected java.lang.Integer  __single_child ;
	protected java.lang.String  __allocation_way ;
	protected java.math.BigDecimal  __allocation_amount ;
	protected java.lang.Integer  __change_type ;
	protected java.math.BigDecimal  __hospitalization_total_cost ;
	protected java.math.BigDecimal  __hospitalization_personal_cost ;
	protected java.lang.Integer  __relationship ;
	protected java.lang.String  __file_id ;
	protected java.lang.String  __file_url ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __special_deduction_type_id ;
	protected java.util.Date  __create_date ;
	protected java.lang.String  __alternate_field1 ;
	protected java.lang.String  __alternate_field2 ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __process_instance_id ;
}
