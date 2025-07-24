package pomplatform.projectStageTemplate.handler;

import org.apache.log4j.Logger;
import pomplatform.projectStageTemplate.bean.BaseSprojectstagetemplatepor;
import pomplatform.projectStageTemplate.bean.ConditionSprojectstagetemplatepor;
import pomplatform.projectStageTemplate.query.QuerySprojectstagetemplatepor;
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

public class SprojectstagetemplateporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectstagetemplateporHandler.class);

	public static BaseCollection<BaseSprojectstagetemplatepor> executeQuerySprojectstagetemplatepor(ConditionSprojectstagetemplatepor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectstagetemplatepor dao = new QuerySprojectstagetemplatepor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectstagetemplatepor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectstagetemplatepor c = new ConditionSprojectstagetemplatepor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectstagetemplatepor> result = executeQuerySprojectstagetemplatepor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectstagetemplatepor> result;
		ConditionSprojectstagetemplatepor c = new ConditionSprojectstagetemplatepor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectstagetemplatepor dao = new QuerySprojectstagetemplatepor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectstagetemplatepor.ALL_CAPTIONS);
			for(BaseSprojectstagetemplatepor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


