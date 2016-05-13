import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.tool.hbm2ddl.DatabaseMetadata;
import org.hibernate.tool.hbm2ddl.TableMetadata;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by serv on 16/5/13.
 */
public class InfoTest {

    private Dialect dialect = new MySQLDialect();


    @Test
    public void info() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test";
        Connection conn = DriverManager.getConnection(url , "root" , "root" ) ;
//        Statement statement = conn.createStatement();

        DatabaseMetadata databaseMetadata = new DatabaseMetadata(conn,dialect,null,false);

        TableMetadata test01 = databaseMetadata.getTableMetadata("TEST01", null, null, false);

        System.out.println("name:"+test01.getName());
        System.out.println("catalog:"+test01.getCatalog());
        System.out.println("schema:"+test01.getSchema());


        System.out.println(test01.toString());

    }
}
