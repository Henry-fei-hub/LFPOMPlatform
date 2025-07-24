package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadProjectEmpAndStage;
import pomplatform.project.bean.BaseOnLoadProjectEmpAndStageListDetail;
import pomplatform.project.bean.BaseOnLoadProjectEmpAndStageWithB;
import pomplatform.project.bean.ConditionOnLoadProjectEmpAndStage;
import pomplatform.project.query.QueryOnLoadProjectEmpAndStage;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class OnLoadProjectEmpAndStageWithBHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectEmpAndStageWithBHandler.class);

	public static BaseCollection<BaseOnLoadProjectEmpAndStageWithB> executeQueryOnLoadProjectEmpAndStage(ConditionOnLoadProjectEmpAndStage c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectEmpAndStage dao = new QueryOnLoadProjectEmpAndStage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectEmpAndStage> collection = dao.executeQuery( c.getKeyValues(), c);
		List<BaseOnLoadProjectEmpAndStageWithB> collections =new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(collection)&&collection.getCollections().size()>0) {
			List<BaseOnLoadProjectEmpAndStage> list = collection.getCollections();
			Map<Integer,BaseOnLoadProjectEmpAndStageWithB> map = new HashMap<>();
			for (BaseOnLoadProjectEmpAndStage base : list) {
				int employeeId = BaseHelpUtils.getIntValue(base.getEmployeeId());
				int gradeId = BaseHelpUtils.getIntValue(base.getGradeId());
				String employeeNo = base.getEmployeeNo();
				String employeeName = base.getEmployeeName();
				int status = BaseHelpUtils.getIntValue(base.getStatus());
				int projectId = BaseHelpUtils.getIntValue(base.getProjectId());
				int stageId = BaseHelpUtils.getIntValue(base.getStageId());
				BigDecimal planIntegral = BaseHelpUtils.getBigDecimalValue(base.getPlanIntegral());
				BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(base.getSureIntegral());
				BigDecimal lastPlanIntegral = BaseHelpUtils.getBigDecimalValue(base.getAlternateField1());
				//如果已经存在则不重复new
				if(!BaseHelpUtils.isNullOrEmpty(map.get(employeeId))) {
					BaseOnLoadProjectEmpAndStageWithB projectEmpAndStageWithB = map.get(employeeId);
					projectEmpAndStageWithB.setPlanTotal(BaseHelpUtils.getBigDecimalValue(projectEmpAndStageWithB.getPlanTotal()).add(planIntegral));
					projectEmpAndStageWithB.setSureIntegral(BaseHelpUtils.getBigDecimalValue(projectEmpAndStageWithB.getSureIntegral()).add(sureIntegral));
					List<BaseOnLoadProjectEmpAndStageListDetail> detailList = projectEmpAndStageWithB.getStageDetail();
					BaseOnLoadProjectEmpAndStageListDetail detail =new BaseOnLoadProjectEmpAndStageListDetail();
					detail.setStageId(stageId);
					detail.setPlanIntegral(planIntegral);
					detail.setSureIntegral(sureIntegral);
					detail.setAlternateField1(lastPlanIntegral+"");
					detail.setStatus(status);
					detailList.add(detail);
					projectEmpAndStageWithB.setStageDetail(detailList);
					map.put(employeeId, projectEmpAndStageWithB);
				}else {
					BaseOnLoadProjectEmpAndStageWithB projectEmpAndStageWithB  =new BaseOnLoadProjectEmpAndStageWithB();
					projectEmpAndStageWithB.setEmployeeId(employeeId);
					projectEmpAndStageWithB.setGradeId(gradeId);
					projectEmpAndStageWithB.setEmployeeNo(employeeNo);
					projectEmpAndStageWithB.setEmployeeName(employeeName);
					projectEmpAndStageWithB.setPlanTotal(planIntegral);
					projectEmpAndStageWithB.setSureIntegral(sureIntegral);
					List<BaseOnLoadProjectEmpAndStageListDetail> detailList =new ArrayList<>();
					BaseOnLoadProjectEmpAndStageListDetail detail =new BaseOnLoadProjectEmpAndStageListDetail();
					detail.setStageId(stageId);
					detail.setPlanIntegral(planIntegral);
					detail.setSureIntegral(sureIntegral);
					detail.setAlternateField1(lastPlanIntegral+"");
					detail.setStatus(status);
					detailList.add(detail);
					projectEmpAndStageWithB.setStageDetail(detailList);
					map.put(employeeId, projectEmpAndStageWithB);
				}
			}
			for(Integer empId : map.keySet()){
				collections.add(map.get(empId));
			}
		}
		BaseCollection<BaseOnLoadProjectEmpAndStageWithB> result =new BaseCollection<>();
		result.setCollections(collections);
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectEmpAndStage c = new ConditionOnLoadProjectEmpAndStage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectEmpAndStageWithB> result = executeQueryOnLoadProjectEmpAndStage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectEmpAndStage> result;
		ConditionOnLoadProjectEmpAndStage c = new ConditionOnLoadProjectEmpAndStage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectEmpAndStage dao = new QueryOnLoadProjectEmpAndStage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectEmpAndStage.ALL_CAPTIONS);
			for(BaseOnLoadProjectEmpAndStage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
	public static void main(String[] args) throws Exception {
		OnLoadProjectEmpAndStageWithBHandler a =new OnLoadProjectEmpAndStageWithBHandler();
		ConditionOnLoadProjectEmpAndStage condition =new  ConditionOnLoadProjectEmpAndStage();
		condition.setProjectId(6257);
		condition.setEmployeeId(79);
		BaseCollection<BaseOnLoadProjectEmpAndStageWithB> list =a.executeQueryOnLoadProjectEmpAndStage(condition, null);
		List<BaseOnLoadProjectEmpAndStageWithB> collections = list.getCollections();
		for (BaseOnLoadProjectEmpAndStageWithB baseOnLoadProjectEmpAndStageWithB : collections) {
			System.out.println(baseOnLoadProjectEmpAndStageWithB.toString());
		}
	}

}


