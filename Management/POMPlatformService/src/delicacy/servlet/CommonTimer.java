package delicacy.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;

/**
 *
 * @author CL
 */
@SuppressWarnings("serial")
@WebServlet(name = "CommonTimer", loadOnStartup = 1, urlPatterns = {"/CommonTimer"})
public class CommonTimer extends HttpServlet {
    private static final Logger __LOGGER = Logger.getLogger(CommonTimer.class);
    public static final long PERIOD_YEAR = 365 * 24 * 60 * 60 * 1000;
    public static final long PERIOD_MONTH = 30 * 24 * 60 * 60 * 1000;
    public static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
    public static final long PERIOD_HOUR = 60 * 60 * 1000;
    public static final long PERIOD_MIN = 60 * 1000;
    public static final long PERIOD_SECOND = 1000;
    
    /**
     * 循环类型: 只循环一次
     */
    private static final int LOOP_TYPE_ONE = 1;
    
    /**	 
     * 循环类型: 无限次循环
     */
    private static final int LOOP_TYPE_TWO = 2;
    
    /**
     * 延时时间类型 1:定点时间 如 23:10
     */
    private static final int DELAY_TIME_TYPE_ONE = 1;
    
    /**
     * 延时时间类型 2:当前时间以后多少秒、分、时、日、月、年
     */
    private static final int DELAY_TIME_TYPE_TWO = 2;
    
    List<TimerBean> taskList = new ArrayList<>();
    
    Timer timer = null;
    
    
    @Override
    public void init() {
    	execTimer();
    }
    
