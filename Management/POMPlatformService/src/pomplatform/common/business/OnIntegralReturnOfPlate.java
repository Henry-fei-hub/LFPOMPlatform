package pomplatform.common.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord;
import com.pomplatform.db.dao.EmployeeSalaryReturnRecord;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.IntegralReturnOfPlate.bean.BaseIntegralReturnOfPlate;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.AccountUtils;

/**
 * 部门积分还款处理
 * 
 * @author 
 */
public class OnIntegralReturnOfPlate implements GenericProcessor {
	private static final Logger __logger = Logger.getLogger("");

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取业务部门id
		int plateId = BaseHelpUtils.getIntValue(param,"plateId");
		//获取检索年月份
        Date recordDate = new Date();
        //设置日期的第一天的日期
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		BaseEmployeeSalaryReturnRecord bean;
		// 获取到职员发放的grid数据
		List<BaseIntegralReturnOfPlate> resultList = GenericBase.__getList(param.get("integralReturnOfPlate"),BaseIntegralReturnOfPlate.newInstance());
		if (!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()) {
		
			for (BaseIntegralReturnOfPlate e : resultList) {
				//该人员的价值积分
				BigDecimal salaryHave = new BigDecimal(BaseHelpUtils.getString(e.getAchieveintegral()));
				//该人员的欠款积分
				BigDecimal salaryReturn = new BigDecimal(BaseHelpUtils.getString(e.getIntegralreturnofplate()));
				int i = salaryHave.compareTo(BigDecimal.ZERO);
				if(i<=0){
					continue;
				}else if(salaryHave.compareTo(salaryReturn)< 0){
					salaryReturn = salaryHave;
				}
				
				int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
				//插入积分还款表
				bean = new BaseEmployeeSalaryReturnRecord();
				bean.setPlateId(plateId);
				bean.setEmployeeId(employeeId);
				bean.setEmployeeName(BaseHelpUtils.getString(e.getEmployeeName()));
				bean.setEmployeeNo(BaseHelpUtils.getString(e.getEmployeeNo()));
				bean.setSalaryReturn(salaryReturn);
				bean.setRecordDate(recordDate);
				dao.clear();
				dao.setDataFromBase(bean);
				dao.save();
				//插入个人账户表
				//获取主键ID，即业务ID
				int businessId = dao.getEmployeeSalaryReturnRecordId();
				//操作人
				int operator = BaseHelpUtils.getIntValue(param, "operator");
				//积分还款插入个人账户表
				AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_SALAEY_REFUND, salaryReturn, recordDate, "", operator);
				//积分还款插入部门账户表
				AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_SALAEY_REFUND, salaryReturn, recordDate, "", operator);
				//账户系统：借业务部门
				AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_32, businessId, businessId, salaryReturn, true, recordDate, operator, "");
				//账户系统：贷个人账户
				AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_EMPLOYEE, employeeId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_32, businessId, businessId, salaryReturn, false, recordDate, operator, "");
			}
		}
		ThreadConnection.commit();
		return dao.generateBase().toOneLineJSON(0, null);
	}
	
}
