package pl.project.charity.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quantity")
    private int quantity;
    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty(message = "{categories.notEmpty}")
    private List<Category> categories = new ArrayList<>();
    @ManyToOne (fetch = FetchType.EAGER)
    @NotNull(message = "{institution.notNull}")
    private Institution institution;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private  String zipCode;
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @Column(name = "time")
    private LocalTime pickUpTime;
    @Column(name = "pick_up_comment")
    private String pickUpComment;



}
