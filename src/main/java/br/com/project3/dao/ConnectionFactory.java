package br.com.project3.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        try (InputStream input = ConnectionFactory.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            props.load(input);
        }
        // Set default values if not present in properties file
        if (!props.containsKey("jdbc.url")) {
            props.setProperty("jdbc.url", "jdbc:postgresql://localhost:5432/vendas_online_2");
        }
        if (!props.containsKey("jdbc.user")) {
            props.setProperty("jdbc.user", "postgres");
        }
        if (!props.containsKey("jdbc.password")) {
            props.setProperty("jdbc.password", "admin");
        }
        return DriverManager.getConnection(
                props.getProperty("jdbc.url"),
                props.getProperty("jdbc.user"),
                props.getProperty("jdbc.password"));
    }
}
