package pomplatform.checking.handler;

import org.apache.log4j.Logger;
import pomplatform.checking.bean.BaseEmployeecheckinoutStatusCount;
import pomplatform.checking.bean.ConditionEmployeecheckinoutStatusCount;
import pomplatform.checking.query.QueryEmployeecheckinoutStatusCount;
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

public class EmployeecheckinoutStatusCountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeecheckinoutStatusCountHandler.class);

	public static BaseCollection<BaseEmployeecheckinoutStatusCount> executeQueryEmployeecheckinoutStatusCount(ConditionEmployeecheckinoutStatusCount c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeecheckinoutStatusCount dao = new QueryEmployeecheckinoutStatusCount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeecheckinoutStatusCount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeecheckinoutStatusCount c = new ConditionEmployeecheckinoutStatusCount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeecheckinoutStatusCount> result = executeQueryEmployeecheckinoutStatusCount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeecheckinoutStatusCount> result;
		ConditionEmployeecheckinoutStatusCount c = new ConditionEmployeecheckinoutStatusCount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeecheckinoutStatusCount dao = new QueryEmployeecheckinoutStatusCount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeecheckinoutStatusCount.ALL_CAPTIONS);
			for(BaseEmployeecheckinoutStatusCount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


