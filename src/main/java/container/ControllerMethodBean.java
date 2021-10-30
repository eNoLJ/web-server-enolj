package container;

import annotation.Controller;
import annotation.GetMapping;
import annotation.PostMapping;
import org.reflections.Reflections;
import util.status.HttpMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ControllerMethodBean {

    public final Map<String, Map<HttpMethod, Method>> beanFactory = new HashMap<>();

    public ControllerMethodBean() {
        init();
    }

    public Method findControllerMethod(String url, HttpMethod method) {
        return beanFactory.get(url).get(method);
    }

    private void init() {
        findControllerClass();
    }

    private void findControllerClass() {
        Reflections reflections = new Reflections("controller");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Controller.class);

        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(GetMapping.class)) {
                    beanFactory.put(method.getDeclaredAnnotation(GetMapping.class).value(),
                            new HashMap<HttpMethod, Method>(){{ put(HttpMethod.GET, method); }});
                }
                if (method.isAnnotationPresent(PostMapping.class)) {
                    beanFactory.put(method.getDeclaredAnnotation(PostMapping.class).value(),
                            new HashMap<HttpMethod, Method>(){{ put(HttpMethod.POST, method); }});
                }
            }
        }
    }
}
