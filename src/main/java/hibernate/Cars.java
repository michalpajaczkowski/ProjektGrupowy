package hibernate;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cars")
@ToString
@RequiredArgsConstructor
public class Cars implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;


    @Column(name = "name")
    @Getter
    @Setter
    @NonNull
    private String name;

    @Column(name = "model")
    @Getter
    @Setter
    @NonNull
    private String model;

    @Column(name = "registrationDate")
    @Getter
    @Setter
    @NonNull
    private Date registrationDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName = "ID")
    @Getter
    @Setter
    @NonNull
    public Employees employees;


    public Cars() {

    }


}
