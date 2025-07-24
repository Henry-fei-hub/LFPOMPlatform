package com.pomplatform.client;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DES;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.*;
import com.delicacy.client.process.EmployeeWithRF;
import com.delicacy.client.ui.DelicacyMenuMain;
import com.delicacy.client.ui.PopupWindow;
import com.delicacy.client.ui.SideMunuTree;
import com.delicacy.client.ui.UserModifyPwd;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.pomplatform.client.common.PomPlatformClientUtil;
import com.pomplatform.client.contract.panel.ScontractccorPanel;
import com.pomplatform.client.data.POMPlatformMenu;
import com.pomplatform.client.data.RoleDefinition;
import com.pomplatform.client.data.WorkflowProcessors;
import com.pomplatform.client.departmentdirector.panel.MDepartmentDirectorPanel;
import com.pomplatform.client.designer.panel.DesignWorkPanel;
import com.pomplatform.client.employeenew.panel.MemployeePanel;
import com.pomplatform.client.managementteamproject.panel.MManagementTeamProjectPanel;
import com.pomplatform.client.operation.panel.OperationManagerPanel;
import com.pomplatform.client.operation.panel.ProjectManagerPanel;
import com.pomplatform.client.project.panel.SprojectManagerPanel;
import com.pomplatform.client.reimbursement.panel.SearchReimbursementInfoPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TabBarControls;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.menu.IMenuButton;
import com.smartgwt.client.widgets.menu.IconMenuButton;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuBar;
import com.smartgwt.client.widgets.menu.events.ItemClickEvent;
import com.smartgwt.client.widgets.menu.events.ItemClickHandler;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.tab.events.TabSelectedEvent;
import com.smartgwt.client.widgets.tab.events.TabSelectedHandler;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.tree.TreeNode;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Main entry point.
 *
 * @author lxf
 */
public class POMPlatform extends DelicacyMenuMain {

    private static final Logger logger = Logger.getLogger("");
    private static LoginWindow loginWindow;
    private final static String LOAD_CONFIG_OPERATION = "EP_OnCommonProcess";

    private final static String MENU_BORDER = "1px solid rgb(134, 134, 134)";

    /**
     * Creates a new instance of MainEntryPoint
     */
    public POMPlatform() {
    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        ClientUtil.setApplicationID(1);
        DelicacyMenuData.appendMenuProcessor(new POMPlatformMenu());
        WorkflowProcessors.initTables();
        onLoadSystemConfigInfo();
        super.onModuleLoad();
    }

    @Override
    public void openLoginWindow() {
        loginWindow = new LoginWindow("");
        loginWindow.setEntry(this);
        if (needLogin) {
            String code = Window.Location.getParameter("code");
            if (null != code && !"".equals(code.trim())) {
                try {
                    qucickLogin();
                } catch (Exception e) {
                    loginWindow.show();
                    loginWindow.bringToFront();
                }

            } else {
                loginWindow.show();
                loginWindow.bringToFront();
            }

        }
    }

