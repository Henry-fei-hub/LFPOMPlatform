package pomplatform.employeeAward.handler;

import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.SystemConfig;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employeeAward.bean.BaseMemployeeAward;
import pomplatform.employeeAward.bean.ConditionMemployeeAward;
import static pomplatform.employeeAward.handler.MemployeeAwardHandler.executeQueryMemployeeAward;

public class CustomMemployeeAwardHandler extends MemployeeAwardHandler {

    private static final Logger __logger = Logger.getLogger(CustomMemployeeAwardHandler.class);

    @Override
    public String find(String creteria) throws Exception {
        ConditionMemployeeAward c = new ConditionMemployeeAward();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseMemployeeAward> result = executeQueryMemployeeAward(c, c.getKeyValues());
        List<BaseMemployeeAward> listBeans = result.getCollections();
        if (!BaseHelpUtils.isNullOrEmpty(listBeans) && listBeans.size() > 0) {
            //先获取所有成员的人工成本的数据
            EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
            dao.unsetSelectFlags();
            dao.setSelectEmployeeId(true);
            dao.setSelectSalaryYear(true);
            dao.setSelectSalaryMonth(true);
            dao.setSelectBasicSalary(true);
            List<BaseEmployeeSalaryDetail> resultBeans = dao.conditionalLoad();
            //获取加密的秘钥
            SystemConfig scDao = new SystemConfig();
            scDao.setSystemConfigId(StaticUtils.SYSTEM_KEY);
            scDao.load();
            String key = scDao.getImagePath();
            DES des = new DES(key);
            for (BaseMemployeeAward bean : listBeans) {
                BigDecimal basicSalary = new BigDecimal(BigInteger.ZERO);
                if (!BaseHelpUtils.isNullOrEmpty(resultBeans) && resultBeans.size() > 0) {
                    for (BaseEmployeeSalaryDetail e : resultBeans) {
                        if (Objects.equals(e.getEmployeeId(), bean.getEmployeeId()) && BaseHelpUtils.getIntValue(e.getSalaryYear())==BaseHelpUtils.getIntValue(bean.getYears()) && BaseHelpUtils.getIntValue(e.getSalaryMonth())==BaseHelpUtils.getIntValue(bean.getMonths())) {
                            basicSalary = new BigDecimal(des.DEC(e.getBasicSalary()));
                        }
                    }
                }
                bean.setAchieveAward(bean.getAchieveIntegral().subtract(basicSalary));
            }
        }
        result.setCollections(listBeans);
        return result.toJSON(null);
    }
    
}
