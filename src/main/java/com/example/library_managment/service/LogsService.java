package com.example.library_managment.service;

import com.example.library_managment.model.Logs;
import com.example.library_managment.repository.LogsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogsService {


    private final LogsRepository logsRepository;

    public void addLog(String message){
        logsRepository.save(new Logs(message));
    }
}
