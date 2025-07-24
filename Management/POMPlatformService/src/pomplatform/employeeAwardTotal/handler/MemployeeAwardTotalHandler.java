package pomplatform.employeeAwardTotal.handler;

import org.apache.log4j.Logger;
import pomplatform.employeeAwardTotal.bean.BaseMemployeeAwardTotal;
import pomplatform.employeeAwardTotal.bean.ConditionMemployeeAwardTotal;
import pomplatform.employeeAwardTotal.query.QueryMemployeeAwardTotal;
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

public class MemployeeAwardTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeeAwardTotalHandler.class);

	public static BaseCollection<BaseMemployeeAwardTotal> executeQueryMemployeeAwardTotal(ConditionMemployeeAwardTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeeAwardTotal dao = new QueryMemployeeAwardTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeAwardTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeeAwardTotal c = new ConditionMemployeeAwardTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeeAwardTotal> result = executeQueryMemployeeAwardTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeeAwardTotal> result;
		ConditionMemployeeAwardTotal c = new ConditionMemployeeAwardTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeeAwardTotal dao = new QueryMemployeeAwardTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeeAwardTotal.ALL_CAPTIONS);
			for(BaseMemployeeAwardTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


