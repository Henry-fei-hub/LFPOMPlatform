package pomplatform.newMainprojectInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.newMainprojectInfo.bean.BaseNewMainprojectInfo;
import pomplatform.newMainprojectInfo.bean.ConditionNewMainprojectInfo;
import pomplatform.newMainprojectInfo.query.QueryNewMainprojectInfo;
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

public class NewMainprojectInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NewMainprojectInfoHandler.class);

	public static BaseCollection<BaseNewMainprojectInfo> executeQueryNewMainprojectInfo(ConditionNewMainprojectInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryNewMainprojectInfo dao = new QueryNewMainprojectInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNewMainprojectInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNewMainprojectInfo c = new ConditionNewMainprojectInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNewMainprojectInfo> result = executeQueryNewMainprojectInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNewMainprojectInfo> result;
		ConditionNewMainprojectInfo c = new ConditionNewMainprojectInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNewMainprojectInfo dao = new QueryNewMainprojectInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNewMainprojectInfo.ALL_CAPTIONS);
			for(BaseNewMainprojectInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


