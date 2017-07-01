package service;

import entity.Developer;

import java.util.List;

/**
 * Created by Lino on 25.06.2017.
 */
public interface DeveloperService {

    Long save(Developer developer);

    Developer findById (Long developerId);

    List<Developer> getAll ();

}
