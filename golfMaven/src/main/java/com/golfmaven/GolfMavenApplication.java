package com.golfmaven;

import com.golfmaven.dao.GolferDao;
import com.golfmaven.dao.GolferJdbcDAO;
import com.golfmaven.models.Golfer;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GolfMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GolfMavenApplication.class, args);

		System.out.println("***** Golf Maven - Banner Placeholder *****");

		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:postgresql://localhost:5432/golf-maven");
		ds.setUsername("postgres");
		ds.setPassword("postgres1");

		GolferDao dao = new GolferJdbcDAO(ds);
		List<Golfer> golfers = dao.getAllGolfers();
		System.out.println(golfers);
	}


}

