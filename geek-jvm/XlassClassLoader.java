package org.lql.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: lql
 * @date: 2021/5/5 21:42
 * @description: 自定义一个 Classloader，加载一个 Hello.xlass 文件
 */
public class XlassClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        //类加载器
        ClassLoader classLoader = new XlassClassLoader();
        //根据Hello.clazz获取Class<?>
        Class<?> clazz = classLoader.loadClass("Hello");

        // ##这里的反射不是很熟练## eg:getDeclaredMethods,getMethods..等等

        //通过clazz获取申明的构造函数实例对象
        Object instance = clazz.getConstructor().newInstance();
        //获取申明的构造方法
        Method[] methods = clazz.getDeclaredMethods();
        //方法使用构造实例
        for (Method method : methods) {
            System.out.println("-----------method执行分割线-----------");
            System.out.println("方法名: " + method.getName());
            method.invoke(instance);
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        //文件名+后缀
        String fileName = name + ".xlass";
        //获取文件输入流
        InputStream in = getResourceAsStream(fileName);
        try {
            //文件流缓冲区
            byte[] buff = new byte[1024 * 1024];
            if (in != null) {
                buff = new byte[in.available()];
                //读取文件到缓冲区
                while (true) {
                    int read = in.read(buff);
                    if (read < 1) {
                        break;
                    }
                }
            }
            //解码文件
            byte[] decode = decode(buff);
            //将字节码文件转化定义为class
            return defineClass(name, decode, 0, decode.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭读取流资源
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 解码
     * Hello.class 文件所有字节（x=255-x）处理后的文件
     *
     * @param buff 字节码缓冲流
     * @return 解码后的文件字节流
     */
    private static byte[] decode(byte[] buff) {
        byte[] res = new byte[buff.length];
        for (int i = 0; i < buff.length; i++) {
            res[i] = (byte) (255 - buff[i]);
        }
        return res;
    }
}
