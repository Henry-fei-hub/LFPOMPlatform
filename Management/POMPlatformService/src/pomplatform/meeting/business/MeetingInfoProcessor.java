package pomplatform.meeting.business;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;
import delicacy.common.*;
import delicacy.date.util.DateUtil;
import message.common.ERPWeixinUtils;
import pomplatform.meeting.bean.*;
import pomplatform.meeting.dao.MeetingWithConfree;
import pomplatform.meeting.query.QueryMeetingInfoPaymentBase;
import pomplatform.meeting.query.QueryMeetingRelevanceInfo;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * 会议室后台处理界面
 *
 * @author xiaolong
 */
public class MeetingInfoProcessor implements GenericProcessor {

    /**
     * 获取会议室的与会成员
     */
    private static final String GET_MEETING_CONFREES = "getMeetingConfrees";

    /**
     * 更新预约的功能
     */
    private static final String UPDATE_MEETING_RECORD = "updateMeetingRecord";

    /**
     * 获取会议记录
     */
    private static final String GET_MEETING_RECORD = "getMeetingRecord";

    /**
     * 获取会议记录详情
     */
    private static final String GET_MEETING_ROOM_AND_EMPLOYEE = "getMeetingAndEmployeeInformation";

    /**
     * 新建会议
     */
    private static final String SAVE_MEETINGS_AND_CONFREES = "saveMeetingsAndConfrees";

    /**
     * 周例会预约
     */
    private static final String SAVE_WEEK_MEETING = "saveWeekMeeting";

    /**
     * 月例会预约
     */
    private static final String SAVE_MONTH_MEETING = "saveMonthMeeting";

    /**
     * 更新status的状态信息
     */
    private static final String UPDATE_MEETINGINFI = "updateMeetingInfo";
    /**
     * 取消预约
     */
    private static final String CANCEL_RESERVATION = "cancelReservation";

    private static final Logger __LOGGER = Logger.getLogger("MeetingRoomRecordPanel的返回值");

    /**
     * 根据日期获取星期几
     */
    SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");

    Map<Integer, String> dateMap = new HashMap<>(0);
    Map<String, Integer> meetingRoomTimeMap = new HashMap<>(0);
    Map<String, Integer> weekMap = new HashMap<>(0);
    Map<Integer, String> weekMap2 = new HashMap<>(0);

    public String execute(String creteria, HttpServletRequest httpServletRequest) throws Exception {
        Map<String, Object> params = (Map<String, Object>) JsonParser.parse(creteria);
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch (optType) {

            case GET_MEETING_ROOM_AND_EMPLOYEE:
                return getMeetingAndEmployeeInformation(params);
            case SAVE_MEETINGS_AND_CONFREES:
                return saveMeetingsAndConfrees(params);
            case SAVE_WEEK_MEETING:
                return saveWeekMeeting(params);
            case SAVE_MONTH_MEETING:
                return saveMonthMeeting(params);
            case UPDATE_MEETINGINFI:
                return updateMeetingInfo(params);
            case CANCEL_RESERVATION:
                return cancelReservation(params);
            case GET_MEETING_RECORD:
                return getMeetingRecord(params);
            case GET_MEETING_CONFREES:
                return getMeetingConfrees(params);
            case UPDATE_MEETING_RECORD:
                return updateMeetingRecord(params);

            default:
                break;
        }
        return null;
    }


    /**
     * 存放时间区间的map
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
     * 传入时间区间获取时区id
     */
    public int getTimeId(String key) {
        meetingRoomTimeMap.put("07:00-08:00", 1);
        meetingRoomTimeMap.put("08:00-09:00", 2);
        meetingRoomTimeMap.put("09:00-10:00", 3);
        meetingRoomTimeMap.put("10:00-11:00", 4);
        meetingRoomTimeMap.put("11:00-12:00", 5);
        meetingRoomTimeMap.put("12:00-13:00", 6);
        meetingRoomTimeMap.put("13:00-14:00", 7);
        meetingRoomTimeMap.put("14:00-15:00", 8);
        meetingRoomTimeMap.put("15:00-16:00", 9);
        meetingRoomTimeMap.put("16:00-17:00", 10);
        meetingRoomTimeMap.put("17:00-18:00", 11);
        meetingRoomTimeMap.put("18:00-19:00", 12);
        meetingRoomTimeMap.put("19:00-20:00", 13);
        meetingRoomTimeMap.put("20:00-21:00", 14);
        meetingRoomTimeMap.put("21:00-22:00", 15);
        return meetingRoomTimeMap.get(key);
    }

    /**
     * 根据id获取星期
     *
     * @param key
     * @return
     */
    public String getWeekTime2(int key) {
        weekMap2.put(1, "星期一");
        weekMap2.put(2, "星期二");
        weekMap2.put(3, "星期三");
        weekMap2.put(4, "星期四");
        weekMap2.put(5, "星期五");
        weekMap2.put(6, "星期六");
        weekMap2.put(7, "星期天");
        return weekMap2.get(key);
    }


