package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnInsteadDeductIllData;
import pomplatform.payment.bean.ConditionOnInsteadDeductIllData;
import pomplatform.payment.query.QueryOnInsteadDeductIllData;
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

public class OnInsteadDeductIllDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnInsteadDeductIllDataHandler.class);

	public static BaseCollection<BaseOnInsteadDeductIllData> executeQueryOnInsteadDeductIllData(ConditionOnInsteadDeductIllData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnInsteadDeductIllData dao = new QueryOnInsteadDeductIllData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnInsteadDeductIllData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnInsteadDeductIllData c = new ConditionOnInsteadDeductIllData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnInsteadDeductIllData> result = executeQueryOnInsteadDeductIllData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnInsteadDeductIllData> result;
		ConditionOnInsteadDeductIllData c = new ConditionOnInsteadDeductIllData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnInsteadDeductIllData dao = new QueryOnInsteadDeductIllData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnInsteadDeductIllData.ALL_CAPTIONS);
			for(BaseOnInsteadDeductIllData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


