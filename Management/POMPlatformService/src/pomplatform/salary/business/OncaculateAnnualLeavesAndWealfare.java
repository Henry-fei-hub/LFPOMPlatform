package pomplatform.salary.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import com.pomplatform.db.bean.BaseAnnualLeave;
import com.pomplatform.db.dao.AnnualLeave;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.salary.bean.BaseRepeatAnnualLeave;
import pomplatform.salary.bean.ConditionRepeatAnnualLeave;
import pomplatform.salary.query.QueryRepeatAnnualLeave;


/**
 * @author liubin
 * 立方年假 ：
 * 		工龄 < 1年 年假天数0天
 * 		1<= 工龄 < 10年 年假天数5天
 * 	    10<= 工龄 < 20年 年假天数10天
 * 		工龄 >= 20年 年假天数15天
 *
 * 	 	特殊规则 ：当年入职的员工，折算后不足0.5天的部分不享受年休假， 当年度在公司剩余日历天数÷365 天 ×员工全年应当享受的年休假天数
 *
 */
public class OncaculateAnnualLeavesAndWealfare extends TimerTask {

    public static String DEFAULT_FORMAT = "yyyy-MM-dd";

    @SuppressWarnings("unused")
    /**
     * 一年的毫秒数
     */
    private static final Long YEARTIME = 365 * 24 * 60 * 60 * 1000L;
    @SuppressWarnings("unused")
    /**
     * 一个月的毫秒数
     */
    private static final Long MONTHTIME = 30 * 24 * 60 * 60 * 1000L;
    /**
     * 一天的毫秒数
     */
    private static final Long DAYTIME = 24 * 60 * 60 * 1000L;
    /**
     * 5天的带薪病假
     */
    private static final BigDecimal PAID_VACATION = new BigDecimal("5");
    /**
     * 5天的年假
     */
    private static final BigDecimal BASIS_DAY_1 = new BigDecimal("5");
    /**
     * 10天年假
     */
    private static final BigDecimal BASIS_DAY_2 = new BigDecimal("10");
    /**
     * 15天年假
     */
    private static final BigDecimal BASIS_DAY_3 = new BigDecimal("15");


