package delicacy.oa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.executor.SystemProcessConstants;

public class CompletePersonnelBusinessTask extends TimerTask {

	private static final Logger __logger = Logger.getLogger(CompletePersonnelBusinessTask.class);

	@Override
	public void run() {
		try {
			Integer[] types = {13,14,15,16,17,31,33,34,35,36};
			SystemProcessInstance dao = new SystemProcessInstance();
			dao.setConditionOtherOperation("=", 0);
			dao.setConditionProcessStatus("=", SystemProcessConstants.PROCESS_STATUS_COMPLETED);
			dao.addCondition(BaseSystemProcessInstance.CS_PROCESS_TYPE, "in", (Object[]) types);
			dao.unsetSelectFlags();
			dao.setSelectBusinessId(true);
			List<BaseSystemProcessInstance> list = dao.conditionalLoad();
			if(null != list && !list.isEmpty()){
				dao.setOtherOperation(1);
				dao.conditionalUpdate();
				Set<Integer> set = new HashSet<>();
				for(BaseSystemProcessInstance obj : list){
					set.add(obj.getBusinessId());
				}
				
				PersonnelBusines businessDao = new PersonnelBusines();
				businessDao.addCondition(BasePersonnelBusines.CS_PERSONNEL_BUSINESS_ID, "in", set.toArray());
				businessDao.setIsCompleted(true);
				businessDao.conditionalUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
