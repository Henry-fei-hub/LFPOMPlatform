package pomplatform.ht.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.BaseOutQuotation;
import com.pomplatform.db.bean.BaseOutRedesignConsideration;
import com.pomplatform.db.bean.BaseOutTemplet;
import com.pomplatform.db.bean.BaseOutTempletOption;
import com.pomplatform.db.bean.BaseOutTempletsLinkOutTempletOption;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BaseProductionValueCoefficient;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.bean.CustomBaseOutDesignConsideration;
import com.pomplatform.db.bean.StaticMethod;
import com.pomplatform.db.dao.DesignConsideration;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.OutDesignConsideration;
import com.pomplatform.db.dao.OutQuotation;
import com.pomplatform.db.dao.OutRedesignConsideration;
import com.pomplatform.db.dao.OutTemplet;
import com.pomplatform.db.dao.OutTempletOption;
import com.pomplatform.db.dao.OutTempletsLinkOutTempletOption;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.ProductionValueCoefficient;
import com.pomplatform.db.dao.ProductionValueCoefficientType;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.executor.SelectValueCache;
import pomplatform.groupOutdesignconsiderationior.bean.BaseGroupOutdesignconsiderationior;
import pomplatform.groupOutdesignconsiderationior.bean.ConditionGroupOutdesignconsiderationior;
import pomplatform.groupOutdesignconsiderationior.query.QueryGroupOutdesignconsiderationior;
import pomplatform.outPriceListItem.bean.BaseOutPriceListItem;
import pomplatform.outPriceListItem.bean.ConditionOutPriceListItem;
import pomplatform.outPriceListItem.query.QueryOutPriceListItem;
import pomplatform.sumDesignconsideration.bean.BaseSumDesignconsideration;
import pomplatform.sumDesignconsideration.bean.ConditionSumDesignconsideration;
import pomplatform.sumDesignconsideration.query.QuerySumDesignconsideration;

