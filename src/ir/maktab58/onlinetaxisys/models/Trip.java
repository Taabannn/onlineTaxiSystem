package ir.maktab58.onlinetaxisys.models;

import ir.maktab58.onlinetaxisys.enumeration.PaymentMode;
import ir.maktab58.onlinetaxisys.enumeration.TripStatus;
import lombok.*;

import javax.persistence.*;

/**
 * @author Taban Soleymani
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int travelId;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Driver driver;
    @OneToOne
    private Coordinate source;
    @OneToOne
    private Coordinate destination;
    @Enumerated(EnumType.STRING)
    private TripStatus status;
    private boolean isPaid;
    private long cost;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Builder(setterPrefix = "with")
    public Trip(int travelId, Passenger passenger, Driver driver, Coordinate source, Coordinate destination, TripStatus status, boolean isPaid, long cost, PaymentMode paymentMode) {
        this.travelId = travelId;
        this.passenger = passenger;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
        this.status = status;
        this.isPaid = isPaid;
        this.cost = cost;
        this.paymentMode = paymentMode;
    }
}

