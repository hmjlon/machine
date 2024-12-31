package service;

import dto.JoinDto;
import repository.JoinRepository;

import java.util.Scanner;

public class JoinService {
    JoinRepository joinRepository = new JoinRepository();

    public int insertService(JoinDto dto) {
        return joinRepository.insertData(dto);
    }


}
