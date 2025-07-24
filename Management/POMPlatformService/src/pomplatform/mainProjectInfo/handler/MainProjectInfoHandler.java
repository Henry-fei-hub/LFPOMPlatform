package pomplatform.mainProjectInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.mainProjectInfo.bean.BaseMainProjectInfo;
import pomplatform.mainProjectInfo.bean.ConditionMainProjectInfo;
import pomplatform.mainProjectInfo.query.QueryMainProjectInfo;
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

public class MainProjectInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MainProjectInfoHandler.class);

	public static BaseCollection<BaseMainProjectInfo> executeQueryMainProjectInfo(ConditionMainProjectInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryMainProjectInfo dao = new QueryMainProjectInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMainProjectInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMainProjectInfo c = new ConditionMainProjectInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMainProjectInfo> result = executeQueryMainProjectInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMainProjectInfo> result;
		ConditionMainProjectInfo c = new ConditionMainProjectInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMainProjectInfo dao = new QueryMainProjectInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMainProjectInfo.ALL_CAPTIONS);
			for(BaseMainProjectInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


