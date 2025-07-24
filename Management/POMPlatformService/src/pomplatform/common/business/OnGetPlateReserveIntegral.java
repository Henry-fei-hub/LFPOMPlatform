package pomplatform.common.business;

import com.pomplatform.db.bean.BasePlateIntegralSumRecord;
import com.pomplatform.db.dao.PlateIntegralSumRecord;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import pomplatform.common.utils.CommonHandel;

/**
 * 根据业务部门ID获取该部门的价值积分
 * @author lxf
 */
public class OnGetPlateReserveIntegral implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        double achieveIntegral = 0;
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
        //获取最终的价值积分
        achieveIntegral = CommonHandel.getTotalAchieveIntegral(plateId, null, null);
        BasePlateIntegralSumRecord bean = new BasePlateIntegralSumRecord();
        bean.setPlateId(plateId);
        bean.setAchieveIntegral(new BigDecimal(achieveIntegral));
        return bean.toOneLineJSON(0,null);
    }

}
