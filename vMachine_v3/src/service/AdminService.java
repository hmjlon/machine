package service;

import dto.AdminDto;
import dto.JoinDto;
import dto.MachineDto;
import repository.AdminRepository;
import repository.JoinRepository;

public class AdminService {

     AdminRepository adminRepository = new AdminRepository();

    public int insertService(MachineDto dto) {
        return adminRepository.insertData(dto);
    }

}


