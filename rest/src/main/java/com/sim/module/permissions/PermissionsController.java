package com.sim.module.permissions;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PermissionsController {

  @RequestMapping(value = "/permissions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Map<String, String> checkHealth() {
    final HashMap<String, String> map = new HashMap<>();
    map.put("permissions", "OK");
    return map;
  }
}