    /**
     * 获取会议室的与会成员
     *
     * @param params
     * @return
     */
    private String getMeetingConfrees(Map<String, Object> params) throws SQLException {
        BaseCollection<BaseEmployee> collection = new BaseCollection<>();
        int meetingRelevanceId = BaseHelpUtils.getIntValue(params.get("meetingRelevanceId"));
        Employee employeeDao = new Employee();
        Confree confreeDao = new Confree();
        confreeDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
        List<BaseConfree> confreeList = confreeDao.conditionalLoad();
        List<BaseEmployee> baseEmployeeList = new ArrayList<>();
        if (confreeList.size() > 0) {
            for (BaseConfree baseConfree : confreeList) {
                employeeDao.clear();
                employeeDao.setConditionEmployeeId("=", baseConfree.getEmployeeId());
                if (!BaseHelpUtils.isNullOrEmpty(employeeDao.executeQueryOneRow())) {
                    baseEmployeeList.add(employeeDao.executeQueryOneRow());
                }
            }
            collection.setCollections(baseEmployeeList);
        }
        return collection.toJSON(0, "");
    }

    /**
     * 确认会议
     *
     * @param params
     * @return
     * @throws SQLException
     */
    private String updateMeetingInfo(Map<String, Object> params) throws SQLException {
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        Meeting dao = new Meeting();
        MeetingRelevance mDao = new MeetingRelevance();

        int meetingRelevanceId = BaseHelpUtils.getIntValue(params.get("meetingRelevanceId"));

        mDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
        mDao.setStatus(2);
        mDao.conditionalUpdate();
        mDao.clear();

        //更新每条记录的状态
        dao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
        dao.setStatus(2);
        dao.conditionalUpdate();
        dao.clear();

        return collection.toJSON(0, "会议室激活成功，已开始使用");
    }


    /**
     * 取消预约功能
     *
     * @param params
     * @return
     */
    private String cancelReservation(Map<String, Object> params) throws SQLException {

        /**
         * 获取会议室关联id和状态
         */
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        int meetingRelevanceId = BaseHelpUtils.getIntValue(params.get("meetingRelevanceId"));
        MeetingRelevance meetingRelevanceDao = new MeetingRelevance();
        Meeting meetingDao = new Meeting();

        meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
        meetingRelevanceDao.setStatus(0);
        meetingRelevanceDao.conditionalUpdate();
        meetingRelevanceDao.clear();

        meetingDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
        List<BaseMeeting> meetingList = meetingDao.conditionalLoad();
        if (meetingList.size() > 0) {
            for (BaseMeeting baseMeeting : meetingList) {
                //更新会议室记录的状态
                meetingDao.setConditionMeetingRelevanceId("=", baseMeeting.getMeetingRelevanceId());
                meetingDao.setStatus(0);
                meetingDao.conditionalUpdate();
                meetingDao.clear();
            }
        }
        return collection.toJSON(0, "会议记录取消成功");
    }


    /**
     * 更新会议室记录
     *
     * @param params
     * @return
     */
    private String updateMeetingRecord(Map<String, Object> params) throws Exception {
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        int myMeetingRelevanceId = BaseHelpUtils.getIntValue(params.get("meetingRelevanceId"));
        int meetingStatus = BaseHelpUtils.getIntValue(params.get("meetingStatus"));

        Meeting meeting = new Meeting();
        Date currentTime = new Date();
        Confree confreeDao = new Confree();
        BaseConfree confreeBean = new BaseConfree();
        MeetingRelevance meetingRelevanceDao = new MeetingRelevance();
        BaseMeetingRelevance meetingRelevanceBean = new BaseMeetingRelevance();

        Map<String, Object> mParams = new HashMap<>(0);
        BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
        MeetingWithConfree dao = new MeetingWithConfree();

        MeetingRoom mtDao = new MeetingRoom();
        String meetingRoomName = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer meetingRoomId;

        //获取会议记录的时间
        Date strDate = new Date(BaseHelpUtils.getLongValue(params.get("meetingTime")));

        try {
            meetingRoomId = BaseHelpUtils.getIntValue(params.get("meetingRoomId"));
        } catch (Exception e) {
            e.printStackTrace();
            return dao.generateBase().toOneLineJSON(-1, "会议室不能为空");
        }

        mtDao.setConditionMeetingRoomId("=", meetingRoomId);
        BaseMeetingRoom mtBean = mtDao.executeQueryOneRow();
        if (mtBean != null) {
            meetingRoomName = mtBean.getMeetingRoomName();
        }

        Integer employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
        int startTime = BaseHelpUtils.getIntValue(params.get("wmStartTime"));
        int endTime = BaseHelpUtils.getIntValue(params.get("wmEndTime"));
        int status = BaseHelpUtils.getIntValue(params.get("status"));

        String meetingTheme = params.get("meetingTheme").toString();
        String date = dateFormat.format(strDate);

        //获取与会成员的数据
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) params.get("detailConfree");

