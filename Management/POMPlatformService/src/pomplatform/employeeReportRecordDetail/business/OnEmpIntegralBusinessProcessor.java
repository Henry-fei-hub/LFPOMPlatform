package pomplatform.employeeReportRecordDetail.business;

import java.io.StringReader;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeIntegralBusines;
import com.pomplatform.db.bean.BaseEmployeeViolationCharge;
import com.pomplatform.db.dao.EmployeeIntegralBusines;
import com.pomplatform.db.dao.EmployeeViolationCharge;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.AccountUtils;

public class OnEmpIntegralBusinessProcessor implements GenericProcessor {
	private static final Logger __LOGGER = Logger.getLogger("");
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			
			if(!BaseHelpUtils.isNullOrEmpty(params) && params.size() > 0){
				int businessTypeId = BaseHelpUtils.getIntValue(params.get("businessTypeId"));
				int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
				int status = BaseHelpUtils.getIntValue(params.get("status"));
				int businessId = BaseHelpUtils.getIntValue(params.get("businessId"));
				
				EmployeeIntegralBusines iDao = new EmployeeIntegralBusines();
				iDao.setConditionBusinessTypeId("=", businessTypeId);
				iDao.setConditionEmployeeId("=", employeeId);
				iDao.setConditionBusinessId("=", businessId);
				BaseEmployeeIntegralBusines iBean = iDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(iBean)){//更新职员积分业务表的status
					iBean.setStatus(status);
					iDao.clear();
					iDao.setDataFromBase(iBean);
					iDao.update();
				}
				
				if(businessTypeId == 11){//11为资源绩效
					EmployeeViolationCharge vDao = new EmployeeViolationCharge();
					vDao.setConditionEmployeeViolationChargesId("=", businessId);
					BaseEmployeeViolationCharge vbean = vDao.executeQueryOneRow();
					if(!BaseHelpUtils.isNullOrEmpty(vbean)){
						vbean.setStatus(status);
						vDao.clear();
						vDao.setDataFromBase(vbean);
						vDao.update();
						if(status == 2){//如果同意，则往个人账户表和部门账户表插入数据
							//入个人账户表
							AccountManageProcess.onSaveEmployeeAccount(employeeId, vbean.getEmployeeViolationChargesId(), AccountManageProcess.EMP_BT_VIOLATION_CHARGES, vbean.getViolationCharges(), vbean.getViolationDate(),vbean.getRemark(),employeeId);
							//入部门账户表
							AccountManageProcess.onSavePlateAccount(vbean.getPlateId(), businessId, AccountManageProcess.PLATE_BT_VIOLATION_CHARGES, vbean.getViolationCharges(), vbean.getViolationDate(), vbean.getRemark(), employeeId);
							//账户系统：借业务部门
							AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, vbean.getPlateId(), AccountUtils.ACCOUNT_BUSSINESS_TYPE_7, businessId, businessId, vbean.getViolationCharges(), true, vbean.getViolationDate(), employeeId, vbean.getRemark());
							//账户系统：贷个人账户
							AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_EMPLOYEE, employeeId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_7, businessId, businessId, vbean.getViolationCharges(), false, vbean.getViolationDate(), employeeId, vbean.getRemark());
						}
					}
				}
				return bc.toJSON();
			}
		}
		return bc.toJSON(-1,"参数不能为空");
	}

}
