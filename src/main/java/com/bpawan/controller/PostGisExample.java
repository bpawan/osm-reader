package com.bpawan.controller;

import org.postgis.PGgeometry;
import org.postgresql.Driver;
import org.postgresql.geometric.PGbox;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostGisExample {
    public void test() {
        java.sql.Connection conn;

        try {
            /*
             * Load the JDBC driver and establish a connection.
             */
            Class.forName(Driver.class.getName());
            String url = "jdbc:postgresql://localhost:5432/nepaldata";
            conn = DriverManager.getConnection(url, "root", "root");
            /*
             * Add the geometry types to the connection. Note that you
             * must cast the connection to the pgsql-specific connection
             * implementation before calling the addDataType() method.
             */
            ((org.postgresql.PGConnection) conn).addDataType("geometry", Class.forName(PGgeometry.class.getName()));
            ((org.postgresql.PGConnection) conn).addDataType("box3d", Class.forName(PGbox.class.getName()));
            /*
             * Create a statement and execute a select query.
             */
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("select osm_id from planet_osm_line");
            while (r.next()) {
                System.out.println(r.getObject(1));
            }
            s.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
