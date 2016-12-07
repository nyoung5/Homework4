/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elon.LibraryDB;

import java.sql.*;

/**
 *
 * @author nyoung5
 */
public class DBUtil {
  public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static String getHtmlTable(ResultSet results)
            throws SQLException
    {
        StringBuilder htmlTable = new StringBuilder();
        ResultSetMetaData metaData = results.getMetaData();
       
        int columnCount = metaData.getColumnCount();
        htmlTable.append("<table class=")
                .append("'").append("results")
                .append("'").append(">\n");
        
        // add header row
        htmlTable.append("\t<tr>\n");
        for (int i = 1; i <= columnCount; i++) {
            htmlTable.append("\t\t<th>");
            htmlTable.append(metaData.getColumnLabel(i));
            htmlTable.append("</th>\n");
        }
        htmlTable.append("\t\t<th></th>\n");
        htmlTable.append("\t</tr>\n");
        
        int count = 0;
        // add all other rows
        while (results.next())
        {
            htmlTable.append("\t<tr>\n");
            for (int i = 1; i <= columnCount; i++) {
                htmlTable.append("\t\t<td>");
                htmlTable.append(results.getString(i));
                htmlTable.append("</td>\n");
            }
            String checkin = results.getString("Book Title");
            htmlTable.append("\t\t<td>\n")
                    .append("\t\t\t<form action=").append("'library'").append(">\n")
                    .append("\t\t\t\t<input type=").append("'hidden'")
                    .append(" name=").append("'").append("action")
                    .append("'").append(" value=")
                    .append("'").append(checkin).append("'").append(">\n")
                    .append("\t\t\t\t<input type=").append("'submit'")
                    .append(" value=").append("'Check In'").append(">\n")
                    .append("\t\t\t</form>\n").append("\t\t</td>\n").append("\t</tr>\n");
            count++;
        }
        
        htmlTable.append("</table>");
        DBUtil.closeResultSet(results);
        
        if(count == 0) {
          return "<p>There are no currently no books in the library!</p>";
        }
        
        return htmlTable.toString();
    }    
    
}
