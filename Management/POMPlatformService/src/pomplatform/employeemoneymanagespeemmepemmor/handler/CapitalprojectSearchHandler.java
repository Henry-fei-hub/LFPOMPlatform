package pomplatform.employeemoneymanagespeemmepemmor.handler;

import org.apache.log4j.Logger;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseCapitalprojectSearch;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionCapitalprojectSearch;
import pomplatform.employeemoneymanagespeemmepemmor.query.QueryCapitalprojectSearch;
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

public class CapitalprojectSearchHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalprojectSearchHandler.class);

	public static BaseCollection<BaseCapitalprojectSearch> executeQueryCapitalprojectSearch(ConditionCapitalprojectSearch c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalprojectSearch dao = new QueryCapitalprojectSearch();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalprojectSearch> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalprojectSearch c = new ConditionCapitalprojectSearch();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalprojectSearch> result = executeQueryCapitalprojectSearch(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalprojectSearch> result;
		ConditionCapitalprojectSearch c = new ConditionCapitalprojectSearch();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalprojectSearch dao = new QueryCapitalprojectSearch();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalprojectSearch.ALL_CAPTIONS);
			for(BaseCapitalprojectSearch b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


