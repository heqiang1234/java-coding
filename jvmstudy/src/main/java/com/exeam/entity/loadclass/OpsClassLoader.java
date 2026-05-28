package com.exeam.entity.loadclass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * @author heqiang
 * @date 2025年08月23日16:13
 */
public class OpsClassLoader extends ClassLoader {
    private String rootDirPath;

    public OpsClassLoader(String cls) {
        this.rootDirPath = cls;
    }

    private byte[] getClassDePass(String className) throws Exception {
        String classpath = rootDirPath + className;

        ByteArrayOutputStream arrayInputStream;
        try (FileInputStream fileInputStream = new FileInputStream(classpath)) {
            arrayInputStream = new ByteArrayOutputStream();
            int bufferSize = 1024;
            int n = 0;
            byte[] bytes = new byte[bufferSize];
            while ((n = fileInputStream.read(bytes)) != -1) {
                arrayInputStream.write(bytes, 0, n);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return arrayInputStream.toByteArray();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] dePass = getClassDePass(name);

            return defineClass(name, dePass, 0, dePass.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
