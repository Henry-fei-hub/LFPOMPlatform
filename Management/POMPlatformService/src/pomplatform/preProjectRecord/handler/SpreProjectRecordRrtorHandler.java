package pomplatform.preProjectRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjectRecord.bean.BaseSpreProjectRecordRrtor;
import pomplatform.preProjectRecord.bean.ConditionSpreProjectRecordRrtor;
import pomplatform.preProjectRecord.query.QuerySpreProjectRecordRrtor;
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

public class SpreProjectRecordRrtorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SpreProjectRecordRrtorHandler.class);

	public static BaseCollection<BaseSpreProjectRecordRrtor> executeQuerySpreProjectRecordRrtor(ConditionSpreProjectRecordRrtor c, KeyValuePair[] replacements ) throws Exception {
		QuerySpreProjectRecordRrtor dao = new QuerySpreProjectRecordRrtor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSpreProjectRecordRrtor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSpreProjectRecordRrtor c = new ConditionSpreProjectRecordRrtor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSpreProjectRecordRrtor> result = executeQuerySpreProjectRecordRrtor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSpreProjectRecordRrtor> result;
		ConditionSpreProjectRecordRrtor c = new ConditionSpreProjectRecordRrtor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySpreProjectRecordRrtor dao = new QuerySpreProjectRecordRrtor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSpreProjectRecordRrtor.ALL_CAPTIONS);
			for(BaseSpreProjectRecordRrtor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


