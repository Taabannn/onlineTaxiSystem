package ir.maktab58.onlinetaxisys.models.vehicle;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "vehicle_type")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String color;
    private String plateNumber;

    public Vehicle(String model, String color, String plateNumber) {
        this.model = model;
        this.color = color;
        this.plateNumber = plateNumber;
    }
}
