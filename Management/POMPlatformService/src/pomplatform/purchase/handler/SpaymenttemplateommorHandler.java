package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseSpaymenttemplateommor;
import pomplatform.purchase.bean.ConditionSpaymenttemplateommor;
import pomplatform.purchase.query.QuerySpaymenttemplateommor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BasePaymentTemplateDetail;
import com.pomplatform.db.dao.PaymentTemplateDetail;
import delicacy.common.BaseCollection;

public class SpaymenttemplateommorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SpaymenttemplateommorHandler.class);

	public static BaseCollection<BaseSpaymenttemplateommor> executeQuerySpaymenttemplateommor(ConditionSpaymenttemplateommor c, KeyValuePair[] replacements ) throws Exception {
		QuerySpaymenttemplateommor dao = new QuerySpaymenttemplateommor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSpaymenttemplateommor> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			PaymentTemplateDetail daoPaymentTemplateDetail = new PaymentTemplateDetail();
			for(BaseSpaymenttemplateommor bean : result.getCollections()){
				daoPaymentTemplateDetail.setConditionPaymentTemplateId("=", bean.getPaymentTemplateId());
				bean.setDetailPaymentTemplateDetail(daoPaymentTemplateDetail.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSpaymenttemplateommor c = new ConditionSpaymenttemplateommor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSpaymenttemplateommor> result = executeQuerySpaymenttemplateommor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSpaymenttemplateommor> result;
		ConditionSpaymenttemplateommor c = new ConditionSpaymenttemplateommor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySpaymenttemplateommor dao = new QuerySpaymenttemplateommor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSpaymenttemplateommor.ALL_CAPTIONS);
			for(BaseSpaymenttemplateommor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


