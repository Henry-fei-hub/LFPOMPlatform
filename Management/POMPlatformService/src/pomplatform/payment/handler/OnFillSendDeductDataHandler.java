package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnFillSendDeductData;
import pomplatform.payment.bean.ConditionOnFillSendDeductData;
import pomplatform.payment.query.QueryOnFillSendDeductData;
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

public class OnFillSendDeductDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnFillSendDeductDataHandler.class);

	public static BaseCollection<BaseOnFillSendDeductData> executeQueryOnFillSendDeductData(ConditionOnFillSendDeductData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnFillSendDeductData dao = new QueryOnFillSendDeductData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnFillSendDeductData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnFillSendDeductData c = new ConditionOnFillSendDeductData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnFillSendDeductData> result = executeQueryOnFillSendDeductData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnFillSendDeductData> result;
		ConditionOnFillSendDeductData c = new ConditionOnFillSendDeductData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnFillSendDeductData dao = new QueryOnFillSendDeductData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnFillSendDeductData.ALL_CAPTIONS);
			for(BaseOnFillSendDeductData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


