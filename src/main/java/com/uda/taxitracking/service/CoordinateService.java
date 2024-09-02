package com.uda.taxitracking.service;

import com.uda.taxitracking.model.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinateService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void enviarCoordenadasPeriodicamente(List<Coordinate> coordinates) {
        for (Coordinate coordinate : coordinates) {
            enviarCoordenada(coordinate);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void enviarCoordenada(Coordinate coordinate) {
        messagingTemplate.convertAndSend("/taxi/coordenada", coordinate);
        System.out.println("Coordenada enviada: " + coordinate);
    }
}
