import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.mapping.Table;
import org.junit.Test;

/**
 * Created by serv on 16/5/13.
 */
public class DropTest {

    private Dialect dialect = new MySQLDialect();

    @Test
    public void drop(){
        String sqlDropString = new Table("TEST01").sqlDropString(dialect, null, null);
        System.out.println(sqlDropString);
    }
}
