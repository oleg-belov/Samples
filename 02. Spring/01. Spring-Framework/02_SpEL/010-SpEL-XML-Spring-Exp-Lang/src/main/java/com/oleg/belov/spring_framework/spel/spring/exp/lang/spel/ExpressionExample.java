package com.oleg.belov.spring_framework.spel.spring.exp.lang.spel;

import static com.oleg.belov.spring_framework.spel.spring.exp.lang.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.oleg.belov.spring_framework.spel.spring.exp.lang.bean.User;

public class ExpressionExample {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public void simpleString() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        log.info(message);
    }

    public void concat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello '.concat('World')");
        String message = (String) exp.getValue();
        log.info(message);
    }

    public void upperCase() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        log.info(message);
    }

    public void math1() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("10 + 10/2 + 10*2");
        Double value = exp.getValue(Double.class);
        log.info("" + value);
    }

    public void math2() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("T(java.lang.Math).random() * 100.0");
        Double value = exp.getValue(Double.class);
        log.info("" + value);
    }

    public void field() {
        User jobs = new User("Steve1", "Jobs", 56);
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp1 = parser.parseExpression("firstName");
        String name = exp1.getValue(jobs, String.class);
        log.info(name);

        Expression exp2 = parser.parseExpression("firstName=='Steve'");
        log.info("" + exp2.getValue(jobs, Boolean.class));
    }
}