public class CustomOutDesigneConsiderationHandler implements GenericProcessor, GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomOutDesigneConsiderationHandler.class);
	
	private static final String CHECK_CFJ_DATA = "checkCFJData";
	/**
	 * 检查报价单子的对内对外的报价金额一致Internal and external
	 */
	private static final String CHECK_INTERNAL_AND_EXTERNAL = "checkInternalAndExternal";
	
	private static final String CHECK_PRICE_DATA = "checkPriceData";
	/**
	 * 检查模板的单子不能相同名称的
	 */
	private static final String CHECK_OUT_DESIGN_CONSIDERATION = "checkOutDesignConsideration";
	/**
	 * 给项目信息标记是否有报价单
	 */
	private static final String SIGN_QUOTATION_STATUS = "signQuotationStatus";
	/**
	 * 加载模板数据的列表
	 */
	private static final String GET_TEMPLATE_DATA_LIST = "getTemplateDataList";

	/**
	 * 根据业务类型,报价单id 查询对应的报价单子项
	 */
	private static final String GET_BUSINESS_TYPE_QUERY_DATA = "getBusinessTypeQueryData";

	/**
	 * 根据主报价单信息获取报价单子项信息
	 */
	private static final String GET_OUT_CONSIDERATIONS_LIST = "getConsiderationsList";
	private static final String GET_CHECK_CONSIDERATIONS_LIST ="getCheckConsiderationsList";

	/**
	 * 统计业务类别的金额
	 */
	private static final String GET_TJ_MONEY = "getCountMoney";
	/**
	 * 报价单子项信息保存或更新
	 */
	private static final String SAVE_OR_UPDATE_OUT_CONSIDERATIONS = "saveOrUpdateOutDesignConsideration";

	/**
	 * 将勾选的报价单转到(初步)拆分价表中去
	 */
	private static final String ADD_RECONSIDERATIONS_LIST = "addRedesigneConsiderationList";
	/**
	 * 将勾选的报价单转到(精细)拆分价表中去
	 */
	private static final String ADD_CONSIDERATIONS_LIST = "addDesigneConsiderationList";
	/**
	 * 删除主报价单的子项
	 */
	private static final String DELETE_OUT_CONSIDERATIONS = "deleteOutDesignConsideration";
	/**
	 * 检查拆分价不能大于报价单的总价
	 */
	private static final String CHECK_NOT_SUM_MONEY = "checkSumMoney";
	/**
	 * 判断报价单能否删除
	 */
	private static final String CHECK_IS_OUT_QUOTATION = "checkIsOutQuotation";

	/**
	 * 移动报价单子项
	 */
	private static final String MOVE_OUT_DESIGNER_CONSIDERATIONS = "moveOutDesignConsideration";
	
	/**
	 * 根据报价单ID和报价单类型删除报价单子项
	 */
	private static final String DELETE_OUT_CONSIDERATIONS_BY_OQ_AND_BT = "deleteOutConsiderationsByOqAndBt";
	/**
	 * 根据报价单页面的projectCode获取mainProjectId,在获取产值表main_project_business_types的作为产值
	 */
	private static final String GET_MAIN_PROJECT_BUSINESS_TYPE = "getMainProjectBusinessType";
	
	/**
	 * 
	 */
	private static final String NEW_MAIN_PROJECT_BUSINESS_TYPE = "newMainProjectBusinessType";
	
	/**
	 * 
	 */
	private static final String SAVE_MAIN_PROJECT_BUSINESS_TYPE = "saveMainProjectBusinessType";
	/**
	 * 
	 */
	private static final String SAVE_OUT_DESIGN_CONSIDERATIONS = "saveOutDesignConsiderations";
	/**
	 * 
	 */
	private static final String UPDATE_NEW_CREATE_QUOTATION_NAME = "updateNewCreateQuotationName";
	/**
	 * 
	 */
	private static final String UPDATE_MAIN_PROJECT_BUSINESS_TYPE = "updateMainProjectBusinessType";
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result)) {
			switch (optType) {
			case GET_TJ_MONEY:
				return getCountMoney(result, 0);
			case SIGN_QUOTATION_STATUS:
				return signQuotationStatus(result);
			case GET_OUT_CONSIDERATIONS_LIST:
				return getConsiderationsList(result);
			case GET_CHECK_CONSIDERATIONS_LIST:
				return getCheckConsiderationsList(result);
			case SAVE_OR_UPDATE_OUT_CONSIDERATIONS:
				return saveOrUpdateOutDesignConsideration(creteria);
			case ADD_CONSIDERATIONS_LIST:
				return addDesigneConsiderationList(result);
			case ADD_RECONSIDERATIONS_LIST:
				return addRedesigneConsiderationList(result);
			case DELETE_OUT_CONSIDERATIONS:
				return deleteOutDesignConsideration(result);
			case CHECK_NOT_SUM_MONEY:
				return CheckSumMoney(result);
			case CHECK_IS_OUT_QUOTATION:
				return checkIsOutQuotation(result);
			case GET_BUSINESS_TYPE_QUERY_DATA:
				return getBusinessTypeQueryData(result);
			case GET_TEMPLATE_DATA_LIST:
				return getTemplateDataList(result);
			case MOVE_OUT_DESIGNER_CONSIDERATIONS:
				return moveOutDesignConsideration(result);
			case DELETE_OUT_CONSIDERATIONS_BY_OQ_AND_BT:
				return deleteOutConsiderationsByOqAndBt(result);
			case CHECK_OUT_DESIGN_CONSIDERATION:
				return checkOutDesignConsideration(result);
			case CHECK_PRICE_DATA:
				return checkPriceData(result);
			case CHECK_INTERNAL_AND_EXTERNAL:
				return checkInternalAndExternal(result);
			case CHECK_CFJ_DATA:
				return checkCFJData(result);
			case GET_MAIN_PROJECT_BUSINESS_TYPE:
				return getMainProjectBusinessType(result);
			case SAVE_MAIN_PROJECT_BUSINESS_TYPE:
				return saveMainProjectBusinessType(result);
			case SAVE_OUT_DESIGN_CONSIDERATIONS:
				return saveOutDesignConsiderations(result);
			case UPDATE_NEW_CREATE_QUOTATION_NAME:
				return updateNewCreateQuotationName(result);
			case UPDATE_MAIN_PROJECT_BUSINESS_TYPE:
				return updateMainProjectBusinessType(result);
			case NEW_MAIN_PROJECT_BUSINESS_TYPE:
				return newMainProjectBusinessType(result);
			}
		}
		return null;
	}
	
	/**
	 * 新增报价单内部报价
	 * @param result
	 * @return
	 * @throws Exception
	 */
	
	public static String newMainProjectBusinessType(Map<String, Object> result) throws Exception{
		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		int outQuotationId = BaseHelpUtils.getIntValue(result.get("outQuotationId"));
		String projectCode = BaseHelpUtils.getString(result.get("projectCode"));
		String infoCode = BaseHelpUtils.getString(result.get("infoCode"));
		MainProject mpDao = new MainProject();
		mpDao.setConditionProjectCode("=", projectCode);
		mpDao.setConditionInfoCode("=", infoCode);
		BaseMainProject bean = mpDao.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(bean)) {
			Integer mainProjectId = bean.getMainProjectId();	
			MainProjectBusinessType mbdao = new MainProjectBusinessType();
			// 业务类别
			BaseMainProjectBusinessType b =new BaseMainProjectBusinessType();
			b.setMainProjectId(mainProjectId);
			b.setOutQuotationId(outQuotationId);
//			b.setBusinessType(BaseHelpUtils.getIntValue(base.getBusinessType()));
			b.setArea(BigDecimal.ZERO);
			b.setOutputValue(BigDecimal.ZERO);
			mbdao.setDataFromBase(b);
			mbdao.save();
		}
		
		return bc.toJSON(0,"");
	}
	
	/**
	 * 更新报价单标题
	 * @param result
	 * @return
	 * @throws Exception
	 */
	
	public static String updateNewCreateQuotationName(Map<String, Object> result) throws Exception{
		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		int outQuotationId = BaseHelpUtils.getIntValue(result.get("outQuotationId"));
		String newCreateQuotationName = BaseHelpUtils.getStringValue(result, "newCreateQuotationName");
		
		if(!BaseHelpUtils.isNullOrEmpty(newCreateQuotationName)&&outQuotationId>0) {
			
			OutDesignConsideration odc = new OutDesignConsideration();
			odc.setConditionOutQuotationId("=", outQuotationId);
			odc.setNewCreateQuotationName(newCreateQuotationName);
			odc.conditionalUpdate();
		}
		
		return bc.toJSON(0,"");
	}
	
	
	/**
	 * 保存合同报价单
	 * @param result
	 * @return
	 * @throws Exception
	 */
	
	public static String saveOutDesignConsiderations(Map<String, Object> result) throws Exception{
		BaseCollection<BaseMainProjectBusinessType> bc = new BaseCollection<>();
		int valRes=1;
		String errorStr="";
		
		//报价单主表id
		int outQuotationId = BaseHelpUtils.getIntValue(result.get("outQuotationId"));
		int type = BaseHelpUtils.getIntValue(result.get("type"));
		int outTempletId = BaseHelpUtils.getIntValue(result.get("outTempletId"));
		int employeeId = BaseHelpUtils.getIntValue(result.get("employeeId"));
		String projectCode = BaseHelpUtils.getString(result.get("projectCode"));
		String infoCode = BaseHelpUtils.getString(result.get("infoCode"));
		String newCreateQuotationName = BaseHelpUtils.getString(result.get("newCreateQuotationName")).trim();
		List<Map<String, String>> outDesignConsiderationsReocrd = (List<Map<String, String>>) result.get("outDesignConsiderationsReocrd");
		if(!BaseHelpUtils.isNullOrEmpty(outDesignConsiderationsReocrd)&&outDesignConsiderationsReocrd.size()>0) {
//			List<BaseOutDesignConsideration> list =new ArrayList<>();
			OutDesignConsideration odc = new OutDesignConsideration();
			for (Map<String, String> map : outDesignConsiderationsReocrd) {
				//只有主键为空的才新增
				BaseOutDesignConsideration b = new BaseOutDesignConsideration();
				int outDesignConsiderationId = BaseHelpUtils.getIntValue(map.get("outDesignConsiderationId"));
//				b.setOutDesignConsiderationId(BaseHelpUtils.getIntValue(map.get("outDesignConsiderationId"))); 
				b.setOutQuotationId(outQuotationId);
				b.setInfoCode(infoCode);// 信息编号
				b.setProjectCode(projectCode);// 项目编号
				b.setBusinessType(BaseHelpUtils.getIntValue(map.get("businessType")));// 业务类型
				b.setOutQuotationId(outQuotationId);// 报价单id
				b.setMainDesignAreaName(BaseHelpUtils.getString(map.get("mainDesignAreaName")));// 业务类型name
				b.setOutTempletId(outTempletId);//模板id
				b.setDesignArea(BaseHelpUtils.getBigDecimalValue(map.get("designArea")));
				b.setNewCreateQuotationName(newCreateQuotationName);
				b.setDesignUnitPrice(BaseHelpUtils.getBigDecimalValue(map.get("designUnitPrice")));
				b.setMoneySum(BaseHelpUtils.getBigDecimalValue(map.get("moneySum")).setScale(2));//总价 = 单价*面积
				b.setEmployeeId(employeeId);
//				b.setType(type);
//				list.add(b);
				if(outDesignConsiderationId>0) {
					b.setOutDesignConsiderationId(outDesignConsiderationId); 
					odc.setDataFromBase(b);
					odc.update();
				}else {
					odc.clear();
					odc.setDataFromBase(b);
					odc.save();
				}
			}
			
//			if(list.size()>0) {
//				OutDesignConsideration odc = new OutDesignConsideration();
//				odc.setConditionProjectCode("=", projectCode);
//				odc.setConditionOutQuotationId("=", outQuotationId);
//				odc.conditionalDelete();
//				
//				odc.clear();
//				odc.save(list);
//			}
		}
		return bc.toJSON(valRes,errorStr);
	}
	
	
	/**
	 * 
	 * @param result
	 * @return
	 * @throws Exception
	 */
	
	public static String saveMainProjectBusinessType(Map<String, Object> result) throws Exception{
		BaseCollection<BaseMainProjectBusinessType> bc = new BaseCollection<>();
		int valRes=-1;
		String errorStr="";
		
		int businessType = BaseHelpUtils.getIntValue(result.get("businessType"));
		if (businessType == 0) {
			return bc.toJSON(-1, "业务类别为空");
		}
		BigDecimal area = BaseHelpUtils.getBigDecimalValue(result.get("area")).setScale(2, BigDecimal.ROUND_HALF_UP);
		/*if (area.compareTo(BigDecimal.ZERO) == 0) {
			return bc.toJSON(-1, "面积为空或者为0");
		}*/
		ProductionValueCoefficient pvcDao = new ProductionValueCoefficient();
		pvcDao.setConditionProductionValueCoefficientTypeId("=", businessType);
		List<BaseProductionValueCoefficient> list = pvcDao
				.conditionalLoad("order by " + BaseProductionValueCoefficient.CS_PRODUCTION_MIN + " desc");
		if (null == list || list.isEmpty()) {
			return bc.toJSON(-1, "该业务类别没有设置系数");
		}
		int size = list.size();
		BigDecimal min = null;
		boolean calculateAll = false;// 是否不做判断，直接计算本区间的全额度
		BigDecimal outputValue = BigDecimal.ZERO;
		int lastOneIndex = size - 1;
		for (int i = 0; i < size; i++) {
			BaseProductionValueCoefficient obj = list.get(i);
			if (null == obj.getCoefficient()) {
				return bc.toJSON(-1, String.format("业务类别的区间额度【%1$s】没有设置系数", obj.getIntervalRange()));
			}
			min = obj.getProductionMin();
			if (min.compareTo(BigDecimal.ZERO) == 0 && i < lastOneIndex) {
				// 还不是最后一条记录，最小值就已经是0了，直接返回错误
				return bc.toJSON(-1, "该业务类别的系数设置有问题");
			}
			if (calculateAll) {
				outputValue = outputValue.add((obj.getIntervalLines().multiply(obj.getCoefficient())));
			} else {
				if (null == obj.getProductionMax()) {
					if (area.compareTo(min) <= 0) {
						continue;
					}
					calculateAll = true;
					outputValue = area.subtract(obj.getProductionMin()).multiply(obj.getCoefficient());
				} else {
					if (area.compareTo(obj.getProductionMax()) > 0) {
						return bc.toJSON(-1, String.format("面积超过本业务类别的最大值%1$s，无法计算出产值", obj.getProductionMax()));
					} else {
						if (area.compareTo(min) <= 0) {
							continue;
						}
						calculateAll = true;
						outputValue = area.subtract(obj.getProductionMin()).multiply(obj.getCoefficient());
					}
				}
			}
		}
		
		BigDecimal setScale = outputValue.multiply(new BigDecimal("10")).setScale(2, BigDecimal.ROUND_HALF_UP);
		BaseMainProjectBusinessType base = new BaseMainProjectBusinessType();
		base.setBusinessType(businessType);
		base.setArea(area);
		base.setOutputValue(setScale);
		//------------------计算产值完毕--------------
		
		int outQuotationId = BaseHelpUtils.getIntValue(result.get("outQuotationId"));
		String projectCode = BaseHelpUtils.getString(result.get("projectCode"));
		String infoCode = BaseHelpUtils.getString(result.get("infoCode"));
		MainProject mpDao = new MainProject();
		mpDao.setConditionProjectCode("=",projectCode );
		mpDao.setConditionInfoCode("=",  infoCode);
		BaseMainProject bean = mpDao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(bean)) {
			valRes=1;
			Integer mainProjectId = bean.getMainProjectId();	
			MainProjectBusinessType mbdao = new MainProjectBusinessType();
			
			PreProject pDao =new PreProject();
			pDao.setConditionInfoCode("=", infoCode);
			
			// 业务类别
			List<Map<String, String>> businessTypeList = (List<Map<String, String>>) result.get("businessTypeReocrd");
			if (!BaseHelpUtils.isNullOrEmpty(businessTypeList) && businessTypeList.size() > 0) {
				for (Map<String, String> btt : businessTypeList) {
					mbdao.clear();
					int mainProjectBusinessTypeId = BaseHelpUtils.getIntValue(btt.get("mainProjectBusinessTypeId"));
//					if(mainProjectBusinessTypeId>0) {
//						mbdao.setConditionMainProjectBusinessTypeId("=", mainProjectBusinessTypeId);
//						mbdao.setMainProjectBusinessTypeId(mainProjectBusinessTypeId);
//						if(mbdao.load()) {
//							BigDecimal oldArea = BaseHelpUtils.getBigDecimalValue(mbdao.getArea());
//							BigDecimal oldOutputValue = BaseHelpUtils.getBigDecimalValue(mbdao.getOutputValue());
//							
//							
//							if
//							
//							
//							
//							
//						}
//						
//						
//					}
					BaseMainProjectBusinessType b =new BaseMainProjectBusinessType();
					b.setMainProjectId(mainProjectId);
					b.setOutQuotationId(outQuotationId);
					b.setBusinessType(BaseHelpUtils.getIntValue(base.getBusinessType()));
					b.setArea(BaseHelpUtils.getBigDecimalValue(base.getArea()));
					b.setOutputValue(BaseHelpUtils.getBigDecimalValue(base.getOutputValue()));
					
					if(mainProjectBusinessTypeId>0) {
						b.setMainProjectBusinessTypeId(mainProjectBusinessTypeId);
						mbdao.setDataFromBase(b);
						mbdao.update();
					}else {
						mbdao.setDataFromBase(b);
						mbdao.save();
					}
					
					
				
				}
			}
			
			
			MainProjectBusinessType mpbtDao =new MainProjectBusinessType();
			mpbtDao.setConditionMainProjectId("=", mainProjectId);
			mpbtDao.setConditionOutQuotationId("=", outQuotationId);
			List<BaseMainProjectBusinessType> conditionalLoad = mpbtDao.conditionalLoad();
			if(conditionalLoad.size()>0) {
				if (!BaseHelpUtils.isNullOrEmpty(conditionalLoad) && conditionalLoad.size() > 0) {
					int businessTypeId = 0;
					String businessName = "";
					ProductionValueCoefficientType bdao =new ProductionValueCoefficientType();
					for (Map<String, String> bt : businessTypeList) {
						businessTypeId = BaseHelpUtils.getIntValue(bt.get("businessType"));
						bdao.clear();
						bdao.setProductionValueCoefficientTypeId(businessTypeId);
						if (bdao.load()) {
							if (BaseHelpUtils.isNullOrEmpty(businessName)) {
								businessName = bdao.getCoefficientType();
							} else {
								businessName = businessName + "," + bdao.getCoefficientType();
							}
						}
					}
					bean.setBusinessType(businessName);
					pDao.setBusinessType(businessName);
				}
				pDao.conditionalUpdate();
				
				mpDao.setDataFromBase(bean);
				mpDao.update();
			}
			

			
		}else {
			errorStr="查询项目编号("+projectCode+")不存在！";
		}
		return bc.toJSON(valRes,errorStr);
	}
	
	
	
	public static String updateMainProjectBusinessType(Map<String, Object> result) throws Exception {
		BaseCollection<BaseMainProjectBusinessType> bc = new BaseCollection<>();
		int valRes=-1;
		String errorStr="";
		
		int businessType = BaseHelpUtils.getIntValue(result.get("businessType"));
		if (businessType == 0) {
			return bc.toJSON(-1, "业务类别为空");
		}
		BigDecimal area = BaseHelpUtils.getBigDecimalValue(result.get("area")).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal setScale = BaseHelpUtils.getBigDecimalValue(result.get("outputValue")).setScale(2, BigDecimal.ROUND_HALF_UP);
		BaseMainProjectBusinessType base = new BaseMainProjectBusinessType();
		base.setBusinessType(businessType);
		base.setArea(area);
		base.setOutputValue(setScale);
		// ------------------计算产值完毕--------------

		int outQuotationId = BaseHelpUtils.getIntValue(result.get("outQuotationId"));
		String projectCode = BaseHelpUtils.getString(result.get("projectCode"));
		String infoCode = BaseHelpUtils.getString(result.get("infoCode"));
		MainProject mpDao = new MainProject();
		mpDao.setConditionProjectCode("=", projectCode);
		mpDao.setConditionInfoCode("=", infoCode);
		BaseMainProject bean = mpDao.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(bean)) {
			valRes = 1;
			Integer mainProjectId = bean.getMainProjectId();
			MainProjectBusinessType mbdao = new MainProjectBusinessType();

			PreProject pDao = new PreProject();
			pDao.setConditionInfoCode("=", infoCode);

			// 业务类别
			List<Map<String, String>> businessTypeList = (List<Map<String, String>>) result.get("businessTypeReocrd");
			if (!BaseHelpUtils.isNullOrEmpty(businessTypeList) && businessTypeList.size() > 0) {
				for (Map<String, String> btt : businessTypeList) {
					mbdao.clear();
					BaseMainProjectBusinessType b = new BaseMainProjectBusinessType();
					b.setMainProjectId(mainProjectId);
					b.setOutQuotationId(outQuotationId);
					b.setBusinessType(BaseHelpUtils.getIntValue(base.getBusinessType()));
					b.setArea(BaseHelpUtils.getBigDecimalValue(base.getArea()));
					b.setOutputValue(BaseHelpUtils.getBigDecimalValue(base.getOutputValue()));
					int mainProjectBusinessTypeId = BaseHelpUtils.getIntValue(btt.get("mainProjectBusinessTypeId"));
					if (mainProjectBusinessTypeId > 0) {
						b.setMainProjectBusinessTypeId(mainProjectBusinessTypeId);
						mbdao.setDataFromBase(b);
						mbdao.update();
					} else {
						mbdao.setDataFromBase(b);
						mbdao.save();
					}
				}
			}

			MainProjectBusinessType mpbtDao = new MainProjectBusinessType();
			mpbtDao.setConditionMainProjectId("=", mainProjectId);
			mpbtDao.setConditionOutQuotationId("=", outQuotationId);
			List<BaseMainProjectBusinessType> conditionalLoad = mpbtDao.conditionalLoad();
			if (conditionalLoad.size() > 0) {
				if (!BaseHelpUtils.isNullOrEmpty(conditionalLoad) && conditionalLoad.size() > 0) {
					int businessTypeId = 0;
					String businessName = "";
					ProductionValueCoefficientType bdao = new ProductionValueCoefficientType();
					for (Map<String, String> bt : businessTypeList) {
						businessTypeId = BaseHelpUtils.getIntValue(bt.get("businessType"));
						bdao.clear();
						bdao.setProductionValueCoefficientTypeId(businessTypeId);
						if (bdao.load()) {
							if (BaseHelpUtils.isNullOrEmpty(businessName)) {
								businessName = bdao.getCoefficientType();
							} else {
								businessName = businessName + "," + bdao.getCoefficientType();
							}
						}
					}
					bean.setBusinessType(businessName);
					pDao.setBusinessType(businessName);
				}
				pDao.conditionalUpdate();

				mpDao.setDataFromBase(bean);
				mpDao.update();
			}

		} else {
			errorStr = "查询项目编号(" + projectCode + ")不存在！";
		}
		return bc.toJSON(valRes, errorStr);

	}
	
	
	
	/**
	 * 
	 * @param result
	 * @return
	 * @throws Exception
	 */
	
	public static String getMainProjectBusinessType(Map<String, Object> result) throws Exception{
		BaseCollection<BaseMainProjectBusinessType> bc = new BaseCollection<>();
		int valRes=-1;
		String errorStr="";
		int outQuotationId = BaseHelpUtils.getIntValue(result.get("outQuotationId"));
		String projectCode = BaseHelpUtils.getString(result.get("projectCode"));
		String infoCode = BaseHelpUtils.getString(result.get("infoCode"));
		MainProject mpDao = new MainProject();
		mpDao.setConditionProjectCode("=",projectCode );
		mpDao.setConditionInfoCode("=",  infoCode);
		BaseMainProject bean = mpDao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(bean)) {
			valRes=1;
			Integer mainProjectId = bean.getMainProjectId();	
			MainProjectBusinessType mDao = new MainProjectBusinessType();
			mDao.setConditionMainProjectId("=", mainProjectId);
			mDao.setConditionOutQuotationId("=", outQuotationId);
			List<BaseMainProjectBusinessType> list = mDao.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()>0) {//修改页面  优先查询有outQuotationId的数据
				bc.setCollections(list);
			}else {//新增页面  否则查询outQuotationId=0的数据
				mDao.clear();
				mDao.setConditionMainProjectId("=", mainProjectId);
				mDao.setConditionOutQuotationId("=", 0);
				List<BaseMainProjectBusinessType> list2 = mDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(list2)&&list2.size()>0) {//修改页面
					bc.setCollections(list2);
				}
			}
		}else {
			errorStr="查询项目编号("+projectCode+")不存在！";
		}
		return bc.toJSON(valRes,errorStr);
	}
	
	
	/**
	 * 
	 * @param result
	 * @return
	 * @throws Exception
	 */
	
	public static String checkCFJData(Map<String, Object> result) throws Exception{
		int valRes=-1;
		String errorStr="";
		ConditionSumDesignconsideration c=new  ConditionSumDesignconsideration();
		QuerySumDesignconsideration dao = new QuerySumDesignconsideration();
		c.setDataFromMap(result);
		BaseCollection<BaseSumDesignconsideration> res = dao.executeQuery( c.getKeyValues(), c) ;
		List<BaseSumDesignconsideration> l=res.getCollections();
		
		System.out.println("===============================l="+l.size());
		
		if(l.size()>0){
			valRes=1;
			for(BaseSumDesignconsideration b:l){
				if(BaseHelpUtils.isNullOrEmpty(b)){
					valRes=-1;
					errorStr="没有拆分价";
					System.out.println(" 1 valRes="+valRes+" errorStr="+errorStr);
					break;
				}else{
					if(StaticMethod.getDouble2Value(BaseHelpUtils.getDoubleValue(b.getMoneySum()))!=
							StaticMethod.getDouble2Value(BaseHelpUtils.getDoubleValue(b.getInteriorMoneySum()))){
						valRes=-1;
						errorStr="内部，外部，拆分价的总金额不一致";
						System.out.println(" 2 valRes="+valRes+" errorStr="+errorStr);
						break;
					}
				}
			}
		}else{
			 valRes=-1;
			 errorStr="没有拆分价";
			 System.out.println(" 3 valRes="+valRes+" errorStr="+errorStr);
		}
		BaseCollection<BaseSumDesignconsideration> bc = new BaseCollection<>();
		return bc.toJSON(valRes,errorStr);
	}
	/**
	 * 检查报价单子的对内对外的报价金额一致
	 * @param result
	 * @return
	 * @throws Exception
	 */
	public static String checkInternalAndExternal(Map<String, Object> result) throws Exception{
		int valRes=-1;
		String errorStr="";
		QueryGroupOutdesignconsiderationior dao = new QueryGroupOutdesignconsiderationior();
		ConditionGroupOutdesignconsiderationior c=new ConditionGroupOutdesignconsiderationior();
		c.setDataFromMap(result);
		BaseCollection<BaseGroupOutdesignconsiderationior> res = dao.executeQuery( c.getKeyValues(), c);
		List<BaseGroupOutdesignconsiderationior> l=res.getCollections();
		if(l.size()>0){
			valRes=1;
//			for(BaseGroupOutdesignconsiderationior b:l){
//				if(StaticMethod.getDouble2Value(BaseHelpUtils.getDoubleValue(b.getMoneySum()))<
//						StaticMethod.getDouble2Value(BaseHelpUtils.getDoubleValue(b.getInteriorMoneySum()))){
//					valRes=-1;
//					errorStr="["+b.getNewCreateQuotationName()+"]产值单的总金额不能大于合同报价单";
//					break;
//				}
//				if(StaticMethod.getDouble2Value(BaseHelpUtils.getDoubleValue(b.getInteriorMoneySum()))>
//						StaticMethod.getDouble2Value(BaseHelpUtils.getDoubleValue(b.getFinalizedMoney()))){
//					valRes=-1;
//					errorStr="["+b.getNewCreateQuotationName()+"]产值单的总金额大于最终报价单";
//					break;
//				}
//			}
		}else{
			 valRes=-1;
			 errorStr="没有报价单";
		}
		BaseCollection<BaseGroupOutdesignconsiderationior> bc = new BaseCollection<>();
		return bc.toJSON(valRes,errorStr);
	}
	
	/**
	 * 
	 * @param result
	 * @return
	 * @throws Exception
	 */
	public static String checkOutDesignConsideration(Map<String, Object> result) throws Exception{
		String res="";
		int count=1;
		int outQuotationId=BaseHelpUtils.getIntValue(result, "outQuotationId");
		if(outQuotationId<=0) {
			throw new SQLException("报价单信息获取失败");
		}
		String infoCode=BaseHelpUtils.getStringValue(result, "infoCode");
		if(!BaseHelpUtils.isNullOrEmpty(infoCode)){
			infoCode=infoCode.trim();
		}else {
			throw new SQLException("信息编号获取失败");
		}
		String projectCode=BaseHelpUtils.getStringValue(result, "projectCode");
		if(!BaseHelpUtils.isNullOrEmpty(projectCode)){
			projectCode=projectCode.trim();
		}else {
			throw new SQLException("项目编号获取失败");
		}
		
		
		OutQuotation o=new OutQuotation();
		o.setConditionInfoCode("=", infoCode);
		o.setConditionProjectCode("=", projectCode);
		o.setConditionOutQuotationId("=", outQuotationId);
		o.setConditionQuotationStatus("=", 3);//正在报价中的报价单
		BaseOutQuotation baseOut=o.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(baseOut)){
			String newCreateQuotationName=BaseHelpUtils.getStringValue(result, "newCreateQuotationName").trim();
			OutDesignConsideration out=new OutDesignConsideration();
			out.setConditionNewCreateQuotationName("=", newCreateQuotationName);
			out.setConditionOutQuotationId("=", baseOut.getOutQuotationId());
			List<BaseOutDesignConsideration> l=out.conditionalLoad();
			if(l.size()>0){
				 count=-1;
				 res="该报价单标题存在，请换一个吧";
			}
		}
		BaseCollection<BaseMainProject> bc = new BaseCollection<>();
		return bc.toJSON(count,res);
	}
	/**
	 * 给项目信息标记是否有报价单
	 * @param result
	 * @return
	 * @throws Exception 
	 */
	public static String signQuotationStatus(Map<String, Object> result) throws Exception{
		int mainProjectId=BaseHelpUtils.getIntValue(result, "mainProjectId");
		MainProject mp=new MainProject();
		mp.setMainProjectId(mainProjectId);
		if(mp.load()){
			mp.setHasOutQuotations(true);
			mp.update();
		}
		BaseCollection<BaseMainProject> bc = new BaseCollection<>();
		return bc.toJSON(1,"");
	}
	/**
	 * @throws SQLException 
	 * 
	 * @Title: deleteOutConsiderationsByOqAndBt 
	 * @Description: 根据报价单ID和报价单类型删除报价单子项
	 * @param @param result
	 * @param @return    
	 * @return String   
	 * @throws
	 */
	public static String deleteOutConsiderationsByOqAndBt(Map<String, Object> result) throws SQLException{
		int status = 1;
		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		int outQuotationId = BaseHelpUtils.getIntValue(result, "outQuotationId");
		String newCreateQuotationName=BaseHelpUtils.getString(result.get("newCreateQuotationName")).trim();
        String infoCode=BaseHelpUtils.getString(result.get("infoCode")).trim();
        String projectCode=BaseHelpUtils.getString(result.get("projectCode")).trim();
		OutDesignConsideration outDao = new OutDesignConsideration();
		outDao.setConditionOutQuotationId("=", outQuotationId);
//		outDao.setConditionNewCreateQuotationName("=", newCreateQuotationName);
		outDao.conditionalDelete();
		
		MainProject m = new MainProject();
		m.setConditionProjectCode("=", projectCode);
		m.setConditionInfoCode("=", infoCode);
		BaseMainProject executeQueryOneRow = m.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
			MainProjectBusinessType mDao = new MainProjectBusinessType();
			mDao.setConditionMainProjectId("=", executeQueryOneRow.getMainProjectId());
			mDao.setConditionOutQuotationId("=",outQuotationId );
			mDao.conditionalDelete();
		}
		
		
		return bc.toJSON(status, "");
	}

	/**
	 * 检索报价单是否已经有该状态的报价单(排除当前的报价单)
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	public static String checkQuotationStatus(int outQuotationId,
			int status,String infoCode) throws SQLException {
		OutQuotation outQuotation = new OutQuotation();
		outQuotation.setConditionInfoCode("=", infoCode);
		outQuotation.setConditionOutQuotationId("!=", outQuotationId);
		outQuotation.setQuotationStatus(status);
		List<BaseOutQuotation> l = outQuotation.conditionalLoad();
		BaseOutQuotation baseOQ = new BaseOutQuotation();
		int number = l.size();String res = "";
		if (number > 0) {
			if(status==3){
				res="有报价单处于报价中...";
			}else if(status==1){
				res="已有成功报价单...";
			}
		}
		return res;
	}

	/**
	 * 
	 * @Title: moveOutDesignConsideration @Description: 移动报价单子项 @param @param
	 * result @param @return @param @throws SQLException @return String @throws
	 */
	private String moveOutDesignConsideration(Map<String, Object> result) throws SQLException {
		int res = 1;
		String move = BaseHelpUtils.getStringValue(result, "moveType");
		int outDesignConsiderationId = BaseHelpUtils.getIntValue(result, "outDesignConsiderationId");
		OutDesignConsideration dao = new OutDesignConsideration();
		dao.setOutDesignConsiderationId(outDesignConsiderationId);
		String errorMsg = "";
		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		if (dao.load()) {
			int fromNum = BaseHelpUtils.getIntValue(dao.getOrderNum());
			int bType = dao.getBusinessType();
			int outQuotationId = dao.getOutQuotationId();
			dao.clear();
			dao.setConditionBusinessType("=", bType);
			dao.setConditionOutQuotationId("=", outQuotationId);
			String descOrAsc = "";
			if (move.equals("up")) {
				dao.setConditionOrderNum("<", fromNum);
				descOrAsc = "DESC";
				errorMsg = "已经在最顶部了";
			}
			if (move.equals("down")) {
				dao.setConditionOrderNum(">", fromNum);
				descOrAsc = "ASC";
				errorMsg = "已经在最低部了";
			}
			BaseOutDesignConsideration bean = dao.executeQueryOneRow(" order by order_num " + descOrAsc);
			if (BaseHelpUtils.isNullOrEmpty(bean)) {
				res = -1;
			} else {
				int toNum = BaseHelpUtils.getIntValue(bean.getOrderNum());
				dao.clear();
				// 修改与当前选定数据相互交换位置的orderNum
				dao.setDataFromBase(bean);
				dao.setPrimaryKeyFromBase(bean);
				dao.setOrderNum(fromNum);
				dao.update();
				dao.clear();
				// 修改当前选定的orderNum
				dao.setOutDesignConsiderationId(outDesignConsiderationId);
				if (dao.load()) {
					dao.setOrderNum(toNum);
					dao.update();
				}
				bc.setCollections(getOutDesignConsiderationList(outQuotationId, dao.getBusinessType()));
			}
		} else {
			res = -1;
			errorMsg = "数据错误";
		}
		return bc.toJSON(res, errorMsg);
	}

	/**
	 * 加载模板的数据
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String getTemplateDataList(Map<String, Object> result) throws SQLException {
		int res = 0;
		// 模板类型
		int businessType = BaseHelpUtils.getIntValue(result, "businessType");
		OutTemplet ot = new OutTemplet();
		ot.setConditionBusinessType("=", businessType);
		List<BaseOutTemplet> resList = ot.conditionalLoad(" order by default_templet desc ");
		res++;
		BaseCollection<BaseOutTemplet> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(res, "");
	}
	private List<BaseOutDesignConsideration> getOutDesignConsiderationList(int outQuotationId, int businessType,
			int outTempletId,String newCreateQuotationName) throws SQLException {
		// 已录入的报价单 子项
				List<BaseOutDesignConsideration> outCxl = new ArrayList<>();
				OutDesignConsideration out = new OutDesignConsideration();
				out.setConditionOutQuotationId("=", outQuotationId);
				out.setConditionOutTempletId("=", outTempletId);
				out.setConditionNewCreateQuotationName("=", newCreateQuotationName);
				if(businessType > 0){
					out.setConditionBusinessType("=", businessType);
				}
				outCxl = out.conditionalLoad(" order by order_num ");

				// 已经录入的数据
				if (outCxl.size() > 0) {
					for (BaseOutDesignConsideration cx : outCxl) {

						// 单位换算为万元的字段
						double sumMoney = BaseHelpUtils.getDoubleValue(cx.getMoneySum());
						if (sumMoney > 0) {
							// 统计报价单
							double tempCount = sumMoney;
							cx.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
						}
						double interiorSumMoney = BaseHelpUtils.getDoubleValue(cx.getInteriorMoneySum());
						if (interiorSumMoney > 0) {
							double tempCount = interiorSumMoney;
							cx.setInteriorMoneySum(
									StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
						}
					}
				}
				return outCxl;
	}
	private List<BaseOutDesignConsideration> getOutDesignConsiderationList(int outQuotationId, int businessType) throws SQLException {
		// 已录入的报价单 子项
		List<BaseOutDesignConsideration> outCxl = new ArrayList<>();
		OutDesignConsideration out = new OutDesignConsideration();
		out.setConditionOutQuotationId("=", outQuotationId);
		if(businessType > 0){
			out.setConditionBusinessType("=", businessType);
		}
		outCxl = out.conditionalLoad(" order by order_num ");

		// 已经录入的数据
		if (outCxl.size() > 0) {
			for (BaseOutDesignConsideration cx : outCxl) {

				// 单位换算为万元的字段
				double sumMoney = BaseHelpUtils.getDoubleValue(cx.getMoneySum());
				if (sumMoney > 0) {
					// 统计报价单
					double tempCount = sumMoney;
					cx.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				}
				double interiorSumMoney = BaseHelpUtils.getDoubleValue(cx.getInteriorMoneySum());
				if (interiorSumMoney > 0) {
					double tempCount = interiorSumMoney;
					cx.setInteriorMoneySum(
							StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				}
			}
		}
		return outCxl;
	}

	/**
	 * 选择模板已经有需要加载的报价单数据
	 * 
	 * @param outTempletId
	 * @param outQuotationId
	 * @param infoCode
	 * @param projectCode
	 * @return
	 * @throws SQLException
	 */
	private String getPassBusinessTypeQueryData( int outQuotationId, String infoCode,
			String projectCode,String newCreateQuotationName) throws SQLException {
		// 报价单的数据统计
		StringBuilder tj = new StringBuilder();
		// 模板数据的封装
		LinkedHashMap<String, BaseOutDesignConsideration> outDC = new LinkedHashMap<>();
		// 已录入的报价单 子项
		List<BaseOutDesignConsideration> outCxl = new ArrayList<>();
		OutDesignConsideration out = new OutDesignConsideration();
		out.setConditionOutQuotationId("=", outQuotationId);
		outCxl = out.conditionalLoad(" order by order_num ");

		double aggregateAmount = 0,finalizedMoney=0;
		BigDecimal  outAggregateAmount = BigDecimal.ZERO;
		
		//报价单合同报价数据
		// 已经录入的数据
		if (outCxl.size() > 0) {
			for (BaseOutDesignConsideration cx : outCxl) {
				finalizedMoney=BaseHelpUtils.getDoubleValue(cx.getFinalizedMoney());//来记录该报价单的最终的报价
				// 单位换算为万元的字段
				double sumMoney = BaseHelpUtils.getDoubleValue(cx.getMoneySum());
				if (sumMoney > 0) {
					// 统计报价单
					double tempCount = sumMoney;
					aggregateAmount += (tempCount);
					cx.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				}
			}
		}
		//报价单产值数据
		MainProject mpDao = new MainProject();
		mpDao.setConditionProjectCode("=",projectCode);
		mpDao.setConditionInfoCode("=",  infoCode);
		BaseMainProject bean = mpDao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(bean)) {
			Integer mainProjectId = bean.getMainProjectId();	
			MainProjectBusinessType mDao = new MainProjectBusinessType();
			mDao.setConditionMainProjectId("=", mainProjectId);
			mDao.setConditionOutQuotationId("=", outQuotationId);
			List<BaseMainProjectBusinessType> list = mDao.conditionalLoad();
			if(list.size()>0) {
				for (BaseMainProjectBusinessType baseMainProjectBusinessType : list) {
					outAggregateAmount = outAggregateAmount.add(BaseHelpUtils.getBigDecimalValue(baseMainProjectBusinessType.getOutputValue()));
				}
			}
		}
		
		
		// 统计报价单
		BigDecimal aggregateAmounts=new BigDecimal(aggregateAmount); 
		BigDecimal outAggregateAmounts=outAggregateAmount; 
		
		DecimalFormat df=new DecimalFormat(",###,##0.00"); 
		tj.append("合同报价总金额=");
		tj.append(df.format(aggregateAmounts));
		tj.append("  产值总金额=");
		tj.append(df.format(outAggregateAmounts));
		
		tj.append("-");
		tj.append(df.format(outAggregateAmounts));
		tj.append("-");
	    tj.append(StaticMethod.getDouble4Value(finalizedMoney==0?0:finalizedMoney));
		
		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		bc.setCollections(outCxl);
		return bc.toJSON(-1, tj.toString());
	}
	
	

	/**
	 * 选择模板的数据添加到报价单子项中去
	 * 
	 * @param outTempletId
	 * @param outQuotationId
	 * @param infoCode
	 * @param projectCode
	 * @return
	 * @throws SQLException
	 */
	private String getBusinessTypeQueryData( int outQuotationId, String infoCode, String projectCode,
			int businessType, int employeeId,String newCreateQuotationName) throws SQLException {
		// 模板数据的封装
		LinkedHashMap<String, BaseOutDesignConsideration> outDC = new LinkedHashMap<>();

		// 模板项列表
//		StringBuilder opt = new StringBuilder();
//		OutTempletsLinkOutTempletOption gl = new OutTempletsLinkOutTempletOption();
//		gl.setConditionOutTempletId("=", outTempletId);
//		List<BaseOutTempletsLinkOutTempletOption> zxList = gl.conditionalLoad();
//		if (zxList.size() > 0) {
//			for (BaseOutTempletsLinkOutTempletOption b : zxList) {
//				if (BaseHelpUtils.isNullOrEmpty(opt)) {
//					opt.append(b.getOutTempletOptionId());
//				} else {
//					opt.append(",").append(b.getOutTempletOptionId());
//				}
//			}
//		}
//		// 对应模板的子项
//		List<BaseOutTempletOption> cxl = new ArrayList<>();
//		if (!BaseHelpUtils.isNullOrEmpty(opt)) {
//			OutTempletOption oto = new OutTempletOption();
//			cxl = oto.conditionalLoad(" out_templet_option_id in(" + opt + ") and option_type=2 ");
//		}
//
//		// 对应模板的专项
//		List<BaseOutTempletOption> zxl = new ArrayList<>();
//		if (!BaseHelpUtils.isNullOrEmpty(opt)) {
//			OutTempletOption oto = new OutTempletOption();
//			zxl = oto.conditionalLoad(" out_templet_option_id in(" + opt + ") and option_type=1 ");
//		}

		// 将数据合并封装到数据源
//		if (cxl.size() > 0) {
//			for (BaseOutTempletOption cx : cxl) {
//				// 将值设置到该对象中去
//				BaseOutDesignConsideration b = new BaseOutDesignConsideration();
//				b.setInfoCode(infoCode);// 信息编号
//				b.setProjectCode(projectCode);// 项目编号
//				b.setBusinessType(cx.getBusinessType());// 业务类型
//				b.setOutQuotationId(outQuotationId);// 报价单id
//				b.setOptionType(cx.getOptionType());// 子项--> 2
//				b.setMainDesignAreaName(cx.getOptionName());// 设计范围
//				b.setOutTempletId(outTempletId);//模板id
//				b.setNewCreateQuotationName(newCreateQuotationName);
//				b.setType(type);
//				outDC.put(cx.getOptionName(), b);
//			}
//		}
		
//		if (zxl.size() > 0) {
//			for (BaseOutTempletOption cx : zxl) {
//				// 将值设置到该对象中去
//				BaseOutDesignConsideration b = new BaseOutDesignConsideration();
//				b.setInfoCode(infoCode);// 信息编号
//				b.setProjectCode(projectCode);// 项目编号
//				b.setBusinessType(cx.getBusinessType());// 业务类型
//				b.setOutQuotationId(outQuotationId);// 报价单id
//				b.setOptionType(cx.getOptionType());// 专项--> 1
//				b.setMainDesignAreaName(cx.getOptionName());// 设计范围
//				b.setOutTempletId(outTempletId);//模板id
//				b.setNewCreateQuotationName(newCreateQuotationName);
//				b.setType(type);
//				outDC.put(cx.getOptionName(), b);
//			}
//		}

		// 将模板的数据保存下来
		if (!BaseHelpUtils.isNullOrEmpty(outDC)) {
			Iterator iter = outDC.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				BaseOutDesignConsideration val = (BaseOutDesignConsideration) entry.getValue();
				val.setEmployeeId(employeeId);
				OutDesignConsideration odc = new OutDesignConsideration();
				odc.setDataFromBase(val);
				odc.save();
				odc.setOrderNum(odc.getOutDesignConsiderationId());
				odc.update();
			}

		}

		return getPassBusinessTypeQueryData(outQuotationId, infoCode, projectCode,newCreateQuotationName);
	}

	/**
	 * 根据业务类型,报价单id 查询对应的报价单子项 1.先加载对应模板的数据 2.再加载对应的报价单子项 3.放入Map中,返回
	 * 
	 * @param result
	 * @param id
	 * @param moneySum
	 * @return
	 * @throws SQLException
	 */
	private String getBusinessTypeQueryData(Map<String, Object> result) throws SQLException {
		// 报价单id
		int outQuotationId = BaseHelpUtils.getIntValue(result, "outQuotationId");
		// 信息编号
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		// 项目编号
		String projectCode = BaseHelpUtils.getStringValue(result, "projectCode");
		// 操作人
		int employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		
		String newCreateQuotationName ="";

		// 该 业务类型 子订单项是否存在
		OutDesignConsideration o = new OutDesignConsideration();
		o.setConditionOutQuotationId("=", outQuotationId);
		return getPassBusinessTypeQueryData( outQuotationId, infoCode, projectCode,newCreateQuotationName);
	}

	/**
	 * 判断报价单能否删除
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String checkIsOutQuotation(Map<String, Object> result) throws SQLException {
		int outQuotationId = BaseHelpUtils.getIntValue(result, "outQuotationId");
		int status = 0;
		String msg = "";
		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		OutQuotation oDao = new OutQuotation();
		oDao.setOutQuotationId(outQuotationId);
		if (oDao.load()) {
			if (oDao.getDisableType() == 1) {
				status = -1;
				msg = "有报价单子项不能删除";
			}

		}
		return bc.toJSON(status, msg);
	}

	/**
	 * 检查报价单价子项的总金额大于报价单的总价
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String CheckSumMoney(Map<String, Object> result) throws SQLException {
		String infoCode, projectCode;
		infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		projectCode = BaseHelpUtils.getStringValue(result, "projectCode");
		int outQuotationId = BaseHelpUtils.getIntValue(result, "outQuotationId");
		int outDesignConsiderationId = BaseHelpUtils.getIntValue(result, "outDesignConsiderationId");
		// 报价单总价
		double sumMoney__ = BaseHelpUtils.getDoubleValue(result.get("sumMoney__"));
		// 当前追加的金额
		double nowMoney = BaseHelpUtils.getDoubleValue(result.get("nowMoney"));
		// 保存数据库中的拆分金额
		double checkNowMoney = CheckSumMoney(outQuotationId, outDesignConsiderationId, infoCode, projectCode);

		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		// 报价单子项金额大于报价单的总金额

		if (StaticMethod.getDouble2Value((nowMoney + checkNowMoney)) > StaticMethod.getDouble2Value(sumMoney__)) {
			return bc.toJSON(-1, "报价单价子项的总金额(" + StaticMethod.getDouble2Value((nowMoney + checkNowMoney)) + ")大于报价单的总价("
					+ StaticMethod.getDouble2Value(sumMoney__) + ")");
		} else {
			return bc.toJSON(1, "");
		}
	}

	/**
	 * 报价单的子项总计
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private double CheckSumMoney(int outQuotationId, int outDesignConsiderationId, String infoCode, String projectCode)
			throws SQLException {
		double tempSumMoney = 0.0;
		OutDesignConsideration desDao = new OutDesignConsideration();
		desDao.setConditionOutQuotationId("=", outQuotationId);
		desDao.setConditionInfoCode("=", infoCode);
		desDao.setConditionProjectCode("=", projectCode);
		List<BaseOutDesignConsideration> baseList = desDao.conditionalLoad();
		if (baseList.size() > 0) {
			for (BaseOutDesignConsideration b : baseList) {
				// 当前的总价数据不能统计
				if (b.getOutDesignConsiderationId() != outDesignConsiderationId) {
					double tempMoneySum = 0, tempWithTheAmount = 0, tempOnSiteTotalMoney = 0;
					if (!BaseHelpUtils.isNullOrEmpty(b.getMoneySum())) {
						tempMoneySum = b.getMoneySum().doubleValue();
					}
					if (!BaseHelpUtils.isNullOrEmpty(b.getWithTheAmount())) {
						tempWithTheAmount = b.getWithTheAmount().doubleValue();
					}
					if (!BaseHelpUtils.isNullOrEmpty(b.getOnSiteTotalMoney())) {
						tempOnSiteTotalMoney = b.getOnSiteTotalMoney().doubleValue();
					}
					tempSumMoney += (tempMoneySum + tempWithTheAmount + tempOnSiteTotalMoney);
				}
			}
		}
		return tempSumMoney;
	}

	/**
	 * 删除主报价单的子项
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String deleteOutDesignConsideration(Map<String, Object> result) throws SQLException {
		ThreadConnection.beginTransaction();
		int status = 0;
		String msg = "";
		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		int outQuotationId = BaseHelpUtils.getIntValue(result, "outQuotationId");
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		if (!BaseHelpUtils.isNullOrEmpty(ids)) {
			// 解析出ids
			String[] idArray = ids.split(",");
			ids = "";
			for (int i = 0; i < idArray.length; i++) {
				OutDesignConsideration outDao = new OutDesignConsideration();
				outDao.setOutDesignConsiderationId(BaseHelpUtils.getIntValue(idArray[i]));
				if (outDao.load()) {
					if (outDao.getDisableType() != 1) {// 能删除
						if (BaseHelpUtils.isNullOrEmpty(ids)) {
							ids = idArray[i];
						} else {
							ids += "," + idArray[i];
						}
					}
				}
			}

			OutDesignConsideration dao = new OutDesignConsideration();
			// 数据被应用了，不能删除
			if (BaseHelpUtils.isNullOrEmpty(ids)) {
				status = -1;
				msg = "数据被应用了，不能删除";
			} else {
				dao.delete(" out_design_consideration_id in(" + ids + ") ");
				status++;
				// 改变报价单是否可禁用的状态
				OutDesignConsideration out = new OutDesignConsideration();
				out.setConditionOutQuotationId("=", outQuotationId);
				List<BaseOutDesignConsideration> l = out.conditionalLoad();
				isUpdateOutQuotationsStatus(outQuotationId, l.size());

				// 删除了报价单子项要将协同项目改为有报价单状态
				if (l.size() <= 0) {
					MainProject mp = new MainProject();
					mp.setConditionInfoCode("=", infoCode);
					com.pomplatform.db.bean.BaseMainProject baseMp = mp.executeQueryOneRow();
					baseMp.setHasOutQuotations(false);
					mp.setDataFromBase(baseMp);
					mp.conditionalUpdate();
				}
			}
		}
		ThreadConnection.commit();
		return bc.toJSON(status, msg);
	}

	/**
	 * 将勾选的报价单转到(初步)拆分价表中去
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */

	private String addRedesigneConsiderationList(Map<String, Object> result) throws SQLException {

		int status = 0;
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		int outQuotationId = BaseHelpUtils.getIntValue(result, "outQuotationId");// 报价单id
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");// 信息编号
		String projectCode = BaseHelpUtils.getStringValue(result, "projectCode");// 项目编号
		double countMoney__ = BaseHelpUtils.getDoubleValue(result.get("moneySum"));// 报价单的总价
		BaseCollection<BaseOutRedesignConsideration> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(ids)) {
			OutDesignConsideration outDao = new OutDesignConsideration();
			List<BaseOutDesignConsideration> outList = outDao
					.conditionalLoad(" out_design_consideration_id in(" + ids + ") ");
			List<BaseOutRedesignConsideration> moveList = new ArrayList<>();
			if (outList.size() > 0) {

				// 效验报价单的总金额是否提过了
				OutRedesignConsideration d = new OutRedesignConsideration();
				d.setConditionOutQuotationId("=", outQuotationId);
				d.setConditionInfoCode("=", infoCode);
				d.setConditionProjectCode("=", projectCode);
				List<BaseOutRedesignConsideration> dList = d.conditionalLoad();
				double tempSumMoney = 0, nowMoney = 0;
				if (dList.size() > 0) {
					for (BaseOutRedesignConsideration b : dList) {
						double tempMoneySum = 0, tempWithTheAmount = 0, tempOnSiteTotalMoney = 0;
						if (!BaseHelpUtils.isNullOrEmpty(b.getMoneySum())) {
							tempMoneySum = b.getMoneySum().doubleValue();
						}
						if (!BaseHelpUtils.isNullOrEmpty(b.getWithTheAmount())) {
							tempWithTheAmount = b.getWithTheAmount().doubleValue();
						}
						if (!BaseHelpUtils.isNullOrEmpty(b.getOnSiteTotalMoney())) {
							tempOnSiteTotalMoney = b.getOnSiteTotalMoney().doubleValue();
						}
						tempSumMoney += (tempMoneySum + tempWithTheAmount + tempOnSiteTotalMoney);
					}
				}

				for (BaseOutDesignConsideration baseOut : outList) {
					BaseOutRedesignConsideration base = new BaseOutRedesignConsideration();
					base.setInfoCode(baseOut.getInfoCode());// 信息编号
					base.setProjectCode(baseOut.getProjectCode());// 项目编号
					base.setBusinessType(baseOut.getBusinessType());// 业务类型
					base.setProjectType(baseOut.getProjectType());// 项目类型
					base.setMainDesignAreaName(baseOut.getMainDesignAreaName());// 区域
																				// 设计范围
					base.setDecorationStatus(baseOut.getDecorationStatus());// 精简装状态
																			// 0精装
																			// 1简装
					base.setDesignArea(baseOut.getDesignArea());// 设计面积
					base.setDesignUnitPrice(baseOut.getDesignUnitPrice());// 设计单价
					base.setMoneySum(baseOut.getMoneySum());// 小计 设计面积总金额
					base.setJobMix(baseOut.getJobMix());// 现场配合
					base.setServiceArea(baseOut.getServiceArea());// 服务面积
					base.setOnSiteTime(baseOut.getOnSiteTime());// 驻场时间(月)
					base.setWithTheAmount(baseOut.getWithTheAmount());// 配合金额
					base.setOnSitePrice(baseOut.getOnSitePrice());// 驻场价格 (元/月)
					base.setOnSiteTotalMoney(baseOut.getOnSiteTotalMoney());// 驻场总金额
																			// (元)
					base.setOutQuotationId(baseOut.getOutQuotationId());
					moveList.add(base);

					double tempMoneySum = 0, tempWithTheAmount = 0, tempOnSiteTotalMoney = 0;
					if (!BaseHelpUtils.isNullOrEmpty(baseOut.getMoneySum())) {
						tempMoneySum = baseOut.getMoneySum().doubleValue();
					}
					if (!BaseHelpUtils.isNullOrEmpty(baseOut.getWithTheAmount())) {
						tempWithTheAmount = baseOut.getWithTheAmount().doubleValue();
					}
					if (!BaseHelpUtils.isNullOrEmpty(baseOut.getOnSiteTotalMoney())) {
						tempOnSiteTotalMoney = baseOut.getOnSiteTotalMoney().doubleValue();
					}
					nowMoney += (tempMoneySum + tempWithTheAmount + tempOnSiteTotalMoney);
				}
				// 效验判断start
				System.out.println("========================");
				System.out.println("拆分价的总金额(" + (nowMoney + tempSumMoney) + ")大于报价单的总价=" + countMoney__);
				// 报价单子项金额大于报价单的总金额
				if (StaticMethod.getDouble2Value((nowMoney + tempSumMoney)) > StaticMethod
						.getDouble2Value(countMoney__)) {
					return bc.toJSON(-1, "拆分价的总金额(" + StaticMethod.getDouble2Value((nowMoney + tempSumMoney))
							+ ")大于报价单的总价(" + StaticMethod.getDouble2Value(countMoney__) + ")");
				} else {
					OutRedesignConsideration desDao = new OutRedesignConsideration();
					desDao.save(moveList);
					status++;
					return bc.toJSON(status, "");
				}
			}
		}
		return bc.toJSON(-1, "没有选中要移动的数据");
	}

	/**
	 * 将勾选的(初步)拆分价转到(精细)拆分价表中去
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */

	private String addDesigneConsiderationList(Map<String, Object> result) throws SQLException {

		int status = 0;
		String ids = BaseHelpUtils.getStringValue(result, "ids");
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");// 信息编号
		String projectCode = BaseHelpUtils.getStringValue(result, "projectCode");// 项目编号
		int employeeId = BaseHelpUtils.getIntValue(result.get("employeeId"));// 操作人id
		double selfPrice=BaseHelpUtils.getDoubleValue(result.get("selfPrice"));
		BaseCollection<BaseDesignConsideration> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(ids)) {
			OutDesignConsideration outDao = new OutDesignConsideration();
			List<BaseOutDesignConsideration> outList = outDao
					.conditionalLoad(" out_design_consideration_id in(" + ids + ") ");
			List<BaseDesignConsideration> moveList = new ArrayList<>();
			if (outList.size() > 0) {

				for (BaseOutDesignConsideration baseOut : outList) {
					BaseDesignConsideration base = new BaseDesignConsideration();
					base.setInfoCode(baseOut.getInfoCode());// 信息编号
					base.setProjectCode(baseOut.getProjectCode());// 项目编号
					base.setBusinessType(baseOut.getBusinessType());// 业务类型
					base.setProjectType(baseOut.getProjectType());// 项目类型
					base.setMainDesignAreaName(baseOut.getMainDesignAreaName());// 区域
																				// 设计范围
					base.setDecorationStatus(baseOut.getDecorationStatus());// 精简装状态
																			// 0装饰
																			// 1简装
					base.setDesignArea(baseOut.getDesignArea());// 设计面积
					base.setDesignUnitPrice(baseOut.getDesignUnitPrice());// 设计单价
					base.setMoneySum(baseOut.getMoneySum());// 小计 设计面积总金额
					base.setJobMix(baseOut.getJobMix());// 现场配合
					base.setServiceArea(baseOut.getServiceArea());// 服务面积
					base.setOnSiteTime(baseOut.getOnSiteTime());// 驻场时间(月)
					base.setWithTheAmount(baseOut.getWithTheAmount());// 配合金额
					base.setOnSitePrice(baseOut.getOnSitePrice());// 驻场价格 (元/月)
					base.setOnSiteTotalMoney(baseOut.getOnSiteTotalMoney());// 驻场总金额
					base.setOutQuotationId(baseOut.getOutQuotationId());// 报价单id
					base.setInteriorPrice(baseOut.getInteriorPrice());
					base.setInteriorMoneySum(baseOut.getInteriorMoneySum());
					base.setRemark(baseOut.getRemark());
					base.setOptionType(baseOut.getOptionType());// 类型 1专项 2子项
					base.setEmployeeId(employeeId);// 操作人
					base.setSplitPrice(StaticMethod.formatComma4BigDecimal(selfPrice));
					base.setOutDesignConsiderationId(BaseHelpUtils.getIntValue(baseOut.getOutDesignConsiderationId()));
					DesignConsideration desDao = new DesignConsideration();
					desDao.setDataFromBase(base);
					desDao.save();
					desDao.setOrderNum(desDao.getDesignConsiderationId());
					desDao.update();
					// moveList.add(base);
				}
				// DesignConsideration desDao = new DesignConsideration();
				// desDao.save(moveList);
				status++;
				return bc.toJSON(status, "");
			}
		}
		return bc.toJSON(-1, "没有选中要移动的数据");
	}
	
	
	/**
	 * 根据主报价单信息获取报价单子项信息 (先根据infoCode 获取outQuotationId)
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String getCheckConsiderationsList(Map<String, Object> result) throws SQLException {
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		String projectCode = BaseHelpUtils.getStringValue(result, "projectCode");
		OutQuotation out=new OutQuotation();
		out.setConditionInfoCode("=", infoCode);
		out.setConditionQuotationStatus("=", 1);
		BaseOutQuotation baseOut =out.executeQueryOneRow();
		int outQuotationId = BaseHelpUtils.getIntValue(baseOut.getOutQuotationId());
		OutDesignConsideration outDao = new OutDesignConsideration();
		outDao.setConditionOutQuotationId("=", outQuotationId);
		outDao.setConditionInfoCode("=", infoCode);
//		outDao.setConditionProjectCode("=", projectCode);
		List<BaseOutDesignConsideration> ds = outDao
				.conditionalLoad(" order by business_type,out_design_consideration_id asc,option_type desc ");
		// 遍历
		double totalMoney = 0, outTotalMoney = 0;
		List<BaseOutDesignConsideration> resList = new ArrayList<>();
		for (BaseOutDesignConsideration d : ds) {
			d.setJobMix(1);
			// 单位换算为万元的字段
			double sumMoney = d.getMoneySum().doubleValue();
			if (sumMoney > 0) {
				// 统计报价单
				double tempCount = sumMoney;
				d.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				outTotalMoney += tempCount;
			}
			double interiorSumMoney = d.getInteriorMoneySum().doubleValue();
			if (interiorSumMoney > 0) {
				double tempCount = interiorSumMoney;
				d.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
				totalMoney += tempCount;
			}
			resList.add(d);
		}
		// 添加合计 (万元)
		BaseOutDesignConsideration bdc = new BaseOutDesignConsideration();
		// 标识正常的数据1，合计统计数据2和最终报价统计数据3
		bdc.setJobMix(2);
		bdc.setMainDesignAreaName("总计：");
		bdc.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(totalMoney));
		bdc.setMoneySum(StaticMethod.formatComma4BigDecimal(outTotalMoney));
		resList.add(bdc);

		BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
		bc.setCollections(resList);
		return bc.toJSON(-1, getCountMoney(outQuotationId));
	}

	/**
	 * 获取成功报价单的子项列表信息
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private String getConsiderationsList(Map<String, Object> result) throws SQLException {
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		OutQuotation oq=new OutQuotation();
		oq.setConditionInfoCode("=", infoCode);
		oq.setConditionQuotationStatus("=", 1);
		BaseOutQuotation baseOut=oq.executeQueryOneRow();
		List<BaseOutPriceListItem> resList = new ArrayList<>();
		BaseCollection<BaseOutPriceListItem> baseResult = null;
		if(!BaseHelpUtils.isNullOrEmpty(baseOut)){
			ConditionOutPriceListItem c=new ConditionOutPriceListItem();
			QueryOutPriceListItem dao = new QueryOutPriceListItem();
			dao.setCurrentPage(c.getCurrentPage());
			dao.setPageLines(c.getPageLines());
			
			c.setInfoCode(infoCode);
			c.setOutQuotationId(baseOut.getOutQuotationId());
			baseResult = dao.executeQuery( c.getKeyValues(), c) ;
			 
			List<BaseOutPriceListItem> ds=baseResult.getCollections();
			// 遍历
			double totalMoney = 0, outTotalMoney = 0;
			for (BaseOutPriceListItem d : ds) {
				
				d.setNewCreateQuotationName(BaseHelpUtils.getIntValue(d.getIsHas())>0?"已拆分":"");
				
				d.setJobMix(1);
				// 单位换算为万元的字段
				double sumMoney = d.getMoneySum().doubleValue();
				if (sumMoney > 0) {
					// 统计报价单
					double tempCount = sumMoney;
					d.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
					outTotalMoney += tempCount;
				}
				double interiorSumMoney = d.getInteriorMoneySum().doubleValue();
				if (interiorSumMoney > 0) {
					double tempCount = interiorSumMoney;
					d.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
					totalMoney += tempCount;
				}
				resList.add(d);
			}
			// 添加合计 (万元)
//			BaseOutPriceListItem bdc = new BaseOutPriceListItem();
//			// 标识正常的数据1，合计统计数据2和最终报价统计数据3
//			bdc.setJobMix(2);
//			bdc.setMainDesignAreaName("总计：");
//			bdc.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(totalMoney));
//			bdc.setMoneySum(StaticMethod.formatComma4BigDecimal(outTotalMoney));
//			resList.add(bdc);
			
			
			
			
			
//			List<BaseOutDesignConsideration> ds = outDao
//					.conditionalLoad(" out_quotation_id="+baseOut.getOutQuotationId()+" order by business_type,out_design_consideration_id asc,option_type desc ");
//			// 遍历
//			double totalMoney = 0, outTotalMoney = 0;
//			for (BaseOutDesignConsideration d : ds) {
//				d.setJobMix(1);
//				// 单位换算为万元的字段
//				double sumMoney = d.getMoneySum().doubleValue();
//				if (sumMoney > 0) {
//					// 统计报价单
//					double tempCount = sumMoney / 10000;
//					d.setMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
//					outTotalMoney += tempCount;
//				}
//				double interiorSumMoney = d.getInteriorMoneySum().doubleValue();
//				if (interiorSumMoney > 0) {
//					double tempCount = interiorSumMoney / 10000;
//					d.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(BaseHelpUtils.getDoubleValue(tempCount)));
//					totalMoney += tempCount;
//				}
//				resList.add(d);
//			}
//			// 添加合计 (万元)
//			BaseOutDesignConsideration bdc = new BaseOutDesignConsideration();
//			// 标识正常的数据1，合计统计数据2和最终报价统计数据3
//			bdc.setJobMix(2);
//			bdc.setMainDesignAreaName("总计：");
//			bdc.setInteriorMoneySum(StaticMethod.formatComma4BigDecimal(totalMoney));
//			bdc.setMoneySum(StaticMethod.formatComma4BigDecimal(outTotalMoney));
//			resList.add(bdc);
		}
		baseResult.setCollections(resList);
		return baseResult.toJSON(-1, getCountMoney(BaseHelpUtils.getIntValue(baseOut.getOutQuotationId())));
	}

	//
	public String getCountMoney(int id) throws SQLException {
		return getCountMoney(null, id);
	}

	/**
	 * 统计业务类别的金额
	 * 
	 * @param result
	 * @return
	 * @throws SQLException
	 */

	private String getCountMoney(Map<String, Object> result, int id) throws SQLException {
		StringBuilder resStr = new StringBuilder();
		// 报价单的id
		int outQuotationId = 0;
		if (id > 0) {
			outQuotationId = id;
		} else {
			outQuotationId = BaseHelpUtils.getIntValue(result, "outQuotationId");
		}
		Map<Integer, Double> resultMap = new HashMap<>();
		// 有多少个业务类型
		Map<Integer, Integer> typeMap = new HashMap<>();
		Map<Integer, BaseOutDesignConsideration> tempResultMap = new HashMap<>();
		// BaseOutDesignConsideration bc = new BaseOutDesignConsideration();
		if (outQuotationId > 0) {
			OutDesignConsideration outDao = new OutDesignConsideration();
			outDao.setConditionOutQuotationId("=", outQuotationId);
			List<BaseOutDesignConsideration> ds = outDao.conditionalLoad();
			// 计算每一行的金额总价
			if (ds.size() > 0) {
				for (BaseOutDesignConsideration baseOutDes : ds) {
					// 业务类型
					int businessType = BaseHelpUtils.getIntValue(baseOutDes.getBusinessType());
					// 设计面积*设计单价的金额
					double designMoney = BaseHelpUtils.getDoubleValue(baseOutDes.getMoneySum());
					// 配合金额
					double withAmountMoney = BaseHelpUtils.getDoubleValue(baseOutDes.getWithTheAmount());
					// 驻场金额
					double onSiteTotalMoney = BaseHelpUtils.getDoubleValue(baseOutDes.getOnSiteTotalMoney());
					// 统计金额
					double tempSunMoney = designMoney + withAmountMoney + onSiteTotalMoney;
					baseOutDes.setMoneySum(new java.math.BigDecimal(tempSunMoney));
					tempResultMap.put(baseOutDes.getOutDesignConsiderationId(), baseOutDes);
					typeMap.put(baseOutDes.getBusinessType(), baseOutDes.getBusinessType());
				}
			}

			// 各个业务类型总金额
			if (typeMap.size() > 0) {
				for (Entry<Integer, Integer> entry : typeMap.entrySet()) {
					double tempMoney = 0;
					if (tempResultMap.size() > 0) {
						for (Entry<Integer, BaseOutDesignConsideration> entry1 : tempResultMap.entrySet()) {
							BaseOutDesignConsideration b = entry1.getValue();
							if (b.getBusinessType() == entry.getKey()) {
								tempMoney += BaseHelpUtils
										.getDoubleValue((b.getMoneySum()).stripTrailingZeros().toPlainString());

							}
						}
					}
					resultMap.put(entry.getKey(), tempMoney);
				}
			}
			BigDecimal tempSum = BigDecimal.ZERO;
			// 遍历resultMap
			for (Map.Entry<Integer, Double> entry : resultMap.entrySet()) {
				BigDecimal value = BaseHelpUtils.format(entry.getValue(),2);
				tempSum = tempSum.add(value);
				//获取业务类别名称
				String tempValue = SelectValueCache.getSelectValue("production_value_coefficient_type",entry.getKey()+"");
				resStr.append(String.format("%1$s : %2$s", BaseHelpUtils.isNullOrEmpty(tempValue) ? "0" : tempValue,value));
			}
			resStr.append(String.format("合计 : %1$s-", tempSum));
			OutQuotation o = new OutQuotation();
			o.setOutQuotationId(outQuotationId);
			if (o.load()) {
				BigDecimal tempCount = BaseHelpUtils.getBigDecimalValue(o.getMoneySum());
				if (tempCount.compareTo(BigDecimal.ZERO) > 0) {
					resStr.append(BaseHelpUtils.format(tempCount,2));// 报价单的总价
				} else {
					resStr.append(BigDecimal.ZERO);// 报价单的总价
				}
			} else {
				resStr.append(BigDecimal.ZERO);// 报价单的总价
			}
		}
		return BaseHelpUtils.getString(resStr);
	}

	/**
	 * 查出所有业务类型系统值
	 * 
	 * @param key
	 * @return
	 * @throws SQLException
	 */
	public static String getSysYWTypeList(int key) throws SQLException {
		// 查出所有业务类型系统值
		SystemDictionary dao = new SystemDictionary();
		dao.setConditionDicTypeId("=", 51);
		dao.setConditionDicTypeValueId("=", key);
		StringBuilder sb = new StringBuilder("");
		List<BaseSystemDictionary> dList = dao.conditionalLoad(" order by dic_type_value_id");
		for (BaseSystemDictionary b : dList) {
			sb.append(b.getDicTypeValue());
		}
		return BaseHelpUtils.getString(sb);
	}

	/**
	 * 更新报价单的能不能删除的状态
	 * 
	 * @param outQuotationId
	 * @param num
	 *            报价单有没有报价单子项
	 * @return
	 * @throws SQLException
	 */
	private void isUpdateOutQuotationsStatus(int outQuotationId, int num) throws SQLException {

		System.out.println(num + "=isUpdateOutQuotationsStatus=" + outQuotationId);
		OutQuotation outDao = new OutQuotation();
		outDao.setOutQuotationId(outQuotationId);
		if (outDao.load()) {
			if (num > 0) {
				if (outDao.getDisableType() != 1) {
					outDao.setDisableType(1);
					outDao.update();
				}
			} else {
				outDao.setDisableType(0);
				outDao.update();
			}
		}
	}

	/**
	 * 产值的总金额和合同报价的总金额是否相同
	 * @param type
	 * @param infoCode
	 * @return
	 * @throws SQLException 
	 */
	private String checkPriceData(Map<String, Object> map) throws SQLException{
			BaseCollection<BaseOutDesignConsideration> bc = new BaseCollection<>();
			int outQuotationId=BaseHelpUtils.getIntValue(map,"outQuotationId");
			int businessType=BaseHelpUtils.getIntValue(map,"businessType");
			int outTempletId=BaseHelpUtils.getIntValue(map,"outTempletId");
			String newCreateQuotationName=BaseHelpUtils.getStringValue(map, "newCreateQuotationName");
			int type=BaseHelpUtils.getIntValue(map,"type");
			String errorStr="";int res=-1;
			OutDesignConsideration out=new OutDesignConsideration();
			out.setConditionOutQuotationId("=", outQuotationId);
			out.setConditionBusinessType("=", businessType);
			out.setConditionOutTempletId("=", outTempletId);
			out.setConditionNewCreateQuotationName("=",newCreateQuotationName);
			out.setConditionType("=", type);
			List<BaseOutDesignConsideration> l=out.conditionalLoad();
			BigDecimal lbSum = BigDecimal.ZERO;
			BigDecimal wbSum = BigDecimal.ZERO;
			BigDecimal finalizedMoney = BigDecimal.ZERO;
//			double lbSum=0.0,wbSum=0.0,finalizedMoney=0.0;
			if(l.size()>0){
				for(BaseOutDesignConsideration b:l){
					finalizedMoney = b.getFinalizedMoney();
					if(null != b.getMoneySum() && b.getMoneySum().compareTo(BigDecimal.ZERO) > 0){
						wbSum=wbSum.add(b.getMoneySum());
					}
					
					if(null != b.getInteriorMoneySum() && b.getInteriorMoneySum().compareTo(BigDecimal.ZERO) > 0){
						lbSum = lbSum.add(b.getInteriorMoneySum());
					}
				}
			}
			if(finalizedMoney.compareTo(lbSum) >= 0 && finalizedMoney.compareTo(wbSum) <= 0){
				res=1;
			}else{
				res=-1;
				errorStr="3种报价关系：合同报价的总金额>=最终报价的总金额不相同>=产值的总金额";
			}
			return bc.toJSON(res,errorStr);
	}
	/**
	 * 报价单子项信息保存或更新
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	private String saveOrUpdateOutDesignConsideration(String json) throws Exception {
		BaseOutDesignConsideration bean = new BaseOutDesignConsideration();
		bean.setDataFromJSON(json);
		
		OutDesignConsideration dao = new OutDesignConsideration();
		dao.setDataFromBase(bean);
		int num = 0;
		ThreadConnection.beginTransaction();
		if (dao.isPrimaryKeyNull()) {
			dao.setMoneySum(new BigDecimal(BaseHelpUtils.getDoubleValue(dao.getMoneySum())));
			dao.setInteriorMoneySum(new BigDecimal(BaseHelpUtils.getDoubleValue(dao.getInteriorMoneySum())));
			num = dao.save();
			dao.setOrderNum(dao.getOutDesignConsiderationId());
			dao.update();
			// 改变报价单是否可禁用的状态
			isUpdateOutQuotationsStatus(dao.getOutQuotationId(), 1);

		} else if (dao.load()) {
			dao.setDataFromBase(bean);
			dao.setMoneySum(new BigDecimal(BaseHelpUtils.getDoubleValue(dao.getMoneySum())));
			dao.setInteriorMoneySum(new BigDecimal(BaseHelpUtils.getDoubleValue(dao.getInteriorMoneySum())));
			num = dao.update();
		}
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String infoCode = BaseHelpUtils.getStringValue(result, "infoCode");
		int outTempletId=BaseHelpUtils.getIntValue(result,"outTempletId");
		String newCreateQuotationName=BaseHelpUtils.getStringValue(result, "newCreateQuotationName");
		String exportType=BaseHelpUtils.getStringValue(result, "exportType");
		int outQuotationId = 0 ;
		if("001".equals(exportType)){
			outQuotationId = BaseHelpUtils.getIntValue(result,"outQuotationId");
		}else{
			OutQuotation o=new OutQuotation();
			o.setConditionInfoCode("=", infoCode);
			o.setConditionQuotationStatus("=", 1);//成功的报价单
			BaseOutQuotation bout=o.executeQueryOneRow();
			outQuotationId = bout.getOutQuotationId();
		}
		if(outQuotationId > 0){
			int businessType = BaseHelpUtils.getIntValue(result, "businessType");
			List<BaseOutDesignConsideration> list=null;
			if("001".equals(exportType)){
				list=getOutDesignConsiderationList(outQuotationId, businessType,outTempletId,newCreateQuotationName);
			}else{
				list=getOutDesignConsiderationList(outQuotationId, businessType);
			}
			try(PrintStream ps = new PrintStream(downFile, "GBK")){
				ps.println(CustomBaseOutDesignConsideration.ALL_CAPTIONS);
				for (BaseOutDesignConsideration b : list) {
					CustomBaseOutDesignConsideration bb = new CustomBaseOutDesignConsideration();
					bb.getDataFromFather(b);
					ps.println(bb.toCSVString());
				}
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}
