package pomplatform.plateIntegralTotal.handler;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.SystemConfig;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.plateIntegralDetail.bean.BaseMplateIntegralDetail;
import pomplatform.plateIntegralDetail.bean.ConditionMplateIntegralDetail;
import pomplatform.plateIntegralDetail.query.QueryMplateIntegralDetail;
import pomplatform.plateIntegralTotal.bean.BaseMplateIntegralTotal;
import pomplatform.plateIntegralTotal.bean.ConditionMplateIntegralTotal;
import pomplatform.plateProjectCost.bean.BaseMplateProjectCost;
import pomplatform.plateProjectCost.bean.ConditionMplateProjectCost;
import pomplatform.plateProjectCost.query.QueryMplateProjectCost;

public class CustomMplateIntegralTotalHandler extends MplateIntegralTotalHandler{
    private static final Logger __logger = Logger.getLogger(CustomMplateIntegralTotalHandler.class);

    @Override
    public String find(String creteria) throws Exception {
        ConditionMplateIntegralTotal c = new ConditionMplateIntegralTotal();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseMplateIntegralTotal> result = executeQueryMplateIntegralTotal(c, c.getKeyValues());
        if(!BaseHelpUtils.isNullOrEmpty(result)){
            List<BaseMplateIntegralTotal> resultList = result.getCollections();
            if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size()>0){
                for(BaseMplateIntegralTotal e : resultList){
                    int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
                    //获取板块下的所有成员的1-6月份的人工成本
                    Long employeeSalaryTotal = BaseHelpUtils.getLongValue(getPlateEmployeeSalary(plateId));
                    e.setSalaryIntegral(BaseHelpUtils.getLongValue(e.getSalaryIntegral())+employeeSalaryTotal);
                    Long achieveIntegrl = BaseHelpUtils.getLongValue(getPlateProjectAchieveIntegral(plateId, employeeSalaryTotal));
                    e.setAchieveIntegral(BaseHelpUtils.getLongValue(e.getAchieveIntegral())+achieveIntegrl);
                }
            }
            result.setCollections(resultList);
        }
        return result.toJSON(null);
    }
    
    /**
     * 获取板块下的所有成员的1-6月份的人工成本
     * @param plateId
     * @return
     * @throws SQLException
     * @throws UnsupportedEncodingException 
     */
    public Long getPlateEmployeeSalary(int plateId) throws SQLException, UnsupportedEncodingException{
        long employeeSalaryTotal = 0;
        Employee dao = new Employee();
        dao.setConditionPlateId("=", plateId);
        List<BaseEmployee> listResult = dao.conditionalLoad();
        //获取所有该业务部门下的职员
        int len = listResult.size();
        Object[] ids = new Object[len];
        int i = 0;
        if(!BaseHelpUtils.isNullOrEmpty(listResult) && len > 0){
            for(BaseEmployee bean : listResult){
                ids[i] = BaseHelpUtils.getIntValue(bean.getEmployeeId());
                i++;
            }
        }
        //检索该业务部门下的所有成员的人工成本
        EmployeeSalaryDetail esdDao = new EmployeeSalaryDetail();
        esdDao.setConditionSalaryYear("=",2016);
        esdDao.addCondition(BaseEmployeeSalaryDetail.CS_EMPLOYEE_ID,"in", ids);
        List<BaseEmployeeSalaryDetail> result = esdDao.conditionalLoad(" cast(salary_month as integer) >=1 and cast(salary_month as integer) <=6");
        if(!BaseHelpUtils.isNullOrEmpty(result) && result.size() > 0){
            //获取解密的秘钥
            SystemConfig sc = new SystemConfig();
            sc.setSystemConfigId(StaticUtils.SYSTEM_KEY);
            sc.load();
            String key = BaseHelpUtils.getString(sc.getImagePath());
            DES des = new DES(key);
            for(BaseEmployeeSalaryDetail e : result){
                //获取人员的成本
                String basicSalary = BaseHelpUtils.getString(e.getBasicSalary());
                employeeSalaryTotal += BaseHelpUtils.getDoubleValue(des.DEC(basicSalary));
            }
        }
        return employeeSalaryTotal;
    }
    
    /**
     * 根据板块去检索板块下参与项目的所有成员的人工成本
     * @param plateId
     * @return 
     * @throws java.sql.SQLException 
     * @throws java.io.UnsupportedEncodingException 
     */
    public Long getPlateProjectCost(int plateId) throws SQLException, UnsupportedEncodingException{
        long projctCost=0;
        ConditionMplateProjectCost condition = new ConditionMplateProjectCost();
        condition.setPlateId(plateId);
        QueryMplateProjectCost dao = new QueryMplateProjectCost();
        BaseCollection<BaseMplateProjectCost> result = dao.executeQuery(null, condition);
        if(!BaseHelpUtils.isNullOrEmpty(result)){
            List<BaseMplateProjectCost> resultList = result.getCollections();
            if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size()>0){
                //获取解密的秘钥
                SystemConfig sc = new SystemConfig();
                sc.setSystemConfigId(StaticUtils.SYSTEM_KEY);
                sc.load();
                String key = BaseHelpUtils.getString(sc.getImagePath());
                DES des = new DES(key);
                for(BaseMplateProjectCost e : resultList){
                    //获取人员的成本
                    String basicSalary = BaseHelpUtils.getString(e.getBasicSalary());
                    projctCost += BaseHelpUtils.getDoubleValue(des.DEC(basicSalary));
                }
            }
        }
        return projctCost;
    }
    
    /**
     * 根据板块获取项目的确定积分
     * @param plateId
     * @param projectCost
     * @return
     * @throws SQLException 
     */
    public Long getPlateProjectAchieveIntegral(int plateId,long projectCost) throws SQLException{
        long achieveIntegral = 0;
        long sureIntegral = 0;
        ConditionMplateIntegralDetail condition = new ConditionMplateIntegralDetail();
        condition.setPlateId(plateId);
        QueryMplateIntegralDetail dao = new QueryMplateIntegralDetail();
        BaseCollection<BaseMplateIntegralDetail> result = dao.executeQuery(null, condition);
        if(!BaseHelpUtils.isNullOrEmpty(result)){
            List<BaseMplateIntegralDetail> resultList = result.getCollections();
            if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size()>0){
                for(BaseMplateIntegralDetail e : resultList){
                    int flag = BaseHelpUtils.getIntValue(e.getFlag());
                    //只检索项目
                    if(flag == 1){
                        sureIntegral = BaseHelpUtils.getLongValue(e.getSureIntegral());
                    }
                }
            }
        }
        achieveIntegral = sureIntegral-projectCost;
        return achieveIntegral;
    }
    
    public static void main(String[] args) throws SQLException, UnsupportedEncodingException {
        CustomMplateIntegralTotalHandler ss = new CustomMplateIntegralTotalHandler();
        ss.getPlateEmployeeSalary(6);
    }
        
}


