package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseBusinessTripApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionBusinessTripApply;
import pomplatform.workflow.personnelbusiness.query.QueryBusinessTripApply;
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

public class BusinessTripApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BusinessTripApplyHandler.class);

	public static BaseCollection<BaseBusinessTripApply> executeQueryBusinessTripApply(ConditionBusinessTripApply c, KeyValuePair[] replacements ) throws Exception {
		QueryBusinessTripApply dao = new QueryBusinessTripApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBusinessTripApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBusinessTripApply c = new ConditionBusinessTripApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBusinessTripApply> result = executeQueryBusinessTripApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBusinessTripApply> result;
		ConditionBusinessTripApply c = new ConditionBusinessTripApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBusinessTripApply dao = new QueryBusinessTripApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBusinessTripApply.ALL_CAPTIONS);
			for(BaseBusinessTripApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


