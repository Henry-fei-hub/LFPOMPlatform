package pomplatform.abouttrainingmanagement.handler;

import org.apache.log4j.Logger;
import pomplatform.abouttrainingmanagement.bean.BaseAboutTrainingManagement;
import pomplatform.abouttrainingmanagement.bean.ConditionAboutTrainingManagement;
import pomplatform.abouttrainingmanagement.query.QueryAboutTrainingManagement;
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

public class AboutTrainingManagementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AboutTrainingManagementHandler.class);

	public static BaseCollection<BaseAboutTrainingManagement> executeQueryAboutTrainingManagement(ConditionAboutTrainingManagement c, KeyValuePair[] replacements ) throws Exception {
		QueryAboutTrainingManagement dao = new QueryAboutTrainingManagement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAboutTrainingManagement> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAboutTrainingManagement c = new ConditionAboutTrainingManagement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAboutTrainingManagement> result = executeQueryAboutTrainingManagement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAboutTrainingManagement> result;
		ConditionAboutTrainingManagement c = new ConditionAboutTrainingManagement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAboutTrainingManagement dao = new QueryAboutTrainingManagement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAboutTrainingManagement.ALL_CAPTIONS);
			for(BaseAboutTrainingManagement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


