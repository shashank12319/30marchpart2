package com.wittybrains.busbookingsystem.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wittybrains.busbookingsystem.dto.BusDTO;
import com.wittybrains.busbookingsystem.service.BusService;





@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @PostMapping("/create")
    public ResponseEntity<List<BusDTO>> createBuses(@RequestBody List<BusDTO> busList) {
        List<BusDTO> createdBuses = busService.createBuses(busList);
        return new ResponseEntity<>(createdBuses, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<BusDTO> getBusById(@PathVariable Long id) {
		BusDTO bus = busService.getBusById(id);
		return ResponseEntity.ok().body(bus);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BusDTO> updateBus(@PathVariable Long id, @RequestBody BusDTO busDTO) {
		BusDTO updatedBus = busService.updateBus(id, busDTO);
		return ResponseEntity.ok().body(updatedBus);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBus(@PathVariable Long id) {
		busService.deleteBus(id);
		return ResponseEntity.ok().body("Bus with id " + id + " deleted successfully");
	}
}



