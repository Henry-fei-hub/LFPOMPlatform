package pomplatform.sinvoiceitior.handler;

import org.apache.log4j.Logger;
import pomplatform.sinvoiceitior.bean.BaseSinvoiceorusecount;
import pomplatform.sinvoiceitior.bean.ConditionSinvoiceorusecount;
import pomplatform.sinvoiceitior.query.QuerySinvoiceorusecount;
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

public class SinvoiceorusecountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SinvoiceorusecountHandler.class);

	public static BaseCollection<BaseSinvoiceorusecount> executeQuerySinvoiceorusecount(ConditionSinvoiceorusecount c, KeyValuePair[] replacements ) throws Exception {
		QuerySinvoiceorusecount dao = new QuerySinvoiceorusecount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSinvoiceorusecount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSinvoiceorusecount c = new ConditionSinvoiceorusecount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSinvoiceorusecount> result = executeQuerySinvoiceorusecount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSinvoiceorusecount> result;
		ConditionSinvoiceorusecount c = new ConditionSinvoiceorusecount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySinvoiceorusecount dao = new QuerySinvoiceorusecount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSinvoiceorusecount.ALL_CAPTIONS);
			for(BaseSinvoiceorusecount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


