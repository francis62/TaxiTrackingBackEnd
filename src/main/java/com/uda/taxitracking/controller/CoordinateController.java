package com.uda.taxitracking.controller;

import com.uda.taxitracking.inicial.CoordinateSender;
import com.uda.taxitracking.model.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoordinateController {

    @Autowired
    private CoordinateSender coordinateSender;

    @MessageMapping("/taxi")
    @SendTo("/taxi/coordenada")
    public Coordinate envio(Coordinate coordinate) {
        // tareas del socket
        return coordinate;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/start")
    @ResponseBody
    public String startSendingCoordinates() {
        try {
            coordinateSender.startSendingCoordinates();
            return "Iniciado envío de coordenadas.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al iniciar el envío de coordenadas.";
        }
    }
}
