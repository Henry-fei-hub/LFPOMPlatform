package pomplatform.exchangerate.handler;

import org.apache.log4j.Logger;
import pomplatform.exchangerate.bean.BaseExchangeRateList;
import pomplatform.exchangerate.bean.ConditionExchangeRateList;
import pomplatform.exchangerate.query.QueryExchangeRateList;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class ExchangeRateListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ExchangeRateListHandler.class);

	public static BaseCollection<BaseExchangeRateList> executeQueryExchangeRateList(ConditionExchangeRateList c, KeyValuePair[] replacements ) throws Exception {
		QueryExchangeRateList dao = new QueryExchangeRateList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseExchangeRateList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionExchangeRateList c = new ConditionExchangeRateList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseExchangeRateList> result = executeQueryExchangeRateList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseExchangeRateList> result;
		ConditionExchangeRateList c = new ConditionExchangeRateList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryExchangeRateList dao = new QueryExchangeRateList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseExchangeRateList.ALL_CAPTIONS);
			for(BaseExchangeRateList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


