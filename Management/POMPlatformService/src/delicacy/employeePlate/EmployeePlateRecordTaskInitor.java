package delicacy.employeePlate;

import java.util.Date;
import java.util.Timer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import delicacy.date.util.DateUtil;

@WebServlet(name = "EmployeePlateRecordTaskInitor", loadOnStartup = 1, urlPatterns = {"/EmployeePlateRecordTaskInitor"})
public class EmployeePlateRecordTaskInitor extends HttpServlet {

    Timer timer;

    @Override
    public void init() {
        timer = new Timer("EMPLOYEEPLATERECORD");
        Date timeToRun = DateUtil.getFirstDayOfNextMonth(new Date());
        timer.schedule(new EmployeePlateRecordSyncTask(), timeToRun, 86400000L);
        timer.schedule(new ExchangeRateTask(), timeToRun, 86400000L);
    }

    @Override
    public void destroy() {
        timer.cancel();
    }

}
