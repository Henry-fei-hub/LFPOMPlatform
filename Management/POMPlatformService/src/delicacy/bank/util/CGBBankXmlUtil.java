package delicacy.bank.util;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import delicacy.common.BaseHelpUtils;

public class CGBBankXmlUtil {

	public final static String PASSWD = "qwer1234";
	
	public final static String RET_CODE = "000";
	
	public final static String ENT_USER_ID = "100001";
	
	public final static String CIF_MASTER= "1000195890";
	
	public static void main(String[] args) {

	}

	/**
	 * 添加公用报头
	 * @param messageElement
	 * @param params
	 */
	public static void addCommHeadElement(Element messageElement, Map<String, Object> params) {
		Element commHeadElement = messageElement.addElement("commHead");
		Element tranCodeElement = commHeadElement.addElement("tranCode");
		tranCodeElement.addText(BaseHelpUtils.getStringValue(params, "tranCode"));
		Element cifMasterElement = commHeadElement.addElement("cifMaster");
		cifMasterElement.addText(CIF_MASTER);
		Element entSeqNoElement = commHeadElement.addElement("entSeqNo");
		entSeqNoElement.addText(BaseHelpUtils.getStringValue(params, "entSeqNo"));
		Element tranDateElement = commHeadElement.addElement("tranDate");
		tranDateElement.addText(BaseHelpUtils.getStringValue(params, "tranDate"));
		Element tranTimeElement = commHeadElement.addElement("tranTime");
		tranTimeElement.addText(BaseHelpUtils.getStringValue(params, "tranTime"));
		Element retCodeElement = commHeadElement.addElement("retCode");
		retCodeElement.addText(RET_CODE);
		Element entUserIdElement = commHeadElement.addElement("entUserId");
		entUserIdElement.addText(ENT_USER_ID);
		Element passwordElement = commHeadElement.addElement("password");
		passwordElement.addCDATA(PASSWD);
	}
	
	
	/**
	 * 3.1.1.3: 查询交易状态
	 * @param params
	 * @return
	 */
	public static String getTransactionStatusXML(Map<String, Object> params){
		// 设置交易码
		params.put("tranCode", "1004");
		
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("BEDC");
		
		Element messageElement = rootElement.addElement("Message");
		
		// 添加通用报头数据定义 
		addCommHeadElement(messageElement, params);
		
		Element bodyElement = messageElement.addElement("Body");
		
		Element origEntseqnoElement = bodyElement.addElement("origEntseqno");
		origEntseqnoElement.addText(BaseHelpUtils.getStringValue(params, "origEntseqno"));
		Element origEntdateElement = bodyElement.addElement("origEntdate");
		origEntdateElement.addText(BaseHelpUtils.getStringValue(params, "origEntdate"));
		
		return document.asXML();
	}
	
