package pomplatform.meeting.business;

import com.pomplatform.db.dao.SystemConfig;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import pomplatform.common.utils.StaticUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 会议室预约的方法
 */
public class MeetingRoomProcessor implements GenericProcessor {
    private static final Logger __LOGGER = Logger.getLogger("meetingroomprocessor");

    //设置超时时间
    private static final String MEETING_RECORD_TIME = "settingMeetingRecordTime";

    //设置推送时间
    private static final String GET_MEETING_RECORD_TIME = "getMeetingRecordTime";

    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(creteria);
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "opt_type");
        switch (optType) {
            case MEETING_RECORD_TIME:
                return settingMeetingRecordTime(params);
            case GET_MEETING_RECORD_TIME:
                return getMeetingRecordTime(params);
            default:
                break;
        }
        return null;
    }


    /**
     * 获取超时时间和推送时间
     *
     * @param params
     * @return
     */
    private String getMeetingRecordTime(Map<String, Object> params) throws SQLException {

        BaseCollection<GenericBase> collection = new BaseCollection<>();

        //获取系统配置表里面的超时时间和推送时间
        SystemConfig dao = new SystemConfig();
        dao.setConditionConfigType("=", StaticUtils.CONFIG_TYPE_12);
        return  collection.toJSON(0,"");
    }


    /**
     * 修改超时和推送时间
     *
     * @param params
     * @return
     */
    private String settingMeetingRecordTime(Map<String, Object> params) throws SQLException {
        Map<Integer, Integer> timeMap = new HashMap<>(0);
        timeMap.put(0, 5);
        timeMap.put(1, 10);
        timeMap.put(2, 15);
        BaseCollection<GenericBase> collection = new BaseCollection<>();

        int outtime = Integer.parseInt(params.get("outTime").toString());
        int pushtime = Integer.parseInt(params.get("pushTime").toString());

        //获取系统配置表里面的超时时间和推送时间
        SystemConfig dao = new SystemConfig();
        dao.setConditionConfigType("=", StaticUtils.CONFIG_TYPE_12);
        dao.setCorpId(timeMap.get(outtime).toString());
        //超时时间
        dao.setCorpId(timeMap.get(outtime).toString());
        //推送时间
        dao.setAgentId(timeMap.get(pushtime).toString());
        __LOGGER.info(timeMap.get(outtime).toString() + "超时时间" + timeMap.get(pushtime).toString() + "推送时间");

        dao.conditionalUpdate();
        dao.clear();
        return collection.toJSON(0, "修改成功");
    }

}
