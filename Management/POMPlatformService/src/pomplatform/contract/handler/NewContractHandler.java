package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseNewContract;
import pomplatform.contract.bean.ConditionNewContract;
import pomplatform.contract.query.QueryNewContract;
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

public class NewContractHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NewContractHandler.class);

	public static BaseCollection<BaseNewContract> executeQueryNewContract(ConditionNewContract c, KeyValuePair[] replacements ) throws Exception {
		QueryNewContract dao = new QueryNewContract();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNewContract> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNewContract c = new ConditionNewContract();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNewContract> result = executeQueryNewContract(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNewContract> result;
		ConditionNewContract c = new ConditionNewContract();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNewContract dao = new QueryNewContract();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNewContract.ALL_CAPTIONS);
			for(BaseNewContract b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


