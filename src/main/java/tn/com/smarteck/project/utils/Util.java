package tn.com.smarteck.project.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;


public interface Util {
	
	// find null attributes in the received object
		static <T> String[] getNullFields(T newEntity) {
			ArrayList<String> strs = new ArrayList<String>();
			for (Field field : newEntity.getClass().getDeclaredFields()) {
		        field.setAccessible(true); // to allow the access of member attributes
		        Object attribute = null;
				try {
					attribute = field.get(newEntity);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.err.println(e.getMessage());
				} 
		        if (attribute == null) {
		            strs.add(field.getName());
		        }
		    }
			
			return strs.toArray(new String[0]);
		}

}
