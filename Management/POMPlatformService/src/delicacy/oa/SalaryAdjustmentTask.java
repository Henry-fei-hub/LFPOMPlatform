package delicacy.oa;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import pomplatform.payment.bean.BaseOnLoadEmployeePayment;
import pomplatform.payment.bean.ConditionOnLoadEmployeePayment;
import pomplatform.payment.query.QueryOnLoadEmployeePayment;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinessSalary;
import pomplatform.workflow.personnelbusiness.bean.ConditionPersonnelBusinessSalary;
import pomplatform.workflow.personnelbusiness.query.QueryPersonnelBusinessSalary;

public class SalaryAdjustmentTask extends TimerTask {

	private static final Logger __logger = Logger.getLogger(SalaryAdjustmentTask.class);

	@Override
	public void run() {
		try {
			Date date = new Date();
			//查找员工调薪已完成但尚未修改薪资信息的记录
			ConditionPersonnelBusinessSalary condition = new ConditionPersonnelBusinessSalary();
			condition.setEndDate(date);
			QueryPersonnelBusinessSalary query = new QueryPersonnelBusinessSalary();
			BaseCollection<BasePersonnelBusinessSalary> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()){
				List<BasePersonnelBusinessSalary> list = bc.getCollections();
				for(BasePersonnelBusinessSalary obj : list){
					Integer employeeId = obj.getEmployeeId();
					ConditionOnLoadEmployeePayment salaryCondition = new ConditionOnLoadEmployeePayment();
					salaryCondition.setEmployeeId(employeeId);
					QueryOnLoadEmployeePayment salaryQuery = new QueryOnLoadEmployeePayment();
					BaseCollection<BaseOnLoadEmployeePayment> salaryCollection = salaryQuery.executeQuery(null, salaryCondition);
					if(null != salaryCollection && null != salaryCollection.getCollections() && !salaryCollection.getCollections().isEmpty()){
						PersonnelBusines pb = new PersonnelBusines();
						pb.setPersonnelBusinessId(obj.getPersonnelBusinessId());
						if(pb.load()){
							pb.setIsCompleted(true);
							pb.update();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
