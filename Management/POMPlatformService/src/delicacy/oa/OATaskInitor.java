package delicacy.oa;

import java.util.Date;
import java.util.Timer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import delicacy.date.util.DateUtil;

/**
 *
 * @author Peter
 */
@WebServlet(name = "OATaskInitor", loadOnStartup = 1, urlPatterns = {"/OATaskInitor"})
public class OATaskInitor extends HttpServlet {

    private static final Logger __logger = Logger.getLogger(OATaskInitor.class);

    Timer timer;

    @Override
    public void init() {
        timer = new Timer("OAEMPLOYEE");
        Date timeToRun = DateUtil.getNextFixedHourDate(1);
        __logger.debug(String.format("距离OA同步程序运行还有:%1$s", DateUtil.generateStringTimeBetween(timeToRun, new Date())));
//        timer.schedule(new OAEmployeeSyncTask(), timeToRun, 86400000L);
    }

    @Override
    public void destroy() {
        timer.cancel();
    }

}
