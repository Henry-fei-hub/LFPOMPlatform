package pomplatform.plateProjectIntegralDetail.handler;

import com.pomplatform.db.dao.SystemConfig;
import org.apache.log4j.Logger;
import pomplatform.plateProjectIntegralDetail.bean.BaseMplateProjectIntegralDetail;
import pomplatform.plateProjectIntegralDetail.bean.ConditionMplateProjectIntegralDetail;
import java.sql.SQLException;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import java.io.UnsupportedEncodingException;
import java.util.List;
import pomplatform.common.utils.StaticUtils;
import pomplatform.getProjectCost.bean.BaseMgetProjectCost;
import pomplatform.getProjectCost.bean.ConditionMgetProjectCost;
import pomplatform.getProjectCost.query.QueryMgetProjectCost;

public class CustomMplateProjectIntegralDetailHandler extends MplateProjectIntegralDetailHandler{

    private static final Logger __logger = Logger.getLogger(CustomMplateProjectIntegralDetailHandler.class);

    @Override
    public String find(String creteria) throws Exception {
        ConditionMplateProjectIntegralDetail c = new ConditionMplateProjectIntegralDetail();
        c.setDataFromJSON(creteria);
        BaseCollection<BaseMplateProjectIntegralDetail> result = executeQueryMplateProjectIntegralDetail(c, c.getKeyValues());
        if(!BaseHelpUtils.isNullOrEmpty(result)){
            List<BaseMplateProjectIntegralDetail> resultList = result.getCollections();
            if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size() > 0){
                for(BaseMplateProjectIntegralDetail e : resultList){
                    int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
                    long salaryIntegral = BaseHelpUtils.getLongValue(getProjectSalaryIntegral(projectId));
                    e.setSalaryIntegral(salaryIntegral);
                    e.setAchieveIntegral(BaseHelpUtils.getLongValue(e.getSureIntegral())-BaseHelpUtils.getLongValue(e.getCostIntegral())-salaryIntegral);
                }
            }
            result.setCollections(resultList);
        }
        return result.toJSON(null);
    }
    
    /**
     * 获取项目的1-6月的人工成本
     * @param projectId
     * @return
     * @throws SQLException
     * @throws UnsupportedEncodingException 
     */
    public Long getProjectSalaryIntegral(int projectId) throws SQLException, UnsupportedEncodingException{
        long salaryIntegral=0;
        ConditionMgetProjectCost condition = new ConditionMgetProjectCost();
        condition.setProjectId(projectId);
        QueryMgetProjectCost dao = new QueryMgetProjectCost();
        BaseCollection<BaseMgetProjectCost> result = dao.executeQuery(null, condition);
        if(!BaseHelpUtils.isNullOrEmpty(result)){
            List<BaseMgetProjectCost> resultList = result.getCollections();
            if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size()>0){
                //获取解密的秘钥
                SystemConfig sc = new SystemConfig();
                sc.setSystemConfigId(StaticUtils.SYSTEM_KEY);
                sc.load();
                String key = BaseHelpUtils.getString(sc.getImagePath());
                DES des = new DES(key);
                for(BaseMgetProjectCost e : resultList){
                    //获取人员的成本
                    String basicSalary = BaseHelpUtils.getString(e.getBasicSalary());
                    salaryIntegral += BaseHelpUtils.getDoubleValue(des.DEC(basicSalary));
                }
            }
        }
        return salaryIntegral;
    }

}


