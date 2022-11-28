package com.autumn.context;

import com.autumn.context.support.AutumnCoordinate;
import com.autumn.context.support.repository.DirectPluginImpl;
import com.autumn.context.repository.PluginRepositories;
import com.autumn.context.support.repository.MulitiPlugin;
import com.autumn.context.support.repository.SecondImplementPluginImpl;
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
public class PluginRepositoriesTest {

    private PluginRepositories pluginRepositories;

    @Before
    public void init() throws Exception {
        this.pluginRepositories = new PluginRepositories();
    }


    @Test
    public void testAddExtension() {
        AutumnCoordinate direct = new AutumnCoordinate(ONE, DIRECT);
        AutumnCoordinate second = new AutumnCoordinate(ONE, SECOND);
        DirectPluginImpl directPlugin = new DirectPluginImpl();
        SecondImplementPluginImpl secondImplementPlugin = new SecondImplementPluginImpl();
        pluginRepositories.addPlugin(direct, directPlugin);
        pluginRepositories.addPlugin(second, secondImplementPlugin);

        ValidatePasswordPlugin validatePasswordPlugin
                = pluginRepositories.getPlugin(direct, ValidatePasswordPlugin.class);
        Assert.assertEquals(directPlugin, validatePasswordPlugin);

        AutumnCoordinate thrid = new AutumnCoordinate(ONE, MULITI);
        MulitiPlugin mulitiPlugin = new MulitiPlugin();
        pluginRepositories.addPlugin(thrid, mulitiPlugin);
        ValidatePasswordPlugin thirdValidatePassword
                = pluginRepositories.getPlugin(thrid, ValidatePasswordPlugin.class);
        Assert.assertEquals(thirdValidatePassword, mulitiPlugin);


    }

}
