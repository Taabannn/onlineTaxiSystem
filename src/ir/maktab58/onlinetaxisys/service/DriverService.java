package ir.maktab58.onlinetaxisys.service;

import ir.maktab58.onlinetaxisys.dao.DriverDao;
import ir.maktab58.onlinetaxisys.models.Driver;
import ir.maktab58.onlinetaxisys.models.Passenger;

import java.util.List;

/**
 * @author Taban Soleymani
 */
public class DriverService {
    private final DriverDao driverDao = new DriverDao();

    public List<Driver> getAllDrivers() {
        return driverDao.getAllDrivers();
    }

    public int saveNewDriver(Driver driver) {
        return driverDao.save(driver);
    }

    public List<Driver> getDriverByUsername(String username) {
        return driverDao.findDriverByUsername(username);
    }

    public List<Driver> getDriverByNationalCode(String nationalCode) {
        return driverDao.findDriverByNationalCode(nationalCode);
    }

    public int getDriverIdByUserAndPass(String username, String password) {
        Driver driver = driverDao.findDriverByUserAndPass(username, password);
        if (driver != null)
            return  driver.getDriverId();
        return 0;
    }
}