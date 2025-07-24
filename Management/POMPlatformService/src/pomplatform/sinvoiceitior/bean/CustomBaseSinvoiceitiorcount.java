package pomplatform.sinvoiceitior.bean;

import delicacy.common.BaseHelpUtils;

public class CustomBaseSinvoiceitiorcount extends BaseSinvoiceitiorcount
{


	public static CustomBaseSinvoiceitiorcount newInstance(){
		return new CustomBaseSinvoiceitiorcount();
	}


	public final static java.lang.String ALL_CAPTIONS = "购票公司,合同编号,合同名称,发票类型,发票代码,发票号码,发票入库日期,备注,客户名称,开票金额,税率,不含税金额,销项税,开票日期,开发票的登记日期,发票状态,原发票代码,原发票号码";

	public final static java.lang.String ALL_CAPTIONS_1 = "购票公司,发票类型,发票代码,发票号码";

	public java.lang.String setReplaceAll(String val){
		if(!BaseHelpUtils.isNullOrEmpty(val)){
			return val.replaceAll("\r", "").replaceAll("\n", "").replaceAll(",", "，");
		}
		return "";
	}
	
	public java.lang.String toCSVString() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String ticketingCompany = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_54", String.valueOf(getTicketingCompany()));
		sb.append(setReplaceAll(ticketingCompany));
		sb.append(",");
		sb.append(setReplaceAll(getContractCode()));
		sb.append(",");
		sb.append(setReplaceAll(getContractName()));
		sb.append(",");
		String invoiceType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_52", String.valueOf(getInvoiceType()));
		sb.append(setReplaceAll(invoiceType));
		sb.append(",");
		sb.append(setReplaceAll(getInvoiceCode()));
		sb.append(",");
		sb.append(setReplaceAll(getInvoiceNumber()));
		sb.append(",");
		sb.append(getInStockDate() == null ? "" : sdf.format(getInStockDate()));
		sb.append(",");
		sb.append(setReplaceAll(getInvalidRemark()));
		sb.append(",");
		String customer = delicacy.system.executor.SelectValueCache.getSelectValue("customers", String.valueOf(getCustomerId()));
		sb.append(setReplaceAll(customer));
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getTaxRate() == null ? "" : getTaxRate());
		sb.append(",");
		sb.append(getNoTaxAmount() == null ? "" : getNoTaxAmount());
		sb.append(",");
		sb.append(getOutputTax() == null ? "" : getOutputTax());
		sb.append(",");
		sb.append(getInvoiceDate() == null ? "" : sdf.format(getInvoiceDate()));
		sb.append(",");
		sb.append(getRegistrationDate() == null ? "" : sdf.format(getRegistrationDate()));
		sb.append(",");
		String sign = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_53", String.valueOf(getSign()));
		sb.append(setReplaceAll(sign));
		sb.append(",");
		sb.append(setReplaceAll(getPrimaryInvoiceCode()));
		sb.append(",");
		sb.append(setReplaceAll(getPrimaryInvoiceNumber()));
		return sb.toString();
	}

	
	public java.lang.String toCSV1String() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String ticketingCompany = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_54", String.valueOf(getTicketingCompany()));
		sb.append(ticketingCompany == null ? "" : ticketingCompany);
		sb.append(",");
		String invoiceType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_52", String.valueOf(getInvoiceType()));
		sb.append(invoiceType == null ? "" : invoiceType);
		sb.append(",");
		sb.append(getInvoiceCode() == null ? "" : getInvoiceCode());
		sb.append(",");
		sb.append(getInvoiceNumber() == null ? "" : getInvoiceNumber());
		return sb.toString();
	}
	
	public void copyFatherData(BaseSinvoiceitiorcount bean){
		try {
			setDataFromJSON(bean.toJSON());
			setInvoiceDate(bean.getInvoiceDate());
			setInStockDate(bean.getInStockDate());
			setRegistrationDate(bean.getRegistrationDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
