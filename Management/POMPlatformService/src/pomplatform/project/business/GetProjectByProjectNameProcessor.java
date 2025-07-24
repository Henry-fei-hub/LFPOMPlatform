package pomplatform.project.business;

import java.io.StringReader;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.contractstatus.bean.BaseContractStatusMonth;
import pomplatform.workflow.contractstatus.bean.ConditionContractStatusMonth;
import pomplatform.workflow.contractstatus.query.QueryContractStatusMonth;

public class GetProjectByProjectNameProcessor implements GenericProcessor {

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取登录用户ID
		String projectName = BaseHelpUtils.getString(param.get("projectName"));
		BaseCollection<BaseProject> bc = new BaseCollection<>();
		// 处于以下订单状态的订单不能参与报销：订单终止—结算中、订单终止、订单暂停、订单结束
		Object[] projectStatusArr = {StaticUtils.PROJECT_STATUS_14, StaticUtils.PROJECT_STATUS_15,
				StaticUtils.PROJECT_STATUS_10, StaticUtils.PROJECT_STATUS_11};
		//落标超过3个月的订单不能参与报销
		ConditionContractStatusMonth condition = new ConditionContractStatusMonth();
		condition.setNewStatus(StaticUtils.CONTRACT_STATUS_2);
		condition.setContractMonth(3);
		QueryContractStatusMonth query = new QueryContractStatusMonth();
		BaseCollection<BaseContractStatusMonth> collection = query.executeQuery(null, condition);
		Set<Integer> contractIds = null;
		if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()) {
			contractIds = new HashSet<>();
			for(BaseContractStatusMonth obj : collection.getCollections()) {
				contractIds.add(obj.getContractId());
			}
		}
		Project dao = new Project();
		dao.unsetSelectFlags();
		dao.setSelectProjectId(true);
		dao.setSelectProjectName(true);
		dao.setSelectContractCode(true);
		dao.setSelectPlateId(true);
		dao.setConditionPlateId(">", 0);
		// 有关键字就根据关键字搜索，没有关键字，就查出所有项目
		if (!BaseHelpUtils.isNullOrEmpty(projectName)) {
			dao.setConditionProjectName("like", "%" + projectName + "%");
		}
		dao.addCondition(BaseProject.CS_STATUS, "not in", projectStatusArr);
		dao.addCondition(BaseProject.CS_STATUS, "not in", projectStatusArr);
		if(null != contractIds) {
			dao.addCondition(BaseProject.CS_CONTRACT_ID, "not in", contractIds.toArray());
		}
		List<BaseProject> list = dao.conditionalLoad();
		if (null == list || list.isEmpty()) {
			return bc.toJSON(-1, null);
		} else {
			for (BaseProject bean : list) {
				StringBuilder sb = new StringBuilder();
				if (!BaseHelpUtils.isNullOrEmpty(bean.getContractCode())) {
					sb.append(bean.getContractCode()).append("--");
				}
				sb.append(bean.getProjectName()).append("--");
				if (!BaseHelpUtils.isNullOrEmpty(bean.getPlateId())) {
					sb.append(bean.getPlateId());
				}
				bean.setProjectName(sb.toString());
			}
		}
		bc.setCollections(list);
		return bc.toJSON();
	}
}