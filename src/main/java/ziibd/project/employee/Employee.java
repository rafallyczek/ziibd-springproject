package ziibd.project.employee;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name="EMPLOYEES")
public class Employee {

    //Pola (Kolumny z tabeli EMPLOYEES)
    //Klucz główny
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;

    //Pozostałe kolumny
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phone;
    @Column(name = "HIRE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name="JOB_ID")
    private String job;
    @Column(name="DEPARTMENT_ID")
    private Integer dept;
    @Column(name="MANAGER_ID")
    private Integer mgr;
    @Column(name = "SALARY")
    private Integer salary;
    @Column(name = "COMMISSION_PCT")
    private Float comm;

    //Konstruktory
    public Employee() {}

    public Employee(int id, String firstName, String lastName, String email, String phone, Date date, String job, int salary, Float comm, int mgr, int dept) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
        this.job=job;
        this.salary=salary;
        this.comm=comm;
        this.mgr=mgr;
        this.dept=dept;
        this.date=date;
    }

    //Gettery i Settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Float getComm() {
        return comm;
    }

    public void setComm(Float comm) {
        this.comm = comm;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }
}
