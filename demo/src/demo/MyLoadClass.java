package demo;

/**
 * @author lipengke
 * @description:
 * @date 2020/4/14 21:49
 */
public class MyLoadClass extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        return super.findClass(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        return super.loadClass(name);
    }
}
