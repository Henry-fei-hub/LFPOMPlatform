package pomplatform.cmbcinfo.business;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import delicacy.common.BaseHelpUtils;
import delicacy.socket.SocketUtils;

public class CMBBankUtil {

	public final static String LGNNAM = "杰恩直连"; 
	public final static String SUCESS_CODE = "0";
	public final static String IP = "113.106.91.66";
	
	
	public static String sendPackageToCMB(String packageStr) throws Exception{
		Socket client = new Socket(IP, 1080);
        SocketUtils.sendData(client, packageStr);
        String resultStr = SocketUtils.receiveData(client);
//        Document document = DocumentHelper.parseText(packageStr);
//        OutputFormat format = new OutputFormat("    ",true);  
//        format.setEncoding("GBK");//设置编码格式  
//        Date currentDate = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("D://CMBXML//"+sdf.format(currentDate)+"_send.xml"),format);  
//        xmlWriter.write(document);  
//        xmlWriter.close();
//        
//        
//        Document document1 = DocumentHelper.parseText(resultStr);
//        OutputFormat format1 = new OutputFormat("    ",true);  
//        format1.setEncoding("GBK");//设置编码格式  
//        XMLWriter xmlWriter1 = new XMLWriter(new FileOutputStream("D://CMBXML//"+sdf.format(currentDate)+"_result.xml"),format);  
//        xmlWriter1.write(document1);  
//        xmlWriter1.close();
        
		return resultStr;
		
	}
	
	/**
	 * 获取系统信息
	 * @return
	 * @throws Exception
	 */
	public static String getSysInfo() throws Exception{
		Map<String, Object> params = new HashMap<>();
		params.put("SYSTYP", "USRINF");
		return sendPackageToCMB(CreateCMBBankXmlUtil.createGetSysInfoXML(params));
	}
	
	/**
	 * 2.1 查询可查询/可经办的账户列表
	 * @return
	 * @throws Exception
	 */
	public static String getListAccount() throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("BUSCOD", "N01010");
		return sendPackageToCMB(CreateCMBBankXmlUtil.createListAccountXML(params));
	}
	
	/**
	 * 2.2 查询账户详细信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String getAccountInfo(Map<String, Object> params) throws Exception{
		List<Map<String, Object>> paramsList = new ArrayList<>();
		paramsList.add(params);
		return sendPackageToCMB(CreateCMBBankXmlUtil.createGetAccInfoXML(paramsList));
	}
	
	/**
	 * 2.2 查询账户详细信息
	 * @param params
	 * @return 
	 * @throws Exception
	 */
	public static String getAccountInfo(List<Map<String, Object>> params) throws Exception{
		return sendPackageToCMB(CreateCMBBankXmlUtil.createGetAccInfoXML(params));
	}
	
	/**
	 * 2.3  查询账户交易信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String getTransInfo(Map<String, Object> params) throws Exception{
		return sendPackageToCMB(CreateCMBBankXmlUtil.createGetTransInfoXML(params));
	}
	
	public static String getAgentDetail(Map<String, Object> params) throws Exception{
		return sendPackageToCMB(CreateCMBBankXmlUtil.createGetAgentDetailXML(params));
	}
	
	public static String getAgentInfo(Map<String, Object> params) throws Exception{
		return sendPackageToCMB(CreateCMBBankXmlUtil.createGetAgentInfoXML(params));
	}
	
	public static boolean checkIsSucess(Element rootElement){
		return checkIsSucess(rootElement, "INFO", "RETCOD", SUCESS_CODE);
	}
	
	public static boolean checkIsSucess(Element rootElement, String parentElementName, String childElementName, String sucessCode) {
		if(null != rootElement && !BaseHelpUtils.isNullOrEmpty(parentElementName) 
				&& !BaseHelpUtils.isNullOrEmpty(childElementName) && !BaseHelpUtils.isNullOrEmpty(sucessCode)){
			Element element = rootElement.element(parentElementName);
			if(null != element){
				String checkValue = element.elementTextTrim(childElementName);
				if(!BaseHelpUtils.isNullOrEmpty(checkValue) && sucessCode.equals(checkValue)){
					return true;
				}
			}
		}
		return false;
	}
}
