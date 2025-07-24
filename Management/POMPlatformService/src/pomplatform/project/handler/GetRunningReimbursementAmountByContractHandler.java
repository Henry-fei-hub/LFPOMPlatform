package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseGetRunningReimbursementAmountByContract;
import pomplatform.project.bean.ConditionGetRunningReimbursementAmountByContract;
import pomplatform.project.query.QueryGetRunningReimbursementAmountByContract;
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

public class GetRunningReimbursementAmountByContractHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetRunningReimbursementAmountByContractHandler.class);

	public static BaseCollection<BaseGetRunningReimbursementAmountByContract> executeQueryGetRunningReimbursementAmountByContract(ConditionGetRunningReimbursementAmountByContract c, KeyValuePair[] replacements ) throws Exception {
		QueryGetRunningReimbursementAmountByContract dao = new QueryGetRunningReimbursementAmountByContract();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetRunningReimbursementAmountByContract> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetRunningReimbursementAmountByContract c = new ConditionGetRunningReimbursementAmountByContract();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetRunningReimbursementAmountByContract> result = executeQueryGetRunningReimbursementAmountByContract(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetRunningReimbursementAmountByContract> result;
		ConditionGetRunningReimbursementAmountByContract c = new ConditionGetRunningReimbursementAmountByContract();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetRunningReimbursementAmountByContract dao = new QueryGetRunningReimbursementAmountByContract();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetRunningReimbursementAmountByContract.ALL_CAPTIONS);
			for(BaseGetRunningReimbursementAmountByContract b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


