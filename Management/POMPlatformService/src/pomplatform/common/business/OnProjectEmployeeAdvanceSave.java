package pomplatform.common.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAdvanceRecord;
import com.pomplatform.db.dao.ProjectEmployeeAdvanceRecord;

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
public class OnProjectEmployeeAdvanceSave implements GenericProcessor {
	private static final Logger __logger = Logger.getLogger("");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取补贴项目ID
		int projectId = BaseHelpUtils.getIntValue(param,"projectId");
		//获取当前操作人ID
		int operateEmployeeId = BaseHelpUtils.getIntValue(param,"operateEmployeeId"); 
		//设置补贴日期为当前系统操作日期
        Date advanceDate = new Date();
        //获取备注
        String remark = BaseHelpUtils.getStringValue(param,"remark");
        
        ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		BaseProjectEmployeeAdvanceRecord bean;
		// 获取到职员发放的grid数据
		List<BaseProjectEmployeeAdvanceRecord> resultList = GenericBase.__getList(param.get("projectEmployeeAdvance"),BaseProjectEmployeeAdvanceRecord.newInstance());
		if (!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()) {
			
			//同时更新人员汇总表中当前部门在当前月的所有人员的价值积分=0
			BigDecimal advanceIntegralTotal = BigDecimal.ZERO;
			Project projectDao = new Project();
			for (BaseProjectEmployeeAdvanceRecord e : resultList) {
				//获取补贴人员ID
				int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
				//获取当次补贴的积分
				BigDecimal advanceIntegral = BaseHelpUtils.getBigDecimalValue(e.getAdvanceIntegral());
				if(advanceIntegral.compareTo(BigDecimal.ZERO) > 0){
					projectDao.clear();
					projectDao.setProjectId(projectId);
					advanceIntegralTotal = advanceIntegralTotal.add(advanceIntegral);
					bean = new BaseProjectEmployeeAdvanceRecord();
					bean.setProjectId(projectId);
					bean.setEmployeeId(employeeId);
					bean.setAdvanceIntegral(BigDecimal.ZERO);
					bean.setAdvancedIntegral(advanceIntegral);
					bean.setAdvanceDate(advanceDate);
					bean.setOperateEmployeeId(operateEmployeeId);
					bean.setRemark(remark);
					dao.clear();
					dao.setDataFromBase(bean);
					dao.save();
					//获取主键ID，即业务ID
					int businessId = dao.getProjectEmployeeAdvanceRecordId();
					//项目补贴插入个人账户表
					AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_PROJECT_SUBSIDY, advanceIntegral, advanceDate,remark,operateEmployeeId);
				}
			}
			//更新项目补贴记录表
			if(advanceIntegralTotal.compareTo(BigDecimal.ZERO)>0){
				ProjectAdvanceRecord projectAdvanceRecordDao = new ProjectAdvanceRecord();
				projectAdvanceRecordDao.setConditionProjectId("=",projectId);
				projectAdvanceRecordDao.setConditionLeftIntegral(">",BigDecimal.ZERO);
				List<BaseProjectAdvanceRecord> projectAdvanceRecordList = projectAdvanceRecordDao.conditionalLoad("order by "+BaseProjectAdvanceRecord.CS_ADVANCE_DATE+" desc");
				if(!BaseHelpUtils.isNullOrEmpty(projectAdvanceRecordList) && !projectAdvanceRecordList.isEmpty()){
					for(BaseProjectAdvanceRecord e : projectAdvanceRecordList){
						int projectAdvanceRecordId = BaseHelpUtils.getIntValue(e.getProjectAdvanceRecordId());
						projectAdvanceRecordDao.clear();
						projectAdvanceRecordDao.setProjectAdvanceRecordId(projectAdvanceRecordId);
						projectAdvanceRecordDao.load();
						//获取剩余积分
						BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(e.getLeftIntegral());
						if(leftIntegral.compareTo(advanceIntegralTotal) >= 0){
							projectAdvanceRecordDao.setLeftIntegral(leftIntegral.subtract(advanceIntegralTotal));
							projectAdvanceRecordDao.update();
							break;
						}else{
							projectAdvanceRecordDao.setLeftIntegral(BigDecimal.ZERO);
							advanceIntegralTotal = advanceIntegralTotal.subtract(leftIntegral);
							projectAdvanceRecordDao.update();
						}
					}
				}
			}
		}
		ThreadConnection.commit();
		return dao.generateBase().toOneLineJSON(0, null);
	}
	
}
