import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Parent parent = new Parent();
        parent.setAge(49);
        parent.setName("Mom");
        Child child = new Child();
        child.setAge(12);
        child.setName("Son");
        child.setMax(25);
        parent.setChild(child);
        System.out.println("Parent before Output " + parent);

        FileOutputStream fos = new FileOutputStream("parent.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(parent);
        oos.flush();
        oos.close();

        parent.setName("Dad");
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
        oos = new ObjectOutputStream(baos);
        oos.writeObject(parent);
        oos.flush();
        oos.close();

        byte[] parentSer = baos.toByteArray();

        FileInputStream fis = new FileInputStream("parent.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        parent = (Parent) ois.readObject();
        ois.close();
        System.out.println("Parent after Reading File " + parent);

        ByteArrayInputStream bais = new ByteArrayInputStream(parentSer);
        ois = new ObjectInputStream(bais);
        parent = (Parent) ois.readObject();
        ois.close();
        System.out.println("Parent after Reading Byte Array " + parent);


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(parent);
        System.out.println("json is now " + json);

        Parent testParent = mapper.readValue(json,Parent.class);
        System.out.println("TestParent after reading from json " + testParent);

    }
}
