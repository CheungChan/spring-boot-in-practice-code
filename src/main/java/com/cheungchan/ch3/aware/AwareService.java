package com.cheungchan.ch3.aware;

import java.io.IOException;

import javax.management.openmbean.InvalidOpenTypeException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;

    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void outputResult() {
        System.out.println("bean的名称为： " + beanName);
        Resource resource = resourceLoader.getResource("classpath:com/cheungchan/ch3/aware/test.txt");
        try {
            System.out.println("ResourceLoader 加载的文件内容为:" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
