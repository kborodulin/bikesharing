package BikeSharing.Erd.controller;

import BikeSharing.Erd.entity.Bike;
import BikeSharing.Erd.repository.interfaces.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Controller
public class BikeController {
    @Autowired
    BikeRepository bikeRepository;

    //{"model":"адидас","description":"Боже, Царя храни!","type":1}
    @PostMapping(value = "/bike/add")
    @ResponseBody
    public Serializable addBike(@RequestBody Bike eba) {
        return bikeRepository.saveBike(eba);//вернет id
    }

    //http://localhost:8080/bikesharing_war/bike/delete/1
    @RequestMapping(value = "/bike/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delBikeById(@PathVariable("id") long id) {
        return bikeRepository.delById(id);//вернет труе/фалсе
    }//todo сделать не удаление а активность=0, а селекты с проверкой активности

    //http://localhost:8080/bikesharing_war/bike/getall
    @RequestMapping(value = "/bike/getall", method = RequestMethod.GET)
    @ResponseBody
    public List<Bike> getBikeList() {
        return bikeRepository.findAll(); //вернет json типа [{"id":1,"model":"адидас","description":"Боже, Царя храни!","type":1}]
    }

    //http://localhost:8080/bikesharing_war/bike/get/1
    @RequestMapping(value = "/bike/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Bike getBikeById(@PathVariable("id") long id) {
        return bikeRepository.getById(id);//вернет json типа {"id":1,"model":"адидас","description":"Боже, Царя храни!","type":1}
    }

    //http://localhost:8080/bikesharing_war/bike/update/1
    //{"model":"Седан","description":"Боже, Царя храни!","type":1}
    @RequestMapping(value = "/bike/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Bike updateBikeById(@PathVariable("id") long id, @RequestBody Bike eba) {
        return bikeRepository.updateById(id, eba);//вернет json типа {"id":1,"model":"Седан","description":"Боже, Царя храни!","type":1}
    }
}
