import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.postgresql.util.PGobject;

import struct.ResultType;

public class DBUtils{
    private Connection con = null;
    
    public DBUtils(){}
    private Connection getConnection(String dbUrl, String user, String pw){
        try{
            //db connection
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbUrl, user, pw);
            System.out.println("DB url: " + dbUrl);
            if(con != null){
                System.out.println("db connect");
            }
            return con;
        }catch(Exception e){
            e.printStackTrace;
        }
        return null;
    }
    
    public staticf void closeConnection(){
        try{
            if(con != null){
                con.close();
                System.out.println("DB disconnected");
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<ResultType> selectQuery(String query){
        ArrayList<ResultType> resultList = new ArrayList<ResultType>();
        
        try{
            getConnection();
            String sb = new StringBuffer();
            sb.append(query);
            PreparedStatement pstmt = con.prepareStatement(sb.toString());
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                ResultType rt = new ResultType();
                rt.setTemp(rs.getString("temp"));
                resultList.add(rt);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        closeConnection();
        return resultList;
    }
    
    public void insertQuery(int dbindex, int equipmentkey, String name){
        try{
            PreparedStatement pstmt = null;
            String sql = "UPDATE thrmresult SET dbindex = ?, equipmentkey = ?, name = ? where dbindex = ? and equipmentkey = ? and name = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 12345);
            pstmt.setInt(2, 12345);
            pstmt.setInt(3, "name2");
            
            pstmt.setInt(4, 12345);
            pstmt.setInt(5, 12345);
            pstmt.setInt(6, "name");
            
            pstmt.executeUpdate();
        }
    }
}