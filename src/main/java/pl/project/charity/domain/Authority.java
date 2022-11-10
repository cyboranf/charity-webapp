package pl.project.charity.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String email;

    @Column(length = 30)
    private String authority;

    public Authority(String email, String authority) {
        this.email = email;
        this.authority = authority;
    }

    public Authority() {

    }
}
