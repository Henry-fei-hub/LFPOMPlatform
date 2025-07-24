package pomplatform.contractchange.handler;

import org.apache.log4j.Logger;
import pomplatform.contractchange.bean.BaseChangeProjectInfo;
import pomplatform.contractchange.bean.ConditionChangeProjectInfo;
import pomplatform.contractchange.query.QueryChangeProjectInfo;
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

public class ChangeProjectInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ChangeProjectInfoHandler.class);

	public static BaseCollection<BaseChangeProjectInfo> executeQueryChangeProjectInfo(ConditionChangeProjectInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryChangeProjectInfo dao = new QueryChangeProjectInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseChangeProjectInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionChangeProjectInfo c = new ConditionChangeProjectInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseChangeProjectInfo> result = executeQueryChangeProjectInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseChangeProjectInfo> result;
		ConditionChangeProjectInfo c = new ConditionChangeProjectInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryChangeProjectInfo dao = new QueryChangeProjectInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseChangeProjectInfo.ALL_CAPTIONS);
			for(BaseChangeProjectInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


