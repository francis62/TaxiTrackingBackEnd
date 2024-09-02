package com.uda.taxitracking.inicial;

import com.uda.taxitracking.model.Coordinate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoordinateSender {

    private final SimpMessagingTemplate template;

    public CoordinateSender(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void startSendingCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(51.50520527706977, -0.1382001014766732));
        coordinates.add(new Coordinate(51.506060471919554, -0.13905812530414122));
        coordinates.add(new Coordinate(51.5070225469402, -0.1400877538971268));
        coordinates.add(new Coordinate(51.507663919001885, -0.14077417295909722));
        coordinates.add(new Coordinate(51.50851906770676, -0.138714915773146));
        coordinates.add(new Coordinate(51.50873285237517, -0.13734207764918516));
        coordinates.add(new Coordinate(51.50958798101733, -0.13579763475972675));
        coordinates.add(new Coordinate(51.51022931696616, -0.13476800616674112));
        coordinates.add(new Coordinate(51.51129819015172, -0.13356677280825793));
        coordinates.add(new Coordinate(51.51193950202568, -0.1316791203878043));
        coordinates.add(new Coordinate(51.512901452909205, -0.12961986320185306));
        coordinates.add(new Coordinate(51.51193950202568, -0.12876183937436506));
        coordinates.add(new Coordinate(51.51097753082923, -0.12841862984338984));
        coordinates.add(new Coordinate(51.50958798101733, -0.127903815546897));
        coordinates.add(new Coordinate(51.508839744333166, -0.12738900125040423));
        coordinates.add(new Coordinate(51.5079846016471, -0.12721739648490663));
        coordinates.add(new Coordinate(51.509053527496846, -0.12498653453345777));
        coordinates.add(new Coordinate(51.50990865012026, -0.12275567258200895));
        coordinates.add(new Coordinate(51.51097753082923, -0.1203532058650625));
        coordinates.add(new Coordinate(51.51129819015172, -0.11829394867911128));
        coordinates.add(new Coordinate(51.51022931696616, -0.11812234391361366));
        coordinates.add(new Coordinate(51.50948109081482, -0.1191519725065793));
        coordinates.add(new Coordinate(51.50862596016634, -0.1208680201615553));
        coordinates.add(new Coordinate(51.50723633863057, -0.12155443922352573));
        coordinates.add(new Coordinate(51.50616737014722, -0.12292727734750654));
        coordinates.add(new Coordinate(51.504456968409706, -0.12327048687850174));
        coordinates.add(new Coordinate(51.50328102997258, -0.12361369640949693));
        coordinates.add(new Coordinate(51.5018912454229, -0.12412851070596977));
        coordinates.add(new Coordinate(51.50114288234036, -0.12378530117499453));
        coordinates.add(new Coordinate(51.50082215154299, -0.12172604398902334));
        coordinates.add(new Coordinate(51.500715240775605, -0.11880876297560407));
        coordinates.add(new Coordinate(51.500501418488426, -0.11760752961712086));
        coordinates.add(new Coordinate(51.500501418488426, -0.11709271532062805));
        coordinates.add(new Coordinate(51.499004634388534, -0.112802596183228));
        coordinates.add(new Coordinate(51.498149307117934, -0.11040012946628153));
        coordinates.add(new Coordinate(51.49761471942267, -0.1079976627493351));
        coordinates.add(new Coordinate(51.496224762070554, -0.10473717220490066));
        coordinates.add(new Coordinate(51.49697320591172, -0.10422235790842782));
        coordinates.add(new Coordinate(51.497507801131185, -0.10353593884643743));
        coordinates.add(new Coordinate(51.498790804075725, -0.10456556743942304));
        coordinates.add(new Coordinate(51.50039450696865, -0.10490877697039826));
        coordinates.add(new Coordinate(51.50146361088052, -0.10456556743942304));
        coordinates.add(new Coordinate(51.50242578295791, -0.10422235790842782));

        enviarCoordenadasPeriodicamente(coordinates);
    }

    private void enviarCoordenadasPeriodicamente(List<Coordinate> coordinates) {
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
        template.convertAndSend("/taxi/coordenada", coordinate);
        System.out.println("Coordenada enviada: " + coordinate);
    }
}
