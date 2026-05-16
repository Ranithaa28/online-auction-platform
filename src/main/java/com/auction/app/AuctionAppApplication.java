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
		System.setProperty("Database_URI", dotenv.get("jdbc:postgresql://localhost:5432/auctionbazaar"));
		System.setProperty("Db_username", dotenv.get("postgres"));
		System.setProperty("Db_password", dotenv.get("postgres"));
		SpringApplication.run(AuctionAppApplication.class, args);
	}

}