    /**
     * 加载系统配置信息数据集
     */
    private void onLoadSystemConfigInfo() {
        Map<String, Object> param = new HashMap<>();
        param.put("optType", "onLoadSystemConfigInfo");
        DBDataSource.callOperation(LOAD_CONFIG_OPERATION, "find", param, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    logger.info("Load system config successful .......");
                } else {
                    logger.info("Load system config failure .......");
                }
            }
        });
    }

    /**
     * 快捷登录方法
     *
     * @throws java.lang.Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void qucickLogin() throws Exception {
        Map param = new LinkedHashMap();
        param.put("code", Window.Location.getParameter("code"));
        param.put("loginType", 2);

        String message = MapUtils.toJSON(param);
        DES des = new DES(DBDataSource.PUBLIC_KEY);

        //新登录方法 
        DBDataSource.callOperation("EP_EmployeeLogin", "login", des.ENC(message), new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    BCollection<EmployeeWithRF> bc = new BCollection<>();
                    Storage sta = Storage.getLocalStorageIfSupported();
                    if (sta != null) {
                        sta.setItem("EMPLOYEEINFO", bc.toJSON());
                    }
                    Record result = dsResponse.getData()[0];
                    String employeeNo = result.getAttribute("employeeNo");
                    String employeeName = result.getAttribute("employeeName");
                    String[] privileges = result.getAttributeAsStringArray("functions");
                    String agency = result.getAttribute("agency");
                    String employeeId = result.getAttribute("employeeId");
                    String departmentId = result.getAttribute("departmentId");
                    String roleTypeId = result.getAttribute("roleId");
                    String plateId = result.getAttribute("plateId");
                    String companyId = result.getAttribute("companyId");
                    String dutyId = result.getAttribute("dutyId");
                    String photo = result.getAttribute("photo");
                    HttpCookie hc = new HttpCookie();
                    hc.setOperatorId(ClientUtil.checkAndGetIntValue(result.getAttribute("employeeId")));
                    hc.setOperatorName(result.getAttribute("employeeName"));
                    hc.setOperatorNo(result.getAttribute("employeeNo"));
                    hc.setDepartmentId(ClientUtil.checkAndGetIntValue(result.getAttribute("departmentId")));
                    hc.setRoleTypeId(ClientUtil.checkAndGetIntValue(result.getAttribute("roleId")));
                    hc.setPlateId(ClientUtil.checkAndGetIntValue(plateId));
                    hc.setHeadImg(photo);
                    hc.setToCookies();
                    StringBuilder sb = new StringBuilder();
                    if (privileges != null) {
                        for (int i = 0; i < privileges.length; i++) {
                            if (i > 0) {
                                sb.append(",");
                            }
                            sb.append(privileges[i]);
                        }
                    }
                    setCookies(employeeNo, employeeName, sb.toString(), agency, employeeId, departmentId, roleTypeId, plateId, companyId, dutyId, photo);

                    loginWindow.hide();

                    drawMainLayout();

                } else {
                    loginWindow.show();
                    loginWindow.bringToFront();
//                    Map errors = dsResponse.getErrors();
//                    SC.say("Quick login failure" + errors.get("errorMsg"));
                }
            }
        });
    }

    /**
     * 设置Cookie
     *
     * @param employeeno
     * @param employee
     * @param privilege
     * @param agency
     * @param employeeId
     * @param departmentId
     * @param roleTypeId
     */
    protected void setCookies(String employeeno, String employee, String privilege, String agency, String employeeId,
            String departmentId, String roleTypeId, String plateId, String companyId, String dutyId, String headImg) {
        Date expires = new Date(System.currentTimeMillis() + LoginLayout.DAY_TIMEMILLIS*60);
        Storage sta = Storage.getLocalStorageIfSupported();
        if (sta != null) {
            sta.setItem(ClientUtil.PRIVILEGE_COOKIE, privilege);
            if (agency != null && agency.length() > 0) {
                sta.setItem(ClientUtil.AGENCY_COOKIE, agency);
            } else {
                sta.removeItem(ClientUtil.AGENCY_COOKIE);
            }
            sta.setItem(ClientUtil.LAST_USED_TIME, String.valueOf(System.currentTimeMillis() + LoginLayout.DAY_TIMEMILLIS));
            
            //向LocalStorage设置基础数据
            sta.setItem(ClientUtil.OPRERATORNO_COOKIE, employeeno);
            sta.setItem(ClientUtil.OPRERATORID_COOKIE, employeeId);
            sta.setItem(ClientUtil.OPRERATORNAME_COOKIE, employee);
            sta.setItem(ClientUtil.OPRERATOR_DEPARTMENTID_COOKIE, departmentId);
            sta.setItem(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE, roleTypeId);
            sta.setItem(ClientUtil.OPRERATOR_PLATEID_COOKIE, plateId);
            sta.setItem(ClientUtil.COMPANYID_COOKIE, companyId);
            sta.setItem(ClientUtil.DUTY_ID_COOKIE, dutyId);
            sta.setItem(ClientUtil.HEAD_IMG, headImg);
        } else {
            Cookies.setCookie(ClientUtil.PRIVILEGE_COOKIE, privilege, expires);
            if (agency != null && agency.length() > 0) {
                Cookies.setCookie(ClientUtil.AGENCY_COOKIE, agency, expires);
            } else {
                Cookies.removeCookie(ClientUtil.AGENCY_COOKIE);
            }
        }

        Cookies.setCookie(ClientUtil.OPRERATORNO_COOKIE, employeeno, expires);
        Cookies.setCookie(ClientUtil.OPRERATORID_COOKIE, employeeId, expires);
        Cookies.setCookie(ClientUtil.OPRERATORNAME_COOKIE, employee, expires);
        Cookies.setCookie(ClientUtil.OPRERATOR_DEPARTMENTID_COOKIE, departmentId, expires);
        Cookies.setCookie(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE, roleTypeId, expires);
        Cookies.setCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE, plateId, expires);
        Cookies.setCookie(ClientUtil.COMPANYID_COOKIE, companyId, expires);
        Cookies.setCookie(ClientUtil.DUTY_ID_COOKIE, dutyId, expires);
        Cookies.setCookie(ClientUtil.HEAD_IMG, headImg, expires);

    }

    @Override
    public void drawMainLayout() {
        // 主布局
        mainLayout = new VLayout() {
            @Override
            protected void onInit() {
                super.onInit();
                if (initToken.length() != 0) {
                    onHistoryChanged(initToken);
                }
            }
        };
        // 设置主布局的样式
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        
        MenuBar menuBar = new MenuBar();

        // 如果是移动设备，我们希望在导航页面下面显示工具栏，一般包括修改密码，重新登录等功能按钮
        // 如果是桌面系统，我们会把这些按钮放置在功能显示容器的TabBarControls中
//        ToolStrip tools = generateTopStrip(menuBar);
        ToolStrip tools = generateTopStrip();
        mainLayout.addMember(tools);

        //中心主体栏
        HLayout centerLayout = new HLayout();
        centerLayout.setHeight("97%");
        centerLayout.setWidth100();
        mainLayout.addMember(centerLayout);

        sidemunu = new SideMunuTree();
        sidemunu.setMenuData();
        final VLayout leftLayout = new VLayout();
        leftLayout.setHeight100();
        leftLayout.setWidth("10%");
        leftLayout.setBackgroundColor("#F2F2F2");
        
        centerLayout.addMember(leftLayout);

        Menu[] menus = new Menu[11];
        
        //人资管理
        Menu hrManagmentMenu = sidemunu.getMenu("hr_managment");
        hrManagmentMenu.setTitle("人资管理");
        hrManagmentMenu.setIconBodyStyleName("customIconClass");
        menus[0] = hrManagmentMenu;
        IconMenuButton hrManagment = new IconMenuButton("&nbsp;&nbsp;人资管理", hrManagmentMenu);
        hrManagment.setIconStyle("vertical-align: middle;");
        hrManagment.setIcon("menuicons/icon-ziyuan2.png");
        hrManagment.setBorder(MENU_BORDER);
        hrManagment.setMenuIconWidth(16);
        hrManagment.setMenuIconHeight(16);
        hrManagment.setShowMenuOnClick(true);
        hrManagment.setWidth100();
        hrManagment.setHeight(40);
        hrManagment.setStyleName("color:red;align:center;border:1px");
        hrManagmentMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(hrManagment);
        //营销管理
        Menu marketManagmentMenu = sidemunu.getMenu("market_managment");
        marketManagmentMenu.setTitle("营销管理");
        menus[1] = marketManagmentMenu;
        IconMenuButton marketManagment = new IconMenuButton("&nbsp;&nbsp;营销管理", marketManagmentMenu);
        marketManagment.setIcon("menuicons/icon-yingxiaoguanli01.png");
        marketManagment.setBorder(MENU_BORDER);
        marketManagment.setShowMenuOnClick(true);
        marketManagment.setWidth100();
        marketManagment.setHeight(40);
        marketManagmentMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(marketManagment);
        //运营管理
        Menu operateManagmentMenu = sidemunu.getMenu("operate_managment");
        operateManagmentMenu.setTitle("运营管理");
        menus[2] = operateManagmentMenu;
        IconMenuButton operateManagment = new IconMenuButton("&nbsp;&nbsp;运营管理", operateManagmentMenu);
        operateManagment.setIcon("menuicons/icon-yunyingguanli.png");
        operateManagment.setBorder(MENU_BORDER);
        operateManagment.setShowMenuOnClick(true);
        operateManagment.setWidth100();
        operateManagment.setHeight(40);
        operateManagmentMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(operateManagment);
        //财务管理
        Menu K3ManagmentMenu = sidemunu.getMenu("K3_managment");
        K3ManagmentMenu.setTitle("财务管理");
        menus[3] = K3ManagmentMenu;
        IconMenuButton K3Managment = new IconMenuButton("&nbsp;&nbsp;财务管理", K3ManagmentMenu);
        K3Managment.setIcon("menuicons/icon-caiwuguanli_erji.png");
        K3Managment.setShowMenuOnClick(true);
        K3Managment.setWidth100();
        K3Managment.setBorder(MENU_BORDER);
        K3Managment.setHeight(40);
        K3ManagmentMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(K3Managment);
        //报表管理
        Menu reportManagementMenu = sidemunu.getMenu("report_management");
        reportManagementMenu.setTitle("报表管理");
        menus[4] = reportManagementMenu;
        IconMenuButton reportManagement = new IconMenuButton("&nbsp;&nbsp;报表管理", reportManagementMenu);
        reportManagement.setIcon("menuicons/icon-baobiaoguanli.png");
        reportManagement.setBorder(MENU_BORDER);
        reportManagement.setShowMenuOnClick(true);
        reportManagement.setWidth100();
        reportManagement.setHeight(40);
        reportManagementMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(reportManagement);
        
        // 供应链管理
        Menu purchaseManagmentMenu = sidemunu.getMenu("purchase_managment");
        purchaseManagmentMenu.setTitle("供应链管理");
        purchaseManagmentMenu.setIconBodyStyleName("customIconClass");
        menus[9] = purchaseManagmentMenu;
        IconMenuButton purchaseManagment = new IconMenuButton("&nbsp;&nbsp;供应链管理", purchaseManagmentMenu);
        purchaseManagment.setIconStyle("vertical-align: middle;");
        purchaseManagment.setIcon("menuicons/icon-baoxiaodan.png");
        purchaseManagment.setBorder(MENU_BORDER);
        purchaseManagment.setMenuIconWidth(16);
        purchaseManagment.setMenuIconHeight(16);
        purchaseManagment.setShowMenuOnClick(true);
        purchaseManagment.setWidth100();
        purchaseManagment.setHeight(40);
        purchaseManagment.setStyleName("color:red;align:center;border:1px");
        purchaseManagmentMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(purchaseManagment);
        
        //J&A官网
        Menu jaidManagementMenu = sidemunu.getMenu("jaid_management");
        jaidManagementMenu.setTitle("J&A官网");
        menus[5] = jaidManagementMenu;
        IconMenuButton jaidManagement = new IconMenuButton("&nbsp;&nbsp;J&A官网", jaidManagementMenu);
        jaidManagement.setIcon("menuicons/icon-guanwang.png");
        jaidManagement.setBorder(MENU_BORDER);
        jaidManagement.setShowMenuOnClick(true);
        jaidManagement.setWidth100();
        jaidManagement.setHeight(40);
        jaidManagementMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
//        leftLayout.addMember(jaidManagement);
        //CWD
        Menu cwdMenu = sidemunu.getMenu("cwd_menu");
        IconMenuButton cwdMenuButton = new IconMenuButton("&nbsp;&nbsp;协同设计管理", cwdMenu);
        cwdMenuButton.setIcon("menuicons/icon-m3-newCoordination-copy.png");
        cwdMenuButton.setBorder(MENU_BORDER);
        cwdMenuButton.setShowMenuOnClick(true);
        cwdMenuButton.setWidth100();
        cwdMenuButton.setHeight(40);
        cwdMenu.addItemClickHandler(new ItemClickHandler() {
        	@Override
        	public void onItemClick(ItemClickEvent event) {
        		TreeNode node = event.getTreeNode();
        		functionProcess(node);
        	}
        });
//        leftLayout.addMember(cwdMenuButton);
        //数据管理
        Menu basicDataManagmentMenu = sidemunu.getMenu("basic_data_managment");
        basicDataManagmentMenu.setTitle("数据管理");
        menus[6] = basicDataManagmentMenu;
        IconMenuButton basicDataManagment = new IconMenuButton("&nbsp;&nbsp;数据管理", basicDataManagmentMenu);
        basicDataManagment.setIcon("menuicons/OSS.png");
        basicDataManagment.setBorder(MENU_BORDER);
        basicDataManagment.setShowMenuOnClick(true);
        basicDataManagment.setWidth100();
        basicDataManagment.setHeight(40);
        basicDataManagmentMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(basicDataManagment);
        //流程管理
        Menu wfManagmentMenu = sidemunu.getMenu("wf_managment");
        wfManagmentMenu.setTitle("流程管理");
        menus[7] = wfManagmentMenu;
        IconMenuButton wfManagment = new IconMenuButton("&nbsp;&nbsp;流程管理", wfManagmentMenu);
        wfManagment.setIcon("menuicons/ee.png");
        wfManagment.setBorder(MENU_BORDER);
        wfManagment.setShowMenuOnClick(true);
        wfManagment.setWidth100();
        wfManagment.setHeight(40);
        wfManagmentMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(wfManagment);
        //系统管理
        Menu systemManagementMenu = sidemunu.getMenu("system_management");
        systemManagementMenu.setTitle("系统管理");
        menus[8] = systemManagementMenu;
        IconMenuButton systemManagement = new IconMenuButton ("&nbsp;&nbsp;系统管理", systemManagementMenu);
        systemManagement.setWidth100();
        systemManagement.setHeight(40);
        systemManagement.setIcon("menuicons/ff.png");
        systemManagement.setBorder(MENU_BORDER);
        systemManagement.setShowMenuOnClick(true);
        systemManagementMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        leftLayout.addMember(systemManagement);
        //My J&A
        Menu myselfManagementMenu = sidemunu.getMenu("myself_management");
        myselfManagementMenu.setTitle("My CUBE");
        menus[9] = myselfManagementMenu;
        IconMenuButton myselfManagement = new IconMenuButton("&nbsp;&nbsp;My CUBE", myselfManagementMenu);
        myselfManagement.setIcon("menuicons/logo_black.png");
        myselfManagement.setBorder(MENU_BORDER);
        myselfManagement.setEdgeImage("position: absolute; right: 8px; width: 18px; height: 18px;");
        myselfManagement.setIconAlign("vertical-align: middle;");
        myselfManagement.setIconStyle("vertical-align: middle;");
        myselfManagement.setShowMenuOnClick(true);
        myselfManagement.setWidth100();
        myselfManagement.setHeight(40);
        myselfManagementMenu.addItemClickHandler(new ItemClickHandler() {
            @Override
            public void onItemClick(ItemClickEvent event) {
                TreeNode node = event.getTreeNode();
                functionProcess(node);
            }
        });
        menuBar.setMenus(menus);
        leftLayout.addMember(myselfManagement);
        //中间箭头面板
        VLayout middleLayout = new VLayout();
        middleLayout.setWidth("2%");
        middleLayout.setHeight100();
        middleLayout.setAlign(Alignment.CENTER);
        final ImgButton openBtn = new ImgButton();
        openBtn.setSrc("left.png");
        openBtn.setWidth(24);
        openBtn.setHeight(24);
        openBtn.setShowRollOver(false);
        openBtn.setShowDownIcon(false);
        openBtn.setShowDown(false);
        openBtn.setPrompt("打开/关闭菜单栏");
        openBtn.setShowHover(true);
        openBtn.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String src = openBtn.getSrc();
                if (src.equals("left.png")) {
                    openBtn.setSrc("right.png");
                    leftLayout.setVisibility(Visibility.HIDDEN);
                } else {
                    openBtn.setSrc("left.png");
                    leftLayout.setVisibility(Visibility.VISIBLE);
                }
            }
        });
        middleLayout.addMember(openBtn);
        centerLayout.addMember(middleLayout);

        // 用来承载用户默认主页的面板
        mainPanel = new VLayout();
        mainPanel.setHeight100();
        mainPanel.setAlign(Alignment.CENTER);
        mainPanel.setAlign(VerticalAlignment.CENTER);
        mainPanel.setPadding(15);
        // 初始化功能显示区
        mainTabSet = new TabSet();
        // 设置功能显示区域的Tab为不能关闭
        mainTabSet.setCanCloseTabs(Boolean.FALSE);
        mainTabSet.setWidth("89%");
        Layout paneContainerProperties = new Layout();
        paneContainerProperties.setLayoutMargin(0);
        paneContainerProperties.setLayoutTopMargin(1);
        // 设置功能显示区域的样式
        mainTabSet.setPaneContainerProperties(paneContainerProperties);
        // 设置功能显示区的样式
        mainTabSet.setWidth100();
        mainTabSet.setHeight100();
        // 添加功能显示区域的改变功能处理程序
        mainTabSet.addTabSelectedHandler(new TabSelectedHandler() {
            @Override
            public void onTabSelected(TabSelectedEvent event) {
                Tab selectedTab = event.getTab();
                // 每个功能都有一个唯一历史标识码
                // 取出该功能的浏览历史标识码
                String historyToken = selectedTab.getAttribute("historyToken");
                // 如果浏览历史标识码为空，说明是默认主页
                if (historyToken != null) {
                    History.newItem(historyToken, false);
                } else {
                    History.newItem("main", false);
                }
            }
        });

        LayoutSpacer layoutSpacer = new LayoutSpacer();
        layoutSpacer.setWidth(5);
        // 设置功能显示分栏区域的控制按钮，有tab的滚动按钮，有tab的选取按钮还有一个5px宽的空白区域
        mainTabSet.setTabBarControls(TabBarControls.TAB_SCROLLER, TabBarControls.TAB_PICKER, layoutSpacer);
        // 创建每个tab的下拉菜单项，有关闭当前，关闭其他和关闭所有
        contextMenu = createContextMenu();

        centerLayout.addMember(mainTabSet);

        // 创建一个默认的主tab，作为当前用户的主页
        Tab tab = new Tab();
        tab.setTitle("Home&nbsp;&nbsp;");
        tab.setIcon("pieces/16/cube_green.png", 16);
        // 可以在子类中重写该方法以实现用户主页的初始化，并把主页内容放入mainPanel中
        initComponents();
        // 把主页面板放入tab
        tab.setPane(mainPanel);
        tab.setCanClose(false);
        mainTabSet.addTab(tab);
        mainLayout.draw();
    }

    @Override
    public ToolStrip generateTopStrip() {
        return generateTopStrip(null);
    }

    public ToolStrip generateTopStrip(MenuBar menuBar) {
        ToolStrip topBar = new ToolStrip();
        topBar.setHeight("3%");
        topBar.setWidth100();
        topBar.setBackgroundColor("#F2F2F2");
        topBar.setDefaultLayoutAlign(VerticalAlignment.CENTER);
        topBar.setAlign(Alignment.RIGHT);
        if (menuBar != null) {
            topBar.addMember(menuBar);
        }
        topBar.addSpacer(16);

        StringBuilder sb = new StringBuilder();
        if (ClientUtil.getDutyId() == -1) {//说明未设定职位,默认为普通职员
            sb.append("普通职员");
        } else {
            sb.append(KeyValueManager.getValue("duties", String.valueOf(ClientUtil.getDutyId())));
        }
        sb.append(" ").append(ClientUtil.getUserName());
        Label roleAndUserName = new Label(sb.toString());
        roleAndUserName.setWidth(200);
        roleAndUserName.setAlign(Alignment.RIGHT);
        roleAndUserName.setMargin(5);
        topBar.addMember(roleAndUserName);
        topBar.addSpacer(16);

        ImgButton sgwtHomeButton = new ImgButton();
        sgwtHomeButton.setSrc("logo.png");
        sgwtHomeButton.setWidth(45);
        sgwtHomeButton.setHeight(24);
        sgwtHomeButton.setShowRollOver(false);
        sgwtHomeButton.setShowDownIcon(false);
        sgwtHomeButton.setShowDown(false);
        topBar.addMember(sgwtHomeButton);
        topBar.addSpacer(16);

        ImgButton modifyPwd = new ImgButton();
        modifyPwd.setSrc("changepwd.png");
        modifyPwd.setWidth(24);
        modifyPwd.setHeight(24);
        modifyPwd.setShowRollOver(false);
        modifyPwd.setShowDownIcon(false);
        modifyPwd.setShowDown(false);
        modifyPwd.setPrompt("Change password");
        modifyPwd.setShowHover(true);
        modifyPwd.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                PopupWindow popupWindow = new PopupWindow("Change password");
                popupWindow.setWidth(450);
                popupWindow.setHeight(400);
                popupWindow.centerInPage();
                UserModifyPwd user = new UserModifyPwd();
                user.initComponents();
                popupWindow.addItem(user);
                user.setParentWindow(popupWindow);
                popupWindow.show();
            }
        });
        detailButtons.add(modifyPwd);
        topBar.addMember(modifyPwd);
        topBar.addSpacer(16);

        ImgButton quitBtn = new ImgButton();
        quitBtn.setSrc("logout.png");
        quitBtn.setWidth(24);
        quitBtn.setHeight(24);
        quitBtn.setShowRollOver(false);
        quitBtn.setShowDownIcon(false);
        quitBtn.setShowDown(false);
        quitBtn.setPrompt("relogin");
        quitBtn.setShowHover(true);
        quitBtn.addClickHandler(new com.smartgwt.client.widgets.events.ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                systemLogout();
            }
        });
        topBar.addMember(quitBtn);
        topBar.addSpacer(16);
        detailButtons.add(quitBtn);
        return topBar;
    }

    @Override
    public void systemLogout() {
        super.systemLogout();
        loginWindow.removeCookies();
        loginWindow.show();
        loginWindow.bringToFront();
    }

    //根据不同的角色(职员的默认角色)初始化我的工作面板
    @Override
    public void initComponents() {
        Map<String, Object> params = new HashMap<>();
        params.put("employeeId", ClientUtil.getEmployeeId());
        KeyValueManager.getValueMapFromQuery("employee_processes", "EmployeeProcess", MapUtils.toJSON(params));
        //用户登录之后，获取用户某些信息以备使用
        DBDataSource.callOperation("EP_GetUserInfo", params, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    Date expires = new Date(System.currentTimeMillis() + LoginLayout.DAY_TIMEMILLIS);
                    Record[] records = dsResponse.getData();
                    Storage sta = Storage.getLocalStorageIfSupported();
                    if (sta != null) {
                        sta.removeItem(PomPlatformClientUtil.ROLE_PLATEID_COOKIE);
                        sta.removeItem(PomPlatformClientUtil.ROLE_DEPARTMENTID_COOKIE);
                        sta.removeItem(PomPlatformClientUtil.PROCESS_ID_COOKIE);
                        sta.removeItem(PomPlatformClientUtil.PROCESS_ICON_COOKIE);
                    } else {
                        Cookies.removeCookie(PomPlatformClientUtil.ROLE_PLATEID_COOKIE);
                        Cookies.removeCookie(PomPlatformClientUtil.ROLE_DEPARTMENTID_COOKIE);
                    }
                    Cookies.removeCookie(PomPlatformClientUtil.PROCESS_ID_COOKIE);
                    if (!BaseHelpUtils.isNullOrEmpty(records)) {
                        for (Record record : records) {
                            if (record.getAttribute("key").equals("rolePlateId")) {
                                String value = record.getAttribute("value").toString();
                                if (sta != null) {
                                    if (value != null && value.length() > 0) {
                                        sta.setItem(PomPlatformClientUtil.ROLE_PLATEID_COOKIE, value);
                                    }
                                } else {
                                    if (value != null && value.length() > 0) {
                                        Cookies.setCookie(PomPlatformClientUtil.ROLE_PLATEID_COOKIE, value, expires);
                                    } else {
                                        Cookies.removeCookie(PomPlatformClientUtil.ROLE_PLATEID_COOKIE);
                                    }
                                }
                            } else if (record.getAttribute("key").equals("roleDepartmentId")) {
                                String value = record.getAttribute("value").toString();
                                if (sta != null) {
                                    if (value != null && value.length() > 0) {
                                        sta.setItem(PomPlatformClientUtil.ROLE_DEPARTMENTID_COOKIE, value);
                                    }
                                } else {
                                    if (value != null && value.length() > 0) {
                                        Cookies.setCookie(PomPlatformClientUtil.ROLE_DEPARTMENTID_COOKIE, value, expires);
                                    } else {
                                        Cookies.removeCookie(PomPlatformClientUtil.ROLE_DEPARTMENTID_COOKIE);
                                    }
                                }
                            } else if (record.getAttribute("key").equals(PomPlatformClientUtil.PROCESS_ID_COOKIE)) {
                                String value = record.getAttribute("value").toString();
                                if (value != null && value.length() > 0) {
                                    sta.setItem(PomPlatformClientUtil.PROCESS_ID_COOKIE, value);
                                }
                            } else if (record.getAttribute("key").equals(PomPlatformClientUtil.PROCESS_ICON_COOKIE)) {
                                String value = record.getAttribute("value").toString();
                                if (value != null && value.length() > 0) {
                                    sta.setItem(PomPlatformClientUtil.PROCESS_ICON_COOKIE, value);
                                }
                            }
                        }
                    }
                }
                Canvas workPanel = generateMyworkPanel();
                if (workPanel != null) {
                    mainPanel.addMember(workPanel);
                }
            }
        });
    }

    /**
     * 获取每个职员默认角色的工作面板
     *
     * @return
     */
    private Canvas generateMyworkPanel() {
        int roleID = ClientUtil.getRoleId();
        switch (roleID) {
            case RoleDefinition.ROLE_DESIGNER:
                return new DesignWorkPanel();
            case RoleDefinition.ROLE_PROJECT_MANAGER:
                return new SprojectManagerPanel();
            case RoleDefinition.ROLE_DEPARTMENT_MANAGER:
                return new ProjectManagerPanel();
            case RoleDefinition.ROLE_DEPARTMENT_DIRECTOR:
                return new MDepartmentDirectorPanel();
            case RoleDefinition.ROLE_MANAGEMENT_TEAM:
                return new MManagementTeamProjectPanel();
            case RoleDefinition.ROLE_CONTRACT_TEAM:
                return new ScontractccorPanel();
            case RoleDefinition.ROLE_HUMAN_RESOURCE_TEAM:
                return new MemployeePanel();
            case RoleDefinition.ROLE_OPERATION_TEAM:
                return new OperationManagerPanel();
            case RoleDefinition.ROLE_FINANCIAL_ACCOUNTING:
                return new SearchReimbursementInfoPanel();
            default:
                break;
        }
        return null;
    }
}
