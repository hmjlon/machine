package service;

import dto.AdminDto;
import dto.JoinDto;
import dto.MachineDto;
import repository.AdminRepository;
import repository.JoinRepository;

import java.awt.*;
import java.util.List;

public class AdminService {

    AdminRepository adminRepository = new AdminRepository();

    public int insertService(MachineDto dto) {
        return adminRepository.insertData(dto);
    }

    public int updateService(MachineDto dto) {
        return adminRepository.updateData(dto);
    }

    public int deleteService(MachineDto dto) {
        return adminRepository.deleteData(dto);
    }

    public List<MachineDto> viewService() {
        return adminRepository.viewMenu();

    }

    AdminRepository adminRepository = new AdminRepository();

    public int insertService(MachineDto dto) {
        return adminRepository.insertData(dto);
    }

    public int updateService(MachineDto dto) {
        return adminRepository.updateData(dto);
    }

    public int deleteService(MachineDto dto) {
        return adminRepository.deleteData(dto);
    }

    public List<MachineDto> viewService() {
        return adminRepository.viewMenu();

    }
}


