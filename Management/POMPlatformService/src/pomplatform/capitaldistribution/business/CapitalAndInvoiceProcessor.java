package pomplatform.capitaldistribution.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseAttachmentLinkInvoice;
import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractMessage;
import com.pomplatform.db.bean.BaseContractMessageDetail;
import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseProjectStageProcessDetail;
import com.pomplatform.db.dao.AttachmentLinkInvoice;
import com.pomplatform.db.dao.AttachmentManage;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractMessage;
import com.pomplatform.db.dao.ContractMessageDetail;
import com.pomplatform.db.dao.Invoice;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.ProjectStageProcessDetail;
import com.pomplatform.db.dao.ProjectStageProcessRecord;
import com.pomplatform.db.dao.SystemProcessInstanceActivity;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.SystemProcessInstance;
import message.common.ERPWeixinUtils;
import pomplatform.ProjectStages.bean.BaseOnLoadProjectStageInProcess;
import pomplatform.ProjectStages.bean.BaseProjectStageProcessRecordWithP;
import pomplatform.ProjectStages.bean.ConditionOnLoadProjectStageInProcess;
import pomplatform.ProjectStages.dao.ProjectStageProcessRecordWithP;
import pomplatform.ProjectStages.query.QueryOnLoadProjectStageInProcess;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.preProjects.bean.BaseOnLoadMainProjectEmployeeNameAndNo;
import pomplatform.preProjects.bean.ConditionOnLoadMainProjectEmployeeNameAndNo;
import pomplatform.preProjects.query.QueryOnLoadMainProjectEmployeeNameAndNo;


public class CapitalAndInvoiceProcessor implements GenericProcessor {
    private static final Logger __logger = Logger.getLogger("");
    private static final String SAVEDATA = "saveData";
    private static final String UPDATEPROJECTMANAGER = "updateProjectManager";
    
