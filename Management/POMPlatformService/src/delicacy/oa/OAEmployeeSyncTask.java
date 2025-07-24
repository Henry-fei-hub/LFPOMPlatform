package delicacy.oa;

import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 *
 * @author Peter
 */
public class OAEmployeeSyncTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OAEmployeeSyncTask.class);

    @Override
    public void run() {
        __logger.debug("开始同步员工数据");
//        OAEmployeeSync.syncUpdateEmployeeFromOA();
        
//        int year = DateUtil.getYear(), month = DateUtil.getMonth();
//        int day = DateUtil.getDay();
//        if (day == 1) {
//            month--;
//            if (month < 1) {
//                month = 12;
//                year--;
//            }
//        }
//        
//        __logger.debug("开始同步考勤数据");
//        try {
//            ReaderEmployeeCheckin.readCheckData(year, month);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        
//        __logger.debug("开始计算考勤数据");
//        try {
//            ReaderEmployeeCheckin.processCheckData(year, month);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

}
