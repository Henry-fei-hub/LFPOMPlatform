package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnJobSubsidysData;
import pomplatform.payment.bean.ConditionOnJobSubsidysData;
import pomplatform.payment.query.QueryOnJobSubsidysData;
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

public class OnJobSubsidysDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnJobSubsidysDataHandler.class);

	public static BaseCollection<BaseOnJobSubsidysData> executeQueryOnJobSubsidysData(ConditionOnJobSubsidysData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnJobSubsidysData dao = new QueryOnJobSubsidysData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnJobSubsidysData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnJobSubsidysData c = new ConditionOnJobSubsidysData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnJobSubsidysData> result = executeQueryOnJobSubsidysData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnJobSubsidysData> result;
		ConditionOnJobSubsidysData c = new ConditionOnJobSubsidysData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnJobSubsidysData dao = new QueryOnJobSubsidysData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnJobSubsidysData.ALL_CAPTIONS);
			for(BaseOnJobSubsidysData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


