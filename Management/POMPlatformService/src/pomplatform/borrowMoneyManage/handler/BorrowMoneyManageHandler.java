package pomplatform.borrowMoneyManage.handler;

import org.apache.log4j.Logger;
import pomplatform.borrowMoneyManage.bean.BaseBorrowMoneyManage;
import pomplatform.borrowMoneyManage.bean.ConditionBorrowMoneyManage;
import pomplatform.borrowMoneyManage.query.QueryBorrowMoneyManage;
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

public class BorrowMoneyManageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BorrowMoneyManageHandler.class);

	public static BaseCollection<BaseBorrowMoneyManage> executeQueryBorrowMoneyManage(ConditionBorrowMoneyManage c, KeyValuePair[] replacements ) throws Exception {
		QueryBorrowMoneyManage dao = new QueryBorrowMoneyManage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBorrowMoneyManage> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBorrowMoneyManage c = new ConditionBorrowMoneyManage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBorrowMoneyManage> result = executeQueryBorrowMoneyManage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBorrowMoneyManage> result;
		ConditionBorrowMoneyManage c = new ConditionBorrowMoneyManage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBorrowMoneyManage dao = new QueryBorrowMoneyManage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBorrowMoneyManage.ALL_CAPTIONS);
			for(BaseBorrowMoneyManage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


