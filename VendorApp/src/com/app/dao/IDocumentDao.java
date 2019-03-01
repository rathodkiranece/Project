package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {
	public void saveDocument(Document doc);
	public List<Object[]> getFileAndName();
	public Document getDocById(int docId);
	

}
