package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadProjectChangeList;
import pomplatform.project.bean.ConditionOnLoadProjectChangeList;
import pomplatform.project.query.QueryOnLoadProjectChangeList;
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

public class OnLoadProjectChangeListHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectChangeListHandler.class);

	public static BaseCollection<BaseOnLoadProjectChangeList> executeQueryOnLoadProjectChangeList(ConditionOnLoadProjectChangeList c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectChangeList dao = new QueryOnLoadProjectChangeList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectChangeList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectChangeList c = new ConditionOnLoadProjectChangeList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectChangeList> result = executeQueryOnLoadProjectChangeList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectChangeList> result;
		ConditionOnLoadProjectChangeList c = new ConditionOnLoadProjectChangeList();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectChangeList dao = new QueryOnLoadProjectChangeList();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectChangeList.ALL_CAPTIONS);
			for(BaseOnLoadProjectChangeList b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


