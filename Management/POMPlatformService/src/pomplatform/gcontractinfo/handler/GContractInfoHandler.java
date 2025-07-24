package pomplatform.gcontractinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.gcontractinfo.bean.BaseGContractInfo;
import pomplatform.gcontractinfo.bean.ConditionGContractInfo;
import pomplatform.gcontractinfo.query.QueryGContractInfo;
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

public class GContractInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GContractInfoHandler.class);

	public static BaseCollection<BaseGContractInfo> executeQueryGContractInfo(ConditionGContractInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryGContractInfo dao = new QueryGContractInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGContractInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGContractInfo c = new ConditionGContractInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGContractInfo> result = executeQueryGContractInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGContractInfo> result;
		ConditionGContractInfo c = new ConditionGContractInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGContractInfo dao = new QueryGContractInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGContractInfo.ALL_CAPTIONS);
			for(BaseGContractInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


