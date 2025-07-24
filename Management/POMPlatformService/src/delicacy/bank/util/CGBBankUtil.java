package delicacy.bank.util;

import java.io.FileOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import delicacy.socket.SocketUtils;

public class CGBBankUtil {
	
	public final static String IP = "192.168.13.36";
	
	public static String sendPackageToCMB(String packageStr) throws Exception{
		
        Document document = DocumentHelper.parseText(packageStr);
        OutputFormat format = new OutputFormat("    ",true);  
        format.setEncoding("GBK");//设置编码格式  
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("D://CGBXML//"+sdf.format(currentDate)+"_send.xml"),format);  
        xmlWriter.write(document);  
        xmlWriter.close();
        
        Socket client = new Socket(IP, 1088);
        SocketUtils.sendDataWithoutLength(client, packageStr);
        String resultStr = SocketUtils.receiveDataWithoutLength(client);
        
        
        Document document1 = DocumentHelper.parseText(resultStr);
        OutputFormat format1 = new OutputFormat("    ",true);  
        format1.setEncoding("GBK");//设置编码格式  
        XMLWriter xmlWriter1 = new XMLWriter(new FileOutputStream("D://CGBXML//"+sdf.format(currentDate)+"_result.xml"),format);  
        xmlWriter1.write(document1);  
        xmlWriter1.close();
		return resultStr;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(testGetTraStatas());
	}
	
	public static String testGetTraStatas() throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("entSeqNo", "2014031110040003");
		params.put("tranDate", "20140311");
		params.put("tranTime", "114251");
		params.put("origEntseqno", "2014031100110003");
		params.put("origEntdate", "20140311");
		String paXml = CGBBankXmlUtil.createGetBatchPamentStatusXML(params);
		System.out.println(paXml);
		return sendPackageToCMB(paXml);
	}
	
}
