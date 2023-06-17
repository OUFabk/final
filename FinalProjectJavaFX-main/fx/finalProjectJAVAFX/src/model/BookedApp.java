package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookedApp {

    private int id;
    private int appointmentId;
    private int userId;
    private String status;
    private String doctorComment;

    public BookedApp(int appointmentId, int userId, String status,String doctorComment) {
        this.appointmentId = appointmentId;
        this.userId = userId;
        this.status = status;
        this.doctorComment = doctorComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctorComment() {
        return doctorComment;
    }

    public void setDoctorComment(String doctorComment) {
        this.doctorComment = doctorComment;
    }
    
    
    
     public int Update() throws ClassNotFoundException, SQLException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordcounter = 0;
        String sql = "UPDATE booked_appointments SET STATUS=?,DOCTOR_COMMENT=? WHERE appointments.id ";
           ps = c.prepareStatement(sql);
             ps.setString(1, this.getStatus());
              ps.setString(2, this.getDoctorComment());
                    ps.setInt(3, this.getId());
    
     recordcounter = ps.executeUpdate();
        if (recordcounter > 0) {
            System.out.println(this.getId()+ "user was added successful");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordcounter;
     }
    

    public static ArrayList<BookedApp> getAllBookedAppointments() throws SQLException, ClassNotFoundException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<BookedApp> bookedAppointments = new ArrayList<>();
       String sql = "SELECT booked_appointments.id, booked_appointments.appointment_id, booked_appointments.user_id, booked_appointments.status "
        + "FROM booked_appointments "
        + "INNER JOIN appointments ON booked_appointments.appointment_id = appointments.id "
        + "INNER JOIN users ON booked_appointments.user_id = users.id";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            BookedApp booked = new BookedApp(
                    rs.getInt("appointment_id"),
                    rs.getInt("user_id"),
                    rs.getString("status"),
                    rs.getString("doctor_comment")
            );
            booked.setId(rs.getInt("id"));
            bookedAppointments.add(booked);
        }

        if (ps != null) {
            ps.close();
        }
        c.close();
        return bookedAppointments;
    }
}
