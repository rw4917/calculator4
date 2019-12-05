import java.sql.*;

public class CreateDB {
    public static void main(String[] args) throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try
        {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        Connection conn= DriverManager.getConnection(dbUrl);

        try {
            Statement s=conn.createStatement();
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
            conn.close();
        }
        catch (Exception e){ }

    }
}