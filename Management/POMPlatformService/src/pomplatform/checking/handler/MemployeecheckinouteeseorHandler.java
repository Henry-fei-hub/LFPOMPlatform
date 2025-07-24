package pomplatform.checking.handler;

import org.apache.log4j.Logger;
import pomplatform.checking.bean.BaseMemployeecheckinouteeseor;
import pomplatform.checking.bean.ConditionMemployeecheckinouteeseor;
import pomplatform.checking.query.QueryMemployeecheckinouteeseor;
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

public class MemployeecheckinouteeseorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeecheckinouteeseorHandler.class);

	public static BaseCollection<BaseMemployeecheckinouteeseor> executeQueryMemployeecheckinouteeseor(ConditionMemployeecheckinouteeseor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeecheckinouteeseor dao = new QueryMemployeecheckinouteeseor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeecheckinouteeseor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeecheckinouteeseor c = new ConditionMemployeecheckinouteeseor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeecheckinouteeseor> result = executeQueryMemployeecheckinouteeseor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeecheckinouteeseor> result;
		ConditionMemployeecheckinouteeseor c = new ConditionMemployeecheckinouteeseor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeecheckinouteeseor dao = new QueryMemployeecheckinouteeseor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeecheckinouteeseor.ALL_CAPTIONS);
			for(BaseMemployeecheckinouteeseor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


