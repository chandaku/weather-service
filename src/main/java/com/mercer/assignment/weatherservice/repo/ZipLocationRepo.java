package com.mercer.assignment.weatherservice.repo;

import com.mercer.assignment.weatherservice.model.Location;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZipLocationRepo implements LocationRepo {
    static Map<Integer, Location> map = new HashMap<>();
    static {
        map.put(110001, new Location(28.6327, 77.2196));
        map.put(126102, new Location(29.2857, 76.2943));
    }

    public Location getLocation(Object zip) {
        return zip instanceof Integer ?
                map.get(zip) :
                null;
    }
}
