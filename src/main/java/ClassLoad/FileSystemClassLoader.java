package ClassLoad;

import java.io.*;

/**
 * 自定义文件类加载器,加载.class文件，属于系统类加载器（AppClassLoader）的子类
 *
 */
public class FileSystemClassLoader extends ClassLoader {
    //定义一个根目录
    private String roodDir;


    public FileSystemClassLoader(String roodDir) {
        this.roodDir = roodDir;
    }
    //重写了ClassLoader中的findClass方法，findClass方法在loadClass方法中被调用。
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{

        //使用findLoadedClass方法来判断类是否已经被我们自定义的FileSystemClassLoader加载了
        Class<?> c= findLoadedClass(name);
        //查询是否加载了这个类，如果已经加载，则直接返回加载好的类
        if (c != null) {
            return c;
        } else {
            ClassLoader parent = getParent();
            try {
                parent.loadClass(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (c!=null) {
               return c;
            }else{//如果父类也没加载，则自己加载
                //将.class文件写成byte数组
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    //将byte数组定义成一个Class对象
                    c = defineClass(name,classData,0,classData.length);
                }
            }

        }
        return c;
    }

    private byte[] getClassData(String className) {
        //将传入的类信息，如Reflect.Foo路径转换成在磁盘中的路径
        String path = roodDir+"/"+className.replace(".","/")+".class";

        //创建文件读取流与字节输出流，将磁盘文件读取出来后写入到一个byte数组中
        InputStream in = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(path);
            int temp = 0;
            byte[] bytes = new byte[1024];
            while ((temp=in.read(bytes))!=-1) {
                bos.write(bytes,0,temp);
            }
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
