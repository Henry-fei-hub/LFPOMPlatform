package pomplatform.plateproductionvalue.business;

import com.pomplatform.db.dao.ProductionValueCoefficient;
import com.pomplatform.db.dao.ProductionValueCoefficientType;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.plateproductionvalue.bean.BaseProductionValueCoefficient;
import pomplatform.plateproductionvalue.bean.BaseProductionValueCoefficientType;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 产值系数新建的后台处理
 *
 * @author: xiaolong
 * @Date: 2019/9/25 12:22
 */
public class ProductionValueProcessor implements GenericProcessor {
    private static final Logger __LOGGER = Logger.getLogger("ProductionValueProcessor");
    //删除产值系数的界面
    private static final String DELETE = "deleteProductionValue";

    @Override
    public String execute(String creteria, HttpServletRequest httpServletRequest) throws Exception {
        @SuppressWarnings("rawtypes")
        JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "opt_type");
        switch (optType) {
            case DELETE:
                return deleteProduction(params);
            default:
                break;
        }
        return null;
    }


    /**
     * 删除方法
     *
     * @param params
     * @return
     */
    private String deleteProduction(Map<String, Object> params) throws SQLException {
        BaseCollection<GenericBase> collection = new BaseCollection<>();

        int productionValueCoefficientTypeId = BaseHelpUtils.getIntValue(params.get("productionValueCoefficientTypeId"));

        __LOGGER.info("重新定义的删除方法中的productionValueCoefficientTypeId" + productionValueCoefficientTypeId);

        if (!BaseHelpUtils.isNullOrZero(productionValueCoefficientTypeId)){
            ProductionValueCoefficientType pdao = new ProductionValueCoefficientType();
            pdao.setConditionProductionValueCoefficientTypeId("=",productionValueCoefficientTypeId);
            pdao.conditionalDelete();
            pdao.clear();
            ProductionValueCoefficient proDao = new ProductionValueCoefficient();
            proDao.setConditionProductionValueCoefficientTypeId("=",productionValueCoefficientTypeId);
            proDao.conditionalDelete();
            proDao.clear();
        }else {
            return collection.toJSON(-1, "删除失败");
        }
        return collection.toJSON(0, "删除成功");
    }
}