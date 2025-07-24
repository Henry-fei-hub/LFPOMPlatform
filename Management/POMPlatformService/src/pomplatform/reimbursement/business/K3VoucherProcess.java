package pomplatform.reimbursement.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractReceivable;
import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.bean.BaseK3Code;
import com.pomplatform.db.bean.BaseK3Voucher;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectPerformance;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.bean.BaseRevenueStatisticalRecord;
import com.pomplatform.db.dao.AttachmentManage;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractReceivable;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.Invoice;
import com.pomplatform.db.dao.K3Code;
import com.pomplatform.db.dao.K3Voucher;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.RevenueStatisticalRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.capital.bean.BaseCapitalVoucher;
import pomplatform.capital.bean.ConditionCapitalVoucher;
import pomplatform.capital.query.QueryCapitalVoucher;
import pomplatform.common.utils.StaticUtils;
import pomplatform.insuranceandhousingfund.bean.BaseInsuranceAndHousingFundVoucherInfo;
import pomplatform.insuranceandhousingfund.bean.ConditionInsuranceAndHousingFundVoucherInfo;
import pomplatform.insuranceandhousingfund.query.QueryInsuranceAndHousingFundVoucherInfo;
import pomplatform.invoice.bean.BaseInvoiceVoucher;
import pomplatform.invoice.bean.ConditionInvoiceVoucher;
import pomplatform.invoice.query.QueryInvoiceVoucher;
import pomplatform.reimbursement.bean.BaseK3VoucherSummary;
import pomplatform.reimbursement.bean.BaseReimbursementpackagemmror;
import pomplatform.salarytotalrecord.bean.BaseSalaryVoucherInfo;
import pomplatform.salarytotalrecord.bean.ConditionSalaryVoucherInfo;
import pomplatform.salarytotalrecord.query.QuerySalaryVoucherInfo;

public class K3VoucherProcess implements GenericProcessor {

