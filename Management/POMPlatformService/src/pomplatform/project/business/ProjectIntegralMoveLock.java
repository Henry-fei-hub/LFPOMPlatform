package pomplatform.project.business;

import com.pomplatform.db.dao.EmployeeReportRecord;
import com.pomplatform.db.dao.PlateIntegralSumRecord;
import com.pomplatform.db.dao.PlateReportRecord;
import com.pomplatform.db.dao.ProjectIntegralSumRecord;
import com.pomplatform.db.dao.ProjectReportRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

/**
 * 解锁操作
 * @author lxf
 */
public class ProjectIntegralMoveLock implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        int result = 0;//初始化操作后的返回参数为0：表示成功;-1表示失败
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        Date startDate = new Date(Long.valueOf(startDateStr));
        //获取结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        Date endDate = new Date(Long.valueOf(endDateStr));
        //获取加锁的业务部门id
        int plateId = BaseHelpUtils.getIntValue(param,"plateId");
        //将开始日期重置为当前月份的第一天的日期
        startDate = DateUtil.getFirstDay(startDate);
        
        //判断结束月份是否大于开始月份，否则抛出异常
        if(startDate.after(endDate)){
            result = -1;
            throw new SQLException("计算的开始年月份不可大于结束年月份,请重置");
        }
        //部门汇总表
        PlateReportRecord plateReportRecordDao = new PlateReportRecord();
        //项目汇总表
        ProjectReportRecord projectReportRecordDao = new ProjectReportRecord();
        //人员汇总表
        EmployeeReportRecord employeeReportRecordDao = new EmployeeReportRecord();
        //获取开始日期和结束日期相差的月数
        int months = DateUtil.getCompareMonths(startDate, endDate)+1;
        Date customDate = startDate;
        //根据月份遍历去加锁数据
        for(int i = 0;i<months;i++){
        	plateReportRecordDao.clear();
        	plateReportRecordDao.setConditionPlateId("=",plateId);
        	plateReportRecordDao.setConditionRecordDate("=", customDate);
        	plateReportRecordDao.setIsLock(Boolean.FALSE);
        	plateReportRecordDao.conditionalUpdate();
            
        	projectReportRecordDao.clear();
        	projectReportRecordDao.setConditionPlateId("=",plateId);
        	projectReportRecordDao.setConditionRecordDate("=", customDate);
        	projectReportRecordDao.setIsLock(Boolean.FALSE);
        	projectReportRecordDao.conditionalUpdate();
        	
        	employeeReportRecordDao.clear();
        	employeeReportRecordDao.setConditionPlateId("=",plateId);
        	employeeReportRecordDao.setConditionRecordDate("=", customDate);
        	employeeReportRecordDao.setIsLock(Boolean.FALSE);
        	employeeReportRecordDao.conditionalUpdate();
            //遍历结束后追加一月
            customDate = DateUtil.getNextMonth(customDate);
        }
        ThreadConnection.commit();
        BaseCollection bc = new BaseCollection();
        return bc.toJSON(result,null);
    }

}