	/**
	 * 3.1.1.1 行内单笔转账
	 * @param params
	 * @return
	 */
	public static String createIntraBankTransferXML(Map<String, Object> params){
		// 设置交易码
		params.put("tranCode", "0011");
		
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("BEDC");
		
		Element messageElement = rootElement.addElement("Message");
		
		// 添加通用报头数据定义 
		addCommHeadElement(messageElement, params);
		
		Element bodyElement = messageElement.addElement("Body");
		Element traceNoElement = bodyElement.addElement("traceNo");
		traceNoElement.addText(BaseHelpUtils.getStringValue(params, "traceNo"));
		Element outAccNameElement = bodyElement.addElement("outAccName");
		outAccNameElement.addText(BaseHelpUtils.getStringValue(params, "outAccName"));
		
		
		Element outAccElement = bodyElement.addElement("outAcc");
		outAccElement.addText(BaseHelpUtils.getStringValue(params, "outAcc"));
		Element outAccBankElement = bodyElement.addElement("outAccBank");
		outAccBankElement.addText(BaseHelpUtils.getStringValue(params, "outAccBank"));
		Element inAccNameElement = bodyElement.addElement("inAccName");
		inAccNameElement.addText(BaseHelpUtils.getStringValue(params, "inAccName"));
		Element inAccElement = bodyElement.addElement("inAcc");
		inAccElement.addText(BaseHelpUtils.getStringValue(params, "inAcc"));
		Element inAccBankElement = bodyElement.addElement("inAccBank");
		inAccBankElement.addText(BaseHelpUtils.getStringValue(params, "inAccBank"));
		Element inAccAddElement = bodyElement.addElement("inAccAdd");
		inAccAddElement.addText(BaseHelpUtils.getStringValue(params, "inAccAdd"));
		Element amountElement = bodyElement.addElement("amount");
		amountElement.addText(BaseHelpUtils.getStringValue(params, "amount"));
		Element remarkElement = bodyElement.addElement("remark");
		remarkElement.addText(BaseHelpUtils.getStringValue(params, "remark"));
		
		Element dateElement = bodyElement.addElement("date");
		dateElement.addText(BaseHelpUtils.getStringValue(params, "date"));
		Element commentElement = bodyElement.addElement("comment");
		commentElement.addText(BaseHelpUtils.getStringValue(params, "comment"));
		Element creNoElement = bodyElement.addElement("creNo");
		creNoElement.addText(BaseHelpUtils.getStringValue(params, "creNo"));
		Element frBalanceElement = bodyElement.addElement("frBalance");
		frBalanceElement.addText(BaseHelpUtils.getStringValue(params, "frBalance"));
		Element toBalanceElement = bodyElement.addElement("toBalance");
		toBalanceElement.addText(BaseHelpUtils.getStringValue(params, "toBalance"));
		Element handleFeeElement = bodyElement.addElement("handleFee");
		handleFeeElement.addText(BaseHelpUtils.getStringValue(params, "handleFee"));
		Element virAccElement = bodyElement.addElement("virAcc");
		virAccElement.addText(BaseHelpUtils.getStringValue(params, "virAcc"));
		Element virAccFlagElement = bodyElement.addElement("virAccFlag");
		virAccFlagElement.addText(BaseHelpUtils.getStringValue(params, "virAccFlag"));
		
		return document.asXML();
	}
	
	/**
	 * 3.1.1.2 跨行回款(0021)
	 * @param params
	 * @param type 1:行内账号  2:行外账号
	 * @return
	 */
	public static String createExternalPaymentXML(Map<String, Object> params, int type) {
		// 设置交易码
		params.put("tranCode", "0021");
		
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("BEDC");
		
		Element messageElement = rootElement.addElement("Message");
		
		// 添加通用报头数据定义 
		addCommHeadElement(messageElement, params);
		
		Element bodyElement = messageElement.addElement("Body");
		Element outAccNameElement = bodyElement.addElement("outAccName");
		outAccNameElement.addText(BaseHelpUtils.getStringValue(params, "outAccName"));
		
		Element outAccElement = bodyElement.addElement("outAcc");
		outAccElement.addText(BaseHelpUtils.getStringValue(params, "outAcc"));
		Element inAccNameElement = bodyElement.addElement("inAccName");
		inAccNameElement.addText(BaseHelpUtils.getStringValue(params, "inAccName"));
		Element inAccElement = bodyElement.addElement("inAcc");
		inAccElement.addText(BaseHelpUtils.getStringValue(params, "inAcc"));
		Element inAccBankElement = bodyElement.addElement("inAccBank");
		inAccBankElement.addText(BaseHelpUtils.getStringValue(params, "inAccBank"));
		Element inAccAddElement = bodyElement.addElement("inAccAdd");
		inAccAddElement.addText(BaseHelpUtils.getStringValue(params, "inAccAdd"));
		Element amountElement = bodyElement.addElement("amount");
		amountElement.addText(BaseHelpUtils.getStringValue(params, "amount"));
		Element remarkElement = bodyElement.addElement("remark");
		remarkElement.addText(BaseHelpUtils.getStringValue(params, "remark"));
		Element commentElement = bodyElement.addElement("comment");
		commentElement.addText(BaseHelpUtils.getStringValue(params, "comment"));
		Element paymentBankidElement = bodyElement.addElement("paymentBankid");
		paymentBankidElement.addText(BaseHelpUtils.getStringValue(params, "paymentBankid"));
		if(type == 1) {
			Element virAccElement = bodyElement.addElement("virAcc");
			virAccElement.addText(BaseHelpUtils.getStringValue(params, "virAcc"));
			Element virAccFlagElement = bodyElement.addElement("virAccFlag");
			virAccFlagElement.addText(BaseHelpUtils.getStringValue(params, "virAccFlag"));
		}
		return document.asXML();
	}
	
