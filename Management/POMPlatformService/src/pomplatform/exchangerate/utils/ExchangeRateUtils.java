package pomplatform.exchangerate.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseExchangeRate;
import com.pomplatform.db.dao.ExchangeRate;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pomplatform.common.utils.StaticUtils;

public class ExchangeRateUtils implements GenericProcessor {
	
	public static final String APP_KEY = "9c4ce89cf8c0c7a510fc66299f4c8d3b";
	public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 3000;
    public static final int DEF_READ_TIMEOUT = 3000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	
    /**
     * 获取今天某种货币相对于人民币的汇率
     * @param currency
     * @param date
     * @return
     */
    public static BigDecimal getTodayExchangeRate(Integer currency) {
    	return getExchangeRateByDate(currency, new Date());
    }
    /**
     * 获取某一天的某种货币相对于人民币的汇率
     * @param currency
     * @param date
     * @return
     */
    public static BigDecimal getExchangeRateByDate(Integer currency, Date date) {
    	try {
    		if(null == currency || null == date) {
    			return null;
    		}
    		if(Objects.equals(currency, StaticUtils.CURRENCY_0)) {
    			return BigDecimal.ONE;
    		}
	    	ExchangeRate dao = new ExchangeRate();
	    	dao.setConditionCurrencyId("=", currency);
	    	dao.setConditionExchangeDate("=", date);
	    	BaseExchangeRate bean = dao.executeQueryOneRow();
	    	if(null == bean) {
	    		//如果找不到当天的汇率记录，则看date是否是今天，如果是，则通过接口获取今天的汇率，并保存到数据库中，如果不是，则获取当月某一天的汇率
	    		if(DateUtil.isSameDay(new Date(), date)) {
	    			return saveExchangeRateToDB(currency);
	    		}else {
	    			StringBuilder sb = new StringBuilder();
	    			sb.append("extract(year from exchange_date) = ").append(DateUtil.getYear(date)).append(" and extract(month from exchange_date) = ").append(DateUtil.getMonth(date));
	    			bean = dao.executeQueryOneRow(sb.toString());
	    			if(null != bean) {
	    				return bean.getExchangeRate();
	    			}
	    		}
	    	}else {
	    		return bean.getExchangeRate();
	    	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    
    /**
     * 根据货币种类返回货币代码
     * @param currency
     * @return
     */
    public static String getCurrencyCode(Integer currency) {
    	switch(currency) {
    	case StaticUtils.CURRENCY_0:
    		return "CNY";
    	case StaticUtils.CURRENCY_1:
    		return "HKD";
    	case StaticUtils.CURRENCY_2:
    		return "USD";
    	case StaticUtils.CURRENCY_3:
    		return "EUR";
		default:
			return null;
    	}
    }
    
    /**
     * 通过接口获取实时的汇率
     * @param fromCurrency
     * @param toCurrency
     * @return
     */
	public static String getExchangeRateByNet(Integer fromCurrency, Integer toCurrency) {
		String fromCurrencyCode = getCurrencyCode(fromCurrency);
		if(BaseHelpUtils.isNullOrEmpty(fromCurrencyCode))
			return null;
		String toCurrencyCode = getCurrencyCode(toCurrency);
		if(BaseHelpUtils.isNullOrEmpty(toCurrencyCode))
			return null;
        String result =null;
        String url ="http://op.juhe.cn/onebox/exchange/currency";//请求接口地址
        Map<String, String> params = new HashMap<>();//请求参数
        params.put("from", fromCurrencyCode);//转换汇率前的货币代码
        params.put("to", toCurrencyCode);//转换汇率成的货币代码
        params.put("key",APP_KEY);//应用APPKEY(应用详细页查询)
        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
            	JSONArray array = object.getJSONArray("result");
            	object = JSONObject.fromObject(array.get(0));
                return BaseHelpUtils.getString(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	/**
    *
    * @param strUrl 请求地址
    * @param params 请求参数
    * @param method 请求方法
    * @return  网络请求字符串
    * @throws Exception
    */
   public static String net(String strUrl, Map<String, String> params,String method) throws Exception {
       HttpURLConnection conn = null;
       BufferedReader reader = null;
       String rs = null;
       try {
           StringBuffer sb = new StringBuffer();
           if(method==null || method.equals("GET")){
               strUrl = strUrl+"?"+urlencode(params);
           }
           URL url = new URL(strUrl);
           conn = (HttpURLConnection) url.openConnection();
           if(method==null || method.equals("GET")){
               conn.setRequestMethod("GET");
           }else{
               conn.setRequestMethod("POST");
               conn.setDoOutput(true);
           }
           conn.setRequestProperty("User-agent", userAgent);
           conn.setUseCaches(false);
           conn.setConnectTimeout(DEF_CONN_TIMEOUT);
           conn.setReadTimeout(DEF_READ_TIMEOUT);
           conn.setInstanceFollowRedirects(false);
           conn.connect();
           if (params!= null && method.equals("POST")) {
               try {
                   DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                       out.writeBytes(urlencode(params));
               } catch (Exception e) {
            	   e.printStackTrace();
               }
           }
           InputStream is = conn.getInputStream();
           reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
           String strRead = null;
           while ((strRead = reader.readLine()) != null) {
               sb.append(strRead);
           }
           rs = sb.toString();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (reader != null) {
               reader.close();
           }
           if (conn != null) {
               conn.disconnect();
           }
       }
       return rs;
   }

   //将map型转为请求参数型
   public static String urlencode(Map<String, String> data) {
       StringBuilder sb = new StringBuilder();
       for (String key : data.keySet()) {
           try {
               sb.append(key).append("=").append(URLEncoder.encode(data.get(key), "UTF-8")).append("&");
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
       }
       return sb.toString();
   }

   /**
    * 从接口查出当天相对于RMB的汇率，并保存到数据库中
    * @param currency
    * @return
    * @throws Exception
    */
   public static BigDecimal saveExchangeRateToDB(Integer currency) throws SQLException{
	   if(null == currency) {
		   return null;
	   }
	   Date today = new Date();
	   //先看数据库中是否有该货币当天的汇率
	   ExchangeRate dao = new ExchangeRate();
	   dao.setConditionCurrencyId("=", currency);
	   dao.setConditionExchangeDate("=", today);
	   BaseExchangeRate bean = dao.executeQueryOneRow();
	   if(null != bean && null != bean.getExchangeRate() && bean.getExchangeRate().compareTo(BigDecimal.ZERO) != 0) {
		   //如果有，且汇率不为空，则直接返回该汇率
		   return bean.getExchangeRate();
	   }
	   //否则，调接口查出该货币的当天汇率，并保存到数据库中
	   String rateStr = getExchangeRateByNet(currency, StaticUtils.CURRENCY_0);
	   if(!BaseHelpUtils.isNullOrEmpty(rateStr)) {
		   dao.clear();
		   if(null == bean) {
			   dao.setExchangeDate(today);
			   dao.setCurrencyId(currency);
			   dao.setExchangeRate(new BigDecimal(rateStr));
			   dao.save();
		   }else {
			   dao.setDataFromBase(bean);
			   dao.clearModifiedFlags();
			   dao.setExchangeRate(new BigDecimal(rateStr));
			   dao.update();
		   }
		   return dao.getExchangeRate();
	   }
	   return null;
   }
   
	@Override
	public String execute(String arg0, HttpServletRequest arg1) throws Exception {
		BaseCollection<BaseExchangeRate> bc = new BaseCollection<>();
		JSON parser = new JSON(new StringReader(arg0));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		Integer currency = BaseHelpUtils.getIntValue(params, "currency");
		BigDecimal rate = getTodayExchangeRate(currency);
		if(null == rate) {
			return bc.toJSON(-1, "没有获取到汇率");
		}else {
			List<BaseExchangeRate> list = new ArrayList<>();
			BaseExchangeRate bean = new BaseExchangeRate();
			bean.setExchangeRate(rate);
			list.add(bean);
			bc.setCollections(list);
			return bc.toJSON();
		}
	}
	
	public static void main(String[] args) {
		ExchangeRateUtils.getTodayExchangeRate(1);
	}
}
