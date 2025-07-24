package pomplatform.projectTemplate.handler;

import org.apache.log4j.Logger;
import pomplatform.projectTemplate.bean.BaseSprojecttemplateor;
import pomplatform.projectTemplate.bean.ConditionSprojecttemplateor;
import pomplatform.projectTemplate.query.QuerySprojecttemplateor;
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

public class SprojecttemplateorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojecttemplateorHandler.class);

	public static BaseCollection<BaseSprojecttemplateor> executeQuerySprojecttemplateor(ConditionSprojecttemplateor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojecttemplateor dao = new QuerySprojecttemplateor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojecttemplateor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojecttemplateor c = new ConditionSprojecttemplateor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojecttemplateor> result = executeQuerySprojecttemplateor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojecttemplateor> result;
		ConditionSprojecttemplateor c = new ConditionSprojecttemplateor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojecttemplateor dao = new QuerySprojecttemplateor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojecttemplateor.ALL_CAPTIONS);
			for(BaseSprojecttemplateor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


