package pomplatform.activityMpcor.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseActivity;
import com.pomplatform.db.dao.Activity;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.employee.bean.BaseMemployeeerfeaor;
import delicacy.employee.bean.ConditionMemployeeerfeaor;
import delicacy.employee.query.QueryMemployeeerfeaor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.activityMpcor.bean.BaseSactivityMpcor;
import pomplatform.activityMpcor.bean.ConditionSactivityMpcor;
import pomplatform.activityMpcor.query.QuerySactivityMpcor;
import pomplatform.project.bean.BaseOnRevenueSureWarn;
import pomplatform.project.bean.ConditionOnRevenueSureWarn;

public class GetActivityDetailsProcess implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";
	// pc端查看数据
	private static final String PC_DETAILS_DATA = "pcDetailsData";
	// 手机端查看某月数据
	private static final String MO_DETAILS_DATA = "moDetailsData";
	// 手机端查看某年数据
	private static final String MO_YEAR_DETAILS_DATA = "moYearDetailsData";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {

		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch (optType) {

		case PC_DETAILS_DATA:

			return pcDetailsData(params);

		case MO_DETAILS_DATA:

			return moDetailsData(params);
			
		case MO_YEAR_DETAILS_DATA:

			return moYearDetailsData(params);

		default:
			return null;
		}

	}

	/**
	 * pc端查看数据
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public String pcDetailsData(Map params) throws SQLException, ParseException {
		if (!BaseHelpUtils.isNullOrEmpty(params.get("meetTime"))) {
		String startTime = "";
		String endTime = "";
		SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
		startTime = sdfs.format(params.get("meetTime"))+" "+"00:00:00";
		endTime=sdfs.format(params.get("meetTime"))+" "+"23:59:59";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		QuerySactivityMpcor daos=new QuerySactivityMpcor();
		ConditionSactivityMpcor con = new ConditionSactivityMpcor();
		con.setStartDate(sdf.parse(startTime));
		con.setEndDate(sdf.parse(endTime));
		BaseCollection<BaseSactivityMpcor> result = daos.executeQuery(null, con);
		List<BaseSactivityMpcor> lists = result.getCollections();
		if(!BaseHelpUtils.isNullOrEmpty(lists)&&lists.size()>0) {
		result.setCollections(lists);
		}
		return result.toJSON(0, null);
		}else {
			BaseCollection<BaseSactivityMpcor> result = new BaseCollection<>();
			return result.toJSON(0, null);
		}
		
	}

	/**
	 * 手机端查看某月数据
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public  String moDetailsData(Map params) throws SQLException {
		List<BaseActivity> list = null;
		Activity dao = new Activity();
		
		if (!BaseHelpUtils.isNullOrEmpty(params.get("operateEmployeeId"))) {
			if (!permission(BaseHelpUtils.getIntValue(params.get("operateEmployeeId")))) {
				dao.setConditionOperateEmployeeId("=", BaseHelpUtils.getIntValue(params.get("operateEmployeeId")));
			}  
		}
		
		if (!BaseHelpUtils.isNullOrEmpty(params.get("year"))&&!BaseHelpUtils.isNullOrEmpty(params.get("month"))) {
			int year=BaseHelpUtils.getIntValue(params.get("year"));
			int month=BaseHelpUtils.getIntValue(params.get("month"));
			int day =GetMonthDayCount(year,month);
			String sql ="meet_time <= '" +year+"-"+month+"-"+day + " 23:59:59' AND meet_time >= '" + year+"-"+month+"-01" + " 00:00:00'";
			list = dao.conditionalLoad(sql+" order by meet_time asc");
		}
		BaseCollection<BaseActivity> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON(0, null);

	}
	/**
	 * 手机端查看某年数据
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public  String moYearDetailsData(Map params) throws SQLException {
		List<BaseActivity> list = null;
		Activity dao = new Activity();
		
		if (!BaseHelpUtils.isNullOrEmpty(params.get("operateEmployeeId"))) {
			if (!permission(BaseHelpUtils.getIntValue(params.get("operateEmployeeId")))) {
				dao.setConditionOperateEmployeeId("=", BaseHelpUtils.getIntValue(params.get("operateEmployeeId")));
			}  
		}
		
		if (!BaseHelpUtils.isNullOrEmpty(params.get("year"))) {
			int year=BaseHelpUtils.getIntValue(params.get("year"));
			String sql ="meet_time <= '" +year+"-12-31" + " 23:59:59' AND meet_time >= '" + year+"-01-01" + " 00:00:00'";
			list = dao.conditionalLoad(sql+" order by meet_time asc");
		}
		BaseCollection<BaseActivity> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON(0, null);

	}

	/**
	 * 判断员工有没有相关权限
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */
	public  boolean permission(Integer employeeId) throws SQLException {
		  // 查询员工所能操作的功能列表
	    ConditionMemployeeerfeaor c = new ConditionMemployeeerfeaor();
	    c.setEmployeeId(employeeId);
	    c.setApplicationId(1);
	    QueryMemployeeerfeaor qdao = new QueryMemployeeerfeaor();
	    BaseCollection<BaseMemployeeerfeaor> fs = qdao.executeQuery(null, c);
	    Set<String> res=   generateFunctionCode(fs);
	    String string="AD-29100-001";
	    if (BaseHelpUtils.isNullOrEmpty(res)) {
			return false;
		}
		return res.contains(string);
		
	}
	public  Set<String> generateFunctionCode(BaseCollection<BaseMemployeeerfeaor> fs) {
		Set<String> res = new HashSet<>();
		for (BaseMemployeeerfeaor b : fs.getCollections()) {
			res.add(b.getFunctionCode());
		}
		return res;
	}
	
	 /**
	  * 判断当月有多少天
	 * @param year
	 * @param month
	 * @return
	 */
	public int GetMonthDayCount(int year,int month)  
	{  
	    switch(month)  
	    {  
	        case 1:  
	        case 3:  
	        case 5:  
	        case 7:  
	        case 8:  
	        case 10:  
	        case 12:  
	            {  
	                return 31;  
	            }  
	        case 4:  
	        case 6:  
	        case 9:  
	        case 11:  
	            {  
	                return 30;  
	            }  
	        case 2:  
	            {if((year%4 ==0&&year%100!=0)||(year%400==0)) {   return  29;   } else {   return  28;   } }  
	        default:  
	            {  
	                return 0;  
	            }  
	    }  
	}  
	
	/*public static void main(String[] args) throws SQLException {
		Map< String, Object> params= new HashMap<>();
		params.put("operateEmployeeId", 0);
		params.put("year", 2017);
		params.put("month", 12);
		new GetActivityDetailsProcess().moDetailsData(params);
		params.put("meetTime", "2018-04-12");
		try {
			new GetActivityDetailsProcess().pcDetailsData(params);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
*/
	
	
}
