package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseAuditedEmployeeBorrowMoney;
import pomplatform.workflow.bean.ConditionAuditedEmployeeBorrowMoney;
import pomplatform.workflow.query.QueryAuditedEmployeeBorrowMoney;
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

public class AuditedEmployeeBorrowMoneyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AuditedEmployeeBorrowMoneyHandler.class);

	public static BaseCollection<BaseAuditedEmployeeBorrowMoney> executeQueryAuditedEmployeeBorrowMoney(ConditionAuditedEmployeeBorrowMoney c, KeyValuePair[] replacements ) throws Exception {
		QueryAuditedEmployeeBorrowMoney dao = new QueryAuditedEmployeeBorrowMoney();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAuditedEmployeeBorrowMoney> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAuditedEmployeeBorrowMoney c = new ConditionAuditedEmployeeBorrowMoney();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAuditedEmployeeBorrowMoney> result = executeQueryAuditedEmployeeBorrowMoney(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAuditedEmployeeBorrowMoney> result;
		ConditionAuditedEmployeeBorrowMoney c = new ConditionAuditedEmployeeBorrowMoney();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAuditedEmployeeBorrowMoney dao = new QueryAuditedEmployeeBorrowMoney();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAuditedEmployeeBorrowMoney.ALL_CAPTIONS);
			for(BaseAuditedEmployeeBorrowMoney b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