        /**
         *先把旧数据删除然后再进行新增操作
         */
        meetingRelevanceDao.setConditionMeetingRelevanceId("=", myMeetingRelevanceId);
        meetingRelevanceDao.conditionalDelete();
        meetingRelevanceDao.clear();
        confreeDao.setConditionMeetingRelevanceId("=", myMeetingRelevanceId);
        confreeDao.conditionalDelete();
        confreeDao.clear();
        meeting.setConditionMeetingRelevanceId("=", myMeetingRelevanceId);
        meeting.conditionalDelete();
        meeting.clear();


        //会议时间
        String meetingRoomTime = getTimeSection(startTime) + "-" + getTimeSection(endTime);
        String meetingInfo = dateFm.format(strDate);
        /**
         * 首先插入一条记录到会议室关联表中去
         * 然后在循环的时候获取到关联表的id，如果插入失败的话，则将该关联id对应的记录删除
         */
        meetingRelevanceBean.setEmployeeId(employeeId);
        meetingRelevanceBean.setMeetingRoomId(meetingRoomId);
        meetingRelevanceBean.setMeetingRoomTime(meetingRoomTime);
        meetingRelevanceBean.setStartTime(startTime);
        meetingRelevanceBean.setMeetingTime(strDate);
        meetingRelevanceBean.setEndTime(endTime);
        meetingRelevanceBean.setStatus(status);

        //根据传入的时间获取日期
        meetingRelevanceBean.setWeekTime(DateUtil.getDayOfWeek(strDate));
        meetingRelevanceBean.setMeetingInfo(meetingInfo);
        meetingRelevanceBean.setMeetingTheme(meetingTheme);
        meetingRelevanceBean.setMeetingRoomName(meetingRoomName);
        meetingRelevanceBean.setMeetingStatus(meetingStatus);
        meetingRelevanceDao.setDataFromBase(meetingRelevanceBean);
        meetingRelevanceDao.save();

        //关联表的id
        int meetingRelevanceId = meetingRelevanceDao.getMeetingRelevanceId();

        if (BaseHelpUtils.isNullOrZero(meetingRelevanceId)) {
            return dao.generateBase().toOneLineJSON(-1, "插入会议记录失败");
        }

