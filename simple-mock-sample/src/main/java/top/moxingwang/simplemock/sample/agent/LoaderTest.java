package top.moxingwang.simplemock.sample.agent;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class LoaderTest {
    public static void main(String[] args) {
        {
            /*URL url1 = null;
            try {
                url1 = new URL("file:C:\\workspace\\simple-mock\\simple-mock-spy\\target\\simple-mock-spy-1.0.1-SNAPSHOT.jar");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            URLClassLoader myClassLoader1 = new URLClassLoader(new URL[] { url1 }, LoaderTest.class.getClassLoader());

            try {
                Class<?> myClass1 = myClassLoader1.loadClass("org.objectweb.asm.ClassVisitor");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }*/
        }

        loadClass("C:\\\\workspace\\\\simple-mock\\\\simple-mock-spy\\\\target\\\\simple-mock-spy-1.0.1-SNAPSHOT-jar-with-dependencies.jar",
                "org.objectweb.asm.ClassVisitor");
    }

    static public Class<?> loadClass(String filename, String classname) {
        try {
            File file = new File(filename);
            URL url = file.toURI().toURL();
            @SuppressWarnings("resource")
            URLClassLoader loader = new URLClassLoader(new URL[] { url });
            //
            return loader.loadClass(classname);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
