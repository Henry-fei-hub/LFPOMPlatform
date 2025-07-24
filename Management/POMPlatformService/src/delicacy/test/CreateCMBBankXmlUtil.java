package delicacy.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import delicacy.common.BaseHelpUtils;
import delicacy.socket.SocketUtils;

public class CreateCMBBankXmlUtil {
	
	/**
	 * 取系统信息XML
	 * @param params
	 * @return
	 */
	public static String createGetSysInfoXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetSysInfo");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdksyinfxElement = rootElement.addElement("SDKSYINFX");
		Element systypElement = sdksyinfxElement.addElement("SYSTYP");
		systypElement.addText(BaseHelpUtils.getStringValue(params, "SYSTYP"));
		return document.asXML();
	}
	
	//  账户 模板    XML          ***************************    开始 
	/**
	 * 2.1查询可查询/可经办的账户列表
	 * @param params
	 * @return
	 */
	public static String createListAccountXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("ListAccount");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdksyinfxElement = rootElement.addElement("SDKACLSTX");
		Element buscodElement = sdksyinfxElement.addElement("BUSCOD");
		buscodElement.addText(BaseHelpUtils.getStringValue(params, "BUSCOD"));
		Element busmodElement = sdksyinfxElement.addElement("BUSMOD");
		busmodElement.addText(BaseHelpUtils.getStringValue(params, "BUSMOD"));
		return document.asXML();
	}
	
	/**
	 * 2.2查询账户详细信息
	 * @param params
	 * @return
	 */
	public static String createGetAccInfoXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetAccInfo");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdksyinfxElement = rootElement.addElement("SDKACINFX");
		Element bbknbrElement = sdksyinfxElement.addElement("BBKNBR");
		bbknbrElement.addText(BaseHelpUtils.getStringValue(params, "BBKNBR"));
		Element c_bbknbrElement = sdksyinfxElement.addElement("C_BBKNBR");
		c_bbknbrElement.addText(BaseHelpUtils.getStringValue(params, "C_BBKNBR"));
		Element accnbrElement = sdksyinfxElement.addElement("ACCNBR");
		accnbrElement.addText(BaseHelpUtils.getStringValue(params, "ACCNBR"));
		return document.asXML();
		
	}
	
	/**
	 * 2.3查询账户交易信息
	 * @param params
	 * @return
	 */
	public static String createGetTransInfoXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetTransInfo");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdksyinfxElement = rootElement.addElement("SDKTSINFX");
		Element bbknbrElement = sdksyinfxElement.addElement("BBKNBR");
		bbknbrElement.addText(BaseHelpUtils.getStringValue(params, "BBKNBR"));
		Element c_bbknbrElement = sdksyinfxElement.addElement("C_BBKNBR");
		c_bbknbrElement.addText(BaseHelpUtils.getStringValue(params, "C_BBKNBR"));
		Element accnbrElement = sdksyinfxElement.addElement("ACCNBR");
		accnbrElement.addText(BaseHelpUtils.getStringValue(params, "ACCNBR"));
		Element bgndatElement = sdksyinfxElement.addElement("BGNDAT");
		bgndatElement.addText(BaseHelpUtils.getStringValue(params, "BGNDAT"));
		Element enddatElement = sdksyinfxElement.addElement("ENDDAT");
		enddatElement.addText(BaseHelpUtils.getStringValue(params, "ENDDAT"));
		Element lowamtElement = sdksyinfxElement.addElement("LOWAMT");
		lowamtElement.addText(BaseHelpUtils.getStringValue(params, "LOWAMT"));
		Element hghamtElement = sdksyinfxElement.addElement("HGHAMT");
		hghamtElement.addText(BaseHelpUtils.getStringValue(params, "HGHAMT"));
		Element amtcdrElement = sdksyinfxElement.addElement("AMTCDR");
		amtcdrElement.addText(BaseHelpUtils.getStringValue(params, "AMTCDR"));
		return document.asXML();
	}
	
	/**
	 * 2.5查询账户历史余额
	 * @param params
	 * @return
	 */
	public static String createGetAccountBalanceXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("SDKNTQABINF");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdksyinfxElement = rootElement.addElement("NTQABINFY");
		Element bbknbrElement = sdksyinfxElement.addElement("BBKNBR");
		bbknbrElement.addText(BaseHelpUtils.getStringValue(params, "BBKNBR"));
		Element accnbrElement = sdksyinfxElement.addElement("ACCNBR");
		accnbrElement.addText(BaseHelpUtils.getStringValue(params, "ACCNBR"));
		Element bgndatElement = sdksyinfxElement.addElement("BGNDAT");
		bgndatElement.addText(BaseHelpUtils.getStringValue(params, "BGNDAT"));
		Element enddatElement = sdksyinfxElement.addElement("ENDDAT");
		enddatElement.addText(BaseHelpUtils.getStringValue(params, "ENDDAT"));
		return document.asXML();
	}
	
	/**
	 * 2.6查询分行号信息
	 * @param params
	 * @return
	 */
	public static String createGetBbkInfoXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetBbkInfo");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdksyinfxElement = rootElement.addElement("NTACCBBKY");
		Element accnbrElement = sdksyinfxElement.addElement("ACCNBR");
		accnbrElement.addText(BaseHelpUtils.getStringValue(params, "ACCNBR"));
		return document.asXML();
	}
	
	/**
	 * 2.9批量查询余额
	 * @param params
	 * @return
	 */
	public static String createBatchGetAccountBalanceXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("NTQADINF");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdksyinfxElement = rootElement.addElement("NTQADINFX");
		Element bbknbrElement = sdksyinfxElement.addElement("BBKNBR");
		bbknbrElement.addText(BaseHelpUtils.getStringValue(params, "BBKNBR"));
		Element accnbrElement = sdksyinfxElement.addElement("ACCNBR");
		accnbrElement.addText(BaseHelpUtils.getStringValue(params, "ACCNBR"));
		return document.asXML();
	}
	
	//  账户 模板    XML          ***************************    结束
	
	
	//  支付  模板    XML          ***************************    开始 
	/**
	 * 3.1支付
	 * @param params
	 * @return
	 */
	public static String createPaymentXML(Map<String, Object> params, List<Map<String, Object>> list){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");//函数名
		funnamElement.addText("Payment");
		Element dattypElement = infoElement.addElement("DATTYP");//数据格式
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");//登陆用户名
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdkpayrqxElement = rootElement.addElement("SDKPAYRQX");
		Element buscodElement = sdkpayrqxElement.addElement("BUSCOD");
		buscodElement.addText(BaseHelpUtils.getStringValue(params, "BUSCOD"));
		Element busmodElement = sdkpayrqxElement.addElement("BUSMOD");
		busmodElement.addText(BaseHelpUtils.getStringValue(params, "BUSMOD"));
		Element modalsElement = sdkpayrqxElement.addElement("MODALS");
		modalsElement.addText(BaseHelpUtils.getStringValue(params, "MODALS"));
		
		for (Map<String, Object> map : list) {
			Element sdkpaydtxElement = rootElement.addElement("SDKPAYDTX");
			Element yurrefElement = sdkpaydtxElement.addElement("YURREF");
			yurrefElement.addText(BaseHelpUtils.getStringValue(map, "YURREF"));
			Element eptdatElement = sdkpaydtxElement.addElement("EPTDAT");
			eptdatElement.addText(BaseHelpUtils.getStringValue(map, "EPTDAT"));
			Element epttimElement = sdkpaydtxElement.addElement("EPTTIM");
			epttimElement.addText(BaseHelpUtils.getStringValue(map, "EPTTIM"));
			Element dbtaccElement = sdkpaydtxElement.addElement("DBTACC");
			dbtaccElement.addText(BaseHelpUtils.getStringValue(map, "DBTACC"));
			Element dbtbbkElement = sdkpaydtxElement.addElement("DBTBBK");
			dbtbbkElement.addText(BaseHelpUtils.getStringValue(map, "DBTBBK"));
			Element c_dbtbbkElement = sdkpaydtxElement.addElement("C_DBTBBK");
			c_dbtbbkElement.addText(BaseHelpUtils.getStringValue(map, "C_DBTBBK"));
			Element trsamtElement = sdkpaydtxElement.addElement("TRSAMT");
			trsamtElement.addText(BaseHelpUtils.getStringValue(map, "TRSAMT"));
			Element ccynbrElement = sdkpaydtxElement.addElement("CCYNBR");
			ccynbrElement.addText(BaseHelpUtils.getStringValue(map, "CCYNBR"));
			Element c_ccynbrElement = sdkpaydtxElement.addElement("C_CCYNBR");
			c_ccynbrElement.addText(BaseHelpUtils.getStringValue(map, "C_CCYNBR"));
			Element stlchnElement = sdkpaydtxElement.addElement("STLCHN");
			stlchnElement.addText(BaseHelpUtils.getStringValue(map, "STLCHN"));
			Element c_stlchnElement = sdkpaydtxElement.addElement("C_STLCHN");
			c_stlchnElement.addText(BaseHelpUtils.getStringValue(map, "C_STLCHN"));
			Element nusageElement = sdkpaydtxElement.addElement("NUSAGE");
			nusageElement.addText(BaseHelpUtils.getStringValue(map, "NUSAGE"));
			Element busnarElement = sdkpaydtxElement.addElement("BUSNAR");
			busnarElement.addText(BaseHelpUtils.getStringValue(map, "BUSNAR"));
			Element crtaccElement = sdkpaydtxElement.addElement("CRTACC");
			crtaccElement.addText(BaseHelpUtils.getStringValue(map, "CRTACC"));
			Element crtnamElement = sdkpaydtxElement.addElement("CRTNAM");
			crtnamElement.addText(BaseHelpUtils.getStringValue(map, "CRTNAM"));
			Element brdnbrElement = sdkpaydtxElement.addElement("BRDNBR");
			brdnbrElement.addText(BaseHelpUtils.getStringValue(map, "BRDNBR"));
			Element bnkflgElement = sdkpaydtxElement.addElement("BNKFLG");
			bnkflgElement.addText(BaseHelpUtils.getStringValue(map, "BNKFLG"));
			Element crtbnkElement = sdkpaydtxElement.addElement("CRTBNK");
			crtbnkElement.addText(BaseHelpUtils.getStringValue(map, "CRTBNK"));
			Element ctycodElement = sdkpaydtxElement.addElement("CTYCOD");
			ctycodElement.addText(BaseHelpUtils.getStringValue(map, "CTYCOD"));
			Element crtpvcElement = sdkpaydtxElement.addElement("CRTPVC");
			crtpvcElement.addText(BaseHelpUtils.getStringValue(map, "CRTPVC"));
			Element crtctyElement = sdkpaydtxElement.addElement("CRTCTY");
			crtctyElement.addText(BaseHelpUtils.getStringValue(map, "CRTCTY"));
			Element crtdtrElement = sdkpaydtxElement.addElement("CRTDTR");
			crtdtrElement.addText(BaseHelpUtils.getStringValue(map, "CRTDTR"));
			Element ntfch1Element = sdkpaydtxElement.addElement("NTFCH1");
			ntfch1Element.addText(BaseHelpUtils.getStringValue(map, "NTFCH1"));
			Element ntfch2Element = sdkpaydtxElement.addElement("NTFCH2");
			ntfch2Element.addText(BaseHelpUtils.getStringValue(map, "NTFCH2"));
			Element crtsqnElement = sdkpaydtxElement.addElement("CRTSQN");
			crtsqnElement.addText(BaseHelpUtils.getStringValue(map, "CRTSQN"));
			Element trstypElement = sdkpaydtxElement.addElement("TRSTYP");
			trstypElement.addText(BaseHelpUtils.getStringValue(map, "TRSTYP"));
			Element rsv29zElement = sdkpaydtxElement.addElement("RSV29Z");
			rsv29zElement.addText(BaseHelpUtils.getStringValue(map, "RSV29Z"));
		}

		return document.asXML();
	}
	
	/**
	 * 3.3查询支付结果
	 * @param params
	 * @return
	 */
	public static String createGetPaymentInfoXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetPaymentInfo");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdkpayqyxElement = rootElement.addElement("SDKPAYQYX");
		Element buscodElement = sdkpayqyxElement.addElement("BUSCOD");
		buscodElement.addText(BaseHelpUtils.getStringValue(params, "BUSCOD"));
		Element bgndatElement = sdkpayqyxElement.addElement("BGNDAT");
		bgndatElement.addText(BaseHelpUtils.getStringValue(params, "BGNDAT"));
		Element enddatElement = sdkpayqyxElement.addElement("ENDDAT");
		enddatElement.addText(BaseHelpUtils.getStringValue(params, "ENDDAT"));
		Element datflgElement = sdkpayqyxElement.addElement("DATFLG");
		datflgElement.addText(BaseHelpUtils.getStringValue(params, "DATFLG"));
		Element minamtElement = sdkpayqyxElement.addElement("MINAMT");
		minamtElement.addText(BaseHelpUtils.getStringValue(params, "MINAMT"));
		Element maxamtElement = sdkpayqyxElement.addElement("MAXAMT");
		maxamtElement.addText(BaseHelpUtils.getStringValue(params, "MAXAMT"));
		Element yurrefElement = sdkpayqyxElement.addElement("YURREF");
		yurrefElement.addText(BaseHelpUtils.getStringValue(params, "YURREF"));
		Element rtnflgElement = sdkpayqyxElement.addElement("RTNFLG");
		rtnflgElement.addText(BaseHelpUtils.getStringValue(params, "RTNFLG"));
		Element oprlgnElement = sdkpayqyxElement.addElement("OPRLGN");
		oprlgnElement.addText(BaseHelpUtils.getStringValue(params, "OPRLGN"));
		
		return document.asXML();
	}
	
	/**
	 * 3.9批量查询支付信息
	 * @param params
	 * @return
	 */
	public static String createBatchGetPaymentInfoXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("NTSTLINF");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element ntstlinfxElement = rootElement.addElement("NTSTLINFX");
		Element reqnbrElement = ntstlinfxElement.addElement("REQNBR");
		reqnbrElement.addText(BaseHelpUtils.getStringValue(params, "REQNBR"));
		
		return document.asXML();
	}
	
	//  支付  模板    XML          ***************************    结束 
	
	//  代发代扣      XML          ***************************    开始
	
	/**
	 * 4.1查询交易代码
	 * @param params
	 * @return
	 */
	public static String createQueryAgentListXML(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetPaymentInfo");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdkagttsxElement = rootElement.addElement("SDKAGTTSX");
		Element buscodElement = sdkagttsxElement.addElement("BUSCOD");
		buscodElement.addText(BaseHelpUtils.getStringValue(params, "BUSCOD"));
		
		return document.asXML();
	}
	
	/**
	 * 4.2直接代发代扣
	 * @param params
	 * @param list
	 * @return
	 */
	public static String createAgentRequestXML(Map<String, Object> params, List<Map<String, Object>> list){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetPaymentInfo");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdkatsrqxElement = rootElement.addElement("SDKATSRQX");
		Element buscodElement = sdkatsrqxElement.addElement("BUSCOD");
		buscodElement.addText(BaseHelpUtils.getStringValue(params, "BUSCOD"));
		Element busmodElement = sdkatsrqxElement.addElement("BUSMOD");
		busmodElement.addText(BaseHelpUtils.getStringValue(params, "BUSMOD"));
		Element modalsElement = sdkatsrqxElement.addElement("MODALS");
		modalsElement.addText(BaseHelpUtils.getStringValue(params, "MODALS"));
		Element c_trstypElement = sdkatsrqxElement.addElement("C_TRSTYP");
		c_trstypElement.addText(BaseHelpUtils.getStringValue(params, "C_TRSTYP"));
		Element trstypElement = sdkatsrqxElement.addElement("TRSTYP");
		trstypElement.addText(BaseHelpUtils.getStringValue(params, "TRSTYP"));
		Element eptdatElement = sdkatsrqxElement.addElement("EPTDAT");
		eptdatElement.addText(BaseHelpUtils.getStringValue(params, "EPTDAT"));
		Element dbtaccElement = sdkatsrqxElement.addElement("DBTACC");
		dbtaccElement.addText(BaseHelpUtils.getStringValue(params, "DBTACC"));
		Element bbknbrElement = sdkatsrqxElement.addElement("BBKNBR");
		bbknbrElement.addText(BaseHelpUtils.getStringValue(params, "BBKNBR"));
		Element bankareaElement = sdkatsrqxElement.addElement("BANKAREA");
		bankareaElement.addText(BaseHelpUtils.getStringValue(params, "BANKAREA"));
		Element sumElement = sdkatsrqxElement.addElement("SUM");
		sumElement.addText(BaseHelpUtils.getStringValue(params, "SUM"));
		Element totalElement = sdkatsrqxElement.addElement("TOTAL");
		totalElement.addText(BaseHelpUtils.getStringValue(params, "TOTAL"));
		Element ccynbrElement = sdkatsrqxElement.addElement("CCYNBR");
		ccynbrElement.addText(BaseHelpUtils.getStringValue(params, "CCYNBR"));
		Element currencyElement = sdkatsrqxElement.addElement("CURRENCY");
		currencyElement.addText(BaseHelpUtils.getStringValue(params, "CURRENCY"));
		Element yurrefElement = sdkatsrqxElement.addElement("YURREF");
		yurrefElement.addText(BaseHelpUtils.getStringValue(params, "YURREF"));
		Element memoElement = sdkatsrqxElement.addElement("MEMO");
		memoElement.addText(BaseHelpUtils.getStringValue(params, "MEMO"));
		Element dmanbrElement = sdkatsrqxElement.addElement("DMANBR");
		dmanbrElement.addText(BaseHelpUtils.getStringValue(params, "DMANBR"));
		Element grtflgElement = sdkatsrqxElement.addElement("GRTFLG");
		grtflgElement.addText(BaseHelpUtils.getStringValue(params, "GRTFLG"));
		
		//代发/代扣账号
		for (Map<String, Object> map : list) {
			Element sdkatdrqxElement = rootElement.addElement("SDKATDRQX");
			Element accnbrElement = sdkatdrqxElement.addElement("ACCNBR");
			accnbrElement.addText(BaseHelpUtils.getStringValue(map, "ACCNBR"));
			Element cltnamElement = sdkatdrqxElement.addElement("CLTNAM");
			cltnamElement.addText(BaseHelpUtils.getStringValue(map, "CLTNAM"));
			Element trsamtElement = sdkatdrqxElement.addElement("TRSAMT");
			trsamtElement.addText(BaseHelpUtils.getStringValue(map, "TRSAMT"));
			Element bnkflgElement = sdkatdrqxElement.addElement("BNKFLG");
			bnkflgElement.addText(BaseHelpUtils.getStringValue(map, "BNKFLG"));
			Element eacbnkElement = sdkatdrqxElement.addElement("EACBNK");
			eacbnkElement.addText(BaseHelpUtils.getStringValue(map, "EACBNK"));
			Element eacctyElement = sdkatdrqxElement.addElement("EACCTY");
			eacctyElement.addText(BaseHelpUtils.getStringValue(map, "EACCTY"));
			Element trsdspElement = sdkatdrqxElement.addElement("TRSDSP");
			trsdspElement.addText(BaseHelpUtils.getStringValue(map, "TRSDSP"));
		}
		
		return document.asXML();
	}
	
	/**
	 * 4.3查询交易概要信息
	 * @param params
	 * @return
	 */
	public static String createGetAgentInfo(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetAgentInfo");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdkagttsxElement = rootElement.addElement("SDKATSQYX");
		Element buscodElement = sdkagttsxElement.addElement("BUSCOD");
		buscodElement.addText(BaseHelpUtils.getStringValue(params, "BUSCOD"));
		Element bgndatElement = sdkagttsxElement.addElement("BGNDAT");
		bgndatElement.addText(BaseHelpUtils.getStringValue(params, "BGNDAT"));
		Element enddatElement = sdkagttsxElement.addElement("ENDDAT");
		enddatElement.addText(BaseHelpUtils.getStringValue(params, "ENDDAT"));
		Element datflgElement = sdkagttsxElement.addElement("DATFLG");
		datflgElement.addText(BaseHelpUtils.getStringValue(params, "DATFLG"));
		Element yurrefElement = sdkagttsxElement.addElement("YURREF");
		yurrefElement.addText(BaseHelpUtils.getStringValue(params, "YURREF"));
		Element oprlgnElement = sdkagttsxElement.addElement("OPRLGN");
		oprlgnElement.addText(BaseHelpUtils.getStringValue(params, "OPRLGN"));
		
		return document.asXML();
	}
	
	/**
	 * 4.4查询交易明细信息
	 * @param params
	 * @return
	 */
	public static String createGetAgentDetail(Map<String, Object> params){
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("GBK");
		
		Element rootElement = document.addElement("CMBSDKPGK");
		
		Element infoElement = rootElement.addElement("INFO");
		Element funnamElement = infoElement.addElement("FUNNAM");
		funnamElement.addText("GetAgentDetail");
		Element dattypElement = infoElement.addElement("DATTYP");
		dattypElement.addText(BaseHelpUtils.getStringValue(params, "DATTYP"));
		Element lgnnamElement = infoElement.addElement("LGNNAM");
		lgnnamElement.addText(BaseHelpUtils.getStringValue(params, "LGNNAM"));
		
		Element sdkatdqyxElement = rootElement.addElement("SDKATDQYX");
		Element reqnbrElement = sdkatdqyxElement.addElement("REQNBR");
		reqnbrElement.addText(BaseHelpUtils.getStringValue(params, "REQNBR"));
		
		return document.asXML();
	}
	
	
	//  代发代扣      XML          ***************************    结束  
	
	/**
	 * 检测传入参数
	 * @param params
	 * @param requireFields
	 * @return
	 */
	public static Boolean checkRequireParams(Map<String, Object> params, String requireFields){
		if(BaseHelpUtils.isNullOrEmpty(requireFields) || null == params || params.isEmpty()){
			return false;
		}else{
			requireFields = requireFields.replaceAll("，", ",");
			String [] fieldsArr = requireFields.split(",");
			boolean flag = true;
			for (String string : fieldsArr) {
				if(BaseHelpUtils.isNullOrEmpty(params.get(string))){
					flag = false;
					System.out.println(String.format("[%1$s]参数不能为空", string));
					break;
				}
			}
			return flag;
		}
	}
	
	
	public static void main(String[] args) throws UnsupportedEncodingException, IOException, DocumentException {
		Map<String, Object> params = new HashMap<>();
		params.put("DATTYP", 2);
		params.put("LGNNAM", "银企直连专用集团1");
		params.put("BUSCOD", "N01010");
		params.put("BBKNBR", 75);
		params.put("ACCNBR", "755915490810435");
		params.put("BGNDAT", "20170101");
		params.put("ENDDAT", "20170330");
		Socket client = new Socket("116.31.82.234", 1080);
        SocketUtils.sendData(client, createGetTransInfoXML(params));
        String s = SocketUtils.receiveData(client);
        Document document = DocumentHelper.parseText(s);
        Element rootElement = document.getRootElement();
        System.out.println(s);
//        List<Element> list = rootElement.elements("NTQACLSTZ");
//        for (Element element : list) {
//			System.out.println(element.asXML());
//		}
        OutputFormat format = new OutputFormat("    ",true);  
        format.setEncoding("GBK");
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("D://test.xml"),format);  
      
        xmlWriter.write(document);  
        xmlWriter.close();

	}

}
