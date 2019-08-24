package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;


public class BearClient {

    public static RequestSpecification bearClient() {

        Properties prop = new Properties();
        RequestSpecification request = RestAssured.given();
        try (InputStream input = new FileInputStream("./src/main/resources/config.properties")) {
            prop.load(input);

            int port = Integer.parseInt(prop.getProperty("port"));
            String url = prop.getProperty("url");

            request.baseUri(url);
            request.port(port);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return request;
    }
}

//получить параметры из конфига, передать в запрос.
//команды grep, tail -f, cat, ccp dump, подсети,
//tail -f --- мониторинг логов, cat --- читать файл, grep --- поиск файла