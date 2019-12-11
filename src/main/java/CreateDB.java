import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class CreateDB {

    public CreateDB() {


        System.out.println("Something is working");
        try {
            Connection connection = getConnection();
            Statement s=connection.createStatement();
            System.out.println("connection works");
            String sqlStr2 = "create table patientofdoctor(" +
                    "    id SERIAL PRIMARY KEY ," +
                    "    patientid int NOT NULL," +
                    "    doctorid int NOT NULL" +
                    ");\n";
            s.executeQuery(sqlStr2);
            String sqlStr3 = "create table patients (\n" +
                    "                    id SERIAL PRIMARY KEY,\n" +
                    "                    familyname varchar(128) NOT NULL, givenname varchar(128) NOT NULL, phonenumber varchar(32)\n" +
                    "            );";
            s.executeQuery(sqlStr3);

            System.out.println("Hopefully we created the table ");
            String sqlStr = "insert into patients (familyname,givenname,phonenumber) values('Jones','Bill','07755678899');";
            ResultSet rset=s.executeQuery(sqlStr);
            while(rset.next()){
                System.out.println(rset.getInt("id")+" "+ rset.getString("familyname")); }
            rset.close();
            s.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("There was a problem:");
            e.printStackTrace();
        }

    }
    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        System.out.println("Working until now");
        return DriverManager.getConnection(dbUrl);
    }
    public static void main(String[] args) throws SQLException, URISyntaxException {

    }
}