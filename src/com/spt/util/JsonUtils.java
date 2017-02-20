package com.spt.util;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonUtils {  
    
    private static ObjectMapper objectMapper = new ObjectMapper();  
      
    public static <T> String bean2Json(T bean) {  
        try {  
            return objectMapper.writeValueAsString(bean);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }  
      
    public static String map2Json(Map<?,?> map) {  
        try {  
            return objectMapper.writeValueAsString(map);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }  
      
    public static String list2Json(List<?> list) {  
        try {  
            return objectMapper.writeValueAsString(list);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return "";  
    }  
      
    public static <T> T json2Bean(String json, Class<T> beanClass) {  
        try {  
            return objectMapper.readValue(json, beanClass);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    @SuppressWarnings("unchecked")
	public static <T> List<T> json2List(String json, Class<T> beanClass) {  
        try {  
              
            return (List<T>)objectMapper.readValue(json, getCollectionType(List.class, beanClass));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    public static Map<?,?> json2Map(String json) {  
        try {  
              
            return (Map<?,?>)objectMapper.readValue(json, Map.class);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
      
    @SuppressWarnings("deprecation")
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {     
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);     
    }   
}