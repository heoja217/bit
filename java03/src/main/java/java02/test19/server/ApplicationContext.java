package java02.test19.server;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import java02.test19.server.annotation.Component;

import org.apache.log4j.Logger;
import org.reflections.Reflections;

/* Bean Container
  1) 빈 생성관리
  2) 의존객체 자동 주입

 * Log4j
  로그 레벨에따라 출력을 제어할 수 있음
  로그레벨
  1) TRACE
  2) DEBUG
  3) INFO
  4) WARN
  5) ERROR OR FATAL
    => 로그 출력 레벨 설정
  1) TRACE로 설정하면 TRACE 이하 모든 로그들을 출력.
  2) WARN레벨로 설정하면 WARN이하, ERROR, FATAL레벨까지도 출력.
    => 로그 설정
    log4j.properties파일 참조 
*/
public class ApplicationContext {
  static Logger log = Logger.getLogger(ApplicationContext.class);
  
  HashMap<String, Object> objPool = new HashMap<>();
  
  public ApplicationContext(String packageName) throws Exception {
    prepareObjects(packageName);
  }
  
  private void prepareObjects(String packageName) throws Exception {
    Reflections reflections = new Reflections(packageName);
    Set<Class<?>> clazzList = 
        reflections.getTypesAnnotatedWith(Component.class);
    
    Object instance = null;
    String instanceName = null;
    Component compAnno = null;
        
    for (Class clazz : clazzList) {
      instance = clazz.newInstance();
      // 클래스 관리자에게서 Component 애노테이션 정보 얻기
      compAnno = (Component) clazz.getAnnotation(Component.class);
      
      if (compAnno.value().equals("")) {
        objPool.put(clazz.getName(), instance);
      } else {
        objPool.put(compAnno.value(), instance);
      }
    }
  }
  
  public void addBean(String key, Object instance) {
    objPool.put(key, instance);
  }
  
  public void injectDependency() throws Exception {
    Method[] methods = null;
    Parameter parameter = null;
    
    Object dependency = null;
    
    // objPool에서 객체를 하나 꺼낸다
    for (Object obj : objPool.values()) {
      // 그 객체에서 setter 메서드를 꺼낸다
      methods = obj.getClass().getMethods();
      log.debug(obj.getClass().getName());
      for (Method m : methods) {
        if (m.getName().startsWith("set")) {
          log.debug("   " + m.getName());
          // setter 메서드이 파라미터 타입 알아내기.
          parameter = m.getParameters()[0];
          //log.debug("       " + parameter.getType().getName());
          // setter 메서드의 파라미터 타입과 일치하는 객체를 찾는다.
          //dependency = findDependency(parameter.getType());
          dependency = findDependency(m.getParameterTypes()[0]);
          log.debug("       " + m.getParameterTypes()[0].getName());          
          if (dependency != null) {
            // setter 메서드를 호출하여 찾은 객체를 주입
            m.invoke(obj, dependency);
          }
          
          
        }
      }
    }
  }

  private Object findDependency(Class<?> type) {
    for (Object obj : objPool.values()) {
      if (type.isInstance(obj)) {
        return obj;
      }
    }
    return null;
  }
  public Collection<Object> getAllBeans() {

    return objPool.values();
  }
}
