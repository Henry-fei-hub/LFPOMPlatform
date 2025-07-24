package pomplatform.payment.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFiveInsuranceOneGold;
import com.pomplatform.db.dao.FiveInsuranceOneGold;

import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;

/**
 *
 * @author 
 */
public class OnFiveInsuranceOneGoldsTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnFiveInsuranceOneGoldsTask.class);

    @Override
    public void run() {
        __logger.debug("开始复制五险一金数据");
        try {
        	//获取当前系统日期
        	Date currentDate = new Date();
        	//获取当前系统日期的最后一天
			Date lastDate = DateUtil.getLastDay(currentDate);
			//比较当前系统日期和最后一天的日期，如果相等则说明当前操作日期是最后一天
			if(DateUtil.isSameDay(lastDate, currentDate)){//说明是最后一天，则进行五险一金的数据复制
				//获取年月份
				int year = DateUtil.getYear(currentDate);
				int month = DateUtil.getMonth(currentDate);
				FiveInsuranceOneGold dao = new FiveInsuranceOneGold();
				dao.setConditionYear("=",year);
				dao.setConditionMonth("=",month);
				List<BaseFiveInsuranceOneGold> result = dao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(result) && result.size() > 0){
					List<BaseFiveInsuranceOneGold> saveList = new ArrayList<>();
					if(month == 12){
						year += 1;
						month = 0;
					}
					for(BaseFiveInsuranceOneGold e : result){
						e.setYear(year);
						e.setMonth(month+1);
						saveList.add(e);
					}
					if(!BaseHelpUtils.isNullOrEmpty(saveList) && saveList.size() > 0){
						//保存
						dao.clear();
						dao.save(saveList);
					}
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}
