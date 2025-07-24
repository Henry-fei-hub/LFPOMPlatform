package pomplatform.project.business;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseSubjectDepartment;
import com.pomplatform.db.bean.BaseSubjectProcessType;
import com.pomplatform.db.bean.BaseSubjectType;
import com.pomplatform.db.dao.SubjectDepartment;
import com.pomplatform.db.dao.SubjectProcessType;
import com.pomplatform.db.dao.SubjectType;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.SystemProcess;

public class GetSubTypeByProcessAndDepartmentProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取登录用户ID
		Integer processId = BaseHelpUtils.getIntValue(param.get("processId"));
		Integer departmentId = BaseHelpUtils.getIntValue(param.get("departmentId"));
		BaseCollection<BaseSubjectType> bc = new BaseCollection<>();
		if(!BaseHelpUtils.isNullOrZero(processId)&&!BaseHelpUtils.isNullOrZero(departmentId)){
			SystemProcess processDao = new SystemProcess();
			processDao.unsetSelectFlags();
			processDao.setSelectProcessTypeId(true);
			processDao.setProcessId(processId);
			if(processDao.load()&&!BaseHelpUtils.isNullOrZero(processDao.getProcessTypeId())){
				int typeId = processDao.getProcessTypeId();
				SubjectProcessType subjectProcessTypeDao = new SubjectProcessType();
				subjectProcessTypeDao.setConditionProcessTypeId("=", typeId);
				List<BaseSubjectProcessType> subjectProcessTypeList = subjectProcessTypeDao.conditionalLoad();
				if(null != subjectProcessTypeList && !subjectProcessTypeList.isEmpty()){
					int size = subjectProcessTypeList.size();
					Object[] tempIds = new Object[size];
					for(int i = 0; i < size; i++){
						tempIds[i] = subjectProcessTypeList.get(i).getSubjectTypeId();
					}
					SubjectDepartment subjectDepartmentDao = new SubjectDepartment();
					subjectDepartmentDao.setConditionDepartmentId("=", departmentId);
					subjectDepartmentDao.addCondition(BaseSubjectDepartment.CS_SUBJECT_TYPE_ID, "in", tempIds);
					List<BaseSubjectDepartment> subjectDepartmentList = subjectDepartmentDao.conditionalLoad();
					if(null != subjectDepartmentList && !subjectDepartmentList.isEmpty()){
						size = subjectDepartmentList.size();
						Object[] arr = new Object[size];
						for(int i = 0; i< size;i++){
							arr[i] = subjectDepartmentList.get(i).getSubjectTypeId();
						}
						SubjectType dao = new SubjectType();
						dao.addCondition(BaseSubjectType.CS_SUBJECT_TYPE_ID, "in", arr);
						dao.setConditionIsEnabled("=", true);
						List<BaseSubjectType> list = dao.conditionalLoad();
						bc.setCollections(list);
					}
				}
			}
		}
		return bc.toJSON();
	}
}