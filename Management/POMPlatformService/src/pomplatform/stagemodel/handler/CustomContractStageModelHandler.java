package pomplatform.stagemodel.handler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.pomplatform.db.bean.BaseContractStageModel;
import com.pomplatform.db.dao.ContractStageModel;
import com.pomplatform.db.handler.ContractStageModelHandler;

import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stagemodel.bean.BaseGetContractStageModelByParentId;
import pomplatform.stagemodel.bean.ConditionGetContractStageModelByParentId;
import pomplatform.stagemodel.query.QueryGetContractStageModelByParentId;

public class CustomContractStageModelHandler extends ContractStageModelHandler{

	@Override
	public String delete(String json) throws Exception{
		BaseContractStageModel bean = new BaseContractStageModel();
		bean.setDataFromJSON(json);
		ContractStageModel dao = new ContractStageModel();
		setDeleteConditions(bean, dao);
		List<BaseContractStageModel> list = dao.conditionalLoad();
		ThreadConnection.beginTransaction();
		int num = 0;
		if(null != list && !list.isEmpty()){
			Set<Integer> set = new HashSet<>();
			for(BaseContractStageModel obj : list){
				ConditionGetContractStageModelByParentId condition = new ConditionGetContractStageModelByParentId();
				condition.setContractStageModelId(obj.getContractStageModelId());
				QueryGetContractStageModelByParentId query = new QueryGetContractStageModelByParentId();
				BaseCollection<BaseGetContractStageModelByParentId> collection = query.executeQuery(null, condition);
				if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
					for(BaseGetContractStageModelByParentId tempBean : collection.getCollections()){
						if(null != tempBean.getContractStageModelId()){
							set.add(tempBean.getContractStageModelId());
						}
					}
				}
			}
			if(set.size() > 0){
				dao.clear();
				dao.addCondition(BaseContractStageModel.CS_CONTRACT_STAGE_MODEL_ID, "in", set.toArray());
				num += dao.conditionalDelete();
			}
		}
		num += dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}
}
