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
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mahmoud
 */
public class AvailableAppoinemnt {
     private int id;
    private Date appointmentDate;
    private String appointmentDay;
    private Time appointmentTime;
    private String status;

    public AvailableAppoinemnt( Date appointmentDate, String appointmentDay, Time appointmentTime, String status) {
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
    
     public static ArrayList<AvailableAppoinemnt> getAllFreeAppoinment() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<AvailableAppoinemnt> appo = new ArrayList<>();
       String sql = "SELECT * FROM APPOINTMENTS WHERE status = 'FREE'";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
        AvailableAppoinemnt aviAppo = new AvailableAppoinemnt(
            rs.getDate("appointment_date"),
            rs.getString("appointment_day"),
            rs.getTime("appointment_time"),
            rs.getString("status")
        );
           aviAppo.setId(rs.getInt("id"));
            appo.add(aviAppo);
            
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return appo;
    }
 
}
