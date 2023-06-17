/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import javafx.scene.Node;

/**
 *
 * @author Mahmoud
 */
public class ViewManager {
    
    public static AdminDashboard adminPage;
      public static RegPage regPages;
      public static PatientDashboard patientPage;
       public static Login login;
        public static LoginDashboard loginPatient;

     

      
    
    
    public ViewManager(){   
    }

        public static void OpenRegisterPage() throws IOException{
        if (regPages == null) {
            regPages = new RegPage();
            regPages.show();
        } else {
            regPages.show();
        
        }
        }
    
    public static void closeRegisterPage(){
        if(regPages != null)
          regPages.close();
    }

   
     public static void openAdminPage() throws IOException{
        if (adminPage == null) {
            adminPage = new AdminDashboard();
            adminPage.show();
        } else {
            adminPage.show();
        }
        
    }
    public static void closeAdminPage(){
        if(adminPage != null)
            adminPage.close();
}
    
          public static void OpenPatientDashboard() throws IOException{
        if (patientPage == null) {
            patientPage = new PatientDashboard();
            patientPage.show();
        } else {
            patientPage.show();
        
        }
        }
    
            public static void ClosePatientDashboard(){
                if(patientPage != null)
                  patientPage.close();
            }

    
    
    public static void OpenLoginPage() throws IOException{
        if (login == null) {
            login = new Login();
            login.show();
        } else {
            login.show();
        
        }
        }
    
    public static void closeLoginPage(){
        if(login != null)
          login.close();
    }
    
    public static void OpenLoginPagePatient() throws IOException{
        if (loginPatient == null) {
            loginPatient = new LoginDashboard();
            loginPatient.show();
        } else {
            loginPatient.show();
        
        }
        }
    
    public static void closeLoginPagePatient(){
        if(loginPatient != null)
          loginPatient.close();
    }

    
}