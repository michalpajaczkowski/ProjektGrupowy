package hibernate;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Printer")
@Data
@RequiredArgsConstructor
public class Printer implements HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "model")
    @Getter
    @Setter
    @NonNull
    private String model;


    @Column(name = "producer")
    @Getter
    @Setter
    @NonNull
    private String producer;

    @Column(name = "cmyk")
    @Getter
    @Setter
    @NonNull
    private boolean cmyk;

    @Column(name = "localization")
    @Getter
    @Setter
    @NonNull
    private String localization;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false, referencedColumnName = "ID")
    @Getter
    @Setter
    @NonNull
    public Employees employees;

    public Printer() {
    }

}
