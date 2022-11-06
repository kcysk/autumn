package com.autumn.boot.extension;

import com.autumn.context.support.AutumnCoordinate;
import com.autumn.context.support.exception.NoCoordinateException;
import com.autumn.context.support.exception.NoUniqueCoordinateException;
import com.autumn.context.support.repository.ExtensionRepository;
import com.autumn.core.Plugin;
import com.autumn.core.annotations.Extension;
import com.autumn.core.annotations.Grid;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Map;
import java.util.Objects;

/**
 * @author shenke
 * @since 2022/11/6 16:14
 */
public class PluginRegister implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private final ExtensionRepository extensionRepository;

    public PluginRegister(ExtensionRepository extensionRepository) {
        this.extensionRepository = extensionRepository;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void registerPlugin() {
        for (Map.Entry<String, ? extends Plugin> entry : applicationContext.getBeansOfType(Plugin.class).entrySet()) {
            Plugin plugin = entry.getValue();
            Extension extension = AnnotationUtils.findAnnotation(plugin.getClass(), Extension.class);
            if (Objects.isNull(extension)) {
                throw new NoCoordinateException(String.format("%s must have @Extension annotation",
                        plugin.getClass().getName()));
            }
            Grid[] coordinates = extension.coordinates();
            if (coordinates == null || coordinates.length == 0) {
                throw new NoCoordinateException(String.format("%s annotation Extension#coordinates is empty",
                        plugin.getClass().getName()));
            }
            for (Grid coordinate : coordinates) {
                for (final String businessIdentity : coordinate.businessIdentity()) {
                    AutumnCoordinate actualCoordinate = new AutumnCoordinate(
                            coordinate::scenario,
                            () -> businessIdentity
                    );
                    Plugin alreadyPlugin = extensionRepository.getExtension(actualCoordinate, plugin.getClass());
                    if (alreadyPlugin != null) {
                        throw new NoUniqueCoordinateException(String.format("already exists plugin %s with coordinate %s",
                                alreadyPlugin, actualCoordinate));
                    }
                    extensionRepository.addExtension(actualCoordinate, plugin);
                }
            }
        }
    }
}
