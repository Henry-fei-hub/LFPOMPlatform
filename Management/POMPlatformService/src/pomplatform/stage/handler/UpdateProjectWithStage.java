package pomplatform.stage.handler;

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
import delicacy.common.GenericProcessor;
import pomplatform.project.bean.BaseOnLoadProjectStageSettlement;
import pomplatform.project.bean.ConditionOnLoadProjectStageSettlement;
import pomplatform.project.query.QueryOnLoadProjectStageSettlement;
import pomplatform.stage.bean.BaseProjectWithP;
import pomplatform.stage.dao.ProjectWithP;

/**
 *
 * @author Peter
 */
public class UpdateProjectWithStage implements GenericProcessor {

    public static void main(String[] args) {
        try {
            UpdateProjectWithStage u = new UpdateProjectWithStage();
            u.execute("{\"logisticsArea\":0,\"commonArea\":3016,\"percentage\":22,\"totalIntegral\":146600,\"reserveIntegral\":25069,\"projectId\":108,\"contractCode\":\"JA.201509009.03-03-803\",\"departmentId\":21,\"projectType\":3,\"projectCode\":\"J&A-X-15-035\",\"projectName\":\"研祥科技工业园光明研发楼17、18层（微软办公室）室内装饰设计合同书\",\"planStartDate\":1471795200000,\"planEndDate\":1471795200000,\"status\":0,\"projectManageId\":290,\"projectIntegral\":114201,\"budget\":0,\"designType\":26,\"totalAmount\":0,\"projectLevel\":4,\"oldProjectDiscount\":0,\"departmentManagerId\":410,\"plateId\":3,\"projectFinishPercent\":5,\"parentId\":0,\"totalFinishPercent\":0,\"projectGradeType\":1,\"plateManagerId\":0,\"lastPercent\":0,\"detailProjectStage\":[{\"projectStageId\":5833,\"projectId\":108,\"stageId\":5,\"stageName\":\"施工图设计\",\"percent\":5}, {\"projectStageId\":5834,\"projectId\":108,\"stageId\":0,\"stageName\":\"动线设计\",\"percent\":9}, {\"projectStageId\":5835,\"projectId\":108,\"stageId\":10,\"stageName\":\"招标图设计\",\"percent\":3}, {\"projectStageId\":5836,\"projectId\":108,\"stageId\":7,\"stageName\":\"招标图\",\"percent\":6}, {\"projectStageId\":5837,\"projectId\":108,\"stageId\":4,\"stageName\":\"深化设计\",\"percent\":9}, {\"projectStageId\":5838,\"projectId\":108,\"stageId\":2,\"stageName\":\"方案设计\",\"percent\":6}]}", null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        BaseProjectWithP bean = new BaseProjectWithP();
        bean.setDataFromJSON(creteria);
        ProjectWithP dao = new ProjectWithP();
        dao.setProjectId(bean.getProjectId());
        if (dao.load()) {
        	BigDecimal projectIntegral = null == dao.getProjectIntegral() ? BigDecimal.ZERO : dao.getProjectIntegral();
        	BigDecimal oneHundred = new BigDecimal(100);
            List<BaseProjectStage> newDetails = bean.getDetailProjectStage();
            if(null != newDetails){
            	SystemDictionary dictionary = new SystemDictionary();
            	dictionary.setConditionDicTypeId("=", 7);
            	List<BaseSystemDictionary> dictionaryList = dictionary.conditionalLoad();
            	//定义map来存放每个阶段的名称
            	Map<Integer,String> nameMap = new HashMap<>();
            	if(!BaseHelpUtils.isNullOrEmpty(dictionaryList) && dictionaryList.size() > 0){
            		for(BaseSystemDictionary e : dictionaryList){
            			nameMap.put(e.getDicTypeValueId(), e.getDicTypeValue());
            		}
            	}
            	//获取每个阶段的名称
            	Integer projectId = dao.getProjectId();
            	/*首先，把新的项目阶段记录循环一遍，看看有没有重复的阶段ID，或者有阶段没有选择设计阶段，有则返回错误*/
            	Map<Integer, Object> map = new HashMap<>();
            	for(BaseProjectStage stage : newDetails){
            		if(null != stage.getStageId()){
            			map.put(stage.getStageId(), null);
            		}
            	}
            	if(map.size()!=newDetails.size()){
            		return bean.toOneLineJSON(-1, "项目阶段有重复的设计阶段或有阶段没有选择设计阶段");
            	}
            	//如果项目积分<=0,则不可进行操作
            	if(projectIntegral.compareTo(BigDecimal.ZERO) <= 0){
            		return bean.toOneLineJSON(-1, "操作异常:项目积分需大于0");
            	}
            	//获取新的阶段占比总和和阶段总积分
            	BigDecimal stagePercentTotal = BigDecimal.ZERO;
            	BigDecimal stageIntegralTotal = BigDecimal.ZERO;
            	for(BaseProjectStage e : newDetails){
            		//获取阶段占比和阶段积分
            		BigDecimal stagePercent = BaseHelpUtils.getBigDecimalValue(e.getPercent());
            		BigDecimal stageIntegral = BaseHelpUtils.getBigDecimalValue(e.getProjectAmount());
            		stagePercentTotal = stagePercentTotal.add(stagePercent);
            		stageIntegralTotal = stageIntegralTotal.add(stageIntegral);
            	}
            	//判断新的阶段占比的总和是否等于100
            	if(stagePercentTotal.compareTo(oneHundred) != 0){
            		return bean.toOneLineJSON(-1, "操作异常:分配的阶段占比总和需等于100");
            	}
            	//判断新的阶段总积分是否等于项目积分
            	if(stageIntegralTotal.compareTo(projectIntegral) != 0){
            		return bean.toOneLineJSON(-1, "操作异常:分配的阶段总积分不等于项目积分("+projectIntegral+")");
            	}
            	//加载原有阶段的数据
            	ConditionOnLoadProjectStageSettlement condition = new ConditionOnLoadProjectStageSettlement();
            	condition.setProjectId(projectId);
            	QueryOnLoadProjectStageSettlement conDao = new QueryOnLoadProjectStageSettlement();
            	BaseCollection<BaseOnLoadProjectStageSettlement> conResult = conDao.executeQuery(null, condition);
            	//定义map来存放该项目已保存的每个阶段的数据集
            	Map<Integer,BaseOnLoadProjectStageSettlement> oldMap = new HashMap<>();
            	if(!BaseHelpUtils.isNullOrEmpty(conResult)){
            		for(BaseOnLoadProjectStageSettlement e : conResult.getCollections()){
            			oldMap.put(e.getStageId(),e);
            		}
            	}
            	//遍历新的阶段，并验证每个阶段的设置是否正确
            	for(BaseProjectStage e : newDetails){
            		int stageId = e.getStageId()==null?0:e.getStageId();
            		//获取阶段名称
            		String stageName = nameMap.get(stageId);
            		e.setStageName(stageName);
            		//获取新的阶段占比
            		BigDecimal stagePercent = e.getPercent()==null?BigDecimal.ZERO:BaseHelpUtils.getBigDecimalValue(e.getPercent());
            		//获取旧阶段的数据集
            		BaseOnLoadProjectStageSettlement oldBean = oldMap.get(stageId);
            		if(!BaseHelpUtils.isNullOrEmpty(oldBean)){
            			//获取旧的阶段占比
            			BigDecimal stagePercentOld = oldBean.getPercent()==null?BigDecimal.ZERO:BaseHelpUtils.getBigDecimalValue(oldBean.getPercent());
            			if(stagePercent.compareTo(stagePercentOld)!=0){//如果不相等，则判断该阶段是否上传确认函
            				//获取确认函标示
            				int attachmentNum = oldBean.getAttachmentNum()==null?0:oldBean.getAttachmentNum();
            				if(attachmentNum > 0){//说明该阶段已上传确认函，不可进行修改
            					return bean.toOneLineJSON(-1, "操作异常:阶段("+stageName+")已上传确认函,不可进行阶段占比的调整");
            				}
            				//获取阶段已确认积分
            				BigDecimal stageSettlementIntegral = oldBean.getSettlementIntegral()==null?BigDecimal.ZERO:oldBean.getSettlementIntegral();
            				//如果阶段已确认积分，则新的阶段占比一定要大于旧的阶段占比
            				if(stageSettlementIntegral.compareTo(BigDecimal.ZERO) > 0){
            					if(stagePercent .compareTo(stagePercentOld) <0){
            						return bean.toOneLineJSON(-1, "操作异常:阶段("+stageName+")已确认积分,阶段占比不可下调");
            					}
            				}
            			}
            		}
            	}
            	
            }
            dao.setDataFromBase(bean);
            dao.update();
        }
        return dao.generateBaseExt().toOneLineJSON(0, null);
    }

}
