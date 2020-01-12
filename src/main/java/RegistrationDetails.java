public class RegistrationDetails {

    // This is the class that stores all the registered user details. Objects of this should be stored in the database.
    private String name;
    private String email;
    private String phone;
    private String typeofDiabetes;
    private String insulinAdmin;
    private String doctorname;
    private String doctoremail;
    private String doctorphone;
    private String username;
    private String password;

    RegistrationDetails(){

    }

    //Methods to access the registration details and also to modify them when needed.

    public void setName(String uiName){
        name = uiName;
    }
    public String getName(){
        return name;
    }

    public void setEmail(String uiEmail){
        email = uiEmail;
    }

    public String getEmail(){return email;}

    public void setPhone(String uiPhone){
        phone = uiPhone;
    }

    public String getPhone(){return phone;}

    public void setTypeofDiabetes(String uiTypeofDiabetes){
        typeofDiabetes = uiTypeofDiabetes;
    }
    public String getTypeofDiabetes(){
        return typeofDiabetes;
    }

    public void setInsulinAdmin(String uiInsulinAdmin){
        insulinAdmin = uiInsulinAdmin;
    }

    public String getInsulinAdmin(){
        return insulinAdmin;
    }

    public void setDoctorname(String uiDocName){
        doctorname = uiDocName;
    }
    public String getDoctorname(){
        return doctorname;
    }

    public void setDoctoremail(String uiDocEmail){
        doctoremail = uiDocEmail;
    }

    public String getDoctorEmail(){return doctoremail;}

    public void setDoctorphone(String uiDocPhone){
        doctorphone = uiDocPhone;
    }

    public String getDoctorphone(){return doctorphone;}

    public void setUserName(String uiUserName){
        username = uiUserName;
    }
    public String getUserName(){
        return username;
    }

    public void setPassword(String uiPassword){
        password = uiPassword;
    }

    public String getPassword(){
        return password;
    }


}
