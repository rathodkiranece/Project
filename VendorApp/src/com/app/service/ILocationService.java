package com.app.service;

import java.util.List;

import com.app.model.Location;


public interface ILocationService {

	public int saveLocation(Location loc);
	public List<Location> getAllLocations();
	public void deleteLocById(int locId);
	
	
	public Location getLocationById(int locId);
	public void updateLocation(Location loc);
	public List<Object[]> getLocTypeWiseCount();
	public boolean isLocNameExist(String locName);
	public boolean isLocationUsedByVendor(int locId);
	
}