	/**
	 * 创建批量付款报文
	 * @param params
	 * @param list
	 * @param type 1:行内  2:行外
	 * @return
	 */
	public static String createBatchPaymentXML(Map<String, Object> params, List<Map<String, Object>> list, int type) {
		// 设置交易码
		params.put("tranCode", "0033");
		
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("BEDC");
		
		Element messageElement = rootElement.addElement("Message");
		
		// 添加通用报头数据定义 
		addCommHeadElement(messageElement, params);
		
		Element bodyElement = messageElement.addElement("Body");
		Element customerBatchNoElement = bodyElement.addElement("customerBatchNo");
		customerBatchNoElement.addText(BaseHelpUtils.getStringValue(params, "customerBatchNoElement"));
		Element accountNoElement = bodyElement.addElement("accountNo");
		accountNoElement.addText(BaseHelpUtils.getStringValue(params, "accountNo"));
		Element allCountElement = bodyElement.addElement("allCount");
		allCountElement.addText(BaseHelpUtils.getStringValue(params, "allCount"));
		Element allSalaryElement = bodyElement.addElement("allSalary");
		allSalaryElement.addText(BaseHelpUtils.getStringValue(params, "allSalary"));
		
		Element recordsElement = bodyElement.addElement("records");
		for (Map<String, Object> recordMap : list) {
			Element recordElement = recordsElement.addElement("record");
			Element customerSalarySeqElement = recordElement.addElement("customerSalarySeq");
			customerSalarySeqElement.addText(BaseHelpUtils.getStringValue(recordMap, "customerSalarySeq"));
			Element transTypeElement = recordElement.addElement("transType");
			if(type == 1) {
				transTypeElement.addText("0");
			}else if(type == 2) {
				transTypeElement.addText("1");
			}
			
			Element inaccnameElement = recordElement.addElement("inaccname");
			inaccnameElement.addText(BaseHelpUtils.getStringValue(recordMap, "inaccname"));
			Element inaccElement = recordElement.addElement("inacc");
			inaccElement.addText(BaseHelpUtils.getStringValue(recordMap, "inacc"));
			Element inaccbankElement = recordElement.addElement("inaccbank");
			inaccbankElement.addText(BaseHelpUtils.getStringValue(recordMap, "inaccbank"));
			Element inaccaddElement = recordElement.addElement("inaccadd");
			inaccaddElement.addText(BaseHelpUtils.getStringValue(recordMap, "inaccadd"));
			Element bankCodeElement = recordElement.addElement("bankCode");
			bankCodeElement.addText(BaseHelpUtils.getStringValue(recordMap, "bankCode"));
			Element salaryElement = recordElement.addElement("salary");
			salaryElement.addText(BaseHelpUtils.getStringValue(recordMap, "salary"));
			Element remarkElement = recordElement.addElement("remark");
			remarkElement.addText(BaseHelpUtils.getStringValue(recordMap, "remark"));
			Element commentElement = recordElement.addElement("comment");
			commentElement.addText(BaseHelpUtils.getStringValue(recordMap, "comment"));
		}
		
		return document.asXML();
	}
	
	/**
	 * 3.1.2.2获取批量转账报文
	 * @param params
	 * @return
	 */
	public static String createGetBatchPamentStatusXML(Map<String, Object> params) {
		// 设置交易码
		params.put("tranCode", "0034");
		
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("BEDC");
		
		Element messageElement = rootElement.addElement("Message");
		
		// 添加通用报头数据定义 
		addCommHeadElement(messageElement, params);
		
		Element bodyElement = messageElement.addElement("Body");
		Element customerBatchNoElement = bodyElement.addElement("customerBatchNo");
		customerBatchNoElement.addText(BaseHelpUtils.getStringValue(params, "customerBatchNo"));
		Element customerSalarySeqElement = bodyElement.addElement("customerSalarySeq");
		customerSalarySeqElement.addText(BaseHelpUtils.getStringValue(params, "customerSalarySeq"));
		
		return document.asXML();
	}
}
