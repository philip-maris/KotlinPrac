/*
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionPoolPrac {

    public static void main( String[] Args){
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env");
            Connection connection = ds.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

*/
