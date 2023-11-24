package by.pvt.shawarma.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(schema = "shaurmasch", name = "comment")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @Column(name = "commentary")
    private String comment;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;
}
