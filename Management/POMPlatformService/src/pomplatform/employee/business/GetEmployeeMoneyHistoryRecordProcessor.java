package pomplatform.employee.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.dao.EmployeeMoneyManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class GetEmployeeMoneyHistoryRecordProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		BaseCollection<BaseEmployeeMoneyManage> bc = new BaseCollection<>();
		if (employeeId >= 0) {
			EmployeeMoneyManage dao = new EmployeeMoneyManage();
			dao.setConditionEmployeeId("=", employeeId);
			//只检索已经完成的数据
			dao.setConditionIsCompleted("=",true);
			List<BaseEmployeeMoneyManage> list = dao
					.conditionalLoad("order by " + BaseEmployeeMoneyManage.CS_EMPLOYEE_MONEY_MANAGE_ID + " desc");
			if (null != list && !list.isEmpty()) {
				for (BaseEmployeeMoneyManage bean : list) {
					if (bean.getFalg() == 2) {
						bean.setBorrowMoney(bean.getReturnMoney().negate());
						bean.setBorrowDate(bean.getReturnDate());
					}
				}
				bc.setCollections(list);
			}
		}
		return bc.toJSON();
	}

}
