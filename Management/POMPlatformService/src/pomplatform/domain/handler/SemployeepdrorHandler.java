package pomplatform.domain.handler;

import org.apache.log4j.Logger;
import pomplatform.domain.bean.BaseSemployeepdror;
import pomplatform.domain.bean.ConditionSemployeepdror;
import pomplatform.domain.query.QuerySemployeepdror;
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

public class SemployeepdrorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SemployeepdrorHandler.class);

	public static BaseCollection<BaseSemployeepdror> executeQuerySemployeepdror(ConditionSemployeepdror c, KeyValuePair[] replacements ) throws Exception {
		QuerySemployeepdror dao = new QuerySemployeepdror();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSemployeepdror> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSemployeepdror c = new ConditionSemployeepdror();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSemployeepdror> result = executeQuerySemployeepdror(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSemployeepdror> result;
		ConditionSemployeepdror c = new ConditionSemployeepdror();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySemployeepdror dao = new QuerySemployeepdror();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSemployeepdror.ALL_CAPTIONS);
			for(BaseSemployeepdror b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


