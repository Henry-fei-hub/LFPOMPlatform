package zkteco.id100com.jni;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.pomplatform.db.dao.Nationality;

import delicacy.common.BaseHelpUtils;

/**
 * IDCardReader Java Native Interface(仅支持Utf8编码)
 * @version 1.0.0.1
 * @author lxf
 *
 */
public class id100sdk {
	/**
	 * <code>id100sdk</code> 身份证阅读器接口类
	 */
	static {
		System.loadLibrary("termb");
	}
	
	/**
	 * 连接身份证阅读器
	 * 
	 * @param nPort 设备端口（串口:1~16;USB:1001~1016）
	 * @return 
	 * 成功返回设备端口
	 * 失败返回0
	 */
	public native static int InitComm(int nPort);

	/**
	 * 自动搜索并连接身份证阅读器
	 * 
	 * @return 
	 * 成功返回设备端口（串口:1~16;USB:1001~1016）
 	 * 失败返回0
	 */
	public native static int InitCommExt();

	/**
	 * 	断开与身份证阅读器连接
	 * @return 
	 * 成功返回1
	 * 失败返回0
	 */
	public native static int CloseComm();

	/**
	 * 认证卡(寻卡&选卡)
	 * @return	
	 * 成功返回1
	 * 失败返回0
	 */
	public native static int Authenticate();

	/**
	 * 读卡操作，信息文件保存在dll所在目录
	 * @param nActive;1读基本信息(文字&照片&指纹);2读文字照片;3读最新地址
	 * @return	1成功;-11无效参数;0其他错误
	 */
	public native static int ReadContent(int nActive);

	/**
	 * 获取SAM模块编号
	 * @return	成功返回SAM模块编号;失败返回空字符串
	 */
	public native static int GetSAMID(byte[] bufSAMID);

	/**
	 * 获取SAM模块编号(10位编号)
	 * @return	成功返回SAM模块编号;失败返回空字符串
	 */
	public native static String GetSAMIDEx();
	
	/**
	 * 解析(xp.wlt)身份证照片
	 * @param FileName xp.wlt全路径名
	 * @return	成功返回1;失败返回0
	 */
	public native static int GetBmpPhoto(String FileName);

	public native static int GetSAMStatus();

	/**
	 * 身份证读卡器阅读
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static Map<String,Object> readID100() throws SQLException, IOException, ParseException{
		//定义存放身份证基本信息的map
    	Map<String,Object> infoMap = new HashMap<>();
		int nRet = 0;
		// 自动搜索，初始化端口;返回0，表示搜索失败；返回正数则为端口号
		if (0 >= (nRet = InitCommExt())) {
			throw new SQLException("操作异常:身份证搜索失败");
		} else {
			/**
			 * 卡认证，本函数用于读卡器和卡片之间的合法身份确认 返回1表示正确放置卡，返回其他表示未放卡或者卡片放置不正确
			 */
			int authenticate = Authenticate();
			if (1 == authenticate) {
				int nRetry = 0;
				do {
					nRet = ReadContent(1);
					if (nRet == 1) {
						break;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					nRetry++;
				} while (nRetry < 10);
				if (1 == nRet) {
					if (1 == GetBmpPhoto("xp.wlt")) {
						String filePath = "wz.txt";
						infoMap = readFile(filePath);
					} else {
						throw new SQLException("操作异常:获取基本信息失败");
					}
				} else {
					throw new SQLException("操作异常:读取信息失败");
				}
			} else {
				throw new SQLException("操作异常:身份证验证失败,请重新放置身份证");
			}
			CloseComm();
		}
		return infoMap;
	}
	
	/**
	 * 身份证基本信息解析
	 * @param filePath
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public static Map<String,Object> readFile(String filePath) throws IOException, SQLException, ParseException {
		//定义存放身份证基本信息的map
    	Map<String,Object> infoMap = new HashMap<>();
		FileInputStream fis = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream instr=new DataInputStream(bis);
		byte [] bufTemp = new byte[256];
		instr.read(bufTemp, 0, 256);
		instr.close();
		bis.close();
		fis.close();
		String stNname = BaseHelpUtils.getString(new String(bufTemp, 0, 30, "UTF-16LE").trim());//姓名
		int gender = BaseHelpUtils.getIntValue(new String(bufTemp, 30, 2, "UTF-16LE").trim());//性别
		int nation = BaseHelpUtils.getIntValue(new String(bufTemp, 32, 4, "UTF-16LE").trim());//名族
		String strBirth = BaseHelpUtils.getString(new String(bufTemp, 36, 16, "UTF-16LE").trim());//生日（YYMMDD）
		String strAddress = BaseHelpUtils.getString(new String(bufTemp, 52, 70, "UTF-16LE").trim());//地址
		String strCard = BaseHelpUtils.getString(new String(bufTemp, 122, 36, "UTF-16LE").trim());//身份证号
		String strAccountLocation = BaseHelpUtils.getString(new String(bufTemp, 158, 30, "UTF-16LE").trim());//签发机构
//		String strEffect = new String(bufTemp, 188, 16, "UTF-16LE");//有效期起始日期（YYMMDD）
//		String strExpire = new String(bufTemp, 204, 16, "UTF-16LE");//有效期截止日期（YYMMDD）
		infoMap.put("employeeName", stNname);//姓名
		infoMap.put("gender", gender);//性别
		//获取名族信息
		Nationality dao = new Nationality();
		dao.setNationalityId(nation);
		if(dao.load()){
			infoMap.put("nationality", dao.getNationalityName());//名族
		}
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
		Date birth = sdf.parse(strBirth);
		infoMap.put("birth", birth);//出生日期
		infoMap.put("address", strAddress);//地址
		infoMap.put("card", strCard);//身份证号
		infoMap.put("accountLocation", strAddress);//签发机构
		return infoMap;
	}
	
	public static void main(String[] args) throws IOException, SQLException, ParseException {
		Map<String,Object> infoMap = readID100();
		System.out.println("infoMap========"+infoMap);
	}
	
}
