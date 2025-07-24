package pomplatform.itemCollection.custom.handler;

import org.apache.log4j.Logger;
import pomplatform.itemCollection.custom.bean.BaseonLoadCapitalAmountOfContract;
import pomplatform.itemCollection.custom.bean.ConditiononLoadCapitalAmountOfContract;
import pomplatform.itemCollection.custom.query.QueryonLoadCapitalAmountOfContract;
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

public class onLoadCapitalAmountOfContractHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(onLoadCapitalAmountOfContractHandler.class);

	public static BaseCollection<BaseonLoadCapitalAmountOfContract> executeQueryonLoadCapitalAmountOfContract(ConditiononLoadCapitalAmountOfContract c, KeyValuePair[] replacements ) throws Exception {
		QueryonLoadCapitalAmountOfContract dao = new QueryonLoadCapitalAmountOfContract();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseonLoadCapitalAmountOfContract> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditiononLoadCapitalAmountOfContract c = new ConditiononLoadCapitalAmountOfContract();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseonLoadCapitalAmountOfContract> result = executeQueryonLoadCapitalAmountOfContract(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseonLoadCapitalAmountOfContract> result;
		ConditiononLoadCapitalAmountOfContract c = new ConditiononLoadCapitalAmountOfContract();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryonLoadCapitalAmountOfContract dao = new QueryonLoadCapitalAmountOfContract();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseonLoadCapitalAmountOfContract.ALL_CAPTIONS);
			for(BaseonLoadCapitalAmountOfContract b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


