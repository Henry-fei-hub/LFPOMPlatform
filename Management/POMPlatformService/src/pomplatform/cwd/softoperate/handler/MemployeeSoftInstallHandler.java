package pomplatform.cwd.softoperate.handler;

import org.apache.log4j.Logger;
import pomplatform.cwd.softoperate.bean.BaseMemployeeSoftInstall;
import pomplatform.cwd.softoperate.bean.ConditionMemployeeSoftInstall;
import pomplatform.cwd.softoperate.query.QueryMemployeeSoftInstall;
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

public class MemployeeSoftInstallHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeeSoftInstallHandler.class);

	public static BaseCollection<BaseMemployeeSoftInstall> executeQueryMemployeeSoftInstall(ConditionMemployeeSoftInstall c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeeSoftInstall dao = new QueryMemployeeSoftInstall();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeSoftInstall> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeeSoftInstall c = new ConditionMemployeeSoftInstall();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeeSoftInstall> result = executeQueryMemployeeSoftInstall(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeeSoftInstall> result;
		ConditionMemployeeSoftInstall c = new ConditionMemployeeSoftInstall();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeeSoftInstall dao = new QueryMemployeeSoftInstall();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeeSoftInstall.ALL_CAPTIONS);
			for(BaseMemployeeSoftInstall b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


