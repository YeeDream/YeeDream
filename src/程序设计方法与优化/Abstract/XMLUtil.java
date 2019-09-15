package 程序设计方法与优化.Abstract;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.*;

public class XMLUtil {
    public static Object getBean() {
        try{
            DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=dFactory.newDocumentBuilder();
            Document doc;
            doc=builder.parse(new File("Abstract.xml"));
            NodeList nl=doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue();
            Class c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        }catch (Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
    }
}
