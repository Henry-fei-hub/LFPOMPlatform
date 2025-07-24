package delicacy.servlet;

import java.util.Timer;
import java.util.TimerTask;

public class TimerBean {
	
	private TimerTask timerTask;
	
	
	/**
	 * 记录该任务执行的timer
	 */
	private Timer timer;
	
	/**
	 * 类路径
	 */
	private String classPath;

	/**
	 * 循环类型 1:循环一次 2:N次循环
	 */
	private Integer loopType;

	/**
	 * 循环间隙时间
	 */
	private String loopTime;

	/**
	 * 循环间隙时间转换 毫秒
	 */
	private Long loopTimeLong;

	/**
	 * 延时申请时间
	 */
	private String delayTime;

	/**
	 * 延时时间类型 1:定点时间 如 23:10 2:当前时间以后多少秒、分、时、日、月、年
	 */
	private Integer delayTimeType;

	/**
	 * 延时的小时数
	 */
	private Integer delayTimeHour;

	/**
	 * 延时的分钟数
	 */
	private Integer delayTimeMinute;

	/**
	 * 延时时间 毫秒转换
	 */
	private Long delayTimeLong;

	public TimerTask getTimerTask() {
		return timerTask;
	}

	public void setTimerTask(TimerTask timerTask) {
		this.timerTask = timerTask;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public Integer getLoopType() {
		return loopType;
	}

	public void setLoopType(Integer loopType) {
		this.loopType = loopType;
	}

	public String getLoopTime() {
		return loopTime;
	}

	public void setLoopTime(String loopTime) {
		this.loopTime = loopTime;
	}

	public String getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(String delayTime) {
		this.delayTime = delayTime;
	}

	public Long getLoopTimeLong() {
		return loopTimeLong;
	}

	public void setLoopTimeLong(Long loopTimeLong) {
		this.loopTimeLong = loopTimeLong;
	}

	public Integer getDelayTimeType() {
		return delayTimeType;
	}

	public void setDelayTimeType(Integer delayTimeType) {
		this.delayTimeType = delayTimeType;
	}

	public Integer getDelayTimeHour() {
		return delayTimeHour;
	}

	public void setDelayTimeHour(Integer delayTimeHour) {
		this.delayTimeHour = delayTimeHour;
	}

	public Integer getDelayTimeMinute() {
		return delayTimeMinute;
	}

	public void setDelayTimeMinute(Integer delayTimeMinute) {
		this.delayTimeMinute = delayTimeMinute;
	}

	public Long getDelayTimeLong() {
		return delayTimeLong;
	}

	public void setDelayTimeLong(Long delayTimeLong) {
		this.delayTimeLong = delayTimeLong;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	@Override
	public String toString() {
		return "TimerBean [classPath=" + classPath + ", loopType=" + loopType + ", loopTime=" + loopTime
				+ ", loopTimeLong=" + loopTimeLong + ", delayTime=" + delayTime + ", delayTimeType=" + delayTimeType
				+ ", delayTimeHour=" + delayTimeHour + ", delayTimeMinute=" + delayTimeMinute + ", delayTimeLong="
				+ delayTimeLong + "]";
	}

}
