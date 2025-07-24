package pomplatform.websitenews.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseJaidFunctionMaintenance;
import com.pomplatform.db.dao.JaidFunctionMaintenance;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

/**
 * 网站公共process
 * @author lxf
 */
public class OnWebsitenewsProcess implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";
	// 加载项目经验数据集
	private static final String ON_GET_PROJECT_EXPERIENCE_DATA = "onGetProjectExperienceData";
	// 加载公司股票信息数据集
	private static final String ON_GET_COMPANY_STOCK_DATA = "onGetCompanyStockData";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(param, OPT_TYPE);
		if (ON_GET_PROJECT_EXPERIENCE_DATA.equals(optType)) {
			return onGetProjectExperienceData(param);
		} else if(ON_GET_COMPANY_STOCK_DATA.equals(optType)) {
			return onGetCompanyStockData();
		}
		return null;
	}
	
	/**
	 * 加载公司股票信息数据集
	 * @return
	 * @throws IOException
	 */
	public String onGetCompanyStockData() throws IOException{
		Map<String,Object> resultMap = new HashMap<>();
		String strURL = "http://hq.sinajs.cn/?rn=1509434397273&list=sz300668";  
        URL url = new URL(strURL);  
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
        InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "gb2312");  
        BufferedReader bufReader = new BufferedReader(input);  
        String line = "";  
        StringBuilder contentBuf = new StringBuilder();  
        while ((line = bufReader.readLine()) != null) {  
            contentBuf.append(line);  
        }  
        if(!BaseHelpUtils.isNullOrEmpty(contentBuf)){
        	int len = contentBuf.toString().length();
        	//字符串截取
        	String valueStr = contentBuf.toString().substring(contentBuf.indexOf("=")+2,len-2);
        	String[] valueArr = valueStr.split(",");
        	int size = valueArr.length;
        	if(size >= 10){
        		boolean isHigh = false;
        		BigDecimal yesterdayClosePrice = BaseHelpUtils.getBigDecimalValue(valueArr[2]);
        		BigDecimal currentPrice = BaseHelpUtils.getBigDecimalValue(valueArr[3]);
        		resultMap.put("companyName",valueArr[0]);//公司名称
        		resultMap.put("todayOpenPrice",valueArr[1]);//今日开盘价
        		resultMap.put("yesterdayClosePrice",yesterdayClosePrice+"");//昨日收盘价
        		resultMap.put("currentPrice",currentPrice+"");//当前价格
        		resultMap.put("todayMaxPrice",valueArr[4]);//今日最高价
        		resultMap.put("todayMinPrice",valueArr[5]);//今日最低价
        		resultMap.put("buyPrice",valueArr[6]);//竞买价
        		resultMap.put("sellPrice",valueArr[7]);//竞卖价
        		resultMap.put("volumeNum",valueArr[8]);//成交量
        		resultMap.put("volumeMoney",valueArr[9]);//成交额
        		if(currentPrice.compareTo(yesterdayClosePrice) >= 0){
        			isHigh = true;
        		}
        		resultMap.put("isHigh",isHigh);
        	}
        }
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        bc.setUserData(resultMap);
        return bc.toJSON(0,"");
	}

	/**
	 * 加载项目经验数据集
	 * @return
	 * @throws SQLException
	 */
	public String onGetProjectExperienceData(Map<String, Object> param) throws SQLException {
		//获取项目类型Id
		int typeDetail = BaseHelpUtils.getIntValue(param, "typeDetail");
		if(typeDetail == 0){
			throw new SQLException("加载异常:项目类型Id不可为空");
		}
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setConditionType("=",1);//只检索项目经验模块的数据集
		dao.setConditionTypeDetail("=",typeDetail);
		List<BaseJaidFunctionMaintenance> list = dao.conditionalLoad(" order by project_address_zh");
		Map<String,Object> map = new HashMap<>();
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			Map<String,List<BaseJaidFunctionMaintenance>> mapZh = new HashMap<>();
			Map<String,List<BaseJaidFunctionMaintenance>> mapEn = new HashMap<>();
			List<BaseJaidFunctionMaintenance> reList = null;
			BaseJaidFunctionMaintenance bean = null;
			for(BaseJaidFunctionMaintenance e : list){
				//获取项目地址
				String projectAddressZh = BaseHelpUtils.getString(e.getProjectAddressZh());
				String projectAddressEn = BaseHelpUtils.getString(e.getProjectAddressEn());
				bean = new BaseJaidFunctionMaintenance();
				bean.setProjectAddressZh(projectAddressZh);
				bean.setProjectAddressEn(projectAddressEn);
				bean.setNameZh(e.getNameZh());
				bean.setNameEn(e.getNameEn());
				if(!BaseHelpUtils.isNullOrEmpty(projectAddressZh)){
					reList = mapZh.get(projectAddressZh);
					if(BaseHelpUtils.isNullOrEmpty(reList)){
						reList = new ArrayList<>();
					}
					reList.add(bean);
					mapZh.put(projectAddressZh, reList);
				}
				if(!BaseHelpUtils.isNullOrEmpty(projectAddressEn)){
					reList = mapEn.get(projectAddressEn);
					if(BaseHelpUtils.isNullOrEmpty(reList)){
						reList = new ArrayList<>();
					}
					reList.add(bean);
					mapEn.put(projectAddressEn, reList);
				}
			}
			map.put("zhRecords", mapZh);
			map.put("enRecords", mapEn);
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		bc.setUserData(map);
		return bc.toJSON(0, null);
	}
	
	public static void main(String[] args) throws SQLException {
		Map<String,Object> map = new HashMap<>();
		map.put("typeDetail", 1);
		OnWebsitenewsProcess process = new OnWebsitenewsProcess();
		String ss = process.onGetProjectExperienceData(map);
		System.out.println(ss);
	}

}
