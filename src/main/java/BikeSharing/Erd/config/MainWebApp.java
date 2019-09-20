package BikeSharing.Erd.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MainWebApp extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { ConfigHibernate.class, ConfigDatabase.class };
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { ConfigWebApp.class };
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}