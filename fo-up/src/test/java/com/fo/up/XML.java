package com.fo.up;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * XML工具
 *
 * @author egan
 *         <pre>
 *         email egzosn@gmail.com
 *         date 2016-6-2 19:45:06
 *         </pre>
 */
public class XML {


    /**
     * 解析xml并转化为json值
     *
     * @param in 输入流
     * @return Json值
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     */
    public static JSONObject toJSONObject(InputStream in) throws IOException, ParserConfigurationException, SAXException {

        if (null == in) {
            return null;
        }

            return (JSONObject) inputStream2Map(in, null);

    }

    /**
     * 解析xml并转化为Json值
     *
     * @param content json字符串
     * @return Json值
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     */
    public static JSONObject toJSONObject(String content) throws IOException, ParserConfigurationException, SAXException {

        if (null == content || "".equals(content)) {
            return null;
        }
        try (InputStream in = new ByteArrayInputStream(content.getBytes("UTF-8"))) {
            return (JSONObject) inputStream2Map(in, null);
        }

    }

    /**
     * 解析xml并转化为Json值
     *
     * @param content json字符串
     * @param clazz 需要转化的类
     * @return Json值
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     */
    public static <T> T toBean(String content, Class<T> clazz) throws IOException, ParserConfigurationException, SAXException {

        if (null == content || "".equals(content)) {
            return null;
        }
        try (InputStream in = new ByteArrayInputStream(content.getBytes("UTF-8"))) {
            return inputStream2Bean(in, clazz);
        }

    }


    /**
     * 获取子结点的xml
     *
     * @param children 集合
     * @return String 子结点的xml
     */
    public static JSON getChildren(NodeList children) {
        JSON json = null;
        for (int idx = 0; idx < children.getLength(); ++idx) {
            Node node = children.item(idx);
            NodeList nodeList = node.getChildNodes();
            if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() <= 1) {
                if (null == json) {
                    json = new JSONObject();
                }
                ((JSONObject) json).put(node.getNodeName(), node.getTextContent());
            } else if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() > 1) {
                if (null == json) {
                    json = new JSONObject();
                }
                if (json instanceof JSONObject) {
                    JSONObject j = ((JSONObject) json);
                    if (j.containsKey(node.getNodeName())) {
                        JSONArray array = new JSONArray();
                        array.add(json);
                        json = array;
                    } else {
                        j.put(node.getNodeName(), getChildren(nodeList));
                    }
                }

                if (json instanceof JSONArray) {
                    JSONObject c = new JSONObject();
                    c.put(node.getNodeName(), getChildren(nodeList));
                    ((JSONArray) json).add(c);
                }
            }
        }

        return json;
    }

    /***
     *  xml 解析成对应的对象
     * @param in 输入流
     * @param clazz 需要转化的类
     * @param <T> 类型
     * @return 对应的对象
     * @throws IOException  xml io转化异常
     * @throws ParserConfigurationException 
     * @throws SAXException 
     */
    public static <T> T inputStream2Bean(InputStream in, Class<T> clazz) throws IOException, ParserConfigurationException, SAXException {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setExpandEntityReferences(false);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = documentBuilder.parse(in);
            doc.getDocumentElement().normalize();
            NodeList children = doc.getDocumentElement().getChildNodes();
            JSON json = getChildren(children);
            return json.toJavaObject(clazz);
        }  finally {
            in.close();
        }

    }

    /**
     * @param in xml输入流
     * @param m  参数集
     * @return 整理完成的参数集
     * @throws IOException xml io转化异常
     * @throws ParserConfigurationException 
     * @throws SAXException 
     */
    public static Map inputStream2Map(InputStream in, Map m) throws IOException, ParserConfigurationException, SAXException {
        if (null == m) {
            m = new JSONObject();
        }
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setExpandEntityReferences(false);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = documentBuilder.parse(in);
            doc.getDocumentElement().normalize();
            NodeList children = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < children.getLength(); ++idx) {
                Node node = children.item(idx);
                NodeList nodeList = node.getChildNodes();
                if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() <= 1) {
                    m.put(node.getNodeName(), node.getTextContent());
                } else if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() > 1) {
                    m.put(node.getNodeName(), getChildren(nodeList));
                }
            }
        } finally {
            in.close();
        }
        return m;
    }

    public static Map<String, Object> inputStream2Map(InputStream in) throws IOException, ParserConfigurationException, SAXException {
        Map<String, Object> m = new TreeMap<String, Object>();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setExpandEntityReferences(false);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = documentBuilder.parse(in);
            doc.getDocumentElement().normalize();
            NodeList children = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < children.getLength(); ++idx) {
                Node node = children.item(idx);
                NodeList nodeList = node.getChildNodes();
                if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() <= 1) {
                    m.put(node.getNodeName(), node.getTextContent());
                } else if (node.getNodeType() == Node.ELEMENT_NODE && nodeList.getLength() > 1) {
                    m.put(node.getNodeName(), getChildren(nodeList));
                }
            }
        } finally {
            in.close();
        }
        return m;
    }



    /**
     * 将Map转换为XML格式的字符串
     *
     * @param data Map类型数据
     * @return XML格式的字符串
     */
    public static String getMap2Xml(Map<String, Object> data) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setExpandEntityReferences(false);
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        org.w3c.dom.Document document = documentBuilder.newDocument();
        org.w3c.dom.Element root = document.createElement("xml");
        document.appendChild(root);
        for (String key : data.keySet()) {
            Object value = data.get(key);
            if (value == null) {
                value = "";
            }
            value = value.toString().trim();
            org.w3c.dom.Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value.toString()));
            root.appendChild(filed);
        }
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            String output = writer.getBuffer().toString(); //.replaceAll("\n|\r", "");
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }


        return "";
    }

    public static void main(String[] args) {
        String ss = "<?xml version='1.0' encoding=\"UTF-8\"?>\n" + 
                "<response>\n" + 
                "    <error>\n" + 
                "        <error-code>123123</error-code>\n" + 
                "    </error>\n" + 
                "</response>";
        try {
            JSONObject jsonObject = XML.toJSONObject(ss);
            System.out.println(jsonObject);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
