package pomplatform.financialtransactionaccount.handler;

import org.apache.log4j.Logger;
import pomplatform.financialtransactionaccount.bean.BaseReceiveUnitRepaymentTrans;
import pomplatform.financialtransactionaccount.bean.ConditionReceiveUnitRepaymentTrans;
import pomplatform.financialtransactionaccount.query.QueryReceiveUnitRepaymentTrans;
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

public class ReceiveUnitRepaymentTransHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReceiveUnitRepaymentTransHandler.class);

	public static BaseCollection<BaseReceiveUnitRepaymentTrans> executeQueryReceiveUnitRepaymentTrans(ConditionReceiveUnitRepaymentTrans c, KeyValuePair[] replacements ) throws Exception {
		QueryReceiveUnitRepaymentTrans dao = new QueryReceiveUnitRepaymentTrans();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReceiveUnitRepaymentTrans> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReceiveUnitRepaymentTrans c = new ConditionReceiveUnitRepaymentTrans();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReceiveUnitRepaymentTrans> result = executeQueryReceiveUnitRepaymentTrans(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReceiveUnitRepaymentTrans> result;
		ConditionReceiveUnitRepaymentTrans c = new ConditionReceiveUnitRepaymentTrans();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReceiveUnitRepaymentTrans dao = new QueryReceiveUnitRepaymentTrans();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReceiveUnitRepaymentTrans.ALL_CAPTIONS);
			for(BaseReceiveUnitRepaymentTrans b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


