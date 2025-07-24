package pomplatform.reimbursement.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursement.bean.BaseProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.query.QueryProjectNormalRemarkAndAmount;
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

public class ProjectNormalRemarkAndAmountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectNormalRemarkAndAmountHandler.class);

	public static BaseCollection<BaseProjectNormalRemarkAndAmount> executeQueryProjectNormalRemarkAndAmount(ConditionProjectNormalRemarkAndAmount c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectNormalRemarkAndAmount dao = new QueryProjectNormalRemarkAndAmount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectNormalRemarkAndAmount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectNormalRemarkAndAmount c = new ConditionProjectNormalRemarkAndAmount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectNormalRemarkAndAmount> result = executeQueryProjectNormalRemarkAndAmount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectNormalRemarkAndAmount> result;
		ConditionProjectNormalRemarkAndAmount c = new ConditionProjectNormalRemarkAndAmount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectNormalRemarkAndAmount dao = new QueryProjectNormalRemarkAndAmount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectNormalRemarkAndAmount.ALL_CAPTIONS);
			for(BaseProjectNormalRemarkAndAmount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


