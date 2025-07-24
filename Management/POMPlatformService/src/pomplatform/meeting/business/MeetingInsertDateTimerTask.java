package pomplatform.meeting.business;

import com.pomplatform.db.dao.MeetingMonthTime;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimerTask;

/**
 * @author: xiaolong
 * @Date: 2019/9/12 10:56
 * 每到12月份，将下一年的数据插入到数据库中
 */
public class MeetingInsertDateTimerTask extends TimerTask {

    @Override
    public void run() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;

        if (month == 12) {
            year += 1;
        }

        Calendar calendar = new GregorianCalendar();
        Calendar calendarEnd = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        calendarEnd.set(Calendar.YEAR, year);
        calendarEnd.set(Calendar.MONTH, 11);
        calendarEnd.set(Calendar.DAY_OF_MONTH, 31);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;

        try {

            MeetingMonthTime monthtimeDao = new MeetingMonthTime();
            while (calendar.getTime().getTime() <= calendarEnd.getTime().getTime()) {
                date = sf.parse(sf.format(calendar.getTime()));

                System.out.println("time" + sf.format(calendar.getTime()));
                System.out.println("获取到的时间=================" + date);

                monthtimeDao.setMeetingMonthDate(sf.parse(sf.format(calendar.getTime())));
                monthtimeDao.save();

                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException, ParseException {
        MeetingInsertDateTimerTask task = new MeetingInsertDateTimerTask();
        task.run();


//
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        String str = sf.format(new Date());
//        Date date =sf.parse(sf.format(new Date()));
//
//        System.out.println("time" + str);
//        System.out.println("获取到的时间=================" + date);
//
//        MeetingMonthTime monthtimeDao = new MeetingMonthTime();
//
//        BaseMeetingMonthTime base =new BaseMeetingMonthTime();
//
//        base.setTime(new Date());
//        monthtimeDao.setDataFromBase(base);
//        monthtimeDao.save();


    }

}
