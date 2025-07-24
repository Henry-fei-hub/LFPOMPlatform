package pomplatform.capitaldistribution.handler;

import org.apache.log4j.Logger;
import pomplatform.capitaldistribution.bean.BaseAutoFitInfo;
import pomplatform.capitaldistribution.bean.ConditionAutoFitInfo;
import pomplatform.capitaldistribution.query.QueryAutoFitInfo;
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

public class AutoFitInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AutoFitInfoHandler.class);

	public static BaseCollection<BaseAutoFitInfo> executeQueryAutoFitInfo(ConditionAutoFitInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryAutoFitInfo dao = new QueryAutoFitInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAutoFitInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAutoFitInfo c = new ConditionAutoFitInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAutoFitInfo> result = executeQueryAutoFitInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAutoFitInfo> result;
		ConditionAutoFitInfo c = new ConditionAutoFitInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAutoFitInfo dao = new QueryAutoFitInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAutoFitInfo.ALL_CAPTIONS);
			for(BaseAutoFitInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


