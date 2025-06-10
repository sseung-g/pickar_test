package com.pickcar.vehicle.presentation.controller;

import com.pickcar.vehicle.application.VehicleService;
import com.pickcar.vehicle.domain.Vehicle;
import com.pickcar.vehicle.domain.VehicleInfo;
import com.pickcar.vehicle.presentation.dto.request.VehicleInfoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public void createVehicle(@RequestBody VehicleInfoRequest request){
        log.info("POST VehicleInfoRequest : {} " ,request);
        vehicleService.create(request.toInfo());
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicle(){
        List<Vehicle> vehicles = vehicleService.getAll();
        return ResponseEntity.ok(vehicles);
    }

//    @PatchMapping
//    public ResponseEntity<VehicleResponse> updateVehiclePartial(
//            @PathVariable Long id,
//            @RequestBody Map<String, Object> updates) {
//
//        Vehicle updatedVehicle = vehicleService.updatePartial(id, updates);
//
//        VehicleResponse response = new VehicleResponse(updatedVehicle);
//        return ResponseEntity.ok(response);
//    }
}
