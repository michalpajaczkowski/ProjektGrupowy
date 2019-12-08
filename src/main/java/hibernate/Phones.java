package hibernate;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Phones")
@ToString
@RequiredArgsConstructor
public class Phones implements HibernateEntity {

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


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName = "ID")
    @Getter
    @Setter
    @NonNull
    public Employees employees;

    public Phones() {

    }

}

