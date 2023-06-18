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
 * @author WAFAco
 */
public class ScheduleAppoinemnt {
     private int id;
    private Date appointmentDate;
    private String appointmentDay;
    private Time appointmentTime;
    private String status;

    public ScheduleAppoinemnt( Date appointmentDate, String appointmentDay, Time appointmentTime, String status) {
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
    
     public static ArrayList<ScheduleAppoinemnt> getAllAppoinment() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ScheduleAppoinemnt> appo = new ArrayList<>();
        String sql = "SELECT * FROM APPOINTMENTS";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
        ScheduleAppoinemnt schAppo = new ScheduleAppoinemnt(
            rs.getDate("appointment_date"),
            rs.getString("appointment_day"),
            rs.getTime("appointment_time"),
            rs.getString("status")
        );
           schAppo.setId(rs.getInt("id"));
            appo.add(schAppo);
            
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return appo;
    }
 
}
