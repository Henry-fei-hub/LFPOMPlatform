package pomplatform.attachment.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.attachment.bean.BaseMprojectccpor;
import pomplatform.attachment.bean.ConditionMprojectccpor;
import pomplatform.attachment.query.QueryMprojectccpor;

public class CustomIntegralAnalysisProcess implements GenericProcessor{
	
	private final static String DO_ANALYSIS = "doAnalysis"; 

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case DO_ANALYSIS:
				return doAnalysis(result);
			}
		}
		return null;
	}
	
	public String doAnalysis(Map<String, Object> params) throws SQLException{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMessage = null;
		//type == 1统计合同相关的订单 type = 2 统计单个订单   type = 3统计全部
		int type = BaseHelpUtils.getIntValue(params , "type");
		int id = BaseHelpUtils.getIntValue(params , "id");
		List<Integer> list = new ArrayList<>();
		if(type == 3 || (id > 0 && type > 0)){
			if(type == 1){
				Project dao = new Project();
				dao.setConditionContractId("=", id);
				List<BaseProject> pList = dao.conditionalLoad();
				for (BaseProject baseProject : pList) {
					list.add(baseProject.getProjectId());
				}
				if(list.size() > 0){
					analysisProjectMoney(list, false);
				}
			} else if(type == 2) {
				list.add(id);
				analysisProjectMoney(list, false);
			} else if(type == 3) {
				analysisProjectMoney(null, true);
			}
		}
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMessage);
	}
	
	/**
	 * 
	 * @Title: analysisProjectMoney 
	 * @Description: 统计分析员工真实发放的积分
	 * @param @param list
	 * @param @param isAnaysisAll
	 * @param @throws SQLException   
	 * @return void   
	 * @throws
	 */
	public static void analysisProjectMoney(List<Integer> list, boolean isAnaysisAll) throws SQLException{
		//isAnaysisAll为统计所有则不需要带入条件
		if((null != list && list.size() > 0) || isAnaysisAll){
			QueryMprojectccpor dao = new QueryMprojectccpor();
			dao.setCurrentPage(0);
			dao.setPageLines(1);
			ConditionMprojectccpor condition = new ConditionMprojectccpor();
			BaseCollection<BaseMprojectccpor> result;
			if(isAnaysisAll){
				result = dao.executeQuery(null, condition);
			} else {
				if(list.size() == 1){
					condition.setProjectId(list.get(0));
					result = dao.executeQuery(null, condition);
				} else {
					int index = 0;
					String ids = "";
					for (Integer projectId : list) {
						if(index != 0){
							ids += ",";
						}
						ids += projectId;
						index ++;
					}
					String conditionStr = " pj.project_id in (" + ids + ") ";
					KeyValuePair replaceKeyValue = new KeyValuePair();
					replaceKeyValue.setKey("pj.project_id = ?");
					replaceKeyValue.setValue(conditionStr);
					KeyValuePair[] replacements = new KeyValuePair[1];
					replacements[0] = replaceKeyValue;
					result = dao.executeQuery(replacements, condition);
				}
			}
			List<BaseMprojectccpor> pList = result.getCollections();
			if(null != pList && pList.size() > 0){
				//分析金额进行更改
				ProjectSettlementDetail psdDao = new ProjectSettlementDetail();
				
				ProjectSettlement psDao = new ProjectSettlement();
//				int index = 0;
				for (BaseMprojectccpor baseMprojectccpor : pList) {
					BigDecimal useIntegral = baseMprojectccpor.getConfirmProjectIntegral();
					if(useIntegral.compareTo(BigDecimal.ZERO) > 0){
						
						int projectId = baseMprojectccpor.getProjectId();
						psDao.clear();
						psDao.setConditionProjectId("=", projectId);
						List<BaseProjectSettlement> psList = psDao.conditionalLoad(" order by stage_id, settlement_id");
						if(psList.size() > 0){
//							index++;
//							System.out.println(" begin =================" + index );
//							System.out.println(baseMprojectccpor.getProjectId() + " ========="  + useIntegral);
							for (BaseProjectSettlement baseProjectSettlement : psList) {
								if(useIntegral.compareTo(BigDecimal.ZERO) > 0){
									//表示当前阶段的确认积分可以全部分配
									if(useIntegral.compareTo(baseProjectSettlement.getTotalAmount()) >= 0){
										//完全下达该settlement_id下的所有积分
										psdDao.clear();
										psdDao.setConditionSettlementId("=", baseProjectSettlement.getSettlementId());
										List<BaseProjectSettlementDetail> psdList = psdDao.conditionalLoad();
										for (BaseProjectSettlementDetail baseProjectSettlementDetail : psdList) {
											psdDao.clear();
											psdDao.setConditionSettlementDetailId("=", baseProjectSettlementDetail.getSettlementDetailId());
											psdDao.setAdjustedAmount(baseProjectSettlementDetail.getRealAmount());
											psdDao.conditionalUpdate();
										}
										useIntegral = useIntegral.subtract(baseProjectSettlement.getTotalAmount());
//										System.out.println("  all ====" + index);
									}else{
										//当钱不足够时  按照  确认积分/该次确认总积分 * 可分配积分 进行分配
										psdDao.clear();
										psdDao.setConditionSettlementDetailId("=", baseProjectSettlement.getSettlementId());
										List<BaseProjectSettlementDetail> psdList = psdDao.conditionalLoad();
										for (BaseProjectSettlementDetail baseProjectSettlementDetail : psdList) {
											psdDao.clear();
											psdDao.setConditionSettlementDetailId("=", baseProjectSettlementDetail.getSettlementDetailId());
											BigDecimal adjustAmount = (baseProjectSettlementDetail.getRealAmount().divide(baseProjectSettlement.getTotalAmount(), 3)).multiply(useIntegral);
											psdDao.setAdjustedAmount(BaseHelpUtils.format(adjustAmount, 2));
											psdDao.conditionalUpdate();
										}
										useIntegral = BigDecimal.ZERO;
//										System.out.println("  some ====" + index);
									}
								}else{
									break;
								}
							}
//							System.out.println(" end ===================");
						}
						
					}
				}
				
			}
		}
	}
	
	
	
