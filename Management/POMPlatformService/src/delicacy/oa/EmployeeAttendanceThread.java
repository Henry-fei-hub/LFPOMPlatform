package delicacy.oa;

import java.util.TimerTask;

/**
 *
 * @author Peter
 */
public class EmployeeAttendanceThread extends TimerTask {

    @Override
    public void run() {
        try {
//            ReaderEmployeeCheckin.readCheckData(year, month);
//            ReaderEmployeeCheckin.processCheckData(year, month);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private int year, month;

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

}
