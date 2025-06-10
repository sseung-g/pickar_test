package com.pickcar.vehicle.presentation.dto.request;

import com.pickcar.vehicle.domain.FuelType;
import com.pickcar.vehicle.domain.VehicleInfo;

public record VehicleInfoRequest(
        String model,
        String color,
        String licensePlate,
        String carAge,
        String brandName,
        FuelType fuelType
) {
    public VehicleInfo toInfo() {
        return new VehicleInfo(
                this.model,
                this.color,
                this.licensePlate,
                this.carAge,
                this.brandName,
                this.fuelType
        );
    }
}
