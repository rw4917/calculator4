import java.sql.*;

public class DBQuery {
    public String output;

    public void main(String[] args) throws SQLException
    {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try
        {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        Connection conn= DriverManager.getConnection(dbUrl);

        try {
            Statement s=conn.createStatement();
            String sqlStr2 = "create table patientofdoctor(\n" +
                    "    id SERIAL PRIMARY KEY ,\n" +
                    "    patientid int NOT NULL,\n" +
                    "    doctorid int NOT NULL\n" +
                    ");\n";
            s.executeQuery(sqlStr2);
            String sqlStr = "SELECT * FROM patients";
            ResultSet rset=s.executeQuery(sqlStr);
            while(rset.next()){
                output+=rset.getInt("id")+" "+ rset.getString("familyname"); }
            rset.close();
            s.close();
            conn.close();
        }
        catch (Exception e){ }


    }
    public String getOutput()
    {
        return output;
    }
}