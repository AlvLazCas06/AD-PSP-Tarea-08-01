package com.salesianostriana.tribici.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Use {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "bicycle_id")
    private Bicycle bicycle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    /*
     * Los primeros 30 minutos, gratis.
     * */
    public double calculatePrice(LocalDateTime finish) {
        long duration = ChronoUnit.MINUTES.between(startDate, finish);
        double price = 0.0;
        long calculate = duration;

        calculate -= 30;

        if (calculate > 60) {
            price = (calculate - 60) * 0.025 + 60 *0.015;
        } else {
            price = calculate * 0.015;
        }

        return price;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Use use = (Use) o;
        return id != null && Objects.equals(id, use.id);
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
