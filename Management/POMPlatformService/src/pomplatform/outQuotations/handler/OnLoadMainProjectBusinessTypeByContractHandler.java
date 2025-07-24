package pomplatform.outQuotations.handler;

import org.apache.log4j.Logger;
import pomplatform.outQuotations.bean.BaseOnLoadMainProjectBusinessTypeByContract;
import pomplatform.outQuotations.bean.ConditionOnLoadMainProjectBusinessTypeByContract;
import pomplatform.outQuotations.query.QueryOnLoadMainProjectBusinessTypeByContract;
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

public class OnLoadMainProjectBusinessTypeByContractHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadMainProjectBusinessTypeByContractHandler.class);

	public static BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> executeQueryOnLoadMainProjectBusinessTypeByContract(ConditionOnLoadMainProjectBusinessTypeByContract c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadMainProjectBusinessTypeByContract dao = new QueryOnLoadMainProjectBusinessTypeByContract();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadMainProjectBusinessTypeByContract c = new ConditionOnLoadMainProjectBusinessTypeByContract();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> result = executeQueryOnLoadMainProjectBusinessTypeByContract(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadMainProjectBusinessTypeByContract> result;
		ConditionOnLoadMainProjectBusinessTypeByContract c = new ConditionOnLoadMainProjectBusinessTypeByContract();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadMainProjectBusinessTypeByContract dao = new QueryOnLoadMainProjectBusinessTypeByContract();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadMainProjectBusinessTypeByContract.ALL_CAPTIONS);
			for(BaseOnLoadMainProjectBusinessTypeByContract b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


