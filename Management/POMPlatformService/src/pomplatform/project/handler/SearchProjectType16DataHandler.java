package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseSearchProjectType16Data;
import pomplatform.project.bean.ConditionSearchProjectType16Data;
import pomplatform.project.query.QuerySearchProjectType16Data;
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

public class SearchProjectType16DataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SearchProjectType16DataHandler.class);

	public static BaseCollection<BaseSearchProjectType16Data> executeQuerySearchProjectType16Data(ConditionSearchProjectType16Data c, KeyValuePair[] replacements ) throws Exception {
		QuerySearchProjectType16Data dao = new QuerySearchProjectType16Data();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSearchProjectType16Data> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSearchProjectType16Data c = new ConditionSearchProjectType16Data();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSearchProjectType16Data> result = executeQuerySearchProjectType16Data(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSearchProjectType16Data> result;
		ConditionSearchProjectType16Data c = new ConditionSearchProjectType16Data();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySearchProjectType16Data dao = new QuerySearchProjectType16Data();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSearchProjectType16Data.ALL_CAPTIONS);
			for(BaseSearchProjectType16Data b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


