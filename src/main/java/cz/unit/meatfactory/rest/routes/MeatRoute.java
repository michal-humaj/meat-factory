package cz.unit.meatfactory.rest.routes;

import cz.unit.meatfactory.persistence.model.Meat;
import cz.unit.meatfactory.rest.controllers.MeatController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MeatRoute {

    @RequestMapping(value = "/meat", method = RequestMethod.POST)
    public void createMeat() {

    }

    @RequestMapping(value = "/meat/{id}", method = RequestMethod.GET)
    public Meat getMeat(@PathVariable(value = "id") Long id) {
        return MeatController.get(id);
    }

    @RequestMapping(value = "/meat", method = RequestMethod.GET)
    public List<Meat> getMeat() {
        return MeatController.getAll();
    }
}
