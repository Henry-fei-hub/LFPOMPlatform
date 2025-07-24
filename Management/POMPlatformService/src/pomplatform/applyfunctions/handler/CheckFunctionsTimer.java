package pomplatform.applyfunctions.handler;
import com.pomplatform.db.bean.BaseFunctionBusiness;
import com.pomplatform.db.dao.FunctionBusiness;
import delicacy.common.BaseHelpUtils;
import delicacy.system.dao.EmployeeFunction;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

/**
 * 权限流程的定时器，权限失效之后就执行该定时任务将权限从个人权限表中删除
 *
 * @author J&A
 */
public class CheckFunctionsTimer extends TimerTask {
    @Override
    public void run() {
        try {
            //获取当前时间
            Date currentDate = new Date();
            EmployeeFunction eDao = new EmployeeFunction();
            FunctionBusiness fDao = new FunctionBusiness();
            fDao.setConditionIsForever("=", false);
            //流程已完成的数据
            fDao.setConditionIsCompleted("=", true);
            List<BaseFunctionBusiness> list = fDao.conditionalLoad();
            System.out.println(list.toString());

            /**
             * 根据functionId 和 employeeId 作为条件删除已过期的权限
             */
            if (!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
                for (BaseFunctionBusiness b : list) {
                    Date endTime = b.getEndDate();
                    //当前时间减去权限结束时间大于等于0的话就将该申请的权限删除
                    long l = currentDate.getTime() - endTime.getTime();
                    if (l >= 0) {
                        int employeeId = BaseHelpUtils.getIntValue(b.getEmployeeId());
                        int functionId = BaseHelpUtils.getIntValue(b.getFunctionId());
                        eDao.clear();
                        eDao.setConditionFunctionId("=", functionId);
                        eDao.setConditionEmployeeId("=", employeeId);
                        eDao.conditionalDelete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CheckFunctionsTimer a = new CheckFunctionsTimer();
        a.run();
    }

}
