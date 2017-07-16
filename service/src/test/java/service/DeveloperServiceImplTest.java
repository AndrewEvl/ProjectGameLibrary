package service;

import entity.Developer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lino on 16.07.2017.
 */
public class DeveloperServiceImplTest extends BaseTest{


    @Autowired
    private DeveloperService developerService;

    @Test
    public void save (){
        Developer developer = new Developer();
        developer.setName("dao");
        developerService.save(developer);
    }

}