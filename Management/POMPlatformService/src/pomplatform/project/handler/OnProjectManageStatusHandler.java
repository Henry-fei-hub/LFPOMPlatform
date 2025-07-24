package pomplatform.project.handler;

import org.apache.log4j.Logger;

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
import pomplatform.project.bean.BaseOnProjectManageStatus;
import pomplatform.project.bean.ConditionOnProjectManageStatus;
import pomplatform.project.query.QueryOnProjectManageStatus;

public class OnProjectManageStatusHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnProjectManageStatusHandler.class);

	public static BaseCollection<BaseOnProjectManageStatus> executeQueryOnProjectManageStatus(ConditionOnProjectManageStatus c, KeyValuePair[] replacements ) throws Exception {
		QueryOnProjectManageStatus dao = new QueryOnProjectManageStatus();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnProjectManageStatus> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnProjectManageStatus c = new ConditionOnProjectManageStatus();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnProjectManageStatus> result = executeQueryOnProjectManageStatus(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnProjectManageStatus> result;
		ConditionOnProjectManageStatus c = new ConditionOnProjectManageStatus();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnProjectManageStatus dao = new QueryOnProjectManageStatus();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnProjectManageStatus.ALL_CAPTIONS);
			for(BaseOnProjectManageStatus b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


