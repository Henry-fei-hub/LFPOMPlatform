package pomplatform.revenuecapitalsinfo.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseFunctionBusiness;
import com.pomplatform.db.bean.BaseRevenueCapitals;
import com.pomplatform.db.dao.Function;
import com.pomplatform.db.dao.FunctionBusiness;
import com.pomplatform.db.dao.RevenueCapitals;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployeeFunction;
import delicacy.system.dao.EmployeeFunction;
import pomplatform.capitalsinfo.bean.BaseCapitalsInfo;
import pomplatform.capitalsinfo.bean.ConditionCapitalsInfo;
import pomplatform.capitalsinfo.query.QueryCapitalsInfo;
import pomplatform.revenueinfo.bean.BaseRevenueInfo;
import pomplatform.revenueinfo.bean.ConditionRevenueInfo;
import pomplatform.revenueinfo.query.QueryRevenueInfo;

public class ReckonRevenueCapitals  implements GenericProcessor{
	private static final Logger __logger = Logger.getLogger("");
	private static final String SAVEDATA = "saveData";
	private static final String CALCULADATE = "calculaDate";
	private static final String DATBYDATE = "DayByDate";
	private static final String GETDETAILFUNCTIONs = "getDetailFunctions";

	@Override
	public String execute(String creteria, HttpServletRequest httpServletRequest) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "optType");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result)) {
			switch (optType) {
			case SAVEDATA:
				return saveData(result);
			case CALCULADATE:
				return calculaDate(result);
			case DATBYDATE:
				return DayByDate(result);
			case GETDETAILFUNCTIONs:
				return getDetailFunctions(result);
			default:
				break;
			}
		}
		return null;
	}

	/**
	 * 计算回款与营收数据
	 * @param result
	 * @return
	 */
	private String saveData(Map<String, Object> result) throws SQLException {
		int status = -1;
		BaseCollection<GenericBase> collection = new BaseCollection<>();
		int year=BaseHelpUtils.getIntValue(result.get("year"));
		QueryCapitalsInfo query=new QueryCapitalsInfo();
		ConditionCapitalsInfo condition=new ConditionCapitalsInfo();
		condition.setYear(year);
		BaseCollection<BaseCapitalsInfo> capitalslist=query.executeQuery(null, condition); 
		List<BaseCapitalsInfo>  resultlist=capitalslist.getCollections();
		RevenueCapitals reDao=new RevenueCapitals();
		ThreadConnection.beginTransaction();
		for (BaseCapitalsInfo baseCapitalsInfo : resultlist) {
			int contractId=BaseHelpUtils.getIntValue(baseCapitalsInfo.getContractId());
			int month=BaseHelpUtils.getIntValue(baseCapitalsInfo.getMonth());
			BigDecimal originalCurrency=BaseHelpUtils.getBigDecimalValue(baseCapitalsInfo.getOriginalCurrency());
			reDao.setConditionContractId("=", contractId);
			reDao.setConditionYear("=", year);
			reDao.setConditionMonth("=", month);
			List<BaseRevenueCapitals> list=reDao.conditionalLoad();
			if(BaseHelpUtils.isNullOrEmpty(list)&&list.size()<=0) {
				reDao.setContractId(contractId);
				reDao.setYear(year);
				reDao.setMonth(month);
				reDao.setCapitalAmount(originalCurrency);
				reDao.setOperateTime(new Date());
				reDao.save();
			}else {
				reDao.setCapitalAmount(originalCurrency);
				reDao.conditionalUpdate();
			}
			reDao.clear();
		}
		QueryRevenueInfo  revenquery=new QueryRevenueInfo();
		ConditionRevenueInfo  conditions=new ConditionRevenueInfo ();
		conditions.setYear(year);
		BaseCollection<BaseRevenueInfo> Revenuelist=revenquery.executeQuery(null, conditions); 
		List<BaseRevenueInfo>  resultlists=Revenuelist.getCollections();
		for (BaseRevenueInfo baseRevenueInfo : resultlists) {
			int contractId=BaseHelpUtils.getIntValue(baseRevenueInfo.getContractId());
			int month=BaseHelpUtils.getIntValue(baseRevenueInfo.getMonth());
			BigDecimal currentRevenue=BaseHelpUtils.getBigDecimalValue(baseRevenueInfo.getCurrentRevenue());
			reDao.setConditionContractId("=", contractId);
			reDao.setConditionYear("=", year);
			reDao.setConditionMonth("=", month);
			List<BaseRevenueCapitals> list=reDao.conditionalLoad();
			if(BaseHelpUtils.isNullOrEmpty(list)&&list.size()<=0) {
				reDao.setContractId(contractId);
				reDao.setYear(year);
				reDao.setMonth(month);
				reDao.setRevenueAmount(currentRevenue);
				reDao.setOperateTime(new Date());
				reDao.save();
			}else {
				reDao.setRevenueAmount(currentRevenue);
				reDao.conditionalUpdate();
			}
			reDao.clear();
		}
		ThreadConnection.commit();
		status=1;
		return collection.toJSON(status,null);
	}


	/**
	 * 计算相差时间
	 * @param result
	 * @return
	 */
	private String calculaDate(Map<String, Object> result) throws SQLException {
		BaseCollection<BaseFunctionBusiness> bc = new BaseCollection<>();
		String startDateStr = BaseHelpUtils.getString(result.get("startDate"));
		String endDateStr = BaseHelpUtils.getString(result.get("endDate"));
		if(BaseHelpUtils.isNullOrEmpty(startDateStr) || BaseHelpUtils.isNullOrEmpty(endDateStr)){
			return bc.toJSON(-1, "请填写开始时间和结束时间");
		}
		Date startDate = GenericBase.__getDate(startDateStr);
		Date endDate = GenericBase.__getDate(endDateStr);
		if(startDate.after(endDate)){
			return bc.toJSON(-1, "开始时间不能晚于结束时间");
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(startDate);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(endDate);
		int day1= cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		int days=0;
		if(year1 != year2) {   //同一年
			int timeDistance = 0 ;
			for(int i = year1 ; i < year2 ; i ++)
			{
				if(i%4==0 && i%100!=0 || i%400==0) //闰年            
				{
					timeDistance += 366;
				}
				else //不是闰年
				{
					timeDistance += 365;
				}
			}
			days=timeDistance + (day2-day1) ;
		}
		else { //不同年
			days=day2-day1;
		}

		List<BaseFunctionBusiness> list = new ArrayList<>();
		BaseFunctionBusiness bean=new BaseFunctionBusiness();
		bean.setDays(BaseHelpUtils.getBigDecimalValue(days));
		list.add(bean);
		bc.setCollections(list);
		return bc.toJSON(0,null);
	}

	/**
	 * 
	 *天数计算日期
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String DayByDate(Map<String, Object> result) throws SQLException {
		BaseCollection<BaseFunctionBusiness> bc = new BaseCollection<>();
		String startDateStr = BaseHelpUtils.getString(result.get("startDate"));
		int days=BaseHelpUtils.getIntValue(result.get("days"));

		if(BaseHelpUtils.isNullOrEmpty(startDateStr)) {
			return bc.toJSON(-1, "获取开始时间失败");
		}

		if(BaseHelpUtils.isNullOrEmpty(days)) {
			return bc.toJSON(-1, "获取天数失败");
		}

		Date startDate = GenericBase.__getDate(startDateStr);

		Calendar ca = Calendar.getInstance();
		ca.setTime(startDate);
		ca.add(Calendar.DATE, days);
		Date endDate=ca.getTime();

		List<BaseFunctionBusiness> list = new ArrayList<>();
		BaseFunctionBusiness bean=new BaseFunctionBusiness();
		bean.setEndDate(endDate);
		list.add(bean);
		bc.setCollections(list);
		return bc.toJSON(0,null);
	}

	/**
	 * 
	 *加载funtionBusiness数据
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String getDetailFunctions(Map<String, Object> result) throws SQLException {
		BaseCollection bc = new BaseCollection<>();

		List<Map<String,Object>> flist = new ArrayList<>();

		int personnelBusinessId=BaseHelpUtils.getIntValue(result.get("personnelBusinessId"));
		int employeeId=BaseHelpUtils.getIntValue(result.get("employeeId"));

		List<Integer>  list1=new ArrayList<>();
		List<Integer>  list2=new ArrayList<>();




		EmployeeFunction edao=new EmployeeFunction();
		edao.setConditionEmployeeId("=", employeeId);
		List<BaseEmployeeFunction>  elist=edao.conditionalLoad();
		for (BaseEmployeeFunction baseEmployeeFunction : elist) {
			int functionId=BaseHelpUtils.getIntValue(baseEmployeeFunction.getFunctionId());
			list1.add(functionId);
		}

		FunctionBusiness dao=new FunctionBusiness();
		Function fdao=new Function();
		dao.setConditionPersonnelBusinessId("=", personnelBusinessId);
		List<BaseFunctionBusiness> list=dao.conditionalLoad();

		for (BaseFunctionBusiness baseFunctionBusiness : list) {
			int functionId=BaseHelpUtils.getIntValue(baseFunctionBusiness.getFunctionId());
			list2.add(functionId);
		}
		list1.removeAll(list2);
		list1.addAll(list2);

		for (Integer functionId : list1) {
			Map<String,Object> map = new HashMap<>();
			fdao.clear();
			fdao.setFunctionId(functionId);
			if(fdao.load()) {
				map.put("functionId",fdao.getFunctionId());
				map.put("functionCode",fdao.getFunctionCode());
				map.put("functionName",fdao.getFunctionName());
				map.put("applicationId",fdao.getApplicationId());
				map.put("parentId",fdao.getParentId());
				map.put("enabled",fdao.getEnabled());
			}
			flist.add(map);
		}
		Map<String,Object> userMap = new HashMap<>();
		userMap.put("userData", flist);
		bc.setUserData(userMap);
		return bc.toJSON(0,null);
	}

}
