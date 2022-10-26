package pl.project.charity.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "institution")
public class Institution {
    @Id
    @Column(name = "institution_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


}