        //循环遍历时区，根据时区的差值增加相应的记录
        for (int i = startTime; i < endTime; i++) {

            String time1 = getTimeSection(i);
            String time2 = getTimeSection(i + 1);
            //时间区间
            String timeDomain = time1 + "-" + time2;
            //时间区间id
            int timeZone = getTimeId(timeDomain);
            String mstartTime = date + " " + time1 + ":00";
            String mendTime = date + " " + time2 + ":00";

            /**
             * 判断会议室记录是否正确
             */
            String where = insertVerify(timeZone, mstartTime, mendTime, meeting, timeDomain, meetingRoomId, employeeId,
                    time1, time2, date, mParams, params);

            if (meeting.countRows(where) > 0) {
                meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                meetingRelevanceDao.conditionalDelete();
                return dao.generateBase().toOneLineJSON(-1, "抱歉，您选择的时间区间内" +
                        timeDomain + "会议室已被预约，请重新选择");
            }

            /**
             * 当前时间如果大于结束的时间段的话则不让预约
             */
            Date endDateTime = sdf.parse(mendTime);

            long l = currentTime.getTime() - endDateTime.getTime();
            if (endDateTime.before(currentTime)) {
                if (l <= 0) {
                    bean.setDataFromMap(mParams);
                    bean.setStatus(status);
                    bean.setMeetingTime(strDate);
                    bean.setMeetingStatus(1);
                    bean.setMeetingRelevanceId(meetingRelevanceId);
                    dao.setDataFromBase(bean);
                    dao.save();
                    sendNotification(confreeDao, confreeBean, dao, mapList, 3, strDate, meetingRoomTime, meetingRoomName, meetingInfo,meetingTheme);
                } else {
                    meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                    meetingRelevanceDao.conditionalDelete();
                    return dao.generateBase().toOneLineJSON(-1, "当前时间区间段已不能预约，请重新选择");
                }
            } else {
                bean.setDataFromMap(mParams);
                bean.setStatus(status);
                bean.setMeetingTime(strDate);
                bean.setMeetingStatus(1);
                bean.setMeetingRelevanceId(meetingRelevanceId);
                dao.setDataFromBase(bean);
                dao.save();

                sendNotification(confreeDao, confreeBean, dao, mapList, 3, strDate, meetingRoomTime, meetingRoomName, meetingInfo,meetingTheme);
            }
        }
        return collection.toJSON(0, "更新会议室记录成功");

    }


    /**
     * 获取会议室记录
     *
     * @param params
     * @return
     */
    private String getMeetingRecord(Map<String, Object> params) throws SQLException {
        ConditionMeetingRelevanceInfo condition = new ConditionMeetingRelevanceInfo();
        condition.setDataFromMap(params);
        QueryMeetingRelevanceInfo query = new QueryMeetingRelevanceInfo();
        query.setCurrentPage(condition.getCurrentPage());
        query.setPageLines(condition.getPageLines());

        List<KeyValuePair> list = new ArrayList<>();
        /**
         * 替换查询条件
         */
        if (BaseHelpUtils.isNullOrEmpty(condition.getYear())) {
            KeyValuePair kv = new KeyValuePair();
            kv.setKey("EXTRACT ( YEAR FROM meeting_time ) = ?");
            kv.setValue("1 = ?");
            list.add(kv);
        }

        if (BaseHelpUtils.isNullOrEmpty(condition.getMonth())) {
            KeyValuePair kv = new KeyValuePair();
            kv.setKey("EXTRACT ( MONTH FROM meeting_time ) = ?");
            kv.setValue("1 = ?");
            list.add(kv);
        }

        KeyValuePair[] kvs = null;
        if (!list.isEmpty()) {
            int size = list.size();
            kvs = new KeyValuePair[size];
            for (int i = 0; i < size; i++) {
                kvs[i] = list.get(i);
            }
        }

        BaseCollection<BaseMeetingRelevanceInfo> bc = query.executeQuery(kvs, condition);
        return bc.toJSON();

    }

    /**
     * 获取会议记录详情
     *
     * @param params
     * @throws SQLException
     */
    private String getMeetingAndEmployeeInformation(Map<String, Object> params) throws SQLException {

        ConditionMeetingInfoPaymentBase condition = new ConditionMeetingInfoPaymentBase();
        condition.setEmployeeId(BaseHelpUtils.getIntValue(params.get("userId")));
        condition.setDataFromMap(params);
        QueryMeetingInfoPaymentBase query = new QueryMeetingInfoPaymentBase();
        query.setCurrentPage(condition.getCurrentPage());
        query.setPageLines(condition.getPageLines());

        List<KeyValuePair> list = new ArrayList<>();

        /**
         * 替换查询条件
         */
        if (BaseHelpUtils.isNullOrEmpty(condition.getYear())) {
            KeyValuePair kv = new KeyValuePair();
            kv.setKey("EXTRACT ( YEAR FROM mt.meeting_time ) = ?");
            kv.setValue("1 = ?");
            list.add(kv);
        }

        if (BaseHelpUtils.isNullOrEmpty(condition.getMonth())) {
            KeyValuePair kv = new KeyValuePair();
            kv.setKey("EXTRACT ( MONTH FROM mt.meeting_time ) = ?");
            kv.setValue("1 = ?");
            list.add(kv);
        }

        KeyValuePair[] kvs = null;
        if (!list.isEmpty()) {
            int size = list.size();
            kvs = new KeyValuePair[size];
            for (int i = 0; i < size; i++) {
                kvs[i] = list.get(i);
            }
        }
        BaseCollection<BaseMeetingInfoPaymentBase> bc = query.executeQuery(kvs, condition);
        return bc.toJSON();
    }

    /**
     * 新建会议
     *
     * @param params
     * @param params
     * @return
     * @throws SQLException
     */
    private String saveMeetingsAndConfrees(Map<String, Object> params) throws Exception {
        Map<String, Object> mParams = new HashMap<>(0);
        BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
        MeetingWithConfree dao = new MeetingWithConfree();
        MeetingRoom mtDao = new MeetingRoom();
        String meetingRoomName = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //会议开始日期
        Date strDate = new Date(BaseHelpUtils.getLongValue(params.get("meetingTime")));

        Integer meetingRoomId = BaseHelpUtils.getIntValue(params.get("meetingRoomId"));
        if (BaseHelpUtils.isNullOrZero(meetingRoomId)) {
            return dao.generateBase().toOneLineJSON(-1, "会议室不能为空");
        }

        //会议开始的星期
        String meetingInfo = dateFm.format(strDate);
        //根据会议室id获取会议室名称
        mtDao.setConditionMeetingRoomId("=", meetingRoomId);
        BaseMeetingRoom mtBean = mtDao.executeQueryOneRow();
        if (null != mtBean) {
            meetingRoomName = mtBean.getMeetingRoomName();
        }

        Integer employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
        int startTime = BaseHelpUtils.getIntValue(params.get("wmStartTime"));
        int endTime = BaseHelpUtils.getIntValue(params.get("wmEndTime"));
        int status = BaseHelpUtils.getIntValue(params.get("status"));
        int meetingStatus = BaseHelpUtils.getIntValue(params.get("meetingStatus"));
        String meetingTheme = params.get("meetingTheme").toString();
        String date = dateFormat.format(params.get("meetingTime"));
        Meeting meeting = new Meeting();
        Date currentTime = new Date();

        //会议时间
        String meetingRoomTime = getTimeSection(startTime) + "-" + getTimeSection(endTime);

        //获取与会成员的数据
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) params.get("detailConfree");
        Confree confreeDao = new Confree();
        BaseConfree confreeBean = new BaseConfree();
        MeetingRelevance meetingRelevanceDao = new MeetingRelevance();
        BaseMeetingRelevance meetingRelevanceBean = new BaseMeetingRelevance();


        /**
         * 首先插入一条记录到会议室关联表中去
         */
        meetingRelevanceBean.setEmployeeId(employeeId);
        meetingRelevanceBean.setMeetingRoomId(meetingRoomId);
        meetingRelevanceBean.setMeetingRoomTime(meetingRoomTime);
        meetingRelevanceBean.setStartTime(startTime);
        meetingRelevanceBean.setMeetingTime(strDate);
        meetingRelevanceBean.setEndTime(endTime);
        meetingRelevanceBean.setStatus(status);
        meetingRelevanceBean.setWeekTime(DateUtil.getDayOfWeek(strDate));
        meetingRelevanceBean.setMeetingInfo(meetingInfo);
        meetingRelevanceBean.setMeetingTheme(meetingTheme);
        meetingRelevanceBean.setMeetingRoomName(meetingRoomName);

        if (!BaseHelpUtils.isNullOrZero(meetingStatus)) {
            meetingRelevanceBean.setMeetingStatus(meetingStatus);
        } else {
            meetingRelevanceBean.setMeetingStatus(1);
        }

        meetingRelevanceDao.setDataFromBase(meetingRelevanceBean);
        meetingRelevanceDao.save();

        //关联表的id
        int meetingRelevanceId = meetingRelevanceDao.getMeetingRelevanceId();
        if (BaseHelpUtils.isNullOrZero(meetingRelevanceId)) {
            meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
            meetingRelevanceDao.conditionalDelete();
            return dao.generateBase().toOneLineJSON(-1, "插入会议记录失败");
        }

        //循环遍历时区，根据时区的差值增加相应的记录
        for (int i = startTime; i < endTime; i++) {

            String time1 = getTimeSection(i);
            String time2 = getTimeSection(i + 1);

            //时间区间
            String timeDomain = time1 + "-" + time2;

            //时间区间id
            int timeZone = getTimeId(timeDomain);
            String mstartTime = date + " " + time1 + ":00";
            String mendTime = date + " " + time2 + ":00";

            /**
             * 判断会议室记录是否正确
             */
            String where = insertVerify(timeZone, mstartTime, mendTime, meeting, timeDomain, meetingRoomId, employeeId,
                    time1, time2, date, mParams, params);
            if (meeting.countRows(where) > 0) {
                meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                meetingRelevanceDao.conditionalDelete();
                return dao.generateBase().toOneLineJSON(-1, "抱歉，您选择的时间区间内" + timeDomain
                        + "会议室已被预约，请重新选择");
            }

            /**
             * 当前时间如果大于结束的时间段的话则不让预约
             */
            Date endDateTime = sdf.parse(mendTime);
            long l = currentTime.getTime() - endDateTime.getTime();
            if (endDateTime.before(currentTime)) {
                if (l <= 0) {
                    bean.setDataFromMap(mParams);
                    bean.setStatus(status);
                    bean.setMeetingTime(strDate);
                    bean.setMeetingStatus(1);
                    bean.setRecordDate(new Date());
                    bean.setMeetingRelevanceId(meetingRelevanceId);
                    dao.setDataFromBase(bean);
                    dao.save();
                    sendNotification(confreeDao, confreeBean, dao, mapList, 1, strDate, meetingRoomTime, meetingRoomName, meetingInfo,meetingTheme);
                } else {
                    meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                    meetingRelevanceDao.conditionalDelete();
                    return dao.generateBase().toOneLineJSON(-1, "当前时间区间段已不能预约，请重新选择");
                }
            } else {
                bean.setDataFromMap(mParams);
                bean.setStatus(status);
                bean.setMeetingTime(strDate);
                bean.setRecordDate(new Date());
                bean.setMeetingStatus(1);
                bean.setMeetingRelevanceId(meetingRelevanceId);
                dao.setDataFromBase(bean);
                dao.save();

                //推送
                String content = "您预约" + meetingRoomName + " " + timeDomain + "的会议成功，请前往ERP会议预约记录表界面确认会议，超时未确认将自动取消预约";
                ERPWeixinUtils.sendWXMsgToUser(employeeId, content);
                sendNotification(confreeDao, confreeBean, dao, mapList, 1, strDate, meetingRoomTime, meetingRoomName, meetingInfo,meetingTheme);
            }
        }
        return dao.generateBase().toOneLineJSON();
    }


    /**
     * 周例会预约
     *
     * @param params
     * @return
     */
    private String saveWeekMeeting(Map<String, Object> params) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int weekNum = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);

        BaseMeetingWithConfree bean = new BaseMeetingWithConfree();

        MeetingWithConfree dao = new MeetingWithConfree();
        MeetingRoom mtDao = new MeetingRoom();
        String meetingRoomName = "";
        String meetingInfo = "";
        int meetingRelevanceId;
        Integer meetingRoomId;

        Integer weekTime = BaseHelpUtils.getIntValue(params.get("weekSelect"));
        try {
            meetingRoomId = BaseHelpUtils.getIntValue(params.get("meetingRoomId"));
        } catch (Exception e) {
            e.printStackTrace();
            return dao.generateBase().toOneLineJSON(-1, "会议室不能为空");
        }

        //根据会议室id获取会议室名称
        mtDao.setConditionMeetingRoomId("=", meetingRoomId);
        BaseMeetingRoom mtBean = mtDao.executeQueryOneRow();

        if (null != mtBean) {
            meetingRoomName = mtBean.getMeetingRoomName();
        }

        //获取会议时间
        Date strDate = new Date(BaseHelpUtils.getLongValue(params.get("recordDate")));
        int meetingStatus = BaseHelpUtils.getIntValue(params.get("meetingStatus"));
        int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));

        int startTimes = BaseHelpUtils.getIntValue(params.get("wmStartTime"));
        int endTimes = BaseHelpUtils.getIntValue(params.get("wmEndTime"));
        int status = BaseHelpUtils.getIntValue(params.get("status"));

        String meetingTheme = params.get("meetingTheme").toString();
        MeetingRelevance meetingRelevanceDao = new MeetingRelevance();
        BaseMeetingRelevance meetingRelevanceBean = new BaseMeetingRelevance();
        Map<String, Object> mparams = new HashMap<>(0);
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Meeting meeting = new Meeting();

        //获取与会成员的数据
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) params.get("detailConfree");
        Confree confreeDao = new Confree();
        BaseConfree confreeBean = new BaseConfree();

        String time1;
        String time2;
        //时区
        String timeDomain;
        //时区id
        int timeZone;
        String mstartTime;
        String mendTime;
        Date endDateTime;

        //会议时间
        String meetingRoomTime = getTimeSection(startTimes) + "-" + getTimeSection(endTimes);
        meetingInfo = "每周/" + getWeekTime2(weekTime);

        for (int i = weekNum; i <= 4; i++) {
            String date = weekDatetomonthData(month, i, weekTime);
            if (date.compareTo(dateFormat.format(new Date())) >= 0) {
                meetingRelevanceBean.setEmployeeId(employeeId);
                meetingRelevanceBean.setMeetingRoomId(meetingRoomId);

                meetingRelevanceBean.setMeetingRoomTime(meetingRoomTime);
                meetingRelevanceBean.setStartTime(startTimes);
                meetingRelevanceBean.setMeetingTime(dateFormat.parse(date));
                meetingRelevanceBean.setEndTime(endTimes);
                meetingRelevanceBean.setStatus(status);
                meetingRelevanceBean.setMeetingTheme(meetingTheme);
                meetingRelevanceBean.setMeetingRoomName(meetingRoomName);

                if (!BaseHelpUtils.isNullOrZero(meetingStatus)) {
                    meetingRelevanceBean.setMeetingStatus(meetingStatus);
                } else {
                    meetingRelevanceBean.setMeetingStatus(2);
                }

                meetingRelevanceBean.setWeekTime(weekTime);
                meetingRelevanceBean.setMeetingInfo(meetingInfo);
                meetingRelevanceDao.setDataFromBase(meetingRelevanceBean);
                meetingRelevanceDao.save();

                //关联表的id
                meetingRelevanceId = meetingRelevanceDao.getMeetingRelevanceId();

                if (BaseHelpUtils.isNullOrZero(meetingRelevanceId)) {
                    meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                    meetingRelevanceDao.conditionalDelete();
                    return dao.generateBase().toOneLineJSON(-1, "插入会议记录失败");
                }

                for (int j = startTimes; j < endTimes; j++) {
                    time1 = getTimeSection(j);
                    time2 = getTimeSection(j + 1);
                    timeDomain = time1 + "-" + time2;
                    timeZone = getTimeId(timeDomain);
                    mstartTime = date + " " + time1 + ":00";
                    mendTime = date + " " + time2 + ":00";
                    endDateTime = sdf.parse(mendTime);

                    String where = insertVerify(timeZone, mstartTime, mendTime, meeting, timeDomain, meetingRoomId,
                            employeeId, time1, time2, date, mparams, params);

                    if (meeting.countRows(where) > 0) {
                        meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                        meetingRelevanceDao.conditionalDelete();
                        return dao.generateBase().toOneLineJSON(-1, "您选择的时间区间内" + timeDomain +
                                "会议室已被预约了，重新选择一个吧");
                    }

                    long l = currentTime.getTime() - endDateTime.getTime();
                    if (endDateTime.after(currentTime) && l <= 0) {
                        bean.setDataFromMap(mparams);
                        bean.setStatus(status);
                        bean.setRecordDate(new Date());
                        bean.setMeetingTime(dateFormat.parse(date));
                        bean.setMeetingStatus(2);
                        bean.setMeetingRelevanceId(meetingRelevanceId);
                        dao.setDataFromBase(bean);
                        dao.save();
                    }

                    if (endDateTime.before(currentTime) && l > 0) {
                        meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                        meetingRelevanceDao.conditionalDelete();
                    }

                }
            }
        }

        //推送
        String content = "您已预约" + meetingInfo + " " + meetingInfo + " " + meetingRoomName + "的周例会，" +
                "请前往ERP会议预约记录表界面确认会议，超时未确认将自动取消预约";

        ERPWeixinUtils.sendWXMsgToUser(employeeId, content);
        sendNotification(confreeDao, confreeBean, dao, mapList, 2, strDate, meetingRoomTime, meetingRoomName, meetingInfo,meetingTheme);

        return dao.generateBase().toOneLineJSON();
    }


    /**
     * 月例会预约(功能已停用)
     *
     * @param params
     * @return
     */
    private String saveMonthMeeting(Map<String, Object> params) throws Exception {
        BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
        MeetingWithConfree dao = new MeetingWithConfree();
        Map<String, Object> mparams = new HashMap<>(0);
        MeetingRoom mtDao = new MeetingRoom();
        String meetingRoomName = "";
        Integer meetingRoomId;
        int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
        int startTimes = BaseHelpUtils.getIntValue(params.get("wmStartTime"));
        int endTimes = BaseHelpUtils.getIntValue(params.get("wmEndTime"));
        int status = BaseHelpUtils.getIntValue(params.get("status"));
        int howManyWeeks = BaseHelpUtils.getIntValue(params.get("monthDay"));
        int monthTime = BaseHelpUtils.getIntValue(params.get("monthSelect"));

        String meetingTheme;
        Date recordDate = new Date(BaseHelpUtils.getLongValue(params.get("recordDate")));

        try {
            meetingRoomId = BaseHelpUtils.getIntValue(params.get("meetingRoomId"));
        } catch (Exception e) {
            e.printStackTrace();
            return dao.generateBase().toOneLineJSON(-1, "会议室不能为空");
        }

        try {
            meetingTheme = params.get("meetingTheme").toString();
        } catch (Exception e) {
            e.printStackTrace();
            return dao.generateBase().toOneLineJSON(-1, "会议主题不能为空");
        }

        mtDao.setConditionMeetingRoomId("=", meetingRoomId);
        BaseMeetingRoom mtBean = mtDao.executeQueryOneRow();
        if (null != mtBean) {
            meetingRoomName = mtBean.getMeetingRoomName();
        }

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int meetingStatus = BaseHelpUtils.getIntValue(params.get("meetingStatus"));

        Meeting meeting = new Meeting();
        //获取与会成员的数据
        List<Map<String, Object>> mapList = (List<Map<String, Object>>) params.get("detailConfree");
        Confree confreeDao = new Confree();
        BaseConfree confreeBean = new BaseConfree();


        MeetingRelevance meetingRelevanceDao = new MeetingRelevance();
        BaseMeetingRelevance meetingRelevanceBean = new BaseMeetingRelevance();

        meetingRelevanceBean.setEmployeeId(employeeId);
        meetingRelevanceBean.setMeetingRoomId(meetingRoomId);
        meetingRelevanceBean.setMeetingRoomTime(getTimeSection(startTimes) + "-" + getTimeSection(endTimes));
        meetingRelevanceBean.setStartTime(startTimes);
        meetingRelevanceBean.setEndTime(endTimes);
        meetingRelevanceBean.setStatus(status);
        meetingRelevanceBean.setMeetingTheme(meetingTheme);
        meetingRelevanceBean.setMeetingRoomName(meetingRoomName);

        if (!BaseHelpUtils.isNullOrZero(meetingStatus)) {
            meetingRelevanceBean.setMeetingStatus(meetingStatus);
        } else {
            meetingRelevanceBean.setMeetingStatus(3);
        }

        meetingRelevanceBean.setWeekTime(monthTime);
        meetingRelevanceBean.setHowManyWeeks(howManyWeeks);
        meetingRelevanceDao.setDataFromBase(meetingRelevanceBean);
        meetingRelevanceDao.save();

        //关联表的id
        int meetingRelevanceId = meetingRelevanceDao.getMeetingRelevanceId();
        if (BaseHelpUtils.isNullOrZero(meetingRelevanceId)) {
            return dao.generateBase().toOneLineJSON(-1, "插入会议记录失败");
        }
        //循环打印需要插入几条记录到数据库中
        for (int i = month; i <= 12; i++) {
            String date = weekDatetomonthData(i, howManyWeeks, monthTime);
            //for循环获得想预约的会议室时间区间
            for (int j = startTimes; j < endTimes; j++) {
                String time1 = getTimeSection(j);
                String time2 = getTimeSection(j + 1);
                String timeDomain = time1 + "-" + time2;
                int timeZone = getTimeId(timeDomain);
                String startTime = date + " " + time1 + ":00";
                String endTime = date + " " + time2 + ":00";
                String where = insertVerify(timeZone, startTime, endTime, meeting, timeDomain, meetingRoomId, employeeId,
                        time1, time2, date, mparams, params);
                if (meeting.countRows(where) > 0) {
                    meetingRelevanceDao.setConditionMeetingRelevanceId("=", meetingRelevanceId);
                    meetingRelevanceDao.conditionalDelete();
                    return dao.generateBase().toOneLineJSON(-1, "抱歉，您选择的时间区间内" + timeDomain
                            + "会议室已被预约，请换一个时间段预约");
                } else {
                    bean.setDataFromMap(mparams);
                    bean.setStatus(status);
                    bean.setMeetingRelevanceId(meetingRelevanceId);
                    dao.setDataFromBase(bean);
                    dao.save();
                }
            }
        }

        return dao.generateBase().toOneLineJSON();
    }


    /**
     * 插入校验
     *
     * @param meeting
     * @param timeDomain
     * @param meetingRoomId
     * @param employeeId
     * @param time1
     * @param time2
     * @param date
     * @param mparams
     * @param params
     * @return
     * @throws SQLException
     */
    public String insertVerify(int timeZone, String mstartTime, String mendTime, Meeting meeting, String timeDomain,
                               Integer meetingRoomId, Integer employeeId, String time1, String time2, String date,
                               Map<String, Object> mparams, Map<String, Object> params) throws SQLException {

        mparams.put("meetingRoomId", meetingRoomId);
        mparams.put("employeeId", employeeId);
        mparams.put("startTime", mstartTime);
        mparams.put("endTime", mendTime);
        mparams.put("status", 1);
        mparams.put("meetingTheme", params.get("meetingTheme"));
        mparams.put("recordDate", date);
        mparams.put("meetingRoomTimeId", timeZone);
        mparams.put("meetingRoomTime", timeDomain);

        /**
         * 添加一个查询，如果能查出数据表示当前时间段已有预约，否则就可以预约
         */
        String where = "meeting_room_id =" + meetingRoomId +
                " and  status > " + "'" + 0 + "'" +
                " and ((start_time > " + "'" + mstartTime + "'" +
                " and start_time < " + "'" + mendTime + "'" + ")" +
                " or (start_time <= " + "'" + mstartTime + "'" +
                " and end_time >= " + "'" + mendTime + "'" + ")" +
                " or (end_time > " + "'" + mstartTime + "'" +
                " and end_time < " + "'" + mendTime + "'" + "))";

        meeting.conditionalLoad(where);

        return where;
    }


    /**
     * 发送通知和获取与会成员的方法
     * status =1 普通会议   status = 2 周例会      status = 3 更新会议   status = 4 修改会议
     * 再传三个字段过来，时间区间和会议室名称   ，如果是周例会的话加一个每周几
     *
     * @param confreeDao
     * @param confreeBean
     * @param dao
     * @param mapList
     * @param status
     */
    public void sendNotification(Confree confreeDao, BaseConfree confreeBean, MeetingWithConfree dao,
                                 List<Map<String, Object>> mapList, int status, Date meetingTime,
                                 String meetingDomain, String meetingRoomName, String meetingInfo, String meetingTheme)
            throws Exception {
        String content;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(meetingTime);
        if (status == 1) {
             content = "您好,"+date + " " + meetingDomain +" 在 "+meetingRoomName +" 有 "+"< "+ meetingTheme +" >"
                     +" 会议需要您参加，请于会议开始前5分钟至会议室准备，谢谢！";
        } else {
            content = "您好,"+date + " " + meetingDomain +" 在 "+meetingRoomName +" 有 "+"< "+ meetingTheme +" >"
                    +" 周例会需要您参加，请于会议开始前5分钟至会议室准备，谢谢！";
        }
        //插入数据到数据库中
        for (Map<String, Object> map : mapList) {
            confreeBean.setEmployeeId(BaseHelpUtils.getIntValue(map.get("employeeId")));
            confreeBean.setMeetingRelevanceId(dao.getMeetingRelevanceId());
            confreeDao.setDataFromBase(confreeBean);
            confreeDao.save();
            //推送给所有的与会成员
            ERPWeixinUtils.sendWXMsgToUser(BaseHelpUtils.getIntValue(map.get("employeeId")), content);
        }
    }

    /**
     * 根据传入的
     * month 月份
     * weekOfMonth 第几周
     * dayofWeek  周几
     *
     * @param month
     * @param weekOfMonth
     * @param dayOfWeek
     * @return
     */
    public static String weekDatetomonthData(int month, int weekOfMonth, int dayOfWeek) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        //计算出 x年 y月 1号 是星期几
        calendar.set(year, month - 1, 1);

        //如果i_week_day =1 的话 实际上是周日(从周日到周一算一周)
        int i_week_day = calendar.get(Calendar.DAY_OF_WEEK);
        int sumDay;

        //dayOfWeek+1 就是星期几（星期日 为 1）
        if (i_week_day == 1) {
            sumDay = (weekOfMonth - 1) * 7 + dayOfWeek + 1;
        } else {
            sumDay = 7 - i_week_day + 1 + (weekOfMonth - 1) * 7 + dayOfWeek + 1;
        }

        //在1号的基础上加上相应的天数
        calendar.set(Calendar.DATE, sumDay);
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");

        return sf2.format(calendar.getTime());

    }


//    public static void main(String[] args) throws SQLException {
//        Calendar calendar = Calendar.getInstance();
//        //如果是新建周例会
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int weekNum = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
//        for (int i = weekNum; i <= 4; i++) {
//            String date = weekDatetomonthData(month, i, 3);
//            System.out.println("周例会的日期为" + date);
//        }
//        /**
//         * weekOfMonth 每月第几周        dayOfWeek  周几
//         * 默认的每一周的开始时间为周日
//         *
//         */
//        for (int i = month; i <= 12; i++) {
//            String date2 = weekDatetomonthData(i, 2, 3);
//            System.out.println("月例会的日期为" + date2);
//        }
//        Date date = new Date();
//        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
//        String currSun = dateFm.format(date);
//        System.out.println(currSun);
//    }

}
