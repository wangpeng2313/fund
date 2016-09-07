<%@page import="java.util.Map"%>
<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%>
<%@ page import="org.jfree.chart.*"%>
<%@ page import="org.jfree.chart.plot.*"%>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%>
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%>
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%>
<%@ page import="java.io.*"%>

<HTML> 
<HEAD> 
<META http-equiv=Content-Type content="text/html; charset=GBK"> 
<META NAME="Author" CONTENT="Alpha">
<TITLE>员工学历情况调查表</TITLE> 
</HEAD> 
<BODY> 
<%
                     Map map=(Map)request.getAttribute("map");
					 int map_xiaoxue=(Integer)map.get("map_xiaoxue");
					 int map_zhongxue=(Integer)map.get("map_zhongxue");
					 int map_gaozhong=(Integer)map.get("map_gaozhong");
                     int map_zhuanke= (Integer)map.get("map_zhuanke");
                     int map_benke= (Integer)map.get("map_benke");
                     int map_shuoshi= (Integer)map.get("map_shuoshi");
                     int map_boshi= (Integer)map.get("map_boshi");
                     int map_boshihou=(Integer)map.get("map_boshihou");
                     
                   DefaultPieDataset data = new DefaultPieDataset(); 
            //数据初始化
           
            data.setValue("小学",map_xiaoxue); 
            data.setValue("中学",map_zhongxue); 
            data.setValue("高中",map_gaozhong); 
            data.setValue("专科",map_zhuanke);
            data.setValue("本科",map_benke); 
            data.setValue("硕士",map_shuoshi); 
            data.setValue("博士",map_boshi); 
            data.setValue("博士后",map_boshihou); 
            
            //HttpSession session = request.getSession();

            PiePlot3D plot = new PiePlot3D(data);//生成一个3D饼图  
            //plot.setURLGenerator(new StandardPieURLGenerator("DegreedView.jsp"));//设定图片链接 
            JFreeChart chart = new JFreeChart("",JFreeChart.DEFAULT_TITLE_FONT, plot, true); 
            chart.setBackgroundPaint(java.awt.Color.white);//可选，设置图片背景色 
            chart.setTitle("员工学历情况调查表");//可选，设置图片标题 
            plot.setToolTipGenerator(new StandardPieToolTipGenerator()); 
            StandardEntityCollection sec = new StandardEntityCollection(); 
            ChartRenderingInfo info = new ChartRenderingInfo(sec); 
            PrintWriter w = new PrintWriter(out);//输出MAP信息 
            //500是图片长度，300是图片高度
            //String filename = ServletUtilities.saveChartAsPNG(chart,500,300,info,session); 
            String filename = ServletUtilities.saveChartAsJPEG(chart,500,300,info,session); 
            ChartUtilities.writeImageMap(w,"map0",info,false); 

            String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" + filename;
%> 

<P ALIGN="CENTER"> 
<img src="<%= graphURL %>" width=500 height=300 border=0 usemap="#map0"> 
</P> 
</BODY> 
</HTML>