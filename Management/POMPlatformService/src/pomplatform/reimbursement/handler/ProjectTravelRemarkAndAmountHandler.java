package pomplatform.reimbursement.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursement.bean.BaseProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.query.QueryProjectTravelRemarkAndAmount;
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

public class ProjectTravelRemarkAndAmountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectTravelRemarkAndAmountHandler.class);

	public static BaseCollection<BaseProjectTravelRemarkAndAmount> executeQueryProjectTravelRemarkAndAmount(ConditionProjectTravelRemarkAndAmount c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectTravelRemarkAndAmount dao = new QueryProjectTravelRemarkAndAmount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectTravelRemarkAndAmount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectTravelRemarkAndAmount c = new ConditionProjectTravelRemarkAndAmount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectTravelRemarkAndAmount> result = executeQueryProjectTravelRemarkAndAmount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectTravelRemarkAndAmount> result;
		ConditionProjectTravelRemarkAndAmount c = new ConditionProjectTravelRemarkAndAmount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectTravelRemarkAndAmount dao = new QueryProjectTravelRemarkAndAmount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectTravelRemarkAndAmount.ALL_CAPTIONS);
			for(BaseProjectTravelRemarkAndAmount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


