package delicacy.oa;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeePayment;
import com.pomplatform.db.dao.EmployeePayment;

import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.personnelbusiness.bean.BaseRegularEmployeeInfo;
import pomplatform.personnelbusiness.bean.ConditionRegularEmployeeInfo;
import pomplatform.personnelbusiness.query.QueryRegularEmployeeInfo;

public class RegularEmployeeTask extends TimerTask {

	private static final Logger __logger = Logger.getLogger(RegularEmployeeTask.class);

	@Override
	public void run() {
		try {
			Date date = new Date();
			//员工转正处理
			ConditionRegularEmployeeInfo condition = new ConditionRegularEmployeeInfo();
			condition.setEndDate(date);
			QueryRegularEmployeeInfo query = new QueryRegularEmployeeInfo();
			BaseCollection<BaseRegularEmployeeInfo> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()){
				List<BaseRegularEmployeeInfo> list = bc.getCollections();
				for(BaseRegularEmployeeInfo obj : list){
					Employee e = new Employee();
					Integer employeeId = obj.getEmployeeId();
					e.setEmployeeId(employeeId);
					if(e.load()){
						try {
							ThreadConnection.beginTransaction();
							//修改职员表的状态
							e.setOnboardStatus(StaticUtils.ONBOARD_STATUS_2);
							e.setPositiveDate(obj.getEndDate());
							e.update();
							//往薪资表中插入一条转正后薪资的数据，同时将该员工的其他薪资记录都设置为false
							EmployeePayment employeePaymentDao = new EmployeePayment();
							employeePaymentDao.setConditionEmployeeId("=", employeeId);
							employeePaymentDao.setEnabled(false);
							employeePaymentDao.conditionalUpdate();
							employeePaymentDao.clear();
							BaseEmployeePayment bean = new BaseEmployeePayment();
							bean.setDataFromJSON(obj.toJSON());
							bean.setChangeDate(obj.getEndDate());
							bean.setEnabled(true);
							bean.setPaymentChangeType(StaticUtils.PAYMENT_CHANGE_TYPE_2);
							employeePaymentDao.setDataFromBase(bean);
							employeePaymentDao.save();
							ThreadConnection.commit();
						}catch(Exception e1) {
							e1.printStackTrace();
							ThreadConnection.rollback();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
