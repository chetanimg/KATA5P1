package kata_p1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class InsertDataInTable {
    
    private Connection connect() {
        String url = "jdbc:sqlite:mail.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
        System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insert(String email) {
        String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void refill(){
        String path = "./email.txt";
        List<String> emails = MailListReader.read(path);
        try {
            String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";
            Connection conn = this.connect();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            for (String email : emails) {
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
