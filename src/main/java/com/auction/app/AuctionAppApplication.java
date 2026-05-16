package com.auction.app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuctionAppApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        String dbUrl = System.getenv("jdbc:postgresql://localhost:5432/auctionbazaar");
        String dbUser = System.getenv("postgres");
        String dbPass = System.getenv("postgres");

        if (dbUrl == null) {
            dbUrl = dotenv.get("Database_URI");
        }

        if (dbUser == null) {
            dbUser = dotenv.get("Db_username");
        }

        if (dbPass == null) {
            dbPass = dotenv.get("Db_password");
        }

        if (dbUrl != null) {
            System.setProperty("Database_URI", dbUrl);
        }

        if (dbUser != null) {
            System.setProperty("Db_username", dbUser);
        }

        if (dbPass != null) {
            System.setProperty("Db_password", dbPass);
        }

        SpringApplication.run(AuctionAppApplication.class, args);
    }
}