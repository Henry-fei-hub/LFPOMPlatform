package pomplatform.annoucement.handler;

import org.apache.log4j.Logger;
import pomplatform.annoucement.bean.BaseSannoucementaaaor;
import pomplatform.annoucement.bean.ConditionSannoucementaaaor;
import pomplatform.annoucement.query.QuerySannoucementaaaor;
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

public class SannoucementaaaorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SannoucementaaaorHandler.class);

	public static BaseCollection<BaseSannoucementaaaor> executeQuerySannoucementaaaor(ConditionSannoucementaaaor c, KeyValuePair[] replacements ) throws Exception {
		QuerySannoucementaaaor dao = new QuerySannoucementaaaor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSannoucementaaaor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSannoucementaaaor c = new ConditionSannoucementaaaor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSannoucementaaaor> result = executeQuerySannoucementaaaor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSannoucementaaaor> result;
		ConditionSannoucementaaaor c = new ConditionSannoucementaaaor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySannoucementaaaor dao = new QuerySannoucementaaaor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSannoucementaaaor.ALL_CAPTIONS);
			for(BaseSannoucementaaaor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


