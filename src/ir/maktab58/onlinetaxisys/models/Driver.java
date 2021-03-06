package ir.maktab58.onlinetaxisys.models;

import ir.maktab58.onlinetaxisys.enumeration.StateOfAttendance;
import ir.maktab58.onlinetaxisys.models.vehicle.Vehicle;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "nationalCode")
@ToString
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private String phoneNumber;
    private String nationalCode;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    private StateOfAttendance stateOfAttendance = StateOfAttendance.WAITING_FOR_TRAVEL;
    private long wallet;
    @OneToOne(cascade = CascadeType.ALL)
    private Coordinate currentLocation;

    @Builder(setterPrefix = "with")
    public Driver(int driverId, String username, String password, String firstName, String lastName, Date birthDate, String phoneNumber, String nationalCode, Vehicle vehicle, StateOfAttendance stateOfAttendance, long wallet, Coordinate currentLocation) {
        this.driverId = driverId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.vehicle = vehicle;
        this.stateOfAttendance = stateOfAttendance;
        this.wallet = wallet;
        this.currentLocation = currentLocation;
    }
}
