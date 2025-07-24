package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseFillcheckApplyTimes;
import pomplatform.workflow.personnelbusiness.bean.ConditionFillcheckApplyTimes;
import pomplatform.workflow.personnelbusiness.query.QueryFillcheckApplyTimes;
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

public class FillcheckApplyTimesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FillcheckApplyTimesHandler.class);

	public static BaseCollection<BaseFillcheckApplyTimes> executeQueryFillcheckApplyTimes(ConditionFillcheckApplyTimes c, KeyValuePair[] replacements ) throws Exception {
		QueryFillcheckApplyTimes dao = new QueryFillcheckApplyTimes();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFillcheckApplyTimes> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFillcheckApplyTimes c = new ConditionFillcheckApplyTimes();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFillcheckApplyTimes> result = executeQueryFillcheckApplyTimes(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFillcheckApplyTimes> result;
		ConditionFillcheckApplyTimes c = new ConditionFillcheckApplyTimes();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFillcheckApplyTimes dao = new QueryFillcheckApplyTimes();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFillcheckApplyTimes.ALL_CAPTIONS);
			for(BaseFillcheckApplyTimes b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


