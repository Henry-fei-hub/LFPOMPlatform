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
import pomplatform.financialtransactionaccount.bean.BaseBorrowMoneyTrans;
import pomplatform.financialtransactionaccount.bean.ConditionBorrowMoneyTrans;
import pomplatform.financialtransactionaccount.query.QueryBorrowMoneyTrans;

public class BorrowMoneyTransHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BorrowMoneyTransHandler.class);

	public static BaseCollection<BaseBorrowMoneyTrans> executeQueryBorrowMoneyTrans(ConditionBorrowMoneyTrans c, KeyValuePair[] replacements ) throws Exception {
		QueryBorrowMoneyTrans dao = new QueryBorrowMoneyTrans();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBorrowMoneyTrans> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBorrowMoneyTrans c = new ConditionBorrowMoneyTrans();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBorrowMoneyTrans> result = executeQueryBorrowMoneyTrans(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBorrowMoneyTrans> result;
		ConditionBorrowMoneyTrans c = new ConditionBorrowMoneyTrans();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBorrowMoneyTrans dao = new QueryBorrowMoneyTrans();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBorrowMoneyTrans.ALL_CAPTIONS);
			for(BaseBorrowMoneyTrans b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


