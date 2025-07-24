package pomplatform.receiveunit.handler;

import org.apache.log4j.Logger;
import pomplatform.receiveunit.bean.BaseMemployeepsrreereeedpor;
import pomplatform.receiveunit.bean.ConditionMemployeepsrreereeedpor;
import pomplatform.receiveunit.query.QueryMemployeepsrreereeedpor;
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

public class MemployeepsrreereeedporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeepsrreereeedporHandler.class);

	public static BaseCollection<BaseMemployeepsrreereeedpor> executeQueryMemployeepsrreereeedpor(ConditionMemployeepsrreereeedpor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeepsrreereeedpor dao = new QueryMemployeepsrreereeedpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeepsrreereeedpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeepsrreereeedpor c = new ConditionMemployeepsrreereeedpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeepsrreereeedpor> result = executeQueryMemployeepsrreereeedpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeepsrreereeedpor> result;
		ConditionMemployeepsrreereeedpor c = new ConditionMemployeepsrreereeedpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeepsrreereeedpor dao = new QueryMemployeepsrreereeedpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeepsrreereeedpor.ALL_CAPTIONS);
			for(BaseMemployeepsrreereeedpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


