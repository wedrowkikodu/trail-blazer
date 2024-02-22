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
@Table(name = "trails")
@Entity
public class Trail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trail_seq_gen")
    @SequenceGenerator(name = "trail_seq_gen", sequenceName = "trail_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "distance")
    private int distance;

    @Column(name = "difficulty", length = 16)
    private String difficulty;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "trail_id")
    private List<Landmark> landmarks;
}
