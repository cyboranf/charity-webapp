package pl.project.charity.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "quantity")
    private int quantity;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();
    @OneToOne(fetch = FetchType.EAGER)
    private Institution institution;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private  String zipCode;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;
    @Column(name = "pick_up_comment")
    private String pickUpComment;



}
