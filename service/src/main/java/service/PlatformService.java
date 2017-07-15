package service;

import entity.Platform;

import java.util.List;

/**
 * Created by Lino on 15.07.2017.
 */
public interface PlatformService {

    List<Platform> findAll();

    void save(Platform platform);
}
