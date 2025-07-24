package pomplatform.mcapitalcmmssmssbor.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.mcapitalcmmssmssbor.bean.BaseScapitalssmor;
import pomplatform.mcapitalcmmssmssbor.bean.ConditionScapitalssmor;
import pomplatform.mcapitalcmmssmssbor.query.QueryScapitalssmor;

public class ScapitalssmorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScapitalssmorHandler.class);

	public static BaseCollection<BaseScapitalssmor> executeQueryScapitalssmor(ConditionScapitalssmor c, KeyValuePair[] replacements ) throws Exception {
		QueryScapitalssmor dao = new QueryScapitalssmor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScapitalssmor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String find(String creteria) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		ConditionScapitalssmor c = new ConditionScapitalssmor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScapitalssmor> result = executeQueryScapitalssmor(c, c.getKeyValues());
		if(null != params.get("balance")){
			BigDecimal balance = new BigDecimal(params.get("balance").toString());
			for (BaseScapitalssmor baseScapitalssmor : result.getCollections()) {
				if(baseScapitalssmor.getCapitalType() == 1 ){
					if(null != baseScapitalssmor.getOriginalCurrency()){
						balance = balance.add(baseScapitalssmor.getOriginalCurrency());
					}
				} else {
					if(null != baseScapitalssmor.getLoanMoney()){
						balance = balance.subtract(baseScapitalssmor.getLoanMoney());
					}
				}
				baseScapitalssmor.setBalance(balance);
			}
		}
		return result.toJSON(null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		BaseCollection<BaseScapitalssmor> result;
		ConditionScapitalssmor c = new ConditionScapitalssmor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScapitalssmor dao = new QueryScapitalssmor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(null != params.get("balance")){
			BigDecimal balance = new BigDecimal(params.get("balance").toString());
			for (BaseScapitalssmor baseScapitalssmor : result.getCollections()) {
				if(baseScapitalssmor.getCapitalType() == 1 ){
					if(null != baseScapitalssmor.getOriginalCurrency()){
						balance = balance.add(baseScapitalssmor.getOriginalCurrency());
					}
				} else {
					if(null != baseScapitalssmor.getLoanMoney()){
						balance = balance.subtract(baseScapitalssmor.getLoanMoney());
					}
				}
				baseScapitalssmor.setBalance(balance);
			}
		}
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScapitalssmor.ALL_CAPTIONS);
			for(BaseScapitalssmor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


