package com.app.util;

import java.io.File;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;
@Component
public class LocationUtil {
	@Autowired
	private ILocationService service;
	public List<Location> getAllLocation(){
		return service.getAllLocations();
	}
	
	
	public void generatePie(String path, List<Object[]> data) {
		// 1.Convert data to dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data){
			dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
		}
		//2.Convertt dataset to Jfree Chart Obj
		JFreeChart chart=ChartFactory.createPieChart3D("Location Report" , dataset,true,true,false);
		//3.Convert image 
		try {
			ChartUtilities.saveChartAsJPEG(new File (path+ "/reportALoc.jpg") , chart, 400, 300);
		}
		catch(Exception e){}
		
	}
	public void generateBar(String path, List<Object[]> data) {
		// 1.create data set
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
			for (Object[] ob:data){
				dataset.setValue(new Double(ob[1].toString()),ob[0].toString(),"");
			}
			//2. convert dataset to JFreeChart Obj
			JFreeChart chart=ChartFactory.createBarChart3D("Location Report", "Location Type","Location Count", dataset);
			//3.convert JFreeChart to image
			try{
				
				ChartUtilities.saveChartAsJPEG(new File(path+"/reportBLoc.jpg"), chart, 400,300);
			}
			catch(Exception e){}		
		
	}
}