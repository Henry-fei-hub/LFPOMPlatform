package pomplatform.ht.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import delicacy.common.GenericBase;
import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseDesignConsideration;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.DesignConsideration;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.account.bean.BaseOnLoadBenefitsData;
import pomplatform.account.bean.ConditionOnLoadBenefitsData;
import pomplatform.account.query.QueryOnLoadBenefitsData;
import pomplatform.hasOutQuotation.bean.BaseMHasOutQuotation;
import pomplatform.hasOutQuotation.bean.ConditionMHasOutQuotation;
import pomplatform.hasOutQuotation.handler.MHasOutQuotationHandler;
import pomplatform.ht.bean.*;
import pomplatform.ht.query.QueryInitiationProject;
import pomplatform.ht.query.QueryOnLoadCapitalAndContractPercent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @ClassName: CustomMainProjectHandler 
 * @Description:  报价单快捷按钮数据切换
 * @author CL
 * @date 2016年10月31日 
 *
 */
public class CustomMainProjectHandler extends MainProjectHandler {

	private static final Logger __logger = Logger.getLogger(CustomMainProjectHandler.class);

	public static BaseCollection<BaseMainProject> executeQueryMainProject(ConditionInitiationProject c, KeyValuePair[] replacements, String isBeforeAfter) throws Exception {
		BaseCollection<BaseMainProject> result = null;
//		if(BaseHelpUtils.isNullOrEmpty(isBeforeAfter)){
//			QueryMainProject dao = new QueryMainProject();
			QueryInitiationProject dao=new QueryInitiationProject();
			dao.setCurrentPage(c.getCurrentPage());
			dao.setPageLines(c.getPageLines());
			result = dao.executeQuery( c.getKeyValues(), c) ;
//		}else{
//			if("before".equals(isBeforeAfter)){
//				QueryBeforeMainProject dao = new QueryBeforeMainProject();
//				dao.setCurrentPage(c.getCurrentPage());
//				dao.setPageLines(c.getPageLines());
//				result = dao.executeQuery( c.getKeyValues(), c) ;
//			}else if("after".equals(isBeforeAfter)){
//				QueryAfterMainProject dao = new QueryAfterMainProject();
//				dao.setCurrentPage(c.getCurrentPage());
//				dao.setPageLines(c.getPageLines());
//				result = dao.executeQuery( c.getKeyValues(), c) ;
//			}else{
//				QueryInitiationProject dao=new QueryInitiationProject();
//				dao.setCurrentPage(c.getCurrentPage());
//				dao.setPageLines(c.getPageLines());
//				result = dao.executeQuery( c.getKeyValues(), c) ;
//			}
//		}
		
		return result;
	}

	
	/**
	 * 检查传进来的项目是否有 
	 * 报价单 
	 * @param
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static List<BaseMHasOutQuotation> getNewMainProject1() throws Exception {
		//有报价单项目
		List<BaseMHasOutQuotation> bList=new ArrayList<>();
		ConditionMHasOutQuotation c = new ConditionMHasOutQuotation();
		BaseCollection<BaseMHasOutQuotation> bl=MHasOutQuotationHandler.executeQueryMHasOutQuotation(c, c.getKeyValues());
		bList=bl.getCollections();
		return bList;
	}
	/**
	 * 检查传进来的项目是否有 
	 * 拆分价
	 * @return
	 * @throws SQLException 
	 */
	public static List<BaseDesignConsideration> getNewDesignConsideration() throws SQLException{
		DesignConsideration d=new DesignConsideration();
		List<BaseDesignConsideration> l=d.conditionalLoad();
		return l;
	}
	/**
	 * 检查传进来的项目是否有 
	 * 合同
	 * @return
	 * @throws SQLException
	 */
	public static List<BaseContract> getNewContract() throws SQLException{
		Contract d=new Contract();
		List<BaseContract> l=d.conditionalLoad();
		return l;
	}
	/**
	 * 完成订单下达的合同
	 * @return
	 * @throws SQLException
	 */
	public static List<BaseContract> getHasOrder()throws SQLException{
		Contract d=new Contract();
		d.setConditionFlowStatus("=", 4);//完成订单下达的合同
		List<BaseContract> l=d.conditionalLoad();
		return l;
	}
	/**
	 * 回款率
	 * @return
	 * @throws SQLException
	 */
	public static List<BaseOnLoadCapitalAndContractPercent>  getHasRateOfPayment() throws SQLException{
		QueryOnLoadCapitalAndContractPercent  query =new QueryOnLoadCapitalAndContractPercent();
		ConditionOnLoadCapitalAndContractPercent condition =new ConditionOnLoadCapitalAndContractPercent();
		BaseCollection<BaseOnLoadCapitalAndContractPercent> execute = query.execute(null, condition);
		List<BaseOnLoadCapitalAndContractPercent> collections  =new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
			collections = execute.getCollections();
		}
		return collections;
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BaseCollection<BaseMainProject> result;
		ConditionInitiationProject c = new ConditionInitiationProject();
		c.setDataFromJSON(creteria);
		QueryInitiationProject dao = new QueryInitiationProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMainProject.ALL_CAPTIONS);
			for(BaseMainProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}
	
	@Override
	public String find(String creteria) throws Exception {
		Map<String, Object> __result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			__result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String isBeforeAfter = null;
		if(null != __result.get("is_before_after")){
			isBeforeAfter = BaseHelpUtils.getStringValue(__result, "is_before_after");
		}
		ConditionInitiationProject c = new ConditionInitiationProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMainProject> result = executeQueryMainProject(c, c.getKeyValues(), isBeforeAfter);
		
		//当逆向项目没有 项目编号 进行该项目信息处理
		//数据处理前的list
		List<BaseMainProject> bList=result.getCollections();
		//定义处理后的list
		List<BaseMainProject> newList=new ArrayList<>();
		
		
		List<BaseMHasOutQuotation> quotationsList = null;
		quotationsList=getNewMainProject1();
//		List<BaseDesignConsideration> designConsiderationList=null;
//		designConsiderationList=getNewDesignConsideration();
		List<BaseContract> contractList=null;
		contractList=getNewContract();
		List<BaseContract> orderList=null;
		orderList=getHasOrder();
		List<BaseOnLoadCapitalAndContractPercent> hasRateOfPayment = null;
		hasRateOfPayment = getHasRateOfPayment();
		BigDecimal hundred = new BigDecimal(100);
		
		StringBuffer sb = new StringBuffer();
		for(BaseMainProject b:bList){
			//判断是否有报价单
			if(quotationsList.size()>0){
				for(BaseMHasOutQuotation oq:quotationsList){
					if(Objects.equals(b.getMainProjectId(), oq.getMainProjectId())){
						b.setHasOutQuotations(true);
						b.setHasOutQuotationTime(oq.getUpdateTime());
						break;
					}
				}
			}
			//判断是否有拆分价
//			if(designConsiderationList.size()>0){
//				for(BaseDesignConsideration bd:designConsiderationList){
//					if((b.getInfoCode()).equalsIgnoreCase(bd.getInfoCode())){
//						b.setHasSplitPrice(true);
//						b.setHasSplitPriceTime(bd.getCreateTime());
//						break;
//					}
//				}
//			}
			//判断是否有合同
			if(contractList.size()>0){
				for(BaseContract bc:contractList){
					if((b.getInfoCode()).equalsIgnoreCase(bc.getInfoCode())){
						b.setHasFormalContracts(true);
						b.setHasFormalContractTime(bc.getCreateTime());
						break;
					}
				}
			}
			//判断是否已经订单下达了
			if(orderList.size()>0){
				for(BaseContract bc:orderList){
					if((b.getProjectCode()).equalsIgnoreCase(bc.getProjectCode())){
						b.setHasOrderRelease(true);
						b.setHasOrderReleaseTime(bc.getUpdateTime());
						break;
					}
				}
			}
			//判断是否已经订单下达了
			if(hasRateOfPayment.size()>0){
				for (BaseOnLoadCapitalAndContractPercent bc : hasRateOfPayment) {
					if((b.getProjectCode()).equalsIgnoreCase(bc.getProjectCode())){
						if(!BaseHelpUtils.isNullOrEmpty(bc.getPercent())&&bc.getPercent().compareTo(BigDecimal.ZERO)>0) {
							b.setHasRateOfPayment(bc.getPercent());
							sb.append(b.getProjectCode());
							sb.append("=====");
							sb.append(b.getHasRateOfPayment());
							sb.append(",");
						}else {
							b.setHasRateOfPayment(BigDecimal.ZERO);
						}
						break;
					}
				}
			}
			newList.add(b);
		}
		result.setCollections(newList);
		
		System.out.println("======================================");
		System.out.println("===="+sb.toString());
		System.out.println("======================================");
		
		return result.toJSON(null);
	}


}


