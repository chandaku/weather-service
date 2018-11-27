package com.mercer.assignment.weatherservice.repo;

import com.mercer.assignment.weatherservice.model.Location;

import java.util.HashMap;
import java.util.Map;

public interface LocationRepo {
    Location getLocation(Object zip);
}
