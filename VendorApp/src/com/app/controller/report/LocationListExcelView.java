package com.app.controller.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;

public class LocationListExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest arg2, HttpServletResponse arg3)
					throws Exception {
		HSSFSheet sheet=book.createSheet("Locations Data");
		List<Location> locList=(List<Location>)map.get("LocationListObj");
		setHeader(sheet);
		setRows(sheet,locList);
	}
	public void setHeader(HSSFSheet sheet ){
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("Location Id");
		row.createCell(1).setCellValue("Location Name");
		row.createCell(2).setCellValue("Location Type");
	}
	private void setRows(HSSFSheet sheet, List<Location> locList) {
		int rowId=1;
		for(Location loc:locList){
			HSSFRow row=sheet.createRow(rowId++);
			row.createCell(0).setCellValue(loc.getLocId());
			row.createCell(1).setCellValue(loc.getLocName());
			row.createCell(2).setCellValue(loc.getLocType());
		}
	}
}




