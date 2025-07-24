package pomplatform.hr.business;

import java.io.StringReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeContractAttachment;
import com.pomplatform.db.dao.EmployeeContractAttachment;

import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;

/**
 * 员工合同管理
 * @author lqw
 */
public class OnEmployeeContractAttachment implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

	@Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		int operateEmployeeId = BaseHelpUtils.getIntValue("operateEmployeeId");
//		int signType = BaseHelpUtils.getIntValue(param.get("signType"));
		
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		BaseEmployeeContractAttachment bean = new BaseEmployeeContractAttachment();
		bean.setDataFromMap(param);
		int employeeContractAttachmentId = BaseHelpUtils.getIntValue(param.get("employeeContractAttachmentId"));
		dao.setEmployeeContractAttachmentId(employeeContractAttachmentId);
		boolean updateEmployeeInfo = false;
		if(dao.load()){//如果不为空，则更新数据
			dao.setDataFromBase(bean);
			dao.setOperateEmployeeId(operateEmployeeId);
			dao.setOperateTime(new Date());
			ColumnChangedData startDateChanged = dao.getColumnChangedData(BaseEmployeeContractAttachment.CS_START_DATE);
			ColumnChangedData endDateChanged = dao.getColumnChangedData(BaseEmployeeContractAttachment.CS_END_DATE);
			ColumnChangedData urlChangedData = dao.getColumnChangedData(BaseEmployeeContractAttachment.CS_ATTACHMENT_URL);
			dao.update(); 
			if(null != urlChangedData || null != startDateChanged || null != endDateChanged) {
				updateEmployeeInfo = true;
			}
		}else{
			updateEmployeeInfo = true;
			dao.clear();
			dao.setDataFromBase(bean);
			dao.setEmployeeId(employeeId);
			dao.setOperateEmployeeId(operateEmployeeId);
			dao.setOperateTime(new Date());
			dao.save();
		}
		if(updateEmployeeInfo) {
			dao.clear();
			dao.setConditionEmployeeId("=", employeeId);
			//0未到期，1即将到期
			Integer[] willEnd = {0,1};
			dao.addCondition(BaseEmployeeContractAttachment.CS_WILL_END, "in", (Object[])willEnd);
			List<BaseEmployeeContractAttachment> list = dao.conditionalLoad("order by " + BaseEmployeeContractAttachment.CS_WILL_END + ", " + BaseEmployeeContractAttachment.CS_END_DATE + " desc");
			if(null != list && !list.isEmpty()) {
				BaseEmployeeContractAttachment newestAttachment = list.get(0);
				Employee eDao = new Employee();
				eDao.setEmployeeId(employeeId);
				if(eDao.load()) {
					eDao.setContractEndDate(newestAttachment.getEndDate());
					eDao.setLaborAttachmentId(newestAttachment.getAttachmentId());
					eDao.setLaborAttachments(newestAttachment.getAttachmentUrl());
					eDao.update();
				}
			}
		}
        ThreadConnection.commit();
        return null;
    }

}
