package com.gestion.velo.service;

import com.gestion.velo.dto.StaffDTO;
import com.gestion.velo.entity.Staff;
import com.gestion.velo.entity.Store;
import com.gestion.velo.mapper.StaffMapper;
import com.gestion.velo.repository.StaffRepository;
import com.gestion.velo.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StaffService {
    private final StaffRepository staffRepo;
    private final StoreRepository storeRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final StaffMapper staffMapper = StaffMapper.INSTANCE;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public StaffDTO addStaff(StaffDTO staffDTO) {
        Staff staff = staffMapper.staffDTOToStaff(staffDTO);

        String hashedPassword = encoder.encode(staffDTO.getPhone());
        staff.setPhone(hashedPassword);

        if (staffDTO.getStoreId() != null) {
            Store store = storeRepo.findById(staffDTO.getStoreId())
                    .orElseThrow(() -> new RuntimeException("Store not found"));
            staff.setStore(store);
        }

        if (staffDTO.getManagerId() != null) {
            Staff manager = staffRepo.findById(staffDTO.getManagerId())
                    .orElseThrow(() -> new RuntimeException("Manager not found"));
            staff.setManager(manager);
        }

        return staffMapper.staffToStaffDTO(staffRepo.save(staff));
    }

    public StaffDTO updateStaff(int id, StaffDTO staffDTO) {
        if (!staffRepo.existsById(id)) {
            throw new RuntimeException("Employé non trouvé");
        }
        Staff staff = staffMapper.staffDTOToStaff(staffDTO);
        staff.setStaffId(id);

        if (staffDTO.getPhone() != null && !staffDTO.getPhone().isEmpty()) {
            String hashedPassword = encoder.encode(staffDTO.getPhone());
            staff.setPhone(hashedPassword);
        }

        if (staffDTO.getStoreId() != null) {
            Store store = storeRepo.findById(staffDTO.getStoreId())
                    .orElseThrow(() -> new RuntimeException("Store not found"));
            staff.setStore(store);
        } else {
            staff.setStore(null);
        }

        if (staffDTO.getManagerId() != null) {
            Staff manager = staffRepo.findById(staffDTO.getManagerId())
                    .orElseThrow(() -> new RuntimeException("Manager not found"));
            staff.setManager(manager);
        } else {
            staff.setManager(null);
        }

        return staffMapper.staffToStaffDTO(staffRepo.save(staff));
    }

    public void deleteStaffById(int id) {
        if (!staffRepo.existsById(id)) { throw new RuntimeException("Employé non trouvé"); }
        staffRepo.deleteById(id);
    }

    public StaffDTO findStaffById(int id) {
        return staffRepo.findById(id).map(staffMapper::staffToStaffDTO).orElseThrow(() -> new RuntimeException("Employé non trouvé"));
    }

    public List<StaffDTO> findAllStaffs() {
        return staffMapper.staffsToStaffDTOs(staffRepo.findAll());
    }

    public String verify(StaffDTO staffDTO) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(staffDTO.getEmail(), staffDTO.getPhone()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(staffDTO.getEmail());
        }else{
            return "fail";
        }
    }
}
