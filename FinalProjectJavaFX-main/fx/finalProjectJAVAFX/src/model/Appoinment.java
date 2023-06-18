/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author WAFAco
 */
public class Appoinment {
    private int id;
    private Date appointmentDate;
    private String appointmentDay;
    private Time appointmentTime;
    private String status;

    public Appoinment( Date appointmentDate, String appointmentDay, Time appointmentTime, String status) {
        this.appointmentDate = appointmentDate;
        this.appointmentDay = appointmentDay;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(String appointmentDay) {
        this.appointmentDay = appointmentDay;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int save() throws ClassNotFoundException, SQLException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordcounter = 0;
String sql = "INSERT INTO APPOINTMENTS (ID,APPOINTMENT_DATE,APPOINTMENT_DAY,APPOINTMENT_TIME,STATUS) VALUES (?, ?, ?, ?,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        ps.setDate(2, (java.sql.Date) this.getAppointmentDate());
        ps.setString(3, this.getAppointmentDay());
        ps.setTime(4, (java.sql.Time) this.getAppointmentTime());
        ps.setString(5, this.getStatus());
   

        recordcounter = ps.executeUpdate();
        if (recordcounter > 0) {
            System.out.println(this.getId()+ "Appoinment was added successful");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordcounter;
    }

        public static ArrayList<Appoinment> getAllAppoinment() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Appoinment> appo = new ArrayList<>();
        String sql = "SELECT * FROM APPOINTMENTS ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
            Appoinment appoinmnt = new Appoinment(rs.getDate(2),rs.getString(3),rs.getTime(4),rs.getString(5));
            appoinmnt.setId(rs.getInt(1));
            appo.add(appoinmnt);
            
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return appo;
    }
 
   public int update() throws ClassNotFoundException, SQLException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordcounter = 0;
String sql = "UPDATE APPOINTMENTS SET APPOINTMENT_DATE=?,APPOINTMENT_DAY=?,APPOINTMENT_TIME=?,STATUS=? WHERE ID=?";
        ps = c.prepareStatement(sql);
        ps.setDate(1, (java.sql.Date) this.getAppointmentDate());
        ps.setString(2, this.getAppointmentDay());
        ps.setTime(3, (java.sql.Time) this.getAppointmentTime());
        ps.setString(4, this.getStatus());
        ps.setInt(5,this.getId());
   

        recordcounter = ps.executeUpdate();
        if (recordcounter > 0) {
            System.out.println("Appoinemnt with id : "+this.getId()+ "Appoinment was Updated successful");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordcounter;
    }
   
   public int delete() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "DELETE FROM APPOINTMENTS WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("The Appoinemnt with id : "+this.getId()+" was deleted successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
} 
