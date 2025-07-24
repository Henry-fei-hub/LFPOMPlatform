package pomplatform.revenueStatistical.business;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseRevenueStatisticalRecord;
import com.pomplatform.db.dao.RevenueStatisticalRecord;
import com.pomplatform.db.dao.RevenueYearStatisticalRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler;

/**
 *
 * @author 
 */
public class OnAccountRevenueData extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnAccountRevenueData.class);

    @Override
    public void run() {
        __logger.debug("每天6点开始，每个6个小时开始自动保存营收数据");
        try {
        	//获取当前系统日期
        	Date currentDate = new Date();
        	//获取年月份
        	int year = DateUtil.getYear(currentDate);
        	int month = DateUtil.getMonth(currentDate);
        	//获取营收数据集
        	ConditionRevenueStatisticalOfRevenue condition = new ConditionRevenueStatisticalOfRevenue();
        	condition.setYear(year);
        	condition.setMonth(month);
        	BaseCollection<BaseRevenueStatisticalOfRevenue> result = CustomRevenueStatisticalOfRevenueHandler.getResult(condition);
        	if(!BaseHelpUtils.isNullOrEmpty(result)){
        		List<BaseRevenueStatisticalOfRevenue> list = result.getCollections();
        		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
        			RevenueStatisticalRecord rsdao = new RevenueStatisticalRecord();
        			rsdao.setConditionYear("=",year);
        			rsdao.setConditionMonth("=",month);
        			rsdao.setConditionIsLocked("=",Boolean.TRUE);
        	    	if(rsdao.isExist()){
        	    		throw new SQLException("操作异常:当前年月份数据已加锁过,不可再进行保存操作");
        	    	}
        	    	RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
        			RevenueYearStatisticalRecord yearDao = new RevenueYearStatisticalRecord();
        			OnRevenueStatisticalProcess process = new OnRevenueStatisticalProcess();
        			BaseRevenueStatisticalRecord e = null;
        			for(BaseRevenueStatisticalOfRevenue bean : list){
        				e = new BaseRevenueStatisticalRecord();
        				e.setDataFromJSON(bean.toJSON());
        				e.setYear(year);
        				e.setMonth(month);
        				e.setOperateEmployeeId(0);
        				e.setOperateTime(currentDate);
        				//先判断该订单在当前年月份是否有保存，如果有则更新，没有则新增
        				int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
        				dao.clear();
        				dao.setConditionProjectId("=",projectId);
        				dao.setConditionYear("=",year);
        				dao.setConditionMonth("=",month);
        				dao.setDataFromBase(e);
        				if(dao.countRows()>0){//说明存在，则做更新
        					dao.conditionalUpdate();
        				}else{
        					dao.save();
        				}
        				//更新或新增该订单的年度营收表数据
        				yearDao.clear();
        				yearDao.setConditionProjectId("=",projectId);
        				yearDao.setConditionYear("=",year);
        				process.onSetRevenue(month,e.getCurrentRevenue(), yearDao);
        				yearDao.setOperateEmployeeId(0);
        				yearDao.setOperateTime(currentDate);
        				if(yearDao.countRows() > 0){//说明存在，则做更新
        					yearDao.conditionalUpdate();
        				}else{
        					yearDao.setProjectId(projectId);
        					yearDao.setYear(year);
        					yearDao.save();
        				}
        			}
        		}
        	}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
        
    }
    
    public static void main(String[] args) {
    	OnAccountRevenueData ss = new OnAccountRevenueData();
    	ss.run();
	}
}
