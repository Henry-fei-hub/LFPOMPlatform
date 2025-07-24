package pomplatform.check.handler;

import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import delicacy.oa.EmployeeAttendanceThread;
import delicacy.oa.ReaderEmployeeCheckin;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import pomplatform.check.bean.ConditionSemployeemonthlycheckymor;

/**
 *
 * @author guanxgun
 */
public class RecalculateCheckingData implements GenericProcessor {

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ConditionSemployeemonthlycheckymor c = new ConditionSemployeemonthlycheckymor();
        c.setDataFromJSON(creteria);
        if(c.getYear() == null){
            throw new SQLException("年份为空");
        }
        if(c.getMonth() == null){
            throw new SQLException("月份为空");
        }
//        EmployeeAttendanceThread task = new EmployeeAttendanceThread();
//        task.setMonth(c.getMonth());
//        task.setYear(c.getYear());
//        Thread t = new Thread(task);
//        t.start();
        try {
//            ReaderEmployeeCheckin.readCheckData(c.getYear(), c.getMonth());
//            ReaderEmployeeCheckin.processCheckData(c.getYear(), c.getMonth());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        BaseCollection bc = new BaseCollection();
        return bc.toJSON();
    }

}
