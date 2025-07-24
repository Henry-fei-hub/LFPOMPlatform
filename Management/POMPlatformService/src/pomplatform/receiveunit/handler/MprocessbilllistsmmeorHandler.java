package pomplatform.receiveunit.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.receiveunit.bean.BaseMprocessbilllistsmmeor;
import pomplatform.receiveunit.bean.ConditionMprocessbilllistsmmeor;
import pomplatform.receiveunit.query.QueryExcludeMprocessbilllistsmmeor;
import pomplatform.receiveunit.query.QueryMprocessbilllistsmmeor;

public class MprocessbilllistsmmeorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprocessbilllistsmmeorHandler.class);

	public static BaseCollection<BaseMprocessbilllistsmmeor> executeQueryMprocessbilllistsmmeor(ConditionMprocessbilllistsmmeor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprocessbilllistsmmeor dao = new QueryMprocessbilllistsmmeor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprocessbilllistsmmeor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}
	
	public static BaseCollection<BaseMprocessbilllistsmmeor> executeQueryExcludeMprocessbilllistsmmeor(ConditionMprocessbilllistsmmeor c, KeyValuePair[] replacements ) throws Exception {
		QueryExcludeMprocessbilllistsmmeor dao = new QueryExcludeMprocessbilllistsmmeor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprocessbilllistsmmeor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String find(String creteria) throws Exception {
		ConditionMprocessbilllistsmmeor c = new ConditionMprocessbilllistsmmeor();
		c.setDataFromJSON(creteria);
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		int searchType = BaseHelpUtils.getIntValue(params, "searchType");
		BaseCollection<BaseMprocessbilllistsmmeor> result = null;
		if(searchType == 2) {//排除 冲账大于等于付款的数据
			result = executeQueryExcludeMprocessbilllistsmmeor(c, c.getKeyValues());
		} else {
			result = executeQueryMprocessbilllistsmmeor(c, c.getKeyValues());
		}
		result.setCollections(returnFinalData(result.getCollections()));
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprocessbilllistsmmeor> result;
		ConditionMprocessbilllistsmmeor c = new ConditionMprocessbilllistsmmeor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		int searchType = BaseHelpUtils.getIntValue(params, "searchType");
		if(searchType == 2) { //排除 冲账大于等于付款的数据
			QueryExcludeMprocessbilllistsmmeor dao = new QueryExcludeMprocessbilllistsmmeor();
			dao.setCurrentPage(1);
			dao.setPageLines(1);
			result = dao.executeQuery( c.getKeyValues(), c) ;
			if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
				throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
			}
			dao.setCurrentPage(0);
			result = dao.executeQuery( c.getKeyValues(), c) ;
			result.setCollections(returnFinalData(result.getCollections()));
			
			try(PrintStream ps = new PrintStream(downFile, "GBK")){
				ps.println(BaseMprocessbilllistsmmeor.ALL_CAPTIONS);
				for(BaseMprocessbilllistsmmeor b : result.getCollections()){
					ps.println(b.toCSVString());
				}
			}
		}else {
			QueryMprocessbilllistsmmeor dao = new QueryMprocessbilllistsmmeor();
			dao.setCurrentPage(1);
			dao.setPageLines(1);
			result = dao.executeQuery( c.getKeyValues(), c) ;
			if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
				throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
			}
			dao.setCurrentPage(0);
			result = dao.executeQuery( c.getKeyValues(), c) ;
			result.setCollections(returnFinalData(result.getCollections()));
			
			try(PrintStream ps = new PrintStream(downFile, "GBK")){
				ps.println(BaseMprocessbilllistsmmeor.ALL_CAPTIONS);
				for(BaseMprocessbilllistsmmeor b : result.getCollections()){
					ps.println(b.toCSVString());
				}
			}
		}
		
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
	
	private List<BaseMprocessbilllistsmmeor> returnFinalData(List<BaseMprocessbilllistsmmeor> params){
		List<BaseMprocessbilllistsmmeor> list = new ArrayList<>();
		for (BaseMprocessbilllistsmmeor tmpBean : params) {
			if(null == tmpBean.getProcessBillListId() && null == tmpBean.getProcessType()){//期初
				tmpBean.setRemark("期初");
				list.add(tmpBean);
			}else{
				if(tmpBean.getProcessType() == 7 || tmpBean.getProcessType() == 6 ){//预付
					tmpBean.setRemark("预付款");
					list.add(tmpBean);
				}else if(tmpBean.getProcessType() == 41){
					tmpBean.setRemark("外部公司还款");
					list.add(tmpBean);
				}else{
					if(null != tmpBean.getPayMoney() || null != tmpBean.getBalanceAmount()){
						if(null != tmpBean.getPayMoney() && tmpBean.getPayMoney().compareTo(BigDecimal.ZERO) > 0
								&& null != tmpBean.getBalanceAmount() && tmpBean.getBalanceAmount().compareTo(BigDecimal.ZERO) > 0){//部分冲账
							tmpBean.setRemark("部分冲账");
							BaseMprocessbilllistsmmeor tmpBean1 = new BaseMprocessbilllistsmmeor();
							BaseMprocessbilllistsmmeor tmpBean2 = new BaseMprocessbilllistsmmeor();
							tmpBean.cloneCopy(tmpBean1);
							tmpBean.cloneCopy(tmpBean2);
							tmpBean1.setBalanceAmount(tmpBean.getPayMoney().add(tmpBean.getBalanceAmount()));
							tmpBean1.setPayMoney(null);
							tmpBean2.setBalanceAmount(null);
							list.add(tmpBean1);
							list.add(tmpBean2);
						}else if((null == tmpBean.getPayMoney() || tmpBean.getPayMoney().compareTo(BigDecimal.ZERO) == 0)
								&& tmpBean.getBalanceAmount().compareTo(BigDecimal.ZERO) > 0){//全额冲账
							tmpBean.setRemark("全额冲账");
							list.add(tmpBean);
						}else{//全额付款
							tmpBean.setRemark("全额付款");
							BaseMprocessbilllistsmmeor tmpBean1 = new BaseMprocessbilllistsmmeor();
							BaseMprocessbilllistsmmeor tmpBean2 = new BaseMprocessbilllistsmmeor();
							tmpBean.cloneCopy(tmpBean1);
							tmpBean.cloneCopy(tmpBean2);
							tmpBean1.setBalanceAmount(tmpBean.getPayMoney());
							tmpBean1.setPayMoney(null);
							tmpBean2.setPayMoney(tmpBean.getPayMoney());
							tmpBean2.setBalanceAmount(null);
							list.add(tmpBean1);
							list.add(tmpBean2);
						}
						
					}
				}
			}
		}
		BigDecimal initAmount = BigDecimal.ZERO;
		for (BaseMprocessbilllistsmmeor baseMprocessbilllistsmmeor : list) {
			if(null != baseMprocessbilllistsmmeor.getPayMoney()){
				initAmount = initAmount.add(baseMprocessbilllistsmmeor.getPayMoney());
			}
			if(null != baseMprocessbilllistsmmeor.getBalanceAmount()){
				initAmount = initAmount.subtract(baseMprocessbilllistsmmeor.getBalanceAmount());
			}
			baseMprocessbilllistsmmeor.setInitAmount(initAmount);
		}
		return list;
	}
}


