package hibernate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Employees")
@ToString
public class Employees implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Getter

    private Integer id;

    @Column(name = "LastName")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "FirstName")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "Address")
    @Getter
    @Setter
    private String address;

    @Column(name = "City")
    @Getter
    @Setter
    private String city;

    @Column(name = "Salary")
    @Getter
    @Setter
    private Integer salary;

    @Column(name = "Age")
    @Getter
    @Setter
    private Integer age;

    @Column(name = "StartJobDate")
    @Getter
    @Setter
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startJobDate;

    @Column(name = "Benefit")
    @Getter
    @Setter
    private int benefit;

    @Column(name = "Email")
    @Getter
    @Setter
    private String email;

    @OneToMany(mappedBy = "employees", orphanRemoval = true, fetch = FetchType.EAGER)
    @Getter
    @Setter
    @ToString.Exclude
    private Set<Cars> cars;

    @OneToMany(mappedBy = "employees", orphanRemoval = true, fetch = FetchType.EAGER)
    @Getter
    @Setter
    @ToString.Exclude
    private Set<Phones> phones;

    @OneToMany(mappedBy = "employees", orphanRemoval = true, fetch = FetchType.EAGER)
    @Getter
    @Setter
    @ToString.Exclude
    private Set<Printer> printers;

    public Employees() {
    }

    public Employees(String lastName, String firstName, String address, String city, int salary, int age, Date startJobDate, int benefit) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.salary = salary;
        this.age = age;
        this.startJobDate = startJobDate;
        this.benefit = benefit;
    }

}
