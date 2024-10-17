package com.gestion.velo.controller;

import com.gestion.velo.dto.StaffDTO;
import com.gestion.velo.service.StaffService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/staffs")
@AllArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/login")
    public String login(@RequestBody StaffDTO staffDTO){
        return staffService.verify(staffDTO);
    }

    @PostMapping
    public ResponseEntity<StaffDTO> addStaff(@Valid @RequestBody StaffDTO staffDTO) {
        StaffDTO createdStaff = staffService.addStaff(staffDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStaff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffDTO> updateStaff(@PathVariable int id, @Valid @RequestBody StaffDTO staffDTO) {
        return ResponseEntity.ok(staffService.updateStaff(id, staffDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable int id) {
        staffService.deleteStaffById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffDTO> findStaffById(@PathVariable int id) {
        return ResponseEntity.ok(staffService.findStaffById(id));
    }

    @GetMapping
    public ResponseEntity<List<StaffDTO>> findAllStaffs() {
        return ResponseEntity.ok(staffService.findAllStaffs());
    }

}
