package com.pickcar.vehicle.application;

import com.pickcar.vehicle.domain.Vehicle;
import com.pickcar.vehicle.domain.VehicleInfo;
import com.pickcar.vehicle.domain.VehicleStatus;
import com.pickcar.vehicle.infrastructure.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Transactional
    public void create(VehicleInfo info) {

        validateDouplicateLicensePlate(info.getLicensePlate());

        //FIXME : 전체적으로 하드코딩 금지
        Vehicle vehicle = Vehicle.builder()
                .info(info)
                .hasGps(true)
                .isRented(false)
                .isActive(true)
                .status(VehicleStatus.OPERABLE)
                .build();

        vehicleRepository.save(vehicle);
    }

    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] Car Not Found By Id " + id));
    }

    public List<Vehicle> getAll(){
        return vehicleRepository.findAll();
    }

//    private boolean hasLicensePlateAlready(String licensePlate) {
//        return vehicleRepository.findByInfo_LicensePlate(licensePlate).isPresent();
//    }

    private void validateDouplicateLicensePlate(String licensePlate) {
        boolean exists = vehicleRepository.findByInfo_LicensePlate(licensePlate).isPresent();
        if(exists){
            throw new IllegalArgumentException("[ERROR] 동일한 번호판을 사용하는 자동차가 이미 존재합니다.");
        }
    }
}
