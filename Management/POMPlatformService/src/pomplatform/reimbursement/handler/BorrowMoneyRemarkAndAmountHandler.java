package pomplatform.reimbursement.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursement.bean.BaseBorrowMoneyRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionBorrowMoneyRemarkAndAmount;
import pomplatform.reimbursement.query.QueryBorrowMoneyRemarkAndAmount;
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

public class BorrowMoneyRemarkAndAmountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BorrowMoneyRemarkAndAmountHandler.class);

	public static BaseCollection<BaseBorrowMoneyRemarkAndAmount> executeQueryBorrowMoneyRemarkAndAmount(ConditionBorrowMoneyRemarkAndAmount c, KeyValuePair[] replacements ) throws Exception {
		QueryBorrowMoneyRemarkAndAmount dao = new QueryBorrowMoneyRemarkAndAmount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBorrowMoneyRemarkAndAmount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBorrowMoneyRemarkAndAmount c = new ConditionBorrowMoneyRemarkAndAmount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBorrowMoneyRemarkAndAmount> result = executeQueryBorrowMoneyRemarkAndAmount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBorrowMoneyRemarkAndAmount> result;
		ConditionBorrowMoneyRemarkAndAmount c = new ConditionBorrowMoneyRemarkAndAmount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBorrowMoneyRemarkAndAmount dao = new QueryBorrowMoneyRemarkAndAmount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBorrowMoneyRemarkAndAmount.ALL_CAPTIONS);
			for(BaseBorrowMoneyRemarkAndAmount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


