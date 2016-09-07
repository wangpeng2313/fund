package com.javaetime.web.tu.ctrl;

import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import com.javaetime.web.tu.service.TuService;
import com.javaetime.web.tu.service.TuServiceImpl;

@SuppressWarnings("serial")
public class TuController extends HttpServlet{
	
	
	private TuService tuService=new TuServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			
			String method = request.getParameter("method");
			
			if( "zhu".equals(method) ){
				this.zhu(request, response);
				return;
			}else if( "bing".equals(method) ){
				this.bing(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} 
	}
	private void bing(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		System.out.println("---------------------------进入bing()---------------------------");
		System.out.println("开始饼状图");
		Map<String,Object> map=tuService.queryBing();
		request.setAttribute("map", map);
		request.getRequestDispatcher("views/tu/bing.jsp").forward(request, response);
	}
	
	private void zhu(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		System.out.println("---------------------------进入zhu()---------------------------");
		System.out.println("开始柱状图");
		response.setContentType("image/jpeg");
		OutputStream out=response.getOutputStream();
		CategoryDataset ds=getDateSet(request,response);
		JFreeChart chart=ChartFactory.createBarChart3D("财务预览图", "月份", "金额", ds, PlotOrientation.VERTICAL, true, false, false);
		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();

		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();//数量范畴

		CategoryAxis domainAxis = categoryplot.getDomainAxis();//种类范畴

		/*------设置X轴坐标上的文字-----------*/
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));

		/*------设置X轴的标题文字------------*/
		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));

		/*------设置Y轴坐标上的文字-----------*/
		numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));

		/*------设置Y轴的标题文字------------*/
		numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));

		/*------这句代码解决了底部汉字乱码的问题-----------*/
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));

		/******* 这句代码解决了标题汉字乱码的问题 ********/
		chart.getTitle().setFont(new Font("宋体", Font.PLAIN, 12));

		try {
			ChartUtilities.writeChartAsJPEG(out, 0.5f, chart, 900, 600, null);
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	
	}
	private CategoryDataset getDateSet(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException {
		DefaultCategoryDataset ds=new DefaultCategoryDataset();
		List<String[]> list=tuService.queryzhu();
		String[] shouRu=list.get(0);
		String[] zhiChu=list.get(1);
		String[] yuSuan=list.get(2);
		int one_shouRu=Integer.parseInt(shouRu[0])+Integer.parseInt(shouRu[1])+Integer.parseInt(shouRu[2]);
		int two_shouRu=Integer.parseInt(shouRu[3])+Integer.parseInt(shouRu[4])+Integer.parseInt(shouRu[5]);
		int three_shouRu=Integer.parseInt(shouRu[6])+Integer.parseInt(shouRu[7])+Integer.parseInt(shouRu[8]);
		int four_shouRu=Integer.parseInt(shouRu[9])+Integer.parseInt(shouRu[10])+Integer.parseInt(shouRu[11]);
		
		int one_zhiChu=Integer.parseInt(zhiChu[0])+Integer.parseInt(zhiChu[1])+Integer.parseInt(zhiChu[2]);
		int two_zhiChu=Integer.parseInt(zhiChu[3])+Integer.parseInt(zhiChu[4])+Integer.parseInt(zhiChu[5]);
		int three_zhiChu=Integer.parseInt(zhiChu[6])+Integer.parseInt(zhiChu[7])+Integer.parseInt(zhiChu[8]);
		int four_zhiChu=Integer.parseInt(zhiChu[9])+Integer.parseInt(zhiChu[10])+Integer.parseInt(zhiChu[11]);
		
		int one_yuSuan=Integer.parseInt(yuSuan[0])+Integer.parseInt(yuSuan[1])+Integer.parseInt(yuSuan[2]);
		int two_yuSuan=Integer.parseInt(yuSuan[3])+Integer.parseInt(yuSuan[4])+Integer.parseInt(yuSuan[5]);
		int three_yuSuan=Integer.parseInt(yuSuan[6])+Integer.parseInt(yuSuan[7])+Integer.parseInt(yuSuan[8]);
		int four_yuSuan=Integer.parseInt(yuSuan[9])+Integer.parseInt(yuSuan[10])+Integer.parseInt(yuSuan[11]);
		
		ds.addValue(one_yuSuan, "预算", "第一季度");
		ds.addValue(one_shouRu, "收入", "第一季度");
		ds.addValue(one_zhiChu, "支出", "第一季度");
		
		ds.addValue(two_yuSuan, "预算", "第二季度");
		ds.addValue(two_shouRu, "收入", "第二季度");
		ds.addValue(two_zhiChu, "支出", "第二季度");
		
		ds.addValue(three_yuSuan, "预算", "第三季度");
		ds.addValue(three_shouRu, "收入", "第三季度");
		ds.addValue(three_zhiChu, "支出", "第三季度");
		
		
		ds.addValue(four_yuSuan, "预算", "第四季度");
		ds.addValue(four_shouRu, "收入", "第四季度");
		ds.addValue(four_zhiChu, "支出", "第四季度");
		return ds;
	}
}
