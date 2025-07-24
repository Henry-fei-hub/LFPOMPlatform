package pomplatform.plateIntegralAssignRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.plateIntegralAssignRecord.bean.BaseSplateIntegralAssignRecord;
import pomplatform.plateIntegralAssignRecord.bean.ConditionSplateIntegralAssignRecord;
import pomplatform.plateIntegralAssignRecord.query.QuerySplateIntegralAssignRecord;
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

public class SplateIntegralAssignRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SplateIntegralAssignRecordHandler.class);

	public static BaseCollection<BaseSplateIntegralAssignRecord> executeQuerySplateIntegralAssignRecord(ConditionSplateIntegralAssignRecord c, KeyValuePair[] replacements ) throws Exception {
		QuerySplateIntegralAssignRecord dao = new QuerySplateIntegralAssignRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSplateIntegralAssignRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSplateIntegralAssignRecord c = new ConditionSplateIntegralAssignRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSplateIntegralAssignRecord> result = executeQuerySplateIntegralAssignRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSplateIntegralAssignRecord> result;
		ConditionSplateIntegralAssignRecord c = new ConditionSplateIntegralAssignRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySplateIntegralAssignRecord dao = new QuerySplateIntegralAssignRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSplateIntegralAssignRecord.ALL_CAPTIONS);
			for(BaseSplateIntegralAssignRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


