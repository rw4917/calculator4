import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class CreateDB {

    public CreateDB() {



        try {
            Connection connection = getConnection();
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

    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        String username = "rrhsgihyhiwjvt";
        String password = "cf112dbe709c8110fe826c4dc67db8c9aae84b431b3786332752cf81745f8b03";
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
    public static void main(String[] args) throws SQLException, URISyntaxException {

    }
}