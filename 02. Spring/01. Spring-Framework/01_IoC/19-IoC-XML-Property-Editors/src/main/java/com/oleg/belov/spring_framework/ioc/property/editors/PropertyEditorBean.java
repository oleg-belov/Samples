package com.oleg.belov.spring_framework.ioc.property.editors;

import static com.oleg.belov.spring_framework.ioc.property.editors.utils.ClassNameUtil.getCurrentClassName;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyEditorBean {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    private byte[] bytes;                 // ByteArrayPropertyEditor
    private Class cls;                    // ClassEditor
    private Boolean trueOrFalse;          // CustomBooleanEditor
    private List<String> stringList;      // CustomCollectionEditor
    private Date date;                    // CustomDateEditor
    private Float floatValue;             // CustomNumberEditor
    private File file;                    // FileEditor
    private InputStream stream;           // InputStreamEditor
    private Locale locale;                // LocaleEditor
    private Pattern pattern;              // PatternEditor
    private Properties properties;        // PropertiesEditor
    private String trimString;            // StringTrimmerEditor
    private URL url;                      // URLEditor

    public void setCls(Class cls) {
        log.info("Setting class: " + cls.getName());
        this.cls = cls;
    }

    public void setFile(File file) {
        log.info("Setting file: " + file.getName());
        this.file = file;
    }

    public void setLocale(Locale locale) {
        log.info("Setting locale: " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setProperties(Properties properties) {
        log.info("Loaded " + properties.size() + " properties");
        this.properties = properties;
    }

    public void setUrl(URL url) {
        log.info("Setting URL: " + url.toExternalForm());
        this.url = url;
    }

    public void setBytes(byte[] bytes) {
        log.info("Adding " + bytes.length + " bytes");
        this.bytes = bytes;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        log.info("Setting Boolean: " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        log.info("Setting string list with size: "
            + stringList.size());

        this.stringList = stringList;

        for (String string: stringList) {
            log.info("String member: " + string);
        }
    }

    public void setDate(Date date) {
        log.info("Setting date: " + date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        log.info("Setting float value: " + floatValue);
        this.floatValue = floatValue;
    }

    public void setStream(InputStream stream) {
        log.info("Setting stream: " + stream);
        this.stream = stream;
    }

    public void setPattern(Pattern pattern) {
        log.info("Setting pattern: " + pattern);
        this.pattern = pattern;
    }

    public void setTrimString(String trimString) {
        log.info("Setting trim string: " + trimString);
        this.trimString = trimString;
    }

    public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar { 
        public void registerCustomEditors(PropertyEditorRegistry registry) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
            registry.registerCustomEditor(Date.class, 
                     new CustomDateEditor(dateFormatter, true));

            registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }

    public static void main(String[] args) throws Exception {
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        PropertyEditorBean bean = 
            (PropertyEditorBean) ctx.getBean("builtInSample");
    }
}
