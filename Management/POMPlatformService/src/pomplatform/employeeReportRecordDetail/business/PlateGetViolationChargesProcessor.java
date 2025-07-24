package pomplatform.employeeReportRecordDetail.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeViolationCharge;
import com.pomplatform.db.dao.EmployeeIntegralBusines;
import com.pomplatform.db.dao.EmployeeViolationCharge;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;

public class PlateGetViolationChargesProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			Date violationDate =  new Date();
			String remark = BaseHelpUtils.getString(params.get("remark"));
			int plateId = BaseHelpUtils.getIntValue(params.get("plateId"));
			int operator = BaseHelpUtils.getIntValue(params.get("operator"));
			Date date = new Date();
			List<BaseEmployeeViolationCharge> tempList = GenericBase.__getList(
					params.get("violationList"), BaseEmployeeViolationCharge.newInstance());
			if(null != tempList && !tempList.isEmpty()){
				EmployeeViolationCharge dao = new EmployeeViolationCharge();
				EmployeeIntegralBusines iDao = new EmployeeIntegralBusines();
				for(BaseEmployeeViolationCharge obj : tempList){
					//只保存项目违规金不为0的数据
					if(obj.getViolationCharges().compareTo(BigDecimal.ZERO) != 0){
						obj.setPlateId(plateId);
						obj.setRemark(remark);
						obj.setViolationDate(violationDate);
						obj.setOperator(operator);
						obj.setOperateTime(date);
						obj.setStatus(1);//待处理
						dao.clear();
						dao.setDataFromBase(obj);
						dao.save();
						
						int businessId = dao.getEmployeeViolationChargesId();
						int employeeId = obj.getEmployeeId();
						BigDecimal integral = obj.getViolationCharges();
						
						//保存至职员积分业务功能表
						iDao.clear();
						iDao.setEmployeeId(employeeId);
						iDao.setBusinessTypeId(11);
						iDao.setBusinessTypeName("资源绩效");
						iDao.setIntegral(integral);
						iDao.setRecordDate(violationDate);
						iDao.setStatus(1);
						iDao.setOperateTime(date);
						iDao.setOperateEmployeeId(operator);
						iDao.setRemark(remark);
						iDao.setBusinessId(businessId);
						iDao.save();
						
						String str = String.format(WeixinStatics.MSG_EMPLOYEE_VIOLATION_CHARGES);
						ERPWeixinUtils.sendWXMsgToUser(employeeId, str);
						//项目违约金入个人账户表
//						AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_VIOLATION_CHARGES, integral, violationDate,remark,operator);
						//项目违约金入部门账户表
//						AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_VIOLATION_CHARGES, integral, violationDate, remark, operator);
					}
				}
				return bc.toJSON();
			}
		}
		return bc.toJSON(-1,"参数不能为空");
	}

}