    //账单流水  -- 流水登记    Project_Stages_Process_Application
    private static final String SAVE_CAPITAL_AND_AUTO_APPLY_STAGES = "saveCapitalAndAutoApplyStages";
    @Override
    public String execute(String creteria, HttpServletRequest httpServletRequest) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            @SuppressWarnings("rawtypes")
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        String optType = BaseHelpUtils.getStringValue(result, "optType");
        if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result)) {
            switch (optType) {
                case SAVEDATA:
                    return saveData(result);
                case UPDATEPROJECTMANAGER:
                    return updateProjectManager(result);
                case SAVE_CAPITAL_AND_AUTO_APPLY_STAGES:
                	return saveCapitalAndAutoApplyStages(result);
                default:
                    break;
            }
        }
        return null;
    }
    

    /**
     * 账单流水  -- 流水登记 并且确认回款是否超过阶段占比，如果是则自动确认可分配阶段
     * @return
     */
	private String saveCapitalAndAutoApplyStages(Map<String, Object> result) throws SQLException {

		
		int employeeId = BaseHelpUtils.getIntValue(result.get("employeeId"));
		int contractId = BaseHelpUtils.getIntValue(result.get("contractId"));

		ThreadConnection.beginTransaction();
		//保存本次的账单流水登记的数据
		Capital cDao = new Capital();
		BaseCapital baseCapital = new BaseCapital();
		baseCapital.setDataFromMap(result);
		cDao.setDataFromBase(baseCapital);
		cDao.save();
		
		if (contractId > 0) {
			Contract dao = new Contract();
			dao.setConditionContractId("=", contractId);
			dao.setContractId(contractId);
			if (!dao.load()) {
				throw new SQLException("合同信息获取失败");
			}

			// 签约总金额
			BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(dao.getSigningMoneySum());

			// 获取该合同下的所有流水金额
			cDao.clear();
			cDao.setConditionContractId("=", contractId);
			List<BaseCapital> capitalList = cDao.conditionalLoad();
			// 回款之和
			BigDecimal borrowMoney = BigDecimal.ZERO;
			for (BaseCapital base : capitalList) {
				borrowMoney = borrowMoney.add(BaseHelpUtils.getBigDecimalValue(base.getBorrowMoney()));
			}

			// 合同下的所有阶段积分之和
			BigDecimal projectAmountSum = BigDecimal.ZERO;
			// 本次可申请的积分之和
			BigDecimal applyAmount = BigDecimal.ZERO;
			// 合同下的已回款比例
			BigDecimal borrowMoneyPercent = BigDecimal.ZERO;
			// 合同下的阶段比例
			BigDecimal percentSum = BigDecimal.ZERO;
			// 可分配阶段申请流程确认占比和 包括status in (1,3)
			BigDecimal applyPercentSum = BigDecimal.ZERO;

			
			ProjectStageProcessRecord pspr =new ProjectStageProcessRecord();
			ProjectStageProcessDetail pspd =new ProjectStageProcessDetail();
			
			ProjectStage psDao = new ProjectStage();
			psDao.setConditionContractId("=", contractId);
			List<BaseProjectStage> baseProjectStageList = psDao.conditionalLoad("order by project_stage_id asc");
			if (baseProjectStageList.size() > 0 && borrowMoney.compareTo(BigDecimal.ZERO) > 0
					&& signingMoneySum.compareTo(BigDecimal.ZERO) > 0) {
				if (borrowMoney.compareTo(signingMoneySum) >= 0) {// 如果回款金额比合同金额大 ，则回款比例设置为100%
					borrowMoneyPercent = new BigDecimal(100);
				} else {
					borrowMoneyPercent = borrowMoney.divide(signingMoneySum, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
				}
				//遍历已完成的
				for (BaseProjectStage base1 : baseProjectStageList) {
					Integer status = BaseHelpUtils.getIntValue(base1.getStatus());
					BigDecimal percent = BaseHelpUtils.getBigDecimalValue(base1.getPercent());
					BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(base1.getProjectAmount());
					if(status == StaticUtils.PROJECT_STAGES_STAUTS_2) {//已完成
						percentSum = percentSum.add(percent);
						projectAmountSum = projectAmountSum.add(projectAmount);
					}
				}
				
				
				//查询流程中的数据
				QueryOnLoadProjectStageInProcess query =new QueryOnLoadProjectStageInProcess();
				ConditionOnLoadProjectStageInProcess condition =new ConditionOnLoadProjectStageInProcess();
				condition.setContractId(contractId);
				condition.setProcessType(76);
				BaseCollection<BaseOnLoadProjectStageInProcess> execute = query.execute(null, condition);
				if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {//如果有进行中的流程
					List<BaseOnLoadProjectStageInProcess> collections = execute.getCollections();
					for (BaseOnLoadProjectStageInProcess baseOnLoadProjectStageInProcess : collections) {
						pspd.clear();
						pspd.setConditionContractId("=", contractId);
						pspd.setConditionProjectStageProcessRecordId("=", baseOnLoadProjectStageInProcess.getProjectStageProcessRecordId());
						List<BaseProjectStageProcessDetail> conditionalLoad = pspd.conditionalLoad("order by project_stage_process_detail_id asc");
						if(conditionalLoad.size()>0) {
							psDao.clear();
							Integer[] stageList =new Integer[conditionalLoad.size()];
							for (int i = 0; i <conditionalLoad.size(); i++) {
								stageList[i] = conditionalLoad.get(i).getStageId();
							}
							psDao.setConditionContractId("=", contractId);
							psDao.setConditionStatus("=", StaticUtils.PROJECT_STAGES_STAUTS_3);
							psDao.addCondition(BaseProjectStage.CS_STAGE_ID, "in", stageList);
							List<BaseProjectStage> baseProjectStageList2 = psDao.conditionalLoad();
							if(baseProjectStageList2.size()>0) {
								for (BaseProjectStage baseProjectStage : baseProjectStageList2) {
									BigDecimal percent = BaseHelpUtils.getBigDecimalValue(baseProjectStage.getPercent());
									BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(baseProjectStage.getProjectAmount());
									percentSum = percentSum.add(percent);
									projectAmountSum = projectAmountSum.add(projectAmount);
								}
								
								if (borrowMoneyPercent.compareTo(percentSum) >= 0) {
									// 把正在进行的流程直接通过
									SystemProcessInstance spi = new SystemProcessInstance();
									spi.setConditionBusinessId("=", baseOnLoadProjectStageInProcess.getProjectStageProcessRecordId());
									spi.setConditionProcessType("=", 76);
									spi.setProcessStatus(3);// 完成
									spi.conditionalUpdate();
		
									SystemProcessInstanceActivity spia = new SystemProcessInstanceActivity();
									spia.setConditionBusinessId("=", baseOnLoadProjectStageInProcess.getProjectStageProcessRecordId());
									spia.setConditionProcessType("=", 76);
									spia.setStatus(2);// 完成
									spia.conditionalUpdate();
								
									BigDecimal percent = BigDecimal.ZERO ;
									for (BaseProjectStage baseProjectStage : baseProjectStageList2) {
										psDao.clear();
										baseProjectStage.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_2);
										psDao.setDataFromBase(baseProjectStage);
										psDao.update();
										
										//本次流程确认的占比和
										percent = percent.add(BaseHelpUtils.getBigDecimalValue(psDao.getPercent()));
									}
									
									settleProjectType16(percent,contractId, employeeId);
									
								}
							}
						}
						
						
					}
				}
				
				List<BaseProjectStageProcessDetail> baseProjectStageProcessDetailList = new ArrayList<BaseProjectStageProcessDetail>();
				for (BaseProjectStage baseProjectStage : baseProjectStageList) {
					Integer status = BaseHelpUtils.getIntValue(baseProjectStage.getStatus());
					BigDecimal percent = BaseHelpUtils.getBigDecimalValue(baseProjectStage.getPercent());
					BigDecimal projectAmount = BaseHelpUtils.getBigDecimalValue(baseProjectStage.getProjectAmount());

					if (status == StaticUtils.PROJECT_STAGES_STAUTS_1) {// 1:未进行 可分配阶段确认
						// 已回款比例比当前累计的阶段的比例大，则表示本阶段可以自动确认，并且还需要校验下一个阶段
						percentSum = percentSum.add(percent);
						projectAmountSum = projectAmountSum.add(projectAmount);
						if (borrowMoneyPercent.compareTo(percentSum) >= 0) {
							applyPercentSum = applyPercentSum.add(percent);
							applyAmount = applyAmount.add(projectAmount);
							BaseProjectStageProcessDetail baseProjectStageProcessDetail = new BaseProjectStageProcessDetail();
							baseProjectStageProcessDetail.setStageId(baseProjectStage.getStageId());
							baseProjectStageProcessDetail
									.setPercent(BaseHelpUtils.getBigDecimalValue(baseProjectStage.getPercent()));
							baseProjectStageProcessDetail.setProjectAmount(baseProjectStage.getProjectAmount());
							baseProjectStageProcessDetail.setStageName(baseProjectStage.getStageName());
							baseProjectStageProcessDetail.setContractId(baseProjectStage.getContractId());
							baseProjectStageProcessDetail.setMainProjectId(baseProjectStage.getMainProjectId());
							baseProjectStageProcessDetailList.add(baseProjectStageProcessDetail);
						}
					}
				}
				
				// 遍历结束
				if (baseProjectStageProcessDetailList.size() > 0) {
					ProjectStageProcessRecordWithP psprDao = new ProjectStageProcessRecordWithP();
					BaseProjectStageProcessRecordWithP bean = new BaseProjectStageProcessRecordWithP();

					BaseProjectStageProcessDetail baseProjectStageProcessDetail = baseProjectStageProcessDetailList.get(0);
					Integer mainProjectId = baseProjectStageProcessDetail.getMainProjectId();
					MainProject mDao = new MainProject();
					mDao.setMainProjectId(mainProjectId);
					mDao.setConditionMainProjectId("=", mainProjectId);
					if (mDao.load()) {
						bean.setContractId(contractId);
						bean.setMainProjectId(mainProjectId);
						bean.setProjectName(mDao.getProjectName());
						bean.setProjectCode(mDao.getProjectCode());
						bean.setProjectAmountSum(projectAmountSum);
						bean.setApplyAmount(applyAmount);
						bean.setRemark("账单流水登记自动确认");
						bean.setDetailProjectStageProcessDetail(baseProjectStageProcessDetailList);
						psprDao.setDataFromBase(bean);
						int save = psprDao.save();
						if (save > 0) {
							List<BaseProjectStageProcessDetail> list = psprDao.getDetailProjectStageProcessDetail();
							for (BaseProjectStageProcessDetail detail : list) {
								Integer stageId = detail.getStageId();
								psDao.clear();
								psDao.setConditionContractId("=", contractId);
								psDao.setConditionStageId("=", stageId);
								BaseProjectStage base = psDao.executeQueryOneRow();
								base.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_2);
								psDao.clear();
								psDao.setDataFromBase(base);
								psDao.update();
							}

							// 比例在0-100
							if (applyPercentSum.compareTo(BigDecimal.ZERO) > 0
									&& applyPercentSum.compareTo(new BigDecimal(100)) <= 0) {
								Project pDao = new Project();
								pDao.setConditionContractId("=", bean.getContractId());
								pDao.setConditionProjectType("=", StaticUtils.PROJECT_TYPE_16);// 管理订单
								List<BaseProject> load = pDao.conditionalLoad();
								if (load.size() > 0) {
									for (BaseProject baseProject : load) {
										Integer projectId = baseProject.getProjectId();
										Integer projectManageId = baseProject.getProjectManageId();
										BigDecimal projectIntegral = baseProject.getProjectIntegral();

										String sheetCode = baseProject.getContractCode();
										String sheetName = baseProject.getProjectName();
										String remark = String.format("本笔结算来自项目%1$s(%2$s)的结算,%3$s", sheetName,
												sheetCode, "账单流水登记绑定合同自动确认可确认积分阶段");
										// 本阶段的管理订单可确认积分
										BigDecimal canSureProjectIntegral = projectIntegral.multiply(applyPercentSum)
												.multiply(new BigDecimal(0.01));
										// 确认积分插入个人账户表
										if (canSureProjectIntegral.compareTo(BigDecimal.ZERO) != 0) {
											ProjectSettlement projectsettDao = new ProjectSettlement();
											projectsettDao.clear();
											projectsettDao.setProjectId(projectId);
											projectsettDao.setEmployeeId(employeeId);
											projectsettDao.setSettlementDate(new Date());
											projectsettDao.setTotalAmount(canSureProjectIntegral);
											projectsettDao.setTotalCost(BigDecimal.ZERO);
											projectsettDao
													.setLeftAmount(projectIntegral.subtract(canSureProjectIntegral));
											projectsettDao.setProjectAmount(projectIntegral);
											projectsettDao.setStageId(-1);
											projectsettDao.setSettlementStatus(2);
											projectsettDao.setRemark(remark);
											projectsettDao.setFlag(2);
											projectsettDao.save();
											// 获取主键ID
											int settlementId = projectsettDao.getSettlementId();
											// 保存明细表
											ProjectSettlementDetail settDetailDao = new ProjectSettlementDetail();
											BaseProjectSettlementDetail settDetailBean = new BaseProjectSettlementDetail();
											settDetailBean.setSettlementId(settlementId);
											settDetailBean.setProjectId(projectId);
											settDetailBean.setEmployeeId(projectManageId);
											settDetailBean.setSettlementDate(new Date());
											settDetailBean.setPlanAmount(BigDecimal.ZERO);
											settDetailBean.setRealAmount(canSureProjectIntegral);
											settDetailBean.setProjectCost(BigDecimal.ZERO);
											settDetailBean.setFinalAmount(canSureProjectIntegral);
											settDetailBean.setSettlementStatus(2);
											settDetailDao.setDataFromBase(settDetailBean);
											settDetailDao.save();
											int businessId = settDetailDao.getSettlementDetailId();
											// 确认积分插入个人账户
											AccountManageProcess.onSaveEmployeeAccount(projectManageId, businessId,
													AccountManageProcess.EMP_BT_SURE_INTEGRAL, canSureProjectIntegral,
													new Date(), remark, -1);

										}
									}
								}
							} else {
								throw new SQLException("本次流程的占比之和范围不在0-100之间");
							}

							Map map = new HashMap<String, Object>();
							map.put("contractId", contractId);
							map.put("projectStageProcessRecordId", psprDao.getProjectStageProcessRecordId());
							map.put("employeeId", employeeId <= 0 ? -1 : employeeId);
							map.put("saveOrUpdate", 2);// 更新
							checkAndSaveContractMessage(map);
						}
					}
				}
			}
		}
		ThreadConnection.commit();

		BaseCollection<GenericBase> collection = new BaseCollection<>();
		return collection.toJSON(1, "");
	}

    /**
     * 更新发票上绑定的项目经理
     * @return
     */
    private String updateProjectManager(Map<String, Object> result) throws SQLException {
        int status = -1;
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        int invoiceId = BaseHelpUtils.getIntValue(result.get("invoiceId"));
        int projectMangerId = BaseHelpUtils.getIntValue(result.get("projectMangerId"));
        if (invoiceId > 0){
            Invoice invoiceDao = new Invoice();
            invoiceDao.setInvoiceId(invoiceId);
            boolean load = invoiceDao.load();
            if (load){
                BaseInvoice baseInvoice = invoiceDao.generateBase();
                invoiceDao.clear();
                baseInvoice.setProjectManagerId(projectMangerId);
                invoiceDao.setDataFromBase(baseInvoice);
                invoiceDao.update();
                status = 0;
            }
        }
        return collection.toJSON(status,"更新成功");
    }

    /**
     * 保存所有的数据
     * @param result
     * @return
     */
    private String saveData(Map<String, Object> result) throws SQLException {
        int status = -1;
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        //取出所有的发票的数据
        List<Map<String,Object>> invoiceList = (List<Map<String, Object>>) result.get("invoiceList");
        //取出所有的回款的数据
        List<Map<String,Object>> capitalList = (List<Map<String, Object>>) result.get("capitalList");
        Invoice invoiceDao = new Invoice();
        Capital capitaDao = new Capital();
        //循环遍历所有的发票数据
        for (Map<String,Object> invoice : invoiceList){
            int invoiceId = BaseHelpUtils.getIntValue(invoice.get("invoiceId"));
            BigDecimal capitalAmount = BaseHelpUtils.getBigDecimalValue(invoice.get("capitalAmount"));
            int isCapital = BaseHelpUtils.getIntValue(invoice.get("isCapital"));
            invoiceDao.setInvoiceId(invoiceId);
            boolean load = invoiceDao.load();
            if (load){
                BaseInvoice baseInvoice = invoiceDao.generateBase();
                invoiceDao.clear();
                baseInvoice.setCapitalAmount(capitalAmount);
                baseInvoice.setIsCapital(isCapital);
                invoiceDao.setDataFromBase(baseInvoice);
                System.out.println("++++++++++++++ isCapital = " + capitalAmount);
                System.out.println("++++++++++++++ capitalAmount = " + capitalAmount);
                System.out.println("++++++++++++++ baseInvoice = " + baseInvoice);
                invoiceDao.update();
                status = 1;
            }
        }
        //循环遍历所有的回款的数据
        for (Map<String,Object> capital : capitalList){
            //回款的主键
            int capitalId = BaseHelpUtils.getIntValue(capital.get("capitalId"));
            capitaDao.setCapitalId(capitalId);
            boolean load = capitaDao.load();
            if (load){
                BaseCapital baseCapital = capitaDao.generateBase();
                capitaDao.clear();
                capitaDao.setDataFromBase(baseCapital);
                capitaDao.setIsHavingInvoice(1);
                System.out.println("++++++++++++++ baseCapital = " + baseCapital);
                System.out.println("++++++++++++++ isHavingInvoice = " + 1);
                capitaDao.update();
                status = 1;
            }
        }
        return collection.toJSON(status,null);
    }

    /**
     * 自动匹配发票与回款相同的数据
     */
    private static void automaticMatchingData() throws SQLException {
        Invoice invoiceDao = new Invoice();
        Capital capitalDao = new Capital();
        Contract contractDao = new Contract();
        //查询合同ID大于0的所有的合同数据
        contractDao.setConditionContractId(">" , 0);
        List<BaseContract> contracts = contractDao.conditionalLoad();
        //循环遍历所有的合同查找出所有的发票的开票金额和回款金额相同的数据
        for (BaseContract baseContract : contracts){
            //定义总计的回款的金额数
            BigDecimal totalCapital = new BigDecimal(0);
            //定义总计的发票的金额数
            BigDecimal totalInvoce = new BigDecimal(0);
            int contractId = BaseHelpUtils.getIntValue(baseContract.getContractId());
            invoiceDao.clear();
            //查询该合同下面关联的所有的发票
            invoiceDao.setConditionContractId("=" , contractId);
            //只查询正常的发票和负数发票
            List<BaseInvoice> baseInvoices = invoiceDao.conditionalLoad("sign in (1 , 2)");
            //循环遍历所有的发票的数据
            if (null != baseInvoices && baseInvoices.size() != 0){
                for (BaseInvoice baseInvoice : baseInvoices){
                    //算出所有的发票的总额
                    BigDecimal temInvoiceAmount = BaseHelpUtils.getBigDecimalValue(baseInvoice.getInvoiceAmount());
                    totalInvoce = totalInvoce.add(temInvoiceAmount);
                }
            }
            capitalDao.clear();
            capitalDao.setConditionContractId("=" , contractId);
            List<BaseCapital> baseCapitals = capitalDao.conditionalLoad();
            //循环遍历所有的回款的数据
            if (null != baseCapitals && baseCapitals.size() != 0){
                for (BaseCapital baseCapital : baseCapitals){
                    //算出所有的回款的总额
                    BigDecimal temCapital = BaseHelpUtils.getBigDecimalValue(baseCapital.getBorrowMoney());
                    totalCapital = totalCapital.add(temCapital);
                }
            }
            //发票的总金额与回款的总金额相同的数据直接匹配
            if (totalCapital.compareTo(totalInvoce) == 0){
                //循环遍历所有的发票的数据
                if (null != baseInvoices && baseInvoices.size() != 0){
                    for (BaseInvoice baseInvoice : baseInvoices){
                        baseInvoice.setCapitalAmount(BaseHelpUtils.getBigDecimalValue(baseInvoice.getInvoiceAmount()));
                        baseInvoice.setIsCapital(1);
                        invoiceDao.clear();
                        invoiceDao.setDataFromBase(baseInvoice);
                        invoiceDao.update();
                    }
                }
                //循环遍历所有的回款的数据
                if (null != baseCapitals && baseCapitals.size() != 0){
                    for (BaseCapital baseCapital : baseCapitals){
                      baseCapital.setIsHavingInvoice(1);
                      capitalDao.clear();
                      capitalDao.setDataFromBase(baseCapital);
                      capitalDao.update();
                    }
                }

            }
        }
    }

    /**
     * 匹配发票和项目经理
     */
    private static void projectManagerAndInvoice() throws SQLException {
        AttachmentManage attachmentManageDao = new AttachmentManage();
        AttachmentLinkInvoice attachmentLinkInvoiceDao = new AttachmentLinkInvoice();
        Invoice invoiceDao = new Invoice();
        attachmentManageDao.setConditionContractId(">",0);
        //查询所有合同id大于0的所有的确认函
        List<BaseAttachmentManage> baseAttachmentManages = attachmentManageDao.conditionalLoad();
        if (null != baseAttachmentManages && baseAttachmentManages.size() != 0){
            //循环遍历所有的确认函
            for (BaseAttachmentManage baseAttachmentManage : baseAttachmentManages){
                //查询确认函绑定的项目经理的Id
                Integer projectmanagerId = BaseHelpUtils.getIntValue(baseAttachmentManage.getProjectManageId());
                int attachmentmanageId = BaseHelpUtils.getIntValue(baseAttachmentManage.getAttachmentManageId());
                attachmentLinkInvoiceDao.clear();
                attachmentLinkInvoiceDao.setConditionAttachmentManageId("=" , attachmentmanageId);
                List<BaseAttachmentLinkInvoice> baseAttachmentLinkInvoices = attachmentLinkInvoiceDao.conditionalLoad();
                //循环遍历所有的发票和确认函的中间表，找出确认函下面所有的发票
                if (null != baseAttachmentLinkInvoices && baseAttachmentLinkInvoices.size() != 0){
                    for (BaseAttachmentLinkInvoice baseAttachmentLinkInvoice : baseAttachmentLinkInvoices){
                        Integer invoiceId = BaseHelpUtils.getIntValue(baseAttachmentLinkInvoice.getInvoiceId());
                        invoiceDao.clear();
                        invoiceDao.setInvoiceId(invoiceId);
                        boolean load = invoiceDao.load();
                        if (load){
                            BaseInvoice baseInvoice = invoiceDao.generateBase();
                            baseInvoice.setProjectManagerId(projectmanagerId);
                            invoiceDao.clear();
                            invoiceDao.setDataFromBase(baseInvoice);
                            invoiceDao.update();
                        }
                    }
                }
            }
        }
    }

    /**
     * 发票关联大项目经理
     */
    public static void projectManagerAndInvoiceSupplement() throws SQLException {
        Invoice invoiceDao = new Invoice();
        Project projectDao = new Project();
        List<BaseInvoice> baseInvoices = invoiceDao.conditionalLoad("project_manager_id is null");
        if (null != baseInvoices && baseInvoices.size() != 0){
            for (BaseInvoice baseInvoice : baseInvoices){
                //获取每个发票下面关联的合同的ID
                Integer contractId = baseInvoice.getContractId();
                projectDao.clear();
                projectDao.setConditionContractId("=" , contractId);
                BaseProject baseProject = projectDao.executeQueryOneRow("project_type in (16 , 33)");
                if (null != baseProject){
                    Integer projectManageId = baseProject.getProjectManageId();
                    invoiceDao.clear();
                    baseInvoice.setProjectManagerId(projectManageId);
                    invoiceDao.setDataFromBase(baseInvoice);
                    invoiceDao.update();
                }
            }
        }
    }
    
    
    
    /**
     * 可分配阶段申请流程完成后，判读当前的阶段确认是否比回款快，如果是则保存数据以及进行消息通知
     */
    public static void checkAndSaveContractMessage(Map<String, Object> map) throws SQLException {
		ProjectStage psDao =new ProjectStage();
		Integer contractId =BaseHelpUtils.getIntValue(map.get("contractId"));
		psDao.setConditionContractId("=", contractId);
		psDao.setConditionStatus("=",StaticUtils.PROJECT_STAGES_STAUTS_2);
		List<BaseProjectStage> baseProjectStageList = psDao.conditionalLoad("order by project_stage_id asc");
		if(baseProjectStageList.size()>0) {
			Contract c =new  Contract();
			c.setConditionContractId("=", contractId);
			c.setContractId(contractId);
			if (!c.load()) {
				throw new SQLException("合同信息获取失败");
			}
			
			MainProject m = new MainProject();
			m.setConditionProjectCode("=", c.getProjectCode());
			BaseMainProject mainProject = m.executeQueryOneRow();
			if (BaseHelpUtils.isNullOrEmpty(mainProject)) {
				throw new SQLException("合同信息获取失败");
			}
			
			//合同下的已回款比例
			BigDecimal borrowMoneyPercent = BigDecimal.ZERO;
			//合同下的阶段比例
			BigDecimal percentSum = BigDecimal.ZERO;
			//签约总金额
			BigDecimal signingMoneySum = c.getSigningMoneySum();
			//回款之和
			BigDecimal borrowMoney = BigDecimal.ZERO;
			//合同下的所有阶段积分之和
			BigDecimal projectAmountSum = BigDecimal.ZERO;
			
			//获取该合同下的所有流水金额
			Capital cDao = new Capital();
			cDao.setConditionContractId("=", contractId);
			List<BaseCapital> capitalList = cDao.conditionalLoad();
			if(capitalList.size()>0) {
				for (BaseCapital base : capitalList) {
					borrowMoney = borrowMoney.add(BaseHelpUtils.getBigDecimalValue(base.getBorrowMoney()));
				}
			}
			
			for (BaseProjectStage baseProjectStage : baseProjectStageList) {
				percentSum = percentSum.add(BaseHelpUtils.getBigDecimalValue(baseProjectStage.getPercent()));
			}
			
			//如果回款金额比合同金额大 ，则回款比例设置为100%
			if(borrowMoney.compareTo(signingMoneySum)>=0) {
				borrowMoneyPercent =new BigDecimal(100);
			}else {
				borrowMoneyPercent = borrowMoney.divide(signingMoneySum,2, BigDecimal.ROUND_HALF_UP);
			}
			
			
			Integer saveOrUpdate =BaseHelpUtils.getIntValue(map.get("saveOrUpdate"));
			if(saveOrUpdate==1) {
				//已确认流程的比例之和大于已回款的比例之和
				if(percentSum.compareTo(borrowMoneyPercent)>0) {
					ContractMessage cm =new ContractMessage();
					BaseContractMessage bcm =new BaseContractMessage();
					
					ContractMessageDetail cmd =new ContractMessageDetail();
					BaseContractMessageDetail bcmd =new BaseContractMessageDetail();
					
					cm.setConditionContractId("=", contractId);
					cm.setConditionMsgStatus("=", StaticUtils.CONTRACT_MESSAGE_STAUTS_1);
					cm.setMsgStatus(StaticUtils.CONTRACT_MESSAGE_STAUTS_3);
					cm.conditionalUpdate();
					
					cm.clear();
					bcm.setContractId(contractId);
					bcm.setMsgCount(1);
					bcm.setBusinessId(BaseHelpUtils.getIntValue(map.get("projectStageProcessRecordId")));
					bcm.setMsgStatus(StaticUtils.CONTRACT_MESSAGE_STAUTS_1);
					bcm.setOperator(BaseHelpUtils.getIntValue(map.get("employeeId")));
					bcm.setRemark("可分配阶段申请流程完成并且已确认流程的比例之和大于已回款的比例之和，生成自动消息推送记录");
					cm.setDataFromBase(bcm);
					cm.save();
					
					QueryOnLoadMainProjectEmployeeNameAndNo query = new QueryOnLoadMainProjectEmployeeNameAndNo();
					ConditionOnLoadMainProjectEmployeeNameAndNo  condition =new ConditionOnLoadMainProjectEmployeeNameAndNo();
					condition.setMainProjectId( mainProject.getMainProjectId());
					BaseCollection<BaseOnLoadMainProjectEmployeeNameAndNo> execute = query.execute(null, condition);
					if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
						List<BaseOnLoadMainProjectEmployeeNameAndNo> employeeList = execute.getCollections();
						HashSet<Integer> set = new HashSet<>();
						String content ="您好,("+c.getContractCode()+")"+c.getContractName()+",出图阶段超过项目回款进度，请尽快处理!";
						StringBuffer employeeStr =new StringBuffer();
						for (BaseOnLoadMainProjectEmployeeNameAndNo baseMainProjectEmployee : employeeList) {
							set.add(baseMainProjectEmployee.getEmployeeId());
							employeeStr.append(baseMainProjectEmployee.getEmployeeName()+";");
						}
						Object[] employeeIds = new Object[set.size()];
						Iterator<Integer> it = set.iterator();
						int i = 0 ;
						while (it.hasNext()) {
							Integer j = it.next();
							employeeIds[i] = j;
							i++;
						}
//						ERPWeixinUtils.sendWXMsgToUser(content, employeeIds);
						bcmd.setContractId(contractId);
						bcmd.setContractMessageId(cm.getContractMessageId());
						bcmd.setOperator(BaseHelpUtils.getIntValue(map.get("employeeId")));
						bcmd.setRemark(employeeStr.toString());
						cmd.clear();
						cmd.setDataFromBase(bcmd);
						cmd.save();
					}else {
						bcmd.setContractId(contractId);
						bcmd.setContractMessageId(cm.getContractMessageId());
						bcmd.setOperator(BaseHelpUtils.getIntValue(map.get("employeeId")));
						bcmd.setRemark("本次消息推送未找到相关的项目人员");
						cmd.clear();
						cmd.setDataFromBase(bcmd);
						cmd.save();
					}
				}
			}else if(saveOrUpdate==2) {
				//已确认流程的比例之和大于已回款的比例之和
				if(percentSum.compareTo(borrowMoneyPercent)<=0) {
					ContractMessage cm =new ContractMessage();
					cm.setConditionContractId("=", contractId);
					cm.setConditionMsgStatus("=", StaticUtils.CONTRACT_MESSAGE_STAUTS_1);
					cm.setMsgStatus(StaticUtils.CONTRACT_MESSAGE_STAUTS_2);
					cm.conditionalUpdate();
				}
			}
		}
    }
    
    

	//结算管理订单的进度
	public static  void settleProjectType16(BigDecimal percent,int contractId,int operateEmployeeId) throws SQLException {
		if(percent.compareTo(BigDecimal.ZERO)>0&&percent.compareTo(new BigDecimal(100))<=0) {
			Project pDao =new Project();
			pDao.clear();
			pDao.setConditionContractId("=",contractId);
			pDao.setConditionProjectType("=", StaticUtils.PROJECT_TYPE_16);//管理订单
			List<BaseProject> conditionalLoad = pDao.conditionalLoad();
			if(conditionalLoad.size()>0) {
				
				BigDecimal percentSum = BigDecimal.ZERO ;
				BigDecimal projectAmountSum = BigDecimal.ZERO;
				ProjectStage psDao =new ProjectStage();
				psDao.setConditionStatus("=", StaticUtils.PROJECT_STAGES_STAUTS_2);
				psDao.setConditionContractId("=", contractId);
				List<BaseProjectStage> list = psDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {
					for (BaseProjectStage baseProjectStage : list) {
						percentSum = percentSum.add(BaseHelpUtils.getBigDecimalValue(baseProjectStage.getPercent()));
						projectAmountSum = projectAmountSum.add(BaseHelpUtils.getBigDecimalValue(baseProjectStage.getProjectAmount()));
					}
				}
				
				for (BaseProject baseProject : conditionalLoad) {
					Integer projectId = baseProject.getProjectId();
					Integer projectManageId = baseProject.getProjectManageId();
					BigDecimal projectIntegral = baseProject.getProjectIntegral();
					
					String sheetCode = baseProject.getContractCode();
					String sheetName = baseProject.getProjectName();
					String remark = String.format("本笔结算来自项目%1$s(%2$s)的结算", sheetName,sheetCode);
					//本阶段的管理订单可确认积分
					BigDecimal canSureProjectIntegral = BigDecimal.ZERO;
					if((percentSum.add(percent)).compareTo(new BigDecimal(100))>0) {
						canSureProjectIntegral = projectIntegral.subtract(projectAmountSum);
					}else {
						canSureProjectIntegral = projectIntegral.multiply(percent).multiply(new BigDecimal(0.01));
					}
					
					//确认积分插入个人账户表
					if(canSureProjectIntegral.compareTo(BigDecimal.ZERO) != 0){
						ProjectSettlement projectsettDao = new ProjectSettlement();
						projectsettDao.clear();
						projectsettDao.setProjectId(projectId);
						projectsettDao.setEmployeeId(operateEmployeeId);
						projectsettDao.setSettlementDate(new Date());
						projectsettDao.setTotalAmount(canSureProjectIntegral);
						projectsettDao.setTotalCost(BigDecimal.ZERO);
						projectsettDao.setLeftAmount(projectIntegral.subtract(canSureProjectIntegral).subtract(projectAmountSum));
						projectsettDao.setProjectAmount(projectIntegral);
						projectsettDao.setStageId(-1);
						projectsettDao.setSettlementStatus(2);
						projectsettDao.setRemark(remark);
						projectsettDao.setFlag(2);
						projectsettDao.save();
						//获取主键ID
						int settlementId = projectsettDao.getSettlementId();
						//保存明细表
						ProjectSettlementDetail settDetailDao = new ProjectSettlementDetail();
						BaseProjectSettlementDetail settDetailBean = new BaseProjectSettlementDetail();
						settDetailBean.setSettlementId(settlementId);
						settDetailBean.setProjectId(projectId);
						settDetailBean.setEmployeeId(projectManageId);
						settDetailBean.setSettlementDate(new Date());
						settDetailBean.setPlanAmount(BigDecimal.ZERO);
						settDetailBean.setRealAmount(canSureProjectIntegral);
						settDetailBean.setProjectCost(BigDecimal.ZERO);
						settDetailBean.setFinalAmount(canSureProjectIntegral);
						settDetailBean.setSettlementStatus(2);
						settDetailDao.setDataFromBase(settDetailBean);
						settDetailDao.save();
						int businessId = settDetailDao.getSettlementDetailId();
						//确认积分插入个人账户
						AccountManageProcess.onSaveEmployeeAccount(projectManageId, businessId, AccountManageProcess.EMP_BT_SURE_INTEGRAL, canSureProjectIntegral, new Date(), remark, -1);
						
					}
				}
			}
		}else {
			throw new SQLException("本次流程的占比之和范围不在0-100之间");
		}
	}

    /**
     * 主方法测试
     * @param args
     */
    public static void main(String[] args) throws SQLException {
    	CapitalAndInvoiceProcessor a =new CapitalAndInvoiceProcessor();
    	Map<String , Object> map =new HashMap<>();
    	map.put("employeeId", 0);
    	map.put("contractId", 2054);
    	
    	a.saveCapitalAndAutoApplyStages(map);
    }
}

