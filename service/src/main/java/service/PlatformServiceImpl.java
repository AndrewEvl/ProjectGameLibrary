package service;

import dao.interfaceDao.PlatformDao;
import entity.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Lino on 15.07.2017.
 */
@Service
@Transactional
public class PlatformServiceImpl implements PlatformService {

    private final PlatformDao platformDao;

    @Autowired
    public PlatformServiceImpl(PlatformDao platformDao) {
        this.platformDao = platformDao;
    }

    @Override
    public List<Platform> findAll() {
        return platformDao.findAll();
    }

    @Override
    public void save(Platform platform) {
        platformDao.save(platform);
    }


}
