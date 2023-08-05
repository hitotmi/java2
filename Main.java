package sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties prop = new Properties();

        try {
            // プロパティファイルから設定を読み込む
            prop.load(new FileInputStream("application.properties"));
            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            // データベースに接続
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("データベース接続成功");
            System.out.println(con);

            // データベース接続を解除
            con.close();

        } catch(IOException | SQLException e) {
            System.out.println("データベース接続失敗：" + e.getMessage());
        }
    }
}