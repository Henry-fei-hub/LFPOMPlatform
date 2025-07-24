package pomplatform.stageIntegral.handler;

import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.ProjectStageRecord;
import org.apache.log4j.Logger;
import pomplatform.stageIntegral.bean.BaseMprojectStageIntegralTotal;
import pomplatform.stageIntegral.bean.ConditionMprojectStageIntegralTotal;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

public class CustomMprojectStageIntegralTotalHandler extends MprojectStageIntegralTotalHandler {

    private static final Logger __logger = Logger.getLogger(CustomMprojectStageIntegralTotalHandler.class);

    @Override
    public String find(String creteria) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
        //根据该项目ID去检索项目阶段记录表是否有数据，如果没有，则从项目阶段表中取最先选择的一条项目阶段保存到该表中，作为记录当前项目目前确认的积分的阶段
        ProjectStageRecord psrDao = new ProjectStageRecord();
        psrDao.setConditionProjectId("=", projectId);
        int count = psrDao.countRows();
        if(count == 0){//如果项目记录表中没有数据，则表示还未进去积分确认的操作
            ProjectStage psDao = new ProjectStage();
            psDao.setConditionProjectId("=",projectId);
            List<BaseProjectStage> listBeans = psDao.conditionalLoad(" order by "+BaseProjectStage.CS_PROJECT_STAGE_ID+" asc");
            if(!BaseHelpUtils.isNullOrEmpty(listBeans) && listBeans.size() > 0){
                BaseProjectStage bean = listBeans.get(0);//只检索第一条记录
                psrDao.clear();
                psrDao.setProjectId(projectId);
                psrDao.setStageId(BaseHelpUtils.getIntValue(bean.getStageId()));
                psrDao.save();
            }
        }
        ConditionMprojectStageIntegralTotal c = new ConditionMprojectStageIntegralTotal();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseMprojectStageIntegralTotal> result = executeQueryMprojectStageIntegralTotal(c, c.getKeyValues());
        return result.toJSON(null);
    }
}
