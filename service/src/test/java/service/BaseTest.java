package service;

import configuration.ServiceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by Lino on 16.07.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
@Transactional
public abstract class BaseTest {
}
