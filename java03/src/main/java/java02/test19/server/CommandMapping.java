package java02.test19.server;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import java02.test19.server.annotation.Command;

import org.reflections.ReflectionUtils;

public class CommandMapping {
  public class CommandInfo {
    public Object instance;
    public Method method;
  }
  
  HashMap<String, CommandInfo> commandMap = new HashMap<>();
  
  @SuppressWarnings("unchecked")
  public void prepare(Collection<Object> objList) throws Exception{
    Set<Method> methods = null;    
    CommandInfo commandInfo = null;
    Command commandAnno = null;
    for (Object obj : objList) {
      methods = ReflectionUtils.getMethods(
          obj.getClass(),
          ReflectionUtils.withAnnotation(Command.class));
      
      for (Method m :methods) {
        commandAnno = m.getAnnotation(Command.class);
        commandInfo = new CommandInfo();
        commandInfo.instance = obj;
        commandInfo.method = m;
        commandMap.put(commandAnno.value(), commandInfo);
      }
    }
  }

  public CommandInfo getCommandInfo(String command) {
    return commandMap.get(command);
  }
}
