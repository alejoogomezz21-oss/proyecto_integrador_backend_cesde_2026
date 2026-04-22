package co.edu.cesde.ga.aplicacion.models;


public class Person {
    protected String firstName; // first_name
    protected String lastName;  // last_name
    protected String documentNumber; // document_number
    protected String code; // code

    public Person() {}

    public Person(String firstName, String lastName, String documentNumber, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
        this.code = code;
    }

    // Getters y Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}