//	public static void analysisProjectMoney(List<Integer> list, boolean isAnaysisAll) throws SQLException{
//		//isAnaysisAll为统计所有则不需要带入条件
//		if((null != list && list.size() > 0) || isAnaysisAll){
//			QueryMprojectccpor dao = new QueryMprojectccpor();
//			dao.setCurrentPage(0);
//			dao.setPageLines(1);
//			ConditionMprojectccpor condition = new ConditionMprojectccpor();
//			BaseCollection<BaseMprojectccpor> result;
//			if(isAnaysisAll){
//				result = dao.executeQuery(null, condition);
//			} else {
//				if(list.size() == 1){
//					condition.setProjectId(list.get(0));
//					result = dao.executeQuery(null, condition);
//				} else {
//					int index = 0;
//					String ids = "";
//					for (Integer projectId : list) {
//						if(index != 0){
//							ids += ",";
//						}
//						ids += projectId;
//						index ++;
//					}
//					String conditionStr = " pj.project_id in (" + ids + ") ";
//					KeyValuePair replaceKeyValue = new KeyValuePair();
//					replaceKeyValue.setKey("pj.project_id = ?");
//					replaceKeyValue.setValue(conditionStr);
//					KeyValuePair[] replacements = new KeyValuePair[1];
//					replacements[0] = replaceKeyValue;
//					result = dao.executeQuery(replacements, condition);
//				}
//			}
//			List<BaseMprojectccpor> pList = result.getCollections();
//			if(null != pList && pList.size() > 0){
//				//分析金额进行更改
//				ProjectSettlementDetail psDao = new ProjectSettlementDetail();
//				for (BaseMprojectccpor baseMprojectccpor : pList) {
//					BigDecimal useIntegral = baseMprojectccpor.getConfirmProjectIntegral();
//					if(useIntegral.compareTo(BigDecimal.ZERO) > 0)System.out.println(baseMprojectccpor.getProjectId() + " ========="  + useIntegral);
//					psDao.clear();
//					psDao.setConditionProjectId("=", baseMprojectccpor.getProjectId());
//					List<BaseProjectSettlementDetail> psList = psDao.conditionalLoad(" order by settlement_date, settlement_detail_id");
//					if(psList.size() > 0 && useIntegral.compareTo(BigDecimal.ZERO) > 0){
//						for (BaseProjectSettlementDetail baseProjectSettlementDetail : psList) {
//							
//							psDao.clear();
//							psDao.setConditionSettlementDetailId("=", baseProjectSettlementDetail.getSettlementDetailId());
//							if(baseProjectSettlementDetail.getRealAmount().compareTo(BigDecimal.ZERO) > 0 ){
//								if(baseProjectSettlementDetail.getRealAmount().compareTo(useIntegral) >= 0){
//									psDao.setAdjustedAmount(useIntegral);
//									useIntegral = BigDecimal.ZERO;
//									psDao.conditionalUpdate();
//									break;
//								}else{
//									psDao.setAdjustedAmount(baseProjectSettlementDetail.getRealAmount());
//									psDao.conditionalUpdate();
//									useIntegral = useIntegral.subtract(baseProjectSettlementDetail.getRealAmount());
//								}
//							} else {
//								break;
//							}
//						}
//					}
//				}
//				
//			}
//		}
//	}
	
	public static void main(String[] args) throws SQLException {
		List<Integer> list= new ArrayList<>();
		analysisProjectMoney(list, true);
	}
}
