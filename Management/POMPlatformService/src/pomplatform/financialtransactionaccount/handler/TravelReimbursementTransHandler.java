package pomplatform.financialtransactionaccount.handler;

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
import pomplatform.financialtransactionaccount.bean.BaseTravelReimbursementTrans;
import pomplatform.financialtransactionaccount.bean.ConditionTravelReimbursementTrans;
import pomplatform.financialtransactionaccount.query.QueryTravelReimbursementTrans;

public class TravelReimbursementTransHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TravelReimbursementTransHandler.class);

	public static BaseCollection<BaseTravelReimbursementTrans> executeQueryTravelReimbursementTrans(ConditionTravelReimbursementTrans c, KeyValuePair[] replacements ) throws Exception {
		QueryTravelReimbursementTrans dao = new QueryTravelReimbursementTrans();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTravelReimbursementTrans> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTravelReimbursementTrans c = new ConditionTravelReimbursementTrans();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTravelReimbursementTrans> result = executeQueryTravelReimbursementTrans(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTravelReimbursementTrans> result;
		ConditionTravelReimbursementTrans c = new ConditionTravelReimbursementTrans();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTravelReimbursementTrans dao = new QueryTravelReimbursementTrans();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTravelReimbursementTrans.ALL_CAPTIONS);
			for(BaseTravelReimbursementTrans b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


