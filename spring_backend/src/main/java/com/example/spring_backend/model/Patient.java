package com.example.spring_backend.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Please provide patient name")
    @Column(name = "patient_Name")
    private String patientName;

    @Column(name = "p_gender")
    private String pgender;

    @Column(name = "p_age")
    private int page;

    @Column(name = "p_dob")
    private String dob;

    @Size(max = 11, message = "Please enter 11 digit phone number")
    @Column(name = "phone_Number")
    private String phoneNumber;

    @Email(message = "Please enter valid email address")
    @Column(name = "email_Id")
    private String emailId;

    @Column(name = "p_address")
    private String paddress;

    @Column(name = "p_photo")
    private String pphoto;

    public Patient() {
    }

    public Patient(String patientName, String pgender, int page, String dob, String phoneNumber, String emailId, String paddress, String pphoto) {
        this.patientName = patientName;
        this.pgender = pgender;
        this.page = page;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.paddress = paddress;
        this.pphoto = pphoto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPgender() {
        return pgender;
    }

    public void setPgender(String pgender) {
        this.pgender = pgender;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPphoto() {
        return pphoto;
    }

    public void setPphoto(String pphoto) {
        this.pphoto = pphoto;
    }
}
