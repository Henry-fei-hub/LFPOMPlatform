package pomplatform.contract.handler;

import org.apache.log4j.Logger;
import pomplatform.contract.bean.BaseOnLoadAttachmentBindContract;
import pomplatform.contract.bean.ConditionOnLoadAttachmentBindContract;
import pomplatform.contract.query.QueryOnLoadAttachmentBindContract;
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

public class OnLoadAttachmentBindContractHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttachmentBindContractHandler.class);

	public static BaseCollection<BaseOnLoadAttachmentBindContract> executeQueryOnLoadAttachmentBindContract(ConditionOnLoadAttachmentBindContract c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttachmentBindContract dao = new QueryOnLoadAttachmentBindContract();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttachmentBindContract> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttachmentBindContract c = new ConditionOnLoadAttachmentBindContract();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttachmentBindContract> result = executeQueryOnLoadAttachmentBindContract(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttachmentBindContract> result;
		ConditionOnLoadAttachmentBindContract c = new ConditionOnLoadAttachmentBindContract();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttachmentBindContract dao = new QueryOnLoadAttachmentBindContract();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttachmentBindContract.ALL_CAPTIONS);
			for(BaseOnLoadAttachmentBindContract b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


