package pomplatform.plateproductionvalue.handler;


import com.pomplatform.db.bean.BaseProductionValueCoefficient;
import com.pomplatform.db.dao.ProductionValueCoefficient;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.date.util.TimeSpanCalculator;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import org.apache.log4j.Logger;
import org.postgresql.util.PSQLException;
import pomplatform.plateproductionvalue.bean.BaseProductionValueCoefficientTypeWithP;
import pomplatform.plateproductionvalue.dao.ProductionValueCoefficientTypeWithP;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProductionValueCoefficientTypeWithPHandler implements GenericDao {

    public final static ThreadLocal currentRequest = new ThreadLocal();

    private static final Logger __logger = Logger.getLogger(ProductionValueCoefficientTypeWithPHandler.class);

    public static BaseProductionValueCoefficientTypeWithP getProductionValueCoefficientTypeWithPById(Integer production_value_coefficient_type_id) {
        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            BaseProductionValueCoefficientTypeWithP result;
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            dao.setProductionValueCoefficientTypeId(production_value_coefficient_type_id);
            if (dao.load(true)) {
                result = dao.generateBaseExt();
                tsc.recordTime();
                __logger.info(String.format("Get ProductionValueCoefficientTypeWithP By ID time used : [%1$d]", tsc.getLastTime()));
                return result;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean isProductionValueCoefficientTypeWithPExists(BaseProductionValueCoefficientTypeWithP bean, String additional) {

        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            setConditions(bean, dao);
            boolean res = dao.isExist(additional);
            tsc.recordTime();
            __logger.info(String.format("Query ProductionValueCoefficientTypeWithP List time used : [%1$d]", tsc.getLastTime()));
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static int countProductionValueCoefficientTypeWithP(BaseProductionValueCoefficientTypeWithP bean, String additional) {

        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            setConditions(bean, dao);
            int res = dao.countRows(additional);
            tsc.recordTime();
            __logger.info(String.format("Query ProductionValueCoefficientTypeWithP List time used : [%1$d]", tsc.getLastTime()));
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static BaseCollection<BaseProductionValueCoefficientTypeWithP> queryProductionValueCoefficientTypeWithP(BaseProductionValueCoefficientTypeWithP bean, int pageNo, int pageLines, String additionalCondition) {
        __logger.info(String.format("Current Page No. [%1$d]", pageNo));
        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            setConditions(bean, dao);
            dao.setCurrentPage(pageNo);
            dao.setPageLines(pageLines);
            List<BaseProductionValueCoefficientTypeWithP> result = dao.conditionalLoadExt(additionalCondition);
            BaseCollection<BaseProductionValueCoefficientTypeWithP> col = new BaseCollection<>();
            col.setCollections(result);
            col.setTotalPages(dao.getTotalPages());
            col.setCurrentPage(dao.getCurrentPage());
            col.setPageLines(dao.getPageLines());
            col.setTotalLines(dao.getTotalLines());
            col.setRecordNumber(result.size());
            tsc.recordTime();
            __logger.info(String.format("Query ProductionValueCoefficientTypeWithP List time used : [%1$d]", tsc.getLastTime()));
            return col;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static BaseProductionValueCoefficientTypeWithP addToProductionValueCoefficientTypeWithP(BaseProductionValueCoefficientTypeWithP productionvaluecoefficienttypewithp) {
        return addToProductionValueCoefficientTypeWithP(productionvaluecoefficienttypewithp, false);
    }

    public static BaseProductionValueCoefficientTypeWithP addToProductionValueCoefficientTypeWithP(BaseProductionValueCoefficientTypeWithP productionvaluecoefficienttypewithp, boolean singleTransaction) {
        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            if (singleTransaction) ThreadConnection.beginTransaction();
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            dao.setDataFromBase(productionvaluecoefficienttypewithp);
            int result = dao.save();
            if (singleTransaction) ThreadConnection.commit();
            tsc.recordTime();
            __logger.info(String.format("Add to ProductionValueCoefficientTypeWithP time used : [%1$d]", tsc.getLastTime()));
            return result == 1 ? dao.generateBaseExt() : null;
        } catch (Exception ex) {
            if (singleTransaction) ThreadConnection.rollback();
            ex.printStackTrace();
            return null;
        }
    }

    public static BaseProductionValueCoefficientTypeWithP addUpdateProductionValueCoefficientTypeWithP(BaseProductionValueCoefficientTypeWithP productionvaluecoefficienttypewithp) {
        return addUpdateProductionValueCoefficientTypeWithP(productionvaluecoefficienttypewithp, false);
    }

    public static BaseProductionValueCoefficientTypeWithP addUpdateProductionValueCoefficientTypeWithP(BaseProductionValueCoefficientTypeWithP productionvaluecoefficienttypewithp, boolean singleTransaction) {
        if (productionvaluecoefficienttypewithp.getProductionValueCoefficientTypeId() == null)
            return addToProductionValueCoefficientTypeWithP(productionvaluecoefficienttypewithp);
        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            if (singleTransaction) ThreadConnection.beginTransaction();
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            dao.setDataFromBase(productionvaluecoefficienttypewithp);
            int result = 0;
            if (dao.load()) {
                dao.setDataFromBase(productionvaluecoefficienttypewithp);
                if (dao.isThisObjectModified()) {
                    result = dao.update();
                } else result = 1;
            } else result = dao.save();
            if (singleTransaction) ThreadConnection.commit();
            tsc.recordTime();
            __logger.info(String.format("Add to ProductionValueCoefficientTypeWithP time used : [%1$d]", tsc.getLastTime()));
            return result == 1 ? dao.generateBaseExt() : null;
        } catch (Exception ex) {
            if (singleTransaction) ThreadConnection.rollback();
            ex.printStackTrace();
            return null;
        }
    }

    public static BaseProductionValueCoefficientTypeWithP deleteProductionValueCoefficientTypeWithP(BaseProductionValueCoefficientTypeWithP bean) {
        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            setDeleteConditions(bean, dao);
            int result = dao.conditionalDelete();
            tsc.recordTime();
            __logger.info(String.format("Delete ProductionValueCoefficientTypeWithP time used : [%1$d]", tsc.getLastTime()));
            return result == 1 ? bean : null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static BaseProductionValueCoefficientTypeWithP updateProductionValueCoefficientTypeWithP(BaseProductionValueCoefficientTypeWithP productionvaluecoefficienttypewithp) {
        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            dao.setProductionValueCoefficientTypeId(productionvaluecoefficienttypewithp.getProductionValueCoefficientTypeId());
            int result = 0;
            if (dao.load()) {
                dao.setDataFromBase(productionvaluecoefficienttypewithp);
                result = dao.update();
            }
            tsc.recordTime();
            __logger.info(String.format("Update ProductionValueCoefficientTypeWithP time used : [%1$d]", tsc.getLastTime()));
            return result == 1 ? productionvaluecoefficienttypewithp : null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static BaseProductionValueCoefficientTypeWithP updateProductionValueCoefficientTypeWithPDirect(BaseProductionValueCoefficientTypeWithP productionvaluecoefficienttypewithp) {
        try {
            TimeSpanCalculator tsc = new TimeSpanCalculator();
            tsc.recordTime();
            ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
            int result = 0;
            dao.setDataFromBase(productionvaluecoefficienttypewithp);
            result = dao.update();
            tsc.recordTime();
            __logger.info(String.format("Update ProductionValueCoefficientTypeWithP time used : [%1$d]", tsc.getLastTime()));
            return result == 1 ? productionvaluecoefficienttypewithp : null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static int setDeleteConditions(BaseProductionValueCoefficientTypeWithP bean, ProductionValueCoefficientTypeWithP dao) {
        int count = 0;
        boolean foundKey = false;
        if (bean.getProductionValueCoefficientTypeId() != null) {
            dao.setProductionValueCoefficientTypeId(bean.getProductionValueCoefficientTypeId());
            dao.setConditionProductionValueCoefficientTypeId("=", bean.getProductionValueCoefficientTypeId());
            count++;
            foundKey = true;
        }
        if (!foundKey) {
            if (bean.getCoefficientType() != null) {
                dao.setConditionCoefficientType("=", bean.getCoefficientType());
                count++;
            }
        }
        return count;
    }

    public static int setConditions(BaseProductionValueCoefficientTypeWithP bean, ProductionValueCoefficientTypeWithP dao) {
        int count = 0;
        if (bean.getProductionValueCoefficientTypeId() != null) {
            dao.setConditionProductionValueCoefficientTypeId("=", bean.getProductionValueCoefficientTypeId());
            count++;
        }
        if (bean.getCoefficientType() != null) {
            if (bean.getCoefficientType().indexOf("%") >= 0)
                dao.setConditionCoefficientType("like", bean.getCoefficientType());
            else
                dao.setConditionCoefficientType("=", bean.getCoefficientType());
            count++;
        }
        return count;
    }

    @Override
    public String findUsingKey(String json) throws Exception {
        BaseProductionValueCoefficientTypeWithP bean = new BaseProductionValueCoefficientTypeWithP();
        bean.setDataFromJSON(json);
        ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
        dao.setPrimaryKeyFromBase(bean);
        if (dao.load(true)) {
            dao.setDataToBase(bean);
            return bean.toOneLineJSON(1, null);
        }
        return bean.toOneLineJSON(0, "Record not found.");
    }

    @Override
    public String find(String json, int currentPage, int pageSize, String addtion) throws Exception {
        BaseCollection<BaseProductionValueCoefficientTypeWithP> rlist = new BaseCollection<>();
        BaseProductionValueCoefficientTypeWithP bean = new BaseProductionValueCoefficientTypeWithP();
        JSON parser = new JSON(new StringReader(json));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        bean.setDataFromMap(params);
        PaginationParameter pp = PaginationParameter.generateFromMap(params);
        if (pp != null) {
            if (pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
            if (pp.getPageSize() > 0) pageSize = pp.getPageSize();
            if (pp.getCondition() != null) addtion = pp.getCondition();
        }
        ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
        setConditions(bean, dao);
        dao.setCurrentPage(currentPage);
        dao.setPageLines(pageSize);
        List<BaseProductionValueCoefficientTypeWithP> result = dao.conditionalLoadExt(addtion);
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

        BaseProductionValueCoefficient baseBean = new BaseProductionValueCoefficient();
        baseBean.setDataFromJSON(json);

        BaseProductionValueCoefficientTypeWithP bean = new BaseProductionValueCoefficientTypeWithP();
        bean.setDataFromJSON(json);

        if (BaseHelpUtils.isNullOrEmpty(bean.getCoefficientType())) {
            return bean.toOneLineJSON(-1, "类型不能为空");
        }
        ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
        ThreadConnection.beginTransaction();

        List<BaseProductionValueCoefficient> baseProductionValueCoefficients = bean.getDetailProductionValueCoefficient();

        int employeeId = baseBean.getEmployeeId();
        String getIntervalRange = "";

        BigDecimal productionMin = null;
        BigDecimal productionMax = null;


        int count = 0;
        try {
            for (int i = 0; i < baseProductionValueCoefficients.size(); i++) {
                //最大值初始化
                BigDecimal maxProduction = baseProductionValueCoefficients.get(0).getProductionMax();
                BigDecimal myProductionMin = baseProductionValueCoefficients.get(i).getProductionMin();
                BigDecimal myProductionMax = baseProductionValueCoefficients.get(i).getProductionMax();
                baseProductionValueCoefficients.get(i).setCreateTime(DateUtil.getToday());
                baseProductionValueCoefficients.get(i).setOperationTime(DateUtil.getToday());
                baseProductionValueCoefficients.get(i).setEmployeeId(employeeId);

                if (myProductionMin == null) {
                    return bean.toOneLineJSON(-1, "产值系数的最小值不能为空");
                }

                if (myProductionMax != null && myProductionMin.compareTo(myProductionMax) == 1) {
                    return bean.toOneLineJSON(-1, "最大值不能小于最小值");
                }

                if (myProductionMax != null && myProductionMin.compareTo(myProductionMax) == 0) {
                    return bean.toOneLineJSON(-1, "最大值不能等于最小值");
                }

                //获取最大值中最大的那个
                if (myProductionMax != null && maxProduction.compareTo(myProductionMax) > -1) {
                    maxProduction = myProductionMax;
                }

                if (myProductionMax == null) {
                    if (myProductionMin.compareTo(maxProduction) > -1) {
                        baseProductionValueCoefficients.get(i).setIntervalLines(myProductionMin);
                        baseProductionValueCoefficients.get(i).setIntervalRange(myProductionMin + "及以上");
                    } else {
                        return bean.toOneLineJSON(-1, "产值系数最大值不正确，请重新输入");
                    }
                    if (count != 0) {
                        return bean.toOneLineJSON(-1, "已经有产值系数最大值，请删除或修改之前的产值最大值");
                    } else {
                        baseProductionValueCoefficients.get(i).setIntervalLines(myProductionMin);
                        baseProductionValueCoefficients.get(i).setIntervalRange(myProductionMin + "及以上");
                    }
                    count++;
                } else {
                    BigDecimal bigDecimal = myProductionMax.subtract(myProductionMin);
                    baseProductionValueCoefficients.get(i).setIntervalLines(bigDecimal);
                    baseProductionValueCoefficients.get(i).setIntervalRange(myProductionMin + "-" + myProductionMax);

                    if (i > 0) {
                        int minAndmin = productionMin.compareTo(myProductionMin);
                        int minAndmax = productionMin.compareTo(myProductionMax);
                        int maxAndmin = productionMax.compareTo(myProductionMin);
                        int maxAndmax = productionMax.compareTo(myProductionMax);

                        if (getIntervalRange.equals(baseProductionValueCoefficients.get(i).getIntervalRange())) {
                            return bean.toOneLineJSON(-1, "最小值不能等于最大值，请重新填写");
                        } else if (minAndmin == 1 && minAndmax == -1 || minAndmin < 1 && maxAndmax > -1 || maxAndmin == 1 && maxAndmax == -1) {
                            return bean.toOneLineJSON(-1, "区间范围" + productionMin + "-" + productionMax + "有重复，请重新填写");
                        }
                    }
                }

                getIntervalRange = baseProductionValueCoefficients.get(i).getIntervalRange();
                productionMin = baseProductionValueCoefficients.get(i).getProductionMin();
                productionMax = baseProductionValueCoefficients.get(i).getProductionMax();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!BaseHelpUtils.isNullOrEmpty(bean)) {
            dao.setDataFromBase(bean);
        } else {
            return bean.toOneLineJSON(-1, "保存失败");
        }

        int num;
        try {
            num = dao.save();
            dao.setDataToBase(bean);
            ThreadConnection.commit();
            return bean.toOneLineJSON(num, null);
        } catch (PSQLException e) {
            e.printStackTrace();
            return bean.toOneLineJSON(-1, "保存失败类型不能重复，请重新填写");
        }
    }

    @Override
    public String saveOrUpdate(String json) throws Exception {
        BaseProductionValueCoefficientTypeWithP bean = new BaseProductionValueCoefficientTypeWithP();
        bean.setDataFromJSON(json);
        int num = 0;
        ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
        ThreadConnection.beginTransaction();
        dao.setDataFromBase(bean);
        if (dao.isPrimaryKeyNull()) num = dao.save();

        else if (dao.load()) {
            dao.setDataFromBase(bean);
            num = dao.update();
        }

        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }

    @Override
    public String update(String json) throws Exception {
        BaseProductionValueCoefficient baseBean = new BaseProductionValueCoefficient();
        baseBean.setDataFromJSON(json);

        BaseProductionValueCoefficientTypeWithP bean = new BaseProductionValueCoefficientTypeWithP();
        bean.setDataFromJSON(json);
        ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
        ThreadConnection.beginTransaction();

        List<BaseProductionValueCoefficient> baseProductionValueCoefficients = bean.getDetailProductionValueCoefficient();

        int employeeId = baseBean.getEmployeeId();
        Date createTime = baseBean.getCreateTime();
        String getIntervalRange = "";
        BigDecimal productionMin = null;
        BigDecimal productionMax = null;
        if (BaseHelpUtils.isNullOrEmpty(bean.getCoefficientType())) {
            return bean.toOneLineJSON(-1, "类型不能为空");
        }
        int count = 0;
        for (int i = 0; i < baseProductionValueCoefficients.size(); i++) {
            BigDecimal maxProduction = baseProductionValueCoefficients.get(0).getProductionMax();

            BigDecimal myProductionMin = baseProductionValueCoefficients.get(i).getProductionMin();
            BigDecimal myProductionMax = baseProductionValueCoefficients.get(i).getProductionMax();
            baseProductionValueCoefficients.get(i).setCreateTime(createTime);
            baseProductionValueCoefficients.get(i).setOperationTime(DateUtil.getToday());
            baseProductionValueCoefficients.get(i).setEmployeeId(employeeId);

            if (myProductionMin == null) {
                return bean.toOneLineJSON(-1, "产值系数的最小值不能为空");
            }
            if (myProductionMax != null && myProductionMin.compareTo(myProductionMax) == 1) {
                return bean.toOneLineJSON(-1, "最大值不能小于最小值");
            }

            if (myProductionMax != null &&myProductionMin.compareTo(myProductionMax) == 0) {
                return bean.toOneLineJSON(-1, "最大值不能等于最小值");
            }
            if (myProductionMax != null && maxProduction.compareTo(myProductionMax) > -1) {
                maxProduction = myProductionMax;
            }
            try {
                if (myProductionMax == null) {
                    if (myProductionMin.compareTo(maxProduction) > -1) {
                        baseProductionValueCoefficients.get(i).setIntervalLines(myProductionMin);
                        baseProductionValueCoefficients.get(i).setIntervalRange(myProductionMin + "及以上");
                    } else {
                        return bean.toOneLineJSON(-1, "产值系数最大值不正确，请重新输入");
                    }
                    if (count != 0) {
                        return bean.toOneLineJSON(-1, "已经有产值系数最大值，请删除或修改之前的产值最大值");
                    } else {
                        baseProductionValueCoefficients.get(i).setIntervalLines(myProductionMin);
                        baseProductionValueCoefficients.get(i).setIntervalRange(myProductionMin + "及以上");
                    }

                    count++;

                } else {
                    BigDecimal bigDecimal = myProductionMax.subtract(myProductionMin);
                    baseProductionValueCoefficients.get(i).setIntervalLines(bigDecimal);
                    baseProductionValueCoefficients.get(i).setIntervalRange(myProductionMin + "-" + myProductionMax);

                    if (i > 0) {
                        int minAndmin = productionMin.compareTo(myProductionMin);
                        int minAndmax = productionMin.compareTo(myProductionMax);
                        int maxAndmin = productionMax.compareTo(myProductionMin);
                        int maxAndmax = productionMax.compareTo(myProductionMax);

                        if (getIntervalRange.equals(baseProductionValueCoefficients.get(i).getIntervalRange())) {
                            return bean.toOneLineJSON(-1, "最小值不能等于最大值，请重新填写");
                        } else if (minAndmin == 1 && minAndmax == -1 || minAndmin < 1 && maxAndmax > -1 || maxAndmin == 1
                                && maxAndmax == -1) {
                            return bean.toOneLineJSON(-1, "区间范围" + productionMin + "~" + productionMax
                                    + "有重复，请重新填写");
                        }
                    }

                }
                getIntervalRange = baseProductionValueCoefficients.get(i).getIntervalRange();
                productionMin = baseProductionValueCoefficients.get(i).getProductionMin();
                productionMax = baseProductionValueCoefficients.get(i).getProductionMax();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        dao.setPrimaryKeyFromBase(bean);
        int num = 0;
        try {
            if (dao.load()) {
                dao.setDataFromBase(bean);
                num = dao.update();
            }
            ThreadConnection.commit();
            return bean.toOneLineJSON(num, null);
        } catch (PSQLException e) {
            e.printStackTrace();
            return bean.toOneLineJSON(-1, "保存失败类型不能重复，请重新填写");
        }
    }


    @Override
    public String delete(String json) throws Exception {
        BaseProductionValueCoefficientTypeWithP bean = new BaseProductionValueCoefficientTypeWithP();
        bean.setDataFromJSON(json);

        ProductionValueCoefficientTypeWithP dao = new ProductionValueCoefficientTypeWithP();
        ProductionValueCoefficient pvDao = new ProductionValueCoefficient();

        ThreadConnection.beginTransaction();

        //删除掉产值类型
        List<BaseProductionValueCoefficient> baseProductionValueCoefficients = bean.getDetailProductionValueCoefficient();
        for (BaseProductionValueCoefficient base : baseProductionValueCoefficients) {
            pvDao.setProductionValueCoefficientTypeId(base.getProductionValueCoefficientTypeId());
            pvDao.delete();
        }

        dao.setDataFromBase(bean);
        setDeleteConditions(bean, dao);
        int num = dao.conditionalDelete();
        ThreadConnection.commit();
        return bean.toOneLineJSON(num, null);
    }

}


