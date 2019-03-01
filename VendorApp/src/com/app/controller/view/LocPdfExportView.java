package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocPdfExportView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document,
			PdfWriter arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
List<Location> listObj=(List<Location>)model.get("locationListObj");
PdfPTable table=new PdfPTable(3);
table.addCell("Location Id");
table.addCell("Location Name");
table.addCell("Location Type");
		for(Location loc:listObj){
			table.addCell(Integer.toString(loc.getLocId()));
			table.addCell(loc.getLocName());
			table.addCell(loc.getLocType());
		}
		Paragraph p=new Paragraph();
		document.addTitle("Location PDF Sample");
		document.add(p);
		document.add(table);
	}
	}