    //操作类型
    private static final String OPT_TYPE = "optType";
    //批量删除凭证(具体指定了哪几条凭证的)
    private static final String DELETE_VOUCHER = "deleteVoucher";
    //修改归属日期
    private static final String UPDATE_VESTING_DATE = "updateVestingDate";
    //生成凭证
    private static final String CREATE_VOUCHER = "createVoucher";
    //定稿
    private static final String LOCK_VOUCHER = "lockVoucher";
    //根据汇总报销单的单号来删除该汇总单下面的所有凭证
    private static final String DELETE_VOUCHER_BY_CODE = "deleteVoucherByCode";
    //上移，调整内部序列号
    private static final String MOVE_UP = "moveUp";
    //下移，调整内部序列号
    private static final String MOVE_DOWN = "moveDown";
    //修改k3凭证
    private static final String UPDATE_K3_VOUCHER = "updateK3Voucher";
    //新增k3凭证
    private static final String SAVE_K3_VOUCHER = "saveK3Voucher";
    //生成发票的k3凭证
    private static final String CREATE_INVOICE_K3_VOUCHER = "createInvoiceK3Voucher";
    //根据发票ID删除发票的k3凭证
    private static final String DELETE_INVOICE_K3_VOUCHER = "deleteInvoiceK3Voucher";
    //生成回款的k3凭证
    private static final String CREATE_CAPITAL_K3_VOUCHER = "createCapitalK3Voucher";
    //根据回款ID删除回款的k3凭证
    private static final String DELETE_CAPITAL_K3_VOUCHER = "deleteCapitalK3Voucher";
    //根据凭证号来定稿
    private static final String LOCK_VOUCHER_BY_SEQUENCE_NUMBER = "lockVoucherBySequenceNumber";
    //根据凭证号来取消定稿
    private static final String UNLOCK_VOUCHER_BY_SEQUENCE_NUMBER = "unlockVoucherBySequenceNumber";
    //根据凭证号来删除凭证
    private static final String DELETE_VOUCHER_BY_SEQUENCE_NUMBER = "deleteVoucherBySequenceNumber";
    //生成收入的K3凭证
    private static final String CREATE_RECEIVABLES_K3_VOUCHER = "createReceivablesK3Voucher";
    //生成年度营收的K3凭证
    private static final String CREATE_RECEIVABLES_K3_VOUCHER_BY_YEAR = "createReceivablesK3VoucherByYear";
    //生成确认函的K3凭证
    private static final String CREATE_ATTACHMENT_K3_VOUCHER = "createAttachmentK3Voucher";
    //删除确认函的K3凭证
    private static final String DELETE_ATTCHMENT_K3_VOUCHER = "deleteAttchmentK3Voucher";
    //生成五险一金凭证
    private static final String CREATE_INSURANCE_AND_HOUSING_FUND_K3_VOUCHER = "createInsuranceAndHousingFundK3Voucher";
    //生成工资的凭证
    private static final String CREATE_SALARY_K3_VOUCHER = "createSalaryK3Voucher";
    //页面双击修改k3凭证数据
    private static final String UPDATE_K3_VOUCHER_BY_DOUBLE_CLICK = "updateK3VoucherByDoubleClick";
    /**
     * 部门类型：营销部门
     */
    private final Integer DEPARTMENT_TYPE_0 = 0;
    /**
     * 部门类型：职能部门
     */
    private final Integer DEPARTMENT_TYPE_1 = 1;
    /**
     * 部门类型：业务部门
     */
    private final Integer DEPARTMENT_TYPE_2 = 2;
    /**
     * 部门类型：研发部门
     */
    private final Integer DEPARTMENT_TYPE_3 = 3;

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
        JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
        switch (optType) {
            case DELETE_VOUCHER:
                return deleteVoucher(params);
            case UPDATE_VESTING_DATE:
                return updateVestingDate(params);
            case CREATE_VOUCHER:
                return createVoucher(params);
            case LOCK_VOUCHER:
                return lockVoucher(params);
            case DELETE_VOUCHER_BY_CODE:
                return deleteVoucherByCode(params);
            case MOVE_UP:
                return moveUp(params);
            case MOVE_DOWN:
                return moveDown(params);
            case UPDATE_K3_VOUCHER:
                return updateK3Voucher(params);
            case SAVE_K3_VOUCHER:
                return saveK3Voucher(params);
            case CREATE_INVOICE_K3_VOUCHER:
                return createInvoiceK3Voucher(params);
            case DELETE_INVOICE_K3_VOUCHER:
                return deleteInvoiceK3Voucher(params);
            case CREATE_CAPITAL_K3_VOUCHER:
                return createCapitalK3Voucher(params);
            case DELETE_CAPITAL_K3_VOUCHER:
                return deleteCapitalK3Voucher(params);
            case LOCK_VOUCHER_BY_SEQUENCE_NUMBER:
                return lockVoucherBySequenceNumber(params);
            case UNLOCK_VOUCHER_BY_SEQUENCE_NUMBER:
                return unlockVoucherBySequenceNumber(params);
            case DELETE_VOUCHER_BY_SEQUENCE_NUMBER:
                return deleteVoucherBySequenceNumber(params);
            case CREATE_RECEIVABLES_K3_VOUCHER:
                return createReceivablesK3Voucher(params);
            case CREATE_RECEIVABLES_K3_VOUCHER_BY_YEAR:
                return createReceivablesK3VoucherByYear(params);
            case CREATE_ATTACHMENT_K3_VOUCHER:
                return createAttachmentK3Voucher(params);
            case DELETE_ATTCHMENT_K3_VOUCHER:
                return deleteAttchmentK3Voucher(params);
            case CREATE_INSURANCE_AND_HOUSING_FUND_K3_VOUCHER:
                return createInsuranceAndHousingFundK3Voucher(params);
            case CREATE_SALARY_K3_VOUCHER:
                return createSalaryK3Voucher(params);
            case UPDATE_K3_VOUCHER_BY_DOUBLE_CLICK:
            	return updateK3VoucherByDoubleClick(params);
            default:
                return null;
        }
    }

    /**
     * 删除确认函的凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String deleteAttchmentK3Voucher(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        List idList = (ArrayList) params.get("sequenceNumber");
        if (null != idList && !idList.isEmpty()) {
            int size = idList.size();
            Integer[] sequenceNumbers = new Integer[size];
            for (int i = 0; i < size; i++) {
                sequenceNumbers[i] = BaseHelpUtils.getIntValue(idList.get(i));
            }
            K3Voucher dao = new K3Voucher();
            dao.addCondition(BaseK3Voucher.CS_SEQUENCE_NUMBER, "in", (Object[]) sequenceNumbers);
            ThreadConnection.beginTransaction();
            List<BaseK3Voucher> list = dao.conditionalLoad();
            if (null != list && !list.isEmpty()) {
                Set<Integer> set1 = new HashSet<>();//确认函
                for (BaseK3Voucher obj : list) {
                    set1.add(obj.getLinkId());
                }
                if (set1.size() > 0) {
                    AttachmentManage atDao = new AttachmentManage();
                    atDao.addCondition(BaseAttachmentManage.CS_ATTACHMENT_MANAGE_ID, "in", set1.toArray());
                    atDao.setHaveVoucher(false);
                    atDao.conditionalUpdate();
                }
                dao.conditionalDelete();
            }
            ThreadConnection.commit();
        }
        return bc.toJSON();
    }

    /**
     * 批量删除凭证(具体指定了哪几条凭证的)
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String deleteVoucher(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        if (null != params && !params.isEmpty()) {
            List<BaseK3Voucher> list = GenericBase.__getList(
                    params.get("voucherList"), BaseK3Voucher.newInstance());
            int size = list.size();
            Object[] ids = new Object[size];
            for (int i = 0; i < size; i++) {
                ids[i] = list.get(i).getK3VoucherId();
            }
            ThreadConnection.beginTransaction();
            K3Voucher dao = new K3Voucher();
            dao.addCondition(BaseK3Voucher.CS_K3_VOUCHER_ID, "in", ids);
            List<BaseK3Voucher> beanList = dao.conditionalLoad();
            Set<String> set = new HashSet<>();
            for (BaseK3Voucher bean : beanList) {
                set.add(bean.getReimbursementPackageCode());
                if (bean.getLocked()) {
                    return bc.toJSON(-1, "删除失败，原因：包含已定稿的凭证");
                }
            }
            int num = dao.conditionalDelete();
            for (String code : set) {
                dao.clear();
                dao.setConditionReimbursementPackageCode("=", code);
                List<BaseK3Voucher> tempList = dao.conditionalLoad("order by " + BaseK3Voucher.CS_INTERNAL_SEQUENCE_NUMBER);
                size = tempList.size();
                for (int i = 0; i < size; i++) {
                    BaseK3Voucher bean = tempList.get(i);
                    if (bean.getInternalSequenceNumber().equals(i + 1)) {
                        continue;
                    } else {
                        bean.setInternalSequenceNumber(i + 1);
                        dao.setDataFromBase(bean);
                        dao.update();
                    }
                }
            }
            ThreadConnection.commit();
            return bc.toJSON(num, null);
        }
        return bc.toJSON(-1, null);
    }

    /**
     * 根据汇总报销单的单号来删除该汇总单下面的所有凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String deleteVoucherByCode(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        if (null != params && !params.isEmpty()) {
            List<BaseK3VoucherSummary> list = GenericBase.__getList(
                    params.get("list"), BaseK3VoucherSummary.newInstance());
            Set<String> set = new HashSet<>();
            for (BaseK3VoucherSummary bean : list) {
                set.add(bean.getReimbursementPackageCode());
            }
            for (String code : set) {
                K3Voucher dao = new K3Voucher();
                dao.setConditionReimbursementPackageCode("=", code);
                dao.conditionalDelete();
            }
            return bc.toJSON();
        }
        return bc.toJSON(-1, null);
    }

    /**
     * 设定归属日期
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String updateVestingDate(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        if (null != params && !params.isEmpty()) {
            String dateStr = BaseHelpUtils.getString(params.get("vestingDate"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date vestingDate = DateUtil.getFirstDay(format.parse(dateStr));
            List<BaseK3VoucherSummary> list = GenericBase.__getList(
                    params.get("list"), BaseK3VoucherSummary.newInstance());
            Set<String> set = new HashSet<>();
            for (BaseK3VoucherSummary bean : list) {
                set.add(bean.getReimbursementPackageCode());
            }
            Date date = new Date();
            for (String code : set) {
                K3Voucher dao = new K3Voucher();
                dao.setConditionReimbursementPackageCode("=", code);
                dao.setVestingDate(vestingDate);
                dao.setUpdateTime(date);
                dao.conditionalUpdate();
            }
            return bc.toJSON();
        }
        return bc.toJSON(-1, null);
    }

    /**
     * 根据汇总单ID生成凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String createVoucher(Map<String, Object> params) throws Exception {
        BaseCollection<BaseReceiveUnitManage> bc = new BaseCollection<>();
        if (null != params && !params.isEmpty()) {
            List<BaseReimbursementpackagemmror> list = GenericBase.__getList(
                    params.get("packageList"), BaseReimbursementpackagemmror.newInstance());
            if (null == list || list.isEmpty()) {
                return bc.toJSON(-1, "没有选择需要生产凭证的汇总单");
            }
            int size = list.size();
            Object[] ids = new Object[size];
            for (int i = 0; i < size; i++) {
                ids[i] = list.get(i).getReimbursementPackageId();
            }
            List<BaseReceiveUnitManage> returnList = VoucherUtil.newCreateVoucher(ids);
            if(null != returnList) {
            	bc.setCollections(returnList);
            	return bc.toJSON(-1, "");
            }else {
            	return bc.toJSON();
            }
        }
        return bc.toJSON(-1, null);
    }

    /**
     * 定稿（定稿之后的凭证 无法删除）
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String lockVoucher(Map<String, Object> params) throws Exception {
        BaseCollection<BaseProjectPerformance> bc = new BaseCollection<>();
        if (null != params && !params.isEmpty()) {
            List<BaseK3VoucherSummary> list = GenericBase.__getList(
                    params.get("list"), BaseK3VoucherSummary.newInstance());
            Set<String> set = new HashSet<>();
            for (BaseK3VoucherSummary bean : list) {
                set.add(bean.getReimbursementPackageCode());
            }
            Date date = new Date();
            for (String code : set) {
                K3Voucher dao = new K3Voucher();
                dao.setConditionReimbursementPackageCode("=", code);
                dao.setLocked(true);
                dao.setLockedTime(date);
                dao.conditionalUpdate();
            }
            return bc.toJSON();
        }
        return bc.toJSON(-1, null);
    }

    /**
     * 上移，调整内部序列号
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String moveUp(Map<String, Object> params) throws Exception {
        BaseCollection<BaseProjectPerformance> bc = new BaseCollection<>();
        if (null != params && !params.isEmpty()) {
            ThreadConnection.beginTransaction();
            BaseK3Voucher bean = new BaseK3Voucher();
            bean.setDataFromMap(params);
            K3Voucher dao = new K3Voucher();
            dao.setPrimaryKeyFromBase(bean);
            if (dao.load()) {
                bean = dao.generateBase();
                bean.setInternalSequenceNumber(bean.getInternalSequenceNumber() - 1);
            }
            dao.clear();
            dao.setConditionSequenceNumber("=", bean.getSequenceNumber());
            dao.setConditionInternalSequenceNumber("=", bean.getInternalSequenceNumber());
            BaseK3Voucher bean2 = dao.executeQueryOneRow();
            bean2.setInternalSequenceNumber(bean2.getInternalSequenceNumber() + 1);
            dao.clear();
            dao.setDataFromBase(bean);
            dao.update();
            dao.clear();
            dao.setDataFromBase(bean2);
            dao.update();
            ThreadConnection.commit();
            return bc.toJSON();
        }
        return bc.toJSON(-1, null);
    }

    /**
     * 下移，调整内部序列号
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String moveDown(Map<String, Object> params) throws Exception {
        BaseCollection<BaseProjectPerformance> bc = new BaseCollection<>();
        if (null != params && !params.isEmpty()) {
            ThreadConnection.beginTransaction();
            BaseK3Voucher bean = new BaseK3Voucher();
            bean.setDataFromMap(params);
            K3Voucher dao = new K3Voucher();
            dao.setPrimaryKeyFromBase(bean);
            if (dao.load()) {
                bean = dao.generateBase();
                bean.setInternalSequenceNumber(bean.getInternalSequenceNumber() + 1);
            }
            dao.clear();
            dao.setConditionSequenceNumber("=", bean.getSequenceNumber());
            dao.setConditionInternalSequenceNumber("=", bean.getInternalSequenceNumber());
            BaseK3Voucher bean2 = dao.executeQueryOneRow();
            bean2.setInternalSequenceNumber(bean2.getInternalSequenceNumber() - 1);
            dao.clear();
            dao.setDataFromBase(bean);
            dao.update();
            dao.clear();
            dao.setDataFromBase(bean2);
            dao.update();
            ThreadConnection.commit();
            return bc.toJSON();
        }
        return bc.toJSON(-1, null);
    }

    /**
     * 修改内部序列号时，连带修改相关联的记录的内部序列号
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String updateK3Voucher(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        ThreadConnection.beginTransaction();
        BaseK3Voucher bean = new BaseK3Voucher();
        bean.setDataFromMap(params);
        K3Voucher dao = new K3Voucher();
        dao.setPrimaryKeyFromBase(bean);
        if (dao.load()) {
            int changeBefore = dao.getInternalSequenceNumber();
            int changeAfter = bean.getInternalSequenceNumber();
            if (changeAfter == changeBefore) {
                dao.setDataFromBase(bean);
                dao.update();
            } else {
                //判断新序列号是否在已有的序列号数组内，如果不是，则报错
                //需要修改其他的内部序列号
                K3Voucher dao1 = new K3Voucher();
                dao1.setConditionReimbursementPackageCode("=", bean.getReimbursementPackageCode());
                int num = dao1.countRows();
                if (changeAfter <= num) {
                    dao1.addCondition(BaseK3Voucher.CS_INTERNAL_SEQUENCE_NUMBER, "between", changeAfter > changeBefore ? changeBefore : changeAfter, changeAfter > changeBefore ? changeAfter : changeBefore);
                    List<BaseK3Voucher> list = dao1.conditionalLoad("order by " + BaseK3Voucher.CS_INTERNAL_SEQUENCE_NUMBER);
                    dao.setDataFromBase(bean);
                    dao.update();
                    int orderNo = 0;
                    if (changeAfter < changeBefore) {
                        orderNo = changeAfter + 1;
                    } else {
                        orderNo = changeBefore;
                    }
                    for (BaseK3Voucher obj : list) {
                        if (obj.getInternalSequenceNumber().intValue() == changeBefore) {
                            continue;
                        }
                        obj.setInternalSequenceNumber(orderNo++);
                        dao.setDataFromBase(obj);
                        dao.update();
                    }
                } else {
                    return bc.toJSON(-1, "凭证内序号只能填选0~" + num + "之间的整数");
                }
            }
            ThreadConnection.commit();
            return bc.toJSON();
        }
        return bc.toJSON(-1, "实体数据不存在");
    }

    public String saveK3Voucher(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        ThreadConnection.beginTransaction();
        BaseK3Voucher bean = new BaseK3Voucher();
        bean.setDataFromMap(params);
        K3Voucher dao = new K3Voucher();
        dao.setConditionReimbursementPackageCode("=", bean.getReimbursementPackageCode());
        int num = dao.countRows();
        dao.clear();
        int changeBefore = num;
        int changeAfter = bean.getInternalSequenceNumber();
        if (changeAfter == changeBefore) {
            dao.setDataFromBase(bean);
            dao.save();
        } else {
            //判断新序列号是否在已有的序列号数组内，如果不是，则报错
            //需要修改其他的内部序列号
            K3Voucher dao1 = new K3Voucher();
            dao1.setConditionReimbursementPackageCode("=", bean.getReimbursementPackageCode());
            if (changeAfter <= num) {
                dao1.addCondition(BaseK3Voucher.CS_INTERNAL_SEQUENCE_NUMBER, "between", changeAfter > changeBefore ? changeBefore : changeAfter, changeAfter > changeBefore ? changeAfter : changeBefore);
                List<BaseK3Voucher> list = dao1.conditionalLoad("order by " + BaseK3Voucher.CS_INTERNAL_SEQUENCE_NUMBER);
                dao.setDataFromBase(bean);
                dao.save();
                int orderNo = 0;
                if (changeAfter < changeBefore) {
                    orderNo = changeAfter + 1;
                } else {
                    orderNo = changeBefore;
                }
                for (BaseK3Voucher obj : list) {
                    if (obj.getInternalSequenceNumber().intValue() == changeBefore) {
                        continue;
                    }
                    obj.setInternalSequenceNumber(orderNo++);
                    dao.setDataFromBase(obj);
                    dao.update();
                }
            } else {
                return bc.toJSON(-1, "凭证内序号只能填选0~" + num + "之间的整数");
            }
        }
        ThreadConnection.commit();
        return bc.toJSON();
    }

    public String createInvoiceK3Voucher(Map<String, Object> params) throws Exception {
        BaseCollection collection = new BaseCollection<>();
        StringBuilder errorSb = new StringBuilder();
        try {
            List idList = (ArrayList) params.get("invoiceId");
            if (null != idList && !idList.isEmpty()) {
                K3Voucher dao = new K3Voucher();
                List<BaseK3Voucher> bb = dao
                        .conditionalLoad("order by " + BaseK3Voucher.CS_SEQUENCE_NUMBER + " desc limit 1");
                int sequenceNumber = 1;
                if (null != bb && !bb.isEmpty()) {
                    sequenceNumber = bb.get(0).getSequenceNumber() + 1;
                }
                K3Code codeDao = new K3Code();
                Integer[] codeIds = {StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_1, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_2, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_3, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_4};
                codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_0);
                codeDao.addCondition(BaseK3Code.CS_BUSINESS_ID, "in", (Object[]) codeIds);
                List<BaseK3Code> codeList = codeDao.conditionalLoad();
                Map<Integer, BaseK3Code> codeMap = new HashMap<>();
                for (BaseK3Code obj : codeList) {
                    codeMap.put(obj.getBusinessId(), obj);
                }
                int size = idList.size();
                List<BaseK3Voucher> list = new ArrayList<>();
                Integer[] invoiceIds = new Integer[size];
                for (int i = 0; i < size; i++) {
                    invoiceIds[i] = BaseHelpUtils.getIntValue(idList.get(i));
                }
                for (Integer invoiceId : invoiceIds) {
                    dao.clear();
                    dao.setConditionLinkId("=", invoiceId);
                    dao.setConditionVoucherType("=", StaticUtils.VOUCHER_TYPE_2);
                    if (dao.countRows() > 0) {
                        continue;
                    }
                    ConditionInvoiceVoucher condition = new ConditionInvoiceVoucher();
                    condition.setInvoiceId(invoiceId);
                    QueryInvoiceVoucher query = new QueryInvoiceVoucher();
                    BaseCollection<BaseInvoiceVoucher> bc = query.executeQuery(null, condition);
                    if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
                        int internalSequenceNumber = 0;
                        BaseInvoiceVoucher bean = bc.getCollections().get(0);
                        BaseK3Voucher obj_1 = new BaseK3Voucher();
                        BaseK3Voucher obj_2 = new BaseK3Voucher();
                        BaseK3Voucher obj_3 = new BaseK3Voucher();
                        BaseK3Voucher obj_4 = new BaseK3Voucher();
                        StringBuilder sb = new StringBuilder();
                        sb.append("应收 ");
                        if (null != bean.getCustomerName()) {
                            sb.append(bean.getCustomerName()).append(" ");
                        }
                        if (null != bean.getContractName()) {
                            sb.append(bean.getContractName()).append(" ");
                        }
                        if (null != bean.getInvalidRemark()) {
                            sb.append(bean.getInvalidRemark());
                        }
                        String remark = sb.toString();
                        if (remark.length() > 100) {
                            obj_1.setSimplifyRemark(remark.substring(0, 100));
                        } else {
                            obj_1.setSimplifyRemark(remark);
                        }
                        obj_1.setVestingDate(bean.getInvoiceDate());
                        obj_1.setCreateTime(new Date());
                        obj_1.setRemark(remark);
                        obj_1.setCompanyId(bean.getCompanyId());
                        obj_1.setSequenceNumber(sequenceNumber++);
                        obj_1.setVoucherType(StaticUtils.VOUCHER_TYPE_2);
                        obj_1.setLinkId(bean.getInvoiceId());
                        obj_1.setReimbursementPackageCode(bean.getInvoiceNumber());
                        obj_1.setLocked(false);
                        obj_1.cloneCopy(obj_3);
                        obj_1.cloneCopy(obj_4);
                        codeDao.clear();
                        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_9);
                        if (null == bean.getCustomerId()) {
                            errorSb.append("<br>合同【").append(bean.getContractName()).append("】没有绑定客户");
                            continue;
//	    					return bc.toJSON(-1, "合同：" + bean.getContractName() + "没有绑定客户");
                        }
                        codeDao.setConditionBusinessId("=", bean.getCustomerId());
                        BaseK3Code customerCode = codeDao.executeQueryOneRow();
                        if (null == customerCode) {
                            errorSb.append("<br>【").append(bean.getCustomerName()).append("】没有K3代码");
                            continue;
//	    					return bc.toJSON(-1, bean.getCustomerName() + "没有K3代码");
                        }
                        obj_1.setSecondaryCodeType(customerCode.getType());
                        obj_1.setSecondaryCodeId(customerCode.getK3CodeId());
                        obj_1.setSecondaryCode(customerCode.getK3Code());
                        obj_1.setSecondaryName(customerCode.getK3Name());
                        obj_1.cloneCopy(obj_2);
                        BaseK3Code code_1 = codeMap.get(StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_1);
                        obj_1.setCodeType(code_1.getType());
                        obj_1.setCodeId(code_1.getK3CodeId());
                        obj_1.setCode(code_1.getK3Code());
                        obj_1.setName(code_1.getK3Name());
                        obj_1.setInternalSequenceNumber(internalSequenceNumber++);
                        obj_1.setDebitSide(bean.getInvoiceAmount());
                        BaseK3Code code_2 = codeMap.get(StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_2);
                        obj_2.setCodeType(code_2.getType());
                        obj_2.setCodeId(code_2.getK3CodeId());
                        obj_2.setCode(code_2.getK3Code());
                        obj_2.setName(code_2.getK3Name());
                        obj_2.setInternalSequenceNumber(internalSequenceNumber++);
                        obj_2.setCreditSide(bean.getInvoiceAmount());
                        BaseK3Code code_3 = codeMap.get(StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_3);
                        obj_3.setCodeType(code_3.getType());
                        obj_3.setCodeId(code_3.getK3CodeId());
                        obj_3.setCode(code_3.getK3Code());
                        obj_3.setName(code_3.getK3Name());
                        obj_3.setInternalSequenceNumber(internalSequenceNumber++);
                        obj_3.setDebitSide(bean.getOutputTax());
                        BaseK3Code code_4 = codeMap.get(StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_4);
                        obj_4.setCodeType(code_4.getType());
                        obj_4.setCodeId(code_4.getK3CodeId());
                        obj_4.setCode(code_4.getK3Code());
                        obj_4.setName(code_4.getK3Name());
                        obj_4.setInternalSequenceNumber(internalSequenceNumber);
                        obj_4.setCreditSide(bean.getOutputTax());
                        list.add(obj_1);
                        list.add(obj_2);
                        list.add(obj_3);
                        list.add(obj_4);
                    }
                }
                if (errorSb.length() > 0) {
                    return collection.toJSON(-1, errorSb.toString());
                }
                ThreadConnection.beginTransaction();
                dao.save(list);
                Invoice invoiceDao = new Invoice();
                invoiceDao.addCondition(BaseInvoice.CS_INVOICE_ID, "in", (Object[]) invoiceIds);
                invoiceDao.setHaveVoucher(true);
                invoiceDao.conditionalUpdate();
                ThreadConnection.commit();
            }
            return collection.toJSON();
        } catch (Exception e) {
            e.printStackTrace();
            return collection.toJSON(-1, "凭证生成失败");
        }
    }

    /**
     * 根据发票ID删除凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String deleteInvoiceK3Voucher(Map<String, Object> params) throws Exception {
        List idList = (ArrayList) params.get("invoiceId");
        BaseCollection bc = new BaseCollection<>();
        if (null != idList && !idList.isEmpty()) {
            int size = idList.size();
            Integer[] invoiceIds = new Integer[size];
            for (int i = 0; i < size; i++) {
                invoiceIds[i] = BaseHelpUtils.getIntValue(idList.get(i));
            }
            ThreadConnection.beginTransaction();
            K3Voucher dao = new K3Voucher();
            dao.addCondition(BaseK3Voucher.CS_LINK_ID, "in", (Object[]) invoiceIds);
            dao.setConditionVoucherType("=", StaticUtils.VOUCHER_TYPE_2);
            dao.setConditionLocked("=", true);
            if (dao.countRows() > 0) {
                return bc.toJSON(-1, "包含已定稿的凭证，无法删除");
            }
            dao.clear();
            dao.addCondition(BaseK3Voucher.CS_LINK_ID, "in", (Object[]) invoiceIds);
            dao.setConditionVoucherType("=", StaticUtils.VOUCHER_TYPE_2);
            dao.conditionalDelete();
            Invoice invoiceDao = new Invoice();
            invoiceDao.addCondition(BaseInvoice.CS_INVOICE_ID, "in", (Object[]) invoiceIds);
            invoiceDao.setHaveVoucher(false);
            invoiceDao.conditionalUpdate();
            ThreadConnection.commit();
            return bc.toJSON();
        }
        return bc.toJSON(-1, "删除失败");
    }

    /**
     * 生成确认函的凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String createAttachmentK3Voucher(Map<String, Object> params) throws Exception {
        ThreadConnection.beginTransaction();
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        int status = 1;
        String errorMsg = null;
        String ids = BaseHelpUtils.getStringValue(params, "ids");
        if (!BaseHelpUtils.isNullOrEmpty(ids)) {
            AttachmentManage amDao = new AttachmentManage();
            amDao.setConditionHaveVoucher("=", false);
            List<BaseAttachmentManage> amList = amDao.conditionalLoad(" attachment_manage_id in (" + ids + ")");
            if (amList.size() > 0) {
                Date currentDate = new Date();
                List<BaseK3Voucher> newList = new ArrayList<>();

                K3Voucher dao = new K3Voucher();
                List<BaseK3Voucher> bb = dao
                        .conditionalLoad("order by " + BaseK3Voucher.CS_SEQUENCE_NUMBER + " desc limit 1");
                int sequenceNumber = 1;
                if (null != bb && !bb.isEmpty()) {
                    sequenceNumber = bb.get(0).getSequenceNumber() + 1;
                }

                K3Code codeDao = new K3Code();

                BaseK3Code borrowCode = null;
                BaseK3Code loanCode = null;
                //取出固定的科目代码
                codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_0);
                codeDao.addCondition(BaseK3Code.CS_BUSINESS_ID, "in", StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_2, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_6);
                List<BaseK3Code> lsCode = codeDao.conditionalLoad();
                for (BaseK3Code baseK3Code : lsCode) {
                    if (Objects.equals(baseK3Code.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_2)) {
                        borrowCode = baseK3Code;
                    } else if (Objects.equals(baseK3Code.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_6)) {
                        loanCode = baseK3Code;
                    }
                }

                //取出所有的客户代码
                codeDao.clear();
                codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_9);
                List<BaseK3Code> customerCode = codeDao.conditionalLoad();

                List<Integer> amIdList = new ArrayList<>();
                for (BaseAttachmentManage baseAttachmentManage : amList) {
                    amIdList.add(baseAttachmentManage.getContractId());
                }

                //查询出相关的合同
                Contract ctDao = new Contract();
                ctDao.addCondition(BaseContract.CS_CONTRACT_ID, "in", amIdList.toArray());
                List<BaseContract> ctList = ctDao.conditionalLoad();
                //合同收款阶段
                ContractReceivable crDao = new ContractReceivable();

                for (BaseAttachmentManage baseAttachmentManage : amList) {
                    amDao.setConditionAttachmentManageId("=", baseAttachmentManage.getAttachmentManageId());
                    amDao.setHaveVoucher(true);
                    amDao.conditionalUpdate();

                    BaseK3Voucher ob1 = new BaseK3Voucher();//借方
                    BaseContract ctBean = returnBaseContract(ctList, baseAttachmentManage.getContractId());
                    BaseK3Code cusCodeBean = null;
                    if (null != ctBean) {
                        cusCodeBean = returnCustomK3Code(ctBean.getCustomerId(), customerCode);
                    }

                    crDao.clear();
                    List<BaseContractReceivable> crList = crDao.conditionalLoad(" contract_receivable_id in "
                            + "(select contract_receivable_id from attachment_link_contract_receivables where attachment_manage_id = " + baseAttachmentManage.getAttachmentManageId() + ")");

                    StringBuilder sb = new StringBuilder("收到|");
                    if (null != ctBean) {
                        sb.append(ctBean.getContractName())
                                .append("|");
                    }
                    for (BaseContractReceivable baseContractReceivable : crList) {
                        if (baseContractReceivable.getParentId() == 0) {
                            crDao.clear();
                            crDao.setContractReceivableId(baseContractReceivable.getParentId());
                            if (crDao.load()) {
                                sb.append(crDao.getReceivableName()).append("-");
                            }
                            sb.append(baseContractReceivable.getReceivableName()).append("-").append(baseContractReceivable.getReceivableSumMoney());
                            sb.append("--");
                        } else {
                            sb.append(baseContractReceivable.getReceivableName()).append("-").append(baseContractReceivable.getReceivableSumMoney());
                            sb.append("--");
                        }
                    }

                    ob1.setLinkId(baseAttachmentManage.getAttachmentManageId());
                    ob1.setRemark(sb.toString());
                    ob1.setSimplifyRemark(sb.toString());
                    ob1.setDebitSide(baseAttachmentManage.getAmount());
                    ob1.setSequenceNumber(sequenceNumber);
                    ob1.setInternalSequenceNumber(1);
                    ob1.setVestingDate(baseAttachmentManage.getRecordDate());
                    ob1.setVoucherType(StaticUtils.VOUCHER_TYPE_5);
                    ob1.setCreateTime(currentDate);
                    if (null != borrowCode) {
                        ob1.setName(borrowCode.getK3Name());
                        ob1.setCode(borrowCode.getK3Code());
                        ob1.setCodeId(borrowCode.getK3CodeId());
                        ob1.setCodeType(borrowCode.getType());
                    }
                    if (null != cusCodeBean) {
                        ob1.setSecondaryCode(cusCodeBean.getK3Code());
                        ob1.setSecondaryCodeId(cusCodeBean.getK3CodeId());
                        ob1.setSecondaryCodeType(cusCodeBean.getType());
                        ob1.setSecondaryName(cusCodeBean.getK3Name());
                    }

                    BaseK3Voucher ob2 = new BaseK3Voucher();//贷方
                    ob2.setLinkId(baseAttachmentManage.getAttachmentManageId());
                    ob2.setRemark(sb.toString());
                    ob2.setSimplifyRemark(sb.toString());
                    ob2.setCreditSide(baseAttachmentManage.getAmount());
                    ob2.setSequenceNumber(sequenceNumber);
                    ob2.setInternalSequenceNumber(2);
                    ob2.setVestingDate(baseAttachmentManage.getRecordDate());
                    ob2.setVoucherType(StaticUtils.VOUCHER_TYPE_5);
                    ob2.setCreateTime(currentDate);
                    if (null != loanCode) {
                        ob2.setName(loanCode.getK3Name());
                        ob2.setCode(loanCode.getK3Code());
                        ob2.setCodeId(loanCode.getK3CodeId());
                        ob2.setCodeType(loanCode.getType());
                    }
                    if (null != cusCodeBean) {
                        ob2.setSecondaryCode(cusCodeBean.getK3Code());
                        ob2.setSecondaryCodeId(cusCodeBean.getK3CodeId());
                        ob2.setSecondaryCodeType(cusCodeBean.getType());
                        ob2.setSecondaryName(cusCodeBean.getK3Name());
                    }
                    sequenceNumber++;

                    newList.add(ob1);
                    newList.add(ob2);
                }
                dao.save(newList);
            }

        } else {
            status = -1;
            errorMsg = "请选择确认函进行生成 ids = " + ids;
        }
        return bc.toJSON(status, errorMsg);

    }

    private BaseContract returnBaseContract(List<BaseContract> list, Integer contractId) {
        for (BaseContract baseContract : list) {
            if (Objects.equals(baseContract.getContractId(), contractId)) {
                return baseContract;
            }
        }
        return null;
    }

    /**
     * 生成收入的K3凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String createReceivablesK3Voucher(Map<String, Object> params) throws Exception {
        ThreadConnection.beginTransaction();
        BaseCollection bc = new BaseCollection<>();
        int status = 1;
        String errorMsg = null;
        int year = BaseHelpUtils.getIntValue(params, "year");
        int month = BaseHelpUtils.getIntValue(params, "month");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (year > 0 && month > 0) {
            Date businessDate = sdf.parse(year + "-" + month + "-15");
            K3Voucher dao = new K3Voucher();
            List<BaseK3Voucher> bb = dao
                    .conditionalLoad("order by " + BaseK3Voucher.CS_SEQUENCE_NUMBER + " desc limit 1");
            int sequenceNumber = 1;
            if (null != bb && !bb.isEmpty()) {
                sequenceNumber = bb.get(0).getSequenceNumber() + 1;
            }
            K3Code codeDao = new K3Code();
            codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_0);
            codeDao.addCondition(BaseK3Code.CS_BUSINESS_ID, "in", StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_6, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_7);
            List<BaseK3Code> codeList = codeDao.conditionalLoad();
            BaseK3Code taxCode = null;
            BaseK3Code reciveCode = null;
            for (BaseK3Code baseK3Code : codeList) {
                if (Objects.equals(baseK3Code.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_6)) {
                    reciveCode = baseK3Code;
                } else if (Objects.equals(baseK3Code.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_7)) {
                    taxCode = baseK3Code;
                }
            }
            if (null != reciveCode && null != taxCode) {
                Date currentDate = new Date();
                //查出当月有营收的项目
                RevenueStatisticalRecord rsrDao = new RevenueStatisticalRecord();
                rsrDao.setConditionYear("=", year);
                rsrDao.setConditionMonth("=", month);
                rsrDao.setConditionCurrentRevenue(">", new BigDecimal("1"));
                List<BaseRevenueStatisticalRecord> rsrList = rsrDao.conditionalLoad();

                if (rsrList.size() > 0) {
                    String ids = "";
                    int i = 0;
                    List<Integer> projectIds = new ArrayList<>();
                    for (BaseRevenueStatisticalRecord baseRevenueStatisticalRecord : rsrList) {
                        if (i != 0) {
                            ids += ",";
                        }
                        ids += baseRevenueStatisticalRecord.getProjectId();
                        projectIds.add(baseRevenueStatisticalRecord.getProjectId());
                        i++;
                    }
                    //有收入的合同需要有一条收入凭证
                    Contract cDao = new Contract();
                    List<BaseContract> cList = cDao.conditionalLoad(" contract_id in (select contract_id from projects where project_id in (" + ids + ")) order by contract_id desc");
                    //查询出相关的订单
                    Project pDao = new Project();
                    List<BaseProject> pList = pDao.conditionalLoad();
                    //查询出所有的客户
                    Customer customerDao = new Customer();
                    List<BaseCustomer> customerList = customerDao.conditionalLoad();

                    if (cList.size() > 0) {
                        //查询出所有客户的K3代码
                        codeDao.clear();
                        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_9);
                        List<BaseK3Code> customeCodeList = codeDao.conditionalLoad();
                        //查询出所有板块区域的K3代码
                        codeDao.clear();
                        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_10);
                        List<BaseK3Code> plateCodeList = codeDao.conditionalLoad();

                        //相关业务部门与区域统计的凭证 （支出）
                        List<CustomerAliaBean> plateList = new ArrayList<>();
                        List<BaseK3Voucher> K3List = new ArrayList<>();
                        int internalSeq = 1;
                        BigDecimal allHaveTaxMoney = BigDecimal.ZERO;
                        BigDecimal allUnHaveTaxMoney = BigDecimal.ZERO;
                        for (BaseContract baseContract : cList) {
                            BaseK3Voucher vBean = new BaseK3Voucher();
                            Integer customerId = baseContract.getCustomerId();
                            BigDecimal allReciMoney = BigDecimal.ZERO;
                            //汇总当前收入 (含税营收) 
                            for (int j = 0; j < pList.size(); j++) {
                                BaseProject tmpPBean = pList.get(j);
                                if (Objects.equals(baseContract.getContractId(), tmpPBean.getContractId())) {
                                    for (int k = 0; k < rsrList.size(); k++) {
                                        BaseRevenueStatisticalRecord tmpRsrBean = rsrList.get(k);
                                        if (Objects.equals(tmpPBean.getProjectId(), tmpRsrBean.getProjectId())) {
                                            allReciMoney = allReciMoney.add(tmpRsrBean.getCurrentRevenue().multiply(new BigDecimal("1.06")));
                                            CustomerAliaBean caBean = new CustomerAliaBean();
                                            caBean.setPlateId(null == tmpPBean.getBusinessType() ? -1 : tmpPBean.getBusinessType());
                                            caBean.setAreaId(null == baseContract.getContractArea() ? -1 : baseContract.getContractArea());
                                            caBean.setAmount(tmpRsrBean.getCurrentRevenue());
                                            //统计板块的支出
                                            analysisPlateData(plateList, caBean);
                                            allUnHaveTaxMoney = allUnHaveTaxMoney.add(tmpRsrBean.getCurrentRevenue());
                                        }
                                    }
                                }
                            }
                            allHaveTaxMoney = allHaveTaxMoney.add(allReciMoney);
                            StringBuilder sb = new StringBuilder();
                            BaseK3Code customerCodeBean = returnCustomK3Code(customerId, customeCodeList);
                            if (null != customerCodeBean) {
                                vBean.setSecondaryCode(customerCodeBean.getK3Code());
                                vBean.setSecondaryName(customerCodeBean.getK3Name());
                                vBean.setSecondaryCodeId(customerCodeBean.getK3CodeId());
                                vBean.setSecondaryCodeType(customerCodeBean.getType());
                            }
                            BaseCustomer customerBean = returnCustomer(customerList, customerId);
                            sb.append("应收\"")
                                    .append(null == customerBean ? "该合同没有绑定客户" : customerBean.getCustomerName())
                                    .append("\"--\"")
                                    .append(baseContract.getContractName())
                                    .append("\"款");
                            vBean.setLinkId(baseContract.getContractId());
                            vBean.setSequenceNumber(sequenceNumber);
                            vBean.setCode(reciveCode.getK3Code());
                            vBean.setCodeId(reciveCode.getK3CodeId());
                            vBean.setCodeType(reciveCode.getType());
                            vBean.setName(reciveCode.getK3Name());
                            vBean.setVoucherType(StaticUtils.VOUCHER_TYPE_4);
                            vBean.setInternalSequenceNumber(internalSeq);
                            vBean.setDebitSide(allReciMoney);
                            vBean.setCreateTime(currentDate);
                            vBean.setRemark(sb.toString());
                            vBean.setSimplifyRemark(sb.toString());
                            vBean.setVestingDate(businessDate);
                            K3List.add(vBean);
                            internalSeq++;
                        }

                        //统计板块的凭证
                        for (CustomerAliaBean customerAliaBean : plateList) {
                            String remark = year + "年" + month + "月营收";

                            BaseK3Voucher vBean = new BaseK3Voucher();
                            //获取业务板块的K3代码
                            BaseK3Code codeBean = returnPlateK3Code(plateCodeList, customerAliaBean.getPlateId(), customerAliaBean.getAreaId());
                            if (null != codeBean) {
                                vBean.setCodeId(codeBean.getK3CodeId());
                                vBean.setCodeType(codeBean.getType());
                                vBean.setCode(codeBean.getK3Code());
                                vBean.setName(codeBean.getK3Name());
                            } else {
                                if (customerAliaBean.getAreaId() < 0) {
                                    remark += "--合同没有绑定区域";
                                }
                                if (customerAliaBean.getPlateId() <= 0) {
                                    remark += "--订单没有设置业务类型";
                                }
                            }
                            vBean.setInternalSequenceNumber(internalSeq);
                            vBean.setSequenceNumber(sequenceNumber);
                            vBean.setLinkId(customerAliaBean.getPlateId());
                            vBean.setAdditionalLinkId(customerAliaBean.getAreaId());
                            vBean.setRemark(remark);
                            vBean.setSimplifyRemark(remark);
                            vBean.setCreateTime(currentDate);
                            vBean.setCreditSide(customerAliaBean.getAmount());
                            vBean.setVestingDate(businessDate);
                            vBean.setVoucherType(StaticUtils.VOUCHER_TYPE_4);
                            K3List.add(vBean);
                            internalSeq++;
                        }
                        //含税营收
                        BaseK3Voucher vBean = new BaseK3Voucher();
                        vBean.setCodeId(taxCode.getK3CodeId());
                        vBean.setCodeType(taxCode.getType());
                        vBean.setCode(taxCode.getK3Code());
                        vBean.setName(taxCode.getK3Name());

                        vBean.setSequenceNumber(sequenceNumber);
                        vBean.setVestingDate(businessDate);
                        vBean.setCreateTime(currentDate);
                        vBean.setCreditSide(allHaveTaxMoney.subtract(allUnHaveTaxMoney));
                        String remark = year + "年" + month + "月营收";
                        vBean.setRemark(remark);
                        vBean.setSimplifyRemark(remark);
                        vBean.setInternalSequenceNumber(internalSeq);
                        vBean.setVoucherType(StaticUtils.VOUCHER_TYPE_4);
                        K3List.add(vBean);
                        for (BaseK3Voucher k3Voucher : K3List) {
                            System.out.println(k3Voucher.toJSONString());
                        }
                        if (K3List.size() > 0) {
                            dao.clear();
                            dao.setConditionVestingDate("=", businessDate);
                            dao.setVoucherType(StaticUtils.VOUCHER_TYPE_4);
                            dao.conditionalDelete();
                            dao.save(K3List);
                        }
                    } else {
                        status = -1;
                        errorMsg = "合同不存在 ";
                    }
                } else {
                    status = -1;
                    errorMsg = year + "年" + month + "月,没有营收的订单";
                }
            } else {
                status = -1;
                errorMsg = "请设置收款的code 与 应交税费的code ";
            }
        } else {
            status = -1;
            errorMsg = "";
        }
        ThreadConnection.commit();
        return bc.toJSON(status, errorMsg);
    }

    /**
     * 生成年度的营收的K3凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String createReceivablesK3VoucherByYear(Map<String, Object> params) throws Exception {
        ThreadConnection.beginTransaction();
        BaseCollection bc = new BaseCollection<>();
        int status = 1;
        String errorMsg = null;
        int year = BaseHelpUtils.getIntValue(params, "year");
        int month = 12;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (year > 0) {
            Date businessDate = sdf.parse(year + "-" + month + "-31");
            K3Voucher dao = new K3Voucher();
            List<BaseK3Voucher> bb = dao
                    .conditionalLoad("order by " + BaseK3Voucher.CS_SEQUENCE_NUMBER + " desc limit 1");
            int sequenceNumber = 1;
            if (null != bb && !bb.isEmpty()) {
                sequenceNumber = bb.get(0).getSequenceNumber() + 1;
            }
            K3Code codeDao = new K3Code();
            codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_0);
            codeDao.addCondition(BaseK3Code.CS_BUSINESS_ID, "in", StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_6, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_7);
            List<BaseK3Code> codeList = codeDao.conditionalLoad();
            BaseK3Code taxCode = null;
            BaseK3Code reciveCode = null;
            for (BaseK3Code baseK3Code : codeList) {
                if (Objects.equals(baseK3Code.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_6)) {
                    reciveCode = baseK3Code;
                } else if (Objects.equals(baseK3Code.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_7)) {
                    taxCode = baseK3Code;
                }
            }
            if (null != reciveCode && null != taxCode) {
                Date currentDate = new Date();
                //查出当月有营收的项目
                RevenueStatisticalRecord rsrDao = new RevenueStatisticalRecord();
                rsrDao.setConditionYear("=", year);
                rsrDao.setConditionCurrentRevenue(">", new BigDecimal("1"));
                List<BaseRevenueStatisticalRecord> rsrList = rsrDao.conditionalLoad();

                if (rsrList.size() > 0) {
                    String ids = "";
                    int i = 0;
                    List<Integer> projectIds = new ArrayList<>();
                    for (BaseRevenueStatisticalRecord baseRevenueStatisticalRecord : rsrList) {
                        if (i != 0) {
                            ids += ",";
                        }
                        ids += baseRevenueStatisticalRecord.getProjectId();
                        projectIds.add(baseRevenueStatisticalRecord.getProjectId());
                        i++;
                    }
                    //有收入的合同需要有一条收入凭证
                    Contract cDao = new Contract();
                    List<BaseContract> cList = cDao.conditionalLoad(" contract_id in (select contract_id from projects where project_id in (" + ids + ")) order by contract_id desc");
                    //查询出相关的订单
                    Project pDao = new Project();
                    List<BaseProject> pList = pDao.conditionalLoad();
                    //查询出所有的客户
                    Customer customerDao = new Customer();
                    List<BaseCustomer> customerList = customerDao.conditionalLoad();

                    if (cList.size() > 0) {
                        //查询出所有客户的K3代码
                        codeDao.clear();
                        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_9);
                        List<BaseK3Code> customeCodeList = codeDao.conditionalLoad();
                        //查询出所有板块区域的K3代码
                        codeDao.clear();
                        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_10);
                        List<BaseK3Code> plateCodeList = codeDao.conditionalLoad();

                        //相关业务部门与区域统计的凭证 （支出）
                        List<CustomerAliaBean> plateList = new ArrayList<>();
                        List<BaseK3Voucher> K3List = new ArrayList<>();
                        int internalSeq = 1;
                        BigDecimal allHaveTaxMoney = BigDecimal.ZERO;
                        BigDecimal allUnHaveTaxMoney = BigDecimal.ZERO;
                        for (BaseContract baseContract : cList) {
                            BaseK3Voucher vBean = new BaseK3Voucher();
                            Integer customerId = baseContract.getCustomerId();
                            BigDecimal allReciMoney = BigDecimal.ZERO;
                            //汇总当前收入 (含税营收) 
                            for (int j = 0; j < pList.size(); j++) {
                                BaseProject tmpPBean = pList.get(j);
                                if (Objects.equals(baseContract.getContractId(), tmpPBean.getContractId())) {
                                    for (int k = 0; k < rsrList.size(); k++) {
                                        BaseRevenueStatisticalRecord tmpRsrBean = rsrList.get(k);
                                        if (Objects.equals(tmpPBean.getProjectId(), tmpRsrBean.getProjectId())) {
                                            allReciMoney = allReciMoney.add(tmpRsrBean.getCurrentRevenue().multiply(new BigDecimal("1.06")));
                                            CustomerAliaBean caBean = new CustomerAliaBean();
                                            caBean.setPlateId(null == tmpPBean.getBusinessType() ? -1 : tmpPBean.getBusinessType());
                                            caBean.setAreaId(null == baseContract.getContractArea() ? -1 : baseContract.getContractArea());
                                            caBean.setAmount(tmpRsrBean.getCurrentRevenue());
                                            //统计板块的支出
                                            analysisPlateData(plateList, caBean);
                                            allUnHaveTaxMoney = allUnHaveTaxMoney.add(tmpRsrBean.getCurrentRevenue());
                                        }
                                    }
                                }
                            }
                            allHaveTaxMoney = allHaveTaxMoney.add(allReciMoney);
                            StringBuilder sb = new StringBuilder();
                            BaseK3Code customerCodeBean = returnCustomK3Code(customerId, customeCodeList);
                            if (null != customerCodeBean) {
                                vBean.setSecondaryCode(customerCodeBean.getK3Code());
                                vBean.setSecondaryName(customerCodeBean.getK3Name());
                                vBean.setSecondaryCodeId(customerCodeBean.getK3CodeId());
                                vBean.setSecondaryCodeType(customerCodeBean.getType());
                            }
                            BaseCustomer customerBean = returnCustomer(customerList, customerId);
                            sb.append("应收\"")
                                    .append(null == customerBean ? "该合同没有绑定客户" : customerBean.getCustomerName())
                                    .append("\"--\"")
                                    .append(baseContract.getContractName())
                                    .append("\"款");
                            vBean.setLinkId(baseContract.getContractId());
                            vBean.setSequenceNumber(sequenceNumber);
                            vBean.setCode(reciveCode.getK3Code());
                            vBean.setCodeId(reciveCode.getK3CodeId());
                            vBean.setCodeType(reciveCode.getType());
                            vBean.setName(reciveCode.getK3Name());
                            vBean.setVoucherType(StaticUtils.VOUCHER_TYPE_4);
                            vBean.setInternalSequenceNumber(internalSeq);
                            vBean.setDebitSide(allReciMoney);
                            vBean.setCreateTime(currentDate);
                            vBean.setRemark(sb.toString());
                            vBean.setSimplifyRemark(sb.toString());
                            vBean.setVestingDate(businessDate);
                            K3List.add(vBean);
                            internalSeq++;
                        }

                        //统计板块的凭证
                        for (CustomerAliaBean customerAliaBean : plateList) {
                            String remark = year + "年营收";

                            BaseK3Voucher vBean = new BaseK3Voucher();
                            //获取业务板块的K3代码
                            BaseK3Code codeBean = returnPlateK3Code(plateCodeList, customerAliaBean.getPlateId(), customerAliaBean.getAreaId());
                            if (null != codeBean) {
                                vBean.setCodeId(codeBean.getK3CodeId());
                                vBean.setCodeType(codeBean.getType());
                                vBean.setCode(codeBean.getK3Code());
                                vBean.setName(codeBean.getK3Name());
                            } else {
                                if (customerAliaBean.getAreaId() < 0) {
                                    remark += "--合同没有绑定区域";
                                }
                                if (customerAliaBean.getPlateId() <= 0) {
                                    remark += "--订单没有设置业务类型";
                                }
                            }
                            vBean.setInternalSequenceNumber(internalSeq);
                            vBean.setSequenceNumber(sequenceNumber);
                            vBean.setLinkId(customerAliaBean.getPlateId());
                            vBean.setAdditionalLinkId(customerAliaBean.getAreaId());
                            vBean.setRemark(remark);
                            vBean.setSimplifyRemark(remark);
                            vBean.setCreateTime(currentDate);
                            vBean.setCreditSide(customerAliaBean.getAmount());
                            vBean.setVestingDate(businessDate);
                            vBean.setVoucherType(StaticUtils.VOUCHER_TYPE_4);
                            K3List.add(vBean);
                            internalSeq++;
                        }
                        //含税营收
                        BaseK3Voucher vBean = new BaseK3Voucher();
                        vBean.setCodeId(taxCode.getK3CodeId());
                        vBean.setCodeType(taxCode.getType());
                        vBean.setCode(taxCode.getK3Code());
                        vBean.setName(taxCode.getK3Name());

                        vBean.setSequenceNumber(sequenceNumber);
                        vBean.setVestingDate(businessDate);
                        vBean.setCreateTime(currentDate);
                        vBean.setCreditSide(allHaveTaxMoney.subtract(allUnHaveTaxMoney));
                        String remark = year + "年营收";
                        vBean.setRemark(remark);
                        vBean.setSimplifyRemark(remark);
                        vBean.setInternalSequenceNumber(internalSeq);
                        vBean.setVoucherType(StaticUtils.VOUCHER_TYPE_4);
                        K3List.add(vBean);
                        if (K3List.size() > 0) {
                            dao.clear();
                            dao.setConditionVestingDate("=", businessDate);
                            dao.setVoucherType(StaticUtils.VOUCHER_TYPE_4);
                            dao.conditionalDelete();
                            for (BaseK3Voucher k3Voucher : K3List) {
                                dao.clear();
                                dao.setDataFromBase(k3Voucher);
                                dao.save();
                            }

                        }
                    } else {
                        status = -1;
                        errorMsg = "合同不存在 ";
                    }
                } else {
                    status = -1;
                    errorMsg = year + "年没有营收的订单";
                }
            } else {
                status = -1;
                errorMsg = "请设置收款的code 与 应交税费的code ";
            }
        } else {
            status = -1;
            errorMsg = "";
        }
        ThreadConnection.commit();
        return bc.toJSON(status, errorMsg);
    }

    private BaseK3Code returnPlateK3Code(List<BaseK3Code> list, Integer businessId, Integer addtionBusinessId) {
        for (BaseK3Code baseK3Code : list) {
            if (Objects.equals(baseK3Code.getBusinessId(), businessId)
                    && Objects.equals(baseK3Code.getAdditionalBusinessId(), addtionBusinessId)) {
                return baseK3Code;
            }
        }
        return null;
    }

    private BaseCustomer returnCustomer(List<BaseCustomer> list, Integer customerId) {
        for (BaseCustomer baseCustomer : list) {
            if (Objects.equals(baseCustomer.getCustomerId(), customerId)) {
                return baseCustomer;
            }
        }
        return null;
    }

    private void analysisPlateData(List<CustomerAliaBean> list, CustomerAliaBean bean) {
        boolean flag = false;
        for (CustomerAliaBean customerAliaBean : list) {
            if (Objects.equals(customerAliaBean.getPlateId(), bean.getPlateId())
                    && Objects.equals(customerAliaBean.getAreaId(), bean.getAreaId())) {
                BigDecimal allMoney = customerAliaBean.getAmount();
                allMoney = allMoney.add(bean.getAmount());
                customerAliaBean.setAmount(allMoney);
                flag = true;
            }
        }
        if (!flag) {
            list.add(bean);
        }
    }

    private BaseK3Code returnCustomK3Code(Integer customerId, List<BaseK3Code> list) {
        if (null != customerId) {
            for (BaseK3Code baseK3Code : list) {
                if (Objects.equals(customerId, baseK3Code.getBusinessId())) {
                    return baseK3Code;
                }
            }
        }
        return null;
    }

    /**
     * 根据回款ID生成凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String createCapitalK3Voucher(Map<String, Object> params) throws Exception {
        BaseCollection collection = new BaseCollection<>();
        try {
            List idList = (ArrayList) params.get("capitalId");
            if (null != idList && !idList.isEmpty()) {
                K3Voucher dao = new K3Voucher();
                List<BaseK3Voucher> bb = dao
                        .conditionalLoad("order by " + BaseK3Voucher.CS_SEQUENCE_NUMBER + " desc limit 1");
                int sequenceNumber = 1;
                if (null != bb && !bb.isEmpty()) {
                    sequenceNumber = bb.get(0).getSequenceNumber() + 1;
                }
                K3Code codeDao = new K3Code();
                codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_0);
                codeDao.setConditionBusinessId("=", StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_10);
                BaseK3Code sureCode = codeDao.executeQueryOneRow();
                int size = idList.size();
                List<BaseK3Voucher> list = new ArrayList<>();
                Integer[] capitalIds = new Integer[size];
                for (int i = 0; i < size; i++) {
                    capitalIds[i] = BaseHelpUtils.getIntValue(idList.get(i));
                }
                for (Integer capitalId : capitalIds) {
                    dao.clear();
                    dao.setConditionLinkId("=", capitalId);
                    dao.setConditionVoucherType("=", StaticUtils.VOUCHER_TYPE_3);
                    if (dao.countRows() > 0) {
                        continue;
                    }
                    ConditionCapitalVoucher condition = new ConditionCapitalVoucher();
                    condition.setCapitalId(capitalId);
                    QueryCapitalVoucher query = new QueryCapitalVoucher();
                    BaseCollection<BaseCapitalVoucher> bc = query.executeQuery(null, condition);
                    if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
                        int internalSequenceNumber = 0;
                        BaseCapitalVoucher bean = bc.getCollections().get(0);
                        BaseK3Voucher obj_1 = new BaseK3Voucher();
                        BaseK3Voucher obj_2 = new BaseK3Voucher();
                        StringBuilder sb = new StringBuilder();
                        sb.append("应收 ");
                        if (null != bean.getCustomerName()) {
                            sb.append(bean.getCustomerName()).append(" ");
                        }
                        if (null != bean.getContractName()) {
                            sb.append(bean.getContractName()).append(" ");
                        }
                        if (null != bean.getRemark()) {
                            sb.append(bean.getRemark());
                        }
                        String remark = sb.toString();
                        if (remark.length() > 100) {
                            obj_1.setSimplifyRemark(remark.substring(0, 100));
                        } else {
                            obj_1.setSimplifyRemark(remark);
                        }
                        obj_1.setVestingDate(bean.getHappenDate());
                        obj_1.setCreateTime(new Date());
                        obj_1.setRemark(remark);
                        obj_1.setCompanyId(bean.getCompanyId());
                        obj_1.setSequenceNumber(sequenceNumber++);
                        obj_1.setVoucherType(StaticUtils.VOUCHER_TYPE_3);
                        obj_1.setLinkId(bean.getCapitalId());
                        obj_1.setLocked(false);
                        obj_1.cloneCopy(obj_2);
                        //借方的科目代码
                        codeDao.clear();
                        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_5);
                        codeDao.setConditionBusinessId("=", bean.getCardManageId());
                        BaseK3Code bankCode = codeDao.executeQueryOneRow();
                        if (null == bankCode) {
                            if (null != bean.getCapitalId()) {
                                Capital capitalDao = new Capital();
                                capitalDao.setCapitalId(bean.getCapitalId());
                                capitalDao.unsetSelectFlags();
                                capitalDao.setSelectSelfBankName(true);
                                capitalDao.setSelectSelfBankAccount(true);
                                if (capitalDao.load() && (null != capitalDao.getSelfBankName() || null != capitalDao.getSelfBankAccount())) {
                                    StringBuilder errorMsg = new StringBuilder();
                                    errorMsg.append("(收款方)");
                                    if (null != capitalDao.getSelfBankName()) {
                                        errorMsg.append("--银行名称:").append(capitalDao.getSelfBankName());
                                    }
                                    if (null != capitalDao.getSelfBankAccount()) {
                                        errorMsg.append("--银行账号:").append(capitalDao.getSelfBankAccount());
                                    }
                                    errorMsg.append("的K3代码不存在");
                                    return collection.toJSON(-1, errorMsg.toString());
                                }
                                return collection.toJSON(-1, "账单流水ID：" + bean.getCapitalId() + "的银行账号K3代码不存在，无法生存凭证");
                            }
                            return collection.toJSON(-1, "因某条账单流水的银行账号K3代码不存在，故无法生存凭证");
                        }
                        obj_1.setCodeType(bankCode.getType());
                        obj_1.setCodeId(bankCode.getK3CodeId());
                        obj_1.setCode(bankCode.getK3Code());
                        obj_1.setName(bankCode.getK3Name());
                        //借方的内部序列号和金额
                        obj_1.setInternalSequenceNumber(internalSequenceNumber++);
                        obj_1.setDebitSide(bean.getBorrowMoney());
                        //贷方的科目代码
                        obj_2.setCodeType(sureCode.getType());
                        obj_2.setCodeId(sureCode.getK3CodeId());
                        obj_2.setCode(sureCode.getK3Code());
                        obj_2.setName(sureCode.getK3Name());
                        //贷方的辅助核算
                        obj_2.setSecondaryCodeType(StaticUtils.K3_CODE_TYPE_9);
                        codeDao.clear();
                        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_9);
                        if (null == bean.getCustomerId() && null != bean.getContractName()) {
                            return bc.toJSON(-1, "合同：" + bean.getContractName() + "没有绑定客户");
                        } else if (null != bean.getCustomerId()) {
                            codeDao.setConditionBusinessId("=", bean.getCustomerId());
                            BaseK3Code customerCode = codeDao.executeQueryOneRow();
                            if (null == customerCode) {
                                return bc.toJSON(-1, bean.getCustomerName() + "没有K3代码");
                            }
                            obj_2.setSecondaryCodeId(customerCode.getK3CodeId());
                            obj_2.setSecondaryCode(customerCode.getK3Code());
                            obj_2.setSecondaryName(customerCode.getK3Name());
                        }
                        //贷方内部序列号和金额
                        obj_2.setInternalSequenceNumber(internalSequenceNumber);
                        obj_2.setCreditSide(bean.getBorrowMoney());
                        list.add(obj_1);
                        list.add(obj_2);
                    }
                }
                ThreadConnection.beginTransaction();
                dao.save(list);
                Capital capitalDao = new Capital();
                capitalDao.addCondition(BaseCapital.CS_CAPITAL_ID, "in", (Object[]) capitalIds);
                capitalDao.setHaveVoucher(true);
                capitalDao.conditionalUpdate();
                ThreadConnection.commit();
            }
            return collection.toJSON();
        } catch (Exception e) {
            e.printStackTrace();
            return collection.toJSON(-1, "凭证生成失败");
        }
    }

    /**
     * 根据回款ID删除凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String deleteCapitalK3Voucher(Map<String, Object> params) throws Exception {
        List idList = (ArrayList) params.get("capitalId");
        BaseCollection bc = new BaseCollection<>();
        if (null != idList && !idList.isEmpty()) {
            int size = idList.size();
            Integer[] capitalIds = new Integer[size];
            for (int i = 0; i < size; i++) {
                capitalIds[i] = BaseHelpUtils.getIntValue(idList.get(i));
            }
            ThreadConnection.beginTransaction();
            K3Voucher dao = new K3Voucher();
            dao.addCondition(BaseK3Voucher.CS_LINK_ID, "in", (Object[]) capitalIds);
            dao.setConditionVoucherType("=", StaticUtils.VOUCHER_TYPE_3);
            dao.setConditionLocked("=", true);
            if (dao.countRows() > 0) {
                return bc.toJSON(-1, "包含已定稿的凭证，无法删除");
            }
            dao.clear();
            dao.addCondition(BaseK3Voucher.CS_LINK_ID, "in", (Object[]) capitalIds);
            dao.setConditionVoucherType("=", StaticUtils.VOUCHER_TYPE_3);
            dao.conditionalDelete();
            Capital capitalDao = new Capital();
            capitalDao.addCondition(BaseCapital.CS_CAPITAL_ID, "in", (Object[]) capitalIds);
            capitalDao.setHaveVoucher(false);
            capitalDao.conditionalUpdate();
            ThreadConnection.commit();
            return bc.toJSON();
        }
        return bc.toJSON(-1, "删除失败");
    }

    /**
     * 根据凭证号来定稿
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String lockVoucherBySequenceNumber(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        List idList = (ArrayList) params.get("sequenceNumber");
        if (null != idList && !idList.isEmpty()) {
            int size = idList.size();
            Integer[] sequenceNumbers = new Integer[size];
            for (int i = 0; i < size; i++) {
                sequenceNumbers[i] = BaseHelpUtils.getIntValue(idList.get(i));
            }
            K3Voucher dao = new K3Voucher();
            dao.addCondition(BaseK3Voucher.CS_SEQUENCE_NUMBER, "in", (Object[]) sequenceNumbers);
            dao.setLocked(true);
            Date date = new Date();
            dao.setLockedTime(date);
            dao.setUpdateTime(date);
            dao.conditionalUpdate();
        }
        return bc.toJSON();
    }

    /**
     * 根据凭证号来取消定稿
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String unlockVoucherBySequenceNumber(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        List idList = (ArrayList) params.get("sequenceNumber");
        if (null != idList && !idList.isEmpty()) {
            int size = idList.size();
            Integer[] sequenceNumbers = new Integer[size];
            for (int i = 0; i < size; i++) {
                sequenceNumbers[i] = BaseHelpUtils.getIntValue(idList.get(i));
            }
            K3Voucher dao = new K3Voucher();
            dao.addCondition(BaseK3Voucher.CS_SEQUENCE_NUMBER, "in", (Object[]) sequenceNumbers);
            dao.setLocked(false);
            dao.setLockedTime(null);
            dao.setUpdateTime(new Date());
            dao.conditionalUpdate();
        }
        return bc.toJSON();
    }

    /**
     * 根据凭证号来删除凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String deleteVoucherBySequenceNumber(Map<String, Object> params) throws Exception {
        BaseCollection bc = new BaseCollection<>();
        List idList = (ArrayList) params.get("sequenceNumber");
        if (null != idList && !idList.isEmpty()) {
            int size = idList.size();
            Integer[] sequenceNumbers = new Integer[size];
            for (int i = 0; i < size; i++) {
                sequenceNumbers[i] = BaseHelpUtils.getIntValue(idList.get(i));
            }
            K3Voucher dao = new K3Voucher();
            dao.addCondition(BaseK3Voucher.CS_SEQUENCE_NUMBER, "in", (Object[]) sequenceNumbers);
            ThreadConnection.beginTransaction();
            List<BaseK3Voucher> list = dao.conditionalLoad();
            if (null != list && !list.isEmpty()) {
                Set<Integer> set1 = new HashSet<>();//发票
                Set<Integer> set2 = new HashSet<>();//回款
                for (BaseK3Voucher obj : list) {
                    if (null != obj.getVoucherType() && obj.getVoucherType().equals(StaticUtils.VOUCHER_TYPE_2) && null != obj.getLinkId()) {
                        set1.add(obj.getLinkId());
                    } else if (null != obj.getVoucherType() && obj.getVoucherType().equals(StaticUtils.VOUCHER_TYPE_3) && null != obj.getLinkId()) {
                        set2.add(obj.getLinkId());
                    }
                }
                if (set1.size() > 0) {
                    Invoice invoiceDao = new Invoice();
                    invoiceDao.addCondition(BaseInvoice.CS_INVOICE_ID, "in", set1.toArray());
                    invoiceDao.setHaveVoucher(false);
                    invoiceDao.conditionalUpdate();
                }
                if (set2.size() > 0) {
                    Capital capitalDao = new Capital();
                    capitalDao.addCondition(BaseCapital.CS_CAPITAL_ID, "in", set2.toArray());
                    capitalDao.setHaveVoucher(false);
                    capitalDao.conditionalUpdate();
                }
                dao.conditionalDelete();
            }
            ThreadConnection.commit();
        }
        return bc.toJSON();
    }

    /**
     * 生成五险一金的凭证，并返回最新的凭证内序号
     *
     * @param amount	本凭证的金额
     * @param departmentType	部门类型
     * @param businessId	k3代码businessId
     * @param date	凭证归属日期
     * @param companyId	归属公司
     * @param sequenceNumber	凭证序号
     * @param internalSequenceNumber凭证内序号
     * @param type	1:社保 2:公积金
     * @return
     * @throws Exception
     */
    public int commonCreateInsuranceVoucher(BigDecimal amount, Integer departmentType, int businessId, Date date, Integer companyId, int sequenceNumber, int internalSequenceNumber, int type) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("计提").append(date.getMonth() + 1);
        if (type == 1) {
            sb.append("月份社保");
        } else if (type == 2) {
            sb.append("月份公积金");
        }
        BaseK3Code codeBean = null;
        K3Code codeDao = new K3Code();
        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_11);
        codeDao.setConditionBusinessId("=", businessId);
        K3Voucher dao = new K3Voucher();
        if (null == departmentType) {
            List<BaseK3Code> codeList = codeDao.conditionalLoad(BaseK3Code.CS_DEPARTMENT_TYPE + " is null");
            if (null != codeList && !codeList.isEmpty()) {
                codeBean = codeList.get(0);
            }
            dao.setCreditSide(amount);
        } else {
            if (departmentType.equals(DEPARTMENT_TYPE_0)) {
                sb.append(" 营销部门");
            } else if (departmentType.equals(DEPARTMENT_TYPE_1)) {
                sb.append(" 职能部门");
            } else if (departmentType.equals(DEPARTMENT_TYPE_2)) {
                sb.append(" 业务部门");
            } else if (departmentType.equals(DEPARTMENT_TYPE_3)) {
                sb.append(" 研发部门");
            }
            codeDao.setConditionDepartmentType("=", departmentType);
            codeBean = codeDao.executeQueryOneRow();
            dao.setDebitSide(amount);
        }
        if (null == codeBean) {
            throw new Exception("找不到" + businessId + "的科目代码");
        }
        dao.setCodeType(StaticUtils.K3_CODE_TYPE_11);
        dao.setCodeId(codeBean.getK3CodeId());
        dao.setCode(codeBean.getK3Code());
        dao.setName(codeBean.getK3Name());
        dao.setRemark(sb.toString());
        dao.setSimplifyRemark(sb.toString());
        dao.setCompanyId(companyId);
        dao.setVestingDate(date);
        dao.setSequenceNumber(sequenceNumber);
        dao.setInternalSequenceNumber(internalSequenceNumber++);
        dao.setLocked(false);
        dao.setVoucherType(StaticUtils.VOUCHER_TYPE_6);
        dao.setCreateTime(new Date());
        dao.setUpdateTime(new Date());
        dao.save();
        return internalSequenceNumber;
    }

    /**
     * 根据公司ID，年份和月份来创建五险一金的凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String createInsuranceAndHousingFundK3Voucher(Map<String, Object> params) throws Exception {
        BaseCollection collection = new BaseCollection<>();
        try {
            if (!params.containsKey("companyId") || !params.containsKey("year") || !params.containsKey("month")) {
                return collection.toJSON(-1, "参数不全，无法生成凭证");
            }
            int companyId = BaseHelpUtils.getIntValue(params.get("companyId"));
            int year = BaseHelpUtils.getIntValue(params.get("year"));
            int month = BaseHelpUtils.getIntValue(params.get("month"));
            if (year <= 0 && (month > 12 || month <= 0)) {
                return collection.toJSON(-1, "参数有误，无法生成凭证");
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1);
            Date date = DateUtil.getLastDay(calendar.getTime());
            K3Voucher voucherDao = new K3Voucher();
            voucherDao.setConditionCompanyId("=", companyId);
            voucherDao.setConditionVestingDate("=", date);
            voucherDao.setConditionVoucherType("=", StaticUtils.VOUCHER_TYPE_6);
            if (voucherDao.countRows() > 0) {
                return collection.toJSON(-1, "已有凭证，请不要重复生成");
            }
            ConditionInsuranceAndHousingFundVoucherInfo condition = new ConditionInsuranceAndHousingFundVoucherInfo();
            condition.setCompanyId(companyId);
            condition.setYear(year);
            condition.setMonth(month);
            QueryInsuranceAndHousingFundVoucherInfo query = new QueryInsuranceAndHousingFundVoucherInfo();
            BaseCollection<BaseInsuranceAndHousingFundVoucherInfo> bc = query.executeQuery(null, condition);
            if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
                ThreadConnection.beginTransaction();
                List<BaseInsuranceAndHousingFundVoucherInfo> list = bc.getCollections();
                K3Voucher dao = new K3Voucher();
                List<BaseK3Voucher> bb = dao
                        .conditionalLoad("order by " + BaseK3Voucher.CS_SEQUENCE_NUMBER + " desc limit 1");
                int sequenceNumber = 1;
                if (null != bb && !bb.isEmpty()) {
                    sequenceNumber = bb.get(0).getSequenceNumber() + 1;
                }
                //基本养老保险
                BigDecimal pension = BigDecimal.ZERO;
                //基本医疗保险
                BigDecimal medicalInsurance = BigDecimal.ZERO;
                //失业保险
                BigDecimal unemploymentInsurance = BigDecimal.ZERO;
                //工伤保险
                BigDecimal injuryInsurance = BigDecimal.ZERO;
                //生育保险
                BigDecimal giveBirthInsurance = BigDecimal.ZERO;
                //大病保险
                BigDecimal largeMedicalInsurance = BigDecimal.ZERO;
                //公积金
                BigDecimal totalFund = BigDecimal.ZERO;
                int internalSequenceNumber = 0;
                for (BaseInsuranceAndHousingFundVoucherInfo obj : list) {
                    //开始依次生成3大部门（营销、业务、职能）的五险一金凭证（借方）
                    if (null != obj.getUnitPension() && obj.getUnitPension().compareTo(BigDecimal.ZERO) != 0) {
                        pension = pension.add(obj.getUnitPension());
                        internalSequenceNumber = commonCreateInsuranceVoucher(obj.getUnitPension(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_1, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                    }
                    if (null != obj.getUnitMedicalInsurance() && obj.getUnitMedicalInsurance().compareTo(BigDecimal.ZERO) != 0) {
                        medicalInsurance = medicalInsurance.add(obj.getUnitMedicalInsurance());
                        internalSequenceNumber = commonCreateInsuranceVoucher(obj.getUnitMedicalInsurance(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_2, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                    }
                    if (null != obj.getUnitUnemploymentInsurance() && obj.getUnitUnemploymentInsurance().compareTo(BigDecimal.ZERO) != 0) {
                        unemploymentInsurance = unemploymentInsurance.add(obj.getUnitUnemploymentInsurance());
                        internalSequenceNumber = commonCreateInsuranceVoucher(obj.getUnitUnemploymentInsurance(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_3, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                    }
                    if (null != obj.getUnitInjuryInsurance() && obj.getUnitInjuryInsurance().compareTo(BigDecimal.ZERO) != 0) {
                        injuryInsurance = injuryInsurance.add(obj.getUnitInjuryInsurance());
                        internalSequenceNumber = commonCreateInsuranceVoucher(obj.getUnitInjuryInsurance(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_4, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                    }
                    if (null != obj.getUnitGiveBirthInsurance() && obj.getUnitGiveBirthInsurance().compareTo(BigDecimal.ZERO) != 0) {
                        giveBirthInsurance = giveBirthInsurance.add(obj.getUnitGiveBirthInsurance());
                        internalSequenceNumber = commonCreateInsuranceVoucher(obj.getUnitGiveBirthInsurance(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_5, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                    }
                    if (null != obj.getUnitLargeMedicalInsurance() && obj.getUnitLargeMedicalInsurance().compareTo(BigDecimal.ZERO) != 0) {
                        largeMedicalInsurance = largeMedicalInsurance.add(obj.getUnitLargeMedicalInsurance());
                        internalSequenceNumber = commonCreateInsuranceVoucher(obj.getUnitLargeMedicalInsurance(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_6, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                    }
                }
                //生成五险一金凭证的贷方数据
                if (pension.compareTo(BigDecimal.ZERO) != 0) {
                    internalSequenceNumber = commonCreateInsuranceVoucher(pension, null, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_1, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                }
                if (medicalInsurance.compareTo(BigDecimal.ZERO) != 0) {
                    internalSequenceNumber = commonCreateInsuranceVoucher(medicalInsurance, null, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_2, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                }
                if (unemploymentInsurance.compareTo(BigDecimal.ZERO) != 0) {
                    internalSequenceNumber = commonCreateInsuranceVoucher(unemploymentInsurance, null, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_3, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                }
                if (injuryInsurance.compareTo(BigDecimal.ZERO) != 0) {
                    internalSequenceNumber = commonCreateInsuranceVoucher(injuryInsurance, null, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_4, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                }
                if (giveBirthInsurance.compareTo(BigDecimal.ZERO) != 0) {
                    internalSequenceNumber = commonCreateInsuranceVoucher(giveBirthInsurance, null, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_5, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                }
                if (largeMedicalInsurance.compareTo(BigDecimal.ZERO) != 0) {
                    internalSequenceNumber = commonCreateInsuranceVoucher(largeMedicalInsurance, null, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_6, date, companyId, sequenceNumber, internalSequenceNumber, 1);
                }
                for (BaseInsuranceAndHousingFundVoucherInfo obj : list) {
                    if (null != obj.getUnitTotalFund() && obj.getUnitTotalFund().compareTo(BigDecimal.ZERO) != 0) {
                        totalFund = totalFund.add(obj.getUnitTotalFund());
                        internalSequenceNumber = commonCreateInsuranceVoucher(obj.getUnitTotalFund(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_7, date, companyId, sequenceNumber, internalSequenceNumber, 2);
                    }
                }
                if (totalFund.compareTo(BigDecimal.ZERO) != 0) {
                    commonCreateInsuranceVoucher(totalFund, null, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_7, date, companyId, sequenceNumber, internalSequenceNumber, 2);
                }
                ThreadConnection.commit();
            } else {
                return collection.toJSON(-1, "没找到相关数据，无法生成凭证");
            }
            return collection.toJSON();
        } catch (Exception e) {
            e.printStackTrace();
            ThreadConnection.rollback();
            return collection.toJSON(-1, "凭证生成失败");
        }
    }

    /**
     * 生成工资的凭证，并返回最新的凭证内序号
     *
     * @param amount	本凭证的金额
     * @param departmentType	部门类型
     * @param businessId	k3代码名称
     * @param date	凭证归属日期
     * @param companyId	归属公司
     * @param sequenceNumber	凭证序号
     * @param internalSequenceNumber凭证内序号
     * @param type	1:预提	2:已审	3:调整
     * @param isCreditSide	是否为贷方
     * @param remark	备注/摘要
     * @return
     * @throws Exception
     */
    public int commonCreateSalaryVoucher(BigDecimal amount, Integer departmentType, Integer businessId, Date date, Integer companyId, int sequenceNumber, int internalSequenceNumber, Integer type, boolean isCreditSide, String remark) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (null == remark) {
            if (null != type) {
                if (type.equals(StaticUtils.K3_CODE_SALARY_TYPE_01)) {
                    sb.append("预提");
                } else if (type.equals(StaticUtils.K3_CODE_SALARY_TYPE_02)) {
                    sb.append("已审");
                } else if (type.equals(StaticUtils.K3_CODE_SALARY_TYPE_03)) {
                    sb.append("调整");
                }
            }
        } else {
            sb.append(remark);
        }
        sb.append(DateUtil.getMonth(date)).append("月份工资");
        K3Code codeDao = new K3Code();
        codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_12);
        codeDao.setConditionBusinessId("=", businessId);
        K3Voucher dao = new K3Voucher();
        if (null != departmentType) {
            if (departmentType.equals(DEPARTMENT_TYPE_0)) {
                sb.append(" 营销部门");
            } else if (departmentType.equals(DEPARTMENT_TYPE_1)) {
                sb.append(" 职能部门");
            } else if (departmentType.equals(DEPARTMENT_TYPE_2)) {
                sb.append(" 业务部门");
            } else if (departmentType.equals(DEPARTMENT_TYPE_3)) {
                sb.append(" 研发部门");
            }
            codeDao.setConditionDepartmentType("=", departmentType);
        }
        BaseK3Code codeBean = codeDao.executeQueryOneRow();
        if (isCreditSide) {
            dao.setCreditSide(amount);
        } else {
            dao.setDebitSide(amount);
        }
        if (null == codeBean) {
            throw new Exception("找不到" + businessId + "的科目代码");
        }
        dao.setProjectId(type);
        dao.setCodeType(StaticUtils.K3_CODE_TYPE_12);
        dao.setCodeId(codeBean.getK3CodeId());
        dao.setCode(codeBean.getK3Code());
        dao.setName(codeBean.getK3Name());
        dao.setRemark(sb.toString());
        dao.setSimplifyRemark(sb.toString());
        dao.setCompanyId(companyId);
        dao.setVestingDate(date);
        dao.setSequenceNumber(sequenceNumber);
        dao.setInternalSequenceNumber(internalSequenceNumber++);
        dao.setLocked(false);
        dao.setVoucherType(StaticUtils.VOUCHER_TYPE_7);
        dao.setCreateTime(new Date());
        dao.setUpdateTime(new Date());
        dao.save();
        return internalSequenceNumber;
    }

    /**
     * 根据公司ID，年份，月份和类型来创建工资的凭证
     *
     * @param params
     * @return
     * @throws Exception
     */
    public String createSalaryK3Voucher(Map<String, Object> params) throws Exception {
        BaseCollection collection = new BaseCollection<>();
        try {
            if (!params.containsKey("companyId") || !params.containsKey("year") || !params.containsKey("month") || !params.containsKey("type")) {
                return collection.toJSON(-1, "参数不全，无法生成凭证");
            }
            int companyId = BaseHelpUtils.getIntValue(params.get("companyId"));
            int year = BaseHelpUtils.getIntValue(params.get("year"));
            int month = BaseHelpUtils.getIntValue(params.get("month"));
            int type = BaseHelpUtils.getIntValue(params.get("type"));
            if (year <= 0 && (month > 12 || month <= 0)) {
                return collection.toJSON(-1, "参数有误，无法生成凭证");
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month - 1);
            Date date = DateUtil.getLastDay(calendar.getTime());
            K3Voucher voucherDao = new K3Voucher();
            voucherDao.setConditionCompanyId("=", companyId);
            voucherDao.setConditionVestingDate("=", date);
            voucherDao.setConditionProjectId("=", type);
            voucherDao.setConditionVoucherType("=", StaticUtils.VOUCHER_TYPE_7);
            if (voucherDao.countRows() > 0) {
                return collection.toJSON(-1, "已有凭证，请不要重复生成");
            }
            ConditionSalaryVoucherInfo condition = new ConditionSalaryVoucherInfo();
            condition.setCompanyId(companyId);
            condition.setYear(year);
            condition.setMonth(month);
            condition.setType(type);
            QuerySalaryVoucherInfo query = new QuerySalaryVoucherInfo();
            BaseCollection<BaseSalaryVoucherInfo> bc = query.executeQuery(null, condition);
            if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
                ThreadConnection.beginTransaction();
                List<BaseSalaryVoucherInfo> list = bc.getCollections();
                K3Voucher dao = new K3Voucher();
                List<BaseK3Voucher> bb = dao
                        .conditionalLoad("order by " + BaseK3Voucher.CS_SEQUENCE_NUMBER + " desc limit 1");
                int sequenceNumber = 1;
                if (null != bb && !bb.isEmpty()) {
                    sequenceNumber = bb.get(0).getSequenceNumber() + 1;
                }
                //应发工资
                BigDecimal shouldSalary = BigDecimal.ZERO;
                //离职补偿
                BigDecimal leaveAdvance = BigDecimal.ZERO;
                //代扣个税
                BigDecimal shouldTax = BigDecimal.ZERO;
                //代扣养老
                BigDecimal personalPension = BigDecimal.ZERO;
                //代扣医疗
                BigDecimal personalMedicalInsurance = BigDecimal.ZERO;
                //代扣失业
                BigDecimal personalUnemploymentInsurance = BigDecimal.ZERO;
                //代扣大额
                BigDecimal personalLargeMedicalInsurance = BigDecimal.ZERO;
                //代扣采暖
                BigDecimal personalHeating = BigDecimal.ZERO;
                //代扣公积金
                BigDecimal totalFund = BigDecimal.ZERO;
                int internalSequenceNumber = 0;
                for (BaseSalaryVoucherInfo obj : list) {
                    //开始依次生成3大部门（营销、业务、职能）的工资凭证（借方--应发工资）
                    if (null != obj.getShouldSalary() && obj.getShouldSalary().compareTo(BigDecimal.ZERO) != 0) {
                        shouldSalary = shouldSalary.add(obj.getShouldSalary());
                        internalSequenceNumber = commonCreateSalaryVoucher(obj.getShouldSalary(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_1, date, companyId, sequenceNumber, internalSequenceNumber, type, false, null);
                    }
                }
                //工资凭证（贷方--应发工资汇总）
                if (shouldSalary.compareTo(BigDecimal.ZERO) != 0) {
                    internalSequenceNumber = commonCreateSalaryVoucher(shouldSalary, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_1, date, companyId, sequenceNumber, internalSequenceNumber, type, true, null);
                }
                for (BaseSalaryVoucherInfo obj : list) {
                    //开始依次生成3大部门（营销、业务、职能）的工资凭证（借方--离职补偿）
                    if (null != obj.getLeaveAdvance() && obj.getLeaveAdvance().compareTo(BigDecimal.ZERO) != 0) {
                        leaveAdvance = leaveAdvance.add(obj.getLeaveAdvance());
                        internalSequenceNumber = commonCreateSalaryVoucher(obj.getLeaveAdvance(), obj.getDepartmentType(), StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_1, date, companyId, sequenceNumber, internalSequenceNumber, type, false, null);
                    }
                }
                //工资凭证（贷方--离职补偿汇总）
                if (leaveAdvance.compareTo(BigDecimal.ZERO) != 0) {
                    internalSequenceNumber = commonCreateSalaryVoucher(leaveAdvance, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_1, date, companyId, sequenceNumber, internalSequenceNumber, type, true, null);
                }
                String remark = "支付";
                //已审的工资生成凭证时，还需要根据代扣的个人五险一金等的汇总数据来生成相对应的凭证
                if (type == StaticUtils.K3_CODE_SALARY_TYPE_02) {
                    //工资凭证（借方--应发工资和离职补偿汇总）
                    if (shouldSalary.add(leaveAdvance).compareTo(BigDecimal.ZERO) != 0) {
                        internalSequenceNumber = commonCreateSalaryVoucher(shouldSalary.add(leaveAdvance), null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_1, date, companyId, sequenceNumber, internalSequenceNumber, type, false, remark);
                    }
                    for (BaseSalaryVoucherInfo obj : list) {
                        //累加（贷方--个人所得税[代扣个税]）
                        if (null != obj.getShouldTax() && obj.getShouldTax().compareTo(BigDecimal.ZERO) != 0) {
                            shouldTax = shouldTax.add(obj.getShouldTax());
                        }
                        //累加（贷方--个人养老保险[代扣养老]）
                        if (null != obj.getPersonalPension() && obj.getPersonalPension().compareTo(BigDecimal.ZERO) != 0) {
                            personalPension = personalPension.add(obj.getPersonalPension());
                        }
                        //累加（贷方--个人医疗保险[代扣医疗]）
                        if (null != obj.getPersonalMedicalInsurance() && obj.getPersonalMedicalInsurance().compareTo(BigDecimal.ZERO) != 0) {
                            personalMedicalInsurance = personalMedicalInsurance.add(obj.getPersonalMedicalInsurance());
                        }
                        //累加（贷方--个人失业保险[代扣失业]）
                        if (null != obj.getPersonalUnemploymentInsurance() && obj.getPersonalUnemploymentInsurance().compareTo(BigDecimal.ZERO) != 0) {
                            personalUnemploymentInsurance = personalUnemploymentInsurance.add(obj.getPersonalUnemploymentInsurance());
                        }
                        //累加（贷方--个人大病保险[代扣大额]）
                        if (null != obj.getPersonalLargeMedicalInsurance() && obj.getPersonalLargeMedicalInsurance().compareTo(BigDecimal.ZERO) != 0) {
                            personalLargeMedicalInsurance = personalLargeMedicalInsurance.add(obj.getPersonalLargeMedicalInsurance());
                        }
                        //累加（贷方--个人采暖[代扣采暖]）
                        if (null != obj.getPersonalHeating() && obj.getPersonalHeating().compareTo(BigDecimal.ZERO) != 0) {
                            personalHeating = personalHeating.add(obj.getPersonalHeating());
                        }
                        //累加（贷方--个人部分住房公积金[代扣公积金]）
                        if (null != obj.getTotalFund() && obj.getTotalFund().compareTo(BigDecimal.ZERO) != 0) {
                            totalFund = totalFund.add(obj.getTotalFund());
                        }
                    }
                    if (shouldTax.compareTo(BigDecimal.ZERO) != 0) {
                        internalSequenceNumber = commonCreateSalaryVoucher(shouldTax, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_3, date, companyId, sequenceNumber, internalSequenceNumber, type, true, remark);
                    }
                    if (personalPension.compareTo(BigDecimal.ZERO) != 0) {
                        internalSequenceNumber = commonCreateSalaryVoucher(personalPension, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_4, date, companyId, sequenceNumber, internalSequenceNumber, type, true, remark);
                    }
                    if (personalMedicalInsurance.compareTo(BigDecimal.ZERO) != 0) {
                        internalSequenceNumber = commonCreateSalaryVoucher(personalMedicalInsurance, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_5, date, companyId, sequenceNumber, internalSequenceNumber, type, true, remark);
                    }
                    if (personalUnemploymentInsurance.compareTo(BigDecimal.ZERO) != 0) {
                        internalSequenceNumber = commonCreateSalaryVoucher(personalUnemploymentInsurance, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_6, date, companyId, sequenceNumber, internalSequenceNumber, type, true, remark);
                    }
                    if (personalLargeMedicalInsurance.compareTo(BigDecimal.ZERO) != 0) {
                        internalSequenceNumber = commonCreateSalaryVoucher(personalLargeMedicalInsurance, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_7, date, companyId, sequenceNumber, internalSequenceNumber, type, true, remark);
                    }
                    if (personalHeating.compareTo(BigDecimal.ZERO) != 0) {
                        internalSequenceNumber = commonCreateSalaryVoucher(personalHeating, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_8, date, companyId, sequenceNumber, internalSequenceNumber, type, true, remark);
                    }
                    if (totalFund.compareTo(BigDecimal.ZERO) != 0) {
                        internalSequenceNumber = commonCreateSalaryVoucher(totalFund, null, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_9, date, companyId, sequenceNumber, internalSequenceNumber, type, true, remark);
                    }
                    String code = StaticUtils.K3_CODE_PAY_BANK_COMMON;
                    if (companyId == StaticUtils.SIGN_COMPANY_0) {
                        code = StaticUtils.K3_CODE_PAY_BANK_JA;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("支付").append(date.getMonth() + 1).append("月份工资");
                    K3Code codeDao = new K3Code();
                    codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_5);
                    codeDao.setConditionK3Code("=", code);
                    BaseK3Code codeBean = codeDao.executeQueryOneRow();
                    K3Voucher payBankVoucherDao = new K3Voucher();
                    if (null == codeBean) {
                        throw new Exception("找不到发放工资的银行的科目代码");
                    }
                    payBankVoucherDao.setCreditSide(shouldSalary.add(leaveAdvance).subtract(shouldTax).subtract(personalPension).subtract(personalMedicalInsurance).subtract(personalUnemploymentInsurance).subtract(personalLargeMedicalInsurance).subtract(personalHeating).subtract(totalFund));
                    payBankVoucherDao.setProjectId(type);
                    payBankVoucherDao.setCodeType(StaticUtils.K3_CODE_TYPE_5);
                    payBankVoucherDao.setCodeId(codeBean.getK3CodeId());
                    payBankVoucherDao.setCode(codeBean.getK3Code());
                    payBankVoucherDao.setName(codeBean.getK3Name());
                    payBankVoucherDao.setRemark(sb.toString());
                    payBankVoucherDao.setSimplifyRemark(sb.toString());
                    payBankVoucherDao.setCompanyId(companyId);
                    payBankVoucherDao.setVestingDate(date);
                    payBankVoucherDao.setSequenceNumber(sequenceNumber);
                    payBankVoucherDao.setInternalSequenceNumber(internalSequenceNumber++);
                    payBankVoucherDao.setLocked(false);
                    payBankVoucherDao.setVoucherType(StaticUtils.VOUCHER_TYPE_7);
                    payBankVoucherDao.setCreateTime(new Date());
                    payBankVoucherDao.setUpdateTime(new Date());
                    payBankVoucherDao.save();
                }
                ThreadConnection.commit();
            } else {
                return collection.toJSON(-1, "没找到相关数据，无法生成凭证");
            }
            return collection.toJSON();
        } catch (Exception e) {
            e.printStackTrace();
            ThreadConnection.rollback();
            return collection.toJSON(-1, "凭证生成失败");
        }
    }

    public String updateK3VoucherByDoubleClick(Map<String, Object> params) throws Exception{
    	BaseK3Voucher bean = new BaseK3Voucher();
    	bean.setDataFromMap(params);
    	K3Voucher dao = new K3Voucher();
    	dao.setPrimaryKeyFromBase(bean);
    	dao.load();
    	dao.setDataFromBase(bean);
    	ColumnChangedData codeChange = dao.getColumnChangedData(BaseK3Voucher.CS_CODE_ID);
    	K3Code codeDao = null;
    	if(null != codeChange) {
    		codeDao = new K3Code();
    		codeDao.setK3CodeId(dao.getCodeId());
    		if(codeDao.load()) {
	    		dao.setCodeType(codeDao.getType());
	    		dao.setCode(codeDao.getK3Code());
	    		dao.setName(codeDao.getK3Name());
    		}
    	}
    	ColumnChangedData secondaryCodeChange = dao.getColumnChangedData(BaseK3Voucher.CS_SECONDARY_CODE_ID);
    	if(null != secondaryCodeChange) {
    		if(null == codeDao) {
    			codeDao = new K3Code();
    		}else {
    			codeDao.clear();
    		}
    		codeDao.setK3CodeId(dao.getSecondaryCodeId());
    		if(codeDao.load()) {
    			dao.setSecondaryCodeType(codeDao.getType());
	    		dao.setSecondaryCode(codeDao.getK3Code());
	    		dao.setSecondaryName(codeDao.getK3Name());
    		}
    		
    	}
    	dao.update();
    	return dao.generateBase().toOneLineJSON();
    }
    
    public static void main(String[] args) {
        try {
            String a = "{\"capitalId\":[\"10141\", \"10142\", \"10143\", \"10144\", \"10153\", \"10178\", \"10189\", \"10190\", \"10191\", \"10192\", \"10193\", \"10194\", \"10358\", \"10415\", \"10418\", \"10421\", \"10422\", \"10423\", \"10432\", \"10433\", \"10439\", \"10453\", \"10455\", \"10574\", \"10575\", \"10588\", \"10591\", \"10592\", \"10593\", \"10594\", \"10595\", \"10596\", \"10597\", \"10600\", \"10605\", \"10606\", \"10607\", \"10608\", \"10609\", \"10610\", \"10611\", \"10612\", \"10613\", \"10614\", \"10615\", \"10616\", \"10617\", \"10641\", \"10835\", \"10836\", \"10838\", \"10926\", \"10927\", \"10931\", \"10932\", \"10934\", \"10991\", \"11000\", \"11033\", \"11039\", \"11061\", \"11066\", \"11076\", \"11077\", \"11078\"],\"optType\":\"createCapitalK3Voucher\"}";
//			JSON parser = new JSON(new StringReader(a)); 
//			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
//    		Map<String, Object> params = new HashMap<>();
//    		params.put("year", 2017);
            K3VoucherProcess aa = new K3VoucherProcess();
//			aa.createReceivablesK3VoucherByYear(params);
            aa.execute(a, null);
//    		PlateRecord pDao = new PlateRecord();
//    		SystemDictionary sdDao = new SystemDictionary();
//    		sdDao.setConditionDicTypeId("=", 116);
//    		List<BaseSystemDictionary> sdList = sdDao.conditionalLoad();
//    		sdDao.clear();
//    		sdDao.setConditionDicTypeId("=", 31);
//    		List<BaseSystemDictionary> mainList = sdDao.conditionalLoad();
//    		List<BaseK3Code> list = new ArrayList<>();
//    		for (BaseSystemDictionary baseSystemDictionary : mainList) {
//    			String pName = baseSystemDictionary.getDicTypeValue();
//    			for (BaseSystemDictionary baseSystemDictionary1 : sdList) {
//    				String sdName = baseSystemDictionary1.getDicTypeValue();
//    				BaseK3Code bean = new BaseK3Code();
//    				bean.setAdditionalBusinessId(baseSystemDictionary1.getDicTypeValueId());
//    				String name = "主营业务收入--" + pName + "--" + sdName;
//    				String code = "6001." + baseSystemDictionary.getDicTypeValueId() + "." + baseSystemDictionary1.getDicTypeValueId();
//    				bean.setBusinessId(baseSystemDictionary.getDicTypeValueId());
//    				bean.setK3Code(code);
//    				bean.setK3Name(name);
//    				bean.setType(10);
//    				list.add(bean);
//    			}
//			}
//    		
//    		if(list.size() > 0){
//    			K3Code dao = new K3Code();
//    			dao.setConditionType("=", 10);
//    			dao.conditionalDelete();
//    			dao.save(list);
//    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
