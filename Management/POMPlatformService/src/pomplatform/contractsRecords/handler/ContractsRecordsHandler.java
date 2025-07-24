package pomplatform.contractsRecords.handler;

import org.apache.log4j.Logger;
import pomplatform.contractsRecords.bean.BaseContractsRecords;
import pomplatform.contractsRecords.bean.ConditionContractsRecords;
import pomplatform.contractsRecords.query.QueryContractsRecords;
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

public class ContractsRecordsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractsRecordsHandler.class);

	public static BaseCollection<BaseContractsRecords> executeQueryContractsRecords(ConditionContractsRecords c, KeyValuePair[] replacements ) throws Exception {
		QueryContractsRecords dao = new QueryContractsRecords();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractsRecords> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractsRecords c = new ConditionContractsRecords();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractsRecords> result = executeQueryContractsRecords(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractsRecords> result;
		ConditionContractsRecords c = new ConditionContractsRecords();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractsRecords dao = new QueryContractsRecords();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractsRecords.EXPORT_CAPTIONS);
			for(BaseContractsRecords b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


