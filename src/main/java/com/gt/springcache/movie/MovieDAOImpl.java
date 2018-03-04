package com.gt.springcache.movie;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("movieDao")
public class MovieDAOImpl implements MovieDAO{
	
	//This "movieFindCache" is delcares in ehcache.xml
	@Cacheable(value = "movieFindCache", key = "#name")
	public Movie findByDirector(String name) {
		slowQuery(2000L);
		System.out.println("find director is running...");
		return new Movie(1, "Forrest Gump", "Robert Zemeckis");
	}
	
	private void slowQuery(long seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
