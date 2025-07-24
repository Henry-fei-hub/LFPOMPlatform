package pomplatform.client.workflow.specialDeduction.handler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.SystemDictionary;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.MapUtils;
import delicacy.connection.ThreadConnection;
import delicacy.connection.ThreadUtil;
import delicacy.system.executor.NewCreateWorkFlow;
import pomplatform.client.workflow.specialDeduction.bean.BaseSpecialDeductionRecordWithS;
import pomplatform.client.workflow.specialDeduction.dao.SpecialDeductionRecordWithS;
import pomplatform.common.utils.StaticUtils;
import pomplatform.project.bean.BaseOnLoadProjectStageSettlement;
import pomplatform.project.bean.ConditionOnLoadProjectStageSettlement;
import pomplatform.project.query.QueryOnLoadProjectStageSettlement;
import pomplatform.stage.bean.BaseProjectWithP;
import pomplatform.stage.dao.ProjectWithP;

/**		
 *
 * @author Peter
 */
public class UpdateSpecialDeductionInformation implements GenericProcessor {
	
	protected BaseSpecialDeductionRecordWithS bean = new BaseSpecialDeductionRecordWithS();

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	bean.setDataFromJSON(creteria);
    	ThreadConnection.beginTransaction();
		NewCreateWorkFlow createWorkFlow = new NewCreateWorkFlow();
		Map<String, Object> map = new HashMap<>();
		Map<String, Integer> processInfoMap = new HashMap<>();
		processInfoMap.put("processId", StaticUtils.PROCESS_ID_195);
		map.put("processDefinition", processInfoMap);
		Map<String, Object> userData = new HashMap<>();
		userData.put("employeId", bean.getEmployeId());
		userData.put("employeeName", bean.getEmployeeName());
		userData.put("plateId", bean.getPlateId());
		userData.put("companyId", bean.getCompanyId());
		userData.put("detailSpecialDeductionDetail", bean.getDetailSpecialDeductionDetail());
		map.put("userData", userData);
		createWorkFlow.execute(MapUtils.toJSON(map), bean.getEmployeId(), true);
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,"");
    }

}
