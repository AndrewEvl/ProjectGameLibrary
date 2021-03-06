package service;

import dao.interfaceDao.DeveloperDao;
import entity.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Lino on 25.06.2017.
 */
@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperDao developerDao;

    @Autowired
    public DeveloperServiceImpl (DeveloperDao developerDao){
        this.developerDao = developerDao;
    }

    
    @Override
    public Long save(Developer developer) {
        developerDao.save(developer);
        return developer.getId();
    }
    
    @Override
    public Developer findById(Long developerId) {
        return developerDao.findById(developerId);
    }
}
