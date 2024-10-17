package com.gestion.velo.service;

import com.gestion.velo.entity.Staff;
import com.gestion.velo.entity.StaffDetails;
import com.gestion.velo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StaffDetailsService implements UserDetailsService {

    @Autowired
    private StaffRepository staffRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Staff staff = staffRepo.findByEmail(username);

        if(staff == null){
            System.out.println("Staff non trouvé");
            throw new UsernameNotFoundException("Staff non trouvé");
        }

        return new StaffDetails(staff);
    }
}
