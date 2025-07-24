package pomplatform.financialtransactionaccount.handler;

import org.apache.log4j.Logger;
import pomplatform.financialtransactionaccount.bean.BaseProcessInfoInTransDetail;
import pomplatform.financialtransactionaccount.bean.ConditionProcessInfoInTransDetail;
import pomplatform.financialtransactionaccount.query.QueryProcessInfoInTransDetail;
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

public class ProcessInfoInTransDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProcessInfoInTransDetailHandler.class);

	public static BaseCollection<BaseProcessInfoInTransDetail> executeQueryProcessInfoInTransDetail(ConditionProcessInfoInTransDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryProcessInfoInTransDetail dao = new QueryProcessInfoInTransDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProcessInfoInTransDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProcessInfoInTransDetail c = new ConditionProcessInfoInTransDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProcessInfoInTransDetail> result = executeQueryProcessInfoInTransDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProcessInfoInTransDetail> result;
		ConditionProcessInfoInTransDetail c = new ConditionProcessInfoInTransDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProcessInfoInTransDetail dao = new QueryProcessInfoInTransDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProcessInfoInTransDetail.ALL_CAPTIONS);
			for(BaseProcessInfoInTransDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


