/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jump.core.util;

import in.macor.commons.util.StringUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author macorin
 */
public class BeanUtil {

    public static boolean nullOrEmpthy(Object entity) {
        if (entity == null) {
            return true;
        }

        Class entityClass = entity.getClass();
        for (Field field : entityClass.getDeclaredFields()) {
            if (field.getAnnotation(Id.class) != null) {
                try {
                    Method methodGet = entityClass.getMethod("get" + StringUtil.capitalize(field.getName()));

                    Object value = methodGet.invoke(entity);
                    if (value != null) {
                        return false;
                    }

                    break;
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return true;
    }

    public static Object detachedToPersist(Object entity) {
        if (entity == null) {
            return null;
        }

        try {
            Class entityClass = entity.getClass();
            for (Field field : entityClass.getDeclaredFields()) {
                if ((field.getAnnotation(OneToOne.class) != null)
                    || (field.getAnnotation(ManyToOne.class) != null)) {
                    Method methodGet = entityClass.getMethod("get" + StringUtil.capitalize(field.getName()));

                    if (nullOrEmpthy(methodGet.invoke(entity))) {
                        Method methodSet = entityClass.getMethod("set" + StringUtil.capitalize(field.getName()), methodGet.getReturnType());
                        methodSet.invoke(entity, new Object[]{null});
                    }
                }
            }
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entity;
    }
}