    @Override
    public void run() {
    	try {
			accountLeaveDay();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//        try {
//            AnnualLeave annualLeaveDao = new AnnualLeave();
//            //取出当年的年份和月份
//            Calendar calendar = Calendar.getInstance();
//            int currentYear = calendar.get(Calendar.YEAR);
//            //查询所有的在职员工
//            Employee employeeDao = new Employee();
////            employeeDao.setConditionEmployeeId("=", 449);
//            employeeDao.setConditionStatus("=", 0);
//            List<BaseEmployee> baseEmployees = employeeDao.conditionalLoad();
//            //获取当年的第一天日期
//            Date currYearFirst = getCurrYearFirst();
//            //获取当年的最后一天的日期
//            Date currYearLast = getCurrYearLast();
//            if (null != baseEmployees && baseEmployees.size() != 0) {
//                for (BaseEmployee baseEmployee : baseEmployees) {
//					//初始化定义年假的基础
//					BigDecimal annualLeaveBase = BigDecimal.ZERO;
//					//初始化定义最终年假
//					BigDecimal annualLeaveFinally = BigDecimal.ZERO;
//					//获取员工的开始工作的时间
//					Date startWorkDate = baseEmployee.getStartWorkDate();
//					if (BaseHelpUtils.isNullOrEmpty(startWorkDate)) {
//						continue;
//					}
//					//计算员工的工龄
//					BigDecimal workingAge = getDayDiff(startWorkDate, new Date(), YEARTIME);
//					if (workingAge.compareTo(new BigDecimal(1)) == -1) {
//						annualLeaveBase = BigDecimal.ZERO;
//					} else if (workingAge.compareTo(new BigDecimal("1")) >= 0 && workingAge.compareTo(new BigDecimal("10")) == -1) {
//						annualLeaveBase = BASIS_DAY_1;
//					} else if (workingAge.compareTo(new BigDecimal("10")) >= 0 && workingAge.compareTo(new BigDecimal("20")) == -1) {
//						annualLeaveBase = BASIS_DAY_2;
//					} else {
//						annualLeaveBase = BASIS_DAY_3;
//					}
//                    //获取员工的入职的日期
//                    Date onBoardDate = baseEmployee.getOnboardDate();
//                    if (BaseHelpUtils.isNullOrEmpty(onBoardDate)) {
//                        continue;
//                    }
//                    calendar.clear();
//                    calendar.setTime(onBoardDate);
//                    //获取设置的
//                    int onBoardYear = calendar.get(Calendar.YEAR);
//                    //如果是当年入职的
//                    if (onBoardYear == currentYear) {
//                        BigDecimal temDay = getDayDiff(onBoardDate, currYearLast, DAYTIME);
//                        annualLeaveFinally = temDay.divide(new BigDecimal("365"), 1, BigDecimal.ROUND_HALF_UP).multiply(annualLeaveBase);
//                    } else {
//                        annualLeaveFinally = annualLeaveBase;
//                    }
//
//                    String s = annualLeaveFinally.toString();
//                    int i1 = s.indexOf(".");
//                    if (i1 >= 0) {
//                        String substring = s.substring(s.lastIndexOf(".")+1);
//                        String substringBefore = s.substring(0, s.indexOf("."));
//                        int i = Integer.parseInt(substring);
//                        if (i >= 0 && i < 5) {
//                            annualLeaveFinally = new BigDecimal(substringBefore);
//                        } else {
//                            annualLeaveFinally = new BigDecimal(substringBefore).add(new BigDecimal("0.5"));
//                        }
//                    }
//                    annualLeaveDao.clear();
//                    annualLeaveDao.setConditionYear("=", currentYear);
//                    annualLeaveDao.setConditionEmployeeId("=", baseEmployee.getEmployeeId());
//                    BaseAnnualLeave baseAnnualLeave = annualLeaveDao.executeQueryOneRow();
//                    if (null == baseAnnualLeave) {
//                        BaseAnnualLeave bean = new BaseAnnualLeave();
//                        bean.setEmployeeId(baseEmployee.getEmployeeId());
//                        bean.setEmployeeNo(baseEmployee.getEmployeeNo());
//                        bean.setDepartmentId(baseEmployee.getDepartmentId());
//                        bean.setYear(currentYear);
//                        bean.setTotalAnnualLeave(annualLeaveFinally);
//                        annualLeaveDao.clear();
//                        annualLeaveDao.setDataFromBase(bean);
//                        annualLeaveDao.save();
//                    } else {
//                        baseAnnualLeave.setTotalAnnualLeave(annualLeaveFinally);
//                        annualLeaveDao.clear();
//                        annualLeaveDao.setDataFromBase(baseAnnualLeave);
//                        annualLeaveDao.update();
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    /**
     * 年假计算
     * @throws SQLException
     */
    public void accountLeaveDay() throws SQLException {
    	AnnualLeave dao = new AnnualLeave();
        //取出当年的年份和月份
    	Date currentDate = new Date();
        int currentYear = DateUtil.getYear(currentDate);
        //查询所有的在职员工
        Employee eDao = new Employee();
        eDao.setConditionStatus("=", 0);
        List<BaseEmployee> list = eDao.conditionalLoad();
        if(BaseHelpUtils.isNullOrEmpty(list) || list.size() == 0) {
        	return;
        }
        //获取当年的最后一天的日期
        Date currYearLast = getCurrYearLast();
        //加载当前年份的年假数据集
        dao.clear();
        dao.setConditionYear("=", currentYear);
        List<BaseAnnualLeave> leaveList = dao.conditionalLoad();
        Map<Integer,BaseAnnualLeave> leaveMap = new HashMap<>();
        if(!BaseHelpUtils.isNullOrEmpty(leaveList) && leaveList.size() > 0) {
        	for (BaseAnnualLeave leaveBean : leaveList) {
        		int empId = BaseHelpUtils.getIntValue(leaveBean.getEmployeeId());
        		leaveMap.put(empId, leaveBean);
        	}
        }
		List<BaseAnnualLeave> saveList = new ArrayList<>();
		//遍历计算
		for(BaseEmployee e : list) {
			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			//初始化定义年假的基础
			BigDecimal annualLeaveBase = BigDecimal.ZERO;
			//初始化定义最终年假
			BigDecimal annualLeaveFinally = BigDecimal.ZERO;
			//获取员工的开始工作的时间
			Date startWorkDate = e.getStartWorkDate();
			if (BaseHelpUtils.isNullOrEmpty(startWorkDate)) {
				continue;
			}
			//计算员工的工龄
			BigDecimal workingAge = getDayDiff(startWorkDate, new Date(), YEARTIME);
			if (workingAge.compareTo(new BigDecimal(1)) == -1) {
				annualLeaveBase = BigDecimal.ZERO;
			} else if (workingAge.compareTo(new BigDecimal("1")) >= 0 && workingAge.compareTo(new BigDecimal("10")) == -1) {
				annualLeaveBase = BASIS_DAY_1;
			} else if (workingAge.compareTo(new BigDecimal("10")) >= 0 && workingAge.compareTo(new BigDecimal("20")) == -1) {
				annualLeaveBase = BASIS_DAY_2;
			} else {
				annualLeaveBase = BASIS_DAY_3;
			}
            //获取员工的入职的日期
            Date onBoardDate = e.getOnboardDate();
            if (BaseHelpUtils.isNullOrEmpty(onBoardDate)) {
                continue;
            }
            //获取设置的
            int onBoardYear = DateUtil.getYear(onBoardDate);
            //如果是当年入职的
            if (onBoardYear == currentYear) {
                BigDecimal temDay = getDayDiff(onBoardDate, currYearLast, DAYTIME);
                annualLeaveFinally = temDay.divide(new BigDecimal("365"), 1, BigDecimal.ROUND_HALF_UP).multiply(annualLeaveBase);
            } else {
                annualLeaveFinally = annualLeaveBase;
            }

            String s = annualLeaveFinally.toString();
            int i1 = s.indexOf(".");
            if (i1 >= 0) {
                String substring = s.substring(s.lastIndexOf(".")+1);
                String substringBefore = s.substring(0, s.indexOf("."));
                int i = Integer.parseInt(substring);
                if (i >= 0 && i < 5) {
                    annualLeaveFinally = new BigDecimal(substringBefore);
                } else {
                    annualLeaveFinally = new BigDecimal(substringBefore).add(new BigDecimal("0.5"));
                }
            }
            BaseAnnualLeave bean = leaveMap.get(empId);
            if (BaseHelpUtils.isNullOrEmpty(bean)) {
                bean = new BaseAnnualLeave();
                bean.setEmployeeId(empId);
                bean.setEmployeeNo(e.getEmployeeNo());
                bean.setDepartmentId(e.getDepartmentId());
                bean.setYear(currentYear);
                bean.setTotalAnnualLeave(annualLeaveFinally);
                saveList.add(bean);
            } else {
                bean.setTotalAnnualLeave(annualLeaveFinally);
                dao.clear();
                dao.setDataFromBase(bean);
                dao.update();
            }
		}
        //保存数据集
		if(!BaseHelpUtils.isNullOrEmpty(saveList) && saveList.size() > 0) {
			dao.clear();
			dao.save(saveList);
		}
		//处理重复的数据
        QueryRepeatAnnualLeave query = new QueryRepeatAnnualLeave();
        ConditionRepeatAnnualLeave condition = new ConditionRepeatAnnualLeave();
        BaseCollection<BaseRepeatAnnualLeave> baseRepeatAnnualLeaveBaseCollection = query.executeQuery(null, condition);
        if (!BaseHelpUtils.isNullOrEmpty(baseRepeatAnnualLeaveBaseCollection)) {
            List<BaseRepeatAnnualLeave> collections = baseRepeatAnnualLeaveBaseCollection.getCollections();
            if (!BaseHelpUtils.isNullOrEmpty(collections)) {
                for (BaseRepeatAnnualLeave collection : collections) {
                    Integer employeeId = collection.getEmployeeId();
                    Integer year = collection.getYear();
                    Integer id = collection.getId();
                    dao.clear();
                    dao.setConditionEmployeeId("=", employeeId);
                    dao.setConditionYear("=", year);
                    dao.setConditionAnnualLeaveId("<>", id);
                    dao.conditionalDelete();
                }
            }
        }


    }
    
    /**
     * @Author: liubin
     * @Description : 获取两个时间之前的间隔
     * @Date: 15:20 2019/11/19
     * @param:
     * @return:
     */
    private BigDecimal getDayDiff(Date startData, Date endData, Long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startData);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endData);
        long time2 = cal.getTimeInMillis();
        long l = (time2 - time1) / time;
        BigDecimal betweenDay = new BigDecimal(l);
        return betweenDay;
    }

    /**
     * @Author: liubin
     * @Description : 获取当前时间间隔某年以后的时间
     * @Date: 16:47 2019/11/19
     * @param:
     * @return:
     */
    private Date getOneYearLater(Date startDate, Integer intervalYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, intervalYear);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 格式化日期
     *
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String formatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
        String sDate = f.format(date);
        return sDate;
    }

    /**
     * @Author: liubin
     * @Description : 获取当年的第一天
     * @Date: 17:18 2019/11/19
     * @param:
     * @return:
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * @Author: liubin
     * @Description ：获取当年的最后一天
     * @Date: 17:19 2019/11/19
     * @param:
     * @return:
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * @Author: liubin
     * @Description ：获取某一年第一天的日期
     * @Date: 17:18 2019/11/19
     * @param: [year]
     * @return: java.util.Date
     */
    public static Date getYearFirst(int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * @Author: liubin
     * @Description ：获取某年最后一天日期
     * @Date: 17:19 2019/11/19
     * @param:
     * @return:
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }


    public static void main(String[] args) throws SQLException {
        OncaculateAnnualLeavesAndWealfare p = new OncaculateAnnualLeavesAndWealfare();
        p.run();
    }
}

