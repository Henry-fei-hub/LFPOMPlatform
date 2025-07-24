package pomplatform.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.personnelbusiness.bean.BaseEmployeeContractAttachment;
import pomplatform.personnelbusiness.bean.ConditionEmployeeContractAttachment;
import pomplatform.personnelbusiness.query.QueryEmployeeContractAttachment;
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

public class EmployeeContractAttachmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeContractAttachmentHandler.class);

	public static BaseCollection<BaseEmployeeContractAttachment> executeQueryEmployeeContractAttachment(ConditionEmployeeContractAttachment c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeContractAttachment dao = new QueryEmployeeContractAttachment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeContractAttachment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeContractAttachment c = new ConditionEmployeeContractAttachment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeContractAttachment> result = executeQueryEmployeeContractAttachment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeContractAttachment> result;
		ConditionEmployeeContractAttachment c = new ConditionEmployeeContractAttachment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeContractAttachment dao = new QueryEmployeeContractAttachment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeContractAttachment.ALL_CAPTIONS);
			for(BaseEmployeeContractAttachment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


