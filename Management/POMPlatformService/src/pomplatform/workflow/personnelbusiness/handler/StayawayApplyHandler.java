package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseStayawayApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionStayawayApply;
import pomplatform.workflow.personnelbusiness.query.QueryStayawayApply;
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

public class StayawayApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(StayawayApplyHandler.class);

	public static BaseCollection<BaseStayawayApply> executeQueryStayawayApply(ConditionStayawayApply c, KeyValuePair[] replacements ) throws Exception {
		QueryStayawayApply dao = new QueryStayawayApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseStayawayApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionStayawayApply c = new ConditionStayawayApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseStayawayApply> result = executeQueryStayawayApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseStayawayApply> result;
		ConditionStayawayApply c = new ConditionStayawayApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryStayawayApply dao = new QueryStayawayApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseStayawayApply.ALL_CAPTIONS);
			for(BaseStayawayApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


