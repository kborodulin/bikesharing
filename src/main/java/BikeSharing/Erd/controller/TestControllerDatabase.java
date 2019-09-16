package BikeSharing.Erd.controller;

import BikeSharing.Erd.entity.TestEntity;
import BikeSharing.Erd.repository.interfaces.TestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class TestControllerDatabase {
    @Autowired
    TestEntityRepository testEntityRepository;

    @Controller
    public class TestControllerServlet {
        @RequestMapping(value = "/testdb", method = RequestMethod.GET)
        @ResponseBody
        public String testController() {
            TestEntity testEntity = new TestEntity();
            testEntity.setStartapp(LocalDateTime.now().withNano(0));
            testEntityRepository.saveTestEntity(testEntity);
            return "TestControllerDatabase!!!";
        }
    }
}
