package java02.test21.spring.exam10;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class EngineFactoryBean extends AbstractFactoryBean<Engine>{
  String type;
  
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public Class<?> getObjectType() {
    
    return Engine.class;
    //리턴되는 타입의 정보(class타입~~~)
  }

  @Override
  protected Engine createInstance() throws Exception {
    if(type.equals("sedan")) {
      return new Engine("현대", 16);
    } else if(type.equals("sports")) {
      return new Engine("기아", 18);
    } else if(type.equals("SUV")) {
      return new Engine("벤츠", 20);
    } else{
      return new Engine("GM", 22);
    }
  }
}
