package pomplatform.project.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectStage;

import delicacy.common.BaseHelpUtils;
import pomplatform.account.business.AccountManageProcess;

/**
 *
 * @author 
 */
public class OnProjectManageFeeTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnProjectManageFeeTask.class);

    @Override
    public void run() {
        __logger.debug("开始计算本月需自动结算的项目管理费数据");
        try {
        	//获取当前系统日期
        	Date currentDate = new Date();
        	//获取当前日期是多少号，现定每个月26号执行
        	Calendar ca = Calendar.getInstance();
        	ca.setTime(currentDate);
        	int day = ca.get(Calendar.DAY_OF_MONTH);
			if(day == 26){//说明是26号一天
				//获取按周期结算的项目管理费订单
				Project dao = new Project();
				dao.setConditionProjectType("=",16);
				dao.setConditionIsAuto("=",Boolean.FALSE);
				dao.setConditionStatus("<>",10);//如果项目暂停，不进行自动结算
				List<BaseProject> list = dao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
					ProjectSettlement psDao = new ProjectSettlement();
					ProjectStage pStageDao = new ProjectStage();
					ProjectCost pcDao = new ProjectCost();
					ProjectSettlementDetail psdDao = new ProjectSettlementDetail();
					for(BaseProject e : list){
						int projectId = e.getProjectId()==null?0:e.getProjectId();
						String projectName = e.getProjectName();
						String projectCode = e.getContractCode();
						pStageDao.clear();
						//加载该项目的项目阶段
						pStageDao.setConditionProjectId("=",projectId);
						BaseProjectStage pStageBean = pStageDao.executeQueryOneRow();
						int stageId = pStageBean==null?0:pStageBean.getStageId()==null?0:pStageBean.getStageId();
						if(stageId == 0){
							__logger.info("操作失败:项目"+projectName+"("+projectCode+")未设定阶段");
							continue;
						}
						//获取周期数
						int timeCycleInt = e.getTimeCycle()==null?0:e.getTimeCycle();
						BigDecimal timeCycle = BaseHelpUtils.getBigDecimalValue(e.getTimeCycle());
						if(timeCycle.compareTo(BigDecimal.ZERO) <= 0){
							__logger.info("操作失败:项目"+projectName+"("+projectCode+")未设定周期数");
							continue;
						}
						//获取项目经理
						int projectManageId = e.getProjectManageId()==null?0:e.getProjectManageId();
						if(projectManageId == 0){
							__logger.info("操作失败:项目"+projectName+"("+projectCode+")未设定项目经理");
							continue;
						}
						//获取项目积分
						BigDecimal projectIntegral = e.getProjectIntegral()==null?BigDecimal.ZERO:e.getProjectIntegral();
						if(projectIntegral.compareTo(BigDecimal.ZERO) <= 0){
							__logger.info("操作失败:项目"+projectName+"("+projectCode+")没有可结算的项目积分");
							continue;
						}
						//检索该项目已经结算的总积分
						BigDecimal settlementIntegralTotal = BigDecimal.ZERO;
						psDao.clear();
						psDao.setConditionProjectId("=",projectId);
						List<BaseProjectSettlement> psList = psDao.conditionalLoad();
						if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0){
							for(BaseProjectSettlement psBean : psList){
								BigDecimal settlementIntegral = BaseHelpUtils.getBigDecimalValue(psBean.getTotalAmount());
								settlementIntegralTotal = settlementIntegralTotal.add(settlementIntegral);
							}
						}
						//检索该项目管理费是否有未结算的项目成本
						pcDao.clear();
						pcDao.setConditionProjectId("=",projectId);
						pcDao.setConditionStatus("=",0);
						List<BaseProjectCost> pcList = pcDao.conditionalLoad();
						BigDecimal projectCostTotal = BigDecimal.ZERO;
						if(!BaseHelpUtils.isNullOrEmpty(pcList) && pcList.size() > 0){
							for(BaseProjectCost pcBean : pcList){
								BigDecimal projectCost = BaseHelpUtils.getBigDecimalValue(pcBean.getAmount());
								projectCostTotal = projectCostTotal.add(projectCost);
							}
						}
						//剩余未结算积分=项目积分-已结算积分
						BigDecimal leftIntegral = projectIntegral.subtract(settlementIntegralTotal);
						if(leftIntegral.compareTo(BigDecimal.ZERO) != 0){
							//设置本次结算积分=剩余未结算积分/周期数
							BigDecimal currentSettlement = leftIntegral.divide(timeCycle,2,BigDecimal.ROUND_DOWN);
							//设置备注
							String remark = String.format("本笔结算来自周期为(%1$s)的结算", timeCycleInt);
							//向结算总表中插入一条数据
							psDao.clear();
							psDao.setProjectId(projectId);
							psDao.setEmployeeId(0);
							psDao.setRemark(remark);
							psDao.setSettlementDate(currentDate);
							psDao.setTotalAmount(currentSettlement);
							psDao.setTotalCost(projectCostTotal);
							psDao.setProjectAmount(projectCostTotal);
							psDao.setLeftAmount(projectIntegral.subtract(currentSettlement));
							psDao.setStageId(stageId);
							psDao.save();
							int settlementId = psDao.getSettlementId();
							//向明结算明细表中插入数据
							psdDao.clear();
							psdDao.setEmployeeId(projectManageId);
							psdDao.setSettlementId(settlementId);
							psdDao.setProjectId(projectId);
							psdDao.setEmployeeId(projectManageId);
							psdDao.setSettlementDate(currentDate);
							psdDao.setPlanAmount(projectIntegral);
							psdDao.setRealAmount(currentSettlement);
							psdDao.setProjectCost(projectCostTotal);
							psdDao.setFinalAmount(currentSettlement.subtract(projectCostTotal));
							psdDao.setWorkContent(remark);
							psdDao.save();
							int businessId = psdDao.getSettlementDetailId();
							//确认积分插入个人账户
							AccountManageProcess.onSaveEmployeeAccount(projectManageId, businessId, AccountManageProcess.EMP_BT_SURE_INTEGRAL, currentSettlement,currentDate, remark, 0);
							//如果有成本，结算后更新项目成本的状态值
							if(projectCostTotal.compareTo(BigDecimal.ZERO) != 0){
								//项目成本插入个人账户
								AccountManageProcess.onSaveEmployeeAccount(projectManageId, businessId, AccountManageProcess.EMP_BT_PROJECT_COST, projectCostTotal,currentDate, remark, 0);
								pcDao.setStatus(1);//设置为已分摊
								pcDao.conditionalUpdate();
							}
							//更新项目的自动结算积分
							dao.clear();
							dao.setProjectId(projectId);
							if(dao.load()){
								dao.setTimeCycle(timeCycleInt-1);
								dao.update();
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
    
    public static void main(String[] args) {
    	OnProjectManageFeeTask  ss = new OnProjectManageFeeTask();
    	ss.run();
	}

}
