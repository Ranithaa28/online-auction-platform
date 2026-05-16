package com.auction.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class AuctionAppApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
        .ignoreIfMissing()
        .load();
		System.setProperty("Database_URI", dotEnv.get("Database_URI"));
		System.setProperty("Db_username", dotEnv.get("DB_username"));
		System.setProperty("Db_password", dotEnv.get("DB_password"));
		SpringApplication.run(AuctionAppApplication.class, args);
	}

}
