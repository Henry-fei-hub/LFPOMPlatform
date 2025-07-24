package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProductionValueCoefficient;

import java.util.List;

import com.pomplatform.db.dao.ProductionValueCoefficient;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;

import java.util.Map;

import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProductionValueCoefficientHandler implements GenericDao {

    private static final Logger __logger = Logger.getLogger(ProductionValueCoefficientHandler.class);

    public static BaseProductionValueCoefficient getProductionValueCoefficientById(
            java.lang.Integer production_value_coefficient_id
    ) throws Exception {
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        dao.setProductionValueCoefficientId(production_value_coefficient_id);
        if (dao.load()) {
            return dao.generateBase();
        }
        return null;
    }

    public static boolean isProductionValueCoefficientExists(com.pomplatform.db.bean.BaseProductionValueCoefficient bean, String additional) throws Exception {

        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        setConditions(bean, dao);
        boolean res = dao.isExist(additional);
        return res;
    }

    public static int countProductionValueCoefficient(com.pomplatform.db.bean.BaseProductionValueCoefficient bean, String additional) throws Exception {

        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        setConditions(bean, dao);
        int res = dao.countRows(additional);
        return res;
    }

    public static BaseCollection<BaseProductionValueCoefficient> queryProductionValueCoefficient(com.pomplatform.db.bean.BaseProductionValueCoefficient bean, int pageNo, int pageLines, String additionalCondition) throws Exception {
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        setConditions(bean, dao);
        dao.setCurrentPage(pageNo);
        dao.setPageLines(pageLines);
        java.util.List<BaseProductionValueCoefficient> result = dao.conditionalLoad(additionalCondition);
        BaseCollection<BaseProductionValueCoefficient> col = new BaseCollection<>();
        col.setCollections(result);
        col.setTotalPages(dao.getTotalPages());
        col.setCurrentPage(dao.getCurrentPage());
        col.setPageLines(dao.getPageLines());
        col.setTotalLines(dao.getTotalLines());
        col.setRecordNumber(result.size());
        return col;
    }

    public static BaseProductionValueCoefficient addToProductionValueCoefficient(BaseProductionValueCoefficient productionvaluecoefficient) throws Exception {
        return addToProductionValueCoefficient(productionvaluecoefficient, false);
    }

    public static BaseProductionValueCoefficient addToProductionValueCoefficient(BaseProductionValueCoefficient productionvaluecoefficient, boolean singleTransaction) throws Exception {
        if (singleTransaction) ThreadConnection.beginTransaction();
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        dao.setDataFromBase(productionvaluecoefficient);
        int result = dao.save();
        if (singleTransaction) ThreadConnection.commit();
        return result == 1 ? dao.generateBase() : null;
    }

    public static BaseProductionValueCoefficient addUpdateProductionValueCoefficient(BaseProductionValueCoefficient productionvaluecoefficient) throws Exception {
        return addUpdateProductionValueCoefficient(productionvaluecoefficient, false);
    }

    public static BaseProductionValueCoefficient addUpdateProductionValueCoefficient(BaseProductionValueCoefficient productionvaluecoefficient, boolean singleTransaction) throws Exception {
        if (productionvaluecoefficient.getProductionValueCoefficientId() == null)
            return addToProductionValueCoefficient(productionvaluecoefficient);
        if (singleTransaction) ThreadConnection.beginTransaction();
        StringBuilder sb = new StringBuilder();
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        dao.setDataFromBase(productionvaluecoefficient);
        int result = 0;
        if (dao.load()) {
            dao.setDataFromBase(productionvaluecoefficient);
            if (dao.isThisObjectModified()) {
                result = dao.update();
            } else result = 1;
        } else result = dao.save();
        if (singleTransaction) ThreadConnection.commit();
        return result == 1 ? dao.generateBase() : null;
    }

    public static int deleteProductionValueCoefficient(BaseProductionValueCoefficient bean) throws Exception {
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        if (setDeleteConditions(bean, dao) == 0) return 0;
        int result = dao.conditionalDelete();
        return result;
    }

    public static BaseProductionValueCoefficient updateProductionValueCoefficient(BaseProductionValueCoefficient productionvaluecoefficient) throws Exception {
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        dao.setProductionValueCoefficientId(productionvaluecoefficient.getProductionValueCoefficientId());
        int result = 0;
        if (dao.load()) {
            dao.setDataFromBase(productionvaluecoefficient);
            result = dao.update();
        }
        return result == 1 ? productionvaluecoefficient : null;
    }

    public static BaseProductionValueCoefficient updateProductionValueCoefficientDirect(BaseProductionValueCoefficient productionvaluecoefficient) throws Exception {
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        int result = 0;
        dao.setDataFromBase(productionvaluecoefficient);
        result = dao.update();
        return result == 1 ? productionvaluecoefficient : null;
    }

    public static int setDeleteConditions(BaseProductionValueCoefficient bean, ProductionValueCoefficient dao) {
        int count = 0;
        boolean foundKey = false;
        if (bean.getProductionValueCoefficientId() != null) {
            dao.setConditionProductionValueCoefficientId("=", bean.getProductionValueCoefficientId());
            count++;
            foundKey = true;
        }
        if (!foundKey) {
            if (bean.getProductionValueCoefficientTypeId() != null) {
                dao.setConditionProductionValueCoefficientTypeId("=", bean.getProductionValueCoefficientTypeId());
                count++;
            }
            if (bean.getEmployeeId() != null) {
                dao.setConditionEmployeeId("=", bean.getEmployeeId());
                count++;
            }
            if (bean.getIntervalRange() != null) {
                dao.setConditionIntervalRange("=", bean.getIntervalRange());
                count++;
            }
        }
        return count;
    }

    public static int setConditions(BaseProductionValueCoefficient bean, ProductionValueCoefficient dao) {
        int count = 0;
        if (bean.getProductionValueCoefficientId() != null) {
            dao.setConditionProductionValueCoefficientId("=", bean.getProductionValueCoefficientId());
            count++;
        }
        if (bean.getProductionValueCoefficientTypeId() != null) {
            dao.setConditionProductionValueCoefficientTypeId("=", bean.getProductionValueCoefficientTypeId());
            count++;
        }
        if (bean.getProductionMin() != null) {
            dao.setConditionProductionMin("=", bean.getProductionMin());
            count++;
        }
        if (bean.getProductionMax() != null) {
            dao.setConditionProductionMax("=", bean.getProductionMax());
            count++;
        }
        if (bean.getIntervalLines() != null) {
            dao.setConditionIntervalLines("=", bean.getIntervalLines());
            count++;
        }
        if (bean.getCoefficient() != null) {
            dao.setConditionCoefficient("=", bean.getCoefficient());
            count++;
        }
        if (bean.getEmployeeId() != null) {
            dao.setConditionEmployeeId("=", bean.getEmployeeId());
            count++;
        }
        if (bean.getOperationTime() != null) {
            dao.setConditionOperationTime(">=", bean.getOperationTime());
            count++;
        }
        if (bean.getCreateTime() != null) {
            dao.setConditionCreateTime(">=", bean.getCreateTime());
            count++;
        }
        if (bean.getIntervalRange() != null) {
            if (bean.getIntervalRange().indexOf("%") >= 0)
                dao.setConditionIntervalRange("like", bean.getIntervalRange());
            else
                dao.setConditionIntervalRange("=", bean.getIntervalRange());
            count++;
        }
        return count;
    }

    @Override
    public String findUsingKey(String json) throws Exception {
        BaseProductionValueCoefficient bean = new BaseProductionValueCoefficient();
        bean.setDataFromJSON(json);
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        dao.setPrimaryKeyFromBase(bean);
        if (dao.load()) {
            dao.setDataToBase(bean);
            return bean.toOneLineJSON(1, null);
        }
        return bean.toOneLineJSON(0, "Record not found.");
    }

    @Override
    public String find(String json, int currentPage, int pageSize, String addtion) throws Exception {
        BaseCollection<BaseProductionValueCoefficient> rlist = new BaseCollection<>();
        BaseProductionValueCoefficient bean = new BaseProductionValueCoefficient();
        Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
        bean.setDataFromMap(params);
        PaginationParameter pp = PaginationParameter.generateFromMap(params);
        if (pp != null) {
            if (pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
            if (pp.getPageSize() > 0) pageSize = pp.getPageSize();
            if (pp.getCondition() != null) addtion = pp.getCondition();
        }
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        setConditions(bean, dao);
        dao.setCurrentPage(currentPage);
        dao.setPageLines(pageSize);
        List<BaseProductionValueCoefficient> result = dao.conditionalLoad(addtion);
        rlist.setCollections(result);
        rlist.setTotalPages(dao.getTotalPages());
        rlist.setCurrentPage(dao.getCurrentPage());
        rlist.setPageLines(dao.getPageLines());
        rlist.setTotalLines(dao.getTotalLines());
        rlist.setRecordNumber(result.size());
        return rlist.toJSON(null);
    }

    @Override
    public String save(String json) throws Exception {
        BaseProductionValueCoefficient bean = new BaseProductionValueCoefficient();
        bean.setDataFromJSON(json);
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        dao.setDataFromBase(bean);
        int num = dao.save();
        dao.setDataToBase(bean);
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String update(String json) throws Exception {
        BaseProductionValueCoefficient bean = new BaseProductionValueCoefficient();
        bean.setDataFromJSON(json);
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        dao.setPrimaryKeyFromBase(bean);
        int num = 0;
        if (dao.load()) {
            dao.setDataFromBase(bean);
            num = dao.update();
        }
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String delete(String json) throws Exception {
        BaseProductionValueCoefficient bean = new BaseProductionValueCoefficient();
        bean.setDataFromJSON(json);
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        setDeleteConditions(bean, dao);
        int num = dao.conditionalDelete();
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String saveOrUpdate(String json) throws Exception {
        BaseProductionValueCoefficient bean = new BaseProductionValueCoefficient();
        bean.setDataFromJSON(json);
        ProductionValueCoefficient dao = new ProductionValueCoefficient();
        dao.setPrimaryKeyFromBase(bean);
        int ret = 0;
        if (dao.isPrimaryKeyNull()) {
            dao.setDataFromBase(bean);
            ret = dao.save();
            bean = dao.generateBase();
        } else if (dao.load()) {
            dao.setDataFromBase(bean);
            ret = dao.update();
            bean = dao.generateBase();
        }
        return bean.toOneLineJSON(ret, null);
    }

}


