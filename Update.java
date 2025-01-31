import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Update{
    static final String DB_URL="jdbc:mysql://localhost:3306/carss";
    static final String USER="root";
    static final String PASS="Msila@123";
    public static void main(String[] args){
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to the Car database...");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            String sql="UPDATE RideRentals SET RentalCost = ? WHERE RentalID = ?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setBigDecimal(1,new java.math.BigDecimal("30.00"));
            pstmt.setInt(2,1);
            int rowsAffected=pstmt.executeUpdate();
            System.out.println("Update completed successfully. Rows affected: "+rowsAffected);
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if (pstmt!=null) pstmt.close();
            }
            catch(SQLException se2){
            }
            try{
                if (conn!=null) conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}