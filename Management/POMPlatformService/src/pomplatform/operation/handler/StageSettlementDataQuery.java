package pomplatform.operation.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.dao.ProjectCost;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.project.bean.BaseOnLoadProjectStageSettlement;
import pomplatform.project.bean.ConditionOnLoadProjectStageSettlement;
import pomplatform.project.query.QueryOnLoadProjectStageSettlement;
import pomplatform.stagesettlement.bean.BaseMprojectstageppsspor;
import pomplatform.stagesettlement.bean.ConditionMprojectstageppsspor;
import pomplatform.stagesettlement.query.QueryMprojectstageppsspor;

/**
 *
 * @author guanxgun
 */
public class StageSettlementDataQuery implements GenericProcessor {
    
    public static void main(String[] args){
        try{
            StageSettlementDataQuery p = new StageSettlementDataQuery();
            String ss = p.execute("{\"projectId\": 3354}", null);
            System.out.println("ssss=="+ss);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
    	@SuppressWarnings("rawtypes")
 		JSON parser = new JSON(new StringReader(creteria));
    	@SuppressWarnings("unchecked")
 		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
    	//获取项目ID
    	int projectId = BaseHelpUtils.getIntValue(param, "projectId");
        QueryMprojectstageppsspor qdao = new QueryMprojectstageppsspor();
        ConditionMprojectstageppsspor cmp = new ConditionMprojectstageppsspor();
        BaseCollection<BaseMprojectstageppsspor> qs = new BaseCollection<>();
        boolean found = false;
    	/*
		 * 获取该项目是否有结算，只要有结算记录说明就是有进行结算
		 * 如果有结算，则检索该项目已经结算到哪个阶段
		 */
		ConditionOnLoadProjectStageSettlement condition = new ConditionOnLoadProjectStageSettlement();
		condition.setProjectId(projectId);
		QueryOnLoadProjectStageSettlement dao = new QueryOnLoadProjectStageSettlement();
		BaseCollection<BaseOnLoadProjectStageSettlement> result = dao.executeQuery(null, condition);
		//设置返回状态值为-1
		int status = -1;
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			List<BaseOnLoadProjectStageSettlement> list = result.getCollections();
			int size = list.size();
			//设置当前可结算阶段为0
			int currentStageId = 0;
			if(!BaseHelpUtils.isNullOrEmpty(list) && size > 0){
				for(BaseOnLoadProjectStageSettlement e : list){
					size--;
					//获取确认函数
					int attachmentNum = BaseHelpUtils.getIntValue(e.getAttachmentNum());
					//获取当前阶段ID
					int stageId = BaseHelpUtils.getIntValue(e.getStageId());
					if(attachmentNum > 0){//说明已经上传了确认函，则说明该阶段已过
						if(size == 0){//说明已经该订单已经竣工
							currentStageId = stageId;
							//如果竣工了，则检索是否有项目成本，如果有项目成本，则需要结算
							ProjectCost projectCostDao = new ProjectCost();
					        projectCostDao.setConditionProjectId("=",projectId);
					        projectCostDao.setConditionStatus("=",0);//检索未结算的项目成本
					        List<BaseProjectCost> projectCostList = projectCostDao.conditionalLoad();
					        if(!BaseHelpUtils.isNullOrEmpty(projectCostList) && projectCostList.size() > 0){
					        	found = true;
					        	status = 0;
					        }
						}
					}else{//说明该阶段未结算完
						currentStageId = stageId;
						found = true;
						//判断当前阶段已确认积分和阶段积分是否相等，如果相等，则说明阶段积分已确认完毕，需提示上传确认函
						BigDecimal projectAmount = e.getProjectAmount()==null?BigDecimal.ZERO:e.getProjectAmount().divide(BigDecimal.ONE, 2,BigDecimal.ROUND_HALF_UP);
						BigDecimal settlementIntegral = e.getSettlementIntegral()==null?BigDecimal.ZERO:e.getSettlementIntegral().divide(BigDecimal.ONE, 2,BigDecimal.ROUND_HALF_UP);
						if(projectAmount.compareTo(settlementIntegral) == 0){
							status = 2;
						}else{
							status = 0;
						}
						break;
					}
				}
				//如果为true，则返回数据集
				if(found){
					cmp.setProjectId(projectId);
					cmp.setStageId(currentStageId);
	        		qs = qdao.executeQuery(null, cmp);
	        		return qs.toJSON(status, "");
				}else{
					return qs.toJSON(status, "无需结算");
				}
				
			}else{
				return qs.toJSON(status, "该项目未设定项目阶段,不可进行积分结算操作");
			}
		}else{
			return qs.toJSON(status, "该项目未设定项目阶段,不可进行积分结算操作");
		}
        
    }

}
