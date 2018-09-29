package ClassLoad;

import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * 网络类加载器，将本地路径rootDir换成URL就可以了
 */
public class NetClassLoader extends ClassLoader {

    //定义一个根目录
    private String url;


    public NetClassLoader(String url) {
        this.url = url;
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
            try {//如果不对AppClassLoader进行try-catch，那么加载次项目外的class文件则会报ClassNotFoundException错误
                c = parent.loadClass(name);//委派给父类加载
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException(e.getMessage());
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
        //将传入的类信息，通过网络URL的方式
        String path = url+"/"+className.replace(".","/")+".class";

        //创建文件读取流与字节输出流，将磁盘文件读取出来后写入到一个byte数组中
        InputStream in = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            //根据URL打开一个输入流
            URL url = new URL(path);
            in =url.openStream();
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
