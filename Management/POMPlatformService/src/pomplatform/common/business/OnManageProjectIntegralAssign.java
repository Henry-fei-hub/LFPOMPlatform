package pomplatform.common.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseManageProjectEmployeeRecord;
import com.pomplatform.db.dao.ManageProject;
import com.pomplatform.db.dao.ManageProjectEmployeeRecord;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.account.business.AccountManageProcess;

/**
 * 部门积分发放处理
 * 
 * @author lxf
 */
public class OnManageProjectIntegralAssign implements GenericProcessor {
	private static final Logger __logger = Logger.getLogger("");

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取管理项目ID
		int manageProjectId = BaseHelpUtils.getIntValue(param.get("manageProjectId"));
		//获取管理项目的剩余积分
		BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(param.get("leftIntegral"));
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		BaseManageProjectEmployeeRecord bean;
		// 获取到职员发放的grid数据
		List<BaseManageProjectEmployeeRecord> resultList = GenericBase.__getList(param.get("employeeAssign"),BaseManageProjectEmployeeRecord.newInstance());
		if (!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()) {
			//更新管理项目的剩余积分
			ManageProject manageProjectDao = new ManageProject();
			manageProjectDao.setManageProjectId(manageProjectId);
			manageProjectDao.load();
			manageProjectDao.setLeftIntegral(leftIntegral);
			manageProjectDao.update();
			int plateId = manageProjectDao.getPlateId();
			for (BaseManageProjectEmployeeRecord e : resultList) {
				BigDecimal assignIntegral = BaseHelpUtils.getBigDecimalValue(e.getAssignIntegral());
				if(assignIntegral.compareTo(BigDecimal.ZERO) == 0){
					continue;
				}
				//获取人员id
				int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
				bean = new BaseManageProjectEmployeeRecord();
				bean.setDataFromJSON(creteria);
				bean.setEmployeeId(employeeId);
				bean.setAssignedIntegral(assignIntegral);
				bean.setAssignIntegral(BigDecimal.ZERO);
				dao.clear();
				dao.setDataFromBase(bean);
				dao.save();
				//获取主键ID，即业务ID
				int businessId = dao.getManageProjectEmployeeRecordId();
				//获取日期
				Date recordDate = bean.getAssignDate();
				//奖金补贴插入个人账户表
				AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_BONUS_SUBSIDY, assignIntegral, recordDate,bean.getRemark(), bean.getOperateEmployeeId());
				//奖金补贴插入部門账户表
				AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_BONUS_SUBSIDY, assignIntegral, recordDate, bean.getRemark(), bean.getOperateEmployeeId());
			}
		}
		ThreadConnection.commit();
		return dao.generateBase().toOneLineJSON(0, null);
	}

}
