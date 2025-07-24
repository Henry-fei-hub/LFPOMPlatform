package pomplatform.common.utils;

public class CommonUtils {

	public static String getCompanyShortName(Integer id) {
		String companyName = "杰恩";
		if (id == null)
			return companyName;
		switch (id) {
		case 0:
			companyName = "杰恩";
			break;
		case 1:
			companyName = "博普森";
			break;
		case 2:
			companyName = "姜峰";
			break;
		case 3:
			companyName = "杰加";
			break;
		case 4:
			companyName = "武汉";
			break;
		case 5:
		case 13:
			companyName = "上海";
			break;
		case 6:
		case 12:
			companyName = "北京";
			break;
		case 7:
		case 10:
			companyName = "大连";
			break;
		case 8:
			companyName = "杰拓";
			break;
		case 9:
			companyName = "香港";
			break;
		case 14:
			companyName = "角立杰出";
			break;
		}
		return companyName;
	}

	public static String getReimbursementFeeType(Integer id) {
		String feeType = "部门费用";
		if (id == null)
			return feeType;
		switch (id) {
		case 0:
			feeType = "部门费用";
			break;
		case 1:
			feeType = "行政费用";
			break;
		case 2:
			feeType = "人资费用";
			break;
		case 3:
			feeType = "品牌部费用";
			break;
		}
		return feeType;
	}
	
	public static String getLeaveType(Integer id) {
		String leaveType = "暂无";
		if (id == null)
			return leaveType;
		switch (id) {
		case 1:
			leaveType = "产假";
			break;
		case 6:
			leaveType = "产检假";
			break;
		case 7:
			leaveType = "陪护假";
			break;
		case 8:
			leaveType = "婚假";
			break;
		case 9:
			leaveType = "丧假";
			break;
		case 12:
			leaveType = "计划生育假";
			break;
		case 19:
			leaveType = "事假";
			break;
		case 20:
			leaveType = "病假";
			break;
		case 21:
			leaveType = "调休";
			break;
		case 22:
			leaveType = "年假";
			break;
		case 23:
			leaveType = "其他假期";
			break;
		}
		return leaveType;
	}
	
	public static void cutStringWithLength(StringBuilder sb, String str, Integer contentLength) {
		if (null != sb && null != str && null != contentLength && contentLength > 0) {
			if (str.length() < contentLength) {
				sb.append(str);
				int length = contentLength - str.length();
				if (length > 0) {
					for (int i = 0; i < length; i++) {
						sb.append("　");
					}
				}
			} else {
				sb.append(str.substring(0, contentLength - 1)).append("　");
			}
		}
	}
	
	public static Integer getFileType(String fileExtension) {
		if (null == fileExtension)
			return null;
		fileExtension = fileExtension.toLowerCase();
		switch (fileExtension) {
		case "xlsx":
		case "xlsm":
		case "xlsb":
		case "xls":
		case "xltx":
		case "xltm":
		case "xlt":
		case "csv":
		case "xlam":
		case "xla":
			return StaticUtils.FILE_TYPE_EXCEL;
		case "docx":
		case "docm":
		case "doc":
		case "dotx":
		case "dotm":
		case "dot":
			return StaticUtils.FILE_TYPE_WORD;
		case "pdf":
			return StaticUtils.FILE_TYPE_PDF;
		case "txt":
			return StaticUtils.FILE_TYPE_TXT;
		case "jpg":
		case "jpeg":
		case "png":
		case "gif":
		case "bmp":
			return StaticUtils.FILE_TYPE_IMAGE;
		case "mp3":
			return StaticUtils.FILE_TYPE_VOICE;
		case "ppt":
		case "pptx":
		case "pptm":
		case "potx":
		case "potm":
		case "pot":
		case "ppsx":
		case "ppsm":
		case "pps":
		case "ppam":
		case "ppa":
			return StaticUtils.FILE_TYPE_PPT;
		case "dwg":
		case "dwt":
		case "dxf":
		case "dws":
			return StaticUtils.FILE_TYPE_CAD;
		case "exe":
			return StaticUtils.FILE_TYPE_EXE;
		case "zip":
		case "rar":
		case "7z":
		case "bzip2":
		case "gzip":
		case "tar":
		case "wim":
		case "xz":
		case "arj":
		case "z":
			return StaticUtils.FILE_TYPE_ZIP;
		case "aiff":
		case "avi":
		case "mov":
		case "mpeg":
		case "mpg":
		case "qt":
		case "ram":
		case "viv":
		case "dat":
		case "ra":
		case "rm":
		case "rmvb":
		case "wmv":
		case "asf":
		case "vob":
		case "mp4":
		case "flv":
			return StaticUtils.FILE_TYPE_VIDEO;
		default:
			return StaticUtils.FILE_TYPE_UNKNOWN;
		}
	}
}
