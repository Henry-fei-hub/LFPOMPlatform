package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseStracktalentsminimumarrangementmmpor;
import pomplatform.project.bean.ConditionStracktalentsminimumarrangementmmpor;
import pomplatform.project.query.QueryStracktalentsminimumarrangementmmpor;
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

public class StracktalentsminimumarrangementmmporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(StracktalentsminimumarrangementmmporHandler.class);

	public static BaseCollection<BaseStracktalentsminimumarrangementmmpor> executeQueryStracktalentsminimumarrangementmmpor(ConditionStracktalentsminimumarrangementmmpor c, KeyValuePair[] replacements ) throws Exception {
		QueryStracktalentsminimumarrangementmmpor dao = new QueryStracktalentsminimumarrangementmmpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseStracktalentsminimumarrangementmmpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionStracktalentsminimumarrangementmmpor c = new ConditionStracktalentsminimumarrangementmmpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseStracktalentsminimumarrangementmmpor> result = executeQueryStracktalentsminimumarrangementmmpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseStracktalentsminimumarrangementmmpor> result;
		ConditionStracktalentsminimumarrangementmmpor c = new ConditionStracktalentsminimumarrangementmmpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryStracktalentsminimumarrangementmmpor dao = new QueryStracktalentsminimumarrangementmmpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseStracktalentsminimumarrangementmmpor.ALL_CAPTIONS);
			for(BaseStracktalentsminimumarrangementmmpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


