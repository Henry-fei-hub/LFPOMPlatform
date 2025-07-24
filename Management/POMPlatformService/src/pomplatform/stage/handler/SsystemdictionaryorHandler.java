package pomplatform.stage.handler;

import org.apache.log4j.Logger;
import pomplatform.stage.bean.BaseSsystemdictionaryor;
import pomplatform.stage.bean.ConditionSsystemdictionaryor;
import pomplatform.stage.query.QuerySsystemdictionaryor;
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

public class SsystemdictionaryorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SsystemdictionaryorHandler.class);

	public static BaseCollection<BaseSsystemdictionaryor> executeQuerySsystemdictionaryor(ConditionSsystemdictionaryor c, KeyValuePair[] replacements ) throws Exception {
		QuerySsystemdictionaryor dao = new QuerySsystemdictionaryor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSsystemdictionaryor> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSsystemdictionaryor c = new ConditionSsystemdictionaryor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSsystemdictionaryor> result = executeQuerySsystemdictionaryor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSsystemdictionaryor> result;
		ConditionSsystemdictionaryor c = new ConditionSsystemdictionaryor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySsystemdictionaryor dao = new QuerySsystemdictionaryor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSsystemdictionaryor.ALL_CAPTIONS);
			for(BaseSsystemdictionaryor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


