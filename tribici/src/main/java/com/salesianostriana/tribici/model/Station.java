package com.salesianostriana.tribici.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String coordinates;

    private int capacity;

    @OneToMany(mappedBy = "station")
    @ToString.Exclude
    @Builder.Default
    private List<Bicycle> bicycles = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Station station = (Station) o;
        return id != null && Objects.equals(id, station.id);
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public void addBicycle(Bicycle bicycle) {
        this.bicycles.add(bicycle);
        bicycle.setStation(this);
    }

    public void removeBicycle(Bicycle bicycle) {
        bicycles.remove(bicycle);
        bicycle.setStation(null);
    }

}
