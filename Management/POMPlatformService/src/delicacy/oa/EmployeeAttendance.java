package delicacy.oa;

import java.util.Date;

/**
 *
 * @author Peter
 */
public class EmployeeAttendance {
	
	private int __employeeId;
	private Date __checkDate;
	private Date __checkIn;
	private Date __checkOut;

	/**
	 * @return the __employeeId
	 */
	public int getEmployeeId() {
		return __employeeId;
	}

	/**
	 * @param __employeeId the __employeeId to set
	 */
	public void setEmployeeId(int __employeeId) {
		this.__employeeId = __employeeId;
	}

	/**
	 * @return the __checkDate
	 */
	public Date getCheckDate() {
		return __checkDate;
	}

	/**
	 * @param __checkDate the __checkDate to set
	 */
	public void setCheckDate(Date __checkDate) {
		this.__checkDate = __checkDate;
	}

	/**
	 * @return the __checkIn
	 */
	public Date getCheckIn() {
		return __checkIn;
	}

	/**
	 * @param __checkIn the __checkIn to set
	 */
	public void setCheckIn(Date __checkIn) {
		this.__checkIn = __checkIn;
	}

	/**
	 * @return the __checkOut
	 */
	public Date getCheckOut() {
		return __checkOut;
	}

	/**
	 * @param __checkOut the __checkOut to set
	 */
	public void setCheckOut(Date __checkOut) {
		this.__checkOut = __checkOut;
	}
	
}
