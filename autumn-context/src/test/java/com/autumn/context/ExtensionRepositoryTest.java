package com.autumn.context;

import com.autumn.context.support.AutumnCoordinate;
import com.autumn.context.support.repository.CommonBusinessIdentity;
import com.autumn.context.support.repository.CommonScenario;
import com.autumn.context.support.repository.DirectPluginImpl;
import com.autumn.context.support.repository.ExtensionRepository;
import com.autumn.context.support.repository.MulitiPlugin;
import com.autumn.context.support.repository.SecondImplementPluginImpl;
import com.autumn.context.support.repository.ValidateAccountStatusPlugin;
import com.autumn.context.support.repository.ValidatePasswordPlugin;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.autumn.context.support.repository.CommonBusinessIdentity.DIRECT;
import static com.autumn.context.support.repository.CommonBusinessIdentity.MULITI;
import static com.autumn.context.support.repository.CommonBusinessIdentity.SECOND;
import static com.autumn.context.support.repository.CommonScenario.ONE;

/**
 * @author shenke
 * @since 2022/11/5 13:28
 */
public class ExtensionRepositoryTest {

    private ExtensionRepository extensionRepository;

    @Before
    public void init() throws Exception {
        this.extensionRepository = new ExtensionRepository();
    }


    @Test
    public void testAddExtension() {
        AutumnCoordinate direct = new AutumnCoordinate(ONE, DIRECT);
        AutumnCoordinate second = new AutumnCoordinate(ONE, SECOND);
        DirectPluginImpl directPlugin = new DirectPluginImpl();
        SecondImplementPluginImpl secondImplementPlugin = new SecondImplementPluginImpl();
        extensionRepository.addExtension(direct, directPlugin);
        extensionRepository.addExtension(second, secondImplementPlugin);

        ValidatePasswordPlugin validatePasswordPlugin
                = extensionRepository.getExtension(direct, ValidatePasswordPlugin.class);
        Assert.assertEquals(directPlugin, validatePasswordPlugin);

        AutumnCoordinate thrid = new AutumnCoordinate(ONE, MULITI);
        MulitiPlugin mulitiPlugin = new MulitiPlugin();
        extensionRepository.addExtension(thrid, mulitiPlugin);
        ValidatePasswordPlugin thirdValidatePassword
                = extensionRepository.getExtension(thrid, ValidatePasswordPlugin.class);
        Assert.assertEquals(thirdValidatePassword, mulitiPlugin);


    }

}
