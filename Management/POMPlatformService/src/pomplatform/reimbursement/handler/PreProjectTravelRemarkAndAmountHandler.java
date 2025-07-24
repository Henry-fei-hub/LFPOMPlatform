package pomplatform.reimbursement.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursement.bean.BasePreProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionPreProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.query.QueryPreProjectTravelRemarkAndAmount;
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

public class PreProjectTravelRemarkAndAmountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PreProjectTravelRemarkAndAmountHandler.class);

	public static BaseCollection<BasePreProjectTravelRemarkAndAmount> executeQueryPreProjectTravelRemarkAndAmount(ConditionPreProjectTravelRemarkAndAmount c, KeyValuePair[] replacements ) throws Exception {
		QueryPreProjectTravelRemarkAndAmount dao = new QueryPreProjectTravelRemarkAndAmount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePreProjectTravelRemarkAndAmount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPreProjectTravelRemarkAndAmount c = new ConditionPreProjectTravelRemarkAndAmount();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePreProjectTravelRemarkAndAmount> result = executeQueryPreProjectTravelRemarkAndAmount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePreProjectTravelRemarkAndAmount> result;
		ConditionPreProjectTravelRemarkAndAmount c = new ConditionPreProjectTravelRemarkAndAmount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPreProjectTravelRemarkAndAmount dao = new QueryPreProjectTravelRemarkAndAmount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePreProjectTravelRemarkAndAmount.ALL_CAPTIONS);
			for(BasePreProjectTravelRemarkAndAmount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


