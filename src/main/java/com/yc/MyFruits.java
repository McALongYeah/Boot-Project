package com.yc;

import com.yc.fruits.Banana;
import com.yc.fruits.Pear;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyFruits implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //TODO SPI -> /META-INF/ XXX
        return new String[]{
                //File f = new File("com/yc/fruits")
                //f.listFile();
                Banana.class.getName(), Pear.class.getName()
        };
    }
}
