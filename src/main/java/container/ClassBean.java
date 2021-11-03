package container;

import annotation.Component;
import annotation.Controller;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.*;

public class ClassBean {

    public final Map<String, Object> beanFactory = new HashMap<>();

    public ClassBean() throws NoSuchMethodException {
        init();
    }

//    [class container.ControllerMethodBean, class request.HttpRequestInfo,
//    interface annotation.GetMapping, class request.RequestHeader,
//    interface annotation.Controller, class request.RequestBody,
//    class db.DataBase, interface annotation.Component, class service.UserService,
//    class webserver.WebServer, interface annotation.PostMapping,
//    class container.ComponentClassBean, class container.ClassBean,
//    class request.StartLine, class util.HttpRequestUtils, class controller.UserController,
//    class util.IOUtils, class model.User, class util.HttpRequestUtils$Pair]

    private void init() throws NoSuchMethodException {
        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflectionss = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false), new ResourcesScanner())
                .setUrls(ClasspathHelper.forPackage(""))
                .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(""))));
        Set<Class<?>> classes = reflectionss.getSubTypesOf(Object.class);

        for (Class<?> clazz : classes) {
            System.out.println(clazz.getName() +  " : " + clazz.isInterface());
                Class<?>[] cla = clazz.getDeclaredConstructor().getParameterTypes();
//                Object newClass = clazz.getConstructor().newInstance();
//                beanFactory.put(clazz.getName(), newClass);
        }
    }

    private boolean verifyBean(String beanName) {
        return beanFactory.containsKey(beanName);
    }
}
