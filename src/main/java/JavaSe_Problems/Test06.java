package JavaSe_Problems;

import org.junit.Test;

import java.io.*;

/**
 * 测试文件类
 */
public class Test06 {


    @Test
    public void test() {

        //这是用来创建文件夹对象的，而不是文件夹，所以如果硬盘上有文件，exists方法或者isFile方法
        //才会返回true
        File dir = new File("C:" + File.separator + "testFileAndIO");
        System.out.println(dir);
        File file = new File(dir, "file1.txt");
        System.out.println(file);
        System.out.println(dir.isDirectory());//判断是否是目录
        System.out.println(file.isFile());//判断是否是文件
        System.out.println(file.exists());//判断文件是否存在
        System.out.println(dir.exists());//判断文件夹是否存在
    }

    /**
     * 创建文件
     */
    @Test
    public void test2() throws IOException {
        File dir = new File("C:" + File.separator + "testFileAndIO");
        boolean b1 = dir.mkdir();
        System.out.println(b1);
        File file = new File(dir, "file.txt");
        boolean b2 = file.createNewFile();
        System.out.println(b2);
        System.out.println(file.exists());
    }

    /**
     * 给文件改名
     */
    public void test3_1() {
        //素材： test/abc.txt  没有 test/def.txt
        File file1 = new File("test/abc.txt");
        File file2 = new File("test/def.txt");
        //file1 是存在的文件，
        //file2 是一个不存在的文件
        //将file1的名字改名为file2对应的名字
        boolean b = file1.renameTo(file2);
        //改名之后：file1就不存在了（abc.txt）
        //          file2存在(def.txt)
        System.out.println(b);//true
    }

    /**
     * 列出文件夹内容
     */
    @Test
    public void test3_2() {
        File file = new File("C:" + File.separator + "testFileAndIO" );
        File[] files = file.listFiles();//获取该文件的目录树
        for (File f:files) {
            if (f.isDirectory()) {
                System.out.println(f.getName()+"文件夹");
            } else {
                System.out.println(f.getName()+"文件");
            }
        }
    }
    /**
     * RandomAccessFile
     * 按照单个字节读写，指针每次移动一个字节
     *
     * read()和write()方法默认读写byte数组（也是按照单位byte读写）或者一个byte
     */
    @Test
    public void test6() {
            RandomAccessFile randomAccessFile = null;
        try {
            //以读写方式创建文件，如果文件不存在，则自动创建一个
             randomAccessFile =
                    new RandomAccessFile(new File("C:" + File.separator +
                            "testFileAndIO/text2.txt"),"rw");
            //获取文件读取指针的初始位置
            long p = randomAccessFile.getFilePointer();
            System.out.println(p);
            randomAccessFile.write(123);//虽然数据是存在int中，但是是byte，范围0——255
            p=randomAccessFile.getFilePointer();
            System.out.println(p);
            randomAccessFile.write(255);
            p=randomAccessFile.getFilePointer();
            System.out.println(p);
            String str = "我是你爹";
            byte[] bytes = str.getBytes("utf-8");//设置字符串编码
            randomAccessFile.write(bytes);
            p = randomAccessFile.getFilePointer();
            System.out.println(p);
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }   finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * RandomAccessFile读取
     */
    @Test
    public void test7() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("C:" + File.separator +
                    "testFileAndIO/text2.txt","r");
            long pointer = randomAccessFile.getFilePointer();
            System.out.println(pointer);
            int a = randomAccessFile.read();
            pointer = randomAccessFile.getFilePointer();
            System.out.println(a);
            System.out.println(pointer);
            int b = randomAccessFile.read();
            System.out.println(b);
            pointer = randomAccessFile.getFilePointer();
            System.out.println(pointer);
            byte[] buf = new byte[13];
            int i = randomAccessFile.read(buf);
            String str = new String(buf,"UTF-8");
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }   finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 写入文件
     */
    @Test
    public void test3() {
        PrintWriter printWriter = null;
        try {
            FileOutputStream fos =
                    new FileOutputStream("C:" + File.separator + "testFileAndIO/file.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF8");
            printWriter = new PrintWriter(osw, true);
            String str = "辜配我日你妈的大鸡巴哈哈";
            byte[] bytes = str.getBytes();
            printWriter.print(str);//字符流不要传入byte数组进行写入不然会乱码，
            // 字节流可以传入byte数组。


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }

    }

    /**
     * 读取文件
     */
    @Test
    public void test4() {
        //按行读取，一次读一行，读完一行如果没有循环读取就不读了
        BufferedReader br = null;
        try {
            FileInputStream fis =
                    new FileInputStream("C:" + File.separator + "testFileAndIO/file.txt");
            InputStreamReader isr = new InputStreamReader(fis, "utf8");
            br = new BufferedReader(isr);
            String str = null;
            while ((str = br.readLine()) != null) {//循环输出
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
