import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PrimaryKey;
import org.hibernate.mapping.Table;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Types;

/**
 * Created by serv on 16/5/13.
 */
public class CreateTest {

    private Dialect dialect = new MySQLDialect();

    @Test
    public void create() throws Exception {

        Table table = new Table("TEST01");

        Column idColumn = new Column("id");
        idColumn.setSqlType(dialect.getTypeName(Types.INTEGER, 100l, 0, 0));
        idColumn.setNullable(false);
        idColumn.setUnique(true);
        idColumn.setComment("id主键");

        Column nameColumn = new Column("name");
        nameColumn.setLength(500);
        nameColumn.setSqlType(dialect.getTypeName(Types.NVARCHAR,500l,0,0));
        nameColumn.setComment("名称");

        PrimaryKey primaryKey = new PrimaryKey();
        primaryKey.addColumn(idColumn);
        primaryKey.setName("id");
        primaryKey.setTable(table);

        table.addColumn(idColumn);
        table.addColumn(nameColumn);
        table.setPrimaryKey(primaryKey);

        String sql = table.sqlCreateString(dialect, null, null, null);
        //create table TEST01 (id integer not null comment 'id主键', name nvarchar(500) comment '名称', primary key (id))
        System.out.println(sql);


        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test";
        Connection conn = DriverManager.getConnection(url , "root" , "root" ) ;
        Statement statement = conn.createStatement();
        statement.execute(sql);

    }
}
