package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.bean.ConditionCheckWorkHandover;
import pomplatform.workflow.personnelbusiness.query.QueryCheckWorkHandover;
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

public class CheckWorkHandoverHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CheckWorkHandoverHandler.class);

	public static BaseCollection<BaseCheckWorkHandover> executeQueryCheckWorkHandover(ConditionCheckWorkHandover c, KeyValuePair[] replacements ) throws Exception {
		QueryCheckWorkHandover dao = new QueryCheckWorkHandover();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCheckWorkHandover> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCheckWorkHandover c = new ConditionCheckWorkHandover();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCheckWorkHandover> result = executeQueryCheckWorkHandover(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCheckWorkHandover> result;
		ConditionCheckWorkHandover c = new ConditionCheckWorkHandover();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCheckWorkHandover dao = new QueryCheckWorkHandover();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCheckWorkHandover.ALL_CAPTIONS);
			for(BaseCheckWorkHandover b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


