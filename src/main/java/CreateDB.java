import java.net.URISyntaxException;
import java.sql.*;

public class CreateDB {
    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }
    public static void main(String[] args) throws SQLException, URISyntaxException {
        Connection connection = getConnection();

        try {
            Statement s=connection.createStatement();
            System.out.println("connection works");
            String sqlStr2 = "create table patientofdoctor(\n" +
                    "    id SERIAL PRIMARY KEY ,\n" +
                    "    patientid int NOT NULL,\n" +
                    "    doctorid int NOT NULL\n" +
                    ");\n";
            s.executeQuery(sqlStr2);
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
}