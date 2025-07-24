package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseSprojectccpor;
import pomplatform.project.bean.ConditionSprojectccpor;
import pomplatform.project.query.QuerySprojectccpor;
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

public class SprojectccporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectccporHandler.class);

	public static BaseCollection<BaseSprojectccpor> executeQuerySprojectccpor(ConditionSprojectccpor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectccpor dao = new QuerySprojectccpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectccpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectccpor c = new ConditionSprojectccpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectccpor> result = executeQuerySprojectccpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectccpor> result;
		ConditionSprojectccpor c = new ConditionSprojectccpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectccpor dao = new QuerySprojectccpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectccpor.ALL_CAPTIONS);
			for(BaseSprojectccpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


