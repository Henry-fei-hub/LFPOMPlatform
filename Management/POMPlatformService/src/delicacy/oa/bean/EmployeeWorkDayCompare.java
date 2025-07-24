package delicacy.oa.bean;

import java.util.Comparator;

public class EmployeeWorkDayCompare extends BaseMemployeeworkor implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		BaseMemployeeworkor bo1 = (BaseMemployeeworkor) o1;
		BaseMemployeeworkor bo2 = (BaseMemployeeworkor) o2;
		return bo2.getOndate().compareTo(bo1.getOndate());
	}

}
