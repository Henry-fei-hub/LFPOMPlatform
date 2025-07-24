package pomplatform.report.business;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.report.bean.BaseReportNewContractTotal;
import pomplatform.report.bean.ConditionReportNewContractTotal;
import pomplatform.report.query.QueryReportNewContractTotal;

public class OnDownloadReportNewContractTotal implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnDownloadReportNewContractTotal.class);

	public static BaseCollection<BaseReportNewContractTotal> executeQueryInsurance(ConditionReportNewContractTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportNewContractTotal dao = new QueryReportNewContractTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportNewContractTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportNewContractTotal c = new ConditionReportNewContractTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportNewContractTotal> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportNewContractTotal> result;
		ConditionReportNewContractTotal c = new ConditionReportNewContractTotal();
		c.setDataFromJSON(creteria);
		QueryReportNewContractTotal dao = new QueryReportNewContractTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportNewContractTotal.ALL_CAPTIONS);
			for(BaseReportNewContractTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


