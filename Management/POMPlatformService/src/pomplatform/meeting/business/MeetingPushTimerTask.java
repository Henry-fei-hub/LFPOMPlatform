package pomplatform.meeting.business;

import com.pomplatform.db.bean.BaseConfree;
import com.pomplatform.db.bean.BaseMeetingRelevance;
import com.pomplatform.db.bean.BaseSystemConfig;
import com.pomplatform.db.dao.*;
import delicacy.common.BaseHelpUtils;
import message.common.ERPWeixinUtils;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 会议室状态修改定时器
 *
 * @author xiaolong
 */
public class MeetingPushTimerTask extends TimerTask {
    private static final long ONE_MIN = 60 * 1000;
    private Map<Integer, String> dateMap = new HashMap<>(0);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public void run() {
        Date currentTime = new Date();
        try {
            SystemConfig dao = new SystemConfig();
            BaseSystemConfig bean;
            Meeting mtDao = new Meeting();
            Confree confreeDao = new Confree();
            MeetingRelevance meetingRelevanceDao = new MeetingRelevance();

            //获取系统配置表里面的超时时间和推送时间
            dao.setConditionSystemConfigId("=", 27);
            bean = dao.executeQueryOneRow();

            if (null == bean) {
                return;
            }

            int outTime = 0;
            if (!BaseHelpUtils.isNullOrZero(bean.getCorpId())) {
                outTime = Integer.parseInt(bean.getCorpId());
            }

            int pushTime = 0;
            if (!BaseHelpUtils.isNullOrZero(bean.getAgentId())) {
                pushTime = Integer.parseInt(bean.getAgentId());
            }

            System.out.println("超时时间" + outTime + "推送时间" + pushTime);


            //获取所有已预约的会议状态(全部从meetingrelevance中获取)
            meetingRelevanceDao.setConditionStatus("=", 1);
            List<BaseMeetingRelevance> meetingRelevanceList2 = meetingRelevanceDao.conditionalLoad();
            if (!BaseHelpUtils.isNullOrEmpty(meetingRelevanceList2) && meetingRelevanceList2.size() > 0) {

                for (BaseMeetingRelevance baseMeetingRelevance : meetingRelevanceList2) {
                    int employeeId = baseMeetingRelevance.getEmployeeId();
                    int meetingRelevanceId = baseMeetingRelevance.getMeetingRelevanceId();
                    String meetingRoomName = baseMeetingRelevance.getMeetingRoomName();
                    String meetingRoomTime = baseMeetingRelevance.getMeetingRoomTime();


                    Date strDate = new Date(BaseHelpUtils.getLongValue(baseMeetingRelevance.getMeetingTime()));
                    String str = sdf2.format(strDate);

                    String mstartTime = str + " " + getTimeSection(baseMeetingRelevance.getStartTime()) + ":00";
                    Date startTime = sdf.parse(mstartTime);

                    long l = startTime.getTime() - currentTime.getTime();
                    long disMin = l / ONE_MIN;

                    //会议还未开始用户已经激活的话在会议开始前15分钟发送推送
                    if (disMin >= 0) {
                        if (disMin == pushTime) {
                            String content = "您预约的" + str + " " + meetingRoomTime + meetingRoomName +
                                    "的会议还有" + pushTime + "分钟就要开始了，请前往ERP会议预约记录表界面确认会议，超时未确认将自动取消预约";
                            ERPWeixinUtils.sendWXMsgToUser(employeeId, content);
                            /**
                             * 所有与会成员的消息推送
                             */
                            confreeDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                            List<BaseConfree> baseConfreeList = confreeDao.conditionalLoad();
                            Employee employee = new Employee();
                            for (BaseConfree baseConfree : baseConfreeList) {
                                int status = 0;
                                employee.setEmployeeId(baseConfree.getEmployeeId());
                                if (employee.load()) {
                                    status = employee.getStatus();
                                }
                                if (baseConfree.getEmployeeId() != employeeId && status == 0) {
                                    String confreesContent = "您有一个" + str + " " + meetingRoomTime + meetingRoomName +
                                            "的会议还有5分钟即将开始，请按时参加！";
                                    ERPWeixinUtils.sendWXMsgToUser(baseConfree.getEmployeeId(), confreesContent);
                                }

                            }

                        }

                    } else {

                        if (disMin == -outTime) {

                            String content = "会议室" + meetingRoomName + str + " " + meetingRoomTime +
                                    "的会议已经超时" + outTime + "分钟未确认,会议预约已取消";

                            ERPWeixinUtils.sendWXMsgToUser(employeeId, content);
                            mtDao.setConditionMeetingRelevanceId("=", baseMeetingRelevance.getMeetingRelevanceId());
                            mtDao.setStatus(0);
                            mtDao.conditionalUpdate();
                            mtDao.clear();


                            meetingRelevanceDao.setConditionMeetingRelevanceId("=", baseMeetingRelevance.getMeetingRelevanceId());
                            meetingRelevanceDao.setStatus(0);
                            meetingRelevanceDao.conditionalUpdate();
                            meetingRelevanceDao.clear();
                        }

                        /**
                         * 已经报废的记录则直接修改记录状态不需要给提示信息
                         */
                        mtDao.setConditionMeetingRelevanceId("=", baseMeetingRelevance.getMeetingRelevanceId());
                        mtDao.setStatus(0);
                        mtDao.conditionalUpdate();
                        mtDao.clear();

                        meetingRelevanceDao.setConditionMeetingRelevanceId("=", baseMeetingRelevance.getMeetingRelevanceId());
                        meetingRelevanceDao.setStatus(0);
                        meetingRelevanceDao.conditionalUpdate();
                        meetingRelevanceDao.clear();

                    }

                }
            }


            /**
             * 获取所有已使用中的会议记录
             */
            meetingRelevanceDao.setConditionStatus("=", 2);
            List<BaseMeetingRelevance> meetingRelevanceList = meetingRelevanceDao.conditionalLoad();

            if (!BaseHelpUtils.isNullOrEmpty(meetingRelevanceList) && meetingRelevanceList.size() > 0) {
                for (BaseMeetingRelevance baseMeetingRelevance : meetingRelevanceList) {
                    //预约人id
                    int employeeId = baseMeetingRelevance.getEmployeeId();

                    int meetingRelevanceId = baseMeetingRelevance.getMeetingRelevanceId();
                    String meetingRoomName = baseMeetingRelevance.getMeetingRoomName();
                    String meetingRoomTime = baseMeetingRelevance.getMeetingRoomTime();
                    Date strDate = new Date(BaseHelpUtils.getLongValue(baseMeetingRelevance.getMeetingTime()));
                    String str = sdf2.format(strDate);

                    String mstartTime = str + " " + getTimeSection(baseMeetingRelevance.getStartTime()) + ":00";
                    String mendTime = str + " " + getTimeSection(baseMeetingRelevance.getEndTime()) + ":00";
                    Date startTime = sdf.parse(mstartTime);
                    Date endTime = sdf.parse(mendTime);

                    System.out.println("开始时间" + startTime + "结束时间" + endTime);

                    long l = startTime.getTime() - currentTime.getTime();
                    long disMin = l / ONE_MIN;

                    System.out.println("时间间隔=================" + disMin + "分钟");

                    if (disMin >= 0) {

                        if (disMin == pushTime) {
                            String content = "您预约的" + str + " " + meetingRoomTime + meetingRoomName +
                                    "的会议还有" + pushTime + "分钟就要开始了，请前往ERP会议预约记录表界面确认会议，超时未确认将自动取消预约";
                            ERPWeixinUtils.sendWXMsgToUser(employeeId, content);

                            /**
                             * 所有与会成员的消息推送
                             */
                            confreeDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                            List<BaseConfree> baseConfreeList = confreeDao.conditionalLoad();

                            for (BaseConfree baseConfree : baseConfreeList) {

                                //预约人如果是与会成员的话则不需要收到与会成员的推送消息
                                if (baseConfree.getEmployeeId() != employeeId) {
                                    String confreesContent = "您有一个" + str + " " + meetingRoomTime + meetingRoomName +
                                            "的会议还有5分钟即将开始，请按时参加！";
                                    ERPWeixinUtils.sendWXMsgToUser(baseConfree.getEmployeeId(), confreesContent);
                                }

                            }
                        }
                    }

                    if (currentTime.after(endTime)) {

                        System.out.println("获取到的关联id" + baseMeetingRelevance.getMeetingRelevanceId());

                        mtDao.setConditionMeetingRelevanceId("=", baseMeetingRelevance.getMeetingRelevanceId());
                        mtDao.setStatus(4);
                        mtDao.conditionalUpdate();
                        mtDao.clear();

                        meetingRelevanceDao.setConditionMeetingRelevanceId("=", baseMeetingRelevance.getMeetingRelevanceId());
                        meetingRelevanceDao.setStatus(4);
                        meetingRelevanceDao.conditionalUpdate();
                        meetingRelevanceDao.clear();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取开始时间和结束时间
     */
    public String getTimeSection(int key) {
        dateMap.put(1, "07:00");
        dateMap.put(2, "08:00");
        dateMap.put(3, "09:00");
        dateMap.put(4, "10:00");
        dateMap.put(5, "11:00");
        dateMap.put(6, "12:00");
        dateMap.put(7, "13:00");
        dateMap.put(8, "14:00");
        dateMap.put(9, "15:00");
        dateMap.put(10, "16:00");
        dateMap.put(11, "17:00");
        dateMap.put(12, "18:00");
        dateMap.put(13, "19:00");
        dateMap.put(14, "20:00");
        dateMap.put(15, "21:00");
        dateMap.put(16, "22:00");
        return dateMap.get(key);
    }


    /**
     * 测试会议室定时器
     *
     * @param args
     */
    public static void main(String[] args) throws SQLException {
        MeetingPushTimerTask pushTimer = new MeetingPushTimerTask();
        pushTimer.run();
    }

}



