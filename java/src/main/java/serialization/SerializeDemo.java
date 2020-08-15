package serialization;

import enmus.BizType;

import java.io.*;

/**
 * @author fan.li
 * @date 2020-07-28
 * @description
 */
public class SerializeDemo {
    public static final String serializeTestFile = "/tmp/EnumSerialize.ser";

    public static void main(String[] args) {
        // 序列化
        // serializeObject(BizType.TYPE1);
        // 反序列化
        deSerializeObjectFromFile(new File(serializeTestFile), BizType.class);
    }

    private static void serializeObject(Object o) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(serializeTestFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + serializeTestFile);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private static <T> T deSerializeObjectFromFile(File file, Class<T> entityClass) {
        T bizType = null;
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            bizType = (T) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return bizType;
        } catch (ClassNotFoundException c) {
            System.out.println(c.getCause());
            c.printStackTrace();
            return bizType;
        }
        System.out.println(bizType);
        return null;
    }
}

