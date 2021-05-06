package utils;
import org.testng.annotations.DataProvider;

import java.sql.*;
import java.util.*;
 
/**
 * ���ݿ��������
 *
 * @author longrong.lang
 */
public class DbDataHeleper {
 
    static Connection conn = null;
 
    public static String driverClassName = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://127.0.0.1:3306/shixunyi";
    public static String username = "root";
    public static String password = "123456";
 
 
    /**
     * ִ��sql
     *
     * @param jdbcUrl ���ݿ���������
     * @param sql     sql���
     * @return
     */
    public static List<Map<String, String>> getDataList(String jdbcUrl, String sql) {
        List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
        Map<String, String> param = new HashMap<>();
        Statement stmt = null;
        try {
            // ע�� JDBC ����
            Class.forName(driverClassName);
            // ������
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            // ִ�в�ѯ
            stmt = conn.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            //String columns[] = {"name", "phone", "pwd"};
            String columns[] = { "phone", "pwd"};
            // չ����������ݿ�
            while (rs.next()) {
                Map<String, String> map = new LinkedHashMap<String, String>();
                for (int i = 0; i < columns.length; i++) {
                    String cellData = rs.getString(columns[i]);
                    map.put(columns[i], cellData);
                }
                paramList.add(map);
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // ���� JDBC ����
            System.out.println("���� JDBC ����!");
        } catch (Exception e) {
            // ���� Class.forName ����
            System.out.println("���� Class.forName ����");
        } finally {
            // �ر���Դ
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return paramList;
    }
 
    @DataProvider
    public Object[][] dbDataMethod() {
       //String sql = "SELECT name,phone,pwd FROM userinfo;";
        String sql = "SELECT phone,pwd FROM userinfo;";
        List<Map<String, String>> result = getDataList(url, sql);
        Object[][] files = new Object[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            files[i] = new Object[]{result.get(i)};
        }
        return files;
    }
}