package pomplatform.ht.handler;

import org.apache.log4j.Logger;
import pomplatform.ht.bean.BaseSsubcontractor;
import pomplatform.ht.bean.ConditionSsubcontractor;
import pomplatform.ht.query.QuerySsubcontractor;
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

public class SsubcontractorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SsubcontractorHandler.class);

	public static BaseCollection<BaseSsubcontractor> executeQuerySsubcontractor(ConditionSsubcontractor c, KeyValuePair[] replacements ) throws Exception {
		QuerySsubcontractor dao = new QuerySsubcontractor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSsubcontractor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSsubcontractor c = new ConditionSsubcontractor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSsubcontractor> result = executeQuerySsubcontractor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSsubcontractor> result;
		ConditionSsubcontractor c = new ConditionSsubcontractor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySsubcontractor dao = new QuerySsubcontractor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSsubcontractor.ALL_CAPTIONS);
			for(BaseSsubcontractor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


