package pomplatform.taskmanage.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.pomplatform.db.bean.BaseCwdTaskTemplate;
import com.pomplatform.db.bean.BaseCwdTaskTemplateDependence;
import com.pomplatform.db.bean.BaseCwdTaskTemplateDetail;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.dao.CwdTaskTemplate;
import com.pomplatform.db.dao.CwdTaskTemplateDependence;
import com.pomplatform.db.dao.CwdTaskTemplateDetail;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.GenericUploadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CustomTaskManageProcess implements GenericProcessor, GenericUploadProcessor{
	
	/**
	 * 上传任务模板
	 */
	private final static String UPLOAD_TASK_TEMPLATE = "uploadTaskTemplate";
	
	private final static String DELETE_TASK_TEMPLATE = "deleteTaskTemplate";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case DELETE_TASK_TEMPLATE:
				return deleteTaskTemplate(result);
			}
		}
		return null;
	}
	
	/**
	 * 删除任务模板
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String deleteTaskTemplate(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = null;
		BaseCwdTaskTemplate bean = new BaseCwdTaskTemplate();
		bean.setDataFromMap(params);
		CwdTaskTemplate ttDao = new CwdTaskTemplate();
		ttDao.setPrimaryKeyFromBase(bean);
		if(ttDao.load()){
			ttDao.delete();
			int cwdTaskTemplateId = ttDao.getCwdTaskTemplateId();
			//删除依赖
			CwdTaskTemplateDependence tdpDao = new CwdTaskTemplateDependence();
			tdpDao.setConditionCwdTaskTemplateId("=", cwdTaskTemplateId);
			tdpDao.conditionalDelete();
			//删除详情
			CwdTaskTemplateDetail tdDao = new CwdTaskTemplateDetail();
			tdDao.setConditionCwdTaskTemplateId("=", cwdTaskTemplateId);
			tdDao.conditionalDelete();
		}
		
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}

	@Override
	public String execute(String creteria, HttpServletRequest request, List<FileItem> items) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        String opt_type = BaseHelpUtils.getStringValue(params, "opt_type");
        String errorMesg = "";
        BaseCollection bc = new BaseCollection();
        File fullName = File.createTempFile("DelicacyUploadFiles", UUID.randomUUID().toString());
        if(items.size() > 0){
        	FileItem fileItem = items.get(0);
            fileItem.write(fullName);
            switch (opt_type) {
    		case UPLOAD_TASK_TEMPLATE:
    			return uploadTaskTemplate(fullName, params);
    		default:
    			break;
    		}
            
        }
        return bc.toJSON(-1, errorMesg);
	}
	
	private static String uploadTaskTemplate(File file, Map<String,Object> param) throws Exception {
		int status = 1;
		BaseCollection<BaseNormalReimbursementLinkProject> bc = new BaseCollection<>();
        
        //模板基础信息
        Map<String, Object> baseInfo = new HashMap<String, Object>();
        //任务模板详情数据
        List<Map<String, Object>> detailList = new ArrayList<>();
        
        // 把一张xls的数据表读到wb里
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        // 获取sheet数
        int count = workbook.getNumberOfSheets(); 
        //初始化行数
        int countRow;
        StringBuilder log = new StringBuilder("错误信息提示<br/>");
        int allerror = 0;
        //当前时间
        Date currentDate = new Date();
        int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
        int departmentId = BaseHelpUtils.getIntValue(param, "departmentId");
        int companyId = BaseHelpUtils.getIntValue(param, "companyId");
        String companyNo = BaseHelpUtils.getStringValue(param, "companyNo");
        
        if(count > 0){//默认取第一个sheet做处理
            // 一般一个excel文件会有三个工作表，这里默认读取第一页
            Sheet sheet = workbook.getSheetAt(0);
            countRow = sheet.getLastRowNum();
            //设置主数据
        	CwdTaskTemplate ttDao = new CwdTaskTemplate();
            //获取基础信息
            if(countRow > 7){
            	String templateName = getCellText(sheet, 1, 1);
            	baseInfo.put("templateName", getCellText(sheet, 1, 1));
            	if(!BaseHelpUtils.isNullOrEmpty(templateName)){
            		ttDao.setConditionTemplateName("=", templateName);
            		if(ttDao.countRows() > 0){
            			throw new SQLException("模板名称重复");
            		}
            	}
            	
            	baseInfo.put("projectLevel", getCellText(sheet, 2, 1));
            	baseInfo.put("projectArea", getCellText(sheet, 3, 1));
            	baseInfo.put("numberOfParticipant", getCellText(sheet, 4, 1));
            	baseInfo.put("numberOfDay", getCellText(sheet, 5, 1));
            	baseInfo.put("operator", employeeId);
            	baseInfo.put("departmentId", departmentId);
            	baseInfo.put("companyId", companyId);
            	baseInfo.put("companyNo", companyNo);
            }
            //根据行号 存储的EXCEL数据
    		Map<Integer, Map<String, Object>> excelRowMap = new HashMap<>();
            //获取详细数据
            if(countRow > 10){
            	int rowIndex = 10;
            	// 初始化列数
            	int countCol = 8;
            	
            	for (int i = rowIndex; i < countRow; i++) {
                    Row row = sheet.getRow(i);
                    if (BaseHelpUtils.isNullOrEmpty(row)) {
                        break;
                    }
                    //获取每一行的列数
                    if(row.getLastCellNum() < 8){
                    	break;
                    }
                    Map<String, Object> params = new HashMap<>();
                    params.put("orderNum", i - 9);
                    params.put("excelNum", i + 1);
                    for (int j = 0; j < countCol; j++) {
                        // 创建一个列单元对象
                        Cell cell = row.getCell(j);
                        if (!BaseHelpUtils.isNullOrEmpty(cell)) {
                            switch (j) {
                                case 0:
                                	cell.setCellType(Cell.CELL_TYPE_STRING);
                                	params.put("taskType", BaseHelpUtils.getString(cell.toString().trim()));
                                    break;
                                case 1:
                                	cell.setCellType(Cell.CELL_TYPE_STRING);
                                	params.put("taskName", BaseHelpUtils.getString(cell.toString().trim()));
                                	break;
                                case 2:
                                	cell.setCellType(Cell.CELL_TYPE_STRING);
                                	params.put("parentIdStr", BaseHelpUtils.getString(cell.toString().trim()));
                                	break;
                                case 3:
                                	cell.setCellType(Cell.CELL_TYPE_STRING);
                                	params.put("predecessorTask", BaseHelpUtils.getString(cell.toString().trim()));
                                	break;
                                case 4:
                                	cell.setCellType(Cell.CELL_TYPE_STRING);
                                	params.put("numberOfDay", BaseHelpUtils.getIntValue(cell.toString().trim()));
                                	break;
                                case 5:
                                	cell.setCellType(Cell.CELL_TYPE_STRING);
                                	params.put("taskLevel", BaseHelpUtils.getString(cell.toString().trim()));
                                	break;
                                case 6:
                                	cell.setCellType(Cell.CELL_TYPE_STRING);
                                	params.put("taskContent", BaseHelpUtils.getString(cell.toString().trim()));
                                	break;
                                case 7:
                                	cell.setCellType(Cell.CELL_TYPE_STRING);
                                	params.put("taskDemand", BaseHelpUtils.getString(cell.toString().trim()));
                                	break;
                                default:
                                    break;
                            }
                        }
                    }
                    if(!BaseHelpUtils.isNullOrEmpty(BaseHelpUtils.getStringValue(params, "taskType"))
                    		&& !BaseHelpUtils.isNullOrEmpty(BaseHelpUtils.getStringValue(params, "taskName"))){
                    	excelRowMap.put(i + 1, params);
        				detailList.add(params);
                    }
                    
                }
            }
            if(detailList.size() > 0){
            	BaseCwdTaskTemplate ttBean = new BaseCwdTaskTemplate();
            	String projectLevel = BaseHelpUtils.getString(baseInfo.get("projectLevel"));
            	
            	if(!BaseHelpUtils.isNullOrEmpty(projectLevel)){
            		SystemDictionary sdDao = new SystemDictionary();
                	sdDao.setConditionDicTypeId("=", 178);
                	sdDao.setConditionDicTypeValue("like", "%" + projectLevel + "%");
                	if(null != sdDao.executeQueryOneRow()){
                		baseInfo.put("projectLevel", sdDao.getDicTypeValueId());
                	}else{
                		baseInfo.remove("projectLevel");
                	}
            	}
            	ttBean.setDataFromMap(baseInfo);
            	ttBean.setCreateTime(currentDate);
            	ttDao.setDataFromBase(ttBean);
            	int saveNum = ttDao.save();
            	if(saveNum > 0){
            		CwdTaskTemplateDetail tdDao = new CwdTaskTemplateDetail();
            		CwdTaskTemplateDependence tdpDao = new CwdTaskTemplateDependence();
            		
            		int cwdTaskTempleteId = ttDao.getCwdTaskTemplateId();
            		//模板子表数据
            		List<BaseCwdTaskTemplateDetail> tdList = new ArrayList<>();
            		//模板依赖数据
            		List<BaseCwdTaskTemplateDependence> tdpList = new ArrayList<>();
            		
            		for (Map<String, Object> map : detailList) {
            			String taskType = BaseHelpUtils.getStringValue(map, "taskType");
            			switch (taskType) {
						case "业态":
							map.put("taskType", 1);
							break;
						case "专业":
							map.put("taskType", 2);
							break;
						case "阶段":
							map.put("taskType", 3);
							break;
						case "任务":
							map.put("taskType", 4);
							break;
						default:
							map.put("taskType", null);
							break;
						}
            			String taskLevel = BaseHelpUtils.getStringValue(map, "taskLevel");
            			switch (taskLevel) {
						case "普通":
							map.put("taskLevel", 1);
							break;
						case "紧急":
							map.put("taskLevel", 2);
							break;	
						case "非常紧急":
							map.put("taskLevel", 3);
							break;	
						default:
							map.put("taskLevel", 1);
							break;
						}
            			BaseCwdTaskTemplateDetail tdBean = new BaseCwdTaskTemplateDetail();
            			tdBean.setDataFromMap(map);
            			tdBean.setCwdTaskTemplateId(cwdTaskTempleteId);
            			tdList.add(tdBean);
					}
            		if(tdDao.save(tdList) > 0){
            			//查询出插入后的所有数据
            			tdDao.clear();
            			tdDao.setConditionCwdTaskTemplateId("=", cwdTaskTempleteId);
            			
            			//根据排序值设置的数据
            			Map<Integer, BaseCwdTaskTemplateDetail> orderNumMap = new HashMap<>();
            			List<BaseCwdTaskTemplateDetail> returnTdList = tdDao.conditionalLoad();
            			for (BaseCwdTaskTemplateDetail baseCwdTaskTemplateDetail : returnTdList) {
            				orderNumMap.put(baseCwdTaskTemplateDetail.getOrderNum(), baseCwdTaskTemplateDetail);
						}
            			
            			//封装依赖数据与设置父级任务主键
            			for (Map<String, Object> map : detailList) {
            				//获取父级ID
            				int ownOrderNum = BaseHelpUtils.getIntValue(map, "orderNum");
            				BaseCwdTaskTemplateDetail ownBean = orderNumMap.get(ownOrderNum);
            				int ownId = ownBean.getCwdTaskTemplateDetailId();
            				int parentId = 0;
            				int parentRow = BaseHelpUtils.getIntValue(map, "parentIdStr");
            				Map<String, Object> parentMap = excelRowMap.get(parentRow);
            				if(null != parentMap){
            					int parentOrderNum = BaseHelpUtils.getIntValue(parentMap, "orderNum");
            					BaseCwdTaskTemplateDetail parentBean = orderNumMap.get(parentOrderNum);
            					if(null != parentBean){
            						parentId = parentBean.getCwdTaskTemplateDetailId();
            					}
            				}
            				//更新父级任 务
            				tdDao.clear();
            				tdDao.setConditionCwdTaskTemplateDetailId("=", ownId);
            				tdDao.setParentId(parentId);
            				tdDao.conditionalUpdate();
            				
            				//处理前置任务
            				if(null != map.get("predecessorTask")){
            					String predecessorTask = BaseHelpUtils.getString(map.get("predecessorTask"));
            					if(!BaseHelpUtils.isNullOrEmpty(predecessorTask)){
            						predecessorTask = predecessorTask.replaceAll("，", ",").replaceAll(" ", "");
            						String [] predecessorTaskArra = predecessorTask.split(",");
            						for (String string : predecessorTaskArra) {
            							int preRow = BaseHelpUtils.getIntValue(string);
            							Map<String, Object> preMap = excelRowMap.get(preRow);
            							
            							if(null != preMap){
            								int preOrderNum = BaseHelpUtils.getIntValue(preMap, "orderNum");
            								BaseCwdTaskTemplateDetail preBean = orderNumMap.get(preOrderNum);
            								if(null != preBean){
            									BaseCwdTaskTemplateDependence tdpBean = new BaseCwdTaskTemplateDependence();
                    							tdpBean.setCwdTaskTemplateId(cwdTaskTempleteId);
                    							tdpBean.setSuccessorTaskId(ownId);
                    							tdpBean.setPredecessorTaskId(preBean.getCwdTaskTemplateDetailId());
                    							tdpList.add(tdpBean);
            								}
            							}
									}
            								
            					}
            				}
						}  
            			if(tdpList.size() > 0){
            				tdpDao.save(tdpList);
            			}
            		}
            		
            	}
            	
            }
        }
        if (allerror > 0) {
        	status = 2;
            log.append("<br/>总共：").append(allerror).append("条没有导入").append("<br/>原因：根据项目编号没有匹配到ERP系统的项目");
        } 
        return bc.toJSON(status, log.toString());
	}
	
	private static String getCellText(Sheet sheet, int y, int x){
		if(null != sheet && null != sheet.getRow(y)){
			Cell cell = sheet.getRow(y).getCell(x);
			if(null != cell){
				cell.setCellType(Cell.CELL_TYPE_STRING);
				return BaseHelpUtils.getString(cell.toString().trim());
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) throws Exception {
//		uploadTaskTemplate(new File("D://项目任务模板.xlsx"), new HashMap<>());
	}
}
