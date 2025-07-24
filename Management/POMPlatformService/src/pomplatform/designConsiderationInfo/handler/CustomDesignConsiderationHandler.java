package pomplatform.designConsiderationInfo.handler;

import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.handler.DesignConsiderationHandler;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CustomDesignConsiderationHandler extends DesignConsiderationHandler {

    @Override
    public String save(String json) throws Exception {
        BaseDesignConsideration bean = new BaseDesignConsideration();
        bean.setDataFromJSON(json);
        DesignConsideration dao = new DesignConsideration();
        dao.setDataFromBase(bean);
        ThreadConnection.beginTransaction();
        int num = dao.save();
        dao.setDataToBase(bean);
        dao.clear();
        UseBySaveOrUpdate(dao, bean);
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String update(String json) throws Exception {
        BaseDesignConsideration bean = new BaseDesignConsideration();
        bean.setDataFromJSON(json);
        DesignConsideration dao = new DesignConsideration();
        dao.setPrimaryKeyFromBase(bean);
        int num = 0;
        ThreadConnection.beginTransaction();
        if (dao.load()) {
            dao.setDataFromBase(bean);
            num = dao.update();
            dao.clear();
            UseBySaveOrUpdate(dao, bean);
        }
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }

    public void UseBySaveOrUpdate(DesignConsideration dao, BaseDesignConsideration bean) throws SQLException {
        dao.setConditionSubContractId("=", bean.getSubContractId());
        List<BaseDesignConsideration> list = dao.conditionalLoad();
        BigDecimal money = new BigDecimal(0);
        BigDecimal commonArea = new BigDecimal(0);
        BigDecimal logisticsArea = new BigDecimal(0);
        for (BaseDesignConsideration base : list) {
            if (!BaseHelpUtils.isNullOrEmpty(base.getMoneySum())) {
                money = money.add(base.getMoneySum());
            }
            if (!BaseHelpUtils.isNullOrEmpty(base.getDecorationStatus())) {
                if (base.getDecorationStatus().equals(0)) {//精装，属于公区面积
                    commonArea = commonArea.add(base.getDesignArea());
                } else if (base.getDecorationStatus().equals(1)) {//简装，属于后勤面积
                    logisticsArea = logisticsArea.add(base.getDesignArea());
                }
            }
        }
        SubContract sc = new SubContract();
        sc.setConditionSubContractId("=", bean.getSubContractId());
        sc.setMoneySum(money);
        sc.setCommonArea(commonArea);
        sc.setLogisticsArea(logisticsArea);
        sc.setUpdateTime(new Date());
        sc.conditionalUpdate();
    }
}
