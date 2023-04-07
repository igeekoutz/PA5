public abstract class Person{
   //Attributes
    public String birthDate;
    public String firstName;
    public String lastName;
    public String role;
    
    //Constructor
    public Person(){
        
    }    
    
    // Methods (getters, setters)4
    public String getRole() {
        return role;
    }public void setRole(String role) {
        this.role = role;
    }

    public String getbirthDate() {
        return birthDate;
    }public void setbirthDate(String birthdate) {
        this.birthDate = birthdate;
    }
    
    public String getFirstName() {
        return firstName;
    }public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}