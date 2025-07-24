package pomplatform.projectprice.handler;

import org.apache.log4j.Logger;
import pomplatform.projectprice.bean.BaseSprojectunitpricepagor;
import pomplatform.projectprice.bean.ConditionSprojectunitpricepagor;
import pomplatform.projectprice.query.QuerySprojectunitpricepagor;
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

public class SprojectunitpricepagorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectunitpricepagorHandler.class);

	public static BaseCollection<BaseSprojectunitpricepagor> executeQuerySprojectunitpricepagor(ConditionSprojectunitpricepagor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectunitpricepagor dao = new QuerySprojectunitpricepagor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectunitpricepagor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectunitpricepagor c = new ConditionSprojectunitpricepagor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectunitpricepagor> result = executeQuerySprojectunitpricepagor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectunitpricepagor> result;
		ConditionSprojectunitpricepagor c = new ConditionSprojectunitpricepagor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectunitpricepagor dao = new QuerySprojectunitpricepagor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSprojectunitpricepagor.ALL_CAPTIONS);
			for(BaseSprojectunitpricepagor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


