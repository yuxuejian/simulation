package com.iocaop.simulation.ioc.reader;

import com.iocaop.simulation.ioc.beans.BeanDefinition;
import com.iocaop.simulation.ioc.beans.BeanReference;
import com.iocaop.simulation.ioc.beans.PropertyValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 读取类信息加载到BeanDefinition类中（xml的方式）
 *
 * @author csu_y
 * @date 2020/2/4 19:45
 */
public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    // 保存解析后的类信息
    private Map<String, BeanDefinition> registry;

    public BeanDefinitionReaderImpl() {
        registry = new HashMap<>();
    }

    @Override
    public void loadBeanDefinitions(String location) throws FileNotFoundException, Exception {
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        Element root = document.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nodes = root.getChildNodes();
        for (int i=0; i<nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                parseBeanDefinition(element);
            }
        }
    }

    private void parseBeanDefinition(Element element) {
        String name = element.getAttribute("id");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(className);
        parseBeanProperty(element, beanDefinition);
        registry.put(name, beanDefinition);
    }

    private void parseBeanProperty(Element element, BeanDefinition beanDefinition) {
        NodeList nodeList = element.getElementsByTagName("property");
        for (int i=0; i<nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element propertyElement = (Element) node;
                String name = propertyElement.getAttribute("name");
                String value = propertyElement.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getPropertyValues().addPropetyValue(new PropertyValue(name, value));
                } else {
                    String ref = propertyElement.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException("ref config error");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropetyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }
}
