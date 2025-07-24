package pomplatform.shift.business;

import com.pomplatform.db.bean.BaseEmployee;
import com.pomplatform.db.bean.BaseEmployeeCheckinoutDetail;
import com.pomplatform.db.dao.Employee;
import com.pomplatform.db.dao.EmployeeCheckinoutDetail;
import delicacy.common.BaseHelpUtils;
import message.common.CheckinWeixinUtils;
import message.common.WeixinUtils;
import message.servlet.SystemInitConfig;
import net.sf.json.JSONArray;

import java.sql.SQLException;
import java.util.*;

/**
 * @author liubin
 * @description //TODO 手机打卡定时器
 * @date 13:14 2020/2/6
 * @param
 * @return
 **/
public class OnloadWeixinLoginTimeTask extends TimerTask {


    @SuppressWarnings({ "static-access", "unchecked" })
	@Override
    public void run() {
        try {
        	Employee dao = new Employee();
			dao.unsetSelectFlags();
			dao.setSelectEmployeeId(true);
			dao.setSelectCompanyWeixin(true);
			dao.setConditionEmployeeId(">",0);
			dao.setConditionStatus("=", 0);//只检索在职的人员
			dao.setConditionIsCheck("=",Boolean.TRUE);//只检索参与考勤的人
			List<BaseEmployee> eList = dao.conditionalLoad("company_weixin is not null order by employee_id");
			if(!BaseHelpUtils.isNullOrEmpty(eList) && eList.size() > 0) {
				//定义map来存放职员id
				Map<String,Integer> empMap = new HashMap<>();
				int size = eList.size();
				int pageLines = 100;
				int page = size/pageLines;
				int leftNum = size%pageLines;
				if(leftNum > 0) {
					page++;
				}
				CheckinWeixinUtils checkinWeixinUtils = new CheckinWeixinUtils();
				Long starttime = null;
				Long endtime = null;
				Calendar ca = Calendar.getInstance();
				//获取时间点，如果是7点之前，则同步上一天的考勤数据
				int hours = ca.get(Calendar.HOUR_OF_DAY);
				if(hours < 7){//同步上一天的数据
					ca.add(Calendar.DAY_OF_MONTH,-1);
				}
				//如果开始时间为空，则设置当天0点为开始时间
				ca.set(Calendar.HOUR_OF_DAY,0);
				ca.set(Calendar.MINUTE,0);
				ca.set(Calendar.SECOND,0);
				starttime = checkinWeixinUtils.toUnixTimeStamp(ca.getTime());
				//如果结束时间为空，则设置当天23点59分为开始时间
				ca.set(Calendar.HOUR_OF_DAY,24);
				ca.set(Calendar.MINUTE,0);
				ca.set(Calendar.SECOND,0);
				endtime = checkinWeixinUtils.toUnixTimeStamp(ca.getTime());
				for(int i = 1;i<=page;i++) {
					dao.setCurrentPage(i);
					dao.setPageLines(pageLines);
					eList = dao.conditionalLoad("order by employee_id");
					if(!BaseHelpUtils.isNullOrEmpty(eList) && eList.size() > 0) {
						int currentSize = eList.size();
						String[] useridlist = new String[currentSize];
						int j = 0;
						for(BaseEmployee e : eList) {
							//获取员工的企业微信id
							String companyWeixin = BaseHelpUtils.getString(e.getCompanyWeixin());
							int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
							empMap.put(companyWeixin, empId);
							useridlist[j] = companyWeixin;
							j++;
						}
						//查询人员的企业微信打卡时间(第一个参数为null 开始时间为0:00 第二个参数为null代表 结束时间为 23:59 第三个参数代表打卡类型为位置打卡，第四个参数是查询人)
						JSONArray jsonArray = WeixinUtils.sendCheckInMsg(checkinWeixinUtils.getAccessToken(), checkinWeixinUtils.AGENTID, useridlist, 1, starttime, endtime);
						//将打卡数据转化为map
						if (!BaseHelpUtils.isNullOrEmpty(jsonArray)) {
							List<Map<String, Object>> lists = ((List<Map<String, Object>>) delicacy.common.JsonParser.parse(jsonArray.toString()));
							List<BaseEmployeeCheckinoutDetail> checkinouts = new ArrayList<BaseEmployeeCheckinoutDetail>();
							if (!BaseHelpUtils.isNullOrEmpty(lists) && lists.size() != 0) {
								BaseEmployeeCheckinoutDetail baseEmployeeCheckinoutDetail = null;
								EmployeeCheckinoutDetail employeeCheckinoutDetail = new EmployeeCheckinoutDetail();
								for (Map<String, Object> map : lists) {
									//获取打卡员工的企业微信号
									String userid = BaseHelpUtils.getString(map.get("userid"));
									//获取打卡时间
									long checkinTime = BaseHelpUtils.getLongValue(map.get("checkin_time"));
									Date date = new Date(checkinTime * 1000);
									//获取异常类型
									String exceptionType = BaseHelpUtils.getString(map.get("exception_type"));
									if (exceptionType.contains("地点异常")) {
										continue;
									}
									int employeeId = BaseHelpUtils.getIntValue(empMap.get(userid));
									if(employeeId > 0) {
										employeeCheckinoutDetail.clear();
										employeeCheckinoutDetail.setConditionEmployeeId("=", employeeId);
										employeeCheckinoutDetail.setConditionCheckTime("=", date);
										if(!employeeCheckinoutDetail.isExist()) {
											baseEmployeeCheckinoutDetail = new BaseEmployeeCheckinoutDetail();
											baseEmployeeCheckinoutDetail.setEmployeeId(employeeId);
											baseEmployeeCheckinoutDetail.setCheckDate(date);
											baseEmployeeCheckinoutDetail.setCheckTime(date);
											baseEmployeeCheckinoutDetail.setOperateTime(date);
											baseEmployeeCheckinoutDetail.setRemark("企业微信打卡");
											checkinouts.add(baseEmployeeCheckinoutDetail);
										}
									}
								}
								employeeCheckinoutDetail.clear();
								employeeCheckinoutDetail.save(checkinouts);
							}
						}
					}
				}
				
			}
			
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        OnloadWeixinLoginTimeTask onloadWeixinLoginTimeTask = new OnloadWeixinLoginTimeTask();
        SystemInitConfig.onLoadSystemConfigInfo();
        onloadWeixinLoginTimeTask.run();

    }
}
