package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseFillcheckApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionFillcheckApply;
import pomplatform.workflow.personnelbusiness.query.QueryFillcheckApply;
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

public class FillcheckApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FillcheckApplyHandler.class);

	public static BaseCollection<BaseFillcheckApply> executeQueryFillcheckApply(ConditionFillcheckApply c, KeyValuePair[] replacements ) throws Exception {
		QueryFillcheckApply dao = new QueryFillcheckApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFillcheckApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFillcheckApply c = new ConditionFillcheckApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFillcheckApply> result = executeQueryFillcheckApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFillcheckApply> result;
		ConditionFillcheckApply c = new ConditionFillcheckApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFillcheckApply dao = new QueryFillcheckApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFillcheckApply.ALL_CAPTIONS);
			for(BaseFillcheckApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


