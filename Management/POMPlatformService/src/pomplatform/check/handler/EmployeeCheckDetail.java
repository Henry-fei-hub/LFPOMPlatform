package pomplatform.check.handler;

import delicacy.common.BaseCollection;
import delicacy.common.GenericProcessor;
import delicacy.date.util.DateUtil;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import pomplatform.check.bean.ConditionSemployeemonthlycheckymor;
import pomplatform.checking.bean.BaseMemployeecheckinouteeseor;
import pomplatform.checking.bean.ConditionMemployeecheckinouteeseor;
import pomplatform.checking.query.QueryMemployeecheckinouteeseor;

/**
 *
 * @author Peter
 */
public class EmployeeCheckDetail implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ConditionSemployeemonthlycheckymor c = new ConditionSemployeemonthlycheckymor();
		c.setDataFromJSON(creteria);
		ConditionMemployeecheckinouteeseor c1 = new ConditionMemployeecheckinouteeseor();
		c1.setEmployeeId(c.getEmployeeId());
		c1.setStartTime(DateUtil.createFirstDayOfMonth(c.getYear(), c.getMonth()));
                Date nextMonth = DateUtil.getFirstDayOfNextMonth(c.getYear(), c.getMonth());
                nextMonth = DateUtil.getNextDayOfDay(nextMonth, -1);
		c1.setEndTime(nextMonth);
		QueryMemployeecheckinouteeseor d = new QueryMemployeecheckinouteeseor();
		BaseCollection<BaseMemployeecheckinouteeseor> res = d.executeQuery(null, c1);
		return res.toJSON();
	}

}
