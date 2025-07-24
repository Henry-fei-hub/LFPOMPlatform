package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadStandardQuoteData;
import pomplatform.project.bean.ConditionOnLoadStandardQuoteData;
import pomplatform.project.query.QueryOnLoadStandardQuoteData;
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

public class OnLoadStandardQuoteDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadStandardQuoteDataHandler.class);

	public static BaseCollection<BaseOnLoadStandardQuoteData> executeQueryOnLoadStandardQuoteData(ConditionOnLoadStandardQuoteData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadStandardQuoteData dao = new QueryOnLoadStandardQuoteData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadStandardQuoteData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadStandardQuoteData c = new ConditionOnLoadStandardQuoteData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadStandardQuoteData> result = executeQueryOnLoadStandardQuoteData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadStandardQuoteData> result;
		ConditionOnLoadStandardQuoteData c = new ConditionOnLoadStandardQuoteData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadStandardQuoteData dao = new QueryOnLoadStandardQuoteData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadStandardQuoteData.ALL_CAPTIONS);
			for(BaseOnLoadStandardQuoteData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