    //定时器执行方
    public void execTimer(){
    	try {
    		__LOGGER.info("开始装载timer.properties数据");
    		String startup = TimerPropertiesUtils.getValue("timer.startup");
    		__LOGGER.info(String.format("timer.startup = %1$s", startup));
    		if(!BaseHelpUtils.isNullOrEmpty(startup) && startup.equals("on")) {
    			String taskArrName = TimerPropertiesUtils.getValue("timer.startup.task");
    			__LOGGER.info(String.format("timer.startup.task = %1$s", taskArrName));
    			if(!BaseHelpUtils.isNullOrEmpty(taskArrName)) {
    				taskArrName = taskArrName.replaceAll("，", ",");
    				String [] taskStrArr = taskArrName.split(",");
    				__LOGGER.info(String.format("设置需要执行的任务数为=%1$s", taskStrArr.length));
    				// 设置任务数据
    				setTaskList(taskStrArr, this.taskList);
    				__LOGGER.info(String.format("装载的任务数为=%1$s", taskList.size()));
    				if(taskList.size() > 0) {
    					for (TimerBean timerBean : this.taskList) {
    						__LOGGER.debug(String.format("创建task参数 %1$s", timerBean.toString()));
    						try {
    							timer = new Timer("commonTimer-" + timerBean.getTimerTask().getClass().getSimpleName());
    							timerBean.setTimer(timer);
    							if(Objects.equals(timerBean.getLoopType(), LOOP_TYPE_ONE)) {
    								// 执行一次
    								if(Objects.equals(timerBean.getDelayTimeType(), DELAY_TIME_TYPE_ONE)) {
    									timer.schedule(timerBean.getTimerTask(), DateUtil.getNextFixedHourDate(timerBean.getDelayTimeHour(), 
    											timerBean.getDelayTimeMinute()));
    								}else if(Objects.equals(timerBean.getDelayTimeType(), DELAY_TIME_TYPE_TWO)) {
    									timer.schedule(timerBean.getTimerTask(), timerBean.getDelayTimeLong());
    								}
    							}else if(Objects.equals(timerBean.getLoopType(), LOOP_TYPE_TWO)) {
    								// 循环执行
    								if(Objects.equals(timerBean.getDelayTimeType(), DELAY_TIME_TYPE_ONE)) {
    									timer.schedule(timerBean.getTimerTask(), DateUtil.getNextFixedHourDate(timerBean.getDelayTimeHour(), 
    											timerBean.getDelayTimeMinute()), timerBean.getLoopTimeLong());
    								}else if(Objects.equals(timerBean.getDelayTimeType(), DELAY_TIME_TYPE_TWO)) {
    									timer.schedule(timerBean.getTimerTask(), timerBean.getDelayTimeLong(), timerBean.getLoopTimeLong());
    								}
    							}
							} catch (Exception e) {
								__LOGGER.error(String.format("将任务加入到定时器中失败参数=%1$s, 错误信息{%2$s}", timerBean.toString(), e.getMessage()));
							}
						}
    				}
    			}
    		}
    		__LOGGER.info("装载timer.properties数据完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void setTaskList(String [] taskStrArr, List<TimerBean> taskList) {
    	for (int i = 0; i < taskStrArr.length; i++) {
    		String taskName = taskStrArr[i];
    		String path = TimerPropertiesUtils.getValue("timer." + taskName + ".path");
    		if(BaseHelpUtils.isNullOrEmpty(path)) {
    			continue;
    		}
    		try {
        		TimerBean bean = new TimerBean();
        		TimerTask timerTask = (TimerTask) Class.forName(path).newInstance();
        		int loopType = BaseHelpUtils.getIntValue(TimerPropertiesUtils.getValue("timer." + taskName + ".looptype"));
        		String loopTime = TimerPropertiesUtils.getValue("timer." + taskName + ".looptime");
        		String delayTime = TimerPropertiesUtils.getValue("timer." + taskName + ".delaytime");
        		if(!BaseHelpUtils.isNullOrEmpty(delayTime)) {
        			bean.setTimerTask(timerTask);
            		bean.setClassPath(path);
            		bean.setLoopTime(loopTime);
            		bean.setDelayTime(delayTime);
            		bean.setLoopType(loopType);
        			if(loopType == LOOP_TYPE_TWO) {// 循环执行模式时 需要检查有没有设置循环时间
            			if(!BaseHelpUtils.isNullOrEmpty(loopTime)) {
            				setTimerDelaytime(bean, delayTime);
            				setTimerLooptime(bean, loopTime);
            				if(bean.getLoopTimeLong() > 0) {
            					taskList.add(bean);
            				}
            			}
            		} else if (loopType == LOOP_TYPE_ONE) {
            			setTimerDelaytime(bean, delayTime);
            			taskList.add(bean);
            		}
        		}
        		
			} catch (Exception e) {
				__LOGGER.error(String.format("装载类路径[%1$s], 失败{%2$s}", path, e.getMessage()));;
			}
		}
    }
    
    /**
     * 设置延时时间参数
     * @param bean
     * @param delayTime
     */
    private void setTimerDelaytime(TimerBean bean, String delayTime) {
    	delayTime = delayTime.replace("：", ":");
    	if(delayTime.indexOf(":") > 0) {
    		bean.setDelayTimeType(DELAY_TIME_TYPE_ONE);
    		String [] timeArra = delayTime.split(":");
    		bean.setDelayTimeHour(BaseHelpUtils.getIntValue(timeArra[0]));
    		bean.setDelayTimeMinute(BaseHelpUtils.getIntValue(timeArra[1]));
    	}else {
    		bean.setDelayTimeType(DELAY_TIME_TYPE_TWO);
    		bean.setDelayTimeLong(getLongTimeByDateStr(delayTime));
    	}
    	
    }
    
    /**
     * 设置循环执行时间参数
     * @param bean
     * @param loopTime
     */
    private void setTimerLooptime(TimerBean bean, String loopTime) {
    	bean.setLoopTimeLong(getLongTimeByDateStr(loopTime));
    }
    
    /**
     * 根据配置的时间字符串返回指定参数
     * @param dateStr
     * @return
     */
    private Long getLongTimeByDateStr(String dateStr) {
    	if(dateStr.length() > 1) {
    		String dateNumberStr = dateStr.substring(0, dateStr.length() - 1);
    		String dateType = dateStr.substring(dateStr.length() - 1);
    		long unitLong = -1L;
    		switch (dateType) {
			case "s":
			case "S":
				unitLong = PERIOD_SECOND;
				break;
			case "m":
				unitLong = PERIOD_MIN;
				break;
			case "h":
			case "H":
				unitLong = PERIOD_HOUR;
				break;
			case "d":
			case "D":
				unitLong = PERIOD_DAY;
				break;
			case "M":
				unitLong = PERIOD_MONTH;
				break;
			case "y":
			case "Y":
				unitLong = PERIOD_YEAR;
				break;
			default:
				break;
			}
    		if(unitLong >= 0) {
    			int dateNumber = BaseHelpUtils.getIntValue(dateNumberStr);
    			return (dateNumber * unitLong);
    		}
    	}
		return -1L;
    	
    }

    @Override
    public void destroy() {
        for (TimerBean timerBean : taskList) {
			if(null != timerBean.getTimer()) {
				timerBean.getTimer().cancel();
			}
		}
        taskList.clear();
    }
    
}
