package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadAttachmentBindContract extends GenericBase implements BaseFactory<BaseOnLoadAttachmentBindContract>, Comparable<BaseOnLoadAttachmentBindContract> 
{


	public static BaseOnLoadAttachmentBindContract newInstance(){
		return new BaseOnLoadAttachmentBindContract();
	}

	@Override
	public BaseOnLoadAttachmentBindContract make(){
		BaseOnLoadAttachmentBindContract b = new BaseOnLoadAttachmentBindContract();
		return b;
	}

	public final static java.lang.String CS_CONTRACT_LINK_ATTACHMENT_ID = "contract_link_attachment_id" ;
	public final static java.lang.String CS_CONTRACT_ATTACHMENT_ID = "contract_attachment_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_SIGNING_MONEY_SUM = "signing_money_sum" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同附件Id,合同编码,附件编码,合同编号,合同名称,客户名称,我方签约公司,合同金额";

	public java.lang.Integer getContractLinkAttachmentId() {
		return this.__contract_link_attachment_id;
	}

	public void setContractLinkAttachmentId( java.lang.Integer value ) {
		this.__contract_link_attachment_id = value;
	}

	public java.lang.Integer getContractAttachmentId() {
		return this.__contract_attachment_id;
	}

	public void setContractAttachmentId( java.lang.Integer value ) {
		this.__contract_attachment_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
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

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.math.BigDecimal getSigningMoneySum() {
		return this.__signing_money_sum;
	}

	public void setSigningMoneySum( java.math.BigDecimal value ) {
		this.__signing_money_sum = value;
	}

	public void cloneCopy(BaseOnLoadAttachmentBindContract __bean){
		__bean.setContractLinkAttachmentId(getContractLinkAttachmentId());
		__bean.setContractAttachmentId(getContractAttachmentId());
		__bean.setContractId(getContractId());
		__bean.setFileId(getFileId());
		__bean.setContractCode(getContractCode());
		__bean.setContractName(getContractName());
		__bean.setCustomerName(getCustomerName());
		__bean.setCompanyId(getCompanyId());
		__bean.setSigningMoneySum(getSigningMoneySum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContractLinkAttachmentId() == null ? "" : getContractLinkAttachmentId());
		sb.append(",");
		sb.append(getContractAttachmentId() == null ? "" : getContractAttachmentId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getSigningMoneySum() == null ? "" : getSigningMoneySum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadAttachmentBindContract o) {
		return __contract_link_attachment_id == null ? -1 : __contract_link_attachment_id.compareTo(o.getContractLinkAttachmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contract_link_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__signing_money_sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadAttachmentBindContract o = (BaseOnLoadAttachmentBindContract)obj;
		if(!Objects.equals(this.__contract_link_attachment_id, o.getContractLinkAttachmentId())) return false;
		if(!Objects.equals(this.__contract_attachment_id, o.getContractAttachmentId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__signing_money_sum, o.getSigningMoneySum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContractLinkAttachmentId() != null) sb.append(__wrapNumber(count++, "contractLinkAttachmentId", getContractLinkAttachmentId()));
		if(getContractAttachmentId() != null) sb.append(__wrapNumber(count++, "contractAttachmentId", getContractAttachmentId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getSigningMoneySum() != null) sb.append(__wrapDecimal(count++, "signingMoneySum", getSigningMoneySum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contractLinkAttachmentId")) != null) setContractLinkAttachmentId(__getInt(val)); 
		if((val = values.get("contractAttachmentId")) != null) setContractAttachmentId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("signingMoneySum")) != null) setSigningMoneySum(__getDecimal(val));  
	}

	protected java.lang.Integer  __contract_link_attachment_id ;
	protected java.lang.Integer  __contract_attachment_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __customer_name ;
	protected java.lang.Integer  __company_id ;
	protected java.math.BigDecimal  __signing_money_sum ;
}
