package pomplatform.persional.handler;

import org.apache.log4j.Logger;
import pomplatform.persional.bean.BaseSemployeeeor;
import pomplatform.persional.bean.ConditionSemployeeeor;
import pomplatform.persional.query.QuerySemployeeeor;
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

public class SemployeeeorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SemployeeeorHandler.class);

	public static BaseCollection<BaseSemployeeeor> executeQuerySemployeeeor(ConditionSemployeeeor c, KeyValuePair[] replacements ) throws Exception {
		QuerySemployeeeor dao = new QuerySemployeeeor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSemployeeeor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSemployeeeor c = new ConditionSemployeeeor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSemployeeeor> result = executeQuerySemployeeeor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSemployeeeor> result;
		ConditionSemployeeeor c = new ConditionSemployeeeor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySemployeeeor dao = new QuerySemployeeeor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSemployeeeor.ALL_CAPTIONS);
			for(BaseSemployeeeor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


