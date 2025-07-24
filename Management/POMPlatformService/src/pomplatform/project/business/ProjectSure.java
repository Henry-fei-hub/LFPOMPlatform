package pomplatform.project.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectEmployeeIntegralRecord;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployeeIntegralRecord;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.ProjectStageRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;
import delicacy.system.dao.Employee;
import pomplatform.sureIntegrl.bean.BaseMprojectEmployeeSureIntegrl;

/**
 * 项目积分确认
 * @author lxf
 */
public class ProjectSure implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        HttpCookie hc = new HttpCookie(request);
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> result = (Map<String, Object>) parser.parse(new BasicHandler());
        int projectId = BaseHelpUtils.getIntValue(result, "projectId");
        int stageId = BaseHelpUtils.getIntValue(result, "stageId");
        String settlementRemark = BaseHelpUtils.getString(result.get("settlementRemark"));
        String settlementDateStr = BaseHelpUtils.getString(result.get("settlementDate"));
        Date settlementDate = new Date(Long.valueOf(settlementDateStr));
        List<BaseMprojectEmployeeSureIntegrl> resultList = GenericBase.__getList(result.get("projectEmployees"), BaseMprojectEmployeeSureIntegrl.newInstance());
        Project p = new Project();
        p.setProjectIdClear(projectId);
        boolean isHave = p.load();
        if (!isHave) {
            throw new SQLException("没有这个项目");
        }
        if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size() > 0){
            //获取分配给所有成员的确认积分
            double assignSureIntegralTotal = 0;
            for(BaseMprojectEmployeeSureIntegrl e : resultList){
                assignSureIntegralTotal += BaseHelpUtils.getDoubleValue(e.getAssignSureIntegral());
            }
            //获取本阶段已确认的总积分
            double stageSureIntegral = BaseHelpUtils.getDoubleValue(result.get("stageSureIntegral"));
            //获取本阶段总积分
            double stageIntegral = BaseHelpUtils.getDoubleValue(result.get("stageIntegral"));
            //检索如果当前分配的总积分+已确认的总积分>阶段总积分，则抛出异常，不进行提交操作
            if(assignSureIntegralTotal+stageSureIntegral>stageIntegral){
                throw new SQLException("分配的确认总积分超过了本阶段积分，请重新分配");
            }
            Employee eDao = new Employee();
            ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
            BaseProjectEmployeeIntegralRecord bean;
            for(BaseMprojectEmployeeSureIntegrl e : resultList){
                //获取成员的预分配积分
                double planIntegral = BaseHelpUtils.getDoubleValue(e.getPlanIntegral());
                //获取成员的已确认积分
                double sureIntegral = BaseHelpUtils.getDoubleValue(e.getSureIntegral());
                //获取成员的分配的确认积分
                double assignSureIntegral = BaseHelpUtils.getDoubleValue(e.getAssignSureIntegral());
                //获取成员id
                int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
                //获取成员名称
                eDao.clear();
                eDao.setEmployeeId(employeeId);
                eDao.load();
                String employeeName = BaseHelpUtils.getString(eDao.getEmployeeName());
                //检索如果现分配的确认积分+已确认的积分>成员的预分配积分的话则抛出异常，不做提交操作
                if(sureIntegral+assignSureIntegral > planIntegral){
                    throw new SQLException("项目成员("+employeeName+")分配的确认积分过多，当前阶段最多可分配("+(planIntegral-sureIntegral)+"),请重新分配");
                }
                //先检索该成员在表中是否已有记录
                dao.clear();
                dao.setConditionProjectId("=",projectId);
                dao.setConditionStageId("=", stageId);
                dao.setConditionEmployeeId("=",employeeId);
                dao.setConditionStatus("=",0);//检索未结算的记录
                bean = dao.executeQueryOneRow();
                if(!BaseHelpUtils.isNullOrEmpty(bean)){//如果不存在，则更新
                    bean.setInputSureIntegral(BigDecimal.ZERO);//初始化分配确认积分
                    bean.setSureIntegral(bean.getSureIntegral().add(new BigDecimal(assignSureIntegral)));
                    bean.setSureDate(settlementDate);
                    bean.setRemark(settlementRemark);
                    dao.setDataFromBase(bean);
                    dao.conditionalUpdate();
                }else{//如果没有，则将成员的确认积分保存到表中
                    bean = new BaseProjectEmployeeIntegralRecord();
                    bean.setProjectId(projectId);
                    bean.setEmployeeId(employeeId);
                    bean.setStageId(stageId);
                    bean.setSureIntegral(new BigDecimal(assignSureIntegral));
                    bean.setSureDate(settlementDate);
                    bean.setRemark(settlementRemark);
                    bean.setInputSureIntegral(BigDecimal.ZERO);
                    dao.setDataFromBase(bean);
                    dao.save();
                }
                //获取当前阶段未分配的确认积分
                double stageFinalIntegral = BaseHelpUtils.getDoubleValue(result.get("stageFinalIntegral"));
                if(stageFinalIntegral == 0){//表示当前阶段的确认积分已经分配完，则更新该项目的下一阶段
                    //获取下一阶段的id
                    ProjectStage psDao = new ProjectStage();
                    //先获取当前阶段的主键id
                    psDao.setConditionProjectId("=",projectId);
                    psDao.setConditionStageId("=", stageId);
                    BaseProjectStage psbean = psDao.executeQueryOneRow();
                    if(!BaseHelpUtils.isNullOrEmpty(psbean)){
                        int projectStageId = BaseHelpUtils.getIntValue(psbean.getProjectStageId());
                        psDao.clear();
                        psDao.setConditionProjectId("=",projectId);
                        psDao.setConditionProjectStageId(">", projectStageId);
                        List<BaseProjectStage> resultBean = psDao.conditionalLoad(" order by "+BaseProjectStage.CS_PROJECT_STAGE_ID+" asc");
                        if(!BaseHelpUtils.isNullOrEmpty(resultBean) && resultBean.size() > 0){
                            BaseProjectStage psBean = resultBean.get(0);
                            //获取下一阶段的id
                            int nextStageId = BaseHelpUtils.getIntValue(psBean.getStageId());
                            //更新该项目的阶段记录表
                            ProjectStageRecord psrDao = new ProjectStageRecord();
                            psrDao.setConditionProjectId("=", projectId);
                            psrDao.setStageId(nextStageId);
                            psrDao.conditionalUpdate();
                        }
                    }
                }
                
            }
        }

        ThreadConnection.commit();
        BaseCollection bc = new BaseCollection();
        return bc.toJSON(0, null);
    }
    
}
