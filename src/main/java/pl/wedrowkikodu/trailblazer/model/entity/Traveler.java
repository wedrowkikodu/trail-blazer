package pl.wedrowkikodu.trailblazer.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "travelers")
@Entity
public class Traveler {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traveler_seq_gen")
    @SequenceGenerator(name = "traveler_seq_gen", sequenceName = "traveler_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "email", length = 64)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "traveler_id")
    private List<TravelLog> travelLogs;
}
