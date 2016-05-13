import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Table;
import org.hibernate.tool.hbm2ddl.DatabaseMetadata;
import org.hibernate.tool.hbm2ddl.SchemaUpdateScript;
import org.hibernate.tool.hbm2ddl.TableMetadata;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by serv on 16/5/13.
 */
public class AlterTest {

    private Dialect dialect = new MySQLDialect();

    @Test
    public void alter() throws Exception{

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test";
        Connection conn = DriverManager.getConnection(url , "root" , "root" ) ;
        Statement statement = conn.createStatement();

        DatabaseMetadata databaseMetadata = new DatabaseMetadata(conn,dialect,null,false);

        TableMetadata test01 = databaseMetadata.getTableMetadata("TEST01", null, null, false);


        Table table = new Table("TEST01");


        Column column = new Column("MEMO_TEST");
        column.setSqlType(dialect.getTypeName(Types.DATE));
        Column column1 = new Column("title11");
        column1.setSqlType(dialect.getTypeName(Types.NVARCHAR,200,0,0));
        column1.setComment("标题");

        table.addColumn(column);
        table.addColumn(column1);

//        alter table TEST01 add column MEMO_TEST date
//        alter table TEST01 add column title nvarchar(200)
        Iterator iterator = table.sqlAlterStrings(dialect, null, test01, null, null);
        while (iterator.hasNext()){
            String script = (String) iterator.next();
            System.out.println(script);
            statement.execute(script);
        }


        statement.close();
        conn.close();



    }
}
